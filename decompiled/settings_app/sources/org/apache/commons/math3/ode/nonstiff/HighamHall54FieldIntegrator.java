package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class HighamHall54FieldIntegrator<T extends RealFieldElement<T>> extends EmbeddedRungeKuttaFieldIntegrator<T> {
    private static final String METHOD_NAME = "Higham-Hall 5(4)";
    private final T[] e;

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    public int getOrder() {
        return 5;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected /* bridge */ /* synthetic */ RungeKuttaFieldStepInterpolator createInterpolator(boolean r1, RealFieldElement[][] r2, FieldODEStateAndDerivative r3, FieldODEStateAndDerivative r4, FieldEquationsMapper r5) {
        return createInterpolator(r1, r2, r3, r4, r5);
    }

    public HighamHall54FieldIntegrator(Field<T> r14, double r15, double r17, double r19, double r21) {
        super(r14, METHOD_NAME, -1, r15, r17, r19, r21);
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r14, 7));
        this.e = r0;
        r0[0] = fraction(-1, 20);
        r0[1] = r14.getZero();
        r0[2] = fraction(81, 160);
        r0[3] = fraction(-6, 5);
        r0[4] = fraction(25, 32);
        r0[5] = fraction(1, 16);
        r0[6] = fraction(-1, 10);
    }

    public HighamHall54FieldIntegrator(Field<T> r12, double r13, double r15, double[] r17, double[] r18) {
        super(r12, METHOD_NAME, -1, r13, r15, r17, r18);
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r12, 7));
        this.e = r0;
        r0[0] = fraction(-1, 20);
        r0[1] = r12.getZero();
        r0[2] = fraction(81, 160);
        r0[3] = fraction(-6, 5);
        r0[4] = fraction(25, 32);
        r0[5] = fraction(1, 16);
        r0[6] = fraction(-1, 10);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 6));
        r0[0] = fraction(2, 9);
        r0[1] = fraction(1, 3);
        r0[2] = fraction(1, 2);
        r0[3] = fraction(3, 5);
        r0[4] = getField().getOne();
        r0[5] = getField().getOne();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        T[][] r0 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 6, -1));
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L6;
        int r4 = r2 + 1;
        r0[r2] = (RealFieldElement[]) MathArrays.buildArray(getField(), r4);
        r2 = r4;
        goto L4
    L6:
        r0[0][0] = fraction(2, 9);
        r0[1][0] = fraction(1, 12);
        r0[1][1] = fraction(1, 4);
        r0[2][0] = fraction(1, 8);
        r0[2][1] = getField().getZero();
        r0[2][2] = fraction(3, 8);
        r0[3][0] = fraction(91, 500);
        r0[3][1] = fraction(-27, 100);
        r0[3][2] = fraction(78, 125);
        r0[3][3] = fraction(8, 125);
        r0[4][0] = fraction(-11, 20);
        r0[4][1] = fraction(27, 20);
        r0[4][2] = fraction(12, 5);
        r0[4][3] = fraction(-36, 5);
        r0[4][4] = fraction(5, 1);
        r0[5][0] = fraction(1, 12);
        r0[5][1] = getField().getZero();
        r0[5][2] = fraction(27, 32);
        r0[5][3] = fraction(-4, 3);
        r0[5][4] = fraction(125, 96);
        r0[5][5] = fraction(5, 48);
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] r0 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 7));
        r0[0] = fraction(1, 12);
        r0[1] = getField().getZero();
        r0[2] = fraction(27, 32);
        r0[3] = fraction(-4, 3);
        r0[4] = fraction(125, 96);
        r0[5] = fraction(5, 48);
        r0[6] = getField().getZero();
        return r0;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected HighamHall54FieldStepInterpolator<T> createInterpolator(boolean r11, T[][] r12, FieldODEStateAndDerivative<T> r13, FieldODEStateAndDerivative<T> r14, FieldEquationsMapper<T> r15) {
        return new HighamHall54FieldStepInterpolator(getField(), r11, r12, r13, r14, r13, r14, r15);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    protected T estimateError(T[][] r8, T[] r9, T[] r10, T r11) {
        T r0 = getField().getZero();
        int r2 = 0;
    L4:
        if (r2 >= this.mainSetDimension) goto L15;
        RealFieldElement r3 = (RealFieldElement) r8[0][r2].multiply(this.e[0]);
        int r4 = 1;
    L6:
        T[] r5 = this.e;
        if (r4 >= r5.length) goto L9;
        r3 = (RealFieldElement) r3.add(r8[r4][r2].multiply(r5[r4]));
        r4 = r4 + 1;
        goto L6
    L9:
        RealFieldElement r6 = MathUtils.max((RealFieldElement) r9[r2].abs(), (RealFieldElement) r10[r2].abs());
        if (this.vecAbsoluteTolerance != null) goto L12;
        RealFieldElement r7 = (RealFieldElement) r6.multiply(this.scalRelativeTolerance);
        double r12 = this.scalAbsoluteTolerance;
    L13:
        RealFieldElement r13 = (RealFieldElement) ((RealFieldElement) r11.multiply(r3)).divide((RealFieldElement) r7.add(r12));
        r0 = (T) r0.add(r13.multiply(r13));
        r2 = r2 + 1;
        goto L4
    L12:
        r7 = (RealFieldElement) r6.multiply(this.vecRelativeTolerance[r2]);
        r12 = this.vecAbsoluteTolerance[r2];
        goto L13
    L15:
        return (T) ((RealFieldElement) r0.divide(this.mainSetDimension)).sqrt();
    }
}
