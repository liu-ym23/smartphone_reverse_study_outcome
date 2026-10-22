package org.apache.commons.math3.ode;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeFieldIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853FieldIntegrator;
import org.apache.commons.math3.ode.sampling.FieldStepHandler;
import org.apache.commons.math3.ode.sampling.FieldStepInterpolator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MultistepFieldIntegrator<T extends RealFieldElement<T>> extends AdaptiveStepsizeFieldIntegrator<T> {
    private double exp;
    private double maxGrowth;
    private double minReduction;
    private final int nSteps;
    protected Array2DRowFieldMatrix<T> nordsieck;
    private double safety;
    protected T[] scaled;
    private FirstOrderFieldIntegrator<T> starter;

    private class FieldNordsieckInitializer implements FieldStepHandler<T> {
        private int count;
        private final FieldEquationsMapper<T> mapper;
        private FieldODEStateAndDerivative<T> savedStart;
        private final T[] t;
        final /* synthetic */ MultistepFieldIntegrator this$0;
        private final T[][] y;
        private final T[][] yDot;

        @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
        public void init(FieldODEStateAndDerivative<T> r1, T r2) {
        }

        FieldNordsieckInitializer(MultistepFieldIntegrator r2, FieldEquationsMapper<T> r3, int r4) {
            this.this$0 = r2;
            this.mapper = r3;
            this.count = 0;
            this.t = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r2.getField(), r4));
            this.y = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(r2.getField(), r4, -1));
            this.yDot = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(r2.getField(), r4, -1));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
        public void handleStep(FieldStepInterpolator<T> r5, boolean r6) throws MaxCountExceededException {
            if (this.count != 0) goto L5;
            FieldODEStateAndDerivative<T> r7 = r5.getPreviousState();
            this.savedStart = r7;
            this.t[this.count] = r7.getTime();
            ((T[][]) this.y)[this.count] = this.mapper.mapState(r7);
            ((T[][]) this.yDot)[this.count] = this.mapper.mapDerivative(r7);
        L5:
            this.count++;
            FieldODEStateAndDerivative<T> r8 = r5.getCurrentState();
            this.t[this.count] = r8.getTime();
            ((T[][]) this.y)[this.count] = this.mapper.mapState(r8);
            ((T[][]) this.yDot)[this.count] = this.mapper.mapDerivative(r8);
            int r9 = this.count;
            T[] r10 = this.t;
            if (r9 != (r10.length - 1)) goto L13;
            this.this$0.setStepSize((RealFieldElement) ((RealFieldElement) r10[r10.length - 1].subtract(r10[0])).divide(this.t.length - 1));
            MultistepFieldIntegrator r11 = this.this$0;
            r11.scaled = (T[]) ((RealFieldElement[]) MathArrays.buildArray(r11.getField(), this.yDot[0].length));
            int r12 = 0;
        L9:
            if (r12 >= this.this$0.scaled.length) goto L11;
            ((T[]) this.this$0.scaled)[r12] = (RealFieldElement) this.yDot[0][r12].multiply(this.this$0.getStepSize());
            r12 = r12 + 1;
            goto L9
        L11:
            MultistepFieldIntegrator r13 = this.this$0;
            r13.nordsieck = r13.initializeHighOrderDerivatives(r13.getStepSize(), this.t, this.y, this.yDot);
            this.this$0.setStepStart(this.savedStart);
            throw new InitializationCompletedMarkerException();
        }
    }

    private static class InitializationCompletedMarkerException extends RuntimeException {
        private static final long serialVersionUID = -1914085471038046418L;

        InitializationCompletedMarkerException() {
            Throwable r1 = (Throwable) null;
            super(null);
        }
    }

    protected abstract Array2DRowFieldMatrix<T> initializeHighOrderDerivatives(T r1, T[] r2, T[][] r3, T[][] r4);

    protected MultistepFieldIntegrator(Field<T> r14, String r15, int r16, int r17, double r18, double r20, double r22, double r24) throws NumberIsTooSmallException {
        super(r14, r15, r18, r20, r22, r24);
        if (r16 < 2) goto L7;
        this.starter = new DormandPrince853FieldIntegrator(r14, r18, r20, r22, r24);
        this.nSteps = r16;
        this.exp = (-1.0d) / ((double) r17);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
        return;
    L7:
        throw new NumberIsTooSmallException(LocalizedFormats.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS, Integer.valueOf(r16), 2, true);
    }

    protected MultistepFieldIntegrator(Field<T> r11, String r12, int r13, int r14, double r15, double r17, double[] r19, double[] r20) {
        super(r11, r12, r15, r17, r19, r20);
        this.starter = new DormandPrince853FieldIntegrator(r11, r15, r17, r19, r20);
        this.nSteps = r13;
        this.exp = (-1.0d) / ((double) r14);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
    }

    public FirstOrderFieldIntegrator<T> getStarterIntegrator() {
        return this.starter;
    }

    public void setStarterIntegrator(FirstOrderFieldIntegrator<T> r1) {
        this.starter = r1;
    }

    protected void start(FieldExpandableODE<T> r5, FieldODEState<T> r6, T r7) throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException {
        this.starter.clearEventHandlers();
        this.starter.clearStepHandlers();
        this.starter.addStepHandler(new FieldNordsieckInitializer(this, r5.getMapper(), (this.nSteps + 3) / 2));
        this.starter.integrate(r5, r6, r7);     // Catch: InitializationCompletedMarkerException -> L5
        throw new MathIllegalStateException(LocalizedFormats.MULTISTEP_STARTER_STOPPED_EARLY, new Object[0]);     // Catch: InitializationCompletedMarkerException -> L5
    L5:
        getEvaluationsCounter().increment(this.starter.getEvaluations());
        this.starter.clearStepHandlers();
    }

    public double getMinReduction() {
        return this.minReduction;
    }

    public void setMinReduction(double r1) {
        this.minReduction = r1;
    }

    public double getMaxGrowth() {
        return this.maxGrowth;
    }

    public void setMaxGrowth(double r1) {
        this.maxGrowth = r1;
    }

    public double getSafety() {
        return this.safety;
    }

    public void setSafety(double r1) {
        this.safety = r1;
    }

    public int getNSteps() {
        return this.nSteps;
    }

    protected void rescale(T r9) {
        RealFieldElement r0 = (RealFieldElement) r9.divide(getStepSize());
        int r2 = 0;
    L3:
        FieldElement[] r3 = this.scaled;
        if (r2 >= r3.length) goto L6;
        r3[r2] = (RealFieldElement) r3[r2].multiply(r0);
        r2 = r2 + 1;
        goto L3
    L6:
        RealFieldElement[][] r4 = (RealFieldElement[][]) this.nordsieck.getDataRef();
        RealFieldElement r5 = r0;
        int r6 = 0;
    L8:
        if (r6 >= r4.length) goto L14;
        r5 = (RealFieldElement) r5.multiply(r0);
        RealFieldElement[] r7 = r4[r6];
        int r8 = 0;
    L11:
        if (r8 >= r7.length) goto L13;
        r7[r8] = (RealFieldElement) r7[r8].multiply(r5);
        r8 = r8 + 1;
        goto L11
    L13:
        r6 = r6 + 1;
        goto L8
    L14:
        setStepSize(r9);
    }

    protected T computeStepGrowShrinkFactor(T r5) {
        return (T) MathUtils.min((RealFieldElement) ((RealFieldElement) r5.getField().getZero()).add(this.maxGrowth), MathUtils.max((RealFieldElement) ((RealFieldElement) r5.getField().getZero()).add(this.minReduction), (RealFieldElement) ((RealFieldElement) r5.pow(this.exp)).multiply(this.safety)));
    }
}
