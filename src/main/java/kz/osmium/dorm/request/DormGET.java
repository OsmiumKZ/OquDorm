package kz.osmium.dorm.request;

import com.google.gson.Gson;
import kz.osmium.account.request.AccountGET;
import kz.osmium.dorm.util.gson.*;
import kz.osmium.dorm.util.statement.StatementDormSELECT;
import kz.osmium.util.CommonMethods;
import kz.osmium.util.DBConnection;
import kz.osmium.util.DataConfig;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DormGET {

    public static String getDB(Response response) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            DataBase dormAll = new DataBase();

            PreparedStatement statement = connection.prepareStatement(StatementDormSELECT.selectDorms());
            ResultSet result = statement.executeQuery();

            while (result.next())
                dormAll.getDorms()
                        .add(
                                new Dorm(
                                        result.getInt(DataConfig.DB_DORM_DORM_ID),
                                        result.getInt(DataConfig.DB_DORM_DORM_NAME_ID)
                                )
                        );

            statement = connection.prepareStatement(StatementDormSELECT.selectFloors());
            result = statement.executeQuery();

            while (result.next())
                dormAll.getFloors()
                        .add(
                                new Floor(
                                        result.getInt(DataConfig.DB_DORM_FLOOR_ID),
                                        result.getInt(DataConfig.DB_DORM_FLOOR_NUMBER),
                                        result.getInt(DataConfig.DB_DORM_FLOOR_DORM_ID)
                                )
                        );

            statement = connection.prepareStatement(StatementDormSELECT.selectKitchens());
            result = statement.executeQuery();

            while (result.next())
                dormAll.getKitchens()
                        .add(
                                new Kitchen(
                                        result.getInt(DataConfig.DB_DORM_KITCHEN_ID),
                                        result.getInt(DataConfig.DB_DORM_KITCHEN_NAME_ID),
                                        result.getInt(DataConfig.DB_DORM_KITCHEN_PLATE_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_KITCHEN_SINK_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_KITCHEN_FLOOR_ID)
                                )
                        );

            statement = connection.prepareStatement(StatementDormSELECT.selectNames());
            result = statement.executeQuery();

            while (result.next())
                dormAll.getNames()
                        .add(
                                new Name(
                                        result.getInt(DataConfig.DB_DORM_NAME_ID),
                                        result.getString(DataConfig.DB_DORM_NAME_ONE),
                                        result.getString(DataConfig.DB_DORM_NAME_GENITIVE),
                                        result.getString(DataConfig.DB_DORM_NAME_DATIVE)
                                )
                        );

            statement = connection.prepareStatement(StatementDormSELECT.selectRestrooms());
            result = statement.executeQuery();

            while (result.next())
                dormAll.getRestroom()
                        .add(
                                new Restroom(
                                        result.getInt(DataConfig.DB_DORM_RESTROOM_ID),
                                        result.getInt(DataConfig.DB_DORM_RESTROOM_NAME_ID),
                                        result.getInt(DataConfig.DB_DORM_RESTROOM_TOILET_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_RESTROOM_SHOWER_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_RESTROOM_SINK_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_RESTROOM_FLOOR_ID)
                                )
                        );

            statement = connection.prepareStatement(StatementDormSELECT.selectRooms());
            result = statement.executeQuery();

            while (result.next())
                dormAll.getRooms()
                        .add(
                                new Room(
                                        result.getInt(DataConfig.DB_DORM_ROOM_ID),
                                        result.getInt(DataConfig.DB_DORM_ROOM_NAME_ID),
                                        result.getInt(DataConfig.DB_DORM_ROOM_MAX),
                                        result.getInt(DataConfig.DB_DORM_ROOM_FLOOR_ID),
                                        result.getInt(DataConfig.DB_DORM_ROOM_NIGHTSTAND_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_ROOM_CHIFFONIER_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_ROOM_SHELF_AMOUNT),
                                        result.getInt(DataConfig.DB_DORM_ROOM_WIFI)
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
            PreparedStatement statement = connection.prepareStatement(StatementDormSELECT.selectRequestAccount());

            statement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REQUEST_ACCOUNT)));

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                response.status(200);

                return new Gson().toJson(
                        new Requests(
                                result.getInt(DataConfig.DB_DORM_REQUEST_ID),
                                AccountGET.getAccountShortInfo(result.getInt(DataConfig.DB_DORM_REQUEST_ACCOUNT_ID)),
                                result.getInt(DataConfig.DB_DORM_REQUEST_ROOM_ID),
                                result.getInt(DataConfig.DB_DORM_REQUEST_STATUS),
                                result.getInt(DataConfig.DB_DORM_REQUEST_BOOKING_PERIOD),
                                result.getString(DataConfig.DB_DORM_REQUEST_EMAIL),
                                result.getString(DataConfig.DB_DORM_REQUEST_DATE_SEND)
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
            PreparedStatement statement = connection.prepareStatement(StatementDormSELECT.selectRequestList());
            ResultSet result = statement.executeQuery();
            List<Requests> list = new ArrayList<>();

            while (result.next())
                list.add(
                        new Requests(
                                result.getInt(DataConfig.DB_DORM_REQUEST_ID),
                                AccountGET.getAccountShortInfo(result.getInt(DataConfig.DB_DORM_REQUEST_ACCOUNT_ID)),
                                result.getInt(DataConfig.DB_DORM_REQUEST_ROOM_ID),
                                result.getInt(DataConfig.DB_DORM_REQUEST_STATUS),
                                result.getInt(DataConfig.DB_DORM_REQUEST_BOOKING_PERIOD),
                                result.getString(DataConfig.DB_DORM_REQUEST_EMAIL),
                                result.getString(DataConfig.DB_DORM_REQUEST_DATE_SEND)
                        )
                );

            response.status(200);

            return new Gson().toJson(list);
        } catch (SQLException e) {

            response.status(409);

            return e.getMessage();
        }
    }

    public static String getResident(Request request, Response response) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            PreparedStatement statement = connection.prepareStatement(StatementDormSELECT.selectResident());
            ResultSet result = statement.executeQuery();
            List<Resident> list = new ArrayList<>();

            while (result.next())
                list.add(
                        new Resident(
                                result.getInt(DataConfig.DB_DORM_RESIDENT_ID),
                                result.getString(DataConfig.DB_DORM_RESIDENT_CHECK_IN),
                                result.getString(DataConfig.DB_DORM_RESIDENT_CHECK_OUT),
                                result.getInt(DataConfig.DB_DORM_RESIDENT_ROOM_ID),
                                AccountGET.getAccountShortInfo(result.getInt(DataConfig.DB_DORM_RESIDENT_ACCOUNT_ID)),
                                result.getInt(DataConfig.DB_DORM_RESIDENT_REPORT_ID),
                                result.getString(DataConfig.DB_DORM_RESIDENT_DATE_CREATE)
                        )
                );

            response.status(200);

            return new Gson().toJson(list);
        } catch (SQLException e) {

            response.status(409);

            return e.getMessage();
        }
    }

    public static String getResidentActive(Request request, Response response) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            PreparedStatement statement = connection.prepareStatement(StatementDormSELECT.selectResidentActive());

            statement.setString(1, CommonMethods.getDateText(new Date()));

            ResultSet result = statement.executeQuery();
            List<Resident> list = new ArrayList<>();

            while (result.next())
                list.add(
                        new Resident(
                                result.getInt(DataConfig.DB_DORM_RESIDENT_ID),
                                result.getString(DataConfig.DB_DORM_RESIDENT_CHECK_IN),
                                result.getString(DataConfig.DB_DORM_RESIDENT_CHECK_OUT),
                                result.getInt(DataConfig.DB_DORM_RESIDENT_ROOM_ID),
                                AccountGET.getAccountShortInfo(result.getInt(DataConfig.DB_DORM_RESIDENT_ACCOUNT_ID)),
                                result.getInt(DataConfig.DB_DORM_RESIDENT_REPORT_ID),
                                result.getString(DataConfig.DB_DORM_RESIDENT_DATE_CREATE)
                        )
                );

            response.status(200);

            return new Gson().toJson(list);
        } catch (SQLException e) {

            response.status(409);

            return e.getMessage();
        }
    }

    public static String getReportAll(Request request, Response response) {

        return getReport(request, response, StatementDormSELECT.selectReportAll());
    }

    public static String getReportActive(Request request, Response response) {

        return getReport(request, response, StatementDormSELECT.selectReportActive());
    }

    public static String getReportAccount(Request request, Response response) {

        return getReport(request, response, StatementDormSELECT.selectReportAccount());
    }

    private static String getReport(Request request, Response response, String sql) {

        try (Connection connection = DBConnection.Dorm.getDB()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            if (request.queryParams(DataConfig.DB_DORM_REPORT_ACCOUNT) != null)
                statement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_DORM_REPORT_ACCOUNT)));

            ResultSet result = statement.executeQuery();
            List<Report> list = new ArrayList<>();

            while (result.next())
                list.add(
                        new Report(
                                result.getInt(DataConfig.DB_DORM_REPORT_ID),
                                AccountGET.getAccountShortInfo(result.getInt(DataConfig.DB_DORM_REPORT_ACCOUNT_ID)),
                                result.getString(DataConfig.DB_DORM_REPORT_ADMIN),
                                result.getInt(DataConfig.DB_DORM_REPORT_STATUS),
                                result.getString(DataConfig.DB_DORM_REPORT_DATE_SEND)
                        )
                );

            response.status(200);

            return new Gson().toJson(list);
        } catch (SQLException | NumberFormatException e) {

            response.status(409);

            return e.getMessage();
        }
    }
}
