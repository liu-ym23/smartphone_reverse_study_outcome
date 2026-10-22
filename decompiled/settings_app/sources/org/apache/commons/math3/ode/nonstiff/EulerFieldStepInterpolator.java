package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class EulerFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    EulerFieldStepInterpolator(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected EulerFieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new EulerFieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r7, T r8, T r9, T r10, T r11) {
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        T[] r12 = currentStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r11.negate()});
        T[] r6 = derivativeLinearCombination(new RealFieldElement[]{(RealFieldElement) r8.getField().getOne()});
    L9:
        return new FieldODEStateAndDerivative(r8, r12, r6);
    L5:
        if (r9.getReal() > 0.5d) goto L7;
        r12 = previousStateLinearCombination(new RealFieldElement[]{r10});
        r6 = derivativeLinearCombination(new RealFieldElement[]{(RealFieldElement) r8.getField().getOne()});
        goto L9
    }
}
