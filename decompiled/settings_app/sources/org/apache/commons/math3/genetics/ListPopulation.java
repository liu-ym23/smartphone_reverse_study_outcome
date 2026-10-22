package org.apache.commons.math3.genetics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ListPopulation implements Population {
    private List<Chromosome> chromosomes;
    private int populationLimit;

    public ListPopulation(int r2) throws NotPositiveException {
        this(Collections.emptyList(), r2);
    }

    public ListPopulation(List<Chromosome> r3, int r4) throws NullArgumentException, NotPositiveException, NumberIsTooLargeException {
        if (r3 == null) goto L14;
        if (r4 <= 0) goto L12;
        if (r3.size() > r4) goto L10;
        this.populationLimit = r4;
        ArrayList r0 = new ArrayList(r4);
        this.chromosomes = r0;
        r0.addAll(r3);
        return;
    L10:
        throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(r3.size()), Integer.valueOf(r4), false);
    L12:
        throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, Integer.valueOf(r4));
    L14:
        throw new NullArgumentException();
    }

    @Deprecated
    public void setChromosomes(List<Chromosome> r4) throws NullArgumentException, NumberIsTooLargeException {
        if (r4 == null) goto L10;
        if (r4.size() > this.populationLimit) goto L8;
        this.chromosomes.clear();
        this.chromosomes.addAll(r4);
        return;
    L8:
        throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(r4.size()), Integer.valueOf(this.populationLimit), false);
    L10:
        throw new NullArgumentException();
    }

    public void addChromosomes(Collection<Chromosome> r4) throws NumberIsTooLargeException {
        if ((this.chromosomes.size() + r4.size()) > this.populationLimit) goto L7;
        this.chromosomes.addAll(r4);
        return;
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(this.chromosomes.size()), Integer.valueOf(this.populationLimit), false);
    }

    public List<Chromosome> getChromosomes() {
        return Collections.unmodifiableList(this.chromosomes);
    }

    protected List<Chromosome> getChromosomeList() {
        return this.chromosomes;
    }

    @Override // org.apache.commons.math3.genetics.Population
    public void addChromosome(Chromosome r4) throws NumberIsTooLargeException {
        if (this.chromosomes.size() >= this.populationLimit) goto L7;
        this.chromosomes.add(r4);
        return;
    L7:
        throw new NumberIsTooLargeException(LocalizedFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, Integer.valueOf(this.chromosomes.size()), Integer.valueOf(this.populationLimit), false);
    }

    @Override // org.apache.commons.math3.genetics.Population
    public Chromosome getFittestChromosome() {
        Chromosome r0 = this.chromosomes.get(0);
        Iterator<Chromosome> r3 = this.chromosomes.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Chromosome r1 = r3.next();
        if (r1.compareTo2(r0) <= 0) goto L4;
        r0 = r1;
        goto L4
    L8:
        return r0;
    }

    @Override // org.apache.commons.math3.genetics.Population
    public int getPopulationLimit() {
        return this.populationLimit;
    }

    public void setPopulationLimit(int r3) throws NotPositiveException, NumberIsTooSmallException {
        if (r3 <= 0) goto L10;
        if (r3 < this.chromosomes.size()) goto L8;
        this.populationLimit = r3;
        return;
    L8:
        throw new NumberIsTooSmallException(Integer.valueOf(r3), Integer.valueOf(this.chromosomes.size()), true);
    L10:
        throw new NotPositiveException(LocalizedFormats.POPULATION_LIMIT_NOT_POSITIVE, Integer.valueOf(r3));
    }

    @Override // org.apache.commons.math3.genetics.Population
    public int getPopulationSize() {
        return this.chromosomes.size();
    }

    public String toString() {
        return this.chromosomes.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<Chromosome> iterator() {
        return getChromosomes().iterator();
    }
}
