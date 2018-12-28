package kz.osmium.dorm.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import kz.osmium.account.request.AccountGET;
import kz.osmium.dorm.util.gson.Report;
import kz.osmium.dorm.util.gson.Resident;
import kz.osmium.dorm.util.statement.StatementDormINSERT;
import kz.osmium.dorm.util.statement.StatementDormSELECT;
import kz.osmium.dorm.util.statement.StatementDormUPDATE;
import kz.osmium.util.CommonMethods;
import kz.osmium.util.DBConnection;
import kz.osmium.util.DataConfig;
import org.eclipse.jetty.http.HttpStatus;
import org.joda.time.DateTime;
import spark.Request;
import spark.Response;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DormPUT {

    public static String putRequestStatus(Request request, Response response) {

        if (request.queryParams(DataConfig.DB_DORM_REQUEST_STATUS) != null) {

            try (Connection connection = DBConnection.Dorm.getDB()) {
                String date = CommonMethods.getDateText(new Date());
                PreparedStatement statement = connection.prepareStatement(StatementDormUPDATE.updateRequestStatus());

                statement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_STATUS)));
                statement.setString(2, date);
                statement.setInt(3, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT)));
                statement.executeUpdate();

                if (Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_STATUS)) == DataConfig.DB_DORM_REQUEST_STATUS_CREATE_REPORT) {
                    statement = connection.prepareStatement(
                            StatementDormINSERT.insertReports(),
                            Statement.RETURN_GENERATED_KEYS
                    );

                    statement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT)));
                    statement.setInt(2, DataConfig.DB_DORM_REPORT_STATUS_VALUE);
                    statement.setString(3, date);
                    statement.executeUpdate();

                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {

                            response.status(201);

                            JsonObject jsonObject = new GsonBuilder().create().toJsonTree(
                                    new Report(
                                            Math.toIntExact(generatedKeys.getLong(1)),
                                            AccountGET.getAccountShortInfo(Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT))),
                                            null,
                                            DataConfig.DB_DORM_REPORT_STATUS_VALUE,
                                            date
                                    )
                            ).getAsJsonObject();

                            jsonObject.addProperty(DataConfig.DB_DORM_REPORT_DATE_SEND, date);

                            return jsonObject.toString();
                        } else {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }
                    }
                } else {

                    response.status(200);

                    Map<String, String> map = new HashMap<>();

                    map.put(DataConfig.DB_DORM_REQUEST_DATE_SEND, date);

                    return new Gson().toJson(map);
                }
            } catch (SQLException | NumberFormatException e) {

                response.status(409);

                return e.getMessage();
            }
        } else {

            response.status(204);

            return HttpStatus.getCode(204).getMessage();
        }
    }

    public static String putReportStatus(Request request, Response response) {

        if (request.queryParams(DataConfig.DB_DORM_REPORT_STATUS) != null) {

            try (Connection connection = DBConnection.Dorm.getDB()) {
                int status = getStatus(StatementDormSELECT.selectReportID(), Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_ID)));
                int statusQuery = Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_STATUS));

                if (!CommonMethods.isValidStatus(status, statusQuery)) {

                    response.status(409);

                    return "Helloooooooo";
                }

                DateTime date = new DateTime(new Date());

                if (statusQuery == DataConfig.DB_DORM_REPORT_STATUS_CREATE_RESIDENT) {
                    int accountId = 0;
                    int roomId = 0;
                    int month = 0;
                    String email = "test@simple.com";
                    PreparedStatement statement = connection.prepareStatement(StatementDormUPDATE.updateReportStatusFinale());

                    statement.setInt(1, statusQuery);
                    statement.setString(2, "http://example.com");
                    statement.setString(3, CommonMethods.getDateTimeText(date));
                    statement.setInt(4, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_ID)));
                    statement.executeUpdate();

                    statement = connection.prepareStatement(StatementDormSELECT.selectReportID());

                    statement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_ID)));

                    ResultSet result = statement.executeQuery();

                    if (result.next())
                        accountId = result.getInt(DataConfig.DB_DORM_REPORT_ACCOUNT_ID);

                    statement = connection.prepareStatement(StatementDormSELECT.selectRequestAccount());

                    statement.setInt(1, accountId);

                    result = statement.executeQuery();

                    if (result.next()) {
                        roomId = result.getInt(DataConfig.DB_DORM_REQUEST_ROOM_ID);
                        month = result.getInt(DataConfig.DB_DORM_REQUEST_BOOKING_PERIOD);
                        email = result.getString(DataConfig.DB_DORM_REQUEST_EMAIL);
                    }

                    Gson gson = new GsonBuilder().create();
                    DateTime dateTime = date.withTime(0, 0, 0, 0);
                    DateTime dateTimeDay = dateTime.plusDays(1);
                    DateTime dateTimeMonth = dateTime.plusMonths(1);
                    statement = connection.prepareStatement(
                            StatementDormINSERT.insertResident(),
                            Statement.RETURN_GENERATED_KEYS
                    );

                    statement.setString(1, CommonMethods.getDateTimeText(dateTimeDay));
                    statement.setString(2, CommonMethods.getDateTimeText(dateTimeMonth));
                    statement.setInt(3, roomId);
                    statement.setInt(4, accountId);
                    statement.setInt(5, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_ID)));
                    statement.setString(6, CommonMethods.getDateTimeText(date));
                    statement.executeUpdate();

                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {

                            response.status(201);

                            return new Gson().toJson(
                                    new Resident(
                                            Math.toIntExact(generatedKeys.getLong(1)),
                                            CommonMethods.getDateTimeText(dateTimeDay),
                                            CommonMethods.getDateTimeText(dateTimeMonth),
                                            roomId,
                                            AccountGET.getAccountShortInfo(accountId),
                                            Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_ID)),
                                            CommonMethods.getDateTimeText(date)
                                    )
                            );
                        } else {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }
                    }
                } else {
                    PreparedStatement statement = connection.prepareStatement(StatementDormUPDATE.updateReportStatus());

                    statement.setInt(1, statusQuery);
                    statement.setString(2, CommonMethods.getDateTimeText(date));
                    statement.setInt(3, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_ID)));
                    statement.executeUpdate();

                    if (true) {

                        response.status(200);

                        Map<String, String> map = new HashMap<>();

                        map.put(DataConfig.DB_DORM_REPORT_DATE_SEND, CommonMethods.getDateTimeText(date));

                        return new Gson().toJson(map);
                    } else {

                        response.status(200);

                        Map<String, String> map = new HashMap<>();

                        map.put(DataConfig.DB_DORM_REPORT_DATE_SEND, CommonMethods.getDateTimeText(date));

                        return new Gson().toJson(map);
                    }
                }
            } catch (SQLException | NumberFormatException e) {

                response.status(409);

                return e.getMessage();
            }
        } else {

            response.status(204);

            return HttpStatus.getCode(204).getMessage();
        }
    }

    private static int getStatus(String sql, int id) throws SQLException, NumberFormatException {
        Connection connection = DBConnection.Dorm.getDB();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();

        if (result.next())
            return result.getInt(1);
        else
            throw new SQLDataException();
    }
}
