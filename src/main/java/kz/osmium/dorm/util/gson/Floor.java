package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Floor {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Номер этажа */
    @SerializedName("number")
    private final int number;

    /* ID общежития */
    @SerializedName("dorm_id")
    private final int dorm_id;

    public Floor(int id, int number, int dorm_id) {
        this.id = id;
        this.number = number;
        this.dorm_id = dorm_id;
    }
}
