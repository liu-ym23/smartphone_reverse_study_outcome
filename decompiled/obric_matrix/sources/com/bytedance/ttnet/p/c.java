package com.bytedance.ttnet.p;

import com.ss.ttuploader.TTUploadResolver;
import d.b.r.y;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends i.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f6502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f6503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h f6504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<String> f6505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<String> f6506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6507j;

    public c() {
        this.f6502e = new f();
        this.f6503f = new g();
        this.f6504g = new h();
        this.f6505h = new CopyOnWriteArraySet();
        this.f6506i = new CopyOnWriteArraySet();
        this.f6507j = TTUploadResolver.HOST_MAX_CACHE_TIME;
    }

    private boolean i(d.b.r.h0.c r2) {
        this.f6502e.c(r2);
        if (this.f6505h.isEmpty() == true) goto L7;
        return i.i(this.f6505h, r2.A());
    L7:
        if (this.f6506i.isEmpty() == false) goto L9;
        return false;
    L9:
        return !i.i(this.f6506i, r2.A());
    }

    @Override // d.b.r.l0.b
    public void a(d.b.r.h0.c r9, y r10) {
        if (i(r9) == false) goto L6;
        this.f6557a.h(r9, false, true, this.f6507j, r10);
        return;
    }

    @Override // d.b.r.l0.b
    public boolean b(d.b.r.h0.c r10, y r11, Executor r12, Runnable r13) {
        if (i(r10) == true) goto L5;
        return false;
    L5:
        return this.f6557a.g(r10, false, this.f6507j, r13, r12, r11);
    }

    @Override // d.b.r.l0.b
    public d.b.r.h0.c d(d.b.r.h0.c r2) {
        d.b.r.h0.c r3 = this.f6503f.b(r2);
        return this.f6504g.d(r3);
    }

    @Override // com.bytedance.ttnet.p.i.a
    public boolean e(JSONObject r3) {
        super.e(r3);
        this.f6502e.a(r3);
        this.f6557a.d(r3, this.f6558b);
        JSONObject r0 = r3.optJSONObject("priority");
        if (this.f6502e.b() == true) goto L7;
        if (r0 != null) goto L7;
        return false;
    L7:
        this.f6503f.a(r0);
        this.f6504g.c(r3);
        JSONObject r4 = r3.optJSONObject("delay");
        if (r4 == null) goto L12;
        this.f6505h.addAll(i.h(r4, "bl_with_priority"));
        this.f6506i.addAll(i.h(r4, "wl_with_priority"));
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.ttnet.p.i.a
    public void f() {
        super.f();
        this.f6504g.a();
    }

    @Override // com.bytedance.ttnet.p.i.a
    public void g() {
        super.g();
        this.f6504g.b();
        this.f6557a.f();
    }

    @Override // com.bytedance.ttnet.p.i.a
    i.b h() {
        return i.b.f6564j;
    }
}
