package l.b.g.d.a;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f22276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f22278c;

    public i(b r1, int r2) {
        this.f22276a = r1;
        this.f22277b = r2;
        int[] r3 = new int[r2 + 1];
        this.f22278c = r3;
        r3[r2] = 1;
    }

    public i(b r10, byte[] r11) {
        this.f22276a = r10;
        int r0 = 8;
        int r2 = 1;
    L4:
        if (r10.d() <= r0) goto L7;
        r2 = r2 + 1;
        r0 = r0 + 8;
        goto L4
    L7:
        if ((r11.length % r2) != 0) goto L29;
        this.f22278c = new int[r11.length / r2];
        int r3 = 0;
        int r4 = 0;
    L9:
        int[] r5 = this.f22278c;
        if (r3 >= r5.length) goto L20;
        int r6 = 0;
    L12:
        if (r6 >= r0) goto L15;
        int[] r7 = this.f22278c;
        r7[r3] = ((r11[r4] & 255) << r6) ^ r7[r3];
        r6 = r6 + 8;
        r4 = r4 + 1;
        goto L12
    L15:
        if (this.f22276a.g(this.f22278c[r3]) == false) goto L18;
        r3 = r3 + 1;
        goto L9
    L18:
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    L20:
        if (r5.length != 1) goto L22;
    L26:
        d();
        return;
    L22:
        if (r5[r5.length - 1] != 0) goto L26;
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    L29:
        throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
    }

    public i(b r1, int[] r2) {
        this.f22276a = r1;
        this.f22278c = q(r2);
        d();
    }

    public i(i r2) {
        this.f22276a = r2.f22276a;
        this.f22277b = r2.f22277b;
        this.f22278c = d.a(r2.f22278c);
    }

    private int[] a(int[] r5, int[] r6) {
        if (r5.length >= r6.length) goto L5;
        int[] r0 = new int[r6.length];
        System.arraycopy(r6, 0, r0, 0, r6.length);
    L6:
        int r7 = r5.length - 1;
    L7:
        if (r7 < 0) goto L9;
        r0[r7] = this.f22276a.a(r0[r7], r5[r7]);
        r7 = r7 - 1;
        goto L7
    L9:
        return r0;
    L5:
        r0 = new int[r5.length];
        System.arraycopy(r5, 0, r0, 0, r5.length);
        r5 = r6;
        goto L6
    }

    private static int c(int[] r2) {
        int r0 = r2.length - 1;
    L3:
        if (r0 < 0) goto L7;
        if (r2[r0] != 0) goto L7;
        r0 = r0 - 1;
    L7:
        return r0;
    }

    private void d() {
        int r0 = this.f22278c.length;
    L3:
        this.f22277b = r0 - 1;
        r0 = this.f22277b;
        if (r0 < 0) goto L8;
        if (this.f22278c[r0] == 0) goto L3;
        return;
    }

    private static int i(int[] r2) {
        int r0 = c(r2);
        if (r0 != (-1)) goto L7;
        return 0;
    L7:
        return r2[r0];
    }

    private static boolean j(int[] r5, int[] r6) {
        int r0 = c(r5);
        if (r0 == c(r6)) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        if (r1 > r0) goto L11;
        if (r5[r1] != r6[r1]) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private int[] l(int[] r6, int[] r7) {
        int r0 = c(r7);
        if (r0 == (-1)) goto L10;
        int r1 = r6.length;
        int[] r2 = new int[r1];
        int r3 = i(r7);
        int r4 = this.f22276a.f(r3);
        System.arraycopy(r6, 0, r2, 0, r1);
    L6:
        if (r0 > c(r2)) goto L8;
        int r8 = this.f22276a.h(i(r2), r4);
        r2 = a(o(p(r7, c(r2) - r0), r8), r2);
        goto L6
    L8:
        return r2;
    L10:
        throw new ArithmeticException("Division by zero");
    }

    private int[] o(int[] r5, int r6) {
        int r0 = c(r5);
        if (r0 == (-1)) goto L14;
        if (r6 == 0) goto L14;
        if (r6 == 1) goto L8;
        int[] r1 = new int[r0 + 1];
    L10:
        if (r0 < 0) goto L12;
        r1[r0] = this.f22276a.h(r5[r0], r6);
        r0 = r0 - 1;
        goto L10
    L12:
        return r1;
    L8:
        return d.a(r5);
    L14:
        return new int[1];
    }

    private static int[] p(int[] r4, int r5) {
        int r0 = c(r4);
        if (r0 == (-1)) goto L5;
        int[] r2 = new int[(r0 + r5) + 1];
        System.arraycopy(r4, 0, r2, r5, r0 + 1);
        return r2;
    L5:
        return new int[1];
    }

    private static int[] q(int[] r3) {
        int r0 = c(r3);
        if (r0 == (-1)) goto L5;
        int r1 = r0 + 1;
        if (r3.length == r1) goto L9;
        int[] r2 = new int[r1];
        System.arraycopy(r3, 0, r2, 0, r1);
        return r2;
    L9:
        return d.a(r3);
    L5:
        return new int[1];
    }

    public void b(i r2) {
        this.f22278c = a(this.f22278c, r2.f22278c);
        d();
    }

    public int e(int r4) {
        int[] r0 = this.f22278c;
        int r1 = this.f22277b;
        int r2 = r0[r1];
        int r3 = r1 - 1;
    L3:
        if (r3 < 0) goto L5;
        r2 = this.f22276a.h(r2, r4) ^ this.f22278c[r3];
        r3 = r3 - 1;
        goto L3
    L5:
        return r2;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r4 instanceof i) == false) goto L15;
        i r5 = (i) r4;
        if (this.f22276a.equals(r5.f22276a) == false) goto L15;
        if (this.f22277b != r5.f22277b) goto L15;
        if (j(this.f22278c, r5.f22278c) == false) goto L15;
        return true;
    }

    public int f(int r2) {
        if (r2 >= 0) goto L4;
        return 0;
    L4:
        if (r2 <= this.f22277b) goto L7;
        return 0;
    L7:
        return this.f22278c[r2];
    }

    public int g() {
        int[] r1 = this.f22278c;
        int r0 = r1.length - 1;
        if (r1[r0] != 0) goto L6;
        return -1;
    L6:
        return r0;
    }

    public byte[] h() {
        int r0 = 8;
        int r1 = 1;
    L4:
        if (this.f22276a.d() <= r0) goto L6;
        r1 = r1 + 1;
        r0 = r0 + 8;
        goto L4
    L6:
        byte[] r2 = new byte[this.f22278c.length * r1];
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= this.f22278c.length) goto L13;
        int r5 = 0;
    L10:
        if (r5 >= r0) goto L12;
        r2[r4] = (byte) (this.f22278c[r3] >>> r5);
        r5 = r5 + 8;
        r4 = r4 + 1;
        goto L10
    L12:
        r3 = r3 + 1;
        goto L8
    L13:
        return r2;
    }

    public int hashCode() {
        int r0 = this.f22276a.hashCode();
        int r1 = 0;
    L3:
        int[] r2 = this.f22278c;
        if (r1 >= r2.length) goto L6;
        r0 = (r0 * 31) + r2[r1];
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public i k(i r2) {
        int[] r3 = l(this.f22278c, r2.f22278c);
        return new i(this.f22276a, r3);
    }

    public void m(int r2) {
        if (this.f22276a.g(r2) == false) goto L7;
        this.f22278c = o(this.f22278c, r2);
        d();
        return;
    L7:
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public i n(int r2) {
        if (this.f22276a.g(r2) == false) goto L7;
        int[] r3 = o(this.f22278c, r2);
        return new i(this.f22276a, r3);
    L7:
        throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
    }

    public String toString() {
        String r0 = " Polynomial over " + this.f22276a.toString() + ": \n";
        int r1 = 0;
    L4:
        if (r1 >= this.f22278c.length) goto L7;
        r0 = r0 + this.f22276a.b(this.f22278c[r1]) + "Y^" + r1 + "+";
        r1 = r1 + 1;
        goto L4
    L7:
        return r0 + ";";
    }
}
