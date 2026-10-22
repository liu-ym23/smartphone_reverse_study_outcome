package com.bytedance.bdturing;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HandlerThread f3134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f3135b;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static q f3136a;

        static {
            f3136a = new q(null);
        }

        static /* synthetic */ q a() {
            return f3136a;
        }
    }

    private class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f3137a;

        private c(q r1, Looper r2) {
            this.f3137a = r1;
            super(r2);
        }

        /* synthetic */ c(q r1, Looper r2, a r3) {
            this(r1, r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            int r0 = r3.what;
            if (r0 != 1) goto L5;
            q.a(this.f3137a, r3);
            return;
        L5:
            if (r0 != 2) goto L7;
            o.c((com.bytedance.bdturing.u.c) r3.obj);
            return;
        L7:
            if (r0 != 3) goto L15;
            o.a();
            return;
        }
    }

    private q() {
    }

    /* synthetic */ q(a r1) {
        this();
    }

    static /* synthetic */ void a(q r0, Message r1) {
        r0.b(r1);
    }

    private void b(Message r1) {
        Object r0 = r1.obj;
        if (r0 == null) goto L6;
        ((p) r0).u();
        return;
    }

    public static q c() {
        return b.a();
    }

    public Looper d() {
        return this.f3134a.getLooper();
    }

    public void e(Runnable r1) {
        c r0 = this.f3135b;
        if (r0 == null) goto L6;
        r0.post(r1);
        return;
    }

    public void f(Runnable r1, long r2) {
        c r0 = this.f3135b;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.postDelayed(r1, r2);
        return;
    L8:
        return;
    }

    public void g(Runnable r1) {
        c r0 = this.f3135b;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.removeCallbacks(r1);
        return;
    L8:
        return;
    }

    public void h(int r2, Object r3) {
        c r0 = this.f3135b;
        if (r0 == null) goto L6;
        Message r4 = r0.obtainMessage(r2, r3);
        this.f3135b.sendMessage(r4);
        return;
    }

    public void i(int r2, Object r3, long r4) {
        c r0 = this.f3135b;
        if (r0 == null) goto L6;
        Message r5 = r0.obtainMessage(r2, r3);
        this.f3135b.sendMessageDelayed(r5, r4);
        return;
    }

    public void j() {
        if (this.f3134a == null) goto L5;
        return;
    L5:
        monitor-enter(q.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f3134a != null) goto L9;
        HandlerThread r1 = new HandlerThread("TuringVerifyThread");     // Catch: Throwable -> L11
        this.f3134a = r1;     // Catch: Throwable -> L11
        r1.start();     // Catch: Throwable -> L11
        this.f3135b = new c(this, this.f3134a.getLooper(), null);     // Catch: Throwable -> L11
    L9:
        monitor-exit(q.class);     // Catch: Throwable -> L11
    }
}
