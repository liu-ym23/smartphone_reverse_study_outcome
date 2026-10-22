package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public interface UnivariateInterpolator {
    UnivariateFunction interpolate(double[] r1, double[] r2) throws MathIllegalArgumentException, DimensionMismatchException;
}
