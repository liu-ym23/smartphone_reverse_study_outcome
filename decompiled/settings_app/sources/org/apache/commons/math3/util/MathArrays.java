package org.apache.commons.math3.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

/* JADX INFO: loaded from: classes6.dex */
public class MathArrays {

    /* JADX INFO: renamed from: org.apache.commons.math3.util.MathArrays$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$MathArrays$Position = null;

        static {
            int[] r0 = new int[Position.values().length];
            $SwitchMap$org$apache$commons$math3$util$MathArrays$Position = r0;
            r0[Position.TAIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L14:
            $SwitchMap$org$apache$commons$math3$util$MathArrays$Position[Position.HEAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L6:
            int[] r2 = new int[OrderDirection.values().length];
            $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection = r2;
            r2[OrderDirection.INCREASING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[OrderDirection.DECREASING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface Function {
        double evaluate(double[] r1);

        double evaluate(double[] r1, int r2, int r3);
    }

    public static final enum OrderDirection extends Enum<OrderDirection> {
        private static final /* synthetic */ OrderDirection[] $VALUES = null;
        public static final OrderDirection DECREASING = null;
        public static final OrderDirection INCREASING = null;

        private OrderDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static OrderDirection valueOf(String r1) {
            return (OrderDirection) Enum.valueOf(OrderDirection.class, r1);
        }

        public static OrderDirection[] values() {
            return (OrderDirection[]) $VALUES.clone();
        }

