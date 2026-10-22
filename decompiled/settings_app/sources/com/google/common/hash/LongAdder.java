package com.google.common.hash;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    @Override // com.google.common.hash.Striped64
    final long fn(long r1, long r3) {
        return r1 + r3;
    }

    public LongAdder() {
    }

    @Override // com.google.common.hash.LongAddable
    public void add(long r7) {
        Striped64.Cell[] r0 = this.cells;
        if (r0 != null) goto L6;
        long r1 = this.base;
        if (casBase(r1, r1 + r7) == false) goto L6;
        return;
    L6:
        int[] r2 = threadHashCode.get();
        boolean r3 = true;
        if (r2 == null) goto L15;
        if (r0 == null) goto L15;
        int r4 = r0.length;
        if (r4 < 1) goto L15;
        Striped64.Cell r5 = r0[(r4 - 1) & r2[0]];
        if (r5 == null) goto L15;
        long r6 = r5.value;
        r3 = r5.cas(r6, r6 + r7);
        if (r3 == false) goto L15;
        return;
    L15:
        retryUpdate(r7, r2, r3);
    }

    @Override // com.google.common.hash.LongAddable
    public void increment() {
        add(1);
    }

    public void decrement() {
        add(-1);
    }

    @Override // com.google.common.hash.LongAddable
    public long sum() {
        long r0 = this.base;
        Striped64.Cell[] r6 = this.cells;
        if (r6 == null) goto L10;
        int r2 = r6.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        Striped64.Cell r4 = r6[r3];
        if (r4 == null) goto L9;
        r0 = r0 + r4.value;
    L9:
        r3 = r3 + 1;
    L10:
        return r0;
    }

    public void reset() {
        internalReset(0);
    }

    public long sumThenReset() {
        long r0 = this.base;
        Striped64.Cell[] r2 = this.cells;
        this.base = 0;
        if (r2 == null) goto L10;
        int r9 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r9) goto L10;
        Striped64.Cell r6 = r2[r5];
        if (r6 == null) goto L9;
        r0 = r0 + r6.value;
        r6.value = 0;
    L9:
        r5 = r5 + 1;
    L10:
        return r0;
    }

    public String toString() {
        return Long.toString(sum());
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    private void writeObject(ObjectOutputStream r3) throws IOException {
        r3.defaultWriteObject();
        r3.writeLong(sum());
    }

    private void readObject(ObjectInputStream r3) throws IOException, ClassNotFoundException {
        r3.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = r3.readLong();
    }
}
