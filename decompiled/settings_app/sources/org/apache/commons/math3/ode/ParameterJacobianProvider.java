package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public interface ParameterJacobianProvider extends Parameterizable {
    void computeParameterJacobian(double r1, double[] r3, double[] r4, String r5, double[] r6) throws DimensionMismatchException, MaxCountExceededException, UnknownParameterException;
}
