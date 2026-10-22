package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class StepNormalizer implements StepHandler {
    private final StepNormalizerBounds bounds;
    private double firstTime;
    private boolean forward;
    private double h;
    private final FixedStepHandler handler;
    private double[] lastDerivatives;
    private double[] lastState;
    private double lastTime;
    private final StepNormalizerMode mode;

    public StepNormalizer(double r7, FixedStepHandler r9) {
        this(r7, r9, StepNormalizerMode.INCREMENT, StepNormalizerBounds.FIRST);
    }

    public StepNormalizer(double r7, FixedStepHandler r9, StepNormalizerMode r10) {
        this(r7, r9, r10, StepNormalizerBounds.FIRST);
    }

    public StepNormalizer(double r7, FixedStepHandler r9, StepNormalizerBounds r10) {
        this(r7, r9, StepNormalizerMode.INCREMENT, r10);
    }

    public StepNormalizer(double r1, FixedStepHandler r3, StepNormalizerMode r4, StepNormalizerBounds r5) {
        this.h = FastMath.abs(r1);
        this.handler = r3;
        this.mode = r4;
        this.bounds = r5;
        this.firstTime = Double.NaN;
        this.lastTime = Double.NaN;
        this.lastState = null;
        this.lastDerivatives = null;
        this.forward = true;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void init(double r8, double[] r10, double r11) {
        this.firstTime = Double.NaN;
        this.lastTime = Double.NaN;
        this.lastState = null;
        this.lastDerivatives = null;
        this.forward = true;
        this.handler.init(r8, r10, r11);
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void handleStep(StepInterpolator r8, boolean r9) throws MaxCountExceededException {
        boolean r1 = false;
        if (this.lastState != null) goto L12;
        this.firstTime = r8.getPreviousTime();
        double r3 = r8.getPreviousTime();
        this.lastTime = r3;
        r8.setInterpolatedTime(r3);
        this.lastState = (double[]) r8.getInterpolatedState().clone();
        this.lastDerivatives = (double[]) r8.getInterpolatedDerivatives().clone();
        if (r8.getCurrentTime() < this.lastTime) goto L7;
        boolean r0 = true;
    L8:
        this.forward = r0;
        if (r0 == true) goto L12;
        this.h = -this.h;
        goto L12
    L7:
        r0 = false;
    L12:
        if (this.mode != StepNormalizerMode.INCREMENT) goto L14;
        double r4 = this.lastTime + this.h;
    L16:
        if (this.mode == StepNormalizerMode.MULTIPLES) goto L18;
    L20:
        boolean r2 = isNextInStep(r4, r8);
    L21:
        if (r2 == false) goto L23;
        doNormalizedStep(false);
        storeStep(r8, r4);
        r4 = r4 + this.h;
        r2 = isNextInStep(r4, r8);
        goto L21
    L23:
        if (r9 == true) goto L25;
        return;
    L25:
        if (this.bounds.lastIncluded() == true) goto L27;
    L29:
        doNormalizedStep(!r1);
        if (r1 == false) goto L35;
        storeStep(r8, r8.getCurrentTime());
        doNormalizedStep(true);
        return;
    L35:
        return;
    L27:
        if (this.lastTime == r8.getCurrentTime()) goto L29;
        r1 = true;
        goto L29
    L18:
        if (Precision.equals(r4, this.lastTime, 1) == false) goto L20;
        r4 = r4 + this.h;
        goto L20
    L14:
        r4 = (FastMath.floor(this.lastTime / this.h) + 1.0d) * this.h;
        goto L16
    }

    private boolean isNextInStep(double r5, StepInterpolator r7) {
        boolean r4 = this.forward;
        double r2 = r7.getCurrentTime();
        if (r4 == false) goto L8;
        if (r5 > r2) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (r5 < r2) goto L11;
        return true;
    }

    private void doNormalizedStep(boolean r8) {
        if (this.bounds.firstIncluded() == false) goto L5;
    L7:
        this.handler.handleStep(this.lastTime, this.lastState, this.lastDerivatives, r8);
        return;
    L5:
        if (this.firstTime != this.lastTime) goto L7;
    }

    private void storeStep(StepInterpolator r3, double r4) throws MaxCountExceededException {
        this.lastTime = r4;
        r3.setInterpolatedTime(r4);
        double[] r5 = r3.getInterpolatedState();
        double[] r6 = this.lastState;
        System.arraycopy(r5, 0, r6, 0, r6.length);
        double[] r7 = r3.getInterpolatedDerivatives();
        double[] r2 = this.lastDerivatives;
        System.arraycopy(r7, 0, r2, 0, r2.length);
    }
}
