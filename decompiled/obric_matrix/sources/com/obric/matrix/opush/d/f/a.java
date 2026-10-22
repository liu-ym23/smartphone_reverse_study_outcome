package com.obric.matrix.opush.d.f;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b, Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f9280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f9281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f9282h;

    /* JADX INFO: renamed from: com.obric.matrix.opush.d.f.a$a, reason: collision with other inner class name */
    class RunnableC0247a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f9283f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f9284g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f9285h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f9286i;

        /* JADX INFO: renamed from: com.obric.matrix.opush.d.f.a$a$a, reason: collision with other inner class name */
        class RunnableC0248a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bitmap f9287f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ RunnableC0247a f9288g;

            RunnableC0248a(RunnableC0247a r1, Bitmap r2) {
                this.f9288g = r1;
                this.f9287f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap r0 = this.f9287f;
                if (r0 != null) goto L5;
            L7:
                this.f9288g.f9285h.onFailed();
                return;
            L5:
                if (r0.isRecycled() == true) goto L7;
                this.f9288g.f9285h.a(this.f9287f);
            }
        }

        RunnableC0247a(a r1, g r2, boolean r3, d r4) {
            this.f9286i = r1;
            this.f9283f = r2;
            this.f9284g = r3;
            this.f9285h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap r0 = null;
            String r1 = a.c(this.f9283f);     // Catch: Throwable -> L14
            if (this.f9284g == false) goto L7;
            if (r1 == null) goto L7;
            r0 = a.d(this.f9286i).a(r1);     // Catch: Throwable -> L14
        L7:
            if (r0 != null) goto L12;
            r0 = a.e(this.f9286i).a(this.f9283f);     // Catch: Throwable -> L14
            if (r1 == null) goto L12;
            if (r0 == null) goto L12;
            a.d(this.f9286i).c(r1, r0);     // Catch: Throwable -> L14
        L12:
            a.f(this.f9286i).post(new RunnableC0248a(this, r0));
        }
    }

    public a(e r1) {
        this.f9280f = r1;
        this.f9282h = new c();
    }

    static /* synthetic */ String c(g r0) {
        return g(r0);
    }

    static /* synthetic */ c d(a r0) {
        return r0.f9282h;
    }

    static /* synthetic */ e e(a r0) {
        return r0.f9280f;
    }

    static /* synthetic */ Handler f(a r0) {
        return r0.f9281g;
    }

    private static String g(g r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.f9296a != null) goto L7;
        return null;
    L7:
        return r1.a();
    }

    @Override // com.obric.matrix.opush.d.f.e
    public Bitmap a(g r1) {
        return this.f9280f.a(r1);
    }

    @Override // com.obric.matrix.opush.d.f.b
    public void b(g r3, boolean r4, d r5) {
        if (this.f9281g != null) goto L5;
        this.f9281g = new Handler(Looper.getMainLooper(), this);
    L5:
        com.bytedance.common.utility.m.c.c(new RunnableC0247a(this, r3, r4, r5));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r1) {
        return false;
    }
}
