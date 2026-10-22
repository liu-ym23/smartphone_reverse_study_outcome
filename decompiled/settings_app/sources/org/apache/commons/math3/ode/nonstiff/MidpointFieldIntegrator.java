package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class MidpointFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public MidpointFieldIntegrator(Field<T> r2, T r3) {
        super(r2, "midpoint", r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 1));
        r0[0] = (RealFieldElement) getField().getOne().multiply(0.5d);
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        T[][] r0 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 1, 1));
        r0[0][0] = fraction(1, 2);
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 2));
        r0[0] = getField().getZero();
        r0[1] = getField().getOne();
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected MidpointFieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new MidpointFieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }
}
