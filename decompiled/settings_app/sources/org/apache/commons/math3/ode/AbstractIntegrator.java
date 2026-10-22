package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.events.EventState;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractIntegrator implements FirstOrderIntegrator {
    private IntegerSequence.Incrementor evaluations;
    private Collection<EventState> eventsStates;
    private transient ExpandableStatefulODE expandable;
    protected boolean isLastStep;
    private final String name;
    protected boolean resetOccurred;
    private boolean statesInitialized;
    protected Collection<StepHandler> stepHandlers;
    protected double stepSize;
    protected double stepStart;

    public abstract void integrate(ExpandableStatefulODE r1, double r2) throws NumberIsTooSmallException, DimensionMismatchException, MaxCountExceededException, NoBracketingException;

    public AbstractIntegrator(String r3) {
        this.name = r3;
        this.stepHandlers = new ArrayList();
        this.stepStart = Double.NaN;
        this.stepSize = Double.NaN;
        this.eventsStates = new ArrayList();
        this.statesInitialized = false;
        this.evaluations = IntegerSequence.Incrementor.create().withMaximalCount(Integer.MAX_VALUE);
    }

    protected AbstractIntegrator() {
        this(null);
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void addStepHandler(StepHandler r1) {
        this.stepHandlers.add(r1);
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public Collection<StepHandler> getStepHandlers() {
        return Collections.unmodifiableCollection(this.stepHandlers);
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void clearStepHandlers() {
        this.stepHandlers.clear();
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void addEventHandler(EventHandler r9, double r10, double r12, int r14) {
        addEventHandler(r9, r10, r12, r14, new BracketingNthOrderBrentSolver(r12, 5));
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void addEventHandler(EventHandler r11, double r12, double r14, int r16, UnivariateSolver r17) {
        this.eventsStates.add(new EventState(r11, r12, r14, r16, r17));
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public Collection<EventHandler> getEventHandlers() {
        ArrayList r0 = new ArrayList(this.eventsStates.size());
        Iterator<EventState> r2 = this.eventsStates.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r0.add(r2.next().getEventHandler());
        goto L4
    L7:
        return Collections.unmodifiableCollection(r0);
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void clearEventHandlers() {
        this.eventsStates.clear();
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public double getCurrentStepStart() {
        return this.stepStart;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public double getCurrentSignedStepsize() {
        return this.stepSize;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void setMaxEvaluations(int r2) {
        IntegerSequence.Incrementor r0 = this.evaluations;
        if (r2 >= 0) goto L5;
        r2 = Integer.MAX_VALUE;
    L5:
        this.evaluations = r0.withMaximalCount(r2);
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    protected void initIntegration(double r11, double[] r13, double r14) {
        this.evaluations = this.evaluations.withStart(0);
        Iterator<EventState> r0 = this.eventsStates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        EventState r2 = r0.next();
        r2.setExpandable(this.expandable);
        r2.getEventHandler().init(r11, r13, r14);
        goto L4
    L6:
        Iterator<StepHandler> r1 = this.stepHandlers.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().init(r11, r13, r14);
        goto L8
    L10:
        setStateInitialized(false);
    }

    protected void setEquations(ExpandableStatefulODE r1) {
        this.expandable = r1;
    }

    protected ExpandableStatefulODE getExpandable() {
        return this.expandable;
    }

    @Deprecated
    protected Incrementor getEvaluationsCounter() {
        return Incrementor.wrap(this.evaluations);
    }

    protected IntegerSequence.Incrementor getCounter() {
        return this.evaluations;
    }

    @Override // org.apache.commons.math3.ode.FirstOrderIntegrator
    public double integrate(FirstOrderDifferentialEquations r3, double r4, double[] r6, double r7, double[] r9) throws DimensionMismatchException, NumberIsTooSmallException, MaxCountExceededException, NoBracketingException {
        if (r6.length != r3.getDimension()) goto L11;
        if (r9.length != r3.getDimension()) goto L9;
        ExpandableStatefulODE r0 = new ExpandableStatefulODE(r3);
        r0.setTime(r4);
        r0.setPrimaryState(r6);
        integrate(r0, r7);
        System.arraycopy(r0.getPrimaryState(), 0, r9, 0, r9.length);
        return r0.getTime();
    L9:
        throw new DimensionMismatchException(r9.length, r3.getDimension());
    L11:
        throw new DimensionMismatchException(r6.length, r3.getDimension());
    }

    public void computeDerivatives(double r2, double[] r4, double[] r5) throws MaxCountExceededException, DimensionMismatchException, NullPointerException {
        this.evaluations.increment();
        this.expandable.computeDerivatives(r2, r4, r5);
    }

    protected void setStateInitialized(boolean r1) {
        this.statesInitialized = r1;
    }

    protected double acceptStep(AbstractStepInterpolator r18, double[] r19, double[] r20, double r21) throws MaxCountExceededException, DimensionMismatchException, NoBracketingException {
        double r3 = r18.getGlobalPreviousTime();
        double r5 = r18.getGlobalCurrentTime();
        if (this.statesInitialized == true) goto L10;
        Iterator<EventState> r7 = this.eventsStates.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r7.next().reinitializeBegin(r18);
        goto L6
    L8:
        this.statesInitialized = true;
    L10:
        if (r18.isForward() == false) goto L12;
        final int r8 = 1;
    L13:
        TreeSet r9 = new TreeSet(new AnonymousClass1(this, r8));
        Iterator<EventState> r10 = this.eventsStates.iterator();
    L15:
        if (r10.hasNext() == false) goto L20;
        EventState r11 = r10.next();
        if (r11.evaluateStep(r18) == false) goto L15;
        r9.add(r11);
    L20:
        if (r9.isEmpty() == true) goto L51;
        Iterator r12 = r9.iterator();
        EventState r13 = (EventState) r12.next();
        r12.remove();
        double r14 = r13.getEventTime();
        r18.setSoftPreviousTime(r3);
        r18.setSoftCurrentTime(r14);
        r18.setInterpolatedTime(r14);
        double[] r4 = new double[r19.length];
        this.expandable.getPrimaryMapper().insertEquationData(r18.getInterpolatedState(), r4);
        EquationsMapper[] r6 = this.expandable.getSecondaryMappers();
        int r15 = r6.length;
        int r16 = 0;
        int r17 = 0;
    L22:
        if (r16 >= r15) goto L24;
        r6[r16].insertEquationData(r18.getInterpolatedSecondaryState(r17), r4);
        r16 = r16 + 1;
        r17 = r17 + 1;
        goto L22
    L24:
        Iterator<EventState> r22 = this.eventsStates.iterator();
    L26:
        if (r22.hasNext() == false) goto L35;
        EventState r23 = r22.next();
        r23.stepAccepted(r14, r4);
        if (this.isLastStep == false) goto L30;
    L33:
        boolean r24 = true;
    L34:
        this.isLastStep = r24;
        goto L26
    L30:
        if (r23.stop() == true) goto L33;
        r24 = false;
        goto L34
    L35:
        Iterator<StepHandler> r25 = this.stepHandlers.iterator();
    L37:
        if (r25.hasNext() == false) goto L40;
        r25.next().handleStep(r18, this.isLastStep);
        goto L37
    L40:
        if (this.isLastStep == true) goto L41;
        this.resetOccurred = false;
        if (r13.reset(r14, r4) == true) goto L45;
        r18.setSoftPreviousTime(r14);
        r18.setSoftCurrentTime(r5);
        if (r13.evaluateStep(r18) == false) goto L50;
        r9.add(r13);
    L50:
        r3 = r14;
        goto L20
    L45:
        r18.setInterpolatedTime(r14);
        System.arraycopy(r4, 0, r19, 0, r19.length);
        computeDerivatives(r14, r19, r20);
        this.resetOccurred = true;
        return r14;
    L41:
        System.arraycopy(r4, 0, r19, 0, r19.length);
        return r14;
    L51:
        r18.setInterpolatedTime(r5);
        double[] r2 = new double[r19.length];
        this.expandable.getPrimaryMapper().insertEquationData(r18.getInterpolatedState(), r2);
        EquationsMapper[] r26 = this.expandable.getSecondaryMappers();
        int r27 = r26.length;
        int r28 = 0;
        int r29 = 0;
    L52:
        if (r28 >= r27) goto L54;
        r26[r28].insertEquationData(r18.getInterpolatedSecondaryState(r29), r2);
        r28 = r28 + 1;
        r29 = r29 + 1;
        goto L52
    L54:
        Iterator<EventState> r30 = this.eventsStates.iterator();
    L56:
        if (r30.hasNext() == false) goto L66;
        EventState r31 = r30.next();
        r31.stepAccepted(r5, r2);
        if (this.isLastStep == false) goto L60;
    L63:
        boolean r32 = true;
    L64:
        this.isLastStep = r32;
        goto L56
    L60:
        if (r31.stop() == true) goto L63;
        r32 = false;
        goto L64
    L66:
        if (this.isLastStep == true) goto L71;
        boolean r33 = true;
        if (Precision.equals(r5, r21, 1) == true) goto L72;
        boolean r34 = false;
    L73:
        this.isLastStep = r34;
        Iterator<StepHandler> r35 = this.stepHandlers.iterator();
    L75:
        if (r35.hasNext() == false) goto L77;
        r35.next().handleStep(r18, this.isLastStep);
        goto L75
    L77:
        return r5;
    L72:
        r34 = r33;
        goto L73
    L71:
        r33 = true;
        goto L72
    L12:
        r8 = -1;
        goto L13
    }

    protected void sanityChecks(ExpandableStatefulODE r5, double r6) throws NumberIsTooSmallException, DimensionMismatchException {
        double r0 = FastMath.ulp(FastMath.max(FastMath.abs(r5.getTime()), FastMath.abs(r6))) * 1000.0d;
        double r4 = FastMath.abs(r5.getTime() - r6);
        if (r4 <= r0) goto L6;
        return;
    L6:
        throw new NumberIsTooSmallException(LocalizedFormats.TOO_SMALL_INTEGRATION_INTERVAL, Double.valueOf(r4), Double.valueOf(r0), false);
    }
}
