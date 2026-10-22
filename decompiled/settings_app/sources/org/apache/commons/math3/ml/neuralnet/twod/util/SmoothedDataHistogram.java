package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: loaded from: classes6.dex */
public class SmoothedDataHistogram implements MapDataVisualization {
    private final DistanceMeasure distance;
    private final double membershipNormalization;
    private final int smoothingBins;

    public SmoothedDataHistogram(int r5, DistanceMeasure r6) {
        this.smoothingBins = r5;
        this.distance = r6;
        double r0 = 0.0d;
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L5;
        r0 = r0 + ((double) (r5 - r7));
        r7 = r7 + 1;
        goto L3
    L5:
        this.membershipNormalization = 1.0d / r0;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapDataVisualization
    public double[][] computeImage(NeuronSquareMesh2D r14, Iterable<double[]> r15) {
        int r0 = r14.getNumberOfRows();
        int r1 = r14.getNumberOfColumns();
        int r2 = r0 * r1;
        if (r2 < this.smoothingBins) goto L13;
        LocationFinder r3 = new LocationFinder(r14);
        double[][] r4 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        Iterator<double[]> r16 = r15.iterator();
    L6:
        if (r16.hasNext() == false) goto L11;
        Neuron[] r5 = MapUtils.sort(r16.next(), r14.getNetwork(), this.distance);
        int r6 = 0;
    L9:
        if (r6 >= this.smoothingBins) goto L6;
        LocationFinder.Location r7 = r3.getLocation(r5[r6]);
        int r8 = r7.getRow();
        int r9 = r7.getColumn();
        double[] r10 = r4[r8];
        r10[r9] = r10[r9] + (((double) (this.smoothingBins - r6)) * this.membershipNormalization);
        r6 = r6 + 1;
        goto L9
    L11:
        return r4;
    L13:
        throw new NumberIsTooSmallException(Integer.valueOf(r2), Integer.valueOf(this.smoothingBins), true);
    }
}
