package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class HighamHall54FieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    HighamHall54FieldStepInterpolator(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected HighamHall54FieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new HighamHall54FieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r27, T r28, T r29, T r30, T r31) {
        RealFieldElement r3 = (RealFieldElement) ((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(-10.0d)).add(16.0d))).add(-7.5d))).add(1.0d);
        RealFieldElement r6 = (RealFieldElement) r28.getField().getZero();
        RealFieldElement r7 = (RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(67.5d)).add(-91.125d))).add(28.6875d));
        RealFieldElement r8 = (RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(-120.0d)).add(152.0d))).add(-44.0d));
        RealFieldElement r9 = (RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(62.5d)).add(-78.125d))).add(23.4375d));
        RealFieldElement r10 = (RealFieldElement) ((RealFieldElement) r29.multiply(0.625d)).multiply(((RealFieldElement) r29.multiply(2)).subtract(1.0d));
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        RealFieldElement r11 = (RealFieldElement) r29.multiply(r29);
        RealFieldElement r2 = (RealFieldElement) r30.divide(r29);
        T[] r1 = currentStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r2.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(-2.5d)).add(5.333333333333333d))).add(-3.75d))).add(1.0d))).add(-0.08333333333333333d)), (RealFieldElement) r28.getField().getZero(), (RealFieldElement) r2.multiply(((RealFieldElement) r11.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(16.875d)).add(-30.375d))).add(14.34375d))).add(-0.84375d)), (RealFieldElement) r2.multiply(((RealFieldElement) r11.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(-30.0d)).add(50.666666666666664d))).add(-22.0d))).add(1.3333333333333333d)), (RealFieldElement) r2.multiply(((RealFieldElement) r11.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(15.625d)).add(-26.041666666666668d))).add(11.71875d))).add(-1.3020833333333333d)), (RealFieldElement) r2.multiply(((RealFieldElement) r11.multiply(((RealFieldElement) r29.multiply(0.4166666666666667d)).add(-0.3125d))).add(-0.10416666666666667d))});
        T[] r0 = derivativeLinearCombination(new RealFieldElement[]{r3, r6, r7, r8, r9, r10});
    L9:
        return new FieldODEStateAndDerivative(r28, r1, r0);
    L5:
        if (r29.getReal() > 0.5d) goto L7;
        r1 = previousStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r30.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(-2.5d)).add(5.333333333333333d))).add(-3.75d))).add(1.0d)), (RealFieldElement) r28.getField().getZero(), (RealFieldElement) r30.multiply(r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(16.875d)).add(-30.375d))).add(14.34375d))), (RealFieldElement) r30.multiply(r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(-30.0d)).add(50.666666666666664d))).add(-22.0d))), (RealFieldElement) r30.multiply(r29.multiply(((RealFieldElement) r29.multiply(((RealFieldElement) r29.multiply(15.625d)).add(-26.041666666666668d))).add(11.71875d))), (RealFieldElement) r30.multiply(r29.multiply(((RealFieldElement) r29.multiply(0.4166666666666667d)).add(-0.3125d)))});
        r0 = derivativeLinearCombination(new RealFieldElement[]{r3, r6, r7, r8, r9, r10});
        goto L9
    }
}
