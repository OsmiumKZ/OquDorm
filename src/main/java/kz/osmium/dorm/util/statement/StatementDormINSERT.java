package kz.osmium.dorm.util.statement;

public class StatementDormINSERT {

    public static String insertRequests() {
        return "INSERT INTO `requests` " +
                "(`account_id`, `room_id`, `status`, `month`, `email`, `date_send`) " +
                "VALUE (?, ?, ?, ?, ?, ?)";
    }

    public static String insertReports() {
        return "INSERT INTO `reports` " +
                "(`account_id`, `status`) " +
                "VALUE (?, ?)";
    }
}
