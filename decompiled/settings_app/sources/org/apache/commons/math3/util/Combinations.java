package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public class Combinations implements Iterable<int[]> {
    private final IterationOrder iterationOrder;
    private final int k;
    private final int n;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.Combinations$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder = null;

        static {
            int[] r0 = new int[IterationOrder.values().length];
            $SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder = r0;
            r0[IterationOrder.LEXICOGRAPHIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    private static final enum IterationOrder extends Enum<IterationOrder> {
        private static final /* synthetic */ IterationOrder[] $VALUES = null;
        public static final IterationOrder LEXICOGRAPHIC = null;

        private IterationOrder(String r1, int r2) {
            super(r1, r2);
        }

        public static IterationOrder valueOf(String r1) {
            return (IterationOrder) Enum.valueOf(IterationOrder.class, r1);
        }

        public static IterationOrder[] values() {
            return (IterationOrder[]) $VALUES.clone();
        }

        static {
            IterationOrder r0 = new IterationOrder("LEXICOGRAPHIC", 0);
            LEXICOGRAPHIC = r0;
            $VALUES = new IterationOrder[]{r0};
        }
    }

    private static class LexicographicComparator implements Comparator<int[]>, Serializable {
        private static final long serialVersionUID = 20130906;
        private final int k;
        private final int n;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(int[] r1, int[] r2) {
            return compare2(r1, r2);
        }

        LexicographicComparator(int r1, int r2) {
            this.n = r1;
            this.k = r2;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r3, int[] r4) {
            int r0 = r3.length;
            int r1 = this.k;
            if (r0 != r1) goto L18;
            if (r4.length != r1) goto L16;
            int[] r5 = MathArrays.copyOf(r3);
            Arrays.sort(r5);
            int[] r6 = MathArrays.copyOf(r4);
            Arrays.sort(r6);
            long r2 = lexNorm(r5);
            long r7 = lexNorm(r6);
            if (r2 >= r7) goto L10;
            return -1;
        L10:
            if (r2 <= r7) goto L13;
            return 1;
        L13:
            return 0;
        L16:
            throw new DimensionMismatchException(r4.length, this.k);
        L18:
            throw new DimensionMismatchException(r3.length, this.k);
        }

        private long lexNorm(int[] r7) {
            long r0 = 0;
            int r3 = 0;
        L4:
            if (r3 >= r7.length) goto L12;
            int r4 = r7[r3];
            if (r4 < 0) goto L11;
            int r5 = this.n;
            if (r4 >= r5) goto L11;
            r0 = r0 + ((long) (r4 * ArithmeticUtils.pow(r5, r3)));
            r3 = r3 + 1;
        L11:
            throw new OutOfRangeException(Integer.valueOf(r4), 0, Integer.valueOf(this.n - 1));
        L12:
            return r0;
        }
    }

    private static class LexicographicIterator implements Iterator<int[]> {
        private final int[] c;
        private int j;
        private final int k;
        private boolean more;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ int[] next() {
            return next2();
        }

        LexicographicIterator(int r5, int r6) {
            int r0 = 1;
            this.more = true;
            this.k = r6;
            this.c = new int[r6 + 3];
            if (r6 == 0) goto L10;
            if (r6 >= r5) goto L10;
        L6:
            if (r0 > r6) goto L8;
            this.c[r0] = r0 - 1;
            r0 = r0 + 1;
            goto L6
        L8:
            int[] r1 = this.c;
            r1[r6 + 1] = r5;
            r1[r6 + 2] = 0;
            this.j = r6;
            return;
        L10:
            this.more = false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.more;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public int[] next2() {
            if (this.more == false) goto L26;
            int r0 = this.k;
            int[] r1 = new int[r0];
            System.arraycopy(this.c, 1, r1, 0, r0);
            int r2 = this.j;
            if (r2 <= 0) goto L8;
            this.c[r2] = r2;
            this.j = r2 - 1;
            return r1;
        L8:
            int[] r3 = this.c;
            int r4 = r3[1];
            if ((r4 + 1) >= r3[2]) goto L12;
            r3[1] = r4 + 1;
            return r1;
        L12:
            this.j = 2;
            boolean r5 = false;
            int r6 = 0;
        L13:
            if (r5 == true) goto L19;
            int[] r7 = this.c;
            int r8 = this.j;
            r7[r8 - 1] = r8 - 2;
            int r9 = r7[r8] + 1;
            if (r9 != r7[r8 + 1]) goto L17;
            this.j = r8 + 1;
        L18:
            r6 = r9;
            goto L13
        L17:
            r5 = true;
            goto L18
        L19:
            int r10 = this.j;
            if (r10 <= this.k) goto L23;
            this.more = false;
            return r1;
        L23:
            this.c[r10] = r6;
            this.j = r10 - 1;
            return r1;
        L26:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class SingletonIterator implements Iterator<int[]> {
        private boolean more;
        private final int[] singleton;

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ int[] next() {
            return next2();
        }

        SingletonIterator(int[] r2) {
            this.more = true;
            this.singleton = r2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.more;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public int[] next2() {
            if (this.more == false) goto L7;
            this.more = false;
            return this.singleton;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Combinations(int r2, int r3) {
        this(r2, r3, IterationOrder.LEXICOGRAPHIC);
    }

    private Combinations(int r1, int r2, IterationOrder r3) {
        CombinatoricsUtils.checkBinomial(r1, r2);
        this.n = r1;
        this.k = r2;
        this.iterationOrder = r3;
    }

    public int getN() {
        return this.n;
    }

    public int getK() {
        return this.k;
    }

    @Override // java.lang.Iterable
    public Iterator<int[]> iterator() {
        int r0 = this.k;
        if (r0 == 0) goto L14;
        if (r0 == this.n) goto L14;
        if (AnonymousClass1.$SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder[this.iterationOrder.ordinal()] != 1) goto L12;
        return new LexicographicIterator(this.n, this.k);
    L12:
        throw new MathInternalError();
    L14:
        return new SingletonIterator(MathArrays.natural(this.k));
    }

    public Comparator<int[]> comparator() {
        return new LexicographicComparator(this.n, this.k);
    }
}
