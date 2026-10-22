package org.apache.commons.math3.genetics;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class GeneticAlgorithm {
    private static RandomGenerator randomGenerator;
    private final CrossoverPolicy crossoverPolicy;
    private final double crossoverRate;
    private int generationsEvolved;
    private final MutationPolicy mutationPolicy;
    private final double mutationRate;
    private final SelectionPolicy selectionPolicy;

    static {
        randomGenerator = new JDKRandomGenerator();
    }

    public GeneticAlgorithm(CrossoverPolicy r8, double r9, MutationPolicy r11, double r12, SelectionPolicy r14) throws OutOfRangeException {
        this.generationsEvolved = 0;
        if (r9 < 0.0d) goto L15;
        if (r9 > 1.0d) goto L15;
        if (r12 < 0.0d) goto L13;
        if (r12 > 1.0d) goto L13;
        this.crossoverPolicy = r8;
        this.crossoverRate = r9;
        this.mutationPolicy = r11;
        this.mutationRate = r12;
        this.selectionPolicy = r14;
        return;
    L13:
        throw new OutOfRangeException(LocalizedFormats.MUTATION_RATE, Double.valueOf(r12), 0, 1);
    L15:
        throw new OutOfRangeException(LocalizedFormats.CROSSOVER_RATE, Double.valueOf(r9), 0, 1);
    }

    public static synchronized void setRandomGenerator(RandomGenerator r1) {
        monitor-enter(GeneticAlgorithm.class);
        randomGenerator = r1;     // Catch: Throwable -> L7
        monitor-exit(GeneticAlgorithm.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized RandomGenerator getRandomGenerator() {
        monitor-enter(GeneticAlgorithm.class);
        RandomGenerator r1 = randomGenerator;     // Catch: Throwable -> L7
        monitor-exit(GeneticAlgorithm.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Population evolve(Population r2, StoppingCondition r3) {
        this.generationsEvolved = 0;
    L4:
        if (r3.isSatisfied(r2) == true) goto L6;
        r2 = nextGeneration(r2);
        this.generationsEvolved++;
        goto L4
    L6:
        return r2;
    }

    public Population nextGeneration(Population r8) {
        Population r0 = r8.nextGeneration();
        RandomGenerator r1 = getRandomGenerator();
    L4:
        if (r0.getPopulationSize() >= r0.getPopulationLimit()) goto L14;
        ChromosomePair r2 = getSelectionPolicy().select(r8);
        if (r1.nextDouble() >= getCrossoverRate()) goto L9;
        r2 = getCrossoverPolicy().crossover(r2.getFirst(), r2.getSecond());
    L9:
        if (r1.nextDouble() >= getMutationRate()) goto L11;
        r2 = new ChromosomePair(getMutationPolicy().mutate(r2.getFirst()), getMutationPolicy().mutate(r2.getSecond()));
    L11:
        r0.addChromosome(r2.getFirst());
        if (r0.getPopulationSize() >= r0.getPopulationLimit()) goto L4;
        r0.addChromosome(r2.getSecond());
        goto L4
    L14:
        return r0;
    }

    public CrossoverPolicy getCrossoverPolicy() {
        return this.crossoverPolicy;
    }

    public double getCrossoverRate() {
        return this.crossoverRate;
    }

    public MutationPolicy getMutationPolicy() {
        return this.mutationPolicy;
    }

    public double getMutationRate() {
        return this.mutationRate;
    }

    public SelectionPolicy getSelectionPolicy() {
        return this.selectionPolicy;
    }

    public int getGenerationsEvolved() {
        return this.generationsEvolved;
    }
}
