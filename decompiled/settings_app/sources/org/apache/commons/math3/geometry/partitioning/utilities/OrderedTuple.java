package org.apache.commons.math3.geometry.partitioning.utilities;

import java.util.Arrays;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class OrderedTuple implements Comparable<OrderedTuple> {
    private static final long EXPONENT_MASK = 9218868437227405312L;
    private static final long IMPLICIT_ONE = 4503599627370496L;
    private static final long MANTISSA_MASK = 4503599627370495L;
    private static final long SIGN_MASK = Long.MIN_VALUE;
    private double[] components;
    private long[] encoding;
    private int lsb;
    private boolean nan;
    private boolean negInf;
    private int offset;
    private boolean posInf;

    private static int computeLSB(long r6) {
        long r0 = -4294967296L;
        int r2 = 32;
        int r3 = 0;
    L3:
        if (r2 == 0) goto L8;
        if ((r6 & r0) != r6) goto L7;
        r3 = r3 | r2;
        r6 = r6 >> r2;
    L7:
        r2 = r2 >> 1;
        r0 = r0 >> r2;
        goto L3
    L8:
        return r3;
    }

    private static int computeMSB(long r6) {
        long r0 = 4294967295L;
        int r2 = 32;
        int r3 = 0;
    L3:
        if (r2 == 0) goto L8;
        if ((r6 & r0) == r6) goto L7;
        r3 = r3 | r2;
        r6 = r6 >> r2;
    L7:
        r2 = r2 >> 1;
        r0 = r0 >> r2;
        goto L3
    L8:
        return r3;
    }

    private static int exponent(long r2) {
        return ((int) ((r2 & EXPONENT_MASK) >> 52)) - 1075;
    }

    private static long mantissa(long r5) {
        if ((EXPONENT_MASK & r5) != 0) goto L6;
        return (r5 & MANTISSA_MASK) << 1;
    L6:
        return (r5 & MANTISSA_MASK) | IMPLICIT_ONE;
    }

    private static long sign(long r2) {
        return r2 & Long.MIN_VALUE;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OrderedTuple r1) {
        return compareTo2(r1);
    }

    public OrderedTuple(double... r11) {
        this.components = (double[]) r11.clone();
        this.lsb = Integer.MAX_VALUE;
        this.posInf = false;
        this.negInf = false;
        this.nan = false;
        int r1 = Integer.MIN_VALUE;
        int r2 = 0;
    L4:
        if (r2 >= r11.length) goto L19;
        if (Double.isInfinite(r11[r2]) == false) goto L12;
        if (r11[r2] >= 0.0d) goto L10;
        this.negInf = true;
    L17:
        r2 = r2 + 1;
        goto L4
    L10:
        this.posInf = true;
        goto L17
    L12:
        if (Double.isNaN(r11[r2]) == false) goto L14;
        this.nan = true;
        goto L17
    L14:
        long r6 = Double.doubleToLongBits(r11[r2]);
        long r8 = mantissa(r6);
        if (r8 == 0) goto L17;
        int r3 = exponent(r6);
        r1 = FastMath.max(r1, computeMSB(r8) + r3);
        this.lsb = FastMath.min(this.lsb, r3 + computeLSB(r8));
        goto L17
    L19:
        if (this.posInf == false) goto L24;
        if (this.negInf == false) goto L24;
        this.posInf = false;
        this.negInf = false;
        this.nan = true;
    L24:
        if (this.lsb > r1) goto L26;
        encode(r1 + 16);
        return;
    L26:
        this.encoding = new long[]{0};
    }

    private void encode(int r12) {
        int r13 = r12 + 31;
        this.offset = r13;
        int r14 = r13 - (r13 % 32);
        this.offset = r14;
        long[] r0 = this.encoding;
        if (r0 != null) goto L5;
    L9:
        this.encoding = new long[this.components.length * ((((r14 + 1) - this.lsb) + 62) / 63)];
        long r6 = 0;
        int r1 = 0;
        int r5 = 62;
    L11:
        if (r1 >= this.encoding.length) goto L24;
        int r8 = 0;
    L14:
        if (r8 >= this.components.length) goto L23;
        if (getBit(r8, r14) == 0) goto L18;
        r6 = r6 | (1 << r5);
    L18:
        int r9 = r5 - 1;
        if (r5 != 0) goto L21;
        this.encoding[r1] = r6;
        r6 = 0;
        r5 = 62;
        r1 = r1 + 1;
    L22:
        r8 = r8 + 1;
        goto L14
    L21:
        r5 = r9;
        goto L22
    L23:
        r14 = r14 - 1;
        goto L11
    L24:
        return;
    L5:
        if (r0.length != 1) goto L9;
        if (r0[0] != 0) goto L9;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(OrderedTuple r11) {
        double[] r0 = this.components;
        int r1 = r0.length;
        double[] r2 = r11.components;
        if (r1 != r2.length) goto L44;
        if (this.nan == false) goto L8;
        return 1;
    L8:
        if (r11.nan == false) goto L11;
        return -1;
    L11:
        if (this.negInf == false) goto L13;
    L42:
        return -1;
    L13:
        if (r11.posInf == true) goto L42;
        if (this.posInf == false) goto L18;
    L41:
        return 1;
    L18:
        if (r11.negInf == true) goto L41;
        int r3 = this.offset;
        int r4 = r11.offset;
        if (r3 >= r4) goto L23;
        encode(r4);
    L25:
        int r5 = FastMath.min(this.encoding.length, r11.encoding.length);
        int r6 = 0;
    L26:
        if (r6 >= r5) goto L34;
        long r7 = this.encoding[r6];
        long r8 = r11.encoding[r6];
        if (r7 < r8) goto L29;
        if (r7 > r8) goto L32;
        r6 = r6 + 1;
        goto L26
    L32:
        return 1;
    L29:
        return -1;
    L34:
        long[] r10 = this.encoding;
        int r9 = r10.length;
        long[] r12 = r11.encoding;
        if (r9 >= r12.length) goto L38;
        return -1;
    L38:
        if (r10.length <= r12.length) goto L40;
        return 1;
    L40:
        return 0;
    L23:
        if (r3 <= r4) goto L25;
        r11.encode(r3);
        goto L25
    L44:
        return r0.length - r2.length;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof OrderedTuple) == true) goto L8;
        return false;
    L8:
        if (compareTo2((OrderedTuple) r4) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        int r0 = ((((Arrays.hashCode(this.components) * 37) + this.offset) * 37) + this.lsb) * 37;
        int r2 = 97;
        if (this.posInf == false) goto L5;
        int r1 = 97;
    L6:
        int r3 = (r0 + r1) * 37;
        if (this.negInf == false) goto L9;
        int r4 = 97;
    L10:
        int r5 = (r3 + r4) * 37;
        if (this.nan == true) goto L15;
        r2 = 71;
    L15:
        return r5 + r2;
    L9:
        r4 = 71;
        goto L10
    L5:
        r1 = 71;
        goto L6
    }

    public double[] getComponents() {
        return (double[]) this.components.clone();
    }

    private int getBit(int r7, int r8) {
        long r0 = Double.doubleToLongBits(this.components[r7]);
        int r9 = exponent(r0);
        if (r8 < r9) goto L26;
        int r6 = this.offset;
        if (r8 > r6) goto L26;
        if (r8 != r6) goto L14;
        if (sign(r0) == 0) goto L12;
        return 0;
    L12:
        return 1;
    L14:
        if (r8 > (r9 + 52)) goto L16;
        long r2 = sign(r0);
        long r1 = mantissa(r0);
        if (r2 == 0) goto L25;
        r1 = -r1;
    L25:
        return (int) ((r1 >> (r8 - r9)) & 1);
    L16:
        if (sign(r0) != 0) goto L19;
        return 0;
    L19:
        return 1;
    L26:
        return 0;
    }
}
