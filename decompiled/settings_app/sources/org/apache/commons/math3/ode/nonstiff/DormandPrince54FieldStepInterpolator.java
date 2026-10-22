package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class DormandPrince54FieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    private final T a70;
    private final T a72;
    private final T a73;
    private final T a74;
    private final T a75;
    private final T d0;
    private final T d2;
    private final T d3;
    private final T d4;
    private final T d5;
    private final T d6;

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    DormandPrince54FieldStepInterpolator(Field<T> r1, boolean r2, T[][] r3, FieldODEStateAndDerivative<T> r4, FieldODEStateAndDerivative<T> r5, FieldODEStateAndDerivative<T> r6, FieldODEStateAndDerivative<T> r7, FieldEquationsMapper<T> r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
        T r9 = r1.getOne();
        this.a70 = (T) ((RealFieldElement) r9.multiply(35.0d)).divide(384.0d);
        this.a72 = (T) ((RealFieldElement) r9.multiply(500.0d)).divide(1113.0d);
        this.a73 = (T) ((RealFieldElement) r9.multiply(125.0d)).divide(192.0d);
        this.a74 = (T) ((RealFieldElement) r9.multiply(-2187.0d)).divide(6784.0d);
        this.a75 = (T) ((RealFieldElement) r9.multiply(11.0d)).divide(84.0d);
        this.d0 = (T) ((RealFieldElement) r9.multiply(-1.2715105075E10d)).divide(1.1282082432E10d);
        this.d2 = (T) ((RealFieldElement) r9.multiply(8.74874797E10d)).divide(3.2700410799E10d);
        this.d3 = (T) ((RealFieldElement) r9.multiply(-1.0690763975E10d)).divide(1.880347072E9d);
        this.d4 = (T) ((RealFieldElement) r9.multiply(7.01980252875E11d)).divide(1.99316789632E11d);
        this.d5 = (T) ((RealFieldElement) r9.multiply(-1.453857185E9d)).divide(8.22651844E8d);
        this.d6 = (T) ((RealFieldElement) r9.multiply(6.9997945E7d)).divide(2.9380423E7d);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected DormandPrince54FieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new DormandPrince54FieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r22, T r23, T r24, T r25, T r26) {
        RealFieldElement r3 = (RealFieldElement) r23.getField().getOne();
        RealFieldElement r4 = (RealFieldElement) r3.subtract(r24);
        RealFieldElement r6 = (RealFieldElement) r24.multiply(2);
        RealFieldElement r5 = (RealFieldElement) r3.subtract(r6);
        RealFieldElement r7 = (RealFieldElement) r24.multiply(((RealFieldElement) r24.multiply(-3)).add(2.0d));
        RealFieldElement r8 = (RealFieldElement) r6.multiply(((RealFieldElement) r24.multiply(r6.subtract(3.0d))).add(1.0d));
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        RealFieldElement r2 = (RealFieldElement) r26.negate();
        RealFieldElement r9 = (RealFieldElement) r26.multiply(r24);
        RealFieldElement r1 = (RealFieldElement) r9.multiply(r24);
        RealFieldElement r10 = (RealFieldElement) r1.multiply(r4);
        RealFieldElement r11 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(this.a70)).subtract(r9.multiply(this.a70.subtract(1.0d)))).add(r1.multiply(((RealFieldElement) this.a70.multiply(2)).subtract(1.0d)))).add(r10.multiply(this.d0));
        RealFieldElement r12 = (RealFieldElement) r23.getField().getZero();
        RealFieldElement r13 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(this.a72)).subtract(r9.multiply(this.a72))).add(r1.multiply(this.a72.multiply(2)))).add(r10.multiply(this.d2));
        RealFieldElement r14 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(this.a73)).subtract(r9.multiply(this.a73))).add(r1.multiply(this.a73.multiply(2)))).add(r10.multiply(this.d3));
        RealFieldElement r15 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(this.a74)).subtract(r9.multiply(this.a74))).add(r1.multiply(this.a74.multiply(2)))).add(r10.multiply(this.d4));
        RealFieldElement r16 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r2.multiply(this.a75)).subtract(r9.multiply(this.a75))).add(r1.multiply(this.a75.multiply(2)))).add(r10.multiply(this.d5));
        RealFieldElement r17 = (RealFieldElement) ((RealFieldElement) r10.multiply(this.d6)).subtract(r1);
        T r18 = this.a70;
        RealFieldElement r19 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r18.subtract(r5.multiply(r18.subtract(1.0d)))).add(r7.multiply(((RealFieldElement) this.a70.multiply(2)).subtract(1.0d)))).add(r8.multiply(this.d0));
        RealFieldElement r20 = (RealFieldElement) r23.getField().getZero();
        T r110 = this.a72;
        RealFieldElement r111 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r110.subtract(r5.multiply(r110))).add(r7.multiply(this.a72.multiply(2)))).add(r8.multiply(this.d2));
        T r112 = this.a73;
        RealFieldElement r113 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r112.subtract(r5.multiply(r112))).add(r7.multiply(this.a73.multiply(2)))).add(r8.multiply(this.d3));
        T r114 = this.a74;
        RealFieldElement r115 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r114.subtract(r5.multiply(r114))).add(r7.multiply(this.a74.multiply(2)))).add(r8.multiply(this.d4));
        T r116 = this.a75;
        RealFieldElement r21 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r116.subtract(r5.multiply(r116))).add(r7.multiply(this.a75.multiply(2)))).add(r8.multiply(this.d5));
        RealFieldElement r27 = (RealFieldElement) ((RealFieldElement) r8.multiply(this.d6)).subtract(r7);
        T[] r28 = currentStateLinearCombination(new RealFieldElement[]{r11, r12, r13, r14, r15, r16, r17});
        T[] r0 = derivativeLinearCombination(new RealFieldElement[]{r19, r20, r111, r113, r115, r21, r27});
    L9:
        return new FieldODEStateAndDerivative(r23, r28, r0);
    L5:
        if (r24.getReal() > 0.5d) goto L7;
        RealFieldElement r29 = (RealFieldElement) r25.multiply(r4);
        RealFieldElement r30 = (RealFieldElement) r29.multiply(r24);
        RealFieldElement r31 = (RealFieldElement) r30.multiply(r4);
        RealFieldElement r117 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(this.a70)).subtract(r29.multiply(this.a70.subtract(1.0d)))).add(r30.multiply(((RealFieldElement) this.a70.multiply(2)).subtract(1.0d)))).add(r31.multiply(this.d0));
        RealFieldElement r118 = (RealFieldElement) r23.getField().getZero();
        RealFieldElement r119 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(this.a72)).subtract(r29.multiply(this.a72))).add(r30.multiply(this.a72.multiply(2)))).add(r31.multiply(this.d2));
        RealFieldElement r120 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(this.a73)).subtract(r29.multiply(this.a73))).add(r30.multiply(this.a73.multiply(2)))).add(r31.multiply(this.d3));
        RealFieldElement r32 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(this.a74)).subtract(r29.multiply(this.a74))).add(r30.multiply(this.a74.multiply(2)))).add(r31.multiply(this.d4));
        RealFieldElement r33 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(this.a75)).subtract(r29.multiply(this.a75))).add(r30.multiply(this.a75.multiply(2)))).add(r31.multiply(this.d5));
        RealFieldElement r34 = (RealFieldElement) ((RealFieldElement) r31.multiply(this.d6)).subtract(r30);
        T r35 = this.a70;
        RealFieldElement r36 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r35.subtract(r5.multiply(r35.subtract(1.0d)))).add(r7.multiply(((RealFieldElement) this.a70.multiply(2)).subtract(1.0d)))).add(r8.multiply(this.d0));
        RealFieldElement r37 = (RealFieldElement) r23.getField().getZero();
        T r121 = this.a72;
        RealFieldElement r122 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r121.subtract(r5.multiply(r121))).add(r7.multiply(this.a72.multiply(2)))).add(r8.multiply(this.d2));
        T r123 = this.a73;
        RealFieldElement r124 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r123.subtract(r5.multiply(r123))).add(r7.multiply(this.a73.multiply(2)))).add(r8.multiply(this.d3));
        T r125 = this.a74;
        RealFieldElement r126 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r125.subtract(r5.multiply(r125))).add(r7.multiply(this.a74.multiply(2)))).add(r8.multiply(this.d4));
        T r127 = this.a75;
        RealFieldElement r38 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r127.subtract(r5.multiply(r127))).add(r7.multiply(this.a75.multiply(2)))).add(r8.multiply(this.d5));
        RealFieldElement r39 = (RealFieldElement) ((RealFieldElement) r8.multiply(this.d6)).subtract(r7);
        r28 = previousStateLinearCombination(new RealFieldElement[]{r117, r118, r119, r120, r32, r33, r34});
        r0 = derivativeLinearCombination(new RealFieldElement[]{r36, r37, r122, r124, r126, r38, r39});
        goto L9
    }
}
