package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.Account;

public class Resident {
    @SerializedName("id")
    private final int id;
    @SerializedName("date_before")
    private final String dateBefore;
    @SerializedName("date_after")
    private final String dateAfter;
    @SerializedName("room_id")
    private final int roomId;
    @SerializedName("account")
    private final Account account;

    public Resident(int id, String dateBefore, String dateAfter, int roomId, Account account) {
        this.id = id;
        this.dateBefore = dateBefore;
        this.dateAfter = dateAfter;
        this.roomId = roomId;
        this.account = account;
    }
}
