package k;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
final class p implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f18291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a0 f18292g;

    public p(InputStream r2, a0 r3) {
        kotlin.n0.d.o.g(r2, "input");
        kotlin.n0.d.o.g(r3, LocationMonitorConst.TIMEOUT);
        this.f18291f = r2;
        this.f18292g = r3;
    }

    @Override // k.z
    public long Z(e r4, long r5) {
        kotlin.n0.d.o.g(r4, "sink");
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r5 < 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L26;
        this.f18292g.f();     // Catch: AssertionError -> L19
        u r0 = r4.n0(1);     // Catch: AssertionError -> L19
        int r3 = this.f18291f.read(r0.f18303a, r0.f18305c, (int) Math.min(r5, 8192 - r0.f18305c));     // Catch: AssertionError -> L19
        if (r3 == (-1)) goto L13;
        r0.f18305c += r3;     // Catch: AssertionError -> L19
        long r2 = r3;
        r4.j0(r4.k0() + r2);     // Catch: AssertionError -> L19
        return r2;
    L13:
        if (r0.f18304b != r0.f18305c) goto L28;
        r4.f18255f = r0.b();     // Catch: AssertionError -> L19
        v.f18312c.a(r0);     // Catch: AssertionError -> L19
        return -1;
    L28:
        return -1;
    L19:
        e = move-exception;
        if (q.c(e) == true) goto L23;
        throw e;
    L23:
        throw new IOException(e);
    L26:
        throw new IllegalArgumentException(("byteCount < 0: " + r5).toString());
    L8:
        r1 = false;
        goto L9
    }

    @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18291f.close();
    }

    @Override // k.z
    public a0 e() {
        return this.f18292g;
    }

    public String toString() {
        return "source(" + this.f18291f + ')';
    }
}
