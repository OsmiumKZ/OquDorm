package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.Account;

public class Report {

    /* Индивидуальный номер */
    @SerializedName("id")
    private final int id;

    /* Объект аккаунта */
    @SerializedName("account")
    private final Account account;

    /* Ссылка на электронную подпись */
    @SerializedName("admin")
    private final String admin;

    /* Статуст выполнения */
    @SerializedName("status")
    private final int status;

    /* Дата обновления */
    @SerializedName("date_send")
    private final String dateSend;

    public Report(int id, Account account, String admin, int status, String dateSend) {
        this.id = id;
        this.account = account;
        this.admin = admin;
        this.status = status;
        this.dateSend = dateSend;
    }
}
