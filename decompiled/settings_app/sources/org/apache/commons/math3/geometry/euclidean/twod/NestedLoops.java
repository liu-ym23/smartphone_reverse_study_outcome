package org.apache.commons.math3.geometry.euclidean.twod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;

/* JADX INFO: loaded from: classes6.dex */
class NestedLoops {
    private Vector2D[] loop;
    private boolean originalIsClockwise;
    private Region<Euclidean2D> polygon;
    private List<NestedLoops> surrounded;
    private final double tolerance;

    NestedLoops(double r2) {
        this.surrounded = new ArrayList();
        this.tolerance = r2;
    }

    private NestedLoops(Vector2D[] r17, double r18) throws MathIllegalArgumentException {
        if (r17[0] == null) goto L14;
        this.loop = r17;
        this.surrounded = new ArrayList();
        this.tolerance = r18;
        ArrayList r12 = new ArrayList();
        Vector2D r2 = r17[r17.length - 1];
        int r14 = 0;
    L6:
        if (r14 >= r17.length) goto L8;
        Vector2D r15 = r17[r14];
        Line r7 = new Line(r2, r15, r18);
        r12.add(new SubLine(r7, new IntervalsSet(r7.toSubSpace(r2).getX(), r7.toSubSpace(r15).getX(), r18)));
        r14 = r14 + 1;
        r2 = r15;
        goto L6
    L8:
        PolygonsSet r1 = new PolygonsSet(r12, r18);
        this.polygon = r1;
        if (Double.isInfinite(r1.getSize()) == false) goto L11;
        this.polygon = new RegionFactory().getComplement(this.polygon);
        this.originalIsClockwise = false;
        return;
    L11:
        this.originalIsClockwise = true;
        return;
    L14:
        throw new MathIllegalArgumentException(LocalizedFormats.OUTLINE_BOUNDARY_LOOP_OPEN, new Object[0]);
    }

    public void add(Vector2D[] r4) throws MathIllegalArgumentException {
        add(new NestedLoops(r4, this.tolerance));
    }

    private void add(NestedLoops r5) throws MathIllegalArgumentException {
        Iterator<NestedLoops> r0 = this.surrounded.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        NestedLoops r1 = r0.next();
        if (r1.polygon.contains(r5.polygon) == false) goto L4;
        r1.add(r5);
        return;
    L9:
        Iterator<NestedLoops> r2 = this.surrounded.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        NestedLoops r3 = r2.next();
        if (r5.polygon.contains(r3.polygon) == false) goto L11;
        r5.surrounded.add(r3);
        r2.remove();
        goto L11
    L15:
        RegionFactory r4 = new RegionFactory();
        Iterator<NestedLoops> r6 = this.surrounded.iterator();
    L17:
        if (r6.hasNext() == false) goto L23;
        NestedLoops r7 = r6.next();
        if (r4.intersection(r5.polygon, r7.polygon).isEmpty() == true) goto L17;
        throw new MathIllegalArgumentException(LocalizedFormats.CROSSING_BOUNDARY_LOOPS, new Object[0]);
    L23:
        this.surrounded.add(r5);
    }

    public void correctOrientation() {
        Iterator<NestedLoops> r2 = this.surrounded.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().setClockWise(true);
        goto L4
    }

    private void setClockWise(boolean r7) {
        if ((this.originalIsClockwise ^ r7) == false) goto L8;
        int r0 = this.loop.length;
        int r2 = -1;
    L5:
        r2 = r2 + 1;
        r0 = r0 - 1;
        if (r2 >= r0) goto L8;
        Vector2D[] r3 = this.loop;
        Vector2D r4 = r3[r2];
        r3[r2] = r3[r0];
        r3[r0] = r4;
    L8:
        Iterator<NestedLoops> r6 = this.surrounded.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        r6.next().setClockWise(!r7);
        goto L10
    }
}
