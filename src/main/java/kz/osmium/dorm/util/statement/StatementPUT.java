package kz.osmium.dorm.util.statement;

public class StatementPUT {

    public static String putRequest() {
        return "UPDATE `requests` " +
                "SET `requests`.`room_id`= ?, " +
                "`requests`.`status`= ?, " +
                "`requests`.`month`= ?, " +
                "`requests`.`date_send`= ? " +
                "WHERE `requests`.`account_id`=?";
    }
}
