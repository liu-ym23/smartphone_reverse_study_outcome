package d.c.g.a.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import d.c.g.a.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c<T extends d.c.g.a.a.a> extends d.c.g.a.a.b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.facebook.common.time.b f15743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f15744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f15748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f15749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f15750i;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f15751f;

        a(c r1) {
            this.f15751f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            c r0 = this.f15751f;
            monitor-enter(r0);
            c.l(this.f15751f, false);     // Catch: Throwable -> L12
            if (c.m(this.f15751f) == true) goto L7;
            c.o(this.f15751f);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L7:
            if (c.n(this.f15751f) == null) goto L10;
            c.n(this.f15751f).g();     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }
    }

    public interface b {
        void g();
    }

    private c(T r3, b r4, com.facebook.common.time.b r5, ScheduledExecutorService r6) {
        super(r3);
        this.f15745d = false;
        this.f15747f = 2000;
        this.f15748g = 1000;
        this.f15750i = new a(this);
        this.f15749h = r4;
        this.f15743b = r5;
        this.f15744c = r6;
    }

    private c(d.c.h.d r1, T r2, b r3, com.facebook.common.time.b r4, ScheduledExecutorService r5) {
        super(r2, r1);
        this.f15745d = false;
        this.f15747f = 2000;
        this.f15748g = 1000;
        this.f15750i = new a(this);
        this.f15749h = r3;
        this.f15743b = r4;
        this.f15744c = r5;
    }

    static /* synthetic */ boolean l(c r0, boolean r1) {
        r0.f15745d = r1;
        return r1;
    }

    static /* synthetic */ boolean m(c r0) {
        return r0.t();
    }

    static /* synthetic */ b n(c r0) {
        return r0.f15749h;
    }

    static /* synthetic */ void o(c r0) {
        r0.u();
    }

    public static <T extends d.c.g.a.a.a & b> d.c.g.a.a.b<T> p(T r1, com.facebook.common.time.b r2, ScheduledExecutorService r3) {
        return q(r1, (b) r1, r2, r3);
    }

    public static <T extends d.c.g.a.a.a> d.c.g.a.a.b<T> q(T r1, b r2, com.facebook.common.time.b r3, ScheduledExecutorService r4) {
        return new c(r1, r2, r3, r4);
    }

    public static <T extends d.c.g.a.a.a & b> d.c.g.a.a.b<T> r(d.c.h.d r1, T r2, com.facebook.common.time.b r3, ScheduledExecutorService r4) {
        return s(r1, r2, (b) r2, r3, r4);
    }

    public static <T extends d.c.g.a.a.a> d.c.g.a.a.b<T> s(d.c.h.d r7, T r8, b r9, com.facebook.common.time.b r10, ScheduledExecutorService r11) {
        return new c(r7, r8, r9, r10, r11);
    }

    private boolean t() {
        if ((this.f15743b.now() - this.f15746e) <= this.f15747f) goto L5;
        return true;
    L5:
        return false;
    }

    private synchronized void u() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f15745d == true) goto L6;
        this.f15745d = true;     // Catch: Throwable -> L8
        this.f15744c.schedule(this.f15750i, this.f15748g, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // d.c.g.a.a.b, d.c.g.a.a.a
    public boolean k(Drawable r3, Canvas r4, int r5) {
        this.f15746e = this.f15743b.now();
        boolean r6 = super.k(r3, r4, r5);
        u();
        return r6;
    }
}
