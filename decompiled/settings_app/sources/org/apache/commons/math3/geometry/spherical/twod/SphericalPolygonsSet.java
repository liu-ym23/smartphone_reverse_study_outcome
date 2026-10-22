package org.apache.commons.math3.geometry.spherical.twod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.geometry.enclosing.EnclosingBall;
import org.apache.commons.math3.geometry.enclosing.WelzlEncloser;
import org.apache.commons.math3.geometry.euclidean.threed.Rotation;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.SphereGenerator;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BoundaryProjection;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.spherical.oned.Sphere1D;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SphericalPolygonsSet extends AbstractRegion<Sphere2D, Sphere1D> {
    private List<Vertex> loops;

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    public SphericalPolygonsSet(double r1) {
        super(r1);
    }

    public SphericalPolygonsSet(Vector3D r5, double r6) {
        super(new BSPTree(new Circle(r5, r6).wholeHyperplane(), new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null), r6);
    }

    public SphericalPolygonsSet(Vector3D r1, Vector3D r2, double r3, int r5, double r6) {
        this(r6, createRegularPolygonVertices(r1, r2, r3, r5));
    }

    public SphericalPolygonsSet(BSPTree<Sphere2D> r1, double r2) {
        super(r1, r2);
    }

    public SphericalPolygonsSet(Collection<SubHyperplane<Sphere2D>> r1, double r2) {
        super(r1, r2);
    }

    public SphericalPolygonsSet(double r1, S2Point... r3) {
        super(verticesToTree(r1, r3), r1);
    }

    private static S2Point[] createRegularPolygonVertices(Vector3D r3, Vector3D r4, double r5, int r7) {
        S2Point[] r0 = new S2Point[r7];
        r0[0] = new S2Point(new Rotation(Vector3D.crossProduct(r3, r4), r5, RotationConvention.VECTOR_OPERATOR).applyTo(r3));
        Rotation r6 = new Rotation(r3, 6.283185307179586d / ((double) r7), RotationConvention.VECTOR_OPERATOR);
        int r8 = 1;
    L3:
        if (r8 >= r7) goto L5;
        r0[r8] = new S2Point(r6.applyTo(r0[r8 - 1].getVector()));
        r8 = r8 + 1;
        goto L3
    L5:
        return r0;
    }

    private static BSPTree<Sphere2D> verticesToTree(double r16, S2Point... r18) {
        int r3 = r18.length;
        if (r3 == 0) goto L5;
        Vertex[] r4 = new Vertex[r3];
        int r6 = 0;
    L7:
        if (r6 >= r3) goto L9;
        r4[r6] = new Vertex(r18[r6]);
        r6 = r6 + 1;
        goto L7
    L9:
        ArrayList r2 = new ArrayList(r3);
        Vertex r7 = r4[r3 - 1];
        int r13 = 0;
    L10:
        if (r13 >= r3) goto L24;
        Vertex r14 = r4[r13];
        Circle r8 = r7.sharedCircleWith(r14);
        if (r8 != null) goto L14;
        r8 = new Circle(r7.getLocation(), r14.getLocation(), r16);
    L14:
        Circle r15 = r8;
        r2.add(new Edge(r7, r14, Vector3D.angle(r7.getLocation().getVector(), r14.getLocation().getVector()), r15));
        int r5 = 0;
    L15:
        if (r5 >= r3) goto L23;
        Vertex r9 = r4[r5];
        if (r9 == r7) goto L22;
        if (r9 == r14) goto L22;
        if (FastMath.abs(r15.getOffset(r9.getLocation())) > r16) goto L22;
        r9.bindWith(r15);
    L22:
        r5 = r5 + 1;
        goto L15
    L23:
        r13 = r13 + 1;
        r7 = r14;
        goto L10
    L24:
        BSPTree<Sphere2D> r10 = new BSPTree();
        insertEdges(r16, r10, r2);
        return r10;
    L5:
        return new BSPTree(Boolean.TRUE);
    }

    private static void insertEdges(double r6, BSPTree<Sphere2D> r8, List<Edge> r9) {
        int r0 = 0;
    L3:
        Edge r2 = null;
    L4:
        if (r2 != null) goto L11;
        if (r0 >= r9.size()) goto L11;
        int r3 = r0 + 1;
        Edge r1 = r9.get(r0);
        if (r8.insertCut(r1.getCircle()) == false) goto L9;
        r2 = r1;
        r0 = r3;
        goto L4
    L9:
        r0 = r3;
    L11:
        if (r2 != null) goto L20;
        BSPTree<S> r7 = r8.getParent();
        if (r7 != 0) goto L15;
    L18:
        r8.setAttribute(Boolean.TRUE);
        return;
    L15:
        if (r8 == r7.getMinus()) goto L18;
        r8.setAttribute(Boolean.FALSE);
        return;
    L20:
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Iterator<Edge> r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L27;
        Edge r11 = r10.next();
        if (r11 == r2) goto L22;
        r11.split(r2.getCircle(), r4, r5);
        goto L22
    L27:
        if (r4.isEmpty() == true) goto L29;
        insertEdges(r6, r8.getPlus(), r4);
    L31:
        if (r5.isEmpty() == true) goto L33;
        insertEdges(r6, r8.getMinus(), r5);
        return;
    L33:
        r8.getMinus().setAttribute(Boolean.TRUE);
        return;
    L29:
        r8.getPlus().setAttribute(Boolean.FALSE);
        goto L31
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public SphericalPolygonsSet buildNew(BSPTree<Sphere2D> r4) {
        return new SphericalPolygonsSet(r4, getTolerance());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    protected void computeGeometricalProperties() throws MathIllegalStateException {
        BSPTree<Sphere2D> r0 = getTree(true);
        if (r0.getCut() == null) goto L5;
        PropertiesComputer r1 = new PropertiesComputer(getTolerance());
        r0.visit(r1);
        setSize(r1.getArea());
        setBarycenter(r1.getBarycenter());
        return;
    L5:
        if (r0.getCut() == null) goto L7;
    L9:
        setSize(0.0d);
        setBarycenter(S2Point.NaN);
        return;
    L7:
        if (((Boolean) r0.getAttribute()).booleanValue() == false) goto L9;
        setSize(12.566370614359172d);
        setBarycenter(new S2Point(0.0d, 0.0d));
    }

    public List<Vertex> getBoundaryLoops() throws MathIllegalStateException {
        if (this.loops != null) goto L21;
        if (getTree(false).getCut() != null) goto L7;
        this.loops = Collections.emptyList();
        goto L21
    L7:
        BSPTree<Sphere2D> r1 = getTree(true);
        EdgesBuilder r2 = new EdgesBuilder(r1, getTolerance());
        r1.visit(r2);
        List<Edge> r3 = r2.getEdges();
        this.loops = new ArrayList();
    L9:
        if (r3.isEmpty() == true) goto L21;
        Edge r4 = r3.get(0);
        Vertex r5 = r4.getStart();
        this.loops.add(r5);
    L11:
        Iterator<Edge> r6 = r3.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        if (r6.next() != r4) goto L13;
        r6.remove();
    L17:
        r4 = r4.getEnd().getOutgoing();
        if (r4.getStart() != r5) goto L11;
    L21:
        return Collections.unmodifiableList(this.loops);
    }

    public EnclosingBall<Sphere2D, S2Point> getEnclosingCap() {
        int r1 = 0;
        if (isEmpty() == false) goto L7;
        return new EnclosingBall(S2Point.PLUS_K, Double.NEGATIVE_INFINITY, new S2Point[0]);
    L7:
        if (isFull() == true) goto L9;
        BSPTree<Sphere2D> r0 = getTree(false);
        if (isEmpty(r0.getMinus()) == false) goto L17;
        if (isFull(r0.getPlus()) == false) goto L17;
        return new EnclosingBall(new S2Point(((Circle) r0.getCut().getHyperplane()).getPole()).negate(), 1.5707963267948966d, new S2Point[0]);
    L17:
        if (isFull(r0.getMinus()) == true) goto L19;
    L22:
        List<Vector3D> r2 = getInsidePoints();
        Iterator<Vertex> r4 = getBoundaryLoops().iterator();
    L24:
        if (r4.hasNext() == false) goto L29;
        Vertex r5 = r4.next();
        int r6 = 0;
        Vertex r7 = r5;
    L26:
        if (r6 == 0) goto L28;
        if (r7 == r5) goto L24;
    L28:
        r6 = r6 + 1;
        r2.add(r7.getLocation().getVector());
        r7 = r7.getOutgoing().getEnd();
        goto L26
    L29:
        EnclosingBall r3 = new WelzlEncloser(getTolerance(), new SphereGenerator()).enclose(r2);
        Vector3D[] r8 = (Vector3D[]) r3.getSupport();
        double r9 = r3.getRadius();
        double r10 = ((Vector3D) r3.getCenter()).getNorm();
        if (r10 >= getTolerance()) goto L38;
        EnclosingBall<Sphere2D, S2Point> r11 = new EnclosingBall(S2Point.PLUS_K, Double.POSITIVE_INFINITY, new S2Point[0]);
        Iterator<Vector3D> r12 = getOutsidePoints().iterator();
    L33:
        if (r12.hasNext() == false) goto L37;
        S2Point r13 = new S2Point(r12.next());
        BoundaryProjection<Sphere2D> r14 = projectToBoundary(r13);
        if ((3.141592653589793d - r14.getOffset()) >= r11.getRadius()) goto L33;
        r11 = new EnclosingBall(r13.negate(), 3.141592653589793d - r14.getOffset(), new S2Point[]{(S2Point) r14.getProjected()});
        goto L33
    L37:
        return r11;
    L38:
        S2Point[] r15 = new S2Point[r8.length];
    L40:
        if (r1 >= r8.length) goto L43;
        r15[r1] = new S2Point(r8[r1]);
        r1 = r1 + 1;
        goto L40
    L43:
        return new EnclosingBall(new S2Point((Vector3D) r3.getCenter()), FastMath.acos((((r10 * r10) + 1.0d) - (r9 * r9)) / (r10 * 2.0d)), r15);
    L19:
        if (isEmpty(r0.getPlus()) == false) goto L22;
        return new EnclosingBall(new S2Point(((Circle) r0.getCut().getHyperplane()).getPole()), 1.5707963267948966d, new S2Point[0]);
    L9:
        return new EnclosingBall(S2Point.PLUS_K, Double.POSITIVE_INFINITY, new S2Point[0]);
    }

    private List<Vector3D> getInsidePoints() {
        PropertiesComputer r0 = new PropertiesComputer(getTolerance());
        getTree(true).visit(r0);
        return r0.getConvexCellsInsidePoints();
    }

    private List<Vector3D> getOutsidePoints() {
        SphericalPolygonsSet r0 = (SphericalPolygonsSet) new RegionFactory().getComplement(this);
        PropertiesComputer r1 = new PropertiesComputer(getTolerance());
        r0.getTree(true).visit(r1);
        return r1.getConvexCellsInsidePoints();
    }
}
