package kotlin.i0.z0;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b \u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H&¨\u0006\f"}, d2 = {"Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "E", "", "K", "V", "Lkotlin/collections/AbstractMutableSet;", "()V", "contains", "", "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends kotlin.i0.f<E> {
    public a() {
    }

    public final boolean b(E r2) {
        o.f(r2, "element");
        return c(r2);
    }

    public abstract boolean c(Map.Entry<? extends K, ? extends V> r1);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return b((Map.Entry) r2);
    }

    public abstract /* bridge */ boolean g(Map.Entry<?, ?> r1);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object r2) {
        if ((r2 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return g((Map.Entry) r2);
    }
}
