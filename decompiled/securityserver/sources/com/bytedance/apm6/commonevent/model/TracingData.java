package com.bytedance.apm6.commonevent.model;

import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TracingData implements Monitorable {
    private JSONArray array;

    public TracingData(JSONArray r1) {
        this.array = r1;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "tracing";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public final JSONObject toJsonObject() {
        return BatchLogWrapUtils.wrapData(getLogType(), this.array);
    }

    public TracingData(JSONObject r2) {
        JSONArray r0 = new JSONArray();
        r0.put(r2);
        this.array = r0;
    }
}
