package com.bytedance.framwork.core.sdkmonitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ServiceMonitorData {
    public JSONObject category;
    JSONObject extrJson;
    public JSONObject metric;
    String serviceName;
    int status;
    long timestamp;
    JSONObject value;

    public ServiceMonitorData(String r1, int r2, JSONObject r3, JSONObject r4, JSONObject r5, JSONObject r6, long r7) {
        this.serviceName = r1;
        this.status = r2;
        this.value = r3;
        this.category = r4;
        this.metric = r5;
        this.extrJson = r6;
        this.timestamp = r7;
    }
}
