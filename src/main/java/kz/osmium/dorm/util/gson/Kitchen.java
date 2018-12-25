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
    @SerializedName("plate_amount")
    private final int plateAmount;

    /* Количество раковин */
    @SerializedName("sink_amount")
    private final int sinkAmount;

    /* ID этажа */
    @SerializedName("floor_id")
    private final int floorId;

    public Kitchen(int id, int nameId, int plateAmount, int sinkAmount, int floorId) {
        this.id = id;
        this.nameId = nameId;
        this.plateAmount = plateAmount;
        this.sinkAmount = sinkAmount;
        this.floorId = floorId;
    }
}
