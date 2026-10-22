package com.bytedance.sync.v2.h;

import com.bytedance.sync.v2.f.m;
import d.b.u.w.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements l, m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<a> f5977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d.b.u.e f5978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bytedance.common.wschannel.r.b f5979h;

    public interface a {
        void M(boolean r1);
    }

    public i(d.b.u.e r2) {
        this.f5977f = new ArrayList();
        this.f5978g = r2;
        r2.f15025c.k(this);
    }

    @Override // com.bytedance.sync.v2.f.m
    public void E(a r2) {
        monitor-enter(this);
        this.f5977f.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // d.b.u.w.l
    public void F(com.bytedance.common.wschannel.r.b r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.f3662d != this.f5978g.f15027e) goto L33;
        com.bytedance.common.wschannel.r.b r0 = this.f5979h;
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L9;
    L11:
        boolean r3 = false;
    L13:
        if (r6.f3660b == com.bytedance.common.wschannel.r.c.f3667k) goto L16;
        r1 = false;
    L16:
        this.f5979h = r6;
        if (r3 == r1) goto L31;
        monitor-enter(this);
        int r7 = this.f5977f.size();     // Catch: Throwable -> L24
        a[] r4 = new a[r7];     // Catch: Throwable -> L24
        this.f5977f.toArray(r4);     // Catch: Throwable -> L24
    L20:
        if (r2 >= r7) goto L22;
        r4[r2].M(r1);     // Catch: Throwable -> L24
        r2 = r2 + 1;     // Catch: Throwable -> L24
        goto L20
    L22:
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    L31:
        return;
    L9:
        if (r0.f3660b != com.bytedance.common.wschannel.r.c.f3667k) goto L11;
        r3 = true;
        goto L13
    }

    @Override // com.bytedance.sync.v2.f.m
    public void X(a r2) {
        monitor-enter(this);
        this.f5977f.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.sync.v2.f.m
    public boolean j() {
        com.bytedance.common.wschannel.r.b r0 = this.f5979h;
        if (r0 == null) goto L9;
        if (r0.f3660b != com.bytedance.common.wschannel.r.c.f3667k) goto L9;
        return true;
    L9:
        return this.f5978g.f15025c.j();
    }
}
