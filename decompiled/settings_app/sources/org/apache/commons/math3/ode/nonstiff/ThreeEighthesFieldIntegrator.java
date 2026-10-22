package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class ThreeEighthesFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public ThreeEighthesFieldIntegrator(Field<T> r2, T r3) {
        super(r2, "3/8", r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 3));
        T r1 = fraction(1, 3);
        r0[0] = r1;
        r0[1] = (RealFieldElement) r1.add(r1);
        r0[2] = getField().getOne();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        T[][] r0 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 3, -1));
        int r3 = 0;
    L4:
        if (r3 >= r0.length) goto L6;
        int r5 = r3 + 1;
        r0[r3] = (RealFieldElement[]) MathArrays.buildArray(getField(), r5);
        r3 = r5;
        goto L4
    L6:
        r0[0][0] = fraction(1, 3);
        r0[1][0] = (RealFieldElement) r0[0][0].negate();
        r0[1][1] = getField().getOne();
        r0[2][0] = getField().getOne();
        r0[2][1] = (RealFieldElement) getField().getOne().negate();
        r0[2][2] = getField().getOne();
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 4));
        r0[0] = fraction(1, 8);
        T r5 = fraction(3, 8);
        r0[1] = r5;
        r0[2] = r5;
        r0[3] = r0[0];
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected ThreeEighthesFieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new ThreeEighthesFieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }
}
