package org.apache.commons.math3.complex;

import com.android.settings.utils.HanziToPinyin;
import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public final class Quaternion implements Serializable {
    public static final Quaternion I = null;
    public static final Quaternion IDENTITY = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final Quaternion f9J = null;
    public static final Quaternion K = null;
    public static final Quaternion ZERO = null;
    private static final long serialVersionUID = 20092012;
    private final double q0;
    private final double q1;
    private final double q2;
    private final double q3;

    static {
        IDENTITY = new Quaternion(1.0d, 0.0d, 0.0d, 0.0d);
        ZERO = new Quaternion(0.0d, 0.0d, 0.0d, 0.0d);
        I = new Quaternion(0.0d, 1.0d, 0.0d, 0.0d);
        f9J = new Quaternion(0.0d, 0.0d, 1.0d, 0.0d);
        K = new Quaternion(0.0d, 0.0d, 0.0d, 1.0d);
    }

    public Quaternion(double r1, double r3, double r5, double r7) {
        this.q0 = r1;
        this.q1 = r3;
        this.q2 = r5;
        this.q3 = r7;
    }

    public Quaternion(double r3, double[] r5) throws DimensionMismatchException {
        if (r5.length != 3) goto L7;
        this.q0 = r3;
        this.q1 = r5[0];
        this.q2 = r5[1];
        this.q3 = r5[2];
        return;
    L7:
        throw new DimensionMismatchException(r5.length, 3);
    }

    public Quaternion(double[] r3) {
        this(0.0d, r3);
    }

    public Quaternion getConjugate() {
        return new Quaternion(this.q0, -this.q1, -this.q2, -this.q3);
    }

    public static Quaternion multiply(Quaternion r29, Quaternion r30) {
        double r0 = r29.getQ0();
        double r2 = r29.getQ1();
        double r4 = r29.getQ2();
        double r6 = r29.getQ3();
        double r8 = r30.getQ0();
        double r10 = r30.getQ1();
        double r12 = r30.getQ2();
        double r14 = r30.getQ3();
        return new Quaternion((((r0 * r8) - (r2 * r10)) - (r4 * r12)) - (r6 * r14), (((r0 * r10) + (r2 * r8)) + (r4 * r14)) - (r6 * r12), (((r0 * r12) - (r2 * r14)) + (r4 * r8)) + (r6 * r10), (((r0 * r14) + (r2 * r12)) - (r4 * r10)) + (r6 * r8));
    }

    public Quaternion multiply(Quaternion r1) {
        return multiply(this, r1);
    }

    public static Quaternion add(Quaternion r10, Quaternion r11) {
        return new Quaternion(r10.getQ0() + r11.getQ0(), r10.getQ1() + r11.getQ1(), r10.getQ2() + r11.getQ2(), r10.getQ3() + r11.getQ3());
    }

    public Quaternion add(Quaternion r1) {
        return add(this, r1);
    }

    public static Quaternion subtract(Quaternion r10, Quaternion r11) {
        return new Quaternion(r10.getQ0() - r11.getQ0(), r10.getQ1() - r11.getQ1(), r10.getQ2() - r11.getQ2(), r10.getQ3() - r11.getQ3());
    }

    public Quaternion subtract(Quaternion r1) {
        return subtract(this, r1);
    }

    public static double dotProduct(Quaternion r6, Quaternion r7) {
        return (((r6.getQ0() * r7.getQ0()) + (r6.getQ1() * r7.getQ1())) + (r6.getQ2() * r7.getQ2())) + (r6.getQ3() * r7.getQ3());
    }

    public double dotProduct(Quaternion r1) {
        return dotProduct(this, r1);
    }

    public double getNorm() {
        double r0 = this.q0;
        double r2 = this.q1;
        double r1 = (r0 * r0) + (r2 * r2);
        double r3 = this.q2;
        double r4 = r1 + (r3 * r3);
        double r5 = this.q3;
        return FastMath.sqrt(r4 + (r5 * r5));
    }

    public Quaternion normalize() {
        double r0 = getNorm();
        if (r0 < Precision.SAFE_MIN) goto L7;
        return new Quaternion(this.q0 / r0, this.q1 / r0, this.q2 / r0, this.q3 / r0);
    L7:
        throw new ZeroException(LocalizedFormats.NORM, new Object[]{Double.valueOf(r0)});
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Quaternion) == false) goto L18;
        Quaternion r9 = (Quaternion) r8;
        if (this.q0 != r9.getQ0()) goto L17;
        if (this.q1 != r9.getQ1()) goto L17;
        if (this.q2 != r9.getQ2()) goto L17;
        if (this.q3 != r9.getQ3()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public int hashCode() {
        int r4 = 0;
        double[] r1 = {this.q0, this.q1, this.q2, this.q3};
        int r7 = 17;
    L3:
        if (r4 >= 4) goto L5;
        r7 = (r7 * 31) + MathUtils.hash(r1[r4]);
        r4 = r4 + 1;
        goto L3
    L5:
        return r7;
    }

    public boolean equals(Quaternion r8, double r9) {
        if (Precision.equals(this.q0, r8.getQ0(), r9) == true) goto L5;
    L11:
        return false;
    L5:
        if (Precision.equals(this.q1, r8.getQ1(), r9) == false) goto L11;
        if (Precision.equals(this.q2, r8.getQ2(), r9) == false) goto L11;
        if (Precision.equals(this.q3, r8.getQ3(), r9) == false) goto L11;
        return true;
    }

    public boolean isUnitQuaternion(double r7) {
        return Precision.equals(getNorm(), 1.0d, r7);
    }

    public boolean isPureQuaternion(double r3) {
        if (FastMath.abs(getQ0()) > r3) goto L5;
        return true;
    L5:
        return false;
    }

    public Quaternion getPositivePolarForm() {
        if (getQ0() >= 0.0d) goto L7;
        Quaternion r10 = normalize();
        return new Quaternion(-r10.getQ0(), -r10.getQ1(), -r10.getQ2(), -r10.getQ3());
    L7:
        return normalize();
    }

    public Quaternion getInverse() {
        double r0 = this.q0;
        double r2 = this.q1;
        double r1 = (r0 * r0) + (r2 * r2);
        double r3 = this.q2;
        double r4 = r1 + (r3 * r3);
        double r5 = this.q3;
        double r6 = r4 + (r5 * r5);
        if (r6 < Precision.SAFE_MIN) goto L7;
        return new Quaternion(this.q0 / r6, (-this.q1) / r6, (-this.q2) / r6, (-this.q3) / r6);
    L7:
        throw new ZeroException(LocalizedFormats.NORM, new Object[]{Double.valueOf(r6)});
    }

    public double getQ0() {
        return this.q0;
    }

    public double getQ1() {
        return this.q1;
    }

    public double getQ2() {
        return this.q2;
    }

    public double getQ3() {
        return this.q3;
    }

    public double getScalarPart() {
        return getQ0();
    }

    public double[] getVectorPart() {
        return new double[]{getQ1(), getQ2(), getQ3()};
    }

    public Quaternion multiply(double r11) {
        return new Quaternion(r11 * this.q0, this.q1 * r11, this.q2 * r11, this.q3 * r11);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[");
        r0.append(this.q0).append(HanziToPinyin.Token.SEPARATOR).append(this.q1).append(HanziToPinyin.Token.SEPARATOR).append(this.q2).append(HanziToPinyin.Token.SEPARATOR).append(this.q3).append("]");
        return r0.toString();
    }
}
