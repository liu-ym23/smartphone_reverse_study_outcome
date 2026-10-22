package com.bytedance.privacy.pcc;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.matrix.push.common.CommonConstants;

/* JADX INFO: loaded from: classes.dex */
public class AppInfo {

    @SerializedName(CommonConstants.APP_ID)
    public final String appId;

    @SerializedName("app_svc_id")
    public final String appSvcId;
    public final String rpdid;
    public final String rpuid;

    public AppInfo(String r1, String r2, String r3, String r4) {
        this.rpdid = r1;
        this.rpuid = r2;
        this.appId = r3;
        this.appSvcId = r4;
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }

    public String toString() {
        return toJsonString();
    }
}
