package com.bytedance.apm6.hub.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements d.b.b.h.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.h.c.a f2163a;

    class a implements com.bytedance.apm6.hub.b.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f2164a;

        a(d r1) {
            this.f2164a = r1;
        }

        @Override // com.bytedance.apm6.hub.b.i.b
        public void a(JSONObject r1, boolean r2) {
            d.a(this.f2164a, r1, r2);
        }
    }

    public d() {
        if (d.b.b.o.a.c() == false) goto L5;
        d.b.b.o.m.b.a("APM-FD", "FdConfigManager:");
    L5:
        com.bytedance.apm6.hub.b.i.a.g().h();
        com.bytedance.apm6.hub.b.i.a.g().k(new a(this));
    }

    static /* synthetic */ void a(d r0, JSONObject r1, boolean r2) {
        r0.b(r1, r2);
    }

    private void b(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("performance_modules");
        if (d.b.b.o.a.c() == false) goto L5;
        d.b.b.o.m.b.a("APM-FD", "parseConfig:" + r13);
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        JSONObject r14 = r13.optJSONObject("fd");
        if (r14 != null) goto L11;
        return;
    L11:
        if (d.b.b.o.a.c() == false) goto L14;
        d.b.b.o.m.b.a("APM-FD", "parseConfig:" + r14);
    L14:
        if (r14.optInt("enable_upload", 0) != 1) goto L16;
        boolean r9 = true;
    L17:
        long r5 = r14.optInt("fd_count_threshold", 800);
        long r15 = r14.optLong("collect_interval", 10) * 60000;
        if (r15 >= 10) goto L20;
        r15 = 600000;
    L20:
        d.b.b.h.c.a r16 = new d.b.b.h.c.a(r5, r15, r9);
        if (d.b.b.o.a.c() == false) goto L23;
        d.b.b.o.m.b.a("APM-FD", "parseConfig:" + r16);
    L23:
        this.f2163a = r16;
        d.b.b.h.a.i().l(r16);
        return;
    L16:
        r9 = false;
        goto L17
    }

    @Override // d.b.b.h.c.b
    public d.b.b.h.c.a getConfig() {
        return this.f2163a;
    }
}
