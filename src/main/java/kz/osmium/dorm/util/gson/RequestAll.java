package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.Account;

public class RequestAll {
    @SerializedName("id")
    private final int id;
    @SerializedName("account")
    private Account account;
    @SerializedName("room_id")
    private final int roomId;
    @SerializedName("status")
    private final int status;
    @SerializedName("month")
    private final int month;
    @SerializedName("email")
    private final String email;
    @SerializedName("date_send")
    private final String dateSend;

    public RequestAll(int id, Account account, int roomId, int status, int month, String email, String dateSend) {
        this.id = id;
        this.account = account;
        this.roomId = roomId;
        this.status = status;
        this.month = month;
        this.email = email;
        this.dateSend = dateSend;
    }
}
