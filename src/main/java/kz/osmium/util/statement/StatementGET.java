package kz.osmium.util.statement;

public class StatementGET {

    public static String getAuth() {
        return "SELECT * FROM `accounts` WHERE `accounts`.iin=?";
    }
}
