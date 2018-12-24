package kz.osmium.dorm.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kz.osmium.account.util.gson.Account;
import kz.osmium.account.util.statement.StatementAccountSELECT;
import kz.osmium.dorm.util.gson.Report;
import kz.osmium.dorm.util.gson.Resident;
import kz.osmium.dorm.util.statement.StatementDormINSERT;
import kz.osmium.dorm.util.statement.StatementDormSELECT;
import kz.osmium.dorm.util.statement.StatementDormUPDATE;
import kz.osmium.util.DBConnection;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DormPUT {

    public static String putRequestStatus(Request request, Response response) {

        if (request.queryParams("status") != null) {

            try (Connection connection = DBConnection.Dorm.getDB(); Connection connection2 = DBConnection.KEU.getDB()) {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                PreparedStatement preparedStatement = connection.prepareStatement(StatementDormUPDATE.updateRequestStatus());

                preparedStatement.setInt(1, Integer.parseInt(request.queryParams("status")));
                preparedStatement.setString(2, date);
                preparedStatement.setInt(3, Integer.parseInt(request.params(":id")));
                preparedStatement.executeUpdate();

                if (Integer.parseInt(request.queryParams("status")) == 2) {
                    Gson gson = new GsonBuilder().create();
                    preparedStatement = connection.prepareStatement(
                            StatementDormINSERT.insertReports(),
                            Statement.RETURN_GENERATED_KEYS
                    );

                    preparedStatement.setInt(1, Integer.parseInt(request.params(":id")));
                    preparedStatement.setInt(2, 0);
                    preparedStatement.setInt(3, date);
                    preparedStatement.executeUpdate();

                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            PreparedStatement preparedStatement2 = connection2.prepareStatement(StatementAccountSELECT.selectAccount());

                            preparedStatement2.setInt(1, Integer.parseInt(request.params(":id")));

                            ResultSet resultSet2 = preparedStatement2.executeQuery();

                            if (resultSet2.next()) {

                                response.status(201);

                                JsonObject jsonObject = gson.toJsonTree(
                                        new Report(
                                                Math.toIntExact(generatedKeys.getLong(1)),
                                                new Account(
                                                        resultSet2.getInt("id"),
                                                        resultSet2.getString("name_ru_name_f"),
                                                        resultSet2.getString("name_ru_name_l"),
                                                        resultSet2.getString("name_ru_patronymic"),
                                                        resultSet2.getString("name_ru_gender")
                                                ),
                                                null,
                                                0,
                                                date
                                        )
                                ).getAsJsonObject();

                                jsonObject.addProperty("date_send", date);

                                return jsonObject.toString();
                            } else {

                                response.status(500);

                                return HttpStatus.getCode(500).getMessage();
                            }
                        } else {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }
                    }
                } else {

                    response.status(200);

                    Map<String, String> map = new HashMap<>();

                    map.put("date_send", date);

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

        if (request.queryParams("status") != null) {

            try (Connection connection = DBConnection.Dorm.getDB(); Connection connection2 = DBConnection.KEU.getDB()) {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                if (Integer.parseInt(request.queryParams("status")) == 4) {
                    int accountId = 0;
                    int roomId = 0;
                    int month = 0;
                    String email = "test@simple.com";
                    PreparedStatement preparedStatement = connection.prepareStatement(StatementDormUPDATE.updateReportStatusFinale());

                    preparedStatement.setInt(1, Integer.parseInt(request.queryParams("status")));
                    preparedStatement.setString(2, "http://example.com");
                    preparedStatement.setString(3, date);
                    preparedStatement.setInt(4, Integer.parseInt(request.params(":id")));
                    preparedStatement.executeUpdate();

                    preparedStatement = connection.prepareStatement(StatementDormSELECT.selectReportID());

                    preparedStatement.setInt(1, Integer.parseInt(request.params(":id")));

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        accountId = resultSet.getInt("account_id");
                        PreparedStatement preparedStatement2 = connection.prepareStatement(StatementDormSELECT.selectRequestAccount());

                        preparedStatement2.setInt(1, accountId);

                        ResultSet resultSet2 = preparedStatement2.executeQuery();

                        if (resultSet2.next()) {
                            roomId = resultSet2.getInt("room_id");
                            month = resultSet2.getInt("month");
                            email = resultSet2.getString("email");
                        }
                    }

                    Gson gson = new GsonBuilder().create();
                    preparedStatement = connection.prepareStatement(
                            StatementDormINSERT.insertResident(),
                            Statement.RETURN_GENERATED_KEYS
                    );

                    preparedStatement.setString(1, "2017-12-22 15:42:36");
                    preparedStatement.setString(2, "2019-12-22 15:42:36");
                    preparedStatement.setInt(3, roomId);
                    preparedStatement.setInt(4, accountId);
                    preparedStatement.setInt(5, Integer.parseInt(request.params(":id")));
                    preparedStatement.executeUpdate();

                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            PreparedStatement preparedStatement2 = connection2.prepareStatement(StatementAccountSELECT.selectAccount());

                            preparedStatement2.setInt(1, accountId);

                            ResultSet resultSet2 = preparedStatement2.executeQuery();

                            if (resultSet2.next()) {

                                response.status(201);

                                JsonObject jsonObject = gson.toJsonTree(
                                        new Resident(
                                                Math.toIntExact(generatedKeys.getLong(1)),
                                                "2017-12-22 15:42:36",
                                                "2019-12-22 15:42:36",
                                                roomId,
                                                new Account(
                                                        resultSet2.getInt("id"),
                                                        resultSet2.getString("name_ru_name_f"),
                                                        resultSet2.getString("name_ru_name_l"),
                                                        resultSet2.getString("name_ru_patronymic"),
                                                        resultSet2.getString("name_ru_gender")
                                                )
                                        )
                                ).getAsJsonObject();

                                jsonObject.addProperty("date_send", date);

                                return jsonObject.toString();
                            } else {

                                response.status(500);

                                return HttpStatus.getCode(500).getMessage();
                            }
                        } else {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }
                    }
                } else {
                    PreparedStatement preparedStatement = connection.prepareStatement(StatementDormUPDATE.updateReportStatus());

                    preparedStatement.setInt(1, Integer.parseInt(request.queryParams("status")));
                    preparedStatement.setString(2, date);
                    preparedStatement.setInt(3, Integer.parseInt(request.params(":id")));
                    preparedStatement.executeUpdate();

                    if (true) {

                        response.status(200);

                        Map<String, String> map = new HashMap<>();

                        map.put("date_send", date);

                        return new Gson().toJson(map);
                    } else {

                        response.status(200);

                        Map<String, String> map = new HashMap<>();

                        map.put("date_send", date);

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
}
