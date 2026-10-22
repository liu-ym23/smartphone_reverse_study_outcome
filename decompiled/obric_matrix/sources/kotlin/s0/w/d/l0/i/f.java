package kotlin.s0.w.d.l0.i;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f20324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final OutputStream f20328e;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private f(OutputStream r2, byte[] r3) {
        this.f20327d = 0;
        this.f20328e = r2;
        this.f20324a = r3;
        this.f20326c = 0;
        this.f20325b = r3.length;
    }

    public static int A(int r0, long r1) {
        return D(r0) + B(r1);
    }

    public static int B(long r0) {
        return w(H(r0));
    }

    public static int C(String r2) {
        byte[] r3 = r2.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L5
        return v(r3.length) + r3.length;
    L5:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported.", e);
    }

    public static int D(int r1) {
        return v(z.c(r1, 0));
    }

    public static int E(int r0) {
        return v(r0);
    }

    public static int F(long r0) {
        return w(r0);
    }

    public static int G(int r1) {
        int r0 = r1 << 1;
        return (r1 >> 31) ^ r0;
    }

    public static long H(long r3) {
        long r0 = r3 << 1;
        return (r3 >> 63) ^ r0;
    }

    public static f J(OutputStream r1, int r2) {
        return new f(r1, new byte[r2]);
    }

    private void K() {
        OutputStream r0 = this.f20328e;
        if (r0 == null) goto L7;
        r0.write(this.f20324a, 0, this.f20326c);
        this.f20326c = 0;
        return;
    L7:
        throw new a();
    }

    public static int a(int r0, boolean r1) {
        return D(r0) + b(r1);
    }

    public static int b(boolean r0) {
        return 1;
    }

    public static int c(byte[] r1) {
        return v(r1.length) + r1.length;
    }

    public static int d(int r0, d r1) {
        return D(r0) + e(r1);
    }

    public static int e(d r1) {
        return v(r1.size()) + r1.size();
    }

    public static int f(int r0, double r1) {
        return D(r0) + g(r1);
    }

    public static int g(double r0) {
        return 8;
    }

    public static int h(int r0, int r1) {
        return D(r0) + i(r1);
    }

    public static int i(int r0) {
        return p(r0);
    }

    public static int j(int r0) {
        return 4;
    }

    public static int k(long r0) {
        return 8;
    }

    public static int l(int r0, float r1) {
        return D(r0) + m(r1);
    }

    public static int m(float r0) {
        return 4;
    }

    public static int n(q r0) {
        return r0.e();
    }

    public static int o(int r0, int r1) {
        return D(r0) + p(r1);
    }

    public static int p(int r0) {
        if (r0 >= 0) goto L4;
        return 10;
    L4:
        return v(r0);
    }

    public static int q(long r0) {
        return w(r0);
    }

    public static int r(m r1) {
        int r2 = r1.b();
        return v(r2) + r2;
    }

    public static int s(int r0, q r1) {
        return D(r0) + t(r1);
    }

    public static int t(q r1) {
        int r2 = r1.e();
        return v(r2) + r2;
    }

    static int u(int r1) {
        if (r1 <= 4096) goto L5;
        return 4096;
    L5:
        return r1;
    }

    public static int v(int r1) {
        if ((r1 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r1 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r1) != 0) goto L15;
        return 3;
    L15:
        if ((r1 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int w(long r4) {
        if (((-128) & r4) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r4) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r4) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r4) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r4) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r4) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r4) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r4) != 0) goto L35;
        return 8;
    L35:
        if ((r4 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public static int x(int r0) {
        return 4;
    }

    public static int y(long r0) {
        return 8;
    }

    public static int z(int r0) {
        return v(G(r0));
    }

    public void I() {
        if (this.f20328e == null) goto L6;
        K();
        return;
    }

    public void L(int r2, boolean r3) {
        w0(r2, 0);
        M(r3);
    }

    public void M(boolean r1) {
        h0(r1 ? 1 : 0);
    }

    public void N(byte[] r2) {
        o0(r2.length);
        k0(r2);
    }

    public void O(int r2, d r3) {
        w0(r2, 2);
        P(r3);
    }

    public void P(d r2) {
        o0(r2.size());
        i0(r2);
    }

    public void Q(int r2, double r3) {
        w0(r2, 1);
        R(r3);
    }

    public void R(double r1) {
        n0(Double.doubleToRawLongBits(r1));
    }

    public void S(int r2, int r3) {
        w0(r2, 0);
        T(r3);
    }

    public void T(int r1) {
        b0(r1);
    }

    public void U(int r1) {
        m0(r1);
    }

    public void V(long r1) {
        n0(r1);
    }

    public void W(int r2, float r3) {
        w0(r2, 5);
        X(r3);
    }

    public void X(float r1) {
        m0(Float.floatToRawIntBits(r1));
    }

    public void Y(int r2, q r3) {
        w0(r2, 3);
        Z(r3);
        w0(r2, 4);
    }

    public void Z(q r1) {
        r1.d(this);
    }

    public void a0(int r2, int r3) {
        w0(r2, 0);
        b0(r3);
    }

    public void b0(int r3) {
        if (r3 < 0) goto L4;
        o0(r3);
        return;
    L4:
        p0(r3);
    }

    public void c0(long r1) {
        p0(r1);
    }

    public void d0(int r2, q r3) {
        w0(r2, 2);
        e0(r3);
    }

    public void e0(q r2) {
        o0(r2.e());
        r2.d(this);
    }

    public void f0(int r4, q r5) {
        w0(1, 3);
        x0(2, r4);
        d0(3, r5);
        w0(1, 4);
    }

    public void g0(byte r4) {
        if (this.f20326c != this.f20325b) goto L5;
        K();
    L5:
        byte[] r0 = this.f20324a;
        int r1 = this.f20326c;
        this.f20326c = r1 + 1;
        r0[r1] = r4;
        this.f20327d++;
    }

    public void h0(int r1) {
        g0((byte) r1);
    }

    public void i0(d r3) {
        j0(r3, 0, r3.size());
    }

    public void j0(d r4, int r5, int r6) {
        int r0 = this.f20325b;
        int r1 = this.f20326c;
        if ((r0 - r1) < r6) goto L6;
        r4.m(this.f20324a, r5, r1, r6);
        this.f20326c += r6;
    L5:
        this.f20327d += r6;
        return;
    L6:
        int r2 = r0 - r1;
        r4.m(this.f20324a, r5, r1, r2);
        int r7 = r5 + r2;
        r6 = r6 - r2;
        this.f20326c = this.f20325b;
        this.f20327d += r2;
        K();
        if (r6 > this.f20325b) goto L9;
        r4.m(this.f20324a, r7, 0, r6);
        this.f20326c = r6;
        goto L5
    L9:
        r4.A(this.f20328e, r7, r6);
        goto L5
    }

    public void k0(byte[] r3) {
        l0(r3, 0, r3.length);
    }

    public void l0(byte[] r4, int r5, int r6) {
        int r0 = this.f20325b;
        int r1 = this.f20326c;
        if ((r0 - r1) < r6) goto L6;
        System.arraycopy(r4, r5, this.f20324a, r1, r6);
        this.f20326c += r6;
    L5:
        this.f20327d += r6;
        return;
    L6:
        int r2 = r0 - r1;
        System.arraycopy(r4, r5, this.f20324a, r1, r2);
        int r7 = r5 + r2;
        r6 = r6 - r2;
        this.f20326c = this.f20325b;
        this.f20327d += r2;
        K();
        if (r6 > this.f20325b) goto L9;
        System.arraycopy(r4, r7, this.f20324a, 0, r6);
        this.f20326c = r6;
        goto L5
    L9:
        this.f20328e.write(r4, r7, r6);
        goto L5
    }

    public void m0(int r2) {
        h0(r2 & 255);
        h0((r2 >> 8) & 255);
        h0((r2 >> 16) & 255);
        h0((r2 >> 24) & 255);
    }

    public void n0(long r3) {
        h0(((int) r3) & 255);
        h0(((int) (r3 >> 8)) & 255);
        h0(((int) (r3 >> 16)) & 255);
        h0(((int) (r3 >> 24)) & 255);
        h0(((int) (r3 >> 32)) & 255);
        h0(((int) (r3 >> 40)) & 255);
        h0(((int) (r3 >> 48)) & 255);
        h0(((int) (r3 >> 56)) & 255);
    }

    public void o0(int r2) {
    L3:
        if ((r2 & (-128)) == 0) goto L4;
        h0((r2 & 127) | 128);
        r2 = r2 >>> 7;
        goto L3
    L4:
        h0(r2);
    }

    public void p0(long r5) {
    L3:
        if (((-128) & r5) == 0) goto L4;
        h0((((int) r5) & 127) | 128);
        r5 = r5 >>> 7;
        goto L3
    L4:
        h0((int) r5);
    }

    public void q0(int r1) {
        m0(r1);
    }

    public void r0(long r1) {
        n0(r1);
    }

    public void s0(int r1) {
        o0(G(r1));
    }

    public void t0(int r2, long r3) {
        w0(r2, 0);
        u0(r3);
    }

    public void u0(long r1) {
        p0(H(r1));
    }

    public void v0(String r2) {
        byte[] r3 = r2.getBytes("UTF-8");
        o0(r3.length);
        k0(r3);
    }

    public void w0(int r1, int r2) {
        o0(z.c(r1, r2));
    }

    public void x0(int r2, int r3) {
        w0(r2, 0);
        y0(r3);
    }

    public void y0(int r1) {
        o0(r1);
    }

    public void z0(long r1) {
        p0(r1);
    }
}
