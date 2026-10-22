package com.bytedance.apm6.commonevent.model;

import android.text.TextUtils;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
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

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return this.logType;
    }

    public JSONObject getLogJson() {
        return this.logJson;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.logType);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r0 = getLogJson();     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        r0 = new JSONObject();     // Catch: Exception -> L7
    L5:
        r0.put("log_type", getLogType());     // Catch: Exception -> L7
        return r0;
    L7:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L15;
        Logger.w(Constants.TAG, "toJsonObject Error.", e);
        return null;
    L15:
        return null;
    }

    public String toString() {
        return "Apm5LegacyEvent{logType='" + this.logType + "'}";
    }
}
