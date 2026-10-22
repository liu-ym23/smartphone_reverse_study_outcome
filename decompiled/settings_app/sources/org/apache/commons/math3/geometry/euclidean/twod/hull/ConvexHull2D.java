package org.apache.commons.math3.geometry.euclidean.twod.hull;

import java.io.Serializable;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.Segment;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.hull.ConvexHull;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class ConvexHull2D implements ConvexHull<Euclidean2D, Vector2D>, Serializable {
    private static final long serialVersionUID = 20140129;
    private transient Segment[] lineSegments;
    private final double tolerance;
    private final Vector2D[] vertices;

    @Override // org.apache.commons.math3.geometry.hull.ConvexHull
    public /* bridge */ /* synthetic */ Point[] getVertices() {
        return getVertices();
    }

    public ConvexHull2D(Vector2D[] r1, double r2) throws MathIllegalArgumentException {
        this.tolerance = r2;
        if (isConvex(r1) == false) goto L7;
        this.vertices = (Vector2D[]) r1.clone();
        return;
    L7:
        throw new MathIllegalArgumentException(LocalizedFormats.NOT_CONVEX, new Object[0]);
    }

    private boolean isConvex(Vector2D[] r22) {
        if (r22.length >= 3) goto L5;
        return true;
    L5:
        int r2 = 0;
        int r4 = 0;
    L7:
        if (r2 >= r22.length) goto L23;
        if (r2 != 0) goto L10;
        int r5 = r22.length - 1;
    L11:
        Vector2D r6 = r22[r5];
        Vector2D r7 = r22[r2];
        if (r2 != (r22.length - 1)) goto L14;
        int r8 = 0;
    L15:
        Vector2D r9 = r22[r8];
        Vector2D r10 = r7.subtract(r6);
        Vector2D r11 = r9.subtract(r7);
        int r12 = Precision.compareTo(MathArrays.linearCombination(r10.getX(), r11.getY(), -r10.getY(), r11.getX()), 0.0d, this.tolerance);
        if (r12 == 0.0d) goto L22;
        if (r4 == 0.0d) goto L21;
        if (r12 == r4) goto L21;
        return false;
    L21:
        r4 = r12;
    L22:
        r2 = r2 + 1;
        goto L7
    L14:
        r8 = r2 + 1;
        goto L15
    L10:
        r5 = r2 - 1;
        goto L11
    L23:
        return true;
    }

    @Override // org.apache.commons.math3.geometry.hull.ConvexHull
    public Vector2D[] getVertices() {
        return (Vector2D[]) this.vertices.clone();
    }

    public Segment[] getLineSegments() {
        return (Segment[]) retrieveLineSegments().clone();
    }

    private Segment[] retrieveLineSegments() {
        if (this.lineSegments != null) goto L19;
        Vector2D[] r0 = this.vertices;
        int r1 = r0.length;
        int r2 = 0;
        if (r1 > 1) goto L8;
        this.lineSegments = new Segment[0];
        goto L19
    L8:
        if (r1 != 2) goto L10;
        this.lineSegments = new Segment[]{new Segment(r4, r0, new Line(r4, r0, this.tolerance))};
        Vector2D r4 = r0[0];
        Vector2D r3 = r0[1];
        goto L19
    L10:
        this.lineSegments = new Segment[r1];
        int r5 = r0.length;
        Vector2D r6 = null;
        Vector2D r7 = null;
        int r8 = 0;
    L11:
        if (r2 >= r5) goto L17;
        Vector2D r9 = r0[r2];
        if (r6 != null) goto L15;
        r7 = r9;
    L16:
        r2 = r2 + 1;
        r6 = r9;
        goto L11
    L15:
        this.lineSegments[r8] = new Segment(r6, r9, new Line(r6, r9, this.tolerance));
        r8 = r8 + 1;
        goto L16
    L17:
        this.lineSegments[r8] = new Segment(r6, r7, new Line(r6, r7, this.tolerance));
    L19:
        return this.lineSegments;
    }

    @Override // org.apache.commons.math3.geometry.hull.ConvexHull
    public Region<Euclidean2D> createRegion() throws InsufficientDataException {
        if (this.vertices.length < 3) goto L11;
        RegionFactory r0 = new RegionFactory();
        Segment[] r4 = retrieveLineSegments();
        Line[] r1 = new Line[r4.length];
        int r2 = 0;
    L6:
        if (r2 >= r4.length) goto L9;
        r1[r2] = r4[r2].getLine();
        r2 = r2 + 1;
        goto L6
    L9:
        return r0.buildConvex(r1);
    L11:
        throw new InsufficientDataException();
    }
}
