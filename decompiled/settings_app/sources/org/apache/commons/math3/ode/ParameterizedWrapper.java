package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
class ParameterizedWrapper implements ParameterizedODE {
    private final FirstOrderDifferentialEquations fode;

    @Override // org.apache.commons.math3.ode.Parameterizable
    public boolean isSupported(String r1) {
        return false;
    }

    @Override // org.apache.commons.math3.ode.ParameterizedODE
    public void setParameter(String r1, double r2) {
    }

    ParameterizedWrapper(FirstOrderDifferentialEquations r1) {
        this.fode = r1;
    }

    public int getDimension() {
        return this.fode.getDimension();
    }

    public void computeDerivatives(double r1, double[] r3, double[] r4) throws MaxCountExceededException, DimensionMismatchException {
        this.fode.computeDerivatives(r1, r3, r4);
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public Collection<String> getParametersNames() {
        return new ArrayList();
    }

    @Override // org.apache.commons.math3.ode.ParameterizedODE
    public double getParameter(String r1) throws UnknownParameterException {
        if (isSupported(r1) == false) goto L7;
        return Double.NaN;
    L7:
        throw new UnknownParameterException(r1);
    }
}
