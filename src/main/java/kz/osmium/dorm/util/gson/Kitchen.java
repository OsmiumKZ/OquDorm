package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.util.DataConfig;

public class Kitchen {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_KITCHEN_ID)
    private final int id;

    /* Название по ID */
    @SerializedName(DataConfig.DB_DORM_KITCHEN_NAME_ID)
    private final int nameId;

    /* Количество плит */
    @SerializedName(DataConfig.DB_DORM_KITCHEN_PLATE_AMOUNT)
    private final int plateAmount;

    /* Количество раковин */
    @SerializedName(DataConfig.DB_DORM_KITCHEN_SINK_AMOUNT)
    private final int sinkAmount;

    /* ID этажа */
    @SerializedName(DataConfig.DB_DORM_KITCHEN_FLOOR_ID)
    private final int floorId;

    public Kitchen(int id, int nameId, int plateAmount, int sinkAmount, int floorId) {
        this.id = id;
        this.nameId = nameId;
        this.plateAmount = plateAmount;
        this.sinkAmount = sinkAmount;
        this.floorId = floorId;
    }
}
