package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.util.DataConfig;

public class Restroom {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_RESTROOM_ID)
    private final int id;

    /* Название по ID */
    @SerializedName(DataConfig.DB_DORM_RESTROOM_NAME_ID)
    private final int nameId;

    /* Количество уборных */
    @SerializedName(DataConfig.DB_DORM_RESTROOM_TOILET_AMOUNT)
    private final int toiletAmount;

    /* Количество душей */
    @SerializedName(DataConfig.DB_DORM_RESTROOM_SHOWER_AMOUNT)
    private final int showerAmount;

    /* Количество раковин */
    @SerializedName(DataConfig.DB_DORM_RESTROOM_SINK_AMOUNT)
    private final int sinkAmount;

    /* ID этажей */
    @SerializedName(DataConfig.DB_DORM_RESTROOM_FLOOR_ID)
    private final int floorId;

    public Restroom(int id, int nameId, int toiletAmount, int showerAmount, int sinkAmount, int floorId) {
        this.id = id;
        this.nameId = nameId;
        this.toiletAmount = toiletAmount;
        this.showerAmount = showerAmount;
        this.sinkAmount = sinkAmount;
        this.floorId = floorId;
    }
}
