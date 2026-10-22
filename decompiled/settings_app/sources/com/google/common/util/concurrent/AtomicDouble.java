package com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    private static final AtomicLongFieldUpdater<AtomicDouble> updater = null;
    private volatile transient long value;

    static {
        updater = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "value");
    }

    public AtomicDouble(double r1) {
        this.value = Double.doubleToRawLongBits(r1);
    }

    public AtomicDouble() {
    }

    public final double get() {
        return Double.longBitsToDouble(this.value);
    }

    public final void set(double r1) {
        this.value = Double.doubleToRawLongBits(r1);
    }

    public final void lazySet(double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        updater.lazySet(this, r3);
    }

    public final double getAndSet(double r2) {
        long r3 = Double.doubleToRawLongBits(r2);
        return Double.longBitsToDouble(updater.getAndSet(this, r3));
    }

    public final boolean compareAndSet(double r7, double r9) {
        return updater.compareAndSet(this, Double.doubleToRawLongBits(r7), Double.doubleToRawLongBits(r9));
    }

    public final boolean weakCompareAndSet(double r7, double r9) {
        return updater.weakCompareAndSet(this, Double.doubleToRawLongBits(r7), Double.doubleToRawLongBits(r9));
    }

    public final double getAndAdd(double r9) {
    L2:
        long r2 = this.value;
        double r6 = Double.longBitsToDouble(r2);
        long r4 = Double.doubleToRawLongBits(r6 + r9);
        if (updater.compareAndSet(this, r2, r4) == false) goto L2;
        return r6;
    }

    public final double addAndGet(double r9) {
    L2:
        long r2 = this.value;
        double r6 = Double.longBitsToDouble(r2) + r9;
        long r4 = Double.doubleToRawLongBits(r6);
        if (updater.compareAndSet(this, r2, r4) == false) goto L2;
        return r6;
    }

    public String toString() {
        return Double.toString(get());
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    private void writeObject(ObjectOutputStream r3) throws IOException {
        r3.defaultWriteObject();
        r3.writeDouble(get());
    }

    private void readObject(ObjectInputStream r3) throws IOException, ClassNotFoundException {
        r3.defaultReadObject();
        set(r3.readDouble());
    }
}
