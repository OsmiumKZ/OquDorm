package kz.osmium.request;

import com.google.gson.Gson;
import kz.osmium.util.DBConnection;
import kz.osmium.util.gson.Auth;
import kz.osmium.util.statement.StatementGET;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DormGET {

    public static String getAuth(Request request, Response response) {

        if (request.queryParams("iin") != null) {

            try (Connection connection = DBConnection.KEU.getDB()) {
                PreparedStatement preparedStatement = connection.prepareStatement(StatementGET.getAuth());

                preparedStatement.setLong(1, Long.parseLong(request.queryParams("iin")));

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Auth account = new Auth(
                            resultSet.getInt("id"),
                            getName(resultSet.getInt("name_f_id"), StatementGET.getNameF(), connection),
                            getName(resultSet.getInt("name_l_id"), StatementGET.getNameL(), connection),
                            getName(resultSet.getInt("patronymic_id"), StatementGET.getPatronymic(), connection),
                            getName(resultSet.getInt("gender_id"), StatementGET.getGender(), connection),
                            resultSet.getLong("iin")
                    );


                    response.status(200);

                    return new Gson().toJson(account);
                }
            } catch (SQLException | NumberFormatException e) {

                response.status(400);

                return HttpStatus.getCode(400).getMessage();
            }
        }

        response.status(204);

        return HttpStatus.getCode(204).getMessage();
    }

    private static String getName(int id, String statement, Connection connection) throws SQLException, NumberFormatException {
        PreparedStatement preparedStatement = connection.prepareStatement(statement);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            PreparedStatement preparedStatement2 = connection.prepareStatement(StatementGET.getName());

            preparedStatement2.setInt(1, resultSet.getInt("name_id"));

            ResultSet resultSet2 = preparedStatement2.executeQuery();

            while (resultSet2.next()) {
                return resultSet2.getString("name_ru");
            }
        }

        return "Null";
    }
}
