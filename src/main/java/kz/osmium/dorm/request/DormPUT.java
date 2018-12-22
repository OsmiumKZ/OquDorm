package kz.osmium.dorm.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kz.osmium.account.util.gson.Account;
import kz.osmium.account.util.statement.StatementAccountSELECT;
import kz.osmium.dorm.util.gson.Report;
import kz.osmium.dorm.util.statement.StatementDormINSERT;
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
                                                0
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
}
