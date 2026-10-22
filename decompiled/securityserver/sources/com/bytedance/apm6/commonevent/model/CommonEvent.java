package com.bytedance.apm6.commonevent.model;

import a.a;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class CommonEvent implements Monitorable {
    public static final String LOG_TYPE = "service_monitor";
    private JSONObject category;
    private JSONObject extraJson;
    private JSONObject metric;
    private String serviceName;
    private int status;
    private JSONObject value;

    public CommonEvent(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.serviceName = r1;
        this.status = r2;
        this.value = r3;
        this.category = r4;
        this.metric = r5;
        this.extraJson = r6;
    }

    public void deepCopyJson() {
        this.value = JsonUtils.safeCopyJson(this.value);
        this.category = JsonUtils.safeCopyJson(this.category);
        this.metric = JsonUtils.safeCopyJson(this.metric);
        this.extraJson = JsonUtils.safeCopyJson(this.extraJson);
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getExtraJson() {
        return this.extraJson;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "service_monitor";
    }

    public JSONObject getMetric() {
        return this.metric;
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

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.serviceName);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r0 = getExtraJson();     // Catch: Exception -> L5
        if (r0 != null) goto L7;
        r0 = new JSONObject();     // Catch: Exception -> L5
    L7:
        r0.put("log_type", "service_monitor");     // Catch: Exception -> L5
        r0.put("service", getServiceName());     // Catch: Exception -> L5
        r0.put("status", getStatus());     // Catch: Exception -> L5
        if (getValue() == null) goto L11;
        r0.put("value", getValue());     // Catch: Exception -> L5
    L11:
        if (getCategory() == null) goto L14;
        r0.put(CommonKey.KEY_CATEGORY, getCategory());     // Catch: Exception -> L5
    L14:
        if (getMetric() == null) goto L16;
        r0.put(CommonKey.KEY_METRIC, getMetric());     // Catch: Exception -> L5
    L16:
        return r0;
    L5:
        e = move-exception;
        if (ApmBaseContext.isDebugMode() == false) goto L24;
        Logger.w(Constants.TAG, "toJsonObject Error.", e);
        return null;
    L24:
        return null;
    }

    public String toString() {
        return a.o(new StringBuilder("CommonEvent{serviceName='"), this.serviceName, "'}");
    }
}
