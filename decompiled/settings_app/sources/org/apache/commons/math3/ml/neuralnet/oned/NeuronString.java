package org.apache.commons.math3.ml.neuralnet.oned;

import java.io.ObjectInputStream;
import java.io.Serializable;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.ml.neuralnet.FeatureInitializer;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;

/* JADX INFO: loaded from: classes6.dex */
public class NeuronString implements Serializable {
    private static final long serialVersionUID = 1;
    private final long[] identifiers;
    private final Network network;
    private final int size;
    private final boolean wrap;

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130226;
        private final double[][] featuresList;
        private final boolean wrap;

        SerializationProxy(boolean r1, double[][] r2) {
            this.wrap = r1;
            this.featuresList = r2;
        }

        private Object readResolve() {
            return new NeuronString(this.wrap, this.featuresList);
        }
    }

    NeuronString(boolean r6, double[][] r7) {
        int r0 = r7.length;
        this.size = r0;
        if (r0 < 2) goto L11;
        this.wrap = r6;
        int r8 = 0;
        this.network = new Network(0, r7[0].length);
        this.identifiers = new long[r0];
    L6:
        if (r8 >= this.size) goto L8;
        this.identifiers[r8] = this.network.createNeuron(r7[r8]);
        r8 = r8 + 1;
        goto L6
    L8:
        createLinks();
        return;
    L11:
        throw new NumberIsTooSmallException(Integer.valueOf(r0), 2, true);
    }

    public NeuronString(int r7, boolean r8, FeatureInitializer[] r9) {
        if (r7 < 2) goto L13;
        this.size = r7;
        this.wrap = r8;
        this.identifiers = new long[r7];
        int r10 = r9.length;
        this.network = new Network(0, r10);
        int r1 = 0;
    L5:
        if (r1 >= r7) goto L10;
        double[] r2 = new double[r10];
        int r3 = 0;
    L7:
        if (r3 >= r10) goto L9;
        r2[r3] = r9[r3].value();
        r3 = r3 + 1;
        goto L7
    L9:
        this.identifiers[r1] = this.network.createNeuron(r2);
        r1 = r1 + 1;
        goto L5
    L10:
        createLinks();
        return;
    L13:
        throw new NumberIsTooSmallException(Integer.valueOf(r7), 2, true);
    }

    public Network getNetwork() {
        return this.network;
    }

    public int getSize() {
        return this.size;
    }

    public double[] getFeatures(int r3) {
        if (r3 < 0) goto L8;
        if (r3 >= this.size) goto L8;
        return this.network.getNeuron(this.identifiers[r3]).getFeatures();
    L8:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(this.size - 1));
    }

    private void createLinks() {
        int r0 = 0;
    L3:
        int r1 = this.size;
        if (r0 >= (r1 - 1)) goto L6;
        Network r2 = this.network;
        Neuron r3 = r2.getNeuron(r0);
        r0 = r0 + 1;
        r2.addLink(r3, this.network.getNeuron(r0));
        goto L3
    L6:
        int r4 = r1 - 1;
    L7:
        if (r4 <= 0) goto L10;
        Network r5 = this.network;
        r5.addLink(r5.getNeuron(r4), this.network.getNeuron(r4 - 1));
        r4 = r4 - 1;
        goto L7
    L10:
        if (this.wrap == false) goto L15;
        Network r6 = this.network;
        r6.addLink(r6.getNeuron(0), this.network.getNeuron(this.size - 1));
        Network r7 = this.network;
        r7.addLink(r7.getNeuron(this.size - 1), this.network.getNeuron(0));
        return;
    }

    private void readObject(ObjectInputStream r1) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        double[][] r0 = new double[this.size][];
        int r1 = 0;
    L4:
        if (r1 >= this.size) goto L7;
        r0[r1] = getFeatures(r1);
        r1 = r1 + 1;
        goto L4
    L7:
        return new SerializationProxy(this.wrap, r0);
    }
}
