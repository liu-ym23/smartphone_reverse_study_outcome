package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class ThreeEighthesFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    ThreeEighthesFieldStepInterpolator(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected ThreeEighthesFieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new ThreeEighthesFieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r19, T r20, T r21, T r22, T r23) {
        RealFieldElement r2 = (RealFieldElement) r21.multiply(0.75d);
        RealFieldElement r4 = (RealFieldElement) ((RealFieldElement) r2.multiply(((RealFieldElement) r21.multiply(4)).subtract(5.0d))).add(1.0d);
        RealFieldElement r5 = (RealFieldElement) r2.multiply(((RealFieldElement) r21.multiply(-6)).add(5.0d));
        RealFieldElement r9 = (RealFieldElement) r2.multiply(((RealFieldElement) r21.multiply(2)).subtract(1.0d));
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        RealFieldElement r6 = (RealFieldElement) r23.divide(-8.0d);
        RealFieldElement r10 = (RealFieldElement) ((RealFieldElement) r21.multiply(r21)).multiply(4);
        RealFieldElement r14 = (RealFieldElement) r21.add(1.0d);
        T[] r7 = currentStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r6.multiply(((RealFieldElement) ((RealFieldElement) r10.multiply(2)).subtract(r21.multiply(7))).add(1.0d)), (RealFieldElement) ((RealFieldElement) r6.multiply(r14.subtract(r10))).multiply(3), (RealFieldElement) ((RealFieldElement) r6.multiply(r14)).multiply(3), (RealFieldElement) r6.multiply(r14.add(r10))});
        T[] r0 = derivativeLinearCombination(new RealFieldElement[]{r4, r5, r2, r9});
        T[] r1 = r7;
    L9:
        return new FieldODEStateAndDerivative(r20, r1, r0);
    L5:
        if (r21.getReal() > 0.5d) goto L7;
        RealFieldElement r11 = (RealFieldElement) r22.divide(8.0d);
        RealFieldElement r15 = (RealFieldElement) ((RealFieldElement) r21.multiply(r21)).multiply(4);
        r1 = previousStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r11.multiply(((RealFieldElement) ((RealFieldElement) r15.multiply(2)).subtract(r21.multiply(15))).add(8.0d)), (RealFieldElement) ((RealFieldElement) r11.multiply(((RealFieldElement) r21.multiply(5)).subtract(r15))).multiply(3), (RealFieldElement) ((RealFieldElement) r11.multiply(r21)).multiply(3), (RealFieldElement) r11.multiply(r15.subtract(r21.multiply(3)))});
        r0 = derivativeLinearCombination(new RealFieldElement[]{r4, r5, r2, r9});
        goto L9
    }
}
