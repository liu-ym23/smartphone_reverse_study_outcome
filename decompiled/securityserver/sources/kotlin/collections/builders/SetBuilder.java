package kotlin.collections.builders;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SetBuilder<E> extends AbstractMutableSet<E> implements Set<E>, Serializable, KMutableSet {
    public final MapBuilder b;

    public SetBuilder(int r2) {
        this.b = new MapBuilder(r2);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int a() {
        return this.b.l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object r1) {
        if (this.b.a(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection r2) {
        Intrinsics.f(r2, "elements");
        this.b.b();
        return super.addAll(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r1) {
        return this.b.containsKey(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        MapBuilder r1 = this.b;
        r1.getClass();
        return new MapBuilder.KeysItr(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r1) {
        MapBuilder r0 = this.b;
        r0.b();
        int r2 = r0.f(r1);
        if (r2 >= 0) goto L5;
        r2 = -1;
    L6:
        if (r2 < 0) goto L8;
        return true;
    L8:
        return false;
    L5:
        r0.j(r2);
        goto L6
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
