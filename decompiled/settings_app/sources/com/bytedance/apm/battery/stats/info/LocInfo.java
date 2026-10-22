package com.bytedance.apm.battery.stats.info;

import com.obric.capabilitykit.common.Ext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class LocInfo extends BaseHookInfo {
    public String request;

    public LocInfo() {
    }

    public String toString() {
        return "LocInfo{request=" + this.request + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadName=" + this.threadName + ", threadStack=" + getStackDetails() + '}';
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.startTime);     // Catch: Throwable -> L4
        r0.put("end_time", this.endTime);     // Catch: Throwable -> L4
        r0.put("thread_name", this.threadName);     // Catch: Throwable -> L4
        r0.put("thread_stack", getStackDetails());     // Catch: Throwable -> L4
        r0.put(Ext.KEY_REQUEST, this.request);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }
}
