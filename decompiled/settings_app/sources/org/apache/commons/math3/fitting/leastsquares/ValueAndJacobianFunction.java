package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
public interface ValueAndJacobianFunction extends MultivariateJacobianFunction {
    RealMatrix computeJacobian(double[] r1);

    RealVector computeValue(double[] r1);
}
