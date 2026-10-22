package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AdaptiveStepsizeIntegrator extends AbstractIntegrator {
    private double initialStep;
    protected int mainSetDimension;
    private double maxStep;
    private double minStep;
    protected double scalAbsoluteTolerance;
    protected double scalRelativeTolerance;
    protected double[] vecAbsoluteTolerance;
    protected double[] vecRelativeTolerance;

    @Override // org.apache.commons.math3.ode.AbstractIntegrator
    public abstract void integrate(ExpandableStatefulODE r1, double r2) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException;

    public AdaptiveStepsizeIntegrator(String r10, double r11, double r13, double r15, double r17) {
        super(r10);
        setStepSizeControl(r11, r13, r15, r17);
        resetInternalState();
    }

    public AdaptiveStepsizeIntegrator(String r8, double r9, double r11, double[] r13, double[] r14) {
        super(r8);
        setStepSizeControl(r9, r11, r13, r14);
        resetInternalState();
    }

    public void setStepSizeControl(double r1, double r3, double r5, double r7) {
        this.minStep = FastMath.abs(r1);
        this.maxStep = FastMath.abs(r3);
        this.initialStep = -1.0d;
        this.scalAbsoluteTolerance = r5;
        this.scalRelativeTolerance = r7;
        this.vecAbsoluteTolerance = null;
        this.vecRelativeTolerance = null;
    }

    public void setStepSizeControl(double r1, double r3, double[] r5, double[] r6) {
        this.minStep = FastMath.abs(r1);
        this.maxStep = FastMath.abs(r3);
        this.initialStep = -1.0d;
        this.scalAbsoluteTolerance = 0.0d;
        this.scalRelativeTolerance = 0.0d;
        this.vecAbsoluteTolerance = (double[]) r5.clone();
        this.vecRelativeTolerance = (double[]) r6.clone();
    }

    public void setInitialStepSize(double r3) {
        if (r3 >= this.minStep) goto L5;
    L8:
        this.initialStep = -1.0d;
        return;
    L5:
        if (r3 > this.maxStep) goto L8;
        this.initialStep = r3;
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator
    protected void sanityChecks(ExpandableStatefulODE r1, double r2) throws DimensionMismatchException, NumberIsTooSmallException {
        super.sanityChecks(r1, r2);
        int r3 = r1.getPrimaryMapper().getDimension();
        this.mainSetDimension = r3;
        double[] r4 = this.vecAbsoluteTolerance;
        if (r4 != null) goto L5;
    L9:
        double[] r5 = this.vecRelativeTolerance;
        if (r5 != null) goto L12;
        return;
    L12:
        if (r5.length != r3) goto L15;
        return;
    L15:
        throw new DimensionMismatchException(this.mainSetDimension, this.vecRelativeTolerance.length);
    L5:
        if (r4.length == r3) goto L9;
        throw new DimensionMismatchException(this.mainSetDimension, this.vecAbsoluteTolerance.length);
    }

    public double initializeStep(boolean r22, int r23, double[] r24, double r25, double[] r27, double[] r28, double[] r29, double[] r30) throws MaxCountExceededException, DimensionMismatchException {
        double r5 = this.initialStep;
        if (r5 <= 0.0d) goto L8;
        if (r22 == false) goto L7;
        return r5;
    L7:
        return -r5;
    L8:
        int r6 = 0;
        int r7 = 0;
        double r9 = 0.0d;
        double r11 = 0.0d;
    L10:
        if (r7 >= r24.length) goto L13;
        double r13 = r27[r7];
        double r15 = r24[r7];
        double r14 = r13 / r15;
        r9 = r9 + (r14 * r14);
        double r16 = r28[r7] / r15;
        r11 = r11 + (r16 * r16);
        r7 = r7 + 1;
        goto L10
    L13:
        if (r9 >= 1.0E-10d) goto L15;
    L18:
        double r10 = 1.0E-6d;
    L19:
        if (r22 == true) goto L21;
        r10 = -r10;
    L21:
        int r8 = 0;
    L23:
        if (r8 >= r27.length) goto L25;
        r29[r8] = r27[r8] + (r28[r8] * r10);
        r8 = r8 + 1;
        goto L23
    L25:
        computeDerivatives(r25 + r10, r29, r30);
        double r17 = 0.0d;
    L27:
        if (r6 >= r24.length) goto L29;
        double r2 = (r30[r6] - r28[r6]) / r24[r6];
        r17 = r17 + (r2 * r2);
        r6 = r6 + 1;
        goto L27
    L29:
        double r1 = FastMath.max(FastMath.sqrt(r11), FastMath.sqrt(r17) / r10);
        if (r1 >= 1.0E-15d) goto L32;
        double r3 = FastMath.max(1.0E-6d, FastMath.abs(r10) * 0.001d);
    L33:
        double r4 = FastMath.max(FastMath.min(FastMath.abs(r10) * 100.0d, r3), FastMath.abs(r25) * 1.0E-12d);
        if (r4 >= getMinStep()) goto L37;
        r4 = getMinStep();
    L37:
        if (r4 <= getMaxStep()) goto L39;
        r4 = getMaxStep();
    L39:
        if (r22 == false) goto L41;
        return r4;
    L41:
        return -r4;
    L32:
        r3 = FastMath.pow(0.01d / r1, 1.0d / ((double) r23));
        goto L33
    L15:
        if (r11 < 1.0E-10d) goto L18;
        r10 = FastMath.sqrt(r9 / r11) * 0.01d;
        goto L19
    }

    protected double filterStep(double r5, boolean r7, boolean r8) throws NumberIsTooSmallException {
        double r0 = FastMath.abs(r5);
        double r2 = this.minStep;
        if (r0 >= r2) goto L10;
        if (r8 == false) goto L9;
        if (r7 == false) goto L7;
        r5 = r2;
        goto L10
    L7:
        r5 = -r2;
        goto L10
    L9:
        throw new NumberIsTooSmallException(LocalizedFormats.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, Double.valueOf(FastMath.abs(r5)), Double.valueOf(this.minStep), true);
    L10:
        double r9 = this.maxStep;
        if (r5 <= r9) goto L14;
        return r9;
    L14:
        if (r5 < (-r9)) goto L16;
        return r5;
    L16:
        return -r9;
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator, org.apache.commons.math3.ode.ODEIntegrator
    public double getCurrentStepStart() {
        return this.stepStart;
    }

    protected void resetInternalState() {
        this.stepStart = Double.NaN;
        this.stepSize = FastMath.sqrt(this.minStep * this.maxStep);
    }

    public double getMinStep() {
        return this.minStep;
    }

    public double getMaxStep() {
        return this.maxStep;
    }
}
