package d.c.i.c.a;

import android.graphics.Bitmap;
import d.c.c.d.i;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f15856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.c.c.h.a<Bitmap> f15857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<d.c.c.h.a<Bitmap>> f15858c;

    private e(c r1) {
        i.g(r1);
        this.f15856a = r1;
    }

    e(f r2) {
        c r0 = r2.d();
        i.g(r0);
        this.f15856a = r0;
        r2.c();
        this.f15857b = r2.e();
        this.f15858c = r2.b();
    }

    public static e b(c r1) {
        return new e(r1);
    }

    public static f h(c r1) {
        return new f(r1);
    }

    public synchronized void a() {
        monitor-enter(this);
        d.c.c.h.a.L(this.f15857b);     // Catch: Throwable -> L6
        this.f15857b = null;     // Catch: Throwable -> L6
        d.c.c.h.a.M(this.f15858c);     // Catch: Throwable -> L6
        this.f15858c = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized d.c.c.h.a<Bitmap> c(int r2) {
        monitor-enter(this);
        List<d.c.c.h.a<Bitmap>> r0 = this.f15858c;     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        d.c.c.h.a<Bitmap> r3 = d.c.c.h.a.E(r0.get(r2));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    L9:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int d() {
        monitor-enter(this);
        List<d.c.c.h.a<Bitmap>> r0 = this.f15858c;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        int r1 = r0.size();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r1;
    L7:
        r1 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public c e() {
        return this.f15856a;
    }

    public synchronized d.c.c.h.a<Bitmap> f() {
        monitor-enter(this);
        d.c.c.h.a<Bitmap> r0 = d.c.c.h.a.E(this.f15857b);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean g(int r2) {
        monitor-enter(this);
        List<d.c.c.h.a<Bitmap>> r0 = this.f15858c;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (r0.get(r2) == null) goto L8;
        boolean r3 = true;
    L9:
        monitor-exit(this);
        return r3;
    L8:
        r3 = false;
    L11:
        th = move-exception;
        throw th;
    }
}
