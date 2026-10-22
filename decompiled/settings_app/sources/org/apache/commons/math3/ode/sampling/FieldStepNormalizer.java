package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class FieldStepNormalizer<T extends RealFieldElement<T>> implements FieldStepHandler<T> {
    private final StepNormalizerBounds bounds;
    private FieldODEStateAndDerivative<T> first;
    private boolean forward;
    private double h;
    private final FieldFixedStepHandler<T> handler;
    private FieldODEStateAndDerivative<T> last;
    private final StepNormalizerMode mode;

    public FieldStepNormalizer(double r7, FieldFixedStepHandler<T> r9) {
        this(r7, r9, StepNormalizerMode.INCREMENT, StepNormalizerBounds.FIRST);
    }

    public FieldStepNormalizer(double r7, FieldFixedStepHandler<T> r9, StepNormalizerMode r10) {
        this(r7, r9, r10, StepNormalizerBounds.FIRST);
    }

    public FieldStepNormalizer(double r7, FieldFixedStepHandler<T> r9, StepNormalizerBounds r10) {
        this(r7, r9, StepNormalizerMode.INCREMENT, r10);
    }

    public FieldStepNormalizer(double r1, FieldFixedStepHandler<T> r3, StepNormalizerMode r4, StepNormalizerBounds r5) {
        this.h = FastMath.abs(r1);
        this.handler = r3;
        this.mode = r4;
        this.bounds = r5;
        this.first = null;
        this.last = null;
        this.forward = true;
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void init(FieldODEStateAndDerivative<T> r2, T r3) {
        this.first = null;
        this.last = null;
        this.forward = true;
        this.handler.init(r2, r3);
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void handleStep(FieldStepInterpolator<T> r7, boolean r8) throws MaxCountExceededException {
        if (this.last != null) goto L8;
        FieldODEStateAndDerivative<T> r0 = r7.getPreviousState();
        this.first = r0;
        this.last = r0;
        boolean r1 = r7.isForward();
        this.forward = r1;
        if (r1 == true) goto L8;
        this.h = -this.h;
    L8:
        if (this.mode != StepNormalizerMode.INCREMENT) goto L10;
        RealFieldElement r2 = this.last.getTime();
        double r3 = this.h;
    L11:
        RealFieldElement r4 = (RealFieldElement) r2.add(r3);
        if (this.mode == StepNormalizerMode.MULTIPLES) goto L14;
    L16:
        boolean r5 = isNextInStep(r4, r7);
    L17:
        boolean r6 = false;
        if (r5 == false) goto L20;
        doNormalizedStep(false);
        this.last = r7.getInterpolatedState(r4);
        r4 = (RealFieldElement) r4.add(this.h);
        r5 = isNextInStep(r4, r7);
        goto L17
    L20:
        if (r8 == true) goto L22;
        return;
    L22:
        if (this.bounds.lastIncluded() == true) goto L24;
    L26:
        doNormalizedStep(!r6);
        if (r6 == false) goto L32;
        this.last = r7.getCurrentState();
        doNormalizedStep(true);
        return;
    L32:
        return;
    L24:
        if (this.last.getTime().getReal() == r7.getCurrentState().getTime().getReal()) goto L26;
        r6 = true;
        goto L26
    L14:
        if (Precision.equals(r4.getReal(), this.last.getTime().getReal(), 1) == false) goto L16;
        r4 = (RealFieldElement) r4.add(this.h);
        goto L16
    L10:
        r2 = (RealFieldElement) this.last.getTime().getField().getZero();
        r3 = (FastMath.floor(this.last.getTime().getReal() / this.h) + 1.0d) * this.h;
        goto L11
    }

    private boolean isNextInStep(T r5, FieldStepInterpolator<T> r6) {
        if (this.forward == false) goto L8;
        if (r5.getReal() > r6.getCurrentState().getTime().getReal()) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (r5.getReal() < r6.getCurrentState().getTime().getReal()) goto L11;
        return true;
    }

    private void doNormalizedStep(boolean r5) {
        if (this.bounds.firstIncluded() == false) goto L5;
    L7:
        this.handler.handleStep(this.last, r5);
        return;
    L5:
        if (this.first.getTime().getReal() != this.last.getTime().getReal()) goto L7;
    }
}
