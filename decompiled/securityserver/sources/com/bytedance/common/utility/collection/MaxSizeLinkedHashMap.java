package com.bytedance.common.utility.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float FACTOR = 0.75f;
    private static final long serialVersionUID = 3805937866184666407L;
    final int mMaxSize;

    public MaxSizeLinkedHashMap(int r2, int r3) {
        this(r2, r3, false);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r1) {
        if (size() <= this.mMaxSize) goto L5;
        return true;
    L5:
        return false;
    }

    public MaxSizeLinkedHashMap(int r2, int r3, boolean r4) {
        super(r3, FACTOR, true);
        this.mMaxSize = r2;
        if (r2 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("maxSize <= 0");
    }
}
