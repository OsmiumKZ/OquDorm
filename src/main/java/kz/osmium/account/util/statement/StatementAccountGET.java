package kz.osmium.account.util.statement;

public class StatementAccountGET {

    public static String getAuth() {
        return "SELECT `accounts`.`id`, `accounts`.`name_f_id`, `accounts`.`name_l_id`, `accounts`.`patronymic_id`, `accounts`.`gender_id`, `accounts`.`iin`, \n" +
                "`name_gender`.`name_ru` AS `name_ru_gender`, `name_gender`.`name_kz` AS `name_kz_gender`, `name_gender`.`name_en` AS `name_en_gender`, \n" +
                "`name_name_f`.`name_ru` AS `name_ru_name_f`, `name_name_f`.`name_kz` AS `name_kz_name_f`, `name_name_f`.`name_en` AS `name_en_name_f`, \n" +
                "`name_name_l`.`name_ru` AS `name_ru_name_l`, `name_name_l`.`name_kz` AS `name_kz_name_l`, `name_name_l`.`name_en` AS `name_en_name_l`, \n" +
                "`name_patronymic`.`name_ru` AS `name_ru_patronymic`, `name_patronymic`.`name_kz` AS `name_kz_patronymic`, `name_patronymic`.`name_en` AS `name_en_patronymic` \n" +
                "FROM `accounts` \n" +
                "INNER JOIN `name_f` ON `accounts`.`name_f_id` = `name_f`.`id` \n" +
                "INNER JOIN `name_l` ON `accounts`.`name_l_id` = `name_l`.`id` \n" +
                "INNER JOIN `patronymic` ON `accounts`.`patronymic_id` = `patronymic`.`id` \n" +
                "INNER JOIN `gender` ON `accounts`.`gender_id` = `gender`.`id` \n" +
                "INNER JOIN `name` AS `name_gender` ON `gender`.`name_id` = `name_gender`.`id` \n" +
                "INNER JOIN `name` AS `name_name_f` ON `name_f`.`name_id` = `name_name_f`.`id` \n" +
                "INNER JOIN `name` AS `name_name_l` ON `name_l`.`name_id` = `name_name_l`.`id` \n" +
                "INNER JOIN `name` AS `name_patronymic` ON `patronymic`.`name_id` = `name_patronymic`.`id` \n" +
                "WHERE `accounts`.iin=?";
    }

    public static String getAccount() {
        return "SELECT `accounts`.`id`, `accounts`.`name_f_id`, `accounts`.`name_l_id`, `accounts`.`patronymic_id`, `accounts`.`gender_id`, \n" +
                "`name_gender`.`name_ru` AS `name_ru_gender`, `name_gender`.`name_kz` AS `name_kz_gender`, `name_gender`.`name_en` AS `name_en_gender`, \n" +
                "`name_name_f`.`name_ru` AS `name_ru_name_f`, `name_name_f`.`name_kz` AS `name_kz_name_f`, `name_name_f`.`name_en` AS `name_en_name_f`, \n" +
                "`name_name_l`.`name_ru` AS `name_ru_name_l`, `name_name_l`.`name_kz` AS `name_kz_name_l`, `name_name_l`.`name_en` AS `name_en_name_l`, \n" +
                "`name_patronymic`.`name_ru` AS `name_ru_patronymic`, `name_patronymic`.`name_kz` AS `name_kz_patronymic`, `name_patronymic`.`name_en` AS `name_en_patronymic` \n" +
                "FROM `accounts` \n" +
                "INNER JOIN `name_f` ON `accounts`.`name_f_id` = `name_f`.`id` \n" +
                "INNER JOIN `name_l` ON `accounts`.`name_l_id` = `name_l`.`id` \n" +
                "INNER JOIN `patronymic` ON `accounts`.`patronymic_id` = `patronymic`.`id` \n" +
                "INNER JOIN `gender` ON `accounts`.`gender_id` = `gender`.`id` \n" +
                "INNER JOIN `name` AS `name_gender` ON `gender`.`name_id` = `name_gender`.`id` \n" +
                "INNER JOIN `name` AS `name_name_f` ON `name_f`.`name_id` = `name_name_f`.`id` \n" +
                "INNER JOIN `name` AS `name_name_l` ON `name_l`.`name_id` = `name_name_l`.`id` \n" +
                "INNER JOIN `name` AS `name_patronymic` ON `patronymic`.`name_id` = `name_patronymic`.`id` \n" +
                "WHERE `accounts`.id=?";
    }
}
