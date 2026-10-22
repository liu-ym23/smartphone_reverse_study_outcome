package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.AbstractFieldIntegrator;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.FirstOrderFieldDifferentialEquations;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RungeKuttaFieldIntegrator<T extends RealFieldElement<T>> extends AbstractFieldIntegrator<T> implements FieldButcherArrayProvider<T> {
    private final T[][] a;
    private final T[] b;
    private final T[] c;
    private final T step;

    protected abstract RungeKuttaFieldStepInterpolator<T> createInterpolator(boolean r1, T[][] r2, FieldODEStateAndDerivative<T> r3, FieldODEStateAndDerivative<T> r4, FieldEquationsMapper<T> r5);

    protected RungeKuttaFieldIntegrator(Field<T> r1, String r2, T r3) {
        super(r1, r2);
        this.c = getC();
        this.a = getA();
        this.b = getB();
        this.step = (T) r3.abs();
    }

    protected T fraction(int r3, int r4) {
        return (T) ((RealFieldElement) getField().getZero().add(r3)).divide(r4);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> r20, FieldODEState<T> r21, T r22) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r21, r22);
        RealFieldElement r1 = r21.getTime();
        RealFieldElement[] r8 = r20.getMapper().mapState(r21);
        setStepStart(initIntegration(r20, r1, r8, r22));
        int r13 = 1;
        if (((RealFieldElement) r22.subtract(r21.getTime())).getReal() <= 0.0d) goto L5;
        boolean r14 = true;
    L6:
        int r15 = this.c.length + 1;
        RealFieldElement[][] r16 = (RealFieldElement[][]) MathArrays.buildArray(getField(), r15, -1);
        RealFieldElement[] r5 = (RealFieldElement[]) MathArrays.buildArray(getField(), r8.length);
        if (r14 == false) goto L13;
        if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(this.step)).subtract(r22)).getReal() < 0.0d) goto L11;
        setStepSize((RealFieldElement) r22.subtract(getStepStart().getTime()));
    L16:
        setIsLastStep(false);
    L17:
        RealFieldElement[] r0 = r20.getMapper().mapState(getStepStart());
        r16[0] = r20.getMapper().mapDerivative(getStepStart());
        int r2 = r13;
    L18:
        if (r2 >= r15) goto L27;
        int r3 = 0;
    L21:
        if (r3 >= r8.length) goto L26;
        int r17 = r2 - 1;
        RealFieldElement r4 = (RealFieldElement) r16[0][r3].multiply(this.a[r17][0]);
        int r6 = r13;
    L23:
        if (r6 >= r2) goto L25;
        r4 = (RealFieldElement) r4.add(r16[r6][r3].multiply(this.a[r17][r6]));
        r6 = r6 + 1;
        goto L23
    L25:
        r5[r3] = (RealFieldElement) r0[r3].add(getStepSize().multiply(r4));
        r3 = r3 + 1;
        r13 = 1;
        goto L21
    L26:
        r16[r2] = computeDerivatives((RealFieldElement) getStepStart().getTime().add(getStepSize().multiply(this.c[r2 - 1])), r5);
        r2 = r2 + 1;
        r13 = 1;
        goto L18
    L27:
        int r7 = 0;
    L29:
        if (r7 >= r8.length) goto L34;
        RealFieldElement r9 = (RealFieldElement) r16[0][r7].multiply(this.b[0]);
        int r10 = 1;
    L31:
        if (r10 >= r15) goto L33;
        r9 = (RealFieldElement) r9.add(r16[r10][r7].multiply(this.b[r10]));
        r10 = r10 + 1;
        goto L31
    L33:
        r5[r7] = (RealFieldElement) r0[r7].add(getStepSize().multiply(r9));
        r7 = r7 + 1;
        goto L29
    L34:
        RealFieldElement r11 = (RealFieldElement) getStepStart().getTime().add(getStepSize());
        FieldODEStateAndDerivative<T> r12 = new FieldODEStateAndDerivative(r11, r5, computeDerivatives(r11, r5));
        System.arraycopy(r5, 0, r0, 0, r8.length);
        RealFieldElement[] r18 = r5;
        setStepStart(acceptStep(createInterpolator(r14, r16, getStepStart(), r12, r20.getMapper()), r22));
        if (isLastStep() == true) goto L47;
        RealFieldElement r19 = (RealFieldElement) getStepStart().getTime().add(getStepSize());
        if (r14 == false) goto L41;
        long r23 = 0;
        if (((RealFieldElement) r19.subtract(r22)).getReal() >= 0.0d) goto L43;
    L44:
        boolean r24 = false;
    L45:
        if (r24 == false) goto L49;
        setStepSize((RealFieldElement) r22.subtract(getStepStart().getTime()));
    L49:
        if (isLastStep() == true) goto L50;
        r5 = r18;
        r13 = 1;
        goto L17
    L50:
        FieldODEStateAndDerivative<T> r25 = getStepStart();
        setStepStart(null);
        setStepSize(null);
        return r25;
    L43:
        r24 = true;
        goto L45
    L41:
        r23 = 0;
        if (((RealFieldElement) r19.subtract(r22)).getReal() > 0.0d) goto L44;
    L47:
        r23 = 0;
        goto L49
    L11:
        setStepSize(this.step);
        goto L16
    L13:
        if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().subtract(this.step)).subtract(r22)).getReal() > 0.0d) goto L15;
        setStepSize((RealFieldElement) r22.subtract(getStepStart().getTime()));
        goto L16
    L15:
        setStepSize((RealFieldElement) this.step.negate());
        goto L16
    L5:
        r14 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] singleStep(FirstOrderFieldDifferentialEquations<T> r18, T r19, T[] r20, T r21) {
        T[] r4 = (T[]) ((RealFieldElement[]) r20.clone());
        int r6 = 1;
        int r5 = this.c.length + 1;
        RealFieldElement[][] r7 = (RealFieldElement[][]) MathArrays.buildArray(getField(), r5, -1);
        RealFieldElement[] r8 = (RealFieldElement[]) r20.clone();
        RealFieldElement r9 = (RealFieldElement) r21.subtract(r19);
        int r11 = 0;
        r7[0] = r18.computeDerivatives(r19, r4);
        int r10 = 1;
    L3:
        if (r10 >= r5) goto L12;
        int r12 = r11;
    L6:
        if (r12 >= r20.length) goto L11;
        int r15 = r10 - 1;
        RealFieldElement r13 = (RealFieldElement) r7[r11][r12].multiply(this.a[r15][r11]);
        int r14 = r6;
    L8:
        if (r14 >= r10) goto L10;
        r13 = (RealFieldElement) r13.add(r7[r14][r12].multiply(this.a[r15][r14]));
        r14 = r14 + 1;
        goto L8
    L10:
        r8[r12] = (RealFieldElement) r4[r12].add(r9.multiply(r13));
        r12 = r12 + 1;
        r6 = 1;
        r11 = 0;
        goto L6
    L11:
        r7[r10] = r18.computeDerivatives((RealFieldElement) r19.add(r9.multiply(this.c[r10 - 1])), r8);
        r10 = r10 + 1;
        r6 = 1;
        r11 = 0;
        goto L3
    L12:
        int r1 = 0;
    L14:
        if (r1 >= r20.length) goto L19;
        RealFieldElement r16 = (RealFieldElement) r7[0][r1].multiply(this.b[0]);
        int r17 = 1;
    L16:
        if (r17 >= r5) goto L18;
        r16 = (RealFieldElement) r16.add(r7[r17][r1].multiply(this.b[r17]));
        r17 = r17 + 1;
        goto L16
    L18:
        r4[r1] = (RealFieldElement) r4[r1].add(r9.multiply(r16));
        r1 = r1 + 1;
        goto L14
    L19:
        return r4;
    }
}
