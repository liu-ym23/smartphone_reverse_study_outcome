package org.apache.commons.math3.ode;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldODEState<T extends RealFieldElement<T>> {
    private final T[][] secondaryState;
    private final T[] state;
    private final T time;

    public FieldODEState(T r3, T[] r4) {
        RealFieldElement[][] r1 = (RealFieldElement[][]) null;
        this(r3, r4, null);
    }

    public FieldODEState(T r1, T[] r2, T[][] r3) {
        this.time = r1;
        this.state = (T[]) ((RealFieldElement[]) r2.clone());
        this.secondaryState = (T[][]) copy(r1.getField(), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected T[][] copy(Field<T> r2, T[][] r3) {
        if (r3 != null) goto L5;
        RealFieldElement[][] r4 = (RealFieldElement[][]) null;
        return null;
    L5:
        T[][] r1 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(r2, r3.length, -1));
        int r5 = 0;
    L7:
        if (r5 >= r3.length) goto L9;
        r1[r5] = (RealFieldElement[]) r3[r5].clone();
        r5 = r5 + 1;
        goto L7
    L9:
        return r1;
    }

    public T getTime() {
        return this.time;
    }

    public int getStateDimension() {
        return this.state.length;
    }

    public T[] getState() {
        return (T[]) ((RealFieldElement[]) this.state.clone());
    }

    public int getNumberOfSecondaryStates() {
        T[][] r0 = this.secondaryState;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public int getSecondaryStateDimension(int r1) {
        if (r1 != 0) goto L5;
        return this.state.length;
    L5:
        return this.secondaryState[r1 - 1].length;
    }

    public T[] getSecondaryState(int r1) {
        if (r1 != 0) goto L4;
        Object r0 = this.state.clone();
    L6:
        return (T[]) ((RealFieldElement[]) r0);
    L4:
        r0 = this.secondaryState[r1 - 1].clone();
        goto L6
    }
}
