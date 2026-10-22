package org.apache.commons.math3.geometry.enclosing;

import java.io.Serializable;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class EnclosingBall<S extends Space, P extends Point<S>> implements Serializable {
    private static final long serialVersionUID = 20140126;
    private final P center;
    private final double radius;
    private final P[] support;

    public EnclosingBall(P r1, double r2, P... r4) {
        this.center = r1;
        this.radius = r2;
        this.support = (P[]) ((Point[]) r4.clone());
    }

    public P getCenter() {
        return this.center;
    }

    public double getRadius() {
        return this.radius;
    }

    public P[] getSupport() {
        return (P[]) ((Point[]) this.support.clone());
    }

    public int getSupportSize() {
        return this.support.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(P r3) {
        if (r3.distance(this.center) > this.radius) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(P r3, double r4) {
        if (r3.distance(this.center) > (this.radius + r4)) goto L5;
        return true;
    L5:
        return false;
    }
}
