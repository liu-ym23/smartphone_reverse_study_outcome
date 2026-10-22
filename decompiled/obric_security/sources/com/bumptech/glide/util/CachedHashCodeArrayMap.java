package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    private int hashCode;

    public CachedHashCodeArrayMap() {
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int r2, V r3) {
        this.hashCode = 0;
        return (V) super.setValueAt(r2, r3);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K r2, V r3) {
        this.hashCode = 0;
        return (V) super.put(r2, r3);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> r2) {
        this.hashCode = 0;
        super.putAll(r2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int r2) {
        this.hashCode = 0;
        return (V) super.removeAt(r2);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        this.hashCode = super.hashCode();
    L6:
        return this.hashCode;
    }
}
