package com.bytedance.apm6.hub.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements d.b.b.j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.b.b.j.b f2167a;

    class a implements com.bytedance.apm6.hub.b.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f2168a;

        a(f r1) {
            this.f2168a = r1;
        }

        @Override // com.bytedance.apm6.hub.b.i.b
        public void a(JSONObject r1, boolean r2) {
            f.a(this.f2168a, r1, r2);
        }
    }

    public f() {
        com.bytedance.apm6.hub.b.i.a.g().h();
        com.bytedance.apm6.hub.b.i.a.g().k(new a(this));
    }

    static /* synthetic */ void a(f r0, JSONObject r1, boolean r2) {
        r0.b(r1, r2);
    }

    private void b(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("performance_modules");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r13 = r12.optJSONObject("memory");
        if (r13 != null) goto L8;
        return;
    L8:
        boolean r2 = true;
        if (r13.optInt("enable_alloc_collect", 0) != 1) goto L11;
        boolean r3 = true;
    L13:
        if (r13.optInt("enable_alloc_upload", 0) == 1) goto L16;
        r2 = false;
    L16:
        this.f2167a = new d.b.b.j.b(r3, r2, r13.optInt("alloc_collect_per_thousand_alloc", 0), r13.optInt("alloc_dump_per_thousand_collect", 0), r13.optInt("alloc_threshold_alloc_frequency", 0), r13.optLong("alloc_threshold_alloc_size", 0));
        if (d.b.b.o.a.c() == false) goto L19;
        d.b.b.o.m.b.a("APM-Config", "parsed JavaAllocConfig=" + this.f2167a);
    L19:
        d.b.b.j.a.b().e(getConfig());
        return;
    L11:
        r3 = false;
        goto L13
    }

    @Override // d.b.b.j.c
    public d.b.b.j.b getConfig() {
        return this.f2167a;
    }
}
