package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final Value DEFAULT_INSTANCE = null;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Value> PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_;
    private Object kind_;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.Value$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Value.access$000());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public KindCase getKindCase() {
            return ((Value) this.instance).getKindCase();
        }

        public Builder clearKind() {
            copyOnWrite();
            Value.access$100((Value) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public boolean hasNullValue() {
            return ((Value) this.instance).hasNullValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public int getNullValueValue() {
            return ((Value) this.instance).getNullValueValue();
        }

        public Builder setNullValueValue(int value) {
            copyOnWrite();
            Value.access$200((Value) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            return ((Value) this.instance).getNullValue();
        }

        public Builder setNullValue(NullValue value) {
            copyOnWrite();
            Value.access$300((Value) this.instance, value);
            return this;
        }

        public Builder clearNullValue() {
            copyOnWrite();
            Value.access$400((Value) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public boolean hasNumberValue() {
            return ((Value) this.instance).hasNumberValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public double getNumberValue() {
            return ((Value) this.instance).getNumberValue();
        }

        public Builder setNumberValue(double value) {
            copyOnWrite();
            Value.access$500((Value) this.instance, value);
            return this;
        }

        public Builder clearNumberValue() {
            copyOnWrite();
            Value.access$600((Value) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public boolean hasStringValue() {
            return ((Value) this.instance).hasStringValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public String getStringValue() {
            return ((Value) this.instance).getStringValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            return ((Value) this.instance).getStringValueBytes();
        }

        public Builder setStringValue(String value) {
            copyOnWrite();
            Value.access$700((Value) this.instance, value);
            return this;
        }

        public Builder clearStringValue() {
            copyOnWrite();
            Value.access$800((Value) this.instance);
            return this;
        }

        public Builder setStringValueBytes(ByteString value) {
            copyOnWrite();
            Value.access$900((Value) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public boolean hasBoolValue() {
            return ((Value) this.instance).hasBoolValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            return ((Value) this.instance).getBoolValue();
        }

        public Builder setBoolValue(boolean value) {
            copyOnWrite();
            Value.access$1000((Value) this.instance, value);
            return this;
        }

        public Builder clearBoolValue() {
            copyOnWrite();
            Value.access$1100((Value) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public boolean hasStructValue() {
            return ((Value) this.instance).hasStructValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public Struct getStructValue() {
            return ((Value) this.instance).getStructValue();
        }

        public Builder setStructValue(Struct value) {
            copyOnWrite();
            Value.access$1200((Value) this.instance, value);
            return this;
        }

        public Builder setStructValue(Struct.Builder builderForValue) {
            copyOnWrite();
            Value.access$1200((Value) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeStructValue(Struct value) {
            copyOnWrite();
            Value.access$1300((Value) this.instance, value);
            return this;
        }

        public Builder clearStructValue() {
            copyOnWrite();
            Value.access$1400((Value) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public boolean hasListValue() {
            return ((Value) this.instance).hasListValue();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
        public ListValue getListValue() {
            return ((Value) this.instance).getListValue();
        }

        public Builder setListValue(ListValue value) {
            copyOnWrite();
            Value.access$1500((Value) this.instance, value);
            return this;
        }

        public Builder setListValue(ListValue.Builder builderForValue) {
            copyOnWrite();
            Value.access$1500((Value) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeListValue(ListValue value) {
            copyOnWrite();
            Value.access$1600((Value) this.instance, value);
            return this;
        }

        public Builder clearListValue() {
            copyOnWrite();
            Value.access$1700((Value) this.instance);
            return this;
        }
    }

    public static final enum KindCase extends java.lang.Enum<KindCase> {
        private static final /* synthetic */ KindCase[] $VALUES = null;
        public static final KindCase BOOL_VALUE = null;
        public static final KindCase KIND_NOT_SET = null;
        public static final KindCase LIST_VALUE = null;
        public static final KindCase NULL_VALUE = null;
        public static final KindCase NUMBER_VALUE = null;
        public static final KindCase STRING_VALUE = null;
        public static final KindCase STRUCT_VALUE = null;
        private final int value;

        public static KindCase valueOf(String name) {
            return (KindCase) java.lang.Enum.valueOf(KindCase.class, name);
        }

        public static KindCase[] values() {
            return (KindCase[]) $VALUES.clone();
        }

        static {
            KindCase r0 = new KindCase("NULL_VALUE", 0, 1);
            NULL_VALUE = r0;
            KindCase r1 = new KindCase("NUMBER_VALUE", 1, 2);
            NUMBER_VALUE = r1;
            KindCase r4 = new KindCase("STRING_VALUE", 2, 3);
            STRING_VALUE = r4;
            KindCase r6 = new KindCase("BOOL_VALUE", 3, 4);
            BOOL_VALUE = r6;
            KindCase r8 = new KindCase("STRUCT_VALUE", 4, 5);
            STRUCT_VALUE = r8;
            KindCase r10 = new KindCase("LIST_VALUE", 5, 6);
            LIST_VALUE = r10;
            KindCase r12 = new KindCase("KIND_NOT_SET", 6, 0);
            KIND_NOT_SET = r12;
            $VALUES = new KindCase[]{r0, r1, r4, r6, r8, r10, r12};
        }

        private KindCase(String $enum$name, int $enum$ordinal, int value) {
            super($enum$name, $enum$ordinal);
            this.value = value;
        }

        @Deprecated
        public static KindCase valueOf(int value) {
            return forNumber(value);
        }

        public static KindCase forNumber(int value) {
            switch(value) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return LIST_VALUE;
        L8:
            return STRUCT_VALUE;
        L10:
            return BOOL_VALUE;
        L12:
            return STRING_VALUE;
        L14:
            return NUMBER_VALUE;
        L16:
            return NULL_VALUE;
        L18:
            return KIND_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }
    }

    static /* synthetic */ Value access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(Value r0) {
        r0.clearKind();
    }

    static /* synthetic */ void access$1000(Value r0, boolean r1) {
        r0.setBoolValue(r1);
    }

    static /* synthetic */ void access$1100(Value r0) {
        r0.clearBoolValue();
    }

    static /* synthetic */ void access$1200(Value r0, Struct r1) {
        r0.setStructValue(r1);
    }

    static /* synthetic */ void access$1300(Value r0, Struct r1) {
        r0.mergeStructValue(r1);
    }

    static /* synthetic */ void access$1400(Value r0) {
        r0.clearStructValue();
    }

    static /* synthetic */ void access$1500(Value r0, ListValue r1) {
        r0.setListValue(r1);
    }

    static /* synthetic */ void access$1600(Value r0, ListValue r1) {
        r0.mergeListValue(r1);
    }

    static /* synthetic */ void access$1700(Value r0) {
        r0.clearListValue();
    }

    static /* synthetic */ void access$200(Value r0, int r1) {
        r0.setNullValueValue(r1);
    }

    static /* synthetic */ void access$300(Value r0, NullValue r1) {
        r0.setNullValue(r1);
    }

    static /* synthetic */ void access$400(Value r0) {
        r0.clearNullValue();
    }

    static /* synthetic */ void access$500(Value r0, double r1) {
        r0.setNumberValue(r1);
    }

    static /* synthetic */ void access$600(Value r0) {
        r0.clearNumberValue();
    }

    static /* synthetic */ void access$700(Value r0, String r1) {
        r0.setStringValue(r1);
    }

    static /* synthetic */ void access$800(Value r0) {
        r0.clearStringValue();
    }

    static /* synthetic */ void access$900(Value r0, ByteString r1) {
        r0.setStringValueBytes(r1);
    }

    private Value() {
        this.kindCase_ = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    private void clearKind() {
        this.kindCase_ = 0;
        this.kind_ = null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasNullValue() {
        if (this.kindCase_ == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        if (this.kindCase_ == 1) goto L5;
        return 0;
    L5:
        return ((Integer) this.kind_).intValue();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.kindCase_ != 1) goto L9;
        NullValue r2 = NullValue.forNumber(((Integer) this.kind_).intValue());
        if (r2 == null) goto L7;
        return r2;
    L7:
        return NullValue.UNRECOGNIZED;
    L9:
        return NullValue.NULL_VALUE;
    }

    private void setNullValueValue(int value) {
        this.kindCase_ = 1;
        this.kind_ = Integer.valueOf(value);
    }

    private void setNullValue(NullValue value) {
        this.kind_ = Integer.valueOf(value.getNumber());
        this.kindCase_ = 1;
    }

    private void clearNullValue() {
        if (this.kindCase_ != 1) goto L6;
        this.kindCase_ = 0;
        this.kind_ = null;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasNumberValue() {
        if (this.kindCase_ != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) goto L5;
        return 0.0d;
    L5:
        return ((Double) this.kind_).doubleValue();
    }

    private void setNumberValue(double value) {
        this.kindCase_ = 2;
        this.kind_ = Double.valueOf(value);
    }

    private void clearNumberValue() {
        if (this.kindCase_ != 2) goto L6;
        this.kindCase_ = 0;
        this.kind_ = null;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasStringValue() {
        if (this.kindCase_ != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public String getStringValue() {
        if (this.kindCase_ == 3) goto L7;
        return "";
    L7:
        return (String) this.kind_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        if (this.kindCase_ != 3) goto L5;
        String r2 = (String) this.kind_;
    L7:
        return ByteString.copyFromUtf8(r2);
    L5:
        r2 = "";
        goto L7
    }

    private void setStringValue(String value) {
        value.getClass();
        this.kindCase_ = 3;
        this.kind_ = value;
    }

    private void clearStringValue() {
        if (this.kindCase_ != 3) goto L6;
        this.kindCase_ = 0;
        this.kind_ = null;
        return;
    }

    private void setStringValueBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.kind_ = value.toStringUtf8();
        this.kindCase_ = 3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasBoolValue() {
        if (this.kindCase_ != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) goto L5;
        return false;
    L5:
        return ((Boolean) this.kind_).booleanValue();
    }

    private void setBoolValue(boolean value) {
        this.kindCase_ = 4;
        this.kind_ = Boolean.valueOf(value);
    }

    private void clearBoolValue() {
        if (this.kindCase_ != 4) goto L6;
        this.kindCase_ = 0;
        this.kind_ = null;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        if (this.kindCase_ != 5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public Struct getStructValue() {
        if (this.kindCase_ != 5) goto L7;
        return (Struct) this.kind_;
    L7:
        return Struct.getDefaultInstance();
    }

    private void setStructValue(Struct value) {
        value.getClass();
        this.kind_ = value;
        this.kindCase_ = 5;
    }

    private void mergeStructValue(Struct value) {
        value.getClass();
        if (this.kindCase_ == 5) goto L5;
    L7:
        this.kind_ = value;
    L8:
        this.kindCase_ = 5;
        return;
    L5:
        if (this.kind_ == Struct.getDefaultInstance()) goto L7;
        this.kind_ = Struct.newBuilder((Struct) this.kind_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearStructValue() {
        if (this.kindCase_ != 5) goto L6;
        this.kindCase_ = 0;
        this.kind_ = null;
        return;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        if (this.kindCase_ != 6) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ValueOrBuilder
    public ListValue getListValue() {
        if (this.kindCase_ != 6) goto L7;
        return (ListValue) this.kind_;
    L7:
        return ListValue.getDefaultInstance();
    }

    private void setListValue(ListValue value) {
        value.getClass();
        this.kind_ = value;
        this.kindCase_ = 6;
    }

    private void mergeListValue(ListValue value) {
        value.getClass();
        if (this.kindCase_ == 6) goto L5;
    L7:
        this.kind_ = value;
    L8:
        this.kindCase_ = 6;
        return;
    L5:
        if (this.kind_ == ListValue.getDefaultInstance()) goto L7;
        this.kind_ = ListValue.newBuilder((ListValue) this.kind_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearListValue() {
        if (this.kindCase_ != 6) goto L6;
        this.kindCase_ = 0;
        this.kind_ = null;
        return;
    }

    public static Value parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Value parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Value parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Value parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Value parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Value parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Value parseFrom(InputStream input) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Value parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Value parseDelimitedFrom(InputStream input) throws IOException {
        return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Value parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Value parseFrom(CodedInputStream input) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Value parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Value prototype) {
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
        Parser<Value> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(Value.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(Value.class);     // Catch: Throwable -> L18
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
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", Struct.class, ListValue.class});
    L27:
        return new Builder(r2);
    L29:
        return new Value();
    }

    static {
        Value r0 = new Value();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(Value.class, r0);
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Value> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
