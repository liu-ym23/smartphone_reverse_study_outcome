package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class MidpointFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    MidpointFieldStepInterpolator(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected MidpointFieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new MidpointFieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r10, T r11, T r12, T r13, T r14) {
        RealFieldElement r0 = (RealFieldElement) r12.multiply(2);
        RealFieldElement r1 = (RealFieldElement) ((RealFieldElement) r11.getField().getOne()).subtract(r0);
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        T[] r15 = currentStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r14.multiply(r12), (RealFieldElement) ((RealFieldElement) r14.multiply(r12.add(1.0d))).negate()});
        T[] r9 = derivativeLinearCombination(new RealFieldElement[]{r1, r0});
    L9:
        return new FieldODEStateAndDerivative(r11, r15, r9);
    L5:
        if (r12.getReal() > 0.5d) goto L7;
        r15 = previousStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r12.multiply(r14), (RealFieldElement) r12.multiply(r13)});
        r9 = derivativeLinearCombination(new RealFieldElement[]{r1, r0});
        goto L9
    }
}
