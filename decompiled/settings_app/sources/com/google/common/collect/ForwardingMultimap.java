package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
    @Override // com.google.common.collect.ForwardingObject
    protected abstract Multimap<K, V> delegate();

    @Override // com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    protected ForwardingMultimap() {
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@CheckForNull Object r1, @CheckForNull Object r2) {
        return delegate().containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object r1) {
        return delegate().containsKey(r1);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object r1) {
        return delegate().containsValue(r1);
    }

    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    public Collection<V> get(@ParametricNullness K r1) {
        return delegate().get(r1);
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        return delegate().keys();
    }

    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(@ParametricNullness K r1, @ParametricNullness V r2) {
        return delegate().put(r1, r2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(@ParametricNullness K r1, Iterable<? extends V> r2) {
        return delegate().putAll(r1, r2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap<? extends K, ? extends V> r1) {
        return delegate().putAll(r1);
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(@CheckForNull Object r1, @CheckForNull Object r2) {
        return delegate().remove(r1, r2);
    }

    public Collection<V> removeAll(@CheckForNull Object r1) {
        return delegate().removeAll(r1);
    }

    public Collection<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2) {
        return delegate().replaceValues(r1, r2);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return delegate().size();
    }

    @Override // com.google.common.collect.Multimap
    public Collection<V> values() {
        return delegate().values();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public boolean equals(@CheckForNull Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return delegate().hashCode();
    }
}
