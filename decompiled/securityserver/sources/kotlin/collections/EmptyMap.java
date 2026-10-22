package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class EmptyMap implements Map, Serializable, KMappedMarker {
    public static final EmptyMap b = null;

    static {
        b = new EmptyMap();
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r1) {
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r2) {
        if ((r2 instanceof Void) == true) goto L5;
        return false;
    L5:
        Intrinsics.f((Void) r2, "value");
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return EmptySet.b;
    }

    @Override // java.util.Map
    public final boolean equals(Object r1) {
        if ((r1 instanceof Map) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Map) r1).isEmpty() == false) goto L7;
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r1) {
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return EmptySet.b;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object r1, Object r2) {
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
    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return EmptyList.b;
    }
}
