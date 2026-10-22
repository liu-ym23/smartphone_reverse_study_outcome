package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public interface WeightedEvaluation {
    double evaluate(double[] r1, double[] r2) throws MathIllegalArgumentException;

    double evaluate(double[] r1, double[] r2, int r3, int r4) throws MathIllegalArgumentException;
}
