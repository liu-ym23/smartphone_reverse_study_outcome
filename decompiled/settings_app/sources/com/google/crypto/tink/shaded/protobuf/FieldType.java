package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final enum FieldType extends java.lang.Enum<FieldType> {
    private static final /* synthetic */ FieldType[] $VALUES = null;
    public static final FieldType BOOL = null;
    public static final FieldType BOOL_LIST = null;
    public static final FieldType BOOL_LIST_PACKED = null;
    public static final FieldType BYTES = null;
    public static final FieldType BYTES_LIST = null;
    public static final FieldType DOUBLE = null;
    public static final FieldType DOUBLE_LIST = null;
    public static final FieldType DOUBLE_LIST_PACKED = null;
    private static final java.lang.reflect.Type[] EMPTY_TYPES = null;
    public static final FieldType ENUM = null;
    public static final FieldType ENUM_LIST = null;
    public static final FieldType ENUM_LIST_PACKED = null;
    public static final FieldType FIXED32 = null;
    public static final FieldType FIXED32_LIST = null;
    public static final FieldType FIXED32_LIST_PACKED = null;
    public static final FieldType FIXED64 = null;
    public static final FieldType FIXED64_LIST = null;
    public static final FieldType FIXED64_LIST_PACKED = null;
    public static final FieldType FLOAT = null;
    public static final FieldType FLOAT_LIST = null;
    public static final FieldType FLOAT_LIST_PACKED = null;
    public static final FieldType GROUP = null;
    public static final FieldType GROUP_LIST = null;
    public static final FieldType INT32 = null;
    public static final FieldType INT32_LIST = null;
    public static final FieldType INT32_LIST_PACKED = null;
    public static final FieldType INT64 = null;
    public static final FieldType INT64_LIST = null;
    public static final FieldType INT64_LIST_PACKED = null;
    public static final FieldType MAP = null;
    public static final FieldType MESSAGE = null;
    public static final FieldType MESSAGE_LIST = null;
    public static final FieldType SFIXED32 = null;
    public static final FieldType SFIXED32_LIST = null;
    public static final FieldType SFIXED32_LIST_PACKED = null;
    public static final FieldType SFIXED64 = null;
    public static final FieldType SFIXED64_LIST = null;
    public static final FieldType SFIXED64_LIST_PACKED = null;
    public static final FieldType SINT32 = null;
    public static final FieldType SINT32_LIST = null;
    public static final FieldType SINT32_LIST_PACKED = null;
    public static final FieldType SINT64 = null;
    public static final FieldType SINT64_LIST = null;
    public static final FieldType SINT64_LIST_PACKED = null;
    public static final FieldType STRING = null;
    public static final FieldType STRING_LIST = null;
    public static final FieldType UINT32 = null;
    public static final FieldType UINT32_LIST = null;
    public static final FieldType UINT32_LIST_PACKED = null;
    public static final FieldType UINT64 = null;
    public static final FieldType UINT64_LIST = null;
    public static final FieldType UINT64_LIST_PACKED = null;
    private static final FieldType[] VALUES = null;
    private final Collection collection;
    private final Class<?> elementType;
    private final int id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.FieldType$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType$Collection = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = null;

        static {
            int[] r0 = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType = r0;
            r0[JavaType.BYTE_STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r3 = new int[Collection.values().length];
            $SwitchMap$com$google$protobuf$FieldType$Collection = r3;
            r3[Collection.MAP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$google$protobuf$FieldType$Collection[Collection.VECTOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$google$protobuf$FieldType$Collection[Collection.SCALAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    static final enum Collection extends java.lang.Enum<Collection> {
        private static final /* synthetic */ Collection[] $VALUES = null;
        public static final Collection MAP = null;
        public static final Collection PACKED_VECTOR = null;
        public static final Collection SCALAR = null;
        public static final Collection VECTOR = null;
        private final boolean isList;

        public static Collection valueOf(String name) {
            return (Collection) java.lang.Enum.valueOf(Collection.class, name);
        }

        public static Collection[] values() {
            return (Collection[]) $VALUES.clone();
        }

        static {
            Collection r0 = new Collection("SCALAR", 0, false);
            SCALAR = r0;
            Collection r1 = new Collection("VECTOR", 1, true);
            VECTOR = r1;
            Collection r3 = new Collection("PACKED_VECTOR", 2, true);
            PACKED_VECTOR = r3;
            Collection r5 = new Collection("MAP", 3, false);
            MAP = r5;
            $VALUES = new Collection[]{r0, r1, r3, r5};
        }

        private Collection(String $enum$name, int $enum$ordinal, boolean isList) {
            super($enum$name, $enum$ordinal);
            this.isList = isList;
        }

        public boolean isList() {
            return this.isList;
        }
    }

    public static FieldType valueOf(String name) {
        return (FieldType) java.lang.Enum.valueOf(FieldType.class, name);
    }

    public static FieldType[] values() {
        return (FieldType[]) $VALUES.clone();
    }

    static {
        FieldType r6 = new FieldType("DOUBLE", 0, 0, Collection.SCALAR, JavaType.DOUBLE);
        DOUBLE = r6;
        FieldType r0 = new FieldType("FLOAT", 1, 1, Collection.SCALAR, JavaType.FLOAT);
        FLOAT = r0;
        FieldType r1 = new FieldType("INT64", 2, 2, Collection.SCALAR, JavaType.LONG);
        INT64 = r1;
        FieldType r2 = new FieldType("UINT64", 3, 3, Collection.SCALAR, JavaType.LONG);
        UINT64 = r2;
        FieldType r3 = new FieldType("INT32", 4, 4, Collection.SCALAR, JavaType.INT);
        INT32 = r3;
        FieldType r4 = new FieldType("FIXED64", 5, 5, Collection.SCALAR, JavaType.LONG);
        FIXED64 = r4;
        FieldType r5 = new FieldType("FIXED32", 6, 6, Collection.SCALAR, JavaType.INT);
        FIXED32 = r5;
        FieldType r13 = new FieldType("BOOL", 7, 7, Collection.SCALAR, JavaType.BOOLEAN);
        BOOL = r13;
        FieldType r7 = new FieldType("STRING", 8, 8, Collection.SCALAR, JavaType.STRING);
        STRING = r7;
        FieldType r8 = new FieldType("MESSAGE", 9, 9, Collection.SCALAR, JavaType.MESSAGE);
        MESSAGE = r8;
        FieldType r9 = new FieldType("BYTES", 10, 10, Collection.SCALAR, JavaType.BYTE_STRING);
        BYTES = r9;
        FieldType r10 = new FieldType("UINT32", 11, 11, Collection.SCALAR, JavaType.INT);
        UINT32 = r10;
        FieldType r11 = new FieldType("ENUM", 12, 12, Collection.SCALAR, JavaType.ENUM);
        ENUM = r11;
        FieldType r12 = new FieldType("SFIXED32", 13, 13, Collection.SCALAR, JavaType.INT);
        SFIXED32 = r12;
        FieldType r20 = new FieldType("SFIXED64", 14, 14, Collection.SCALAR, JavaType.LONG);
        SFIXED64 = r20;
        FieldType r14 = new FieldType("SINT32", 15, 15, Collection.SCALAR, JavaType.INT);
        SINT32 = r14;
        FieldType r15 = new FieldType("SINT64", 16, 16, Collection.SCALAR, JavaType.LONG);
        SINT64 = r15;
        FieldType r16 = new FieldType("GROUP", 17, 17, Collection.SCALAR, JavaType.MESSAGE);
        GROUP = r16;
        FieldType r17 = new FieldType("DOUBLE_LIST", 18, 18, Collection.VECTOR, JavaType.DOUBLE);
        DOUBLE_LIST = r17;
        FieldType r18 = new FieldType("FLOAT_LIST", 19, 19, Collection.VECTOR, JavaType.FLOAT);
        FLOAT_LIST = r18;
        FieldType r19 = new FieldType("INT64_LIST", 20, 20, Collection.VECTOR, JavaType.LONG);
        INT64_LIST = r19;
        FieldType r27 = new FieldType("UINT64_LIST", 21, 21, Collection.VECTOR, JavaType.LONG);
        UINT64_LIST = r27;
        FieldType r21 = new FieldType("INT32_LIST", 22, 22, Collection.VECTOR, JavaType.INT);
        INT32_LIST = r21;
        FieldType r22 = new FieldType("FIXED64_LIST", 23, 23, Collection.VECTOR, JavaType.LONG);
        FIXED64_LIST = r22;
        FieldType r23 = new FieldType("FIXED32_LIST", 24, 24, Collection.VECTOR, JavaType.INT);
        FIXED32_LIST = r23;
        FieldType r24 = new FieldType("BOOL_LIST", 25, 25, Collection.VECTOR, JavaType.BOOLEAN);
        BOOL_LIST = r24;
        FieldType r25 = new FieldType("STRING_LIST", 26, 26, Collection.VECTOR, JavaType.STRING);
        STRING_LIST = r25;
        FieldType r26 = new FieldType("MESSAGE_LIST", 27, 27, Collection.VECTOR, JavaType.MESSAGE);
        MESSAGE_LIST = r26;
        FieldType r34 = new FieldType("BYTES_LIST", 28, 28, Collection.VECTOR, JavaType.BYTE_STRING);
        BYTES_LIST = r34;
        FieldType r28 = new FieldType("UINT32_LIST", 29, 29, Collection.VECTOR, JavaType.INT);
        UINT32_LIST = r28;
        FieldType r29 = new FieldType("ENUM_LIST", 30, 30, Collection.VECTOR, JavaType.ENUM);
        ENUM_LIST = r29;
        FieldType r30 = new FieldType("SFIXED32_LIST", 31, 31, Collection.VECTOR, JavaType.INT);
        SFIXED32_LIST = r30;
        FieldType r31 = new FieldType("SFIXED64_LIST", 32, 32, Collection.VECTOR, JavaType.LONG);
        SFIXED64_LIST = r31;
        FieldType r32 = new FieldType("SINT32_LIST", 33, 33, Collection.VECTOR, JavaType.INT);
        SINT32_LIST = r32;
        FieldType r33 = new FieldType("SINT64_LIST", 34, 34, Collection.VECTOR, JavaType.LONG);
        SINT64_LIST = r33;
        FieldType r41 = new FieldType("DOUBLE_LIST_PACKED", 35, 35, Collection.PACKED_VECTOR, JavaType.DOUBLE);
        DOUBLE_LIST_PACKED = r41;
        FieldType r35 = new FieldType("FLOAT_LIST_PACKED", 36, 36, Collection.PACKED_VECTOR, JavaType.FLOAT);
        FLOAT_LIST_PACKED = r35;
        FieldType r36 = new FieldType("INT64_LIST_PACKED", 37, 37, Collection.PACKED_VECTOR, JavaType.LONG);
        INT64_LIST_PACKED = r36;
        FieldType r37 = new FieldType("UINT64_LIST_PACKED", 38, 38, Collection.PACKED_VECTOR, JavaType.LONG);
        UINT64_LIST_PACKED = r37;
        FieldType r38 = new FieldType("INT32_LIST_PACKED", 39, 39, Collection.PACKED_VECTOR, JavaType.INT);
        INT32_LIST_PACKED = r38;
        FieldType r39 = new FieldType("FIXED64_LIST_PACKED", 40, 40, Collection.PACKED_VECTOR, JavaType.LONG);
        FIXED64_LIST_PACKED = r39;
        FieldType r40 = new FieldType("FIXED32_LIST_PACKED", 41, 41, Collection.PACKED_VECTOR, JavaType.INT);
        FIXED32_LIST_PACKED = r40;
        FieldType r48 = new FieldType("BOOL_LIST_PACKED", 42, 42, Collection.PACKED_VECTOR, JavaType.BOOLEAN);
        BOOL_LIST_PACKED = r48;
        FieldType r42 = new FieldType("UINT32_LIST_PACKED", 43, 43, Collection.PACKED_VECTOR, JavaType.INT);
        UINT32_LIST_PACKED = r42;
        FieldType r43 = new FieldType("ENUM_LIST_PACKED", 44, 44, Collection.PACKED_VECTOR, JavaType.ENUM);
        ENUM_LIST_PACKED = r43;
        FieldType r44 = new FieldType("SFIXED32_LIST_PACKED", 45, 45, Collection.PACKED_VECTOR, JavaType.INT);
        SFIXED32_LIST_PACKED = r44;
        FieldType r45 = new FieldType("SFIXED64_LIST_PACKED", 46, 46, Collection.PACKED_VECTOR, JavaType.LONG);
        SFIXED64_LIST_PACKED = r45;
        FieldType r46 = new FieldType("SINT32_LIST_PACKED", 47, 47, Collection.PACKED_VECTOR, JavaType.INT);
        SINT32_LIST_PACKED = r46;
        FieldType r47 = new FieldType("SINT64_LIST_PACKED", 48, 48, Collection.PACKED_VECTOR, JavaType.LONG);
        SINT64_LIST_PACKED = r47;
        FieldType r55 = new FieldType("GROUP_LIST", 49, 49, Collection.VECTOR, JavaType.MESSAGE);
        GROUP_LIST = r55;
        FieldType r49 = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.VOID);
        MAP = r49;
        int r110 = 0;
        $VALUES = new FieldType[]{r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, r11, r12, r20, r14, r15, r16, r17, r18, r19, r27, r21, r22, r23, r24, r25, r26, r34, r28, r29, r30, r31, r32, r33, r41, r35, r36, r37, r38, r39, r40, r48, r42, r43, r44, r45, r46, r47, r55, r49};
        EMPTY_TYPES = new java.lang.reflect.Type[0];
        FieldType[] r50 = values();
        VALUES = new FieldType[r50.length];
        int r51 = r50.length;
    L3:
        if (r110 >= r51) goto L5;
        FieldType r52 = r50[r110];
        VALUES[r52.id] = r52;
        r110 = r110 + 1;
        goto L3
    }

    private FieldType(String $enum$name, int $enum$ordinal, int id, Collection collection, JavaType javaType) {
        super($enum$name, $enum$ordinal);
        this.id = id;
        this.collection = collection;
        this.javaType = javaType;
        int r1 = AnonymousClass1.$SwitchMap$com$google$protobuf$FieldType$Collection[collection.ordinal()];
        boolean r3 = true;
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L6;
        this.elementType = null;
    L9:
        if (collection != Collection.SCALAR) goto L16;
        int r2 = AnonymousClass1.$SwitchMap$com$google$protobuf$JavaType[javaType.ordinal()];
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L16;
    L17:
        this.primitiveScalar = r3;
        return;
    L16:
        r3 = false;
        goto L17
    L6:
        this.elementType = javaType.getBoxedType();
        goto L9
    L7:
        this.elementType = javaType.getBoxedType();
        goto L9
    }

    public int id() {
        return this.id;
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        if (this.collection != Collection.SCALAR) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        if (this.collection != Collection.MAP) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidForField(java.lang.reflect.Field field) {
        if (Collection.VECTOR.equals(this.collection) == false) goto L7;
        return isValidForList(field);
    L7:
        return this.javaType.getType().isAssignableFrom(field.getType());
    }

    private boolean isValidForList(java.lang.reflect.Field field) {
        Class<?> r0 = field.getType();
        if (this.javaType.getType().isAssignableFrom(r0) == true) goto L6;
        return false;
    L6:
        java.lang.reflect.Type[] r1 = EMPTY_TYPES;
        if ((field.getGenericType() instanceof ParameterizedType) == false) goto L9;
        r1 = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
    L9:
        java.lang.reflect.Type r4 = getListParameter(r0, r1);
        if ((r4 instanceof Class) == true) goto L14;
        return true;
    L14:
        return this.elementType.isAssignableFrom((Class) r4);
    }

    public static FieldType forId(int id) {
        if (id < 0) goto L8;
        FieldType[] r0 = VALUES;
        if (id < r0.length) goto L7;
        return null;
    L7:
        return r0[id];
    L8:
        return null;
    }

    private static java.lang.reflect.Type getGenericSuperList(Class<?> clazz) {
        java.lang.reflect.Type[] r0 = clazz.getGenericInterfaces();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        java.lang.reflect.Type r3 = r0[r2];
        if ((r3 instanceof ParameterizedType) == false) goto L9;
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) r3).getRawType()) == false) goto L9;
        return r3;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        java.lang.reflect.Type r6 = clazz.getGenericSuperclass();
        if ((r6 instanceof ParameterizedType) == true) goto L13;
        return null;
    L13:
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) r6).getRawType()) == false) goto L21;
        return r6;
    L21:
        return null;
    }

    private static java.lang.reflect.Type getListParameter(Class<?> clazz, java.lang.reflect.Type[] realTypes) {
    L2:
        int r1 = 0;
        if (clazz == List.class) goto L37;
        java.lang.reflect.Type r0 = getGenericSuperList(clazz);
        if ((r0 instanceof ParameterizedType) == true) goto L6;
        realTypes = EMPTY_TYPES;
        Class<?>[] r2 = clazz.getInterfaces();
        int r3 = r2.length;
    L30:
        if (r1 >= r3) goto L35;
        Class<?> r4 = r2[r1];
        if (List.class.isAssignableFrom(r4) == true) goto L33;
        r1 = r1 + 1;
        goto L30
    L33:
        clazz = r4;
        goto L2
    L35:
        clazz = clazz.getSuperclass();
        goto L2
    L6:
        ParameterizedType r5 = (ParameterizedType) r0;
        java.lang.reflect.Type[] r6 = r5.getActualTypeArguments();
        int r7 = 0;
    L8:
        if (r7 >= r6.length) goto L28;
        java.lang.reflect.Type r8 = r6[r7];
        if ((r8 instanceof TypeVariable) == false) goto L27;
        TypeVariable<Class<?>>[] r9 = clazz.getTypeParameters();
        if (realTypes.length != r9.length) goto L26;
        int r10 = 0;
    L15:
        if (r10 >= r9.length) goto L20;
        if (r8 == r9[r10]) goto L18;
        r10 = r10 + 1;
        goto L15
    L18:
        r6[r7] = realTypes[r10];
        boolean r11 = true;
    L21:
        if (r11 == true) goto L27;
        throw new RuntimeException("Unable to find replacement for " + r8);
    L20:
        r11 = false;
        goto L21
    L26:
        throw new RuntimeException("Type array mismatch");
    L27:
        r7 = r7 + 1;
        goto L8
    L28:
        clazz = (Class) r5.getRawType();
        realTypes = r6;
        goto L2
    L37:
        if (realTypes.length != 1) goto L41;
        return realTypes[0];
    L41:
        throw new RuntimeException("Unable to identify parameter type for List<T>");
    }
}
