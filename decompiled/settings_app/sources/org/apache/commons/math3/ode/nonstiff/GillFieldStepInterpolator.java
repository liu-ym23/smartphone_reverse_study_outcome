package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class GillFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    private final T one_minus_inv_sqrt_2;
    private final T one_plus_inv_sqrt_2;

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    GillFieldStepInterpolator(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
        RealFieldElement r9 = (RealFieldElement) ((RealFieldElement) r1.getZero().add(0.5d)).sqrt();
        this.one_minus_inv_sqrt_2 = (T) r1.getOne().subtract(r9);
        this.one_plus_inv_sqrt_2 = (T) r1.getOne().add(r9);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected GillFieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new GillFieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r21, T r22, T r23, T r24, T r25) {
        RealFieldElement r2 = (RealFieldElement) r22.getField().getOne();
        RealFieldElement r4 = (RealFieldElement) r23.multiply(2);
        RealFieldElement r5 = (RealFieldElement) r4.multiply(r4);
        RealFieldElement r6 = (RealFieldElement) ((RealFieldElement) r23.multiply(r4.subtract(3.0d))).add(1.0d);
        RealFieldElement r3 = (RealFieldElement) r4.multiply(r2.subtract(r23));
        RealFieldElement r9 = (RealFieldElement) r3.multiply(this.one_minus_inv_sqrt_2);
        RealFieldElement r7 = (RealFieldElement) r3.multiply(this.one_plus_inv_sqrt_2);
        RealFieldElement r10 = (RealFieldElement) r23.multiply(r4.subtract(1.0d));
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        RealFieldElement r8 = (RealFieldElement) r25.divide(-6.0d);
        RealFieldElement r11 = (RealFieldElement) r8.multiply(((RealFieldElement) r4.add(2.0d)).subtract(r5));
        T[] r1 = currentStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r8.multiply(((RealFieldElement) r5.subtract(r23.multiply(5))).add(1.0d)), (RealFieldElement) r11.multiply(this.one_minus_inv_sqrt_2), (RealFieldElement) r11.multiply(this.one_plus_inv_sqrt_2), (RealFieldElement) r8.multiply(((RealFieldElement) r5.add(r23)).add(1.0d))});
        T[] r0 = derivativeLinearCombination(new RealFieldElement[]{r6, r9, r7, r10});
    L9:
        return new FieldODEStateAndDerivative(r22, r1, r0);
    L5:
        if (r23.getReal() > 0.5d) goto L7;
        RealFieldElement r12 = (RealFieldElement) r24.divide(6.0d);
        RealFieldElement r13 = (RealFieldElement) r12.multiply(((RealFieldElement) r23.multiply(6)).subtract(r5));
        r1 = previousStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r12.multiply(((RealFieldElement) r5.subtract(r23.multiply(9))).add(6.0d)), (RealFieldElement) r13.multiply(this.one_minus_inv_sqrt_2), (RealFieldElement) r13.multiply(this.one_plus_inv_sqrt_2), (RealFieldElement) r12.multiply(r5.subtract(r23.multiply(3)))});
        r0 = derivativeLinearCombination(new RealFieldElement[]{r6, r9, r7, r10});
        goto L9
    }
}
