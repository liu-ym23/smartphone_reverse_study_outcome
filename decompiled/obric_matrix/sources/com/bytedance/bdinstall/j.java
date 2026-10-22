package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f2808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f2810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g0.e.c f2812e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f2815c;

        a() {
            this.f2813a = false;
            this.f2814b = 0;
            this.f2815c = 0;
        }
    }

    protected j(Context r2) {
        this.f2809b = 0;
        this.f2808a = r2;
    }

    protected j(Context r2, long r3) {
        this.f2809b = 0;
        this.f2808a = r2;
        this.f2810c = r3;
    }

    protected abstract boolean a();

    protected abstract String b();

    public g0.e.c c() {
        return this.f2812e;
    }

    protected abstract long[] d();

    boolean e() {
        return this.f2811d;
    }

    public abstract boolean f();

    protected abstract boolean g();

    protected abstract long h();

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends j> T i() {
        this.f2810c = 0;
        return this;
    }

    public void j(g0.e.c r1) {
        this.f2812e = r1;
    }

    long k() {
        return 60000;
    }

    protected void l() {
        this.f2811d = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final a m() {
        boolean r1 = true;
        int r2 = 1;
        int r3 = 0;
        boolean r4 = false;
        r4 = false;
        if (g() == true) goto L5;
    L8:
        Object[] r0 = true;
    L9:
        if (r0 == true) goto L11;
        long r5 = 60000;
        q.c("network not ready. delay 60000 ms do " + b());
    L22:
        a r10 = new a();
        r10.f2814b = r2;
        r10.f2813a = r4;
        r10.f2815c = r5;
        return r10;
    L11:
        long r6 = this.f2810c + h();
        long r7 = System.currentTimeMillis();
        if (r6 <= (1000 + r7)) goto L24;
        r5 = r6 - r7;
        r2 = 2;
        q.a("time not ready. need " + r5);
        goto L22
    L24:
        boolean r8 = a();     // Catch: Exception -> L15
    L17:
        if (r8 == false) goto L19;
        this.f2809b = 0;
        this.f2810c = System.currentTimeMillis();
        r5 = h();
    L20:
        q.e(b() + " worked:" + r8 + " " + r5, null);
        int r9 = r3;
        r4 = r1;
        r2 = r9;
        goto L22
    L19:
        long[] r11 = d();
        int r12 = this.f2809b;
        this.f2809b = r12 + 1;
        r5 = r11[r12 % r11.length];
        r3 = 3;
        r1 = false;
    L15:
        e = move-exception;
        q.i(e);
        r8 = false;
        goto L17
    L5:
        if (com.bytedance.bdinstall.d1.i.a(this.f2808a) == true) goto L8;
        r0 = false;
        goto L9
    }
}
