package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            LimitedInputStream(InputStream in, int limit) {
                super(in);
                this.limit = limit;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r0 = super.read();
                if (r0 < 0) goto L9;
                this.limit--;
            L9:
                return r0;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(final byte[] b, final int off, int len) throws IOException {
                int r0 = this.limit;
                if (r0 > 0) goto L6;
                return -1;
            L6:
                int r2 = super.read(b, off, Math.min(len, r0));
                if (r2 < 0) goto L9;
                this.limit -= r2;
            L9:
                return r2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(final long n) throws IOException {
                int r3 = (int) super.skip(Math.min(n, this.limit));
                if (r3 < 0) goto L6;
                this.limit -= r3;
            L6:
                return r3;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public abstract BuilderType clone();

        protected abstract BuilderType internalMergeFrom(MessageType message);

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(final CodedInputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException;

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo952clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
            return mergeFrom(data);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(data, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
            return mergeFrom(input);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
            return mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
            return mergeFrom(other);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
            return mergeFrom(input);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
            return mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
            return mergeFrom(data);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final int off, final int len) throws InvalidProtocolBufferException {
            return mergeFrom(data, off, len);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final int off, final int len, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(data, off, len, extensionRegistry);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(data, extensionRegistry);
        }

        public Builder() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream r2) throws IOException {
            return (BuilderType) mergeFrom(r2, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
            CodedInputStream r3 = data.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r3.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            CodedInputStream r2 = data.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r2, extensionRegistry);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r2.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r3) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r3, 0, r3.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(final byte[] data, final int off, final int len) throws InvalidProtocolBufferException {
            CodedInputStream r1 = CodedInputStream.newInstance(data, off, len);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r1);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r1.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] r3, ExtensionRegistryLite r4) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r3, 0, r3.length, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(final byte[] data, final int off, final int len, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            CodedInputStream r1 = CodedInputStream.newInstance(data, off, len);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r1, extensionRegistry);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r1.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(final InputStream input) throws IOException {
            CodedInputStream r2 = CodedInputStream.newInstance(input);
            mergeFrom(r2);
            r2.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
            CodedInputStream r1 = CodedInputStream.newInstance(input);
            mergeFrom(r1, extensionRegistry);
            r1.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = input.read();
            if (r0 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new LimitedInputStream(input, CodedInputStream.readRawVarint32(r0, input)), extensionRegistry);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(final InputStream input) throws IOException {
            return mergeDelimitedFrom(input, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite r2) {
            if (getDefaultInstanceForType().getClass().isInstance(r2) == false) goto L7;
            return (BuilderType) internalMergeFrom((AbstractMessageLite) r2);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        private String getReadingExceptionMessage(String target) {
            return "Reading " + getClass().getName() + " from a " + target + " threw an IOException (should never happen).";
        }

        private static <T> void addAllCheckingNulls(Iterable<T> values, List<? super T> list) {
            if ((list instanceof ArrayList) == true) goto L5;
        L7:
            int r0 = list.size();
            Iterator<T> r3 = values.iterator();
        L9:
            if (r3.hasNext() == false) goto L18;
            T r1 = r3.next();
            if (r1 == null) goto L12;
            list.add(r1);
            goto L9
        L12:
            String r4 = "Element at index " + (list.size() - r0) + " is null.";
            int r2 = list.size() - 1;
        L13:
            if (r2 < r0) goto L16;
            list.remove(r2);
            r2 = r2 - 1;
            goto L13
        L16:
            throw new NullPointerException(r4);
        L18:
            return;
        L5:
            if ((values instanceof Collection) == false) goto L7;
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) values).size());
            goto L7
        }

        protected static UninitializedMessageException newUninitializedMessageException(MessageLite message) {
            return new UninitializedMessageException(message);
        }

        @Deprecated
        protected static <T> void addAll(final Iterable<T> values, final Collection<? super T> list) {
            addAll(values, (List) list);
        }

        protected static <T> void addAll(final Iterable<T> values, final List<? super T> list) {
            Internal.checkNotNull(values);
            if ((values instanceof LazyStringList) == false) goto L19;
            List<?> r3 = ((LazyStringList) values).getUnderlyingElements();
            LazyStringList r0 = (LazyStringList) list;
            int r4 = list.size();
            Iterator<?> r5 = r3.iterator();
        L6:
            if (r5.hasNext() == false) goto L32;
            Object r1 = r5.next();
            if (r1 == null) goto L9;
            if ((r1 instanceof ByteString) == true) goto L16;
            r0.add((String) r1);
            goto L6
        L16:
            r0.add((ByteString) r1);
            goto L6
        L9:
            String r6 = "Element at index " + (r0.size() - r4) + " is null.";
            int r2 = r0.size() - 1;
        L10:
            if (r2 < r4) goto L13;
            r0.remove(r2);
            r2 = r2 - 1;
            goto L10
        L13:
            throw new NullPointerException(r6);
        L32:
            return;
        L19:
            if ((values instanceof PrimitiveNonBoxingCollection) == false) goto L21;
            list.addAll((Collection) values);
            return;
        L21:
            addAllCheckingNulls(values, list);
        }
    }

    protected interface InternalOneOfEnum {
        int getNumber();
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r0 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r0.getCodedOutput());     // Catch: IOException -> L4
        return r0.build();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r0 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r1 = CodedOutputStream.newInstance(r0);     // Catch: IOException -> L4
        writeTo(r1);     // Catch: IOException -> L4
        r1.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public void writeTo(final OutputStream output) throws IOException {
        CodedOutputStream r2 = CodedOutputStream.newInstance(output, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(r2);
        r2.flush();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public void writeDelimitedTo(final OutputStream output) throws IOException {
        int r0 = getSerializedSize();
        CodedOutputStream r3 = CodedOutputStream.newInstance(output, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeUInt32SizeNoTag(r0) + r0));
        r3.writeUInt32NoTag(r0);
        writeTo(r3);
        r3.flush();
    }

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    void setMemoizedSerializedSize(int size) {
        throw new UnsupportedOperationException();
    }

    int getSerializedSize(Schema schema) {
        int r0 = getMemoizedSerializedSize();
        if (r0 != (-1)) goto L6;
        int r1 = schema.getSerializedSize(this);
        setMemoizedSerializedSize(r1);
        return r1;
    L6:
        return r0;
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    private String getSerializingExceptionMessage(String target) {
        return "Serializing " + getClass().getName() + " to a " + target + " threw an IOException (should never happen).";
    }

    protected static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (byteString.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    @Deprecated
    protected static <T> void addAll(final Iterable<T> values, final Collection<? super T> list) {
        Builder.addAll(values, (List) list);
    }

    protected static <T> void addAll(final Iterable<T> values, final List<? super T> list) {
        Builder.addAll(values, list);
    }
}
