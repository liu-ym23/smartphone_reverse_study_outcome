package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractListChromosome<T> extends Chromosome {
    private final List<T> representation;

    protected abstract void checkValidity(List<T> r1) throws InvalidRepresentationException;

    public abstract AbstractListChromosome<T> newFixedLengthChromosome(List<T> r1);

    public AbstractListChromosome(List<T> r2) throws InvalidRepresentationException {
        this(r2, true);
    }

    public AbstractListChromosome(T[] r1) throws InvalidRepresentationException {
        this(Arrays.asList(r1));
    }

    public AbstractListChromosome(List<T> r1, boolean r2) {
        checkValidity(r1);
        if (r2 == false) goto L5;
        r1 = new ArrayList(r1);
    L5:
        this.representation = Collections.unmodifiableList(r1);
    }

    protected List<T> getRepresentation() {
        return this.representation;
    }

    public int getLength() {
        return getRepresentation().size();
    }

    public String toString() {
        return String.format("(f=%s %s)", new Object[]{Double.valueOf(getFitness()), getRepresentation()});
    }
}
