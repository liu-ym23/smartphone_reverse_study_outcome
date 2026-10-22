package org.apache.commons.math3.ode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
class ParameterJacobianWrapper implements ParameterJacobianProvider {
    private final FirstOrderDifferentialEquations fode;
    private final Map<String, Double> hParam;
    private final ParameterizedODE pode;

    ParameterJacobianWrapper(FirstOrderDifferentialEquations r7, ParameterizedODE r8, ParameterConfiguration[] r9) {
        this.fode = r7;
        this.pode = r8;
        this.hParam = new HashMap();
        int r10 = r9.length;
        int r0 = 0;
    L3:
        if (r0 >= r10) goto L8;
        ParameterConfiguration r1 = r9[r0];
        String r2 = r1.getParameterName();
        if (r8.isSupported(r2) == false) goto L7;
        this.hParam.put(r2, Double.valueOf(r1.getHP()));
    L7:
        r0 = r0 + 1;
        goto L3
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public Collection<String> getParametersNames() {
        return this.pode.getParametersNames();
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public boolean isSupported(String r1) {
        return this.pode.isSupported(r1);
    }

    @Override // org.apache.commons.math3.ode.ParameterJacobianProvider
    public void computeParameterJacobian(double r15, double[] r17, double[] r18, String r19, double[] r20) throws DimensionMismatchException, MaxCountExceededException {
        int r3 = this.fode.getDimension();
        int r5 = 0;
        if (this.pode.isSupported(r19) == false) goto L8;
        double[] r4 = new double[r3];
        double r6 = this.pode.getParameter(r19);
        double r8 = this.hParam.get(r19).doubleValue();
        this.pode.setParameter(r19, r6 + r8);
        this.fode.computeDerivatives(r15, r17, r4);
    L5:
        if (r5 >= r3) goto L7;
        r20[r5] = (r4[r5] - r18[r5]) / r8;
        r5 = r5 + 1;
        goto L5
    L7:
        this.pode.setParameter(r19, r6);
        return;
    L8:
        Arrays.fill(r20, 0, r3, 0.0d);
    }
}
