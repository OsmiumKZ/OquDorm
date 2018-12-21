package kz.osmium.dorm.request;

import com.google.gson.Gson;
import kz.osmium.dorm.util.statement.StatementDormPUT;
import kz.osmium.util.DBConnection;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DormPUT {

    public static String putRequestStatus(Request request, Response response) {

        if (request.queryParams("status") != null) {

            try (Connection connection = DBConnection.Dorm.getDB()) {
                String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss k").format(new Date());
                PreparedStatement preparedStatement = connection.prepareStatement(StatementDormPUT.putRequestStatus());

                preparedStatement.setInt(1, Integer.parseInt(request.queryParams("status")));
                preparedStatement.setString(2, date);
                preparedStatement.setInt(3, Integer.parseInt(request.params(":id")));
                preparedStatement.executeUpdate();

                response.status(200);

                Map<String, String> map = new HashMap<>();

                map.put("date_send", date);

                return new Gson().toJson(map);
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
