package org.apache.commons.math3.geometry.euclidean.threed;

import java.util.ArrayList;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class OutlineExtractor {
    private Vector3D u;
    private Vector3D v;
    private Vector3D w;

    private class BoundaryProjector implements BSPTreeVisitor<Euclidean3D> {
        private PolygonsSet projected;
        final /* synthetic */ OutlineExtractor this$0;
        private final double tolerance;

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitLeafNode(BSPTree<Euclidean3D> r1) {
        }

        BoundaryProjector(OutlineExtractor r3, double r4) {
            this.this$0 = r3;
            this.projected = new PolygonsSet(new BSPTree(Boolean.FALSE), r4);
            this.tolerance = r4;
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

        private void addContribution(SubHyperplane<Euclidean3D> r24, boolean r25) {
            AbstractSubHyperplane r1 = (AbstractSubHyperplane) r24;
            Plane r2 = (Plane) r24.getHyperplane();
            double r3 = r2.getNormal().dotProduct(OutlineExtractor.access$000(this.this$0));
            if (FastMath.abs(r3) <= 0.001d) goto L59;
            Vector2D[][] r4 = ((PolygonsSet) r1.getRemainingRegion()).getVertices();
            int r5 = 0;
            int r6 = 1;
            if (r3 >= 0.0d) goto L7;
            boolean r7 = true;
        L9:
            if ((r7 ^ r25) == false) goto L25;
            Vector2D[][] r8 = new Vector2D[r4.length][];
            int r9 = 0;
        L12:
            if (r9 >= r4.length) goto L24;
            Vector2D[] r10 = r4[r9];
            Vector2D[] r11 = new Vector2D[r10.length];
            if (r10[0] != null) goto L19;
            r11[0] = null;
            int r12 = 1;
        L17:
            if (r12 >= r10.length) goto L23;
            r11[r12] = r10[r10.length - r12];
            r12 = r12 + 1;
        L23:
            r8[r9] = r11;
            r9 = r9 + 1;
            goto L12
        L19:
            int r13 = 0;
        L21:
            if (r13 >= r10.length) goto L23;
            int r14 = r13 + 1;
            r11[r13] = r10[r10.length - r14];
            r13 = r14;
            goto L21
        L24:
            r4 = r8;
        L25:
            ArrayList r15 = new ArrayList();
            int r16 = r4.length;
            int r17 = 0;
        L26:
            if (r17 >= r16) goto L50;
            Vector2D[] r18 = r4[r17];
            if (r18[r5] == null) goto L30;
            int r19 = r6;
        L31:
            if (r19 == 0) goto L33;
            int r110 = r18.length - r6;
        L34:
            Vector3D r111 = r2.toSpace(r18[r110]);
            int r112 = (r110 + 1) % r18.length;
            int r26 = r16;
            Vector2D r113 = new Vector2D(r111.dotProduct(OutlineExtractor.access$100(this.this$0)), r111.dotProduct(OutlineExtractor.access$200(this.this$0)));
            int r20 = r110;
            int r114 = r112;
        L36:
            if (r114 >= r18.length) goto L49;
            Vector3D r21 = r2.toSpace(r18[r114]);
            Vector2D r22 = new Vector2D(r21.dotProduct(OutlineExtractor.access$100(this.this$0)), r21.dotProduct(OutlineExtractor.access$200(this.this$0)));
            org.apache.commons.math3.geometry.euclidean.twod.Line r23 = new org.apache.commons.math3.geometry.euclidean.twod.Line(r113, r22, this.tolerance);
            SubHyperplane r115 = r23.wholeHyperplane();
            if (r19 == 0) goto L40;
        L41:
            r115 = r115.split(new org.apache.commons.math3.geometry.euclidean.twod.Line(r113, r23.getAngle() + 1.5707963267948966d, this.tolerance)).getPlus();
        L42:
            if (r19 != 0) goto L47;
            if (r114 != (r18.length - 1)) goto L47;
        L48:
            r15.add(r115);
            r113 = r22;
            int r27 = r114;
            r114 = r114 + 1;
            r20 = r27;
        L47:
            r115 = r115.split(new org.apache.commons.math3.geometry.euclidean.twod.Line(r22, r23.getAngle() + 1.5707963267948966d, this.tolerance)).getMinus();
            goto L48
        L40:
            if (r20 == 1) goto L42;
        L49:
            r17 = r17 + 1;
            r16 = r26;
            r6 = 1;
            r5 = 0;
            goto L26
        L33:
            r110 = r6;
            goto L34
        L30:
            r19 = r5;
            goto L31
        L50:
            this.projected = (PolygonsSet) new RegionFactory().union(this.projected, new PolygonsSet(r15, this.tolerance));
            return;
        L7:
            r7 = false;
            goto L9
        }

        public PolygonsSet getProjected() {
            return this.projected;
        }
    }

    static /* synthetic */ Vector3D access$000(OutlineExtractor r0) {
        return r0.w;
    }

    static /* synthetic */ Vector3D access$100(OutlineExtractor r0) {
        return r0.u;
    }

    static /* synthetic */ Vector3D access$200(OutlineExtractor r0) {
        return r0.v;
    }

    public OutlineExtractor(Vector3D r1, Vector3D r2) {
        this.u = r1;
        this.v = r2;
        this.w = Vector3D.crossProduct(r1, r2);
    }

    public Vector2D[][] getOutline(PolyhedronsSet r9) {
        BoundaryProjector r0 = new BoundaryProjector(this, r9.getTolerance());
        r9.getTree(true).visit(r0);
        Vector2D[][] r10 = r0.getProjected().getVertices();
        int r1 = 0;
    L4:
        if (r1 >= r10.length) goto L19;
        Vector2D[] r2 = r10[r1];
        int r3 = r2.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L16;
        if (pointIsBetween(r2, r3, r4) == true) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        int r5 = r4;
    L11:
        if (r5 >= (r3 - 1)) goto L13;
        int r6 = r5 + 1;
        r2[r5] = r2[r6];
        r5 = r6;
        goto L11
    L13:
        r3 = r3 - 1;
        goto L6
    L16:
        if (r3 == r2.length) goto L18;
        Vector2D[] r7 = new Vector2D[r3];
        r10[r1] = r7;
        System.arraycopy(r2, 0, r7, 0, r3);
    L18:
        r1 = r1 + 1;
        goto L4
    L19:
        return r10;
    }

    private boolean pointIsBetween(Vector2D[] r13, int r14, int r15) {
        Vector2D r12 = r13[((r15 + r14) - 1) % r14];
        Vector2D r1 = r13[r15];
        Vector2D r16 = r13[(r15 + 1) % r14];
        double r17 = r1.getX() - r12.getX();
        double r2 = r1.getY() - r12.getY();
        double r4 = r16.getX() - r1.getX();
        double r18 = r16.getY() - r1.getY();
        double r6 = (r17 * r18) - (r4 * r2);
        double r8 = (r17 * r4) + (r2 * r18);
        double r19 = FastMath.sqrt(((r17 * r17) + (r2 * r2)) * ((r4 * r4) + (r18 * r18)));
        if (FastMath.abs(r6) <= (r19 * 1.0E-6d)) goto L5;
    L7:
        return false;
    L5:
        if (r8 < 0.0d) goto L7;
        return true;
    }
}
