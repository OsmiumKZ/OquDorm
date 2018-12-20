package kz.osmium.account.util.statement;

public class StatementGET {

    public static String getAuth() {
        return "SELECT * FROM `accounts` WHERE `accounts`.iin=?";
    }

    public static String getName() {
        return "SELECT * FROM `name` WHERE `name`.id=?";
    }

    public static String getGender() {
        return "SELECT * FROM `gender` WHERE `gender`.id=?";
    }

    public static String getNameF() {
        return "SELECT * FROM `name_f` WHERE `name_f`.id=?";
    }

    public static String getNameL() {
        return "SELECT * FROM `name_l` WHERE `name_l`.id=?";
    }

    public static String getPatronymic() {
        return "SELECT * FROM `patronymic` WHERE `patronymic`.id=?";
    }
}
