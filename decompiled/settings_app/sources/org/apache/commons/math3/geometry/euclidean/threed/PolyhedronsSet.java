package org.apache.commons.math3.geometry.euclidean.threed;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Transform;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class PolyhedronsSet extends AbstractRegion<Euclidean3D, Euclidean2D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;

    private class FacetsContributionVisitor implements BSPTreeVisitor<Euclidean3D> {
        final /* synthetic */ PolyhedronsSet this$0;

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitLeafNode(BSPTree<Euclidean3D> r1) {
        }

        FacetsContributionVisitor(PolyhedronsSet r10) {
            this.this$0 = r10;
            PolyhedronsSet.access$000(r10, 0.0d);
            PolyhedronsSet.access$100(r10, new Vector3D(0.0d, 0.0d, 0.0d));
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public BSPTreeVisitor.Order visitOrder(BSPTree<Euclidean3D> r1) {
            return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitInternalNode(BSPTree<Euclidean3D> r3) {
            BoundaryAttribute r4 = (BoundaryAttribute) r3.getAttribute();
            if (r4.getPlusOutside() == null) goto L6;
            addContribution(r4.getPlusOutside(), false);
        L6:
            if (r4.getPlusInside() == null) goto L9;
            addContribution(r4.getPlusInside(), true);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void addContribution(SubHyperplane<Euclidean3D> r11, boolean r12) {
            Region<Euclidean2D> r0 = ((SubPlane) r11).getRemainingRegion();
            double r1 = r0.getSize();
            if (Double.isInfinite(r1) == false) goto L5;
            PolyhedronsSet.access$200(this.this$0, Double.POSITIVE_INFINITY);
            PolyhedronsSet.access$300(this.this$0, Vector3D.NaN);
            return;
        L5:
            Plane r13 = (Plane) r11.getHyperplane();
            Vector3D r9 = r13.toSpace(r0.getBarycenter());
            double r2 = r1 * r9.dotProduct(r13.getNormal());
            if (r12 == false) goto L8;
            double r7 = -r2;
        L9:
            PolyhedronsSet r14 = this.this$0;
            PolyhedronsSet.access$400(r14, r14.getSize() + r7);
            PolyhedronsSet.access$500(this.this$0, new Vector3D(1.0d, (Vector3D) this.this$0.getBarycenter(), r7, r9));
            return;
        L8:
            r7 = r2;
            goto L9
        }
    }

    private static class RotationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Plane cachedOriginal;
        private Transform<Euclidean2D, Euclidean1D> cachedTransform;
        private Vector3D center;
        private Rotation rotation;

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Point apply(Point r1) {
            return apply(r1);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Hyperplane apply(Hyperplane r1) {
            return apply(r1);
        }

        RotationTransform(Vector3D r1, Rotation r2) {
            this.center = r1;
            this.rotation = r2;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Vector3D apply(Point<Euclidean3D> r9) {
            Vector3D r10 = ((Vector3D) r9).subtract(this.center);
            return new Vector3D(1.0d, this.center, 1.0d, this.rotation.applyTo(r10));
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Plane apply(Hyperplane<Euclidean3D> r2) {
            return ((Plane) r2).rotate(this.center, this.rotation);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public SubHyperplane<Euclidean2D> apply(SubHyperplane<Euclidean2D> r22, Hyperplane<Euclidean3D> r23, Hyperplane<Euclidean3D> r24) {
            if (r23 == this.cachedOriginal) goto L6;
            Plane r1 = (Plane) r23;
            Plane r2 = (Plane) r24;
            Vector3D r3 = r1.getOrigin();
            Vector3D r4 = r1.toSpace(new Vector2D(1.0d, 0.0d));
            Vector3D r5 = r1.toSpace(new Vector2D(0.0d, 1.0d));
            Vector2D r6 = r2.toSubSpace(apply(r3));
            Vector2D r7 = r2.toSubSpace(apply(r4));
            Vector2D r8 = r2.toSubSpace(apply(r5));
            this.cachedOriginal = r1;
            this.cachedTransform = org.apache.commons.math3.geometry.euclidean.twod.Line.getTransform(r7.getX() - r6.getX(), r7.getY() - r6.getY(), r8.getX() - r6.getX(), r8.getY() - r6.getY(), r6.getX(), r6.getY());
        L6:
            return ((org.apache.commons.math3.geometry.euclidean.twod.SubLine) r22).applyTransform(this.cachedTransform);
        }
    }

    private static class TranslationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Plane cachedOriginal;
        private Transform<Euclidean2D, Euclidean1D> cachedTransform;
        private Vector3D translation;

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Point apply(Point r1) {
            return apply(r1);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public /* bridge */ /* synthetic */ Hyperplane apply(Hyperplane r1) {
            return apply(r1);
        }

        TranslationTransform(Vector3D r1) {
            this.translation = r1;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Vector3D apply(Point<Euclidean3D> r9) {
            return new Vector3D(1.0d, (Vector3D) r9, 1.0d, this.translation);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public Plane apply(Hyperplane<Euclidean3D> r1) {
            return ((Plane) r1).translate(this.translation);
        }

        @Override // org.apache.commons.math3.geometry.partitioning.Transform
        public SubHyperplane<Euclidean2D> apply(SubHyperplane<Euclidean2D> r13, Hyperplane<Euclidean3D> r14, Hyperplane<Euclidean3D> r15) {
            if (r14 == this.cachedOriginal) goto L6;
            Plane r16 = (Plane) r14;
            Vector2D r17 = ((Plane) r15).toSubSpace(apply(r16.getOrigin()));
            this.cachedOriginal = r16;
            this.cachedTransform = org.apache.commons.math3.geometry.euclidean.twod.Line.getTransform(1.0d, 0.0d, 0.0d, 1.0d, r17.getX(), r17.getY());
        L6:
            return ((org.apache.commons.math3.geometry.euclidean.twod.SubLine) r13).applyTransform(this.cachedTransform);
        }
    }

    static /* synthetic */ void access$000(PolyhedronsSet r0, double r1) {
        r0.setSize(r1);
    }

    static /* synthetic */ void access$100(PolyhedronsSet r0, Point r1) {
        r0.setBarycenter(r1);
    }

    static /* synthetic */ void access$200(PolyhedronsSet r0, double r1) {
        r0.setSize(r1);
    }

    static /* synthetic */ void access$300(PolyhedronsSet r0, Point r1) {
        r0.setBarycenter(r1);
    }

    static /* synthetic */ void access$400(PolyhedronsSet r0, double r1) {
        r0.setSize(r1);
    }

    static /* synthetic */ void access$500(PolyhedronsSet r0, Point r1) {
        r0.setBarycenter(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    public PolyhedronsSet(double r1) {
        super(r1);
    }

    public PolyhedronsSet(BSPTree<Euclidean3D> r1, double r2) {
        super(r1, r2);
    }

    public PolyhedronsSet(Collection<SubHyperplane<Euclidean3D>> r1, double r2) {
        super(r1, r2);
    }

    public PolyhedronsSet(List<Vector3D> r1, List<int[]> r2, double r3) {
        super(buildBoundary(r1, r2, r3), r3);
    }

    public PolyhedronsSet(double r1, double r3, double r5, double r7, double r9, double r11, double r13) {
        super(buildBoundary(r1, r3, r5, r7, r9, r11, r13), r13);
    }

    @Deprecated
    public PolyhedronsSet() {
        this(1.0E-10d);
    }

    @Deprecated
    public PolyhedronsSet(BSPTree<Euclidean3D> r3) {
        this(r3, 1.0E-10d);
    }

    @Deprecated
    public PolyhedronsSet(Collection<SubHyperplane<Euclidean3D>> r3) {
        this(r3, 1.0E-10d);
    }

    @Deprecated
    public PolyhedronsSet(double r16, double r18, double r20, double r22, double r24, double r26) {
        this(r16, r18, r20, r22, r24, r26, 1.0E-10d);
    }

    private static BSPTree<Euclidean3D> buildBoundary(double r17, double r19, double r21, double r23, double r25, double r27, double r29) {
        if (r17 >= (r19 - r29)) goto L12;
        if (r21 >= (r23 - r29)) goto L12;
        if (r25 >= (r27 - r29)) goto L12;
        Plane r5 = new Plane(new Vector3D(r17, 0.0d, 0.0d), Vector3D.MINUS_I, r29);
        Plane r14 = new Plane(new Vector3D(r19, 0.0d, 0.0d), Vector3D.PLUS_I, r29);
        Plane r0 = new Plane(new Vector3D(0.0d, r21, 0.0d), Vector3D.MINUS_J, r29);
        Plane r1 = new Plane(new Vector3D(0.0d, r23, 0.0d), Vector3D.PLUS_J, r29);
        Plane r2 = new Plane(new Vector3D(0.0d, 0.0d, r25), Vector3D.MINUS_K, r29);
        Plane r3 = new Plane(new Vector3D(0.0d, 0.0d, r27), Vector3D.PLUS_K, r29);
        return new RegionFactory().buildConvex(new Hyperplane[]{r5, r14, r0, r1, r2, r3}).getTree(false);
    L12:
        return new BSPTree(Boolean.FALSE);
    }

    private static List<SubHyperplane<Euclidean3D>> buildBoundary(List<Vector3D> r17, List<int[]> r18, double r19) {
        int r1 = 0;
    L4:
        if (r1 >= (r17.size() - 1)) goto L13;
        Vector3D r2 = r17.get(r1);
        r1 = r1 + 1;
        int r3 = r1;
    L7:
        if (r3 >= r17.size()) goto L4;
        if (Vector3D.distance(r2, r17.get(r3)) <= r19) goto L12;
        r3 = r3 + 1;
        goto L7
    L12:
        throw new MathIllegalArgumentException(LocalizedFormats.CLOSE_VERTICES, new Object[]{Double.valueOf(r2.getX()), Double.valueOf(r2.getY()), Double.valueOf(r2.getZ())});
    L13:
        int[][] r4 = successors(r17, r18, findReferences(r17, r18));
        int r5 = 0;
    L15:
        if (r5 >= r17.size()) goto L35;
        int[] r6 = r4[r5];
        int r7 = r6.length;
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L34;
        int r13 = r6[r8];
        if (r13 < 0) goto L33;
        int[] r14 = r4[r13];
        int r15 = r14.length;
        int r11 = 0;
        boolean r16 = false;
    L21:
        if (r11 >= r15) goto L29;
        int r12 = r14[r11];
        if (r16 == true) goto L27;
        if (r12 == r5) goto L27;
        r16 = false;
    L28:
        r11 = r11 + 1;
    L27:
        r16 = true;
        goto L28
    L29:
        if (r16 == true) goto L33;
        Vector3D r9 = r17.get(r5);
        Vector3D r0 = r17.get(r13);
        throw new MathIllegalArgumentException(LocalizedFormats.EDGE_CONNECTED_TO_ONE_FACET, new Object[]{Double.valueOf(r9.getX()), Double.valueOf(r9.getY()), Double.valueOf(r9.getZ()), Double.valueOf(r0.getX()), Double.valueOf(r0.getY()), Double.valueOf(r0.getZ())});
    L33:
        r8 = r8 + 1;
        goto L17
    L34:
        r5 = r5 + 1;
        goto L15
    L35:
        ArrayList r110 = new ArrayList();
        Iterator<int[]> r111 = r18.iterator();
    L37:
        if (r111.hasNext() == false) goto L47;
        int[] r112 = r111.next();
        Plane r113 = new Plane(r17.get(r112[0]), r17.get(r112[1]), r17.get(r112[2]), r19);
        Vector2D[] r10 = new Vector2D[r112.length];
        int r20 = 0;
    L40:
        if (r20 >= r112.length) goto L46;
        Vector3D r21 = r17.get(r112[r20]);
        if (r113.contains(r21) == false) goto L45;
        r10[r20] = r113.toSubSpace(r21);
        r20 = r20 + 1;
        goto L40
    L45:
        throw new MathIllegalArgumentException(LocalizedFormats.OUT_OF_PLANE, new Object[]{Double.valueOf(r21.getX()), Double.valueOf(r21.getY()), Double.valueOf(r21.getZ())});
    L46:
        r110.add(new SubPlane(r113, new PolygonsSet(r19, r10)));
        goto L37
    L47:
        return r110;
    }

    private static int[][] findReferences(List<Vector3D> r10, List<int[]> r11) {
        int[] r0 = new int[r10.size()];
        Iterator<int[]> r1 = r11.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        int[] r4 = r1.next();
        if (r4.length < 3) goto L11;
        int r6 = r4.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L4;
        int r8 = r4[r7];
        int r9 = r0[r8] + 1;
        r0[r8] = r9;
        r3 = FastMath.max(r3, r9);
        r7 = r7 + 1;
        goto L8
    L11:
        throw new NumberIsTooSmallException(LocalizedFormats.WRONG_NUMBER_OF_POINTS, 3, Integer.valueOf(r4.length), true);
    L12:
        int[][] r12 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r10.size(), r3});
        int r2 = r12.length;
        int r5 = 0;
    L13:
        if (r5 >= r2) goto L15;
        Arrays.fill(r12[r5], -1);
        r5 = r5 + 1;
        goto L13
    L15:
        int r13 = 0;
    L17:
        if (r13 >= r11.size()) goto L27;
        int[] r14 = r11.get(r13);
        int r15 = r14.length;
        int r16 = 0;
    L19:
        if (r16 >= r15) goto L26;
        int r17 = r14[r16];
        int r18 = 0;
    L21:
        if (r18 >= r3) goto L25;
        if (r12[r17][r18] < 0) goto L25;
        r18 = r18 + 1;
    L25:
        r12[r17][r18] = r13;
        r16 = r16 + 1;
        goto L19
    L26:
        r13 = r13 + 1;
        goto L17
    L27:
        return r12;
    }

    private static int[][] successors(List<Vector3D> r10, List<int[]> r11, int[][] r12) {
        int[][] r0 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r10.size(), r12[0].length});
        int r2 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        Arrays.fill(r0[r4], -1);
        r4 = r4 + 1;
        goto L3
    L5:
        int r3 = 0;
    L7:
        if (r3 >= r10.size()) goto L28;
        int r5 = 0;
    L10:
        if (r5 >= r0[r3].length) goto L27;
        int r6 = r12[r3][r5];
        if (r6 < 0) goto L27;
        int[] r7 = r11.get(r6);
        int r8 = 0;
    L15:
        if (r8 >= r7.length) goto L19;
        if (r7[r8] == r3) goto L19;
        r8 = r8 + 1;
    L19:
        r0[r3][r5] = r7[(r8 + 1) % r7.length];
        int r9 = 0;
    L20:
        if (r9 >= r5) goto L26;
        int[] r13 = r0[r3];
        if (r13[r9] == r13[r5]) goto L24;
        r9 = r9 + 1;
        goto L20
    L24:
        Vector3D r14 = r10.get(r3);
        Vector3D r15 = r10.get(r0[r3][r5]);
        throw new MathIllegalArgumentException(LocalizedFormats.FACET_ORIENTATION_MISMATCH, new Object[]{Double.valueOf(r14.getX()), Double.valueOf(r14.getY()), Double.valueOf(r14.getZ()), Double.valueOf(r15.getX()), Double.valueOf(r15.getY()), Double.valueOf(r15.getZ())});
    L26:
        r5 = r5 + 1;
    L27:
        r3 = r3 + 1;
        goto L7
    L28:
        return r0;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public PolyhedronsSet buildNew(BSPTree<Euclidean3D> r4) {
        return new PolyhedronsSet(r4, getTolerance());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    protected void computeGeometricalProperties() {
        getTree(true).visit(new FacetsContributionVisitor(this));
        if (getSize() >= 0.0d) goto L5;
        setSize(Double.POSITIVE_INFINITY);
        setBarycenter(Vector3D.NaN);
        return;
    L5:
        setSize(getSize() / 3.0d);
        setBarycenter(new Vector3D(1.0d / (getSize() * 4.0d), (Vector3D) getBarycenter()));
    }

    public SubHyperplane<Euclidean3D> firstIntersection(Vector3D r2, Line r3) {
        return recurseFirstIntersection(getTree(true), r2, r3);
    }

    private SubHyperplane<Euclidean3D> recurseFirstIntersection(BSPTree<Euclidean3D> r11, Vector3D r12, Line r13) {
        SubHyperplane<S> r0 = r11.getCut();
        if (r0 != 0) goto L6;
        return null;
    L6:
        BSPTree<Euclidean3D> r1 = r11.getMinus();
        BSPTree<Euclidean3D> r2 = r11.getPlus();
        Plane r3 = (Plane) r0.getHyperplane();
        double r4 = r3.getOffset(r12);
        if (FastMath.abs(r4) >= getTolerance()) goto L9;
        boolean r5 = true;
    L11:
        if (r4 < 0.0d) goto L14;
        r2 = r1;
        r1 = r2;
    L14:
        if (r5 == false) goto L18;
        SubHyperplane<Euclidean3D> r6 = boundaryFacet(r12, r11);
        if (r6 == null) goto L18;
        return r6;
    L18:
        SubHyperplane<Euclidean3D> r7 = recurseFirstIntersection(r1, r12, r13);
        if (r7 == null) goto L21;
        return r7;
    L21:
        if (r5 == true) goto L30;
        Vector3D r8 = r3.intersection(r13);
        if (r8 == null) goto L30;
        if (r13.getAbscissa(r8) <= r13.getAbscissa(r12)) goto L30;
        SubHyperplane<Euclidean3D> r14 = boundaryFacet(r8, r11);
        if (r14 == null) goto L30;
        return r14;
    L30:
        return recurseFirstIntersection(r2, r12, r13);
    L9:
        r5 = false;
        goto L11
    }

    private SubHyperplane<Euclidean3D> boundaryFacet(Vector3D r2, BSPTree<Euclidean3D> r3) {
        Vector2D r1 = ((Plane) r3.getCut().getHyperplane()).toSubSpace(r2);
        BoundaryAttribute r4 = (BoundaryAttribute) r3.getAttribute();
        if (r4.getPlusOutside() == null) goto L9;
        if (((SubPlane) r4.getPlusOutside()).getRemainingRegion().checkPoint(r1) != Region.Location.INSIDE) goto L9;
        return r4.getPlusOutside();
    L9:
        if (r4.getPlusInside() != null) goto L11;
        return null;
    L11:
        if (((SubPlane) r4.getPlusInside()).getRemainingRegion().checkPoint(r1) == Region.Location.INSIDE) goto L13;
        return null;
    L13:
        return r4.getPlusInside();
    }

    public PolyhedronsSet rotate(Vector3D r2, Rotation r3) {
        return (PolyhedronsSet) applyTransform(new RotationTransform(r2, r3));
    }

    public PolyhedronsSet translate(Vector3D r2) {
        return (PolyhedronsSet) applyTransform(new TranslationTransform(r2));
    }
}
