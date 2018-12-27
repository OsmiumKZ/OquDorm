package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.AccountShort;
import kz.osmium.util.DataConfig;

public class Resident {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_RESIDENT_ID)
    private final int id;

    /* Когда студент был заселен */
    @SerializedName(DataConfig.DB_DORM_RESIDENT_CHECK_IN)
    private final String checkIn;

    /* Когда время проживания в общежития кончится */
    @SerializedName(DataConfig.DB_DORM_RESIDENT_CHECK_OUT)
    private final String checkOut;

    /* ID комнаты */
    @SerializedName(DataConfig.DB_DORM_RESIDENT_ROOM_ID)
    private final int roomId;

    /* Объект аккаунта */
    @SerializedName(DataConfig.DB_DORM_RESIDENT_ACCOUNT)
    private final AccountShort account;

    /* ID отчета */
    @SerializedName(DataConfig.DB_DORM_RESIDENT_REPORT_ID)
    private final int reportId;

    /* Дата создания */
    @SerializedName(DataConfig.DB_DORM_RESIDENT_DATE_CREATE)
    private final String dateCreate;

    public Resident(int id, String checkIn, String checkOut, int roomId, AccountShort account, int reportId, String dateCreate) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomId = roomId;
        this.account = account;
        this.reportId = reportId;
        this.dateCreate = dateCreate;
    }
}
