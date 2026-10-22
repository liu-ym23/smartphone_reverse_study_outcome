package org.apache.commons.math3.ode;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MultistepIntegrator extends AdaptiveStepsizeIntegrator {
    private double exp;
    private double maxGrowth;
    private double minReduction;
    private final int nSteps;
    protected Array2DRowRealMatrix nordsieck;
    private double safety;
    protected double[] scaled;
    private FirstOrderIntegrator starter;

    private static class InitializationCompletedMarkerException extends RuntimeException {
        private static final long serialVersionUID = -1914085471038046418L;

        InitializationCompletedMarkerException() {
            Throwable r1 = (Throwable) null;
            super(null);
        }
    }

    private class NordsieckInitializer implements StepHandler {
        private int count;
        private final double[] t;
        final /* synthetic */ MultistepIntegrator this$0;
        private final double[][] y;
        private final double[][] yDot;

        @Override // org.apache.commons.math3.ode.sampling.StepHandler
        public void init(double r1, double[] r3, double r4) {
        }

        NordsieckInitializer(MultistepIntegrator r5, int r6, int r7) {
            this.this$0 = r5;
            this.count = 0;
            this.t = new double[r6];
            this.y = (double[][]) Array.newInstance(Double.TYPE, new int[]{r6, r7});
            this.yDot = (double[][]) Array.newInstance(Double.TYPE, new int[]{r6, r7});
        }

        @Override // org.apache.commons.math3.ode.sampling.StepHandler
        public void handleStep(StepInterpolator r12, boolean r13) throws MaxCountExceededException {
            double r0 = r12.getPreviousTime();
            double r2 = r12.getCurrentTime();
            int r4 = 0;
            if (this.count != 0) goto L7;
            r12.setInterpolatedTime(r0);
            this.t[0] = r0;
            ExpandableStatefulODE r14 = this.this$0.getExpandable();
            EquationsMapper r1 = r14.getPrimaryMapper();
            r1.insertEquationData(r12.getInterpolatedState(), this.y[this.count]);
            r1.insertEquationData(r12.getInterpolatedDerivatives(), this.yDot[this.count]);
            EquationsMapper[] r15 = r14.getSecondaryMappers();
            int r3 = r15.length;
            int r5 = 0;
            int r6 = 0;
        L5:
            if (r5 >= r3) goto L7;
            EquationsMapper r7 = r15[r5];
            r7.insertEquationData(r12.getInterpolatedSecondaryState(r6), this.y[this.count]);
            r7.insertEquationData(r12.getInterpolatedSecondaryDerivatives(r6), this.yDot[this.count]);
            r6 = r6 + 1;
            r5 = r5 + 1;
        L7:
            this.count++;
            r12.setInterpolatedTime(r2);
            this.t[this.count] = r2;
            ExpandableStatefulODE r16 = this.this$0.getExpandable();
            EquationsMapper r8 = r16.getPrimaryMapper();
            r8.insertEquationData(r12.getInterpolatedState(), this.y[this.count]);
            r8.insertEquationData(r12.getInterpolatedDerivatives(), this.yDot[this.count]);
            EquationsMapper[] r17 = r16.getSecondaryMappers();
            int r9 = r17.length;
            int r10 = 0;
            int r11 = 0;
        L8:
            if (r10 >= r9) goto L10;
            EquationsMapper r18 = r17[r10];
            r18.insertEquationData(r12.getInterpolatedSecondaryState(r11), this.y[this.count]);
            r18.insertEquationData(r12.getInterpolatedSecondaryDerivatives(r11), this.yDot[this.count]);
            r11 = r11 + 1;
            r10 = r10 + 1;
            goto L8
        L10:
            int r19 = this.count;
            double[] r110 = this.t;
            if (r19 != (r110.length - 1)) goto L18;
            this.this$0.stepStart = r110[0];
            MultistepIntegrator r111 = this.this$0;
            double[] r112 = this.t;
            r111.stepSize = (r112[r112.length - 1] - r112[0]) / ((double) (r112.length - 1));
            this.this$0.scaled = (double[]) this.yDot[0].clone();
        L14:
            if (r4 >= this.this$0.scaled.length) goto L16;
            double[] r113 = this.this$0.scaled;
            r113[r4] = r113[r4] * this.this$0.stepSize;
            r4 = r4 + 1;
            goto L14
        L16:
            MultistepIntegrator r114 = this.this$0;
            r114.nordsieck = r114.initializeHighOrderDerivatives(r114.stepSize, this.t, this.y, this.yDot);
            throw new InitializationCompletedMarkerException();
        }
    }

    @Deprecated
    public interface NordsieckTransformer {
        Array2DRowRealMatrix initializeHighOrderDerivatives(double r1, double[] r3, double[][] r4, double[][] r5);
    }

    protected abstract Array2DRowRealMatrix initializeHighOrderDerivatives(double r1, double[] r3, double[][] r4, double[][] r5);

    protected MultistepIntegrator(String r13, int r14, int r15, double r16, double r18, double r20, double r22) throws NumberIsTooSmallException {
        super(r13, r16, r18, r20, r22);
        if (r14 < 2) goto L7;
        this.starter = new DormandPrince853Integrator(r16, r18, r20, r22);
        this.nSteps = r14;
        this.exp = (-1.0d) / ((double) r15);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
        return;
    L7:
        throw new NumberIsTooSmallException(LocalizedFormats.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS, Integer.valueOf(r14), 2, true);
    }

    protected MultistepIntegrator(String r10, int r11, int r12, double r13, double r15, double[] r17, double[] r18) {
        super(r10, r13, r15, r17, r18);
        this.starter = new DormandPrince853Integrator(r13, r15, r17, r18);
        this.nSteps = r11;
        this.exp = (-1.0d) / ((double) r12);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
    }

    public ODEIntegrator getStarterIntegrator() {
        return this.starter;
    }

    public void setStarterIntegrator(FirstOrderIntegrator r1) {
        this.starter = r1;
    }

    protected void start(double r10, double[] r12, double r13) throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException {
        this.starter.clearEventHandlers();
        this.starter.clearStepHandlers();
        this.starter.addStepHandler(new NordsieckInitializer(this, (this.nSteps + 3) / 2, r12.length));
        FirstOrderIntegrator r1 = this.starter;     // Catch: InitializationCompletedMarkerException -> L9
        if ((r1 instanceof AbstractIntegrator) == false) goto L6;
        ((AbstractIntegrator) r1).integrate(getExpandable(), r13);     // Catch: InitializationCompletedMarkerException -> L9
    L8:
        throw new MathIllegalStateException(LocalizedFormats.MULTISTEP_STARTER_STOPPED_EARLY, new Object[0]);     // Catch: InitializationCompletedMarkerException -> L9
    L6:
        r1.integrate(new AnonymousClass1(this), r10, r12, r13, new double[r12.length]);     // Catch: InitializationCompletedMarkerException -> L9
    L9:
        getCounter().increment(this.starter.getEvaluations());
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

    protected double computeStepGrowShrinkFactor(double r9) {
        return FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, this.safety * FastMath.pow(r9, this.exp)));
    }
}
