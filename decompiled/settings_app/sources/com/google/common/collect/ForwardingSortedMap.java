package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    protected class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet(ForwardingSortedMap r1) {
            super(r1);
        }
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected abstract SortedMap<K, V> delegate();

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    protected ForwardingSortedMap() {
    }

    @Override // java.util.SortedMap
    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // java.util.SortedMap
    @ParametricNullness
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(@ParametricNullness K r1) {
        return delegate().headMap(r1);
    }

    @Override // java.util.SortedMap
    @ParametricNullness
    public K lastKey() {
        return delegate().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(@ParametricNullness K r1, @ParametricNullness K r2) {
        return delegate().subMap(r1, r2);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(@ParametricNullness K r1) {
        return delegate().tailMap(r1);
    }

    static int unsafeCompare(@CheckForNull Comparator<?> r0, @CheckForNull Object r1, @CheckForNull Object r2) {
        if (r0 != null) goto L6;
        return ((Comparable) r1).compareTo(r2);
    L6:
        return r0.compare(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap
    protected boolean standardContainsKey(@CheckForNull Object r3) {
        K r1 = tailMap(r3).firstKey();     // Catch: Throwable -> L7
        if (unsafeCompare(comparator(), r1, r3) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    protected SortedMap<K, V> standardSubMap(K r3, K r4) {
        if (unsafeCompare(comparator(), r3, r4) > 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "fromKey must be <= toKey");
        return tailMap(r3).headMap(r4);
    L5:
        r0 = false;
        goto L6
    }
}
