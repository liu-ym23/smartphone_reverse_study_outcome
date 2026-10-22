package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class BinaryMutation implements MutationPolicy {
    public BinaryMutation() {
    }

    @Override // org.apache.commons.math3.genetics.MutationPolicy
    public Chromosome mutate(Chromosome r4) throws MathIllegalArgumentException {
        int r0 = 0;
        if ((r4 instanceof BinaryChromosome) == false) goto L10;
        BinaryChromosome r5 = (BinaryChromosome) r4;
        ArrayList r3 = new ArrayList(r5.getRepresentation());
        int r1 = GeneticAlgorithm.getRandomGenerator().nextInt(r5.getLength());
        if (r5.getRepresentation().get(r1).intValue() != 0) goto L7;
        r0 = 1;
    L7:
        r3.set(r1, Integer.valueOf(r0));
        return r5.newFixedLengthChromosome(r3);
    L10:
        throw new MathIllegalArgumentException(LocalizedFormats.INVALID_BINARY_CHROMOSOME, new Object[0]);
    }
}
