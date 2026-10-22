package androidx.arch.core.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap;

    public FastSafeIterableMap() {
        this.mHashMap = new HashMap();
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    protected SafeIterableMap.Entry<K, V> get(K r1) {
        return this.mHashMap.get(r1);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(K r2, V r3) {
        SafeIterableMap.Entry<K, V> r0 = get(r2);
        if (r0 != null) goto L5;
        this.mHashMap.put(r2, put(r2, r3));
        return null;
    L5:
        return r0.mValue;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(K r2) {
        V r0 = (V) super.remove(r2);
        this.mHashMap.remove(r2);
        return r0;
    }

    public boolean contains(K r1) {
        return this.mHashMap.containsKey(r1);
    }

    public Map.Entry<K, V> ceil(K r2) {
        if (contains(r2) == true) goto L5;
        return null;
    L5:
        return this.mHashMap.get(r2).mPrevious;
    }
}
