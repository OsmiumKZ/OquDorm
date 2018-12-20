package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Restroom {
    @SerializedName("id")
    private final int id;
    @SerializedName("name_id")
    private final int nameId;
    @SerializedName("restroom")
    private final int restroom;
    @SerializedName("shower")
    private final int shower;
    @SerializedName("sink")
    private final int sink;
    @SerializedName("floor_id")
    private final int floorId;

    public Restroom(int id, int nameId, int restroom, int shower, int sink, int floorId) {
        this.id = id;
        this.nameId = nameId;
        this.restroom = restroom;
        this.shower = shower;
        this.sink = sink;
        this.floorId = floorId;
    }
}
