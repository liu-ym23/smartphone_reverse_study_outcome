package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Rint implements UnivariateFunction {
    public Rint() {
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r1) {
        return FastMath.rint(r1);
    }
}
