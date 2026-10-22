package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class PrfBasedDeriverKeyFormat extends GeneratedMessageLite<PrfBasedDeriverKeyFormat, Builder> implements PrfBasedDeriverKeyFormatOrBuilder {
    private static final PrfBasedDeriverKeyFormat DEFAULT_INSTANCE = null;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<PrfBasedDeriverKeyFormat> PARSER = null;
    public static final int PRF_KEY_TEMPLATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private PrfBasedDeriverParams params_;
    private KeyTemplate prfKeyTemplate_;

    /* JADX INFO: renamed from: com.google.crypto.tink.proto.PrfBasedDeriverKeyFormat$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<PrfBasedDeriverKeyFormat, Builder> implements PrfBasedDeriverKeyFormatOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return super.build();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return super.buildPartial();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return super.clear();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return super.clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return super.clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo952clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
            return super.internalMergeFrom((GeneratedMessageLite) message);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return super.mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
            return super.mergeFrom(input, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.mergeFrom(input, offset, length, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString data) throws InvalidProtocolBufferException {
            return super.mergeFrom(data);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.mergeFrom(data, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input) throws IOException {
            return super.mergeFrom(input);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return super.mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite other) {
            return super.mergeFrom(other);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream input) throws IOException {
            return super.mergeFrom(input);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return super.mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] data) throws InvalidProtocolBufferException {
            return super.mergeFrom(data);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
            return super.mergeFrom(input, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.mergeFrom(input, offset, length, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return super.mergeFrom(data, extensionRegistry);
        }

        private Builder() {
            super(PrfBasedDeriverKeyFormat.access$000());
        }

        @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
        public boolean hasPrfKeyTemplate() {
            return ((PrfBasedDeriverKeyFormat) this.instance).hasPrfKeyTemplate();
        }

        @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
        public KeyTemplate getPrfKeyTemplate() {
            return ((PrfBasedDeriverKeyFormat) this.instance).getPrfKeyTemplate();
        }

        public Builder setPrfKeyTemplate(KeyTemplate value) {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$100((PrfBasedDeriverKeyFormat) this.instance, value);
            return this;
        }

        public Builder setPrfKeyTemplate(KeyTemplate.Builder builderForValue) {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$100((PrfBasedDeriverKeyFormat) this.instance, (KeyTemplate) builderForValue.build());
            return this;
        }

        public Builder mergePrfKeyTemplate(KeyTemplate value) {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$200((PrfBasedDeriverKeyFormat) this.instance, value);
            return this;
        }

        public Builder clearPrfKeyTemplate() {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$300((PrfBasedDeriverKeyFormat) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
        public boolean hasParams() {
            return ((PrfBasedDeriverKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
        public PrfBasedDeriverParams getParams() {
            return ((PrfBasedDeriverKeyFormat) this.instance).getParams();
        }

        public Builder setParams(PrfBasedDeriverParams value) {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$400((PrfBasedDeriverKeyFormat) this.instance, value);
            return this;
        }

        public Builder setParams(PrfBasedDeriverParams.Builder builderForValue) {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$400((PrfBasedDeriverKeyFormat) this.instance, (PrfBasedDeriverParams) builderForValue.build());
            return this;
        }

        public Builder mergeParams(PrfBasedDeriverParams value) {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$500((PrfBasedDeriverKeyFormat) this.instance, value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            PrfBasedDeriverKeyFormat.access$600((PrfBasedDeriverKeyFormat) this.instance);
            return this;
        }
    }

    static /* synthetic */ PrfBasedDeriverKeyFormat access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(PrfBasedDeriverKeyFormat r0, KeyTemplate r1) {
        r0.setPrfKeyTemplate(r1);
    }

    static /* synthetic */ void access$200(PrfBasedDeriverKeyFormat r0, KeyTemplate r1) {
        r0.mergePrfKeyTemplate(r1);
    }

    static /* synthetic */ void access$300(PrfBasedDeriverKeyFormat r0) {
        r0.clearPrfKeyTemplate();
    }

    static /* synthetic */ void access$400(PrfBasedDeriverKeyFormat r0, PrfBasedDeriverParams r1) {
        r0.setParams(r1);
    }

    static /* synthetic */ void access$500(PrfBasedDeriverKeyFormat r0, PrfBasedDeriverParams r1) {
        r0.mergeParams(r1);
    }

    static /* synthetic */ void access$600(PrfBasedDeriverKeyFormat r0) {
        r0.clearParams();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return super.toBuilder();
    }

    private PrfBasedDeriverKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
    public boolean hasPrfKeyTemplate() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
    public KeyTemplate getPrfKeyTemplate() {
        KeyTemplate r0 = this.prfKeyTemplate_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return KeyTemplate.getDefaultInstance();
    }

    private void setPrfKeyTemplate(KeyTemplate value) {
        value.getClass();
        this.prfKeyTemplate_ = value;
        this.bitField0_ |= 1;
    }

    private void mergePrfKeyTemplate(KeyTemplate value) {
        value.getClass();
        KeyTemplate r0 = this.prfKeyTemplate_;
        if (r0 != null) goto L5;
    L7:
        this.prfKeyTemplate_ = value;
    L8:
        this.bitField0_ |= 1;
        return;
    L5:
        if (r0 == KeyTemplate.getDefaultInstance()) goto L7;
        this.prfKeyTemplate_ = (KeyTemplate) KeyTemplate.newBuilder(this.prfKeyTemplate_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearPrfKeyTemplate() {
        this.prfKeyTemplate_ = null;
        this.bitField0_ &= -2;
    }

    @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
    public boolean hasParams() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.proto.PrfBasedDeriverKeyFormatOrBuilder
    public PrfBasedDeriverParams getParams() {
        PrfBasedDeriverParams r0 = this.params_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return PrfBasedDeriverParams.getDefaultInstance();
    }

    private void setParams(PrfBasedDeriverParams value) {
        value.getClass();
        this.params_ = value;
        this.bitField0_ |= 2;
    }

    private void mergeParams(PrfBasedDeriverParams value) {
        value.getClass();
        PrfBasedDeriverParams r0 = this.params_;
        if (r0 != null) goto L5;
    L7:
        this.params_ = value;
    L8:
        this.bitField0_ |= 2;
        return;
    L5:
        if (r0 == PrfBasedDeriverParams.getDefaultInstance()) goto L7;
        this.params_ = (PrfBasedDeriverParams) PrfBasedDeriverParams.newBuilder(this.params_).mergeFrom(value).buildPartial();
        goto L8
    }

    private void clearParams() {
        this.params_ = null;
        this.bitField0_ &= -3;
    }

    public static PrfBasedDeriverKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(InputStream input) throws IOException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PrfBasedDeriverKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (PrfBasedDeriverKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static PrfBasedDeriverKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PrfBasedDeriverKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static PrfBasedDeriverKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (PrfBasedDeriverKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(PrfBasedDeriverKeyFormat prototype) {
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
        Parser<PrfBasedDeriverKeyFormat> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(PrfBasedDeriverKeyFormat.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(PrfBasedDeriverKeyFormat.class);     // Catch: Throwable -> L18
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
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "prfKeyTemplate_", "params_"});
    L27:
        return new Builder(r2);
    L29:
        return new PrfBasedDeriverKeyFormat();
    }

    static {
        PrfBasedDeriverKeyFormat r0 = new PrfBasedDeriverKeyFormat();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(PrfBasedDeriverKeyFormat.class, r0);
    }

    public static PrfBasedDeriverKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PrfBasedDeriverKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
