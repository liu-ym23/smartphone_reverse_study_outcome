package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class CycleCrossover<T> implements CrossoverPolicy {
    private final boolean randomStart;

    public CycleCrossover() {
        this(false);
    }

    public CycleCrossover(boolean r1) {
        this.randomStart = r1;
    }

    public boolean isRandomStart() {
        return this.randomStart;
    }

    @Override // org.apache.commons.math3.genetics.CrossoverPolicy
    public ChromosomePair crossover(Chromosome r2, Chromosome r3) throws DimensionMismatchException, MathIllegalArgumentException {
        if ((r2 instanceof AbstractListChromosome) == false) goto L9;
        if ((r3 instanceof AbstractListChromosome) == false) goto L9;
        return mate((AbstractListChromosome) r2, (AbstractListChromosome) r3);
    L9:
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_FIXED_LENGTH_CHROMOSOME, new Object[0]);
    }

    protected ChromosomePair mate(AbstractListChromosome<T> r16, AbstractListChromosome<T> r17) throws DimensionMismatchException {
        int r0 = r16.getLength();
        if (r0 != r17.getLength()) goto L33;
        List<T> r1 = r16.getRepresentation();
        List<T> r2 = r17.getRepresentation();
        ArrayList r3 = new ArrayList(r17.getRepresentation());
        ArrayList r4 = new ArrayList(r16.getRepresentation());
        HashSet r5 = new HashSet(r0);
        ArrayList r6 = new ArrayList(r0);
        if (this.randomStart == false) goto L7;
        int r7 = GeneticAlgorithm.getRandomGenerator().nextInt(r0);
    L8:
        int r10 = 1;
    L10:
        if (r5.size() >= r0) goto L31;
        r6.add(Integer.valueOf(r7));
        int r8 = r1.indexOf(r2.get(r7));
    L13:
        if (r8 == ((Integer) r6.get(0)).intValue()) goto L15;
        r6.add(Integer.valueOf(r8));
        r8 = r1.indexOf(r2.get(r8));
        goto L13
    L15:
        int r9 = r10 + 1;
        if ((r10 % 2) == 0) goto L21;
        Iterator r11 = r6.iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        int r12 = ((Integer) r11.next()).intValue();
        Object r13 = r3.get(r12);
        r3.set(r12, r4.get(r12));
        r4.set(r12, r13);
    L21:
        r5.addAll(r6);
        int r14 = (((Integer) r6.get(0)).intValue() + 1) % r0;
    L23:
        if (r5.contains(Integer.valueOf(r14)) == false) goto L29;
        if (r5.size() >= r0) goto L29;
        r14 = r14 + 1;
        if (r14 < r0) goto L23;
        r14 = 0;
    L29:
        r6.clear();
        int r15 = r14;
        r10 = r9;
        r7 = r15;
        goto L10
    L31:
        return new ChromosomePair(r16.newFixedLengthChromosome(r3), r17.newFixedLengthChromosome(r4));
    L7:
        r7 = 0;
        goto L8
    L33:
        throw new DimensionMismatchException(r17.getLength(), r0);
    }
}
