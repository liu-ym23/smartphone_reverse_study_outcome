package kotlin.collections;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>, KMappedMarker {

    @Metadata
    public static final class Companion {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if ((r4 instanceof Set) == true) goto L8;
        return false;
    L8:
        Set r5 = (Set) r4;
        Intrinsics.f(r5, "other");
        if (size() == r5.size()) goto L12;
        return false;
    L12:
        return containsAll(r5);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Iterator<E> r3 = iterator();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L10;
        E r2 = r3.next();
        if (r2 == null) goto L8;
        int r4 = r2.hashCode();
    L9:
        r1 = r1 + r4;
        goto L4
    L8:
        r4 = 0;
        goto L9
    L10:
        return r1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
