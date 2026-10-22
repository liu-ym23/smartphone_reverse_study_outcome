package org.apache.commons.math3.geometry.euclidean.threed;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Plane implements Hyperplane<Euclidean3D>, Embedding<Euclidean3D, Euclidean2D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private Vector3D origin;
    private double originOffset;
    private final double tolerance;
    private Vector3D u;
    private Vector3D v;
    private Vector3D w;

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

    public Plane(Vector3D r1, double r2) throws MathArithmeticException {
        setNormal(r1);
        this.tolerance = r2;
        this.originOffset = 0.0d;
        setFrame();
    }

    public Plane(Vector3D r1, Vector3D r2, double r3) throws MathArithmeticException {
        setNormal(r2);
        this.tolerance = r3;
        this.originOffset = -r1.dotProduct(this.w);
        setFrame();
    }

    public Plane(Vector3D r1, Vector3D r2, Vector3D r3, double r4) throws MathArithmeticException {
        this(r1, r2.subtract(r1).crossProduct(r3.subtract(r1)), r4);
    }

    @Deprecated
    public Plane(Vector3D r3) throws MathArithmeticException {
        this(r3, 1.0E-10d);
    }

    @Deprecated
    public Plane(Vector3D r3, Vector3D r4) throws MathArithmeticException {
        this(r3, r4, 1.0E-10d);
    }

    @Deprecated
    public Plane(Vector3D r7, Vector3D r8, Vector3D r9) throws MathArithmeticException {
        this(r7, r8, r9, 1.0E-10d);
    }

    public Plane(Plane r3) {
        this.originOffset = r3.originOffset;
        this.origin = r3.origin;
        this.u = r3.u;
        this.v = r3.v;
        this.w = r3.w;
        this.tolerance = r3.tolerance;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Plane copySelf() {
        return new Plane(this);
    }

    public void reset(Vector3D r1, Vector3D r2) throws MathArithmeticException {
        setNormal(r2);
        this.originOffset = -r1.dotProduct(this.w);
        setFrame();
    }

    public void reset(Plane r3) {
        this.originOffset = r3.originOffset;
        this.origin = r3.origin;
        this.u = r3.u;
        this.v = r3.v;
        this.w = r3.w;
    }

    private void setNormal(Vector3D r6) throws MathArithmeticException {
        double r0 = r6.getNorm();
        if (r0 < 1.0E-10d) goto L7;
        this.w = new Vector3D(1.0d / r0, r6);
        return;
    L7:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    private void setFrame() {
        this.origin = new Vector3D(-this.originOffset, this.w);
        Vector3D r0 = this.w.orthogonal();
        this.u = r0;
        this.v = Vector3D.crossProduct(this.w, r0);
    }

    public Vector3D getOrigin() {
        return this.origin;
    }

    public Vector3D getNormal() {
        return this.w;
    }

    public Vector3D getU() {
        return this.u;
    }

    public Vector3D getV() {
        return this.v;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Point<Euclidean3D> project(Point<Euclidean3D> r1) {
        return toSpace(toSubSpace(r1));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getTolerance() {
        return this.tolerance;
    }

    public void revertSelf() {
        Vector3D r0 = this.u;
        this.u = this.v;
        this.v = r0;
        this.w = this.w.negate();
        this.originOffset = -this.originOffset;
    }

    public Vector2D toSubSpace(Vector<Euclidean3D> r1) {
        return toSubSpace(r1);
    }

    public Vector3D toSpace(Vector<Euclidean2D> r1) {
        return toSpace(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector2D toSubSpace(Point<Euclidean3D> r4) {
        Vector3D r5 = (Vector3D) r4;
        return new Vector2D(r5.dotProduct(this.u), r5.dotProduct(this.v));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector3D toSpace(Point<Euclidean2D> r12) {
        Vector2D r13 = (Vector2D) r12;
        return new Vector3D(r13.getX(), this.u, r13.getY(), this.v, -this.originOffset, this.w);
    }

    public Vector3D getPointAt(Vector2D r12, double r13) {
        return new Vector3D(r12.getX(), this.u, r12.getY(), this.v, r13 - this.originOffset, this.w);
    }

    public boolean isSimilarTo(Plane r7) {
        double r0 = Vector3D.angle(this.w, r7.w);
        if (r0 >= 1.0E-10d) goto L7;
        if (FastMath.abs(this.originOffset - r7.originOffset) >= this.tolerance) goto L7;
    L10:
        return true;
    L7:
        if (r0 > 3.141592653489793d) goto L9;
    L11:
        return false;
    L9:
        if (FastMath.abs(this.originOffset + r7.originOffset) >= this.tolerance) goto L11;
        goto L10
    }

    public Plane rotate(Vector3D r5, Rotation r6) {
        Plane r1 = new Plane(r5.add(r6.applyTo(this.origin.subtract(r5))), r6.applyTo(this.w), this.tolerance);
        r1.u = r6.applyTo(this.u);
        r1.v = r6.applyTo(this.v);
        return r1;
    }

    public Plane translate(Vector3D r5) {
        Plane r0 = new Plane(this.origin.add(r5), this.w, this.tolerance);
        r0.u = this.u;
        r0.v = this.v;
        return r0;
    }

    public Vector3D intersection(Line r8) {
        Vector3D r6 = r8.getDirection();
        double r0 = this.w.dotProduct(r6);
        if (FastMath.abs(r0) >= 1.0E-10d) goto L6;
        return null;
    L6:
        Vector3D r3 = r8.toSpace(Vector1D.ZERO);
        return new Vector3D(1.0d, r3, (-(this.originOffset + this.w.dotProduct(r3))) / r0, r6);
    }

    public Line intersection(Plane r6) {
        Vector3D r0 = Vector3D.crossProduct(this.w, r6.w);
        double r1 = r0.getNorm();
        double r3 = this.tolerance;
        if (r1 >= r3) goto L6;
        return null;
    L6:
        Vector3D r7 = intersection(this, r6, new Plane(r0, r3));
        return new Line(r7, r7.add(r0), this.tolerance);
    }

    public static Vector3D intersection(Plane r40, Plane r41, Plane r42) {
        double r3 = r40.w.getX();
        double r5 = r40.w.getY();
        double r7 = r40.w.getZ();
        double r9 = r40.originOffset;
        double r11 = r41.w.getX();
        double r13 = r41.w.getY();
        double r15 = r41.w.getZ();
        double r0 = r41.originOffset;
        double r1 = r42.w.getX();
        double r10 = r42.w.getY();
        double r8 = r42.w.getZ();
        double r6 = r42.originOffset;
        double r12 = (r13 * r8) - (r10 * r15);
        double r14 = (r15 * r1) - (r8 * r11);
        double r16 = (r11 * r10) - (r1 * r13);
        double r23 = ((r3 * r12) + (r5 * r14)) + (r7 * r16);
        if (FastMath.abs(r23) >= 1.0E-10d) goto L6;
        return null;
    L6:
        double r25 = 1.0d / r23;
        return new Vector3D(((((-r12) * r9) - (((r7 * r10) - (r8 * r5)) * r0)) - (((r15 * r5) - (r7 * r13)) * r6)) * r25, ((((-r14) * r9) - (((r8 * r3) - (r7 * r1)) * r0)) - (((r7 * r11) - (r15 * r3)) * r6)) * r25, ((((-r16) * r9) - (((r1 * r5) - (r10 * r3)) * r0)) - (((r13 * r3) - (r5 * r11)) * r6)) * r25);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubPlane wholeHyperplane() {
        return new SubPlane(this, new PolygonsSet(this.tolerance));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public PolyhedronsSet wholeSpace() {
        return new PolyhedronsSet(this.tolerance);
    }

    public boolean contains(Vector3D r3) {
        if (FastMath.abs(getOffset(r3)) >= this.tolerance) goto L5;
        return true;
    L5:
        return false;
    }

    public double getOffset(Plane r3) {
        double r0 = this.originOffset;
        if (sameOrientationAs(r3) == false) goto L5;
        double r2 = -r3.originOffset;
    L7:
        return r0 + r2;
    L5:
        r2 = r3.originOffset;
        goto L7
    }

    public double getOffset(Vector<Euclidean3D> r1) {
        return getOffset(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Euclidean3D> r3) {
        return ((Vector3D) r3).dotProduct(this.w) + this.originOffset;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Euclidean3D> r3) {
        if (((Plane) r3).w.dotProduct(this.w) <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }
}
