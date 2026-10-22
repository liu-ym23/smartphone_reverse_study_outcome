package kotlin.collections;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class ReversedListReadOnly<T> extends AbstractList<T> {
    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r1) {
        CollectionsKt__ReversedViewsKt.a(this, r1);
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        throw null;
    }
}
