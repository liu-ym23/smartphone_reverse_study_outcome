package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap;

    /* JADX INFO: renamed from: com.google.common.reflect.MutableTypeToInstanceMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        /* synthetic */ UnmodifiableEntry(Map.Entry r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ Iterator access$000(Iterator r0) {
            return transformEntries(r0);
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        static <K, V> Set<Map.Entry<K, V>> transformEntries(final Set<Map.Entry<K, V>> r1) {
            return new AnonymousClass1(r1);
        }

        private static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> r1) {
            return Iterators.transform(r1, new AnonymousClass2());
        }

        private UnmodifiableEntry(Map.Entry<K, V> r1) {
            this.delegate = (Map.Entry) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        protected Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V r1) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @Deprecated
    public /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
        return put((TypeToken) r1, r2);
    }

    public MutableTypeToInstanceMap() {
        this.backingMap = Maps.newHashMap();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(Class<T> r1) {
        return (T) trustedGet(TypeToken.of(r1));
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(TypeToken<T> r1) {
        return (T) trustedGet(r1.rejectTypeVariables());
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T putInstance(Class<T> r1, T r2) {
        return (T) trustedPut(TypeToken.of(r1), r2);
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T putInstance(TypeToken<T> r1, T r2) {
        return (T) trustedPut(r1.rejectTypeVariables(), r2);
    }

    @Deprecated
    public B put(TypeToken<? extends B> r1, B r2) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> r1) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return UnmodifiableEntry.transformEntries(super.entrySet());
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    protected Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    private <T extends B> T trustedPut(TypeToken<T> r1, T r2) {
        return this.backingMap.put(r1, r2);
    }

    private <T extends B> T trustedGet(TypeToken<T> r1) {
        return this.backingMap.get(r1);
    }
}
