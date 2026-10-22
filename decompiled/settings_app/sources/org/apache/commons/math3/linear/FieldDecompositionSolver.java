package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldDecompositionSolver<T extends FieldElement<T>> {
    FieldMatrix<T> getInverse();

    boolean isNonSingular();

    FieldMatrix<T> solve(FieldMatrix<T> r1);

    FieldVector<T> solve(FieldVector<T> r1);
}
