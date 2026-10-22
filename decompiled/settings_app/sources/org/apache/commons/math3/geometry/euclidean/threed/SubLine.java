package org.apache.commons.math3.geometry.euclidean.threed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Region;

/* JADX INFO: loaded from: classes6.dex */
public class SubLine {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private final Line line;
    private final IntervalsSet remainingRegion;

    public SubLine(Line r1, IntervalsSet r2) {
        this.line = r1;
        this.remainingRegion = r2;
    }

    public SubLine(Vector3D r2, Vector3D r3, double r4) throws MathIllegalArgumentException {
        this(new Line(r2, r3, r4), buildIntervalSet(r2, r3, r4));
    }

    public SubLine(Vector3D r3, Vector3D r4) throws MathIllegalArgumentException {
        this(r3, r4, 1.0E-10d);
    }

    public SubLine(Segment r6) throws MathIllegalArgumentException {
        this(r6.getLine(), buildIntervalSet(r6.getStart(), r6.getEnd(), r6.getLine().getTolerance()));
    }

    public List<Segment> getSegments() {
        List<Interval> r0 = this.remainingRegion.asList();
        ArrayList r1 = new ArrayList(r0.size());
        Iterator<Interval> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Interval r3 = r2.next();
        r1.add(new Segment(this.line.toSpace(new Vector1D(r3.getInf())), this.line.toSpace(new Vector1D(r3.getSup())), this.line));
        goto L4
    L6:
        return r1;
    }

    public Vector3D intersection(SubLine r4, boolean r5) {
        Vector3D r0 = this.line.intersection(r4.line);
        if (r0 != null) goto L5;
        return null;
    L5:
        Region.Location r3 = this.remainingRegion.checkPoint(this.line.toSubSpace(r0));
        Region.Location r6 = r4.remainingRegion.checkPoint(r4.line.toSubSpace(r0));
        if (r5 == false) goto L15;
        if (r3 == Region.Location.OUTSIDE) goto L13;
        if (r6 == Region.Location.OUTSIDE) goto L13;
        return r0;
    L13:
        return null;
    L15:
        if (r3 != Region.Location.INSIDE) goto L20;
        if (r6 != Region.Location.INSIDE) goto L20;
        return r0;
    L20:
        return null;
    }

    private static IntervalsSet buildIntervalSet(Vector3D r9, Vector3D r10, double r11) throws MathIllegalArgumentException {
        Line r0 = new Line(r9, r10, r11);
        return new IntervalsSet(r0.toSubSpace(r9).getX(), r0.toSubSpace(r10).getX(), r11);
    }
}
