package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes6.dex */
public interface RealVectorChangingVisitor {
    double end();

    void start(int r1, int r2, int r3);

    double visit(int r1, double r2);
}
