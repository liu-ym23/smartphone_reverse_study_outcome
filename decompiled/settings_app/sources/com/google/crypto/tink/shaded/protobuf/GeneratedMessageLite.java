package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap;
    private int memoizedSerializedSize;
    protected UnknownFieldSetLite unknownFields;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType = null;

        static {
            int[] r0 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = r0;
            r0[WireFormat.JavaType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo952clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
            return internalMergeFrom((GeneratedMessageLite) message);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
            return mergeFrom(input, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(input, offset, length, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
            return mergeFrom(input, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(input, offset, length, extensionRegistry);
        }

        protected Builder(MessageType r1) {
            this.defaultInstance = r1;
            if (r1.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        private MessageType newMutableInstance() {
            return (MessageType) this.defaultInstance.newMutableInstance();
        }

        protected final void copyOnWrite() {
            if (this.instance.isMutable() == true) goto L6;
            copyOnWriteInternal();
            return;
        }

        protected void copyOnWriteInternal() {
            MessageType r0 = (MessageType) newMutableInstance();
            mergeFromInstance(r0, this.instance);
            this.instance = r0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public final BuilderType clear() {
            if (this.defaultInstance.isMutable() == true) goto L7;
            this.instance = (MessageType) newMutableInstance();
            return this;
        L7:
            throw new IllegalArgumentException("Default instance must be immutable.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType clone() {
            BuilderType r0 = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            r0.instance = (MessageType) buildPartial();
            return r0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public MessageType buildPartial() {
            if (this.instance.isMutable() == false) goto L5;
            this.instance.makeImmutable();
            return this.instance;
        L5:
            return this.instance;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public final MessageType build() {
            MessageType r1 = (MessageType) buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
        }

        protected BuilderType internalMergeFrom(MessageType r1) {
            return (BuilderType) mergeFrom(r1);
        }

        public BuilderType mergeFrom(MessageType message) {
            if (getDefaultInstanceForType().equals(message) == false) goto L5;
            return this;
        L5:
            copyOnWrite();
            mergeFromInstance(this.instance, message);
            return this;
        }

        private static <MessageType> void mergeFromInstance(MessageType dest, MessageType src) {
            Protobuf.getInstance().schemaFor(dest).mergeFrom(dest, src);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, input, offset, offset + length, new ArrayDecoders.Registers(extensionRegistry));     // Catch: IOException -> L5 IndexOutOfBoundsException -> L8 InvalidProtocolBufferException -> L10
            return this;
        L10:
            e = move-exception;
            throw e;
        L5:
            e = move-exception;
            throw new RuntimeException("Reading from byte array should not throw IOException.", e);
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r2, int r3, int r4) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r2, r3, r4, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            copyOnWrite();
            Protobuf.getInstance().schemaFor(this.instance).mergeFrom(this.instance, CodedInputStreamReader.forCodedInput(input), extensionRegistry);     // Catch: RuntimeException -> L5
            return this;
        L5:
            e = move-exception;
            if ((e.getCause() instanceof IOException) == true) goto L9;
            throw e;
        L9:
            throw ((IOException) e.getCause());
        }
    }

    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractParser, com.google.crypto.tink.shaded.protobuf.Parser
        public /* bridge */ /* synthetic */ MessageLite parsePartialFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return parsePartialFrom(input, offset, length, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return parsePartialFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractParser, com.google.crypto.tink.shaded.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return parsePartialFrom(input, offset, length, extensionRegistry);
        }

        public DefaultInstanceBasedParser(T defaultInstance) {
            this.defaultInstance = defaultInstance;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Parser
        public T parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.parsePartialFrom(this.defaultInstance, r1, r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractParser, com.google.crypto.tink.shaded.protobuf.Parser
        public T parsePartialFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return (T) GeneratedMessageLite.access$200(this.defaultInstance, r1, r2, r3, r4);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        protected ExtendableBuilder(MessageType defaultInstance) {
            super(defaultInstance);
        }

        void internalSetExtensionSet(FieldSet<ExtensionDescriptor> extensions) {
            copyOnWrite();
            ((ExtendableMessage) this.instance).extensions = extensions;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder
        protected void copyOnWriteInternal() {
            super.copyOnWriteInternal();
            if (((ExtendableMessage) this.instance).extensions == FieldSet.emptySet()) goto L6;
            ExtendableMessage r0 = (ExtendableMessage) this.instance;
            r0.extensions = ((ExtendableMessage) this.instance).extensions.clone();
            return;
        }

        private FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            FieldSet<ExtensionDescriptor> r0 = ((ExtendableMessage) this.instance).extensions;
            if (r0.isImmutable() == false) goto L6;
            FieldSet r1 = r0.clone();
            ((ExtendableMessage) this.instance).extensions = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public final MessageType buildPartial() {
            if (((ExtendableMessage) this.instance).isMutable() == false) goto L5;
            ((ExtendableMessage) this.instance).extensions.makeImmutable();
            return (MessageType) super.buildPartial();
        L5:
            return (MessageType) this.instance;
        }

        private void verifyExtensionContainingType(final GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(final ExtensionLite<MessageType, Type> extension) {
            return ((ExtendableMessage) this.instance).hasExtension(extension);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(final ExtensionLite<MessageType, List<Type>> extension) {
            return ((ExtendableMessage) this.instance).getExtensionCount(extension);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r1) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r1, int r2) {
            return (Type) ((ExtendableMessage) this.instance).getExtension(r1, r2);
        }

        public final <Type> BuilderType setExtension(final ExtensionLite<MessageType, Type> extension, final Type value) {
            GeneratedExtension<MessageType, ?> r3 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r3);
            copyOnWrite();
            ensureExtensionsAreMutable().setField(r3.descriptor, r3.toFieldSetType(value));
            return this;
        }

        public final <Type> BuilderType setExtension(final ExtensionLite<MessageType, List<Type>> extension, final int index, final Type value) {
            GeneratedExtension<MessageType, ?> r3 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r3);
            copyOnWrite();
            ensureExtensionsAreMutable().setRepeatedField(r3.descriptor, index, r3.singularToFieldSetType(value));
            return this;
        }

        public final <Type> BuilderType addExtension(final ExtensionLite<MessageType, List<Type>> extension, final Type value) {
            GeneratedExtension<MessageType, ?> r3 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r3);
            copyOnWrite();
            ensureExtensionsAreMutable().addRepeatedField(r3.descriptor, r3.singularToFieldSetType(value));
            return this;
        }

        public final BuilderType clearExtension(final ExtensionLite<MessageType, ?> extension) {
            GeneratedExtension<MessageType, ?> r2 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r2);
            copyOnWrite();
            ensureExtensionsAreMutable().clearField(r2.descriptor);
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;
            final /* synthetic */ ExtendableMessage this$0;

            /* synthetic */ ExtensionWriter(ExtendableMessage r1, boolean r2, AnonymousClass1 r3) {
                this(r1, r2);
            }

            private ExtensionWriter(final ExtendableMessage this$0, boolean messageSetWireFormat) {
                this.this$0 = this$0;
                Iterator r2 = this$0.extensions.iterator();
                this.iter = r2;
                if (r2.hasNext() == false) goto L5;
                this.next = (Map.Entry) r2.next();
            L5:
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(final int end, final CodedOutputStream output) throws IOException {
            L2:
                Map.Entry<ExtensionDescriptor, Object> r0 = this.next;
                if (r0 == null) goto L18;
                if (r0.getKey().getNumber() >= end) goto L26;
                ExtensionDescriptor r1 = this.next.getKey();
                if (this.messageSetWireFormat == true) goto L9;
            L13:
                FieldSet.writeField(r1, this.next.getValue(), output);
            L15:
                if (this.iter.hasNext() == true) goto L16;
                this.next = null;
                goto L2
            L16:
                this.next = this.iter.next();
                goto L2
            L9:
                if (r1.getLiteJavaType() != WireFormat.JavaType.MESSAGE) goto L13;
                if (r1.isRepeated() == true) goto L13;
                output.writeMessageSetExtension(r1.getNumber(), (MessageLite) this.next.getValue());
                goto L15
            L26:
                return;
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.emptySet();
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

        protected final void mergeExtensionFields(final MessageType other) {
            if (this.extensions.isImmutable() == false) goto L5;
            this.extensions = this.extensions.clone();
        L5:
            this.extensions.mergeFrom(other.extensions);
        }

        protected <MessageType extends MessageLite> boolean parseUnknownField(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            int r5 = WireFormat.getTagFieldNumber(tag);
            return parseExtension(input, extensionRegistry, extensionRegistry.findLiteExtensionByNumber(defaultInstance, r5), tag, r5);
        }

        private boolean parseExtension(CodedInputStream input, ExtensionRegistryLite extensionRegistry, GeneratedExtension<?, ?> extension, int tag, int fieldNumber) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (extension != null) goto L6;
        L4:
            boolean r1 = true;
            boolean r3 = false;
        L15:
            if (r1 == true) goto L17;
            ensureExtensionsAreMutable();
            if (r3 == false) goto L32;
            int r6 = input.pushLimit(input.readRawVarint32());
            if (extension.descriptor.getLiteType() != WireFormat.FieldType.ENUM) goto L29;
        L23:
            if (input.getBytesUntilLimit() <= 0) goto L31;
            Internal.EnumLite r8 = extension.descriptor.getEnumType().findValueByNumber(input.readEnum());
            if (r8 == null) goto L26;
            this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(r8));
            goto L23
        L26:
            return true;
        L31:
            input.popLimit(r6);
        L59:
            return true;
        L29:
            if (input.getBytesUntilLimit() <= 0) goto L31;
            this.extensions.addRepeatedField(extension.descriptor, FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false));
            goto L29
        L32:
            int r9 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[extension.descriptor.getLiteJavaType().ordinal()];
            if (r9 == 1) goto L43;
            if (r9 == 2) goto L37;
            Object r5 = FieldSet.readPrimitiveField(input, extension.descriptor.getLiteType(), false);
        L56:
            if (extension.descriptor.isRepeated() == false) goto L58;
            this.extensions.addRepeatedField(extension.descriptor, extension.singularToFieldSetType(r5));
            goto L59
        L58:
            this.extensions.setField(extension.descriptor, extension.singularToFieldSetType(r5));
            goto L59
        L37:
            int r7 = input.readEnum();
            Internal.EnumLite r10 = extension.descriptor.getEnumType().findValueByNumber(r7);
            if (r10 != null) goto L41;
            mergeVarintField(fieldNumber, r7);
            return true;
        L41:
            r5 = r10;
            goto L56
        L43:
            if (extension.descriptor.isRepeated() == true) goto L47;
            MessageLite r11 = (MessageLite) this.extensions.getField(extension.descriptor);
            if (r11 == null) goto L47;
            MessageLite.Builder r12 = r11.toBuilder();
        L48:
            if (r12 != null) goto L51;
            r12 = extension.getMessageDefaultInstance().newBuilderForType();
        L51:
            if (extension.descriptor.getLiteType() != WireFormat.FieldType.GROUP) goto L53;
            input.readGroup(extension.getNumber(), r12, extensionRegistry);
        L54:
            r5 = r12.build();
            goto L56
        L53:
            input.readMessage(r12, extensionRegistry);
        L47:
            r12 = null;
            goto L48
        L17:
            return parseUnknownField(tag, input);
        L6:
            if (r0 != FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), false)) goto L9;
            r1 = false;
            r3 = false;
            goto L15
        L9:
            if (extension.descriptor.isRepeated == false) goto L4;
            if (extension.descriptor.type.isPackable() == false) goto L4;
            if (r0 != FieldSet.getWireFormatForFieldType(extension.descriptor.getLiteType(), true)) goto L4;
            r3 = true;
            r1 = false;
            goto L15
        }

        protected <MessageType extends MessageLite> boolean parseUnknownFieldAsMessageSet(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            if (tag != WireFormat.MESSAGE_SET_ITEM_TAG) goto L7;
            mergeMessageSetExtensionFromCodedStream(defaultInstance, input, extensionRegistry);
            return true;
        L7:
            if (WireFormat.getTagWireType(tag) != 2) goto L11;
            return parseUnknownField(defaultInstance, input, extensionRegistry, tag);
        L11:
            return input.skipField(tag);
        }

        private <MessageType extends MessageLite> void mergeMessageSetExtensionFromCodedStream(MessageType defaultInstance, CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = 0;
            ByteString r2 = null;
            GeneratedExtension<?, ?> r3 = null;
        L3:
            int r4 = input.readTag();
            if (r4 == 0) goto L19;
            if (r4 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) goto L8;
            if (r4 == WireFormat.MESSAGE_SET_MESSAGE_TAG) goto L13;
            if (input.skipField(r4) == true) goto L3;
        L13:
            if (r0 == 0) goto L16;
            if (r3 == null) goto L16;
            eagerlyMergeMessageSetExtension(input, r3, extensionRegistry, r0);
            r2 = null;
        L16:
            r2 = input.readBytes();
            goto L3
        L8:
            r0 = input.readUInt32();
            if (r0 == 0) goto L3;
            r3 = extensionRegistry.findLiteExtensionByNumber(defaultInstance, r0);
        L19:
            input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (r2 == null) goto L43;
            if (r0 == 0) goto L44;
            if (r3 == null) goto L24;
            mergeMessageSetExtensionFromBytes(r2, extensionRegistry, r3);
            return;
        L24:
            if (r2 == null) goto L46;
            mergeLengthDelimitedField(r0, r2);
            return;
        L46:
            return;
        L44:
            return;
        }

        private void eagerlyMergeMessageSetExtension(CodedInputStream input, GeneratedExtension<?, ?> extension, ExtensionRegistryLite extensionRegistry, int typeId) throws IOException {
            parseExtension(input, extensionRegistry, extension, WireFormat.makeTag(typeId, 2), typeId);
        }

        private void mergeMessageSetExtensionFromBytes(ByteString rawBytes, ExtensionRegistryLite extensionRegistry, GeneratedExtension<?, ?> extension) throws IOException {
            MessageLite r0 = (MessageLite) this.extensions.getField(extension.descriptor);
            if (r0 == null) goto L5;
            MessageLite.Builder r1 = r0.toBuilder();
        L6:
            if (r1 != null) goto L8;
            r1 = extension.getMessageDefaultInstance().newBuilderForType();
        L8:
            r1.mergeFrom(rawBytes, extensionRegistry);
            MessageLite r3 = r1.build();
            ensureExtensionsAreMutable().setField(extension.descriptor, extension.singularToFieldSetType(r3));
            return;
        L5:
            r1 = null;
            goto L6
        }

        FieldSet<ExtensionDescriptor> ensureExtensionsAreMutable() {
            if (this.extensions.isImmutable() == false) goto L6;
            this.extensions = this.extensions.clone();
        L6:
            return this.extensions;
        }

        private void verifyExtensionContainingType(final GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(final ExtensionLite<MessageType, Type> extension) {
            GeneratedExtension<MessageType, ?> r1 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r1);
            return this.extensions.hasField(r1.descriptor);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(final ExtensionLite<MessageType, List<Type>> extension) {
            GeneratedExtension<MessageType, ?> r1 = GeneratedMessageLite.access$000(extension);
            verifyExtensionContainingType(r1);
            return this.extensions.getRepeatedFieldCount(r1.descriptor);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> r2) {
            GeneratedExtension<MessageType, ?> r3 = GeneratedMessageLite.access$000(r2);
            verifyExtensionContainingType(r3);
            Object r1 = this.extensions.getField(r3.descriptor);
            if (r1 != null) goto L7;
            return r3.defaultValue;
        L7:
            return (Type) r3.fromFieldSetType(r1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> r2, int r3) {
            GeneratedExtension<MessageType, ?> r4 = GeneratedMessageLite.access$000(r2);
            verifyExtensionContainingType(r4);
            return (Type) r4.singularFromFieldSetType(this.extensions.getRepeatedField(r4.descriptor, r3));
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected ExtendableMessage<MessageType, BuilderType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
        <Type> Type getExtension(ExtensionLite<MessageType, Type> extension);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extension, int index);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extension);

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extension);
    }

    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        final Internal.EnumLiteMap<?> enumTypeMap;
        final boolean isPacked;
        final boolean isRepeated;
        final int number;
        final WireFormat.FieldType type;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object other) {
            return compareTo((ExtensionDescriptor) other);
        }

        ExtensionDescriptor(final Internal.EnumLiteMap<?> enumTypeMap, final int number, final WireFormat.FieldType type, final boolean isRepeated, final boolean isPacked) {
            this.enumTypeMap = enumTypeMap;
            this.number = number;
            this.type = type;
            this.isRepeated = isRepeated;
            this.isPacked = isPacked;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
            return ((Builder) to).mergeFrom((GeneratedMessageLite) from);
        }

        public int compareTo(ExtensionDescriptor other) {
            return this.number - other.number;
        }
    }

    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
        final ContainingType containingTypeDefaultInstance;
        final Type defaultValue;
        final ExtensionDescriptor descriptor;
        final MessageLite messageDefaultInstance;

        GeneratedExtension(final ContainingType containingTypeDefaultInstance, final Type defaultValue, final MessageLite messageDefaultInstance, final ExtensionDescriptor descriptor, final Class singularType) {
            if (containingTypeDefaultInstance == null) goto L13;
            if (descriptor.getLiteType() != WireFormat.FieldType.MESSAGE) goto L10;
            if (messageDefaultInstance != null) goto L10;
            throw new IllegalArgumentException("Null messageDefaultInstance");
        L10:
            this.containingTypeDefaultInstance = containingTypeDefaultInstance;
            this.defaultValue = defaultValue;
            this.messageDefaultInstance = messageDefaultInstance;
            this.descriptor = descriptor;
            return;
        L13:
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ExtensionLite
        public int getNumber() {
            return this.descriptor.getNumber();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ExtensionLite
        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        Object fromFieldSetType(Object value) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r0 = new ArrayList();
            Iterator r3 = ((List) value).iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            r0.add(singularFromFieldSetType(r3.next()));
            goto L8
        L10:
            return r0;
        L11:
            return value;
        L13:
            return singularFromFieldSetType(value);
        }

        Object singularFromFieldSetType(Object value) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return value;
        L5:
            return this.descriptor.enumTypeMap.findValueByNumber(((Integer) value).intValue());
        }

        Object toFieldSetType(Object value) {
            if (this.descriptor.isRepeated() == false) goto L13;
            if (this.descriptor.getLiteJavaType() != WireFormat.JavaType.ENUM) goto L11;
            ArrayList r0 = new ArrayList();
            Iterator r3 = ((List) value).iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            r0.add(singularToFieldSetType(r3.next()));
            goto L8
        L10:
            return r0;
        L11:
            return value;
        L13:
            return singularToFieldSetType(value);
        }

        Object singularToFieldSetType(Object value) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) goto L5;
            return value;
        L5:
            return Integer.valueOf(((Internal.EnumLite) value).getNumber());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return this.descriptor.getLiteType();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ExtensionLite
        public boolean isRepeated() {
            return this.descriptor.isRepeated;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ExtensionLite
        public Type getDefaultValue() {
            return this.defaultValue;
        }
    }

    public static final enum MethodToInvoke extends java.lang.Enum<MethodToInvoke> {
        private static final /* synthetic */ MethodToInvoke[] $VALUES = null;
        public static final MethodToInvoke BUILD_MESSAGE_INFO = null;
        public static final MethodToInvoke GET_DEFAULT_INSTANCE = null;
        public static final MethodToInvoke GET_MEMOIZED_IS_INITIALIZED = null;
        public static final MethodToInvoke GET_PARSER = null;
        public static final MethodToInvoke NEW_BUILDER = null;
        public static final MethodToInvoke NEW_MUTABLE_INSTANCE = null;
        public static final MethodToInvoke SET_MEMOIZED_IS_INITIALIZED = null;

        private MethodToInvoke(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static MethodToInvoke valueOf(String name) {
            return (MethodToInvoke) java.lang.Enum.valueOf(MethodToInvoke.class, name);
        }

        public static MethodToInvoke[] values() {
            return (MethodToInvoke[]) $VALUES.clone();
        }

        static {
            MethodToInvoke r0 = new MethodToInvoke("GET_MEMOIZED_IS_INITIALIZED", 0);
            GET_MEMOIZED_IS_INITIALIZED = r0;
            MethodToInvoke r1 = new MethodToInvoke("SET_MEMOIZED_IS_INITIALIZED", 1);
            SET_MEMOIZED_IS_INITIALIZED = r1;
            MethodToInvoke r3 = new MethodToInvoke("BUILD_MESSAGE_INFO", 2);
            BUILD_MESSAGE_INFO = r3;
            MethodToInvoke r5 = new MethodToInvoke("NEW_MUTABLE_INSTANCE", 3);
            NEW_MUTABLE_INSTANCE = r5;
            MethodToInvoke r7 = new MethodToInvoke("NEW_BUILDER", 4);
            NEW_BUILDER = r7;
            MethodToInvoke r9 = new MethodToInvoke("GET_DEFAULT_INSTANCE", 5);
            GET_DEFAULT_INSTANCE = r9;
            MethodToInvoke r11 = new MethodToInvoke("GET_PARSER", 6);
            GET_PARSER = r11;
            $VALUES = new MethodToInvoke[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public static SerializedForm of(MessageLite message) {
            return new SerializedForm(message);
        }

        SerializedForm(MessageLite regularForm) {
            this.messageClass = regularForm.getClass();
            this.messageClassName = regularForm.getClass().getName();
            this.asBytes = regularForm.toByteArray();
        }

        protected Object readResolve() throws ObjectStreamException {
            java.lang.reflect.Field r0 = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L15
            r0.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L15
            return ((MessageLite) r0.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L15:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e);
        L14:
            return readResolveFallback();
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            java.lang.reflect.Field r0 = resolveMessageClass().getDeclaredField("defaultInstance");     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            r0.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L4 IllegalAccessException -> L7 SecurityException -> L10 NoSuchFieldException -> L13 ClassNotFoundException -> L16
            return ((MessageLite) r0.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to understand proto buffer", e);
        L16:
            e = move-exception;
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to call parsePartialFrom", e);
        L13:
            e = move-exception;
            throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e);
        L10:
            e = move-exception;
            throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e);
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> r0 = this.messageClass;
            if (r0 == null) goto L6;
            return r0;
        L6:
            return Class.forName(this.messageClassName);
        }
    }

    protected abstract Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1);

    public GeneratedMessageLite() {
        this.memoizedSerializedSize = -1;
        this.unknownFields = UnknownFieldSetLite.getDefaultInstance();
    }

    static /* synthetic */ GeneratedExtension access$000(ExtensionLite r0) {
        return checkIsLite(r0);
    }

    static /* synthetic */ GeneratedMessageLite access$200(GeneratedMessageLite r0, byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return parsePartialFrom(r0, r1, r2, r3, r4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    boolean isMutable() {
        if ((this.memoizedSerializedSize & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    void setMemoizedHashCode(int value) {
        this.memoizedHashCode = value;
    }

    void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    boolean hashCodeIsNotMemoized() {
        if (getMemoizedHashCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    MessageType newMutableInstance() {
        return (MessageType) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    public int hashCode() {
        if (isMutable() == false) goto L7;
        return computeHashCode();
    L7:
        if (hashCodeIsNotMemoized() == false) goto L10;
        setMemoizedHashCode(computeHashCode());
    L10:
        return getMemoizedHashCode();
    }

    int computeHashCode() {
        return Protobuf.getInstance().schemaFor(this).hashCode(this);
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if (getClass() == other.getClass()) goto L12;
        return false;
    L12:
        return Protobuf.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) other);
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        this.unknownFields = UnknownFieldSetLite.newInstance();
        return;
    }

    protected boolean parseUnknownField(int tag, CodedInputStream input) throws IOException {
        if (WireFormat.getTagWireType(tag) != 4) goto L6;
        return false;
    L6:
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(tag, input);
    }

    protected void mergeVarintField(int tag, int value) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(tag, value);
    }

    protected void mergeLengthDelimitedField(int fieldNumber, ByteString value) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(fieldNumber, value);
    }

    protected void makeImmutable() {
        Protobuf.getInstance().schemaFor(this).makeImmutable(this);
        markImmutable();
    }

    protected final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    protected final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType r1) {
        return (BuilderType) createBuilder().mergeFrom(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return isInitialized(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final BuilderType toBuilder() {
        return (BuilderType) ((Builder) dynamicMethod(MethodToInvoke.NEW_BUILDER)).mergeFrom(this);
    }

    protected Object dynamicMethod(MethodToInvoke method, Object arg0) {
        return dynamicMethod(method, arg0, null);
    }

    protected Object dynamicMethod(MethodToInvoke method) {
        return dynamicMethod(method, null, null);
    }

    void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int size) {
        if (size < 0) goto L6;
        this.memoizedSerializedSize = (size & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        return;
    L6:
        throw new IllegalStateException("serialized size must be non-negative, was " + size);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        Protobuf.getInstance().schemaFor(this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(output));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    int getSerializedSize(Schema schema) {
        if (isMutable() == false) goto L10;
        int r2 = computeSerializedSize(schema);
        if (r2 < 0) goto L8;
        return r2;
    L8:
        throw new IllegalStateException("serialized size must be non-negative, was " + r2);
    L10:
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) goto L12;
        int r3 = computeSerializedSize(schema);
        setMemoizedSerializedSize(r3);
        return r3;
    L12:
        return getMemoizedSerializedSize();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    private int computeSerializedSize(Schema<?> nullableSchema) {
        if (nullableSchema != null) goto L6;
        return Protobuf.getInstance().schemaFor(this).getSerializedSize(this);
    L6:
        return nullableSchema.getSerializedSize(this);
    }

    Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    static {
        defaultInstanceMap = new ConcurrentHashMap();
    }

    static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> r3) {
        GeneratedMessageLite<?, ?> r0 = defaultInstanceMap.get(r3);
        if (r0 == null) goto L16;
    L9:
        if (r0 != null) goto L15;
        r0 = (T) ((GeneratedMessageLite) UnsafeUtil.allocateInstance(r3)).getDefaultInstanceForType();
        if (r0 == null) goto L14;
        defaultInstanceMap.put(r3, r0);
        goto L15
    L14:
        throw new IllegalStateException();
    L15:
        return (T) r0;
    L16:
        Class.forName(r3.getName(), true, r3.getClassLoader());     // Catch: ClassNotFoundException -> L6
        r0 = defaultInstanceMap.get(r3);
    L6:
        e = move-exception;
        throw new IllegalStateException("Class initialization cannot fail.", e);
    }

    protected static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> clazz, T defaultInstance) {
        defaultInstance.markImmutable();
        defaultInstanceMap.put(clazz, defaultInstance);
    }

    protected static Object newMessageInfo(MessageLite defaultInstance, String info, Object[] objects) {
        return new RawMessageInfo(defaultInstance, info, objects);
    }

    protected final void mergeUnknownFields(UnknownFieldSetLite unknownFields) {
        this.unknownFields = UnknownFieldSetLite.mutableCopyOf(this.unknownFields, unknownFields);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(final ContainingType containingTypeDefaultInstance, final Type defaultValue, final MessageLite messageDefaultInstance, final Internal.EnumLiteMap<?> enumTypeMap, final int number, final WireFormat.FieldType type, final Class singularType) {
        return new GeneratedExtension(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, false, false), singularType);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(final ContainingType containingTypeDefaultInstance, final MessageLite messageDefaultInstance, final Internal.EnumLiteMap<?> enumTypeMap, final int number, final WireFormat.FieldType type, final boolean isPacked, final Class singularType) {
        return new GeneratedExtension(containingTypeDefaultInstance, Collections.emptyList(), messageDefaultInstance, new ExtensionDescriptor(enumTypeMap, number, type, true, isPacked), singularType);
    }

    static java.lang.reflect.Method getMethodOrDie(Class clazz, String name, Class... params) {
        return clazz.getMethod(name, params);
    L4:
        e = move-exception;
        throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
    }

    static Object invokeOrDie(java.lang.reflect.Method method, Object object, Object... params) {
        return method.invoke(object, params);
    L15:
        e = move-exception;
        throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
    L4:
        e = move-exception;
        Throwable r0 = e.getCause();
        if ((r0 instanceof RuntimeException) == true) goto L14;
        if ((r0 instanceof Error) == false) goto L12;
        throw ((Error) r0);
    L12:
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", r0);
    L14:
        throw ((RuntimeException) r0);
    }

    private static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extension) {
        if (extension.isLite() == false) goto L7;
        return (GeneratedExtension) extension;
    L7:
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T message, boolean shouldMemoize) {
        byte r0 = ((Byte) message.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        boolean r1 = Protobuf.getInstance().schemaFor(message).isInitialized(message);
        if (shouldMemoize == false) goto L15;
        MethodToInvoke r3 = MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED;
        if (r1 == false) goto L13;
        Object r2 = message;
    L14:
        message.dynamicMethod(r3, r2);
        goto L15
    L13:
        r2 = null;
    L15:
        return r1;
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.crypto.tink.shaded.protobuf.Internal$IntList] */
    protected static Internal.IntList mutableCopy(Internal.IntList list) {
        int r0 = list.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.crypto.tink.shaded.protobuf.Internal$LongList] */
    protected static Internal.LongList mutableCopy(Internal.LongList list) {
        int r0 = list.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    protected static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.crypto.tink.shaded.protobuf.Internal$FloatList] */
    protected static Internal.FloatList mutableCopy(Internal.FloatList list) {
        int r0 = list.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.crypto.tink.shaded.protobuf.Internal$DoubleList] */
    protected static Internal.DoubleList mutableCopy(Internal.DoubleList list) {
        int r0 = list.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.crypto.tink.shaded.protobuf.Internal$BooleanList] */
    protected static Internal.BooleanList mutableCopy(Internal.BooleanList list) {
        int r0 = list.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    protected static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    protected static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> list) {
        int r0 = list.size();
        if (r0 != 0) goto L5;
        int r1 = 10;
    L7:
        return list.mutableCopyWithCapacity(r1);
    L5:
        r1 = r0 * 2;
        goto L7
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r1, CodedInputStream r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        T r4 = (T) r1.newMutableInstance();
        Schema r0 = Protobuf.getInstance().schemaFor(r4);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r0.mergeFrom(r4, CodedInputStreamReader.forCodedInput(r2), r3);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        r0.makeImmutable(r4);     // Catch: RuntimeException -> L5 IOException -> L11 UninitializedMessageException -> L18 InvalidProtocolBufferException -> L21
        return r4;
    L21:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L26;
        e = new InvalidProtocolBufferException(e);
    L26:
        throw e.setUnfinishedMessage(r4);
    L18:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r4);
    L11:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == false) goto L17;
        throw ((InvalidProtocolBufferException) e.getCause());
    L17:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r4);
    L5:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == true) goto L9;
        throw e;
    L9:
        throw ((InvalidProtocolBufferException) e.getCause());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r7, byte[] r8, int r9, int r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        T r12 = (T) r7.newMutableInstance();
        Schema r6 = Protobuf.getInstance().schemaFor(r12);     // Catch: IndexOutOfBoundsException -> L5 IOException -> L7 UninitializedMessageException -> L14 InvalidProtocolBufferException -> L17
        r6.mergeFrom(r12, r8, r9, r9 + r10, new ArrayDecoders.Registers(r11));     // Catch: IndexOutOfBoundsException -> L5 IOException -> L7 UninitializedMessageException -> L14 InvalidProtocolBufferException -> L17
        r6.makeImmutable(r12);     // Catch: IndexOutOfBoundsException -> L5 IOException -> L7 UninitializedMessageException -> L14 InvalidProtocolBufferException -> L17
        return r12;
    L17:
        e = e;
        if (e.getThrownFromInputStream() == false) goto L22;
        e = new InvalidProtocolBufferException(e);
    L22:
        throw e.setUnfinishedMessage(r12);
    L14:
        e = move-exception;
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(r12);
    L7:
        e = move-exception;
        if ((e.getCause() instanceof InvalidProtocolBufferException) == false) goto L13;
        throw ((InvalidProtocolBufferException) e.getCause());
    L13:
        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r12);
    L6:
        throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(r12);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r1, CodedInputStream r2) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T message) throws InvalidProtocolBufferException {
        if (message != null) goto L4;
    L8:
        return message;
    L4:
        if (message.isInitialized() == true) goto L8;
        throw message.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(message);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(r0, CodedInputStream.newInstance(r1), r2));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteBuffer r2) throws InvalidProtocolBufferException {
        return (T) parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, ByteString r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r0, r1, r2));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T r0, ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        CodedInputStream r3 = r1.newCodedInput();
        T r4 = (T) parsePartialFrom(r0, r3, r2);
        r3.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r4;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r4);
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r3, byte[] r4) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r3, r4, 0, r4.length, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r2, byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r2, r3, 0, r3.length, r4));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, InputStream r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r1, CodedInputStream.newInstance(r2), ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r0, CodedInputStream.newInstance(r1), r2));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r1, CodedInputStream r2) throws InvalidProtocolBufferException {
        return (T) parseFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T r0, CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(r0, r1, r2));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r1, InputStream r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2, ExtensionRegistryLite.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T r0, InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(r0, r1, r2));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T r2, InputStream r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        int r0 = r3.read();     // Catch: IOException -> L13 InvalidProtocolBufferException -> L16
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        CodedInputStream r5 = CodedInputStream.newInstance(new AbstractMessageLite.Builder.LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)));
        T r6 = (T) parsePartialFrom(r2, r5, r4);
        r5.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L10
        return r6;
    L10:
        e = move-exception;
        throw e.setUnfinishedMessage(r6);
    L16:
        e = move-exception;
        if (e.getThrownFromInputStream() == true) goto L20;
        throw e;
    L20:
        throw new InvalidProtocolBufferException(e);
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }
}
