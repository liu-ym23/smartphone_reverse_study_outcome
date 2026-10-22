package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.MapEntryLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
            this.keyType = keyType;
            this.defaultKey = defaultKey;
            this.valueType = valueType;
            this.defaultValue = defaultValue;
        }
    }

    private MapEntryLite(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
        this.metadata = new Metadata(keyType, defaultKey, valueType, defaultValue);
        this.key = defaultKey;
        this.value = defaultValue;
    }

    private MapEntryLite(Metadata<K, V> metadata, K key, V value) {
        this.metadata = metadata;
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType keyType, K defaultKey, WireFormat.FieldType valueType, V defaultValue) {
        return new MapEntryLite(keyType, defaultKey, valueType, defaultValue);
    }

    static <K, V> void writeTo(CodedOutputStream output, Metadata<K, V> metadata, K key, V value) throws IOException {
        FieldSet.writeElement(output, metadata.keyType, 1, key);
        FieldSet.writeElement(output, metadata.valueType, 2, value);
    }

    static <K, V> int computeSerializedSize(Metadata<K, V> metadata, K key, V value) {
        return FieldSet.computeElementSize(metadata.keyType, 1, key) + FieldSet.computeElementSize(metadata.valueType, 2, value);
    }

    static <T> T parseField(CodedInputStream r2, ExtensionRegistryLite r3, WireFormat.FieldType r4, T r5) throws IOException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r4.ordinal()];
        if (r0 != 1) goto L5;
        MessageLite.Builder r6 = ((MessageLite) r5).toBuilder();
        r2.readMessage(r6, r3);
        return (T) r6.buildPartial();
    L5:
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L11;
        return (T) FieldSet.readPrimitiveField(r2, r4, true);
    L11:
        throw new RuntimeException("Groups are not allowed in maps.");
    L13:
        return (T) Integer.valueOf(r2.readEnum());
    }

    public void serializeTo(CodedOutputStream output, int fieldNumber, K key, V value) throws IOException {
        output.writeTag(fieldNumber, 2);
        output.writeUInt32NoTag(computeSerializedSize(this.metadata, key, value));
        writeTo(output, this.metadata, key, value);
    }

    public int computeMessageSize(int fieldNumber, K key, V value) {
        return CodedOutputStream.computeTagSize(fieldNumber) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, key, value));
    }

    public Map.Entry<K, V> parseEntry(ByteString bytes, ExtensionRegistryLite extensionRegistry) throws IOException {
        return parseEntry(bytes.newCodedInput(), this.metadata, extensionRegistry);
    }

    static <K, V> Map.Entry<K, V> parseEntry(CodedInputStream input, Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
        Object r0 = metadata.defaultKey;
        Object r1 = metadata.defaultValue;
    L3:
        int r2 = input.readTag();
        if (r2 == 0) goto L15;
        if (r2 == WireFormat.makeTag(1, metadata.keyType.getWireType())) goto L8;
        if (r2 == WireFormat.makeTag(2, metadata.valueType.getWireType())) goto L11;
        if (input.skipField(r2) == true) goto L3;
    L11:
        r1 = parseField(input, extensionRegistry, metadata.valueType, r1);
        goto L3
    L8:
        r0 = parseField(input, extensionRegistry, metadata.keyType, r0);
    L15:
        return new AbstractMap.SimpleImmutableEntry(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> map, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        int r0 = input.pushLimit(input.readRawVarint32());
        Object r1 = this.metadata.defaultKey;
        Object r2 = this.metadata.defaultValue;
    L3:
        int r3 = input.readTag();
        if (r3 == 0) goto L14;
        if (r3 == WireFormat.makeTag(1, this.metadata.keyType.getWireType())) goto L8;
        if (r3 == WireFormat.makeTag(2, this.metadata.valueType.getWireType())) goto L11;
        if (input.skipField(r3) == true) goto L3;
    L11:
        r2 = parseField(input, extensionRegistry, this.metadata.valueType, r2);
        goto L3
    L8:
        r1 = parseField(input, extensionRegistry, this.metadata.keyType, r1);
    L14:
        input.checkLastTagWas(0);
        input.popLimit(r0);
        map.put(r1, r2);
    }

    Metadata<K, V> getMetadata() {
        return this.metadata;
    }
}
