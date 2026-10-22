package org.apache.commons.math3.ml.neuralnet.sofm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.math3.analysis.function.Gaussian;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.UpdateAction;

/* JADX INFO: loaded from: classes6.dex */
public class KohonenUpdateAction implements UpdateAction {
    private final DistanceMeasure distance;
    private final LearningFactorFunction learningFactor;
    private final NeighbourhoodSizeFunction neighbourhoodSize;
    private final AtomicLong numberOfCalls;

    public KohonenUpdateAction(DistanceMeasure r4, LearningFactorFunction r5, NeighbourhoodSizeFunction r6) {
        this.numberOfCalls = new AtomicLong(0);
        this.distance = r4;
        this.learningFactor = r5;
        this.neighbourhoodSize = r6;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.UpdateAction
    public void update(Network r11, double[] r12) {
        long r0 = this.numberOfCalls.incrementAndGet() - 1;
        double r4 = this.learningFactor.value(r0);
        Neuron r2 = findAndUpdateBestNeuron(r11, r12, r4);
        int r1 = this.neighbourhoodSize.value(r0);
        Gaussian r3 = new Gaussian(r4, 0.0d, r1);
        if (r1 <= 0) goto L11;
        Collection<Neuron> r5 = new HashSet();
        r5.add(r2);
        HashSet r6 = new HashSet();
        r6.add(r2);
        int r7 = 1;
    L5:
        r5 = r11.getNeighbours(r5, r6);
        Iterator<Neuron> r8 = r5.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        updateNeighbouringNeuron(r8.next(), r12, r3.value(r7));
        goto L7
    L9:
        r6.addAll(r5);
        r7 = r7 + 1;
        if (r7 <= r1) goto L5;
        return;
    }

    public long getNumberOfCalls() {
        return this.numberOfCalls.get();
    }

    private boolean attemptNeuronUpdate(Neuron r2, double[] r3, double r4) {
        double[] r0 = r2.getFeatures();
        return r2.compareAndSetFeatures(r0, computeFeatures(r0, r3, r4));
    }

    private void updateNeighbouringNeuron(Neuron r2, double[] r3, double r4) {
    L3:
        if (attemptNeuronUpdate(r2, r3, r4) == false) goto L3;
    }

    private Neuron findAndUpdateBestNeuron(Network r3, double[] r4, double r5) {
    L2:
        Neuron r0 = MapUtils.findBest(r4, r3, this.distance);
        if (attemptNeuronUpdate(r0, r4, r5) == false) goto L2;
        return r0;
    }

    private double[] computeFeatures(double[] r2, double[] r3, double r4) {
        ArrayRealVector r1 = new ArrayRealVector(r2, false);
        return new ArrayRealVector(r3, false).subtract(r1).mapMultiplyToSelf(r4).add(r1).toArray();
    }
}
