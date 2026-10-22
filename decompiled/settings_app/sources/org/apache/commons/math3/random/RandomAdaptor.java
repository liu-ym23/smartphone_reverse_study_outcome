package org.apache.commons.math3.random;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class RandomAdaptor extends Random implements RandomGenerator {
    private static final long serialVersionUID = 2306581345647615033L;
    private final RandomGenerator randomGenerator;

    private RandomAdaptor() {
        this.randomGenerator = null;
    }

    public RandomAdaptor(RandomGenerator r1) {
        this.randomGenerator = r1;
    }

    public static Random createAdaptor(RandomGenerator r1) {
        return new RandomAdaptor(r1);
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public boolean nextBoolean() {
        return this.randomGenerator.nextBoolean();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public void nextBytes(byte[] r1) {
        this.randomGenerator.nextBytes(r1);
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public double nextDouble() {
        return this.randomGenerator.nextDouble();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public float nextFloat() {
        return this.randomGenerator.nextFloat();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public double nextGaussian() {
        return this.randomGenerator.nextGaussian();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public int nextInt() {
        return this.randomGenerator.nextInt();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public int nextInt(int r1) {
        return this.randomGenerator.nextInt(r1);
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public long nextLong() {
        return this.randomGenerator.nextLong();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int r1) {
        RandomGenerator r0 = this.randomGenerator;
        if (r0 == null) goto L6;
        r0.setSeed(r1);
        return;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] r1) {
        RandomGenerator r0 = this.randomGenerator;
        if (r0 == null) goto L6;
        r0.setSeed(r1);
        return;
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long r1) {
        RandomGenerator r0 = this.randomGenerator;
        if (r0 == null) goto L6;
        r0.setSeed(r1);
        return;
    }
}
