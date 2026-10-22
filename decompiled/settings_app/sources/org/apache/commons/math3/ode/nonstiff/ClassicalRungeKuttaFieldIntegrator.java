package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class ClassicalRungeKuttaFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public ClassicalRungeKuttaFieldIntegrator(Field<T> r2, T r3) {
        super(r2, "classical Runge-Kutta", r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 3));
        RealFieldElement r1 = (RealFieldElement) getField().getOne().multiply(0.5d);
        r0[0] = r1;
        r0[1] = r1;
        r0[2] = getField().getOne();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        T[][] r0 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 3, -1));
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L6;
        int r4 = r2 + 1;
        r0[r2] = (RealFieldElement[]) MathArrays.buildArray(getField(), r4);
        r2 = r4;
        goto L4
    L6:
        r0[0][0] = fraction(1, 2);
        r0[1][0] = getField().getZero();
        r0[1][1] = r0[0][0];
        r0[2][0] = getField().getZero();
        r0[2][1] = getField().getZero();
        r0[2][2] = getField().getOne();
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 4));
        r0[0] = fraction(1, 6);
        T r4 = fraction(1, 3);
        r0[1] = r4;
        r0[2] = r4;
        r0[3] = r0[0];
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected ClassicalRungeKuttaFieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new ClassicalRungeKuttaFieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }
}
