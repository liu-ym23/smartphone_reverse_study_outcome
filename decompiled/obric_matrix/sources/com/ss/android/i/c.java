package com.ss.android.i;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f11874f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d.b.s.a.t.c f11875g;

        a(Activity r1, d.b.s.a.t.c r2) {
            this.f11874f = r1;
            this.f11875g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.b.s.a.t.d r0 = new d.b.s.a.t.d(this.f11874f);
            r0.c(this.f11875g);
            r0.show();
        }
    }

    public c() {
    }

    public abstract boolean a(int r1);

    public boolean b(d.b.s.a.t.c r3) {
        o.g(r3, "dialogParams");
        Activity r2 = d.b.s.a.l0.d.i();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.isFinishing() == false) goto L8;
        return false;
    L8:
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        d.b.s.a.t.d r0 = new d.b.s.a.t.d(r2);
        r0.c(r3);
        r0.show();
        return true;
    L10:
        new Handler(Looper.getMainLooper()).post(new a(r2, r3));
        return true;
    }
}
