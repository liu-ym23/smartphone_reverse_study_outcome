package org.apache.commons.math3.genetics;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Chromosome implements Comparable<Chromosome>, Fitness {
    private static final double NO_FITNESS = Double.NEGATIVE_INFINITY;
    private double fitness;

    protected boolean isSame(Chromosome r1) {
        return false;
    }

    public Chromosome() {
        this.fitness = Double.NEGATIVE_INFINITY;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Chromosome r1) {
        return compareTo2(r1);
    }

    public double getFitness() {
        if (this.fitness != Double.NEGATIVE_INFINITY) goto L6;
        this.fitness = fitness();
    L6:
        return this.fitness;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Chromosome r3) {
        return Double.compare(getFitness(), r3.getFitness());
    }

    protected Chromosome findSameChromosome(Population r3) {
        Iterator<Chromosome> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Chromosome r0 = r4.next();
        if (isSame(r0) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    public void searchForFitnessUpdate(Population r3) {
        Chromosome r4 = findSameChromosome(r3);
        if (r4 == null) goto L6;
        this.fitness = r4.getFitness();
        return;
    }
}
