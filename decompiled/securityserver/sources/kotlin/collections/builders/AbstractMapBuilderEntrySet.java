package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    public abstract boolean b(Map.Entry r1);

    public /* bridge */ boolean c(Map.Entry r1) {
        return super.remove(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r2) {
        if ((r2 instanceof Map.Entry) == true) goto L6;
        return false;
    L6:
        Map.Entry r3 = (Map.Entry) r2;
        Intrinsics.f(r3, "element");
        return b(r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object r2) {
        if ((r2 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return c((Map.Entry) r2);
    }
}
