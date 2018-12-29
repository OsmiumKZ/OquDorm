package kz.osmium.dorm.request;

import com.google.gson.Gson;
import kz.osmium.account.request.AccountGET;
import kz.osmium.dorm.util.gson.Requests;
import kz.osmium.dorm.util.statement.StatementDormSELECT;
import kz.osmium.dorm.util.statement.StatementDormINSERT;
import kz.osmium.dorm.util.statement.StatementDormUPDATE;
import kz.osmium.util.CommonMethods;
import kz.osmium.util.DBConnection;
import kz.osmium.util.DataConfig;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DormPOST {

    public static String postRequest(Request request, Response response) {

        if (request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT) != null &&
                request.queryParams(DataConfig.DB_DORM_REQUEST_ROOM) != null &&
                request.queryParams(DataConfig.DB_DORM_REQUEST_PERIOD) != null) {
            String email = CommonMethods.isValidEmailAddress(request.queryParams(DataConfig.DB_DORM_REQUEST_EMAIL)) ? request.queryParams(DataConfig.DB_DORM_REQUEST_EMAIL) : null;

            try (Connection connection = DBConnection.Dorm.getDB()) {

                if (isReportAndResident(Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT)))) {
                    String date = new SimpleDateFormat(DataConfig.GLOBAL_DATE_FORMAT).format(new Date());
                    PreparedStatement statement = connection.prepareStatement(StatementDormSELECT.selectRequestAccount());

                    statement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT)));

                    ResultSet result = statement.executeQuery();

                    if (result.next()) {
                        PreparedStatement statementTwo = connection.prepareStatement(StatementDormUPDATE.updateRequest());

                        statementTwo.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ROOM)));
                        statementTwo.setInt(2, DataConfig.DB_DORM_REQUEST_STATUS_VALUE);
                        statementTwo.setInt(3, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_PERIOD)));
                        statementTwo.setString(5, date);
                        statementTwo.setInt(6, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT)));

                        if (email != null)
                            statementTwo.setString(4, email);
                        else
                            statementTwo.setNull(4, Types.VARCHAR);

                        if (statementTwo.executeUpdate() == 0) {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }

                        response.status(201);

                        return new Gson().toJson(
                                new Requests(
                                        result.getInt(DataConfig.DB_DORM_REQUEST_ID),
                                        AccountGET.getAccountShortInfo(Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT))),
                                        Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ROOM)),
                                        DataConfig.DB_DORM_REQUEST_STATUS_VALUE,
                                        Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_PERIOD)),
                                        email,
                                        date
                                )
                        );
                    }

                    statement = connection
                            .prepareStatement(
                                    StatementDormINSERT.insertRequests(),
                                    Statement.RETURN_GENERATED_KEYS
                            );

                    statement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT)));
                    statement.setInt(2, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ROOM)));
                    statement.setInt(3, DataConfig.DB_DORM_REQUEST_STATUS_VALUE);
                    statement.setInt(4, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_PERIOD)));
                    statement.setString(6, date);

                    if (email != null)
                        statement.setString(5, email);
                    else
                        statement.setNull(5, Types.VARCHAR);

                    if (statement.executeUpdate() == 0) {

                        response.status(500);

                        return HttpStatus.getCode(500).getMessage();
                    }

                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {

                            response.status(201);

                            return new Gson().toJson(
                                    new Requests(
                                            Math.toIntExact(generatedKeys.getLong(1)),
                                            AccountGET.getAccountShortInfo(Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT))),
                                            Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ROOM)),
                                            DataConfig.DB_DORM_REQUEST_STATUS_VALUE,
                                            Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_PERIOD)),
                                            email,
                                            date
                                    )
                            );
                        } else {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }
                    }
                } else {

                    response.status(409);

                    return HttpStatus.getMessage(409);
                }
            } catch (SQLException | NumberFormatException e) {

                response.status(409);

                return e.getMessage();
            }
        } else {

            response.status(400);

            return HttpStatus.getCode(400).getMessage();
        }
    }

    private static boolean isReportAndResident(int account) throws SQLException, NumberFormatException {
        Connection connection = DBConnection.Dorm.getDB();
        PreparedStatement statement = connection.prepareStatement(StatementDormSELECT.selectReportAccountActive());

        statement.setInt(1, account);

        ResultSet result = statement.executeQuery();

        return !result.next();
    }
}
