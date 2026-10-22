package com.bytedance.sync.v2.compensate;

import android.os.Handler;
import com.bytedance.sync.v2.f.k;
import d.b.u.l;

/* JADX INFO: loaded from: classes.dex */
abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c f5902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<Handler> f5903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final k f5904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f5905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f5906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f5907f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f5908f;

        a(f r1) {
            this.f5908f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5908f.d();
            f.a(this.f5908f);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f5909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5910b;

        b() {
        }
    }

    public f(String r2, c r3, k r4, l<Handler> r5, b r6) {
        this.f5907f = new a(this);
        this.f5905d = r2;
        this.f5902a = r3;
        this.f5904c = r4;
        this.f5903b = r5;
        this.f5906e = r6;
    }

    static /* synthetic */ void a(f r0) {
        r0.h();
    }

    private void c() {
        d.b.u.x.b.a(this.f5905d + "receive data, do reset rotate");
        this.f5903b.b(new Object[0]).removeCallbacks(this.f5907f);
        h();
    }

    private void h() {
        long r0 = e();
        d.b.u.x.b.a(this.f5905d + "next time to request: " + (r0 / 1000) + "s");
        if (r0 >= 0) goto L5;
        return;
    L5:
        this.f5903b.b(new Object[0]).postDelayed(this.f5907f, r0);
    }

    public void b() {
        this.f5903b.b(new Object[0]).removeCallbacks(this.f5907f);
    }

    protected abstract void d();

    protected long e() {
        boolean r0 = this.f5902a.isForeground();
        b r5 = this.f5906e;
        if (r0 == false) goto L5;
        long r3 = r5.f5909a;
    L7:
        return r3 * 1000;
    L5:
        r3 = r5.f5910b;
        goto L7
    }

    public abstract int f();

    protected abstract boolean g(com.bytedance.sync.v2.j.e r1);

    public void i(boolean r1) {
        if (r1 == true) goto L4;
        d();
    L4:
        h();
    }

    public void j(com.bytedance.sync.v2.j.e r1) {
        if (g(r1) == false) goto L6;
        c();
        return;
    }

    public void k(b r1) {
        this.f5906e = r1;
    }
}
