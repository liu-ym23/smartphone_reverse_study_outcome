package com.bytedanceos.security.widget.stickylistheaders;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
class DualHashMap<TKey, TValue> {
    HashMap<TKey, TValue> mKeyToValue;
    HashMap<TValue, TKey> mValueToKey;

    DualHashMap() {
        this.mKeyToValue = new HashMap();
        this.mValueToKey = new HashMap();
    }

    public void put(TKey t1, TValue t2) {
        remove(t1);
        removeByValue(t2);
        this.mKeyToValue.put(t1, t2);
        this.mValueToKey.put(t2, t1);
    }

    public TKey getKey(TValue value) {
        return this.mValueToKey.get(value);
    }

    public TValue get(TKey key) {
        return this.mKeyToValue.get(key);
    }

    public void remove(TKey key) {
        if (get(key) == null) goto L5;
        this.mValueToKey.remove(get(key));
    L5:
        this.mKeyToValue.remove(key);
    }

    public void removeByValue(TValue value) {
        if (getKey(value) == null) goto L5;
        this.mKeyToValue.remove(getKey(value));
    L5:
        this.mValueToKey.remove(value);
    }
}
