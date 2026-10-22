package com.bytedance.apm.data.type;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class EventData implements ITypeData {
    public JSONObject category;
    public JSONObject extrJson;
    public boolean isUploadImmediately;
    public JSONObject metric;
    public String serviceName;
    public int status;
    public JSONObject value;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public EventData(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.serviceName = r1;
        this.status = r2;
        this.value = r3;
        this.category = r4;
        this.metric = r5;
        this.extrJson = r6;
    }

    public EventData(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6, boolean r7) {
        this.serviceName = r1;
        this.status = r2;
        this.value = r3;
        this.category = r4;
        this.metric = r5;
        this.extrJson = r6;
        this.isUploadImmediately = r7;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        if (this.extrJson != null) goto L18;
        this.extrJson = new JSONObject();
    L18:
        this.extrJson.put("log_type", "service_monitor");     // Catch: JSONException -> L16
        this.extrJson.put("service", this.serviceName);     // Catch: JSONException -> L16
        this.extrJson.put("status", this.status);     // Catch: JSONException -> L16
        JSONObject r0 = this.value;     // Catch: JSONException -> L16
        if (r0 == null) goto L8;
        this.extrJson.put("value", r0);     // Catch: JSONException -> L16
    L8:
        JSONObject r1 = this.category;     // Catch: JSONException -> L16
        if (r1 == null) goto L11;
        this.extrJson.put("category", r1);     // Catch: JSONException -> L16
    L11:
        JSONObject r2 = this.metric;     // Catch: JSONException -> L16
        if (r2 == null) goto L14;
        this.extrJson.put(CommonKey.KEY_METRIC, r2);     // Catch: JSONException -> L16
    L14:
        return this.extrJson;
    L16:
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r1) {
        return SamplerHelper.getServiceSwitch(this.serviceName);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return this.isUploadImmediately;
    }
}
