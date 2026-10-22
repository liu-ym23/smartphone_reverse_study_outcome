package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import javax.annotation.CheckForNull;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Immutable
public final class ImmutableIntArray implements Serializable {
    private static final ImmutableIntArray EMPTY = null;
    private final int[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: renamed from: com.google.common.primitives.ImmutableIntArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        /* synthetic */ AsList(ImmutableIntArray r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        private AsList(ImmutableIntArray r1) {
            this.parent = r1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int r1) {
            return Integer.valueOf(this.parent.get(r1));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object r1) {
            if (indexOf(r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object r2) {
            if ((r2 instanceof Integer) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Integer) r2).intValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object r2) {
            if ((r2 instanceof Integer) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Integer) r2).intValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int r1, int r2) {
            return this.parent.subArray(r1, r2).asList();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Integer> spliterator() {
            return ImmutableIntArray.access$500(this.parent);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object r6) {
            if ((r6 instanceof AsList) == false) goto L7;
            return this.parent.equals(((AsList) r6).parent);
        L7:
            if ((r6 instanceof List) == true) goto L9;
            return false;
        L9:
            List r7 = (List) r6;
            if (size() == r7.size()) goto L12;
            return false;
        L12:
            int r0 = ImmutableIntArray.access$100(this.parent);
            Iterator r8 = r7.iterator();
        L14:
            if (r8.hasNext() == false) goto L22;
            Object r2 = r8.next();
            if ((r2 instanceof Integer) == false) goto L21;
            int r4 = r0 + 1;
            if (ImmutableIntArray.access$000(this.parent)[r0] != ((Integer) r2).intValue()) goto L21;
            r0 = r4;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    public static final class Builder {
        private int[] array;
        private int count;

        Builder(int r2) {
            this.count = 0;
            this.array = new int[r2];
        }

        public Builder add(int r4) {
            ensureRoomFor(1);
            int[] r1 = this.array;
            int r2 = this.count;
            r1[r2] = r4;
            this.count = r2 + 1;
            return this;
        }

        public Builder addAll(int[] r5) {
            ensureRoomFor(r5.length);
            System.arraycopy(r5, 0, this.array, this.count, r5.length);
            this.count += r5.length;
            return this;
        }

        public Builder addAll(Iterable<Integer> r2) {
            if ((r2 instanceof Collection) == true) goto L5;
            Iterator<Integer> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            add(r3.next().intValue());
            goto L8
        L10:
            return this;
        L5:
            return addAll((Collection) r2);
        }

        public Builder addAll(Collection<Integer> r5) {
            ensureRoomFor(r5.size());
            Iterator<Integer> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Integer r0 = r6.next();
            int[] r1 = this.array;
            int r2 = this.count;
            this.count = r2 + 1;
            r1[r2] = r0.intValue();
            goto L4
        L6:
            return this;
        }

        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Spliterator$OfInt] */
        public Builder addAll(IntStream r5) {
            ?? r6 = r5.spliterator();
            long r0 = r6.getExactSizeIfKnown();
            if (r0 <= 0) goto L5;
            ensureRoomFor(Ints.saturatedCast(r0));
        L5:
            r6.forEachRemaining(new ImmutableIntArray$Builder$$ExternalSyntheticLambda0(this));
            return this;
        }

        public Builder addAll(ImmutableIntArray r6) {
            ensureRoomFor(r6.length());
            System.arraycopy(ImmutableIntArray.access$000(r6), ImmutableIntArray.access$100(r6), this.array, this.count, r6.length());
            this.count += r6.length();
            return this;
        }

        private void ensureRoomFor(int r3) {
            int r0 = this.count + r3;
            int[] r4 = this.array;
            if (r0 <= r4.length) goto L6;
            this.array = Arrays.copyOf(r4, expandedCapacity(r4.length, r0));
            return;
        }

        private static int expandedCapacity(int r1, int r2) {
            if (r2 < 0) goto L10;
            int r3 = (r1 + (r1 >> 1)) + 1;
            if (r3 >= r2) goto L6;
            r3 = Integer.highestOneBit(r2 - 1) << 1;
        L6:
            if (r3 >= 0) goto L11;
            return Integer.MAX_VALUE;
        L11:
            return r3;
        L10:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CheckReturnValue
        public ImmutableIntArray build() {
            if (this.count == 0) goto L7;
            int r3 = 0;
            return new ImmutableIntArray(this.array, r3, this.count, null);
        L7:
            return ImmutableIntArray.access$200();
        }
    }

    /* synthetic */ ImmutableIntArray(int[] r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ int[] access$000(ImmutableIntArray r0) {
        return r0.array;
    }

    static /* synthetic */ int access$100(ImmutableIntArray r0) {
        return r0.start;
    }

    static /* synthetic */ ImmutableIntArray access$200() {
        return EMPTY;
    }

    static /* synthetic */ Spliterator.OfInt access$500(ImmutableIntArray r0) {
        return r0.spliterator();
    }

    static {
        EMPTY = new ImmutableIntArray(new int[0]);
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public static ImmutableIntArray of(int r3) {
        return new ImmutableIntArray(new int[]{r3});
    }

    public static ImmutableIntArray of(int r3, int r4) {
        return new ImmutableIntArray(new int[]{r3, r4});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5) {
        return new ImmutableIntArray(new int[]{r3, r4, r5});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5, int r6) {
        return new ImmutableIntArray(new int[]{r3, r4, r5, r6});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5, int r6, int r7) {
        return new ImmutableIntArray(new int[]{r3, r4, r5, r6, r7});
    }

    public static ImmutableIntArray of(int r3, int r4, int r5, int r6, int r7, int r8) {
        return new ImmutableIntArray(new int[]{r3, r4, r5, r6, r7, r8});
    }

    public static ImmutableIntArray of(int r4, int... r5) {
        if (r5.length > 2147483646) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "the total number of elements must fit in an int");
        int[] r1 = new int[r5.length + 1];
        r1[0] = r4;
        System.arraycopy(r5, 0, r1, 1, r5.length);
        return new ImmutableIntArray(r1);
    L5:
        r0 = false;
        goto L6
    }

    public static ImmutableIntArray copyOf(int[] r2) {
        if (r2.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableIntArray(Arrays.copyOf(r2, r2.length));
    }

    public static ImmutableIntArray copyOf(Collection<Integer> r1) {
        if (r1.isEmpty() == false) goto L6;
        return EMPTY;
    L6:
        return new ImmutableIntArray(Ints.toArray(r1));
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> r1) {
        if ((r1 instanceof Collection) == false) goto L7;
        return copyOf((Collection) r1);
    L7:
        return builder().addAll(r1).build();
    }

    public static ImmutableIntArray copyOf(IntStream r1) {
        int[] r2 = r1.toArray();
        if (r2.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableIntArray(r2);
    }

    public static Builder builder(int r2) {
        if (r2 < 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Invalid initialCapacity: %s", r2);
        return new Builder(r2);
    L4:
        r0 = false;
        goto L5
    }

    public static Builder builder() {
        return new Builder(10);
    }

    private ImmutableIntArray(int[] r3) {
        this(r3, 0, r3.length);
    }

    private ImmutableIntArray(int[] r1, int r2, int r3) {
        this.array = r1;
        this.start = r2;
        this.end = r3;
    }

    public int length() {
        return this.end - this.start;
    }

    public boolean isEmpty() {
        if (this.end != this.start) goto L5;
        return true;
    L5:
        return false;
    }

    public int get(int r2) {
        Preconditions.checkElementIndex(r2, length());
        return this.array[this.start + r2];
    }

    public int indexOf(int r3) {
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L10;
        if (this.array[r0] == r3) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0 - this.start;
    L10:
        return -1;
    }

    public int lastIndexOf(int r4) {
        int r0 = this.end;
    L3:
        r0 = r0 - 1;
        int r1 = this.start;
        if (r0 < r1) goto L10;
        if (this.array[r0] != r4) goto L3;
        return r0 - r1;
    L10:
        return -1;
    }

    public boolean contains(int r1) {
        if (indexOf(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void forEach(IntConsumer r3) {
        Preconditions.checkNotNull(r3);
        int r0 = this.start;
    L4:
        if (r0 >= this.end) goto L6;
        r3.accept(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    }

    public IntStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public ImmutableIntArray subArray(int r3, int r4) {
        Preconditions.checkPositionIndexes(r3, r4, length());
        if (r3 == r4) goto L7;
        int[] r1 = this.array;
        int r2 = this.start;
        return new ImmutableIntArray(r1, r3 + r2, r2 + r4);
    L7:
        return EMPTY;
    }

    private Spliterator.OfInt spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public List<Integer> asList() {
        return new AsList(this, null);
    }

    public boolean equals(@CheckForNull Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof ImmutableIntArray) == true) goto L8;
        return false;
    L8:
        ImmutableIntArray r7 = (ImmutableIntArray) r6;
        if (length() == r7.length()) goto L11;
        return false;
    L11:
        int r1 = 0;
    L13:
        if (r1 >= length()) goto L18;
        if (get(r1) != r7.get(r1)) goto L16;
        r1 = r1 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public int hashCode() {
        int r0 = this.start;
        int r1 = 1;
    L4:
        if (r0 >= this.end) goto L6;
        r1 = (r1 * 31) + Ints.hashCode(this.array[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r1;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r0 = new StringBuilder(length() * 5);
        r0.append('[').append(this.array[this.start]);
        int r1 = this.start;
    L7:
        r1 = r1 + 1;
        if (r1 >= this.end) goto L10;
        r0.append(", ").append(this.array[r1]);
        goto L7
    L10:
        r0.append(']');
        return r0.toString();
    }

    public ImmutableIntArray trimmed() {
        if (isPartialView() == true) goto L5;
        return this;
    L5:
        return new ImmutableIntArray(toArray());
    }

    private boolean isPartialView() {
        if (this.start <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.end < this.array.length) goto L8;
        return false;
    }

    Object writeReplace() {
        return trimmed();
    }

    Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return EMPTY;
    }
}
