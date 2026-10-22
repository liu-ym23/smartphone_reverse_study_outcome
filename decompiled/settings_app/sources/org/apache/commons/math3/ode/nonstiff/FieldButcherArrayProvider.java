package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.RealFieldElement;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldButcherArrayProvider<T extends RealFieldElement<T>> {
    T[][] getA();

    T[] getB();

    T[] getC();
}
