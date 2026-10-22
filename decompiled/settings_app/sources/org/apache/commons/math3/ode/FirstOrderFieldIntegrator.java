package org.apache.commons.math3.ode;

import java.util.Collection;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ode.events.FieldEventHandler;
import org.apache.commons.math3.ode.sampling.FieldStepHandler;

/* JADX INFO: loaded from: classes6.dex */
public interface FirstOrderFieldIntegrator<T extends RealFieldElement<T>> {
    void addEventHandler(FieldEventHandler<T> r1, double r2, double r4, int r6);

    void addEventHandler(FieldEventHandler<T> r1, double r2, double r4, int r6, BracketedRealFieldUnivariateSolver<T> r7);

    void addStepHandler(FieldStepHandler<T> r1);

    void clearEventHandlers();

    void clearStepHandlers();

    T getCurrentSignedStepsize();

    FieldODEStateAndDerivative<T> getCurrentStepStart();

    int getEvaluations();

    Collection<FieldEventHandler<T>> getEventHandlers();

    int getMaxEvaluations();

    String getName();

    Collection<FieldStepHandler<T>> getStepHandlers();

    FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> r1, FieldODEState<T> r2, T r3) throws NumberIsTooSmallException, MaxCountExceededException, NoBracketingException;

    void setMaxEvaluations(int r1);
}
