package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldEventHandler<T extends RealFieldElement<T>> {
    Action eventOccurred(FieldODEStateAndDerivative<T> r1, boolean r2);

    T g(FieldODEStateAndDerivative<T> r1);

    void init(FieldODEStateAndDerivative<T> r1, T r2);

    FieldODEState<T> resetState(FieldODEStateAndDerivative<T> r1);
}
