package org.apache.commons.math3.ode;

import java.util.Collection;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.sampling.StepHandler;

/* JADX INFO: loaded from: classes6.dex */
public interface ODEIntegrator {
    void addEventHandler(EventHandler r1, double r2, double r4, int r6);

    void addEventHandler(EventHandler r1, double r2, double r4, int r6, UnivariateSolver r7);

    void addStepHandler(StepHandler r1);

    void clearEventHandlers();

    void clearStepHandlers();

    double getCurrentSignedStepsize();

    double getCurrentStepStart();

    int getEvaluations();

    Collection<EventHandler> getEventHandlers();

    int getMaxEvaluations();

    String getName();

    Collection<StepHandler> getStepHandlers();

    void setMaxEvaluations(int r1);
}
