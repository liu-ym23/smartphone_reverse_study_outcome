package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class NPointCrossover<T> implements CrossoverPolicy {
    private final int crossoverPoints;

    public NPointCrossover(int r1) throws NotStrictlyPositiveException {
        if (r1 <= 0) goto L7;
        this.crossoverPoints = r1;
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r1));
    }

    public int getCrossoverPoints() {
        return this.crossoverPoints;
    }

    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome r2, Chromosome r3) throws DimensionMismatchException, MathIllegalArgumentException {
        if ((r2 instanceof AbstractListChromosome) == false) goto L9;
        if ((r3 instanceof AbstractListChromosome) == false) goto L9;
        return mate((AbstractListChromosome) r2, (AbstractListChromosome) r3);
    L9:
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    private ChromosomePair mate(AbstractListChromosome<T> r16, AbstractListChromosome<T> r17) throws DimensionMismatchException, NumberIsTooLargeException {
        int r1 = r16.getLength();
        if (r1 != r17.getLength()) goto L20;
        int r3 = 0;
        if (this.crossoverPoints >= r1) goto L18;
        List<T> r2 = r16.getRepresentation();
        List<T> r4 = r17.getRepresentation();
        ArrayList r5 = new ArrayList(r1);
        ArrayList r6 = new ArrayList(r1);
        RandomGenerator r7 = GeneticAlgorithm.getRandomGenerator();
        ArrayList r10 = r5;
        ArrayList r11 = r6;
        int r9 = this.crossoverPoints;
        int r8 = 0;
    L8:
        if (r3 >= this.crossoverPoints) goto L13;
        int r12 = (r8 + 1) + r7.nextInt((r1 - r8) - r9);
    L10:
        if (r8 >= r12) goto L12;
        r10.add(r2.get(r8));
        r11.add(r4.get(r8));
        r8 = r8 + 1;
        goto L10
    L12:
        r3 = r3 + 1;
        r9 = r9 - 1;
        r8 = r12;
        ArrayList r14 = r11;
        r11 = r10;
        r10 = r14;
    L13:
        if (r8 >= r1) goto L16;
        r10.add(r2.get(r8));
        r11.add(r4.get(r8));
        r8 = r8 + 1;
        goto L13
    L16:
        return new ChromosomePair(r16.newFixedLengthChromosome(r5), r17.newFixedLengthChromosome(r6));
    L18:
        throw new NumberIsTooLargeException(Integer.valueOf(this.crossoverPoints), Integer.valueOf(r1), false);
    L20:
        throw new DimensionMismatchException(r17.getLength(), r1);
    }
}
