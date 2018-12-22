package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;
import kz.osmium.account.util.gson.Account;

public class Report {
    @SerializedName("id")
    private final int id;
    @SerializedName("account")
    private final Account account;
    @SerializedName("admin")
    private final String admin;
    @SerializedName("status")
    private final int status;

    public Report(int id, Account account, String admin, int status) {
        this.id = id;
        this.account = account;
        this.admin = admin;
        this.status = status;
    }
}
