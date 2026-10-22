package com.bytedance.bdinstall.d1;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.bytedance.bdinstall.b0;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.n0;

/* JADX INFO: loaded from: classes.dex */
public class r implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f2743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n0 f2744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f2745c;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h0 f2746f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ r f2747g;

        a(r r1, h0 r2) {
            this.f2747g = r1;
            this.f2746f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.b(this.f2747g) == null) goto L5;
            r.b(this.f2747g).b(this.f2746f);
            com.bytedance.bdinstall.i.r(this.f2747g);
        L5:
            r.c(this.f2747g, null);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r f2748f;

        b(r r1) {
            this.f2748f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.b(this.f2748f) == null) goto L5;
            r.b(this.f2748f).a();
            com.bytedance.bdinstall.i.r(this.f2748f);
        L5:
            r.c(this.f2748f, null);
        }
    }

    public r(long r3, n0 r5) {
        this.f2745c = new Handler(Looper.getMainLooper());
        this.f2743a = r3;
        this.f2744b = r5;
    }

    static /* synthetic */ n0 b(r r0) {
        return r0.f2744b;
    }

    static /* synthetic */ n0 c(r r0, n0 r1) {
        r0.f2744b = r1;
        return r1;
    }

    @Override // com.bytedance.bdinstall.b0
    public void a(@NonNull h0 r3) {
        this.f2745c.post(new a(this, r3));
    }

    public void d() {
        this.f2745c.postDelayed(new b(this), this.f2743a);
    }
}
