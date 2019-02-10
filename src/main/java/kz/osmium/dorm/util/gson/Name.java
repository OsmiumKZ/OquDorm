package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.util.DataConfig;

public class Name {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_NAME_ID)
    private final int id;

    /* Название на расском в именительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_RU)
    private final String nameRu;

    /* Название на расском в радительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_RU_GENITIVE)
    private final String nameRuGenitive;

    /* Название на расском в дательном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_RU_DATIVE)
    private final String nameRuDative;

    public Name(int id, String nameRu, String nameRuGenitive, String nameRuDative) {
        this.id = id;
        this.nameRu = nameRu;
        this.nameRuGenitive = nameRuGenitive;
        this.nameRuDative = nameRuDative;
    }
}
