package org.apache.commons.math3.geometry.euclidean.threed;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class Line implements Embedding<Euclidean3D, Euclidean1D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private Vector3D direction;
    private final double tolerance;
    private Vector3D zero;

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSpace(Point r1) {
        return toSpace(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public /* bridge */ /* synthetic */ Point toSubSpace(Point r1) {
        return toSubSpace(r1);
    }

    public Line(Vector3D r1, Vector3D r2, double r3) throws MathIllegalArgumentException {
        reset(r1, r2);
        this.tolerance = r3;
    }

    public Line(Line r3) {
        this.direction = r3.direction;
        this.zero = r3.zero;
        this.tolerance = r3.tolerance;
    }

    @Deprecated
    public Line(Vector3D r3, Vector3D r4) throws MathIllegalArgumentException {
        this(r3, r4, 1.0E-10d);
    }

    public void reset(Vector3D r8, Vector3D r9) throws MathIllegalArgumentException {
        Vector3D r6 = r9.subtract(r8);
        double r0 = r6.getNormSq();
        if (r0 == 0.0d) goto L7;
        this.direction = new Vector3D(1.0d / FastMath.sqrt(r0), r6);
        this.zero = new Vector3D(1.0d, r8, (-r8.dotProduct(r6)) / r0, r6);
        return;
    L7:
        throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public double getTolerance() {
        return this.tolerance;
    }

    public Line revert() {
        Line r0 = new Line(this);
        r0.direction = r0.direction.negate();
        return r0;
    }

    public Vector3D getDirection() {
        return this.direction;
    }

    public Vector3D getOrigin() {
        return this.zero;
    }

    public double getAbscissa(Vector3D r2) {
        return r2.subtract(this.zero).dotProduct(this.direction);
    }

    public Vector3D pointAt(double r9) {
        return new Vector3D(1.0d, this.zero, r9, this.direction);
    }

    public Vector1D toSubSpace(Vector<Euclidean3D> r1) {
        return toSubSpace(r1);
    }

    public Vector3D toSpace(Vector<Euclidean1D> r1) {
        return toSpace(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector1D toSubSpace(Point<Euclidean3D> r2) {
        return new Vector1D(getAbscissa((Vector3D) r2));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector3D toSpace(Point<Euclidean1D> r3) {
        return pointAt(((Vector1D) r3).getX());
    }

    public boolean isSimilarTo(Line r7) {
        double r0 = Vector3D.angle(this.direction, r7.direction);
        double r2 = this.tolerance;
        if (r0 < r2) goto L7;
        if (r0 > (3.141592653589793d - r2)) goto L7;
    L9:
        return false;
    L7:
        if (contains(r7.zero) == false) goto L9;
        return true;
    }

    public boolean contains(Vector3D r3) {
        if (distance(r3) >= this.tolerance) goto L5;
        return true;
    L5:
        return false;
    }

    public double distance(Vector3D r9) {
        Vector3D r4 = r9.subtract(this.zero);
        return new Vector3D(1.0d, r4, -r4.dotProduct(this.direction), this.direction).getNorm();
    }

    public double distance(Line r6) {
        Vector3D r0 = Vector3D.crossProduct(this.direction, r6.direction);
        double r1 = r0.getNorm();
        if (r1 >= Precision.SAFE_MIN) goto L7;
        return distance(r6.zero);
    L7:
        return FastMath.abs(r6.zero.subtract(this.zero).dotProduct(r0) / r1);
    }

    public Vector3D closestPoint(Line r19) {
        double r2 = this.direction.dotProduct(r19.direction);
        double r4 = 1.0d - (r2 * r2);
        if (r4 < Precision.EPSILON) goto L5;
        Vector3D r6 = r19.zero.subtract(this.zero);
        double r7 = r6.dotProduct(this.direction);
        double r9 = r6.dotProduct(r19.direction);
        return new Vector3D(1.0d, this.zero, (r7 - (r9 * r2)) / r4, this.direction);
    L5:
        return this.zero;
    }

    public Vector3D intersection(Line r1) {
        Vector3D r0 = closestPoint(r1);
        if (r1.contains(r0) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public SubLine wholeLine() {
        return new SubLine(this, new IntervalsSet(this.tolerance));
    }
}
