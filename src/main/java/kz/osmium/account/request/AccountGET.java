package kz.osmium.account.request;

import com.google.gson.Gson;
import kz.osmium.account.util.gson.Account;
import kz.osmium.account.util.gson.AccountShort;
import kz.osmium.util.DBConnection;
import kz.osmium.account.util.gson.Auth;
import kz.osmium.account.util.statement.StatementAccountSELECT;
import kz.osmium.util.DataConfig;
import org.eclipse.jetty.http.HttpStatus;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountGET {

    public static String getAuth(Request request, Response response) {

        if (request.queryParams(DataConfig.DB_ACCOUNT_AUTH_UIN) != null) {

            try (Connection connection = DBConnection.KEU.getDB()) {
                PreparedStatement preparedStatement = connection.prepareStatement(StatementAccountSELECT.selectAuth());

                preparedStatement.setLong(1, Long.parseLong(request.queryParams(DataConfig.DB_ACCOUNT_AUTH_UIN)));

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Auth account = new Auth(
                            resultSet.getInt(DataConfig.DB_ACCOUNT_AUTH_ID),
                            resultSet.getString(DataConfig.DB_ACCOUNT_AUTH_NAME_F),
                            resultSet.getString(DataConfig.DB_ACCOUNT_AUTH_NAME_L),
                            resultSet.getString(DataConfig.DB_ACCOUNT_AUTH_PATRONYMIC),
                            resultSet.getString(DataConfig.DB_ACCOUNT_AUTH_GENDER)
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

    public static String getAccount(Request request, Response response) {

        try (Connection connection = DBConnection.KEU.getDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StatementAccountSELECT.selectAccount());

            preparedStatement.setInt(1, Integer.parseInt(request.queryParams(DataConfig.DB_ACCOUNT_ID)));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account account = new Account(
                        resultSet.getInt(DataConfig.DB_ACCOUNT_ID),
                        resultSet.getString(DataConfig.DB_ACCOUNT_NAME_F),
                        resultSet.getString(DataConfig.DB_ACCOUNT_NAME_L),
                        resultSet.getString(DataConfig.DB_ACCOUNT_PATRONYMIC),
                        resultSet.getString(DataConfig.DB_ACCOUNT_GENDER)
                );

                response.status(200);

                return new Gson().toJson(account);
            }

            response.status(400);

            return HttpStatus.getCode(400).getMessage();
        } catch (SQLException | NumberFormatException e) {

            response.status(400);

            return HttpStatus.getCode(400).getMessage();
        }
    }

    public static AccountShort getAccountShortInfo(int idAccount) throws SQLException {

        try (Connection connection = DBConnection.KEU.getDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(StatementAccountSELECT.selectAccount());

            preparedStatement.setInt(1, idAccount);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                return new AccountShort(
                        resultSet.getInt(DataConfig.DB_ACCOUNT_SHORT_ID),
                        resultSet.getString(DataConfig.DB_ACCOUNT_SHORT_NAME_F),
                        resultSet.getString(DataConfig.DB_ACCOUNT_SHORT_NAME_L),
                        resultSet.getString(DataConfig.DB_ACCOUNT_SHORT_PATRONYMIC),
                        resultSet.getString(DataConfig.DB_ACCOUNT_SHORT_GENDER)
                );

            throw new SQLException();
        }
    }
}
