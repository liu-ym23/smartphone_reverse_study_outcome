package k;

import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s f18277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Deflater f18278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final i f18279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CRC32 f18281j;

    public m(x r4) {
        kotlin.n0.d.o.g(r4, "sink");
        s r0 = new s(r4);
        this.f18277f = r0;
        Deflater r5 = new Deflater(-1, true);
        this.f18278g = r5;
        this.f18279h = new i(r0, r5);
        this.f18281j = new CRC32();
        e r3 = r0.f18295f;
        r3.z0(8075);
        r3.s0(8);
        r3.s0(0);
        r3.v0(0);
        r3.s0(0);
        r3.s0(0);
    }

    private final void a(e r6, long r7) {
        u r8 = r6.f18255f;
        if (r8 != null) goto L5;
        kotlin.n0.d.o.p();
        throw null;
    L5:
        if (r7 <= 0) goto L11;
        int r1 = (int) Math.min(r7, r8.f18305c - r8.f18304b);
        this.f18281j.update(r8.f18303a, r8.f18304b, r1);
        r7 = r7 - ((long) r1);
        r8 = r8.f18308f;
        if (r8 != null) goto L5;
        kotlin.n0.d.o.p();
        throw null;
    }

    private final void b() {
        this.f18277f.u((int) this.f18281j.getValue());
        this.f18277f.u((int) this.f18278g.getBytesRead());
    }

    @Override // k.x
    public void J(e r3, long r4) {
        kotlin.n0.d.o.g(r3, "source");
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        if (r4 != 0) goto L9;
        return;
    L9:
        a(r3, r4);
        this.f18279h.J(r3, r4);
        return;
    L12:
        throw new IllegalArgumentException(("byteCount < 0: " + r4).toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18280i == false) goto L5;
        return;
    L5:
        Throwable th = null;
        this.f18279h.b();     // Catch: Throwable -> L8
        b();     // Catch: Throwable -> L8
    L25:
        this.f18278g.end();     // Catch: Throwable -> L11
    L23:
        this.f18277f.close();     // Catch: Throwable -> L16
    L19:
        this.f18280i = true;
        if (th != null) goto L22;
        return;
    L22:
        throw th;
    L16:
        th = move-exception;
        if (th != null) goto L19;
        th = th;
    L11:
        th = move-exception;
        if (th != null) goto L23;
        th = th;
    L8:
        th = th;
        goto L25
    }

    @Override // k.x
    public a0 e() {
        return this.f18277f.e();
    }

    @Override // k.x, java.io.Flushable
    public void flush() {
        this.f18279h.flush();
    }
}
