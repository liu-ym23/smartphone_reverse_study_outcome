package org.apache.commons.math3.transform;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;

/* JADX INFO: loaded from: classes6.dex */
public interface RealTransformer {
    double[] transform(UnivariateFunction r1, double r2, double r4, int r6, TransformType r7) throws NonMonotonicSequenceException, NotStrictlyPositiveException, MathIllegalArgumentException;

    double[] transform(double[] r1, TransformType r2) throws MathIllegalArgumentException;
}
