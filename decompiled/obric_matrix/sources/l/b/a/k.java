package l.b.a;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class k extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f21610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[][] f21611h;

    public k(InputStream r2) {
        this(r2, c2.c(r2));
    }

    public k(InputStream r2, int r3) {
        this(r2, r3, false);
    }

    public k(InputStream r1, int r2, boolean r3) {
        super(r1);
        this.f21609f = r2;
        this.f21610g = r3;
        this.f21611h = new byte[11][];
    }

    public k(byte[] r2) {
        this(new ByteArrayInputStream(r2), r2.length);
    }

    public k(byte[] r2, boolean r3) {
        this(new ByteArrayInputStream(r2), r2.length, r3);
    }

    static int A(InputStream r4, int r5, boolean r6) {
        int r0 = r4.read();
        if (r0 < 0) goto L32;
        if (r0 != 128) goto L9;
        return -1;
    L9:
        if (r0 <= 127) goto L30;
        int r1 = r0 & 127;
        if (r1 > 4) goto L29;
        int r2 = 0;
        int r3 = 0;
    L13:
        if (r3 >= r1) goto L19;
        int r7 = r4.read();
        if (r7 < 0) goto L18;
        r2 = (r2 << 8) + r7;
        r3 = r3 + 1;
        goto L13
    L18:
        throw new EOFException("EOF found reading length");
    L19:
        if (r2 < 0) goto L27;
        if (r2 < r5) goto L35;
        if (r6 == true) goto L35;
        throw new IOException("corrupted stream - out of bounds length found: " + r2 + " >= " + r5);
    L35:
        return r2;
    L27:
        throw new IOException("corrupted stream - negative length found");
    L29:
        throw new IOException("DER length more than 4 bytes: " + r1);
    L30:
        return r0;
    L32:
        throw new EOFException("EOF found when length expected");
    }

    static int E(InputStream r2, int r3) {
        int r4 = r3 & 31;
        if (r4 != 31) goto L16;
        int r5 = 0;
        int r0 = r2.read();
        if ((r0 & 127) == 0) goto L15;
    L6:
        if (r0 < 0) goto L10;
        if ((r0 & 128) == 0) goto L10;
        r5 = (r5 | (r0 & 127)) << 7;
        r0 = r2.read();
    L10:
        if (r0 < 0) goto L13;
        return r5 | (r0 & 127);
    L13:
        throw new EOFException("EOF found inside tag value.");
    L15:
        throw new IOException("corrupted stream - invalid high tag number found");
    L16:
        return r4;
    }

    static t b(int r1, v1 r2, byte[][] r3) {
        if (r1 == 10) goto L51;
        if (r1 == 12) goto L49;
        if (r1 == 30) goto L47;
        switch(r1) {
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L35;
            default: goto L9;
        };
    L9:
        switch(r1) {
            case 18: goto L33;
            case 19: goto L31;
            case 20: goto L29;
            case 21: goto L27;
            case 22: goto L25;
            case 23: goto L23;
            case 24: goto L21;
            case 25: goto L19;
            case 26: goto L17;
            case 27: goto L15;
            case 28: goto L13;
            default: goto L11;
        };
    L11:
        throw new IOException("unknown tag " + r1 + " encountered");
    L13:
        return new h1(r2.s());
    L15:
        return new s0(r2.s());
    L17:
        return new j1(r2.s());
    L19:
        return new u0(r2.s());
    L21:
        return new j(r2.s());
    L23:
        return new b0(r2.s());
    L25:
        return new v0(r2.s());
    L27:
        return new i1(r2.s());
    L29:
        return new e1(r2.s());
    L31:
        return new b1(r2.s());
    L33:
        return new x0(r2.s());
    L35:
        return o.y(l(r2, r3));
    L37:
        return w0.f21794f;
    L39:
        return new y0(r2.s());
    L41:
        return b.w(r2.g(), r2);
    L43:
        return new l(r2.s(), false);
    L45:
        return c.w(l(r2, r3));
    L47:
        return new o0(g(r2));
    L49:
        return new g1(r2.s());
    L51:
        return g.w(l(r2, r3));
    }

    private static char[] g(v1 r10) {
        int r0 = r10.g();
        if ((r0 & 1) != 0) goto L28;
        int r1 = r0 / 2;
        char[] r2 = new char[r1];
        byte[] r4 = new byte[8];
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r0 < 8) goto L12;
        if (l.b.h.i.a.d(r10, r4, 0, 8) != 8) goto L11;
        r2[r6] = (char) ((r4[0] << 8) | (r4[1] & 255));
        r2[r6 + 1] = (char) ((r4[2] << 8) | (r4[3] & 255));
        r2[r6 + 2] = (char) ((r4[4] << 8) | (r4[5] & 255));
        r2[r6 + 3] = (char) ((r4[6] << 8) | (r4[7] & 255));
        r6 = r6 + 4;
        r0 = r0 - 8;
        goto L6
    L11:
        throw new EOFException("EOF encountered in middle of BMPString");
    L12:
        if (r0 <= 0) goto L22;
        if (l.b.h.i.a.d(r10, r4, 0, r0) != r0) goto L20;
    L15:
        int r7 = r5 + 1;
        int r8 = r7 + 1;
        int r9 = r6 + 1;
        r2[r6] = (char) ((r4[r5] << 8) | (r4[r7] & 255));
        if (r8 >= r0) goto L17;
        r5 = r8;
        r6 = r9;
        goto L15
    L17:
        r6 = r9;
        goto L22
    L20:
        throw new EOFException("EOF encountered in middle of BMPString");
    L22:
        if (r10.g() != 0) goto L26;
        if (r1 != r6) goto L26;
        return r2;
    L26:
        throw new IllegalStateException();
    L28:
        throw new IOException("malformed BMPString encoding encountered");
    }

    private static byte[] l(v1 r2, byte[][] r3) {
        int r0 = r2.g();
        if (r0 >= r3.length) goto L5;
        byte[] r1 = r3[r0];
        if (r1 != null) goto L9;
        r1 = new byte[r0];
        r3[r0] = r1;
    L9:
        r2.l(r1);
        return r1;
    L5:
        return r2.s();
    }

    public t C() {
        int r0 = read();
        if (r0 > 0) goto L9;
        if (r0 == 0) goto L8;
        return null;
    L8:
        throw new IOException("unexpected end-of-contents marker");
    L9:
        int r1 = E(this, r0);
        if ((r0 & 32) == 0) goto L12;
        boolean r2 = true;
    L13:
        int r4 = x();
        if (r4 >= 0) goto L49;
        if (r2 == false) goto L43;
        y r5 = new y(new x1(this, this.f21609f), this.f21609f);
        if ((r0 & 64) == 0) goto L21;
        return new d0(r1, r5).d();
    L21:
        if ((r0 & 128) == 0) goto L25;
        return new m0(true, r1, r5).d();
    L25:
        if (r1 == 4) goto L41;
        if (r1 == 8) goto L39;
        if (r1 == 16) goto L37;
        if (r1 != 17) goto L35;
        return new k0(r5).d();
    L35:
        throw new IOException("unknown BER object encountered");
    L37:
        return new i0(r5).d();
    L39:
        return new r0(r5).d();
    L41:
        return new g0(r5).d();
    L43:
        throw new IOException("indefinite-length primitive encoding encountered");
    L49:
        return a(r0, r1, r4);
    L46:
        e = move-exception;
        throw new h("corrupted stream detected", e);
    L12:
        r2 = false;
        goto L13
    }

    f F(v1 r2) {
        if (r2.g() < 1) goto L5;
        k r1 = new k(r2);
        f r3 = new f();
    L7:
        t r0 = r1.C();
        if (r0 == null) goto L10;
        r3.a(r0);
        goto L7
    L10:
        return r3;
    L5:
        return new f(0);
    }

    protected t a(int r5, int r6, int r7) {
        int r1 = 0;
        if ((r5 & 32) == 0) goto L5;
        boolean r0 = true;
    L6:
        v1 r2 = new v1(this, r7, this.f21609f);
        if ((r5 & 64) == 0) goto L11;
        return new k1(r0, r6, r2.s());
    L11:
        if ((r5 & 128) != 0) goto L13;
        if (r0 == false) goto L45;
        if (r6 != 4) goto L18;
        f r4 = F(r2);
        int r8 = r4.f();
        p[] r9 = new p[r8];
    L36:
        if (r1 == r8) goto L43;
        e r10 = r4.d(r1);
        if ((r10 instanceof p) == false) goto L41;
        r9[r1] = (p) r10;
        r1 = r1 + 1;
        goto L36
    L41:
        throw new h("unknown object encountered in constructed OCTET STRING: " + r10.getClass());
    L43:
        return new f0(r9);
    L18:
        if (r6 == 8) goto L34;
        if (r6 == 16) goto L28;
        if (r6 != 17) goto L26;
        return n1.b(F(r2));
    L26:
        throw new IOException("unknown tag " + r6 + " encountered");
    L28:
        if (this.f21610g == false) goto L32;
        return new z1(r2.s());
    L32:
        return n1.a(F(r2));
    L34:
        return new m1(F(r2));
    L45:
        return b(r6, r2, this.f21611h);
    L13:
        return new y(r2).c(r0, r6);
    L5:
        r0 = false;
        goto L6
    }

    int s() {
        return this.f21609f;
    }

    protected int x() {
        return A(this, this.f21609f, false);
    }
}
