package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldVectorChangingVisitor<T extends FieldElement<?>> {
    T end();

    void start(int r1, int r2, int r3);

    T visit(int r1, T r2);
}
