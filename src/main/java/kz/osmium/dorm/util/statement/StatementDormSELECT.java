package kz.osmium.dorm.util.statement;

import kz.osmium.util.DataConfig;

public class StatementDormSELECT {

    /* Получить все общежития */
    public static String selectDorms() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_DORM + "`";
    }

    /* Получить все этажи */
    public static String selectFloors() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_FLOOR + "`";
    }

    /* Получить все кухни */
    public static String selectKitchens() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_KITCHEN + "`";
    }

    /* Получить все названия */
    public static String selectNames() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_NAME + "`";
    }

    /* Получить все уборные */
    public static String selectRestrooms() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_RESTROOM + "`";
    }

    /* Получить все комнаты */
    public static String selectRooms() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_ROOM + "`";
    }

    /* Получить заявление конкретного студента */
    public static String selectRequestAccount() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_REQUEST + "` WHERE `" + DataConfig.DB_DORM_REQUEST + "`.`" + DataConfig.DB_DORM_REQUEST_ACCOUNT_ID + "`=?";
    }

    /* Получить заявления со статусом нуль */
    public static String selectRequestList() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_REQUEST + "` WHERE `" + DataConfig.DB_DORM_REQUEST + "`.`" + DataConfig.DB_DORM_REQUEST_STATUS + "`=0";
    }

    /* Получить всех заселенных */
    public static String selectResident() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_RESIDENT + "`";
    }

    /* Получить все отчеты */
    public static String selectReportAll() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_REPORT + "`";
    }

    /* Прочитать отчеты со статусами один и три */
    public static String selectReportActive() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_REPORT + "` WHERE `" + DataConfig.DB_DORM_REPORT + "`.`" + DataConfig.DB_DORM_REPORT_STATUS + "`=" + DataConfig.DB_DORM_REPORT_STATUS_CHECK_ONE + " OR `" + DataConfig.DB_DORM_REPORT + "`.`" + DataConfig.DB_DORM_REPORT_STATUS + "`=" + DataConfig.DB_DORM_REPORT_STATUS_CHECK_TWO;
    }

    /* Получить отчеты студента */
    public static String selectReportAccount() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_REPORT + "` WHERE `" + DataConfig.DB_DORM_REPORT + "`.`" + DataConfig.DB_DORM_REPORT_ACCOUNT_ID + "`=?";
    }

    /* Получить активный отчет студента */
    public static String selectReportAccountActive() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_REPORT + "` WHERE `" + DataConfig.DB_DORM_REPORT + "`.`" + DataConfig.DB_DORM_REPORT_ACCOUNT_ID + "`=? AND `" + DataConfig.DB_DORM_REPORT + "`.`" + DataConfig.DB_DORM_REPORT_STATUS + "`=4 AND `" + DataConfig.DB_DORM_REPORT + "`.`" + DataConfig.DB_DORM_REPORT_STATUS + "`=5";
    }

    /* Получить отчет по ID */
    public static String selectReportID() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_REPORT + "` WHERE `" + DataConfig.DB_DORM_REPORT + "`.`" + DataConfig.DB_DORM_REPORT_ID + "`=?";
    }

    /* Получить тех, кто на данный момент живет в общежитии */
    public static String selectResidentActive() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_RESIDENT + "` WHERE `" + DataConfig.DB_DORM_RESIDENT + "`.`" + DataConfig.DB_DORM_RESIDENT_CHECK_OUT + "`>=?";
    }

    /* Получить по ID аккаутна, чтобы понять, проживает ли он сейчас или нет */
    public static String selectResidentAccountActive() {
        return "SELECT * FROM `" + DataConfig.DB_DORM_RESIDENT + "` WHERE `" + DataConfig.DB_DORM_RESIDENT + "`.`" + DataConfig.DB_DORM_RESIDENT_CHECK_OUT + "`>=? AND `" + DataConfig.DB_DORM_RESIDENT + "`.`" + DataConfig.DB_DORM_RESIDENT_ACCOUNT_ID + "`=?";
    }
}
