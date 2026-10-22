package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver;
import org.apache.commons.math3.analysis.solvers.PegasusSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class EventState {
    private final double convergence;
    private ExpandableStatefulODE expandable;
    private boolean forward;
    private double g0;
    private boolean g0Positive;
    private final EventHandler handler;
    private boolean increasing;
    private final double maxCheckInterval;
    private final int maxIterationCount;
    private EventHandler.Action nextAction;
    private boolean pendingEvent;
    private double pendingEventTime;
    private double previousEventTime;
    private final UnivariateSolver solver;
    private double t0;

    private static class LocalMaxCountExceededException extends RuntimeException {
        private static final long serialVersionUID = 20120901;
        private final MaxCountExceededException wrapped;

        LocalMaxCountExceededException(MaxCountExceededException r1) {
            this.wrapped = r1;
        }

        public MaxCountExceededException getException() {
            return this.wrapped;
        }
    }

    static /* synthetic */ double[] access$000(EventState r0, StepInterpolator r1) {
        return r0.getCompleteState(r1);
    }

    static /* synthetic */ EventHandler access$100(EventState r0) {
        return r0.handler;
    }

    public EventState(EventHandler r1, double r2, double r4, int r6, UnivariateSolver r7) {
        this.handler = r1;
        this.maxCheckInterval = r2;
        this.convergence = FastMath.abs(r4);
        this.maxIterationCount = r6;
        this.solver = r7;
        this.expandable = null;
        this.t0 = Double.NaN;
        this.g0 = Double.NaN;
        this.g0Positive = true;
        this.pendingEvent = false;
        this.pendingEventTime = Double.NaN;
        this.previousEventTime = Double.NaN;
        this.increasing = true;
        this.nextAction = EventHandler.Action.CONTINUE;
    }

    public EventHandler getEventHandler() {
        return this.handler;
    }

    public void setExpandable(ExpandableStatefulODE r1) {
        this.expandable = r1;
    }

    public double getMaxCheckInterval() {
        return this.maxCheckInterval;
    }

    public double getConvergence() {
        return this.convergence;
    }

    public int getMaxIterationCount() {
        return this.maxIterationCount;
    }

    public void reinitializeBegin(StepInterpolator r9) throws MaxCountExceededException {
        double r0 = r9.getPreviousTime();
        this.t0 = r0;
        r9.setInterpolatedTime(r0);
        double r1 = this.handler.g(this.t0, getCompleteState(r9));
        this.g0 = r1;
        if (r1 != 0.0d) goto L6;
        double r2 = FastMath.max(this.solver.getAbsoluteAccuracy(), FastMath.abs(this.solver.getRelativeAccuracy() * this.t0));
        double r4 = this.t0 + (r2 * 0.5d);
        r9.setInterpolatedTime(r4);
        this.g0 = this.handler.g(r4, getCompleteState(r9));
    L6:
        if (this.g0 < 0.0d) goto L8;
        boolean r10 = true;
    L9:
        this.g0Positive = r10;
        return;
    L8:
        r10 = false;
        goto L9
    }

    private double[] getCompleteState(StepInterpolator r7) {
        double[] r0 = new double[this.expandable.getTotalDimension()];
        this.expandable.getPrimaryMapper().insertEquationData(r7.getInterpolatedState(), r0);
        EquationsMapper[] r6 = this.expandable.getSecondaryMappers();
        int r1 = r6.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r6[r2].insertEquationData(r7.getInterpolatedSecondaryState(r3), r0);
        r2 = r2 + 1;
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public boolean evaluateStep(StepInterpolator r30) throws MaxCountExceededException, NoBracketingException {
        final StepInterpolator r1 = r30;
        this.forward = r30.isForward();     // Catch: LocalMaxCountExceededException -> L83
        double r2 = r30.getCurrentTime();     // Catch: LocalMaxCountExceededException -> L83
        double r4 = r2 - this.t0;     // Catch: LocalMaxCountExceededException -> L83
        boolean r7 = false;
        if (FastMath.abs(r4) >= this.convergence) goto L6;
        return false;
    L6:
        int r6 = FastMath.max(1, (int) FastMath.ceil(FastMath.abs(r4) / this.maxCheckInterval));     // Catch: LocalMaxCountExceededException -> L83
        double r5 = r4 / ((double) r6);     // Catch: LocalMaxCountExceededException -> L83
        UnivariateFunction r14 = new AnonymousClass1(this, r1);     // Catch: LocalMaxCountExceededException -> L83
        double r9 = this.t0;     // Catch: LocalMaxCountExceededException -> L83
        double r11 = this.g0;     // Catch: LocalMaxCountExceededException -> L83
        int r15 = 0;
        double r19 = r9;
    L7:
        if (r15 >= r6) goto L81;
        if (r15 != (r6 - 1)) goto L11;
        double r8 = r2;
    L12:
        r1.setInterpolatedTime(r8);     // Catch: LocalMaxCountExceededException -> L83
        double r21 = this.handler.g(r8, getCompleteState(r30));     // Catch: LocalMaxCountExceededException -> L83
        boolean r10 = this.g0Positive;     // Catch: LocalMaxCountExceededException -> L83
        if (r21 < 0.0d) goto L15;
        boolean r12 = true;
    L17:
        if ((r10 ^ r12) == true) goto L19;
        r2 = r2;
        UnivariateFunction r3 = r14;
    L80:
        r19 = r8;
        r11 = r21;
        r15 = r15 + 1;     // Catch: LocalMaxCountExceededException -> L83
        r14 = r3;
        r2 = r2;
        r7 = false;
        r1 = r30;
        goto L7
    L19:
        if (r21 < r11) goto L21;
        boolean r13 = true;
    L22:
        this.increasing = r13;     // Catch: LocalMaxCountExceededException -> L83
        UnivariateSolver r16 = this.solver;     // Catch: LocalMaxCountExceededException -> L83
        if ((r16 instanceof BracketedUnivariateSolver) == false) goto L29;
        BracketedUnivariateSolver r17 = (BracketedUnivariateSolver) r16;     // Catch: LocalMaxCountExceededException -> L83
        if (this.forward == false) goto L27;
        UnivariateFunction r26 = r14;
        double r18 = r17.solve(this.maxIterationCount, r14, r19, r8, AllowedSolution.RIGHT_SIDE);     // Catch: LocalMaxCountExceededException -> L83
    L39:
        if (Double.isNaN(this.previousEventTime) == false) goto L41;
    L71:
        r3 = r26;
        if (Double.isNaN(this.previousEventTime) == true) goto L77;
        if (FastMath.abs(this.previousEventTime - r18) > this.convergence) goto L77;
        r15 = r15;
    L77:
        this.pendingEventTime = r18;     // Catch: LocalMaxCountExceededException -> L83
        this.pendingEvent = true;     // Catch: LocalMaxCountExceededException -> L83
        return true;
    L41:
        if (FastMath.abs(r18 - r19) > this.convergence) goto L71;
        if (FastMath.abs(r18 - this.previousEventTime) > this.convergence) goto L71;
    L45:
        if (this.forward == false) goto L47;
        double r110 = r19 + this.convergence;     // Catch: LocalMaxCountExceededException -> L83
    L48:
        double r20 = r110;
        r3 = r26;
        r21 = r3.value(r20);     // Catch: LocalMaxCountExceededException -> L83
        boolean r111 = this.g0Positive;     // Catch: LocalMaxCountExceededException -> L83
        if (r21 < 0.0d) goto L51;
        boolean r112 = true;
    L53:
        if ((r111 ^ r112) == false) goto L62;
        boolean r113 = this.forward;     // Catch: LocalMaxCountExceededException -> L83
        if (r20 < r8) goto L57;
        boolean r114 = true;
    L59:
        if ((r113 ^ r114) == false) goto L62;
        r19 = r20;
        r26 = r3;
        goto L45
    L57:
        r114 = false;
    L62:
        boolean r115 = this.forward;     // Catch: LocalMaxCountExceededException -> L83
        if (r20 < r8) goto L65;
        boolean r22 = true;
    L67:
        if ((r22 ^ r115) == false) goto L69;
        r15 = r15 - 1;     // Catch: LocalMaxCountExceededException -> L83
        r8 = r20;
        goto L80
    L69:
        this.pendingEventTime = r18;     // Catch: LocalMaxCountExceededException -> L83
        this.pendingEvent = true;     // Catch: LocalMaxCountExceededException -> L83
        return true;
    L65:
        r22 = false;
        goto L67
    L51:
        r112 = false;
        goto L53
    L47:
        r110 = r19 - this.convergence;     // Catch: LocalMaxCountExceededException -> L83
        goto L48
    L27:
        r26 = r14;
        r18 = r17.solve(this.maxIterationCount, r26, r8, r19, AllowedSolution.LEFT_SIDE);     // Catch: LocalMaxCountExceededException -> L83
        goto L39
    L29:
        r26 = r14;
        r15 = r15;
        if (this.forward == false) goto L32;
        double r23 = r16.solve(this.maxIterationCount, r26, r19, r8);     // Catch: LocalMaxCountExceededException -> L83
    L33:
        double r116 = r23;
        int r24 = this.maxIterationCount - this.solver.getEvaluations();     // Catch: LocalMaxCountExceededException -> L83
        PegasusSolver r117 = new PegasusSolver(this.solver.getRelativeAccuracy(), this.solver.getAbsoluteAccuracy());     // Catch: LocalMaxCountExceededException -> L83
        if (this.forward == false) goto L36;
        double r25 = UnivariateSolverUtils.forceSide(r24, r26, r117, r116, r19, r8, AllowedSolution.RIGHT_SIDE);     // Catch: LocalMaxCountExceededException -> L83
    L37:
        r18 = r25;
        goto L39
    L36:
        r25 = UnivariateSolverUtils.forceSide(r24, r26, r117, r116, r8, r19, AllowedSolution.LEFT_SIDE);     // Catch: LocalMaxCountExceededException -> L83
        goto L37
    L32:
        r23 = r16.solve(this.maxIterationCount, r26, r8, r19);     // Catch: LocalMaxCountExceededException -> L83
        goto L33
    L21:
        r13 = false;
        goto L22
    L15:
        r12 = false;
        goto L17
    L11:
        r8 = this.t0 + (((double) (r15 + 1)) * r5);     // Catch: LocalMaxCountExceededException -> L83
        goto L12
    L81:
        boolean r27 = r7;
        this.pendingEvent = r27;     // Catch: LocalMaxCountExceededException -> L83
        this.pendingEventTime = Double.NaN;     // Catch: LocalMaxCountExceededException -> L83
        return r27;
    L83:
        e = move-exception;
        throw e.getException();
    }

    public double getEventTime() {
        if (this.pendingEvent == false) goto L6;
        return this.pendingEventTime;
    L6:
        if (this.forward == false) goto L8;
        return Double.POSITIVE_INFINITY;
    L8:
        return Double.NEGATIVE_INFINITY;
    }

    public void stepAccepted(double r7, double[] r9) {
        this.t0 = r7;
        this.g0 = this.handler.g(r7, r9);
        boolean r1 = true;
        if (this.pendingEvent == false) goto L8;
        if (FastMath.abs(this.pendingEventTime - r7) > this.convergence) goto L8;
        this.previousEventTime = r7;
        boolean r0 = this.increasing;
        this.g0Positive = r0;
        this.nextAction = this.handler.eventOccurred(r7, r9, !(r0 ^ this.forward));
        return;
    L8:
        if (this.g0 >= 0.0d) goto L11;
        r1 = false;
    L11:
        this.g0Positive = r1;
        this.nextAction = EventHandler.Action.CONTINUE;
    }

    public boolean stop() {
        if (this.nextAction != EventHandler.Action.STOP) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean reset(double r7, double[] r9) {
        if (this.pendingEvent == true) goto L5;
        return false;
    L5:
        if (FastMath.abs(this.pendingEventTime - r7) <= this.convergence) goto L8;
        return false;
    L8:
        if (this.nextAction != EventHandler.Action.RESET_STATE) goto L10;
        this.handler.resetState(r7, r9);
    L10:
        this.pendingEvent = false;
        this.pendingEventTime = Double.NaN;
        if (this.nextAction != EventHandler.Action.RESET_STATE) goto L13;
    L14:
        return true;
    L13:
        if (this.nextAction == EventHandler.Action.RESET_DERIVATIVES) goto L14;
        return false;
    }
}
