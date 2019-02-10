package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.util.DataConfig;

public class Name {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_NAME_ID)
    private final int id;

    /* Название на расском в именительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_ONE)
    private final String name;

    /* Название на расском в радительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_GENITIVE)
    private final String nameGenitive;

    /* Название на расском в дательном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_DATIVE)
    private final String nameDative;

    public Name(int id, String name, String nameGenitive, String nameDative) {
        this.id = id;
        this.name = name;
        this.nameGenitive = nameGenitive;
        this.nameDative = nameDative;
    }
}
