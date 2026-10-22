package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Field extends GeneratedMessageLite<Field, Builder> implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final Field DEFAULT_INSTANCE = null;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;
    private static volatile Parser<Field> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;
    private String defaultValue_;
    private String jsonName_;
    private int kind_;
    private String name_;
    private int number_;
    private int oneofIndex_;
    private Internal.ProtobufList<Option> options_;
    private boolean packed_;
    private String typeUrl_;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.Field$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = null;

        static {
            int[] r0 = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0;
            r0[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Field.access$000());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public int getKindValue() {
            return ((Field) this.instance).getKindValue();
        }

        public Builder setKindValue(int value) {
            copyOnWrite();
            Field.access$100((Field) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public Kind getKind() {
            return ((Field) this.instance).getKind();
        }

        public Builder setKind(Kind value) {
            copyOnWrite();
            Field.access$200((Field) this.instance, value);
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            Field.access$300((Field) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return ((Field) this.instance).getCardinalityValue();
        }

        public Builder setCardinalityValue(int value) {
            copyOnWrite();
            Field.access$400((Field) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public Cardinality getCardinality() {
            return ((Field) this.instance).getCardinality();
        }

        public Builder setCardinality(Cardinality value) {
            copyOnWrite();
            Field.access$500((Field) this.instance, value);
            return this;
        }

        public Builder clearCardinality() {
            copyOnWrite();
            Field.access$600((Field) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public int getNumber() {
            return ((Field) this.instance).getNumber();
        }

        public Builder setNumber(int value) {
            copyOnWrite();
            Field.access$700((Field) this.instance, value);
            return this;
        }

        public Builder clearNumber() {
            copyOnWrite();
            Field.access$800((Field) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public String getName() {
            return ((Field) this.instance).getName();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            return ((Field) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            Field.access$900((Field) this.instance, value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            Field.access$1000((Field) this.instance);
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            Field.access$1100((Field) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            return ((Field) this.instance).getTypeUrl();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            return ((Field) this.instance).getTypeUrlBytes();
        }

        public Builder setTypeUrl(String value) {
            copyOnWrite();
            Field.access$1200((Field) this.instance, value);
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            Field.access$1300((Field) this.instance);
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            copyOnWrite();
            Field.access$1400((Field) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return ((Field) this.instance).getOneofIndex();
        }

        public Builder setOneofIndex(int value) {
            copyOnWrite();
            Field.access$1500((Field) this.instance, value);
            return this;
        }

        public Builder clearOneofIndex() {
            copyOnWrite();
            Field.access$1600((Field) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return ((Field) this.instance).getPacked();
        }

        public Builder setPacked(boolean value) {
            copyOnWrite();
            Field.access$1700((Field) this.instance, value);
            return this;
        }

        public Builder clearPacked() {
            copyOnWrite();
            Field.access$1800((Field) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Field) this.instance).getOptionsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            return ((Field) this.instance).getOptionsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public Option getOptions(int index) {
            return ((Field) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            Field.access$1900((Field) this.instance, index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Field.access$1900((Field) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            Field.access$2000((Field) this.instance, value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            Field.access$2100((Field) this.instance, index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            Field.access$2000((Field) this.instance, builderForValue.build());
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Field.access$2100((Field) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            Field.access$2200((Field) this.instance, values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            Field.access$2300((Field) this.instance);
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            Field.access$2400((Field) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public String getJsonName() {
            return ((Field) this.instance).getJsonName();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            return ((Field) this.instance).getJsonNameBytes();
        }

        public Builder setJsonName(String value) {
            copyOnWrite();
            Field.access$2500((Field) this.instance, value);
            return this;
        }

        public Builder clearJsonName() {
            copyOnWrite();
            Field.access$2600((Field) this.instance);
            return this;
        }

        public Builder setJsonNameBytes(ByteString value) {
            copyOnWrite();
            Field.access$2700((Field) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            return ((Field) this.instance).getDefaultValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            return ((Field) this.instance).getDefaultValueBytes();
        }

        public Builder setDefaultValue(String value) {
            copyOnWrite();
            Field.access$2800((Field) this.instance, value);
            return this;
        }

        public Builder clearDefaultValue() {
            copyOnWrite();
            Field.access$2900((Field) this.instance);
            return this;
        }

        public Builder setDefaultValueBytes(ByteString value) {
            copyOnWrite();
            Field.access$3000((Field) this.instance, value);
            return this;
        }
    }

    public static final enum Cardinality extends java.lang.Enum<Cardinality> implements Internal.EnumLite {
        private static final /* synthetic */ Cardinality[] $VALUES = null;
        public static final Cardinality CARDINALITY_OPTIONAL = null;
        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final Cardinality CARDINALITY_REPEATED = null;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final Cardinality CARDINALITY_REQUIRED = null;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final Cardinality CARDINALITY_UNKNOWN = null;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        public static final Cardinality UNRECOGNIZED = null;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = null;
        private final int value;

        private static final class CardinalityVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private CardinalityVerifier() {
            }

            static {
                INSTANCE = new CardinalityVerifier();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                if (Cardinality.forNumber(number) == null) goto L5;
                return true;
            L5:
                return false;
            }
        }

        public static Cardinality valueOf(String name) {
            return (Cardinality) java.lang.Enum.valueOf(Cardinality.class, name);
        }

        public static Cardinality[] values() {
            return (Cardinality[]) $VALUES.clone();
        }

        static {
            Cardinality r0 = new Cardinality("CARDINALITY_UNKNOWN", 0, 0);
            CARDINALITY_UNKNOWN = r0;
            Cardinality r1 = new Cardinality("CARDINALITY_OPTIONAL", 1, 1);
            CARDINALITY_OPTIONAL = r1;
            Cardinality r3 = new Cardinality("CARDINALITY_REQUIRED", 2, 2);
            CARDINALITY_REQUIRED = r3;
            Cardinality r5 = new Cardinality("CARDINALITY_REPEATED", 3, 3);
            CARDINALITY_REPEATED = r5;
            Cardinality r7 = new Cardinality("UNRECOGNIZED", 4, -1);
            UNRECOGNIZED = r7;
            $VALUES = new Cardinality[]{r0, r1, r3, r5, r7};
            internalValueMap = new AnonymousClass1();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Cardinality valueOf(int value) {
            return forNumber(value);
        }

        public static Cardinality forNumber(int value) {
            if (value == 0) goto L18;
            if (value == 1) goto L16;
            if (value == 2) goto L14;
            if (value == 3) goto L12;
            return null;
        L12:
            return CARDINALITY_REPEATED;
        L14:
            return CARDINALITY_REQUIRED;
        L16:
            return CARDINALITY_OPTIONAL;
        L18:
            return CARDINALITY_UNKNOWN;
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CardinalityVerifier.INSTANCE;
        }

        private Cardinality(String $enum$name, int $enum$ordinal, int value) {
            super($enum$name, $enum$ordinal);
            this.value = value;
        }
    }

    public static final enum Kind extends java.lang.Enum<Kind> implements Internal.EnumLite {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind TYPE_BOOL = null;
        public static final int TYPE_BOOL_VALUE = 8;
        public static final Kind TYPE_BYTES = null;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final Kind TYPE_DOUBLE = null;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final Kind TYPE_ENUM = null;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final Kind TYPE_FIXED32 = null;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final Kind TYPE_FIXED64 = null;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final Kind TYPE_FLOAT = null;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final Kind TYPE_GROUP = null;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final Kind TYPE_INT32 = null;
        public static final int TYPE_INT32_VALUE = 5;
        public static final Kind TYPE_INT64 = null;
        public static final int TYPE_INT64_VALUE = 3;
        public static final Kind TYPE_MESSAGE = null;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final Kind TYPE_SFIXED32 = null;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final Kind TYPE_SFIXED64 = null;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final Kind TYPE_SINT32 = null;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final Kind TYPE_SINT64 = null;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final Kind TYPE_STRING = null;
        public static final int TYPE_STRING_VALUE = 9;
        public static final Kind TYPE_UINT32 = null;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final Kind TYPE_UINT64 = null;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final Kind TYPE_UNKNOWN = null;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        public static final Kind UNRECOGNIZED = null;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = null;
        private final int value;

        private static final class KindVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = null;

            private KindVerifier() {
            }

            static {
                INSTANCE = new KindVerifier();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                if (Kind.forNumber(number) == null) goto L5;
                return true;
            L5:
                return false;
            }
        }

        public static Kind valueOf(String name) {
            return (Kind) java.lang.Enum.valueOf(Kind.class, name);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }

        static {
            Kind r0 = new Kind("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r0;
            Kind r1 = new Kind("TYPE_DOUBLE", 1, 1);
            TYPE_DOUBLE = r1;
            Kind r3 = new Kind("TYPE_FLOAT", 2, 2);
            TYPE_FLOAT = r3;
            Kind r5 = new Kind("TYPE_INT64", 3, 3);
            TYPE_INT64 = r5;
            Kind r7 = new Kind("TYPE_UINT64", 4, 4);
            TYPE_UINT64 = r7;
            Kind r9 = new Kind("TYPE_INT32", 5, 5);
            TYPE_INT32 = r9;
            Kind r11 = new Kind("TYPE_FIXED64", 6, 6);
            TYPE_FIXED64 = r11;
            Kind r13 = new Kind("TYPE_FIXED32", 7, 7);
            TYPE_FIXED32 = r13;
            Kind r15 = new Kind("TYPE_BOOL", 8, 8);
            TYPE_BOOL = r15;
            Kind r14 = new Kind("TYPE_STRING", 9, 9);
            TYPE_STRING = r14;
            Kind r12 = new Kind("TYPE_GROUP", 10, 10);
            TYPE_GROUP = r12;
            Kind r10 = new Kind("TYPE_MESSAGE", 11, 11);
            TYPE_MESSAGE = r10;
            Kind r8 = new Kind("TYPE_BYTES", 12, 12);
            TYPE_BYTES = r8;
            Kind r6 = new Kind("TYPE_UINT32", 13, 13);
            TYPE_UINT32 = r6;
            Kind r4 = new Kind("TYPE_ENUM", 14, 14);
            TYPE_ENUM = r4;
            Kind r2 = new Kind("TYPE_SFIXED32", 15, 15);
            TYPE_SFIXED32 = r2;
            Kind r16 = new Kind("TYPE_SFIXED64", 16, 16);
            TYPE_SFIXED64 = r16;
            Kind r17 = new Kind("TYPE_SINT32", 17, 17);
            TYPE_SINT32 = r17;
            Kind r18 = new Kind("TYPE_SINT64", 18, 18);
            TYPE_SINT64 = r18;
            Kind r19 = new Kind("UNRECOGNIZED", 19, -1);
            UNRECOGNIZED = r19;
            $VALUES = new Kind[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
            internalValueMap = new AnonymousClass1();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) goto L7;
            return this.value;
        L7:
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Kind valueOf(int value) {
            return forNumber(value);
        }

        public static Kind forNumber(int value) {
            switch(value) {
                case 0: goto L42;
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L16;
                case 14: goto L14;
                case 15: goto L12;
                case 16: goto L10;
                case 17: goto L8;
                case 18: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return TYPE_SINT64;
        L8:
            return TYPE_SINT32;
        L10:
            return TYPE_SFIXED64;
        L12:
            return TYPE_SFIXED32;
        L14:
            return TYPE_ENUM;
        L16:
            return TYPE_UINT32;
        L18:
            return TYPE_BYTES;
        L20:
            return TYPE_MESSAGE;
        L22:
            return TYPE_GROUP;
        L24:
            return TYPE_STRING;
        L26:
            return TYPE_BOOL;
        L28:
            return TYPE_FIXED32;
        L30:
            return TYPE_FIXED64;
        L32:
            return TYPE_INT32;
        L34:
            return TYPE_UINT64;
        L36:
            return TYPE_INT64;
        L38:
            return TYPE_FLOAT;
        L40:
            return TYPE_DOUBLE;
        L42:
            return TYPE_UNKNOWN;
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return KindVerifier.INSTANCE;
        }

        private Kind(String $enum$name, int $enum$ordinal, int value) {
            super($enum$name, $enum$ordinal);
            this.value = value;
        }
    }

    static /* synthetic */ Field access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(Field r0, int r1) {
        r0.setKindValue(r1);
    }

    static /* synthetic */ void access$1000(Field r0) {
        r0.clearName();
    }

    static /* synthetic */ void access$1100(Field r0, ByteString r1) {
        r0.setNameBytes(r1);
    }

    static /* synthetic */ void access$1200(Field r0, String r1) {
        r0.setTypeUrl(r1);
    }

    static /* synthetic */ void access$1300(Field r0) {
        r0.clearTypeUrl();
    }

    static /* synthetic */ void access$1400(Field r0, ByteString r1) {
        r0.setTypeUrlBytes(r1);
    }

    static /* synthetic */ void access$1500(Field r0, int r1) {
        r0.setOneofIndex(r1);
    }

    static /* synthetic */ void access$1600(Field r0) {
        r0.clearOneofIndex();
    }

    static /* synthetic */ void access$1700(Field r0, boolean r1) {
        r0.setPacked(r1);
    }

    static /* synthetic */ void access$1800(Field r0) {
        r0.clearPacked();
    }

    static /* synthetic */ void access$1900(Field r0, int r1, Option r2) {
        r0.setOptions(r1, r2);
    }

    static /* synthetic */ void access$200(Field r0, Kind r1) {
        r0.setKind(r1);
    }

    static /* synthetic */ void access$2000(Field r0, Option r1) {
        r0.addOptions(r1);
    }

    static /* synthetic */ void access$2100(Field r0, int r1, Option r2) {
        r0.addOptions(r1, r2);
    }

    static /* synthetic */ void access$2200(Field r0, Iterable r1) {
        r0.addAllOptions(r1);
    }

    static /* synthetic */ void access$2300(Field r0) {
        r0.clearOptions();
    }

    static /* synthetic */ void access$2400(Field r0, int r1) {
        r0.removeOptions(r1);
    }

    static /* synthetic */ void access$2500(Field r0, String r1) {
        r0.setJsonName(r1);
    }

    static /* synthetic */ void access$2600(Field r0) {
        r0.clearJsonName();
    }

    static /* synthetic */ void access$2700(Field r0, ByteString r1) {
        r0.setJsonNameBytes(r1);
    }

    static /* synthetic */ void access$2800(Field r0, String r1) {
        r0.setDefaultValue(r1);
    }

    static /* synthetic */ void access$2900(Field r0) {
        r0.clearDefaultValue();
    }

    static /* synthetic */ void access$300(Field r0) {
        r0.clearKind();
    }

    static /* synthetic */ void access$3000(Field r0, ByteString r1) {
        r0.setDefaultValueBytes(r1);
    }

    static /* synthetic */ void access$400(Field r0, int r1) {
        r0.setCardinalityValue(r1);
    }

    static /* synthetic */ void access$500(Field r0, Cardinality r1) {
        r0.setCardinality(r1);
    }

    static /* synthetic */ void access$600(Field r0) {
        r0.clearCardinality();
    }

    static /* synthetic */ void access$700(Field r0, int r1) {
        r0.setNumber(r1);
    }

    static /* synthetic */ void access$800(Field r0) {
        r0.clearNumber();
    }

    static /* synthetic */ void access$900(Field r0, String r1) {
        r0.setName(r1);
    }

    private Field() {
        this.name_ = "";
        this.typeUrl_ = "";
        this.options_ = emptyProtobufList();
        this.jsonName_ = "";
        this.defaultValue_ = "";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.kind_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public Kind getKind() {
        Kind r0 = Kind.forNumber(this.kind_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Kind.UNRECOGNIZED;
    }

    private void setKindValue(int value) {
        this.kind_ = value;
    }

    private void setKind(Kind value) {
        this.kind_ = value.getNumber();
    }

    private void clearKind() {
        this.kind_ = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality r0 = Cardinality.forNumber(this.cardinality_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Cardinality.UNRECOGNIZED;
    }

    private void setCardinalityValue(int value) {
        this.cardinality_ = value;
    }

    private void setCardinality(Cardinality value) {
        this.cardinality_ = value.getNumber();
    }

    private void clearCardinality() {
        this.cardinality_ = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.number_;
    }

    private void setNumber(int value) {
        this.number_ = value;
    }

    private void clearNumber() {
        this.number_ = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    private void setName(String value) {
        value.getClass();
        this.name_ = value;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void setNameBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.name_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    private void setTypeUrl(String value) {
        value.getClass();
        this.typeUrl_ = value;
    }

    private void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    private void setTypeUrlBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.typeUrl_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    private void setOneofIndex(int value) {
        this.oneofIndex_ = value;
    }

    private void clearOneofIndex() {
        this.oneofIndex_ = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.packed_;
    }

    private void setPacked(boolean value) {
        this.packed_ = value;
    }

    private void clearPacked() {
        this.packed_ = false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public Option getOptions(int index) {
        return this.options_.get(index);
    }

    public OptionOrBuilder getOptionsOrBuilder(int index) {
        return this.options_.get(index);
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<Option> r0 = this.options_;
        if (r0.isModifiable() == true) goto L6;
        this.options_ = GeneratedMessageLite.mutableCopy(r0);
        return;
    }

    private void setOptions(int index, Option value) {
        value.getClass();
        ensureOptionsIsMutable();
        this.options_.set(index, value);
    }

    private void addOptions(Option value) {
        value.getClass();
        ensureOptionsIsMutable();
        this.options_.add(value);
    }

    private void addOptions(int index, Option value) {
        value.getClass();
        ensureOptionsIsMutable();
        this.options_.add(index, value);
    }

    private void addAllOptions(Iterable<? extends Option> values) {
        ensureOptionsIsMutable();
        AbstractMessageLite.addAll(values, this.options_);
    }

    private void clearOptions() {
        this.options_ = emptyProtobufList();
    }

    private void removeOptions(int index) {
        ensureOptionsIsMutable();
        this.options_.remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public String getJsonName() {
        return this.jsonName_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        return ByteString.copyFromUtf8(this.jsonName_);
    }

    private void setJsonName(String value) {
        value.getClass();
        this.jsonName_ = value;
    }

    private void clearJsonName() {
        this.jsonName_ = getDefaultInstance().getJsonName();
    }

    private void setJsonNameBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.jsonName_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        return this.defaultValue_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.defaultValue_);
    }

    private void setDefaultValue(String value) {
        value.getClass();
        this.defaultValue_ = value;
    }

    private void clearDefaultValue() {
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    private void setDefaultValueBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.defaultValue_ = value.toStringUtf8();
    }

    public static Field parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Field parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Field parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Field parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Field parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Field parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Field parseFrom(InputStream input) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Field parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Field parseDelimitedFrom(InputStream input) throws IOException {
        return (Field) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Field parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Field parseFrom(CodedInputStream input) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Field parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Field prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        AnonymousClass1 r2 = null;
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L9:
        Parser<Field> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(Field.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(Field.class);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L5:
        throw new UnsupportedOperationException();
    L8:
        return (byte) 1;
    L23:
        return DEFAULT_INSTANCE;
    L25:
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", Option.class, "jsonName_", "defaultValue_"});
    L27:
        return new Builder(r2);
    L29:
        return new Field();
    }

    static {
        Field r0 = new Field();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(Field.class, r0);
    }

    public static Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Field> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
