package com.bytedance.apm.q.j.m;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1809e;

    public c() {
    }

    @Nullable
    public JSONObject b() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.f1805a);     // Catch: Throwable -> L4
        r0.put("end_time", this.f1806b);     // Catch: Throwable -> L4
        r0.put("thread_name", this.f1807c);     // Catch: Throwable -> L4
        r0.put("thread_stack", a());     // Catch: Throwable -> L4
        r0.put("request", this.f1809e);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public String toString() {
        return "LocInfo{request=" + this.f1809e + ", startTime=" + this.f1805a + ", endTime=" + this.f1806b + ", threadName=" + this.f1807c + ", threadStack=" + a() + '}';
    }
}
