package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: loaded from: classes6.dex */
public class HitHistogram implements MapDataVisualization {
    private final DistanceMeasure distance;
    private final boolean normalizeCount;

    public HitHistogram(boolean r1, DistanceMeasure r2) {
        this.normalizeCount = r1;
        this.distance = r2;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapDataVisualization
    public double[][] computeImage(NeuronSquareMesh2D r13, Iterable<double[]> r14) {
        int r0 = r13.getNumberOfRows();
        int r1 = r13.getNumberOfColumns();
        LocationFinder r2 = new LocationFinder(r13);
        double[][] r3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        Iterator<double[]> r15 = r14.iterator();
        int r5 = 0;
    L4:
        if (r15.hasNext() == false) goto L7;
        LocationFinder.Location r6 = r2.getLocation(MapUtils.findBest(r15.next(), r13, this.distance));
        int r7 = r6.getRow();
        int r8 = r6.getColumn();
        double[] r9 = r3[r7];
        r9[r8] = r9[r8] + 1.0d;
        r5 = r5 + 1;
        goto L4
    L7:
        if (this.normalizeCount == false) goto L14;
        int r12 = 0;
    L9:
        if (r12 >= r0) goto L14;
        int r16 = 0;
    L11:
        if (r16 >= r1) goto L13;
        double[] r17 = r3[r12];
        r17[r16] = r17[r16] / ((double) r5);
        r16 = r16 + 1;
        goto L11
    L13:
        r12 = r12 + 1;
    L14:
        return r3;
    }
}
