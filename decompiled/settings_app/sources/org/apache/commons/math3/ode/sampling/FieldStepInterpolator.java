package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldStepInterpolator<T extends RealFieldElement<T>> {
    FieldODEStateAndDerivative<T> getCurrentState();

    FieldODEStateAndDerivative<T> getInterpolatedState(T r1);

    FieldODEStateAndDerivative<T> getPreviousState();

    boolean isForward();
}
