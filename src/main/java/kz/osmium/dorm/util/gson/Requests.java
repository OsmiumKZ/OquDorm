package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.AccountShort;
import kz.osmium.util.DataConfig;

public class Requests {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_REQUEST_ID)
    private final int id;

    /* Объект аккаунта */
    @SerializedName(DataConfig.DB_DORM_REQUEST_ACCOUNT)
    private AccountShort account;

    /* ID комнаты */
    @SerializedName(DataConfig.DB_DORM_REQUEST_ROOM_ID)
    private final int roomId;

    /* Статуст выполнения */
    @SerializedName(DataConfig.DB_DORM_REQUEST_STATUS)
    private final int status;

    /* На сколько месяцев идет бронь комнаты */
    @SerializedName(DataConfig.DB_DORM_REQUEST_BOOKING_PERIOD)
    private final int bookingPeriod;

    /* Электронная почта студента, по которой можно уведомлять */
    @SerializedName(DataConfig.DB_DORM_REQUEST_EMAIL)
    private final String email;

    /* Дата обновления */
    @SerializedName(DataConfig.DB_DORM_REQUEST_DATE_SEND)
    private final String dateSend;

    public Requests(int id, AccountShort account, int roomId, int status, int bookingPeriod, String email, String dateSend) {
        this.id = id;
        this.account = account;
        this.roomId = roomId;
        this.status = status;
        this.bookingPeriod = bookingPeriod;
        this.email = email;
        this.dateSend = dateSend;
    }
}
