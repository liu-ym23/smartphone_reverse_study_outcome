package com.bytedance.monitor.collector;

import android.util.Pair;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f5108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f5109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f5110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile boolean f5111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected d.b.l.a.h.d f5112e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f5113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f5114g;

        a(b r1, int r2) {
            this.f5114g = r1;
            this.f5113f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r0 = this.f5114g;
            int r1 = r0.f5109b;
            if (r1 > (-1)) goto L6;
            return;
        L6:
            if (r1 != 2) goto L11;
            int r2 = r0.f5110c;
            int r3 = this.f5113f;
            if (r2 == r3) goto L12;
            r0.f5110c = r3;
            r0.f(r3);
            return;
        L12:
            return;
        }
    }

    public b(int r3, String r4) {
        this.f5109b = 0;
        this.f5110c = 1;
        this.f5111d = false;
        this.f5108a = r4;
        this.f5110c = r3;
        k.n().a(this);
        this.f5112e = d.b.l.a.h.c.a();
    }

    Pair<String, ?> a() {
        return null;
    }

    Pair<String, ?> b(long r1, long r3) {
        return null;
    }

    public final void c(int r2) {
        d.b.l.a.h.e r3 = d.b.l.a.h.c.e("refreshConfig", new a(this, r2));
        d.b.l.a.h.d r1 = this.f5112e;
        if (r1 == null) goto L6;
        r1.c(r3);
        return;
    }

    @CallSuper
    void d() {
        if (this.f5109b < 0) goto L7;
        this.f5109b = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    @CallSuper
    void e() {
        this.f5109b = 1;
    }

    protected abstract void f(int r1);
}
