package androidx.core.math;

/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    public static double clamp(double r1, double r3, double r5) {
        if (r1 >= r3) goto L6;
        return r3;
    L6:
        if (r1 <= r5) goto L8;
        return r5;
    L8:
        return r1;
    }

    public static float clamp(float r1, float r2, float r3) {
        if (r1 >= r2) goto L6;
        return r2;
    L6:
        if (r1 <= r3) goto L8;
        return r3;
    L8:
        return r1;
    }

    public static int clamp(int r0, int r1, int r2) {
        if (r0 >= r1) goto L4;
        return r1;
    L4:
        if (r0 <= r2) goto L6;
        return r2;
    L6:
        return r0;
    }

    public static long clamp(long r1, long r3, long r5) {
        if (r1 >= r3) goto L6;
        return r3;
    L6:
        if (r1 <= r5) goto L8;
        return r5;
    L8:
        return r1;
    }

    private MathUtils() {
    }

    public static int addExact(int r1, int r2) {
        int r0 = r1 + r2;
        if (((r1 ^ r0) & (r2 ^ r0)) < 0) goto L6;
        return r0;
    L6:
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long r2, long r4) {
        long r0 = r2 + r4;
        if (((r2 ^ r0) & (r4 ^ r0)) < 0) goto L6;
        return r0;
    L6:
        throw new ArithmeticException("long overflow");
    }

    public static int subtractExact(int r1, int r2) {
        int r0 = r1 - r2;
        int r3 = r2 ^ r1;
        if (((r1 ^ r0) & r3) < 0) goto L6;
        return r0;
    L6:
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long r2, long r4) {
        long r0 = r2 - r4;
        long r5 = r4 ^ r2;
        if (((r2 ^ r0) & r5) < 0) goto L6;
        return r0;
    L6:
        throw new ArithmeticException("long overflow");
    }

    public static int multiplyExact(int r4, int r5) {
        long r0 = ((long) r4) * ((long) r5);
        int r6 = (int) r0;
        if (r6 != r0) goto L6;
        return r6;
    L6:
        throw new ArithmeticException("integer overflow");
    }

    public static long multiplyExact(long r6, long r8) {
        long r0 = r6 * r8;
        if (((Math.abs(r6) | Math.abs(r8)) >>> 31) != 0) goto L5;
    L15:
        return r0;
    L5:
        if (r8 == 0) goto L9;
        if ((r0 / r8) == r6) goto L9;
    L14:
        throw new ArithmeticException("long overflow");
    L9:
        if (r6 != Long.MIN_VALUE) goto L15;
        if (r8 == (-1)) goto L14;
        goto L15
    }

    public static int incrementExact(int r1) {
        if (r1 == Integer.MAX_VALUE) goto L7;
        return r1 + 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long r2) {
        if (r2 == Long.MAX_VALUE) goto L7;
        return r2 + 1;
    L7:
        throw new ArithmeticException("long overflow");
    }

    public static int decrementExact(int r1) {
        if (r1 == Integer.MIN_VALUE) goto L7;
        return r1 - 1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long decrementExact(long r2) {
        if (r2 == Long.MIN_VALUE) goto L7;
        return r2 - 1;
    L7:
        throw new ArithmeticException("long overflow");
    }

    public static int negateExact(int r1) {
        if (r1 == Integer.MIN_VALUE) goto L7;
        return -r1;
    L7:
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long r2) {
        if (r2 == Long.MIN_VALUE) goto L7;
        return -r2;
    L7:
        throw new ArithmeticException("long overflow");
    }

    public static int toIntExact(long r3) {
        int r0 = (int) r3;
        if (r0 != r3) goto L6;
        return r0;
    L6:
        throw new ArithmeticException("integer overflow");
    }
}
