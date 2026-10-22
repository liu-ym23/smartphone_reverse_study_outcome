package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultRealMatrixChangingVisitor implements RealMatrixChangingVisitor {
    @Override // org.apache.commons.math3.linear.RealMatrixChangingVisitor
    public double end() {
        return 0.0d;
    }

    @Override // org.apache.commons.math3.linear.RealMatrixChangingVisitor
    public void start(int r1, int r2, int r3, int r4, int r5, int r6) {
    }

    @Override // org.apache.commons.math3.linear.RealMatrixChangingVisitor
    public double visit(int r1, int r2, double r3) {
        return r3;
    }

    public DefaultRealMatrixChangingVisitor() {
    }
}
