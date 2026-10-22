package org.apache.commons.math3.geometry.spherical.oned;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BoundaryProjection;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class ArcsSet extends AbstractRegion<Sphere1D, Sphere1D> implements Iterable<double[]> {

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.spherical.oned.ArcsSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class InconsistentStateAt2PiWrapping extends MathIllegalArgumentException {
        private static final long serialVersionUID = 20140107;

        public InconsistentStateAt2PiWrapping() {
            super(LocalizedFormats.INCONSISTENT_STATE_AT_2_PI_WRAPPING, new Object[0]);
        }
    }

    public static class Split {
        private final ArcsSet minus;
        private final ArcsSet plus;

        /* synthetic */ Split(ArcsSet r1, ArcsSet r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private Split(ArcsSet r1, ArcsSet r2) {
            this.plus = r1;
            this.minus = r2;
        }

        public ArcsSet getPlus() {
            return this.plus;
        }

        public ArcsSet getMinus() {
            return this.minus;
        }

        public Side getSide() {
            if (this.plus == null) goto L11;
            if (this.minus == null) goto L9;
            return Side.BOTH;
        L9:
            return Side.PLUS;
        L11:
            if (this.minus == null) goto L15;
            return Side.MINUS;
        L15:
            return Side.HYPER;
        }
    }

    private class SubArcsIterator implements Iterator<double[]> {
        private BSPTree<Sphere1D> current;
        private final BSPTree<Sphere1D> firstStart;
        private double[] pending;
        final /* synthetic */ ArcsSet this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ double[] next() {
            return next2();
        }

        SubArcsIterator(ArcsSet r2) {
            this.this$0 = r2;
            BSPTree<Sphere1D> r0 = ArcsSet.access$000(r2);
            this.firstStart = r0;
            this.current = r0;
            if (r0 == null) goto L5;
            selectPending();
            return;
        L5:
            if (((Boolean) ArcsSet.access$100(r2, r2.getTree(false)).getAttribute()).booleanValue() == false) goto L7;
            this.pending = new double[]{0.0d, 6.283185307179586d};
            return;
        L7:
            this.pending = null;
        }

        private void selectPending() {
            BSPTree<Sphere1D> r0 = this.current;
        L3:
            if (r0 == null) goto L8;
            if (ArcsSet.access$200(this.this$0, r0) == true) goto L8;
            r0 = ArcsSet.access$300(this.this$0, r0);
        L8:
            if (r0 != null) goto L11;
            this.current = null;
            this.pending = null;
            return;
        L11:
            BSPTree<Sphere1D> r2 = r0;
        L12:
            if (r2 == null) goto L17;
            if (ArcsSet.access$400(this.this$0, r2) == true) goto L17;
            r2 = ArcsSet.access$300(this.this$0, r2);
        L17:
            if (r2 == null) goto L19;
            this.pending = new double[]{ArcsSet.access$500(this.this$0, r0), ArcsSet.access$500(this.this$0, r2)};
            this.current = r2;
            return;
        L19:
            BSPTree<Sphere1D> r3 = this.firstStart;
        L20:
            if (r3 == null) goto L24;
            if (ArcsSet.access$400(this.this$0, r3) == true) goto L24;
            r3 = ArcsSet.access$600(this.this$0, r3);
        L24:
            if (r3 == null) goto L28;
            this.pending = new double[]{ArcsSet.access$500(this.this$0, r0), ArcsSet.access$500(this.this$0, r3) + 6.283185307179586d};
            this.current = null;
            return;
        L28:
            throw new MathInternalError();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pending == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public double[] next2() {
            double[] r0 = this.pending;
            if (r0 == null) goto L7;
            selectPending();
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static /* synthetic */ BSPTree access$000(ArcsSet r0) {
        return r0.getFirstArcStart();
    }

    static /* synthetic */ BSPTree access$100(ArcsSet r0, BSPTree r1) {
        return r0.getFirstLeaf(r1);
    }

    static /* synthetic */ boolean access$200(ArcsSet r0, BSPTree r1) {
        return r0.isArcStart(r1);
    }

    static /* synthetic */ BSPTree access$300(ArcsSet r0, BSPTree r1) {
        return r0.nextInternalNode(r1);
    }

    static /* synthetic */ boolean access$400(ArcsSet r0, BSPTree r1) {
        return r0.isArcEnd(r1);
    }

    static /* synthetic */ double access$500(ArcsSet r0, BSPTree r1) {
        return r0.getAngle(r1);
    }

    static /* synthetic */ BSPTree access$600(ArcsSet r0, BSPTree r1) {
        return r0.previousInternalNode(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    public ArcsSet(double r1) {
        super(r1);
    }

    public ArcsSet(double r1, double r3, double r5) throws NumberIsTooLargeException {
        super(buildTree(r1, r3, r5), r5);
    }

    public ArcsSet(BSPTree<Sphere1D> r1, double r2) throws InconsistentStateAt2PiWrapping {
        super(r1, r2);
        check2PiConsistency();
    }

    public ArcsSet(Collection<SubHyperplane<Sphere1D>> r1, double r2) throws InconsistentStateAt2PiWrapping {
        super(r1, r2);
        check2PiConsistency();
    }

    private static BSPTree<Sphere1D> buildTree(double r7, double r9, double r11) throws NumberIsTooLargeException {
        if (Precision.equals(r7, r9, 0) == true) goto L18;
        double r1 = r9 - r7;
        if (r1 >= 6.283185307179586d) goto L18;
        if (r7 > r9) goto L16;
        double r8 = MathUtils.normalizeAngle(r7, 3.141592653589793d);
        double r2 = r1 + r8;
        SubLimitAngle r10 = new LimitAngle(new S1Point(r8), false, r11).wholeHyperplane();
        if (r2 > 6.283185307179586d) goto L14;
        SubLimitAngle r12 = new LimitAngle(new S1Point(r2), true, r11).wholeHyperplane();
        return new BSPTree(r10, new BSPTree(Boolean.FALSE), new BSPTree(r12, new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null), null);
    L14:
        return new BSPTree(r10, new BSPTree(new LimitAngle(new S1Point(r2 - 6.283185307179586d), true, r11).wholeHyperplane(), new BSPTree(Boolean.FALSE), new BSPTree(Boolean.TRUE), null), new BSPTree(Boolean.TRUE), null);
    L16:
        throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(r7), Double.valueOf(r9), true);
    L18:
        return new BSPTree(Boolean.TRUE);
    }

    private void check2PiConsistency() throws InconsistentStateAt2PiWrapping {
        BSPTree<Sphere1D> r0 = getTree(false);
        if (r0.getCut() != null) goto L5;
        return;
    L5:
        Boolean r1 = (Boolean) getFirstLeaf(r0).getAttribute();
        Boolean r2 = (Boolean) getLastLeaf(r0).getAttribute();
        boolean r3 = r1.booleanValue();
        if ((r2.booleanValue() ^ r3) == true) goto L9;
        return;
    L9:
        throw new InconsistentStateAt2PiWrapping();
    }

    private BSPTree<Sphere1D> getFirstLeaf(BSPTree<Sphere1D> r3) {
        if (r3.getCut() != null) goto L5;
        return r3;
    L5:
        BSPTree<Sphere1D> r0 = null;
    L6:
        if (r3 == null) goto L9;
        r0 = r3;
        r3 = previousInternalNode(r3);
        goto L6
    L9:
        return leafBefore(r0);
    }

    private BSPTree<Sphere1D> getLastLeaf(BSPTree<Sphere1D> r3) {
        if (r3.getCut() != null) goto L5;
        return r3;
    L5:
        BSPTree<Sphere1D> r0 = null;
    L6:
        if (r3 == null) goto L9;
        r0 = r3;
        r3 = nextInternalNode(r3);
        goto L6
    L9:
        return leafAfter(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math3.geometry.spherical.oned.ArcsSet] */
    private BSPTree<Sphere1D> getFirstArcStart() {
        BSPTree r0 = getTree(false);
        if (r0.getCut() != null) goto L6;
        return null;
    L6:
        BSPTree r1 = getFirstLeaf(r0).getParent();
    L7:
        if (r1 == null) goto L11;
        if (isArcStart(r1) == true) goto L11;
        r1 = nextInternalNode(r1);
    L11:
        return r1;
    }

    private boolean isArcStart(BSPTree<Sphere1D> r3) {
        if (((Boolean) leafBefore(r3).getAttribute()).booleanValue() == false) goto L6;
        return false;
    L6:
        if (((Boolean) leafAfter(r3).getAttribute()).booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    }

    private boolean isArcEnd(BSPTree<Sphere1D> r3) {
        if (((Boolean) leafBefore(r3).getAttribute()).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) leafAfter(r3).getAttribute()).booleanValue() == false) goto L8;
        return false;
    L8:
        return true;
    }

    private BSPTree<Sphere1D> nextInternalNode(BSPTree<Sphere1D> r2) {
        if (childAfter(r2).getCut() == null) goto L7;
        return leafAfter(r2).getParent();
    L7:
        if (isAfterParent(r2) == false) goto L10;
        r2 = r2.getParent();
        goto L7
    L10:
        return r2.getParent();
    }

    private BSPTree<Sphere1D> previousInternalNode(BSPTree<Sphere1D> r2) {
        if (childBefore(r2).getCut() == null) goto L7;
        return leafBefore(r2).getParent();
    L7:
        if (isBeforeParent(r2) == false) goto L10;
        r2 = r2.getParent();
        goto L7
    L10:
        return r2.getParent();
    }

    private BSPTree<Sphere1D> leafBefore(BSPTree<Sphere1D> r2) {
        BSPTree<Sphere1D> r3 = childBefore(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childAfter(r3);
        goto L4
    L6:
        return r3;
    }

    private BSPTree<Sphere1D> leafAfter(BSPTree<Sphere1D> r2) {
        BSPTree<Sphere1D> r3 = childAfter(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childBefore(r3);
        goto L4
    L6:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isBeforeParent(BSPTree<Sphere1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childBefore(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isAfterParent(BSPTree<Sphere1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childAfter(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    private BSPTree<Sphere1D> childBefore(BSPTree<Sphere1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getMinus();
    L7:
        return r1.getPlus();
    }

    private BSPTree<Sphere1D> childAfter(BSPTree<Sphere1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getPlus();
    L7:
        return r1.getMinus();
    }

    private boolean isDirect(BSPTree<Sphere1D> r1) {
        return ((LimitAngle) r1.getCut().getHyperplane()).isDirect();
    }

    private double getAngle(BSPTree<Sphere1D> r1) {
        return ((LimitAngle) r1.getCut().getHyperplane()).getLocation().getAlpha();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public ArcsSet buildNew(BSPTree<Sphere1D> r4) {
        return new ArcsSet(r4, getTolerance());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion
    protected void computeGeometricalProperties() {
        double r2 = 6.283185307179586d;
        double r4 = 0.0d;
        if (getTree(false).getCut() != null) goto L9;
        setBarycenter(S1Point.NaN);
        if (((Boolean) getTree(false).getAttribute()).booleanValue() == true) goto L8;
        r2 = 0.0d;
    L8:
        setSize(r2);
        return;
    L9:
        Iterator<double[]> r1 = iterator();
        double r6 = 0.0d;
    L11:
        if (r1.hasNext() == false) goto L13;
        double[] r8 = r1.next();
        double r9 = r8[1];
        double r11 = r8[0];
        double r13 = r9 - r11;
        r4 = r4 + r13;
        r6 = r6 + (r13 * (r11 + r9));
        goto L11
    L13:
        setSize(r4);
        if (Precision.equals(r4, 6.283185307179586d, 0) == false) goto L17;
        setBarycenter(S1Point.NaN);
        return;
    L17:
        if (r4 < Precision.SAFE_MIN) goto L19;
        setBarycenter(new S1Point(r6 / (r4 * 2.0d)));
        return;
    L19:
        setBarycenter(((LimitAngle) getTree(false).getCut().getHyperplane()).getLocation());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public BoundaryProjection<Sphere1D> projectToBoundary(Point<Sphere1D> r14) {
        double r0 = ((S1Point) r14).getAlpha();
        Iterator<double[]> r13 = iterator();
        double r3 = Double.NaN;
        boolean r7 = false;
        double r5 = Double.NaN;
    L4:
        if (r13.hasNext() == false) goto L31;
        double[] r8 = r13.next();
        if (Double.isNaN(r5) == false) goto L9;
        r5 = r8[0];
    L9:
        if (r7 == true) goto L29;
        double r10 = r8[0];
        if (r0 < r10) goto L13;
        double r4 = r8[1];
        if (r0 > r4) goto L29;
        double r11 = r10 - r0;
        double r1 = r0 - r4;
        if (r11 >= r1) goto L28;
        return new BoundaryProjection(r14, new S1Point(r8[1]), r1);
    L28:
        return new BoundaryProjection(r14, new S1Point(r8[0]), r11);
    L13:
        if (Double.isNaN(r3) == false) goto L15;
        r7 = true;
        goto L29
    L15:
        double r6 = r0 - r3;
        double r9 = r8[0] - r0;
        if (r6 >= r9) goto L20;
        return new BoundaryProjection(r14, new S1Point(r3), r6);
    L20:
        return new BoundaryProjection(r14, new S1Point(r8[0]), r9);
    L29:
        r3 = r8[1];
        goto L4
    L31:
        if (Double.isNaN(r3) == true) goto L33;
        if (r7 == false) goto L41;
        double r12 = r0 - (r3 - 6.283185307179586d);
        double r2 = r5 - r0;
        if (r12 >= r2) goto L40;
        return new BoundaryProjection(r14, new S1Point(r3), r12);
    L40:
        return new BoundaryProjection(r14, new S1Point(r5), r2);
    L41:
        double r15 = r0 - r3;
        double r16 = (6.283185307179586d + r5) - r0;
        if (r15 >= r16) goto L46;
        return new BoundaryProjection(r14, new S1Point(r3), r15);
    L46:
        return new BoundaryProjection(r14, new S1Point(r5), r16);
    L33:
        return new BoundaryProjection(r14, null, 6.283185307179586d);
    }

    public List<Arc> asList() {
        ArrayList r0 = new ArrayList();
        Iterator<double[]> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        double[] r2 = r1.next();
        r0.add(new Arc(r2[0], r2[1], getTolerance()));
        goto L4
    L6:
        return r0;
    }

    @Override // java.lang.Iterable
    public Iterator<double[]> iterator() {
        return new SubArcsIterator(this);
    }

    @Deprecated
    public Side side(Arc r1) {
        return split(r1).getSide();
    }

    public Split split(Arc r21) {
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        double r5 = r21.getInf() + 3.141592653589793d;
        double r3 = r21.getSup() - r21.getInf();
        Iterator<double[]> r7 = iterator();
    L4:
        if (r7.hasNext() == false) goto L22;
        double[] r8 = r7.next();
        double r10 = MathUtils.normalizeAngle(r8[0], r5) - r21.getInf();
        double r12 = r8[0];
        double r14 = r12 - r10;
        double r16 = r8[1] - r14;
        if (r10 < r3) goto L7;
        r2.add(Double.valueOf(r12));
        if (r16 > 6.283185307179586d) goto L16;
        r2.add(Double.valueOf(r8[1]));
        goto L4
    L16:
        double r11 = r14 + 6.283185307179586d;
        r2.add(Double.valueOf(r11));
        r1.add(Double.valueOf(r11));
        double r18 = r3 + 6.283185307179586d;
        if (r16 > r18) goto L18;
        r1.add(Double.valueOf(r8[1]));
        goto L4
    L18:
        double r19 = r18 + r14;
        r1.add(Double.valueOf(r19));
        r2.add(Double.valueOf(r19));
        r2.add(Double.valueOf(r8[1]));
        goto L4
    L7:
        r1.add(Double.valueOf(r12));
        if (r16 > r3) goto L9;
        r1.add(Double.valueOf(r8[1]));
        goto L4
    L9:
        double r13 = r3 + r14;
        r1.add(Double.valueOf(r13));
        r2.add(Double.valueOf(r13));
        if (r16 > 6.283185307179586d) goto L11;
        r2.add(Double.valueOf(r8[1]));
        goto L4
    L11:
        double r15 = r14 + 6.283185307179586d;
        r2.add(Double.valueOf(r15));
        r1.add(Double.valueOf(r15));
        r1.add(Double.valueOf(r8[1]));
        goto L4
    L22:
        return new Split(createSplitPart(r2), createSplitPart(r1), null);
    }

    private void addArcLimit(BSPTree<Sphere1D> r3, double r4, boolean r6) {
        LimitAngle r0 = new LimitAngle(new S1Point(r4), !r6, getTolerance());
        BSPTree<S> r2 = r3.getCell(r0.getLocation(), getTolerance());
        if (r2.getCut() != null) goto L7;
        r2.insertCut(r0);
        r2.setAttribute(null);
        r2.getPlus().setAttribute(Boolean.FALSE);
        r2.getMinus().setAttribute(Boolean.TRUE);
        return;
    L7:
        throw new MathInternalError();
    }

    private ArcsSet createSplitPart(List<Double> r10) {
        if (r10.isEmpty() == false) goto L5;
        return null;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r10.size()) goto L21;
        int r3 = (r2 + 1) % r10.size();
        double r5 = r10.get(r2).doubleValue();
        if (FastMath.abs(MathUtils.normalizeAngle(r10.get(r3).doubleValue(), r5) - r5) > getTolerance()) goto L20;
        if (r3 <= 0) goto L12;
        r10.remove(r3);
        r10.remove(r2);
        r2 = r2 - 1;
        goto L20
    L12:
        double r6 = r10.remove(r10.size() - 1).doubleValue();
        double r7 = r10.remove(0).doubleValue();
        if (r10.isEmpty() == true) goto L15;
        r10.add(Double.valueOf(r10.remove(0).doubleValue() + 6.283185307179586d));
        goto L20
    L15:
        if ((r6 - r7) > 3.141592653589793d) goto L17;
        return null;
    L17:
        return new ArcsSet(new BSPTree(Boolean.TRUE), getTolerance());
    L20:
        r2 = r2 + 1;
        goto L7
    L21:
        BSPTree<Sphere1D> r4 = new BSPTree(Boolean.FALSE);
        int r8 = 0;
    L23:
        if (r8 >= (r10.size() - 1)) goto L26;
        addArcLimit(r4, r10.get(r8).doubleValue(), true);
        addArcLimit(r4, r10.get(r8 + 1).doubleValue(), false);
        r8 = r8 + 2;
        goto L23
    L26:
        if (r4.getCut() != null) goto L29;
        return null;
    L29:
        return new ArcsSet(r4, getTolerance());
    }
}
