package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private static final FieldSet DEFAULT_INSTANCE = null;
    private final SmallSortedMap<T, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.FieldSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L81:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L97:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L105:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L109:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L69:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L71:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L89:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L91:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L111:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L115:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L73:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L79:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L95:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L101:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
        L119:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
        L67:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
        L83:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L57
        L29:
            int[] r9 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r9;
            r9[WireFormat.JavaType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L103:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L107:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L117:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L75:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L85:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L87:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L93:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L113:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this(SmallSortedMap.newFieldMap(16));
        }

        private Builder(SmallSortedMap<T, Object> fields) {
            this.fields = fields;
            this.isMutable = true;
        }

        public FieldSet<T> build() {
            return buildImpl(false);
        }

        public FieldSet<T> buildPartial() {
            return buildImpl(true);
        }

        private FieldSet<T> buildImpl(boolean partial) {
            if (this.fields.isEmpty() == true) goto L5;
            this.isMutable = false;
            SmallSortedMap<T, Object> r1 = this.fields;
            if (this.hasNestedBuilders == false) goto L9;
            r1 = FieldSet.access$100(r1, false);
            replaceBuilders(r1, partial);
        L9:
            FieldSet<T> r4 = new FieldSet(r1, null);
            FieldSet.access$302(r4, this.hasLazyField);
            return r4;
        L5:
            return FieldSet.emptySet();
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> fieldMap, boolean partial) {
            int r0 = 0;
        L4:
            if (r0 >= fieldMap.getNumArrayEntries()) goto L6;
            replaceBuilders(fieldMap.getArrayEntryAt(r0), partial);
            r0 = r0 + 1;
            goto L4
        L6:
            Iterator r2 = fieldMap.getOverflowEntries().iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            replaceBuilders((Map.Entry) r2.next(), partial);
            goto L8
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry, boolean partial) {
            entry.setValue(replaceBuilders(entry.getKey(), entry.getValue(), partial));
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T descriptor, Object value, boolean partial) {
            if (value != null) goto L5;
            return value;
        L5:
            if (descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L7;
            return value;
        L7:
            if (descriptor.isRepeated() == false) goto L23;
            if ((value instanceof List) == false) goto L21;
            List r3 = (List) value;
            int r0 = 0;
        L12:
            if (r0 >= r3.size()) goto L19;
            Object r1 = r3.get(r0);
            Object r2 = replaceBuilder(r1, partial);
            if (r2 == r1) goto L18;
            if (r3 != value) goto L17;
            r3 = new ArrayList(r3);
        L17:
            r3.set(r0, r2);
        L18:
            r0 = r0 + 1;
            goto L12
        L19:
            return r3;
        L21:
            throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + value.getClass());
        L23:
            return replaceBuilder(value, partial);
        }

        private static Object replaceBuilder(Object value, boolean partial) {
            if ((value instanceof MessageLite.Builder) == true) goto L5;
            return value;
        L5:
            MessageLite.Builder r1 = (MessageLite.Builder) value;
            if (partial == false) goto L10;
            return r1.buildPartial();
        L10:
            return r1.build();
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> r0 = new Builder(FieldSet.access$100(FieldSet.access$400(fieldSet), true));
            ((Builder) r0).hasLazyField = FieldSet.access$300(fieldSet);
            return r0;
        }

        public Map<T, Object> getAllFields() {
            if (this.hasLazyField == false) goto L9;
            SmallSortedMap r0 = FieldSet.access$100(this.fields, false);
            if (this.fields.isImmutable() == false) goto L7;
            r0.makeImmutable();
        L8:
            return r0;
        L7:
            replaceBuilders(r0, true);
            goto L8
        L9:
            boolean r1 = this.fields.isImmutable();
            SmallSortedMap<T, Object> r2 = this.fields;
            if (r1 == false) goto L13;
            return r2;
        L13:
            return Collections.unmodifiableMap(r2);
        }

        public boolean hasField(final T descriptor) {
            if (descriptor.isRepeated() == true) goto L10;
            if (this.fields.get(descriptor) == null) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public Object getField(final T descriptor) {
            return replaceBuilders(descriptor, getFieldAllowBuilders(descriptor), true);
        }

        Object getFieldAllowBuilders(final T descriptor) {
            Object r0 = this.fields.get(descriptor);
            if ((r0 instanceof LazyField) == true) goto L5;
            return r0;
        L5:
            return ((LazyField) r0).getValue();
        }

        private void ensureIsMutable() {
            if (this.isMutable == true) goto L6;
            this.fields = FieldSet.access$100(this.fields, true);
            this.isMutable = true;
            return;
        }

        public void setField(T r6, Object r7) {
            ensureIsMutable();
            boolean r1 = false;
            if (r6.isRepeated() == true) goto L5;
            verifyType(r6, r7);
        L22:
            if ((r7 instanceof LazyField) == false) goto L25;
            this.hasLazyField = true;
        L25:
            if (this.hasNestedBuilders == false) goto L27;
        L28:
            r1 = true;
        L29:
            this.hasNestedBuilders = r1;
            this.fields.put(r6, r7);
            return;
        L27:
            if ((r7 instanceof MessageLite.Builder) == false) goto L29;
        L5:
            if ((r7 instanceof List) == false) goto L19;
            ArrayList r0 = new ArrayList((List) r7);
            Iterator r8 = r0.iterator();
        L8:
            if (r8.hasNext() == false) goto L17;
            Object r3 = r8.next();
            verifyType(r6, r3);
            if (this.hasNestedBuilders == false) goto L12;
        L15:
            boolean r4 = true;
        L16:
            this.hasNestedBuilders = r4;
            goto L8
        L12:
            if ((r3 instanceof MessageLite.Builder) == true) goto L15;
            r4 = false;
            goto L16
        L17:
            r7 = r0;
            goto L22
        L19:
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }

        public void clearField(final T descriptor) {
            ensureIsMutable();
            this.fields.remove(descriptor);
            if (this.fields.isEmpty() == false) goto L6;
            this.hasLazyField = false;
            return;
        }

        public int getRepeatedFieldCount(final T descriptor) {
            if (descriptor.isRepeated() == false) goto L11;
            Object r1 = getFieldAllowBuilders(descriptor);
            if (r1 != null) goto L9;
            return 0;
        L9:
            return ((List) r1).size();
        L11:
            throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
        }

        public Object getRepeatedField(final T descriptor, final int index) {
            if (this.hasNestedBuilders == false) goto L6;
            ensureIsMutable();
        L6:
            return replaceBuilder(getRepeatedFieldAllowBuilders(descriptor, index), true);
        }

        Object getRepeatedFieldAllowBuilders(final T descriptor, final int index) {
            if (descriptor.isRepeated() == false) goto L11;
            Object r1 = getFieldAllowBuilders(descriptor);
            if (r1 == null) goto L9;
            return ((List) r1).get(index);
        L9:
            throw new IndexOutOfBoundsException();
        L11:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public void setRepeatedField(final T descriptor, final int index, final Object value) {
            ensureIsMutable();
            if (descriptor.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            this.hasNestedBuilders = r0;
            Object r1 = getFieldAllowBuilders(descriptor);
            if (r1 == null) goto L16;
            verifyType(descriptor, value);
            ((List) r1).set(index, value);
            return;
        L16:
            throw new IndexOutOfBoundsException();
        L7:
            if ((value instanceof MessageLite.Builder) == true) goto L10;
            r0 = false;
            goto L11
        L18:
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public void addRepeatedField(final T descriptor, final Object value) {
            ensureIsMutable();
            if (descriptor.isRepeated() == false) goto L18;
            if (this.hasNestedBuilders == false) goto L7;
        L10:
            boolean r0 = true;
        L11:
            this.hasNestedBuilders = r0;
            verifyType(descriptor, value);
            Object r1 = getFieldAllowBuilders(descriptor);
            if (r1 != null) goto L14;
            List r2 = new ArrayList();
            this.fields.put(descriptor, r2);
        L15:
            r2.add(value);
            return;
        L14:
            r2 = (List) r1;
            goto L15
        L7:
            if ((value instanceof MessageLite.Builder) == true) goto L10;
            r0 = false;
            goto L11
        L18:
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        private void verifyType(final T descriptor, final Object value) {
            if (FieldSet.access$500(descriptor.getLiteType(), value) == false) goto L5;
            return;
        L5:
            if (descriptor.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE) goto L10;
            if ((value instanceof MessageLite.Builder) == false) goto L10;
            return;
        L10:
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(descriptor.getNumber()), descriptor.getLiteType().getJavaType(), value.getClass().getName()}));
        }

        public boolean isInitialized() {
            int r1 = 0;
        L4:
            if (r1 >= this.fields.getNumArrayEntries()) goto L9;
            if (FieldSet.access$600(this.fields.getArrayEntryAt(r1)) == false) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L9:
            Iterator r3 = this.fields.getOverflowEntries().iterator();
        L11:
            if (r3.hasNext() == false) goto L15;
            if (FieldSet.access$600((Map.Entry) r3.next()) == true) goto L11;
            return false;
        L15:
            return true;
        }

        public void mergeFrom(final FieldSet<T> other) {
            ensureIsMutable();
            int r0 = 0;
        L4:
            if (r0 >= FieldSet.access$400(other).getNumArrayEntries()) goto L6;
            mergeFromField(FieldSet.access$400(other).getArrayEntryAt(r0));
            r0 = r0 + 1;
            goto L4
        L6:
            Iterator r3 = FieldSet.access$400(other).getOverflowEntries().iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            mergeFromField((Map.Entry) r3.next());
            goto L8
        }

        private void mergeFromField(final Map.Entry<T, Object> entry) {
            T r0 = entry.getKey();
            Object r4 = entry.getValue();
            if ((r4 instanceof LazyField) == false) goto L6;
            r4 = ((LazyField) r4).getValue();
        L6:
            if (r0.isRepeated() == false) goto L15;
            List r1 = (List) getFieldAllowBuilders(r0);
            if (r1 != null) goto L10;
            r1 = new ArrayList();
            this.fields.put(r0, r1);
        L10:
            Iterator r3 = ((List) r4).iterator();
        L12:
            if (r3.hasNext() == false) goto L29;
            r1.add(FieldSet.access$700(r3.next()));
            goto L12
        L29:
            return;
        L15:
            if (r0.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L23;
            Object r2 = getFieldAllowBuilders(r0);
            if (r2 != null) goto L20;
            this.fields.put(r0, FieldSet.access$700(r4));
            return;
        L20:
            if ((r2 instanceof MessageLite.Builder) == false) goto L22;
            r0.internalMergeFrom((MessageLite.Builder) r2, (MessageLite) r4);
            return;
        L22:
            MessageLite r5 = r0.internalMergeFrom(((MessageLite) r2).toBuilder(), (MessageLite) r4).build();
            this.fields.put(r0, r5);
            return;
        L23:
            this.fields.put(r0, FieldSet.access$700(r4));
        }
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from);

        boolean isPacked();

        boolean isRepeated();
    }

    /* synthetic */ FieldSet(SmallSortedMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ SmallSortedMap access$100(SmallSortedMap r0, boolean r1) {
        return cloneAllFieldsMap(r0, r1);
    }

    static /* synthetic */ boolean access$300(FieldSet r0) {
        return r0.hasLazyField;
    }

    static /* synthetic */ boolean access$302(FieldSet r0, boolean r1) {
        r0.hasLazyField = r1;
        return r1;
    }

    static /* synthetic */ SmallSortedMap access$400(FieldSet r0) {
        return r0.fields;
    }

    static /* synthetic */ boolean access$500(WireFormat.FieldType r0, Object r1) {
        return isValidType(r0, r1);
    }

    static /* synthetic */ boolean access$600(Map.Entry r0) {
        return isInitialized(r0);
    }

    static /* synthetic */ Object access$700(Object r0) {
        return cloneIfMutable(r0);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m953clone() throws CloneNotSupportedException {
        return clone();
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    private FieldSet(final boolean dummy) {
        this(SmallSortedMap.newFieldMap(0));
        makeImmutable();
    }

    private FieldSet(SmallSortedMap<T, Object> fields) {
        this.fields = fields;
        makeImmutable();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet();
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return DEFAULT_INSTANCE;
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder(null);
    }

    static {
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public void makeImmutable() {
        if (this.isImmutable == false) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.fields.getNumArrayEntries()) goto L12;
        Map.Entry<K, Object> r1 = this.fields.getArrayEntryAt(r0);
        if ((r1.getValue() instanceof GeneratedMessageLite) == false) goto L11;
        ((GeneratedMessageLite) r1.getValue()).makeImmutable();
    L11:
        r0 = r0 + 1;
        goto L7
    L12:
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof FieldSet) == true) goto L10;
        return false;
    L10:
        return this.fields.equals(((FieldSet) o).fields);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public FieldSet<T> clone() {
        FieldSet<T> r0 = newFieldSet();
        int r1 = 0;
    L4:
        if (r1 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r2 = this.fields.getArrayEntryAt(r1);
        r0.setField((FieldDescriptorLite) r2.getKey(), r2.getValue());
        r1 = r1 + 1;
        goto L4
    L6:
        Iterator r3 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.setField((FieldDescriptorLite) r4.getKey(), r4.getValue());
        goto L8
    L10:
        r0.hasLazyField = this.hasLazyField;
        return r0;
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public Map<T, Object> getAllFields() {
        if (this.hasLazyField == false) goto L8;
        SmallSortedMap r0 = cloneAllFieldsMap(this.fields, false);
        if (this.fields.isImmutable() == false) goto L7;
        r0.makeImmutable();
    L7:
        return r0;
    L8:
        boolean r1 = this.fields.isImmutable();
        SmallSortedMap<T, Object> r2 = this.fields;
        if (r1 == false) goto L12;
        return r2;
    L12:
        return Collections.unmodifiableMap(r2);
    }

    private static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> fields, boolean copyList) {
        SmallSortedMap<T, Object> r0 = SmallSortedMap.newFieldMap(16);
        int r1 = 0;
    L4:
        if (r1 >= fields.getNumArrayEntries()) goto L6;
        cloneFieldEntry(r0, fields.getArrayEntryAt(r1), copyList);
        r1 = r1 + 1;
        goto L4
    L6:
        Iterator r3 = fields.getOverflowEntries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        cloneFieldEntry(r0, (Map.Entry) r3.next(), copyList);
        goto L8
    L10:
        return r0;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean copyList) {
        T r0 = entry.getKey();
        Object r3 = entry.getValue();
        if ((r3 instanceof LazyField) == false) goto L5;
        map.put(r0, ((LazyField) r3).getValue());
        return;
    L5:
        if (copyList == true) goto L7;
    L9:
        map.put(r0, r3);
        return;
    L7:
        if ((r3 instanceof List) == false) goto L9;
        map.put(r0, new ArrayList((List) r3));
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (this.hasLazyField == false) goto L7;
        return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    L7:
        return this.fields.entrySet().iterator();
    }

    Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (this.hasLazyField == false) goto L7;
        return new LazyField.LazyIterator(this.fields.descendingEntrySet().iterator());
    L7:
        return this.fields.descendingEntrySet().iterator();
    }

    public boolean hasField(final T descriptor) {
        if (descriptor.isRepeated() == true) goto L10;
        if (this.fields.get(descriptor) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public Object getField(final T descriptor) {
        Object r0 = this.fields.get(descriptor);
        if ((r0 instanceof LazyField) == true) goto L5;
        return r0;
    L5:
        return ((LazyField) r0).getValue();
    }

    public void setField(T r3, Object r4) {
        if (r3.isRepeated() == true) goto L5;
        verifyType(r3, r4);
    L15:
        if ((r4 instanceof LazyField) == false) goto L17;
        this.hasLazyField = true;
    L17:
        this.fields.put(r3, r4);
        return;
    L5:
        if ((r4 instanceof List) == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.addAll((List) r4);
        Iterator r5 = r0.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        verifyType(r3, r5.next());
        goto L8
    L10:
        r4 = r0;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void clearField(final T descriptor) {
        this.fields.remove(descriptor);
        if (this.fields.isEmpty() == false) goto L6;
        this.hasLazyField = false;
        return;
    }

    public int getRepeatedFieldCount(final T descriptor) {
        if (descriptor.isRepeated() == false) goto L11;
        Object r1 = getField(descriptor);
        if (r1 != null) goto L9;
        return 0;
    L9:
        return ((List) r1).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public Object getRepeatedField(final T descriptor, final int index) {
        if (descriptor.isRepeated() == false) goto L11;
        Object r1 = getField(descriptor);
        if (r1 == null) goto L9;
        return ((List) r1).get(index);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void setRepeatedField(final T descriptor, final int index, final Object value) {
        if (descriptor.isRepeated() == false) goto L11;
        Object r0 = getField(descriptor);
        if (r0 == null) goto L9;
        verifyType(descriptor, value);
        ((List) r0).set(index, value);
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public void addRepeatedField(final T descriptor, final Object value) {
        if (descriptor.isRepeated() == false) goto L11;
        verifyType(descriptor, value);
        Object r0 = getField(descriptor);
        if (r0 != null) goto L7;
        List r1 = new ArrayList();
        this.fields.put(descriptor, r1);
    L8:
        r1.add(value);
        return;
    L7:
        r1 = (List) r0;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private void verifyType(final T descriptor, final Object value) {
        if (isValidType(descriptor.getLiteType(), value) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(descriptor.getNumber()), descriptor.getLiteType().getJavaType(), value.getClass().getName()}));
    }

    private static boolean isValidType(final WireFormat.FieldType type, final Object value) {
        Internal.checkNotNull(value);
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[type.getJavaType().ordinal()]) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L20;
            case 8: goto L13;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if ((value instanceof MessageLite) == false) goto L8;
        return true;
    L8:
        if ((value instanceof LazyField) == false) goto L11;
        return true;
    L11:
        return false;
    L13:
        if ((value instanceof Integer) == false) goto L15;
        return true;
    L15:
        if ((value instanceof Internal.EnumLite) == false) goto L18;
        return true;
    L18:
        return false;
    L20:
        if ((value instanceof ByteString) == false) goto L22;
        return true;
    L22:
        if ((value instanceof byte[]) == false) goto L25;
        return true;
    L25:
        return false;
    L27:
        return value instanceof String;
    L29:
        return value instanceof Boolean;
    L31:
        return value instanceof Double;
    L33:
        return value instanceof Float;
    L35:
        return value instanceof Long;
    L37:
        return value instanceof Integer;
    }

    public boolean isInitialized() {
        int r1 = 0;
    L4:
        if (r1 >= this.fields.getNumArrayEntries()) goto L9;
        if (isInitialized(this.fields.getArrayEntryAt(r1)) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r3 = this.fields.getOverflowEntries().iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        if (isInitialized((Map.Entry) r3.next()) == true) goto L11;
        return false;
    L15:
        return true;
    }

    private static <T extends FieldDescriptorLite<T>> boolean isInitialized(final Map.Entry<T, Object> entry) {
        T r0 = entry.getKey();
        if (r0.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
        return true;
    L5:
        if (r0.isRepeated() == false) goto L14;
        Iterator r3 = ((List) entry.getValue()).iterator();
    L8:
        if (r3.hasNext() == false) goto L20;
        if (isMessageFieldValueInitialized(r3.next()) == true) goto L8;
        return false;
    L20:
        return true;
    L14:
        return isMessageFieldValueInitialized(entry.getValue());
    }

    private static boolean isMessageFieldValueInitialized(Object value) {
        if ((value instanceof MessageLiteOrBuilder) == false) goto L7;
        return ((MessageLiteOrBuilder) value).isInitialized();
    L7:
        if ((value instanceof LazyField) == false) goto L11;
        return true;
    L11:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    static int getWireFormatForFieldType(final WireFormat.FieldType type, boolean isPacked) {
        if (isPacked == false) goto L6;
        return 2;
    L6:
        return type.getWireType();
    }

    public void mergeFrom(final FieldSet<T> other) {
        int r0 = 0;
    L4:
        if (r0 >= other.fields.getNumArrayEntries()) goto L6;
        mergeFromField(other.fields.getArrayEntryAt(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r3 = other.fields.getOverflowEntries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        mergeFromField((Map.Entry) r3.next());
        goto L8
    }

    private static Object cloneIfMutable(Object value) {
        if ((value instanceof byte[]) == false) goto L6;
        byte[] r3 = (byte[]) value;
        byte[] r0 = new byte[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    L6:
        return value;
    }

    private void mergeFromField(final Map.Entry<T, Object> entry) {
        T r0 = entry.getKey();
        Object r5 = entry.getValue();
        if ((r5 instanceof LazyField) == false) goto L6;
        r5 = ((LazyField) r5).getValue();
    L6:
        if (r0.isRepeated() == false) goto L16;
        Object r1 = getField(r0);
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        Iterator r6 = ((List) r5).iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        ((List) r1).add(cloneIfMutable(r6.next()));
        goto L12
    L14:
        this.fields.put(r0, r1);
        return;
    L16:
        if (r0.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L21;
        Object r2 = getField(r0);
        if (r2 != null) goto L20;
        this.fields.put(r0, cloneIfMutable(r5));
        return;
    L20:
        MessageLite r7 = r0.internalMergeFrom(((MessageLite) r2).toBuilder(), (MessageLite) r5).build();
        this.fields.put(r0, r7);
        return;
    L21:
        this.fields.put(r0, cloneIfMutable(r5));
    }

    public static Object readPrimitiveField(CodedInputStream input, final WireFormat.FieldType type, boolean checkUtf8) throws IOException {
        if (checkUtf8 == false) goto L6;
        return WireFormat.readPrimitiveField(input, type, WireFormat.Utf8Validation.STRICT);
    L6:
        return WireFormat.readPrimitiveField(input, type, WireFormat.Utf8Validation.LOOSE);
    }

    public void writeTo(final CodedOutputStream output) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r1 = this.fields.getArrayEntryAt(r0);
        writeField((FieldDescriptorLite) r1.getKey(), r1.getValue(), output);
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r3 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r3.next();
        writeField((FieldDescriptorLite) r2.getKey(), r2.getValue(), output);
        goto L8
    }

    public void writeMessageSetTo(final CodedOutputStream output) throws IOException {
        int r0 = 0;
    L4:
        if (r0 >= this.fields.getNumArrayEntries()) goto L6;
        writeMessageSetTo(this.fields.getArrayEntryAt(r0), output);
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r1 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        writeMessageSetTo((Map.Entry) r1.next(), output);
        goto L8
    }

    private void writeMessageSetTo(final Map.Entry<T, Object> entry, final CodedOutputStream output) throws IOException {
        T r2 = entry.getKey();
        if (r2.getLiteJavaType() == WireFormat.JavaType.MESSAGE) goto L5;
    L12:
        writeField(r2, entry.getValue(), output);
        return;
    L5:
        if (r2.isRepeated() == true) goto L12;
        if (r2.isPacked() == true) goto L12;
        Object r3 = entry.getValue();
        if ((r3 instanceof LazyField) == false) goto L11;
        ByteString r4 = ((LazyField) r3).toByteString();
        output.writeRawMessageSetExtension(entry.getKey().getNumber(), r4);
        return;
    L11:
        output.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) r3);
    }

    static void writeElement(final CodedOutputStream output, final WireFormat.FieldType type, final int number, final Object value) throws IOException {
        if (type != WireFormat.FieldType.GROUP) goto L5;
        output.writeGroup(number, (MessageLite) value);
        return;
    L5:
        output.writeTag(number, getWireFormatForFieldType(type, false));
        writeElementNoTag(output, type, value);
    }

    static void writeElementNoTag(final CodedOutputStream output, final WireFormat.FieldType type, final Object value) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L19;
            case 12: goto L15;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L6;
            default: goto L53;
        };
    L9:
        output.writeSInt64NoTag(((Long) value).longValue());
        return;
    L10:
        output.writeSInt32NoTag(((Integer) value).intValue());
        return;
    L11:
        output.writeSFixed64NoTag(((Long) value).longValue());
        return;
    L12:
        output.writeSFixed32NoTag(((Integer) value).intValue());
        return;
    L13:
        output.writeUInt32NoTag(((Integer) value).intValue());
        return;
    L22:
        output.writeMessageNoTag((MessageLite) value);
        return;
    L23:
        output.writeGroupNoTag((MessageLite) value);
        return;
    L24:
        output.writeBoolNoTag(((Boolean) value).booleanValue());
        return;
    L25:
        output.writeFixed32NoTag(((Integer) value).intValue());
        return;
    L26:
        output.writeFixed64NoTag(((Long) value).longValue());
        return;
    L27:
        output.writeInt32NoTag(((Integer) value).intValue());
        return;
    L28:
        output.writeUInt64NoTag(((Long) value).longValue());
        return;
    L29:
        output.writeInt64NoTag(((Long) value).longValue());
        return;
    L30:
        output.writeFloatNoTag(((Float) value).floatValue());
        return;
    L31:
        output.writeDoubleNoTag(((Double) value).doubleValue());
        return;
    L53:
        return;
    L6:
        if ((value instanceof Internal.EnumLite) == false) goto L8;
        output.writeEnumNoTag(((Internal.EnumLite) value).getNumber());
        return;
    L8:
        output.writeEnumNoTag(((Integer) value).intValue());
        return;
    L15:
        if ((value instanceof ByteString) == false) goto L17;
        output.writeBytesNoTag((ByteString) value);
        return;
    L17:
        output.writeByteArrayNoTag((byte[]) value);
        return;
    L19:
        if ((value instanceof ByteString) == false) goto L21;
        output.writeBytesNoTag((ByteString) value);
        return;
    L21:
        output.writeStringNoTag((String) value);
    }

    public static void writeField(final FieldDescriptorLite<?> descriptor, final Object value, final CodedOutputStream output) throws IOException {
        WireFormat.FieldType r0 = descriptor.getLiteType();
        int r1 = descriptor.getNumber();
        if (descriptor.isRepeated() == false) goto L22;
        List r4 = (List) value;
        if (descriptor.isPacked() == true) goto L7;
        Iterator r3 = r4.iterator();
    L19:
        if (r3.hasNext() == false) goto L31;
        writeElement(output, r0, r1, r3.next());
        goto L19
    L31:
        return;
    L7:
        if (r4.isEmpty() == false) goto L9;
        return;
    L9:
        output.writeTag(r1, 2);
        Iterator r5 = r4.iterator();
        int r2 = 0;
    L11:
        if (r5.hasNext() == false) goto L13;
        r2 = r2 + computeElementSizeNoTag(r0, r5.next());
        goto L11
    L13:
        output.writeUInt32NoTag(r2);
        Iterator r6 = r4.iterator();
    L15:
        if (r6.hasNext() == false) goto L30;
        writeElementNoTag(output, r0, r6.next());
        goto L15
    L30:
        return;
    L22:
        if ((value instanceof LazyField) == false) goto L24;
        writeElement(output, r0, r1, ((LazyField) value).getValue());
        return;
    L24:
        writeElement(output, r0, r1, value);
    }

    public int getSerializedSize() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.fields.getNumArrayEntries()) goto L6;
        Map.Entry<K, Object> r2 = this.fields.getArrayEntryAt(r0);
        r1 = r1 + computeFieldSize((FieldDescriptorLite) r2.getKey(), r2.getValue());
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r4 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) r4.next();
        r1 = r1 + computeFieldSize((FieldDescriptorLite) r3.getKey(), r3.getValue());
        goto L8
    L10:
        return r1;
    }

    public int getMessageSetSerializedSize() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.fields.getNumArrayEntries()) goto L6;
        r1 = r1 + getMessageSetSerializedSize(this.fields.getArrayEntryAt(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r2 = this.fields.getOverflowEntries().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r1 = r1 + getMessageSetSerializedSize((Map.Entry) r2.next());
        goto L8
    L10:
        return r1;
    }

    private int getMessageSetSerializedSize(final Map.Entry<T, Object> entry) {
        T r3 = entry.getKey();
        Object r0 = entry.getValue();
        if (r3.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L15;
        if (r3.isRepeated() == true) goto L15;
        if (r3.isPacked() == true) goto L15;
        if ((r0 instanceof LazyField) == false) goto L13;
        return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) r0);
    L13:
        return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) r0);
    L15:
        return computeFieldSize(r3, r0);
    }

    static int computeElementSize(final WireFormat.FieldType type, final int number, final Object value) {
        int r2 = CodedOutputStream.computeTagSize(number);
        if (type != WireFormat.FieldType.GROUP) goto L6;
        r2 = r2 * 2;
    L6:
        return r2 + computeElementSizeNoTag(type, value);
    }

    static int computeElementSizeNoTag(final WireFormat.FieldType type, final Object value) {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case 1: goto L57;
            case 2: goto L55;
            case 3: goto L53;
            case 4: goto L51;
            case 5: goto L49;
            case 6: goto L47;
            case 7: goto L45;
            case 8: goto L43;
            case 9: goto L41;
            case 10: goto L35;
            case 11: goto L29;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L17;
            case 16: goto L15;
            case 17: goto L13;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        if ((value instanceof Internal.EnumLite) == false) goto L11;
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) value).getNumber());
    L11:
        return CodedOutputStream.computeEnumSizeNoTag(((Integer) value).intValue());
    L13:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long) value).longValue());
    L15:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer) value).intValue());
    L17:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long) value).longValue());
    L19:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) value).intValue());
    L21:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer) value).intValue());
    L23:
        if ((value instanceof ByteString) == false) goto L27;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
    L27:
        return CodedOutputStream.computeByteArraySizeNoTag((byte[]) value);
    L29:
        if ((value instanceof ByteString) == false) goto L33;
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
    L33:
        return CodedOutputStream.computeStringSizeNoTag((String) value);
    L35:
        if ((value instanceof LazyField) == false) goto L39;
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) value);
    L39:
        return CodedOutputStream.computeMessageSizeNoTag((MessageLite) value);
    L41:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite) value);
    L43:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean) value).booleanValue());
    L45:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer) value).intValue());
    L47:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long) value).longValue());
    L49:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer) value).intValue());
    L51:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long) value).longValue());
    L53:
        return CodedOutputStream.computeInt64SizeNoTag(((Long) value).longValue());
    L55:
        return CodedOutputStream.computeFloatSizeNoTag(((Float) value).floatValue());
    L57:
        return CodedOutputStream.computeDoubleSizeNoTag(((Double) value).doubleValue());
    }

    public static int computeFieldSize(final FieldDescriptorLite<?> descriptor, final Object value) {
        WireFormat.FieldType r0 = descriptor.getLiteType();
        int r1 = descriptor.getNumber();
        if (descriptor.isRepeated() == false) goto L21;
        List r4 = (List) value;
        int r2 = 0;
        if (descriptor.isPacked() == true) goto L7;
        Iterator r3 = r4.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        r2 = r2 + computeElementSize(r0, r1, r3.next());
        goto L17
    L19:
        return r2;
    L7:
        if (r4.isEmpty() == false) goto L9;
        return 0;
    L9:
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L14;
        r2 = r2 + computeElementSizeNoTag(r0, r5.next());
        goto L11
    L14:
        return (CodedOutputStream.computeTagSize(r1) + r2) + CodedOutputStream.computeUInt32SizeNoTag(r2);
    L21:
        return computeElementSize(r0, r1, value);
    }
}
