package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Name {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Название на расском в именительном падиже */
    @SerializedName("name_ru")
    private final String nameRu;

    /* Название на расском в радительном падиже */
    @SerializedName("name_ru_genetive")
    private final String nameRuGenetive;

    /* Название на расском в дательном падиже */
    @SerializedName("name_ru_dative")
    private final String nameRuDative;

    /* Название на казахском в именительном падиже */
    @SerializedName("name_kz")
    private final String nameKz;

    /* Название на казахском в радительном падиже */
    @SerializedName("name_kz_genetive")
    private final String nameKzGenetive;

    /* Название на казахском в дательном падиже */
    @SerializedName("name_kz_dative")
    private final String nameKzDative;

    /* Название на английском в именительном падиже */
    @SerializedName("name_en")
    private final String nameEn;

    /* Название на английском в радительном падиже */
    @SerializedName("name_en_genetive")
    private final String nameEnGenetive;

    /* Название на английском в дательном падиже */
    @SerializedName("name_en_dative")
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
