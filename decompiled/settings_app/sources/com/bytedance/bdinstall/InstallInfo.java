package com.bytedance.bdinstall;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InstallInfo implements Cloneable {
    private String clientUdid;
    private String did;
    private String iid;
    private String openUdid;
    private String ssid;

    public InstallInfo() {
        this.did = "";
        this.iid = "";
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m886clone() throws CloneNotSupportedException {
        return clone();
    }

    public String getIid() {
        return this.iid;
    }

    public String getOpenUdid() {
        return this.openUdid;
    }

    public String getClientUdid() {
        return this.clientUdid;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String r1) {
        this.did = r1;
    }

    public void setIid(String r1) {
        this.iid = r1;
    }

    public void setOpenUdid(String r1) {
        this.openUdid = r1;
    }

    public void setClientUdid(String r1) {
        this.clientUdid = r1;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String r1) {
        this.ssid = r1;
    }

    JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put("did", this.did);     // Catch: JSONException -> L5
        r0.put(WsConstants.KEY_INSTALL_ID, this.iid);     // Catch: JSONException -> L5
        r0.put(Api.KEY_OPEN_UDID, this.openUdid);     // Catch: JSONException -> L5
        r0.put("cliend_udid", this.clientUdid);     // Catch: JSONException -> L5
        r0.put("ssid", this.ssid);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    static InstallInfo parse(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r4);     // Catch: JSONException -> L7
        InstallInfo r5 = new InstallInfo();     // Catch: JSONException -> L7
        r5.setDid(r1.optString("did", ""));     // Catch: JSONException -> L7
        r5.setIid(r1.optString(WsConstants.KEY_INSTALL_ID, ""));     // Catch: JSONException -> L7
        r5.setOpenUdid(r1.optString(Api.KEY_OPEN_UDID, ""));     // Catch: JSONException -> L7
        r5.setClientUdid(r1.optString("cliend_udid", ""));     // Catch: JSONException -> L7
        r5.setSsid(r1.optString("ssid", ""));     // Catch: JSONException -> L7
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String toString() {
        return "{d='" + this.did + "', i='" + this.iid + "', o='" + this.openUdid + "', c='" + this.clientUdid + "', s='" + this.ssid + "'}";
    }

    public InstallInfo clone() {
        return (InstallInfo) super.clone();
    L4:
        e = move-exception;
        DrLog.e("clone error", e);
        return null;
    }
}
