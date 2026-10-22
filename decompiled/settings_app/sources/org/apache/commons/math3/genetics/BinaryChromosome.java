package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BinaryChromosome extends AbstractListChromosome<Integer> {
    public BinaryChromosome(List<Integer> r1) throws InvalidRepresentationException {
        super(r1);
    }

    public BinaryChromosome(Integer[] r1) throws InvalidRepresentationException {
        super(r1);
    }

    @Override // org.apache.commons.math3.genetics.AbstractListChromosome
    protected void checkValidity(List<Integer> r4) throws InvalidRepresentationException {
        Iterator<Integer> r3 = r4.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        int r5 = r3.next().intValue();
        if (r5 < 0) goto L10;
        if (r5 <= 1) goto L4;
    L10:
        throw new InvalidRepresentationException(LocalizedFormats.INVALID_BINARY_DIGIT, new Object[]{Integer.valueOf(r5)});
    }

    public static List<Integer> randomBinaryRepresentation(int r4) {
        ArrayList r0 = new ArrayList(r4);
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r0.add(Integer.valueOf(GeneticAlgorithm.getRandomGenerator().nextInt(2)));
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    @Override // org.apache.commons.math3.genetics.Chromosome
    protected boolean isSame(Chromosome r5) {
        if ((r5 instanceof BinaryChromosome) == true) goto L5;
        return false;
    L5:
        BinaryChromosome r6 = (BinaryChromosome) r5;
        if (getLength() == r6.getLength()) goto L8;
        return false;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= getRepresentation().size()) goto L15;
        if (getRepresentation().get(r0).equals(r6.getRepresentation().get(r0)) == false) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }
}
