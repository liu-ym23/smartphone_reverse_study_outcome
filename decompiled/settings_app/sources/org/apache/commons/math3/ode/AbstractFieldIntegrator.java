package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver;
import org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.events.FieldEventHandler;
import org.apache.commons.math3.ode.events.FieldEventState;
import org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator;
import org.apache.commons.math3.ode.sampling.FieldStepHandler;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.IntegerSequence;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFieldIntegrator<T extends RealFieldElement<T>> implements FirstOrderFieldIntegrator<T> {
    private static final double DEFAULT_FUNCTION_VALUE_ACCURACY = 1.0E-15d;
    private static final double DEFAULT_RELATIVE_ACCURACY = 1.0E-14d;
    private transient FieldExpandableODE<T> equations;
    private IntegerSequence.Incrementor evaluations;
    private Collection<FieldEventState<T>> eventsStates;
    private final Field<T> field;
    private boolean isLastStep;
    private final String name;
    private boolean resetOccurred;
    private boolean statesInitialized;
    private Collection<FieldStepHandler<T>> stepHandlers;
    private T stepSize;
    private FieldODEStateAndDerivative<T> stepStart;

    protected AbstractFieldIntegrator(Field<T> r1, String r2) {
        this.field = r1;
        this.name = r2;
        this.stepHandlers = new ArrayList();
        this.stepStart = null;
        this.stepSize = null;
        this.eventsStates = new ArrayList();
        this.statesInitialized = false;
        this.evaluations = IntegerSequence.Incrementor.create().withMaximalCount(Integer.MAX_VALUE);
    }

    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public void addStepHandler(FieldStepHandler<T> r1) {
        this.stepHandlers.add(r1);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public Collection<FieldStepHandler<T>> getStepHandlers() {
        return Collections.unmodifiableCollection(this.stepHandlers);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public void clearStepHandlers() {
        this.stepHandlers.clear();
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public void addEventHandler(FieldEventHandler<T> r9, double r10, double r12, int r14) {
        addEventHandler(r9, r10, r12, r14, new FieldBracketingNthOrderBrentSolver((RealFieldElement) this.field.getZero().add(DEFAULT_RELATIVE_ACCURACY), (RealFieldElement) this.field.getZero().add(r12), (RealFieldElement) this.field.getZero().add(1.0E-15d), 5));
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public void addEventHandler(FieldEventHandler<T> r11, double r12, double r14, int r16, BracketedRealFieldUnivariateSolver<T> r17) {
        this.eventsStates.add(new FieldEventState(r11, r12, (RealFieldElement) this.field.getZero().add(r14), r16, r17));
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public Collection<FieldEventHandler<T>> getEventHandlers() {
        ArrayList r0 = new ArrayList(this.eventsStates.size());
        Iterator<FieldEventState<T>> r2 = this.eventsStates.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r0.add(r2.next().getEventHandler());
        goto L4
    L7:
        return Collections.unmodifiableCollection(r0);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public void clearEventHandlers() {
        this.eventsStates.clear();
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> getCurrentStepStart() {
        return this.stepStart;
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public T getCurrentSignedStepsize() {
        return this.stepSize;
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public void setMaxEvaluations(int r2) {
        IntegerSequence.Incrementor r0 = this.evaluations;
        if (r2 >= 0) goto L5;
        r2 = Integer.MAX_VALUE;
    L5:
        this.evaluations = r0.withMaximalCount(r2);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    protected FieldODEStateAndDerivative<T> initIntegration(FieldExpandableODE<T> r3, T r4, T[] r5, T r6) {
        this.equations = r3;
        this.evaluations = this.evaluations.withStart(0);
        r3.init(r4, r5, r6);
        FieldODEStateAndDerivative<T> r0 = new FieldODEStateAndDerivative(r4, r5, computeDerivatives(r4, r5));
        Iterator<FieldEventState<T>> r7 = this.eventsStates.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.next().getEventHandler().init(r0, r6);
        goto L4
    L6:
        Iterator<FieldStepHandler<T>> r8 = this.stepHandlers.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r8.next().init(r0, r6);
        goto L8
    L10:
        setStateInitialized(false);
        return r0;
    }

    protected FieldExpandableODE<T> getEquations() {
        return this.equations;
    }

    protected IntegerSequence.Incrementor getEvaluationsCounter() {
        return this.evaluations;
    }

    public T[] computeDerivatives(T r2, T[] r3) throws DimensionMismatchException, MaxCountExceededException, NullPointerException {
        this.evaluations.increment();
        return (T[]) this.equations.computeDerivatives(r2, r3);
    }

    protected void setStateInitialized(boolean r1) {
        this.statesInitialized = r1;
    }

    protected FieldODEStateAndDerivative<T> acceptStep(AbstractFieldStepInterpolator<T> r11, T r12) throws MaxCountExceededException, DimensionMismatchException, NoBracketingException {
        FieldODEStateAndDerivative<T> r0 = r11.getGlobalPreviousState();
        FieldODEStateAndDerivative<T> r1 = r11.getGlobalCurrentState();
        boolean r3 = true;
        if (this.statesInitialized == true) goto L10;
        Iterator<FieldEventState<T>> r2 = this.eventsStates.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r2.next().reinitializeBegin(r11);
        goto L6
    L8:
        this.statesInitialized = true;
    L10:
        if (r11.isForward() == false) goto L12;
        final int r4 = 1;
    L13:
        TreeSet r5 = new TreeSet(new AnonymousClass1(this, r4));
        Iterator<FieldEventState<T>> r6 = this.eventsStates.iterator();
    L15:
        if (r6.hasNext() == false) goto L20;
        FieldEventState<T> r7 = r6.next();
        if (r7.evaluateStep(r11) == false) goto L15;
        r5.add(r7);
    L20:
        if (r5.isEmpty() == true) goto L50;
        Iterator r8 = r5.iterator();
        FieldEventState r9 = (FieldEventState) r8.next();
        r8.remove();
        FieldODEStateAndDerivative<T> r10 = r11.getInterpolatedState(r9.getEventTime());
        AbstractFieldStepInterpolator<T> r13 = r11.restrictStep(r0, r10);
        Iterator<FieldEventState<T>> r14 = this.eventsStates.iterator();
    L23:
        if (r14.hasNext() == false) goto L32;
        FieldEventState<T> r15 = r14.next();
        r15.stepAccepted(r10);
        if (this.isLastStep == false) goto L27;
    L30:
        boolean r16 = true;
    L31:
        this.isLastStep = r16;
        goto L23
    L27:
        if (r15.stop() == true) goto L30;
        r16 = false;
        goto L31
    L32:
        Iterator<FieldStepHandler<T>> r17 = this.stepHandlers.iterator();
    L34:
        if (r17.hasNext() == false) goto L37;
        r17.next().handleStep(r13, this.isLastStep);
        goto L34
    L37:
        if (this.isLastStep == true) goto L38;
        this.resetOccurred = false;
        Iterator<FieldEventState<T>> r18 = this.eventsStates.iterator();
    L41:
        if (r18.hasNext() == false) goto L46;
        FieldODEState<T> r19 = r18.next().reset(r10);
        if (r19 == null) goto L41;
        RealFieldElement[] r110 = this.equations.getMapper().mapState(r19);
        RealFieldElement[] r111 = computeDerivatives(r19.getTime(), r110);
        this.resetOccurred = true;
        return this.equations.getMapper().mapStateAndDerivative(r19.getTime(), r110, r111);
    L46:
        r11 = r13.restrictStep(r10, r1);
        if (r9.evaluateStep(r11) == false) goto L49;
        r5.add(r9);
    L49:
        r0 = r10;
        goto L20
    L38:
        return r10;
    L50:
        Iterator<FieldEventState<T>> r20 = this.eventsStates.iterator();
    L52:
        if (r20.hasNext() == false) goto L62;
        FieldEventState<T> r21 = r20.next();
        r21.stepAccepted(r1);
        if (this.isLastStep == false) goto L56;
    L59:
        boolean r22 = true;
    L60:
        this.isLastStep = r22;
        goto L52
    L56:
        if (r21.stop() == true) goto L59;
        r22 = false;
        goto L60
    L62:
        if (this.isLastStep == false) goto L64;
    L67:
        this.isLastStep = r3;
        Iterator<FieldStepHandler<T>> r112 = this.stepHandlers.iterator();
    L69:
        if (r112.hasNext() == false) goto L71;
        r112.next().handleStep(r11, this.isLastStep);
        goto L69
    L71:
        return r1;
    L64:
        if (((RealFieldElement) ((RealFieldElement) r1.getTime().subtract(r12)).abs()).getReal() <= FastMath.ulp(r12.getReal())) goto L67;
        r3 = false;
        goto L67
    L12:
        r4 = -1;
        goto L13
    }

    protected void sanityChecks(FieldODEState<T> r5, T r6) throws NumberIsTooSmallException, DimensionMismatchException {
        double r0 = FastMath.ulp(FastMath.max(FastMath.abs(r5.getTime().getReal()), FastMath.abs(r6.getReal()))) * 1000.0d;
        double r4 = ((RealFieldElement) ((RealFieldElement) r5.getTime().subtract(r6)).abs()).getReal();
        if (r4 <= r0) goto L6;
        return;
    L6:
        throw new NumberIsTooSmallException(LocalizedFormats.TOO_SMALL_INTEGRATION_INTERVAL, Double.valueOf(r4), Double.valueOf(r0), false);
    }

    protected boolean resetOccurred() {
        return this.resetOccurred;
    }

    protected void setStepSize(T r1) {
        this.stepSize = r1;
    }

    protected T getStepSize() {
        return this.stepSize;
    }

    protected void setStepStart(FieldODEStateAndDerivative<T> r1) {
        this.stepStart = r1;
    }

    protected FieldODEStateAndDerivative<T> getStepStart() {
        return this.stepStart;
    }

    protected void setIsLastStep(boolean r1) {
        this.isLastStep = r1;
    }

    protected boolean isLastStep() {
        return this.isLastStep;
    }
}
