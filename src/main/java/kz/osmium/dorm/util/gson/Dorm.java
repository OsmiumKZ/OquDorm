package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Dorm {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Название по ID */
    @SerializedName("name_id")
    private final int nameId;

    public Dorm(int id, int nameId) {
        this.id = id;
        this.nameId = nameId;
    }
}
