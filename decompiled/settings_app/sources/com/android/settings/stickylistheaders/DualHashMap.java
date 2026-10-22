package com.android.settings.stickylistheaders;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
class DualHashMap<TKey, TValue> {
    HashMap<TKey, TValue> mKeyToValue;
    HashMap<TValue, TKey> mValueToKey;

    DualHashMap() {
        this.mKeyToValue = new HashMap();
        this.mValueToKey = new HashMap();
    }

    public void put(TKey r2, TValue r3) {
        remove(r2);
        removeByValue(r3);
        this.mKeyToValue.put(r2, r3);
        this.mValueToKey.put(r3, r2);
    }

    public TKey getKey(TValue r1) {
        return this.mValueToKey.get(r1);
    }

    public TValue get(TKey r1) {
        return this.mKeyToValue.get(r1);
    }

    public void remove(TKey r3) {
        if (get(r3) == null) goto L5;
        this.mValueToKey.remove(get(r3));
    L5:
        this.mKeyToValue.remove(r3);
    }

    public void removeByValue(TValue r3) {
        if (getKey(r3) == null) goto L5;
        this.mKeyToValue.remove(getKey(r3));
    L5:
        this.mValueToKey.remove(r3);
    }
}
