package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    public ArrayMap(int r1) {
        super(r1);
    }

    public ArrayMap(SimpleArrayMap r1) {
        super(r1);
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections != null) goto L6;
        this.mCollections = new AnonymousClass1(this);
    L6:
        return this.mCollections;
    }

    public boolean containsAll(Collection<?> r1) {
        return MapCollections.containsAllHelper(this, r1);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> r3) {
        ensureCapacity(this.mSize + r3.size());
        Iterator<Map.Entry<? extends K, ? extends V>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<? extends K, ? extends V> r0 = r4.next();
        put(r0.getKey(), r0.getValue());
        goto L4
    }

    public boolean removeAll(Collection<?> r1) {
        return MapCollections.removeAllHelper(this, r1);
    }

    public boolean retainAll(Collection<?> r1) {
        return MapCollections.retainAllHelper(this, r1);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return getCollection().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return getCollection().getKeySet();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return getCollection().getValues();
    }
}
