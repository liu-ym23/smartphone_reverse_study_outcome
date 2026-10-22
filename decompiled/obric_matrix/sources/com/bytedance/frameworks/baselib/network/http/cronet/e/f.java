package com.bytedance.frameworks.baselib.network.http.cronet.e;

import com.bytedance.common.utility.reflect.Reflect;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
class f extends c {
    private HttpURLConnection p;

    public f(d.b.r.h0.c r1) {
        super(r1);
        this.p = null;
    }

    @Override // d.b.h.a.a.h.m.b
    protected int B(IOException r3) {
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        return -1;
    L10:
        return j.l(this.p);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.c
    HttpURLConnection Z() {
        return this.p;
    }

    @Override // d.b.r.l0.c
    public void a(Throwable r2, boolean r3) {
        W(this.p, r2, r3);
    }

    @Override // d.b.r.n
    public void c() {
        d.b.h.a.a.h.m.b.A(this.f13419g, this);
    }

    @Override // d.b.r.h0.e
    public void cancel() {
        V(this.p);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.c, d.b.r.h0.e
    public boolean d(long r6) {
        super.d(r6);
        HttpURLConnection r5 = this.p;
        if (r5 != null) goto L9;
    L8:
        return true;
    L9:
        Reflect.on(r5).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L7
    L7:
        return false;
    }

    @Override // d.b.h.a.a.h.m.b
    protected IOException h(Exception r4) {
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(r4.getClass().getName()) == false) goto L5;
        c();
        int r0 = j.l(this.p);
    L7:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r4.getClass().getName()) == false) goto L9;
    L10:
        r0 = j.l(this.p);
    L12:
        return new e(r4, this.f13419g, r0);
    L9:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r4.getClass().getName()) == false) goto L12;
    L5:
        r0 = 0;
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.e.c
    void i0(HttpURLConnection r1) {
        this.p = r1;
    }
}
