package k;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
final class r implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OutputStream f18293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a0 f18294g;

    public r(OutputStream r2, a0 r3) {
        kotlin.n0.d.o.g(r2, "out");
        kotlin.n0.d.o.g(r3, LocationMonitorConst.TIMEOUT);
        this.f18293f = r2;
        this.f18294g = r3;
    }

    @Override // k.x
    public void J(e r8, long r9) {
        kotlin.n0.d.o.g(r8, "source");
        c.b(r8.k0(), 0, r9);
    L4:
        if (r9 <= 0) goto L12;
        this.f18294g.f();
        u r0 = r8.f18255f;
        if (r0 == null) goto L10;
        int r1 = (int) Math.min(r9, r0.f18305c - r0.f18304b);
        this.f18293f.write(r0.f18303a, r0.f18304b, r1);
        r0.f18304b += r1;
        long r2 = r1;
        r9 = r9 - r2;
        r8.j0(r8.k0() - r2);
        if (r0.f18304b != r0.f18305c) goto L4;
        r8.f18255f = r0.b();
        v.f18312c.a(r0);
        goto L4
    L10:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18293f.close();
    }

    @Override // k.x
    public a0 e() {
        return this.f18294g;
    }

    @Override // k.x, java.io.Flushable
    public void flush() {
        this.f18293f.flush();
    }

    public String toString() {
        return "sink(" + this.f18293f + ')';
    }
}
