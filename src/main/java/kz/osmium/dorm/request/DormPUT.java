package kz.osmium.dorm.request;

import com.google.gson.Gson;
import kz.osmium.dorm.util.statement.StatementPUT;
import kz.osmium.util.DBConnection;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DormPUT {

    public static String putRequestStatus(Request request, Response response) {

        if (request.queryParams("status") != null) {

            try (Connection connection = DBConnection.Dorm.getDB()) {
                PreparedStatement preparedStatement = connection.prepareStatement(StatementPUT.putRequestStatus());

                preparedStatement.setInt(1, Integer.parseInt(request.queryParams("status")));
                preparedStatement.setString(2, "2011-04-12T00:00:00.000");
                preparedStatement.setInt(3, Integer.parseInt(request.params(":id")));
                preparedStatement.executeUpdate();

                response.status(200);

                Map<String, String> map = new HashMap<>();

                map.put("date_send", "2011-04-12T00:00:00.000");

                return new Gson().toJson(map);
            } catch (SQLException | NumberFormatException e) {

                response.status(409);

                return HttpStatus.getCode(409).getMessage();
            }
        } else {

            response.status(204);

            return HttpStatus.getCode(204).getMessage();
        }
    }
}
