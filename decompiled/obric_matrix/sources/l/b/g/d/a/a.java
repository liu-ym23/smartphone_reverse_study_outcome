package l.b.g.d.a;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[][] f22269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22270d;

    public a(int r6, int[][] r7) {
        int r0 = 0;
        if (r7[0].length != ((r6 + 31) >> 5)) goto L14;
        this.f22274b = r6;
        this.f22273a = r7.length;
        this.f22270d = r7[0].length;
        int r8 = r6 & 31;
        if (r8 != 0) goto L7;
        int r9 = -1;
    L9:
        if (r0 >= this.f22273a) goto L11;
        int[] r2 = r7[r0];
        int r3 = this.f22270d - 1;
        r2[r3] = r2[r3] & r9;
        r0 = r0 + 1;
        goto L9
    L11:
        this.f22269c = r7;
        return;
    L7:
        r9 = (1 << r8) - 1;
        goto L9
    L14:
        throw new ArithmeticException("Int array does not match given number of columns.");
    }

    public a(a r4) {
        this.f22274b = r4.a();
        this.f22273a = r4.b();
        this.f22270d = r4.f22270d;
        this.f22269c = new int[r4.f22269c.length][];
        int r0 = 0;
    L3:
        int[][] r1 = this.f22269c;
        if (r0 >= r1.length) goto L6;
        r1[r0] = d.a(r4.f22269c[r0]);
        r0 = r0 + 1;
        goto L3
    }

    public a(byte[] r10) {
        if (r10.length < 9) goto L22;
        this.f22273a = f.e(r10, 0);
        int r2 = f.e(r10, 4);
        this.f22274b = r2;
        int r4 = this.f22273a;
        int r3 = ((r2 + 7) >>> 3) * r4;
        if (r4 <= 0) goto L20;
        int r6 = 8;
        if (r3 != (r10.length - 8)) goto L20;
        int r1 = (r2 + 31) >>> 5;
        this.f22270d = r1;
        this.f22269c = (int[][]) Array.newInstance(int.class, new int[]{r4, r1});
        int r5 = this.f22274b;
        int r7 = r5 >> 5;
        int r8 = r5 & 31;
        int r9 = 0;
    L10:
        if (r9 >= this.f22273a) goto L18;
        int r11 = 0;
    L12:
        if (r11 >= r7) goto L14;
        this.f22269c[r9][r11] = f.e(r10, r6);
        r11 = r11 + 1;
        r6 = r6 + 4;
        goto L12
    L14:
        int r12 = 0;
    L15:
        if (r12 >= r8) goto L17;
        int[] r13 = this.f22269c[r9];
        r13[r7] = ((r10[r6] & 255) << r12) ^ r13[r7];
        r12 = r12 + 8;
        r6 = r6 + 1;
        goto L15
    L17:
        r9 = r9 + 1;
        goto L10
    L18:
        return;
    L20:
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    L22:
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public byte[] c() {
        int r0 = (this.f22274b + 7) >>> 3;
        int r1 = this.f22273a;
        int r2 = 8;
        byte[] r3 = new byte[(r0 * r1) + 8];
        f.a(r1, r3, 0);
        f.a(this.f22274b, r3, 4);
        int r4 = this.f22274b;
        int r5 = r4 >>> 5;
        int r6 = r4 & 31;
        int r7 = 0;
    L4:
        if (r7 >= this.f22273a) goto L12;
        int r8 = 0;
    L6:
        if (r8 >= r5) goto L8;
        f.a(this.f22269c[r7][r8], r3, r2);
        r8 = r8 + 1;
        r2 = r2 + 4;
        goto L6
    L8:
        int r9 = 0;
    L9:
        if (r9 >= r6) goto L11;
        r3[r2] = (byte) ((this.f22269c[r7][r5] >>> r9) & 255);
        r9 = r9 + 8;
        r2 = r2 + 1;
        goto L9
    L11:
        r7 = r7 + 1;
        goto L4
    L12:
        return r3;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof a) == true) goto L5;
        return false;
    L5:
        a r6 = (a) r5;
        if (this.f22273a == r6.f22273a) goto L8;
    L21:
        return false;
    L8:
        if (this.f22274b != r6.f22274b) goto L21;
        if (this.f22270d != r6.f22270d) goto L21;
        int r0 = 0;
    L14:
        if (r0 >= this.f22273a) goto L19;
        if (d.b(this.f22269c[r0], r6.f22269c[r0]) == false) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public int hashCode() {
        int r0 = (((this.f22273a * 31) + this.f22274b) * 31) + this.f22270d;
        int r1 = 0;
    L4:
        if (r1 >= this.f22273a) goto L6;
        r0 = (r0 * 31) + l.b.h.a.m(this.f22269c[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public String toString() {
        int r0 = this.f22274b & 31;
        int r1 = this.f22270d;
        if (r0 == 0) goto L6;
        r1 = r1 - 1;
    L6:
        StringBuffer r2 = new StringBuffer();
        int r4 = 0;
    L8:
        if (r4 >= this.f22273a) goto L30;
        r2.append(r4 + ": ");
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L21;
        int r8 = this.f22269c[r4][r5];
        int r9 = 0;
    L14:
        if (r9 >= 32) goto L20;
        if (((r8 >>> r9) & 1) != 0) goto L18;
        r2.append('0');
    L19:
        r9 = r9 + 1;
        goto L14
    L18:
        r2.append('1');
        goto L19
    L20:
        r2.append(' ');
        r5 = r5 + 1;
        goto L11
    L21:
        int r6 = this.f22269c[r4][this.f22270d - 1];
        int r10 = 0;
    L22:
        if (r10 >= r0) goto L28;
        if (((r6 >>> r10) & 1) != 0) goto L26;
        r2.append('0');
    L27:
        r10 = r10 + 1;
        goto L22
    L26:
        r2.append('1');
        goto L27
    L28:
        r2.append('\n');
        r4 = r4 + 1;
        goto L8
    L30:
        return r2.toString();
    }
}
