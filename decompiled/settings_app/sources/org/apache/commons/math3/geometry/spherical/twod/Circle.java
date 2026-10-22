package org.apache.commons.math3.geometry.spherical.twod;

import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Transform;
import org.apache.commons.math3.geometry.spherical.oned.Arc;
import org.apache.commons.math3.geometry.spherical.oned.ArcsSet;
import org.apache.commons.math3.geometry.spherical.oned.S1Point;
import org.apache.commons.math3.geometry.spherical.oned.Sphere1D;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Circle implements Hyperplane<Sphere2D>, Embedding<Sphere2D, Sphere1D> {
    private Vector3D pole;
    private final double tolerance;
    private Vector3D x;
    private Vector3D y;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.spherical.twod.Circle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class CircleTransform implements Transform<Sphere2D, Sphere1D> {
        private final Rotation rotation;

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public SubHyperplane<Sphere1D> apply(SubHyperplane<Sphere1D> r1, Hyperplane<Sphere2D> r2, Hyperplane<Sphere2D> r3) {
            return r1;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Point apply(Point r1) {
            return apply(r1);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Hyperplane apply(Hyperplane r1) {
            return apply(r1);
        }

        CircleTransform(Rotation r1) {
            this.rotation = r1;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public S2Point apply(Point<Sphere2D> r2) {
            return new S2Point(this.rotation.applyTo(((S2Point) r2).getVector()));
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Circle apply(Hyperplane<Sphere2D> r9) {
            Circle r10 = (Circle) r9;
            return new Circle(this.rotation.applyTo(Circle.access$000(r10)), this.rotation.applyTo(Circle.access$100(r10)), this.rotation.applyTo(Circle.access$200(r10)), Circle.access$300(r10), null);
        }
    }

    /* synthetic */ Circle(Vector3D r1, Vector3D r2, Vector3D r3, double r4, AnonymousClass1 r6) {
        this(r1, r2, r3, r4);
    }

    static /* synthetic */ Vector3D access$000(Circle r0) {
        return r0.pole;
    }

    static /* synthetic */ Vector3D access$100(Circle r0) {
        return r0.x;
    }

    static /* synthetic */ Vector3D access$200(Circle r0) {
        return r0.y;
    }

    static /* synthetic */ double access$300(Circle r2) {
        return r2.tolerance;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Hyperplane copySelf() {
        return copySelf();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSpace(Point r1) {
        return toSpace(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSubSpace(Point r1) {
        return toSubSpace(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ SubHyperplane wholeHyperplane() {
        return wholeHyperplane();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Region wholeSpace() {
        return wholeSpace();
    }

    public Circle(Vector3D r1, double r2) {
        reset(r1);
        this.tolerance = r2;
    }

    public Circle(S2Point r1, S2Point r2, double r3) {
        reset(r1.getVector().crossProduct(r2.getVector()));
        this.tolerance = r3;
    }

    private Circle(Vector3D r1, Vector3D r2, Vector3D r3, double r4) {
        this.pole = r1;
        this.x = r2;
        this.y = r3;
        this.tolerance = r4;
    }

    public Circle(Circle r7) {
        this(r7.pole, r7.x, r7.y, r7.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Circle copySelf() {
        return new Circle(this);
    }

    public void reset(Vector3D r2) {
        this.pole = r2.normalize();
        Vector3D r0 = r2.orthogonal();
        this.x = r0;
        this.y = Vector3D.crossProduct(r2, r0).normalize();
    }

    public void revertSelf() {
        this.y = this.y.negate();
        this.pole = this.pole.negate();
    }

    public Circle getReverse() {
        return new Circle(this.pole.negate(), this.x, this.y.negate(), this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Point<Sphere2D> project(Point<Sphere2D> r1) {
        return toSpace(toSubSpace(r1));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getTolerance() {
        return this.tolerance;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public S1Point toSubSpace(Point<Sphere2D> r2) {
        return new S1Point(getPhase(((S2Point) r2).getVector()));
    }

    public double getPhase(Vector3D r3) {
        return FastMath.atan2(-r3.dotProduct(this.y), -r3.dotProduct(this.x)) + 3.141592653589793d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public S2Point toSpace(Point<Sphere1D> r4) {
        return new S2Point(getPointAt(((S1Point) r4).getAlpha()));
    }

    public Vector3D getPointAt(double r9) {
        return new Vector3D(FastMath.cos(r9), this.x, FastMath.sin(r9), this.y);
    }

    public Vector3D getXAxis() {
        return this.x;
    }

    public Vector3D getYAxis() {
        return this.y;
    }

    public Vector3D getPole() {
        return this.pole;
    }

    public Arc getInsideArc(Circle r10) {
        double r0 = getPhase(r10.pole);
        return new Arc(r0 - 1.5707963267948966d, r0 + 1.5707963267948966d, this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubCircle wholeHyperplane() {
        return new SubCircle(this, new ArcsSet(this.tolerance));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SphericalPolygonsSet wholeSpace() {
        return new SphericalPolygonsSet(this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Sphere2D> r1) {
        return getOffset(((S2Point) r1).getVector());
    }

    public double getOffset(Vector3D r3) {
        return Vector3D.angle(this.pole, r3) - 1.5707963267948966d;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Sphere2D> r3) {
        if (Vector3D.dotProduct(this.pole, ((Circle) r3).pole) < 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    public static Transform<Sphere2D, Sphere1D> getTransform(Rotation r1) {
        return new CircleTransform(r1);
    }
}
