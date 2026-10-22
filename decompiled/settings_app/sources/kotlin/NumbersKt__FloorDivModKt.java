package kotlin;

import android.icu.text.PluralRules;

/* JADX INFO: compiled from: FloorDivMod.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b¨\u0006\t"}, d2 = {"floorDiv", "", "", PluralRules.KEYWORD_OTHER, "", "", "mod", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    public NumbersKt__FloorDivModKt() {
    }

    private static final int floorDiv(byte r2, byte r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final byte mod(byte r2, byte r3) {
        int r4 = r2 % r3;
        return (byte) (r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31)));
    }

    private static final int floorDiv(byte r2, short r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final short mod(byte r2, short r3) {
        int r4 = r2 % r3;
        return (short) (r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31)));
    }

    private static final int floorDiv(byte r2, int r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final int mod(byte r2, int r3) {
        int r4 = r2 % r3;
        return r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31));
    }

    private static final long floorDiv(byte r8, long r9) {
        long r0 = r8;
        long r2 = r0 / r9;
        if ((r0 ^ r9) < 0) goto L5;
        return r2;
    L5:
        if ((r9 * r2) != r0) goto L7;
        return r2;
    L7:
        return r2 - 1;
    }

    private static final long mod(byte r6, long r7) {
        long r0 = ((long) r6) % r7;
        return r0 + (r7 & (((r0 ^ r7) & ((-r0) | r0)) >> 63));
    }

    private static final int floorDiv(short r2, byte r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final byte mod(short r2, byte r3) {
        int r4 = r2 % r3;
        return (byte) (r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31)));
    }

    private static final int floorDiv(short r2, short r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final short mod(short r2, short r3) {
        int r4 = r2 % r3;
        return (short) (r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31)));
    }

    private static final int floorDiv(short r2, int r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final int mod(short r2, int r3) {
        int r4 = r2 % r3;
        return r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31));
    }

    private static final long floorDiv(short r8, long r9) {
        long r0 = r8;
        long r2 = r0 / r9;
        if ((r0 ^ r9) < 0) goto L5;
        return r2;
    L5:
        if ((r9 * r2) != r0) goto L7;
        return r2;
    L7:
        return r2 - 1;
    }

    private static final long mod(short r6, long r7) {
        long r0 = ((long) r6) % r7;
        return r0 + (r7 & (((r0 ^ r7) & ((-r0) | r0)) >> 63));
    }

    private static final int floorDiv(int r2, byte r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final byte mod(int r2, byte r3) {
        int r4 = r2 % r3;
        return (byte) (r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31)));
    }

    private static final int floorDiv(int r2, short r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final short mod(int r2, short r3) {
        int r4 = r2 % r3;
        return (short) (r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31)));
    }

    private static final int floorDiv(int r2, int r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        return r0;
    L5:
        if ((r3 * r0) != r2) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final int mod(int r2, int r3) {
        int r4 = r2 % r3;
        return r4 + (r3 & (((r4 ^ r3) & ((-r4) | r4)) >> 31));
    }

    private static final long floorDiv(int r8, long r9) {
        long r0 = r8;
        long r2 = r0 / r9;
        if ((r0 ^ r9) < 0) goto L5;
        return r2;
    L5:
        if ((r9 * r2) != r0) goto L7;
        return r2;
    L7:
        return r2 - 1;
    }

    private static final long mod(int r6, long r7) {
        long r0 = ((long) r6) % r7;
        return r0 + (r7 & (((r0 ^ r7) & ((-r0) | r0)) >> 63));
    }

    private static final long floorDiv(long r8, byte r10) {
        long r0 = r10;
        long r2 = r8 / r0;
        if ((r8 ^ r0) < 0) goto L5;
        return r2;
    L5:
        if ((r0 * r2) != r8) goto L7;
        return r2;
    L7:
        return r2 - 1;
    }

    private static final byte mod(long r6, byte r8) {
        long r0 = r8;
        long r7 = r6 % r0;
        return (byte) (r7 + (r0 & (((r7 ^ r0) & ((-r7) | r7)) >> 63)));
    }

    private static final long floorDiv(long r8, short r10) {
        long r0 = r10;
        long r2 = r8 / r0;
        if ((r8 ^ r0) < 0) goto L5;
        return r2;
    L5:
        if ((r0 * r2) != r8) goto L7;
        return r2;
    L7:
        return r2 - 1;
    }

    private static final short mod(long r6, short r8) {
        long r0 = r8;
        long r7 = r6 % r0;
        return (short) (r7 + (r0 & (((r7 ^ r0) & ((-r7) | r7)) >> 63)));
    }

    private static final long floorDiv(long r8, int r10) {
        long r0 = r10;
        long r2 = r8 / r0;
        if ((r8 ^ r0) < 0) goto L5;
        return r2;
    L5:
        if ((r0 * r2) != r8) goto L7;
        return r2;
    L7:
        return r2 - 1;
    }

    private static final int mod(long r6, int r8) {
        long r0 = r8;
        long r7 = r6 % r0;
        return (int) (r7 + (r0 & (((r7 ^ r0) & ((-r7) | r7)) >> 63)));
    }

    private static final long floorDiv(long r6, long r8) {
        long r0 = r6 / r8;
        if ((r6 ^ r8) < 0) goto L5;
        return r0;
    L5:
        if ((r8 * r0) != r6) goto L7;
        return r0;
    L7:
        return r0 - 1;
    }

    private static final long mod(long r4, long r6) {
        long r5 = r4 % r6;
        return r5 + (r6 & (((r5 ^ r6) & ((-r5) | r5)) >> 63));
    }

    private static final float mod(float r4, float r5) {
        float r6 = r4 % r5;
        boolean r1 = true;
        if (r6 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r6;
    L8:
        if (Math.signum(r6) == Math.signum(r5)) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return r6;
    L13:
        return r6 + r5;
    L5:
        r0 = false;
        goto L6
    }

    private static final double mod(float r8, double r9) {
        double r0 = ((double) r8) % r9;
        boolean r2 = true;
        if (r0 != 0.0d) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        return r0;
    L8:
        if (Math.signum(r0) == Math.signum(r9)) goto L11;
        r2 = false;
    L11:
        if (r2 == false) goto L13;
        return r0;
    L13:
        return r0 + r9;
    L5:
        r10 = false;
        goto L6
    }

    private static final double mod(double r8, float r10) {
        double r0 = r10;
        double r9 = r8 % r0;
        boolean r2 = true;
        if (r9 != 0.0d) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return r9;
    L8:
        if (Math.signum(r9) == Math.signum(r0)) goto L11;
        r2 = false;
    L11:
        if (r2 == false) goto L13;
        return r9;
    L13:
        return r9 + r0;
    L5:
        r11 = false;
        goto L6
    }

    private static final double mod(double r7, double r9) {
        double r8 = r7 % r9;
        boolean r1 = true;
        if (r8 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r8;
    L8:
        if (Math.signum(r8) == Math.signum(r9)) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return r8;
    L13:
        return r8 + r9;
    L5:
        r0 = false;
        goto L6
    }
}
