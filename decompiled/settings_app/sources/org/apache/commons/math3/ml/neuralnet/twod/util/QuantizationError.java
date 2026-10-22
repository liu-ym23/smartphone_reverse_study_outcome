package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: loaded from: classes6.dex */
public class QuantizationError implements MapDataVisualization {
    private final DistanceMeasure distance;

    public QuantizationError(DistanceMeasure r1) {
        this.distance = r1;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapDataVisualization
    public double[][] computeImage(NeuronSquareMesh2D r17, Iterable<double[]> r18) {
        int r2 = r17.getNumberOfRows();
        int r3 = r17.getNumberOfColumns();
        LocationFinder r4 = new LocationFinder(r17);
        int r7 = 1;
        int[][] r6 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r2, r3});
        double[][] r5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, r3});
        Iterator<double[]> r9 = r18.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        double[] r10 = r9.next();
        Neuron r11 = MapUtils.findBest(r10, r17, this.distance);
        LocationFinder.Location r12 = r4.getLocation(r11);
        int r13 = r12.getRow();
        int r14 = r12.getColumn();
        int[] r15 = r6[r13];
        r15[r14] = r15[r14] + r7;
        double[] r16 = r5[r13];
        r16[r14] = r16[r14] + this.distance.compute(r10, r11.getFeatures());
        r7 = 1;
        goto L4
    L6:
        int r0 = 0;
    L7:
        if (r0 >= r2) goto L15;
        int r1 = 0;
    L9:
        if (r1 >= r3) goto L14;
        int r8 = r6[r0][r1];
        if (r8 == 0) goto L13;
        double[] r19 = r5[r0];
        r19[r1] = r19[r1] / ((double) r8);
    L13:
        r1 = r1 + 1;
        goto L9
    L14:
        r0 = r0 + 1;
        goto L7
    L15:
        return r5;
    }
}
