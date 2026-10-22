package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldFixedStepHandler<T extends RealFieldElement<T>> {
    void handleStep(FieldODEStateAndDerivative<T> r1, boolean r2);

    void init(FieldODEStateAndDerivative<T> r1, T r2);
}
