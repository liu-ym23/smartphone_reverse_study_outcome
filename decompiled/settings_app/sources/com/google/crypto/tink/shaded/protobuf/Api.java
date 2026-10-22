package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE = null;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<Api> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private int bitField0_;
    private Internal.ProtobufList<Method> methods_;
    private Internal.ProtobufList<Mixin> mixins_;
    private String name_;
    private Internal.ProtobufList<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private String version_;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.Api$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Api.access$000());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public String getName() {
            return ((Api) this.instance).getName();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            return ((Api) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            Api.access$100((Api) this.instance, value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            Api.access$200((Api) this.instance);
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            Api.access$300((Api) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            return Collections.unmodifiableList(((Api) this.instance).getMethodsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            return ((Api) this.instance).getMethodsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public Method getMethods(int index) {
            return ((Api) this.instance).getMethods(index);
        }

        public Builder setMethods(int index, Method value) {
            copyOnWrite();
            Api.access$400((Api) this.instance, index, value);
            return this;
        }

        public Builder setMethods(int index, Method.Builder builderForValue) {
            copyOnWrite();
            Api.access$400((Api) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addMethods(Method value) {
            copyOnWrite();
            Api.access$500((Api) this.instance, value);
            return this;
        }

        public Builder addMethods(int index, Method value) {
            copyOnWrite();
            Api.access$600((Api) this.instance, index, value);
            return this;
        }

        public Builder addMethods(Method.Builder builderForValue) {
            copyOnWrite();
            Api.access$500((Api) this.instance, builderForValue.build());
            return this;
        }

        public Builder addMethods(int index, Method.Builder builderForValue) {
            copyOnWrite();
            Api.access$600((Api) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllMethods(Iterable<? extends Method> values) {
            copyOnWrite();
            Api.access$700((Api) this.instance, values);
            return this;
        }

        public Builder clearMethods() {
            copyOnWrite();
            Api.access$800((Api) this.instance);
            return this;
        }

        public Builder removeMethods(int index) {
            copyOnWrite();
            Api.access$900((Api) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Api) this.instance).getOptionsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            return ((Api) this.instance).getOptionsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public Option getOptions(int index) {
            return ((Api) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            Api.access$1000((Api) this.instance, index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Api.access$1000((Api) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            Api.access$1100((Api) this.instance, value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            Api.access$1200((Api) this.instance, index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            Api.access$1100((Api) this.instance, builderForValue.build());
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Api.access$1200((Api) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            Api.access$1300((Api) this.instance, values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            Api.access$1400((Api) this.instance);
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            Api.access$1500((Api) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public String getVersion() {
            return ((Api) this.instance).getVersion();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            return ((Api) this.instance).getVersionBytes();
        }

        public Builder setVersion(String value) {
            copyOnWrite();
            Api.access$1600((Api) this.instance, value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            Api.access$1700((Api) this.instance);
            return this;
        }

        public Builder setVersionBytes(ByteString value) {
            copyOnWrite();
            Api.access$1800((Api) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            return ((Api) this.instance).hasSourceContext();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public SourceContext getSourceContext() {
            return ((Api) this.instance).getSourceContext();
        }

        public Builder setSourceContext(SourceContext value) {
            copyOnWrite();
            Api.access$1900((Api) this.instance, value);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            copyOnWrite();
            Api.access$1900((Api) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            copyOnWrite();
            Api.access$2000((Api) this.instance, value);
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            Api.access$2100((Api) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            return Collections.unmodifiableList(((Api) this.instance).getMixinsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            return ((Api) this.instance).getMixinsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public Mixin getMixins(int index) {
            return ((Api) this.instance).getMixins(index);
        }

        public Builder setMixins(int index, Mixin value) {
            copyOnWrite();
            Api.access$2200((Api) this.instance, index, value);
            return this;
        }

        public Builder setMixins(int index, Mixin.Builder builderForValue) {
            copyOnWrite();
            Api.access$2200((Api) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addMixins(Mixin value) {
            copyOnWrite();
            Api.access$2300((Api) this.instance, value);
            return this;
        }

        public Builder addMixins(int index, Mixin value) {
            copyOnWrite();
            Api.access$2400((Api) this.instance, index, value);
            return this;
        }

        public Builder addMixins(Mixin.Builder builderForValue) {
            copyOnWrite();
            Api.access$2300((Api) this.instance, builderForValue.build());
            return this;
        }

        public Builder addMixins(int index, Mixin.Builder builderForValue) {
            copyOnWrite();
            Api.access$2400((Api) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllMixins(Iterable<? extends Mixin> values) {
            copyOnWrite();
            Api.access$2500((Api) this.instance, values);
            return this;
        }

        public Builder clearMixins() {
            copyOnWrite();
            Api.access$2600((Api) this.instance);
            return this;
        }

        public Builder removeMixins(int index) {
            copyOnWrite();
            Api.access$2700((Api) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return ((Api) this.instance).getSyntaxValue();
        }

        public Builder setSyntaxValue(int value) {
            copyOnWrite();
            Api.access$2800((Api) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            return ((Api) this.instance).getSyntax();
        }

        public Builder setSyntax(Syntax value) {
            copyOnWrite();
            Api.access$2900((Api) this.instance, value);
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            Api.access$3000((Api) this.instance);
            return this;
        }
    }

    static /* synthetic */ Api access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(Api r0, String r1) {
        r0.setName(r1);
    }

    static /* synthetic */ void access$1000(Api r0, int r1, Option r2) {
        r0.setOptions(r1, r2);
    }

    static /* synthetic */ void access$1100(Api r0, Option r1) {
        r0.addOptions(r1);
    }

    static /* synthetic */ void access$1200(Api r0, int r1, Option r2) {
        r0.addOptions(r1, r2);
    }

    static /* synthetic */ void access$1300(Api r0, Iterable r1) {
        r0.addAllOptions(r1);
    }

    static /* synthetic */ void access$1400(Api r0) {
        r0.clearOptions();
    }

    static /* synthetic */ void access$1500(Api r0, int r1) {
        r0.removeOptions(r1);
    }

    static /* synthetic */ void access$1600(Api r0, String r1) {
        r0.setVersion(r1);
    }

    static /* synthetic */ void access$1700(Api r0) {
        r0.clearVersion();
    }

    static /* synthetic */ void access$1800(Api r0, ByteString r1) {
        r0.setVersionBytes(r1);
    }

    static /* synthetic */ void access$1900(Api r0, SourceContext r1) {
        r0.setSourceContext(r1);
    }

    static /* synthetic */ void access$200(Api r0) {
        r0.clearName();
    }

    static /* synthetic */ void access$2000(Api r0, SourceContext r1) {
        r0.mergeSourceContext(r1);
    }

    static /* synthetic */ void access$2100(Api r0) {
        r0.clearSourceContext();
    }

    static /* synthetic */ void access$2200(Api r0, int r1, Mixin r2) {
        r0.setMixins(r1, r2);
    }

    static /* synthetic */ void access$2300(Api r0, Mixin r1) {
        r0.addMixins(r1);
    }

    static /* synthetic */ void access$2400(Api r0, int r1, Mixin r2) {
        r0.addMixins(r1, r2);
    }

    static /* synthetic */ void access$2500(Api r0, Iterable r1) {
        r0.addAllMixins(r1);
    }

    static /* synthetic */ void access$2600(Api r0) {
        r0.clearMixins();
    }

    static /* synthetic */ void access$2700(Api r0, int r1) {
        r0.removeMixins(r1);
    }

    static /* synthetic */ void access$2800(Api r0, int r1) {
        r0.setSyntaxValue(r1);
    }

    static /* synthetic */ void access$2900(Api r0, Syntax r1) {
        r0.setSyntax(r1);
    }

    static /* synthetic */ void access$300(Api r0, ByteString r1) {
        r0.setNameBytes(r1);
    }

    static /* synthetic */ void access$3000(Api r0) {
        r0.clearSyntax();
    }

    static /* synthetic */ void access$400(Api r0, int r1, Method r2) {
        r0.setMethods(r1, r2);
    }

    static /* synthetic */ void access$500(Api r0, Method r1) {
        r0.addMethods(r1);
    }

    static /* synthetic */ void access$600(Api r0, int r1, Method r2) {
        r0.addMethods(r1, r2);
    }

    static /* synthetic */ void access$700(Api r0, Iterable r1) {
        r0.addAllMethods(r1);
    }

    static /* synthetic */ void access$800(Api r0) {
        r0.clearMethods();
    }

    static /* synthetic */ void access$900(Api r0, int r1) {
        r0.removeMethods(r1);
    }

    private Api() {
        this.name_ = "";
        this.methods_ = emptyProtobufList();
        this.options_ = emptyProtobufList();
        this.version_ = "";
        this.mixins_ = emptyProtobufList();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public List<Method> getMethodsList() {
        return this.methods_;
    }

    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public Method getMethods(int index) {
        return this.methods_.get(index);
    }

    public MethodOrBuilder getMethodsOrBuilder(int index) {
        return this.methods_.get(index);
    }

    private void ensureMethodsIsMutable() {
        Internal.ProtobufList<Method> r0 = this.methods_;
        if (r0.isModifiable() == true) goto L6;
        this.methods_ = GeneratedMessageLite.mutableCopy(r0);
        return;
    }

    private void setMethods(int index, Method value) {
        value.getClass();
        ensureMethodsIsMutable();
        this.methods_.set(index, value);
    }

    private void addMethods(Method value) {
        value.getClass();
        ensureMethodsIsMutable();
        this.methods_.add(value);
    }

    private void addMethods(int index, Method value) {
        value.getClass();
        ensureMethodsIsMutable();
        this.methods_.add(index, value);
    }

    private void addAllMethods(Iterable<? extends Method> values) {
        ensureMethodsIsMutable();
        AbstractMessageLite.addAll(values, this.methods_);
    }

    private void clearMethods() {
        this.methods_ = emptyProtobufList();
    }

    private void removeMethods(int index) {
        ensureMethodsIsMutable();
        this.methods_.remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    private void setVersion(String value) {
        value.getClass();
        this.version_ = value;
    }

    private void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    private void setVersionBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.version_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public boolean hasSourceContext() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.mixins_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public Mixin getMixins(int index) {
        return this.mixins_.get(index);
    }

    public MixinOrBuilder getMixinsOrBuilder(int index) {
        return this.mixins_.get(index);
    }

    private void ensureMixinsIsMutable() {
        Internal.ProtobufList<Mixin> r0 = this.mixins_;
        if (r0.isModifiable() == true) goto L6;
        this.mixins_ = GeneratedMessageLite.mutableCopy(r0);
        return;
    }

    private void setMixins(int index, Mixin value) {
        value.getClass();
        ensureMixinsIsMutable();
        this.mixins_.set(index, value);
    }

    private void addMixins(Mixin value) {
        value.getClass();
        ensureMixinsIsMutable();
        this.mixins_.add(value);
    }

    private void addMixins(int index, Mixin value) {
        value.getClass();
        ensureMixinsIsMutable();
        this.mixins_.add(index, value);
    }

    private void addAllMixins(Iterable<? extends Mixin> values) {
        ensureMixinsIsMutable();
        AbstractMessageLite.addAll(values, this.mixins_);
    }

    private void clearMixins() {
        this.mixins_ = emptyProtobufList();
    }

    private void removeMixins(int index) {
        ensureMixinsIsMutable();
        this.mixins_.remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ApiOrBuilder
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

    public static Api parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Api parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Api parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Api parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Api parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Api parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Api parseFrom(InputStream input) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Api parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Api parseDelimitedFrom(InputStream input) throws IOException {
        return (Api) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Api parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Api parseFrom(CodedInputStream input) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Api parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Api prototype) {
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
        Parser<Api> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(Api.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(Api.class);     // Catch: Throwable -> L18
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
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004Ȉ\u0005ဉ\u0000\u0006\u001b\u0007\f", new Object[]{"bitField0_", "name_", "methods_", Method.class, "options_", Option.class, "version_", "sourceContext_", "mixins_", Mixin.class, "syntax_"});
    L27:
        return new Builder(r2);
    L29:
        return new Api();
    }

    static {
        Api r0 = new Api();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(Api.class, r0);
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Api> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
