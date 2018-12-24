package kz.osmium.dorm.util.statement;

public class StatementDormINSERT {

    /* Создание заявки */
    public static String insertRequests() {
        return "INSERT INTO `requests` " +
                "(`account_id`, `room_id`, `status`, `month`, `email`, `date_send`) " +
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
                "(`date_before`, `date_after`, `room_id`, `account_id`, `report_id`) " +
                "VALUE (?, ?, ?, ?, ?)";
    }
}
