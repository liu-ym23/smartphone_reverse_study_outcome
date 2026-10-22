package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Min implements BivariateFunction {
    public Min() {
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double r1, double r3) {
        return FastMath.min(r1, r3);
    }
}
