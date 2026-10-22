package com.bytedanceos.security.widget.stickylistheaders;

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
        TKey keyIdToKey(Object keyId);

        Object keyToKeyId(TKey key);

        TItemValue valueIdToValue(Object valueId);

        Object valueToValueId(TItemValue value);
    }

    DistinctMultiHashMap() {
        this(new AnonymousClass1());
    }

    DistinctMultiHashMap(IDMapper<TKey, TItemValue> idMapper) {
        this.mKeyToValuesMap = new LinkedHashMap();
        this.mValueToKeyIndexer = new LinkedHashMap();
        this.mIDMapper = idMapper;
    }

    public List<TItemValue> get(TKey key) {
        return this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(key));
    }

    public TKey getKey(TItemValue value) {
        return this.mValueToKeyIndexer.get(this.mIDMapper.valueToValueId(value));
    }

    public void add(TKey key, TItemValue value) {
        Object r0 = this.mIDMapper.keyToKeyId(key);
        if (this.mKeyToValuesMap.get(r0) != null) goto L5;
        this.mKeyToValuesMap.put(r0, new ArrayList());
    L5:
        TKey r1 = getKey(value);
        if (r1 == null) goto L8;
        this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(r1)).remove(value);
    L8:
        this.mValueToKeyIndexer.put(this.mIDMapper.valueToValueId(value), key);
        if (containsValue(this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(key)), value) == true) goto L12;
        this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(key)).add(value);
        return;
    }

    public void removeKey(TKey key) {
        if (this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(key)) == null) goto L11;
        Iterator<TItemValue> r0 = this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(key)).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        TItemValue r1 = r0.next();
        this.mValueToKeyIndexer.remove(this.mIDMapper.valueToValueId(r1));
        goto L6
    L8:
        this.mKeyToValuesMap.remove(this.mIDMapper.keyToKeyId(key));
        return;
    }

    public void removeValue(TItemValue value) {
        if (getKey(value) == null) goto L7;
        List<TItemValue> r0 = this.mKeyToValuesMap.get(this.mIDMapper.keyToKeyId(getKey(value)));
        if (r0 == null) goto L7;
        r0.remove(value);
    L7:
        this.mValueToKeyIndexer.remove(this.mIDMapper.valueToValueId(value));
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

    protected boolean containsValue(List<TItemValue> list, TItemValue value) {
        Iterator<TItemValue> r3 = list.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        TItemValue r0 = r3.next();
        if (this.mIDMapper.valueToValueId(r0).equals(this.mIDMapper.valueToValueId(value)) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public TItemValue getValueByPosition(int position) {
        Object[] r0 = this.mValueToKeyIndexer.keySet().toArray();
        if (position > r0.length) goto L7;
        Object r3 = r0[position];
        return this.mIDMapper.valueIdToValue(r3);
    L7:
        throw new IndexOutOfBoundsException();
    }
}
