package kz.osmium.dorm.request;

import com.google.gson.Gson;
import kz.osmium.dorm.util.statement.StatementGET;
import kz.osmium.dorm.util.statement.StatementPOST;
import kz.osmium.dorm.util.statement.StatementPUT;
import kz.osmium.util.DBConnection;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.*;

public class DormPOST {

    public static String postRequest(Request request, Response response) {

            if (request.queryParams("account_id") != null &&
                    request.queryParams("room_id") != null &&
                    request.queryParams("month") != null) {

                try (Connection connection = DBConnection.Dorm.getDB()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(StatementGET.getRequestAccount());

                    preparedStatement.setInt(1, Integer.parseInt(request.queryParams("account_id")));

                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        PreparedStatement preparedStatement2 = connection.prepareStatement(StatementPUT.putRequest());

                        preparedStatement2.setInt(1, Integer.parseInt(request.queryParams("room_id")));
                        preparedStatement2.setInt(2, 0);
                        preparedStatement2.setInt(3, Integer.parseInt(request.queryParams("month")));
                        preparedStatement2.setString(4, "2011-04-12T00:00:00.000");
                        preparedStatement2.setInt(5, Integer.parseInt(request.queryParams("account_id")));

                        if (preparedStatement2.executeUpdate() == 0) {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }

                        response.status(201);

                        return new Gson().toJson(
                                new kz.osmium.dorm.util.gson.Request(
                                        resultSet.getInt("id"),
                                        Integer.parseInt(request.queryParams("account_id")),
                                        Integer.parseInt(request.queryParams("room_id")),
                                        0,
                                        Integer.parseInt(request.queryParams("month")),
                                        request.queryParams("date_send")
                                )
                        );
                    }

                    preparedStatement = connection
                            .prepareStatement(
                                    StatementPOST.postRequests(),
                                    Statement.RETURN_GENERATED_KEYS
                            );

                    preparedStatement.setInt(1, Integer.parseInt(request.queryParams("account_id")));
                    preparedStatement.setInt(2, Integer.parseInt(request.queryParams("room_id")));
                    preparedStatement.setInt(3, 0);
                    preparedStatement.setInt(4, Integer.parseInt(request.queryParams("month")));
                    preparedStatement.setString(5, "2011-04-12T00:00:00.000");

                    if (preparedStatement.executeUpdate() == 0) {

                        response.status(500);

                        return HttpStatus.getCode(500).getMessage();
                    }

                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {

                            response.status(201);

                            return new Gson().toJson(
                                    new kz.osmium.dorm.util.gson.Request(
                                            Math.toIntExact(generatedKeys.getLong(1)),
                                            Integer.parseInt(request.queryParams("account_id")),
                                            Integer.parseInt(request.queryParams("room_id")),
                                            0,
                                            Integer.parseInt(request.queryParams("month")),
                                            request.queryParams("date_send")
                                    )
                            );
                        } else {

                            response.status(500);

                            return HttpStatus.getCode(500).getMessage();
                        }
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
}
