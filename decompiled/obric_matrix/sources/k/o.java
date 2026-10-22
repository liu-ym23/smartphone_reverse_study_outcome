package k;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f18288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final g f18289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Inflater f18290i;

    public o(g r2, Inflater r3) {
        kotlin.n0.d.o.g(r2, "source");
        kotlin.n0.d.o.g(r3, "inflater");
        this.f18289h = r2;
        this.f18290i = r3;
    }

    private final void b() {
        int r0 = this.f18287f;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = r0 - this.f18290i.getRemaining();
        this.f18287f -= r1;
        this.f18289h.skip(r1);
    }

    @Override // k.z
    public long Z(e r8, long r9) {
        kotlin.n0.d.o.g(r8, "sink");
        if (r9 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L36;
        if ((!this.f18288g) == false) goto L34;
        if (r9 != 0) goto L11;
        return 0;
    L11:
        boolean r0 = a();
        u r1 = r8.n0(1);     // Catch: DataFormatException -> L30
        int r2 = this.f18290i.inflate(r1.f18303a, r1.f18305c, (int) Math.min(r9, 8192 - r1.f18305c));     // Catch: DataFormatException -> L30
        if (r2 > 0) goto L14;
        if (this.f18290i.finished() == true) goto L25;
        if (this.f18290i.needsDictionary() == true) goto L25;
        if (r0 == false) goto L11;
        throw new EOFException("source exhausted prematurely");     // Catch: DataFormatException -> L30
    L25:
        b();     // Catch: DataFormatException -> L30
        if (r1.f18304b != r1.f18305c) goto L42;
        r8.f18255f = r1.b();     // Catch: DataFormatException -> L30
        v.f18312c.a(r1);     // Catch: DataFormatException -> L30
        return -1;
    L42:
        return -1;
    L14:
        r1.f18305c += r2;     // Catch: DataFormatException -> L30
        long r3 = r2;
        r8.j0(r8.k0() + r3);     // Catch: DataFormatException -> L30
        return r3;
    L30:
        e = move-exception;
        throw new IOException(e);
    L34:
        throw new IllegalStateException("closed".toString());
    L36:
        throw new IllegalArgumentException(("byteCount < 0: " + r9).toString());
    L5:
        r4 = false;
        goto L6
    }

    public final boolean a() {
        if (this.f18290i.needsInput() == true) goto L5;
        return false;
    L5:
        b();
        if (this.f18290i.getRemaining() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L20;
        if (this.f18289h.v() == false) goto L13;
        return true;
    L13:
        u r1 = this.f18289h.d().f18255f;
        if (r1 == null) goto L17;
        int r2 = r1.f18305c;
        int r3 = r1.f18304b;
        int r4 = r2 - r3;
        this.f18287f = r4;
        this.f18290i.setInput(r1.f18303a, r3, r4);
        return false;
    L17:
        kotlin.n0.d.o.p();
        throw null;
    L20:
        throw new IllegalStateException("?".toString());
    L8:
        r0 = false;
        goto L9
    }

    @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18288g == false) goto L5;
        return;
    L5:
        this.f18290i.end();
        this.f18288g = true;
        this.f18289h.close();
    }

    @Override // k.z
    public a0 e() {
        return this.f18289h.e();
    }
}
