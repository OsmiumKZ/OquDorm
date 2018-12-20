package kz.osmium.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static class Dorm {

        /* Ссылка на базу данных. */
        private static URI dbUri;

        static {

            try {
                dbUri = new URI(System.getenv("JAWSDB_URL"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        /**
         * Ссылка для подключения к базе данных через JDBC.
         * {@link DriverManager#getConnection}
         */
        private static final String url = "jdbc:mysql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath() + "?" + dbUri.getQuery();

        /* Логин для подключения к базе данных. */
        private static final String login = dbUri.getUserInfo().split(":")[0];

        /* Пароль для подключения к базе данных. */
        private static final String password = dbUri.getUserInfo().split(":")[1];

        /* Подключение к БД. */
        public static Connection getDB() throws SQLException {
            return DriverManager.getConnection(url, login, password);
        }
    }

    public static class KEU {

        /* Ссылка на базу данных. */
        private static URI dbUri;

        static {

            try {
                dbUri = new URI(System.getenv("JAWSDB_CRIMSON_URL"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        /**
         * Ссылка для подключения к базе данных через JDBC.
         * {@link DriverManager#getConnection}
         */
        private static final String url = "jdbc:mysql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath() + "?" + dbUri.getQuery();

        /* Логин для подключения к базе данных. */
        private static final String login = dbUri.getUserInfo().split(":")[0];

        /* Пароль для подключения к базе данных. */
        private static final String password = dbUri.getUserInfo().split(":")[1];

        /* Подключение к БД. */
        public static Connection getDB() throws SQLException {
            return DriverManager.getConnection(url, login, password);
        }
    }
}
