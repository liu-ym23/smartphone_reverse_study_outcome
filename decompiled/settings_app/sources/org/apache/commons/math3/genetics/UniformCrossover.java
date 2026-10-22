package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class UniformCrossover<T> implements CrossoverPolicy {
    private final double ratio;

    public UniformCrossover(double r6) throws OutOfRangeException {
        if (r6 < 0.0d) goto L9;
        if (r6 > 1.0d) goto L9;
        this.ratio = r6;
        return;
    L9:
        throw new OutOfRangeException(LocalizedFormats.CROSSOVER_RATE, Double.valueOf(r6), Double.valueOf(0.0d), Double.valueOf(1.0d));
    }

    public double getRatio() {
        return this.ratio;
    }

    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome r2, Chromosome r3) throws DimensionMismatchException, MathIllegalArgumentException {
        if ((r2 instanceof AbstractListChromosome) == false) goto L9;
        if ((r3 instanceof AbstractListChromosome) == false) goto L9;
        return mate((AbstractListChromosome) r2, (AbstractListChromosome) r3);
    L9:
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    private ChromosomePair mate(AbstractListChromosome<T> r12, AbstractListChromosome<T> r13) throws DimensionMismatchException {
        int r0 = r12.getLength();
        if (r0 != r13.getLength()) goto L14;
        List<T> r1 = r12.getRepresentation();
        List<T> r2 = r13.getRepresentation();
        ArrayList r3 = new ArrayList(r0);
        List<T> r4 = new ArrayList(r0);
        RandomGenerator r5 = GeneticAlgorithm.getRandomGenerator();
        int r6 = 0;
    L5:
        if (r6 >= r0) goto L12;
        if (r5.nextDouble() >= this.ratio) goto L9;
        r3.add(r2.get(r6));
        r4.add(r1.get(r6));
    L10:
        r6 = r6 + 1;
        goto L5
    L9:
        r3.add(r1.get(r6));
        r4.add(r2.get(r6));
        goto L10
    L12:
        return new ChromosomePair(r12.newFixedLengthChromosome(r3), r13.newFixedLengthChromosome(r4));
    L14:
        throw new DimensionMismatchException(r13.getLength(), r0);
    }
}
