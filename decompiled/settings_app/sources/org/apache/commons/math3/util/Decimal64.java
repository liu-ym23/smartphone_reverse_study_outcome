package org.apache.commons.math3.util;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public class Decimal64 extends Number implements RealFieldElement<Decimal64>, Comparable<Decimal64> {
    public static final Decimal64 NAN = null;
    public static final Decimal64 NEGATIVE_INFINITY = null;
    public static final Decimal64 ONE = null;
    public static final Decimal64 POSITIVE_INFINITY = null;
    public static final Decimal64 ZERO = null;
    private static final long serialVersionUID = 20120227;
    private final double value;

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 abs() {
        return abs2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 acos() {
        return acos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 acosh() {
        return acosh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 add(double r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object add(Object r1) throws NullArgumentException {
        return add((Decimal64) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 asin() {
        return asin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 asinh() {
        return asinh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 atan() {
        return atan3();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 atan2(Decimal64 r1) throws DimensionMismatchException {
        return atan22(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 atanh() {
        return atanh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 cbrt() {
        return cbrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 ceil() {
        return ceil2();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Decimal64 r1) {
        return compareTo2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 copySign(double r1) {
        return copySign2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 copySign(Decimal64 r1) {
        return copySign2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 cos() {
        return cos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 cosh() {
        return cosh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 divide(double r1) {
        return divide2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object divide(Object r1) throws NullArgumentException, MathArithmeticException {
        return divide((Decimal64) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 exp() {
        return exp2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 expm1() {
        return expm12();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 floor() {
        return floor2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 hypot(Decimal64 r1) throws DimensionMismatchException {
        return hypot2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(double r1, Decimal64 r3, double r4, Decimal64 r6) {
        return linearCombination2(r1, r3, r4, r6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(double r1, Decimal64 r3, double r4, Decimal64 r6, double r7, Decimal64 r9) {
        return linearCombination2(r1, r3, r4, r6, r7, r9);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(double r1, Decimal64 r3, double r4, Decimal64 r6, double r7, Decimal64 r9, double r10, Decimal64 r12) {
        return linearCombination2(r1, r3, r4, r6, r7, r9, r10, r12);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(Decimal64 r1, Decimal64 r2, Decimal64 r3, Decimal64 r4) {
        return linearCombination2(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(Decimal64 r1, Decimal64 r2, Decimal64 r3, Decimal64 r4, Decimal64 r5, Decimal64 r6) {
        return linearCombination2(r1, r2, r3, r4, r5, r6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(Decimal64 r1, Decimal64 r2, Decimal64 r3, Decimal64 r4, Decimal64 r5, Decimal64 r6, Decimal64 r7, Decimal64 r8) {
        return linearCombination2(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(double[] r1, Decimal64[] r2) throws DimensionMismatchException {
        return linearCombination2(r1, r2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 linearCombination(Decimal64[] r1, Decimal64[] r2) throws DimensionMismatchException {
        return linearCombination2(r1, r2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 log() {
        return log2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 log1p() {
        return log1p2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 multiply(double r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(int r1) {
        return multiply(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(Object r1) throws NullArgumentException {
        return multiply((Decimal64) r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 pow(double r1) {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 pow(int r1) {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 pow(Decimal64 r1) throws DimensionMismatchException {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object reciprocal() {
        return reciprocal();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 remainder(double r1) {
        return remainder2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 remainder(Decimal64 r1) throws DimensionMismatchException {
        return remainder2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 rint() {
        return rint2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 rootN(int r1) {
        return rootN2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 scalb(int r1) {
        return scalb2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 signum() {
        return signum2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 sin() {
        return sin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 sinh() {
        return sinh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 sqrt() {
        return sqrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 subtract(double r1) {
        return subtract2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object subtract(Object r1) throws NullArgumentException {
        return subtract((Decimal64) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 tan() {
        return tan2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 tanh() {
        return tanh2();
    }

    static {
        ZERO = new Decimal64(0.0d);
        ONE = new Decimal64(1.0d);
        NEGATIVE_INFINITY = new Decimal64(Double.NEGATIVE_INFINITY);
        POSITIVE_INFINITY = new Decimal64(Double.POSITIVE_INFINITY);
        NAN = new Decimal64(Double.NaN);
    }

    public Decimal64(double r1) {
        this.value = r1;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<Decimal64> getField() {
        return Decimal64Field.getInstance();
    }

    public Decimal64 add(Decimal64 r4) {
        return new Decimal64(this.value + r4.value);
    }

    public Decimal64 subtract(Decimal64 r4) {
        return new Decimal64(this.value - r4.value);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Decimal64 negate() {
        return new Decimal64(-this.value);
    }

    public Decimal64 multiply(Decimal64 r4) {
        return new Decimal64(this.value * r4.value);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Decimal64 multiply(int r4) {
        return new Decimal64(((double) r4) * this.value);
    }

    public Decimal64 divide(Decimal64 r4) {
        return new Decimal64(this.value / r4.value);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public Decimal64 reciprocal() {
        return new Decimal64(1.0d / this.value);
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return (short) this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Decimal64 r3) {
        return Double.compare(this.value, r3.value);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Decimal64) == true) goto L5;
        return false;
    L5:
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(((Decimal64) r5).value)) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.value);
        return (int) (r0 ^ (r0 >>> 32));
    }

    public String toString() {
        return Double.toString(this.value);
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.value;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public Decimal64 add2(double r4) {
        return new Decimal64(this.value + r4);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public Decimal64 subtract2(double r4) {
        return new Decimal64(this.value - r4);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Decimal64 multiply2(double r4) {
        return new Decimal64(this.value * r4);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public Decimal64 divide2(double r4) {
        return new Decimal64(this.value / r4);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: remainder, reason: avoid collision after fix types in other method */
    public Decimal64 remainder2(double r4) {
        return new Decimal64(FastMath.IEEEremainder(this.value, r4));
    }

    /* JADX INFO: renamed from: remainder, reason: avoid collision after fix types in other method */
    public Decimal64 remainder2(Decimal64 r4) {
        return new Decimal64(FastMath.IEEEremainder(this.value, r4.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: abs, reason: avoid collision after fix types in other method */
    public Decimal64 abs2() {
        return new Decimal64(FastMath.abs(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: ceil, reason: avoid collision after fix types in other method */
    public Decimal64 ceil2() {
        return new Decimal64(FastMath.ceil(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: floor, reason: avoid collision after fix types in other method */
    public Decimal64 floor2() {
        return new Decimal64(FastMath.floor(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: rint, reason: avoid collision after fix types in other method */
    public Decimal64 rint2() {
        return new Decimal64(FastMath.rint(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public long round() {
        return FastMath.round(this.value);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: signum, reason: avoid collision after fix types in other method */
    public Decimal64 signum2() {
        return new Decimal64(FastMath.signum(this.value));
    }

    /* JADX INFO: renamed from: copySign, reason: avoid collision after fix types in other method */
    public Decimal64 copySign2(Decimal64 r4) {
        return new Decimal64(FastMath.copySign(this.value, r4.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: copySign, reason: avoid collision after fix types in other method */
    public Decimal64 copySign2(double r4) {
        return new Decimal64(FastMath.copySign(this.value, r4));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: scalb, reason: avoid collision after fix types in other method */
    public Decimal64 scalb2(int r4) {
        return new Decimal64(FastMath.scalb(this.value, r4));
    }

    /* JADX INFO: renamed from: hypot, reason: avoid collision after fix types in other method */
    public Decimal64 hypot2(Decimal64 r4) {
        return new Decimal64(FastMath.hypot(this.value, r4.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sqrt, reason: avoid collision after fix types in other method */
    public Decimal64 sqrt2() {
        return new Decimal64(FastMath.sqrt(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cbrt, reason: avoid collision after fix types in other method */
    public Decimal64 cbrt2() {
        return new Decimal64(FastMath.cbrt(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: rootN, reason: avoid collision after fix types in other method */
    public Decimal64 rootN2(int r7) {
        double r0 = this.value;
        if (r0 >= 0.0d) goto L7;
        return new Decimal64(-FastMath.pow(-r0, 1.0d / ((double) r7)));
    L7:
        return new Decimal64(FastMath.pow(r0, 1.0d / ((double) r7)));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public Decimal64 pow2(double r4) {
        return new Decimal64(FastMath.pow(this.value, r4));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public Decimal64 pow2(int r4) {
        return new Decimal64(FastMath.pow(this.value, r4));
    }

    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public Decimal64 pow2(Decimal64 r4) {
        return new Decimal64(FastMath.pow(this.value, r4.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: exp, reason: avoid collision after fix types in other method */
    public Decimal64 exp2() {
        return new Decimal64(FastMath.exp(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: expm1, reason: avoid collision after fix types in other method */
    public Decimal64 expm12() {
        return new Decimal64(FastMath.expm1(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: log, reason: avoid collision after fix types in other method */
    public Decimal64 log2() {
        return new Decimal64(FastMath.log(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: log1p, reason: avoid collision after fix types in other method */
    public Decimal64 log1p2() {
        return new Decimal64(FastMath.log1p(this.value));
    }

    public Decimal64 log10() {
        return new Decimal64(FastMath.log10(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cos, reason: avoid collision after fix types in other method */
    public Decimal64 cos2() {
        return new Decimal64(FastMath.cos(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sin, reason: avoid collision after fix types in other method */
    public Decimal64 sin2() {
        return new Decimal64(FastMath.sin(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: tan, reason: avoid collision after fix types in other method */
    public Decimal64 tan2() {
        return new Decimal64(FastMath.tan(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acos, reason: avoid collision after fix types in other method */
    public Decimal64 acos2() {
        return new Decimal64(FastMath.acos(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asin, reason: avoid collision after fix types in other method */
    public Decimal64 asin2() {
        return new Decimal64(FastMath.asin(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: atan, reason: avoid collision after fix types in other method */
    public Decimal64 atan3() {
        return new Decimal64(FastMath.atan(this.value));
    }

    /* JADX INFO: renamed from: atan2, reason: avoid collision after fix types in other method */
    public Decimal64 atan22(Decimal64 r4) {
        return new Decimal64(FastMath.atan2(this.value, r4.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cosh, reason: avoid collision after fix types in other method */
    public Decimal64 cosh2() {
        return new Decimal64(FastMath.cosh(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sinh, reason: avoid collision after fix types in other method */
    public Decimal64 sinh2() {
        return new Decimal64(FastMath.sinh(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: tanh, reason: avoid collision after fix types in other method */
    public Decimal64 tanh2() {
        return new Decimal64(FastMath.tanh(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acosh, reason: avoid collision after fix types in other method */
    public Decimal64 acosh2() {
        return new Decimal64(FastMath.acosh(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asinh, reason: avoid collision after fix types in other method */
    public Decimal64 asinh2() {
        return new Decimal64(FastMath.asinh(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: atanh, reason: avoid collision after fix types in other method */
    public Decimal64 atanh2() {
        return new Decimal64(FastMath.atanh(this.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(Decimal64[] r5, Decimal64[] r6) throws DimensionMismatchException {
        if (r5.length != r6.length) goto L11;
        double[] r4 = new double[r5.length];
        double[] r0 = new double[r6.length];
        int r1 = 0;
    L6:
        if (r1 >= r5.length) goto L9;
        r4[r1] = r5[r1].value;
        r0[r1] = r6[r1].value;
        r1 = r1 + 1;
        goto L6
    L9:
        return new Decimal64(MathArrays.linearCombination(r4, r0));
    L11:
        throw new DimensionMismatchException(r5.length, r6.length);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(double[] r4, Decimal64[] r5) throws DimensionMismatchException {
        if (r4.length != r5.length) goto L11;
        double[] r3 = new double[r5.length];
        int r0 = 0;
    L6:
        if (r0 >= r4.length) goto L9;
        r3[r0] = r5[r0].value;
        r0 = r0 + 1;
        goto L6
    L9:
        return new Decimal64(MathArrays.linearCombination(r4, r3));
    L11:
        throw new DimensionMismatchException(r4.length, r5.length);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(Decimal64 r9, Decimal64 r10, Decimal64 r11, Decimal64 r12) {
        return new Decimal64(MathArrays.linearCombination(r9.value, r10.value, r11.value, r12.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(double r9, Decimal64 r11, double r12, Decimal64 r14) {
        return new Decimal64(MathArrays.linearCombination(r9, r11.value, r12, r14.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(Decimal64 r14, Decimal64 r15, Decimal64 r16, Decimal64 r17, Decimal64 r18, Decimal64 r19) {
        return new Decimal64(MathArrays.linearCombination(r14.value, r15.value, r16.value, r17.value, r18.value, r19.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(double r14, Decimal64 r16, double r17, Decimal64 r19, double r20, Decimal64 r22) {
        return new Decimal64(MathArrays.linearCombination(r14, r16.value, r17, r19.value, r20, r22.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(Decimal64 r18, Decimal64 r19, Decimal64 r20, Decimal64 r21, Decimal64 r22, Decimal64 r23, Decimal64 r24, Decimal64 r25) {
        return new Decimal64(MathArrays.linearCombination(r18.value, r19.value, r20.value, r21.value, r22.value, r23.value, r24.value, r25.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(double r18, Decimal64 r20, double r21, Decimal64 r23, double r24, Decimal64 r26, double r27, Decimal64 r29) {
        return new Decimal64(MathArrays.linearCombination(r18, r20.value, r21, r23.value, r24, r26.value, r27, r29.value));
    }
}
