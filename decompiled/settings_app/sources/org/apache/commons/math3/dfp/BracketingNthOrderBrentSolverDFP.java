package org.apache.commons.math3.dfp;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BracketingNthOrderBrentSolverDFP extends FieldBracketingNthOrderBrentSolver<Dfp> {
    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public /* bridge */ /* synthetic */ RealFieldElement getAbsoluteAccuracy() {
        return getAbsoluteAccuracy();
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public /* bridge */ /* synthetic */ RealFieldElement getFunctionValueAccuracy() {
        return getFunctionValueAccuracy();
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public /* bridge */ /* synthetic */ RealFieldElement getRelativeAccuracy() {
        return getRelativeAccuracy();
    }

    public BracketingNthOrderBrentSolverDFP(Dfp r1, Dfp r2, Dfp r3, int r4) throws NumberIsTooSmallException {
        super(r1, r2, r3, r4);
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public Dfp getAbsoluteAccuracy() {
        return (Dfp) super.getAbsoluteAccuracy();
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public Dfp getRelativeAccuracy() {
        return (Dfp) super.getRelativeAccuracy();
    }

    @Override // org.apache.commons.math3.analysis.solvers.FieldBracketingNthOrderBrentSolver, org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver
    public Dfp getFunctionValueAccuracy() {
        return (Dfp) super.getFunctionValueAccuracy();
    }

    public Dfp solve(int r10, UnivariateDfpFunction r11, Dfp r12, Dfp r13, AllowedSolution r14) throws NullArgumentException, NoBracketingException {
        return solve(r10, r11, r12, r13, r12.add(r13).divide(2), r14);
    }

    public Dfp solve(int r8, final UnivariateDfpFunction r9, Dfp r10, Dfp r11, Dfp r12, AllowedSolution r13) throws NullArgumentException, NoBracketingException {
        MathUtils.checkNotNull(r9);
        return solve(r8, new AnonymousClass1(this, r9), r10, r11, r12, r13);
    }
}
