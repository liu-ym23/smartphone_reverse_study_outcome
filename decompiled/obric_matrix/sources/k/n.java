package k;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte f18282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t f18283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Inflater f18284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final o f18285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CRC32 f18286j;

    public n(z r3) {
        kotlin.n0.d.o.g(r3, "source");
        t r0 = new t(r3);
        this.f18283g = r0;
        Inflater r4 = new Inflater(true);
        this.f18284h = r4;
        this.f18285i = new o(r0, r4);
        this.f18286j = new CRC32();
    }

    private final void a(String r3, int r4, int r5) {
        if (r5 != r4) goto L4;
        return;
    L4:
        String r2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r3, Integer.valueOf(r5), Integer.valueOf(r4)}, 3));
        kotlin.n0.d.o.b(r2, "java.lang.String.format(this, *args)");
        throw new IOException(r2);
    }

    private final void b() {
        this.f18283g.b0(10);
        byte r7 = this.f18283g.f18299f.O(3);
        boolean r8 = true;
        if (((r7 >> 1) & 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        l(this.f18283g.f18299f, 0, 10);
    L8:
        a("ID1ID2", 8075, this.f18283g.readShort());
        this.f18283g.skip(8);
        if (((r7 >> 2) & 1) != 1) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L21;
        this.f18283g.b0(2);
        if (r10 == false) goto L16;
        l(this.f18283g.f18299f, 0, 2);
    L16:
        long r11 = this.f18283g.f18299f.g0();
        this.f18283g.b0(r11);
        if (r10 == false) goto L19;
        l(this.f18283g.f18299f, 0, r11);
    L19:
        this.f18283g.skip(r11);
    L21:
        if (((r7 >> 3) & 1) != 1) goto L23;
        boolean r1 = true;
    L25:
        if (r1 == false) goto L34;
        long r15 = this.f18283g.a((byte) 0);
        if (r15 == (-1)) goto L32;
        if (r10 == false) goto L30;
        l(this.f18283g.f18299f, 0, r15 + 1);
    L30:
        this.f18283g.skip(r15 + 1);
        goto L34
    L32:
        throw new EOFException();
    L34:
        if (((r7 >> 4) & 1) == 1) goto L37;
        r8 = false;
    L37:
        if (r8 == false) goto L45;
        long r9 = this.f18283g.a((byte) 0);
        if (r9 == (-1)) goto L44;
        if (r10 == false) goto L42;
        l(this.f18283g.f18299f, 0, r9 + 1);
    L42:
        this.f18283g.skip(r9 + 1);
        goto L45
    L44:
        throw new EOFException();
    L45:
        if (r10 == false) goto L48;
        a("FHCRC", this.f18283g.l(), (short) this.f18286j.getValue());
        this.f18286j.reset();
        return;
    L48:
        return;
    L23:
        r1 = false;
        goto L25
    L11:
        r0 = false;
        goto L12
    L5:
        r10 = false;
        goto L6
    }

    private final void g() {
        a("CRC", this.f18283g.R(), (int) this.f18286j.getValue());
        a("ISIZE", this.f18283g.R(), (int) this.f18284h.getBytesWritten());
    }

    private final void l(e r6, long r7, long r9) {
        u r8 = r6.f18255f;
        if (r8 == null) goto L20;
    L4:
        int r1 = r8.f18305c;
        int r2 = r8.f18304b;
        if (r7 < (r1 - r2)) goto L13;
        r7 = r7 - ((long) (r1 - r2));
        r8 = r8.f18308f;
        if (r8 != null) goto L4;
        kotlin.n0.d.o.p();
        throw null;
    L13:
        if (r9 <= 0) goto L19;
        int r10 = (int) (((long) r8.f18304b) + r7);
        int r11 = (int) Math.min(r8.f18305c - r10, r9);
        this.f18286j.update(r8.f18303a, r10, r11);
        r9 = r9 - ((long) r11);
        r8 = r8.f18308f;
        if (r8 == null) goto L17;
        r7 = 0;
        goto L13
    L17:
        kotlin.n0.d.o.p();
        throw null;
    L19:
        return;
    L20:
        kotlin.n0.d.o.p();
        throw null;
    }

    @Override // k.z
    public long Z(e r12, long r13) {
        kotlin.n0.d.o.g(r12, "sink");
        if (r13 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L28;
        if (r13 != 0) goto L10;
        return 0;
    L10:
        if (this.f18282f != 0) goto L13;
        b();
        this.f18282f = 1;
    L13:
        if (this.f18282f != 1) goto L20;
        long r7 = r12.k0();
        long r14 = this.f18285i.Z(r12, r13);
        if (r14 == (-1)) goto L18;
        l(r12, r7, r14);
        return r14;
    L18:
        this.f18282f = 2;
    L20:
        if (this.f18282f != 2) goto L26;
        g();
        this.f18282f = 3;
        if (this.f18283g.v() == true) goto L26;
        throw new IOException("gzip finished without exhausting source");
    L26:
        return -1;
    L28:
        throw new IllegalArgumentException(("byteCount < 0: " + r13).toString());
    L5:
        r4 = false;
        goto L6
    }

    @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18285i.close();
    }

    @Override // k.z
    public a0 e() {
        return this.f18283g.e();
    }
}
