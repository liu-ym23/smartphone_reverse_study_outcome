package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class Options implements Key {
    private final ArrayMap<Option<?>, Object> values;

    public Options() {
        this.values = new CachedHashCodeArrayMap();
    }

    public void putAll(Options r1) {
        this.values.putAll(r1.values);
    }

    public <T> Options set(Option<T> r2, T r3) {
        this.values.put(r2, r3);
        return this;
    }

    public Options remove(Option<?> r2) {
        this.values.remove(r2);
        return this;
    }

    public <T> T get(Option<T> r2) {
        if (this.values.containsKey(r2) == false) goto L6;
        return (T) this.values.get(r2);
    L6:
        return r2.getDefaultValue();
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r2) {
        if ((r2 instanceof Options) == true) goto L5;
        return false;
    L5:
        return this.values.equals(((Options) r2).values);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.values.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.values.size()) goto L6;
        updateDiskCacheKey(this.values.keyAt(r0), this.values.valueAt(r0), r4);
        r0 = r0 + 1;
        goto L4
    }

    public String toString() {
        return "Options{values=" + this.values + '}';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void updateDiskCacheKey(Option<T> r0, Object r1, MessageDigest r2) {
        r0.update(r1, r2);
    }
}
