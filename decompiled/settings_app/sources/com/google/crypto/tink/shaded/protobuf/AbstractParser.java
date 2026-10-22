package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;

    public AbstractParser() {
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(input);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(input, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return parseFrom(data);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parseFrom(data, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input) throws InvalidProtocolBufferException {
        return parseFrom(input);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parseFrom(input, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream input) throws InvalidProtocolBufferException {
        return parseFrom(input);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parseFrom(input, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return parseFrom(data);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parseFrom(data, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return parseFrom(data);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
        return parseFrom(data, off, len);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parseFrom(data, off, len, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parseFrom(data, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(input);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(input, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data) throws InvalidProtocolBufferException {
        return parsePartialFrom(data);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parsePartialFrom(data, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
        return parsePartialFrom(input);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input) throws InvalidProtocolBufferException {
        return parsePartialFrom(input);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parsePartialFrom(input, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data) throws InvalidProtocolBufferException {
        return parsePartialFrom(data);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
        return parsePartialFrom(data, off, len);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parsePartialFrom(data, off, len, extensionRegistry);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public /* bridge */ /* synthetic */ Object parsePartialFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return parsePartialFrom(data, extensionRegistry);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType message) {
        if ((message instanceof AbstractMessageLite) == false) goto L7;
        return ((AbstractMessageLite) message).newUninitializedMessageException();
    L7:
        return new UninitializedMessageException(message);
    }

    private MessageType checkMessageInitialized(MessageType message) throws InvalidProtocolBufferException {
        if (message != null) goto L4;
    L8:
        return message;
    L4:
        if (message.isInitialized() == true) goto L8;
        throw newUninitializedMessageException(message).asInvalidProtocolBufferException().setUnfinishedMessage(message);
    }

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream input) throws InvalidProtocolBufferException {
        return parsePartialFrom(input, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(CodedInputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream r1 = data.newCodedInput();     // Catch: InvalidProtocolBufferException -> L9
        MessageType r0 = parsePartialFrom(r1, extensionRegistry);     // Catch: InvalidProtocolBufferException -> L9
        r1.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return r0;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r0);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(ByteString r2) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(ByteString r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r2, ExtensionRegistryLite r3) throws InvalidProtocolBufferException {
        CodedInputStream r4 = CodedInputStream.newInstance(r2);     // Catch: InvalidProtocolBufferException -> L10
        MessageType r5 = parsePartialFrom(r4, r3);     // Catch: InvalidProtocolBufferException -> L10
        r4.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L7
    L6:
        return (MessageType) checkMessageInitialized(r5);
    L7:
        e = move-exception;
        throw e.setUnfinishedMessage(r5);     // Catch: InvalidProtocolBufferException -> L10
    L10:
        e = move-exception;
        throw e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(ByteBuffer r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream r1 = CodedInputStream.newInstance(data, off, len);     // Catch: InvalidProtocolBufferException -> L9
        MessageType r0 = parsePartialFrom(r1, extensionRegistry);     // Catch: InvalidProtocolBufferException -> L9
        r1.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L6
        return r0;
    L6:
        e = move-exception;
        throw e.setUnfinishedMessage(r0);     // Catch: InvalidProtocolBufferException -> L9
    L9:
        e = move-exception;
        throw e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r2, int r3, int r4) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r2, r3, r4, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r3, 0, r3.length, r4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(byte[] r4) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r4, 0, r4.length, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2, r3, r4));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(byte[] r2, int r3, int r4) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, r3, r4, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r3, 0, r3.length, r4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(byte[] r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        CodedInputStream r1 = CodedInputStream.newInstance(input);
        MessageType r0 = parsePartialFrom(r1, extensionRegistry);
        r1.checkLastTagWas(0);     // Catch: InvalidProtocolBufferException -> L5
        return r0;
    L5:
        e = move-exception;
        throw e.setUnfinishedMessage(r0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialFrom(r1, r2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parseFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
        int r0 = r3.read();     // Catch: IOException -> L9
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) parsePartialFrom(new AbstractMessageLite.Builder.LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)), r4);
    L9:
        e = move-exception;
        throw new InvalidProtocolBufferException(e);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialDelimitedFrom(r2, EMPTY_REGISTRY);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized(parsePartialDelimitedFrom(r1, r2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream r2) throws InvalidProtocolBufferException {
        return (MessageType) parseDelimitedFrom(r2, EMPTY_REGISTRY);
    }
}
