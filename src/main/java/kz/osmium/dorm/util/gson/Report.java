package kz.osmium.dorm.util.gson;

import com.google.gson.annotations.SerializedName;

public class Report {
    @SerializedName("id")
    private final int id;
    @SerializedName("account_id")
    private final int accountId;
    @SerializedName("admin")
    private final String admin;
    @SerializedName("status")
    private final int status;

    public Report(int id, int accountId, String admin, int status) {
        this.id = id;
        this.accountId = accountId;
        this.admin = admin;
        this.status = status;
    }
}
