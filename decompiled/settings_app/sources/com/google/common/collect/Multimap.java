package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
@ElementTypesAreNonnullByDefault
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@CheckForNull Object r1, @CheckForNull Object r2);

    boolean containsKey(@CheckForNull Object r1);

    boolean containsValue(@CheckForNull Object r1);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@CheckForNull Object r1);

    Collection<V> get(@ParametricNullness K r1);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    boolean put(@ParametricNullness K r1, @ParametricNullness V r2);

    boolean putAll(Multimap<? extends K, ? extends V> r1);

    boolean putAll(@ParametricNullness K r1, Iterable<? extends V> r2);

    boolean remove(@CheckForNull Object r1, @CheckForNull Object r2);

    Collection<V> removeAll(@CheckForNull Object r1);

    Collection<V> replaceValues(@ParametricNullness K r1, Iterable<? extends V> r2);

    int size();

    Collection<V> values();

    default void forEach(final BiConsumer<? super K, ? super V> r2) {
        Preconditions.checkNotNull(r2);
        entries().forEach(new Multimap$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$forEach$0(BiConsumer r1, Map.Entry r2) {
        r1.accept(r2.getKey(), r2.getValue());
    }
}
