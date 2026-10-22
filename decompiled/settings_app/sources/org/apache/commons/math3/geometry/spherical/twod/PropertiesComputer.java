package org.apache.commons.math3.geometry.spherical.twod;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class PropertiesComputer implements BSPTreeVisitor<Sphere2D> {
    private final List<Vector3D> convexCellsInsidePoints;
    private double summedArea;
    private Vector3D summedBarycenter;
    private final double tolerance;

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<Sphere2D> r1) {
    }

    PropertiesComputer(double r1) {
        this.tolerance = r1;
        this.summedArea = 0.0d;
        this.summedBarycenter = Vector3D.ZERO;
        this.convexCellsInsidePoints = new ArrayList();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<Sphere2D> r1) {
        return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<Sphere2D> r10) {
        if (((Boolean) r10.getAttribute()).booleanValue() == false) goto L9;
        List<Vertex> r11 = new SphericalPolygonsSet(r10.pruneAroundConvexCell(Boolean.TRUE, Boolean.FALSE, null), this.tolerance).getBoundaryLoops();
        if (r11.size() != 1) goto L8;
        double r6 = convexCellArea(r11.get(0));
        Vector3D r8 = convexCellBarycenter(r11.get(0));
        this.convexCellsInsidePoints.add(r8);
        this.summedArea += r6;
        this.summedBarycenter = new Vector3D(1.0d, this.summedBarycenter, r6, r8);
        return;
    L8:
        throw new MathInternalError();
    }

    private double convexCellArea(Vertex r10) {
        Edge r9 = r10.getOutgoing();
        int r0 = 0;
        double r3 = 0.0d;
    L3:
        if (r0 != 0) goto L5;
    L9:
        Vector3D r5 = r9.getCircle().getPole();
        Vector3D r6 = r9.getEnd().getOutgoing().getCircle().getPole();
        double r7 = FastMath.atan2(Vector3D.dotProduct(r6, Vector3D.crossProduct(r9.getEnd().getLocation().getVector(), r5)), -Vector3D.dotProduct(r6, r5));
        if (r7 >= 0.0d) goto L12;
        r7 = r7 + 6.283185307179586d;
    L12:
        r3 = r3 + r7;
        r0 = r0 + 1;
        r9 = r9.getEnd().getOutgoing();
        goto L3
    L5:
        if (r9.getStart() != r10) goto L9;
        return r3 - (((double) (r0 - 2)) * 3.141592653589793d);
    }

    private Vector3D convexCellBarycenter(Vertex r10) {
        Vector3D r9 = Vector3D.ZERO;
        Edge r0 = r10.getOutgoing();
        int r1 = 0;
    L3:
        Vector3D r5 = r9;
        if (r1 == 0) goto L10;
        if (r0.getStart() != r10) goto L10;
        return r5.normalize();
    L10:
        r9 = new Vector3D(1.0d, r5, r0.getLength(), r0.getCircle().getPole());
        r1 = r1 + 1;
        r0 = r0.getEnd().getOutgoing();
        goto L3
    }

    public double getArea() {
        return this.summedArea;
    }

    public S2Point getBarycenter() {
        if (this.summedBarycenter.getNormSq() != 0.0d) goto L7;
        return S2Point.NaN;
    L7:
        return new S2Point(this.summedBarycenter);
    }

    public List<Vector3D> getConvexCellsInsidePoints() {
        return this.convexCellsInsidePoints;
    }
}
