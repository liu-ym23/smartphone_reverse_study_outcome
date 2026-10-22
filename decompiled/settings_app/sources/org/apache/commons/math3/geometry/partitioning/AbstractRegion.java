package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractRegion<S extends Space, T extends Space> implements Region<S> {
    private Point<S> barycenter;
    private double size;
    private final double tolerance;
    private BSPTree<S> tree;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.partitioning.AbstractRegion$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = null;

        static {
            int[] r0 = new int[Side.values().length];
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side = r0;
            r0[Side.PLUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.MINUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[Side.BOTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public abstract AbstractRegion<S, T> buildNew(BSPTree<S> r1);

    protected abstract void computeGeometricalProperties();

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region copySelf() {
        return copySelf();
    }

    protected AbstractRegion(double r3) {
        this.tree = new BSPTree(Boolean.TRUE);
        this.tolerance = r3;
    }

    protected AbstractRegion(BSPTree<S> r1, double r2) {
        this.tree = r1;
        this.tolerance = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected AbstractRegion(Collection<SubHyperplane<S>> r1, double r2) {
        this.tolerance = r2;
        if (r1.size() != 0) goto L5;
        this.tree = new BSPTree(Boolean.TRUE);
        return;
    L5:
        TreeSet r3 = new TreeSet(new AnonymousClass1(this));
        r3.addAll(r1);
        BSPTree<S> r4 = new BSPTree();
        this.tree = r4;
        insertCuts(r4, r3);
        this.tree.visit(new AnonymousClass2(this));
    }

    public AbstractRegion(Hyperplane<S>[] r3, double r4) {
        this.tolerance = r4;
        if (r3 != null) goto L5;
    L13:
        this.tree = new BSPTree(Boolean.FALSE);
        return;
    L5:
        if (r3.length == 0) goto L13;
        int r5 = 0;
        BSPTree<S> r6 = r3[0].wholeSpace().getTree(false);
        this.tree = r6;
        r6.setAttribute(Boolean.TRUE);
        int r2 = r3.length;
    L8:
        if (r5 >= r2) goto L18;
        if (r6.insertCut(r3[r5]) == false) goto L12;
        r6.setAttribute(null);
        r6.getPlus().setAttribute(Boolean.FALSE);
        r6 = r6.getMinus();
        r6.setAttribute(Boolean.TRUE);
    L12:
        r5 = r5 + 1;
        goto L8
    }

    public double getTolerance() {
        return this.tolerance;
    }

    private void insertCuts(BSPTree<S> r8, Collection<SubHyperplane<S>> r9) {
        Iterator<SubHyperplane<S>> r10 = r9.iterator();
    L3:
        Hyperplane<S> r1 = null;
    L4:
        if (r1 != null) goto L11;
        if (r10.hasNext() == false) goto L11;
        r1 = r10.next().getHyperplane();
        if (r8.insertCut(r1.copySelf()) == true) goto L4;
    L11:
        if (r10.hasNext() == true) goto L13;
        return;
    L13:
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
    L15:
        if (r10.hasNext() == false) goto L26;
        SubHyperplane<S> r3 = r10.next();
        SubHyperplane.SplitSubHyperplane<S> r4 = r3.split(r1);
        int r5 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$geometry$partitioning$Side[r4.getSide().ordinal()];
        if (r5 != 1) goto L19;
        r0.add(r3);
        goto L15
    L19:
        if (r5 != 2) goto L21;
        r2.add(r3);
        goto L15
    L21:
        if (r5 != 3) goto L15;
        r0.add(r4.getPlus());
        r2.add(r4.getMinus());
        goto L15
    L26:
        insertCuts(r8.getPlus(), r0);
        insertCuts(r8.getMinus(), r2);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public AbstractRegion<S, T> copySelf() {
        return buildNew(this.tree.copySelf());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isEmpty() {
        return isEmpty(this.tree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isEmpty(BSPTree<S> r3) {
        if (r3.getCut() != null) goto L7;
        return !((Boolean) r3.getAttribute()).booleanValue();
    L7:
        if (isEmpty(r3.getMinus()) == true) goto L9;
    L11:
        return false;
    L9:
        if (isEmpty(r3.getPlus()) == false) goto L11;
        return true;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isFull() {
        return isFull(this.tree);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean isFull(BSPTree<S> r2) {
        if (r2.getCut() != null) goto L7;
        return ((Boolean) r2.getAttribute()).booleanValue();
    L7:
        if (isFull(r2.getMinus()) == true) goto L9;
    L11:
        return false;
    L9:
        if (isFull(r2.getPlus()) == false) goto L11;
        return true;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public boolean contains(Region<S> r2) {
        return new RegionFactory().difference(r2, this).isEmpty();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public BoundaryProjection<S> projectToBoundary(Point<S> r2) {
        BoundaryProjector r0 = new BoundaryProjector(r2);
        getTree(true).visit(r0);
        return r0.getProjection();
    }

    public Region.Location checkPoint(Vector<S> r1) {
        return checkPoint(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public Region.Location checkPoint(Point<S> r2) {
        return checkPoint(this.tree, r2);
    }

    protected Region.Location checkPoint(BSPTree<S> r1, Vector<S> r2) {
        return checkPoint(r1, r2);
    }

    protected Region.Location checkPoint(BSPTree<S> r3, Point<S> r4) {
        BSPTree<S> r5 = r3.getCell(r4, this.tolerance);
        if (r5.getCut() == null) goto L5;
        Region.Location r0 = checkPoint(r5.getMinus(), r4);
        if (r0 != checkPoint(r5.getPlus(), r4)) goto L13;
        return r0;
    L13:
        return Region.Location.BOUNDARY;
    L5:
        if (((Boolean) r5.getAttribute()).booleanValue() == false) goto L8;
        return Region.Location.INSIDE;
    L8:
        return Region.Location.OUTSIDE;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public BSPTree<S> getTree(boolean r2) {
        if (r2 == false) goto L9;
        if (this.tree.getCut() == null) goto L9;
        if (this.tree.getAttribute() != null) goto L9;
        this.tree.visit(new BoundaryBuilder());
    L9:
        return this.tree;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public double getBoundarySize() {
        BoundarySizeVisitor r0 = new BoundarySizeVisitor();
        getTree(true).visit(r0);
        return r0.getSize();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public double getSize() {
        if (this.barycenter != null) goto L6;
        computeGeometricalProperties();
    L6:
        return this.size;
    }

    protected void setSize(double r1) {
        this.size = r1;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public Point<S> getBarycenter() {
        if (this.barycenter != null) goto L6;
        computeGeometricalProperties();
    L6:
        return this.barycenter;
    }

    protected void setBarycenter(Vector<S> r1) {
        setBarycenter(r1);
    }

    protected void setBarycenter(Point<S> r1) {
        this.barycenter = r1;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    @Deprecated
    public Side side(Hyperplane<S> r2) {
        InsideFinder r0 = new InsideFinder(this);
        r0.recurseSides(this.tree, r2.wholeHyperplane());
        if (r0.plusFound() == false) goto L9;
        if (r0.minusFound() == false) goto L14;
        return Side.BOTH;
    L14:
        return Side.PLUS;
    L9:
        if (r0.minusFound() == false) goto L12;
        return Side.MINUS;
    L12:
        return Side.HYPER;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Region
    public SubHyperplane<S> intersection(SubHyperplane<S> r2) {
        return recurseIntersection(this.tree, r2);
    }

    private SubHyperplane<S> recurseIntersection(BSPTree<S> r3, SubHyperplane<S> r4) {
        if (r3.getCut() == null) goto L5;
        SubHyperplane.SplitSubHyperplane<S> r0 = r4.split(r3.getCut().getHyperplane());
        if (r0.getPlus() == null) goto L23;
        if (r0.getMinus() == null) goto L21;
        SubHyperplane<S> r5 = recurseIntersection(r3.getPlus(), r0.getPlus());
        SubHyperplane<S> r2 = recurseIntersection(r3.getMinus(), r0.getMinus());
        if (r5 != null) goto L16;
        return r2;
    L16:
        if (r2 != null) goto L19;
        return r5;
    L19:
        return r5.reunite(r2);
    L21:
        return recurseIntersection(r3.getPlus(), r4);
    L23:
        if (r0.getMinus() == null) goto L27;
        return recurseIntersection(r3.getMinus(), r4);
    L27:
        return recurseIntersection(r3.getPlus(), recurseIntersection(r3.getMinus(), r4));
    L5:
        if (((Boolean) r3.getAttribute()).booleanValue() == true) goto L28;
        return null;
    L28:
        return r4.copySelf();
    }

    public AbstractRegion<S, T> applyTransform(Transform<S, T> r7) {
        HashMap r0 = new HashMap();
        BSPTree<S> r8 = recurseTransform(getTree(false), r7, r0);
        Iterator<Map.Entry<BSPTree<S>, BSPTree<S>>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<BSPTree<S>, BSPTree<S>> r2 = r1.next();
        if (r2.getKey().getCut() == null) goto L4;
        BoundaryAttribute r3 = (BoundaryAttribute) r2.getKey().getAttribute();
        if (r3 == null) goto L4;
        BoundaryAttribute r4 = (BoundaryAttribute) r2.getValue().getAttribute();
        Iterator<BSPTree<S>> r5 = r3.getSplitters().iterator();
    L11:
        if (r5.hasNext() == false) goto L4;
        BSPTree<S> r6 = r5.next();
        r4.getSplitters().add(r0.get(r6));
        goto L11
    L14:
        return buildNew(r8);
    }

    private BSPTree<S> recurseTransform(BSPTree<S> r6, Transform<S, T> r7, Map<BSPTree<S>, BSPTree<S>> r8) {
        if (r6.getCut() != null) goto L5;
        BSPTree<S> r5 = new BSPTree(r6.getAttribute());
    L17:
        r8.put(r6, r5);
        return r5;
    L5:
        AbstractSubHyperplane<S, T> r0 = ((AbstractSubHyperplane) r6.getCut()).applyTransform(r7);
        BoundaryAttribute r1 = (BoundaryAttribute) r6.getAttribute();
        if (r1 == null) goto L16;
        AbstractSubHyperplane<S, T> r3 = null;
        if (r1.getPlusOutside() != null) goto L10;
        AbstractSubHyperplane<S, T> r2 = null;
    L12:
        if (r1.getPlusInside() == null) goto L15;
        r3 = ((AbstractSubHyperplane) r1.getPlusInside()).applyTransform(r7);
    L15:
        r1 = new BoundaryAttribute(r2, r3, new NodesSet());
        goto L16
    L10:
        r2 = ((AbstractSubHyperplane) r1.getPlusOutside()).applyTransform(r7);
    L16:
        r5 = new BSPTree(r0, recurseTransform(r6.getPlus(), r7, r8), recurseTransform(r6.getMinus(), r7, r8), r1);
        goto L17
    }
}
