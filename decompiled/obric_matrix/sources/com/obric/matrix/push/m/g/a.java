package com.obric.matrix.push.m.g;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b, Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f9676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f9677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f9678h;

    /* JADX INFO: renamed from: com.obric.matrix.push.m.g.a$a, reason: collision with other inner class name */
    class RunnableC0268a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g f9679f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f9680g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f9681h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f9682i;

        /* JADX INFO: renamed from: com.obric.matrix.push.m.g.a$a$a, reason: collision with other inner class name */
        class RunnableC0269a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Bitmap f9683f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ RunnableC0268a f9684g;

            RunnableC0269a(RunnableC0268a r1, Bitmap r2) {
                this.f9684g = r1;
                this.f9683f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap r0 = this.f9683f;
                if (r0 != null) goto L5;
            L7:
                this.f9684g.f9681h.onFailed();
                return;
            L5:
                if (r0.isRecycled() == true) goto L7;
                this.f9684g.f9681h.a(this.f9683f);
            }
        }

        RunnableC0268a(a r1, g r2, boolean r3, d r4) {
            this.f9682i = r1;
            this.f9679f = r2;
            this.f9680g = r3;
            this.f9681h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap r0 = null;
            String r1 = a.c(this.f9679f);     // Catch: Throwable -> L14
            if (this.f9680g == false) goto L7;
            if (r1 == null) goto L7;
            r0 = a.d(this.f9682i).a(r1);     // Catch: Throwable -> L14
        L7:
            if (r0 != null) goto L12;
            r0 = a.e(this.f9682i).b(this.f9679f);     // Catch: Throwable -> L14
            if (r1 == null) goto L12;
            if (r0 == null) goto L12;
            a.d(this.f9682i).c(r1, r0);     // Catch: Throwable -> L14
        L12:
            a.f(this.f9682i).post(new RunnableC0269a(this, r0));
        }
    }

    public a(e r1) {
        this.f9676f = r1;
        this.f9678h = new c();
    }

    static /* synthetic */ String c(g r0) {
        return g(r0);
    }

    static /* synthetic */ c d(a r0) {
        return r0.f9678h;
    }

    static /* synthetic */ e e(a r0) {
        return r0.f9676f;
    }

    static /* synthetic */ Handler f(a r0) {
        return r0.f9677g;
    }

    private static String g(g r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.f9692a != null) goto L7;
        return null;
    L7:
        return r1.a();
    }

    @Override // com.obric.matrix.push.m.g.b
    public void a(g r3, boolean r4, d r5) {
        if (this.f9677g != null) goto L5;
        this.f9677g = new Handler(Looper.getMainLooper(), this);
    L5:
        com.bytedance.common.utility.m.c.c(new RunnableC0268a(this, r3, r4, r5));
    }

    @Override // com.obric.matrix.push.m.g.e
    public Bitmap b(g r1) {
        return this.f9676f.b(r1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r1) {
        return false;
    }
}
