package org.apache.commons.math3.geometry.euclidean.twod;

import java.awt.geom.AffineTransform;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.OrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Transform;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Line implements Hyperplane<Euclidean2D>, Embedding<Euclidean2D, Euclidean1D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private double angle;
    private double cos;
    private double originOffset;
    private Line reverse;
    private double sin;
    private final double tolerance;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.euclidean.twod.Line$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LineTransform implements Transform<Euclidean2D, Euclidean1D> {
        private double c11;
        private double c1X;
        private double c1Y;
        private double cX1;
        private double cXX;
        private double cXY;
        private double cY1;
        private double cYX;
        private double cYY;

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Point apply(Point r1) {
            return apply(r1);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Hyperplane apply(Hyperplane r1) {
            return apply(r1);
        }

        LineTransform(double r18, double r20, double r22, double r24, double r26, double r28) throws MathIllegalArgumentException {
            this.cXX = r18;
            this.cYX = r20;
            this.cXY = r22;
            this.cYY = r24;
            this.cX1 = r26;
            this.cY1 = r28;
            this.c1Y = MathArrays.linearCombination(r22, r28, -r24, r26);
            double r1 = -r20;
            this.c1X = MathArrays.linearCombination(r18, r28, r1, r26);
            double r2 = MathArrays.linearCombination(r18, r24, r1, r22);
            this.c11 = r2;
            if (FastMath.abs(r2) < 1.0E-20d) goto L6;
            return;
        L6:
            throw new MathIllegalArgumentException(LocalizedFormats.NON_INVERTIBLE_TRANSFORM, new Object[0]);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Vector2D apply(Point<Euclidean2D> r21) {
            Vector2D r1 = (Vector2D) r21;
            double r14 = r1.getX();
            double r16 = r1.getY();
            return new Vector2D(MathArrays.linearCombination(this.cXX, r14, this.cXY, r16, this.cX1, 1.0d), MathArrays.linearCombination(this.cYX, r14, this.cYY, r16, this.cY1, 1.0d));
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Line apply(Hyperplane<Euclidean2D> r25) {
            Line r1 = (Line) r25;
            double r2 = MathArrays.linearCombination(this.c1X, Line.access$000(r1), this.c1Y, Line.access$100(r1), this.c11, Line.access$200(r1));
            double r4 = MathArrays.linearCombination(this.cXX, Line.access$000(r1), this.cXY, Line.access$100(r1));
            double r6 = MathArrays.linearCombination(this.cYX, Line.access$000(r1), this.cYY, Line.access$100(r1));
            double r10 = 1.0d / FastMath.sqrt((r6 * r6) + (r4 * r4));
            return new Line(FastMath.atan2(-r6, -r4) + 3.141592653589793d, r10 * r4, r10 * r6, r10 * r2, Line.access$300(r1), null);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public SubHyperplane<Euclidean1D> apply(SubHyperplane<Euclidean1D> r3, Hyperplane<Euclidean2D> r4, Hyperplane<Euclidean2D> r5) {
            OrientedPoint r6 = (OrientedPoint) r3.getHyperplane();
            Line r7 = (Line) r4;
            return new OrientedPoint(((Line) r5).toSubSpace(apply(r7.toSpace(r6.getLocation()))), r6.isDirect(), Line.access$300(r7)).wholeHyperplane();
        }
    }

    /* synthetic */ Line(double r1, double r3, double r5, double r7, double r9, AnonymousClass1 r11) {
        this(r1, r3, r5, r7, r9);
    }

    static /* synthetic */ double access$000(Line r2) {
        return r2.cos;
    }

    static /* synthetic */ double access$100(Line r2) {
        return r2.sin;
    }

    static /* synthetic */ double access$200(Line r2) {
        return r2.originOffset;
    }

    static /* synthetic */ double access$300(Line r2) {
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

    public Line(Vector2D r1, Vector2D r2, double r3) {
        reset(r1, r2);
        this.tolerance = r3;
    }

    public Line(Vector2D r1, double r2, double r4) {
        reset(r1, r2);
        this.tolerance = r4;
    }

    private Line(double r1, double r3, double r5, double r7, double r9) {
        this.angle = r1;
        this.cos = r3;
        this.sin = r5;
        this.originOffset = r7;
        this.tolerance = r9;
        this.reverse = null;
    }

    @Deprecated
    public Line(Vector2D r3, Vector2D r4) {
        this(r3, r4, 1.0E-10d);
    }

    @Deprecated
    public Line(Vector2D r7, double r8) {
        this(r7, r8, 1.0E-10d);
    }

    public Line(Line r5) {
        this.angle = MathUtils.normalizeAngle(r5.angle, 3.141592653589793d);
        this.cos = r5.cos;
        this.sin = r5.sin;
        this.originOffset = r5.originOffset;
        this.tolerance = r5.tolerance;
        this.reverse = null;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Line copySelf() {
        return new Line(this);
    }

    public void reset(Vector2D r16, Vector2D r17) {
        unlinkReverse();
        double r1 = r17.getX() - r16.getX();
        double r3 = r17.getY() - r16.getY();
        double r5 = FastMath.hypot(r1, r3);
        if (r5 != 0.0d) goto L5;
        this.angle = 0.0d;
        this.cos = 1.0d;
        this.sin = 0.0d;
        this.originOffset = r16.getY();
        return;
    L5:
        this.angle = FastMath.atan2(-r3, -r1) + 3.141592653589793d;
        this.cos = r1 / r5;
        this.sin = r3 / r5;
        this.originOffset = MathArrays.linearCombination(r17.getX(), r16.getY(), -r16.getX(), r17.getY()) / r5;
    }

    public void reset(Vector2D r9, double r10) {
        unlinkReverse();
        double r11 = MathUtils.normalizeAngle(r10, 3.141592653589793d);
        this.angle = r11;
        this.cos = FastMath.cos(r11);
        this.sin = FastMath.sin(this.angle);
        this.originOffset = MathArrays.linearCombination(this.cos, r9.getY(), -this.sin, r9.getX());
    }

    public void revertSelf() {
        unlinkReverse();
        double r0 = this.angle;
        if (r0 >= 3.141592653589793d) goto L5;
        this.angle = r0 + 3.141592653589793d;
    L6:
        this.cos = -this.cos;
        this.sin = -this.sin;
        this.originOffset = -this.originOffset;
        return;
    L5:
        this.angle = r0 - 3.141592653589793d;
        goto L6
    }

    private void unlinkReverse() {
        Line r0 = this.reverse;
        if (r0 == null) goto L5;
        r0.reverse = null;
    L5:
        this.reverse = null;
    }

    public Line getReverse() {
        if (this.reverse != null) goto L10;
        double r1 = this.angle;
        if (r1 >= 3.141592653589793d) goto L7;
        double r2 = r1 + 3.141592653589793d;
    L8:
        Line r0 = new Line(r2, -this.cos, -this.sin, -this.originOffset, this.tolerance);
        this.reverse = r0;
        r0.reverse = this;
        goto L10
    L7:
        r2 = r1 - 3.141592653589793d;
    L10:
        return this.reverse;
    }

    public Vector1D toSubSpace(Vector<Euclidean2D> r1) {
        return toSubSpace(r1);
    }

    public Vector2D toSpace(Vector<Euclidean1D> r1) {
        return toSpace(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector1D toSubSpace(Point<Euclidean2D> r10) {
        Vector2D r11 = (Vector2D) r10;
        return new Vector1D(MathArrays.linearCombination(this.cos, r11.getX(), this.sin, r11.getY()));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Embedding
    public Vector2D toSpace(Point<Euclidean1D> r13) {
        double r8 = ((Vector1D) r13).getX();
        return new Vector2D(MathArrays.linearCombination(r8, this.cos, -this.originOffset, this.sin), MathArrays.linearCombination(r8, this.sin, this.originOffset, this.cos));
    }

    public Vector2D intersection(Line r14) {
        double r0 = MathArrays.linearCombination(this.sin, r14.cos, -r14.sin, this.cos);
        if (FastMath.abs(r0) >= this.tolerance) goto L7;
        return null;
    L7:
        return new Vector2D(MathArrays.linearCombination(this.cos, r14.originOffset, -r14.cos, this.originOffset) / r0, MathArrays.linearCombination(this.sin, r14.originOffset, -r14.sin, this.originOffset) / r0);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Point<Euclidean2D> project(Point<Euclidean2D> r1) {
        return toSpace(toSubSpace(r1));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getTolerance() {
        return this.tolerance;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubLine wholeHyperplane() {
        return new SubLine(this, new IntervalsSet(this.tolerance));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public PolygonsSet wholeSpace() {
        return new PolygonsSet(this.tolerance);
    }

    public double getOffset(Line r11) {
        double r0 = this.originOffset;
        if (MathArrays.linearCombination(this.cos, r11.cos, this.sin, r11.sin) <= 0.0d) goto L5;
        double r10 = -r11.originOffset;
    L7:
        return r0 + r10;
    L5:
        r10 = r11.originOffset;
        goto L7
    }

    public double getOffset(Vector<Euclidean2D> r1) {
        return getOffset(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Euclidean2D> r13) {
        Vector2D r14 = (Vector2D) r13;
        return MathArrays.linearCombination(this.sin, r14.getX(), -this.cos, r14.getY(), 1.0d, this.originOffset);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Euclidean2D> r9) {
        Line r10 = (Line) r9;
        if (MathArrays.linearCombination(this.sin, r10.sin, this.cos, r10.cos) < 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    public Vector2D getPointAt(Vector1D r13, double r14) {
        double r8 = r13.getX();
        double r15 = r14 - this.originOffset;
        return new Vector2D(MathArrays.linearCombination(r8, this.cos, r15, this.sin), MathArrays.linearCombination(r8, this.sin, -r15, this.cos));
    }

    public boolean contains(Vector2D r3) {
        if (FastMath.abs(getOffset(r3)) >= this.tolerance) goto L5;
        return true;
    L5:
        return false;
    }

    public double distance(Vector2D r1) {
        return FastMath.abs(getOffset(r1));
    }

    public boolean isParallelTo(Line r9) {
        if (FastMath.abs(MathArrays.linearCombination(this.sin, r9.cos, -this.cos, r9.sin)) >= this.tolerance) goto L5;
        return true;
    L5:
        return false;
    }

    public void translateToPoint(Vector2D r9) {
        this.originOffset = MathArrays.linearCombination(this.cos, r9.getY(), -this.sin, r9.getX());
    }

    public double getAngle() {
        return MathUtils.normalizeAngle(this.angle, 3.141592653589793d);
    }

    public void setAngle(double r3) {
        unlinkReverse();
        double r4 = MathUtils.normalizeAngle(r3, 3.141592653589793d);
        this.angle = r4;
        this.cos = FastMath.cos(r4);
        this.sin = FastMath.sin(this.angle);
    }

    public double getOriginOffset() {
        return this.originOffset;
    }

    public void setOriginOffset(double r1) {
        unlinkReverse();
        this.originOffset = r1;
    }

    @Deprecated
    public static Transform<Euclidean2D, Euclidean1D> getTransform(AffineTransform r14) throws MathIllegalArgumentException {
        double[] r0 = new double[6];
        r14.getMatrix(r0);
        return new LineTransform(r0[0], r0[1], r0[2], r0[3], r0[4], r0[5]);
    }

    public static Transform<Euclidean2D, Euclidean1D> getTransform(double r14, double r16, double r18, double r20, double r22, double r24) throws MathIllegalArgumentException {
        return new LineTransform(r14, r16, r18, r20, r22, r24);
    }
}
