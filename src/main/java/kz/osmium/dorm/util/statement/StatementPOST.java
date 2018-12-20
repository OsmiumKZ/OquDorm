package kz.osmium.dorm.util.statement;

public class StatementPOST {

    public static String postRequests() {
        return "INSERT INTO `requests` " +
                "(`account_id`, `room_id`, `status`, `month`, `date_send`) " +
                "VALUE (?, ?, ?, ?, ?)";
    }
}
