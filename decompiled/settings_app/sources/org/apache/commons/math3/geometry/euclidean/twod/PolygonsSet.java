package org.apache.commons.math3.geometry.euclidean.twod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.NodesSet;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class PolygonsSet extends AbstractRegion<Euclidean2D, Euclidean1D> {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private Vector2D[][] vertices;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = null;

        static {
            int[] r0 = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = r0;
            r0[Side.PLUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static class ConnectableSegment extends Segment {
        private final BSPTree<Euclidean2D> endNode;
        private ConnectableSegment next;
        private final BSPTree<Euclidean2D> node;
        private ConnectableSegment previous;
        private boolean processed;
        private final BSPTree<Euclidean2D> startNode;

        ConnectableSegment(Vector2D r1, Vector2D r2, Line r3, BSPTree<Euclidean2D> r4, BSPTree<Euclidean2D> r5, BSPTree<Euclidean2D> r6) {
            super(r1, r2, r3);
            this.node = r4;
            this.startNode = r5;
            this.endNode = r6;
            this.previous = null;
            this.next = null;
            this.processed = false;
        }

        public BSPTree<Euclidean2D> getNode() {
            return this.node;
        }

        public BSPTree<Euclidean2D> getStartNode() {
            return this.startNode;
        }

        public BSPTree<Euclidean2D> getEndNode() {
            return this.endNode;
        }

        public ConnectableSegment getPrevious() {
            return this.previous;
        }

        public void setPrevious(ConnectableSegment r1) {
            this.previous = r1;
        }

        public ConnectableSegment getNext() {
            return this.next;
        }

        public void setNext(ConnectableSegment r1) {
            this.next = r1;
        }

        public void setProcessed(boolean r1) {
            this.processed = r1;
        }

        public boolean isProcessed() {
            return this.processed;
        }
    }

    private static class Edge {
        private final Vertex end;
        private final Line line;
        private BSPTree<Euclidean2D> node;
        private final Vertex start;

        Edge(Vertex r1, Vertex r2, Line r3) {
            this.start = r1;
            this.end = r2;
            this.line = r3;
            this.node = null;
            r1.setOutgoing(this);
            r2.setIncoming(this);
        }

        public Vertex getStart() {
            return this.start;
        }

        public Vertex getEnd() {
            return this.end;
        }

        public Line getLine() {
            return this.line;
        }

        public void setNode(BSPTree<Euclidean2D> r1) {
            this.node = r1;
        }

        public BSPTree<Euclidean2D> getNode() {
            return this.node;
        }

        public Vertex split(Line r5) {
            Vertex r0 = new Vertex(this.line.intersection(r5));
            r0.bindWith(r5);
            Edge r6 = new Edge(this.start, r0, this.line);
            Edge r1 = new Edge(r0, this.end, this.line);
            r6.node = this.node;
            r1.node = this.node;
            return r0;
        }
    }

    private static class SegmentsBuilder implements BSPTreeVisitor<Euclidean2D> {
        private final List<ConnectableSegment> segments;
        private final double tolerance;

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitLeafNode(BSPTree<Euclidean2D> r1) {
        }

        SegmentsBuilder(double r1) {
            this.tolerance = r1;
            this.segments = new ArrayList();
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public BSPTreeVisitor.Order visitOrder(BSPTree<Euclidean2D> r1) {
            return BSPTreeVisitor.Order.MINUS_SUB_PLUS;
        }

        @Override // org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor
        public void visitInternalNode(BSPTree<Euclidean2D> r5) {
            BoundaryAttribute r0 = (BoundaryAttribute) r5.getAttribute();
            NodesSet r1 = r0.getSplitters();
            if (r0.getPlusOutside() == null) goto L6;
            addContribution(r0.getPlusOutside(), r5, r1, false);
        L6:
            if (r0.getPlusInside() == null) goto L9;
            addContribution(r0.getPlusInside(), r5, r1, true);
            return;
        }

        private void addContribution(SubHyperplane<Euclidean2D> r16, BSPTree<Euclidean2D> r17, Iterable<BSPTree<Euclidean2D>> r18, boolean r19) {
            Line r3 = (Line) r16.getHyperplane();
            Iterator<Interval> r2 = ((IntervalsSet) ((AbstractSubHyperplane) r16).getRemainingRegion()).asList().iterator();
        L4:
            if (r2.hasNext() == false) goto L17;
            Interval r4 = r2.next();
            if (Double.isInfinite(r4.getInf()) == false) goto L8;
            Vector2D r9 = null;
        L10:
            if (Double.isInfinite(r4.getSup()) == false) goto L12;
            Vector2D r8 = null;
        L13:
            BSPTree<Euclidean2D> r13 = selectClosest(r9, r18);
            BSPTree<Euclidean2D> r12 = selectClosest(r8, r18);
            if (r19 == true) goto L15;
            this.segments.add(new ConnectableSegment(r9, r8, r3, r17, r13, r12));
            goto L4
        L15:
            this.segments.add(new ConnectableSegment(r8, r9, r3.getReverse(), r17, r12, r13));
            goto L4
        L12:
            r8 = r3.toSpace(new Vector1D(r4.getSup()));
            goto L13
        L8:
            r9 = r3.toSpace(new Vector1D(r4.getInf()));
            goto L10
        }

        private BSPTree<Euclidean2D> selectClosest(Vector2D r9, Iterable<BSPTree<Euclidean2D>> r10) {
            Iterator<BSPTree<Euclidean2D>> r11 = r10.iterator();
            double r1 = Double.POSITIVE_INFINITY;
            BSPTree<Euclidean2D> r3 = null;
        L4:
            if (r11.hasNext() == false) goto L9;
            BSPTree<Euclidean2D> r4 = r11.next();
            double r5 = FastMath.abs(r4.getCut().getHyperplane().getOffset(r9));
            if (r5 >= r1) goto L4;
            r3 = r4;
            r1 = r5;
            goto L4
        L9:
            if (r1 <= this.tolerance) goto L11;
            return null;
        L11:
            return r3;
        }

        public List<ConnectableSegment> getSegments() {
            return this.segments;
        }
    }

    private static class Vertex {
        private Edge incoming;
        private final List<Line> lines;
        private final Vector2D location;
        private Edge outgoing;

        Vertex(Vector2D r1) {
            this.location = r1;
            this.incoming = null;
            this.outgoing = null;
            this.lines = new ArrayList();
        }

        public Vector2D getLocation() {
            return this.location;
        }

        public void bindWith(Line r1) {
            this.lines.add(r1);
        }

        public Line sharedLineWith(Vertex r4) {
            Iterator<Line> r3 = this.lines.iterator();
        L4:
            if (r3.hasNext() == false) goto L11;
            Line r0 = r3.next();
            Iterator<Line> r1 = r4.lines.iterator();
        L7:
            if (r1.hasNext() == false) goto L4;
            if (r0 != r1.next()) goto L7;
            return r0;
        L11:
            return null;
        }

        public void setIncoming(Edge r1) {
            this.incoming = r1;
            bindWith(r1.getLine());
        }

        public Edge getIncoming() {
            return this.incoming;
        }

        public void setOutgoing(Edge r1) {
            this.outgoing = r1;
            bindWith(r1.getLine());
        }

        public Edge getOutgoing() {
            return this.outgoing;
        }
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    public PolygonsSet(double r1) {
        super(r1);
    }

    public PolygonsSet(BSPTree<Euclidean2D> r1, double r2) {
        super(r1, r2);
    }

    public PolygonsSet(Collection<SubHyperplane<Euclidean2D>> r1, double r2) {
        super(r1, r2);
    }

    public PolygonsSet(double r1, double r3, double r5, double r7, double r9) {
        super(boxBoundary(r1, r3, r5, r7, r9), r9);
    }

    public PolygonsSet(double r1, Vector2D... r3) {
        super(verticesToTree(r1, r3), r1);
    }

    @Deprecated
    public PolygonsSet() {
        this(1.0E-10d);
    }

    @Deprecated
    public PolygonsSet(BSPTree<Euclidean2D> r3) {
        this(r3, 1.0E-10d);
    }

    @Deprecated
    public PolygonsSet(Collection<SubHyperplane<Euclidean2D>> r3) {
        this(r3, 1.0E-10d);
    }

    @Deprecated
    public PolygonsSet(double r12, double r14, double r16, double r18) {
        this(r12, r14, r16, r18, 1.0E-10d);
    }

    private static Line[] boxBoundary(double r2, double r4, double r6, double r8, double r10) {
        if (r2 < (r4 - r10)) goto L5;
        return null;
    L5:
        if (r6 >= (r8 - r10)) goto L11;
        Vector2D r0 = new Vector2D(r2, r6);
        Vector2D r1 = new Vector2D(r2, r8);
        Vector2D r3 = new Vector2D(r4, r6);
        Vector2D r5 = new Vector2D(r4, r8);
        return new Line[]{new Line(r0, r3, r10), new Line(r3, r5, r10), new Line(r5, r1, r10), new Line(r1, r0, r10)};
    L11:
        return null;
    }

    private static BSPTree<Euclidean2D> verticesToTree(double r11, Vector2D... r13) {
        int r0 = r13.length;
        if (r0 == 0) goto L5;
        Vertex[] r1 = new Vertex[r0];
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r1[r3] = new Vertex(r13[r3]);
        r3 = r3 + 1;
        goto L7
    L9:
        ArrayList r14 = new ArrayList(r0);
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L23;
        Vertex r5 = r1[r4];
        r4 = r4 + 1;
        Vertex r6 = r1[r4 % r0];
        Line r7 = r5.sharedLineWith(r6);
        if (r7 != null) goto L14;
        r7 = new Line(r5.getLocation(), r6.getLocation(), r11);
    L14:
        r14.add(new Edge(r5, r6, r7));
        int r8 = 0;
    L15:
        if (r8 >= r0) goto L10;
        Vertex r9 = r1[r8];
        if (r9 == r5) goto L22;
        if (r9 == r6) goto L22;
        if (FastMath.abs(r7.getOffset(r9.getLocation())) > r11) goto L22;
        r9.bindWith(r7);
    L22:
        r8 = r8 + 1;
        goto L15
    L23:
        BSPTree<Euclidean2D> r2 = new BSPTree();
        insertEdges(r11, r2, r14);
        return r2;
    L5:
        return new BSPTree(Boolean.TRUE);
    }

    private static void insertEdges(double r18, BSPTree<Euclidean2D> r20, List<Edge> r21) {
        int r3 = 0;
    L3:
        Edge r5 = null;
    L4:
        if (r5 != null) goto L14;
        if (r3 >= r21.size()) goto L14;
        int r6 = r3 + 1;
        Edge r4 = r21.get(r3);
        if (r4.getNode() != null) goto L12;
        if (r20.insertCut(r4.getLine()) == false) goto L12;
        r4.setNode(r20);
        r5 = r4;
        r3 = r6;
    L12:
        r3 = r6;
    L14:
        if (r5 != null) goto L23;
        BSPTree<S> r0 = r20.getParent();
        if (r0 != 0) goto L18;
    L21:
        r20.setAttribute(Boolean.TRUE);
        return;
    L18:
        if (r20 == r0.getMinus()) goto L21;
        r20.setAttribute(Boolean.FALSE);
        return;
    L23:
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        Iterator<Edge> r9 = r21.iterator();
    L25:
        if (r9.hasNext() == false) goto L61;
        Edge r10 = r9.next();
        if (r10 == r5) goto L25;
        double r11 = r5.getLine().getOffset(r10.getStart().getLocation());
        double r12 = r5.getLine().getOffset(r10.getEnd().getLocation());
        if (FastMath.abs(r11) > r18) goto L32;
        Side r13 = Side.HYPER;
    L36:
        if (FastMath.abs(r12) > r18) goto L39;
        Side r14 = Side.HYPER;
    L42:
        int r15 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r13.ordinal()];
        if (r15 != 1) goto L45;
        if (r14 == Side.MINUS) goto L58;
        r7.add(r10);
        goto L25
    L58:
        Vertex r16 = r10.split(r5.getLine());
        r8.add(r16.getOutgoing());
        r7.add(r16.getIncoming());
        goto L25
    L45:
        if (r15 != 2) goto L47;
        if (r14 == Side.PLUS) goto L54;
        r8.add(r10);
        goto L25
    L54:
        Vertex r17 = r10.split(r5.getLine());
        r8.add(r17.getIncoming());
        r7.add(r17.getOutgoing());
        goto L25
    L47:
        if (r14 == Side.PLUS) goto L48;
        if (r14 != Side.MINUS) goto L25;
        r8.add(r10);
        goto L25
    L48:
        r7.add(r10);
        goto L25
    L39:
        if (r12 >= 0.0d) goto L41;
        r14 = Side.MINUS;
        goto L42
    L41:
        r14 = Side.PLUS;
        goto L42
    L32:
        if (r11 >= 0.0d) goto L34;
        r13 = Side.MINUS;
        goto L36
    L34:
        r13 = Side.PLUS;
        goto L36
    L61:
        if (r7.isEmpty() == true) goto L63;
        insertEdges(r18, r20.getPlus(), r7);
    L65:
        if (r8.isEmpty() == true) goto L67;
        insertEdges(r18, r20.getMinus(), r8);
        return;
    L67:
        r20.getMinus().setAttribute(Boolean.TRUE);
        return;
    L63:
        r20.getPlus().setAttribute(Boolean.FALSE);
        goto L65
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public PolygonsSet buildNew(BSPTree<Euclidean2D> r4) {
        return new PolygonsSet(r4, getTolerance());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    protected void computeGeometricalProperties() {
        Vector2D[][] r1 = getVertices();
        if (r1.length != 0) goto L11;
        BSPTree<Euclidean2D> r2 = getTree(false);
        if (r2.getCut() == null) goto L7;
    L9:
        setSize(0.0d);
        setBarycenter(new Vector2D(0.0d, 0.0d));
        return;
    L7:
        if (((Boolean) r2.getAttribute()).booleanValue() == false) goto L9;
        setSize(Double.POSITIVE_INFINITY);
        setBarycenter(Vector2D.NaN);
        return;
    L11:
        if (r1[0][0] != null) goto L13;
        setSize(Double.POSITIVE_INFINITY);
        setBarycenter(Vector2D.NaN);
        return;
    L13:
        int r3 = r1.length;
        int r8 = 0;
        double r9 = 0.0d;
        double r11 = 0.0d;
        double r13 = 0.0d;
    L14:
        if (r8 >= r3) goto L20;
        Vector2D[] r15 = r1[r8];
        double r16 = r15[r15.length - 1].getX();
        double r18 = r15[r15.length - 1].getY();
        int r5 = r15.length;
        int r4 = 0;
    L16:
        if (r4 >= r5) goto L18;
        Vector2D r6 = r15[r4];
        double r20 = r6.getX();
        double r22 = r6.getY();
        double r24 = (r16 * r22) - (r18 * r20);
        r9 = r9 + r24;
        r11 = r11 + ((r16 + r20) * r24);
        r13 = r13 + (r24 * (r18 + r22));
        r4 = r4 + 1;
        r16 = r20;
        r18 = r22;
        goto L16
    L18:
        r8 = r8 + 1;
        goto L14
    L20:
        if (r9 >= 0.0d) goto L22;
        setSize(Double.POSITIVE_INFINITY);
        setBarycenter(Vector2D.NaN);
        return;
    L22:
        setSize(r9 / 2.0d);
        double r10 = r9 * 3.0d;
        setBarycenter(new Vector2D(r11 / r10, r13 / r10));
    }

    public Vector2D[][] getVertices() {
        if (this.vertices != null) goto L58;
        int r1 = 0;
        if (getTree(false).getCut() != null) goto L7;
        this.vertices = new Vector2D[0][];
        goto L58
    L7:
        SegmentsBuilder r2 = new SegmentsBuilder(getTolerance());
        int r3 = 1;
        getTree(true).visit(r2);
        List<ConnectableSegment> r4 = r2.getSegments();
        int r5 = r4.size() - naturalFollowerConnections(r4);
        if (r5 <= 0) goto L10;
        r5 = r5 - splitEdgeConnections(r4);
    L10:
        if (r5 <= 0) goto L12;
        closeVerticesConnections(r4);
    L12:
        ArrayList r6 = new ArrayList();
    L13:
        ConnectableSegment r7 = getUnprocessed(r4);
        if (r7 == null) goto L21;
        List<Segment> r8 = followLoop(r7);
        if (r8 == null) goto L13;
        if (r8.get(0).getStart() == null) goto L19;
        r6.add(r8);
        goto L13
    L19:
        r6.add(0, r8);
        goto L13
    L21:
        this.vertices = new Vector2D[r6.size()][];
        Iterator r9 = r6.iterator();
        int r10 = 0;
    L23:
        if (r9.hasNext() == false) goto L58;
        List r11 = (List) r9.next();
        Vector2D r12 = null;
        if (r11.size() >= 2) goto L27;
    L55:
        Iterator r15 = r9;
        Line r13 = ((Segment) r11.get(r1)).getLine();
        Vector2D[][] r14 = this.vertices;
        Vector2D[] r16 = new Vector2D[3];
        r16[r1] = null;
        int r17 = 1;
        r16[1] = r13.toSpace(new Vector1D(-3.4028234663852886E38d));
        r16[2] = r13.toSpace(new Vector1D(3.4028234663852886E38d));
        r14[r10] = r16;
        r10 = r10 + 1;
    L56:
        r3 = r17;
        r9 = r15;
        goto L23
    L27:
        if (r11.size() != 2) goto L34;
        if (((Segment) r11.get(r1)).getStart() != null) goto L34;
        if (((Segment) r11.get(r3)).getEnd() == null) goto L55;
    L34:
        if (((Segment) r11.get(r1)).getStart() != null) goto L49;
        int r18 = r11.size() + 2;
        Vector2D[] r19 = new Vector2D[r18];
        Iterator r20 = r11.iterator();
        int r21 = r1;
    L37:
        if (r20.hasNext() == false) goto L48;
        Segment r110 = (Segment) r20.next();
        if (r21 != 0) goto L42;
        double r111 = r110.getLine().toSubSpace(r110.getEnd()).getX();
        double r22 = r111 - FastMath.max(1.0d, FastMath.abs(r111 / 2.0d));
        int r112 = r21 + 1;
        r19[r21] = r12;
        r21 = r112 + 1;
        r19[r112] = r110.getLine().toSpace(new Vector1D(r22));
    L42:
        int r23 = r18 - 1;
        if (r21 >= r23) goto L45;
        r19[r21] = r110.getEnd();
        r21 = r21 + 1;
    L45:
        if (r21 != r23) goto L47;
        double r24 = r110.getLine().toSubSpace(r110.getStart()).getX();
        r19[r21] = r110.getLine().toSpace(new Vector1D(r24 + FastMath.max(1.0d, FastMath.abs(r24 / 2.0d))));
        r21 = r21 + 1;
    L47:
        r9 = r9;
        r12 = null;
        goto L37
    L48:
        r15 = r9;
        this.vertices[r10] = r19;
        r10 = r10 + 1;
    L54:
        r1 = 0;
        r17 = 1;
        goto L56
    L49:
        r15 = r9;
        Vector2D[] r25 = new Vector2D[r11.size()];
        Iterator r26 = r11.iterator();
        int r27 = 0;
    L51:
        if (r26.hasNext() == false) goto L53;
        r25[r27] = ((Segment) r26.next()).getStart();
        r27 = r27 + 1;
        goto L51
    L53:
        this.vertices[r10] = r25;
        r10 = r10 + 1;
    L58:
        return (Vector2D[][]) this.vertices.clone();
    }

    private int naturalFollowerConnections(List<ConnectableSegment> r8) {
        Iterator<ConnectableSegment> r7 = r8.iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L17;
        ConnectableSegment r1 = r7.next();
        if (r1.getNext() != null) goto L4;
        BSPTree<Euclidean2D> r2 = r1.getNode();
        BSPTree<Euclidean2D> r3 = r1.getEndNode();
        Iterator<ConnectableSegment> r4 = r8.iterator();
    L9:
        if (r4.hasNext() == false) goto L4;
        ConnectableSegment r5 = r4.next();
        if (r5.getPrevious() != null) goto L9;
        if (r5.getNode() != r3) goto L9;
        if (r5.getStartNode() != r2) goto L9;
        r1.setNext(r5);
        r5.setPrevious(r1);
        r0 = r0 + 1;
        goto L4
    L17:
        return r0;
    }

    private int splitEdgeConnections(List<ConnectableSegment> r8) {
        Iterator<ConnectableSegment> r7 = r8.iterator();
        int r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L17;
        ConnectableSegment r1 = r7.next();
        if (r1.getNext() != null) goto L4;
        Hyperplane r2 = r1.getNode().getCut().getHyperplane();
        BSPTree<Euclidean2D> r3 = r1.getEndNode();
        Iterator<ConnectableSegment> r4 = r8.iterator();
    L9:
        if (r4.hasNext() == false) goto L4;
        ConnectableSegment r5 = r4.next();
        if (r5.getPrevious() != null) goto L9;
        if (r5.getNode().getCut().getHyperplane() != r2) goto L9;
        if (r5.getStartNode() != r3) goto L9;
        r1.setNext(r5);
        r5.setPrevious(r1);
        r0 = r0 + 1;
        goto L4
    L17:
        return r0;
    }

    private int closeVerticesConnections(List<ConnectableSegment> r13) {
        Iterator<ConnectableSegment> r0 = r13.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L22;
        ConnectableSegment r2 = r0.next();
        if (r2.getNext() != null) goto L4;
        if (r2.getEnd() == null) goto L4;
        Vector2D r3 = r2.getEnd();
        Iterator<ConnectableSegment> r4 = r13.iterator();
        ConnectableSegment r5 = null;
        double r6 = Double.POSITIVE_INFINITY;
    L11:
        if (r4.hasNext() == false) goto L20;
        ConnectableSegment r8 = r4.next();
        if (r8.getPrevious() != null) goto L11;
        if (r8.getStart() == null) goto L11;
        double r9 = Vector2D.distance(r3, r8.getStart());
        if (r9 >= r6) goto L11;
        r5 = r8;
        r6 = r9;
        goto L11
    L20:
        if (r6 > getTolerance()) goto L4;
        r2.setNext(r5);
        r5.setPrevious(r2);
        r1 = r1 + 1;
        goto L4
    L22:
        return r1;
    }

    private ConnectableSegment getUnprocessed(List<ConnectableSegment> r2) {
        Iterator<ConnectableSegment> r1 = r2.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ConnectableSegment r3 = r1.next();
        if (r3.isProcessed() == true) goto L4;
        return r3;
    L8:
        return null;
    }

    private List<Segment> followLoop(ConnectableSegment r5) {
        ArrayList r0 = new ArrayList();
        r0.add(r5);
        r5.setProcessed(true);
        ConnectableSegment r2 = r5.getNext();
    L3:
        if (r2 == r5) goto L7;
        if (r2 == null) goto L7;
        r0.add(r2);
        r2.setProcessed(true);
        r2 = r2.getNext();
    L7:
        if (r2 != null) goto L11;
        ConnectableSegment r6 = r5.getPrevious();
    L9:
        if (r6 == null) goto L11;
        r0.add(0, r6);
        r6.setProcessed(true);
        r6 = r6.getPrevious();
    L11:
        filterSpuriousVertices(r0);
        if (r0.size() == 2) goto L14;
    L17:
        return r0;
    L14:
        if (r0.get(0).getStart() == null) goto L17;
        return null;
    }

    private void filterSpuriousVertices(List<Segment> r11) {
        int r10 = 0;
    L4:
        if (r10 >= r11.size()) goto L11;
        Segment r0 = r11.get(r10);
        int r1 = (r10 + 1) % r11.size();
        Segment r2 = r11.get(r1);
        if (r2 == null) goto L10;
        if (Precision.equals(r0.getLine().getAngle(), r2.getLine().getAngle(), Precision.EPSILON) == false) goto L10;
        r11.set(r1, new Segment(r0.getStart(), r2.getEnd(), r0.getLine()));
        r11.remove(r10);
        r10 = r10 - 1;
    L10:
        r10 = r10 + 1;
        goto L4
    }
}
