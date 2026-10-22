package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MapBuilderEntries<K, V> extends AbstractMapBuilderEntrySet<Map.Entry<K, V>, K, V> {
    public final MapBuilder b;

    public MapBuilderEntries(MapBuilder r2) {
        Intrinsics.f(r2, "backing");
        this.b = r2;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int a() {
        return this.b.l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object r1) {
        Intrinsics.f((Map.Entry) r1, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection r1) {
        Intrinsics.f(r1, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public final boolean b(Map.Entry r2) {
        Intrinsics.f(r2, "element");
        return this.b.d(r2);
    }

    @Override // kotlin.collections.builders.AbstractMapBuilderEntrySet
    public final boolean c(Map.Entry r4) {
        Intrinsics.f(r4, "element");
        MapBuilder r3 = this.b;
        r3.getClass();
        r3.b();
        int r0 = r3.f(r4.getKey());
        if (r0 < 0) goto L10;
        Object[] r2 = r3.c;
        Intrinsics.c(r2);
        if (Intrinsics.a(r2[r0], r4.getValue()) == false) goto L11;
        r3.j(r0);
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection r2) {
        Intrinsics.f(r2, "elements");
        return this.b.c(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        MapBuilder r1 = this.b;
        r1.getClass();
        return new MapBuilder.EntriesItr(r1);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection r2) {
        Intrinsics.f(r2, "elements");
        this.b.b();
        return super.removeAll(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection r2) {
        Intrinsics.f(r2, "elements");
        this.b.b();
        return super.retainAll(r2);
    }
}
