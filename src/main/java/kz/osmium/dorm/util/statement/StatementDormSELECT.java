package kz.osmium.dorm.util.statement;

import kz.osmium.util.DataConfig;

public class StatementDormSELECT {

    /* Прочитать все общежития */
    public static String selectDorms(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_DORM +"`";
    }
    /* Прочитать все этажи */
    public static String selectFloors(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_FLOOR +"`";
    }

    /* Прочитать все кухни */
    public static String selectKitchens(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_KITCHEN +"`";
    }

    /* Прочитать все названия */
    public static String selectNames(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_NAME +"`";
    }

    /* Прочитать все уборные */
    public static String selectRestrooms(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_RESTROOM +"`";
    }

    /* Прочитать все комнаты */
    public static String selectRooms(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_ROOM +"`";
    }

    /* Прочитать заявление конкретного студента */
    public static String selectRequestAccount(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_REQUEST +"` WHERE `"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_ACCOUNT_ID +"`=?";
    }

    /* Прочитать заявления со статусом нуль */
    public static String selectRequestList(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_REQUEST +"` WHERE `"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_STATUS +"`=0";
    }

    /* Прочитать всех заселенных */
    public static String selectResident(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_RESIDENT +"`";
    }

    /* Прочитать все отчеты */
    public static String selectReportAll(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_REPORT +"`";
    }

    /* Прочитать отчеты со статусами один и три */
    public static String selectReportActive(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_REPORT +"` WHERE `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_STATUS +"`="+ DataConfig.DB_DORM_REPORT_STATUS_CHECK_ONE +" OR `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_STATUS +"`="+ DataConfig.DB_DORM_REPORT_STATUS_CHECK_TWO;
    }

    /* Прочитеть отчеты студента */
    public static String selectReportAccount(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_REPORT +"` WHERE `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_ACCOUNT_ID +"`=?";
    }

    /* Прочитать отчет по ID */
    public static String selectReportID(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_REPORT +"` WHERE `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_ID +"`=?";
    }

    /* Прочитать заявление по ID */
    public static String selectRequestID(){
        return "SELECT * FROM `"+ DataConfig.DB_DORM_REQUEST +"` WHERE `"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_ID +"`=?";
    }

    /* Прочитать тех, кто на данный момент живет в общежитии */
    public static String selectResidentActive(){
        return "SELECT * FROM `" + DataConfig.DB_DORM_RESIDENT + "` WHERE `" + DataConfig.DB_DORM_RESIDENT + "`.`" + DataConfig.DB_DORM_RESIDENT_CHECK_OUT + "`>=?";
    }
}
