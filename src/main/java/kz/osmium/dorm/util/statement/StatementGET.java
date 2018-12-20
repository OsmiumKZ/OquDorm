package kz.osmium.dorm.util.statement;

public class StatementGET {

    public static String getDorms(){
        return "SELECT * FROM `dorms`";
    }

    public static String getFloors(){
        return "SELECT * FROM `floors`";
    }

    public static String getKitchens(){
        return "SELECT * FROM `kitchens`";
    }

    public static String getNames(){
        return "SELECT * FROM `name`";
    }

    public static String getRestrooms(){
        return "SELECT * FROM `restrooms`";
    }

    public static String getRooms(){
        return "SELECT * FROM `rooms`";
    }
}
