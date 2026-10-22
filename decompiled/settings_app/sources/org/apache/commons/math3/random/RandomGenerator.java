package org.apache.commons.math3.random;

/* JADX INFO: loaded from: classes6.dex */
public interface RandomGenerator {
    boolean nextBoolean();

    void nextBytes(byte[] r1);

    double nextDouble();

    float nextFloat();

    double nextGaussian();

    int nextInt();

    int nextInt(int r1);

    long nextLong();

    void setSeed(int r1);

    void setSeed(long r1);

    void setSeed(int[] r1);
}
