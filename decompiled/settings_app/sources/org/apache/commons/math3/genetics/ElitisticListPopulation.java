package org.apache.commons.math3.genetics;

import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ElitisticListPopulation extends ListPopulation {
    private double elitismRate;

    public ElitisticListPopulation(List<Chromosome> r1, int r2, double r3) throws NullArgumentException, NotPositiveException, NumberIsTooLargeException, OutOfRangeException {
        super(r1, r2);
        this.elitismRate = 0.9d;
        setElitismRate(r3);
    }

    public ElitisticListPopulation(int r3, double r4) throws NotPositiveException, OutOfRangeException {
        super(r3);
        this.elitismRate = 0.9d;
        setElitismRate(r4);
    }

    @Override // org.apache.commons.math3.genetics.Population
    public Population nextGeneration() {
        ElitisticListPopulation r0 = new ElitisticListPopulation(getPopulationLimit(), getElitismRate());
        List<Chromosome> r1 = getChromosomeList();
        Collections.sort(r1);
        int r6 = (int) FastMath.ceil((1.0d - getElitismRate()) * ((double) r1.size()));
    L4:
        if (r6 >= r1.size()) goto L6;
        r0.addChromosome(r1.get(r6));
        r6 = r6 + 1;
        goto L4
    L6:
        return r0;
    }

    public void setElitismRate(double r3) throws OutOfRangeException {
        if (r3 < 0.0d) goto L9;
        if (r3 > 1.0d) goto L9;
        this.elitismRate = r3;
        return;
    L9:
        throw new OutOfRangeException(LocalizedFormats.ELITISM_RATE, Double.valueOf(r3), 0, 1);
    }

    public double getElitismRate() {
        return this.elitismRate;
    }
}
