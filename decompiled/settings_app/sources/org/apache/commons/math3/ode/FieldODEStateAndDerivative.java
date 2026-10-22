package org.apache.commons.math3.ode;

import org.apache.commons.math3.RealFieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class FieldODEStateAndDerivative<T extends RealFieldElement<T>> extends FieldODEState<T> {
    private final T[] derivative;
    private final T[][] secondaryDerivative;

    public FieldODEStateAndDerivative(T r7, T[] r8, T[] r9) {
        RealFieldElement[][] r0 = (RealFieldElement[][]) null;
        this(r7, r8, r9, null, null);
    }

    public FieldODEStateAndDerivative(T r1, T[] r2, T[] r3, T[][] r4, T[][] r5) {
        super(r1, r2, r4);
        this.derivative = (T[]) ((RealFieldElement[]) r3.clone());
        this.secondaryDerivative = copy(r1.getField(), r5);
    }

    public T[] getDerivative() {
        return (T[]) ((RealFieldElement[]) this.derivative.clone());
    }

    public T[] getSecondaryDerivative(int r1) {
        if (r1 != 0) goto L4;
        Object r0 = this.derivative.clone();
    L6:
        return (T[]) ((RealFieldElement[]) r0);
    L4:
        r0 = this.secondaryDerivative[r1 - 1].clone();
        goto L6
    }
}
