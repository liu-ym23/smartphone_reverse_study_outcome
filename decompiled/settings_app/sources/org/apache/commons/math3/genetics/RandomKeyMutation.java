package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class RandomKeyMutation implements MutationPolicy {
    public RandomKeyMutation() {
    }

    @Override // org.apache.commons.math3.genetics.MutationPolicy
    public Chromosome mutate(Chromosome r5) throws MathIllegalArgumentException {
        if ((r5 instanceof RandomKey) == false) goto L7;
        RandomKey r6 = (RandomKey) r5;
        List<Double> r4 = r6.getRepresentation();
        int r0 = GeneticAlgorithm.getRandomGenerator().nextInt(r4.size());
        ArrayList r1 = new ArrayList(r4);
        r1.set(r0, Double.valueOf(GeneticAlgorithm.getRandomGenerator().nextDouble()));
        return r6.newFixedLengthChromosome(r1);
    L7:
        throw new MathIllegalArgumentException(LocalizedFormats.RANDOMKEY_MUTATION_WRONG_CLASS, new Object[]{r5.getClass().getSimpleName()});
    }
}
