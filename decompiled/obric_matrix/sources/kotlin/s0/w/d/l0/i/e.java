package kotlin.s0.w.d.l0.i;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f20312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f20315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f20316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f20317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20319h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20320i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20321j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20322k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20323l;
    private int m;
    private a n;

    private interface a {
        void a();
    }

    private e(InputStream r3) {
        this.f20319h = false;
        this.f20321j = Integer.MAX_VALUE;
        this.f20323l = 64;
        this.m = 67108864;
        this.n = null;
        this.f20312a = new byte[4096];
        this.f20314c = 0;
        this.f20316e = 0;
        this.f20320i = 0;
        this.f20317f = r3;
        this.f20313b = false;
    }

    private e(p r3) {
        this.f20319h = false;
        this.f20321j = Integer.MAX_VALUE;
        this.f20323l = 64;
        this.m = 67108864;
        this.n = null;
        this.f20312a = r3.f20369g;
        int r1 = r3.E();
        this.f20316e = r1;
        this.f20314c = r1 + r3.size();
        this.f20320i = -this.f20316e;
        this.f20317f = null;
        this.f20313b = true;
    }

    public static int B(int r3, InputStream r4) {
        if ((r3 & 128) != 0) goto L5;
        return r3;
    L5:
        int r5 = r3 & 127;
        int r0 = 7;
    L7:
        if (r0 >= 32) goto L17;
        int r1 = r4.read();
        if (r1 == (-1)) goto L15;
        r5 = r5 | ((r1 & 127) << r0);
        if ((r1 & 128) == 0) goto L12;
        r0 = r0 + 7;
        goto L7
    L12:
        return r5;
    L15:
        throw k.k();
    L17:
        if (r0 >= 64) goto L27;
        int r2 = r4.read();
        if (r2 == (-1)) goto L25;
        if ((r2 & 128) == 0) goto L22;
        r0 = r0 + 7;
        goto L17
    L22:
        return r5;
    L25:
        throw k.k();
    L27:
        throw k.f();
    }

    private void N() {
        int r0 = this.f20314c + this.f20315d;
        this.f20314c = r0;
        int r1 = this.f20320i + r0;
        int r2 = this.f20321j;
        if (r1 <= r2) goto L5;
        int r3 = r1 - r2;
        this.f20315d = r3;
        this.f20314c = r0 - r3;
        return;
    L5:
        this.f20315d = 0;
    }

    private void O(int r1) {
        if (T(r1) == false) goto L6;
        return;
    L6:
        throw k.k();
    }

    private void S(int r5) {
        if (r5 < 0) goto L14;
        int r0 = this.f20320i;
        int r1 = this.f20316e;
        int r2 = (r0 + r1) + r5;
        int r3 = this.f20321j;
        if (r2 > r3) goto L11;
        int r4 = this.f20314c;
        int r6 = r4 - r1;
        this.f20316e = r4;
    L6:
        O(1);
        int r7 = r5 - r6;
        int r8 = this.f20314c;
        if (r7 <= r8) goto L9;
        r6 = r6 + r8;
        this.f20316e = r8;
        goto L6
    L9:
        this.f20316e = r7;
        return;
    L11:
        R((r3 - r0) - r1);
        throw k.k();
    L14:
        throw k.g();
    }

    private boolean T(int r6) {
        int r0 = this.f20316e;
        if ((r0 + r6) > this.f20314c) goto L5;
        StringBuilder r1 = new StringBuilder(77);
        r1.append("refillBuffer() called when ");
        r1.append(r6);
        r1.append(" bytes were already available in buffer");
        throw new IllegalStateException(r1.toString());
    L5:
        if (((this.f20320i + r0) + r6) <= this.f20321j) goto L7;
        return false;
    L7:
        a r2 = this.n;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        if (this.f20317f == null) goto L36;
        int r3 = this.f20316e;
        if (r3 <= 0) goto L18;
        int r4 = this.f20314c;
        if (r4 <= r3) goto L17;
        byte[] r5 = this.f20312a;
        System.arraycopy(r5, r3, r5, 0, r4 - r3);
    L17:
        this.f20320i += r3;
        this.f20314c -= r3;
        this.f20316e = 0;
    L18:
        InputStream r7 = this.f20317f;
        byte[] r8 = this.f20312a;
        int r9 = this.f20314c;
        int r10 = r7.read(r8, r9, r8.length - r9);
        if (r10 != 0) goto L21;
    L34:
        StringBuilder r11 = new StringBuilder(102);
        r11.append("InputStream#read(byte[]) returned invalid result: ");
        r11.append(r10);
        r11.append("\nThe InputStream implementation is buggy.");
        throw new IllegalStateException(r11.toString());
    L21:
        if (r10 < (-1)) goto L34;
        if (r10 > this.f20312a.length) goto L34;
        if (r10 <= 0) goto L36;
        this.f20314c += r10;
        if (((this.f20320i + r6) - this.m) > 0) goto L33;
        N();
        if (this.f20314c < r6) goto L31;
        return true;
    L31:
        return T(r6);
    L33:
        throw k.j();
    L36:
        return false;
    }

    public static int b(int r1) {
        int r0 = r1 >>> 1;
        return (-(r1 & 1)) ^ r0;
    }

    public static long c(long r4) {
        long r0 = r4 >>> 1;
        return (-(r4 & 1)) ^ r0;
    }

    private void d(int r3) {
        if ((this.f20314c - this.f20316e) >= r3) goto L6;
        O(r3);
        return;
    }

    public static e g(InputStream r1) {
        return new e(r1);
    }

    static e h(p r1) {
        e r0 = new e(r1);
        r0.j(r1.size());     // Catch: k -> L5
        return r0;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private byte[] x(int r13) {
        if (r13 > 0) goto L8;
        if (r13 != 0) goto L7;
        return j.f20358a;
    L7:
        throw k.g();
    L8:
        int r0 = this.f20320i;
        int r1 = this.f20316e;
        int r2 = (r0 + r1) + r13;
        int r3 = this.f20321j;
        if (r2 <= r3) goto L11;
        R((r3 - r0) - r1);
        throw k.k();
    L11:
        if (r13 >= 4096) goto L14;
        byte[] r4 = new byte[r13];
        int r5 = this.f20314c - r1;
        System.arraycopy(this.f20312a, r1, r4, 0, r5);
        this.f20316e = this.f20314c;
        int r14 = r13 - r5;
        d(r14);
        System.arraycopy(this.f20312a, 0, r4, r5, r14);
        this.f20316e = r14;
        return r4;
    L14:
        int r6 = this.f20314c;
        this.f20320i = r0 + r6;
        this.f20316e = 0;
        this.f20314c = 0;
        int r7 = r6 - r1;
        int r8 = r13 - r7;
        ArrayList r9 = new ArrayList();
    L15:
        if (r8 <= 0) goto L27;
        int r10 = Math.min(r8, 4096);
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L17:
        if (r12 >= r10) goto L26;
        InputStream r15 = this.f20317f;
        if (r15 != null) goto L21;
        int r16 = -1;
    L22:
        if (r16 == (-1)) goto L25;
        this.f20320i += r16;
        r12 = r12 + r16;
        goto L17
    L25:
        throw k.k();
    L21:
        r16 = r15.read(r11, r12, r10 - r12);
        goto L22
    L26:
        r8 = r8 - r10;
        r9.add(r11);
        goto L15
    L27:
        byte[] r17 = new byte[r13];
        System.arraycopy(this.f20312a, r1, r17, 0, r7);
        Iterator r18 = r9.iterator();
    L29:
        if (r18.hasNext() == false) goto L31;
        byte[] r19 = (byte[]) r18.next();
        System.arraycopy(r19, 0, r17, r7, r19.length);
        r7 = r7 + r19.length;
        goto L29
    L31:
        return r17;
    }

    public int A() {
        int r0 = this.f20316e;
        int r1 = this.f20314c;
        if (r1 == r0) goto L36;
        byte[] r2 = this.f20312a;
        int r3 = r0 + 1;
        byte r4 = r2[r0];
        if (r4 < 0) goto L10;
        this.f20316e = r3;
        return r4;
    L10:
        if ((r1 - r3) < 9) goto L36;
        int r5 = r3 + 1;
        int r6 = r4 ^ (r2[r3] << 7);
        long r7 = r6;
        if (r7 >= 0) goto L16;
        long r8 = -128;
    L15:
        int r9 = (int) (r7 ^ r8);
    L37:
        this.f20316e = r5;
        return r9;
    L16:
        int r10 = r5 + 1;
        int r11 = r6 ^ (r2[r5] << 14);
        long r12 = r11;
        if (r12 < 0) goto L20;
        r9 = (int) (16256 ^ r12);
    L19:
        r5 = r10;
        goto L37
    L20:
        r5 = r10 + 1;
        int r13 = r11 ^ (r2[r10] << 21);
        r7 = r13;
        if (r7 >= 0) goto L23;
        r8 = -2080896;
        goto L15
    L23:
        r10 = r5 + 1;
        byte r14 = r2[r5];
        r9 = (int) (((long) (r13 ^ (r14 << 28))) ^ 266354560);
        if (r14 >= 0) goto L19;
        r5 = r10 + 1;
        if (r2[r10] >= 0) goto L37;
        r10 = r5 + 1;
        if (r2[r5] >= 0) goto L19;
        r5 = r10 + 1;
        if (r2[r10] >= 0) goto L37;
        r10 = r5 + 1;
        if (r2[r5] >= 0) goto L19;
        r5 = r10 + 1;
        if (r2[r10] >= 0) goto L37;
    L36:
        return (int) D();
    }

    public long C() {
        int r0 = this.f20316e;
        int r1 = this.f20314c;
        if (r1 == r0) goto L40;
        byte[] r2 = this.f20312a;
        int r3 = r0 + 1;
        byte r4 = r2[r0];
        if (r4 < 0) goto L10;
        this.f20316e = r3;
        return r4;
    L10:
        if ((r1 - r3) < 9) goto L40;
        int r5 = r3 + 1;
        long r6 = r4 ^ (r2[r3] << 7);
        if (r6 >= 0) goto L16;
        long r7 = -128;
    L15:
        long r8 = r6 ^ r7;
    L43:
        this.f20316e = r5;
        return r8;
    L16:
        int r9 = r5 + 1;
        long r10 = r6 ^ ((long) (r2[r5] << 14));
        if (r10 < 0) goto L20;
        long r11 = 16256;
    L19:
        r8 = r10 ^ r11;
        r5 = r9;
        goto L43
    L20:
        r5 = r9 + 1;
        r6 = r10 ^ ((long) (r2[r9] << 21));
        if (r6 >= 0) goto L23;
        r7 = -2080896;
        goto L15
    L23:
        r9 = r5 + 1;
        r10 = r6 ^ (((long) r2[r5]) << 28);
        if (r10 < 0) goto L26;
        r11 = 266354560;
        goto L19
    L26:
        r5 = r9 + 1;
        r6 = r10 ^ (((long) r2[r9]) << 35);
        if (r6 >= 0) goto L29;
        r7 = -34093383808L;
        goto L15
    L29:
        r9 = r5 + 1;
        r10 = r6 ^ (((long) r2[r5]) << 42);
        if (r10 < 0) goto L32;
        r11 = 4363953127296L;
        goto L19
    L32:
        r5 = r9 + 1;
        r6 = r10 ^ (((long) r2[r9]) << 49);
        if (r6 >= 0) goto L35;
        r7 = -558586000294016L;
        goto L15
    L35:
        int r12 = r5 + 1;
        long r13 = (r6 ^ (((long) r2[r5]) << 56)) ^ 71499008037633920L;
        if (r13 >= 0) goto L41;
        r5 = r12 + 1;
        if (r2[r12] < 0) goto L40;
    L42:
        r8 = r13;
        goto L43
    L41:
        r5 = r12;
    L40:
        return D();
    }

    long D() {
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= 64) goto L10;
        byte r3 = w();
        r0 = r0 | (((long) (r3 & 127)) << r2);
        if ((r3 & 128) == 0) goto L7;
        r2 = r2 + 7;
        goto L4
    L7:
        return r0;
    L10:
        throw k.f();
    }

    public int E() {
        return y();
    }

    public long F() {
        return z();
    }

    public int G() {
        return b(A());
    }

    public long H() {
        return c(C());
    }

    public String I() {
        int r0 = A();
        if (r0 > (this.f20314c - this.f20316e)) goto L7;
        if (r0 <= 0) goto L7;
        String r1 = new String(this.f20312a, this.f20316e, r0, "UTF-8");
        this.f20316e += r0;
        return r1;
    L7:
        if (r0 != 0) goto L11;
        return "";
    L11:
        return new String(x(r0), "UTF-8");
    }

    public String J() {
        int r0 = A();
        int r1 = this.f20316e;
        if (r0 > (this.f20314c - r1)) goto L6;
        if (r0 <= 0) goto L6;
        byte[] r2 = this.f20312a;
        this.f20316e = r1 + r0;
    L11:
        if (y.f(r2, r1, r1 + r0) == false) goto L15;
        return new String(r2, r1, r0, "UTF-8");
    L15:
        throw k.d();
    L6:
        if (r0 != 0) goto L9;
        return "";
    L9:
        r2 = x(r0);
        r1 = 0;
        goto L11
    }

    public int K() {
        if (f() == false) goto L6;
        this.f20318g = 0;
        return 0;
    L6:
        int r0 = A();
        this.f20318g = r0;
        if (z.a(r0) == 0) goto L11;
        return this.f20318g;
    L11:
        throw k.c();
    }

    public int L() {
        return A();
    }

    public long M() {
        return C();
    }

    public boolean P(int r5, f r6) {
        int r0 = z.b(r5);
        if (r0 == 0) goto L24;
        if (r0 != 1) goto L6;
        long r2 = z();
        r6.o0(r5);
        r6.V(r2);
        return true;
    L6:
        if (r0 != 2) goto L8;
        d r4 = l();
        r6.o0(r5);
        r6.P(r4);
        return true;
    L8:
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L11;
        return false;
    L11:
        if (r0 != 5) goto L15;
        int r7 = y();
        r6.o0(r5);
        r6.U(r7);
        return true;
    L15:
        throw k.e();
    L18:
        r6.o0(r5);
        Q(r6);
        int r8 = z.c(z.a(r5), 4);
        a(r8);
        r6.o0(r8);
        return true;
    L24:
        long r3 = t();
        r6.o0(r5);
        r6.z0(r3);
        return true;
    }

    public void Q(f r2) {
    L2:
        int r0 = K();
        if (r0 == 0) goto L6;
        if (P(r0, r2) == true) goto L2;
        return;
    }

    public void R(int r3) {
        int r0 = this.f20314c;
        int r1 = this.f20316e;
        if (r3 > (r0 - r1)) goto L6;
        if (r3 < 0) goto L6;
        this.f20316e = r1 + r3;
        return;
    L6:
        S(r3);
    }

    public void a(int r1) {
        if (this.f20318g != r1) goto L6;
        return;
    L6:
        throw k.b();
    }

    public int e() {
        int r0 = this.f20321j;
        if (r0 != Integer.MAX_VALUE) goto L7;
        return -1;
    L7:
        return r0 - (this.f20320i + this.f20316e);
    }

    public boolean f() {
        if (this.f20316e == this.f20314c) goto L5;
    L7:
        return false;
    L5:
        if (T(1) == true) goto L7;
        return true;
    }

    public void i(int r1) {
        this.f20321j = r1;
        N();
    }

    public int j(int r3) {
        if (r3 < 0) goto L10;
        int r4 = r3 + (this.f20320i + this.f20316e);
        int r0 = this.f20321j;
        if (r4 > r0) goto L8;
        this.f20321j = r4;
        N();
        return r0;
    L8:
        throw k.k();
    L10:
        throw k.g();
    }

    public boolean k() {
        if (C() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public d l() {
        int r0 = A();
        int r1 = this.f20314c;
        int r2 = this.f20316e;
        if (r0 > (r1 - r2)) goto L13;
        if (r0 <= 0) goto L13;
        if (this.f20313b == true) goto L8;
    L10:
        d r3 = d.g(this.f20312a, r2, r0);
    L11:
        this.f20316e += r0;
        return r3;
    L8:
        if (this.f20319h == false) goto L10;
        r3 = new c(this.f20312a, this.f20316e, r0);
    L13:
        if (r0 != 0) goto L17;
        return d.f20305f;
    L17:
        return new p(x(r0));
    }

    public double m() {
        return Double.longBitsToDouble(z());
    }

    public int n() {
        return A();
    }

    public int o() {
        return y();
    }

    public long p() {
        return z();
    }

    public float q() {
        return Float.intBitsToFloat(y());
    }

    public void r(int r3, q.a r4, g r5) {
        int r0 = this.f20322k;
        if (r0 >= this.f20323l) goto L7;
        this.f20322k = r0 + 1;
        r4.x(this, r5);
        a(z.c(r3, 4));
        this.f20322k--;
        return;
    L7:
        throw k.h();
    }

    public int s() {
        return A();
    }

    public long t() {
        return C();
    }

    public <T extends q> T u(s<T> r4, g r5) {
        int r0 = A();
        if (this.f20322k >= this.f20323l) goto L7;
        int r1 = j(r0);
        this.f20322k++;
        T r6 = r4.b(this, r5);
        a(0);
        this.f20322k--;
        i(r1);
        return r6;
    L7:
        throw k.h();
    }

    public void v(q.a r4, g r5) {
        int r0 = A();
        if (this.f20322k >= this.f20323l) goto L7;
        int r1 = j(r0);
        this.f20322k++;
        r4.x(this, r5);
        a(0);
        this.f20322k--;
        i(r1);
        return;
    L7:
        throw k.h();
    }

    public byte w() {
        if (this.f20316e != this.f20314c) goto L5;
        O(1);
    L5:
        byte[] r0 = this.f20312a;
        int r1 = this.f20316e;
        this.f20316e = r1 + 1;
        return r0[r1];
    }

    public int y() {
        int r0 = this.f20316e;
        if ((this.f20314c - r0) >= 4) goto L5;
        O(4);
        r0 = this.f20316e;
    L5:
        byte[] r1 = this.f20312a;
        this.f20316e = r0 + 4;
        return (((r1[r0] & 255) | ((r1[r0 + 1] & 255) << 8)) | ((r1[r0 + 2] & 255) << 16)) | ((r1[r0 + 3] & 255) << 24);
    }

    public long z() {
        int r0 = this.f20316e;
        if ((this.f20314c - r0) >= 8) goto L5;
        O(8);
        r0 = this.f20316e;
    L5:
        byte[] r1 = this.f20312a;
        this.f20316e = r0 + 8;
        long r2 = ((((((((long) r1[r0]) & 255) | ((((long) r1[r0 + 1]) & 255) << 8)) | ((((long) r1[r0 + 2]) & 255) << 16)) | ((((long) r1[r0 + 3]) & 255) << 24)) | ((((long) r1[r0 + 4]) & 255) << 32)) | ((((long) r1[r0 + 5]) & 255) << 40)) | ((((long) r1[r0 + 6]) & 255) << 48);
        return ((((long) r1[r0 + 7]) & 255) << 56) | r2;
    }
}
