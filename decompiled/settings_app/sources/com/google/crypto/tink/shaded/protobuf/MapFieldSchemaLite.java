package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
class MapFieldSchemaLite implements MapFieldSchema {
    MapFieldSchemaLite() {
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Map<?, ?> forMutableMapData(Object mapField) {
        return (MapFieldLite) mapField;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public MapEntryLite.Metadata<?, ?> forMapMetadata(Object mapDefaultEntry) {
        return ((MapEntryLite) mapDefaultEntry).getMetadata();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Map<?, ?> forMapData(Object mapField) {
        return (MapFieldLite) mapField;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public boolean isImmutable(Object mapField) {
        return !((MapFieldLite) mapField).isMutable();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Object toImmutable(Object mapField) {
        ((MapFieldLite) mapField).makeImmutable();
        return mapField;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Object newMapField(Object unused) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public Object mergeFrom(Object destMapField, Object srcMapField) {
        return mergeFromLite(destMapField, srcMapField);
    }

    private static <K, V> MapFieldLite<K, V> mergeFromLite(Object destMapField, Object srcMapField) {
        MapFieldLite<K, V> r1 = (MapFieldLite) destMapField;
        MapFieldLite<K, V> r2 = (MapFieldLite) srcMapField;
        if (r2.isEmpty() == false) goto L5;
    L8:
        return r1;
    L5:
        if (r1.isMutable() == true) goto L7;
        r1 = r1.mutableCopy();
    L7:
        r1.mergeFrom(r2);
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MapFieldSchema
    public int getSerializedSize(int fieldNumber, Object mapField, Object mapDefaultEntry) {
        return getSerializedSizeLite(fieldNumber, mapField, mapDefaultEntry);
    }

    private static <K, V> int getSerializedSizeLite(int fieldNumber, Object mapField, Object defaultEntry) {
        MapFieldLite r4 = (MapFieldLite) mapField;
        MapEntryLite r5 = (MapEntryLite) defaultEntry;
        int r1 = 0;
        if (r4.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<K, V>> r6 = r4.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<K, V> r0 = r6.next();
        r1 = r1 + r5.computeMessageSize(fieldNumber, r0.getKey(), r0.getValue());
        goto L7
    L9:
        return r1;
    }
}
