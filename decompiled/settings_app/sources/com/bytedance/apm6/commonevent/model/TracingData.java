package com.bytedance.apm6.commonevent.model;

import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TracingData implements Monitorable {
    private JSONArray array;

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "tracing";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public TracingData(JSONArray r1) {
        this.array = r1;
    }

    public TracingData(JSONObject r2) {
        JSONArray r0 = new JSONArray();
        r0.put(r2);
        this.array = r0;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public final JSONObject toJsonObject() {
        return BatchLogWrapUtils.wrapData(getLogType(), this.array);
    }
}
