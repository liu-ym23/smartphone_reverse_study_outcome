package org.apache.commons.math3.stat.regression;

import java.util.Arrays;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class MillerUpdatingRegression implements UpdatingMultipleLinearRegression {
    private final double[] d;
    private final double epsilon;
    private boolean hasIntercept;
    private final boolean[] lindep;
    private long nobs;
    private final int nvars;
    private final double[] r;
    private final double[] rhs;
    private final double[] rss;
    private boolean rss_set;
    private double sserr;
    private double sumsqy;
    private double sumy;
    private final double[] tol;
    private boolean tol_set;
    private final int[] vorder;
    private final double[] work_sing;
    private final double[] work_tolset;
    private final double[] x_sing;

    private MillerUpdatingRegression() {
        this(-1, false, Double.NaN);
    }

    public MillerUpdatingRegression(int r7, boolean r8, double r9) throws ModelSpecificationException {
        this.nobs = 0;
        this.sserr = 0.0d;
        int r4 = 0;
        this.rss_set = false;
        this.tol_set = false;
        this.sumy = 0.0d;
        this.sumsqy = 0.0d;
        if (r7 < 1) goto L17;
        if (r8 == false) goto L6;
        this.nvars = r7 + 1;
    L7:
        this.hasIntercept = r8;
        this.nobs = 0;
        int r10 = this.nvars;
        this.d = new double[r10];
        this.rhs = new double[r10];
        this.r = new double[((r10 - 1) * r10) / 2];
        this.tol = new double[r10];
        this.rss = new double[r10];
        this.vorder = new int[r10];
        this.x_sing = new double[r10];
        this.work_sing = new double[r10];
        this.work_tolset = new double[r10];
        this.lindep = new boolean[r10];
    L9:
        if (r4 >= this.nvars) goto L12;
        this.vorder[r4] = r4;
        r4 = r4 + 1;
        goto L9
    L12:
        if (r9 <= 0.0d) goto L14;
        this.epsilon = r9;
        return;
    L14:
        this.epsilon = -r9;
        return;
    L6:
        this.nvars = r7;
        goto L7
    L17:
        throw new ModelSpecificationException(LocalizedFormats.NO_REGRESSORS, new Object[0]);
    }

    public MillerUpdatingRegression(int r3, boolean r4) throws ModelSpecificationException {
        this(r3, r4, Precision.EPSILON);
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public boolean hasIntercept() {
        return this.hasIntercept;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public long getN() {
        return this.nobs;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void addObservation(double[] r10, double r11) throws ModelSpecificationException {
        boolean r0 = this.hasIntercept;
        if (r0 == false) goto L5;
    L6:
        if (r0 == true) goto L8;
    L12:
        if (r0 == true) goto L14;
        include(MathArrays.copyOf(r10, r10.length), 1.0d, r11);
    L15:
        this.nobs++;
        return;
    L14:
        double[] r4 = new double[r10.length + 1];
        System.arraycopy(r10, 0, r4, 1, r10.length);
        r4[0] = 1.0d;
        include(r4, 1.0d, r11);
        goto L15
    L8:
        if ((r10.length + 1) == this.nvars) goto L12;
    L11:
        throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, new Object[]{Integer.valueOf(r10.length), Integer.valueOf(this.nvars)});
    L5:
        if (r10.length != this.nvars) goto L11;
        goto L6
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void addObservations(double[][] r6, double[] r7) throws ModelSpecificationException {
        int r2 = 0;
        if (r6 == null) goto L20;
        if (r7 == null) goto L20;
        if (r6.length != r7.length) goto L20;
        if (r6.length == 0) goto L19;
        if ((r6[0].length + 1) > r6.length) goto L17;
    L13:
        if (r2 >= r6.length) goto L15;
        addObservation(r6[r2], r7[r2]);
        r2 = r2 + 1;
        goto L13
    L15:
        return;
    L17:
        throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[]{Integer.valueOf(r6.length), Integer.valueOf(r6[0].length)});
    L19:
        throw new ModelSpecificationException(LocalizedFormats.NO_DATA, new Object[0]);
    L20:
        LocalizedFormats r3 = LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE;
        Object[] r0 = new Object[2];
        if (r6 != null) goto L23;
        int r8 = 0;
    L24:
        r0[0] = Integer.valueOf(r8);
        if (r7 == null) goto L28;
        r2 = r7.length;
    L28:
        r0[1] = Integer.valueOf(r2);
        throw new ModelSpecificationException(r3, r0);
    L23:
        r8 = r6.length;
        goto L24
    }

    private void include(double[] r24, double r25, double r27) {
        this.rss_set = false;
        this.sumy = smartAdd(r27, this.sumy);
        this.sumsqy = smartAdd(this.sumsqy, r27 * r27);
        int r6 = 0;
        int r7 = 0;
        double r4 = r27;
        double r2 = r25;
    L4:
        if (r6 >= r24.length) goto L32;
        double r8 = 0.0d;
        if (r2 == 0.0d) goto L7;
        double r10 = r24[r6];
        if (r10 != 0.0d) goto L11;
        r7 = r7 + ((this.nvars - r6) - 1);
    L31:
        r6 = r6 + 1;
        goto L4
    L11:
        double r12 = this.d[r6];
        double r14 = r2 * r10;
        if (r12 == 0.0d) goto L17;
        double r9 = r14 * r10;
        double r17 = smartAdd(r12, r9);
        if (FastMath.abs(r9 / r12) <= Precision.EPSILON) goto L16;
        r2 = (r2 * r12) / r17;
    L16:
        r8 = r2;
    L18:
        this.d[r6] = r17;
        int r3 = r6 + 1;
    L20:
        if (r3 >= this.nvars) goto L26;
        double r26 = r8;
        double r11 = r24[r3];
        double r19 = r4;
        r24[r3] = smartAdd(r11, (-r10) * this.r[r7]);
        if (r12 == 0.0d) goto L24;
        double[] r5 = this.r;
        r5[r7] = smartAdd(r5[r7] * r12, r11 * r14) / r17;
    L25:
        r7 = r7 + 1;
        r3 = r3 + 1;
        r8 = r26;
        r4 = r19;
        goto L20
    L24:
        this.r[r7] = r11 / r10;
        goto L25
    L26:
        double r110 = r4;
        double r28 = r8;
        double r13 = smartAdd(r110, (-r10) * this.rhs[r6]);
        if (r12 == 0.0d) goto L29;
        double[] r15 = this.rhs;
        r15[r6] = smartAdd(r12 * r15[r6], r14 * r110) / r17;
    L30:
        r4 = r13;
        r2 = r28;
        goto L31
    L29:
        this.rhs[r6] = r110 / r10;
        goto L30
    L17:
        r17 = r14 * r10;
        goto L18
    L7:
        return;
    L32:
        this.sserr = smartAdd(this.sserr, (r2 * r4) * r4);
    }

    private double smartAdd(double r7, double r9) {
        double r0 = FastMath.abs(r7);
        double r2 = FastMath.abs(r9);
        if (r0 <= r2) goto L9;
        if (r2 > (r0 * Precision.EPSILON)) goto L7;
        return r7;
    L7:
        return r7 + r9;
    L9:
        if (r0 > (r2 * Precision.EPSILON)) goto L11;
        return r9;
    L11:
        return r7 + r9;
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public void clear() {
        Arrays.fill(this.d, 0.0d);
        Arrays.fill(this.rhs, 0.0d);
        Arrays.fill(this.r, 0.0d);
        Arrays.fill(this.tol, 0.0d);
        Arrays.fill(this.rss, 0.0d);
        Arrays.fill(this.work_tolset, 0.0d);
        Arrays.fill(this.work_sing, 0.0d);
        Arrays.fill(this.x_sing, 0.0d);
        Arrays.fill(this.lindep, false);
        int r0 = 0;
    L4:
        if (r0 >= this.nvars) goto L6;
        this.vorder[r0] = r0;
        r0 = r0 + 1;
        goto L4
    L6:
        this.nobs = 0;
        this.sserr = 0.0d;
        this.sumy = 0.0d;
        this.sumsqy = 0.0d;
        this.rss_set = false;
        this.tol_set = false;
    }

    private void tolset() {
        double r0 = this.epsilon;
        int r3 = 0;
    L4:
        if (r3 >= this.nvars) goto L6;
        this.work_tolset[r3] = FastMath.sqrt(this.d[r3]);
        r3 = r3 + 1;
        goto L4
    L6:
        this.tol[0] = this.work_tolset[0] * r0;
        int r4 = 1;
    L8:
        if (r4 >= this.nvars) goto L13;
        int r5 = r4 - 1;
        double r6 = this.work_tolset[r4];
        int r8 = 0;
    L10:
        if (r8 >= r4) goto L12;
        r6 = r6 + (FastMath.abs(this.r[r5]) * this.work_tolset[r8]);
        r5 = r5 + ((this.nvars - r8) - 2);
        r8 = r8 + 1;
        goto L10
    L12:
        this.tol[r4] = r6 * r0;
        r4 = r4 + 1;
        goto L8
    L13:
        this.tol_set = true;
    }

    private double[] regcf(int r15) throws ModelSpecificationException {
        int r0 = 0;
        if (r15 < 1) goto L29;
        if (r15 > this.nvars) goto L27;
        if (this.tol_set == true) goto L9;
        tolset();
    L9:
        double[] r2 = new double[r15];
        int r4 = r15 - 1;
        boolean r5 = false;
    L11:
        if (r4 <= (-1)) goto L19;
        if (FastMath.sqrt(this.d[r4]) >= this.tol[r4]) goto L15;
        r2[r4] = 0.0d;
        this.d[r4] = 0.0d;
        r5 = true;
    L18:
        r4 = r4 - 1;
        goto L11
    L15:
        r2[r4] = this.rhs[r4];
        int r6 = this.nvars;
        int r7 = ((((r6 + r6) - r4) - 1) * r4) / 2;
        int r8 = r4 + 1;
    L16:
        if (r8 >= r15) goto L18;
        r2[r4] = smartAdd(r2[r4], (-this.r[r7]) * r2[r8]);
        r7 = r7 + 1;
        r8 = r8 + 1;
        goto L16
    L19:
        if (r5 == false) goto L25;
    L20:
        if (r0 >= r15) goto L25;
        if (this.lindep[r0] == false) goto L24;
        r2[r0] = Double.NaN;
    L24:
        r0 = r0 + 1;
    L25:
        return r2;
    L27:
        throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, new Object[]{Integer.valueOf(r15), Integer.valueOf(this.nvars)});
    L29:
        throw new ModelSpecificationException(LocalizedFormats.NO_REGRESSORS, new Object[0]);
    }

    private void singcheck() {
        int r1 = 0;
    L4:
        if (r1 >= this.nvars) goto L6;
        this.work_sing[r1] = FastMath.sqrt(this.d[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        int r2 = 0;
    L8:
        if (r2 >= this.nvars) goto L27;
        double r3 = this.tol[r2];
        int r4 = r2 - 1;
        int r5 = 0;
        int r6 = r4;
    L11:
        if (r5 >= r4) goto L16;
        if ((FastMath.abs(this.r[r6]) * this.work_sing[r5]) >= r3) goto L15;
        this.r[r6] = 0.0d;
    L15:
        r6 = r6 + ((this.nvars - r5) - 2);
        r5 = r5 + 1;
        goto L11
    L16:
        boolean[] r7 = this.lindep;
        r7[r2] = false;
        if (this.work_sing[r2] >= r3) goto L26;
        r7[r2] = true;
        if (r2 >= (this.nvars - 1)) goto L25;
        Arrays.fill(this.x_sing, 0.0d);
        int r8 = this.nvars;
        int r9 = ((((r8 + r8) - r2) - 1) * r2) / 2;
        int r10 = r2 + 1;
    L22:
        if (r10 >= this.nvars) goto L24;
        double[] r11 = this.x_sing;
        double[] r12 = this.r;
        r11[r10] = r12[r9];
        r12[r9] = 0.0d;
        r10 = r10 + 1;
        r9 = r9 + 1;
        goto L22
    L24:
        double[] r13 = this.rhs;
        double r14 = r13[r2];
        double[] r15 = this.d;
        double r16 = r15[r2];
        r15[r2] = 0.0d;
        r13[r2] = 0.0d;
        include(this.x_sing, r16, r14);
        goto L26
    L25:
        double r17 = this.sserr;
        double r18 = this.d[r2];
        double r19 = this.rhs[r2];
        this.sserr = r17 + ((r18 * r19) * r19);
    L26:
        r2 = r2 + 1;
        goto L8
    }

    private void ss() {
        double r0 = this.sserr;
        double[] r2 = this.rss;
        int r3 = this.nvars;
        r2[r3 - 1] = r0;
        int r4 = r3 - 1;
    L3:
        if (r4 <= 0) goto L5;
        double r5 = this.d[r4];
        double r6 = this.rhs[r4];
        r0 = r0 + ((r5 * r6) * r6);
        this.rss[r4 - 1] = r0;
        r4 = r4 - 1;
        goto L3
    L5:
        this.rss_set = true;
    }

    private double[] cov(int r22) {
        if (this.nobs > r22) goto L6;
        return null;
    L6:
        int r2 = 0;
        double r3 = 0.0d;
        int r5 = 0;
    L7:
        double r6 = 1.0d;
        if (r5 >= r22) goto L13;
        if (this.lindep[r5] == true) goto L12;
        r3 = r3 + 1.0d;
    L12:
        r5 = r5 + 1;
        goto L7
    L13:
        int r8 = r22 - 1;
        double r9 = this.rss[r8] / (this.nobs - r3);
        double[] r4 = new double[(r22 * r8) / 2];
        inverse(r4, r22);
        double[] r7 = new double[((r22 + 1) * r22) / 2];
        Arrays.fill(r7, Double.NaN);
        int r10 = 0;
    L14:
        if (r2 >= r22) goto L35;
        if (this.lindep[r2] == true) goto L34;
        int r11 = r2;
        int r12 = r10;
    L18:
        if (r11 >= r22) goto L34;
        if (this.lindep[r11] == true) goto L32;
        int r13 = (r10 + r11) - r2;
        if (r2 != r11) goto L24;
        double r14 = r6 / this.d[r11];
    L25:
        int r15 = r11 + 1;
        int r16 = r15;
    L26:
        if (r16 >= r22) goto L31;
        if (this.lindep[r16] == true) goto L30;
        r14 = r14 + ((r4[r13] * r4[r12]) / this.d[r16]);
    L30:
        r13 = r13 + 1;
        r12 = r12 + 1;
        r16 = r16 + 1;
        goto L26
    L31:
        r7[((r15 * r11) / 2) + r2] = r14 * r9;
    L33:
        r11 = r11 + 1;
        r6 = 1.0d;
        goto L18
    L24:
        r14 = r4[r13 - 1] / this.d[r11];
        goto L25
    L32:
        r12 = r12 + ((r22 - r11) - 1);
    L34:
        r10 = r10 + ((r22 - r2) - 1);
        r2 = r2 + 1;
        r6 = 1.0d;
        goto L14
    L35:
        return r7;
    }

    private void inverse(double[] r14, int r15) {
        int r0 = r15 - 1;
        int r1 = ((r15 * r0) / 2) - 1;
        Arrays.fill(r14, Double.NaN);
    L3:
        if (r0 <= 0) goto L18;
        if (this.lindep[r0] == true) goto L16;
        int r3 = this.nvars;
        int r2 = ((r0 - 1) * ((r3 + r3) - r0)) / 2;
        int r4 = r15;
    L7:
        if (r4 <= r0) goto L17;
        double r5 = 0.0d;
        int r6 = r0;
        int r8 = r1;
        int r7 = r2;
    L10:
        if (r6 >= (r4 - 1)) goto L15;
        r8 = r8 + ((r15 - r6) - 1);
        if (this.lindep[r6] == true) goto L14;
        r5 = r5 + ((-this.r[r7]) * r14[r8]);
    L14:
        r7 = r7 + 1;
        r6 = r6 + 1;
        goto L10
    L15:
        r14[r1] = r5 - this.r[r7];
        r1 = r1 - 1;
        r4 = r4 - 1;
    L17:
        r0 = r0 - 1;
        goto L3
    L16:
        r1 = r1 - (r15 - r0);
        goto L17
    }

    public double[] getPartialCorrelations(int r28) {
        int r2 = this.nvars;
        double[] r3 = new double[(((r2 - r28) + 1) * (r2 - r28)) / 2];
        int r4 = -r28;
        int r5 = r28 + 1;
        int r6 = -r5;
        double[] r7 = new double[r2 - r28];
        double[] r8 = new double[(r2 - r28) - 1];
        int r9 = ((r2 - r28) * ((r2 - r28) - 1)) / 2;
        if (r28 < (-1)) goto L42;
        if (r28 >= r2) goto L54;
        int r10 = (r2 - 1) - r28;
        int r11 = this.r.length - ((r10 * (r10 + 1)) / 2);
        double r12 = this.d[r28];
        double r13 = 0.0d;
        if (r12 <= 0.0d) goto L10;
        r7[r28 + r4] = 1.0d / FastMath.sqrt(r12);
    L10:
        if (r5 >= this.nvars) goto L19;
        int r14 = ((r11 + r5) - 1) - r28;
        double r15 = this.d[r5];
        int r16 = r28;
    L12:
        if (r16 >= r5) goto L14;
        double r17 = this.d[r16];
        double r20 = this.r[r14];
        r15 = r15 + ((r17 * r20) * r20);
        r14 = r14 + ((this.nvars - r16) - 2);
        r16 = r16 + 1;
        r9 = r9;
        r13 = 0.0d;
        goto L12
    L14:
        int r18 = r9;
        if (r15 <= r13) goto L17;
        r7[r5 + r4] = 1.0d / FastMath.sqrt(r15);
    L18:
        r5 = r5 + 1;
        r9 = r18;
        r13 = 0.0d;
        goto L10
    L17:
        r7[r5 + r4] = r13;
        goto L18
    L19:
        int r19 = r9;
        double r110 = this.sserr;
        int r21 = r28;
    L21:
        if (r21 >= this.nvars) goto L23;
        double r111 = this.d[r21];
        double r22 = this.rhs[r21];
        r110 = r110 + ((r111 * r22) * r22);
        r21 = r21 + 1;
        goto L21
    L23:
        double r112 = 0.0d;
        if (r110 <= 0.0d) goto L26;
        r110 = 1.0d / FastMath.sqrt(r110);
    L26:
        int r23 = r28;
    L28:
        if (r23 >= this.nvars) goto L41;
        Arrays.fill(r8, r112);
        int r24 = ((r11 + r23) - r28) - 1;
        int r25 = r28;
        double r113 = r112;
    L30:
        if (r25 >= r23) goto L36;
        int r114 = r24 + 1;
        int r115 = r23 + 1;
    L32:
        int r116 = this.nvars;
        if (r115 >= r116) goto L35;
        int r117 = r115 + r6;
        double r26 = r8[r117];
        int r27 = r11;
        double r29 = this.d[r25];
        double[] r118 = this.r;
        r8[r117] = r26 + ((r29 * r118[r24]) * r118[r114]);
        r114 = r114 + 1;
        r115 = r115 + 1;
        r11 = r27;
        goto L32
    L35:
        r113 = r113 + ((this.d[r25] * this.r[r24]) * this.rhs[r25]);
        r24 = r24 + ((r116 - r25) - 2);
        r25 = r25 + 1;
        r11 = r11;
        goto L30
    L36:
        int r210 = r11;
        int r30 = r24 + 1;
        int r31 = r23 + 1;
        int r119 = r31;
    L38:
        if (r119 >= this.nvars) goto L40;
        int r120 = r119 + r6;
        double r121 = r8[r120] + (this.d[r23] * this.r[r30]);
        r8[r120] = r121;
        r30 = r30 + 1;
        r3[(((((r119 - 1) - r28) * (r119 - r28)) / 2) + r23) - r28] = (r121 * r7[r23 + r4]) * r7[r119 + r4];
        r119 = r119 + 1;
        r6 = r6;
        goto L38
    L40:
        double r122 = r113 + (this.d[r23] * this.rhs[r23]);
        int r32 = r23 + r4;
        r3[r32 + r19] = (r122 * r7[r32]) * r110;
        r23 = r31;
        r6 = r6;
        r11 = r210;
        r112 = 0.0d;
        goto L28
    L41:
        return r3;
    L54:
        return null;
    L42:
        return null;
    }

    private void vmove(int r26, int r27) {
        int r1 = r26;
        if (r1 != r27) goto L6;
        return;
    L6:
        if (this.rss_set == true) goto L8;
        ss();
    L8:
        int r3 = 1;
        if (r1 >= r27) goto L11;
        int r4 = r27 - r1;
        int r2 = 1;
    L12:
        int r6 = 0;
        boolean r7 = false;
    L13:
        if (r6 >= r4) goto L56;
        int r8 = this.nvars;
        int r9 = ((((r8 + r8) - r1) - r3) * r1) / 2;
        int r10 = ((r8 + r9) - r1) - r3;
        int r11 = r1 + 1;
        double[] r12 = this.d;
        double r13 = r12[r1];
        double r14 = r12[r11];
        int r15 = r6;
        double r5 = this.epsilon;
        if (r13 <= r5) goto L17;
    L20:
        double r16 = this.r[r9];
        if ((FastMath.abs(r16) * FastMath.sqrt(r13)) >= this.tol[r11]) goto L24;
        r16 = 0.0d;
    L24:
        if (r13 < this.epsilon) goto L36;
        double r17 = FastMath.abs(r16);
        boolean r28 = r7;
        int r20 = r10;
        double r18 = this.epsilon;
        if (r17 >= r18) goto L29;
    L37:
        double[] r19 = this.d;
        r19[r1] = r14;
        r19[r11] = r13;
        this.r[r9] = 0.0d;
        int r21 = r1 + 2;
        int r22 = r20;
    L39:
        if (r21 >= this.nvars) goto L41;
        r9 = r9 + 1;
        double[] r23 = this.r;
        double r24 = r23[r9];
        r23[r9] = r23[r22];
        r23[r22] = r24;
        r22 = r22 + 1;
        r21 = r21 + 1;
        goto L39
    L41:
        double[] r25 = this.rhs;
        r16 = r25[r1];
        r25[r1] = r25[r11];
        r25[r11] = r16;
    L42:
        boolean r29 = true;
    L43:
        if (r29 == true) goto L49;
        double r30 = r13 * r16;
        double r110 = r14 + (r30 * r16);
        double r111 = r14 / r110;
        double r31 = r30 / r110;
        double[] r32 = this.d;
        r32[r1] = r110;
        r32[r11] = r13 * r111;
        this.r[r9] = r31;
        int r33 = r1 + 2;
    L46:
        if (r33 >= this.nvars) goto L48;
        r9 = r9 + 1;
        double[] r112 = this.r;
        double r113 = r112[r9];
        r112[r9] = (r112[r22] * r111) + (r31 * r113);
        r112[r22] = r113 - (r112[r22] * r16);
        r22 = r22 + 1;
        r33 = r33 + 1;
        goto L46
    L48:
        int r114 = 1;
        double[] r34 = this.rhs;
        double r35 = r34[r1];
        r34[r1] = (r111 * r34[r11]) + (r31 * r35);
        r34[r11] = r35 - (r16 * r34[r11]);
    L50:
        r7 = r29;
    L51:
        if (r1 <= 0) goto L55;
        int r36 = r1;
        int r37 = 0;
    L53:
        if (r37 >= r1) goto L55;
        double[] r38 = this.r;
        double r39 = r38[r36];
        int r40 = r36 - 1;
        r38[r36] = r38[r40];
        r38[r40] = r39;
        r36 = r36 + ((this.nvars - r37) - 2);
        r37 = r37 + 1;
    L55:
        int[] r41 = this.vorder;
        int r42 = r41[r1];
        r41[r1] = r41[r11];
        r41[r11] = r42;
        double[] r43 = this.tol;
        double r44 = r43[r1];
        r43[r1] = r43[r11];
        r43[r11] = r44;
        double[] r45 = this.rss;
        double r46 = r45[r11];
        double r47 = this.d[r11];
        double r115 = this.rhs[r11];
        r45[r1] = r46 + ((r47 * r115) * r115);
        r1 = r1 + r2;
        r6 = r15 + 1;
        r3 = r114;
        r4 = r4;
        goto L13
    L49:
        r114 = 1;
        goto L50
    L29:
        if (r14 >= r18) goto L35;
        this.d[r1] = (r13 * r16) * r16;
        this.r[r9] = 1.0d / r16;
        int r48 = r9 + 1;
    L32:
        if (r48 >= (((this.nvars + r9) - r1) - 1)) goto L34;
        double[] r49 = this.r;
        r49[r48] = r49[r48] / r16;
        r48 = r48 + 1;
        goto L32
    L34:
        double[] r50 = this.rhs;
        r50[r1] = r50[r1] / r16;
        r22 = r20;
        goto L42
    L35:
        r29 = r28;
        r22 = r20;
        goto L43
    L36:
        r20 = r10;
        goto L37
    L17:
        if (r14 > r5) goto L20;
        r114 = r3;
        goto L51
    L56:
        return;
    L11:
        int r51 = r1 - r27;
        r2 = -1;
        r1 = r1 - 1;
        r4 = r51;
        goto L12
    }

    private int reorderRegressors(int[] r7, int r8) {
        if (r7.length >= 1) goto L5;
        return -1;
    L5:
        if (r7.length > ((this.nvars + 1) - r8)) goto L31;
        int r0 = r8;
        int r1 = r0;
    L9:
        if (r0 >= this.nvars) goto L21;
        int r2 = this.vorder[r0];
        int r4 = 0;
    L12:
        if (r4 >= r7.length) goto L20;
        if (r2 != r7[r4]) goto L19;
        if (r0 <= r1) goto L19;
        vmove(r0, r1);
        r1 = r1 + 1;
        if (r1 < (r7.length + r8)) goto L20;
        return 0;
    L19:
        r4 = r4 + 1;
    L20:
        r0 = r0 + 1;
        goto L9
    L21:
        return 0;
    L31:
        return -1;
    }

    public double getDiagonalOfHatMatrix(double[] r18) {
        double[] r1 = r18;
        int r2 = this.nvars;
        double[] r3 = new double[r2];
        if (r1.length <= r2) goto L7;
        return Double.NaN;
    L7:
        if (this.hasIntercept == false) goto L9;
        double[] r4 = new double[r1.length + 1];
        r4[0] = 1.0d;
        System.arraycopy(r1, 0, r4, 1, r1.length);
        r1 = r4;
    L9:
        int r5 = 0;
        double r7 = 0.0d;
    L11:
        if (r5 >= r1.length) goto L20;
        if (FastMath.sqrt(this.d[r5]) >= this.tol[r5]) goto L15;
        r3[r5] = 0.0d;
    L19:
        r5 = r5 + 1;
        goto L11
    L15:
        int r9 = r5 - 1;
        double r10 = r1[r5];
        int r12 = 0;
    L16:
        if (r12 >= r5) goto L18;
        r10 = smartAdd(r10, (-r3[r12]) * this.r[r9]);
        r9 = r9 + ((this.nvars - r12) - 2);
        r12 = r12 + 1;
        goto L16
    L18:
        r3[r5] = r10;
        r7 = smartAdd(r7, (r10 * r10) / this.d[r5]);
        goto L19
    L20:
        return r7;
    }

    public int[] getOrderOfRegressors() {
        return MathArrays.copyOf(this.vorder);
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public RegressionResults regress() throws ModelSpecificationException {
        return regress(this.nvars);
    }

    public RegressionResults regress(int r24) throws ModelSpecificationException {
        if (this.nobs <= r24) goto L49;
        if (r24 > this.nvars) goto L47;
        tolset();
        singcheck();
        double[] r7 = regcf(r24);
        ss();
        double[] r2 = cov(r24);
        int r6 = 0;
        int r14 = 0;
    L7:
        boolean[] r8 = this.lindep;
        if (r6 >= r8.length) goto L13;
        if (r8[r6] == true) goto L12;
        r14 = r14 + 1;
    L12:
        r6 = r6 + 1;
        goto L7
    L13:
        int r9 = 0;
    L14:
        if (r9 >= r24) goto L19;
        if (this.vorder[r9] != r9) goto L17;
        r9 = r9 + 1;
        goto L14
    L17:
        boolean r10 = true;
    L20:
        if (r10 == false) goto L22;
        double[] r11 = new double[r7.length];
        double[] r12 = new double[r2.length];
        int[] r13 = new int[r7.length];
        int r15 = 0;
    L25:
        if (r15 >= this.nvars) goto L33;
        int r16 = 0;
    L27:
        if (r16 >= r24) goto L32;
        if (this.vorder[r16] != r15) goto L31;
        r11[r15] = r7[r16];
        r13[r15] = r16;
    L31:
        r16 = r16 + 1;
        goto L27
    L32:
        r15 = r15 + 1;
        goto L25
    L33:
        int r1 = 0;
        int r17 = 0;
    L35:
        if (r1 >= r7.length) goto L45;
        int r18 = r13[r1];
        int r19 = 0;
    L37:
        if (r19 > r1) goto L43;
        int r110 = r13[r19];
        if (r18 <= r110) goto L41;
        int r111 = (((r18 + 1) * r18) / 2) + r110;
    L42:
        r12[r17] = r2[r111];
        r19 = r19 + 1;
        r17 = r17 + 1;
        goto L37
    L41:
        r111 = ((r110 * (r110 + 1)) / 2) + r18;
        goto L42
    L43:
        r1 = r1 + 1;
        goto L35
    L45:
        return new RegressionResults(r11, new double[][]{r12}, true, this.nobs, r14, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
    L22:
        return new RegressionResults(r7, new double[][]{r2}, true, this.nobs, r14, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
    L19:
        r10 = false;
        goto L20
    L47:
        throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, new Object[]{Integer.valueOf(r24), Integer.valueOf(this.nvars)});
    L49:
        throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[]{Long.valueOf(this.nobs), Integer.valueOf(r24)});
    }

    @Override // org.apache.commons.math3.stat.regression.UpdatingMultipleLinearRegression
    public RegressionResults regress(int[] r25) throws ModelSpecificationException {
        int[] r1 = r25;
        int r2 = r1.length;
        int r3 = this.nvars;
        if (r2 > r3) goto L72;
        if (this.nobs <= r3) goto L70;
        Arrays.sort(r25);
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r1.length) goto L18;
        if (r4 >= this.nvars) goto L17;
        if (r4 <= 0) goto L15;
        if (r1[r4] != r1[r4 - 1]) goto L15;
        r1[r4] = -1;
        r5 = r5 + 1;
    L15:
        r4 = r4 + 1;
        goto L8
    L17:
        throw new ModelSpecificationException(LocalizedFormats.INDEX_LARGER_THAN_MAX, new Object[]{Integer.valueOf(r4), Integer.valueOf(this.nvars)});
    L18:
        if (r5 <= 0) goto L27;
        int[] r6 = new int[r1.length - r5];
        int r7 = 0;
        int r8 = 0;
    L21:
        if (r7 >= r1.length) goto L26;
        int r9 = r1[r7];
        if (r9 <= (-1)) goto L25;
        r6[r8] = r9;
        r8 = r8 + 1;
    L25:
        r7 = r7 + 1;
        goto L21
    L26:
        r1 = r6;
    L27:
        reorderRegressors(r1, 0);
        tolset();
        singcheck();
        double[] r10 = regcf(r1.length);
        ss();
        double[] r11 = cov(r1.length);
        int r12 = 0;
        int r15 = 0;
    L28:
        boolean[] r13 = this.lindep;
        if (r12 >= r13.length) goto L34;
        if (r13[r12] == true) goto L33;
        r15 = r15 + 1;
    L33:
        r12 = r12 + 1;
        goto L28
    L34:
        int r14 = 0;
    L36:
        if (r14 >= this.nvars) goto L41;
        if (this.vorder[r14] != r1[r14]) goto L39;
        r14 = r14 + 1;
        goto L36
    L39:
        boolean r16 = true;
    L42:
        if (r16 == false) goto L44;
        double[] r17 = new double[r10.length];
        int[] r18 = new int[r10.length];
        int r19 = 0;
    L47:
        if (r19 >= r1.length) goto L56;
        int r20 = 0;
    L49:
        int[] r110 = this.vorder;
        if (r20 >= r110.length) goto L55;
        if (r110[r20] != r1[r19]) goto L54;
        r17[r19] = r10[r20];
        r18[r19] = r20;
    L54:
        r20 = r20 + 1;
        goto L49
    L55:
        r19 = r19 + 1;
        goto L47
    L56:
        double[] r21 = new double[r11.length];
        int r22 = 0;
        int r23 = 0;
    L58:
        if (r22 >= r10.length) goto L68;
        int r111 = r18[r22];
        int r112 = 0;
    L60:
        if (r112 > r22) goto L66;
        int r113 = r18[r112];
        if (r111 <= r113) goto L64;
        int r114 = (((r111 + 1) * r111) / 2) + r113;
    L65:
        r21[r23] = r11[r114];
        r112 = r112 + 1;
        r23 = r23 + 1;
        goto L60
    L64:
        r114 = ((r113 * (r113 + 1)) / 2) + r111;
        goto L65
    L66:
        r22 = r22 + 1;
        goto L58
    L68:
        return new RegressionResults(r17, new double[][]{r21}, true, this.nobs, r15, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
    L44:
        return new RegressionResults(r10, new double[][]{r11}, true, this.nobs, r15, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
    L41:
        r16 = false;
        goto L42
    L70:
        throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, new Object[]{Long.valueOf(this.nobs), Integer.valueOf(this.nvars)});
    L72:
        throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, new Object[]{Integer.valueOf(r1.length), Integer.valueOf(this.nvars)});
    }
}
