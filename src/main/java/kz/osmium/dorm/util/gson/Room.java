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
    @SerializedName("nightstand")
    private final int nightstand;

    /* Количество шифоньеров */
    @SerializedName("chiffonier")
    private final int chiffonier;

    /* Количество полок */
    @SerializedName("shelf")
    private final int shelf;

    /* Сигнал Wi-Fi */
    @SerializedName("wifi")
    private final int wifi;

    public Room(int id, int nameId, int max, int floorId, int nightstand, int chiffonier, int shelf, int wifi) {
        this.id = id;
        this.nameId = nameId;
        this.max = max;
        this.floorId = floorId;
        this.nightstand = nightstand;
        this.chiffonier = chiffonier;
        this.shelf = shelf;
        this.wifi = wifi;
    }
}
