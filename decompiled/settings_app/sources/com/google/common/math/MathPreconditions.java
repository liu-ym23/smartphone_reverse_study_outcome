package com.google.common.math;

import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class MathPreconditions {
    static int checkPositive(String r3, int r4) {
        if (r4 <= 0) goto L5;
        return r4;
    L5:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r3).length() + 26).append(r3).append(" (").append(r4).append(") must be > 0").toString());
    }

    static long checkPositive(String r3, long r4) {
        if (r4 <= 0) goto L6;
        return r4;
    L6:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r3).length() + 35).append(r3).append(" (").append(r4).append(") must be > 0").toString());
    }

    static BigInteger checkPositive(String r3, BigInteger r4) {
        if (r4.signum() <= 0) goto L5;
        return r4;
    L5:
        String r5 = String.valueOf(r4);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(r3).length() + 15) + String.valueOf(r5).length()).append(r3).append(" (").append(r5).append(") must be > 0").toString());
    }

    static int checkNonNegative(String r3, int r4) {
        if (r4 < 0) goto L5;
        return r4;
    L5:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r3).length() + 27).append(r3).append(" (").append(r4).append(") must be >= 0").toString());
    }

    static long checkNonNegative(String r3, long r4) {
        if (r4 < 0) goto L6;
        return r4;
    L6:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r3).length() + 36).append(r3).append(" (").append(r4).append(") must be >= 0").toString());
    }

    static BigInteger checkNonNegative(String r3, BigInteger r4) {
        if (r4.signum() < 0) goto L5;
        return r4;
    L5:
        String r5 = String.valueOf(r4);
        throw new IllegalArgumentException(new StringBuilder((String.valueOf(r3).length() + 16) + String.valueOf(r5).length()).append(r3).append(" (").append(r5).append(") must be >= 0").toString());
    }

    static double checkNonNegative(String r3, double r4) {
        if (r4 < 0.0d) goto L6;
        return r4;
    L6:
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r3).length() + 40).append(r3).append(" (").append(r4).append(") must be >= 0").toString());
    }

    static void checkRoundingUnnecessary(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }

    static void checkInRangeForRoundingInputs(boolean r2, double r3, RoundingMode r5) {
        if (r2 == false) goto L4;
        return;
    L4:
        String r6 = String.valueOf(r5);
        throw new ArithmeticException(new StringBuilder(String.valueOf(r6).length() + 83).append("rounded value is out of range for input ").append(r3).append(" and rounding mode ").append(r6).toString());
    }

    static void checkNoOverflow(boolean r2, String r3, int r4, int r5) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException(new StringBuilder(String.valueOf(r3).length() + 36).append("overflow: ").append(r3).append("(").append(r4).append(", ").append(r5).append(")").toString());
    }

    static void checkNoOverflow(boolean r2, String r3, long r4, long r6) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException(new StringBuilder(String.valueOf(r3).length() + 54).append("overflow: ").append(r3).append("(").append(r4).append(", ").append(r6).append(")").toString());
    }

    private MathPreconditions() {
    }
}
