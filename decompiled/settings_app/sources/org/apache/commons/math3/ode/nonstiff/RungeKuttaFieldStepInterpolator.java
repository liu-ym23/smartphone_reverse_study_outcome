package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
abstract class RungeKuttaFieldStepInterpolator<T extends RealFieldElement<T>> extends AbstractFieldStepInterpolator<T> {
    private final Field<T> field;
    private final T[][] yDotK;

    protected abstract RungeKuttaFieldStepInterpolator<T> create(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8);

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected /* bridge */ /* synthetic */ AbstractFieldStepInterpolator create(boolean r1, FieldODEStateAndDerivative r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldEquationsMapper r6) {
        return create(r1, r2, r3, r4, r5, r6);
    }

    protected RungeKuttaFieldStepInterpolator(Field<T> r8, boolean r9, T[][] r10, FieldODEStateAndDerivative<T> r11, FieldODEStateAndDerivative<T> r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        super(r9, r11, r12, r13, r14, r15);
        this.field = r8;
        this.yDotK = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(r8, r10.length, -1));
        int r16 = 0;
    L4:
        if (r16 >= r10.length) goto L6;
        ((T[][]) this.yDotK)[r16] = (RealFieldElement[]) r10[r16].clone();
        r16 = r16 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected RungeKuttaFieldStepInterpolator<T> create(boolean r10, FieldODEStateAndDerivative<T> r11, FieldODEStateAndDerivative<T> r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return create(this.field, r10, this.yDotK, r11, r12, r13, r14, r15);
    }

    protected final T[] previousStateLinearCombination(T... r2) {
        return (T[]) combine(getPreviousState().getState(), r2);
    }

    protected T[] currentStateLinearCombination(T... r2) {
        return (T[]) combine(getCurrentState().getState(), r2);
    }

    protected T[] derivativeLinearCombination(T... r4) {
        return (T[]) combine((RealFieldElement[]) MathArrays.buildArray(this.field, this.yDotK[0].length), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T[] combine(T[] r7, T... r8) {
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L10;
        int r2 = 0;
    L7:
        if (r2 >= r8.length) goto L9;
        r7[r1] = (RealFieldElement) r7[r1].add(r8[r2].multiply(this.yDotK[r2][r1]));
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L10:
        return r7;
    }
}
