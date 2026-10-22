package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Max implements BivariateFunction {
    public Max() {
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double r1, double r3) {
        return FastMath.max(r1, r3);
    }
}
