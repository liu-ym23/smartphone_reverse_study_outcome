package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableCollection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MapBuilderValues<V> extends AbstractMutableCollection<V> implements Collection<V>, KMutableCollection {
    public final MapBuilder b;

    public MapBuilderValues(MapBuilder r2) {
        Intrinsics.f(r2, "backing");
        this.b = r2;
    }

    @Override // kotlin.collections.AbstractMutableCollection
    public final int a() {
        return this.b.l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection r1) {
        Intrinsics.f(r1, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object r1) {
        return this.b.containsValue(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        MapBuilder r1 = this.b;
        r1.getClass();
        return new MapBuilder.ValuesItr(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object r1) {
        MapBuilder r0 = this.b;
        r0.b();
        int r2 = r0.g(r1);
        if (r2 >= 0) goto L5;
        return false;
    L5:
        r0.j(r2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection r2) {
        Intrinsics.f(r2, "elements");
        this.b.b();
        return super.removeAll(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection r2) {
        Intrinsics.f(r2, "elements");
        this.b.b();
        return super.retainAll(r2);
    }
}
