package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@ExperimentalUnsignedTypes
@JvmInline
public final class ULongArray implements Collection<ULong>, KMappedMarker {

    @Metadata
    public static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {
        public final long[] b;
        public int c;

        public Iterator() {
            Intrinsics.f(null, "array");
            this.b = null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.c >= this.b.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final ULong next() {
            int r0 = this.c;
            long[] r1 = this.b;
            if (r0 >= r1.length) goto L7;
            this.c = r0 + 1;
            return new ULong(r1[r0]);
        L7:
            throw new NoSuchElementException(String.valueOf(this.c));
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static void a() {
        new Iterator();
    }

    @Override // java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(ULong r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends ULong> r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object r1) {
        if ((r1 instanceof ULong) == true) goto L6;
        return false;
    L6:
        ArraysKt.e(((ULong) r1).b);
        throw null;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection r2) {
        Intrinsics.f(r2, "elements");
        if (r2.isEmpty() == true) goto L14;
        java.util.Iterator r1 = r2.iterator();
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        if ((r3 instanceof ULong) == true) goto L10;
        return false;
    L10:
        ArraysKt.e(((ULong) r3).b);
        throw null;
    L12:
        return true;
    L14:
        return true;
    }

    @Override // java.util.Collection
    public final boolean equals(Object r2) {
        if ((r2 instanceof ULongArray) == false) goto L10;
        ((ULongArray) r2).getClass();
        if (Intrinsics.a(null, null) == false) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return Arrays.hashCode(null);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        throw null;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Iterator iterator() {
        new Iterator();
        throw null;
    }

    @Override // java.util.Collection
    public final boolean remove(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        throw null;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final String toString() {
        return "ULongArray(storage=" + Arrays.toString(null) + ')';
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] r2) {
        Intrinsics.f(r2, "array");
        return CollectionToArray.b(this, r2);
    }
}
