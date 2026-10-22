package org.apache.commons.math3.geometry.spherical.oned;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class LimitAngle implements Hyperplane<Sphere1D> {
    private boolean direct;
    private S1Point location;
    private final double tolerance;

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public LimitAngle copySelf() {
        return this;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Hyperplane copySelf() {
        return copySelf();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ SubHyperplane wholeHyperplane() {
        return wholeHyperplane();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Region wholeSpace() {
        return wholeSpace();
    }

    public LimitAngle(S1Point r1, boolean r2, double r3) {
        this.location = r1;
        this.direct = r2;
        this.tolerance = r3;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Sphere1D> r5) {
        double r0 = ((S1Point) r5).getAlpha() - this.location.getAlpha();
        if (this.direct == false) goto L6;
        return r0;
    L6:
        return -r0;
    }

    public boolean isDirect() {
        return this.direct;
    }

    public LimitAngle getReverse() {
        return new LimitAngle(this.location, !this.direct, this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubLimitAngle wholeHyperplane() {
        return new SubLimitAngle(this, null);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public ArcsSet wholeSpace() {
        return new ArcsSet(this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Sphere1D> r1) {
        return !(this.direct ^ ((LimitAngle) r1).direct);
    }

    public S1Point getLocation() {
        return this.location;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Point<Sphere1D> project(Point<Sphere1D> r1) {
        return this.location;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getTolerance() {
        return this.tolerance;
    }
}
