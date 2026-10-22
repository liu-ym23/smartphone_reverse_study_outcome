package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Pow implements BivariateFunction {
    public Pow() {
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double r1, double r3) {
        return FastMath.pow(r1, r3);
    }
}
