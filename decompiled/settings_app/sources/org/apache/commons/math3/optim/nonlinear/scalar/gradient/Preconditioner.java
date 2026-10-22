package org.apache.commons.math3.optim.nonlinear.scalar.gradient;

/* JADX INFO: loaded from: classes6.dex */
public interface Preconditioner {
    double[] precondition(double[] r1, double[] r2);
}
