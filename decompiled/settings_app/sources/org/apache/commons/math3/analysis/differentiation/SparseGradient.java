package org.apache.commons.math3.analysis.differentiation;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SparseGradient implements RealFieldElement<SparseGradient>, Serializable {
    private static final long serialVersionUID = 20131025;
    private final Map<Integer, Double> derivatives;
    private double value;

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient abs() {
        return abs2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient acos() {
        return acos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient acosh() {
        return acosh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient add(double r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object add(Object r1) throws NullArgumentException {
        return add((SparseGradient) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient asin() {
        return asin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient asinh() {
        return asinh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient atan() {
        return atan3();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient atan2(SparseGradient r1) throws DimensionMismatchException {
        return atan22(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient atanh() {
        return atanh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient cbrt() {
        return cbrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient ceil() {
        return ceil2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient copySign(double r1) {
        return copySign2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient copySign(SparseGradient r1) {
        return copySign2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient cos() {
        return cos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient cosh() {
        return cosh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient divide(double r1) {
        return divide2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object divide(Object r1) throws NullArgumentException, MathArithmeticException {
        return divide((SparseGradient) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient exp() {
        return exp2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient expm1() {
        return expm12();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient floor() {
        return floor2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient hypot(SparseGradient r1) throws DimensionMismatchException {
        return hypot2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(double r1, SparseGradient r3, double r4, SparseGradient r6) {
        return linearCombination2(r1, r3, r4, r6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(double r1, SparseGradient r3, double r4, SparseGradient r6, double r7, SparseGradient r9) {
        return linearCombination2(r1, r3, r4, r6, r7, r9);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(double r1, SparseGradient r3, double r4, SparseGradient r6, double r7, SparseGradient r9, double r10, SparseGradient r12) {
        return linearCombination2(r1, r3, r4, r6, r7, r9, r10, r12);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(SparseGradient r1, SparseGradient r2, SparseGradient r3, SparseGradient r4) {
        return linearCombination2(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(SparseGradient r1, SparseGradient r2, SparseGradient r3, SparseGradient r4, SparseGradient r5, SparseGradient r6) {
        return linearCombination2(r1, r2, r3, r4, r5, r6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(SparseGradient r1, SparseGradient r2, SparseGradient r3, SparseGradient r4, SparseGradient r5, SparseGradient r6, SparseGradient r7, SparseGradient r8) {
        return linearCombination2(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(double[] r1, SparseGradient[] r2) throws DimensionMismatchException {
        return linearCombination2(r1, r2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient linearCombination(SparseGradient[] r1, SparseGradient[] r2) throws DimensionMismatchException {
        return linearCombination2(r1, r2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient log() {
        return log2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient log1p() {
        return log1p2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient multiply(double r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(int r1) {
        return multiply(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(Object r1) throws NullArgumentException {
        return multiply((SparseGradient) r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient pow(double r1) {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient pow(int r1) {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient pow(SparseGradient r1) throws DimensionMismatchException {
        return pow2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object reciprocal() {
        return reciprocal();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient remainder(double r1) {
        return remainder2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient remainder(SparseGradient r1) throws DimensionMismatchException {
        return remainder2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient rint() {
        return rint2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient rootN(int r1) {
        return rootN2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient scalb(int r1) {
        return scalb2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient signum() {
        return signum2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient sin() {
        return sin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient sinh() {
        return sinh2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient sqrt() {
        return sqrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient subtract(double r1) {
        return subtract2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object subtract(Object r1) throws NullArgumentException {
        return subtract((SparseGradient) r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient tan() {
        return tan2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient tanh() {
        return tanh2();
    }

    private SparseGradient(double r1, Map<Integer, Double> r3) {
        this.value = r1;
        HashMap r2 = new HashMap();
        this.derivatives = r2;
        if (r3 == null) goto L6;
        r2.putAll(r3);
        return;
    }

    private SparseGradient(double r4, double r6, Map<Integer, Double> r8) {
        this.value = r4;
        this.derivatives = new HashMap();
        if (r8 == null) goto L8;
        Iterator<Map.Entry<Integer, Double>> r5 = r8.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<Integer, Double> r7 = r5.next();
        this.derivatives.put(r7.getKey(), Double.valueOf(r7.getValue().doubleValue() * r6));
        goto L6
    L10:
        return;
    }

    public static SparseGradient createConstant(double r2) {
        return new SparseGradient(r2, Collections.emptyMap());
    }

    public static SparseGradient createVariable(int r3, double r4) {
        return new SparseGradient(r4, Collections.singletonMap(Integer.valueOf(r3), Double.valueOf(1.0d)));
    }

    public int numVars() {
        return this.derivatives.size();
    }

    public double getDerivative(int r1) {
        Double r0 = this.derivatives.get(Integer.valueOf(r1));
        if (r0 != null) goto L6;
        return 0.0d;
    L6:
        return r0.doubleValue();
    }

    public double getValue() {
        return this.value;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.value;
    }

    public SparseGradient add(SparseGradient r9) {
        SparseGradient r0 = new SparseGradient(this.value + r9.value, this.derivatives);
        Iterator<Map.Entry<Integer, Double>> r8 = r9.derivatives.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<Integer, Double> r10 = r8.next();
        int r1 = r10.getKey().intValue();
        Double r2 = r0.derivatives.get(Integer.valueOf(r1));
        if (r2 == null) goto L7;
        r0.derivatives.put(Integer.valueOf(r1), Double.valueOf(r2.doubleValue() + r10.getValue().doubleValue()));
        goto L4
    L7:
        r0.derivatives.put(Integer.valueOf(r1), r10.getValue());
        goto L4
    L9:
        return r0;
    }

    public void addInPlace(SparseGradient r9) {
        this.value += r9.value;
        Iterator<Map.Entry<Integer, Double>> r10 = r9.derivatives.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<Integer, Double> r0 = r10.next();
        int r1 = r0.getKey().intValue();
        Double r2 = this.derivatives.get(Integer.valueOf(r1));
        if (r2 == null) goto L7;
        this.derivatives.put(Integer.valueOf(r1), Double.valueOf(r2.doubleValue() + r0.getValue().doubleValue()));
        goto L4
    L7:
        this.derivatives.put(Integer.valueOf(r1), r0.getValue());
        goto L4
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public SparseGradient add2(double r4) {
        return new SparseGradient(this.value + r4, this.derivatives);
    }

    public SparseGradient subtract(SparseGradient r9) {
        SparseGradient r0 = new SparseGradient(this.value - r9.value, this.derivatives);
        Iterator<Map.Entry<Integer, Double>> r8 = r9.derivatives.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<Integer, Double> r10 = r8.next();
        int r1 = r10.getKey().intValue();
        Double r2 = r0.derivatives.get(Integer.valueOf(r1));
        if (r2 == null) goto L7;
        r0.derivatives.put(Integer.valueOf(r1), Double.valueOf(r2.doubleValue() - r10.getValue().doubleValue()));
        goto L4
    L7:
        r0.derivatives.put(Integer.valueOf(r1), Double.valueOf(-r10.getValue().doubleValue()));
        goto L4
    L9:
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public SparseGradient subtract2(double r4) {
        return new SparseGradient(this.value - r4, this.derivatives);
    }

    public SparseGradient multiply(SparseGradient r12) {
        SparseGradient r0 = new SparseGradient(this.value * r12.value, Collections.emptyMap());
        Iterator<Map.Entry<Integer, Double>> r1 = this.derivatives.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<Integer, Double> r2 = r1.next();
        r0.derivatives.put(r2.getKey(), Double.valueOf(r12.value * r2.getValue().doubleValue()));
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Double>> r13 = r12.derivatives.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L13;
        Map.Entry<Integer, Double> r3 = r13.next();
        int r4 = r3.getKey().intValue();
        Double r5 = r0.derivatives.get(Integer.valueOf(r4));
        if (r5 == null) goto L11;
        r0.derivatives.put(Integer.valueOf(r4), Double.valueOf(r5.doubleValue() + (this.value * r3.getValue().doubleValue())));
        goto L8
    L11:
        r0.derivatives.put(Integer.valueOf(r4), Double.valueOf(this.value * r3.getValue().doubleValue()));
        goto L8
    L13:
        return r0;
    }

    public void multiplyInPlace(SparseGradient r12) {
        Iterator<Map.Entry<Integer, Double>> r0 = this.derivatives.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<Integer, Double> r1 = r0.next();
        this.derivatives.put(r1.getKey(), Double.valueOf(r12.value * r1.getValue().doubleValue()));
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Double>> r2 = r12.derivatives.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<Integer, Double> r3 = r2.next();
        int r4 = r3.getKey().intValue();
        Double r5 = this.derivatives.get(Integer.valueOf(r4));
        if (r5 == null) goto L11;
        this.derivatives.put(Integer.valueOf(r4), Double.valueOf(r5.doubleValue() + (this.value * r3.getValue().doubleValue())));
        goto L8
    L11:
        this.derivatives.put(Integer.valueOf(r4), Double.valueOf(this.value * r3.getValue().doubleValue()));
        goto L8
    L13:
        this.value *= r12.value;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public SparseGradient multiply2(double r8) {
        return new SparseGradient(this.value * r8, r8, this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient multiply(int r8) {
        double r3 = r8;
        return new SparseGradient(this.value * r3, r3, this.derivatives);
    }

    public SparseGradient divide(SparseGradient r12) {
        SparseGradient r0 = new SparseGradient(this.value / r12.value, Collections.emptyMap());
        Iterator<Map.Entry<Integer, Double>> r11 = this.derivatives.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<Integer, Double> r1 = r11.next();
        r0.derivatives.put(r1.getKey(), Double.valueOf(r1.getValue().doubleValue() / r12.value));
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Double>> r13 = r12.derivatives.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L13;
        Map.Entry<Integer, Double> r2 = r13.next();
        int r3 = r2.getKey().intValue();
        Double r4 = r0.derivatives.get(Integer.valueOf(r3));
        if (r4 == null) goto L11;
        r0.derivatives.put(Integer.valueOf(r3), Double.valueOf(r4.doubleValue() - ((r0.value / r12.value) * r2.getValue().doubleValue())));
        goto L8
    L11:
        r0.derivatives.put(Integer.valueOf(r3), Double.valueOf(((-r0.value) / r12.value) * r2.getValue().doubleValue()));
        goto L8
    L13:
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public SparseGradient divide2(double r8) {
        return new SparseGradient(this.value / r8, 1.0d / r8, this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient negate() {
        return new SparseGradient(-this.value, -1.0d, this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<SparseGradient> getField() {
        return new AnonymousClass1(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: remainder, reason: avoid collision after fix types in other method */
    public SparseGradient remainder2(double r4) {
        return new SparseGradient(FastMath.IEEEremainder(this.value, r4), this.derivatives);
    }

    /* JADX INFO: renamed from: remainder, reason: avoid collision after fix types in other method */
    public SparseGradient remainder2(SparseGradient r5) {
        double r0 = FastMath.IEEEremainder(this.value, r5.value);
        return subtract(r5.multiply2(FastMath.rint((this.value - r0) / r5.value)));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: abs, reason: avoid collision after fix types in other method */
    public SparseGradient abs2() {
        if (Double.doubleToLongBits(this.value) < 0) goto L5;
        return this;
    L5:
        return negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: ceil, reason: avoid collision after fix types in other method */
    public SparseGradient ceil2() {
        return createConstant(FastMath.ceil(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: floor, reason: avoid collision after fix types in other method */
    public SparseGradient floor2() {
        return createConstant(FastMath.floor(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: rint, reason: avoid collision after fix types in other method */
    public SparseGradient rint2() {
        return createConstant(FastMath.rint(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public long round() {
        return FastMath.round(this.value);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: signum, reason: avoid collision after fix types in other method */
    public SparseGradient signum2() {
        return createConstant(FastMath.signum(this.value));
    }

    /* JADX INFO: renamed from: copySign, reason: avoid collision after fix types in other method */
    public SparseGradient copySign2(SparseGradient r7) {
        long r0 = Double.doubleToLongBits(this.value);
        long r2 = Double.doubleToLongBits(r7.value);
        if (r0 >= 0) goto L5;
    L6:
        if (r0 >= 0) goto L11;
        if (r2 >= 0) goto L11;
    L9:
        return this;
    L11:
        return negate();
    L5:
        if (r2 >= 0) goto L9;
        goto L6
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: copySign, reason: avoid collision after fix types in other method */
    public SparseGradient copySign2(double r5) {
        long r0 = Double.doubleToLongBits(this.value);
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

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: scalb, reason: avoid collision after fix types in other method */
    public SparseGradient scalb2(int r7) {
        SparseGradient r0 = new SparseGradient(FastMath.scalb(this.value, r7), Collections.emptyMap());
        Iterator<Map.Entry<Integer, Double>> r6 = this.derivatives.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<Integer, Double> r1 = r6.next();
        r0.derivatives.put(r1.getKey(), Double.valueOf(FastMath.scalb(r1.getValue().doubleValue(), r7)));
        goto L4
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: hypot, reason: avoid collision after fix types in other method */
    public SparseGradient hypot2(SparseGradient r4) {
        if (Double.isInfinite(this.value) == true) goto L25;
        if (Double.isInfinite(r4.value) == true) goto L25;
        if (Double.isNaN(this.value) == true) goto L23;
        if (Double.isNaN(r4.value) == true) goto L23;
        int r0 = FastMath.getExponent(this.value);
        int r1 = FastMath.getExponent(r4.value);
        if (r0 <= (r1 + 27)) goto L17;
        return abs2();
    L17:
        if (r1 > (r0 + 27)) goto L19;
        int r2 = (r0 + r1) / 2;
        int r3 = -r2;
        SparseGradient r5 = scalb2(r3);
        SparseGradient r6 = r4.scalb2(r3);
        return r5.multiply(r5).add(r6.multiply(r6)).sqrt2().scalb2(r2);
    L19:
        return r4.abs2();
    L23:
        return createConstant(Double.NaN);
    L25:
        return createConstant(Double.POSITIVE_INFINITY);
    }

    public static SparseGradient hypot(SparseGradient r0, SparseGradient r1) {
        return r0.hypot2(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public SparseGradient reciprocal() {
        double r0 = this.value;
        return new SparseGradient(1.0d / r0, (-1.0d) / (r0 * r0), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sqrt, reason: avoid collision after fix types in other method */
    public SparseGradient sqrt2() {
        double r3 = FastMath.sqrt(this.value);
        return new SparseGradient(r3, 0.5d / r3, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cbrt, reason: avoid collision after fix types in other method */
    public SparseGradient cbrt2() {
        double r3 = FastMath.cbrt(this.value);
        return new SparseGradient(r3, 1.0d / ((3.0d * r3) * r3), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: rootN, reason: avoid collision after fix types in other method */
    public SparseGradient rootN2(int r15) {
        if (r15 != 2) goto L7;
        return sqrt2();
    L7:
        if (r15 == 3) goto L9;
        double r2 = r15;
        double r9 = FastMath.pow(this.value, 1.0d / r2);
        return new SparseGradient(r9, 1.0d / (r2 * FastMath.pow(r9, r15 - 1)), this.derivatives);
    L9:
        return cbrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public SparseGradient pow2(double r10) {
        return new SparseGradient(FastMath.pow(this.value, r10), FastMath.pow(this.value, r10 - 1.0d) * r10, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public SparseGradient pow2(int r10) {
        if (r10 == 0) goto L4;
        double r0 = FastMath.pow(this.value, r10 - 1);
        return new SparseGradient(this.value * r0, ((double) r10) * r0, this.derivatives);
    L4:
        return getField().getOne();
    }

    /* JADX INFO: renamed from: pow, reason: avoid collision after fix types in other method */
    public SparseGradient pow2(SparseGradient r1) {
        return log2().multiply(r1).exp2();
    }

    public static SparseGradient pow(double r8, SparseGradient r10) {
        if (r8 != 0.0d) goto L14;
        double r9 = r10.value;
        if (r9 != 0.0d) goto L9;
        return r10.compose(1.0d, Double.NEGATIVE_INFINITY);
    L9:
        if (r9 >= 0.0d) goto L13;
        return r10.compose(Double.NaN, Double.NaN);
    L13:
        return r10.getField().getZero();
    L14:
        double r3 = FastMath.pow(r8, r10.value);
        return new SparseGradient(r3, r3 * FastMath.log(r8), r10.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: exp, reason: avoid collision after fix types in other method */
    public SparseGradient exp2() {
        double r5 = FastMath.exp(this.value);
        return new SparseGradient(r5, r5, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: expm1, reason: avoid collision after fix types in other method */
    public SparseGradient expm12() {
        return new SparseGradient(FastMath.expm1(this.value), FastMath.exp(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: log, reason: avoid collision after fix types in other method */
    public SparseGradient log2() {
        return new SparseGradient(FastMath.log(this.value), 1.0d / this.value, this.derivatives);
    }

    public SparseGradient log10() {
        return new SparseGradient(FastMath.log10(this.value), 1.0d / (FastMath.log(10.0d) * this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: log1p, reason: avoid collision after fix types in other method */
    public SparseGradient log1p2() {
        return new SparseGradient(FastMath.log1p(this.value), 1.0d / (this.value + 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cos, reason: avoid collision after fix types in other method */
    public SparseGradient cos2() {
        return new SparseGradient(FastMath.cos(this.value), -FastMath.sin(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sin, reason: avoid collision after fix types in other method */
    public SparseGradient sin2() {
        return new SparseGradient(FastMath.sin(this.value), FastMath.cos(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: tan, reason: avoid collision after fix types in other method */
    public SparseGradient tan2() {
        double r3 = FastMath.tan(this.value);
        return new SparseGradient(r3, (r3 * r3) + 1.0d, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acos, reason: avoid collision after fix types in other method */
    public SparseGradient acos2() {
        double r1 = FastMath.acos(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, (-1.0d) / FastMath.sqrt(1.0d - (r3 * r3)), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asin, reason: avoid collision after fix types in other method */
    public SparseGradient asin2() {
        double r1 = FastMath.asin(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / FastMath.sqrt(1.0d - (r3 * r3)), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: atan, reason: avoid collision after fix types in other method */
    public SparseGradient atan3() {
        double r1 = FastMath.atan(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / ((r3 * r3) + 1.0d), this.derivatives);
    }

    /* JADX INFO: renamed from: atan2, reason: avoid collision after fix types in other method */
    public SparseGradient atan22(SparseGradient r6) {
        SparseGradient r0 = multiply(this).add(r6.multiply(r6)).sqrt2();
        if (r6.value < 0.0d) goto L5;
        SparseGradient r1 = divide(r0.add(r6)).atan3().multiply(2);
    L10:
        r1.value = FastMath.atan2(this.value, r6.value);
        return r1;
    L5:
        SparseGradient r2 = divide(r0.subtract(r6)).atan3().multiply(-2);
        if (r2.value > 0.0d) goto L8;
        double r3 = -3.141592653589793d;
    L9:
        r1 = r2.add2(r3);
        goto L10
    L8:
        r3 = 3.141592653589793d;
        goto L9
    }

    public static SparseGradient atan2(SparseGradient r0, SparseGradient r1) {
        return r0.atan22(r1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cosh, reason: avoid collision after fix types in other method */
    public SparseGradient cosh2() {
        return new SparseGradient(FastMath.cosh(this.value), FastMath.sinh(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sinh, reason: avoid collision after fix types in other method */
    public SparseGradient sinh2() {
        return new SparseGradient(FastMath.sinh(this.value), FastMath.cosh(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: tanh, reason: avoid collision after fix types in other method */
    public SparseGradient tanh2() {
        double r3 = FastMath.tanh(this.value);
        return new SparseGradient(r3, 1.0d - (r3 * r3), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acosh, reason: avoid collision after fix types in other method */
    public SparseGradient acosh2() {
        double r1 = FastMath.acosh(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / FastMath.sqrt((r3 * r3) - 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asinh, reason: avoid collision after fix types in other method */
    public SparseGradient asinh2() {
        double r1 = FastMath.asinh(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / FastMath.sqrt((r3 * r3) + 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: atanh, reason: avoid collision after fix types in other method */
    public SparseGradient atanh2() {
        double r1 = FastMath.atanh(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / (1.0d - (r3 * r3)), this.derivatives);
    }

    public SparseGradient toDegrees() {
        return new SparseGradient(FastMath.toDegrees(this.value), FastMath.toDegrees(1.0d), this.derivatives);
    }

    public SparseGradient toRadians() {
        return new SparseGradient(FastMath.toRadians(this.value), FastMath.toRadians(1.0d), this.derivatives);
    }

    public double taylor(double... r8) {
        double r0 = this.value;
        int r2 = 0;
    L4:
        if (r2 >= r8.length) goto L6;
        r0 = r0 + (r8[r2] * getDerivative(r2));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public SparseGradient compose(double r8, double r10) {
        return new SparseGradient(r8, r10, this.derivatives);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(SparseGradient[] r6, SparseGradient[] r7) throws DimensionMismatchException {
        int r5 = 0;
        SparseGradient r0 = r6[0].getField().getZero();
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0 = r0.add(r6[r1].multiply(r7[r1]));
        r1 = r1 + 1;
        goto L4
    L6:
        double[] r2 = new double[r6.length];
        int r3 = 0;
    L8:
        if (r3 >= r6.length) goto L10;
        r2[r3] = r6[r3].getValue();
        r3 = r3 + 1;
        goto L8
    L10:
        double[] r8 = new double[r7.length];
    L12:
        if (r5 >= r7.length) goto L14;
        r8[r5] = r7[r5].getValue();
        r5 = r5 + 1;
        goto L12
    L14:
        r0.value = MathArrays.linearCombination(r2, r8);
        return r0;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(double[] r6, SparseGradient[] r7) {
        int r5 = 0;
        SparseGradient r0 = r7[0].getField().getZero();
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0 = r0.add(r7[r1].multiply2(r6[r1]));
        r1 = r1 + 1;
        goto L4
    L6:
        double[] r2 = new double[r7.length];
    L8:
        if (r5 >= r7.length) goto L10;
        r2[r5] = r7[r5].getValue();
        r5 = r5 + 1;
        goto L8
    L10:
        r0.value = MathArrays.linearCombination(r6, r2);
        return r0;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(SparseGradient r9, SparseGradient r10, SparseGradient r11, SparseGradient r12) {
        SparseGradient r8 = r9.multiply(r10).add(r11.multiply(r12));
        r8.value = MathArrays.linearCombination(r9.value, r10.value, r11.value, r12.value);
        return r8;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(double r9, SparseGradient r11, double r12, SparseGradient r14) {
        SparseGradient r8 = r11.multiply2(r9).add(r14.multiply2(r12));
        r8.value = MathArrays.linearCombination(r9, r11.value, r12, r14.value);
        return r8;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(SparseGradient r14, SparseGradient r15, SparseGradient r16, SparseGradient r17, SparseGradient r18, SparseGradient r19) {
        SparseGradient r0 = r14.multiply(r15).add(r16.multiply(r17)).add(r18.multiply(r19));
        r0.value = MathArrays.linearCombination(r14.value, r15.value, r16.value, r17.value, r18.value, r19.value);
        return r0;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(double r16, SparseGradient r18, double r19, SparseGradient r21, double r22, SparseGradient r24) {
        SparseGradient r12 = r18.multiply2(r16).add(r21.multiply2(r19)).add(r24.multiply2(r22));
        r12.value = MathArrays.linearCombination(r16, r18.value, r19, r21.value, r22, r24.value);
        return r12;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(SparseGradient r18, SparseGradient r19, SparseGradient r20, SparseGradient r21, SparseGradient r22, SparseGradient r23, SparseGradient r24, SparseGradient r25) {
        SparseGradient r0 = r18.multiply(r19).add(r20.multiply(r21)).add(r22.multiply(r23)).add(r24.multiply(r25));
        r0.value = MathArrays.linearCombination(r18.value, r19.value, r20.value, r21.value, r22.value, r23.value, r24.value, r25.value);
        return r0;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(double r21, SparseGradient r23, double r24, SparseGradient r26, double r27, SparseGradient r29, double r30, SparseGradient r32) {
        SparseGradient r14 = r23.multiply2(r21).add(r26.multiply2(r24)).add(r29.multiply2(r27)).add(r32.multiply2(r30));
        r14.value = MathArrays.linearCombination(r21, r23.value, r24, r26.value, r27, r29.value, r30, r32.value);
        return r14;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SparseGradient) == false) goto L23;
        SparseGradient r9 = (SparseGradient) r8;
        if (Precision.equals(this.value, r9.value, 1) == true) goto L11;
        return false;
    L11:
        if (this.derivatives.size() == r9.derivatives.size()) goto L13;
        return false;
    L13:
        Iterator<Map.Entry<Integer, Double>> r7 = this.derivatives.entrySet().iterator();
    L15:
        if (r7.hasNext() == false) goto L22;
        Map.Entry<Integer, Double> r1 = r7.next();
        if (r9.derivatives.containsKey(r1.getKey()) == false) goto L18;
        if (Precision.equals(r1.getValue().doubleValue(), r9.derivatives.get(r1.getKey()).doubleValue(), 1) == true) goto L15;
        return false;
    L18:
        return false;
    L22:
        return true;
    L23:
        return false;
    }

    public int hashCode() {
        return ((MathUtils.hash(this.value) * 809) + 743) + (this.derivatives.hashCode() * 167);
    }
}
