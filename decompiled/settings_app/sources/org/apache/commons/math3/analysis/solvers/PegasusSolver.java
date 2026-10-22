package org.apache.commons.math3.analysis.solvers;

/* JADX INFO: loaded from: classes6.dex */
public class PegasusSolver extends BaseSecantSolver {
    public PegasusSolver() {
        super(1.0E-6d, BaseSecantSolver.Method.PEGASUS);
    }

    public PegasusSolver(double r2) {
        super(r2, BaseSecantSolver.Method.PEGASUS);
    }

    public PegasusSolver(double r7, double r9) {
        super(r7, r9, BaseSecantSolver.Method.PEGASUS);
    }

    public PegasusSolver(double r9, double r11, double r13) {
        super(r9, r11, r13, BaseSecantSolver.Method.PEGASUS);
    }
}
