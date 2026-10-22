package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldStepHandler<T extends RealFieldElement<T>> {
    void handleStep(FieldStepInterpolator<T> r1, boolean r2) throws MaxCountExceededException;

    void init(FieldODEStateAndDerivative<T> r1, T r2);
}
