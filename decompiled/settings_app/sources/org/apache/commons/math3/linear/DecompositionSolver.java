package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes6.dex */
public interface DecompositionSolver {
    RealMatrix getInverse() throws SingularMatrixException;

    boolean isNonSingular();

    RealMatrix solve(RealMatrix r1) throws SingularMatrixException;

    RealVector solve(RealVector r1) throws SingularMatrixException;
}
