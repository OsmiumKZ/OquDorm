package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Room {
    @SerializedName("id")
    private final int id;
    @SerializedName("name_id")
    private final int nameId;
    @SerializedName("max")
    private final int max;
    @SerializedName("floor_id")
    private final int floorId;
    @SerializedName("nightstand")
    private final int nightstand;
    @SerializedName("chiffonier")
    private final int chiffonier;
    @SerializedName("shelf")
    private final int shelf;
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
