package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.Decimal64;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class EmbeddedRungeKuttaFieldIntegrator<T extends RealFieldElement<T>> extends AdaptiveStepsizeFieldIntegrator<T> implements FieldButcherArrayProvider<T> {
    private final T[][] a;
    private final T[] b;
    private final T[] c;
    private final T exp;
    private final int fsal;
    private T maxGrowth;
    private T minReduction;
    private T safety;

    protected abstract RungeKuttaFieldStepInterpolator<T> createInterpolator(boolean r1, T[][] r2, FieldODEStateAndDerivative<T> r3, FieldODEStateAndDerivative<T> r4, FieldEquationsMapper<T> r5);

    protected abstract T estimateError(T[][] r1, T[] r2, T[] r3, T r4);

    public abstract int getOrder();

    protected EmbeddedRungeKuttaFieldIntegrator(Field<T> r13, String r14, int r15, double r16, double r18, double r20, double r22) {
        super(r13, r14, r16, r18, r20, r22);
        this.fsal = r15;
        this.c = getC();
        this.a = getA();
        this.b = getB();
        this.exp = (T) r13.getOne().divide(-getOrder());
        setSafety((RealFieldElement) r13.getZero().add(0.9d));
        setMinReduction((RealFieldElement) r13.getZero().add(0.2d));
        setMaxGrowth((RealFieldElement) r13.getZero().add(10.0d));
    }

    protected EmbeddedRungeKuttaFieldIntegrator(Field<T> r11, String r12, int r13, double r14, double r16, double[] r18, double[] r19) {
        super(r11, r12, r14, r16, r18, r19);
        this.fsal = r13;
        this.c = getC();
        this.a = getA();
        this.b = getB();
        this.exp = (T) r11.getOne().divide(-getOrder());
        setSafety((RealFieldElement) r11.getZero().add(0.9d));
        setMinReduction((RealFieldElement) r11.getZero().add(0.2d));
        setMaxGrowth((RealFieldElement) r11.getZero().add(10.0d));
    }

    protected T fraction(int r1, int r2) {
        return (T) ((RealFieldElement) getField().getOne().multiply(r1)).divide(r2);
    }

    protected T fraction(double r1, double r3) {
        return (T) ((RealFieldElement) getField().getOne().multiply(r1)).divide(r3);
    }

    public T getSafety() {
        return this.safety;
    }

    public void setSafety(T r1) {
        this.safety = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> r23, FieldODEState<T> r24, T r25) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException {
        sanityChecks(r24, r25);
        RealFieldElement r1 = r24.getTime();
        RealFieldElement[] r8 = r23.getMapper().mapState(r24);
        setStepStart(initIntegration(r23, r1, r8, r25));
        double r10 = 0.0d;
        if (((RealFieldElement) r25.subtract(r24.getTime())).getReal() <= 0.0d) goto L5;
        boolean r14 = true;
    L6:
        int r15 = this.c.length + 1;
        RealFieldElement[][] r5 = (RealFieldElement[][]) MathArrays.buildArray(getField(), r15, -1);
        RealFieldElement[] r4 = (RealFieldElement[]) MathArrays.buildArray(getField(), r8.length);
        T r0 = getField().getZero();
        setIsLastStep(false);
        RealFieldElement[] r2 = r8;
        boolean r3 = true;
    L7:
        RealFieldElement r6 = (RealFieldElement) getField().getZero().add(10.0d);
        T r12 = r0;
        RealFieldElement[] r13 = r2;
        boolean r17 = r3;
    L9:
        if (((RealFieldElement) r6.subtract(1.0d)).getReal() < r10) goto L53;
        r13 = r23.getMapper().mapState(getStepStart());
        r5[0] = r23.getMapper().mapDerivative(getStepStart());
        if (r17 == false) goto L23;
        RealFieldElement[] r7 = (RealFieldElement[]) MathArrays.buildArray(getField(), this.mainSetDimension);
        if (this.vecAbsoluteTolerance != null) goto L18;
        int r9 = 0;
    L16:
        if (r9 >= r7.length) goto L22;
        r7[r9] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r13[r9].abs()).multiply(this.scalRelativeTolerance)).add(this.scalAbsoluteTolerance);
        r9 = r9 + 1;
    L22:
        RealFieldElement[] r11 = r4;
        r17 = false;
        r12 = initializeStep(r14, getOrder(), r7, getStepStart(), r23.getMapper());
    L24:
        setStepSize(r12);
        if (r14 == false) goto L30;
        if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(getStepSize())).subtract(r25)).getReal() < 0.0d) goto L32;
        setStepSize((RealFieldElement) r25.subtract(getStepStart().getTime()));
    L32:
        int r16 = 1;
    L33:
        if (r16 >= r15) goto L42;
        int r18 = 0;
    L36:
        if (r18 >= r8.length) goto L41;
        Decimal64 r19 = r5[0][r18];
        int r20 = r16 - 1;
        RealFieldElement r21 = (RealFieldElement) r19.multiply(this.a[r20][0]);
        int r22 = 1;
    L38:
        if (r22 >= r16) goto L40;
        r21 = (RealFieldElement) r21.add(r5[r22][r18].multiply(this.a[r20][r22]));
        r22 = r22 + 1;
        goto L38
    L40:
        r11[r18] = (RealFieldElement) r13[r18].add(getStepSize().multiply(r21));
        r18 = r18 + 1;
        goto L36
    L41:
        r5[r16] = computeDerivatives((RealFieldElement) getStepStart().getTime().add(getStepSize().multiply(this.c[r16 - 1])), r11);
        r16 = r16 + 1;
        goto L33
    L42:
        int r26 = 0;
    L44:
        if (r26 >= r8.length) goto L49;
        RealFieldElement r27 = (RealFieldElement) r5[0][r26].multiply(this.b[0]);
        int r28 = 1;
    L46:
        if (r28 >= r15) goto L48;
        r27 = (RealFieldElement) r27.add(r5[r28][r26].multiply(this.b[r28]));
        r28 = r28 + 1;
        goto L46
    L48:
        r11[r26] = (RealFieldElement) r13[r26].add(getStepSize().multiply(r27));
        r26 = r26 + 1;
        goto L44
    L49:
        r6 = estimateError(r5, r13, r11, getStepSize());
        if (((RealFieldElement) r6.subtract(1.0d)).getReal() < 0.0d) goto L52;
        r12 = filterStep((RealFieldElement) getStepSize().multiply(MathUtils.min(this.maxGrowth, MathUtils.max(this.minReduction, (RealFieldElement) this.safety.multiply(r6.pow(this.exp))))), r14, false);
    L52:
        r5 = r5;
        r4 = r11;
        r10 = 0.0d;
        goto L9
    L30:
        if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(getStepSize())).subtract(r25)).getReal() > 0.0d) goto L32;
        setStepSize((RealFieldElement) r25.subtract(getStepStart().getTime()));
        goto L32
    L18:
        int r29 = 0;
    L20:
        if (r29 >= r7.length) goto L22;
        r7[r29] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) r13[r29].abs()).multiply(this.vecRelativeTolerance[r29])).add(this.vecAbsoluteTolerance[r29]);
        r29 = r29 + 1;
        goto L20
    L23:
        r11 = r4;
        goto L24
    L53:
        RealFieldElement[] r110 = r4;
        RealFieldElement[][] r111 = r5;
        RealFieldElement r30 = (RealFieldElement) getStepStart().getTime().add(getStepSize());
        int r31 = this.fsal;
        if (r31 < 0) goto L56;
        RealFieldElement[] r32 = r111[r31];
    L57:
        FieldODEStateAndDerivative<T> r33 = new FieldODEStateAndDerivative(r30, r110, r32);
        System.arraycopy(r110, 0, r13, 0, r8.length);
        RealFieldElement r34 = r6;
        setStepStart(acceptStep(createInterpolator(r14, r111, getStepStart(), r33, r23.getMapper()), r25));
        if (isLastStep() == true) goto L79;
        RealFieldElement r35 = (RealFieldElement) getStepSize().multiply(MathUtils.min(this.maxGrowth, MathUtils.max(this.minReduction, (RealFieldElement) this.safety.multiply(r34.pow(this.exp)))));
        RealFieldElement r36 = (RealFieldElement) getStepStart().getTime().add(r35);
        if (r14 == false) goto L65;
        if (((RealFieldElement) r36.subtract(r25)).getReal() >= 0.0d) goto L66;
    L67:
        boolean r37 = false;
    L68:
        r0 = filterStep(r35, r14, r37);
        RealFieldElement r38 = (RealFieldElement) getStepStart().getTime().add(r0);
        if (r14 == false) goto L73;
        double r39 = 0.0d;
        if (((RealFieldElement) r38.subtract(r25)).getReal() >= 0.0d) goto L75;
    L76:
        boolean r40 = false;
    L77:
        if (r40 == false) goto L81;
        r0 = (T) r25.subtract(getStepStart().getTime());
    L81:
        if (isLastStep() == true) goto L82;
        r5 = r111;
        r2 = r13;
        r3 = r17;
        r4 = r110;
        r10 = r39;
        goto L7
    L82:
        FieldODEStateAndDerivative<T> r41 = getStepStart();
        resetInternalState();
        return r41;
    L75:
        r40 = true;
        goto L77
    L73:
        r39 = 0.0d;
        if (((RealFieldElement) r38.subtract(r25)).getReal() > 0.0d) goto L76;
    L66:
        r37 = true;
        goto L68
    L65:
        if (((RealFieldElement) r36.subtract(r25)).getReal() > 0.0d) goto L67;
    L79:
        r39 = 0.0d;
        r0 = r12;
        goto L81
    L56:
        r32 = computeDerivatives(r30, r110);
        goto L57
    L5:
        r14 = false;
        goto L6
    }

    public T getMinReduction() {
        return this.minReduction;
    }

    public void setMinReduction(T r1) {
        this.minReduction = r1;
    }

    public T getMaxGrowth() {
        return this.maxGrowth;
    }

    public void setMaxGrowth(T r1) {
        this.maxGrowth = r1;
    }
}
