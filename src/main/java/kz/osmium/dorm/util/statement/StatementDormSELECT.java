package kz.osmium.dorm.util.statement;

public class StatementDormSELECT {

    public static String selectDorms(){
        return "SELECT * FROM `dorms`";
    }

    public static String selectFloors(){
        return "SELECT * FROM `floors`";
    }

    public static String selectKitchens(){
        return "SELECT * FROM `kitchens`";
    }

    public static String selectNames(){
        return "SELECT * FROM `name`";
    }

    public static String selectRestrooms(){
        return "SELECT * FROM `restrooms`";
    }

    public static String selectRooms(){
        return "SELECT * FROM `rooms`";
    }

    public static String selectRequestAccount(){
        return "SELECT * FROM `requests` WHERE `requests`.`account_id`=?";
    }

    public static String selectRequestList(){
        return "SELECT * FROM `requests` WHERE `requests`.`status`=0";
    }

    public static String selectResident(){
        return "SELECT * FROM `residents`";
    }

    public static String selectReportAll(){
        return "SELECT * FROM `reports`";
    }

    public static String selectReportActive(){
        return "SELECT * FROM `reports` WHERE `reports`.`status`=1 OR `reports`.`status`=3";
    }

    public static String selectReportAccount(){
        return "SELECT * FROM `reports` WHERE `reports`.`account_id`=?";
    }
}
