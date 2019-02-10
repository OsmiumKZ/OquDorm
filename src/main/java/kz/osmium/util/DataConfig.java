package kz.osmium.util;

public class DataConfig {
    public static final String GLOBAL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String GLOBAL_TOKEN = "token";

    public static final String DB_DORM_DORM = "dorms";
    public static final String DB_DORM_DORM_ID = "id";
    public static final String DB_DORM_DORM_NAME_ID = "name_id";

    public static final String DB_DORM_FLOOR = "floors";
    public static final String DB_DORM_FLOOR_ID = "id";
    public static final String DB_DORM_FLOOR_NUMBER = "number";
    public static final String DB_DORM_FLOOR_DORM_ID = "dorm_id";

    public static final String DB_DORM_KITCHEN = "kitchens";
    public static final String DB_DORM_KITCHEN_ID = "id";
    public static final String DB_DORM_KITCHEN_NAME_ID = "name_id";
    public static final String DB_DORM_KITCHEN_PLATE_AMOUNT = "plate_amount";
    public static final String DB_DORM_KITCHEN_SINK_AMOUNT = "sink_amount";
    public static final String DB_DORM_KITCHEN_FLOOR_ID = "floor_id";

    public static final String DB_DORM_NAME = "names";
    public static final String DB_DORM_NAME_ID = "id";
    public static final String DB_DORM_NAME_RU = "name";
    public static final String DB_DORM_NAME_RU_GENITIVE = "name_genitive";
    public static final String DB_DORM_NAME_RU_DATIVE = "name_dative";

    public static final String DB_DORM_REPORT = "reports";
    public static final String DB_DORM_REPORT_ID = "id";
    public static final String DB_DORM_REPORT_ACCOUNT = "account";
    public static final String DB_DORM_REPORT_ACCOUNT_ID = "account_id";
    public static final String DB_DORM_REPORT_ADMIN = "admin";
    public static final String DB_DORM_REPORT_STATUS = "status";
    public static final String DB_DORM_REPORT_DATE_SEND = "date_send";
    public static final int DB_DORM_REPORT_STATUS_VALUE = 0;
    public static final int DB_DORM_REPORT_STATUS_CHECK_ONE = 1;
    public static final int DB_DORM_REPORT_STATUS_CHECK_TWO = 3;
    public static final int DB_DORM_REPORT_STATUS_CREATE_RESIDENT = 4;

    public static final String DB_DORM_REQUEST = "requests";
    public static final String DB_DORM_REQUEST_ID = "id";
    public static final String DB_DORM_REQUEST_ACCOUNT = "account";
    public static final String DB_DORM_REQUEST_ACCOUNT_ID = "account_id";
    public static final String DB_DORM_REQUEST_ROOM = "room";
    public static final String DB_DORM_REQUEST_ROOM_ID = "room_id";
    public static final String DB_DORM_REQUEST_STATUS = "status";
    public static final String DB_DORM_REQUEST_PERIOD = "period";
    public static final String DB_DORM_REQUEST_BOOKING_PERIOD = "booking_period";
    public static final String DB_DORM_REQUEST_EMAIL = "email";
    public static final String DB_DORM_REQUEST_DATE_SEND = "date_send";
    public static final int DB_DORM_REQUEST_STATUS_VALUE = 0;
    public static final int DB_DORM_REQUEST_STATUS_CREATE_REPORT = 2;

    public static final String DB_DORM_RESIDENT = "residents";
    public static final String DB_DORM_RESIDENT_ID = "id";
    public static final String DB_DORM_RESIDENT_CHECK_IN = "check_in";
    public static final String DB_DORM_RESIDENT_CHECK_OUT = "check_out";
    public static final String DB_DORM_RESIDENT_ROOM_ID = "room_id";
    public static final String DB_DORM_RESIDENT_ACCOUNT = "account";
    public static final String DB_DORM_RESIDENT_ACCOUNT_ID = "account_id";
    public static final String DB_DORM_RESIDENT_REPORT_ID = "report_id";
    public static final String DB_DORM_RESIDENT_DATE_CREATE = "date_create";

    public static final String DB_DORM_RESTROOM = "restrooms";
    public static final String DB_DORM_RESTROOM_ID = "id";
    public static final String DB_DORM_RESTROOM_NAME_ID = "name_id";
    public static final String DB_DORM_RESTROOM_TOILET_AMOUNT = "toilet_amount";
    public static final String DB_DORM_RESTROOM_SHOWER_AMOUNT = "shower_amount";
    public static final String DB_DORM_RESTROOM_SINK_AMOUNT = "sink_amount";
    public static final String DB_DORM_RESTROOM_FLOOR_ID = "floor_id";

    public static final String DB_DORM_ROOM = "rooms";
    public static final String DB_DORM_ROOM_ID = "id";
    public static final String DB_DORM_ROOM_NAME_ID = "name_id";
    public static final String DB_DORM_ROOM_MAX = "max";
    public static final String DB_DORM_ROOM_FLOOR_ID = "floor_id";
    public static final String DB_DORM_ROOM_NIGHTSTAND_AMOUNT = "nightstand_amount";
    public static final String DB_DORM_ROOM_CHIFFONIER_AMOUNT = "chiffonier_amount";
    public static final String DB_DORM_ROOM_SHELF_AMOUNT = "shelf_amount";
    public static final String DB_DORM_ROOM_WIFI = "wifi";

    public static final String DB_ACCOUNT = "account";
    public static final String DB_ACCOUNT_ID = "id";
    public static final String DB_ACCOUNT_NAME_F = "name_f";
    public static final String DB_ACCOUNT_NAME_L = "name_l";
    public static final String DB_ACCOUNT_PATRONYMIC = "patronymic";
    public static final String DB_ACCOUNT_GENDER = "gender";

    public static final String DB_ACCOUNT_SHORT_ID = "id";
    public static final String DB_ACCOUNT_SHORT_NAME_F = "name_f";
    public static final String DB_ACCOUNT_SHORT_NAME_L = "name_l";
    public static final String DB_ACCOUNT_SHORT_PATRONYMIC = "patronymic";
    public static final String DB_ACCOUNT_SHORT_GENDER = "gender";

    public static final String DB_ACCOUNT_AUTH_ID = "id";
    public static final String DB_ACCOUNT_AUTH_NAME_F = "name_f";
    public static final String DB_ACCOUNT_AUTH_NAME_L = "name_l";
    public static final String DB_ACCOUNT_AUTH_PATRONYMIC = "patronymic";
    public static final String DB_ACCOUNT_AUTH_GENDER = "gender";
    public static final String DB_ACCOUNT_AUTH_UIN = "uin";

    public static final String DB_ACCOUNT_NAME_RU = "name_ru";
    public static final String DB_ACCOUNT_NAME_KZ = "name_kz";
    public static final String DB_ACCOUNT_NAME_EN = "name_en";
}
