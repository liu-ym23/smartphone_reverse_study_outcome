package org.apache.commons.math3.geometry.partitioning;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class BoundaryProjection<S extends Space> {
    private final double offset;
    private final Point<S> original;
    private final Point<S> projected;

    public BoundaryProjection(Point<S> r1, Point<S> r2, double r3) {
        this.original = r1;
        this.projected = r2;
        this.offset = r3;
    }

    public Point<S> getOriginal() {
        return this.original;
    }

    public Point<S> getProjected() {
        return this.projected;
    }

    public double getOffset() {
        return this.offset;
    }
}
