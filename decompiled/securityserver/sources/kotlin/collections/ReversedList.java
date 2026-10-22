package kotlin.collections;

import a.a;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ReversedList<T> extends AbstractMutableList<T> {
    @Override // kotlin.collections.AbstractMutableList
    public final int a() {
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r5, Object r6) {
        if (new IntRange(0, size(), 1).b(r5) == false) goto L6;
        size();
        throw null;
    L6:
        StringBuilder r7 = a.p(r5, "Position index ", " must be in range [");
        r7.append(new IntRange(0, size(), 1));
        r7.append("].");
        throw new IndexOutOfBoundsException(r7.toString());
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object b(int r1) {
        CollectionsKt__ReversedViewsKt.a(this, r1);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r1) {
        CollectionsKt__ReversedViewsKt.a(this, r1);
        throw null;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r1, Object r2) {
        CollectionsKt__ReversedViewsKt.a(this, r1);
        throw null;
    }
}
