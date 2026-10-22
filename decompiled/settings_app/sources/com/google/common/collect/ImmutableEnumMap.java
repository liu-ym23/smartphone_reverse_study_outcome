package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableEnumMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        EnumSerializedForm(EnumMap<K, V> r1) {
            this.delegate = r1;
        }

        Object readResolve() {
            return new ImmutableEnumMap(this.delegate, null);
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    /* synthetic */ ImmutableEnumMap(EnumMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L7;
        Map.Entry r3 = (Map.Entry) Iterables.getOnlyElement(r2.entrySet());
        return ImmutableMap.of((Enum) r3.getKey(), r3.getValue());
    L7:
        return new ImmutableEnumMap(r2);
    L11:
        return ImmutableMap.of();
    }

    private ImmutableEnumMap(EnumMap<K, V> r1) {
        this.delegate = r1;
        Preconditions.checkArgument(!r1.isEmpty());
    }

    @Override // com.google.common.collect.ImmutableMap
    UnmodifiableIterator<K> keyIterator() {
        return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap
    Spliterator<K> keySpliterator() {
        return this.delegate.keySet().spliterator();
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@CheckForNull Object r1) {
        return this.delegate.containsKey(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r1) {
        return this.delegate.get(r1);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(@CheckForNull Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof ImmutableEnumMap) == false) goto L9;
        r2 = ((ImmutableEnumMap) r2).delegate;
    L9:
        return this.delegate.equals(r2);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return CollectSpliterators.map(this.delegate.entrySet().spliterator(), new ImmutableEnumMap$$ExternalSyntheticLambda0());
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> r1) {
        this.delegate.forEach(r1);
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}
