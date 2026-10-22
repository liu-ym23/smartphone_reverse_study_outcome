package org.apache.commons.math3.ode;

import org.apache.commons.math3.RealFieldElement;

/* JADX INFO: loaded from: classes6.dex */
public interface FirstOrderFieldDifferentialEquations<T extends RealFieldElement<T>> {
    T[] computeDerivatives(T r1, T[] r2);

    int getDimension();

    void init(T r1, T[] r2, T r3);
}
