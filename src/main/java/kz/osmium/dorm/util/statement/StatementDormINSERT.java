package kz.osmium.dorm.util.statement;

public class StatementDormINSERT {

    /* Создание заявки */
    public static String insertRequests() {
        return "INSERT INTO `requests` " +
                "(`account_id`, `room_id`, `status`, `booking_period`, `email`, `date_send`) " +
                "VALUE (?, ?, ?, ?, ?, ?)";
    }

    /* Создание отчета */
    public static String insertReports() {
        return "INSERT INTO `reports` " +
                "(`account_id`, `status`, `date_send`) " +
                "VALUE (?, ?, ?)";
    }

    /* Создание заселенного */
    public static String insertResident() {
        return "INSERT INTO `residents` " +
                "(`check_in`, `check_out`, `room_id`, `account_id`, `report_id`) " +
                "VALUE (?, ?, ?, ?, ?)";
    }
}
