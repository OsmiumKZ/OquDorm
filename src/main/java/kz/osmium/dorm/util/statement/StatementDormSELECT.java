package kz.osmium.dorm.util.statement;

public class StatementDormSELECT {

    /* Прочитать все общежития */
    public static String selectDorms(){
        return "SELECT * FROM `dorms`";
    }
    /* Прочитать все этажи */
    public static String selectFloors(){
        return "SELECT * FROM `floors`";
    }

    /* Прочитать все кухни */
    public static String selectKitchens(){
        return "SELECT * FROM `kitchens`";
    }

    /* Прочитать все названия */
    public static String selectNames(){
        return "SELECT * FROM `name`";
    }

    /* Прочитать все уборные */
    public static String selectRestrooms(){
        return "SELECT * FROM `restrooms`";
    }

    /* Прочитать все комнаты */
    public static String selectRooms(){
        return "SELECT * FROM `rooms`";
    }

    /* Прочитать заявление конкретного студента */
    public static String selectRequestAccount(){
        return "SELECT * FROM `requests` WHERE `requests`.`account_id`=?";
    }

    /* Прочитать заявления со статусом нуль */
    public static String selectRequestList(){
        return "SELECT * FROM `requests` WHERE `requests`.`status`=0";
    }

    /* Прочитать всех заселенных */
    public static String selectResident(){
        return "SELECT * FROM `residents`";
    }

    /* Прочитать все отчеты */
    public static String selectReportAll(){
        return "SELECT * FROM `reports`";
    }

    /* Прочитать отчеты со статусами один и три */
    public static String selectReportActive(){
        return "SELECT * FROM `reports` WHERE `reports`.`status`=1 OR `reports`.`status`=3";
    }

    /* Прочитеть отчеты студента */
    public static String selectReportAccount(){
        return "SELECT * FROM `reports` WHERE `reports`.`account_id`=?";
    }

    /* Прочитать отчет по ID */
    public static String selectReportID(){
        return "SELECT * FROM `reports` WHERE `reports`.`id`=?";
    }
}
