package k;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f18272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Deflater f18273h;

    public i(f r2, Deflater r3) {
        kotlin.n0.d.o.g(r2, "sink");
        kotlin.n0.d.o.g(r3, "deflater");
        this.f18272g = r2;
        this.f18273h = r3;
    }

    @IgnoreJRERequirement
    private final void a(boolean r8) {
        e r0 = this.f18272g.d();
    L3:
        u r1 = r0.n0(1);
        Deflater r2 = this.f18273h;
        byte[] r3 = r1.f18303a;
        int r4 = r1.f18305c;
        int r5 = 8192 - r4;
        if (r8 == false) goto L6;
        int r6 = r2.deflate(r3, r4, r5, 2);
    L7:
        if (r6 > 0) goto L8;
        if (this.f18273h.needsInput() == false) goto L3;
        if (r1.f18304b != r1.f18305c) goto L21;
        r0.f18255f = r1.b();
        v.f18312c.a(r1);
        return;
    L21:
        return;
    L8:
        r1.f18305c += r6;
        r0.j0(r0.k0() + ((long) r6));
        this.f18272g.z();
        goto L3
    L6:
        r6 = r2.deflate(r3, r4, r5);
        goto L7
    }

    @Override // k.x
    public void J(e r8, long r9) {
        kotlin.n0.d.o.g(r8, "source");
        c.b(r8.k0(), 0, r9);
    L4:
        if (r9 <= 0) goto L13;
        u r0 = r8.f18255f;
        if (r0 == null) goto L11;
        int r1 = (int) Math.min(r9, r0.f18305c - r0.f18304b);
        this.f18273h.setInput(r0.f18303a, r0.f18304b, r1);
        a(false);
        long r4 = r1;
        r8.j0(r8.k0() - r4);
        int r2 = r0.f18304b + r1;
        r0.f18304b = r2;
        if (r2 != r0.f18305c) goto L10;
        r8.f18255f = r0.b();
        v.f18312c.a(r0);
    L10:
        r9 = r9 - r4;
        goto L4
    L11:
        kotlin.n0.d.o.p();
        throw null;
    }

    public final void b() {
        this.f18273h.finish();
        a(false);
    }

    @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18271f == false) goto L5;
        return;
    L5:
        Throwable th = null;
        b();     // Catch: Throwable -> L8
    L23:
        this.f18273h.end();     // Catch: Throwable -> L11
    L27:
        this.f18272g.close();     // Catch: Throwable -> L16
    L19:
        this.f18271f = true;
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
        if (th != null) goto L27;
        th = th;
    L8:
        th = th;
        goto L23
    }

    @Override // k.x
    public a0 e() {
        return this.f18272g.e();
    }

    @Override // k.x, java.io.Flushable
    public void flush() {
        a(true);
        this.f18272g.flush();
    }

    public String toString() {
        return "DeflaterSink(" + this.f18272g + ')';
    }
}
