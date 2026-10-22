package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFieldStepInterpolator<T extends RealFieldElement<T>> implements FieldStepInterpolator<T> {
    private final boolean forward;
    private final FieldODEStateAndDerivative<T> globalCurrentState;
    private final FieldODEStateAndDerivative<T> globalPreviousState;
    private FieldEquationsMapper<T> mapper;
    private final FieldODEStateAndDerivative<T> softCurrentState;
    private final FieldODEStateAndDerivative<T> softPreviousState;

    protected abstract FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r1, T r2, T r3, T r4, T r5) throws MaxCountExceededException;

    protected abstract AbstractFieldStepInterpolator<T> create(boolean r1, FieldODEStateAndDerivative<T> r2, FieldODEStateAndDerivative<T> r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldEquationsMapper<T> r6);

    protected AbstractFieldStepInterpolator(boolean r1, FieldODEStateAndDerivative<T> r2, FieldODEStateAndDerivative<T> r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldEquationsMapper<T> r6) {
        this.forward = r1;
        this.globalPreviousState = r2;
        this.globalCurrentState = r3;
        this.softPreviousState = r4;
        this.softCurrentState = r5;
        this.mapper = r6;
    }

    public AbstractFieldStepInterpolator<T> restrictStep(FieldODEStateAndDerivative<T> r8, FieldODEStateAndDerivative<T> r9) {
        return create(this.forward, this.globalPreviousState, this.globalCurrentState, r8, r9, this.mapper);
    }

    public FieldODEStateAndDerivative<T> getGlobalPreviousState() {
        return this.globalPreviousState;
    }

    public FieldODEStateAndDerivative<T> getGlobalCurrentState() {
        return this.globalCurrentState;
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepInterpolator
    public FieldODEStateAndDerivative<T> getPreviousState() {
        return this.softPreviousState;
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepInterpolator
    public FieldODEStateAndDerivative<T> getCurrentState() {
        return this.softCurrentState;
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepInterpolator
    public FieldODEStateAndDerivative<T> getInterpolatedState(T r8) {
        RealFieldElement r5 = (RealFieldElement) r8.subtract(this.globalPreviousState.getTime());
        RealFieldElement r6 = (RealFieldElement) this.globalCurrentState.getTime().subtract(r8);
        RealFieldElement r4 = (RealFieldElement) r5.divide(this.globalCurrentState.getTime().subtract(this.globalPreviousState.getTime()));
        return computeInterpolatedStateAndDerivatives(this.mapper, r8, r4, r5, r6);
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepInterpolator
    public boolean isForward() {
        return this.forward;
    }
}
