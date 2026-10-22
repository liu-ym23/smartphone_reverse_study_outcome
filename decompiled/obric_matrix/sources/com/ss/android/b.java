package com.ss.android;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends d.b.s.a.a0.d.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11860b;

    public b(String r2) {
        o.g(r2, LocationMonitorConst.TAG);
        this.f11860b = r2;
    }

    @Override // d.b.s.a.a0.d.a
    public String e() {
        return this.f11860b;
    }

    @Override // d.b.s.a.a0.d.a
    public void h(String r6, int r7, String r8, d.b.s.a.a0.d.c r9, u<String, ? extends Object>[] r10) {
        o.g(r6, "recordName");
        o.g(r10, "params");
        JSONObject r0 = new JSONObject();
        int r1 = r10.length;     // Catch: JSONException -> L19
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L6;
        u<String, ? extends Object> r3 = r10[r2];     // Catch: JSONException -> L19
        r0.put(r3.a(), r3.b());     // Catch: JSONException -> L19
        r2 = r2 + 1;     // Catch: JSONException -> L19
        goto L4
    L6:
        r0.put("event_level", r7);     // Catch: JSONException -> L19
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r0.put("checkpoint_name", r8);     // Catch: JSONException -> L19
        long r4 = 0;
        if (r9 == null) goto L13;
        long r5 = r9.a();     // Catch: JSONException -> L19
    L14:
        r0.put("time_since_last_checkpoint_ms", r5);     // Catch: JSONException -> L19
        if (r9 == null) goto L17;
        r4 = r9.b();     // Catch: JSONException -> L19
    L17:
        r0.put("time_since_last_checkpoint_ns", r4);     // Catch: JSONException -> L19
        com.bytedance.sdk.account.monitor.c.k("Profiler_" + e() + '_' + r6, r0);     // Catch: JSONException -> L19
        return;
    L13:
        r5 = 0;
    L19:
        e = move-exception;
        d.b.s.a.a0.a.c("AccountProfiler", "Error assembling report params", e);
    }
}
