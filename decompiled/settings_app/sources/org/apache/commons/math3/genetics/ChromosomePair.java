package org.apache.commons.math3.genetics;

/* JADX INFO: loaded from: classes6.dex */
public class ChromosomePair {
    private final Chromosome first;
    private final Chromosome second;

    public ChromosomePair(Chromosome r1, Chromosome r2) {
        this.first = r1;
        this.second = r2;
    }

    public Chromosome getFirst() {
        return this.first;
    }

    public Chromosome getSecond() {
        return this.second;
    }

    public String toString() {
        return String.format("(%s,%s)", new Object[]{getFirst(), getSecond()});
    }
}
