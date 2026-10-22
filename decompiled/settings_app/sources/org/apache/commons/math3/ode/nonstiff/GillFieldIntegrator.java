package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class GillFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public GillFieldIntegrator(Field<T> r2, T r3) {
        super(r2, "Gill", r3);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 3));
        T r3 = fraction(1, 2);
        r0[0] = r3;
        r0[1] = r3;
        r0[2] = getField().getOne();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        RealFieldElement r0 = (RealFieldElement) ((RealFieldElement) getField().getZero().add(2.0d)).sqrt();
        T[][] r3 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 3, -1));
        int r5 = 0;
    L4:
        if (r5 >= r3.length) goto L6;
        int r7 = r5 + 1;
        r3[r5] = (RealFieldElement[]) MathArrays.buildArray(getField(), r7);
        r5 = r7;
        goto L4
    L6:
        r3[0][0] = fraction(1, 2);
        r3[1][0] = (RealFieldElement) ((RealFieldElement) r0.subtract(1.0d)).multiply(0.5d);
        r3[1][1] = (RealFieldElement) ((RealFieldElement) r0.subtract(2.0d)).multiply(-0.5d);
        r3[2][0] = getField().getZero();
        r3[2][1] = (RealFieldElement) r0.multiply(-0.5d);
        r3[2][2] = (RealFieldElement) ((RealFieldElement) r0.add(2.0d)).multiply(0.5d);
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        RealFieldElement r0 = (RealFieldElement) ((RealFieldElement) getField().getZero().add(2.0d)).sqrt();
        T[] r3 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 4));
        r3[0] = fraction(1, 6);
        r3[1] = (RealFieldElement) ((RealFieldElement) r0.subtract(2.0d)).divide(-6.0d);
        r3[2] = (RealFieldElement) ((RealFieldElement) r0.add(2.0d)).divide(6.0d);
        r3[3] = r3[0];
        return r3;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    protected GillFieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new GillFieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }
}
