package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Restroom {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Название по ID */
    @SerializedName("name_id")
    private final int nameId;

    /* Количество уборных */
    @SerializedName("restroom")
    private final int restroom;

    /* Количество душей */
    @SerializedName("shower")
    private final int shower;

    /* Количество раковин */
    @SerializedName("sink")
    private final int sink;

    /* ID этажей */
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
