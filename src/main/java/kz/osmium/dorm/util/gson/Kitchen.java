package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Kitchen {
    @SerializedName("id")
    private final int id;
    @SerializedName("name_id")
    private final int nameId;
    @SerializedName("plate")
    private final int plate;
    @SerializedName("sink")
    private final int sink;
    @SerializedName("floor_id")
    private final int floorId;

    public Kitchen(int id, int nameId, int plate, int sink, int floorId) {
        this.id = id;
        this.nameId = nameId;
        this.plate = plate;
        this.sink = sink;
        this.floorId = floorId;
    }
}
