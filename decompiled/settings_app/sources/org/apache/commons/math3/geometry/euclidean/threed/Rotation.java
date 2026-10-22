package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class Rotation implements Serializable {
    public static final Rotation IDENTITY = null;
    private static final long serialVersionUID = -2153622329907944313L;
    private final double q0;
    private final double q1;
    private final double q2;
    private final double q3;

    static {
        IDENTITY = new Rotation(1.0d, 0.0d, 0.0d, 0.0d, false);
    }

    public Rotation(double r5, double r7, double r9, double r11, boolean r13) {
        if (r13 == false) goto L5;
        double r2 = 1.0d / FastMath.sqrt((((r5 * r5) + (r7 * r7)) + (r9 * r9)) + (r11 * r11));
        r5 = r5 * r2;
        r7 = r7 * r2;
        r9 = r9 * r2;
        r11 = r11 * r2;
    L5:
        this.q0 = r5;
        this.q1 = r7;
        this.q2 = r9;
        this.q3 = r11;
    }

    @Deprecated
    public Rotation(Vector3D r2, double r3) throws MathIllegalArgumentException {
        this(r2, r3, RotationConvention.VECTOR_OPERATOR);
    }

    public Rotation(Vector3D r5, double r6, RotationConvention r8) throws MathIllegalArgumentException {
        double r0 = r5.getNorm();
        if (r0 == 0.0d) goto L11;
        if (r8 != RotationConvention.VECTOR_OPERATOR) goto L7;
        double r2 = -0.5d;
    L8:
        double r7 = r6 * r2;
        double r3 = FastMath.sin(r7) / r0;
        this.q0 = FastMath.cos(r7);
        this.q1 = r5.getX() * r3;
        this.q2 = r5.getY() * r3;
        this.q3 = r3 * r5.getZ();
        return;
    L7:
        r2 = 0.5d;
        goto L8
    L11:
        throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
    }

    public Rotation(double[][] r26, double r27) throws NotARotationMatrixException {
        if (r26.length != 3) goto L17;
        if (r26[0].length != 3) goto L17;
        if (r26[1].length != 3) goto L17;
        if (r26[2].length != 3) goto L17;
        double[][] r1 = orthogonalizeMatrix(r26, r27);
        double[] r2 = r1[0];
        double r7 = r2[0];
        double[] r9 = r1[1];
        double r10 = r9[1];
        double[] r12 = r1[2];
        double r13 = r12[2];
        double r17 = r12[1];
        double r19 = r9[2];
        double r15 = r9[0];
        double r21 = r2[1];
        double r23 = r2[2];
        double r8 = ((r7 * ((r10 * r13) - (r17 * r19))) - (r15 * ((r13 * r21) - (r17 * r23)))) + (r12[0] * ((r21 * r19) - (r10 * r23)));
        if (r8 < 0.0d) goto L15;
        double[] r3 = mat2quat(r1);
        this.q0 = r3[0];
        this.q1 = r3[1];
        this.q2 = r3[2];
        this.q3 = r3[3];
        return;
    L15:
        throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, new Object[]{Double.valueOf(r8)});
    L17:
        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, new Object[]{Integer.valueOf(r26.length), Integer.valueOf(r26[0].length)});
    }

    public Rotation(Vector3D r28, Vector3D r29, Vector3D r30, Vector3D r31) throws MathArithmeticException {
        Vector3D r1 = r28.crossProduct(r29).normalize();
        Vector3D r3 = r1.crossProduct(r28).normalize();
        Vector3D r2 = r28.normalize();
        Vector3D r4 = r30.crossProduct(r31).normalize();
        Vector3D r6 = r4.crossProduct(r30).normalize();
        Vector3D r5 = r30.normalize();
        double[] r7 = mat2quat(new double[][]{new double[]{MathArrays.linearCombination(r2.getX(), r5.getX(), r3.getX(), r6.getX(), r1.getX(), r4.getX()), MathArrays.linearCombination(r2.getY(), r5.getX(), r3.getY(), r6.getX(), r1.getY(), r4.getX()), MathArrays.linearCombination(r2.getZ(), r5.getX(), r3.getZ(), r6.getX(), r1.getZ(), r4.getX())}, new double[]{MathArrays.linearCombination(r2.getX(), r5.getY(), r3.getX(), r6.getY(), r1.getX(), r4.getY()), MathArrays.linearCombination(r2.getY(), r5.getY(), r3.getY(), r6.getY(), r1.getY(), r4.getY()), MathArrays.linearCombination(r2.getZ(), r5.getY(), r3.getZ(), r6.getY(), r1.getZ(), r4.getY())}, new double[]{MathArrays.linearCombination(r2.getX(), r5.getZ(), r3.getX(), r6.getZ(), r1.getX(), r4.getZ()), MathArrays.linearCombination(r2.getY(), r5.getZ(), r3.getY(), r6.getZ(), r1.getY(), r4.getZ()), MathArrays.linearCombination(r2.getZ(), r5.getZ(), r3.getZ(), r6.getZ(), r1.getZ(), r4.getZ())}});
        this.q0 = r7[0];
        this.q1 = r7[1];
        this.q2 = r7[2];
        this.q3 = r7[3];
    }

    public Rotation(Vector3D r9, Vector3D r10) throws MathArithmeticException {
        double r0 = r9.getNorm() * r10.getNorm();
        if (r0 == 0.0d) goto L10;
        double r4 = r9.dotProduct(r10);
        if (r4 >= ((-0.999999999999998d) * r0)) goto L7;
        Vector3D r11 = r9.orthogonal();
        this.q0 = 0.0d;
        this.q1 = -r11.getX();
        this.q2 = -r11.getY();
        this.q3 = -r11.getZ();
        return;
    L7:
        double r5 = FastMath.sqrt(((r4 / r0) + 1.0d) * 0.5d);
        this.q0 = r5;
        double r2 = 1.0d / ((r5 * 2.0d) * r0);
        Vector3D r12 = r10.crossProduct(r9);
        this.q1 = r12.getX() * r2;
        this.q2 = r12.getY() * r2;
        this.q3 = r2 * r12.getZ();
        return;
    L10:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
    }

    @Deprecated
    public Rotation(RotationOrder r10, double r11, double r13, double r15) {
        this(r10, RotationConvention.VECTOR_OPERATOR, r11, r13, r15);
    }

    public Rotation(RotationOrder r3, RotationConvention r4, double r5, double r7, double r9) {
        Rotation r6 = new Rotation(r3.getA1(), r5, r4).compose(new Rotation(r3.getA2(), r7, r4).compose(new Rotation(r3.getA3(), r9, r4), r4), r4);
        this.q0 = r6.q0;
        this.q1 = r6.q1;
        this.q2 = r6.q2;
        this.q3 = r6.q3;
    }

    private static double[] mat2quat(double[][] r22) {
        double[] r0 = new double[4];
        double r2 = r22[0][0];
        double r5 = r22[1][1];
        double r10 = r22[2][2];
        double r7 = (r2 + r5) + r10;
        if (r7 <= (-0.19d)) goto L5;
        double r3 = FastMath.sqrt(r7 + 1.0d) * 0.5d;
        r0[0] = r3;
        double r16 = 0.25d / r3;
        double[] r4 = r22[1];
        double r6 = r4[2];
        double[] r8 = r22[2];
        r0[1] = (r6 - r8[1]) * r16;
        double r9 = r8[0];
        double[] r11 = r22[0];
        r0[2] = (r9 - r11[2]) * r16;
        r0[3] = r16 * (r11[1] - r4[0]);
    L12:
        return r0;
    L5:
        double r12 = (r2 - r5) - r10;
        if (r12 <= (-0.19d)) goto L8;
        double r13 = FastMath.sqrt(r12 + 1.0d) * 0.5d;
        r0[1] = r13;
        double r17 = 0.25d / r13;
        double[] r14 = r22[1];
        double r15 = r14[2];
        double[] r18 = r22[2];
        r0[0] = (r15 - r18[1]) * r17;
        double[] r19 = r22[0];
        r0[2] = (r19[1] + r14[0]) * r17;
        r0[3] = r17 * (r19[2] + r18[0]);
        goto L12
    L8:
        double r20 = (r5 - r2) - r10;
        if (r20 <= (-0.19d)) goto L11;
        double r21 = FastMath.sqrt(r20 + 1.0d) * 0.5d;
        r0[2] = r21;
        double r110 = 0.25d / r21;
        double[] r23 = r22[2];
        double r24 = r23[0];
        double[] r25 = r22[0];
        r0[0] = (r24 - r25[2]) * r110;
        double r26 = r25[1];
        double[] r27 = r22[1];
        r0[1] = (r26 + r27[0]) * r110;
        r0[3] = r110 * (r23[1] + r27[2]);
        goto L12
    L11:
        double r28 = FastMath.sqrt(((r10 - r2) - r5) + 1.0d) * 0.5d;
        r0[3] = r28;
        double r111 = 0.25d / r28;
        double[] r29 = r22[0];
        double r30 = r29[1];
        double[] r31 = r22[1];
        r0[0] = (r30 - r31[0]) * r111;
        double r32 = r29[2];
        double[] r33 = r22[2];
        r0[1] = (r32 + r33[0]) * r111;
        r0[2] = r111 * (r33[1] + r31[2]);
        goto L12
    }

    public Rotation revert() {
        return new Rotation(-this.q0, this.q1, this.q2, this.q3, false);
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

    @Deprecated
    public Vector3D getAxis() {
        return getAxis(RotationConvention.VECTOR_OPERATOR);
    }

    public Vector3D getAxis(RotationConvention r14) {
        double r0 = this.q1;
        double r2 = this.q2;
        double r1 = (r0 * r0) + (r2 * r2);
        double r3 = this.q3;
        double r4 = r1 + (r3 * r3);
        if (r4 != 0.0d) goto L10;
        if (r14 != RotationConvention.VECTOR_OPERATOR) goto L8;
        return Vector3D.PLUS_I;
    L8:
        return Vector3D.MINUS_I;
    L10:
        if (r14 != RotationConvention.VECTOR_OPERATOR) goto L12;
        double r5 = 1.0d;
    L14:
        if (this.q0 >= 0.0d) goto L17;
        double r6 = r5 / FastMath.sqrt(r4);
        return new Vector3D(this.q1 * r6, this.q2 * r6, this.q3 * r6);
    L17:
        double r7 = (-r5) / FastMath.sqrt(r4);
        return new Vector3D(this.q1 * r7, this.q2 * r7, this.q3 * r7);
    L12:
        r5 = -1.0d;
        goto L14
    }

    public double getAngle() {
        double r0 = this.q0;
        if (r0 >= (-0.1d)) goto L5;
    L13:
        double r1 = this.q1;
        double r5 = this.q2;
        double r2 = (r1 * r1) + (r5 * r5);
        double r6 = this.q3;
        double r3 = FastMath.asin(FastMath.sqrt(r2 + (r6 * r6)));
    L11:
        return r3 * 2.0d;
    L5:
        if (r0 > 0.1d) goto L13;
        if (r0 >= 0.0d) goto L12;
        r3 = FastMath.acos(-r0);
        goto L11
    L12:
        r3 = FastMath.acos(r0);
        goto L11
    }

    @Deprecated
    public double[] getAngles(RotationOrder r2) throws CardanEulerSingularityException {
        return getAngles(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public double[] getAngles(RotationOrder r12, RotationConvention r13) throws CardanEulerSingularityException {
        if (r13 != RotationConvention.VECTOR_OPERATOR) goto L123;
        if (r12 != RotationOrder.XYZ) goto L15;
        Vector3D r14 = applyTo(Vector3D.PLUS_K);
        Vector3D r11 = applyInverseTo(Vector3D.PLUS_I);
        if (r11.getZ() < (-0.9999999999d)) goto L13;
        if (r11.getZ() > 0.9999999999d) goto L13;
        return new double[]{FastMath.atan2(-r14.getY(), r14.getZ()), FastMath.asin(r11.getZ()), FastMath.atan2(-r11.getY(), r11.getX())};
    L13:
        throw new CardanEulerSingularityException(true);
    L15:
        if (r12 != RotationOrder.XZY) goto L25;
        Vector3D r15 = applyTo(Vector3D.PLUS_J);
        Vector3D r16 = applyInverseTo(Vector3D.PLUS_I);
        if (r16.getY() < (-0.9999999999d)) goto L23;
        if (r16.getY() > 0.9999999999d) goto L23;
        return new double[]{FastMath.atan2(r15.getZ(), r15.getY()), -FastMath.asin(r16.getY()), FastMath.atan2(r16.getZ(), r16.getX())};
    L23:
        throw new CardanEulerSingularityException(true);
    L25:
        if (r12 != RotationOrder.YXZ) goto L35;
        Vector3D r17 = applyTo(Vector3D.PLUS_K);
        Vector3D r18 = applyInverseTo(Vector3D.PLUS_J);
        if (r18.getZ() < (-0.9999999999d)) goto L33;
        if (r18.getZ() > 0.9999999999d) goto L33;
        return new double[]{FastMath.atan2(r17.getX(), r17.getZ()), -FastMath.asin(r18.getZ()), FastMath.atan2(r18.getX(), r18.getY())};
    L33:
        throw new CardanEulerSingularityException(true);
    L35:
        if (r12 != RotationOrder.YZX) goto L45;
        Vector3D r19 = applyTo(Vector3D.PLUS_I);
        Vector3D r110 = applyInverseTo(Vector3D.PLUS_J);
        if (r110.getX() < (-0.9999999999d)) goto L43;
        if (r110.getX() > 0.9999999999d) goto L43;
        return new double[]{FastMath.atan2(-r19.getZ(), r19.getX()), FastMath.asin(r110.getX()), FastMath.atan2(-r110.getZ(), r110.getY())};
    L43:
        throw new CardanEulerSingularityException(true);
    L45:
        if (r12 != RotationOrder.ZXY) goto L55;
        Vector3D r111 = applyTo(Vector3D.PLUS_J);
        Vector3D r112 = applyInverseTo(Vector3D.PLUS_K);
        if (r112.getY() < (-0.9999999999d)) goto L53;
        if (r112.getY() > 0.9999999999d) goto L53;
        return new double[]{FastMath.atan2(-r111.getX(), r111.getY()), FastMath.asin(r112.getY()), FastMath.atan2(-r112.getX(), r112.getZ())};
    L53:
        throw new CardanEulerSingularityException(true);
    L55:
        if (r12 != RotationOrder.ZYX) goto L65;
        Vector3D r113 = applyTo(Vector3D.PLUS_I);
        Vector3D r114 = applyInverseTo(Vector3D.PLUS_K);
        if (r114.getX() < (-0.9999999999d)) goto L63;
        if (r114.getX() > 0.9999999999d) goto L63;
        return new double[]{FastMath.atan2(r113.getY(), r113.getX()), -FastMath.asin(r114.getX()), FastMath.atan2(r114.getY(), r114.getZ())};
    L63:
        throw new CardanEulerSingularityException(true);
    L65:
        if (r12 != RotationOrder.XYX) goto L75;
        Vector3D r115 = applyTo(Vector3D.PLUS_I);
        Vector3D r116 = applyInverseTo(Vector3D.PLUS_I);
        if (r116.getX() < (-0.9999999999d)) goto L73;
        if (r116.getX() > 0.9999999999d) goto L73;
        return new double[]{FastMath.atan2(r115.getY(), -r115.getZ()), FastMath.acos(r116.getX()), FastMath.atan2(r116.getY(), r116.getZ())};
    L73:
        throw new CardanEulerSingularityException(false);
    L75:
        if (r12 != RotationOrder.XZX) goto L85;
        Vector3D r117 = applyTo(Vector3D.PLUS_I);
        Vector3D r118 = applyInverseTo(Vector3D.PLUS_I);
        if (r118.getX() < (-0.9999999999d)) goto L83;
        if (r118.getX() > 0.9999999999d) goto L83;
        return new double[]{FastMath.atan2(r117.getZ(), r117.getY()), FastMath.acos(r118.getX()), FastMath.atan2(r118.getZ(), -r118.getY())};
    L83:
        throw new CardanEulerSingularityException(false);
    L85:
        if (r12 != RotationOrder.YXY) goto L95;
        Vector3D r119 = applyTo(Vector3D.PLUS_J);
        Vector3D r120 = applyInverseTo(Vector3D.PLUS_J);
        if (r120.getY() < (-0.9999999999d)) goto L93;
        if (r120.getY() > 0.9999999999d) goto L93;
        return new double[]{FastMath.atan2(r119.getX(), r119.getZ()), FastMath.acos(r120.getY()), FastMath.atan2(r120.getX(), -r120.getZ())};
    L93:
        throw new CardanEulerSingularityException(false);
    L95:
        if (r12 != RotationOrder.YZY) goto L105;
        Vector3D r121 = applyTo(Vector3D.PLUS_J);
        Vector3D r122 = applyInverseTo(Vector3D.PLUS_J);
        if (r122.getY() < (-0.9999999999d)) goto L103;
        if (r122.getY() > 0.9999999999d) goto L103;
        return new double[]{FastMath.atan2(r121.getZ(), -r121.getX()), FastMath.acos(r122.getY()), FastMath.atan2(r122.getZ(), r122.getX())};
    L103:
        throw new CardanEulerSingularityException(false);
    L105:
        if (r12 != RotationOrder.ZXZ) goto L114;
        Vector3D r123 = applyTo(Vector3D.PLUS_K);
        Vector3D r124 = applyInverseTo(Vector3D.PLUS_K);
        if (r124.getZ() < (-0.9999999999d)) goto L113;
        if (r124.getZ() > 0.9999999999d) goto L113;
        return new double[]{FastMath.atan2(r123.getX(), -r123.getY()), FastMath.acos(r124.getZ()), FastMath.atan2(r124.getX(), r124.getY())};
    L113:
        throw new CardanEulerSingularityException(false);
    L114:
        Vector3D r125 = applyTo(Vector3D.PLUS_K);
        Vector3D r126 = applyInverseTo(Vector3D.PLUS_K);
        if (r126.getZ() < (-0.9999999999d)) goto L121;
        if (r126.getZ() > 0.9999999999d) goto L121;
        return new double[]{FastMath.atan2(r125.getY(), r125.getX()), FastMath.acos(r126.getZ()), FastMath.atan2(r126.getY(), -r126.getX())};
    L121:
        throw new CardanEulerSingularityException(false);
    L123:
        if (r12 != RotationOrder.XYZ) goto L133;
        Vector3D r127 = applyTo(Vector3D.PLUS_I);
        Vector3D r128 = applyInverseTo(Vector3D.PLUS_K);
        if (r128.getX() < (-0.9999999999d)) goto L131;
        if (r128.getX() > 0.9999999999d) goto L131;
        return new double[]{FastMath.atan2(-r128.getY(), r128.getZ()), FastMath.asin(r128.getX()), FastMath.atan2(-r127.getY(), r127.getX())};
    L131:
        throw new CardanEulerSingularityException(true);
    L133:
        if (r12 != RotationOrder.XZY) goto L143;
        Vector3D r129 = applyTo(Vector3D.PLUS_I);
        Vector3D r130 = applyInverseTo(Vector3D.PLUS_J);
        if (r130.getX() < (-0.9999999999d)) goto L141;
        if (r130.getX() > 0.9999999999d) goto L141;
        return new double[]{FastMath.atan2(r130.getZ(), r130.getY()), -FastMath.asin(r130.getX()), FastMath.atan2(r129.getZ(), r129.getX())};
    L141:
        throw new CardanEulerSingularityException(true);
    L143:
        if (r12 != RotationOrder.YXZ) goto L153;
        Vector3D r131 = applyTo(Vector3D.PLUS_J);
        Vector3D r132 = applyInverseTo(Vector3D.PLUS_K);
        if (r132.getY() < (-0.9999999999d)) goto L151;
        if (r132.getY() > 0.9999999999d) goto L151;
        return new double[]{FastMath.atan2(r132.getX(), r132.getZ()), -FastMath.asin(r132.getY()), FastMath.atan2(r131.getX(), r131.getY())};
    L151:
        throw new CardanEulerSingularityException(true);
    L153:
        if (r12 != RotationOrder.YZX) goto L163;
        Vector3D r133 = applyTo(Vector3D.PLUS_J);
        Vector3D r134 = applyInverseTo(Vector3D.PLUS_I);
        if (r134.getY() < (-0.9999999999d)) goto L161;
        if (r134.getY() > 0.9999999999d) goto L161;
        return new double[]{FastMath.atan2(-r134.getZ(), r134.getX()), FastMath.asin(r134.getY()), FastMath.atan2(-r133.getZ(), r133.getY())};
    L161:
        throw new CardanEulerSingularityException(true);
    L163:
        if (r12 != RotationOrder.ZXY) goto L173;
        Vector3D r135 = applyTo(Vector3D.PLUS_K);
        Vector3D r136 = applyInverseTo(Vector3D.PLUS_J);
        if (r136.getZ() < (-0.9999999999d)) goto L171;
        if (r136.getZ() > 0.9999999999d) goto L171;
        return new double[]{FastMath.atan2(-r136.getX(), r136.getY()), FastMath.asin(r136.getZ()), FastMath.atan2(-r135.getX(), r135.getZ())};
    L171:
        throw new CardanEulerSingularityException(true);
    L173:
        if (r12 != RotationOrder.ZYX) goto L183;
        Vector3D r137 = applyTo(Vector3D.PLUS_K);
        Vector3D r138 = applyInverseTo(Vector3D.PLUS_I);
        if (r138.getZ() < (-0.9999999999d)) goto L181;
        if (r138.getZ() > 0.9999999999d) goto L181;
        return new double[]{FastMath.atan2(r138.getY(), r138.getX()), -FastMath.asin(r138.getZ()), FastMath.atan2(r137.getY(), r137.getZ())};
    L181:
        throw new CardanEulerSingularityException(true);
    L183:
        if (r12 != RotationOrder.XYX) goto L193;
        Vector3D r139 = applyTo(Vector3D.PLUS_I);
        Vector3D r140 = applyInverseTo(Vector3D.PLUS_I);
        if (r140.getX() < (-0.9999999999d)) goto L191;
        if (r140.getX() > 0.9999999999d) goto L191;
        return new double[]{FastMath.atan2(r140.getY(), -r140.getZ()), FastMath.acos(r140.getX()), FastMath.atan2(r139.getY(), r139.getZ())};
    L191:
        throw new CardanEulerSingularityException(false);
    L193:
        if (r12 != RotationOrder.XZX) goto L203;
        Vector3D r141 = applyTo(Vector3D.PLUS_I);
        Vector3D r142 = applyInverseTo(Vector3D.PLUS_I);
        if (r142.getX() < (-0.9999999999d)) goto L201;
        if (r142.getX() > 0.9999999999d) goto L201;
        return new double[]{FastMath.atan2(r142.getZ(), r142.getY()), FastMath.acos(r142.getX()), FastMath.atan2(r141.getZ(), -r141.getY())};
    L201:
        throw new CardanEulerSingularityException(false);
    L203:
        if (r12 != RotationOrder.YXY) goto L213;
        Vector3D r143 = applyTo(Vector3D.PLUS_J);
        Vector3D r144 = applyInverseTo(Vector3D.PLUS_J);
        if (r144.getY() < (-0.9999999999d)) goto L211;
        if (r144.getY() > 0.9999999999d) goto L211;
        return new double[]{FastMath.atan2(r144.getX(), r144.getZ()), FastMath.acos(r144.getY()), FastMath.atan2(r143.getX(), -r143.getZ())};
    L211:
        throw new CardanEulerSingularityException(false);
    L213:
        if (r12 != RotationOrder.YZY) goto L223;
        Vector3D r145 = applyTo(Vector3D.PLUS_J);
        Vector3D r146 = applyInverseTo(Vector3D.PLUS_J);
        if (r146.getY() < (-0.9999999999d)) goto L221;
        if (r146.getY() > 0.9999999999d) goto L221;
        return new double[]{FastMath.atan2(r146.getZ(), -r146.getX()), FastMath.acos(r146.getY()), FastMath.atan2(r145.getZ(), r145.getX())};
    L221:
        throw new CardanEulerSingularityException(false);
    L223:
        if (r12 != RotationOrder.ZXZ) goto L232;
        Vector3D r147 = applyTo(Vector3D.PLUS_K);
        Vector3D r148 = applyInverseTo(Vector3D.PLUS_K);
        if (r148.getZ() < (-0.9999999999d)) goto L231;
        if (r148.getZ() > 0.9999999999d) goto L231;
        return new double[]{FastMath.atan2(r148.getX(), -r148.getY()), FastMath.acos(r148.getZ()), FastMath.atan2(r147.getX(), r147.getY())};
    L231:
        throw new CardanEulerSingularityException(false);
    L232:
        Vector3D r149 = applyTo(Vector3D.PLUS_K);
        Vector3D r150 = applyInverseTo(Vector3D.PLUS_K);
        if (r150.getZ() < (-0.9999999999d)) goto L239;
        if (r150.getZ() > 0.9999999999d) goto L239;
        return new double[]{FastMath.atan2(r150.getY(), r150.getX()), FastMath.acos(r150.getZ()), FastMath.atan2(r149.getY(), -r149.getX())};
    L239:
        throw new CardanEulerSingularityException(false);
    }

    public double[][] getMatrix() {
        double r1 = this.q0;
        double r3 = r1 * r1;
        double r5 = this.q1;
        double r7 = r1 * r5;
        double r9 = this.q2;
        double r11 = r1 * r9;
        double r13 = this.q3;
        double r2 = r1 * r13;
        double r15 = r5 * r5;
        double r17 = r5 * r9;
        double r6 = r5 * r13;
        double r19 = r9 * r9;
        double r10 = r9 * r13;
        return new double[][]{new double[]{((r15 + r3) * 2.0d) - 1.0d, (r17 + r2) * 2.0d, (r6 - r11) * 2.0d}, new double[]{(r17 - r2) * 2.0d, ((r3 + r19) * 2.0d) - 1.0d, (r10 + r7) * 2.0d}, new double[]{(r6 + r11) * 2.0d, (r10 - r7) * 2.0d, ((r3 + (r13 * r13)) * 2.0d) - 1.0d}};
    }

    public Vector3D applyTo(Vector3D r30) {
        double r1 = r30.getX();
        double r3 = r30.getY();
        double r5 = r30.getZ();
        double r7 = ((this.q1 * r1) + (this.q2 * r3)) + (this.q3 * r5);
        double r9 = this.q0;
        double r13 = this.q2;
        double r17 = r13 * r5;
        double r14 = this.q3;
        double r6 = this.q1;
        return new Vector3D((((((r1 * r9) - (r17 - (r14 * r3))) * r9) + (r7 * r6)) * 2.0d) - r1, (((((r3 * r9) - ((r14 * r1) - (r6 * r5))) * r9) + (r7 * r13)) * 2.0d) - r3, (((r9 * ((r5 * r9) - ((r6 * r3) - (r13 * r1)))) + (r7 * r14)) * 2.0d) - r5);
    }

    public void applyTo(double[] r27, double[] r28) {
        double r2 = r27[0];
        double r5 = r27[1];
        double r8 = r27[2];
        double r10 = this.q1;
        double r14 = this.q2;
        double r4 = this.q3;
        double r12 = ((r10 * r2) + (r14 * r5)) + (r4 * r8);
        double r6 = this.q0;
        r28[0] = (((((r2 * r6) - ((r14 * r8) - (r4 * r5))) * r6) + (r12 * r10)) * 2.0d) - r2;
        r28[1] = (((((r5 * r6) - ((r4 * r2) - (r10 * r8))) * r6) + (r12 * r14)) * 2.0d) - r5;
        r28[2] = (((r6 * ((r8 * r6) - ((r10 * r5) - (r14 * r2)))) + (r12 * r4)) * 2.0d) - r8;
    }

    public Vector3D applyInverseTo(Vector3D r30) {
        double r1 = r30.getX();
        double r3 = r30.getY();
        double r5 = r30.getZ();
        double r7 = ((this.q1 * r1) + (this.q2 * r3)) + (this.q3 * r5);
        double r9 = -this.q0;
        double r13 = this.q2;
        double r15 = r13 * r5;
        double r14 = this.q3;
        double r6 = this.q1;
        return new Vector3D((((((r1 * r9) - (r15 - (r14 * r3))) * r9) + (r7 * r6)) * 2.0d) - r1, (((((r3 * r9) - ((r14 * r1) - (r6 * r5))) * r9) + (r7 * r13)) * 2.0d) - r3, (((r9 * ((r5 * r9) - ((r6 * r3) - (r13 * r1)))) + (r7 * r14)) * 2.0d) - r5);
    }

    public void applyInverseTo(double[] r28, double[] r29) {
        double r2 = r28[0];
        double r5 = r28[1];
        double r8 = r28[2];
        double r10 = this.q1;
        double r14 = this.q2;
        double r4 = this.q3;
        double r12 = ((r10 * r2) + (r14 * r5)) + (r4 * r8);
        double r7 = -this.q0;
        r29[0] = (((((r2 * r7) - ((r14 * r8) - (r4 * r5))) * r7) + (r12 * r10)) * 2.0d) - r2;
        r29[1] = (((((r5 * r7) - ((r4 * r2) - (r10 * r8))) * r7) + (r12 * r14)) * 2.0d) - r5;
        r29[2] = (((r7 * ((r8 * r7) - ((r10 * r5) - (r14 * r2)))) + (r12 * r4)) * 2.0d) - r8;
    }

    public Rotation applyTo(Rotation r2) {
        return compose(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public Rotation compose(Rotation r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInternal(r2);
    L6:
        return r2.composeInternal(this);
    }

    private Rotation composeInternal(Rotation r29) {
        double r2 = r29.q0;
        double r4 = this.q0;
        double r6 = r2 * r4;
        double r8 = r29.q1;
        double r11 = this.q1;
        double r3 = r29.q2;
        double r10 = this.q2;
        double r13 = (r8 * r11) + (r3 * r10);
        double r12 = r29.q3;
        double r0 = this.q3;
        double r7 = r6 - (r13 + (r12 * r0));
        double r14 = ((r8 * r4) + (r2 * r11)) + ((r3 * r0) - (r12 * r10));
        double r22 = ((r3 * r4) + (r2 * r10)) + ((r12 * r11) - (r8 * r0));
        double r15 = (r12 * r4) + (r0 * r2);
        return new Rotation(r7, r14, r22, ((r8 * r10) - (r3 * r11)) + r15, false);
    }

    public Rotation applyInverseTo(Rotation r2) {
        return composeInverse(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public Rotation composeInverse(Rotation r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInverseInternal(r2);
    L6:
        return r2.composeInternal(revert());
    }

    private Rotation composeInverseInternal(Rotation r27) {
        double r2 = r27.q0;
        double r6 = this.q0;
        double r4 = (-r2) * r6;
        double r8 = r27.q1;
        double r11 = this.q1;
        double r3 = r27.q2;
        double r10 = this.q2;
        double r13 = (r8 * r11) + (r3 * r10);
        double r12 = r27.q3;
        double r0 = this.q3;
        return new Rotation(r4 - (r13 + (r12 * r0)), (((-r8) * r6) + (r2 * r11)) + ((r3 * r0) - (r12 * r10)), (((-r3) * r6) + (r2 * r10)) + ((r12 * r11) - (r8 * r0)), (((-r12) * r6) + (r0 * r2)) + ((r8 * r10) - (r3 * r11)), false);
    }

    private double[][] orthogonalizeMatrix(double[][] r69, double r70) throws NotARotationMatrixException {
        double[] r1 = r69[0];
        double[] r3 = r69[1];
        double[] r5 = r69[2];
        double r6 = r1[0];
        double r8 = r1[1];
        double r10 = r1[2];
        double r12 = r3[0];
        double r14 = r3[1];
        double r16 = r3[2];
        double r18 = r5[0];
        double r20 = r5[1];
        double r22 = r5[2];
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{3, 3});
        double[] r4 = r2[0];
        int r25 = 1;
        double[] r26 = r2[1];
        double[] r27 = r2[2];
        double r28 = 0.0d;
        int r30 = 0;
    L3:
        int r0 = r30 + 1;
        double[][] r610 = r2;
        if (r0 >= 11) goto L9;
        double r32 = r1[0];
        double r34 = r3[0];
        double r38 = r5[0];
        double r36 = ((r32 * r6) + (r34 * r12)) + (r38 * r18);
        double r40 = r1[r25];
        double r44 = r3[r25];
        double r46 = r5[r25];
        double r42 = ((r40 * r6) + (r44 * r12)) + (r46 * r18);
        double r48 = r1[2];
        double r50 = r3[2];
        double r54 = r5[2];
        double r52 = ((r48 * r6) + (r50 * r12)) + (r54 * r18);
        double r56 = ((r32 * r8) + (r34 * r14)) + (r38 * r20);
        double r58 = ((r40 * r8) + (r44 * r14)) + (r46 * r20);
        double r60 = ((r48 * r8) + (r50 * r14)) + (r54 * r20);
        double r62 = ((r32 * r10) + (r34 * r16)) + (r38 * r22);
        double r35 = ((r40 * r10) + (r44 * r16)) + (r46 * r22);
        double r39 = ((r48 * r10) + (r50 * r16)) + (r54 * r22);
        r4[0] = r6 - (((((r6 * r36) + (r8 * r42)) + (r10 * r52)) - r32) * 0.5d);
        r4[1] = r8 - (((((r6 * r56) + (r8 * r58)) + (r10 * r60)) - r40) * 0.5d);
        r4[2] = r10 - (((((r6 * r62) + (r8 * r35)) + (r10 * r39)) - r48) * 0.5d);
        r26[0] = r12 - (((((r12 * r36) + (r14 * r42)) + (r16 * r52)) - r3[0]) * 0.5d);
        r26[1] = r14 - (((((r12 * r56) + (r14 * r58)) + (r16 * r60)) - r3[1]) * 0.5d);
        r26[2] = r16 - (((((r12 * r62) + (r14 * r35)) + (r16 * r39)) - r3[2]) * 0.5d);
        double r7 = r18 - (((((r36 * r18) + (r42 * r20)) + (r52 * r22)) - r5[0]) * 0.5d);
        r27[0] = r7;
        double r9 = r20 - (((((r56 * r18) + (r58 * r20)) + (r60 * r22)) - r5[1]) * 0.5d);
        r27[1] = r9;
        double r23 = r22 - (((((r18 * r62) + (r20 * r35)) + (r39 * r22)) - r5[2]) * 0.5d);
        r27[2] = r23;
        double r11 = r4[0] - r1[0];
        double r15 = r4[1] - r1[1];
        double r17 = r4[2] - r1[2];
        double r19 = r26[0] - r3[0];
        double r21 = r26[1] - r3[1];
        double r33 = r26[2] - r3[2];
        double r13 = r7 - r5[0];
        double r24 = r9 - r5[1];
        double r29 = r23 - r5[2];
        double r31 = ((((((((r11 * r11) + (r15 * r15)) + (r17 * r17)) + (r19 * r19)) + (r21 * r21)) + (r33 * r33)) + (r13 * r13)) + (r24 * r24)) + (r29 * r29);
        if (FastMath.abs(r31 - r28) <= r70) goto L7;
        double r37 = r4[0];
        double r110 = r4[1];
        double r111 = r4[2];
        double r112 = r26[0];
        double r113 = r26[1];
        double r210 = r26[2];
        double r211 = r27[0];
        double r212 = r27[1];
        r2 = r610;
        r30 = r0;
        r25 = 1;
        r22 = r27[2];
        r28 = r31;
        r6 = r37;
        r8 = r110;
        r10 = r111;
        r12 = r112;
        r14 = r113;
        r16 = r210;
        r18 = r211;
        r20 = r212;
        goto L3
    L7:
        return r610;
    L9:
        int r114 = r25;
        LocalizedFormats r41 = LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX;
        Object[] r43 = new Object[r114];
        r43[0] = Integer.valueOf(r0 - r114);
        throw new NotARotationMatrixException(r41, r43);
    }

    public static double distance(Rotation r0, Rotation r1) {
        return r0.composeInverseInternal(r1).getAngle();
    }
}
