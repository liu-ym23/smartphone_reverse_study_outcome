package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;
    private final int k;

    @CheckForNull
    private T threshold;

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int r1) {
        return least(r1, Ordering.natural());
    }

    public static <T> TopKSelector<T> least(int r1, Comparator<? super T> r2) {
        return new TopKSelector(r2, r1);
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int r1) {
        return greatest(r1, Ordering.natural());
    }

    public static <T> TopKSelector<T> greatest(int r1, Comparator<? super T> r2) {
        return new TopKSelector(Ordering.from(r2).reverse(), r1);
    }

    private TopKSelector(Comparator<? super T> r4, int r5) {
        this.comparator = (Comparator) Preconditions.checkNotNull(r4, "comparator");
        this.k = r5;
        boolean r6 = true;
        if (r5 < 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "k (%s) must be >= 0", r5);
        if (r5 <= 1073741823) goto L10;
        r6 = false;
    L10:
        Preconditions.checkArgument(r6, "k (%s) must be <= Integer.MAX_VALUE / 2", r5);
        this.buffer = (T[]) new Object[IntMath.checkedMultiply(r5, 2)];
        this.bufferSize = 0;
        this.threshold = null;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void offer(@ParametricNullness T r4) {
        int r0 = this.k;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = this.bufferSize;
        if (r1 != 0) goto L8;
        this.buffer[0] = r4;
        this.threshold = r4;
        this.bufferSize = 1;
        return;
    L8:
        if (r1 >= r0) goto L13;
        T[] r2 = this.buffer;
        this.bufferSize = r1 + 1;
        r2[r1] = r4;
        if (this.comparator.compare(r4, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) <= 0) goto L19;
        this.threshold = r4;
        return;
    L19:
        return;
    L13:
        if (this.comparator.compare(r4, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) >= 0) goto L21;
        T[] r3 = this.buffer;
        int r5 = this.bufferSize;
        int r6 = r5 + 1;
        this.bufferSize = r6;
        r3[r5] = r4;
        if (r6 != (this.k * 2)) goto L22;
        trim();
        return;
    L22:
        return;
    }

    private void trim() {
        int r0 = (this.k * 2) - 1;
        int r1 = IntMath.log2(r0 + 0, RoundingMode.CEILING) * 3;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int r5 = partition(r2, r0, ((r2 + r0) + 1) >>> 1);
        int r6 = this.k;
        if (r5 <= r6) goto L7;
        r0 = r5 - 1;
    L9:
        r3 = r3 + 1;
        if (r3 < r1) goto L3;
        Arrays.sort(this.buffer, r2, r0 + 1, this.comparator);
        goto L12
    L7:
        if (r5 >= r6) goto L12;
        r2 = Math.max(r5, r2 + 1);
        r4 = r5;
    L12:
        this.bufferSize = this.k;
        this.threshold = (T) NullnessCasts.uncheckedCastNullableTToT(this.buffer[r4]);
    L13:
        r4 = r4 + 1;
        if (r4 >= this.k) goto L19;
        if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[r4]), (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) <= 0) goto L13;
        this.threshold = this.buffer[r4];
        goto L13
    }

    private int partition(int r4, int r5, int r6) {
        Object r0 = NullnessCasts.uncheckedCastNullableTToT(this.buffer[r6]);
        T[] r1 = this.buffer;
        r1[r6] = r1[r5];
        int r7 = r4;
    L3:
        if (r4 >= r5) goto L8;
        if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[r4]), r0) >= 0) goto L7;
        swap(r7, r4);
        r7 = r7 + 1;
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        T[] r3 = this.buffer;
        r3[r5] = r3[r7];
        r3[r7] = r0;
        return r7;
    }

    private void swap(int r3, int r4) {
        T[] r2 = this.buffer;
        T r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    TopKSelector<T> combine(TopKSelector<T> r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.bufferSize) goto L6;
        offer(NullnessCasts.uncheckedCastNullableTToT(r3.buffer[r0]));
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    public void offerAll(Iterable<? extends T> r1) {
        offerAll(r1.iterator());
    }

    public void offerAll(Iterator<? extends T> r2) {
    L3:
        if (r2.hasNext() == false) goto L5;
        offer(r2.next());
        goto L3
    }

    public List<T> topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        int r0 = this.bufferSize;
        int r1 = this.k;
        if (r0 <= r1) goto L6;
        T[] r2 = this.buffer;
        Arrays.fill(r2, r1, r2.length, null);
        int r3 = this.k;
        this.bufferSize = r3;
        this.threshold = this.buffer[r3 - 1];
    L6:
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }
}
