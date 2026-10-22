package com.bytedance.apm.q.j.m;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1811f;

    public d() {
    }

    @Nullable
    public JSONObject b() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("flags", this.f1810e);     // Catch: Throwable -> L4
        r0.put(LocationMonitorConst.TAG, this.f1811f);     // Catch: Throwable -> L4
        r0.put("start_time", this.f1805a);     // Catch: Throwable -> L4
        r0.put("end_time", this.f1806b);     // Catch: Throwable -> L4
        r0.put("thread_name", this.f1807c);     // Catch: Throwable -> L4
        r0.put("thread_stack", a());     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public String toString() {
        return "WakeLockInfo{flags=" + this.f1810e + ", tag=" + this.f1811f + ", startTime=" + this.f1805a + ", endTime=" + this.f1806b + ", threadName=" + this.f1807c + ", threadStack=" + a() + '}';
    }
}
