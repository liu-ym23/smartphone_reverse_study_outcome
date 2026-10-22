package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class OrderedCrossover<T> implements CrossoverPolicy {
    public OrderedCrossover() {
    }

    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome r2, Chromosome r3) throws DimensionMismatchException, MathIllegalArgumentException {
        if ((r2 instanceof AbstractListChromosome) == false) goto L9;
        if ((r3 instanceof AbstractListChromosome) == false) goto L9;
        return mate((AbstractListChromosome) r2, (AbstractListChromosome) r3);
    L9:
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    protected ChromosomePair mate(AbstractListChromosome<T> r13, AbstractListChromosome<T> r14) throws DimensionMismatchException {
        int r12 = r13.getLength();
        if (r12 != r14.getLength()) goto L19;
        List<T> r0 = r13.getRepresentation();
        List<T> r1 = r14.getRepresentation();
        ArrayList r2 = new ArrayList(r12);
        ArrayList r3 = new ArrayList(r12);
        HashSet r4 = new HashSet(r12);
        HashSet r5 = new HashSet(r12);
        RandomGenerator r6 = GeneticAlgorithm.getRandomGenerator();
        int r7 = r6.nextInt(r12);
    L5:
        int r8 = r6.nextInt(r12);
        if (r7 == r8) goto L5;
        int r9 = FastMath.min(r7, r8);
        int r10 = FastMath.max(r7, r8);
        int r11 = r10 + 1;
        r2.addAll(r0.subList(r9, r11));
        r4.addAll(r2);
        r3.addAll(r1.subList(r9, r11));
        r5.addAll(r3);
        int r15 = 1;
    L8:
        if (r15 > r12) goto L16;
        int r16 = (r10 + r15) % r12;
        T r17 = r0.get(r16);
        T r18 = r1.get(r16);
        if (r4.contains(r18) == true) goto L13;
        r2.add(r18);
        r4.add(r18);
    L13:
        if (r5.contains(r17) == true) goto L15;
        r3.add(r17);
        r5.add(r17);
    L15:
        r15 = r15 + 1;
        goto L8
    L16:
        Collections.rotate(r2, r9);
        Collections.rotate(r3, r9);
        return new ChromosomePair(r13.newFixedLengthChromosome(r2), r14.newFixedLengthChromosome(r3));
    L19:
        throw new DimensionMismatchException(r14.getLength(), r12);
    }
}
