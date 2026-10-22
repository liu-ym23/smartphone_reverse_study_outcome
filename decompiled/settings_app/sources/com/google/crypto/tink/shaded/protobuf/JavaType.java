package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes4.dex */
public final enum JavaType extends java.lang.Enum<JavaType> {
    private static final /* synthetic */ JavaType[] $VALUES = null;
    public static final JavaType BOOLEAN = null;
    public static final JavaType BYTE_STRING = null;
    public static final JavaType DOUBLE = null;
    public static final JavaType ENUM = null;
    public static final JavaType FLOAT = null;
    public static final JavaType INT = null;
    public static final JavaType LONG = null;
    public static final JavaType MESSAGE = null;
    public static final JavaType STRING = null;
    public static final JavaType VOID = null;
    private final Class<?> boxedType;
    private final Object defaultDefault;
    private final Class<?> type;

    public static JavaType valueOf(String name) {
        return (JavaType) java.lang.Enum.valueOf(JavaType.class, name);
    }

    public static JavaType[] values() {
        return (JavaType[]) $VALUES.clone();
    }

    static {
        JavaType r6 = new JavaType("VOID", 0, Void.class, Void.class, null);
        VOID = r6;
        JavaType r0 = new JavaType("INT", 1, Integer.TYPE, Integer.class, 0);
        INT = r0;
        JavaType r2 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        LONG = r2;
        JavaType r3 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        FLOAT = r3;
        JavaType r4 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        DOUBLE = r4;
        JavaType r5 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, false);
        BOOLEAN = r5;
        JavaType r7 = new JavaType("STRING", 6, String.class, String.class, "");
        STRING = r7;
        JavaType r14 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.EMPTY);
        BYTE_STRING = r14;
        JavaType r8 = new JavaType("ENUM", 8, Integer.TYPE, Integer.class, null);
        ENUM = r8;
        JavaType r9 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        MESSAGE = r9;
        $VALUES = new JavaType[]{r6, r0, r2, r3, r4, r5, r7, r14, r8, r9};
    }

    private JavaType(String $enum$name, int $enum$ordinal, Class type, Class boxedType, Object defaultDefault) {
        super($enum$name, $enum$ordinal);
        this.type = type;
        this.boxedType = boxedType;
        this.defaultDefault = defaultDefault;
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    public Class<?> getType() {
        return this.type;
    }

    public Class<?> getBoxedType() {
        return this.boxedType;
    }

    public boolean isValidType(Class<?> t) {
        return this.type.isAssignableFrom(t);
    }
}
