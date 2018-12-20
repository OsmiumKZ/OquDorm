package kz.osmium.dorm.request;

import kz.osmium.dorm.util.statement.StatementPUT;
import kz.osmium.util.DBConnection;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DormPUT {

    public static String putRequestStatus(Request request, Response response) {

            if (request.queryParams("account_id") != null &&
                    request.queryParams("status") != null) {

                try (Connection connection = DBConnection.Dorm.getDB()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(StatementPUT.putRequestStatus());

                    preparedStatement.setInt(1, Integer.parseInt(request.params(":id")));
                    preparedStatement.setInt(2, Integer.parseInt(request.queryParams("status")));
                    preparedStatement.executeUpdate();

                    response.status(200);
                } catch (SQLException | NumberFormatException e) {

                    response.status(409);

                    return HttpStatus.getCode(409).getMessage();
                }

                return HttpStatus.getCode(200).getMessage();
            } else {

                response.status(204);

                return HttpStatus.getCode(204).getMessage();
            }
    }
}
