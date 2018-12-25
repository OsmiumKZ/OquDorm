package kz.osmium.dorm.util.statement;

public class StatementDormUPDATE {

    /* Обновить заявление студента */
    public static String updateRequest() {
        return "UPDATE `requests` " +
                "SET `requests`.`room_id`= ?, " +
                "`requests`.`status`= ?, " +
                "`requests`.`booking_period`= ?, " +
                "`requests`.`email`= ?, " +
                "`requests`.`date_send`= ? " +
                "WHERE `requests`.`account_id`=?";
    }

    /* Обновить заявление студента */
    public static String updateRequestStatus() {
        return "UPDATE `requests` " +
                "SET `requests`.`status`= ?, " +
                "`requests`.`date_send`= ? " +
                "WHERE `requests`.`account_id`=?";
    }

    /* Обновить отчет по ID */
    public static String updateReportStatus() {
        return "UPDATE `reports` " +
                "SET `reports`.`status`= ?, " +
                "`reports`.`date_send`= ? " +
                "WHERE `reports`.`id`=?";
    }

    /* Обновить отчеты по ID */
    public static String updateReportStatusFinale() {
        return "UPDATE `reports` " +
                "SET `reports`.`status`= ?, " +
                "`reports`.`admin`= ?, " +
                "`reports`.`date_send`= ? " +
                "WHERE `reports`.`id`=?";
    }
}
