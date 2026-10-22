package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SphericalCoordinates implements Serializable {
    private static final long serialVersionUID = 20130206;
    private double[][] jacobian;
    private final double phi;
    private double[][] phiHessian;
    private final double r;
    private double[][] rHessian;
    private final double theta;
    private double[][] thetaHessian;
    private final Vector3D v;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20130206;
        private final double x;
        private final double y;
        private final double z;

        DataTransferObject(double r1, double r3, double r5) {
            this.x = r1;
            this.y = r3;
            this.z = r5;
        }

        private Object readResolve() {
            return new SphericalCoordinates(new Vector3D(this.x, this.y, this.z));
        }
    }

    public SphericalCoordinates(Vector3D r5) {
        this.v = r5;
        double r0 = r5.getNorm();
        this.r = r0;
        this.theta = r5.getAlpha();
        this.phi = FastMath.acos(r5.getZ() / r0);
    }

    public SphericalCoordinates(double r19, double r21, double r23) {
        double r3 = FastMath.cos(r21);
        double r5 = FastMath.sin(r21);
        double r7 = FastMath.cos(r23);
        double r9 = FastMath.sin(r23);
        this.r = r19;
        this.theta = r21;
        this.phi = r23;
        this.v = new Vector3D((r3 * r19) * r9, (r19 * r5) * r9, r19 * r7);
    }

    public Vector3D getCartesian() {
        return this.v;
    }

    public double getR() {
        return this.r;
    }

    public double getTheta() {
        return this.theta;
    }

    public double getPhi() {
        return this.phi;
    }

    public double[] toCartesianGradient(double[] r18) {
        computeJacobian();
        double r2 = r18[0];
        double[][] r4 = this.jacobian;
        double[] r5 = r4[0];
        double r3 = r2 * r5[0];
        double r7 = r18[1];
        double[] r9 = r4[1];
        double r6 = r3 + (r9[0] * r7);
        double r11 = r18[2];
        double[] r8 = r4[2];
        double r1 = r18[0];
        return new double[]{r6 + (r8[0] * r11), ((r5[1] * r1) + (r7 * r9[1])) + (r8[1] * r11), (r1 * r5[2]) + (r11 * r8[2])};
    }

    public double[][] toCartesianHessian(double[][] r31, double[] r32) {
        computeJacobian();
        computeHessians();
        Class r3 = Double.TYPE;
        double[][] r2 = (double[][]) Array.newInstance(r3, new int[]{3, 3});
        Class r4 = Double.TYPE;
        double[][] r5 = (double[][]) Array.newInstance(r4, new int[]{3, 3});
        double[] r6 = r2[0];
        double[] r7 = r31[0];
        double r8 = r7[0];
        double[][] r9 = this.jacobian;
        double[] r10 = r9[0];
        double r11 = r8 * r10[0];
        double[] r12 = r31[1];
        double r13 = r12[0];
        double[] r15 = r9[1];
        double r14 = r11 + (r13 * r15[0]);
        double[] r16 = r31[2];
        double r17 = r16[0];
        double[] r18 = r9[2];
        r6[0] = r14 + (r17 * r18[0]);
        double r19 = r7[0];
        double r110 = r10[1] * r19;
        double r111 = r12[0];
        double r112 = r110 + (r15[1] * r111);
        double r20 = r16[0];
        r6[1] = r112 + (r18[1] * r20);
        r6[2] = (r19 * r10[2]) + (r20 * r18[2]);
        double[] r21 = r2[1];
        double r113 = r111 * r10[0];
        double r22 = r12[1];
        double r114 = r113 + (r15[0] * r22);
        double r115 = r16[1];
        r21[0] = r114 + (r18[0] * r115);
        r21[1] = ((r12[0] * r10[1]) + (r22 * r15[1])) + (r115 * r18[1]);
        double[] r23 = r2[2];
        double r24 = r16[0] * r10[0];
        double r116 = r16[1];
        double r25 = r24 + (r15[0] * r116);
        double r117 = r16[2];
        double r26 = r25 + (r18[0] * r117);
        r23[0] = r26;
        double r118 = r16[0];
        double r27 = ((r10[1] * r118) + (r116 * r15[1])) + (r18[1] * r117);
        r23[1] = r27;
        double r119 = (r118 * r10[2]) + (r117 * r18[2]);
        r23[2] = r119;
        double[] r120 = r5[0];
        r120[0] = ((r10[0] * r6[0]) + (r15[0] * r21[0])) + (r18[0] * r26);
        double[] r28 = r5[1];
        double r121 = r10[1];
        double r122 = r6[0] * r121;
        double r29 = r15[1];
        double r123 = r122 + (r21[0] * r29);
        double r210 = r18[1];
        r28[0] = r123 + (r23[0] * r210);
        double[] r30 = r5[2];
        double r124 = r10[2];
        double r211 = r6[0] * r124;
        double r33 = r18[2];
        r30[0] = r211 + (r23[0] * r33);
        r28[1] = ((r121 * r6[1]) + (r29 * r21[1])) + (r210 * r27);
        r30[1] = (r6[1] * r124) + (r23[1] * r33);
        double r125 = (r124 * r6[2]) + (r33 * r119);
        r30[2] = r125;
        double r34 = r120[0];
        double r35 = r32[0];
        double[][] r36 = this.rHessian;
        double r37 = r35 * r36[0][0];
        double r126 = r32[1];
        double[][] r127 = this.thetaHessian;
        double r38 = r37 + (r127[0][0] * r126);
        double r128 = r32[2];
        double[][] r0 = this.phiHessian;
        r120[0] = r34 + (r38 + (r0[0][0] * r128));
        double r39 = r28[0];
        double r40 = r32[0];
        double[] r212 = r36[1];
        double r41 = r40 * r212[0];
        double[] r129 = r127[1];
        double r42 = r41 + (r129[0] * r126);
        double[] r213 = r0[1];
        r28[0] = r39 + (r42 + (r213[0] * r128));
        double r43 = r30[0];
        double r44 = r32[0];
        double[] r45 = r36[2];
        double r46 = r44 * r45[0];
        double[] r1 = r0[2];
        double r47 = r43 + (r46 + (r1[0] * r128));
        r30[0] = r47;
        double r48 = r28[1];
        double r214 = r32[0];
        r28[1] = r48 + (((r212[1] * r214) + (r126 * r129[1])) + (r213[1] * r128));
        r30[1] = r30[1] + ((r45[1] * r214) + (r1[1] * r128));
        r30[2] = r125 + ((r214 * r45[2]) + (r128 * r1[2]));
        r120[1] = r28[0];
        r120[2] = r47;
        r28[2] = r30[1];
        return r5;
    }

    private void computeJacobian() {
        if (this.jacobian != null) goto L6;
        double r1 = this.v.getX();
        double r3 = this.v.getY();
        double r5 = this.v.getZ();
        double r7 = (r1 * r1) + (r3 * r3);
        double r9 = FastMath.sqrt(r7);
        double r11 = (r5 * r5) + r7;
        Class r15 = Double.TYPE;
        double[][] r14 = (double[][]) Array.newInstance(r15, new int[]{3, 3});
        this.jacobian = r14;
        double[] r16 = r14[0];
        double r13 = this.r;
        r16[0] = r1 / r13;
        r16[1] = r3 / r13;
        r16[2] = r5 / r13;
        double[] r17 = r14[1];
        r17[0] = (-r3) / r7;
        r17[1] = r1 / r7;
        double[] r2 = r14[2];
        double r18 = r9 * r11;
        r2[0] = (r1 * r5) / r18;
        r2[1] = (r3 * r5) / r18;
        r2[2] = (-r9) / r11;
        return;
    }

    private void computeHessians() {
        if (this.rHessian != null) goto L6;
        double r1 = this.v.getX();
        double r3 = this.v.getY();
        double r5 = this.v.getZ();
        double r7 = r1 * r1;
        double r9 = r3 * r3;
        double r11 = r5 * r5;
        double r13 = r7 + r9;
        double r15 = FastMath.sqrt(r13);
        double r17 = r13 + r11;
        double r10 = this.r;
        double r21 = r1 / r10;
        double r23 = r3 / r10;
        double r25 = r1 / r13;
        double r27 = r3 / r13;
        double r22 = r21 / r17;
        double r24 = r23 / r17;
        double r12 = (r5 / r10) / r17;
        Class r8 = Double.TYPE;
        double[][] r14 = (double[][]) Array.newInstance(r8, new int[]{3, 3});
        this.rHessian = r14;
        double[] r31 = r14[0];
        double r32 = r3 * r24;
        double r34 = r5 * r12;
        r31[0] = r32 + r34;
        double[] r37 = r14[1];
        double r16 = -r1;
        r37[0] = r24 * r16;
        double[] r18 = r14[2];
        double r19 = (-r5) * r22;
        r18[0] = r19;
        double r26 = r22 * r1;
        r37[1] = r26 + r34;
        r18[1] = (-r3) * r12;
        r18[2] = r26 + r32;
        r31[1] = r37[0];
        r31[2] = r19;
        r37[2] = r18[1];
        Class r20 = Double.TYPE;
        double[][] r28 = (double[][]) Array.newInstance(r20, new int[]{2, 2});
        this.thetaHessian = r28;
        double[] r29 = r28[0];
        r29[0] = (r25 * 2.0d) * r27;
        double[] r30 = r28[1];
        double r210 = (r27 * r27) - (r25 * r25);
        r30[0] = r210;
        r30[1] = (r25 * (-2.0d)) * r27;
        r29[1] = r210;
        double r33 = r15 * r17;
        double r110 = r15 * r33;
        double r35 = r33 * r17;
        double r111 = r35 * r13;
        double r211 = (3.0d * r13) + r11;
        Class r36 = Double.TYPE;
        double[][] r38 = (double[][]) Array.newInstance(r36, new int[]{3, 3});
        this.phiHessian = r38;
        double[] r212 = r38[0];
        r212[0] = ((r110 - (r7 * r211)) * r5) / r111;
        double[] r213 = r38[1];
        r213[0] = (((r16 * r3) * r5) * r211) / r111;
        double[] r39 = r38[2];
        double r112 = r13 - r11;
        double r2 = (r1 * r112) / r35;
        r39[0] = r2;
        r213[1] = (r5 * (r110 - (r9 * r211))) / r111;
        r39[1] = (r3 * r112) / r35;
        r39[2] = ((r15 * 2.0d) * r12) / this.r;
        r212[1] = r213[0];
        r212[2] = r2;
        r213[2] = r39[1];
        return;
    }

    private Object writeReplace() {
        return new DataTransferObject(this.v.getX(), this.v.getY(), this.v.getZ());
    }
}
