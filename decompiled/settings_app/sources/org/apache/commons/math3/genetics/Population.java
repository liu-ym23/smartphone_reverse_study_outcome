package org.apache.commons.math3.genetics;

import org.apache.commons.math3.exception.NumberIsTooLargeException;

/* JADX INFO: loaded from: classes6.dex */
public interface Population extends Iterable<Chromosome> {
    void addChromosome(Chromosome r1) throws NumberIsTooLargeException;

    Chromosome getFittestChromosome();

    int getPopulationLimit();

    int getPopulationSize();

    Population nextGeneration();
}
