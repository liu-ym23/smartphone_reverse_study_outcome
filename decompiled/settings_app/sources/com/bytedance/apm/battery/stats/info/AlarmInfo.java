package com.bytedance.apm.battery.stats.info;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmInfo extends BaseHookInfo {
    public String intentInfo;
    public long interval;
    public int type;

    public AlarmInfo() {
    }

    public long getUTCTriggerAtMillis() {
        int r0 = this.type;
        if (r0 == 1) goto L9;
        if (r0 == 0) goto L9;
        return (this.startTime + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    L9:
        return this.startTime;
    }

    public boolean isWakeUpAlarm() {
        int r1 = this.type;
        if (r1 == 2) goto L7;
        if (r1 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "AlarmInfo{type=" + this.type + ", interval=" + this.interval + ", intentInfo=" + this.intentInfo + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadName=" + this.threadName + ", threadStack=" + getStackDetails() + '}';
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.startTime);     // Catch: Throwable -> L4
        r0.put("end_time", this.endTime);     // Catch: Throwable -> L4
        r0.put("thread_name", this.threadName);     // Catch: Throwable -> L4
        r0.put("thread_stack", getStackDetails());     // Catch: Throwable -> L4
        r0.put("interval", this.interval);     // Catch: Throwable -> L4
        r0.put("type", this.type);     // Catch: Throwable -> L4
        r0.put("intent_info", this.intentInfo);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }
}
