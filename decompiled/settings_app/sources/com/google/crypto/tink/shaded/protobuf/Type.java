package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Type extends GeneratedMessageLite<Type, Builder> implements TypeOrBuilder {
    private static final Type DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 7;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    private static volatile Parser<Type> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private int bitField0_;
    private String edition_;
    private Internal.ProtobufList<Field> fields_;
    private String name_;
    private Internal.ProtobufList<String> oneofs_;
    private Internal.ProtobufList<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.Type$1, reason: invalid class name */
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

    public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            super(Type.access$000());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public String getName() {
            return ((Type) this.instance).getName();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            return ((Type) this.instance).getNameBytes();
        }

        public Builder setName(String value) {
            copyOnWrite();
            Type.access$100((Type) this.instance, value);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            Type.access$200((Type) this.instance);
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            copyOnWrite();
            Type.access$300((Type) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public List<Field> getFieldsList() {
            return Collections.unmodifiableList(((Type) this.instance).getFieldsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            return ((Type) this.instance).getFieldsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public Field getFields(int index) {
            return ((Type) this.instance).getFields(index);
        }

        public Builder setFields(int index, Field value) {
            copyOnWrite();
            Type.access$400((Type) this.instance, index, value);
            return this;
        }

        public Builder setFields(int index, Field.Builder builderForValue) {
            copyOnWrite();
            Type.access$400((Type) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addFields(Field value) {
            copyOnWrite();
            Type.access$500((Type) this.instance, value);
            return this;
        }

        public Builder addFields(int index, Field value) {
            copyOnWrite();
            Type.access$600((Type) this.instance, index, value);
            return this;
        }

        public Builder addFields(Field.Builder builderForValue) {
            copyOnWrite();
            Type.access$500((Type) this.instance, builderForValue.build());
            return this;
        }

        public Builder addFields(int index, Field.Builder builderForValue) {
            copyOnWrite();
            Type.access$600((Type) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllFields(Iterable<? extends Field> values) {
            copyOnWrite();
            Type.access$700((Type) this.instance, values);
            return this;
        }

        public Builder clearFields() {
            copyOnWrite();
            Type.access$800((Type) this.instance);
            return this;
        }

        public Builder removeFields(int index) {
            copyOnWrite();
            Type.access$900((Type) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public List<String> getOneofsList() {
            return Collections.unmodifiableList(((Type) this.instance).getOneofsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return ((Type) this.instance).getOneofsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public String getOneofs(int index) {
            return ((Type) this.instance).getOneofs(index);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int index) {
            return ((Type) this.instance).getOneofsBytes(index);
        }

        public Builder setOneofs(int index, String value) {
            copyOnWrite();
            Type.access$1000((Type) this.instance, index, value);
            return this;
        }

        public Builder addOneofs(String value) {
            copyOnWrite();
            Type.access$1100((Type) this.instance, value);
            return this;
        }

        public Builder addAllOneofs(Iterable<String> values) {
            copyOnWrite();
            Type.access$1200((Type) this.instance, values);
            return this;
        }

        public Builder clearOneofs() {
            copyOnWrite();
            Type.access$1300((Type) this.instance);
            return this;
        }

        public Builder addOneofsBytes(ByteString value) {
            copyOnWrite();
            Type.access$1400((Type) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Type) this.instance).getOptionsList());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            return ((Type) this.instance).getOptionsCount();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public Option getOptions(int index) {
            return ((Type) this.instance).getOptions(index);
        }

        public Builder setOptions(int index, Option value) {
            copyOnWrite();
            Type.access$1500((Type) this.instance, index, value);
            return this;
        }

        public Builder setOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Type.access$1500((Type) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addOptions(Option value) {
            copyOnWrite();
            Type.access$1600((Type) this.instance, value);
            return this;
        }

        public Builder addOptions(int index, Option value) {
            copyOnWrite();
            Type.access$1700((Type) this.instance, index, value);
            return this;
        }

        public Builder addOptions(Option.Builder builderForValue) {
            copyOnWrite();
            Type.access$1600((Type) this.instance, builderForValue.build());
            return this;
        }

        public Builder addOptions(int index, Option.Builder builderForValue) {
            copyOnWrite();
            Type.access$1700((Type) this.instance, index, builderForValue.build());
            return this;
        }

        public Builder addAllOptions(Iterable<? extends Option> values) {
            copyOnWrite();
            Type.access$1800((Type) this.instance, values);
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            Type.access$1900((Type) this.instance);
            return this;
        }

        public Builder removeOptions(int index) {
            copyOnWrite();
            Type.access$2000((Type) this.instance, index);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            return ((Type) this.instance).hasSourceContext();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public SourceContext getSourceContext() {
            return ((Type) this.instance).getSourceContext();
        }

        public Builder setSourceContext(SourceContext value) {
            copyOnWrite();
            Type.access$2100((Type) this.instance, value);
            return this;
        }

        public Builder setSourceContext(SourceContext.Builder builderForValue) {
            copyOnWrite();
            Type.access$2100((Type) this.instance, builderForValue.build());
            return this;
        }

        public Builder mergeSourceContext(SourceContext value) {
            copyOnWrite();
            Type.access$2200((Type) this.instance, value);
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            Type.access$2300((Type) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return ((Type) this.instance).getSyntaxValue();
        }

        public Builder setSyntaxValue(int value) {
            copyOnWrite();
            Type.access$2400((Type) this.instance, value);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public Syntax getSyntax() {
            return ((Type) this.instance).getSyntax();
        }

        public Builder setSyntax(Syntax value) {
            copyOnWrite();
            Type.access$2500((Type) this.instance, value);
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            Type.access$2600((Type) this.instance);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public String getEdition() {
            return ((Type) this.instance).getEdition();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
        public ByteString getEditionBytes() {
            return ((Type) this.instance).getEditionBytes();
        }

        public Builder setEdition(String value) {
            copyOnWrite();
            Type.access$2700((Type) this.instance, value);
            return this;
        }

        public Builder clearEdition() {
            copyOnWrite();
            Type.access$2800((Type) this.instance);
            return this;
        }

        public Builder setEditionBytes(ByteString value) {
            copyOnWrite();
            Type.access$2900((Type) this.instance, value);
            return this;
        }
    }

    static /* synthetic */ Type access$000() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ void access$100(Type r0, String r1) {
        r0.setName(r1);
    }

    static /* synthetic */ void access$1000(Type r0, int r1, String r2) {
        r0.setOneofs(r1, r2);
    }

    static /* synthetic */ void access$1100(Type r0, String r1) {
        r0.addOneofs(r1);
    }

    static /* synthetic */ void access$1200(Type r0, Iterable r1) {
        r0.addAllOneofs(r1);
    }

    static /* synthetic */ void access$1300(Type r0) {
        r0.clearOneofs();
    }

    static /* synthetic */ void access$1400(Type r0, ByteString r1) {
        r0.addOneofsBytes(r1);
    }

    static /* synthetic */ void access$1500(Type r0, int r1, Option r2) {
        r0.setOptions(r1, r2);
    }

    static /* synthetic */ void access$1600(Type r0, Option r1) {
        r0.addOptions(r1);
    }

    static /* synthetic */ void access$1700(Type r0, int r1, Option r2) {
        r0.addOptions(r1, r2);
    }

    static /* synthetic */ void access$1800(Type r0, Iterable r1) {
        r0.addAllOptions(r1);
    }

    static /* synthetic */ void access$1900(Type r0) {
        r0.clearOptions();
    }

    static /* synthetic */ void access$200(Type r0) {
        r0.clearName();
    }

    static /* synthetic */ void access$2000(Type r0, int r1) {
        r0.removeOptions(r1);
    }

    static /* synthetic */ void access$2100(Type r0, SourceContext r1) {
        r0.setSourceContext(r1);
    }

    static /* synthetic */ void access$2200(Type r0, SourceContext r1) {
        r0.mergeSourceContext(r1);
    }

    static /* synthetic */ void access$2300(Type r0) {
        r0.clearSourceContext();
    }

    static /* synthetic */ void access$2400(Type r0, int r1) {
        r0.setSyntaxValue(r1);
    }

    static /* synthetic */ void access$2500(Type r0, Syntax r1) {
        r0.setSyntax(r1);
    }

    static /* synthetic */ void access$2600(Type r0) {
        r0.clearSyntax();
    }

    static /* synthetic */ void access$2700(Type r0, String r1) {
        r0.setEdition(r1);
    }

    static /* synthetic */ void access$2800(Type r0) {
        r0.clearEdition();
    }

    static /* synthetic */ void access$2900(Type r0, ByteString r1) {
        r0.setEditionBytes(r1);
    }

    static /* synthetic */ void access$300(Type r0, ByteString r1) {
        r0.setNameBytes(r1);
    }

    static /* synthetic */ void access$400(Type r0, int r1, Field r2) {
        r0.setFields(r1, r2);
    }

    static /* synthetic */ void access$500(Type r0, Field r1) {
        r0.addFields(r1);
    }

    static /* synthetic */ void access$600(Type r0, int r1, Field r2) {
        r0.addFields(r1, r2);
    }

    static /* synthetic */ void access$700(Type r0, Iterable r1) {
        r0.addAllFields(r1);
    }

    static /* synthetic */ void access$800(Type r0) {
        r0.clearFields();
    }

    static /* synthetic */ void access$900(Type r0, int r1) {
        r0.removeFields(r1);
    }

    private Type() {
        this.name_ = "";
        this.fields_ = emptyProtobufList();
        this.oneofs_ = GeneratedMessageLite.emptyProtobufList();
        this.options_ = emptyProtobufList();
        this.edition_ = "";
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public List<Field> getFieldsList() {
        return this.fields_;
    }

    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public Field getFields(int index) {
        return this.fields_.get(index);
    }

    public FieldOrBuilder getFieldsOrBuilder(int index) {
        return this.fields_.get(index);
    }

    private void ensureFieldsIsMutable() {
        Internal.ProtobufList<Field> r0 = this.fields_;
        if (r0.isModifiable() == true) goto L6;
        this.fields_ = GeneratedMessageLite.mutableCopy(r0);
        return;
    }

    private void setFields(int index, Field value) {
        value.getClass();
        ensureFieldsIsMutable();
        this.fields_.set(index, value);
    }

    private void addFields(Field value) {
        value.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(value);
    }

    private void addFields(int index, Field value) {
        value.getClass();
        ensureFieldsIsMutable();
        this.fields_.add(index, value);
    }

    private void addAllFields(Iterable<? extends Field> values) {
        ensureFieldsIsMutable();
        AbstractMessageLite.addAll(values, this.fields_);
    }

    private void clearFields() {
        this.fields_ = emptyProtobufList();
    }

    private void removeFields(int index) {
        ensureFieldsIsMutable();
        this.fields_.remove(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public List<String> getOneofsList() {
        return this.oneofs_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.oneofs_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public String getOneofs(int index) {
        return this.oneofs_.get(index);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int index) {
        return ByteString.copyFromUtf8(this.oneofs_.get(index));
    }

    private void ensureOneofsIsMutable() {
        Internal.ProtobufList<String> r0 = this.oneofs_;
        if (r0.isModifiable() == true) goto L6;
        this.oneofs_ = GeneratedMessageLite.mutableCopy(r0);
        return;
    }

    private void setOneofs(int index, String value) {
        value.getClass();
        ensureOneofsIsMutable();
        this.oneofs_.set(index, value);
    }

    private void addOneofs(String value) {
        value.getClass();
        ensureOneofsIsMutable();
        this.oneofs_.add(value);
    }

    private void addAllOneofs(Iterable<String> values) {
        ensureOneofsIsMutable();
        AbstractMessageLite.addAll(values, this.oneofs_);
    }

    private void clearOneofs() {
        this.oneofs_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void addOneofsBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        ensureOneofsIsMutable();
        this.oneofs_.add(value.toStringUtf8());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public boolean hasSourceContext() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
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

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
    public String getEdition() {
        return this.edition_;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.TypeOrBuilder
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

    public static Type parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Type parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Type parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Type parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Type parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Type parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Type parseFrom(InputStream input) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Type parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Type parseDelimitedFrom(InputStream input) throws IOException {
        return (Type) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Type parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Type) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Type parseFrom(CodedInputStream input) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Type parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Type prototype) {
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
        Parser<Type> r0 = PARSER;
        if (r0 == null) goto L12;
    L21:
        return r0;
    L12:
        monitor-enter(Type.class);
        r0 = PARSER;     // Catch: Throwable -> L18
        if (r0 != null) goto L16;
        r0 = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);     // Catch: Throwable -> L18
        PARSER = r0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(Type.class);     // Catch: Throwable -> L18
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
        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003Ț\u0004\u001b\u0005ဉ\u0000\u0006\f\u0007Ȉ", new Object[]{"bitField0_", "name_", "fields_", Field.class, "oneofs_", "options_", Option.class, "sourceContext_", "syntax_", "edition_"});
    L27:
        return new Builder(r2);
    L29:
        return new Type();
    }

    static {
        Type r0 = new Type();
        DEFAULT_INSTANCE = r0;
        GeneratedMessageLite.registerDefaultInstance(Type.class, r0);
    }

    public static Type getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Type> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
