package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: loaded from: classes6.dex */
public class UnifiedDistanceMatrix implements MapVisualization {
    private final DistanceMeasure distance;
    private final boolean individualDistances;

    public UnifiedDistanceMatrix(boolean r1, DistanceMeasure r2) {
        this.individualDistances = r1;
        this.distance = r2;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapVisualization
    public double[][] computeImage(NeuronSquareMesh2D r2) {
        if (this.individualDistances == false) goto L7;
        return individualDistances(r2);
    L7:
        return averageDistances(r2);
    }

    private double[][] individualDistances(NeuronSquareMesh2D r20) {
        int r2 = r20.getNumberOfRows();
        int r3 = r20.getNumberOfColumns();
        double[][] r4 = (double[][]) Array.newInstance(Double.TYPE, new int[]{(r2 * 2) + 1, (r3 * 2) + 1});
        int r7 = 0;
    L3:
        if (r7 >= r2) goto L14;
        int r8 = (r7 * 2) + 1;
        int r9 = 0;
    L5:
        if (r9 >= r3) goto L13;
        int r10 = (r9 * 2) + 1;
        double[] r11 = r20.getNeuron(r7, r9).getFeatures();
        Neuron r12 = r20.getNeuron(r7, r9, NeuronSquareMesh2D.HorizontalDirection.RIGHT, NeuronSquareMesh2D.VerticalDirection.CENTER);
        if (r12 == null) goto L9;
        r4[r8][r10 + 1] = this.distance.compute(r11, r12.getFeatures());
    L9:
        Neuron r13 = r20.getNeuron(r7, r9, NeuronSquareMesh2D.HorizontalDirection.CENTER, NeuronSquareMesh2D.VerticalDirection.DOWN);
        if (r13 == null) goto L12;
        r4[r8 + 1][r10] = this.distance.compute(r11, r13.getFeatures());
    L12:
        r9 = r9 + 1;
        goto L5
    L13:
        r7 = r7 + 1;
        goto L3
    L14:
        int r14 = 0;
    L15:
        if (r14 >= r2) goto L29;
        int r15 = (r14 * 2) + 1;
        int r16 = 0;
    L17:
        if (r16 >= r3) goto L28;
        int r17 = (r16 * 2) + 1;
        Neuron r18 = r20.getNeuron(r14, r16);
        Neuron r19 = r20.getNeuron(r14, r16, NeuronSquareMesh2D.HorizontalDirection.RIGHT, NeuronSquareMesh2D.VerticalDirection.CENTER);
        Neuron r110 = r20.getNeuron(r14, r16, NeuronSquareMesh2D.HorizontalDirection.CENTER, NeuronSquareMesh2D.VerticalDirection.DOWN);
        Neuron r111 = r20.getNeuron(r14, r16, NeuronSquareMesh2D.HorizontalDirection.RIGHT, NeuronSquareMesh2D.VerticalDirection.DOWN);
        if (r111 != null) goto L21;
        double r112 = 0.0d;
    L22:
        if (r19 == null) goto L26;
        if (r110 == null) goto L26;
        double r113 = this.distance.compute(r19.getFeatures(), r110.getFeatures());
    L27:
        r4[r15 + 1][r17 + 1] = (r112 + r113) * 0.5d;
        r16 = r16 + 1;
    L26:
        r113 = 0.0d;
        goto L27
    L21:
        r112 = this.distance.compute(r18.getFeatures(), r111.getFeatures());
        goto L22
    L28:
        r14 = r14 + 1;
        goto L15
    L29:
        int r0 = r4.length - 1;
        double[] r1 = r4[r0];
        r4[0] = r1;
        int r5 = r1.length - 1;
        int r6 = 0;
    L30:
        if (r6 >= r0) goto L32;
        double[] r21 = r4[r6];
        r21[0] = r21[r5];
        r6 = r6 + 1;
        goto L30
    L32:
        return r4;
    }

    private double[][] averageDistances(NeuronSquareMesh2D r15) {
        int r0 = r15.getNumberOfRows();
        int r1 = r15.getNumberOfColumns();
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        Network r4 = r15.getNetwork();
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L12;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L11;
        Neuron r7 = r15.getNeuron(r5, r6);
        Collection<Neuron> r8 = r4.getNeighbours(r7);
        double[] r9 = r7.getFeatures();
        Iterator<Neuron> r10 = r8.iterator();
        double r11 = 0.0d;
        int r12 = 0;
    L8:
        if (r10.hasNext() == false) goto L10;
        r12 = r12 + 1;
        r11 = r11 + this.distance.compute(r9, r10.next().getFeatures());
        goto L8
    L10:
        r2[r5][r6] = r11 / ((double) r12);
        r6 = r6 + 1;
        goto L5
    L11:
        r5 = r5 + 1;
        goto L3
    L12:
        return r2;
    }
}
