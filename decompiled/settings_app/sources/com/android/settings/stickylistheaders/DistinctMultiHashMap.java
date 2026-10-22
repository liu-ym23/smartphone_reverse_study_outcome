package com.android.settings.stickylistheaders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class DistinctMultiHashMap<TKey, TItemValue> {
    private IDMapper<TKey, TItemValue> mIDMapper;
    LinkedHashMap<Object, List<TItemValue>> mKeyToValuesMap;
    LinkedHashMap<Object, TKey> mValueToKeyIndexer;

    interface IDMapper<TKey, TItemValue> {
        TKey keyIdToKey(Object r1);

        Object keyToKeyId(TKey r1);

        TItemValue valueIdToValue(Object r1);

        Object valueToValueId(TItemValue r1);
    }

    DistinctMultiHashMap() {
        this(new AnonymousClass1());
    }

    DistinctMultiHashMap(IDMapper<TKey, TItemValue> r2) {
        this.mKeyToValuesMap = new LinkedHashMap();
        this.mValueToKeyIndexer = new LinkedHashMap();
        this.mIDMapper = r2;
    }

    public List<TItemValue> get(TKey r2) {
        return this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(r2));
    }

    public TKey getKey(TItemValue r2) {
        return this.mValueToKeyIndexer.get(this.mIDMapper.valueToValueId(r2));
    }

    public void add(TKey r4, TItemValue r5) {
        Object r0 = this.mIDMapper.keyToKeyId(r4);
        if (this.mKeyToValuesMap.get(r0) != null) goto L5;
        this.mKeyToValuesMap.put(r0, new ArrayList());
    L5:
        TKey r1 = getKey(r5);
        if (r1 == null) goto L8;
        this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(r1)).remove(r5);
    L8:
        this.mValueToKeyIndexer.put(this.mIDMapper.valueToValueId(r5), r4);
        if (containsValue(this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(r4)), r5) == true) goto L12;
        this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(r4)).add(r5);
        return;
    }

    public void removeKey(TKey r5) {
        if (this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(r5)) == null) goto L11;
        Iterator<TItemValue> r0 = this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(r5)).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        TItemValue r1 = r0.next();
        this.mValueToKeyIndexer.remove(this.mIDMapper.valueToValueId(r1));
        goto L6
    L8:
        this.mKeyToValuesMap.remove(this.mIDMapper.keyToKeyId(r5));
        return;
    }

    public void removeValue(TItemValue r4) {
        if (getKey(r4) == null) goto L7;
        List<TItemValue> r0 = this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(getKey(r4)));
        if (r0 == null) goto L7;
        r0.remove(r4);
    L7:
        this.mValueToKeyIndexer.remove(this.mIDMapper.valueToValueId(r4));
    }

    public void clear() {
        this.mValueToKeyIndexer.clear();
        this.mKeyToValuesMap.clear();
    }

    public void clearValues() {
        Iterator<Map.Entry<Object, List<TItemValue>>> r0 = entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Object, List<TItemValue>> r1 = r0.next();
        if (r1.getValue() == null) goto L4;
        r1.getValue().clear();
        goto L4
    L8:
        this.mValueToKeyIndexer.clear();
    }

    public Set<Map.Entry<Object, List<TItemValue>>> entrySet() {
        return this.mKeyToValuesMap.entrySet();
    }

    public Set<Map.Entry<Object, TKey>> reverseEntrySet() {
        return this.mValueToKeyIndexer.entrySet();
    }

    public int size() {
        return this.mKeyToValuesMap.size();
    }

    public int valuesSize() {
        return this.mValueToKeyIndexer.size();
    }

    protected boolean containsValue(List<TItemValue> r3, TItemValue r4) {
        Iterator<TItemValue> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        TItemValue r0 = r5.next();
        if (this.mIDMapper.valueToValueId(r0).equals(this.mIDMapper.valueToValueId(r4)) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public TItemValue getValueByPosition(int r3) {
        Object[] r0 = this.mValueToKeyIndexer.keySet().toArray();
        if (r3 > r0.length) goto L7;
        Object r4 = r0[r3];
        return this.mIDMapper.valueIdToValue(r4);
    L7:
        throw new IndexOutOfBoundsException();
    }
}
