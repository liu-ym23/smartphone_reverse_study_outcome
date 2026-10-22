package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class OnePointCrossover<T> implements CrossoverPolicy {
    public OnePointCrossover() {
    }

    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome r2, Chromosome r3) throws DimensionMismatchException, MathIllegalArgumentException {
        if ((r2 instanceof AbstractListChromosome) == false) goto L9;
        if ((r3 instanceof AbstractListChromosome) == false) goto L9;
        return crossover((AbstractListChromosome) r2, (AbstractListChromosome) r3);
    L9:
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    private ChromosomePair crossover(AbstractListChromosome<T> r8, AbstractListChromosome<T> r9) throws DimensionMismatchException {
        int r7 = r8.getLength();
        if (r7 != r9.getLength()) goto L12;
        List<T> r0 = r8.getRepresentation();
        List<T> r1 = r9.getRepresentation();
        ArrayList r2 = new ArrayList(r7);
        List<T> r3 = new ArrayList(r7);
        int r4 = GeneticAlgorithm.getRandomGenerator().nextInt(r7 - 2) + 1;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L7;
        r2.add(r0.get(r5));
        r3.add(r1.get(r5));
        r5 = r5 + 1;
    L7:
        if (r4 >= r7) goto L10;
        r2.add(r1.get(r4));
        r3.add(r0.get(r4));
        r4 = r4 + 1;
        goto L7
    L10:
        return new ChromosomePair(r8.newFixedLengthChromosome(r2), r9.newFixedLengthChromosome(r3));
    L12:
        throw new DimensionMismatchException(r9.getLength(), r7);
    }
}
