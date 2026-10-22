package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import com.bytedance.sync.v2.f.k;
import d.b.u.l;

/* JADX INFO: loaded from: classes.dex */
final class i implements d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final c f5924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final l<Handler> f5925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k f5926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f5927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private f f5928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d.b.u.b0.a f5929k;

    i(c r1, l<Handler> r2, k r3, boolean r4) {
        this.f5924f = r1;
        this.f5925g = r2;
        this.f5926h = r3;
        this.f5927i = r4;
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void a(com.bytedance.sync.v2.j.e r1) {
        f r0 = this.f5928j;
        if (r0 == null) goto L6;
        r0.j(r1);
        return;
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void b() {
        f r0 = this.f5928j;
        if (r0 != null) goto L5;
    L6:
        f r1 = this.f5928j;
        if (r1 == null) goto L9;
        r1.b();
    L9:
        f.b r7 = new f.b();
        r7.f5909a = this.f5929k.c();
        r7.f5910b = this.f5929k.c();
        e r2 = new e("[Compensator] ", this.f5924f, this.f5926h, this.f5925g, r7);
        this.f5928j = r2;
        r2.i(true);
        return;
    L5:
        if (r0.f() == 1) goto L6;
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void c(d.b.u.b0.a r8, boolean r9) {
        d.b.u.x.b.a("[Compensator] WsConnectedCompensator start readyToPoll = " + r9);
        this.f5929k = r8;
        f.b r6 = new f.b();
        if (r9 == false) goto L5;
        r6.f5909a = r8.c();
        r6.f5910b = r8.c();
        f r10 = new e("[Compensator] ", this.f5924f, this.f5926h, this.f5925g, r6);
    L6:
        this.f5928j = r10;
        this.f5928j.i(this.f5927i);
        return;
    L5:
        r6.f5909a = r8.d();
        r6.f5910b = r8.d();
        r10 = new h("[Compensator] ", this.f5924f, this.f5926h, this.f5925g, r6);
        goto L6
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void d(d.b.u.b0.a r4) {
        this.f5929k = r4;
        f.b r0 = new f.b();
        if (this.f5928j.f() != 1) goto L5;
        r0.f5909a = r4.d();
        int r5 = r4.d();
    L6:
        r0.f5910b = r5;
        this.f5928j.k(r0);
        return;
    L5:
        r0.f5909a = r4.c();
        r5 = r4.c();
        goto L6
    }

    @Override // com.bytedance.sync.v2.compensate.d
    public void destroy() {
        d.b.u.x.b.a("[Compensator] WsConnectedCompensator destroy");
        f r1 = this.f5928j;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    @Override // com.bytedance.sync.v2.h.f.a
    public int e() {
        return 1;
    }
}
