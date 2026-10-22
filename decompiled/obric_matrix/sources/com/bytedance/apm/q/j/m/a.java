package com.bytedance.apm.q.j.m;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1804g;

    public a() {
    }

    public long b() {
        int r0 = this.f1802e;
        if (r0 == 1) goto L9;
        if (r0 == 0) goto L9;
        return (this.f1805a + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    L9:
        return this.f1805a;
    }

    public boolean c() {
        int r1 = this.f1802e;
        if (r1 == 2) goto L7;
        if (r1 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Nullable
    public JSONObject d() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("start_time", this.f1805a);     // Catch: Throwable -> L4
        r0.put("end_time", this.f1806b);     // Catch: Throwable -> L4
        r0.put("thread_name", this.f1807c);     // Catch: Throwable -> L4
        r0.put("thread_stack", a());     // Catch: Throwable -> L4
        r0.put("interval", this.f1803f);     // Catch: Throwable -> L4
        r0.put(WsConstants.KEY_CONNECTION_TYPE, this.f1802e);     // Catch: Throwable -> L4
        r0.put("intent_info", this.f1804g);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    public String toString() {
        return "AlarmInfo{type=" + this.f1802e + ", interval=" + this.f1803f + ", intentInfo=" + this.f1804g + ", startTime=" + this.f1805a + ", endTime=" + this.f1806b + ", threadName=" + this.f1807c + ", threadStack=" + a() + '}';
    }
}
