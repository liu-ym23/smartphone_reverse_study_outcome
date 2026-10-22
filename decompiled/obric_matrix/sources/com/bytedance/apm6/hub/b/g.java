package com.bytedance.apm6.hub.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g implements d.b.b.k.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.k.f.a f2169a;

    class a implements com.bytedance.apm6.hub.b.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f2170a;

        a(g r1) {
            this.f2170a = r1;
        }

        @Override // com.bytedance.apm6.hub.b.i.b
        public void a(JSONObject r1, boolean r2) {
            g.a(this.f2170a, r1, r2);
        }
    }

    public g() {
        com.bytedance.apm6.hub.b.i.a.g().h();
        com.bytedance.apm6.hub.b.i.a.g().k(new a(this));
    }

    static /* synthetic */ void a(g r0, JSONObject r1, boolean r2) {
        r0.b(r1, r2);
    }

    private void b(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("performance_modules");
        if (r13 != null) goto L5;
        return;
    L5:
        JSONObject r14 = r13.optJSONObject("memory");
        if (r14 != null) goto L8;
        return;
    L8:
        long r1 = r14.optLong("collect_interval", 120);
        double r3 = r14.optDouble("reach_top_memory_rate", 0.8d);
        boolean r8 = true;
        if (r14.optInt("enable_upload", 0) != 1) goto L11;
        boolean r9 = true;
    L13:
        if (r14.optInt("close_memory_collect") != 1) goto L16;
        r8 = false;
    L16:
        this.f2169a = new d.b.b.k.f.a(r1, r3, false, false, r9, r8);
        if (d.b.b.o.a.c() == false) goto L19;
        d.b.b.o.m.b.a("APM-Config", "parsed MemoryConfig=" + this.f2169a);
    L19:
        d.b.b.k.b.h().q(getConfig());
        return;
    L11:
        r9 = false;
        goto L13
    }

    @Override // d.b.b.k.f.b
    public d.b.b.k.f.a getConfig() {
        return this.f2169a;
    }
}
