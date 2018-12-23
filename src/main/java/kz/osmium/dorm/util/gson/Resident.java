package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.Account;

public class Resident {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Когда студент был заселен */
    @SerializedName("date_before")
    private final String dateBefore;

    /* Когда время проживания в общежития кончится */
    @SerializedName("date_after")
    private final String dateAfter;

    /* ID комнаты */
    @SerializedName("room_id")
    private final int roomId;

    /* Объект аккаунта */
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
