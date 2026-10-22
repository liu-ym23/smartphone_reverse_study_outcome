package com.bytedance.sync.v2.compensate;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.sync.v2.f.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CompensatorImpl f5890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f5891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d.b.u.e f5892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bytedance.sync.v2.f.i f5893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f5894j;

    public a(Context r1, d.b.u.e r2, com.bytedance.sync.v2.f.i r3) {
        this.f5891g = r1;
        this.f5892h = r2;
        this.f5893i = r3;
    }

    @Override // com.bytedance.sync.v2.f.a
    public void a(com.bytedance.sync.v2.j.e r2) {
        CompensatorImpl r0 = this.f5890f;
        if (r0 == null) goto L5;
        r0.l(r2);
    L5:
        g r1 = this.f5894j;
        if (r1 == null) goto L9;
        r1.f(r2);
        return;
    }

    @Override // com.bytedance.sync.v2.f.a
    public void m() {
        CompensatorImpl r0 = this.f5890f;
        if (r0 == null) goto L5;
        r0.j();
    L5:
        g r1 = this.f5894j;
        if (r1 == null) goto L9;
        r1.e();
        return;
    }

    @Override // com.bytedance.sync.v2.f.a
    public void m0() {
        CompensatorImpl r0 = new CompensatorImpl(this.f5891g, this.f5892h, this.f5893i);
        r0.m();
        g r1 = new g(this.f5891g, this.f5892h);
        r1.g();
        this.f5890f = r0;
        this.f5894j = r1;
    }

    @Override // com.bytedance.sync.v2.f.a
    public void reset() {
        CompensatorImpl r0 = this.f5890f;
        if (r0 == null) goto L5;
        r0.h();
        this.f5890f = null;
    L5:
        g r1 = this.f5894j;
        if (r1 == null) goto L9;
        r1.c();
        this.f5894j = null;
        return;
    }
}
