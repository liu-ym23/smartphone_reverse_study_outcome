package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class EvaluationRmsChecker implements ConvergenceChecker<LeastSquaresProblem.Evaluation> {
    private final double absTol;
    private final double relTol;

    @Override // org.apache.commons.math3.optim.ConvergenceChecker
    public /* bridge */ /* synthetic */ boolean converged(int r1, LeastSquaresProblem.Evaluation r2, LeastSquaresProblem.Evaluation r3) {
        return converged2(r1, r2, r3);
    }

    public EvaluationRmsChecker(double r1) {
        this(r1, r1);
    }

    public EvaluationRmsChecker(double r1, double r3) {
        this.relTol = r1;
        this.absTol = r3;
    }

    /* JADX INFO: renamed from: converged, reason: avoid collision after fix types in other method */
    public boolean converged2(int r9, LeastSquaresProblem.Evaluation r10, LeastSquaresProblem.Evaluation r11) {
        double r12 = r10.getRMS();
        double r6 = r11.getRMS();
        if (Precision.equals(r12, r6, this.absTol) == false) goto L5;
    L8:
        return true;
    L5:
        if (Precision.equalsWithRelativeTolerance(r12, r6, this.relTol) == true) goto L8;
        return false;
    }
}
