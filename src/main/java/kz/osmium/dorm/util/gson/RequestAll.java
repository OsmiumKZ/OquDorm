package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.Account;

public class RequestAll {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Объект аккаунта */
    @SerializedName("account")
    private Account account;

    /* ID комнаты */
    @SerializedName("room_id")
    private final int roomId;

    /* Статуст выполнения */
    @SerializedName("status")
    private final int status;

    /* На сколько месяцев идет бронь комнаты */
    @SerializedName("booking_period")
    private final int bookingPeriod;

    /* Электронная почта студента, по которой можно уведомлять */
    @SerializedName("email")
    private final String email;

    /* Дата обновления */
    @SerializedName("date_send")
    private final String dateSend;

    public RequestAll(int id, Account account, int roomId, int status, int bookingPeriod, String email, String dateSend) {
        this.id = id;
        this.account = account;
        this.roomId = roomId;
        this.status = status;
        this.bookingPeriod = bookingPeriod;
        this.email = email;
        this.dateSend = dateSend;
    }
}
