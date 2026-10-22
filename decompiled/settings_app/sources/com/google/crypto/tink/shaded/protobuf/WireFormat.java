package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class WireFormat {
    static final int FIXED32_SIZE = 4;
    static final int FIXED64_SIZE = 8;
    static final int MAX_VARINT32_SIZE = 5;
    static final int MAX_VARINT64_SIZE = 10;
    static final int MAX_VARINT_SIZE = 10;
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.WireFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public static enum FieldType extends java.lang.Enum<FieldType> {
        private static final /* synthetic */ FieldType[] $VALUES = null;
        public static final FieldType BOOL = null;
        public static final FieldType BYTES = null;
        public static final FieldType DOUBLE = null;
        public static final FieldType ENUM = null;
        public static final FieldType FIXED32 = null;
        public static final FieldType FIXED64 = null;
        public static final FieldType FLOAT = null;
        public static final FieldType GROUP = null;
        public static final FieldType INT32 = null;
        public static final FieldType INT64 = null;
        public static final FieldType MESSAGE = null;
        public static final FieldType SFIXED32 = null;
        public static final FieldType SFIXED64 = null;
        public static final FieldType SINT32 = null;
        public static final FieldType SINT64 = null;
        public static final FieldType STRING = null;
        public static final FieldType UINT32 = null;
        public static final FieldType UINT64 = null;
        private final JavaType javaType;
        private final int wireType;

        public boolean isPackable() {
            return true;
        }

        /* synthetic */ FieldType(String r1, int r2, JavaType r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        public static FieldType valueOf(String name) {
            return (FieldType) java.lang.Enum.valueOf(FieldType.class, name);
        }

        public static FieldType[] values() {
            return (FieldType[]) $VALUES.clone();
        }

        static {
            FieldType r0 = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = r0;
            FieldType r1 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = r1;
            final int r8 = 2;
            FieldType r2 = new FieldType("INT64", 2, JavaType.LONG, 0);
            INT64 = r2;
            final int r10 = 3;
            FieldType r5 = new FieldType("UINT64", 3, JavaType.LONG, 0);
            UINT64 = r5;
            FieldType r7 = new FieldType("INT32", 4, JavaType.INT, 0);
            INT32 = r7;
            FieldType r9 = new FieldType("FIXED64", 5, JavaType.LONG, 1);
            FIXED64 = r9;
            FieldType r11 = new FieldType("FIXED32", 6, JavaType.INT, 5);
            FIXED32 = r11;
            FieldType r13 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = r13;
            final JavaType r15 = JavaType.STRING;
            final String r12 = "STRING";
            final int r4 = 8;
            FieldType r14 = new AnonymousClass1(r12, r4, r15, r8);
            STRING = r14;
            final JavaType r16 = JavaType.MESSAGE;
            final String r6 = "GROUP";
            final int r17 = 9;
            FieldType r18 = new AnonymousClass2(r6, r17, r16, r10);
            GROUP = r18;
            final JavaType r19 = JavaType.MESSAGE;
            final String r20 = "MESSAGE";
            final int r110 = 10;
            FieldType r21 = new AnonymousClass3(r20, r110, r19, r8);
            MESSAGE = r21;
            final JavaType r111 = JavaType.BYTE_STRING;
            final String r112 = "BYTES";
            final int r3 = 11;
            FieldType r22 = new AnonymousClass4(r112, r3, r111, r8);
            BYTES = r22;
            FieldType r113 = new FieldType("UINT32", 12, JavaType.INT, 0);
            UINT32 = r113;
            FieldType r23 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = r23;
            FieldType r24 = new FieldType("SFIXED32", 14, JavaType.INT, 5);
            SFIXED32 = r24;
            FieldType r25 = new FieldType("SFIXED64", 15, JavaType.LONG, 1);
            SFIXED64 = r25;
            FieldType r26 = new FieldType("SINT32", 16, JavaType.INT, 0);
            SINT32 = r26;
            FieldType r27 = new FieldType("SINT64", 17, JavaType.LONG, 0);
            SINT64 = r27;
            $VALUES = new FieldType[]{r0, r1, r2, r5, r7, r9, r11, r13, r14, r18, r21, r22, r113, r23, r24, r25, r26, r27};
        }

        private FieldType(String $enum$name, int $enum$ordinal, final JavaType javaType, final int wireType) {
            super($enum$name, $enum$ordinal);
            this.javaType = javaType;
            this.wireType = wireType;
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }
    }

    public static final enum JavaType extends java.lang.Enum<JavaType> {
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
        private final Object defaultDefault;

        public static JavaType valueOf(String name) {
            return (JavaType) java.lang.Enum.valueOf(JavaType.class, name);
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }

        static {
            JavaType r0 = new JavaType("INT", 0, 0);
            INT = r0;
            JavaType r2 = new JavaType("LONG", 1, 0L);
            LONG = r2;
            JavaType r3 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            FLOAT = r3;
            JavaType r4 = new JavaType("DOUBLE", 3, Double.valueOf(0.0d));
            DOUBLE = r4;
            JavaType r6 = new JavaType("BOOLEAN", 4, false);
            BOOLEAN = r6;
            JavaType r8 = new JavaType("STRING", 5, "");
            STRING = r8;
            JavaType r10 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            BYTE_STRING = r10;
            JavaType r12 = new JavaType("ENUM", 7, null);
            ENUM = r12;
            JavaType r14 = new JavaType("MESSAGE", 8, null);
            MESSAGE = r14;
            $VALUES = new JavaType[]{r0, r2, r3, r4, r6, r8, r10, r12, r14};
        }

        private JavaType(String $enum$name, int $enum$ordinal, final Object defaultDefault) {
            super($enum$name, $enum$ordinal);
            this.defaultDefault = defaultDefault;
        }

        Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    static abstract enum Utf8Validation extends java.lang.Enum<Utf8Validation> {
        private static final /* synthetic */ Utf8Validation[] $VALUES = null;
        public static final Utf8Validation LAZY = null;
        public static final Utf8Validation LOOSE = null;
        public static final Utf8Validation STRICT = null;

        abstract Object readString(CodedInputStream input) throws IOException;

        private Utf8Validation(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        /* synthetic */ Utf8Validation(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static Utf8Validation valueOf(String name) {
            return (Utf8Validation) java.lang.Enum.valueOf(Utf8Validation.class, name);
        }

        public static Utf8Validation[] values() {
            return (Utf8Validation[]) $VALUES.clone();
        }

        static {
            final String r1 = "LOOSE";
            final int r2 = 0;
            Utf8Validation r0 = new AnonymousClass1(r1, r2);
            LOOSE = r0;
            final String r3 = "STRICT";
            final int r4 = 1;
            Utf8Validation r5 = new AnonymousClass2(r3, r4);
            STRICT = r5;
            final String r6 = "LAZY";
            final int r7 = 2;
            Utf8Validation r8 = new AnonymousClass3(r6, r7);
            LAZY = r8;
            $VALUES = new Utf8Validation[]{r0, r5, r8};
        }
    }

    public static int getTagFieldNumber(final int tag) {
        return tag >>> 3;
    }

    public static int getTagWireType(final int tag) {
        return tag & 7;
    }

    static int makeTag(final int fieldNumber, final int wireType) {
        return (fieldNumber << 3) | wireType;
    }

    private WireFormat() {
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    static Object readPrimitiveField(CodedInputStream input, FieldType type, Utf8Validation utf8Validation) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[type.ordinal()]) {
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return utf8Validation.readString(input);
    L15:
        return Long.valueOf(input.readSInt64());
    L17:
        return Integer.valueOf(input.readSInt32());
    L19:
        return Long.valueOf(input.readSFixed64());
    L21:
        return Integer.valueOf(input.readSFixed32());
    L23:
        return Integer.valueOf(input.readUInt32());
    L25:
        return input.readBytes();
    L27:
        return Boolean.valueOf(input.readBool());
    L29:
        return Integer.valueOf(input.readFixed32());
    L31:
        return Long.valueOf(input.readFixed64());
    L33:
        return Integer.valueOf(input.readInt32());
    L35:
        return Long.valueOf(input.readUInt64());
    L37:
        return Long.valueOf(input.readInt64());
    L39:
        return Float.valueOf(input.readFloat());
    L41:
        return Double.valueOf(input.readDouble());
    }
}
