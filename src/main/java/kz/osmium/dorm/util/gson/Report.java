package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.AccountShort;
import kz.osmium.util.DataConfig;

public class Report {

    /* Индивидуальный номер */
    @SerializedName(DataConfig.DB_DORM_REPORT_ID)
    private final int id;

    /* Объект аккаунта */
    @SerializedName(DataConfig.DB_DORM_REPORT_ACCOUNT)
    private final AccountShort account;

    /* Ссылка на электронную подпись */
    @SerializedName(DataConfig.DB_DORM_REPORT_ADMIN)
    private final String admin;

    /* Статуст выполнения */
    @SerializedName(DataConfig.DB_DORM_REPORT_STATUS)
    private final int status;

    /* Дата обновления */
    @SerializedName(DataConfig.DB_DORM_REPORT_DATE_SEND)
    private final String dateSend;

    public Report(int id, AccountShort account, String admin, int status, String dateSend) {
        this.id = id;
        this.account = account;
        this.admin = admin;
        this.status = status;
        this.dateSend = dateSend;
    }
}
