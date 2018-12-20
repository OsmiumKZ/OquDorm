package kz.osmium.dorm.request;

import com.google.gson.Gson;
import kz.osmium.dorm.util.gson.*;
import kz.osmium.dorm.util.statement.StatementGET;
import kz.osmium.util.DBConnection;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DormGET {

    public static String getAuth(Request request, Response response) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StatementGET.getDormAll());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DormAll> listDormAll = new ArrayList<>();

            while (resultSet.next())
                listDormAll.add(new DormAll(
                        new Dorm(
                                resultSet.getInt("id_dorms"),
                                resultSet.getInt("name_id_dorms")
                        ),
                        new Floor(
                                resultSet.getInt("id_floors"),
                                resultSet.getInt("number"),
                                resultSet.getInt("dorm_id")
                        ),
                        new Kitchen(
                                resultSet.getInt("id_kitchens"),
                                resultSet.getInt("name_id_kitchens"),
                                resultSet.getInt("plate"),
                                resultSet.getInt("sink_kitchens"),
                                resultSet.getInt("floor_id_kitchens")
                        ),
                        new Name(
                                resultSet.getInt("id_name"),
                                resultSet.getString("name_ru"),
                                resultSet.getString("name_ru_genetive"),
                                resultSet.getString("name_ru_dative"),
                                resultSet.getString("name_kz"),
                                resultSet.getString("name_kz_genetive"),
                                resultSet.getString("name_kz_dative"),
                                resultSet.getString("name_en"),
                                resultSet.getString("name_en_genetive"),
                                resultSet.getString("name_en_dative")
                        ),
                        new Restroom(
                                resultSet.getInt("id_restrooms"),
                                resultSet.getInt("name_id_restrooms"),
                                resultSet.getInt("restroom"),
                                resultSet.getInt("shower"),
                                resultSet.getInt("sink_restrooms"),
                                resultSet.getInt("floor_id_restrooms")
                        ),
                        new Room(
                                resultSet.getInt("id_rooms"),
                                resultSet.getInt("name_id_rooms"),
                                resultSet.getInt("max"),
                                resultSet.getInt("floor_id_rooms"),
                                resultSet.getInt("nightstand"),
                                resultSet.getInt("chiffonier"),
                                resultSet.getInt("shelf"),
                                resultSet.getInt("wifi")
                        )
                ));

            response.status(200);

            return new Gson().toJson(listDormAll);
        } catch (SQLException | NumberFormatException e) {

            response.status(400);

            return e.getMessage();
        }
    }
}
