package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Kitchen {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Название по ID */
    @SerializedName("name_id")
    private final int nameId;

    /* Количество плит */
    @SerializedName("plate")
    private final int plate;

    /* Количество раковин */
    @SerializedName("sink")
    private final int sink;

    /* ID этажа */
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
