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
    private final String nameRuGenetive;

    /* Название на расском в дательном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_RU_DATIVE)
    private final String nameRuDative;

    /* Название на казахском в именительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_KZ)
    private final String nameKz;

    /* Название на казахском в радительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_KZ_GENITIVE)
    private final String nameKzGenetive;

    /* Название на казахском в дательном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_KZ_DATIVE)
    private final String nameKzDative;

    /* Название на английском в именительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_EN)
    private final String nameEn;

    /* Название на английском в радительном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_EN_GENITIVE)
    private final String nameEnGenetive;

    /* Название на английском в дательном падиже */
    @SerializedName(DataConfig.DB_DORM_NAME_EN_DATIVE)
    private final String nameEnDative;

    public Name(int id, String nameRu, String nameRuGenetive, String nameRuDative, String nameKz, String nameKzGenetive, String nameKzDative, String nameEn, String nameEnGenetive, String nameEnDative) {
        this.id = id;
        this.nameRu = nameRu;
        this.nameRuGenetive = nameRuGenetive;
        this.nameRuDative = nameRuDative;
        this.nameKz = nameKz;
        this.nameKzGenetive = nameKzGenetive;
        this.nameKzDative = nameKzDative;
        this.nameEn = nameEn;
        this.nameEnGenetive = nameEnGenetive;
        this.nameEnDative = nameEnDative;
    }
}
