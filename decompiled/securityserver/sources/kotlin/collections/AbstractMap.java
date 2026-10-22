package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class AbstractMap<K, V> implements Map<K, V>, KMappedMarker {
    public volatile AbstractMap$keys$1 b;
    public volatile C00441 c;

    @Metadata
    public static final class Companion {
    }

    public abstract Set a();

    public final Map.Entry b(Object r3) {
        Iterator r2 = a().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r0 = r2.next();
        if (Intrinsics.a(((Map.Entry) r0).getKey(), r3) == false) goto L4;
    L10:
        return (Map.Entry) r0;
    L8:
        r0 = null;
        goto L10
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r1) {
        if (b(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r3) {
        Set r2 = a();
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L18;
        if (Intrinsics.a(((Map.Entry) r4.next()).getValue(), r3) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return a();
    }

    @Override // java.util.Map
    public final boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if ((r6 instanceof Map) == true) goto L8;
        return false;
    L8:
        Map r7 = (Map) r6;
        if (size() == r7.size()) goto L11;
        return false;
    L11:
        Set<Map.Entry<K, V>> r8 = r7.entrySet();
        if ((r8 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L39;
        Map.Entry r1 = (Map.Entry) r9.next();
        if (r1 == null) goto L29;
        Object r3 = r1.getKey();
        Object r2 = r1.getValue();
        V r4 = get(r3);
        if (Intrinsics.a(r2, r4) == false) goto L29;
        if (r4 != null) goto L18;
        if (containsKey(r3) == true) goto L18;
    L29:
        return false;
    L39:
        return true;
    L14:
        if (r8.isEmpty() == false) goto L16;
        return true;
    }

    @Override // java.util.Map
    public final Object get(Object r1) {
        Map.Entry r0 = b(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getValue();
    }

    @Override // java.util.Map
    public final int hashCode() {
        return a().hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.AbstractMap$keys$1] */
    @Override // java.util.Map
    public final Set keySet() {
        if (this.b != null) goto L5;
        this.b = new AbstractMap$keys$1(this);
    L5:
        AbstractMap$keys$1 r1 = this.b;
        Intrinsics.c(r1);
        return r1;
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
        return a().size();
    }

    public final String toString() {
        return CollectionsKt.i(a(), ", ", "{", "}", new AnonymousClass1(this), 24);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.AbstractMap$values$1] */
    @Override // java.util.Map
    public final Collection values() {
        if (this.c != null) goto L5;
        this.c = new C00441(this);
    L5:
        C00441 r1 = this.c;
        Intrinsics.c(r1);
        return r1;
    }
}
