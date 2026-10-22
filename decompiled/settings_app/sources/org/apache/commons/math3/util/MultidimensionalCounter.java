package org.apache.commons.math3.util;

import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public class MultidimensionalCounter implements Iterable<Integer> {
    private final int dimension;
    private final int last;
    private final int[] size;
    private final int totalSize;
    private final int[] uniCounterOffset;

    public class Iterator implements java.util.Iterator<Integer> {
        private int count;
        private final int[] counter;
        private final int maxCount;
        final /* synthetic */ MultidimensionalCounter this$0;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Integer next() {
            return next();
        }

        Iterator(MultidimensionalCounter r4) {
            this.this$0 = r4;
            int[] r0 = new int[MultidimensionalCounter.access$000(r4)];
            this.counter = r0;
            this.count = -1;
            this.maxCount = MultidimensionalCounter.access$100(r4) - 1;
            r0[MultidimensionalCounter.access$200(r4)] = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.count >= this.maxCount) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            if (hasNext() == false) goto L13;
            int r0 = MultidimensionalCounter.access$200(this.this$0);
        L5:
            if (r0 < 0) goto L10;
            if (this.counter[r0] != (MultidimensionalCounter.access$300(this.this$0)[r0] - 1)) goto L9;
            this.counter[r0] = 0;
            r0 = r0 - 1;
            goto L5
        L9:
            int[] r1 = this.counter;
            r1[r0] = r1[r0] + 1;
        L10:
            int r2 = this.count + 1;
            this.count = r2;
            return Integer.valueOf(r2);
        L13:
            throw new NoSuchElementException();
        }

        public int getCount() {
            return this.count;
        }

        public int[] getCounts() {
            return MathArrays.copyOf(this.counter);
        }

        public int getCount(int r1) {
            return this.counter[r1];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static /* synthetic */ int access$000(MultidimensionalCounter r0) {
        return r0.dimension;
    }

    static /* synthetic */ int access$100(MultidimensionalCounter r0) {
        return r0.totalSize;
    }

    static /* synthetic */ int access$200(MultidimensionalCounter r0) {
        return r0.last;
    }

    static /* synthetic */ int[] access$300(MultidimensionalCounter r0) {
        return r0.size;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ java.util.Iterator<Integer> iterator() {
        return iterator2();
    }

    public MultidimensionalCounter(int... r9) throws NotStrictlyPositiveException {
        int r0 = r9.length;
        this.dimension = r0;
        this.size = MathArrays.copyOf(r9);
        this.uniCounterOffset = new int[r0];
        int r1 = r0 - 1;
        this.last = r1;
        int r2 = r9[r1];
        int r3 = 0;
    L3:
        int r4 = this.last;
        if (r3 >= r4) goto L10;
        int r5 = r3 + 1;
        int r6 = 1;
        int r7 = r5;
    L7:
        if (r7 >= this.dimension) goto L9;
        r6 = r6 * r9[r7];
        r7 = r7 + 1;
        goto L7
    L9:
        this.uniCounterOffset[r3] = r6;
        r2 = r2 * r9[r3];
        r3 = r5;
        goto L3
    L10:
        this.uniCounterOffset[r4] = 0;
        if (r2 <= 0) goto L15;
        this.totalSize = r2;
        return;
    L15:
        throw new NotStrictlyPositiveException(Integer.valueOf(r2));
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public java.util.Iterator<Integer> iterator2() {
        return new Iterator(this);
    }

    public int getDimension() {
        return this.dimension;
    }

    public int[] getCounts(int r7) throws OutOfRangeException {
        if (r7 < 0) goto L16;
        if (r7 >= this.totalSize) goto L16;
        int[] r1 = new int[this.dimension];
        int r2 = 0;
        int r3 = 0;
    L7:
        int r4 = this.last;
        if (r2 >= r4) goto L13;
        int r5 = this.uniCounterOffset[r2];
        int r6 = 0;
    L10:
        if (r3 > r7) goto L12;
        r3 = r3 + r5;
        r6 = r6 + 1;
        goto L10
    L12:
        r3 = r3 - r5;
        r1[r2] = r6 - 1;
        r2 = r2 + 1;
        goto L7
    L13:
        r1[r4] = r7 - r3;
        return r1;
    L16:
        throw new OutOfRangeException(Integer.valueOf(r7), 0, Integer.valueOf(this.totalSize));
    }

    public int getCount(int... r6) throws OutOfRangeException, DimensionMismatchException {
        if (r6.length != this.dimension) goto L17;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r1 >= this.dimension) goto L15;
        int r3 = r6[r1];
        if (r3 < 0) goto L13;
        if (r3 >= this.size[r1]) goto L13;
        r2 = r2 + (this.uniCounterOffset[r1] * r3);
        r1 = r1 + 1;
    L13:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(this.size[r1] - 1));
    L15:
        return r2 + r6[this.last];
    L17:
        throw new DimensionMismatchException(r6.length, this.dimension);
    }

    public int getSize() {
        return this.totalSize;
    }

    public int[] getSizes() {
        return MathArrays.copyOf(this.size);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L4:
        if (r2 >= this.dimension) goto L7;
        r0.append("[").append(getCount(new int[]{r2})).append("]");
        r2 = r2 + 1;
        goto L4
    L7:
        return r0.toString();
    }
}
