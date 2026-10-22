package org.apache.commons.math3.ml.neuralnet;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;

/* JADX INFO: loaded from: classes6.dex */
public class Network implements Iterable<Neuron>, Serializable {
    private static final long serialVersionUID = 20130207;
    private final int featureSize;
    private final ConcurrentHashMap<Long, Set<Long>> linkMap;
    private final ConcurrentHashMap<Long, Neuron> neuronMap;
    private final AtomicLong nextId;

    public static class NeuronIdentifierComparator implements Comparator<Neuron>, Serializable {
        private static final long serialVersionUID = 20130207;

        public NeuronIdentifierComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Neuron r1, Neuron r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Neuron r3, Neuron r4) {
            long r2 = r3.getIdentifier();
            long r0 = r4.getIdentifier();
            if (r2 >= r0) goto L5;
            return -1;
        L5:
            if (r2 <= r0) goto L7;
            return 1;
        L7:
            return 0;
        }
    }

    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130207;
        private final int featureSize;
        private final long[][] neighbourIdList;
        private final Neuron[] neuronList;
        private final long nextId;

        SerializationProxy(long r1, int r3, Neuron[] r4, long[][] r5) {
            this.nextId = r1;
            this.featureSize = r3;
            this.neuronList = r4;
            this.neighbourIdList = r5;
        }

        private Object readResolve() {
            return new Network(this.nextId, this.featureSize, this.neuronList, this.neighbourIdList);
        }
    }

    Network(long r10, int r12, Neuron[] r13, long[][] r14) {
        this.neuronMap = new ConcurrentHashMap();
        this.linkMap = new ConcurrentHashMap();
        int r0 = r13.length;
        if (r0 != r14.length) goto L24;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L11;
        Neuron r3 = r13[r2];
        long r4 = r3.getIdentifier();
        if (r4 >= r10) goto L10;
        this.neuronMap.put(Long.valueOf(r4), r3);
        this.linkMap.put(Long.valueOf(r4), new HashSet());
        r2 = r2 + 1;
        goto L5
    L10:
        throw new MathIllegalStateException();
    L11:
        int r5 = 0;
    L12:
        if (r5 >= r0) goto L21;
        Set<Long> r6 = this.linkMap.get(Long.valueOf(r13[r5].getIdentifier()));
        long[] r7 = r14[r5];
        int r8 = r7.length;
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L20;
        Long r11 = Long.valueOf(r7[r9]);
        if (this.neuronMap.get(r11) == null) goto L19;
        addLinkToLinkSet(r6, r11.longValue());
        r9 = r9 + 1;
        goto L14
    L19:
        throw new MathIllegalStateException();
    L20:
        r5 = r5 + 1;
        goto L12
    L21:
        this.nextId = new AtomicLong(r10);
        this.featureSize = r12;
        return;
    L24:
        throw new MathIllegalStateException();
    }

    public Network(long r2, int r4) {
        this.neuronMap = new ConcurrentHashMap();
        this.linkMap = new ConcurrentHashMap();
        this.nextId = new AtomicLong(r2);
        this.featureSize = r4;
    }

    public synchronized Network copy() {
        monitor-enter(this);
        Network r0 = new Network(this.nextId.get(), this.featureSize);     // Catch: Throwable -> L14
        Iterator<Map.Entry<Long, Neuron>> r1 = this.neuronMap.entrySet().iterator();     // Catch: Throwable -> L14
    L5:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<Long, Neuron> r2 = r1.next();     // Catch: Throwable -> L14
        r0.neuronMap.put(r2.getKey(), r2.getValue().copy());     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<Map.Entry<Long, Set<Long>>> r3 = this.linkMap.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r3.hasNext() == false) goto L12;
        Map.Entry<Long, Set<Long>> r4 = r3.next();     // Catch: Throwable -> L14
        r0.linkMap.put(r4.getKey(), new HashSet(r4.getValue()));     // Catch: Throwable -> L14
        goto L8
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Iterable
    public Iterator<Neuron> iterator() {
        return this.neuronMap.values().iterator();
    }

    public Collection<Neuron> getNeurons(Comparator<Neuron> r2) {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.neuronMap.values());
        Collections.sort(r0, r2);
        return r0;
    }

    public long createNeuron(double[] r6) {
        if (r6.length != this.featureSize) goto L7;
        long r0 = createNextId().longValue();
        this.neuronMap.put(Long.valueOf(r0), new Neuron(r0, r6));
        this.linkMap.put(Long.valueOf(r0), new HashSet());
        return r0;
    L7:
        throw new DimensionMismatchException(r6.length, this.featureSize);
    }

    public void deleteNeuron(Neuron r3) {
        Iterator<Neuron> r0 = getNeighbours(r3).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        deleteLink(r0.next(), r3);
        goto L4
    L6:
        this.neuronMap.remove(Long.valueOf(r3.getIdentifier()));
    }

    public int getFeaturesSize() {
        return this.featureSize;
    }

    public void addLink(Neuron r6, Neuron r7) {
        long r0 = r6.getIdentifier();
        long r2 = r7.getIdentifier();
        if (r6 != getNeuron(r0)) goto L11;
        if (r7 != getNeuron(r2)) goto L9;
        addLinkToLinkSet(this.linkMap.get(Long.valueOf(r0)), r2);
        return;
    L9:
        throw new NoSuchElementException(Long.toString(r2));
    L11:
        throw new NoSuchElementException(Long.toString(r0));
    }

    private void addLinkToLinkSet(Set<Long> r1, long r2) {
        r1.add(Long.valueOf(r2));
    }

    public void deleteLink(Neuron r6, Neuron r7) {
        long r0 = r6.getIdentifier();
        long r2 = r7.getIdentifier();
        if (r6 != getNeuron(r0)) goto L11;
        if (r7 != getNeuron(r2)) goto L9;
        deleteLinkFromLinkSet(this.linkMap.get(Long.valueOf(r0)), r2);
        return;
    L9:
        throw new NoSuchElementException(Long.toString(r2));
    L11:
        throw new NoSuchElementException(Long.toString(r0));
    }

    private void deleteLinkFromLinkSet(Set<Long> r1, long r2) {
        r1.remove(Long.valueOf(r2));
    }

    public Neuron getNeuron(long r2) {
        Neuron r1 = this.neuronMap.get(Long.valueOf(r2));
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NoSuchElementException(Long.toString(r2));
    }

    public Collection<Neuron> getNeighbours(Iterable<Neuron> r2) {
        return getNeighbours(r2, null);
    }

    public Collection<Neuron> getNeighbours(Iterable<Neuron> r6, Iterable<Neuron> r7) {
        HashSet r0 = new HashSet();
        Iterator<Neuron> r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Neuron r1 = r8.next();
        r0.addAll(this.linkMap.get(Long.valueOf(r1.getIdentifier())));
        goto L4
    L6:
        if (r7 == null) goto L11;
        Iterator<Neuron> r9 = r7.iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        r0.remove(Long.valueOf(r9.next().getIdentifier()));
    L11:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r0.iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        r10.add(getNeuron(((Long) r11.next()).longValue()));
        goto L13
    L15:
        return r10;
    }

    public Collection<Neuron> getNeighbours(Neuron r2) {
        return getNeighbours(r2, null);
    }

    public Collection<Neuron> getNeighbours(Neuron r4, Iterable<Neuron> r5) {
        Set<Long> r6 = this.linkMap.get(Long.valueOf(r4.getIdentifier()));
        if (r5 == null) goto L8;
        Iterator<Neuron> r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r6.remove(Long.valueOf(r7.next().getIdentifier()));
    L8:
        ArrayList r8 = new ArrayList();
        Iterator<Long> r9 = r6.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r8.add(getNeuron(r9.next().longValue()));
        goto L10
    L12:
        return r8;
    }

    private Long createNextId() {
        return Long.valueOf(this.nextId.getAndIncrement());
    }

    private void readObject(ObjectInputStream r1) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        Neuron[] r6 = (Neuron[]) this.neuronMap.values().toArray(new Neuron[0]);
        long[][] r7 = new long[r6.length][];
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L11;
        Collection<Neuron> r2 = getNeighbours(r6[r0]);
        long[] r3 = new long[r2.size()];
        Iterator<Neuron> r4 = r2.iterator();
        int r5 = 0;
    L7:
        if (r4.hasNext() == false) goto L9;
        r3[r5] = r4.next().getIdentifier();
        r5 = r5 + 1;
        goto L7
    L9:
        r7[r0] = r3;
        r0 = r0 + 1;
        goto L4
    L11:
        return new SerializationProxy(this.nextId.get(), this.featureSize, r6, r7);
    }
}
