package org.apache.commons.math3.analysis.differentiation;

import org.apache.commons.math3.analysis.UnivariateMatrixFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public interface UnivariateDifferentiableMatrixFunction extends UnivariateMatrixFunction {
    DerivativeStructure[][] value(DerivativeStructure r1) throws MathIllegalArgumentException;
}
