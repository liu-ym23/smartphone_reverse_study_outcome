package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class EulerFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public EulerFieldIntegrator(Field<T> r2, T r3) {
        super(r2, "Euler", r3);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        return (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 0));
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        return (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 0, 0));
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 1));
        r0[0] = getField().getOne();
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected EulerFieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new EulerFieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }
}
