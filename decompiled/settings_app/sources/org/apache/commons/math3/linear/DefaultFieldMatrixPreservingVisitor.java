package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultFieldMatrixPreservingVisitor<T extends FieldElement<T>> implements FieldMatrixPreservingVisitor<T> {
    private final T zero;

    @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
    public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
    public void visit(int r1, int r2, T r3) {
    }

    public DefaultFieldMatrixPreservingVisitor(T r1) {
        this.zero = r1;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
    public T end() {
        return this.zero;
    }
}
