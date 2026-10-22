package d.c.g.a.b.e;

import android.graphics.Bitmap;
import android.util.SparseArray;
import d.c.i.d.f;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Class<?> f15773f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f15774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.g.a.b.c f15775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bitmap.Config f15776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExecutorService f15777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray<Runnable> f15778e;

    private class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final d.c.g.a.b.b f15779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final d.c.g.a.a.a f15780g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f15781h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f15782i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ c f15783j;

        public a(c r1, d.c.g.a.a.a r2, d.c.g.a.b.b r3, int r4, int r5) {
            this.f15783j = r1;
            this.f15780g = r2;
            this.f15779f = r3;
            this.f15781h = r4;
            this.f15782i = r5;
        }

        private boolean a(int r8, int r9) {
            int r2 = 2;
            if (r9 != 1) goto L5;
            d.c.c.h.a<Bitmap> r3 = this.f15779f.a(r8, this.f15780g.e(), this.f15780g.c());     // Catch: Throwable -> L23
        L15:
            boolean r10 = b(r8, r3, r9);     // Catch: Throwable -> L23
            d.c.c.h.a.L(r3);
            if (r10 == true) goto L22;
            if (r2 == (-1)) goto L22;
            return a(r8, r2);
        L22:
            return r10;
        L5:
            if (r9 == 2) goto L26;
            d.c.c.h.a.L(null);
            return false;
        L26:
            r3 = c.e(this.f15783j).d(this.f15780g.e(), this.f15780g.c(), c.d(this.f15783j));     // Catch: RuntimeException -> L10 Throwable -> L23
            r2 = -1;
            goto L15
        L10:
            e = move-exception;
            d.c.c.e.a.z(c.b(), "Failed to create frame bitmap", e);     // Catch: Throwable -> L23
            d.c.c.h.a.L(null);
            return false;
        L23:
            th = move-exception;
            d.c.c.h.a.L(null);
            throw th;
        }

        private boolean b(int r4, d.c.c.h.a<Bitmap> r5, int r6) {
            if (d.c.c.h.a.S(r5) == true) goto L6;
            return false;
        L6:
            if (c.f(this.f15783j).a(r4, r5.N()) == true) goto L8;
            return false;
        L8:
            d.c.c.e.a.s(c.b(), "Frame %d ready.", Integer.valueOf(this.f15781h));
            SparseArray r7 = c.c(this.f15783j);
            monitor-enter(r7);
            this.f15779f.b(this.f15781h, r5, r6);     // Catch: Throwable -> L14
            monitor-exit(r7);     // Catch: Throwable -> L14
            return true;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
        L25:
            th = move-exception;
            monitor-enter(c.c(this.f15783j));
            c.c(this.f15783j).remove(this.f15782i);     // Catch: Throwable -> L31
            throw th;
        L31:
            th = move-exception;
            throw th;
        L3:
            if (this.f15779f.c(this.f15781h) == false) goto L14;
            d.c.c.e.a.s(c.b(), "Frame %d is cached already.", Integer.valueOf(this.f15781h));     // Catch: Throwable -> L25
            SparseArray r0 = c.c(this.f15783j);
            monitor-enter(r0);
            c.c(this.f15783j).remove(this.f15782i);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            if (a(this.f15781h, 1) == false) goto L16;
            d.c.c.e.a.s(c.b(), "Prepared frame frame %d.", Integer.valueOf(this.f15781h));     // Catch: Throwable -> L25
        L17:
            SparseArray r1 = c.c(this.f15783j);
            monitor-enter(r1);
            c.c(this.f15783j).remove(this.f15782i);     // Catch: Throwable -> L22
            monitor-exit(r1);     // Catch: Throwable -> L22
            return;
        L22:
            th = move-exception;
            throw th;
        L16:
            d.c.c.e.a.h(c.b(), "Could not prepare frame %d.", new Object[]{Integer.valueOf(this.f15781h)});     // Catch: Throwable -> L25
            goto L17
        }
    }

    static {
        f15773f = c.class;
    }

    public c(f r1, d.c.g.a.b.c r2, Bitmap.Config r3, ExecutorService r4) {
        this.f15774a = r1;
        this.f15775b = r2;
        this.f15776c = r3;
        this.f15777d = r4;
        this.f15778e = new SparseArray();
    }

    static /* synthetic */ Class b() {
        return f15773f;
    }

    static /* synthetic */ SparseArray c(c r0) {
        return r0.f15778e;
    }

    static /* synthetic */ Bitmap.Config d(c r0) {
        return r0.f15776c;
    }

    static /* synthetic */ f e(c r0) {
        return r0.f15774a;
    }

    static /* synthetic */ d.c.g.a.b.c f(c r0) {
        return r0.f15775b;
    }

    private static int g(d.c.g.a.a.a r0, int r1) {
        return (r0.hashCode() * 31) + r1;
    }

    @Override // d.c.g.a.b.e.b
    public boolean a(d.c.g.a.b.b r11, d.c.g.a.a.a r12, int r13) {
        int r6 = g(r12, r13);
        SparseArray<Runnable> r7 = this.f15778e;
        monitor-enter(r7);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f15778e.get(r6) == null) goto L10;
        d.c.c.e.a.s(f15773f, "Already scheduled decode job for frame %d", Integer.valueOf(r13));     // Catch: Throwable -> L17
        monitor-exit(r7);     // Catch: Throwable -> L17
        return true;
    L10:
        if (r11.c(r13) == false) goto L14;
        d.c.c.e.a.s(f15773f, "Frame %d is cached already.", Integer.valueOf(r13));     // Catch: Throwable -> L17
        monitor-exit(r7);     // Catch: Throwable -> L17
        return true;
    L14:
        a r9 = new a(this, r12, r11, r13, r6);     // Catch: Throwable -> L17
        this.f15778e.put(r6, r9);     // Catch: Throwable -> L17
        this.f15777d.execute(r9);     // Catch: Throwable -> L17
        monitor-exit(r7);     // Catch: Throwable -> L17
        return true;
    }
}
