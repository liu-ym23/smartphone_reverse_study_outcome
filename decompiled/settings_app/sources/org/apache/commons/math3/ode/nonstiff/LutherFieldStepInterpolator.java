package org.apache.commons.math3.ode.nonstiff;

import android.icu.lang.UCharacter;
import com.ttnet.org.chromium.net.NetError;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: loaded from: classes6.dex */
class LutherFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    private final T c5a;
    private final T c5b;
    private final T c5c;
    private final T c5d;
    private final T c6a;
    private final T c6b;
    private final T c6c;
    private final T c6d;
    private final T d5a;
    private final T d5b;
    private final T d5c;
    private final T d6a;
    private final T d6b;
    private final T d6c;

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator create(Field r1, boolean r2, RealFieldElement[][] r3, FieldODEStateAndDerivative r4, FieldODEStateAndDerivative r5, FieldODEStateAndDerivative r6, FieldODEStateAndDerivative r7, FieldEquationsMapper r8) {
        return create(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    LutherFieldStepInterpolator(Field<T> r5, boolean r6, T[][] r7, FieldODEStateAndDerivative<T> r8, FieldODEStateAndDerivative<T> r9, FieldODEStateAndDerivative<T> r10, FieldODEStateAndDerivative<T> r11, FieldEquationsMapper<T> r12) {
        super(r5, r6, r7, r8, r9, r10, r11, r12);
        RealFieldElement r13 = (RealFieldElement) ((RealFieldElement) r5.getZero().add(21.0d)).sqrt();
        this.c5a = (T) ((RealFieldElement) r13.multiply(-49)).add(-49.0d);
        this.c5b = (T) ((RealFieldElement) r13.multiply(UCharacter.UnicodeBlock.MAKASAR_ID)).add(392.0d);
        this.c5c = (T) ((RealFieldElement) r13.multiply(NetError.ERR_RESPONSE_HEADERS_TRUNCATED)).add(-637.0d);
        this.c5d = (T) ((RealFieldElement) r13.multiply(343)).add(833.0d);
        this.c6a = (T) ((RealFieldElement) r13.multiply(49)).add(-49.0d);
        this.c6b = (T) ((RealFieldElement) r13.multiply(-287)).add(392.0d);
        this.c6c = (T) ((RealFieldElement) r13.multiply(357)).add(-637.0d);
        this.c6d = (T) ((RealFieldElement) r13.multiply(NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT)).add(833.0d);
        this.d5a = (T) ((RealFieldElement) r13.multiply(49)).add(49.0d);
        this.d5b = (T) ((RealFieldElement) r13.multiply(-847)).add(-1372.0d);
        this.d5c = (T) ((RealFieldElement) r13.multiply(1029)).add(2254.0d);
        this.d6a = (T) ((RealFieldElement) r13.multiply(-49)).add(49.0d);
        this.d6b = (T) ((RealFieldElement) r13.multiply(847)).add(-1372.0d);
        this.d6c = (T) ((RealFieldElement) r13.multiply(-1029)).add(2254.0d);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    protected LutherFieldStepInterpolator<T> create(Field<T> r11, boolean r12, T[][] r13, FieldODEStateAndDerivative<T> r14, FieldODEStateAndDerivative<T> r15, FieldODEStateAndDerivative<T> r16, FieldODEStateAndDerivative<T> r17, FieldEquationsMapper<T> r18) {
        return new LutherFieldStepInterpolator(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    protected FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> r29, T r30, T r31, T r32, T r33) {
        RealFieldElement r4 = (RealFieldElement) ((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(21)).add(-47.0d))).add(36.0d))).add(-10.8d))).add(1.0d);
        RealFieldElement r7 = (RealFieldElement) r30.getField().getZero();
        RealFieldElement r8 = (RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(112)).add(-202.66666666666666d))).add(106.66666666666667d))).add(-13.866666666666667d));
        RealFieldElement r9 = (RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(-113.4d)).add(194.4d))).add(-97.2d))).add(12.96d));
        RealFieldElement r10 = (RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(this.c5a.divide(5.0d))).add(this.c5b.divide(15.0d)))).add(this.c5c.divide(30.0d)))).add(this.c5d.divide(150.0d)));
        RealFieldElement r5 = (RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(this.c6a.divide(5.0d))).add(this.c6b.divide(15.0d)))).add(this.c6c.divide(30.0d)))).add(this.c6d.divide(150.0d)));
        RealFieldElement r6 = (RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(3.0d)).add(-3.0d))).add(0.6d));
        if (getGlobalPreviousState() != null) goto L5;
    L7:
        T[] r1 = currentStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r33.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(-4.2d)).add(7.55d))).add(-4.45d))).add(0.95d))).add(-0.05d)), (RealFieldElement) r30.getField().getZero(), (RealFieldElement) r33.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(-22.4d)).add(28.266666666666666d))).add(-7.288888888888889d))).add(-0.35555555555555557d))).add(-0.35555555555555557d)), (RealFieldElement) r33.multiply(r31.multiply(r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(22.68d)).add(-25.92d))).add(6.48d)))), (RealFieldElement) r33.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(this.d5a.divide(25.0d))).add(this.d5b.divide(300.0d)))).add(this.d5c.divide(900.0d)))).add(-0.2722222222222222d))).add(-0.2722222222222222d)), (RealFieldElement) r33.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(this.d6a.divide(25.0d))).add(this.d6b.divide(300.0d)))).add(this.d6c.divide(900.0d)))).add(-0.2722222222222222d))).add(-0.2722222222222222d)), (RealFieldElement) r33.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(-0.75d)).add(0.25d))).add(-0.05d))).add(-0.05d))});
        T[] r0 = derivativeLinearCombination(new RealFieldElement[]{r4, r7, r8, r9, r10, r5, r6});
    L9:
        return new FieldODEStateAndDerivative(r30, r1, r0);
    L5:
        if (r31.getReal() > 0.5d) goto L7;
        r1 = previousStateLinearCombination(new RealFieldElement[]{(RealFieldElement) r32.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(4.2d)).add(-11.75d))).add(12.0d))).add(-5.4d))).add(1.0d)), (RealFieldElement) r30.getField().getZero(), (RealFieldElement) r32.multiply(r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(22.4d)).add(-50.666666666666664d))).add(35.55555555555556d))).add(-6.933333333333334d))), (RealFieldElement) r32.multiply(r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(-22.68d)).add(48.6d))).add(-32.4d))).add(6.48d))), (RealFieldElement) r32.multiply(r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(this.c5a.divide(25.0d))).add(this.c5b.divide(60.0d)))).add(this.c5c.divide(90.0d)))).add(this.c5d.divide(300.0d)))), (RealFieldElement) r32.multiply(r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(this.c6a.divide(25.0d))).add(this.c6b.divide(60.0d)))).add(this.c6c.divide(90.0d)))).add(this.c6d.divide(300.0d)))), (RealFieldElement) r32.multiply(r31.multiply(((RealFieldElement) r31.multiply(((RealFieldElement) r31.multiply(0.75d)).add(-1.0d))).add(0.3d)))});
        r0 = derivativeLinearCombination(new RealFieldElement[]{r4, r7, r8, r9, r10, r5, r6});
        goto L9
    }
}
