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
    @SerializedName("toilet_amount")
    private final int toiletAmount;

    /* Количество душей */
    @SerializedName("shower_amount")
    private final int showerAmount;

    /* Количество раковин */
    @SerializedName("sink_amount")
    private final int sinkAmount;

    /* ID этажей */
    @SerializedName("floor_id")
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
