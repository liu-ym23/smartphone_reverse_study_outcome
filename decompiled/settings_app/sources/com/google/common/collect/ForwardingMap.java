package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {

    protected abstract class StandardEntrySet extends Maps.EntrySet<K, V> {
        final /* synthetic */ ForwardingMap this$0;

        public StandardEntrySet(ForwardingMap r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Maps.EntrySet
        Map<K, V> map() {
            return this.this$0;
        }
    }

    protected class StandardKeySet extends Maps.KeySet<K, V> {
        public StandardKeySet(ForwardingMap r1) {
            super(r1);
        }
    }

    protected class StandardValues extends Maps.Values<K, V> {
        public StandardValues(ForwardingMap r1) {
            super(r1);
        }
    }

    @Override // com.google.common.collect.ForwardingObject
    protected abstract Map<K, V> delegate();

    @Override // com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    protected ForwardingMap() {
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @CheckForNull
    public V remove(@CheckForNull Object r1) {
        return delegate().remove(r1);
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object r1) {
        return delegate().containsKey(r1);
    }

    public boolean containsValue(@CheckForNull Object r1) {
        return delegate().containsValue(r1);
    }

    @Override // java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r1) {
        return delegate().get(r1);
    }

    @CheckForNull
    public V put(@ParametricNullness K r1, @ParametricNullness V r2) {
        return delegate().put(r1, r2);
    }

    public void putAll(Map<? extends K, ? extends V> r1) {
        delegate().putAll(r1);
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    protected void standardPutAll(Map<? extends K, ? extends V> r1) {
        Maps.putAllImpl(this, r1);
    }

    @CheckForNull
    protected V standardRemove(@CheckForNull Object r3) {
        Iterator<Map.Entry<K, V>> r2 = entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<K, V> r0 = r2.next();
        if (Objects.equal(r0.getKey(), r3) == false) goto L4;
        V r4 = r0.getValue();
        r2.remove();
        return r4;
    L9:
        return null;
    }

    protected void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    protected boolean standardContainsKey(@CheckForNull Object r1) {
        return Maps.containsKeyImpl(this, r1);
    }

    protected boolean standardContainsValue(@CheckForNull Object r1) {
        return Maps.containsValueImpl(this, r1);
    }

    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    protected boolean standardEquals(@CheckForNull Object r1) {
        return Maps.equalsImpl(this, r1);
    }

    protected int standardHashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    protected String standardToString() {
        return Maps.toStringImpl(this);
    }
}