        static {
            OrderDirection r0 = new OrderDirection("INCREASING", 0);
            INCREASING = r0;
            OrderDirection r1 = new OrderDirection("DECREASING", 1);
            DECREASING = r1;
            $VALUES = new OrderDirection[]{r0, r1};
        }
    }

    private static class PairDoubleInteger {
        private final double key;
        private final int value;

        PairDoubleInteger(double r1, int r3) {
            this.key = r1;
            this.value = r3;
        }

        public double getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Position extends Enum<Position> {
        private static final /* synthetic */ Position[] $VALUES = null;
        public static final Position HEAD = null;
        public static final Position TAIL = null;

        private Position(String r1, int r2) {
            super(r1, r2);
        }

        public static Position valueOf(String r1) {
            return (Position) Enum.valueOf(Position.class, r1);
        }

        public static Position[] values() {
            return (Position[]) $VALUES.clone();
        }

        static {
            Position r0 = new Position("HEAD", 0);
            HEAD = r0;
            Position r1 = new Position("TAIL", 1);
            TAIL = r1;
            $VALUES = new Position[]{r0, r1};
        }
    }

    private MathArrays() {
    }

    public static double[] scale(double r4, double[] r6) {
        double[] r0 = new double[r6.length];
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0[r1] = r6[r1] * r4;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static void scaleInPlace(double r3, double[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        r5[r0] = r5[r0] * r3;
        r0 = r0 + 1;
        goto L4
    }

    public static double[] ebeAdd(double[] r6, double[] r7) throws DimensionMismatchException {
        checkEqualLength(r6, r7);
        double[] r0 = (double[]) r6.clone();
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0[r1] = r0[r1] + r7[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static double[] ebeSubtract(double[] r6, double[] r7) throws DimensionMismatchException {
        checkEqualLength(r6, r7);
        double[] r0 = (double[]) r6.clone();
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0[r1] = r0[r1] - r7[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static double[] ebeMultiply(double[] r6, double[] r7) throws DimensionMismatchException {
        checkEqualLength(r6, r7);
        double[] r0 = (double[]) r6.clone();
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0[r1] = r0[r1] * r7[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static double[] ebeDivide(double[] r6, double[] r7) throws DimensionMismatchException {
        checkEqualLength(r6, r7);
        double[] r0 = (double[]) r6.clone();
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0[r1] = r0[r1] / r7[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static double distance1(double[] r7, double[] r8) throws DimensionMismatchException {
        checkEqualLength(r7, r8);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0 = r0 + FastMath.abs(r7[r2] - r8[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static int distance1(int[] r4, int[] r5) throws DimensionMismatchException {
        checkEqualLength(r4, r5);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r1 = r1 + FastMath.abs(r4[r0] - r5[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static double distance(double[] r7, double[] r8) throws DimensionMismatchException {
        checkEqualLength(r7, r8);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L7;
        double r3 = r7[r2] - r8[r2];
        r0 = r0 + (r3 * r3);
        r2 = r2 + 1;
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public static double cosAngle(double[] r4, double[] r5) {
        return linearCombination(r4, r5) / (safeNorm(r4) * safeNorm(r5));
    }

    public static double distance(int[] r5, int[] r6) throws DimensionMismatchException {
        checkEqualLength(r5, r6);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L7;
        double r3 = r5[r2] - r6[r2];
        r0 = r0 + (r3 * r3);
        r2 = r2 + 1;
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public static double distanceInf(double[] r7, double[] r8) throws DimensionMismatchException {
        checkEqualLength(r7, r8);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0 = FastMath.max(r0, FastMath.abs(r7[r2] - r8[r2]));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static int distanceInf(int[] r4, int[] r5) throws DimensionMismatchException {
        checkEqualLength(r4, r5);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r1 = FastMath.max(r1, FastMath.abs(r4[r0] - r5[r0]));
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public static <T extends Comparable<? super T>> boolean isMonotonic(T[] r7, OrderDirection r8, boolean r9) {
        T r1 = r7[0];
        int r2 = r7.length;
        int r4 = 1;
    L3:
        if (r4 >= r2) goto L23;
        int r5 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[r8.ordinal()];
        if (r5 != 1) goto L7;
        int r3 = r1.compareTo(r7[r4]);
        if (r9 == false) goto L20;
        if (r3 < 0) goto L22;
        return false;
    L22:
        r1 = r7[r4];
        r4 = r4 + 1;
        goto L3
    L20:
        if (r3 <= 0) goto L22;
        return false;
    L7:
        if (r5 != 2) goto L15;
        int r6 = r7[r4].compareTo(r1);
        if (r9 == false) goto L12;
        if (r6 < 0) goto L22;
        return false;
    L12:
        if (r6 <= 0) goto L22;
        return false;
    L15:
        throw new MathInternalError();
    L23:
        return true;
    }

    public static boolean isMonotonic(double[] r1, OrderDirection r2, boolean r3) {
        return checkOrder(r1, r2, r3, false);
    }

    public static boolean checkEqualLength(double[] r2, double[] r3, boolean r4) {
        if (r2.length != r3.length) goto L6;
        return true;
    L6:
        if (r4 == true) goto L10;
        return false;
    L10:
        throw new DimensionMismatchException(r2.length, r3.length);
    }

    public static void checkEqualLength(double[] r1, double[] r2) {
        checkEqualLength(r1, r2, true);
    }

    public static boolean checkEqualLength(int[] r2, int[] r3, boolean r4) {
        if (r2.length != r3.length) goto L6;
        return true;
    L6:
        if (r4 == true) goto L10;
        return false;
    L10:
        throw new DimensionMismatchException(r2.length, r3.length);
    }

    public static void checkEqualLength(int[] r1, int[] r2) {
        checkEqualLength(r1, r2, true);
    }

    public static boolean checkOrder(double[] r11, OrderDirection r12, boolean r13, boolean r14) throws NonMonotonicSequenceException {
        double r1 = r11[0];
        int r3 = r11.length;
        int r8 = 1;
    L3:
        if (r8 >= r3) goto L25;
        int r5 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[r12.ordinal()];
        if (r5 != 1) goto L7;
        if (r13 == false) goto L22;
        if (r11[r8] <= r1) goto L25;
    L24:
        r1 = r11[r8];
        r8 = r8 + 1;
        goto L3
    L22:
        if (r11[r8] >= r1) goto L24;
    L7:
        if (r5 != 2) goto L16;
        if (r13 == false) goto L13;
        if (r11[r8] < r1) goto L24;
    L13:
        if (r11[r8] <= r1) goto L24;
    L16:
        throw new MathInternalError();
    L25:
        if (r8 != r3) goto L27;
        return true;
    L27:
        if (r14 == true) goto L30;
        return false;
    L30:
        throw new NonMonotonicSequenceException(Double.valueOf(r11[r8]), Double.valueOf(r1), r8, r12, r13);
    }

    public static void checkOrder(double[] r1, OrderDirection r2, boolean r3) throws NonMonotonicSequenceException {
        checkOrder(r1, r2, r3, true);
    }

    public static void checkOrder(double[] r2) throws NonMonotonicSequenceException {
        checkOrder(r2, OrderDirection.INCREASING, true);
    }

    public static void checkRectangular(long[][] r4) throws NullArgumentException, DimensionMismatchException {
        MathUtils.checkNotNull(r4);
        int r0 = 1;
    L4:
        if (r0 >= r4.length) goto L10;
        if (r4[r0].length != r4[0].length) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new DimensionMismatchException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, r4[r0].length, r4[0].length);
    }

    public static void checkPositive(double[] r5) throws NotStrictlyPositiveException {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L10;
        if (r5[r0] <= 0.0d) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new NotStrictlyPositiveException(Double.valueOf(r5[r0]));
    }

    public static void checkNotNaN(double[] r3) throws NotANumberException {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L10;
        if (Double.isNaN(r3[r0]) == true) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new NotANumberException();
    }

    public static void checkNonNegative(long[] r5) throws NotPositiveException {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L10;
        if (r5[r0] < 0) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new NotPositiveException(Long.valueOf(r5[r0]));
    }

    public static void checkNonNegative(long[][] r7) throws NotPositiveException {
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L14;
        int r2 = 0;
    L6:
        long[] r3 = r7[r1];
        if (r2 >= r3.length) goto L13;
        if (r3[r2] < 0) goto L12;
        r2 = r2 + 1;
        goto L6
    L12:
        throw new NotPositiveException(Long.valueOf(r7[r1][r2]));
    L13:
        r1 = r1 + 1;
        goto L4
    }

    public static double safeNorm(double[] r23) {
        double r3 = 1.304E19d / ((double) r23.length);
        int r5 = 0;
        double r6 = 0.0d;
        double r8 = 0.0d;
        double r10 = 0.0d;
        double r12 = 0.0d;
        double r14 = 0.0d;
    L4:
        if (r5 >= r23.length) goto L26;
        double r1 = FastMath.abs(r23[r5]);
        if (r1 < 3.834E-20d) goto L13;
        if (r1 > r3) goto L13;
        r8 = r8 + (r1 * r1);
    L24:
        r5 = r5 + 1;
    L13:
        if (r1 <= 3.834E-20d) goto L19;
        if (r1 <= r10) goto L17;
        double r11 = r10 / r1;
        r6 = ((r6 * r11) * r11) + 1.0d;
        r10 = r1;
        goto L24
    L17:
        double r2 = r1 / r10;
        r6 = r6 + (r2 * r2);
        goto L24
    L19:
        if (r1 <= r12) goto L22;
        double r13 = r12 / r1;
        r14 = ((r14 * r13) * r13) + 1.0d;
        r12 = r1;
        goto L24
    L22:
        if (r1 == 0.0d) goto L24;
        double r4 = r1 / r12;
        r14 = r14 + (r4 * r4);
        goto L24
    L26:
        if (r6 == 0.0d) goto L29;
        return r10 * Math.sqrt(r6 + ((r8 / r10) / r10));
    L29:
        if (r8 != 0.0d) goto L32;
        return r12 * Math.sqrt(r14);
    L32:
        if (r8 < r12) goto L35;
        return Math.sqrt(r8 * (((r12 / r8) * (r12 * r14)) + 1.0d));
    L35:
        return Math.sqrt(r12 * ((r8 / r12) + (r14 * r12)));
    }

    public static void sortInPlace(double[] r1, double[]... r2) throws DimensionMismatchException, NullArgumentException {
        sortInPlace(r1, OrderDirection.INCREASING, r2);
    }

    public static void sortInPlace(double[] r8, OrderDirection r9, double[]... r10) throws NullArgumentException, DimensionMismatchException {
        if (r8 == null) goto L32;
        int r0 = r10.length;
        int r1 = r8.length;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L14;
        double[] r4 = r10[r3];
        if (r4 == null) goto L13;
        if (r4.length != r1) goto L11;
        r3 = r3 + 1;
        goto L4
    L11:
        throw new DimensionMismatchException(r4.length, r1);
    L13:
        throw new NullArgumentException();
    L14:
        ArrayList r5 = new ArrayList(r1);
        int r6 = 0;
    L15:
        if (r6 >= r1) goto L18;
        r5.add(new PairDoubleInteger(r8[r6], r6));
        r6 = r6 + 1;
        goto L15
    L18:
        if (r9 != OrderDirection.INCREASING) goto L20;
        Comparator<PairDoubleInteger> r11 = new AnonymousClass1();
    L21:
        Collections.sort(r5, r11);
        int[] r12 = new int[r1];
        int r7 = 0;
    L22:
        if (r7 >= r1) goto L24;
        PairDoubleInteger r13 = (PairDoubleInteger) r5.get(r7);
        r8[r7] = r13.getKey();
        r12[r7] = r13.getValue();
        r7 = r7 + 1;
        goto L22
    L24:
        int r14 = 0;
    L25:
        if (r14 >= r0) goto L30;
        double[] r15 = r10[r14];
        double[] r16 = (double[]) r15.clone();
        int r17 = 0;
    L27:
        if (r17 >= r1) goto L29;
        r15[r17] = r16[r12[r17]];
        r17 = r17 + 1;
        goto L27
    L29:
        r14 = r14 + 1;
        goto L25
    L30:
        return;
    L20:
        r11 = new AnonymousClass2();
        goto L21
    L32:
        throw new NullArgumentException();
    }

    public static int[] copyOf(int[] r1) {
        return copyOf(r1, r1.length);
    }

    public static double[] copyOf(double[] r1) {
        return copyOf(r1, r1.length);
    }

    public static int[] copyOf(int[] r2, int r3) {
        int[] r0 = new int[r3];
        System.arraycopy(r2, 0, r0, 0, FastMath.min(r3, r2.length));
        return r0;
    }

    public static double[] copyOf(double[] r2, int r3) {
        double[] r0 = new double[r3];
        System.arraycopy(r2, 0, r0, 0, FastMath.min(r3, r2.length));
        return r0;
    }

    public static double[] copyOfRange(double[] r2, int r3, int r4) {
        int r5 = r4 - r3;
        double[] r0 = new double[r5];
        System.arraycopy(r2, r3, r0, 0, FastMath.min(r5, r2.length - r3));
        return r0;
    }

    public static double linearCombination(double[] r24, double[] r25) throws DimensionMismatchException {
        checkEqualLength(r24, r25);
        int r1 = r24.length;
        int r2 = 0;
        int r3 = 1;
        if (r1 == 1) goto L5;
        double[] r4 = new double[r1];
        double r5 = 0.0d;
        int r7 = 0;
        double r8 = 0.0d;
    L7:
        if (r7 >= r1) goto L9;
        double r10 = r24[r7];
        double r12 = Double.longBitsToDouble(Double.doubleToRawLongBits(r10) & (-134217728));
        double r16 = r10 - r12;
        double r18 = r25[r7];
        double r14 = Double.longBitsToDouble(Double.doubleToRawLongBits(r18) & (-134217728));
        double r20 = r18 - r14;
        double r11 = r10 * r18;
        r4[r7] = r11;
        r8 = r8 + ((r16 * r20) - (((r11 - (r12 * r14)) - (r16 * r14)) - (r12 * r20)));
        r7 = r7 + 1;
        goto L7
    L9:
        double r13 = r4[0];
        double r15 = r4[1];
        double r17 = r13 + r15;
        double r19 = r17 - r15;
        double r110 = (r15 - (r17 - r19)) + (r13 - r19);
        int r9 = r1 - 1;
    L10:
        if (r3 >= r9) goto L12;
        r3 = r3 + 1;
        double r111 = r4[r3];
        double r112 = r17 + r111;
        double r113 = r112 - r111;
        r110 = r110 + ((r111 - (r112 - r113)) + (r17 - r113));
        r17 = r112;
        goto L10
    L12:
        double r114 = r17 + (r8 + r110);
        if (Double.isNaN(r114) == false) goto L21;
    L14:
        if (r2 >= r1) goto L17;
        r5 = r5 + (r24[r2] * r25[r2]);
        r2 = r2 + 1;
        goto L14
    L17:
        return r5;
    L21:
        return r114;
    L5:
        return r24[0] * r25[0];
    }

    public static double linearCombination(double r18, double r20, double r22, double r24) {
        double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r18) & (-134217728));
        double r4 = r18 - r0;
        double r6 = Double.longBitsToDouble(Double.doubleToRawLongBits(r20) & (-134217728));
        double r8 = r20 - r6;
        double r10 = r18 * r20;
        double r12 = (r4 * r8) - (((r10 - (r0 * r6)) - (r4 * r6)) - (r0 * r8));
        double r1 = Double.longBitsToDouble(Double.doubleToRawLongBits(r22) & (-134217728));
        double r5 = r22 - r1;
        double r2 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(r24));
        double r7 = r24 - r2;
        double r9 = r22 * r24;
        double r14 = (r5 * r7) - (((r9 - (r1 * r2)) - (r5 * r2)) - (r1 * r7));
        double r3 = r10 + r9;
        double r11 = r3 - r9;
        double r13 = r12 + r14;
        double r15 = (r13 + ((r9 - (r3 - r11)) + (r10 - r11))) + r3;
        if (Double.isNaN(r15) == false) goto L6;
        return r3;
    L6:
        return r15;
    }

    public static double linearCombination(double r22, double r24, double r26, double r28, double r30, double r32) {
        double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r22) & (-134217728));
        double r4 = r22 - r0;
        double r6 = Double.longBitsToDouble(Double.doubleToRawLongBits(r24) & (-134217728));
        double r8 = r24 - r6;
        double r10 = r22 * r24;
        double r12 = (r4 * r8) - (((r10 - (r0 * r6)) - (r4 * r6)) - (r0 * r8));
        double r1 = Double.longBitsToDouble(Double.doubleToRawLongBits(r26) & (-134217728));
        double r5 = r26 - r1;
        double r7 = Double.longBitsToDouble(Double.doubleToRawLongBits(r28) & (-134217728));
        double r9 = r28 - r7;
        double r14 = r26 * r28;
        double r16 = (r5 * r9) - (((r14 - (r1 * r7)) - (r5 * r7)) - (r1 * r9));
        double r2 = Double.longBitsToDouble(Double.doubleToRawLongBits(r30) & (-134217728));
        double r11 = r30 - r2;
        double r3 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(r32));
        double r13 = r32 - r3;
        double r15 = r30 * r32;
        double r18 = (r11 * r13) - (((r15 - (r2 * r3)) - (r11 * r3)) - (r2 * r13));
        double r17 = r10 + r14;
        double r19 = r17 - r14;
        double r110 = (r14 - (r17 - r19)) + (r10 - r19);
        double r20 = r17 + r15;
        double r21 = r20 - r15;
        double r111 = ((r12 + r16) + r18) + r110;
        double r112 = (r111 + ((r15 - (r20 - r21)) + (r17 - r21))) + r20;
        if (Double.isNaN(r112) == false) goto L6;
        return r20;
    L6:
        return r112;
    }

    public static double linearCombination(double r26, double r28, double r30, double r32, double r34, double r36, double r38, double r40) {
        double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r26) & (-134217728));
        double r4 = r26 - r0;
        double r6 = Double.longBitsToDouble(Double.doubleToRawLongBits(r28) & (-134217728));
        double r8 = r28 - r6;
        double r10 = r26 * r28;
        double r12 = (r4 * r8) - (((r10 - (r0 * r6)) - (r4 * r6)) - (r0 * r8));
        double r1 = Double.longBitsToDouble(Double.doubleToRawLongBits(r30) & (-134217728));
        double r5 = r30 - r1;
        double r7 = Double.longBitsToDouble(Double.doubleToRawLongBits(r32) & (-134217728));
        double r9 = r32 - r7;
        double r14 = r30 * r32;
        double r16 = (r5 * r9) - (((r14 - (r1 * r7)) - (r5 * r7)) - (r1 * r9));
        double r2 = Double.longBitsToDouble(Double.doubleToRawLongBits(r34) & (-134217728));
        double r11 = r34 - r2;
        double r13 = Double.longBitsToDouble(Double.doubleToRawLongBits(r36) & (-134217728));
        double r15 = r36 - r13;
        double r18 = r34 * r36;
        double r20 = (r11 * r15) - (((r18 - (r2 * r13)) - (r11 * r13)) - (r2 * r15));
        double r3 = Double.longBitsToDouble(Double.doubleToRawLongBits(r38) & (-134217728));
        double r17 = r38 - r3;
        double r19 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(r40));
        double r21 = r40 - r19;
        double r22 = r38 * r40;
        double r23 = (r17 * r21) - (((r22 - (r3 * r19)) - (r17 * r19)) - (r3 * r21));
        double r24 = r10 + r14;
        double r25 = r24 - r14;
        double r110 = (r14 - (r24 - r25)) + (r10 - r25);
        double r27 = r24 + r18;
        double r29 = r27 - r18;
        double r111 = (r18 - (r27 - r29)) + (r24 - r29);
        double r31 = r27 + r22;
        double r33 = r31 - r22;
        double r112 = ((((r12 + r16) + r20) + r23) + r110) + r111;
        double r113 = (r112 + ((r22 - (r31 - r33)) + (r27 - r33))) + r31;
        if (Double.isNaN(r113) == false) goto L6;
        return r31;
    L6:
        return r113;
    }

    public static boolean equals(float[] r5, float[] r6) {
        boolean r1 = false;
        if (r5 == null) goto L17;
        if (r6 == null) goto L17;
        if (r5.length == r6.length) goto L9;
        return false;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r5.length) goto L16;
        if (Precision.equals(r5[r2], r6[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        if (r5 != null) goto L19;
        boolean r7 = true;
    L20:
        if (r6 != null) goto L23;
        r1 = true;
    L23:
        return !(r7 ^ r1);
    L19:
        r7 = false;
        goto L20
    }

    public static boolean equalsIncludingNaN(float[] r5, float[] r6) {
        boolean r1 = false;
        if (r5 == null) goto L17;
        if (r6 == null) goto L17;
        if (r5.length == r6.length) goto L9;
        return false;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r5.length) goto L16;
        if (Precision.equalsIncludingNaN(r5[r2], r6[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        if (r5 != null) goto L19;
        boolean r7 = true;
    L20:
        if (r6 != null) goto L23;
        r1 = true;
    L23:
        return !(r7 ^ r1);
    L19:
        r7 = false;
        goto L20
    }

    public static boolean equals(double[] r7, double[] r8) {
        boolean r1 = false;
        if (r7 == null) goto L17;
        if (r8 == null) goto L17;
        if (r7.length == r8.length) goto L9;
        return false;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r7.length) goto L16;
        if (Precision.equals(r7[r2], r8[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        if (r7 != null) goto L19;
        boolean r9 = true;
    L20:
        if (r8 != null) goto L23;
        r1 = true;
    L23:
        return !(r9 ^ r1);
    L19:
        r9 = false;
        goto L20
    }

    public static boolean equalsIncludingNaN(double[] r7, double[] r8) {
        boolean r1 = false;
        if (r7 == null) goto L17;
        if (r8 == null) goto L17;
        if (r7.length == r8.length) goto L9;
        return false;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r7.length) goto L16;
        if (Precision.equalsIncludingNaN(r7[r2], r8[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        if (r7 != null) goto L19;
        boolean r9 = true;
    L20:
        if (r8 != null) goto L23;
        r1 = true;
    L23:
        return !(r9 ^ r1);
    L19:
        r9 = false;
        goto L20
    }

    public static double[] normalizeArray(double[] r10, double r11) throws MathIllegalArgumentException, MathArithmeticException {
        int r1 = 0;
        if (Double.isInfinite(r11) == true) goto L30;
        if (Double.isNaN(r11) == true) goto L28;
        int r0 = r10.length;
        double[] r2 = new double[r0];
        int r5 = 0;
        double r6 = 0.0d;
    L7:
        if (r5 >= r0) goto L17;
        if (Double.isInfinite(r10[r5]) == true) goto L15;
        if (Double.isNaN(r10[r5]) == true) goto L13;
        r6 = r6 + r10[r5];
    L13:
        r5 = r5 + 1;
        goto L7
    L15:
        throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, new Object[]{Double.valueOf(r10[r5]), Integer.valueOf(r5)});
    L17:
        if (r6 == 0.0d) goto L26;
    L18:
        if (r1 >= r0) goto L24;
        if (Double.isNaN(r10[r1]) == false) goto L22;
        r2[r1] = Double.NaN;
    L23:
        r1 = r1 + 1;
        goto L18
    L22:
        r2[r1] = (r10[r1] * r11) / r6;
        goto L23
    L24:
        return r2;
    L26:
        throw new MathArithmeticException(LocalizedFormats.ARRAY_SUMS_TO_ZERO, new Object[0]);
    L28:
        throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_NAN, new Object[0]);
    L30:
        throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_INFINITE, new Object[0]);
    }

    public static <T> T[] buildArray(Field<T> r1, int r2) {
        T[] r3 = (T[]) ((Object[]) Array.newInstance(r1.getRuntimeClass(), r2));
        Arrays.fill(r3, r1.getZero());
        return r3;
    }

    public static <T> T[][] buildArray(Field<T> r4, int r5, int r6) {
        int r0 = 0;
        if (r6 < 0) goto L11;
        T[][] r7 = (T[][]) ((Object[][]) Array.newInstance(r4.getRuntimeClass(), new int[]{r5, r6}));
    L6:
        if (r0 >= r5) goto L9;
        Arrays.fill(r7[r0], r4.getZero());
        r0 = r0 + 1;
        goto L6
    L9:
        return r7;
    L11:
        return (T[][]) ((Object[][]) Array.newInstance(buildArray(r4, 0).getClass(), r5));
    }

    public static double[] convolve(double[] r18, double[] r19) throws NullArgumentException, NoDataException {
        MathUtils.checkNotNull(r18);
        MathUtils.checkNotNull(r19);
        int r2 = r18.length;
        int r3 = r19.length;
        if (r2 == 0) goto L14;
        if (r3 == 0) goto L14;
        int r4 = (r2 + r3) - 1;
        double[] r5 = new double[r4];
        int r7 = 0;
    L6:
        if (r7 >= r4) goto L12;
        int r8 = r7 + 1;
        int r9 = FastMath.max(0, r8 - r2);
        int r10 = r7 - r9;
        double r11 = 0.0d;
    L8:
        if (r9 >= r3) goto L11;
        if (r10 < 0) goto L11;
        r11 = r11 + (r18[r10] * r19[r9]);
        r9 = r9 + 1;
        r10 = r10 - 1;
    L11:
        r5[r7] = r11;
        r7 = r8;
        goto L6
    L12:
        return r5;
    L14:
        throw new NoDataException();
    }

    public static void shuffle(int[] r1, int r2, Position r3) {
        shuffle(r1, r2, r3, new Well19937c());
    }

    public static void shuffle(int[] r3, int r4, Position r5, RandomGenerator r6) {
        int r7 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$Position[r5.ordinal()];
        if (r7 != 1) goto L5;
        int r8 = r3.length - 1;
    L15:
        if (r8 < r4) goto L27;
        if (r8 != r4) goto L18;
        int r0 = r4;
    L19:
        int r1 = r3[r0];
        r3[r0] = r3[r8];
        r3[r8] = r1;
        r8 = r8 - 1;
        goto L15
    L18:
        r0 = new UniformIntegerDistribution(r6, r4, r8).sample();
        goto L19
    L27:
        return;
    L5:
        if (r7 != 2) goto L13;
        int r9 = 0;
    L7:
        if (r9 > r4) goto L20;
        if (r9 != r4) goto L10;
        int r2 = r4;
    L11:
        int r10 = r3[r2];
        r3[r2] = r3[r9];
        r3[r9] = r10;
        r9 = r9 + 1;
        goto L7
    L10:
        r2 = new UniformIntegerDistribution(r6, r9, r4).sample();
        goto L11
    L20:
        return;
    L13:
        throw new MathInternalError();
    }

    public static void shuffle(int[] r2, RandomGenerator r3) {
        shuffle(r2, 0, Position.TAIL, r3);
    }

    public static void shuffle(int[] r1) {
        shuffle(r1, new Well19937c());
    }

    public static int[] natural(int r2) {
        return sequence(r2, 0, 1);
    }

    public static int[] sequence(int r3, int r4, int r5) {
        int[] r0 = new int[r3];
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0[r1] = (r1 * r5) + r4;
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static boolean verifyValues(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return verifyValues(r1, r2, r3, false);
    }

    public static boolean verifyValues(double[] r3, int r4, int r5, boolean r6) throws MathIllegalArgumentException {
        if (r3 == null) goto L19;
        if (r4 < 0) goto L17;
        if (r5 < 0) goto L15;
        int r7 = r4 + r5;
        if (r7 > r3.length) goto L13;
        if (r5 != 0) goto L11;
        if (r6 == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, Integer.valueOf(r7), Integer.valueOf(r3.length), true);
    L15:
        throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(r5));
    L17:
        throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(r4));
    L19:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public static boolean verifyValues(double[] r1, double[] r2, int r3, int r4) throws MathIllegalArgumentException {
        return verifyValues(r1, r2, r3, r4, false);
    }

    public static boolean verifyValues(double[] r10, double[] r11, int r12, int r13, boolean r14) throws MathIllegalArgumentException {
        if (r11 == null) goto L31;
        if (r10 == null) goto L31;
        checkEqualLength(r11, r10);
        int r1 = r12;
        boolean r2 = false;
    L7:
        if (r1 >= (r12 + r13)) goto L25;
        double r3 = r11[r1];
        if (Double.isNaN(r3) == true) goto L24;
        if (Double.isInfinite(r3) == true) goto L22;
        if (r3 < 0.0d) goto L20;
        if (r2 == true) goto L18;
        if (r3 <= 0.0d) goto L18;
        r2 = true;
    L18:
        r1 = r1 + 1;
        goto L7
    L20:
        throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(r1), Double.valueOf(r3)});
    L22:
        throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, new Object[]{Double.valueOf(r3), Integer.valueOf(r1)});
    L24:
        throw new MathIllegalArgumentException(LocalizedFormats.NAN_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(r1)});
    L25:
        if (r2 == false) goto L29;
        return verifyValues(r10, r12, r13, r14);
    L29:
        throw new MathIllegalArgumentException(LocalizedFormats.WEIGHT_AT_LEAST_ONE_NON_ZERO, new Object[0]);
    L31:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public static double[] concatenate(double[]... r6) {
        int r0 = r6.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r6[r2].length;
        r2 = r2 + 1;
        goto L3
    L5:
        double[] r1 = new double[r3];
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r4 >= r6.length) goto L9;
        double[] r7 = r6[r4];
        int r8 = r7.length;
        System.arraycopy(r7, 0, r1, r5, r8);
        r5 = r5 + r8;
        r4 = r4 + 1;
        goto L7
    L9:
        return r1;
    }

    public static double[] unique(double[] r6) {
        TreeSet r0 = new TreeSet();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L6;
        r0.add(Double.valueOf(r6[r2]));
        r2 = r2 + 1;
        goto L4
    L6:
        int r7 = r0.size();
        double[] r3 = new double[r7];
        Iterator r4 = r0.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r1 = r1 + 1;
        r3[r7 - r1] = ((Double) r4.next()).doubleValue();
        goto L8
    L10:
        return r3;
    }
}
