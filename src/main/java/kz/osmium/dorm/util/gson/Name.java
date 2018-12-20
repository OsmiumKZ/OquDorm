package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Name {
    @SerializedName("id")
    private final int id;
    @SerializedName("name_ru")
    private final String nameRu;
    @SerializedName("name_ru_genetive")
    private final String nameRuGenetive;
    @SerializedName("name_ru_dative")
    private final String nameRuDative;
    @SerializedName("name_kz")
    private final String nameKz;
    @SerializedName("name_kz_genetive")
    private final String nameKzGenetive;
    @SerializedName("name_kz_dative")
    private final String nameKzDative;
    @SerializedName("name_en")
    private final String nameEn;
    @SerializedName("name_en_genetive")
    private final String nameEnGenetive;
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
