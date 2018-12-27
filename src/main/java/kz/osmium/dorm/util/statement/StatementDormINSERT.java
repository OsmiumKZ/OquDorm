package kz.osmium.dorm.util.statement;

import kz.osmium.util.DataConfig;

public class StatementDormINSERT {

    /* Создание заявки */
    public static String insertRequests() {
        return "INSERT INTO `"+ DataConfig.DB_DORM_REQUEST +"` " +
                "(`"+ DataConfig.DB_DORM_REQUEST_ACCOUNT_ID +"`, `"+ DataConfig.DB_DORM_REQUEST_ROOM_ID +"`, `"+ DataConfig.DB_DORM_REQUEST_STATUS +"`, `"+ DataConfig.DB_DORM_REQUEST_BOOKING_PERIOD +"`, `"+ DataConfig.DB_DORM_REQUEST_EMAIL +"`, `"+ DataConfig.DB_DORM_REQUEST_DATE_SEND +"`) " +
                "VALUE (?, ?, ?, ?, ?, ?)";
    }

    /* Создание отчета */
    public static String insertReports() {
        return "INSERT INTO `"+ DataConfig.DB_DORM_REPORT +"` " +
                "(`"+ DataConfig.DB_DORM_REPORT_ACCOUNT_ID +"`, `"+ DataConfig.DB_DORM_REPORT_STATUS +"`, `"+ DataConfig.DB_DORM_REPORT_DATE_SEND +"`) " +
                "VALUE (?, ?, ?)";
    }

    /* Создание заселенного */
    public static String insertResident() {
        return "INSERT INTO `"+ DataConfig.DB_DORM_RESIDENT +"` " +
                "(`"+ DataConfig.DB_DORM_RESIDENT_CHECK_IN +"`, `"+ DataConfig.DB_DORM_RESIDENT_CHECK_OUT +"`, `"+ DataConfig.DB_DORM_RESIDENT_ROOM_ID +"`, `"+ DataConfig.DB_DORM_RESIDENT_ACCOUNT_ID +"`, `"+ DataConfig.DB_DORM_RESIDENT_REPORT_ID +"`, `"+ DataConfig.DB_DORM_RESIDENT_DATE_CREATE +"`) " +
                "VALUE (?, ?, ?, ?, ?, ?)";
    }
}
