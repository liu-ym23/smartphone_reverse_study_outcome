package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class MapWithDefaultImpl<K, V> implements MapWithDefault<K, V> {
    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r1) {
        throw null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r1) {
        throw null;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        throw null;
    }

    @Override // java.util.Map
    public final boolean equals(Object r1) {
        throw null;
    }

    @Override // java.util.Map
    public final Object get(Object r1) {
        throw null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        throw null;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        throw null;
    }

    @Override // java.util.Map
    public final Set keySet() {
        throw null;
    }

    @Override // java.util.Map
    public final Object put(Object r1, Object r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final Object remove(Object r1) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        throw null;
    }

    public final String toString() {
        throw null;
    }

    @Override // java.util.Map
    public final Collection values() {
        throw null;
    }
}
