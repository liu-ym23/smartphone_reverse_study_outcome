package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class ClassicalRungeKuttaFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    ClassicalRungeKuttaFieldStepInterpolator(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected ClassicalRungeKuttaFieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new ClassicalRungeKuttaFieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r18, T r19, T r20, T r21, T r22) {
        RealFieldElement r2 = (RealFieldElement) r19.getField().getOne();
        RealFieldElement r3 = (RealFieldElement) r2.subtract(r20);
        RealFieldElement r4 = (RealFieldElement) r2.subtract(r20.multiply(2));
        RealFieldElement r5 = (RealFieldElement) r3.multiply(r4);
        RealFieldElement r6 = (RealFieldElement) ((RealFieldElement) r20.multiply(r3)).multiply(2);
        RealFieldElement r7 = (RealFieldElement) ((RealFieldElement) r20.multiply(r4)).negate();
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        RealFieldElement r8 = (RealFieldElement) r20.multiply(4);
        RealFieldElement r9 = (RealFieldElement) r22.divide(6.0d);
        RealFieldElement r10 = (RealFieldElement) r9.multiply(((RealFieldElement) r20.multiply(((RealFieldElement) r8.negate()).add(5.0d))).subtract(1.0d));
        RealFieldElement r11 = (RealFieldElement) r9.multiply(((RealFieldElement) r20.multiply(r8.subtract(2.0d))).subtract(2.0d));
        T[] r1 = currentStateLinearCombination(new RealFieldElement[]{r10, r11, r11, (RealFieldElement) r9.multiply(((RealFieldElement) r20.multiply(((RealFieldElement) r8.negate()).subtract(1.0d))).subtract(1.0d))});
        T[] r0 = derivativeLinearCombination(new RealFieldElement[]{r5, r6, r6, r7});
    L9:
        return new FieldODEStateAndDerivative(r19, r1, r0);
    L5:
        if (r20.getReal() > 0.5d) goto L7;
        RealFieldElement r12 = (RealFieldElement) ((RealFieldElement) r20.multiply(r20)).multiply(4);
        RealFieldElement r13 = (RealFieldElement) r21.divide(6.0d);
        RealFieldElement r14 = (RealFieldElement) r13.multiply(((RealFieldElement) r12.subtract(r20.multiply(9))).add(6.0d));
        RealFieldElement r15 = (RealFieldElement) r13.multiply(((RealFieldElement) r20.multiply(6)).subtract(r12));
        r1 = previousStateLinearCombination(new RealFieldElement[]{r14, r15, r15, (RealFieldElement) r13.multiply(r12.subtract(r20.multiply(3)))});
        r0 = derivativeLinearCombination(new RealFieldElement[]{r5, r6, r6, r7});
        goto L9
    }
}
