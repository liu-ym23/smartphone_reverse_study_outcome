package com.bytedance.sync.v2;

import com.bytedance.sync.v2.f.l;
import d.b.u.r;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class c implements l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile AtomicInteger f5869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile AtomicBoolean f5870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile AtomicLong f5871h;

    public c() {
        this.f5869f = new AtomicInteger(1);
        this.f5870g = new AtomicBoolean(true);
        this.f5871h = new AtomicLong(0);
    }

    @Override // com.bytedance.sync.v2.f.l
    public boolean c0() {
        return this.f5870g.get();
    }

    @Override // com.bytedance.sync.v2.f.l
    public void k0(int r1, int r2, long r3) {
        this.f5869f.set(r1);
        this.f5871h.set(r3);
    }

    @Override // com.bytedance.sync.v2.f.l
    public void m() {
        r.i(this.f5871h.get());
    }

    @Override // com.bytedance.sync.v2.f.l
    public int p() {
        return this.f5869f.get();
    }

    @Override // com.bytedance.sync.v2.f.l
    public void q(boolean r1) {
        this.f5870g.set(r1);
    }
}
