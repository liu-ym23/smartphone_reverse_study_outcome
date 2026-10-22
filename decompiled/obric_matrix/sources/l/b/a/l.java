package l.b.a;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class l extends t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21616g;

    public l(long r1) {
        this.f21615f = BigInteger.valueOf(r1).toByteArray();
        this.f21616g = 0;
    }

    public l(BigInteger r1) {
        this.f21615f = r1.toByteArray();
        this.f21616g = 0;
    }

    public l(byte[] r2) {
        this(r2, true);
    }

    l(byte[] r2, boolean r3) {
        if (C(r2) == true) goto L10;
        if (r3 == false) goto L6;
        byte[] r4 = l.b.h.a.d(r2);
    L7:
        this.f21615f = r4;
        this.f21616g = F(r2);
        return;
    L6:
        r4 = r2;
        goto L7
    L10:
        throw new IllegalArgumentException("malformed integer");
    }

    static int A(byte[] r2, int r3, int r4) {
        int r0 = r2.length;
        int r5 = Math.max(r3, r0 - 4);
        int r6 = r4 & r2[r5];
    L3:
        r5 = r5 + 1;
        if (r5 >= r0) goto L6;
        r6 = (r6 << 8) | (r2[r5] & 255);
        goto L3
    L6:
        return r6;
    }

    static boolean C(byte[] r3) {
        int r0 = r3.length;
        if (r0 != 0) goto L5;
        return true;
    L5:
        if (r0 != 1) goto L7;
        return false;
    L7:
        if (r3[0] != (r3[1] >> 7)) goto L12;
        if (l.b.h.f.b("org.bouncycastle.asn1.allow_unsafe_integer") == true) goto L12;
        return true;
    L12:
        return false;
    }

    static long D(byte[] r5, int r6, int r7) {
        int r0 = r5.length;
        int r8 = Math.max(r6, r0 - 8);
        long r1 = r7 & r5[r8];
    L3:
        r8 = r8 + 1;
        if (r8 >= r0) goto L6;
        r1 = (r1 << 8) | ((long) (r5[r8] & 255));
        goto L3
    L6:
        return r1;
    }

    static int F(byte[] r5) {
        int r0 = r5.length - 1;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L7;
        int r3 = r1 + 1;
        if (r5[r1] != (r5[r3] >> 7)) goto L7;
        r1 = r3;
    L7:
        return r1;
    }

    public static l w(Object r3) {
        if (r3 == null) goto L16;
        if ((r3 instanceof l) == true) goto L16;
        if ((r3 instanceof byte[]) == false) goto L14;
        return (l) t.s((byte[]) r3);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: " + r3.getClass().getName());
    L16:
        return (l) r3;
    }

    public static l x(a0 r0, boolean r1) {
        t r2 = r0.x();
        if (r1 == true) goto L10;
        if ((r2 instanceof l) == true) goto L10;
        return new l(p.w(r2).y());
    L10:
        return w(r2);
    }

    public int B() {
        byte[] r0 = this.f21615f;
        int r1 = r0.length;
        int r3 = this.f21616g;
        if ((r1 - r3) > 4) goto L7;
        return A(r0, r3, -1);
    L7:
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public long E() {
        byte[] r0 = this.f21615f;
        int r1 = r0.length;
        int r3 = this.f21616g;
        if ((r1 - r3) > 8) goto L7;
        return D(r0, r3, -1);
    L7:
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    @Override // l.b.a.n
    public int hashCode() {
        return l.b.h.a.j(this.f21615f);
    }

    @Override // l.b.a.t
    boolean n(t r2) {
        if ((r2 instanceof l) == true) goto L7;
        return false;
    L7:
        return l.b.h.a.a(this.f21615f, ((l) r2).f21615f);
    }

    @Override // l.b.a.t
    void o(r r2, boolean r3) {
        r2.n(r3, 2, this.f21615f);
    }

    @Override // l.b.a.t
    int p() {
        return (c2.a(this.f21615f.length) + 1) + this.f21615f.length;
    }

    @Override // l.b.a.t
    boolean t() {
        return false;
    }

    public String toString() {
        return y().toString();
    }

    public BigInteger y() {
        return new BigInteger(this.f21615f);
    }

    public boolean z(BigInteger r4) {
        if (r4 != null) goto L4;
    L8:
        return false;
    L4:
        if (A(this.f21615f, this.f21616g, -1) != r4.intValue()) goto L8;
        if (y().equals(r4) == false) goto L8;
        return true;
    }
}
