package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Room {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Название по ID */
    @SerializedName("name_id")
    private final int nameId;

    /* Максимальное количество мест для студентов */
    @SerializedName("max")
    private final int max;

    /* ID этажа */
    @SerializedName("floor_id")
    private final int floorId;

    /* Количество тумбочек */
    @SerializedName("nightstand_amount")
    private final int nightstandAmount;

    /* Количество шифоньеров */
    @SerializedName("chiffonier_amount")
    private final int chiffonierAmount;

    /* Количество полок */
    @SerializedName("shelf_amount")
    private final int shelfAmount;

    /* Сигнал Wi-Fi */
    @SerializedName("wifi")
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
