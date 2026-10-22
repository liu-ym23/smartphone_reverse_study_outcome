package org.apache.commons.math3.analysis.differentiation;

import android.icu.lang.UCharacter;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DerivativeStructure implements RealFieldElement<DerivativeStructure>, Serializable {
    private static final long serialVersionUID = 20120730;
    private transient DSCompiler compiler;
    private final double[] data;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120730;
        private final double[] data;
        private final int order;
        private final int variables;

        DataTransferObject(int r1, int r2, double[] r3) {
            this.variables = r1;
            this.order = r2;
            this.data = r3;
        }

        private Object readResolve() {
            return new DerivativeStructure(this.variables, this.order, this.data);
        }
    }

    static /* synthetic */ DSCompiler access$000(DerivativeStructure r0) {
        return r0.compiler;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure abs() {
        return abs2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure acos() {
        return acos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure acosh() {
        return acosh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure add(double r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object add(Object r1) throws NullArgumentException {
        return add((DerivativeStructure) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure asin() {
        return asin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure asinh() {
        return asinh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure atan() {
        return atan3();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure atan2(DerivativeStructure r1) throws DimensionMismatchException {
        return atan22(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure atanh() {
        return atanh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure cbrt() {
        return cbrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure ceil() {
        return ceil2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure copySign(double r1) {
        return copySign2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure copySign(DerivativeStructure r1) {
        return copySign2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure cos() {
        return cos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure cosh() {
        return cosh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure divide(double r1) {
        return divide2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object divide(Object r1) throws NullArgumentException, MathArithmeticException {
        return divide((DerivativeStructure) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure exp() {
        return exp2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure expm1() {
        return expm12();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure floor() {
        return floor2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure hypot(DerivativeStructure r1) throws DimensionMismatchException {
        return hypot2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(double r1, DerivativeStructure r3, double r4, DerivativeStructure r6) {
        return linearCombination2(r1, r3, r4, r6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(double r1, DerivativeStructure r3, double r4, DerivativeStructure r6, double r7, DerivativeStructure r9) {
        return linearCombination2(r1, r3, r4, r6, r7, r9);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(double r1, DerivativeStructure r3, double r4, DerivativeStructure r6, double r7, DerivativeStructure r9, double r10, DerivativeStructure r12) {
        return linearCombination2(r1, r3, r4, r6, r7, r9, r10, r12);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(DerivativeStructure r1, DerivativeStructure r2, DerivativeStructure r3, DerivativeStructure r4) {
        return linearCombination2(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(DerivativeStructure r1, DerivativeStructure r2, DerivativeStructure r3, DerivativeStructure r4, DerivativeStructure r5, DerivativeStructure r6) {
        return linearCombination2(r1, r2, r3, r4, r5, r6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(DerivativeStructure r1, DerivativeStructure r2, DerivativeStructure r3, DerivativeStructure r4, DerivativeStructure r5, DerivativeStructure r6, DerivativeStructure r7, DerivativeStructure r8) {
        return linearCombination2(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(double[] r1, DerivativeStructure[] r2) throws DimensionMismatchException {
        return linearCombination2(r1, r2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure linearCombination(DerivativeStructure[] r1, DerivativeStructure[] r2) throws DimensionMismatchException {
        return linearCombination2(r1, r2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure log() {
        return log2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure log1p() {
        return log1p2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure multiply(double r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(int r1) {
        return multiply(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(Object r1) throws NullArgumentException {
        return multiply((DerivativeStructure) r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure pow(double r1) {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure pow(int r1) {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure pow(DerivativeStructure r1) throws DimensionMismatchException {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object reciprocal() {
        return reciprocal();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure remainder(double r1) {
        return remainder2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure remainder(DerivativeStructure r1) throws DimensionMismatchException {
        return remainder2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure rint() {
        return rint2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure rootN(int r1) {
        return rootN2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure scalb(int r1) {
        return scalb2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure signum() {
        return signum2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure sin() {
        return sin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure sinh() {
        return sinh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure sqrt() {
        return sqrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure subtract(double r1) {
        return subtract2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object subtract(Object r1) throws NullArgumentException {
        return subtract((DerivativeStructure) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure tan() {
        return tan2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure tanh() {
        return tanh2();
    }

    private DerivativeStructure(DSCompiler r1) {
        this.compiler = r1;
        this.data = new double[r1.getSize()];
    }

    public DerivativeStructure(int r1, int r2) throws NumberIsTooLargeException {
        this(DSCompiler.getCompiler(r1, r2));
    }

    public DerivativeStructure(int r1, int r2, double r3) throws NumberIsTooLargeException {
        this(r1, r2);
        this.data[0] = r3;
    }

    public DerivativeStructure(int r1, int r2, int r3, double r4) throws NumberIsTooLargeException {
        this(r1, r2, r4);
        if (r3 >= r1) goto L8;
        if (r2 <= 0) goto L9;
        this.data[DSCompiler.getCompiler(r3, r2).getSize()] = 1.0d;
        return;
    L9:
        return;
    L8:
        throw new NumberIsTooLargeException(Integer.valueOf(r3), Integer.valueOf(r1), false);
    }

    public DerivativeStructure(double r17, DerivativeStructure r19, double r20, DerivativeStructure r22) throws DimensionMismatchException {
        this(r19.compiler);
        this.compiler.checkCompatibility(r22.compiler);
        this.compiler.linearCombination(r17, r19.data, 0, r20, r22.data, 0, this.data, 0);
    }

    public DerivativeStructure(double r22, DerivativeStructure r24, double r25, DerivativeStructure r27, double r28, DerivativeStructure r30) throws DimensionMismatchException {
        this(r24.compiler);
        this.compiler.checkCompatibility(r27.compiler);
        this.compiler.checkCompatibility(r30.compiler);
        this.compiler.linearCombination(r22, r24.data, 0, r25, r27.data, 0, r28, r30.data, 0, this.data, 0);
    }

    public DerivativeStructure(double r25, DerivativeStructure r27, double r28, DerivativeStructure r30, double r31, DerivativeStructure r33, double r34, DerivativeStructure r36) throws DimensionMismatchException {
        this(r27.compiler);
        this.compiler.checkCompatibility(r30.compiler);
        this.compiler.checkCompatibility(r33.compiler);
        this.compiler.checkCompatibility(r36.compiler);
        this.compiler.linearCombination(r25, r27.data, 0, r28, r30.data, 0, r31, r33.data, 0, r34, r36.data, 0, this.data, 0);
    }

    public DerivativeStructure(int r2, int r3, double... r4) throws DimensionMismatchException, NumberIsTooLargeException {
        this(r2, r3);
        int r5 = r4.length;
        double[] r6 = this.data;
        if (r5 != r6.length) goto L7;
        System.arraycopy(r4, 0, r6, 0, r6.length);
        return;
    L7:
        throw new DimensionMismatchException(r4.length, this.data.length);
    }

    private DerivativeStructure(DerivativeStructure r2) {
        this.compiler = r2.compiler;
        this.data = (double[]) r2.data.clone();
    }

    public int getFreeParameters() {
        return this.compiler.getFreeParameters();
    }

    public int getOrder() {
        return this.compiler.getOrder();
    }

    public DerivativeStructure createConstant(double r3) {
        return new DerivativeStructure(getFreeParameters(), getOrder(), r3);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.data[0];
    }

    public double getValue() {
        return this.data[0];
    }

    public double getPartialDerivative(int... r2) throws DimensionMismatchException, NumberIsTooLargeException {
        return this.data[this.compiler.getPartialDerivativeIndex(r2)];
    }

    public double[] getAllDerivatives() {
        return (double[]) this.data.clone();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public DerivativeStructure add2(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        double[] r4 = r0.data;
        r4[0] = r4[0] + r5;
        return r0;
    }

    public DerivativeStructure add(DerivativeStructure r9) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r9.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this);
        this.compiler.add(this.data, 0, r9.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public DerivativeStructure subtract2(double r1) {
        return add2(-r1);
    }

    public DerivativeStructure subtract(DerivativeStructure r9) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r9.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this);
        this.compiler.subtract(this.data, 0, r9.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure multiply(int r3) {
        return multiply2(r3);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public DerivativeStructure multiply2(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        int r4 = 0;
    L3:
        double[] r1 = r0.data;
        if (r4 >= r1.length) goto L6;
        r1[r4] = r1[r4] * r5;
        r4 = r4 + 1;
        goto L3
    L6:
        return r0;
    }

    public DerivativeStructure multiply(DerivativeStructure r10) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.multiply(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public DerivativeStructure divide2(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        int r4 = 0;
    L3:
        double[] r1 = r0.data;
        if (r4 >= r1.length) goto L6;
        r1[r4] = r1[r4] / r5;
        r4 = r4 + 1;
        goto L3
    L6:
        return r0;
    }

    public DerivativeStructure divide(DerivativeStructure r10) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.divide(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: remainder, reason: avoid collision after fix types in other method */
    public DerivativeStructure remainder2(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        double[] r4 = r0.data;
        r4[0] = FastMath.IEEEremainder(r4[0], r5);
        return r0;
    }

    /* JADX INFO: renamed from: remainder, reason: avoid collision after fix types in other method */
    public DerivativeStructure remainder2(DerivativeStructure r10) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.remainder(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure negate() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = -this.data[r1];
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: abs, reason: avoid collision after fix types in other method */
    public DerivativeStructure abs2() {
        if (Double.doubleToLongBits(this.data[0]) < 0) goto L5;
        return this;
    L5:
        return negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: ceil, reason: avoid collision after fix types in other method */
    public DerivativeStructure ceil2() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.ceil(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: floor, reason: avoid collision after fix types in other method */
    public DerivativeStructure floor2() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.floor(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: rint, reason: avoid collision after fix types in other method */
    public DerivativeStructure rint2() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.rint(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public long round() {
        return FastMath.round(this.data[0]);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: signum, reason: avoid collision after fix types in other method */
    public DerivativeStructure signum2() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.signum(this.data[0]));
    }

    /* JADX INFO: renamed from: copySign, reason: avoid collision after fix types in other method */
    public DerivativeStructure copySign2(DerivativeStructure r7) {
        long r2 = Double.doubleToLongBits(this.data[0]);
        long r0 = Double.doubleToLongBits(r7.data[0]);
        if (r2 >= 0) goto L5;
    L6:
        if (r2 >= 0) goto L11;
        if (r0 >= 0) goto L11;
    L9:
        return this;
    L11:
        return negate();
    L5:
        if (r0 >= 0) goto L9;
        goto L6
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: copySign, reason: avoid collision after fix types in other method */
    public DerivativeStructure copySign2(double r5) {
        long r0 = Double.doubleToLongBits(this.data[0]);
        long r6 = Double.doubleToLongBits(r5);
        if (r0 >= 0) goto L5;
    L6:
        if (r0 >= 0) goto L11;
        if (r6 >= 0) goto L11;
    L9:
        return this;
    L11:
        return negate();
    L5:
        if (r6 >= 0) goto L9;
        goto L6
    }

    public int getExponent() {
        return FastMath.getExponent(this.data[0]);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: scalb, reason: avoid collision after fix types in other method */
    public DerivativeStructure scalb2(int r6) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = FastMath.scalb(this.data[r1], r6);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: hypot, reason: avoid collision after fix types in other method */
    public DerivativeStructure hypot2(DerivativeStructure r5) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r5.compiler);
        if (Double.isInfinite(this.data[0]) == true) goto L25;
        if (Double.isInfinite(r5.data[0]) == true) goto L25;
        if (Double.isNaN(this.data[0]) == true) goto L23;
        if (Double.isNaN(r5.data[0]) == true) goto L23;
        int r0 = getExponent();
        int r1 = r5.getExponent();
        if (r0 <= (r1 + 27)) goto L17;
        return abs2();
    L17:
        if (r1 > (r0 + 27)) goto L19;
        int r2 = (r0 + r1) / 2;
        int r3 = -r2;
        DerivativeStructure r4 = scalb2(r3);
        DerivativeStructure r6 = r5.scalb2(r3);
        return r4.multiply(r4).add(r6.multiply(r6)).sqrt2().scalb2(r2);
    L19:
        return r5.abs2();
    L23:
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getFreeParameters(), Double.NaN);
    L25:
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getFreeParameters(), Double.POSITIVE_INFINITY);
    }

    public static DerivativeStructure hypot(DerivativeStructure r0, DerivativeStructure r1) throws DimensionMismatchException {
        return r0.hypot2(r1);
    }

    public DerivativeStructure compose(double... r9) throws DimensionMismatchException {
        if (r9.length != (getOrder() + 1)) goto L7;
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.compose(this.data, 0, r9, r0.data, 0);
        return r0;
    L7:
        throw new DimensionMismatchException(r9.length, getOrder() + 1);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public DerivativeStructure reciprocal() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, -1, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sqrt, reason: avoid collision after fix types in other method */
    public DerivativeStructure sqrt2() {
        return rootN2(2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cbrt, reason: avoid collision after fix types in other method */
    public DerivativeStructure cbrt2() {
        return rootN2(3);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: rootN, reason: avoid collision after fix types in other method */
    public DerivativeStructure rootN2(int r9) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.rootN(this.data, 0, r9, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<DerivativeStructure> getField() {
        return new AnonymousClass1(this);
    }

    public static DerivativeStructure pow(double r9, DerivativeStructure r11) {
        DerivativeStructure r0 = new DerivativeStructure(r11.compiler);
        r11.compiler.pow(r9, r11.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public DerivativeStructure pow2(double r10) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, r10, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public DerivativeStructure pow2(int r9) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, r9, r0.data, 0);
        return r0;
    }

    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public DerivativeStructure pow2(DerivativeStructure r10) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: exp, reason: avoid collision after fix types in other method */
    public DerivativeStructure exp2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.exp(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: expm1, reason: avoid collision after fix types in other method */
    public DerivativeStructure expm12() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.expm1(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: log, reason: avoid collision after fix types in other method */
    public DerivativeStructure log2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.log(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: log1p, reason: avoid collision after fix types in other method */
    public DerivativeStructure log1p2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.log1p(this.data, 0, r0.data, 0);
        return r0;
    }

    public DerivativeStructure log10() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.log10(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cos, reason: avoid collision after fix types in other method */
    public DerivativeStructure cos2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.cos(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sin, reason: avoid collision after fix types in other method */
    public DerivativeStructure sin2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.sin(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: tan, reason: avoid collision after fix types in other method */
    public DerivativeStructure tan2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.tan(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acos, reason: avoid collision after fix types in other method */
    public DerivativeStructure acos2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.acos(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asin, reason: avoid collision after fix types in other method */
    public DerivativeStructure asin2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.asin(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: atan, reason: avoid collision after fix types in other method */
    public DerivativeStructure atan3() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.atan(this.data, 0, r0.data, 0);
        return r0;
    }

    /* JADX INFO: renamed from: atan2, reason: avoid collision after fix types in other method */
    public DerivativeStructure atan22(DerivativeStructure r10) throws DimensionMismatchException {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.atan2(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    public static DerivativeStructure atan2(DerivativeStructure r0, DerivativeStructure r1) throws DimensionMismatchException {
        return r0.atan22(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cosh, reason: avoid collision after fix types in other method */
    public DerivativeStructure cosh2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.cosh(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sinh, reason: avoid collision after fix types in other method */
    public DerivativeStructure sinh2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.sinh(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: tanh, reason: avoid collision after fix types in other method */
    public DerivativeStructure tanh2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.tanh(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acosh, reason: avoid collision after fix types in other method */
    public DerivativeStructure acosh2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.acosh(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asinh, reason: avoid collision after fix types in other method */
    public DerivativeStructure asinh2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.asinh(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: atanh, reason: avoid collision after fix types in other method */
    public DerivativeStructure atanh2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.atanh(this.data, 0, r0.data, 0);
        return r0;
    }

    public DerivativeStructure toDegrees() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = FastMath.toDegrees(this.data[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public DerivativeStructure toRadians() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = FastMath.toRadians(this.data[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public double taylor(double... r3) throws MathArithmeticException {
        return this.compiler.taylor(this.data, 0, r3);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(DerivativeStructure[] r7, DerivativeStructure[] r8) throws DimensionMismatchException {
        double[] r6 = new double[r7.length];
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L6;
        r6[r1] = r7[r1].getValue();
        r1 = r1 + 1;
        goto L4
    L6:
        double[] r2 = new double[r8.length];
        int r3 = 0;
    L8:
        if (r3 >= r8.length) goto L10;
        r2[r3] = r8[r3].getValue();
        r3 = r3 + 1;
        goto L8
    L10:
        double r4 = MathArrays.linearCombination(r6, r2);
        DerivativeStructure r9 = r7[0].getField().getZero();
        int r5 = 0;
    L12:
        if (r5 >= r7.length) goto L14;
        r9 = r9.add(r7[r5].multiply(r8[r5]));
        r5 = r5 + 1;
        goto L12
    L14:
        double[] r10 = r9.getAllDerivatives();
        r10[0] = r4;
        return new DerivativeStructure(r9.getFreeParameters(), r9.getOrder(), r10);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(double[] r8, DerivativeStructure[] r9) throws DimensionMismatchException {
        double[] r7 = new double[r9.length];
        int r1 = 0;
    L4:
        if (r1 >= r9.length) goto L6;
        r7[r1] = r9[r1].getValue();
        r1 = r1 + 1;
        goto L4
    L6:
        double r2 = MathArrays.linearCombination(r8, r7);
        DerivativeStructure r10 = r9[0].getField().getZero();
        int r3 = 0;
    L8:
        if (r3 >= r8.length) goto L10;
        r10 = r10.add(r9[r3].multiply2(r8[r3]));
        r3 = r3 + 1;
        goto L8
    L10:
        double[] r11 = r10.getAllDerivatives();
        r11[0] = r2;
        return new DerivativeStructure(r10.getFreeParameters(), r10.getOrder(), r11);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(DerivativeStructure r9, DerivativeStructure r10, DerivativeStructure r11, DerivativeStructure r12) throws DimensionMismatchException {
        double r0 = MathArrays.linearCombination(r9.getValue(), r10.getValue(), r11.getValue(), r12.getValue());
        double[] r13 = r9.multiply(r10).add(r11.multiply(r12)).getAllDerivatives();
        r13[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r13);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(double r9, DerivativeStructure r11, double r12, DerivativeStructure r14) throws DimensionMismatchException {
        double r0 = MathArrays.linearCombination(r9, r11.getValue(), r12, r14.getValue());
        double[] r10 = r11.multiply2(r9).add(r14.multiply2(r12)).getAllDerivatives();
        r10[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r10);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(DerivativeStructure r13, DerivativeStructure r14, DerivativeStructure r15, DerivativeStructure r16, DerivativeStructure r17, DerivativeStructure r18) throws DimensionMismatchException {
        double r0 = MathArrays.linearCombination(r13.getValue(), r14.getValue(), r15.getValue(), r16.getValue(), r17.getValue(), r18.getValue());
        double[] r2 = r13.multiply(r14).add(r15.multiply(r16)).add(r17.multiply(r18)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(double r13, DerivativeStructure r15, double r16, DerivativeStructure r18, double r19, DerivativeStructure r21) throws DimensionMismatchException {
        double r0 = MathArrays.linearCombination(r13, r15.getValue(), r16, r18.getValue(), r19, r21.getValue());
        double[] r2 = r15.multiply2(r13).add(r18.multiply2(r16)).add(r21.multiply2(r19)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(DerivativeStructure r17, DerivativeStructure r18, DerivativeStructure r19, DerivativeStructure r20, DerivativeStructure r21, DerivativeStructure r22, DerivativeStructure r23, DerivativeStructure r24) throws DimensionMismatchException {
        double r0 = MathArrays.linearCombination(r17.getValue(), r18.getValue(), r19.getValue(), r20.getValue(), r21.getValue(), r22.getValue(), r23.getValue(), r24.getValue());
        double[] r2 = r17.multiply(r18).add(r19.multiply(r20)).add(r21.multiply(r22)).add(r23.multiply(r24)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(double r17, DerivativeStructure r19, double r20, DerivativeStructure r22, double r23, DerivativeStructure r25, double r26, DerivativeStructure r28) throws DimensionMismatchException {
        double r0 = MathArrays.linearCombination(r17, r19.getValue(), r20, r22.getValue(), r23, r25.getValue(), r26, r28.getValue());
        double[] r2 = r19.multiply2(r17).add(r22.multiply2(r20)).add(r25.multiply2(r23)).add(r28.multiply2(r26)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DerivativeStructure) == false) goto L16;
        DerivativeStructure r6 = (DerivativeStructure) r5;
        if (getFreeParameters() != r6.getFreeParameters()) goto L15;
        if (getOrder() != r6.getOrder()) goto L15;
        if (MathArrays.equals(this.data, r6.data) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return (((getFreeParameters() * UCharacter.UnicodeBlock.KHOJKI_ID) + UCharacter.UnicodeBlock.GEOMETRIC_SHAPES_EXTENDED_ID) + (getOrder() * 233)) + (MathUtils.hash(this.data) * UCharacter.UnicodeBlock.NABATAEAN_ID);
    }

    private Object writeReplace() {
        return new DataTransferObject(this.compiler.getFreeParameters(), this.compiler.getOrder(), this.data);
    }
}
