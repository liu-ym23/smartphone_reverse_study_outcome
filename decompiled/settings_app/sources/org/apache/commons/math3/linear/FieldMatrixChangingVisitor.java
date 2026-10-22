package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldMatrixChangingVisitor<T extends FieldElement<?>> {
    T end();

    void start(int r1, int r2, int r3, int r4, int r5, int r6);

    T visit(int r1, int r2, T r3);
}
