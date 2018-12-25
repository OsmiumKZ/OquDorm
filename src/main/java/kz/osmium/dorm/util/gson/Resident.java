package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.Account;

public class Resident {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Когда студент был заселен */
    @SerializedName("check_in")
    private final String checkIn;

    /* Когда время проживания в общежития кончится */
    @SerializedName("check_out")
    private final String checkOut;

    /* ID комнаты */
    @SerializedName("room_id")
    private final int roomId;

    /* Объект аккаунта */
    @SerializedName("account")
    private final Account account;

    public Resident(int id, String checkIn, String checkOut, int roomId, Account account) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomId = roomId;
        this.account = account;
    }
}
