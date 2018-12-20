package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Resident {
    @SerializedName("id")
    private final int id;
    @SerializedName("date_before")
    private final String dateBefore;
    @SerializedName("date_after")
    private final String dateAfter;
    @SerializedName("room_id")
    private final int roomId;
    @SerializedName("account_id")
    private final int accountId;

    public Resident(int id, String dateBefore, String dateAfter, int roomId, int accountId) {
        this.id = id;
        this.dateBefore = dateBefore;
        this.dateAfter = dateAfter;
        this.roomId = roomId;
        this.accountId = accountId;
    }
}
