package org.apache.commons.math3.geometry.spherical.twod;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.spherical.oned.Arc;
import org.apache.commons.math3.geometry.spherical.oned.ArcsSet;
import org.apache.commons.math3.geometry.spherical.oned.S1Point;

/* JADX INFO: loaded from: classes6.dex */
class EdgesBuilder implements BSPTreeVisitor<Sphere2D> {
    private final Map<Edge, BSPTree<Sphere2D>> edgeToNode;
    private final Map<BSPTree<Sphere2D>, List<Edge>> nodeToEdgesList;
    private final BSPTree<Sphere2D> root;
    private final double tolerance;

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitLeafNode(BSPTree<Sphere2D> r1) {
    }

    EdgesBuilder(BSPTree<Sphere2D> r1, double r2) {
        this.root = r1;
        this.tolerance = r2;
        this.edgeToNode = new IdentityHashMap();
        this.nodeToEdgesList = new IdentityHashMap();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public BSPTreeVisitor.Order visitOrder(BSPTree<Sphere2D> r1) {
        return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
    public void visitInternalNode(BSPTree<Sphere2D> r4) {
        this.nodeToEdgesList.put(r4, new ArrayList());
        BoundaryAttribute r0 = (BoundaryAttribute) r4.getAttribute();
        if (r0.getPlusOutside() == null) goto L6;
        addContribution((SubCircle) r0.getPlusOutside(), false, r4);
    L6:
        if (r0.getPlusInside() == null) goto L9;
        addContribution((SubCircle) r0.getPlusInside(), true, r4);
        return;
    }

    private void addContribution(SubCircle r10, boolean r11, BSPTree<Sphere2D> r12) {
        Circle r0 = (Circle) r10.getHyperplane();
        Iterator<Arc> r13 = ((ArcsSet) r10.getRemainingRegion()).asList().iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        Arc r1 = r13.next();
        Vertex r4 = new Vertex(r0.toSpace(new S1Point(r1.getInf())));
        Vertex r3 = new Vertex(r0.toSpace(new S1Point(r1.getSup())));
        r4.bindWith(r0);
        r3.bindWith(r0);
        if (r11 == false) goto L8;
        Edge r8 = new Edge(r3, r4, r1.getSize(), r0.getReverse());
    L9:
        this.edgeToNode.put(r8, r12);
        this.nodeToEdgesList.get(r12).add(r8);
        goto L4
    L8:
        r8 = new Edge(r4, r3, r1.getSize(), r0);
        goto L9
    }

    private Edge getFollowingEdge(Edge r11) throws MathIllegalStateException {
        S2Point r0 = r11.getEnd().getLocation();
        List<BSPTree<S>> r1 = this.root.getCloseCuts(r0, this.tolerance);
        double r2 = this.tolerance;
        Iterator r3 = r1.iterator();
        Edge r4 = null;
    L4:
        if (r3.hasNext() == false) goto L15;
        BSPTree r5 = (BSPTree) r3.next();
        Iterator<Edge> r6 = this.nodeToEdgesList.get(r5).iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        Edge r7 = r6.next();
        if (r7 == r11) goto L7;
        if (r7.getStart().getIncoming() != null) goto L7;
        Vector3D r8 = r7.getStart().getLocation().getVector();
        double r9 = Vector3D.angle(r0.getVector(), r8);
        if (r9 > r2) goto L7;
        r4 = r7;
        r2 = r9;
        goto L7
    L15:
        if (r4 != null) goto L21;
        Vector3D r10 = r11.getStart().getLocation().getVector();
        if (Vector3D.angle(r0.getVector(), r10) > this.tolerance) goto L20;
        return r11;
    L20:
        throw new MathIllegalStateException(LocalizedFormats.OUTLINE_BOUNDARY_LOOP_OPEN, new Object[0]);
    L21:
        return r4;
    }

    public List<Edge> getEdges() throws MathIllegalStateException {
        Iterator<Edge> r0 = this.edgeToNode.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        Edge r1 = r0.next();
        r1.setNextEdge(getFollowingEdge(r1));
        goto L4
    L7:
        return new ArrayList(this.edgeToNode.keySet());
    }
}
