package com.bytedance.bdturing;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f3055d = 6000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f3056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f3057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3058c;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f3059f;

        a(i r1) {
            this.f3059f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r1 = i.a(this.f3059f).size() - 1;     // Catch: Throwable -> L16 Exception -> L21
            double r2 = ((b) i.a(this.f3059f).get(r1)).f3064e;     // Catch: Throwable -> L16 Exception -> L21
        L4:
            if (r1 < 0) goto L14;
            b r4 = (b) i.a(this.f3059f).get(r1);     // Catch: Throwable -> L16 Exception -> L21
            long r5 = r4.f3064e;     // Catch: Throwable -> L16 Exception -> L21
            if (r2 >= r5) goto L12;
            if (r1 == 0) goto L12;
            String r6 = "uploadEvent abandon " + r4.f3064e + " " + r4.f3065f;     // Catch: Throwable -> L16 Exception -> L21
        L11:
            g.c("onTouch", r6);     // Catch: Throwable -> L16 Exception -> L21
            r1 = r1 - 1;     // Catch: Throwable -> L16 Exception -> L21
        L12:
            o.b(r5, r4.f3060a, r4.f3061b, r4.f3065f, r4.f3062c, r4.f3063d);     // Catch: Throwable -> L16 Exception -> L21
            r2 = r2 - 33.3333d;     // Catch: Throwable -> L16 Exception -> L21
            r6 = "uploadEvent use " + r4.f3064e + " " + r4.f3065f;     // Catch: Throwable -> L16 Exception -> L21
            goto L11
        L14:
            i.a(this.f3059f).clear();     // Catch: Throwable -> L16 Exception -> L21
        L16:
            th = move-exception;
            i.b(this.f3059f, false);
            throw th;
        L19:
            i.b(this.f3059f, false);
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f3060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f3061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f3062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f3063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f3064e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3065f;

        b(i r1) {
        }
    }

    static {
    }

    public i(int r2) {
        this.f3056a = new ArrayList();
        this.f3057b = false;
        int r0 = f3055d;
        this.f3058c = r0;
        if (r2 <= r0) goto L6;
        this.f3058c = r2;
        return;
    }

    static /* synthetic */ List a(i r0) {
        return r0.f3056a;
    }

    static /* synthetic */ boolean b(i r0, boolean r1) {
        r0.f3057b = r1;
        return r1;
    }

    private void d() {
        q.c().e(new a(this));     // Catch: Exception -> L4
        return;
    }

    public void c(MotionEvent r6) {
        if (this.f3057b == false) goto L27;
        return;
    L27:
    L20:
        int r1 = 1;
    L21:
        if (r1 != 1) goto L31;
    L22:
        this.f3057b = true;
        d();
        return;
    L31:
        return;
    L15:
        th = th;
        r1 = 1;
    L17:
        if (r1 != 1) goto L19;
        this.f3057b = true;
        d();
    L19:
        throw th;
    L6:
        if (this.f3056a.size() >= this.f3058c) goto L12;
        r1 = r6.getAction();     // Catch: Throwable -> L15 Exception -> L20
        b r2 = new b(this);     // Catch: Throwable -> L10 Exception -> L24
        r2.f3060a = r6.getPressure();     // Catch: Throwable -> L10 Exception -> L24
        r2.f3061b = r6.getTouchMajor();     // Catch: Throwable -> L10 Exception -> L24
        r2.f3062c = r6.getX();     // Catch: Throwable -> L10 Exception -> L24
        r2.f3063d = r6.getY();     // Catch: Throwable -> L10 Exception -> L24
        r2.f3064e = r6.getEventTime();     // Catch: Throwable -> L10 Exception -> L24
        r2.f3065f = r6.getAction();     // Catch: Throwable -> L10 Exception -> L24
        this.f3056a.add(r2);     // Catch: Throwable -> L10 Exception -> L24
        g.a("onTouch", "events : " + this.f3056a.size());     // Catch: Throwable -> L10 Exception -> L24
    L13:
        if (r1 == 1) goto L22;
        return;
    L10:
        th = th;
        goto L17
    L12:
        r1 = 1;
        goto L13
    }
}
