package d.c.i.l;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements Closeable, f, h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected d.c.h.d f16171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16172g;

    public c() {
    }

    public boolean A() {
        return false;
    }

    public boolean C() {
        return this.f16172g;
    }

    @Override // d.c.i.l.h
    public void a() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    protected void finalize() {
        if (isClosed() == false) goto L5;
        return;
    L5:
        d.c.c.e.a.d("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        close();     // Catch: Throwable -> L9
        super.finalize();
        return;
    L9:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public void g(e r1) {
        r1.o0();
        r1.l0();
        r1.m0();
    }

    public abstract boolean isClosed();

    public d.c.h.d l() {
        d.c.h.d r0 = this.f16171f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return d.c.h.d.f15831b;
    }

    public i s() {
        return g.f16188d;
    }

    public abstract int x();
}
