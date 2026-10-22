package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Enum extends GeneratedMessageLite<Enum, Builder> implements EnumOrBuilder {
    private static final Enum DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 6;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Enum> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private int bitField0_;
    private String edition_;
    private Internal.ProtobufList<EnumValue> enumvalue_;
    private String name_;
    private Internal.ProtobufList<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.Enum$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Enum, Builder> implements EnumOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Enum.access$000());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public String getName() {
            return ((Enum) this.instance).getName();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            return ((Enum) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            Enum.access$100((Enum) this.instance, value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            Enum.access$200((Enum) this.instance);
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            Enum.access$300((Enum) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            return Collections.unmodifiableList(((Enum) this.instance).getEnumvalueList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            return ((Enum) this.instance).getEnumvalueCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int index) {
            return ((Enum) this.instance).getEnumvalue(index);
        }

        public Builder setEnumvalue(int index, EnumValue value) {
            copyOnWrite();
            Enum.access$400((Enum) this.instance, index, value);
            return this;
        }

        public Builder setEnumvalue(int index, EnumValue.Builder builderForValue) {
            copyOnWrite();
            Enum.access$400((Enum) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addEnumvalue(EnumValue value) {
            copyOnWrite();
            Enum.access$500((Enum) this.instance, value);
            return this;
        }

        public Builder addEnumvalue(int index, EnumValue value) {
            copyOnWrite();
            Enum.access$600((Enum) this.instance, index, value);
            return this;
        }

        public Builder addEnumvalue(EnumValue.Builder builderForValue) {
            copyOnWrite();
            Enum.access$500((Enum) this.instance, builderForValue.build());
            return this;
        }

        public Builder addEnumvalue(int index, EnumValue.Builder builderForValue) {
            copyOnWrite();
            Enum.access$600((Enum) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> values) {
            copyOnWrite();
            Enum.access$700((Enum) this.instance, values);
            return this;
        }

        public Builder clearEnumvalue() {
            copyOnWrite();
            Enum.access$800((Enum) this.instance);
            return this;
        }

        public Builder removeEnumvalue(int index) {
            copyOnWrite();
            Enum.access$900((Enum) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Enum) this.instance).getOptionsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            return ((Enum) this.instance).getOptionsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public Option getOptions(int index) {
            return ((Enum) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            Enum.access$1000((Enum) this.instance, index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Enum.access$1000((Enum) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            Enum.access$1100((Enum) this.instance, value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            Enum.access$1200((Enum) this.instance, index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            Enum.access$1100((Enum) this.instance, builderForValue.build());
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Enum.access$1200((Enum) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            Enum.access$1300((Enum) this.instance, values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            Enum.access$1400((Enum) this.instance);
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            Enum.access$1500((Enum) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            return ((Enum) this.instance).hasSourceContext();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            return ((Enum) this.instance).getSourceContext();
        }

        public Builder setSourceContext(SourceContext value) {
            copyOnWrite();
            Enum.access$1600((Enum) this.instance, value);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            copyOnWrite();
            Enum.access$1600((Enum) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            copyOnWrite();
            Enum.access$1700((Enum) this.instance, value);
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            Enum.access$1800((Enum) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return ((Enum) this.instance).getSyntaxValue();
        }

        public Builder setSyntaxValue(int value) {
            copyOnWrite();
            Enum.access$1900((Enum) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public Syntax getSyntax() {
            return ((Enum) this.instance).getSyntax();
        }

        public Builder setSyntax(Syntax value) {
            copyOnWrite();
            Enum.access$2000((Enum) this.instance, value);
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            Enum.access$2100((Enum) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public String getEdition() {
            return ((Enum) this.instance).getEdition();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
        public ByteString getEditionBytes() {
            return ((Enum) this.instance).getEditionBytes();
        }

        public Builder setEdition(String value) {
            copyOnWrite();
            Enum.access$2200((Enum) this.instance, value);
            return this;
        }

        public Builder clearEdition() {
            copyOnWrite();
            Enum.access$2300((Enum) this.instance);
            return this;
        }

        public Builder setEditionBytes(ByteString value) {
            copyOnWrite();
            Enum.access$2400((Enum) this.instance, value);
            return this;
        }
    }

    static /* synthetic */ Enum access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(Enum r0, String r1) {
        r0.setName(r1);
    }

    static /* synthetic */ void access$1000(Enum r0, int r1, Option r2) {
        r0.setOptions(r1, r2);
    }

    static /* synthetic */ void access$1100(Enum r0, Option r1) {
        r0.addOptions(r1);
    }

    static /* synthetic */ void access$1200(Enum r0, int r1, Option r2) {
        r0.addOptions(r1, r2);
    }

    static /* synthetic */ void access$1300(Enum r0, Iterable r1) {
        r0.addAllOptions(r1);
    }

    static /* synthetic */ void access$1400(Enum r0) {
        r0.clearOptions();
    }

    static /* synthetic */ void access$1500(Enum r0, int r1) {
        r0.removeOptions(r1);
    }

    static /* synthetic */ void access$1600(Enum r0, SourceContext r1) {
        r0.setSourceContext(r1);
    }

    static /* synthetic */ void access$1700(Enum r0, SourceContext r1) {
        r0.mergeSourceContext(r1);
    }

    static /* synthetic */ void access$1800(Enum r0) {
        r0.clearSourceContext();
    }

    static /* synthetic */ void access$1900(Enum r0, int r1) {
        r0.setSyntaxValue(r1);
    }

    static /* synthetic */ void access$200(Enum r0) {
        r0.clearName();
    }

    static /* synthetic */ void access$2000(Enum r0, Syntax r1) {
        r0.setSyntax(r1);
    }

    static /* synthetic */ void access$2100(Enum r0) {
        r0.clearSyntax();
    }

    static /* synthetic */ void access$2200(Enum r0, String r1) {
        r0.setEdition(r1);
    }

    static /* synthetic */ void access$2300(Enum r0) {
        r0.clearEdition();
    }

    static /* synthetic */ void access$2400(Enum r0, ByteString r1) {
        r0.setEditionBytes(r1);
    }

    static /* synthetic */ void access$300(Enum r0, ByteString r1) {
        r0.setNameBytes(r1);
    }

    static /* synthetic */ void access$400(Enum r0, int r1, EnumValue r2) {
        r0.setEnumvalue(r1, r2);
    }

    static /* synthetic */ void access$500(Enum r0, EnumValue r1) {
        r0.addEnumvalue(r1);
    }

    static /* synthetic */ void access$600(Enum r0, int r1, EnumValue r2) {
        r0.addEnumvalue(r1, r2);
    }

    static /* synthetic */ void access$700(Enum r0, Iterable r1) {
        r0.addAllEnumvalue(r1);
    }

    static /* synthetic */ void access$800(Enum r0) {
        r0.clearEnumvalue();
    }

    static /* synthetic */ void access$900(Enum r0, int r1) {
        r0.removeEnumvalue(r1);
    }

    private Enum() {
        this.name_ = "";
        this.enumvalue_ = emptyProtobufList();
        this.options_ = emptyProtobufList();
        this.edition_ = "";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int index) {
        return this.enumvalue_.get(index);
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int index) {
        return this.enumvalue_.get(index);
    }

    private void ensureEnumvalueIsMutable() {
        Internal.ProtobufList<EnumValue> r0 = this.enumvalue_;
        if (r0.isModifiable() == true) goto L6;
        this.enumvalue_ = GeneratedMessageLite.mutableCopy(r0);
        return;
    }

    private void setEnumvalue(int index, EnumValue value) {
        value.getClass();
        ensureEnumvalueIsMutable();
        this.enumvalue_.set(index, value);
    }

    private void addEnumvalue(EnumValue value) {
        value.getClass();
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(value);
    }

    private void addEnumvalue(int index, EnumValue value) {
        value.getClass();
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(index, value);
    }

    private void addAllEnumvalue(Iterable<? extends EnumValue> values) {
        ensureEnumvalueIsMutable();
        AbstractMessageLite.addAll(values, this.enumvalue_);
    }

    private void clearEnumvalue() {
        this.enumvalue_ = emptyProtobufList();
    }

    private void removeEnumvalue(int index) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r0 = this.sourceContext_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SourceContext.getDefaultInstance();
    }

    private void setSourceContext(SourceContext value) {
        value.getClass();
        this.sourceContext_ = value;
        this.bitField0_ |= 1;
    }

    private void mergeSourceContext(SourceContext value) {
        value.getClass();
        SourceContext r0 = this.sourceContext_;
        if (r0 != null) goto L5;
    L7:
        this.sourceContext_ = value;
    L8:
        this.bitField0_ |= 1;
        return;
    L5:
        if (r0 == SourceContext.getDefaultInstance()) goto L7;
        this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearSourceContext() {
        this.sourceContext_ = null;
        this.bitField0_ &= -2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public Syntax getSyntax() {
        Syntax r0 = Syntax.forNumber(this.syntax_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    private void setSyntaxValue(int value) {
        this.syntax_ = value;
    }

    private void setSyntax(Syntax value) {
        this.syntax_ = value.getNumber();
    }

    private void clearSyntax() {
        this.syntax_ = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public String getEdition() {
        return this.edition_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.EnumOrBuilder
    public ByteString getEditionBytes() {
        return ByteString.copyFromUtf8(this.edition_);
    }

    private void setEdition(String value) {
        value.getClass();
        this.edition_ = value;
    }

    private void clearEdition() {
        this.edition_ = getDefaultInstance().getEdition();
    }

    private void setEditionBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.edition_ = value.toStringUtf8();
    }

    public static Enum parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Enum parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Enum parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Enum parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Enum parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Enum parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Enum parseFrom(InputStream input) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Enum parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Enum parseDelimitedFrom(InputStream input) throws IOException {
        return (Enum) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Enum parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Enum parseFrom(CodedInputStream input) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Enum parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Enum prototype) {
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
        Parser<Enum> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(Enum.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(Enum.class);     // Catch: Throwable -> L18
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
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004ဉ\u0000\u0005\f\u0006Ȉ", new Object[]{"bitField0_", "name_", "enumvalue_", EnumValue.class, "options_", Option.class, "sourceContext_", "syntax_", "edition_"});
    L27:
        return new Builder(r2);
    L29:
        return new Enum();
    }

    static {
        Enum r0 = new Enum();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(Enum.class, r0);
    }

    public static Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Enum> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
