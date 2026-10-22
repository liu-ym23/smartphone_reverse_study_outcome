package org.apache.commons.math3.genetics;

import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public interface CrossoverPolicy {
    ChromosomePair crossover(Chromosome r1, Chromosome r2) throws MathIllegalArgumentException;
}
