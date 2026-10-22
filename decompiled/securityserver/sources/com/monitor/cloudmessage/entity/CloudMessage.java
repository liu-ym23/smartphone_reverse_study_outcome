package com.monitor.cloudmessage.entity;

import a.a;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CloudMessage {
    private String mCommandId;
    private String mParams;
    private JSONObject mParamsJson;

    @Deprecated
    private long mSendTime;
    private String mType;
    private String messageString;

    public CloudMessage() {
    }

    public static CloudMessage fromString(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return null;
    L16:
        CloudMessage r0 = new CloudMessage();     // Catch: Exception -> L8
        JSONObject r2 = new JSONObject(r5);     // Catch: Exception -> L8
        r0.mCommandId = r2.optString("command_id");     // Catch: Exception -> L8
        r0.mType = r2.optString("type");     // Catch: Exception -> L8
        String r3 = r2.optString("params");     // Catch: Exception -> L8
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r4 = new JSONObject(r3);     // Catch: Exception -> L8
    L10:
        r0.mParams = r3;     // Catch: Exception -> L8
        r0.mParamsJson = r4;     // Catch: Exception -> L8
        r0.messageString = r5;     // Catch: Exception -> L8
        return r0;
    L8:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L15;
        Logger.printErrStackTrace("cloudmessage", e, new String[]{"Parse CloudMessage Error."});
    L15:
        return null;
    }

    public String getCommandId() {
        return this.mCommandId;
    }

    public String getMessageString() {
        return this.messageString;
    }

    public String getParams() {
        return this.mParams;
    }

    public JSONObject getParamsJson() {
        return this.mParamsJson;
    }

    @Deprecated
    public long getSendTime() {
        return this.mSendTime;
    }

    public String getType() {
        return this.mType;
    }

    public boolean isWifiOnly() {
        return this.mParamsJson.optBoolean("wifiOnly");
    }

    @Deprecated
    public void setSendTime(long r1) {
        this.mSendTime = r1;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CloudMessage{mParams='");
        r0.append(this.mParams);
        r0.append("', mType=");
        r0.append(this.mType);
        r0.append(", send_time=");
        r0.append(this.mSendTime);
        r0.append(", command_id='");
        return a.o(r0, this.mCommandId, "'}");
    }
}
