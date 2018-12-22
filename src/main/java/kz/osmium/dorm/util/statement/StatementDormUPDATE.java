package kz.osmium.dorm.util.statement;

public class StatementDormUPDATE {

    public static String updateRequest() {
        return "UPDATE `requests` " +
                "SET `requests`.`room_id`= ?, " +
                "`requests`.`status`= ?, " +
                "`requests`.`month`= ?, " +
                "`requests`.`email`= ?, " +
                "`requests`.`date_send`= ? " +
                "WHERE `requests`.`account_id`=?";
    }

    public static String updateRequestStatus() {
        return "UPDATE `requests` " +
                "SET `requests`.`status`= ?, " +
                "`requests`.`date_send`= ? " +
                "WHERE `requests`.`account_id`=?";
    }
}
