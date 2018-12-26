package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.util.DataConfig;

public class Room {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_ROOM_ID)
    private final int id;

    /* Название по ID */
    @SerializedName(DataConfig.DB_DORM_ROOM_NAME_ID)
    private final int nameId;

    /* Максимальное количество мест для студентов */
    @SerializedName(DataConfig.DB_DORM_ROOM_MAX)
    private final int max;

    /* ID этажа */
    @SerializedName(DataConfig.DB_DORM_ROOM_FLOOR_ID)
    private final int floorId;

    /* Количество тумбочек */
    @SerializedName(DataConfig.DB_DORM_ROOM_NIGHTSTAND_AMOUNT)
    private final int nightstandAmount;

    /* Количество шифоньеров */
    @SerializedName(DataConfig.DB_DORM_ROOM_CHIFFONIER_AMOUNT)
    private final int chiffonierAmount;

    /* Количество полок */
    @SerializedName(DataConfig.DB_DORM_ROOM_SHELF_AMOUNT)
    private final int shelfAmount;

    /* Сигнал Wi-Fi */
    @SerializedName(DataConfig.DB_DORM_ROOM_WIFI)
    private final int wifi;

    public Room(int id, int nameId, int max, int floorId, int nightstandAmount, int chiffonierAmount, int shelfAmount, int wifi) {
        this.id = id;
        this.nameId = nameId;
        this.max = max;
        this.floorId = floorId;
        this.nightstandAmount = nightstandAmount;
        this.chiffonierAmount = chiffonierAmount;
        this.shelfAmount = shelfAmount;
        this.wifi = wifi;
    }
}
