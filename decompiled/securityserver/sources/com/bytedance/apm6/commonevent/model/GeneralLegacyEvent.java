package com.bytedance.apm6.commonevent.model;

import a.a;
import android.text.TextUtils;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class GeneralLegacyEvent implements Monitorable {
    private JSONObject logJson;
    private String logType;

    public GeneralLegacyEvent(String r1, JSONObject r2) {
        this.logType = r1;
        this.logJson = r2;
    }

    public JSONObject getLogJson() {
        return this.logJson;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return this.logType;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.logType);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r0 = getLogJson();     // Catch: Exception -> L5
        if (r0 != null) goto L7;
        r0 = new JSONObject();     // Catch: Exception -> L5
    L7:
        r0.put("log_type", getLogType());     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        if (ApmBaseContext.isDebugMode() == false) goto L16;
        Logger.w(Constants.TAG, "toJsonObject Error.", e);
        return null;
    L16:
        return null;
    }

    public String toString() {
        return a.o(new StringBuilder("Apm5LegacyEvent{logType='"), this.logType, "'}");
    }
}
