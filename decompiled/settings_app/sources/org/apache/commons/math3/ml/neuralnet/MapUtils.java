package org.apache.commons.math3.ml.neuralnet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public class MapUtils {

    private static class PairNeuronDouble {
        static final Comparator<PairNeuronDouble> COMPARATOR = null;
        private final Neuron neuron;
        private final double value;

        static /* synthetic */ double access$000(PairNeuronDouble r2) {
            return r2.value;
        }

        static {
            COMPARATOR = new AnonymousClass1();
        }

        PairNeuronDouble(Neuron r1, double r2) {
            this.neuron = r1;
            this.value = r2;
        }

        public Neuron getNeuron() {
            return this.neuron;
        }
    }

    private MapUtils() {
    }

    public static Neuron findBest(double[] r7, Iterable<Neuron> r8, DistanceMeasure r9) {
        Iterator<Neuron> r10 = r8.iterator();
        Neuron r0 = null;
        double r1 = Double.POSITIVE_INFINITY;
    L4:
        if (r10.hasNext() == false) goto L8;
        Neuron r3 = r10.next();
        double r4 = r9.compute(r3.getFeatures(), r7);
        if (r4 >= r1) goto L4;
        r0 = r3;
        r1 = r4;
        goto L4
    L8:
        return r0;
    }

    public static Pair<Neuron, Neuron> findBestAndSecondBest(double[] r10, Iterable<Neuron> r11, DistanceMeasure r12) {
        Neuron[] r1 = {null, null};
        double[] r0 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        Iterator<Neuron> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        Neuron r3 = r13.next();
        double r5 = r12.compute(r3.getFeatures(), r10);
        double r7 = r0[0];
        if (r5 < r7) goto L7;
        if (r5 >= r0[1]) goto L4;
        r0[1] = r5;
        r1[1] = r3;
        goto L4
    L7:
        r0[1] = r7;
        r1[1] = r1[0];
        r0[0] = r5;
        r1[0] = r3;
        goto L4
    L12:
        return new Pair(r1[0], r1[1]);
    }

    public static Neuron[] sort(double[] r5, Iterable<Neuron> r6, DistanceMeasure r7) {
        ArrayList r0 = new ArrayList();
        Iterator<Neuron> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Neuron r1 = r8.next();
        r0.add(new PairNeuronDouble(r1, r7.compute(r1.getFeatures(), r5)));
        goto L4
    L6:
        Collections.sort(r0, PairNeuronDouble.COMPARATOR);
        int r9 = r0.size();
        Neuron[] r10 = new Neuron[r9];
        int r11 = 0;
    L7:
        if (r11 >= r9) goto L9;
        r10[r11] = ((PairNeuronDouble) r0.get(r11)).getNeuron();
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    public static double[][] computeU(NeuronSquareMesh2D r14, DistanceMeasure r15) {
        int r0 = r14.getNumberOfRows();
        int r1 = r14.getNumberOfColumns();
        double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r1});
        Network r4 = r14.getNetwork();
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L12;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L11;
        Neuron r7 = r14.getNeuron(r5, r6);
        Collection<Neuron> r8 = r4.getNeighbours(r7);
        double[] r9 = r7.getFeatures();
        Iterator<Neuron> r10 = r8.iterator();
        double r11 = 0.0d;
        int r12 = 0;
    L8:
        if (r10.hasNext() == false) goto L10;
        r12 = r12 + 1;
        r11 = r11 + r15.compute(r9, r10.next().getFeatures());
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

    public static int[][] computeHitHistogram(Iterable<double[]> r7, NeuronSquareMesh2D r8, DistanceMeasure r9) {
        HashMap r0 = new HashMap();
        Network r1 = r8.getNetwork();
        Iterator<double[]> r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        Neuron r2 = findBest(r10.next(), r1, r9);
        Integer r4 = (Integer) r0.get(r2);
        if (r4 == null) goto L7;
        r0.put(r2, Integer.valueOf(r4.intValue() + 1));
        goto L4
    L7:
        r0.put(r2, 1);
        goto L4
    L9:
        int r11 = r8.getNumberOfRows();
        int r12 = r8.getNumberOfColumns();
        int[][] r3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r11, r12});
        int r5 = 0;
    L10:
        if (r5 >= r11) goto L19;
        int r6 = 0;
    L12:
        if (r6 >= r12) goto L18;
        Integer r13 = (Integer) r0.get(r8.getNeuron(r5, r6));
        if (r13 != null) goto L16;
        r3[r5][r6] = 0;
    L17:
        r6 = r6 + 1;
        goto L12
    L16:
        r3[r5][r6] = r13.intValue();
        goto L17
    L18:
        r5 = r5 + 1;
        goto L10
    L19:
        return r3;
    }

    public static double computeQuantizationError(Iterable<double[]> r5, Iterable<Neuron> r6, DistanceMeasure r7) {
        Iterator<double[]> r8 = r5.iterator();
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L6;
        double[] r3 = r8.next();
        r2 = r2 + 1;
        r0 = r0 + r7.compute(r3, findBest(r3, r6, r7).getFeatures());
        goto L4
    L6:
        if (r2 == 0) goto L10;
        return r0 / ((double) r2);
    L10:
        throw new NoDataException();
    }

    public static double computeTopographicError(Iterable<double[]> r4, Network r5, DistanceMeasure r6) {
        Iterator<double[]> r7 = r4.iterator();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L8;
        r0 = r0 + 1;
        Pair<Neuron, Neuron> r2 = findBestAndSecondBest(r7.next(), r5, r6);
        if (r5.getNeighbours(r2.getFirst()).contains(r2.getSecond()) == true) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        if (r0 == 0) goto L12;
        return ((double) r1) / ((double) r0);
    L12:
        throw new NoDataException();
    }
}
