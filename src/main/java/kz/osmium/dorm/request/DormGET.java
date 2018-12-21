package kz.osmium.dorm.request;

import com.google.gson.Gson;
import kz.osmium.account.util.gson.Account;
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

    public static String getDB(Response response) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            DormAll dormAll = new DormAll();

            PreparedStatement preparedStatement = connection.prepareStatement(StatementGET.getDorms());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                dormAll.getDorms()
                        .add(
                                new Dorm(
                                        resultSet.getInt("id"),
                                        resultSet.getInt("name_id")
                                )
                        );

            preparedStatement = connection.prepareStatement(StatementGET.getFloors());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                dormAll.getFloors()
                        .add(
                                new Floor(
                                        resultSet.getInt("id"),
                                        resultSet.getInt("number"),
                                        resultSet.getInt("dorm_id")
                                )
                        );

            preparedStatement = connection.prepareStatement(StatementGET.getKitchens());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                dormAll.getKitchens()
                        .add(
                                new Kitchen(
                                        resultSet.getInt("id"),
                                        resultSet.getInt("name_id"),
                                        resultSet.getInt("plate"),
                                        resultSet.getInt("sink"),
                                        resultSet.getInt("floor_id")
                                )
                        );

            preparedStatement = connection.prepareStatement(StatementGET.getNames());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                dormAll.getNames()
                        .add(
                                new Name(
                                        resultSet.getInt("id"),
                                        resultSet.getString("name_ru"),
                                        resultSet.getString("name_ru_genetive"),
                                        resultSet.getString("name_ru_dative"),
                                        resultSet.getString("name_kz"),
                                        resultSet.getString("name_kz_genetive"),
                                        resultSet.getString("name_kz_dative"),
                                        resultSet.getString("name_en"),
                                        resultSet.getString("name_en_genetive"),
                                        resultSet.getString("name_en_dative")
                                )
                        );

            preparedStatement = connection.prepareStatement(StatementGET.getRestrooms());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                dormAll.getRestroom()
                        .add(
                                new Restroom(
                                        resultSet.getInt("id"),
                                        resultSet.getInt("name_id"),
                                        resultSet.getInt("restroom"),
                                        resultSet.getInt("shower"),
                                        resultSet.getInt("sink"),
                                        resultSet.getInt("floor_id")
                                )
                        );

            preparedStatement = connection.prepareStatement(StatementGET.getRooms());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                dormAll.getRooms()
                        .add(
                                new Room(
                                        resultSet.getInt("id"),
                                        resultSet.getInt("name_id"),
                                        resultSet.getInt("max"),
                                        resultSet.getInt("floor_id"),
                                        resultSet.getInt("nightstand"),
                                        resultSet.getInt("chiffonier"),
                                        resultSet.getInt("shelf"),
                                        resultSet.getInt("wifi")
                                )
                        );

            response.status(200);

            return new Gson().toJson(dormAll);
        } catch (SQLException | NumberFormatException e) {

            response.status(400);

            return HttpStatus.getCode(400).getMessage();
        }
    }

    public static String getRequestAccount(Request request, Response response) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StatementGET.getRequestAccount());

            preparedStatement.setInt(1, Integer.parseInt(request.params(":id")));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                response.status(200);

                return new Gson().toJson(
                        new kz.osmium.dorm.util.gson.Request(
                                resultSet.getInt("id"),
                                resultSet.getInt("account_id"),
                                resultSet.getInt("room_id"),
                                resultSet.getInt("status"),
                                resultSet.getInt("month"),
                                resultSet.getString("date_send")
                        )
                );
            }

            response.status(400);

            return HttpStatus.getCode(400).getMessage();
        } catch (SQLException e) {

            response.status(409);

            return HttpStatus.getCode(409).getMessage();
        }
    }

    public static String getRequestList(Request request, Response response) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StatementGET.getRequestList());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<RequestAll> list = new ArrayList<>();

            while (resultSet.next()){
                PreparedStatement preparedStatement2 = connection.prepareStatement(kz.osmium.account.util.statement.StatementGET.getAccount());

                preparedStatement2.setInt(1, resultSet.getInt("account_id"));

                ResultSet resultSet2 = preparedStatement2.executeQuery();

//                while (resultSet2.next())
//                    list.add(
//                            new RequestAll(
//                                    resultSet.getInt("id"),
//                                    new Account(
//                                            resultSet2.getInt("id"),
//                                            resultSet2.getString("name_ru_name_f"),
//                                            resultSet2.getString("name_ru_name_l"),
//                                            resultSet2.getString("name_ru_patronymic"),
//                                            resultSet2.getString("name_ru_gender")
//                                    ),
//                                    resultSet.getInt("room_id"),
//                                    resultSet.getInt("status"),
//                                    resultSet.getInt("month"),
//                                    resultSet.getString("date_send")
//                            )
//                    );
            }

            response.status(200);

            return new Gson().toJson(list);
        } catch (SQLException e) {

            response.status(409);

            return e.getMessage();
        }
    }
}
