package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes6.dex */
public interface RealMatrixChangingVisitor {
    double end();

    void start(int r1, int r2, int r3, int r4, int r5, int r6);

    double visit(int r1, int r2, double r3);
}
