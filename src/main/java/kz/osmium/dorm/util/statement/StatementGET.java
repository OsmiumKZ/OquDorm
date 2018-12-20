package kz.osmium.dorm.util.statement;

public class StatementGET {

    public static String getDormAll(){
        return "SELECT " +
                "`name`.`id` AS \"id_name\", `name`.`name_ru`, `name`.`name_ru_genetive`, `name`.`name_ru_dative`, `name`.`name_kz`, `name`.`name_kz_genetive`, `name`.`name_kz_dative`, `name`.`name_en`, `name`.`name_en_genetive`, `name`.`name_en_dative`, " +
                "`dorms`.`id` AS \"id_dorms\", `dorms`.`name_id` AS \"name_id_dorms\"," +
                "`floors`.`id` AS \"id_floors\", `floors`.`number`, `floors`.`dorm_id`," +
                "`rooms`.`id` AS \"id_rooms\", `rooms`.`name_id` AS \"name_id_rooms\", `rooms`.`max`, `rooms`.`floor_id` AS \"floor_id_rooms\", `rooms`.`nightstand`, `rooms`.`chiffonier`, `rooms`.`shelf`, `rooms`.`wifi`," +
                "`restrooms`.`id` AS \"id_restrooms\", `restrooms`.`name_id` AS \"name_id_restrooms\", `restrooms`.`restroom`, `restrooms`.`shower`,`restrooms`.`sink` AS \"sink_restrooms\",`restrooms`.`floor_id` AS \"floor_id_restrooms\"," +
                "`kitchens`.`id` AS \"id_kitchens\", `kitchens`.`name_id` AS \"name_id_kitchens\", `kitchens`.`plate`, `kitchens`.`sink` AS \"sink_kitchens\", `kitchens`.`floor_id` AS \"floor_id_kitchens\"" +
                "FROM `name`, `dorms`, `floors`, `rooms`, `restrooms`, `kitchens`";
    }
}
