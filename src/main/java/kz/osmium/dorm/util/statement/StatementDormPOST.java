package kz.osmium.dorm.util.statement;

public class StatementDormPOST {

    public static String postRequests() {
        return "INSERT INTO `requests` " +
                "(`account_id`, `room_id`, `status`, `month`, `email`, `date_send`) " +
                "VALUE (?, ?, ?, ?, ?, ?)";
    }
}
