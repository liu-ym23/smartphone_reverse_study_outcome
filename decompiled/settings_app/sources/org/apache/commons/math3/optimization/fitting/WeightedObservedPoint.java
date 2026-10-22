package org.apache.commons.math3.optimization.fitting;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class WeightedObservedPoint implements Serializable {
    private static final long serialVersionUID = 5306874947404636157L;
    private final double weight;
    private final double x;
    private final double y;

    public WeightedObservedPoint(double r1, double r3, double r5) {
        this.weight = r1;
        this.x = r3;
        this.y = r5;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
