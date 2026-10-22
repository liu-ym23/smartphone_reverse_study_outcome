package org.apache.commons.math3.random;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedRandomGenerator implements RandomGenerator {
    private final RandomGenerator wrapped;

    public SynchronizedRandomGenerator(RandomGenerator r1) {
        this.wrapped = r1;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void setSeed(int r2) {
        monitor-enter(this);
        this.wrapped.setSeed(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void setSeed(int[] r2) {
        monitor-enter(this);
        this.wrapped.setSeed(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void setSeed(long r2) {
        monitor-enter(this);
        this.wrapped.setSeed(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void nextBytes(byte[] r2) {
        monitor-enter(this);
        this.wrapped.nextBytes(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized int nextInt() {
        monitor-enter(this);
        int r0 = this.wrapped.nextInt();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized int nextInt(int r2) {
        monitor-enter(this);
        int r3 = this.wrapped.nextInt(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized long nextLong() {
        monitor-enter(this);
        long r0 = this.wrapped.nextLong();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized boolean nextBoolean() {
        monitor-enter(this);
        boolean r0 = this.wrapped.nextBoolean();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized float nextFloat() {
        monitor-enter(this);
        float r0 = this.wrapped.nextFloat();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized double nextDouble() {
        monitor-enter(this);
        double r0 = this.wrapped.nextDouble();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized double nextGaussian() {
        monitor-enter(this);
        double r0 = this.wrapped.nextGaussian();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
