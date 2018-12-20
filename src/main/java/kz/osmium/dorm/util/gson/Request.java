package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("id")
    private final int id;
    @SerializedName("account_id")
    private final int accountId;
    @SerializedName("room_id")
    private final int roomId;
    @SerializedName("status")
    private final int status;
    @SerializedName("month")
    private final int month;
    @SerializedName("date_send")
    private final String dateSend;

    public Request(int id, int accountId, int roomId, int status, int month, String dateSend) {
        this.id = id;
        this.accountId = accountId;
        this.roomId = roomId;
        this.status = status;
        this.month = month;
        this.dateSend = dateSend;
    }
}
