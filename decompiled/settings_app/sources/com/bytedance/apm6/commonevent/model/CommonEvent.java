package com.bytedance.apm6.commonevent.model;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonEvent implements Monitorable {
    public static final String LOG_TYPE = "service_monitor";
    private JSONObject category;
    private JSONObject extraJson;
    private JSONObject metric;
    private String serviceName;
    private int status;
    private JSONObject value;

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "service_monitor";
    }

    public CommonEvent(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.serviceName = r1;
        this.status = r2;
        this.value = r3;
        this.category = r4;
        this.metric = r5;
        this.extraJson = r6;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getStatus() {
        return this.status;
    }

    public JSONObject getValue() {
        return this.value;
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getMetric() {
        return this.metric;
    }

    public JSONObject getExtraJson() {
        return this.extraJson;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.serviceName);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r0 = getExtraJson();     // Catch: Exception -> L15
        if (r0 != null) goto L5;
        r0 = new JSONObject();     // Catch: Exception -> L15
    L5:
        r0.put("log_type", "service_monitor");     // Catch: Exception -> L15
        r0.put("service", getServiceName());     // Catch: Exception -> L15
        r0.put("status", getStatus());     // Catch: Exception -> L15
        if (getValue() == null) goto L9;
        r0.put("value", getValue());     // Catch: Exception -> L15
    L9:
        if (getCategory() == null) goto L12;
        r0.put("category", getCategory());     // Catch: Exception -> L15
    L12:
        if (getMetric() == null) goto L14;
        r0.put(CommonKey.KEY_METRIC, getMetric());     // Catch: Exception -> L15
    L14:
        return r0;
    L15:
        e = move-exception;
        if (ApmContext.isDebugMode() == false) goto L23;
        Logger.w(Constants.TAG, "toJsonObject Error.", e);
        return null;
    L23:
        return null;
    }

    public void deepCopyJson() {
        this.value = JsonUtils.safeCopyJson(this.value);
        this.category = JsonUtils.safeCopyJson(this.category);
        this.metric = JsonUtils.safeCopyJson(this.metric);
        this.extraJson = JsonUtils.safeCopyJson(this.extraJson);
    }

    public String toString() {
        return "CommonEvent{serviceName='" + this.serviceName + "'}";
    }
}
