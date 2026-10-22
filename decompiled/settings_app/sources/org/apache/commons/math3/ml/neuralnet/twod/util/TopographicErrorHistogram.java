package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class TopographicErrorHistogram implements MapDataVisualization {
    private final DistanceMeasure distance;
    private final boolean relativeCount;

    public TopographicErrorHistogram(boolean r1, DistanceMeasure r2) {
        this.relativeCount = r1;
        this.distance = r2;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapDataVisualization
    public double[][] computeImage(NeuronSquareMesh2D r19, Iterable<double[]> r20) {
        int r2 = r19.getNumberOfRows();
        int r3 = r19.getNumberOfColumns();
        Network r4 = r19.getNetwork();
        LocationFinder r5 = new LocationFinder(r19);
        int[][] r7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r2, r3});
        double[][] r6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r2, r3});
        Iterator<double[]> r10 = r20.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Pair<Neuron, Neuron> r11 = MapUtils.findBestAndSecondBest(r10.next(), r19, this.distance);
        Neuron r12 = r11.getFirst();
        LocationFinder.Location r13 = r5.getLocation(r12);
        int r14 = r13.getRow();
        int r15 = r13.getColumn();
        int[] r16 = r7[r14];
        r16[r15] = r16[r15] + 1;
        if (r4.getNeighbours(r12).contains(r11.getSecond()) == true) goto L4;
        double[] r17 = r6[r14];
        r17[r15] = r17[r15] + 1.0d;
        goto L4
    L9:
        if (this.relativeCount == false) goto L16;
        int r0 = 0;
    L11:
        if (r0 >= r2) goto L16;
        int r1 = 0;
    L13:
        if (r1 >= r3) goto L15;
        double[] r8 = r6[r0];
        r8[r1] = r8[r1] / ((double) r7[r0][r1]);
        r1 = r1 + 1;
        goto L13
    L15:
        r0 = r0 + 1;
    L16:
        return r6;
    }
}
