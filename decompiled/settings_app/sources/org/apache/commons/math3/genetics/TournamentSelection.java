package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class TournamentSelection implements SelectionPolicy {
    private int arity;

    public TournamentSelection(int r1) {
        this.arity = r1;
    }

    @Override // org.apache.commons.math3.genetics.SelectionPolicy
    public ChromosomePair select(Population r3) throws MathIllegalArgumentException {
        ListPopulation r4 = (ListPopulation) r3;
        return new ChromosomePair(tournament(r4), tournament(r4));
    }

    private Chromosome tournament(ListPopulation r5) throws MathIllegalArgumentException {
        int r2 = 0;
        if (r5.getPopulationSize() < this.arity) goto L11;
        final int r1 = this.arity;
        ListPopulation r0 = new AnonymousClass1(this, r1);
        ArrayList r3 = new ArrayList(r5.getChromosomes());
    L6:
        if (r2 >= this.arity) goto L9;
        int r6 = GeneticAlgorithm.getRandomGenerator().nextInt(r3.size());
        r0.addChromosome((Chromosome) r3.get(r6));
        r3.remove(r6);
        r2 = r2 + 1;
        goto L6
    L9:
        return r0.getFittestChromosome();
    L11:
        throw new MathIllegalArgumentException(LocalizedFormats.TOO_LARGE_TOURNAMENT_ARITY, new Object[]{Integer.valueOf(this.arity), Integer.valueOf(r5.getPopulationSize())});
    }

    public int getArity() {
        return this.arity;
    }

    public void setArity(int r1) {
        this.arity = r1;
    }
}
