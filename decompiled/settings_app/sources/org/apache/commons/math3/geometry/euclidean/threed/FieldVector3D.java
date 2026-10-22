package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldVector3D<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224;
    private final T x;
    private final T y;
    private final T z;

    public FieldVector3D(T r1, T r2, T r3) {
        this.x = r1;
        this.y = r2;
        this.z = r3;
    }

    public FieldVector3D(T[] r3) throws DimensionMismatchException {
        if (r3.length != 3) goto L7;
        this.x = r3[0];
        this.y = r3[1];
        this.z = r3[2];
        return;
    L7:
        throw new DimensionMismatchException(r3.length, 3);
    }

    public FieldVector3D(T r3, T r4) {
        RealFieldElement r0 = (RealFieldElement) r4.cos();
        this.x = (T) ((RealFieldElement) r3.cos()).multiply(r0);
        this.y = (T) ((RealFieldElement) r3.sin()).multiply(r0);
        this.z = (T) r4.sin();
    }

    public FieldVector3D(T r2, FieldVector3D<T> r3) {
        this.x = (T) r2.multiply(r3.x);
        this.y = (T) r2.multiply(r3.y);
        this.z = (T) r2.multiply(r3.z);
    }

    public FieldVector3D(T r3, Vector3D r4) {
        this.x = (T) r3.multiply(r4.getX());
        this.y = (T) r3.multiply(r4.getY());
        this.z = (T) r3.multiply(r4.getZ());
    }

    public FieldVector3D(double r2, FieldVector3D<T> r4) {
        this.x = (T) r4.x.multiply(r2);
        this.y = (T) r4.y.multiply(r2);
        this.z = (T) r4.z.multiply(r2);
    }

    public FieldVector3D(T r3, FieldVector3D<T> r4, T r5, FieldVector3D<T> r6) {
        this.x = (T) r3.linearCombination(r3, r4.getX(), r5, r6.getX());
        this.y = (T) r3.linearCombination(r3, r4.getY(), r5, r6.getY());
        this.z = (T) r3.linearCombination(r3, r4.getZ(), r5, r6.getZ());
    }

    public FieldVector3D(T r9, Vector3D r10, T r11, Vector3D r12) {
        this.x = (T) r9.linearCombination(r10.getX(), r9, r12.getX(), r11);
        this.y = (T) r9.linearCombination(r10.getY(), r9, r12.getY(), r11);
        this.z = (T) r9.linearCombination(r10.getZ(), r9, r12.getZ(), r11);
    }

    public FieldVector3D(double r9, FieldVector3D<T> r11, double r12, FieldVector3D<T> r14) {
        RealFieldElement r7 = r11.getX();
        this.x = (T) r7.linearCombination(r9, r11.getX(), r12, r14.getX());
        this.y = (T) r7.linearCombination(r9, r11.getY(), r12, r14.getY());
        this.z = (T) r7.linearCombination(r9, r11.getZ(), r12, r14.getZ());
    }

    public FieldVector3D(T r9, FieldVector3D<T> r10, T r11, FieldVector3D<T> r12, T r13, FieldVector3D<T> r14) {
        this.x = (T) r9.linearCombination(r9, r10.getX(), r11, r12.getX(), r13, r14.getX());
        this.y = (T) r9.linearCombination(r9, r10.getY(), r11, r12.getY(), r13, r14.getY());
        this.z = (T) r9.linearCombination(r9, r10.getZ(), r11, r12.getZ(), r13, r14.getZ());
    }

    public FieldVector3D(T r13, Vector3D r14, T r15, Vector3D r16, T r17, Vector3D r18) {
        this.x = (T) r13.linearCombination(r14.getX(), r13, r16.getX(), r15, r18.getX(), r17);
        this.y = (T) r13.linearCombination(r14.getY(), r13, r16.getY(), r15, r18.getY(), r17);
        this.z = (T) r13.linearCombination(r14.getZ(), r13, r16.getZ(), r15, r18.getZ(), r17);
    }

    public FieldVector3D(double r13, FieldVector3D<T> r15, double r16, FieldVector3D<T> r18, double r19, FieldVector3D<T> r21) {
        RealFieldElement r11 = r15.getX();
        this.x = (T) r11.linearCombination(r13, r15.getX(), r16, r18.getX(), r19, r21.getX());
        this.y = (T) r11.linearCombination(r13, r15.getY(), r16, r18.getY(), r19, r21.getY());
        this.z = (T) r11.linearCombination(r13, r15.getZ(), r16, r18.getZ(), r19, r21.getZ());
    }

    public FieldVector3D(T r12, FieldVector3D<T> r13, T r14, FieldVector3D<T> r15, T r16, FieldVector3D<T> r17, T r18, FieldVector3D<T> r19) {
        this.x = (T) r12.linearCombination(r12, r13.getX(), r14, r15.getX(), r16, r17.getX(), r18, r19.getX());
        this.y = (T) r12.linearCombination(r12, r13.getY(), r14, r15.getY(), r16, r17.getY(), r18, r19.getY());
        this.z = (T) r12.linearCombination(r12, r13.getZ(), r14, r15.getZ(), r16, r17.getZ(), r18, r19.getZ());
    }

    public FieldVector3D(T r16, Vector3D r17, T r18, Vector3D r19, T r20, Vector3D r21, T r22, Vector3D r23) {
        this.x = (T) r16.linearCombination(r17.getX(), r16, r19.getX(), r18, r21.getX(), r20, r23.getX(), r22);
        this.y = (T) r16.linearCombination(r17.getY(), r16, r19.getY(), r18, r21.getY(), r20, r23.getY(), r22);
        this.z = (T) r16.linearCombination(r17.getZ(), r16, r19.getZ(), r18, r21.getZ(), r20, r23.getZ(), r22);
    }

    public FieldVector3D(double r16, FieldVector3D<T> r18, double r19, FieldVector3D<T> r21, double r22, FieldVector3D<T> r24, double r25, FieldVector3D<T> r27) {
        RealFieldElement r14 = r18.getX();
        this.x = (T) r14.linearCombination(r16, r18.getX(), r19, r21.getX(), r22, r24.getX(), r25, r27.getX());
        this.y = (T) r14.linearCombination(r16, r18.getY(), r19, r21.getY(), r22, r24.getY(), r25, r27.getY());
        this.z = (T) r14.linearCombination(r16, r18.getZ(), r19, r21.getZ(), r22, r24.getZ(), r25, r27.getZ());
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }

    public T getZ() {
        return this.z;
    }

    public T[] toArray() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(this.x.getField(), 3));
        r0[0] = this.x;
        r0[1] = this.y;
        r0[2] = this.z;
        return r0;
    }

    public Vector3D toVector3D() {
        return new Vector3D(this.x.getReal(), this.y.getReal(), this.z.getReal());
    }

    public T getNorm1() {
        return (T) ((RealFieldElement) ((RealFieldElement) this.x.abs()).add(this.y.abs())).add(this.z.abs());
    }

    public T getNorm() {
        T r0 = this.x;
        RealFieldElement r1 = (RealFieldElement) r0.multiply(r0);
        T r2 = this.y;
        RealFieldElement r3 = (RealFieldElement) r1.add(r2.multiply(r2));
        T r4 = this.z;
        return (T) ((RealFieldElement) r3.add(r4.multiply(r4))).sqrt();
    }

    public T getNormSq() {
        T r0 = this.x;
        RealFieldElement r1 = (RealFieldElement) r0.multiply(r0);
        T r2 = this.y;
        RealFieldElement r3 = (RealFieldElement) r1.add(r2.multiply(r2));
        T r4 = this.z;
        return (T) r3.add(r4.multiply(r4));
    }

    public T getNormInf() {
        T r0 = (T) this.x.abs();
        T r1 = (T) this.y.abs();
        T r6 = (T) this.z.abs();
        if (r0.getReal() > r1.getReal()) goto L9;
        if (r1.getReal() > r6.getReal()) goto L7;
        return r6;
    L7:
        return r1;
    L9:
        if (r0.getReal() > r6.getReal()) goto L11;
        return r6;
    L11:
        return r0;
    }

    public T getAlpha() {
        return (T) this.y.atan2(this.x);
    }

    public T getDelta() {
        return (T) ((RealFieldElement) this.z.divide(getNorm())).asin();
    }

    public FieldVector3D<T> add(FieldVector3D<T> r5) {
        return new FieldVector3D((RealFieldElement) this.x.add(r5.x), (RealFieldElement) this.y.add(r5.y), (RealFieldElement) this.z.add(r5.z));
    }

    public FieldVector3D<T> add(Vector3D r6) {
        return new FieldVector3D((RealFieldElement) this.x.add(r6.getX()), (RealFieldElement) this.y.add(r6.getY()), (RealFieldElement) this.z.add(r6.getZ()));
    }

    public FieldVector3D<T> add(T r3, FieldVector3D<T> r4) {
        return new FieldVector3D((RealFieldElement) this.x.getField().getOne(), this, r3, r4);
    }

    public FieldVector3D<T> add(T r6, Vector3D r7) {
        return new FieldVector3D((RealFieldElement) this.x.add(r6.multiply(r7.getX())), (RealFieldElement) this.y.add(r6.multiply(r7.getY())), (RealFieldElement) this.z.add(r6.multiply(r7.getZ())));
    }

    public FieldVector3D<T> add(double r9, FieldVector3D<T> r11) {
        return new FieldVector3D(1.0d, this, r9, r11);
    }

    public FieldVector3D<T> add(double r6, Vector3D r8) {
        return new FieldVector3D((RealFieldElement) this.x.add(r8.getX() * r6), (RealFieldElement) this.y.add(r8.getY() * r6), (RealFieldElement) this.z.add(r6 * r8.getZ()));
    }

    public FieldVector3D<T> subtract(FieldVector3D<T> r5) {
        return new FieldVector3D((RealFieldElement) this.x.subtract(r5.x), (RealFieldElement) this.y.subtract(r5.y), (RealFieldElement) this.z.subtract(r5.z));
    }

    public FieldVector3D<T> subtract(Vector3D r6) {
        return new FieldVector3D((RealFieldElement) this.x.subtract(r6.getX()), (RealFieldElement) this.y.subtract(r6.getY()), (RealFieldElement) this.z.subtract(r6.getZ()));
    }

    public FieldVector3D<T> subtract(T r3, FieldVector3D<T> r4) {
        return new FieldVector3D((RealFieldElement) this.x.getField().getOne(), this, (RealFieldElement) r3.negate(), r4);
    }

    public FieldVector3D<T> subtract(T r6, Vector3D r7) {
        return new FieldVector3D((RealFieldElement) this.x.subtract(r6.multiply(r7.getX())), (RealFieldElement) this.y.subtract(r6.multiply(r7.getY())), (RealFieldElement) this.z.subtract(r6.multiply(r7.getZ())));
    }

    public FieldVector3D<T> subtract(double r9, FieldVector3D<T> r11) {
        return new FieldVector3D(1.0d, this, -r9, r11);
    }

    public FieldVector3D<T> subtract(double r6, Vector3D r8) {
        return new FieldVector3D((RealFieldElement) this.x.subtract(r8.getX() * r6), (RealFieldElement) this.y.subtract(r8.getY() * r6), (RealFieldElement) this.z.subtract(r6 * r8.getZ()));
    }

    public FieldVector3D<T> normalize() throws MathArithmeticException {
        RealFieldElement r0 = getNorm();
        if (r0.getReal() == 0.0d) goto L7;
        return scalarMultiply((RealFieldElement) r0.reciprocal());
    L7:
        throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    public FieldVector3D<T> orthogonal() throws MathArithmeticException {
        double r0 = getNorm().getReal() * 0.6d;
        if (r0 == 0.0d) goto L15;
        if (FastMath.abs(this.x.getReal()) > r0) goto L9;
        T r1 = this.y;
        RealFieldElement r2 = (RealFieldElement) r1.multiply(r1);
        T r3 = this.z;
        RealFieldElement r4 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.add(r3.multiply(r3))).sqrt()).reciprocal();
        return new FieldVector3D((RealFieldElement) r4.getField().getZero(), (RealFieldElement) r4.multiply(this.z), (RealFieldElement) ((RealFieldElement) r4.multiply(this.y)).negate());
    L9:
        if (FastMath.abs(this.y.getReal()) > r0) goto L12;
        T r5 = this.x;
        RealFieldElement r6 = (RealFieldElement) r5.multiply(r5);
        T r7 = this.z;
        RealFieldElement r8 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.add(r7.multiply(r7))).sqrt()).reciprocal();
        return new FieldVector3D((RealFieldElement) ((RealFieldElement) r8.multiply(this.z)).negate(), (RealFieldElement) r8.getField().getZero(), (RealFieldElement) r8.multiply(this.x));
    L12:
        T r9 = this.x;
        RealFieldElement r10 = (RealFieldElement) r9.multiply(r9);
        T r11 = this.y;
        RealFieldElement r12 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r10.add(r11.multiply(r11))).sqrt()).reciprocal();
        return new FieldVector3D((RealFieldElement) r12.multiply(this.y), (RealFieldElement) ((RealFieldElement) r12.multiply(this.x)).negate(), (RealFieldElement) r12.getField().getZero());
    L15:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static <T extends RealFieldElement<T>> T angle(FieldVector3D<T> r11, FieldVector3D<T> r12) throws MathArithmeticException {
        RealFieldElement r0 = (RealFieldElement) r11.getNorm().multiply(r12.getNorm());
        if (r0.getReal() == 0.0d) goto L18;
        RealFieldElement r1 = dotProduct(r11, r12);
        double r5 = r0.getReal() * 0.9999d;
        if (r1.getReal() >= (-r5)) goto L7;
    L11:
        FieldVector3D r13 = crossProduct(r11, r12);
        if (r1.getReal() < 0.0d) goto L16;
        return (T) ((RealFieldElement) r13.getNorm().divide(r0)).asin();
    L16:
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r13.getNorm().divide(r0)).asin()).subtract(3.141592653589793d)).negate();
    L7:
        if (r1.getReal() > r5) goto L11;
        return (T) ((RealFieldElement) r1.divide(r0)).acos();
    L18:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static <T extends RealFieldElement<T>> T angle(FieldVector3D<T> r11, Vector3D r12) throws MathArithmeticException {
        RealFieldElement r0 = (RealFieldElement) r11.getNorm().multiply(r12.getNorm());
        if (r0.getReal() == 0.0d) goto L18;
        RealFieldElement r1 = dotProduct(r11, r12);
        double r5 = r0.getReal() * 0.9999d;
        if (r1.getReal() >= (-r5)) goto L7;
    L11:
        FieldVector3D r13 = crossProduct(r11, r12);
        if (r1.getReal() < 0.0d) goto L16;
        return (T) ((RealFieldElement) r13.getNorm().divide(r0)).asin();
    L16:
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r13.getNorm().divide(r0)).asin()).subtract(3.141592653589793d)).negate();
    L7:
        if (r1.getReal() > r5) goto L11;
        return (T) ((RealFieldElement) r1.divide(r0)).acos();
    L18:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static <T extends RealFieldElement<T>> T angle(Vector3D r0, FieldVector3D<T> r1) throws MathArithmeticException {
        return (T) angle(r1, r0);
    }

    public FieldVector3D<T> negate() {
        return new FieldVector3D((RealFieldElement) this.x.negate(), (RealFieldElement) this.y.negate(), (RealFieldElement) this.z.negate());
    }

    public FieldVector3D<T> scalarMultiply(T r4) {
        return new FieldVector3D((RealFieldElement) this.x.multiply(r4), (RealFieldElement) this.y.multiply(r4), (RealFieldElement) this.z.multiply(r4));
    }

    public FieldVector3D<T> scalarMultiply(double r4) {
        return new FieldVector3D((RealFieldElement) this.x.multiply(r4), (RealFieldElement) this.y.multiply(r4), (RealFieldElement) this.z.multiply(r4));
    }

    public boolean isNaN() {
        if (Double.isNaN(this.x.getReal()) == false) goto L5;
    L10:
        return true;
    L5:
        if (Double.isNaN(this.y.getReal()) == true) goto L10;
        if (Double.isNaN(this.z.getReal()) == true) goto L10;
        return false;
    }

    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
    L11:
        return false;
    L5:
        if (Double.isInfinite(this.x.getReal()) == false) goto L7;
    L10:
        return true;
    L7:
        if (Double.isInfinite(this.y.getReal()) == true) goto L10;
        if (Double.isInfinite(this.z.getReal()) == false) goto L11;
        goto L10
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FieldVector3D) == false) goto L20;
        FieldVector3D r6 = (FieldVector3D) r5;
        if (r6.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.x.equals(r6.x) == false) goto L19;
        if (this.y.equals(r6.y) == false) goto L19;
        if (this.z.equals(r6.z) == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 409;
    L7:
        return (((this.x.hashCode() * 107) + (this.y.hashCode() * 83)) + this.z.hashCode()) * 311;
    }

    public T dotProduct(FieldVector3D<T> r8) {
        T r1 = this.x;
        return (T) r1.linearCombination(r1, r8.x, this.y, r8.y, this.z, r8.z);
    }

    public T dotProduct(Vector3D r11) {
        return (T) this.x.linearCombination(r11.getX(), this.x, r11.getY(), this.y, r11.getZ(), this.z);
    }

    public FieldVector3D<T> crossProduct(FieldVector3D<T> r8) {
        return new FieldVector3D((RealFieldElement) this.x.linearCombination(this.y, r8.z, this.z.negate(), r8.y), (RealFieldElement) this.y.linearCombination(this.z, r8.x, this.x.negate(), r8.z), (RealFieldElement) this.z.linearCombination(this.x, r8.y, this.y.negate(), r8.x));
    }

    public FieldVector3D<T> crossProduct(Vector3D r11) {
        return new FieldVector3D((RealFieldElement) this.x.linearCombination(r11.getZ(), this.y, -r11.getY(), this.z), (RealFieldElement) this.y.linearCombination(r11.getX(), this.z, -r11.getZ(), this.x), (RealFieldElement) this.z.linearCombination(r11.getY(), this.x, -r11.getX(), this.y));
    }

    public T distance1(FieldVector3D<T> r4) {
        RealFieldElement r0 = (RealFieldElement) ((RealFieldElement) r4.x.subtract(this.x)).abs();
        RealFieldElement r1 = (RealFieldElement) ((RealFieldElement) r4.y.subtract(this.y)).abs();
        RealFieldElement r3 = (RealFieldElement) ((RealFieldElement) r4.z.subtract(this.z)).abs();
        return (T) ((RealFieldElement) r0.add(r1)).add(r3);
    }

    public T distance1(Vector3D r5) {
        RealFieldElement r0 = (RealFieldElement) ((RealFieldElement) this.x.subtract(r5.getX())).abs();
        RealFieldElement r1 = (RealFieldElement) ((RealFieldElement) this.y.subtract(r5.getY())).abs();
        RealFieldElement r4 = (RealFieldElement) ((RealFieldElement) this.z.subtract(r5.getZ())).abs();
        return (T) ((RealFieldElement) r0.add(r1)).add(r4);
    }

    public T distance(FieldVector3D<T> r4) {
        RealFieldElement r0 = (RealFieldElement) r4.x.subtract(this.x);
        RealFieldElement r1 = (RealFieldElement) r4.y.subtract(this.y);
        RealFieldElement r3 = (RealFieldElement) r4.z.subtract(this.z);
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(r0)).add(r1.multiply(r1))).add(r3.multiply(r3))).sqrt();
    }

    public T distance(Vector3D r5) {
        RealFieldElement r0 = (RealFieldElement) this.x.subtract(r5.getX());
        RealFieldElement r1 = (RealFieldElement) this.y.subtract(r5.getY());
        RealFieldElement r4 = (RealFieldElement) this.z.subtract(r5.getZ());
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(r0)).add(r1.multiply(r1))).add(r4.multiply(r4))).sqrt();
    }

    public T distanceInf(FieldVector3D<T> r7) {
        T r0 = (T) ((RealFieldElement) r7.x.subtract(this.x)).abs();
        T r1 = (T) ((RealFieldElement) r7.y.subtract(this.y)).abs();
        T r6 = (T) ((RealFieldElement) r7.z.subtract(this.z)).abs();
        if (r0.getReal() > r1.getReal()) goto L9;
        if (r1.getReal() > r6.getReal()) goto L7;
        return r6;
    L7:
        return r1;
    L9:
        if (r0.getReal() > r6.getReal()) goto L11;
        return r6;
    L11:
        return r0;
    }

    public T distanceInf(Vector3D r7) {
        T r0 = (T) ((RealFieldElement) this.x.subtract(r7.getX())).abs();
        T r1 = (T) ((RealFieldElement) this.y.subtract(r7.getY())).abs();
        T r6 = (T) ((RealFieldElement) this.z.subtract(r7.getZ())).abs();
        if (r0.getReal() > r1.getReal()) goto L9;
        if (r1.getReal() > r6.getReal()) goto L7;
        return r6;
    L7:
        return r1;
    L9:
        if (r0.getReal() > r6.getReal()) goto L11;
        return r6;
    L11:
        return r0;
    }

    public T distanceSq(FieldVector3D<T> r4) {
        RealFieldElement r0 = (RealFieldElement) r4.x.subtract(this.x);
        RealFieldElement r1 = (RealFieldElement) r4.y.subtract(this.y);
        RealFieldElement r3 = (RealFieldElement) r4.z.subtract(this.z);
        return (T) ((RealFieldElement) ((RealFieldElement) r0.multiply(r0)).add(r1.multiply(r1))).add(r3.multiply(r3));
    }

    public T distanceSq(Vector3D r5) {
        RealFieldElement r0 = (RealFieldElement) this.x.subtract(r5.getX());
        RealFieldElement r1 = (RealFieldElement) this.y.subtract(r5.getY());
        RealFieldElement r4 = (RealFieldElement) this.z.subtract(r5.getZ());
        return (T) ((RealFieldElement) ((RealFieldElement) r0.multiply(r0)).add(r1.multiply(r1))).add(r4.multiply(r4));
    }

    public static <T extends RealFieldElement<T>> T dotProduct(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.dotProduct(r1);
    }

    public static <T extends RealFieldElement<T>> T dotProduct(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.dotProduct(r1);
    }

    public static <T extends RealFieldElement<T>> T dotProduct(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.dotProduct(r0);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return r0.crossProduct(r1);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(FieldVector3D<T> r0, Vector3D r1) {
        return r0.crossProduct(r1);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(Vector3D r10, FieldVector3D<T> r11) {
        return new FieldVector3D((RealFieldElement) ((FieldVector3D) r11).x.linearCombination(r10.getY(), ((FieldVector3D) r11).z, -r10.getZ(), ((FieldVector3D) r11).y), (RealFieldElement) ((FieldVector3D) r11).y.linearCombination(r10.getZ(), ((FieldVector3D) r11).x, -r10.getX(), ((FieldVector3D) r11).z), (RealFieldElement) ((FieldVector3D) r11).z.linearCombination(r10.getX(), ((FieldVector3D) r11).y, -r10.getY(), ((FieldVector3D) r11).x));
    }

    public static <T extends RealFieldElement<T>> T distance1(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distance1(r1);
    }

    public static <T extends RealFieldElement<T>> T distance1(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distance1(r1);
    }

    public static <T extends RealFieldElement<T>> T distance1(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distance1(r0);
    }

    public static <T extends RealFieldElement<T>> T distance(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distance(r1);
    }

    public static <T extends RealFieldElement<T>> T distance(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distance(r1);
    }

    public static <T extends RealFieldElement<T>> T distance(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distance(r0);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distanceInf(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distanceInf(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distanceInf(r0);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distanceSq(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distanceSq(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distanceSq(r0);
    }

    public String toString() {
        return Vector3DFormat.getInstance().format(toVector3D());
    }

    public String toString(NumberFormat r2) {
        return new Vector3DFormat(r2).format(toVector3D());
    }
}
