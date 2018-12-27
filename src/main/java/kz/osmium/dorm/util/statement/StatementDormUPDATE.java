package kz.osmium.dorm.util.statement;

import kz.osmium.util.DataConfig;

public class StatementDormUPDATE {

    /* Обновить заявление студента */
    public static String updateRequest() {
        return "UPDATE `"+ DataConfig.DB_DORM_REQUEST +"` " +
                "SET `"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_ROOM_ID +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_STATUS +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_BOOKING_PERIOD +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_EMAIL +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_DATE_SEND +"`= ? " +
                "WHERE `"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_ACCOUNT_ID +"`=?";
    }

    /* Обновить заявление студента */
    public static String updateRequestStatus() {
        return "UPDATE `"+ DataConfig.DB_DORM_REQUEST +"` " +
                "SET `"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_STATUS +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_DATE_SEND +"`= ? " +
                "WHERE `"+ DataConfig.DB_DORM_REQUEST +"`.`"+ DataConfig.DB_DORM_REQUEST_ACCOUNT_ID +"`=?";
    }

    /* Обновить отчет по ID */
    public static String updateReportStatus() {
        return "UPDATE `"+ DataConfig.DB_DORM_REPORT +"` " +
                "SET `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_STATUS +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_DATE_SEND +"`= ? " +
                "WHERE `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_ID +"`=?";
    }

    /* Обновить отчеты по ID */
    public static String updateReportStatusFinale() {
        return "UPDATE `"+ DataConfig.DB_DORM_REPORT +"` " +
                "SET `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_STATUS +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_ADMIN +"`= ?, " +
                "`"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_DATE_SEND +"`= ? " +
                "WHERE `"+ DataConfig.DB_DORM_REPORT +"`.`"+ DataConfig.DB_DORM_REPORT_ID +"`=?";
    }
}
