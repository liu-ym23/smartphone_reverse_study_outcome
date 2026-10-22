package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldRotation<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224;
    private final T q0;
    private final T q1;
    private final T q2;
    private final T q3;

    public FieldRotation(T r2, T r3, T r4, T r5, boolean r6) {
        if (r6 == false) goto L5;
        RealFieldElement r7 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(r2)).add(r3.multiply(r3))).add(r4.multiply(r4))).add(r5.multiply(r5))).sqrt()).reciprocal();
        this.q0 = (T) r7.multiply(r2);
        this.q1 = (T) r7.multiply(r3);
        this.q2 = (T) r7.multiply(r4);
        this.q3 = (T) r7.multiply(r5);
        return;
    L5:
        this.q0 = r2;
        this.q1 = r3;
        this.q2 = r4;
        this.q3 = r5;
    }

    @Deprecated
    public FieldRotation(FieldVector3D<T> r2, T r3) throws MathIllegalArgumentException {
        this(r2, r3, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation(FieldVector3D<T> r6, T r7, RotationConvention r8) throws MathIllegalArgumentException {
        RealFieldElement r0 = r6.getNorm();
        if (r0.getReal() == 0.0d) goto L11;
        if (r8 != RotationConvention.VECTOR_OPERATOR) goto L7;
        double r1 = -0.5d;
    L8:
        RealFieldElement r9 = (RealFieldElement) r7.multiply(r1);
        RealFieldElement r10 = (RealFieldElement) ((RealFieldElement) r9.sin()).divide(r0);
        this.q0 = (T) r9.cos();
        this.q1 = (T) r10.multiply(r6.getX());
        this.q2 = (T) r10.multiply(r6.getY());
        this.q3 = (T) r10.multiply(r6.getZ());
        return;
    L7:
        r1 = 0.5d;
        goto L8
    L11:
        throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
    }

    public FieldRotation(T[][] r10, double r11) throws NotARotationMatrixException {
        if (r10.length != 3) goto L17;
        if (r10[0].length != 3) goto L17;
        if (r10[1].length != 3) goto L17;
        if (r10[2].length != 3) goto L17;
        RealFieldElement[][] r12 = orthogonalizeMatrix(r10, r11);
        RealFieldElement r13 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r12[0][0].multiply((RealFieldElement) ((RealFieldElement) r12[1][1].multiply(r12[2][2])).subtract(r12[2][1].multiply(r12[1][2])))).subtract(r12[1][0].multiply((RealFieldElement) ((RealFieldElement) r12[0][1].multiply(r12[2][2])).subtract(r12[2][1].multiply(r12[0][2]))))).add(r12[2][0].multiply((RealFieldElement) ((RealFieldElement) r12[0][1].multiply(r12[1][2])).subtract(r12[1][1].multiply(r12[0][2]))));
        if (r13.getReal() < 0.0d) goto L15;
        RealFieldElement[] r14 = mat2quat(r12);
        this.q0 = (T) r14[0];
        this.q1 = (T) r14[1];
        this.q2 = (T) r14[2];
        this.q3 = (T) r14[3];
        return;
    L15:
        throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, new Object[]{r13});
    L17:
        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r10[0].length)});
    }

    public FieldRotation(FieldVector3D<T> r12, FieldVector3D<T> r13, FieldVector3D<T> r14, FieldVector3D<T> r15) throws MathArithmeticException {
        FieldVector3D<T> r16 = FieldVector3D.crossProduct(r12, r13).normalize();
        FieldVector3D<T> r0 = FieldVector3D.crossProduct(r16, r12).normalize();
        FieldVector3D<T> r17 = r12.normalize();
        FieldVector3D<T> r18 = FieldVector3D.crossProduct(r14, r15).normalize();
        FieldVector3D<T> r1 = FieldVector3D.crossProduct(r18, r14).normalize();
        FieldVector3D<T> r19 = r14.normalize();
        RealFieldElement[][] r2 = (RealFieldElement[][]) MathArrays.buildArray(r17.getX().getField(), 3, 3);
        r2[0][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getX().multiply(r19.getX())).add(r0.getX().multiply(r1.getX()))).add(r16.getX().multiply(r18.getX()));
        r2[0][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getY().multiply(r19.getX())).add(r0.getY().multiply(r1.getX()))).add(r16.getY().multiply(r18.getX()));
        r2[0][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getZ().multiply(r19.getX())).add(r0.getZ().multiply(r1.getX()))).add(r16.getZ().multiply(r18.getX()));
        r2[1][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getX().multiply(r19.getY())).add(r0.getX().multiply(r1.getY()))).add(r16.getX().multiply(r18.getY()));
        r2[1][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getY().multiply(r19.getY())).add(r0.getY().multiply(r1.getY()))).add(r16.getY().multiply(r18.getY()));
        r2[1][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getZ().multiply(r19.getY())).add(r0.getZ().multiply(r1.getY()))).add(r16.getZ().multiply(r18.getY()));
        r2[2][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getX().multiply(r19.getZ())).add(r0.getX().multiply(r1.getZ()))).add(r16.getX().multiply(r18.getZ()));
        r2[2][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getY().multiply(r19.getZ())).add(r0.getY().multiply(r1.getZ()))).add(r16.getY().multiply(r18.getZ()));
        r2[2][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r17.getZ().multiply(r19.getZ())).add(r0.getZ().multiply(r1.getZ()))).add(r16.getZ().multiply(r18.getZ()));
        RealFieldElement[] r110 = mat2quat(r2);
        this.q0 = (T) r110[0];
        this.q1 = (T) r110[1];
        this.q2 = (T) r110[2];
        this.q3 = (T) r110[3];
    }

    public FieldRotation(FieldVector3D<T> r9, FieldVector3D<T> r10) throws MathArithmeticException {
        RealFieldElement r0 = (RealFieldElement) r9.getNorm().multiply(r10.getNorm());
        if (r0.getReal() == 0.0d) goto L10;
        RealFieldElement r1 = FieldVector3D.dotProduct(r9, r10);
        if (r1.getReal() >= (r0.getReal() * (-0.999999999999998d))) goto L7;
        FieldVector3D<T> r11 = r9.orthogonal();
        this.q0 = (T) r0.getField().getZero();
        this.q1 = (T) r11.getX().negate();
        this.q2 = (T) r11.getY().negate();
        this.q3 = (T) r11.getZ().negate();
        return;
    L7:
        T r2 = (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.divide(r0)).add(1.0d)).multiply(0.5d)).sqrt();
        this.q0 = r2;
        RealFieldElement r3 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(r0)).multiply(2.0d)).reciprocal();
        FieldVector3D r12 = FieldVector3D.crossProduct(r10, r9);
        this.q1 = (T) r3.multiply(r12.getX());
        this.q2 = (T) r3.multiply(r12.getY());
        this.q3 = (T) r3.multiply(r12.getZ());
        return;
    L10:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
    }

    @Deprecated
    public FieldRotation(RotationOrder r7, T r8, T r9, T r10) {
        this(r7, RotationConvention.VECTOR_OPERATOR, r8, r9, r10);
    }

    public FieldRotation(RotationOrder r5, RotationConvention r6, T r7, T r8, T r9) {
        RealFieldElement r0 = (RealFieldElement) r7.getField().getOne();
        FieldRotation<T> r10 = new FieldRotation(new FieldVector3D(r0, r5.getA1()), r7, r6).compose(new FieldRotation(new FieldVector3D(r0, r5.getA2()), r8, r6).compose(new FieldRotation(new FieldVector3D(r0, r5.getA3()), r9, r6), r6), r6);
        this.q0 = r10.q0;
        this.q1 = r10.q1;
        this.q2 = r10.q2;
        this.q3 = r10.q3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T[] mat2quat(T[][] r18) {
        T[] r1 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r18[0][0].getField(), 4));
        RealFieldElement r2 = (RealFieldElement) ((RealFieldElement) r18[0][0].add(r18[1][1])).add(r18[2][2]);
        if (r2.getReal() <= (-0.19d)) goto L5;
        RealFieldElement r3 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.add(1.0d)).sqrt()).multiply(0.5d);
        r1[0] = r3;
        RealFieldElement r4 = (RealFieldElement) ((RealFieldElement) r3.reciprocal()).multiply(0.25d);
        r1[1] = (RealFieldElement) r4.multiply(r18[1][2].subtract(r18[2][1]));
        r1[2] = (RealFieldElement) r4.multiply(r18[2][0].subtract(r18[0][2]));
        r1[3] = (RealFieldElement) r4.multiply(r18[0][1].subtract(r18[1][0]));
    L12:
        return r1;
    L5:
        RealFieldElement r5 = (RealFieldElement) ((RealFieldElement) r18[0][0].subtract(r18[1][1])).subtract(r18[2][2]);
        if (r5.getReal() <= (-0.19d)) goto L8;
        RealFieldElement r6 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r5.add(1.0d)).sqrt()).multiply(0.5d);
        r1[1] = r6;
        RealFieldElement r7 = (RealFieldElement) ((RealFieldElement) r6.reciprocal()).multiply(0.25d);
        r1[0] = (RealFieldElement) r7.multiply(r18[1][2].subtract(r18[2][1]));
        r1[2] = (RealFieldElement) r7.multiply(r18[0][1].add(r18[1][0]));
        r1[3] = (RealFieldElement) r7.multiply(r18[0][2].add(r18[2][0]));
        goto L12
    L8:
        RealFieldElement r8 = (RealFieldElement) ((RealFieldElement) r18[1][1].subtract(r18[0][0])).subtract(r18[2][2]);
        if (r8.getReal() <= (-0.19d)) goto L11;
        RealFieldElement r9 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r8.add(1.0d)).sqrt()).multiply(0.5d);
        r1[2] = r9;
        RealFieldElement r10 = (RealFieldElement) ((RealFieldElement) r9.reciprocal()).multiply(0.25d);
        r1[0] = (RealFieldElement) r10.multiply(r18[2][0].subtract(r18[0][2]));
        r1[1] = (RealFieldElement) r10.multiply(r18[0][1].add(r18[1][0]));
        r1[3] = (RealFieldElement) r10.multiply(r18[2][1].add(r18[1][2]));
        goto L12
    L11:
        RealFieldElement r11 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r18[2][2].subtract(r18[0][0])).subtract(r18[1][1])).add(1.0d)).sqrt()).multiply(0.5d);
        r1[3] = r11;
        RealFieldElement r12 = (RealFieldElement) ((RealFieldElement) r11.reciprocal()).multiply(0.25d);
        r1[0] = (RealFieldElement) r12.multiply(r18[0][1].subtract(r18[1][0]));
        r1[1] = (RealFieldElement) r12.multiply(r18[0][2].add(r18[2][0]));
        r1[2] = (RealFieldElement) r12.multiply(r18[2][1].add(r18[1][2]));
        goto L12
    }

    public FieldRotation<T> revert() {
        return new FieldRotation((RealFieldElement) this.q0.negate(), this.q1, this.q2, this.q3, false);
    }

    public T getQ0() {
        return this.q0;
    }

    public T getQ1() {
        return this.q1;
    }

    public T getQ2() {
        return this.q2;
    }

    public T getQ3() {
        return this.q3;
    }

    @Deprecated
    public FieldVector3D<T> getAxis() {
        return getAxis(RotationConvention.VECTOR_OPERATOR);
    }

    public FieldVector3D<T> getAxis(RotationConvention r8) {
        T r0 = this.q1;
        RealFieldElement r1 = (RealFieldElement) r0.multiply(r0);
        T r2 = this.q2;
        RealFieldElement r3 = (RealFieldElement) r1.add(r2.multiply(r2));
        T r4 = this.q3;
        RealFieldElement r5 = (RealFieldElement) r3.add(r4.multiply(r4));
        if (r5.getReal() != 0.0d) goto L11;
        Field<T> r7 = r5.getField();
        if (r8 != RotationConvention.VECTOR_OPERATOR) goto L7;
        Object r9 = r7.getOne();
    L9:
        return new FieldVector3D((RealFieldElement) r9, (RealFieldElement) r7.getZero(), (RealFieldElement) r7.getZero());
    L7:
        r9 = ((RealFieldElement) r7.getOne()).negate();
        goto L9
    L11:
        if (r8 != RotationConvention.VECTOR_OPERATOR) goto L13;
        double r6 = 1.0d;
    L15:
        if (this.q0.getReal() >= 0.0d) goto L18;
        RealFieldElement r10 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r5.sqrt()).reciprocal()).multiply(r6);
        return new FieldVector3D((RealFieldElement) this.q1.multiply(r10), (RealFieldElement) this.q2.multiply(r10), (RealFieldElement) this.q3.multiply(r10));
    L18:
        RealFieldElement r11 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r5.sqrt()).reciprocal()).negate()).multiply(r6);
        return new FieldVector3D((RealFieldElement) this.q1.multiply(r11), (RealFieldElement) this.q2.multiply(r11), (RealFieldElement) this.q3.multiply(r11));
    L13:
        r6 = -1.0d;
        goto L15
    }

    public T getAngle() {
        if (this.q0.getReal() >= (-0.1d)) goto L5;
    L13:
        T r0 = this.q1;
        RealFieldElement r1 = (RealFieldElement) r0.multiply(r0);
        T r2 = this.q2;
        RealFieldElement r3 = (RealFieldElement) r1.add(r2.multiply(r2));
        T r6 = this.q3;
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r3.add(r6.multiply(r6))).sqrt()).asin()).multiply(2);
    L5:
        if (this.q0.getReal() > 0.1d) goto L13;
        if (this.q0.getReal() >= 0.0d) goto L12;
        return (T) ((RealFieldElement) ((RealFieldElement) this.q0.negate()).acos()).multiply(2);
    L12:
        return (T) ((RealFieldElement) this.q0.acos()).multiply(2);
    }

    @Deprecated
    public T[] getAngles(RotationOrder r2) throws CardanEulerSingularityException {
        return (T[]) getAngles(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public T[] getAngles(RotationOrder r15, RotationConvention r16) throws CardanEulerSingularityException {
        if (r16 != RotationConvention.VECTOR_OPERATOR) goto L123;
        if (r15 != RotationOrder.XYZ) goto L15;
        FieldVector3D<T> r8 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r0 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r0.getZ().getReal() < (-0.9999999999d)) goto L13;
        if (r0.getZ().getReal() > 0.9999999999d) goto L13;
        return (T[]) buildArray((RealFieldElement) ((RealFieldElement) r8.getY().negate()).atan2(r8.getZ()), (RealFieldElement) r0.getZ().asin(), (RealFieldElement) ((RealFieldElement) r0.getY().negate()).atan2(r0.getX()));
    L13:
        throw new CardanEulerSingularityException(true);
    L15:
        if (r15 != RotationOrder.XZY) goto L25;
        FieldVector3D<T> r9 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r1 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r1.getY().getReal() < (-0.9999999999d)) goto L23;
        if (r1.getY().getReal() > 0.9999999999d) goto L23;
        return (T[]) buildArray((RealFieldElement) r9.getZ().atan2(r9.getY()), (RealFieldElement) ((RealFieldElement) r1.getY().asin()).negate(), (RealFieldElement) r1.getZ().atan2(r1.getX()));
    L23:
        throw new CardanEulerSingularityException(true);
    L25:
        if (r15 != RotationOrder.YXZ) goto L35;
        FieldVector3D<T> r10 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r2 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r2.getZ().getReal() < (-0.9999999999d)) goto L33;
        if (r2.getZ().getReal() > 0.9999999999d) goto L33;
        return (T[]) buildArray((RealFieldElement) r10.getX().atan2(r10.getZ()), (RealFieldElement) ((RealFieldElement) r2.getZ().asin()).negate(), (RealFieldElement) r2.getX().atan2(r2.getY()));
    L33:
        throw new CardanEulerSingularityException(true);
    L35:
        if (r15 != RotationOrder.YZX) goto L45;
        FieldVector3D<T> r11 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r3 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r3.getX().getReal() < (-0.9999999999d)) goto L43;
        if (r3.getX().getReal() > 0.9999999999d) goto L43;
        return (T[]) buildArray((RealFieldElement) ((RealFieldElement) r11.getZ().negate()).atan2(r11.getX()), (RealFieldElement) r3.getX().asin(), (RealFieldElement) ((RealFieldElement) r3.getZ().negate()).atan2(r3.getY()));
    L43:
        throw new CardanEulerSingularityException(true);
    L45:
        if (r15 != RotationOrder.ZXY) goto L55;
        FieldVector3D<T> r12 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r4 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r4.getY().getReal() < (-0.9999999999d)) goto L53;
        if (r4.getY().getReal() > 0.9999999999d) goto L53;
        return (T[]) buildArray((RealFieldElement) ((RealFieldElement) r12.getX().negate()).atan2(r12.getY()), (RealFieldElement) r4.getY().asin(), (RealFieldElement) ((RealFieldElement) r4.getX().negate()).atan2(r4.getZ()));
    L53:
        throw new CardanEulerSingularityException(true);
    L55:
        if (r15 != RotationOrder.ZYX) goto L65;
        FieldVector3D<T> r13 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r5 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r5.getX().getReal() < (-0.9999999999d)) goto L63;
        if (r5.getX().getReal() > 0.9999999999d) goto L63;
        return (T[]) buildArray((RealFieldElement) r13.getY().atan2(r13.getX()), (RealFieldElement) ((RealFieldElement) r5.getX().asin()).negate(), (RealFieldElement) r5.getY().atan2(r5.getZ()));
    L63:
        throw new CardanEulerSingularityException(true);
    L65:
        if (r15 != RotationOrder.XYX) goto L75;
        FieldVector3D<T> r14 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r6 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r6.getX().getReal() < (-0.9999999999d)) goto L73;
        if (r6.getX().getReal() > 0.9999999999d) goto L73;
        return (T[]) buildArray((RealFieldElement) r14.getY().atan2(r14.getZ().negate()), (RealFieldElement) r6.getX().acos(), (RealFieldElement) r6.getY().atan2(r6.getZ()));
    L73:
        throw new CardanEulerSingularityException(false);
    L75:
        if (r15 != RotationOrder.XZX) goto L85;
        FieldVector3D<T> r17 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r7 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r7.getX().getReal() < (-0.9999999999d)) goto L83;
        if (r7.getX().getReal() > 0.9999999999d) goto L83;
        return (T[]) buildArray((RealFieldElement) r17.getZ().atan2(r17.getY()), (RealFieldElement) r7.getX().acos(), (RealFieldElement) r7.getZ().atan2(r7.getY().negate()));
    L83:
        throw new CardanEulerSingularityException(false);
    L85:
        if (r15 != RotationOrder.YXY) goto L95;
        FieldVector3D<T> r18 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r19 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r19.getY().getReal() < (-0.9999999999d)) goto L93;
        if (r19.getY().getReal() > 0.9999999999d) goto L93;
        return (T[]) buildArray((RealFieldElement) r18.getX().atan2(r18.getZ()), (RealFieldElement) r19.getY().acos(), (RealFieldElement) r19.getX().atan2(r19.getZ().negate()));
    L93:
        throw new CardanEulerSingularityException(false);
    L95:
        if (r15 != RotationOrder.YZY) goto L105;
        FieldVector3D<T> r20 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r21 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r21.getY().getReal() < (-0.9999999999d)) goto L103;
        if (r21.getY().getReal() > 0.9999999999d) goto L103;
        return (T[]) buildArray((RealFieldElement) r20.getZ().atan2(r20.getX().negate()), (RealFieldElement) r21.getY().acos(), (RealFieldElement) r21.getZ().atan2(r21.getX()));
    L103:
        throw new CardanEulerSingularityException(false);
    L105:
        if (r15 != RotationOrder.ZXZ) goto L114;
        FieldVector3D<T> r22 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r23 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r23.getZ().getReal() < (-0.9999999999d)) goto L113;
        if (r23.getZ().getReal() > 0.9999999999d) goto L113;
        return (T[]) buildArray((RealFieldElement) r22.getX().atan2(r22.getY().negate()), (RealFieldElement) r23.getZ().acos(), (RealFieldElement) r23.getX().atan2(r23.getY()));
    L113:
        throw new CardanEulerSingularityException(false);
    L114:
        FieldVector3D<T> r24 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r25 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r25.getZ().getReal() < (-0.9999999999d)) goto L121;
        if (r25.getZ().getReal() > 0.9999999999d) goto L121;
        return (T[]) buildArray((RealFieldElement) r24.getY().atan2(r24.getX()), (RealFieldElement) r25.getZ().acos(), (RealFieldElement) r25.getY().atan2(r25.getX().negate()));
    L121:
        throw new CardanEulerSingularityException(false);
    L123:
        if (r15 != RotationOrder.XYZ) goto L133;
        FieldVector3D<T> r26 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r27 = applyInverseTo(Vector3D.PLUS_K);
        if (r27.getX().getReal() < (-0.9999999999d)) goto L131;
        if (r27.getX().getReal() > 0.9999999999d) goto L131;
        return (T[]) buildArray((RealFieldElement) ((RealFieldElement) r27.getY().negate()).atan2(r27.getZ()), (RealFieldElement) r27.getX().asin(), (RealFieldElement) ((RealFieldElement) r26.getY().negate()).atan2(r26.getX()));
    L131:
        throw new CardanEulerSingularityException(true);
    L133:
        if (r15 != RotationOrder.XZY) goto L143;
        FieldVector3D<T> r28 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r29 = applyInverseTo(Vector3D.PLUS_J);
        if (r29.getX().getReal() < (-0.9999999999d)) goto L141;
        if (r29.getX().getReal() > 0.9999999999d) goto L141;
        return (T[]) buildArray((RealFieldElement) r29.getZ().atan2(r29.getY()), (RealFieldElement) ((RealFieldElement) r29.getX().asin()).negate(), (RealFieldElement) r28.getZ().atan2(r28.getX()));
    L141:
        throw new CardanEulerSingularityException(true);
    L143:
        if (r15 != RotationOrder.YXZ) goto L153;
        FieldVector3D<T> r30 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r31 = applyInverseTo(Vector3D.PLUS_K);
        if (r31.getY().getReal() < (-0.9999999999d)) goto L151;
        if (r31.getY().getReal() > 0.9999999999d) goto L151;
        return (T[]) buildArray((RealFieldElement) r31.getX().atan2(r31.getZ()), (RealFieldElement) ((RealFieldElement) r31.getY().asin()).negate(), (RealFieldElement) r30.getX().atan2(r30.getY()));
    L151:
        throw new CardanEulerSingularityException(true);
    L153:
        if (r15 != RotationOrder.YZX) goto L163;
        FieldVector3D<T> r32 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r33 = applyInverseTo(Vector3D.PLUS_I);
        if (r33.getY().getReal() < (-0.9999999999d)) goto L161;
        if (r33.getY().getReal() > 0.9999999999d) goto L161;
        return (T[]) buildArray((RealFieldElement) ((RealFieldElement) r33.getZ().negate()).atan2(r33.getX()), (RealFieldElement) r33.getY().asin(), (RealFieldElement) ((RealFieldElement) r32.getZ().negate()).atan2(r32.getY()));
    L161:
        throw new CardanEulerSingularityException(true);
    L163:
        if (r15 != RotationOrder.ZXY) goto L173;
        FieldVector3D<T> r34 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r35 = applyInverseTo(Vector3D.PLUS_J);
        if (r35.getZ().getReal() < (-0.9999999999d)) goto L171;
        if (r35.getZ().getReal() > 0.9999999999d) goto L171;
        return (T[]) buildArray((RealFieldElement) ((RealFieldElement) r35.getX().negate()).atan2(r35.getY()), (RealFieldElement) r35.getZ().asin(), (RealFieldElement) ((RealFieldElement) r34.getX().negate()).atan2(r34.getZ()));
    L171:
        throw new CardanEulerSingularityException(true);
    L173:
        if (r15 != RotationOrder.ZYX) goto L183;
        FieldVector3D<T> r36 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r37 = applyInverseTo(Vector3D.PLUS_I);
        if (r37.getZ().getReal() < (-0.9999999999d)) goto L181;
        if (r37.getZ().getReal() > 0.9999999999d) goto L181;
        return (T[]) buildArray((RealFieldElement) r37.getY().atan2(r37.getX()), (RealFieldElement) ((RealFieldElement) r37.getZ().asin()).negate(), (RealFieldElement) r36.getY().atan2(r36.getZ()));
    L181:
        throw new CardanEulerSingularityException(true);
    L183:
        if (r15 != RotationOrder.XYX) goto L193;
        FieldVector3D<T> r38 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r39 = applyInverseTo(Vector3D.PLUS_I);
        if (r39.getX().getReal() < (-0.9999999999d)) goto L191;
        if (r39.getX().getReal() > 0.9999999999d) goto L191;
        return (T[]) buildArray((RealFieldElement) r39.getY().atan2(r39.getZ().negate()), (RealFieldElement) r39.getX().acos(), (RealFieldElement) r38.getY().atan2(r38.getZ()));
    L191:
        throw new CardanEulerSingularityException(false);
    L193:
        if (r15 != RotationOrder.XZX) goto L203;
        FieldVector3D<T> r40 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r41 = applyInverseTo(Vector3D.PLUS_I);
        if (r41.getX().getReal() < (-0.9999999999d)) goto L201;
        if (r41.getX().getReal() > 0.9999999999d) goto L201;
        return (T[]) buildArray((RealFieldElement) r41.getZ().atan2(r41.getY()), (RealFieldElement) r41.getX().acos(), (RealFieldElement) r40.getZ().atan2(r40.getY().negate()));
    L201:
        throw new CardanEulerSingularityException(false);
    L203:
        if (r15 != RotationOrder.YXY) goto L213;
        FieldVector3D<T> r42 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r43 = applyInverseTo(Vector3D.PLUS_J);
        if (r43.getY().getReal() < (-0.9999999999d)) goto L211;
        if (r43.getY().getReal() > 0.9999999999d) goto L211;
        return (T[]) buildArray((RealFieldElement) r43.getX().atan2(r43.getZ()), (RealFieldElement) r43.getY().acos(), (RealFieldElement) r42.getX().atan2(r42.getZ().negate()));
    L211:
        throw new CardanEulerSingularityException(false);
    L213:
        if (r15 != RotationOrder.YZY) goto L223;
        FieldVector3D<T> r44 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r45 = applyInverseTo(Vector3D.PLUS_J);
        if (r45.getY().getReal() < (-0.9999999999d)) goto L221;
        if (r45.getY().getReal() > 0.9999999999d) goto L221;
        return (T[]) buildArray((RealFieldElement) r45.getZ().atan2(r45.getX().negate()), (RealFieldElement) r45.getY().acos(), (RealFieldElement) r44.getZ().atan2(r44.getX()));
    L221:
        throw new CardanEulerSingularityException(false);
    L223:
        if (r15 != RotationOrder.ZXZ) goto L232;
        FieldVector3D<T> r46 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r47 = applyInverseTo(Vector3D.PLUS_K);
        if (r47.getZ().getReal() < (-0.9999999999d)) goto L231;
        if (r47.getZ().getReal() > 0.9999999999d) goto L231;
        return (T[]) buildArray((RealFieldElement) r47.getX().atan2(r47.getY().negate()), (RealFieldElement) r47.getZ().acos(), (RealFieldElement) r46.getX().atan2(r46.getY()));
    L231:
        throw new CardanEulerSingularityException(false);
    L232:
        FieldVector3D<T> r48 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r49 = applyInverseTo(Vector3D.PLUS_K);
        if (r49.getZ().getReal() < (-0.9999999999d)) goto L239;
        if (r49.getZ().getReal() > 0.9999999999d) goto L239;
        return (T[]) buildArray((RealFieldElement) r49.getY().atan2(r49.getX()), (RealFieldElement) r49.getZ().acos(), (RealFieldElement) r48.getY().atan2(r48.getX().negate()));
    L239:
        throw new CardanEulerSingularityException(false);
    }

    private T[] buildArray(T r2, T r3, T r4) {
        T[] r1 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r2.getField(), 3));
        r1[0] = r2;
        r1[1] = r3;
        r1[2] = r4;
        return r1;
    }

    private FieldVector3D<T> vector(double r2, double r4, double r6) {
        RealFieldElement r1 = (RealFieldElement) this.q0.getField().getZero();
        return new FieldVector3D((RealFieldElement) r1.add(r2), (RealFieldElement) r1.add(r4), (RealFieldElement) r1.add(r6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] getMatrix() {
        T r1 = this.q0;
        RealFieldElement r2 = (RealFieldElement) r1.multiply(r1);
        RealFieldElement r3 = (RealFieldElement) this.q0.multiply(this.q1);
        RealFieldElement r4 = (RealFieldElement) this.q0.multiply(this.q2);
        RealFieldElement r5 = (RealFieldElement) this.q0.multiply(this.q3);
        T r6 = this.q1;
        RealFieldElement r7 = (RealFieldElement) r6.multiply(r6);
        RealFieldElement r8 = (RealFieldElement) this.q1.multiply(this.q2);
        RealFieldElement r9 = (RealFieldElement) this.q1.multiply(this.q3);
        T r10 = this.q2;
        RealFieldElement r11 = (RealFieldElement) r10.multiply(r10);
        RealFieldElement r12 = (RealFieldElement) this.q2.multiply(this.q3);
        T r13 = this.q3;
        RealFieldElement r14 = (RealFieldElement) r13.multiply(r13);
        T[][] r0 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(this.q0.getField(), 3, 3));
        r0[0][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.add(r7)).multiply(2)).subtract(1.0d);
        r0[1][0] = (RealFieldElement) ((RealFieldElement) r8.subtract(r5)).multiply(2);
        r0[2][0] = (RealFieldElement) ((RealFieldElement) r9.add(r4)).multiply(2);
        r0[0][1] = (RealFieldElement) ((RealFieldElement) r8.add(r5)).multiply(2);
        r0[1][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.add(r11)).multiply(2)).subtract(1.0d);
        r0[2][1] = (RealFieldElement) ((RealFieldElement) r12.subtract(r3)).multiply(2);
        r0[0][2] = (RealFieldElement) ((RealFieldElement) r9.subtract(r4)).multiply(2);
        r0[1][2] = (RealFieldElement) ((RealFieldElement) r12.add(r3)).multiply(2);
        r0[2][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.add(r14)).multiply(2)).subtract(1.0d);
        return r0;
    }

    public Rotation toRotation() {
        return new Rotation(this.q0.getReal(), this.q1.getReal(), this.q2.getReal(), this.q3.getReal(), false);
    }

    public FieldVector3D<T> applyTo(FieldVector3D<T> r11) {
        RealFieldElement r0 = r11.getX();
        RealFieldElement r1 = r11.getY();
        RealFieldElement r12 = r11.getZ();
        RealFieldElement r2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r0)).add(this.q2.multiply(r1))).add(this.q3.multiply(r12));
        T r4 = this.q0;
        RealFieldElement r5 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r4.multiply(((RealFieldElement) r0.multiply(r4)).subtract(((RealFieldElement) this.q2.multiply(r12)).subtract(this.q3.multiply(r1))))).add(r2.multiply(this.q1))).multiply(2)).subtract(r0);
        T r6 = this.q0;
        RealFieldElement r7 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r1.multiply(r6)).subtract(((RealFieldElement) this.q3.multiply(r0)).subtract(this.q1.multiply(r12))))).add(r2.multiply(this.q2))).multiply(2)).subtract(r1);
        T r8 = this.q0;
        return new FieldVector3D(r5, r7, (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r8.multiply(((RealFieldElement) r12.multiply(r8)).subtract(((RealFieldElement) this.q1.multiply(r1)).subtract(this.q2.multiply(r0))))).add(r2.multiply(this.q3))).multiply(2)).subtract(r12));
    }

    public FieldVector3D<T> applyTo(Vector3D r14) {
        double r0 = r14.getX();
        double r2 = r14.getY();
        double r4 = r14.getZ();
        RealFieldElement r15 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r0)).add(this.q2.multiply(r2))).add(this.q3.multiply(r4));
        T r7 = this.q0;
        RealFieldElement r8 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r7.multiply(((RealFieldElement) r7.multiply(r0)).subtract(((RealFieldElement) this.q2.multiply(r4)).subtract(this.q3.multiply(r2))))).add(r15.multiply(this.q1))).multiply(2)).subtract(r0);
        T r9 = this.q0;
        RealFieldElement r10 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.multiply(((RealFieldElement) r9.multiply(r2)).subtract(((RealFieldElement) this.q3.multiply(r0)).subtract(this.q1.multiply(r4))))).add(r15.multiply(this.q2))).multiply(2)).subtract(r2);
        T r11 = this.q0;
        return new FieldVector3D(r8, r10, (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r11.multiply(((RealFieldElement) r11.multiply(r4)).subtract(((RealFieldElement) this.q1.multiply(r2)).subtract(this.q2.multiply(r0))))).add(r15.multiply(this.q3))).multiply(2)).subtract(r4));
    }

    public void applyTo(T[] r11, T[] r12) {
        T r1 = r11[0];
        T r3 = r11[1];
        T r13 = r11[2];
        RealFieldElement r5 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r1)).add(this.q2.multiply(r3))).add(this.q3.multiply(r13));
        T r6 = this.q0;
        r12[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r1.multiply(r6)).subtract(((RealFieldElement) this.q2.multiply(r13)).subtract(this.q3.multiply(r3))))).add(r5.multiply(this.q1))).multiply(2)).subtract(r1);
        T r0 = this.q0;
        r12[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(((RealFieldElement) r3.multiply(r0)).subtract(((RealFieldElement) this.q3.multiply(r1)).subtract(this.q1.multiply(r13))))).add(r5.multiply(this.q2))).multiply(2)).subtract(r3);
        T r2 = this.q0;
        r12[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(((RealFieldElement) r13.multiply(r2)).subtract(((RealFieldElement) this.q1.multiply(r3)).subtract(this.q2.multiply(r1))))).add(r5.multiply(this.q3))).multiply(2)).subtract(r13);
    }

    public void applyTo(double[] r14, T[] r15) {
        double r1 = r14[0];
        double r4 = r14[1];
        double r7 = r14[2];
        RealFieldElement r16 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r1)).add(this.q2.multiply(r4))).add(this.q3.multiply(r7));
        T r9 = this.q0;
        r15[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.multiply(((RealFieldElement) r9.multiply(r1)).subtract(((RealFieldElement) this.q2.multiply(r7)).subtract(this.q3.multiply(r4))))).add(r16.multiply(this.q1))).multiply(2)).subtract(r1);
        T r0 = this.q0;
        r15[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(((RealFieldElement) r0.multiply(r4)).subtract(((RealFieldElement) this.q3.multiply(r1)).subtract(this.q1.multiply(r7))))).add(r16.multiply(this.q2))).multiply(2)).subtract(r4);
        T r2 = this.q0;
        r15[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(((RealFieldElement) r2.multiply(r7)).subtract(((RealFieldElement) this.q1.multiply(r4)).subtract(this.q2.multiply(r1))))).add(r16.multiply(this.q3))).multiply(2)).subtract(r7);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyTo(Rotation r10, FieldVector3D<T> r11) {
        RealFieldElement r0 = r11.getX();
        RealFieldElement r1 = r11.getY();
        RealFieldElement r12 = r11.getZ();
        RealFieldElement r2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(r10.getQ1())).add(r1.multiply(r10.getQ2()))).add(r12.multiply(r10.getQ3()));
        return new FieldVector3D((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(r10.getQ0())).subtract(((RealFieldElement) r12.multiply(r10.getQ2())).subtract(r1.multiply(r10.getQ3())))).multiply(r10.getQ0())).add(r2.multiply(r10.getQ1()))).multiply(2)).subtract(r0), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(r10.getQ0())).subtract(((RealFieldElement) r0.multiply(r10.getQ3())).subtract(r12.multiply(r10.getQ1())))).multiply(r10.getQ0())).add(r2.multiply(r10.getQ2()))).multiply(2)).subtract(r1), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r12.multiply(r10.getQ0())).subtract(((RealFieldElement) r1.multiply(r10.getQ1())).subtract(r0.multiply(r10.getQ2())))).multiply(r10.getQ0())).add(r2.multiply(r10.getQ3()))).multiply(2)).subtract(r12));
    }

    public FieldVector3D<T> applyInverseTo(FieldVector3D<T> r11) {
        RealFieldElement r0 = r11.getX();
        RealFieldElement r1 = r11.getY();
        RealFieldElement r12 = r11.getZ();
        RealFieldElement r2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r0)).add(this.q2.multiply(r1))).add(this.q3.multiply(r12));
        RealFieldElement r3 = (RealFieldElement) this.q0.negate();
        return new FieldVector3D((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r3.multiply(((RealFieldElement) r0.multiply(r3)).subtract(((RealFieldElement) this.q2.multiply(r12)).subtract(this.q3.multiply(r1))))).add(r2.multiply(this.q1))).multiply(2)).subtract(r0), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r3.multiply(((RealFieldElement) r1.multiply(r3)).subtract(((RealFieldElement) this.q3.multiply(r0)).subtract(this.q1.multiply(r12))))).add(r2.multiply(this.q2))).multiply(2)).subtract(r1), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r3.multiply(((RealFieldElement) r12.multiply(r3)).subtract(((RealFieldElement) this.q1.multiply(r1)).subtract(this.q2.multiply(r0))))).add(r2.multiply(this.q3))).multiply(2)).subtract(r12));
    }

    public FieldVector3D<T> applyInverseTo(Vector3D r14) {
        double r0 = r14.getX();
        double r2 = r14.getY();
        double r4 = r14.getZ();
        RealFieldElement r15 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r0)).add(this.q2.multiply(r2))).add(this.q3.multiply(r4));
        RealFieldElement r6 = (RealFieldElement) this.q0.negate();
        return new FieldVector3D((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r6.multiply(r0)).subtract(((RealFieldElement) this.q2.multiply(r4)).subtract(this.q3.multiply(r2))))).add(r15.multiply(this.q1))).multiply(2)).subtract(r0), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r6.multiply(r2)).subtract(((RealFieldElement) this.q3.multiply(r0)).subtract(this.q1.multiply(r4))))).add(r15.multiply(this.q2))).multiply(2)).subtract(r2), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r6.multiply(r4)).subtract(((RealFieldElement) this.q1.multiply(r2)).subtract(this.q2.multiply(r0))))).add(r15.multiply(this.q3))).multiply(2)).subtract(r4));
    }

    public void applyInverseTo(T[] r11, T[] r12) {
        T r1 = r11[0];
        T r3 = r11[1];
        T r13 = r11[2];
        RealFieldElement r5 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r1)).add(this.q2.multiply(r3))).add(this.q3.multiply(r13));
        RealFieldElement r6 = (RealFieldElement) this.q0.negate();
        r12[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r1.multiply(r6)).subtract(((RealFieldElement) this.q2.multiply(r13)).subtract(this.q3.multiply(r3))))).add(r5.multiply(this.q1))).multiply(2)).subtract(r1);
        r12[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r3.multiply(r6)).subtract(((RealFieldElement) this.q3.multiply(r1)).subtract(this.q1.multiply(r13))))).add(r5.multiply(this.q2))).multiply(2)).subtract(r3);
        r12[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r6.multiply(((RealFieldElement) r13.multiply(r6)).subtract(((RealFieldElement) this.q1.multiply(r3)).subtract(this.q2.multiply(r1))))).add(r5.multiply(this.q3))).multiply(2)).subtract(r13);
    }

    public void applyInverseTo(double[] r14, T[] r15) {
        double r1 = r14[0];
        double r4 = r14[1];
        double r7 = r14[2];
        RealFieldElement r16 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r1)).add(this.q2.multiply(r4))).add(this.q3.multiply(r7));
        RealFieldElement r9 = (RealFieldElement) this.q0.negate();
        r15[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.multiply(((RealFieldElement) r9.multiply(r1)).subtract(((RealFieldElement) this.q2.multiply(r7)).subtract(this.q3.multiply(r4))))).add(r16.multiply(this.q1))).multiply(2)).subtract(r1);
        r15[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.multiply(((RealFieldElement) r9.multiply(r4)).subtract(((RealFieldElement) this.q3.multiply(r1)).subtract(this.q1.multiply(r7))))).add(r16.multiply(this.q2))).multiply(2)).subtract(r4);
        r15[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.multiply(((RealFieldElement) r9.multiply(r7)).subtract(((RealFieldElement) this.q1.multiply(r4)).subtract(this.q2.multiply(r1))))).add(r16.multiply(this.q3))).multiply(2)).subtract(r7);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyInverseTo(Rotation r12, FieldVector3D<T> r13) {
        RealFieldElement r0 = r13.getX();
        RealFieldElement r1 = r13.getY();
        RealFieldElement r14 = r13.getZ();
        RealFieldElement r2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(r12.getQ1())).add(r1.multiply(r12.getQ2()))).add(r14.multiply(r12.getQ3()));
        double r3 = -r12.getQ0();
        return new FieldVector3D((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r0.multiply(r3)).subtract(((RealFieldElement) r14.multiply(r12.getQ2())).subtract(r1.multiply(r12.getQ3())))).multiply(r3)).add(r2.multiply(r12.getQ1()))).multiply(2)).subtract(r0), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r1.multiply(r3)).subtract(((RealFieldElement) r0.multiply(r12.getQ3())).subtract(r14.multiply(r12.getQ1())))).multiply(r3)).add(r2.multiply(r12.getQ2()))).multiply(2)).subtract(r1), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r14.multiply(r3)).subtract(((RealFieldElement) r1.multiply(r12.getQ1())).subtract(r0.multiply(r12.getQ2())))).multiply(r3)).add(r2.multiply(r12.getQ3()))).multiply(2)).subtract(r14));
    }

    public FieldRotation<T> applyTo(FieldRotation<T> r2) {
        return compose(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> compose(FieldRotation<T> r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInternal(r2);
    L6:
        return r2.composeInternal(this);
    }

    private FieldRotation<T> composeInternal(FieldRotation<T> r8) {
        return new FieldRotation((RealFieldElement) ((RealFieldElement) r8.q0.multiply(this.q0)).subtract(((RealFieldElement) ((RealFieldElement) r8.q1.multiply(this.q1)).add(r8.q2.multiply(this.q2))).add(r8.q3.multiply(this.q3))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r8.q1.multiply(this.q0)).add(r8.q0.multiply(this.q1))).add(((RealFieldElement) r8.q2.multiply(this.q3)).subtract(r8.q3.multiply(this.q2))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r8.q2.multiply(this.q0)).add(r8.q0.multiply(this.q2))).add(((RealFieldElement) r8.q3.multiply(this.q1)).subtract(r8.q1.multiply(this.q3))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r8.q3.multiply(this.q0)).add(r8.q0.multiply(this.q3))).add(((RealFieldElement) r8.q1.multiply(this.q2)).subtract(r8.q2.multiply(this.q1))), false);
    }

    public FieldRotation<T> applyTo(Rotation r2) {
        return compose(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> compose(Rotation r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInternal(r2);
    L6:
        return applyTo(r2, this);
    }

    private FieldRotation<T> composeInternal(Rotation r10) {
        return new FieldRotation((RealFieldElement) ((RealFieldElement) this.q0.multiply(r10.getQ0())).subtract(((RealFieldElement) ((RealFieldElement) this.q1.multiply(r10.getQ1())).add(this.q2.multiply(r10.getQ2()))).add(this.q3.multiply(r10.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q0.multiply(r10.getQ1())).add(this.q1.multiply(r10.getQ0()))).add(((RealFieldElement) this.q3.multiply(r10.getQ2())).subtract(this.q2.multiply(r10.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q0.multiply(r10.getQ2())).add(this.q2.multiply(r10.getQ0()))).add(((RealFieldElement) this.q1.multiply(r10.getQ3())).subtract(this.q3.multiply(r10.getQ1()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q0.multiply(r10.getQ3())).add(this.q3.multiply(r10.getQ0()))).add(((RealFieldElement) this.q2.multiply(r10.getQ1())).subtract(this.q1.multiply(r10.getQ2()))), false);
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyTo(Rotation r9, FieldRotation<T> r10) {
        return new FieldRotation((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q0.multiply(r9.getQ0())).subtract(((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q1.multiply(r9.getQ1())).add(((FieldRotation) r10).q2.multiply(r9.getQ2()))).add(((FieldRotation) r10).q3.multiply(r9.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q1.multiply(r9.getQ0())).add(((FieldRotation) r10).q0.multiply(r9.getQ1()))).add(((RealFieldElement) ((FieldRotation) r10).q2.multiply(r9.getQ3())).subtract(((FieldRotation) r10).q3.multiply(r9.getQ2()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q2.multiply(r9.getQ0())).add(((FieldRotation) r10).q0.multiply(r9.getQ2()))).add(((RealFieldElement) ((FieldRotation) r10).q3.multiply(r9.getQ1())).subtract(((FieldRotation) r10).q1.multiply(r9.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q3.multiply(r9.getQ0())).add(((FieldRotation) r10).q0.multiply(r9.getQ3()))).add(((RealFieldElement) ((FieldRotation) r10).q1.multiply(r9.getQ2())).subtract(((FieldRotation) r10).q2.multiply(r9.getQ1()))), false);
    }

    public FieldRotation<T> applyInverseTo(FieldRotation<T> r2) {
        return composeInverse(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> composeInverse(FieldRotation<T> r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInverseInternal(r2);
    L6:
        return r2.composeInternal(revert());
    }

    private FieldRotation<T> composeInverseInternal(FieldRotation<T> r9) {
        return new FieldRotation((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.q0.multiply(this.q0)).add(((RealFieldElement) ((RealFieldElement) r9.q1.multiply(this.q1)).add(r9.q2.multiply(this.q2))).add(r9.q3.multiply(this.q3)))).negate(), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.q0.multiply(this.q1)).add(((RealFieldElement) r9.q2.multiply(this.q3)).subtract(r9.q3.multiply(this.q2)))).subtract(r9.q1.multiply(this.q0)), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.q0.multiply(this.q2)).add(((RealFieldElement) r9.q3.multiply(this.q1)).subtract(r9.q1.multiply(this.q3)))).subtract(r9.q2.multiply(this.q0)), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.q0.multiply(this.q3)).add(((RealFieldElement) r9.q1.multiply(this.q2)).subtract(r9.q2.multiply(this.q1)))).subtract(r9.q3.multiply(this.q0)), false);
    }

    public FieldRotation<T> applyInverseTo(Rotation r2) {
        return composeInverse(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> composeInverse(Rotation r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInverseInternal(r2);
    L6:
        return applyTo(r2, revert());
    }

    private FieldRotation<T> composeInverseInternal(Rotation r10) {
        return new FieldRotation((RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q0.multiply(r10.getQ0())).add(((RealFieldElement) ((RealFieldElement) this.q1.multiply(r10.getQ1())).add(this.q2.multiply(r10.getQ2()))).add(this.q3.multiply(r10.getQ3())))).negate(), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q1.multiply(r10.getQ0())).add(((RealFieldElement) this.q3.multiply(r10.getQ2())).subtract(this.q2.multiply(r10.getQ3())))).subtract(this.q0.multiply(r10.getQ1())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q2.multiply(r10.getQ0())).add(((RealFieldElement) this.q1.multiply(r10.getQ3())).subtract(this.q3.multiply(r10.getQ1())))).subtract(this.q0.multiply(r10.getQ2())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.q3.multiply(r10.getQ0())).add(((RealFieldElement) this.q2.multiply(r10.getQ1())).subtract(this.q1.multiply(r10.getQ2())))).subtract(this.q0.multiply(r10.getQ3())), false);
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyInverseTo(Rotation r9, FieldRotation<T> r10) {
        return new FieldRotation((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q0.multiply(r9.getQ0())).add(((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q1.multiply(r9.getQ1())).add(((FieldRotation) r10).q2.multiply(r9.getQ2()))).add(((FieldRotation) r10).q3.multiply(r9.getQ3())))).negate(), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q0.multiply(r9.getQ1())).add(((RealFieldElement) ((FieldRotation) r10).q2.multiply(r9.getQ3())).subtract(((FieldRotation) r10).q3.multiply(r9.getQ2())))).subtract(((FieldRotation) r10).q1.multiply(r9.getQ0())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q0.multiply(r9.getQ2())).add(((RealFieldElement) ((FieldRotation) r10).q3.multiply(r9.getQ1())).subtract(((FieldRotation) r10).q1.multiply(r9.getQ3())))).subtract(((FieldRotation) r10).q2.multiply(r9.getQ0())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) r10).q0.multiply(r9.getQ3())).add(((RealFieldElement) ((FieldRotation) r10).q1.multiply(r9.getQ2())).subtract(((FieldRotation) r10).q2.multiply(r9.getQ1())))).subtract(((FieldRotation) r10).q3.multiply(r9.getQ0())), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v2, types: [T extends org.apache.commons.math3.RealFieldElement<T>[][], org.apache.commons.math3.RealFieldElement[][]] */
    /* JADX WARN: Type inference failed for: r15v38 */
    /* JADX WARN: Type inference failed for: r16v9, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r20v1, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r23v1, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r27v0, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v9, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object] */
    private T[][] orthogonalizeMatrix(T[][] r31, double r32) throws NotARotationMatrixException {
        char r0 = 0;
        T[] r1 = r31[0];
        T r2 = r1[0];
        int r3 = 1;
        T r4 = r1[1];
        T r5 = r1[2];
        T[] r6 = r31[1];
        T r7 = r6[0];
        T r8 = r6[1];
        T r9 = r6[2];
        T[] r10 = r31[2];
        T r11 = r10[0];
        T r12 = r10[1];
        T r13 = r10[2];
        ?? r14 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(r2.getField(), 3, 3));
        double r15 = 0.0d;
        int r16 = 0;
        ?? r17 = r5;
        ?? r18 = r2;
        ?? r19 = r4;
        ?? r20 = r9;
        ?? r21 = r7;
        ?? r22 = r8;
        ?? r23 = r13;
        ?? r110 = r11;
        ?? r111 = r12;
    L3:
        int r112 = r16 + r3;
        if (r112 >= 11) goto L9;
        RealFieldElement r24 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[r0][r0].multiply(r18)).add(r31[r3][r0].multiply(r21))).add(r31[2][r0].multiply(r110));
        RealFieldElement r25 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[r0][1].multiply(r18)).add(r31[1][1].multiply(r21))).add(r31[2][1].multiply(r110));
        double r26 = r15;
        RealFieldElement r27 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[0][2].multiply(r18)).add(r31[1][2].multiply(r21))).add(r31[2][2].multiply(r110));
        RealFieldElement r113 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[0][0].multiply(r19)).add(r31[1][0].multiply(r22))).add(r31[2][0].multiply(r111));
        ?? r28 = r110;
        RealFieldElement r114 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[0][1].multiply(r19)).add(r31[1][1].multiply(r22))).add(r31[2][1].multiply(r111));
        ?? r115 = r21;
        RealFieldElement r29 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[0][2].multiply(r19)).add(r31[1][2].multiply(r22))).add(r31[2][2].multiply(r111));
        ?? r210 = r111;
        RealFieldElement r116 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[0][0].multiply(r17)).add(r31[1][0].multiply(r20))).add(r31[2][0].multiply(r23));
        RealFieldElement r117 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[0][1].multiply(r17)).add(r31[1][1].multiply(r20))).add(r31[2][1].multiply(r23));
        ?? r211 = r22;
        RealFieldElement r30 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r31[0][2].multiply(r17)).add(r31[1][2].multiply(r20))).add(r31[2][2].multiply(r23));
        ?? r212 = r23;
        r14[0][0] = (RealFieldElement) r18.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r18.multiply(r24)).add(r19.multiply(r25))).add(r17.multiply(r27))).subtract(r31[0][0])).multiply(0.5d));
        r14[0][1] = (RealFieldElement) r19.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r18.multiply(r113)).add(r19.multiply(r114))).add(r17.multiply(r29))).subtract(r31[0][1])).multiply(0.5d));
        r14[0][2] = (RealFieldElement) r17.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r18.multiply(r116)).add(r19.multiply(r117))).add(r17.multiply(r30))).subtract(r31[0][2])).multiply(0.5d));
        r14[1][0] = (RealFieldElement) r115.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r115.multiply(r24)).add(r211.multiply(r25))).add(r20.multiply(r27))).subtract(r31[1][0])).multiply(0.5d));
        ?? r33 = r14[1];
        RealFieldElement r34 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r115.multiply(r113)).add(r211.multiply(r114))).add(r20.multiply(r29))).subtract(r31[1][1]);
        ?? r35 = r20;
        r33[1] = (RealFieldElement) r211.subtract(r34.multiply(0.5d));
        r14[1][2] = (RealFieldElement) r35.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r115.multiply(r116)).add(r211.multiply(r117))).add(r35.multiply(r30))).subtract(r31[1][2])).multiply(0.5d));
        r14[2][0] = (RealFieldElement) r28.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r28.multiply(r24)).add(r210.multiply(r25))).add(r212.multiply(r27))).subtract(r31[2][0])).multiply(0.5d));
        r14[2][1] = (RealFieldElement) r210.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r28.multiply(r113)).add(r210.multiply(r114))).add(r212.multiply(r29))).subtract(r31[2][1])).multiply(0.5d));
        r14[2][2] = (RealFieldElement) r212.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r28.multiply(r116)).add(r210.multiply(r117))).add(r212.multiply(r30))).subtract(r31[2][2])).multiply(0.5d));
        double r36 = r14[0][0].getReal() - r31[0][0].getReal();
        double r37 = r14[0][1].getReal() - r31[0][1].getReal();
        double r38 = r14[0][2].getReal() - r31[0][2].getReal();
        double r118 = r14[1][0].getReal() - r31[1][0].getReal();
        double r119 = r14[1][1].getReal() - r31[1][1].getReal();
        double r120 = r14[1][2].getReal() - r31[1][2].getReal();
        double r213 = r14[2][0].getReal() - r31[2][0].getReal();
        double r214 = r14[2][1].getReal() - r31[2][1].getReal();
        double r215 = r14[2][2].getReal() - r31[2][2].getReal();
        r15 = ((((((((r36 * r36) + (r37 * r37)) + (r38 * r38)) + (r118 * r118)) + (r119 * r119)) + (r120 * r120)) + (r213 * r213)) + (r214 * r214)) + (r215 * r215);
        if (FastMath.abs(r15 - r26) <= r32) goto L7;
        r0 = 0;
        ?? r39 = r14[0];
        ?? r40 = r39[0];
        r3 = 1;
        ?? r41 = r39[1];
        ?? r42 = r39[2];
        ?? r43 = r14[1];
        ?? r44 = r43[0];
        ?? r45 = r43[1];
        ?? r46 = r43[2];
        ?? r47 = r14[2];
        ?? r121 = r47[0];
        ?? r122 = r47[1];
        r16 = r112;
        r17 = r42;
        r18 = r40;
        r19 = r41;
        r20 = r46;
        r21 = r44;
        r22 = r45;
        r23 = r47[2];
        r110 = r121;
        r111 = r122;
        goto L3
    L7:
        return r14;
    L9:
        LocalizedFormats r48 = LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX;
        Object[] r49 = new Object[r3];
        r49[r0] = Integer.valueOf(r112 - 1);
        throw new NotARotationMatrixException(r48, r49);
    }

    public static <T extends RealFieldElement<T>> T distance(FieldRotation<T> r0, FieldRotation<T> r1) {
        return (T) r0.composeInverseInternal(r1).getAngle();
    }
}
