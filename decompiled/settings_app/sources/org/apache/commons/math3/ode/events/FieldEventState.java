package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.sampling.FieldStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class FieldEventState<T extends RealFieldElement<T>> {
    private final T convergence;
    private boolean forward;
    private T g0;
    private boolean g0Positive;
    private final FieldEventHandler<T> handler;
    private boolean increasing;
    private final double maxCheckInterval;
    private final int maxIterationCount;
    private Action nextAction;
    private boolean pendingEvent;
    private T pendingEventTime;
    private T previousEventTime;
    private final BracketedRealFieldUnivariateSolver<T> solver;
    private T t0;

    static /* synthetic */ FieldEventHandler access$000(FieldEventState r0) {
        return r0.handler;
    }

    public FieldEventState(FieldEventHandler<T> r1, double r2, T r4, int r5, BracketedRealFieldUnivariateSolver<T> r6) {
        this.handler = r1;
        this.maxCheckInterval = r2;
        this.convergence = (T) r4.abs();
        this.maxIterationCount = r5;
        this.solver = r6;
        this.t0 = null;
        this.g0 = null;
        this.g0Positive = true;
        this.pendingEvent = false;
        this.pendingEventTime = null;
        this.previousEventTime = null;
        this.increasing = true;
        this.nextAction = Action.CONTINUE;
    }

    public FieldEventHandler<T> getEventHandler() {
        return this.handler;
    }

    public double getMaxCheckInterval() {
        return this.maxCheckInterval;
    }

    public T getConvergence() {
        return this.convergence;
    }

    public int getMaxIterationCount() {
        return this.maxIterationCount;
    }

    public void reinitializeBegin(FieldStepInterpolator<T> r8) throws MaxCountExceededException {
        FieldODEStateAndDerivative<T> r0 = r8.getPreviousState();
        this.t0 = r0.getTime();
        T r1 = (T) this.handler.g(r0);
        this.g0 = r1;
        if (r1.getReal() != 0.0d) goto L6;
        double r2 = FastMath.max(this.solver.getAbsoluteAccuracy().getReal(), FastMath.abs(((RealFieldElement) this.solver.getRelativeAccuracy().multiply(this.t0)).getReal()));
        RealFieldElement r3 = (RealFieldElement) this.t0.add(r2 * 0.5d);
        this.g0 = (T) this.handler.g(r8.getInterpolatedState(r3));
    L6:
        if (this.g0.getReal() < 0.0d) goto L8;
        boolean r9 = true;
    L9:
        this.g0Positive = r9;
        return;
    L8:
        r9 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [org.apache.commons.math3.analysis.RealFieldUnivariateFunction, org.apache.commons.math3.ode.events.FieldEventState$1] */
    /* JADX WARN: Type inference failed for: r9v17, types: [org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    public boolean evaluateStep(final FieldStepInterpolator<T> r22) throws MaxCountExceededException, NoBracketingException {
        this.forward = r22.isForward();
        T r2 = r22.getCurrentState().getTime();
        RealFieldElement r3 = (RealFieldElement) r2.subtract(this.t0);
        if (((RealFieldElement) ((RealFieldElement) r3.abs()).subtract(this.convergence)).getReal() >= 0.0d) goto L5;
        return false;
    L5:
        int r4 = FastMath.max(1, (int) FastMath.ceil(FastMath.abs(r3.getReal()) / this.maxCheckInterval));
        RealFieldElement r5 = (RealFieldElement) r3.divide(r4);
        ?? r15 = new AnonymousClass1(this, r22);
        T r9 = this.t0;
        RealFieldElement r10 = this.g0;
        int r13 = 0;
        RealFieldElement r14 = r9;
    L6:
        if (r13 >= r4) goto L71;
        if (r13 != (r4 - 1)) goto L10;
        RealFieldElement r12 = r2;
    L11:
        RealFieldElement r11 = this.handler.g(r22.getInterpolatedState(r12));
        boolean r16 = this.g0Positive;
        if (r11.getReal() < 0.0d) goto L14;
        boolean r17 = true;
    L16:
        if ((r16 ^ r17) == true) goto L18;
        r14 = r12;
        r10 = r11;
    L70:
        r13 = r13 + 1;
        goto L6
    L18:
        if (((RealFieldElement) r11.subtract(r10)).getReal() < 0.0d) goto L20;
        boolean r18 = true;
    L21:
        this.increasing = r18;
        if (this.forward == false) goto L24;
        BracketedRealFieldUnivariateSolver<T> r19 = this.solver;
        int r110 = this.maxIterationCount;
        RealFieldElement r111 = r12;
        r12 = r14;
        RealFieldElement r112 = r111;
        RealFieldElement r20 = r14;
        AllowedSolution r113 = AllowedSolution.RIGHT_SIDE;
        ?? r21 = r19;
    L25:
        T r23 = (T) r21.solve(r110, r15, r12, r112, r113);
        if (this.previousEventTime == null) goto L60;
        RealFieldElement r114 = r20;
        if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r23.subtract(r114)).abs()).subtract(this.convergence)).getReal() > 0.0d) goto L60;
        if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r23.subtract(this.previousEventTime)).abs()).subtract(this.convergence)).getReal() > 0.0d) goto L60;
        RealFieldElement r115 = r114;
    L33:
        if (this.forward == false) goto L35;
        Object r116 = r115.add(this.convergence);
    L36:
        r115 = (RealFieldElement) r116;
        RealFieldElement r117 = r15.value(r115);
        boolean r118 = this.g0Positive;
        if (r117.getReal() < 0.0d) goto L39;
        boolean r119 = true;
    L41:
        if ((r118 ^ r119) == false) goto L50;
        boolean r120 = this.forward;
        RealFieldElement r121 = r111;
        if (((RealFieldElement) r115.subtract(r121)).getReal() < 0.0d) goto L45;
        boolean r122 = true;
    L47:
        if ((r120 ^ r122) == false) goto L51;
        r111 = r121;
    L51:
        boolean r123 = this.forward;
        if (((RealFieldElement) r115.subtract(r121)).getReal() < 0.0d) goto L54;
        boolean r124 = true;
    L56:
        if ((r123 ^ r124) == false) goto L58;
        r13 = r13 - 1;
        RealFieldElement r125 = r115;
    L66:
        r10 = r117;
        r14 = r125;
        goto L70
    L58:
        this.pendingEventTime = r23;
        this.pendingEvent = true;
        return true;
    L54:
        r124 = false;
        goto L56
    L45:
        r122 = false;
        goto L47
    L50:
        r121 = r111;
        goto L51
    L39:
        r119 = false;
        goto L41
    L35:
        r116 = r115.subtract(this.convergence);
    L60:
        r125 = r111;
        T r126 = this.previousEventTime;
        if (r126 == null) goto L67;
        if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r126.subtract(r23)).abs()).subtract(this.convergence)).getReal() > 0.0d) goto L67;
        r117 = r11;
        r13 = r13;
    L67:
        this.pendingEventTime = r23;
        this.pendingEvent = true;
        return true;
    L24:
        r111 = r12;
        r20 = r14;
        BracketedRealFieldUnivariateSolver<T> r24 = this.solver;
        r110 = this.maxIterationCount;
        r113 = AllowedSolution.LEFT_SIDE;
        r112 = r20;
        r21 = r24;
        goto L25
    L20:
        r18 = false;
        goto L21
    L14:
        r17 = false;
        goto L16
    L10:
        r12 = (RealFieldElement) this.t0.add(r5.multiply(r13 + 1));
        goto L11
    L71:
        this.pendingEvent = false;
        this.pendingEventTime = null;
        return false;
    }

    public T getEventTime() {
        if (this.pendingEvent == true) goto L11;
        RealFieldElement r0 = (RealFieldElement) this.t0.getField().getZero();
        if (this.forward == false) goto L8;
        double r1 = Double.POSITIVE_INFINITY;
    L10:
        return (T) r0.add(r1);
    L8:
        r1 = Double.NEGATIVE_INFINITY;
        goto L10
    L11:
        return this.pendingEventTime;
    }

    public void stepAccepted(FieldODEStateAndDerivative<T> r7) {
        this.t0 = r7.getTime();
        this.g0 = (T) this.handler.g(r7);
        boolean r1 = true;
        if (this.pendingEvent == false) goto L8;
        if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.pendingEventTime.subtract(r7.getTime())).abs()).subtract(this.convergence)).getReal() > 0.0d) goto L8;
        this.previousEventTime = r7.getTime();
        boolean r0 = this.increasing;
        this.g0Positive = r0;
        this.nextAction = this.handler.eventOccurred(r7, !(r0 ^ this.forward));
        return;
    L8:
        if (this.g0.getReal() >= 0.0d) goto L11;
        r1 = false;
    L11:
        this.g0Positive = r1;
        this.nextAction = Action.CONTINUE;
    }

    public boolean stop() {
        if (this.nextAction != Action.STOP) goto L5;
        return true;
    L5:
        return false;
    }

    public FieldODEState<T> reset(FieldODEStateAndDerivative<T> r7) {
        if (this.pendingEvent == true) goto L5;
    L16:
        return null;
    L5:
        if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.pendingEventTime.subtract(r7.getTime())).abs()).subtract(this.convergence)).getReal() > 0.0d) goto L16;
        if (this.nextAction != Action.RESET_STATE) goto L11;
        r7 = this.handler.resetState(r7);
    L14:
        this.pendingEvent = false;
        this.pendingEventTime = null;
        return r7;
    L11:
        if (this.nextAction == Action.RESET_DERIVATIVES) goto L14;
        r7 = null;
        goto L14
    }
}
