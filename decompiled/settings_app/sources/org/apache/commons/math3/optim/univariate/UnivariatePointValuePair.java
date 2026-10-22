package org.apache.commons.math3.optim.univariate;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class UnivariatePointValuePair implements Serializable {
    private static final long serialVersionUID = 1003888396256744753L;
    private final double point;
    private final double value;

    public UnivariatePointValuePair(double r1, double r3) {
        this.point = r1;
        this.value = r3;
    }

    public double getPoint() {
        return this.point;
    }

    public double getValue() {
        return this.value;
    }
}
