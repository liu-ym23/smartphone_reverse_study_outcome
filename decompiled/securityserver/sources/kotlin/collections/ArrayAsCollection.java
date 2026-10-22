package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ArrayAsCollection<T> implements Collection<T>, KMappedMarker {
    public final Object[] b;
    public final boolean c;

    public ArrayAsCollection(Object[] r2, boolean r3) {
        Intrinsics.f(r2, "values");
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.Collection
    public final boolean add(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object r2) {
        Object[] r1 = this.b;
        Intrinsics.f(r1, "<this>");
        if (ArraysKt.s(r1, r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection r3) {
        Intrinsics.f(r3, "elements");
        if (r3.isEmpty() == true) goto L15;
        Iterator<T> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        if (contains(r4.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        if (this.b.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return ArrayIteratorKt.a(this.b);
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
        return this.b.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] r1 = this.b;
        Intrinsics.f(r1, "<this>");
        if (this.c == true) goto L5;
    L7:
        Object[] r2 = Arrays.copyOf(r1, r1.length, Object[].class);
        Intrinsics.e(r2, "copyOf(this, this.size, Array<Any?>::class.java)");
        return r2;
    L5:
        if (r1.getClass().equals(Object[].class) == false) goto L7;
        return r1;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] r2) {
        Intrinsics.f(r2, "array");
        return CollectionToArray.b(this, r2);
    }
}
