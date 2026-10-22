package com.bytedance.ttnet.p;

import android.text.TextUtils;
import d.b.r.y;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends i.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f6508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<String> f6509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<String> f6510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<String> f6511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicLong f6514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Set<d.b.r.h0.c> f6515l;

    class a extends d.b.h.a.a.d.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.r.h0.c f6516f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f6517g;

        a(d r1, d.b.r.h0.c r2) {
            this.f6517g = r1;
            this.f6516f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.i(this.f6517g).remove(this.f6516f) == true) goto L5;
            return;
        L5:
            if (d.i(this.f6517g).size() != 0) goto L9;
            this.f6517g.f6557a.f();
            return;
        }
    }

    public d() {
        this.f6508e = new f();
        this.f6509f = new CopyOnWriteArraySet();
        this.f6510g = new CopyOnWriteArraySet();
        this.f6511h = new CopyOnWriteArraySet();
        this.f6512i = 5000;
        this.f6513j = 5000;
        this.f6514k = new AtomicLong(0);
        this.f6515l = new CopyOnWriteArraySet();
    }

    static /* synthetic */ Set i(d r0) {
        return r0.f6515l;
    }

    private boolean j(d.b.r.h0.c r7) {
        this.f6508e.c(r7);
        boolean r1 = false;
        if (i.i(this.f6509f, r7.A()) == false) goto L7;
        this.f6514k.set(System.currentTimeMillis());
        this.f6515l.add(r7);
        return false;
    L7:
        if ((System.currentTimeMillis() - this.f6514k.get()) <= this.f6512i) goto L9;
    L19:
        return r1;
    L9:
        if (this.f6515l.isEmpty() == true) goto L19;
        if (this.f6510g.isEmpty() == false) goto L14;
        r1 = true;
        if (this.f6511h.isEmpty() == true) goto L19;
        return !i.i(this.f6511h, r7.A());
    L14:
        return i.i(this.f6510g, r7.A());
    }

    @Override // d.b.r.l0.b
    public void a(d.b.r.h0.c r9, y r10) {
        if (j(r9) == false) goto L6;
        this.f6557a.h(r9, false, true, this.f6513j, r10);
        return;
    }

    @Override // d.b.r.l0.b
    public boolean b(d.b.r.h0.c r10, y r11, Executor r12, Runnable r13) {
        if (j(r10) == true) goto L5;
        return false;
    L5:
        return this.f6557a.g(r10, false, this.f6513j, r13, r12, r11);
    }

    @Override // com.bytedance.ttnet.p.i.a, d.b.r.l0.b
    public void c(d.b.r.h0.c r3) {
        d.b.h.a.a.d.c.c(d.b.h.a.a.d.d.f13252f).d(new a(this, r3));
    }

    @Override // com.bytedance.ttnet.p.i.a
    public boolean e(JSONObject r6) {
        super.e(r6);
        this.f6508e.a(r6);
        this.f6557a.d(r6, this.f6558b);
        JSONArray r0 = r6.optJSONArray("p0");
        int r1 = 0;
        if (r0 == null) goto L12;
        int r2 = 0;
    L6:
        if (r2 >= r0.length()) goto L12;
        String r3 = r0.optString(r2);
        if (TextUtils.isEmpty(r3) == true) goto L10;
        this.f6509f.add(r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (this.f6508e.b() == false) goto L14;
    L16:
        JSONArray r4 = r6.optJSONArray("bl_for_runtime");
        if (r4 == null) goto L25;
        int r5 = 0;
    L20:
        if (r5 >= r4.length()) goto L25;
        String r7 = r4.optString(r5);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        this.f6510g.add(r7);
    L24:
        r5 = r5 + 1;
    L25:
        JSONArray r8 = r6.optJSONArray("wl_for_runtime");
        if (r8 != null) goto L28;
    L33:
        this.f6512i = r6.optInt("p0_check_max_ms", 5000);
        this.f6513j = r6.optInt("p1_wait_max_ms", 5000);
        return true;
    L28:
        if (r1 >= r8.length()) goto L33;
        String r9 = r8.optString(r1);
        if (TextUtils.isEmpty(r9) == true) goto L32;
        this.f6511h.add(r9);
    L32:
        r1 = r1 + 1;
        goto L28
    L14:
        if (this.f6509f.isEmpty() == false) goto L16;
        return false;
    }

    @Override // com.bytedance.ttnet.p.i.a
    public void g() {
        super.g();
        this.f6557a.f();
    }

    @Override // com.bytedance.ttnet.p.i.a
    i.b h() {
        return i.b.f6563i;
    }
}
