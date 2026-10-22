package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r2) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = size();
        r0.getClass();
        AbstractList.Companion.a(r2, r1);
        int r3 = (0 + r2) % 0;
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] r3) {
        Intrinsics.f(r3, "array");
        if (r3.length >= size()) goto L6;
        r3 = Arrays.copyOf(r3, size());
        Intrinsics.e(r3, "copyOf(this, newSize)");
    L6:
        if (size() > 0) goto L12;
        if (r3.length <= size()) goto L10;
        r3[size()] = null;
    L10:
        return r3;
    L12:
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
