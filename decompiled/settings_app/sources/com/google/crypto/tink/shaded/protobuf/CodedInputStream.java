package com.google.crypto.tink.shaded.protobuf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.CodedInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        /* synthetic */ ArrayDecoder(byte[] r1, int r2, int r3, boolean r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        private ArrayDecoder(final byte[] buffer, final int offset, final int len, boolean immutable) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            this.limit = len + offset;
            this.pos = offset;
            this.startPos = offset;
            this.immutable = immutable;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r0 = readRawVarint32();
            this.lastTag = r0;
            if (WireFormat.getTagFieldNumber(r0) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            long r2 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(r2);
            return true;
        L6:
            if (r0 != 2) goto L8;
            ByteString r4 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(r4);
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            int r5 = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(r5);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int r6 = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(r6);
            output.writeUInt32NoTag(r6);
            return true;
        L24:
            long r3 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(r3);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0, output) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r0 = readRawVarint32();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r0 > (this.limit - this.pos)) goto L8;
            String r1 = new String(this.buffer, this.pos, r0, Internal.UTF_8);
            this.pos += r0;
            return r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r0 = readRawVarint32();
            if (r0 <= 0) goto L8;
            int r1 = this.limit;
            int r2 = this.pos;
            if (r0 > (r1 - r2)) goto L8;
            String r3 = Utf8.decodeUtf8(this.buffer, r2, r0);
            this.pos += r0;
            return r3;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return r3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return r3;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r0 = readRawVarint32();
            if (r0 <= 0) goto L14;
            int r1 = this.limit;
            int r2 = this.pos;
            if (r0 > (r1 - r2)) goto L14;
            if (this.immutable == true) goto L9;
        L11:
            ByteString r3 = ByteString.copyFrom(this.buffer, r2, r0);
        L12:
            this.pos += r0;
            return r3;
        L9:
            if (this.enableAliasing == false) goto L11;
            r3 = ByteString.wrap(this.buffer, r2, r0);
        L14:
            if (r0 != 0) goto L18;
            return ByteString.EMPTY;
        L18:
            return ByteString.wrap(readRawBytes(r0));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r0 = readRawVarint32();
            if (r0 <= 0) goto L14;
            int r1 = this.limit;
            int r2 = this.pos;
            if (r0 > (r1 - r2)) goto L14;
            if (this.immutable == false) goto L9;
        L11:
            ByteBuffer r3 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r2, r2 + r0));
        L12:
            this.pos += r0;
            return r3;
        L9:
            if (this.enableAliasing == false) goto L11;
            r3 = ByteBuffer.wrap(this.buffer, r2, r0).slice();
        L14:
            if (r0 == 0) goto L16;
            if (r0 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int r0 = this.pos;
            int r1 = this.limit;
            if (r1 == r0) goto L35;
            byte[] r2 = this.buffer;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.pos = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L35;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L15;
            int r7 = r6 ^ (-128);
        L36:
            this.pos = r5;
            return r7;
        L15:
            int r8 = r5 + 1;
            int r9 = r6 ^ (r2[r5] << 14);
            if (r9 < 0) goto L19;
            r7 = r9 ^ 16256;
        L18:
            r5 = r8;
            goto L36
        L19:
            r5 = r8 + 1;
            int r10 = r9 ^ (r2[r8] << 21);
            if (r10 >= 0) goto L22;
            r7 = r10 ^ (-2080896);
            goto L36
        L22:
            r8 = r5 + 1;
            byte r11 = r2[r5];
            r7 = (r10 ^ (r11 << 28)) ^ 266354560;
            if (r11 >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if ((this.limit - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            byte[] r1 = this.buffer;
            int r2 = this.pos;
            this.pos = r2 + 1;
            if (r1[r2] >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            int r0 = this.pos;
            int r1 = this.limit;
            if (r1 == r0) goto L41;
            byte[] r2 = this.buffer;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.pos = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L41;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L16;
            int r7 = r6 ^ (-128);
        L15:
            long r8 = r7;
        L44:
            this.pos = r5;
            return r8;
        L16:
            int r9 = r5 + 1;
            int r10 = r6 ^ (r2[r5] << 14);
            if (r10 < 0) goto L19;
            r5 = r9;
            r8 = r10 ^ 16256;
            goto L44
        L19:
            r5 = r9 + 1;
            int r11 = r10 ^ (r2[r9] << 21);
            if (r11 >= 0) goto L22;
            r7 = r11 ^ (-2080896);
            goto L15
        L22:
            long r12 = r11;
            int r13 = r5 + 1;
            long r14 = r12 ^ (((long) r2[r5]) << 28);
            if (r14 < 0) goto L26;
            long r15 = 266354560;
        L25:
            r8 = r14 ^ r15;
            r5 = r13;
            goto L44
        L26:
            r5 = r13 + 1;
            long r16 = r14 ^ (((long) r2[r13]) << 35);
            if (r16 >= 0) goto L30;
            long r17 = -34093383808L;
        L29:
            r8 = r16 ^ r17;
            goto L44
        L30:
            r13 = r5 + 1;
            r14 = r16 ^ (((long) r2[r5]) << 42);
            if (r14 < 0) goto L33;
            r15 = 4363953127296L;
            goto L25
        L33:
            r5 = r13 + 1;
            r16 = r14 ^ (((long) r2[r13]) << 49);
            if (r16 >= 0) goto L36;
            r17 = -558586000294016L;
            goto L29
        L36:
            int r18 = r5 + 1;
            long r19 = (r16 ^ (((long) r2[r5]) << 56)) ^ 71499008037633920L;
            if (r19 >= 0) goto L42;
            r5 = r18 + 1;
            if (r2[r18] < 0) goto L41;
        L43:
            r8 = r19;
            goto L44
        L42:
            r5 = r18;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = readRawByte();
            r0 = r0 | (((long) (r3 & 127)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int r0 = this.pos;
            if ((this.limit - r0) < 4) goto L7;
            byte[] r1 = this.buffer;
            this.pos = r0 + 4;
            return (((r1[r0] & 255) | ((r1[r0 + 1] & 255) << 8)) | ((r1[r0 + 2] & 255) << 16)) | ((r1[r0 + 3] & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int r0 = this.pos;
            if ((this.limit - r0) < 8) goto L7;
            byte[] r1 = this.buffer;
            this.pos = r0 + 8;
            long r2 = ((((((((long) r1[r0]) & 255) | ((((long) r1[r0 + 1]) & 255) << 8)) | ((((long) r1[r0 + 2]) & 255) << 16)) | ((((long) r1[r0 + 3]) & 255) << 24)) | ((((long) r1[r0 + 4]) & 255) << 32)) | ((((long) r1[r0 + 5]) & 255) << 40)) | ((((long) r1[r0 + 6]) & 255) << 48);
            return ((((long) r1[r0 + 7]) & 255) << 56) | r2;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L14;
            int r2 = byteLimit + getTotalBytesRead();
            if (r2 < 0) goto L12;
            int r0 = this.currentLimit;
            if (r2 > r0) goto L10;
            this.currentLimit = r2;
            recomputeBufferSizeAfterLimit();
            return r0;
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L12:
            throw InvalidProtocolBufferException.parseFailure();
        L14:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            int r0 = this.limit + this.bufferSizeAfterLimit;
            this.limit = r0;
            int r1 = r0 - this.startPos;
            int r2 = this.currentLimit;
            if (r1 <= r2) goto L5;
            int r3 = r1 - r2;
            this.bufferSizeAfterLimit = r3;
            this.limit = r0 - r3;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r0 = this.currentLimit;
            if (r0 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r0 - getTotalBytesRead();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            int r0 = this.pos;
            if (r0 == this.limit) goto L7;
            byte[] r1 = this.buffer;
            this.pos = r0 + 1;
            return r1[r0];
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(final int length) throws IOException {
            if (length <= 0) goto L7;
            int r0 = this.limit;
            int r1 = this.pos;
            if (length > (r0 - r1)) goto L7;
            int r3 = length + r1;
            this.pos = r3;
            return Arrays.copyOfRange(this.buffer, r1, r3);
        L7:
            if (length > 0) goto L14;
            if (length != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(final int length) throws IOException {
            if (length < 0) goto L7;
            int r0 = this.limit;
            int r1 = this.pos;
            if (length > (r0 - r1)) goto L7;
            this.pos = r1 + length;
            return;
        L7:
            if (length >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        /* synthetic */ IterableDirectByteBufferDecoder(Iterable r1, int r2, boolean r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> inputBufs, int size, boolean immutableFlag) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = size;
            this.input = inputBufs;
            this.iterator = inputBufs.iterator();
            this.immutable = immutableFlag;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (size != 0) goto L5;
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0;
            this.currentByteBufferStartPos = 0;
            this.currentByteBufferLimit = 0;
            this.currentAddress = 0;
            return;
        L5:
            tryGetNextByteBuffer();
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (this.iterator.hasNext() == false) goto L7;
            tryGetNextByteBuffer();
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer r0 = this.iterator.next();
            this.currentByteBuffer = r0;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long r1 = r0.position();
            this.currentByteBufferPos = r1;
            this.currentByteBufferStartPos = r1;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long r2 = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = r2;
            this.currentByteBufferPos += r2;
            this.currentByteBufferStartPos += r2;
            this.currentByteBufferLimit += r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r0 = readRawVarint32();
            this.lastTag = r0;
            if (WireFormat.getTagFieldNumber(r0) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            long r2 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(r2);
            return true;
        L6:
            if (r0 != 2) goto L8;
            ByteString r4 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(r4);
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            int r5 = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(r5);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int r6 = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(r6);
            output.writeUInt32NoTag(r6);
            return true;
        L24:
            long r3 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(r3);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0, output) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r0 = readRawVarint32();
            if (r0 <= 0) goto L8;
            long r8 = r0;
            long r1 = this.currentByteBufferLimit;
            long r3 = this.currentByteBufferPos;
            if (r8 > (r1 - r3)) goto L8;
            byte[] r2 = new byte[r0];
            UnsafeUtil.copyMemory(r3, r2, 0, r8);
            String r4 = new String(r2, Internal.UTF_8);
            this.currentByteBufferPos += r8;
            return r4;
        L8:
            if (r0 > 0) goto L10;
        L13:
            if (r0 != 0) goto L16;
            return "";
        L16:
            if (r0 >= 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r0 > remaining()) goto L13;
            byte[] r5 = new byte[r0];
            readRawBytesTo(r5, 0, r0);
            return new String(r5, Internal.UTF_8);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r0 = readRawVarint32();
            if (r0 <= 0) goto L8;
            long r1 = r0;
            long r3 = this.currentByteBufferLimit;
            long r5 = this.currentByteBufferPos;
            if (r1 > (r3 - r5)) goto L8;
            String r2 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (r5 - this.currentByteBufferStartPos), r0);
            this.currentByteBufferPos += r1;
            return r2;
        L8:
            if (r0 >= 0) goto L10;
        L13:
            if (r0 != 0) goto L16;
            return "";
        L16:
            if (r0 > 0) goto L20;
            throw InvalidProtocolBufferException.negativeSize();
        L20:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            if (r0 > remaining()) goto L13;
            byte[] r4 = new byte[r0];
            readRawBytesTo(r4, 0, r0);
            return Utf8.decodeUtf8(r4, 0, r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return r3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return r3;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r0 = readRawVarint32();
            if (r0 <= 0) goto L14;
            long r8 = r0;
            long r1 = this.currentByteBufferLimit;
            long r3 = this.currentByteBufferPos;
            if (r8 > (r1 - r3)) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r2 = new byte[r0];
            UnsafeUtil.copyMemory(r3, r2, 0, r8);
            this.currentByteBufferPos += r8;
            return ByteString.wrap(r2);
        L9:
            if (this.enableAliasing == false) goto L12;
            int r4 = (int) (r3 - this.currentAddress);
            ByteString r5 = ByteString.wrap(slice(r4, r0 + r4));
            this.currentByteBufferPos += r8;
            return r5;
        L14:
            if (r0 > 0) goto L16;
        L31:
            if (r0 == 0) goto L33;
            if (r0 >= 0) goto L38;
            throw InvalidProtocolBufferException.negativeSize();
        L38:
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            return ByteString.EMPTY;
        L16:
            if (r0 > remaining()) goto L31;
            if (this.immutable == true) goto L20;
        L29:
            byte[] r6 = new byte[r0];
            readRawBytesTo(r6, 0, r0);
            return ByteString.wrap(r6);
        L20:
            if (this.enableAliasing == false) goto L29;
            ArrayList r7 = new ArrayList();
        L22:
            if (r0 <= 0) goto L28;
            if (currentRemaining() != 0) goto L26;
            getNextByteBuffer();
        L26:
            int r9 = Math.min(r0, (int) currentRemaining());
            int r10 = (int) (this.currentByteBufferPos - this.currentAddress);
            r7.add(ByteString.wrap(slice(r10, r10 + r9)));
            r0 = r0 - r9;
            this.currentByteBufferPos += (long) r9;
            goto L22
        L28:
            return ByteString.copyFrom(r7);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r0 = readRawVarint32();
            if (r0 <= 0) goto L14;
            long r8 = r0;
            if (r8 > currentRemaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r1 = new byte[r0];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r1, 0, r8);
            this.currentByteBufferPos += r8;
            return ByteBuffer.wrap(r1);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r2 = this.currentByteBufferPos + r8;
            this.currentByteBufferPos = r2;
            long r3 = this.currentAddress;
            return slice((int) ((r2 - r3) - r8), (int) (r2 - r3));
        L14:
            if (r0 > 0) goto L16;
        L19:
            if (r0 == 0) goto L21;
            if (r0 >= 0) goto L26;
            throw InvalidProtocolBufferException.negativeSize();
        L26:
            throw InvalidProtocolBufferException.truncatedMessage();
        L21:
            return Internal.EMPTY_BYTE_BUFFER;
        L16:
            if (r0 > remaining()) goto L19;
            byte[] r4 = new byte[r0];
            readRawBytesTo(r4, 0, r0);
            return ByteBuffer.wrap(r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            long r0 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r0) goto L35;
            long r4 = r0 + 1;
            byte r1 = UnsafeUtil.getByte(r0);
            if (r1 < 0) goto L10;
            this.currentByteBufferPos++;
            return r1;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L35;
            long r6 = r4 + 1;
            int r2 = r1 ^ (UnsafeUtil.getByte(r4) << 7);
            if (r2 >= 0) goto L15;
            int r3 = r2 ^ (-128);
        L36:
            this.currentByteBufferPos = r6;
            return r3;
        L15:
            long r5 = r6 + 1;
            int r7 = r2 ^ (UnsafeUtil.getByte(r6) << 14);
            if (r7 < 0) goto L19;
            r3 = r7 ^ 16256;
        L18:
            r6 = r5;
            goto L36
        L19:
            r6 = r5 + 1;
            int r8 = r7 ^ (UnsafeUtil.getByte(r5) << 21);
            if (r8 >= 0) goto L22;
            r3 = r8 ^ (-2080896);
            goto L36
        L22:
            r5 = r6 + 1;
            byte r9 = UnsafeUtil.getByte(r6);
            r3 = (r8 ^ (r9 << 28)) ^ 266354560;
            if (r9 >= 0) goto L18;
            r6 = r5 + 1;
            if (UnsafeUtil.getByte(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (UnsafeUtil.getByte(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (UnsafeUtil.getByte(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (UnsafeUtil.getByte(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (UnsafeUtil.getByte(r5) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long r0 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit == r0) goto L42;
            long r4 = r0 + 1;
            byte r1 = UnsafeUtil.getByte(r0);
            if (r1 < 0) goto L10;
            this.currentByteBufferPos++;
            return r1;
        L10:
            if ((this.currentByteBufferLimit - this.currentByteBufferPos) < 10) goto L42;
            long r6 = r4 + 1;
            int r2 = r1 ^ (UnsafeUtil.getByte(r4) << 7);
            if (r2 >= 0) goto L16;
            int r3 = r2 ^ (-128);
        L15:
            long r5 = r3;
        L44:
            this.currentByteBufferPos = r6;
            return r5;
        L16:
            long r7 = r6 + 1;
            int r8 = r2 ^ (UnsafeUtil.getByte(r6) << 14);
            if (r8 < 0) goto L20;
            r5 = r8 ^ 16256;
        L19:
            r6 = r7;
            goto L44
        L20:
            r6 = r7 + 1;
            int r9 = r8 ^ (UnsafeUtil.getByte(r7) << 21);
            if (r9 >= 0) goto L23;
            r3 = r9 ^ (-2080896);
            goto L15
        L23:
            r7 = r6 + 1;
            long r10 = ((long) r9) ^ (((long) UnsafeUtil.getByte(r6)) << 28);
            if (r10 < 0) goto L27;
            long r11 = 266354560;
        L26:
            r5 = r10 ^ r11;
            goto L19
        L27:
            long r12 = r7 + 1;
            long r13 = r10 ^ (((long) UnsafeUtil.getByte(r7)) << 35);
            if (r13 >= 0) goto L31;
            long r14 = -34093383808L;
        L30:
            r5 = r13 ^ r14;
            r6 = r12;
            goto L44
        L31:
            r7 = r12 + 1;
            r10 = r13 ^ (((long) UnsafeUtil.getByte(r12)) << 42);
            if (r10 < 0) goto L34;
            r11 = 4363953127296L;
            goto L26
        L34:
            r12 = r7 + 1;
            r13 = r10 ^ (((long) UnsafeUtil.getByte(r7)) << 49);
            if (r13 >= 0) goto L37;
            r14 = -558586000294016L;
            goto L30
        L37:
            r7 = r12 + 1;
            r5 = (r13 ^ (((long) UnsafeUtil.getByte(r12)) << 56)) ^ 71499008037633920L;
            if (r5 >= 0) goto L19;
            long r15 = 1 + r7;
            if (UnsafeUtil.getByte(r7) < 0) goto L42;
            r6 = r15;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = readRawByte();
            r0 = r0 | (((long) (r3 & 127)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) goto L6;
            long r0 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + r0;
            return (((UnsafeUtil.getByte(r0) & 255) | ((UnsafeUtil.getByte(1 + r0) & 255) << 8)) | ((UnsafeUtil.getByte(2 + r0) & 255) << 16)) | ((UnsafeUtil.getByte(r0 + 3) & 255) << 24);
        L6:
            int r1 = ((readRawByte() & 255) | ((readRawByte() & 255) << 8)) | ((readRawByte() & 255) << 16);
            return ((readRawByte() & 255) << 24) | r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            if (currentRemaining() < 8) goto L6;
            long r13 = this.currentByteBufferPos;
            this.currentByteBufferPos = 8 + r13;
            return (((((((((long) UnsafeUtil.getByte(r13)) & 255) | ((((long) UnsafeUtil.getByte(1 + r13)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + r13)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + r13)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r13)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r13)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r13)) & 255) << 48)) | ((((long) UnsafeUtil.getByte(r13 + 7)) & 255) << 56);
        L6:
            long r3 = ((((((((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8)) | ((((long) readRawByte()) & 255) << 16)) | ((((long) readRawByte()) & 255) << 24)) | ((((long) readRawByte()) & 255) << 32)) | ((((long) readRawByte()) & 255) << 40)) | ((((long) readRawByte()) & 255) << 48);
            return ((((long) readRawByte()) & 255) << 56) | r3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L10;
            int r2 = byteLimit + getTotalBytesRead();
            int r0 = this.currentLimit;
            if (r2 > r0) goto L8;
            this.currentLimit = r2;
            recomputeBufferSizeAfterLimit();
            return r0;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            int r0 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = r0;
            int r1 = r0 - this.startOffset;
            int r2 = this.currentLimit;
            if (r1 <= r2) goto L5;
            int r3 = r1 - r2;
            this.bufferSizeAfterCurrentLimit = r3;
            this.totalBufferSize = r0 - r3;
            return;
        L5:
            this.bufferSizeAfterCurrentLimit = 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r0 = this.currentLimit;
            if (r0 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r0 - getTotalBytesRead();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos) != this.totalBufferSize) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (currentRemaining() != 0) goto L5;
            getNextByteBuffer();
        L5:
            long r0 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + r0;
            return UnsafeUtil.getByte(r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(final int length) throws IOException {
            if (length < 0) goto L7;
            long r7 = length;
            if (r7 > currentRemaining()) goto L7;
            byte[] r10 = new byte[length];
            UnsafeUtil.copyMemory(this.currentByteBufferPos, r10, 0, r7);
            this.currentByteBufferPos += r7;
            return r10;
        L7:
            if (length >= 0) goto L9;
        L12:
            if (length > 0) goto L19;
            if (length != 0) goto L17;
            return Internal.EMPTY_BYTE_ARRAY;
        L17:
            throw InvalidProtocolBufferException.negativeSize();
        L19:
            throw InvalidProtocolBufferException.truncatedMessage();
        L9:
            if (length > remaining()) goto L12;
            byte[] r0 = new byte[length];
            readRawBytesTo(r0, 0, length);
            return r0;
        }

        private void readRawBytesTo(byte[] bytes, int offset, final int length) throws IOException {
            if (length >= 0) goto L4;
        L12:
            if (length > 0) goto L18;
            if (length != 0) goto L16;
            return;
        L16:
            throw InvalidProtocolBufferException.negativeSize();
        L18:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > remaining()) goto L12;
            int r0 = length;
        L6:
            if (r0 <= 0) goto L11;
            if (currentRemaining() != 0) goto L10;
            getNextByteBuffer();
        L10:
            int r1 = Math.min(r0, (int) currentRemaining());
            long r9 = r1;
            UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, (length - r0) + offset, r9);
            r0 = r0 - r1;
            this.currentByteBufferPos += r9;
            goto L6
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(final int length) throws IOException {
            if (length >= 0) goto L4;
        L11:
            if (length >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos)) goto L11;
        L5:
            if (length <= 0) goto L10;
            if (currentRemaining() != 0) goto L9;
            getNextByteBuffer();
        L9:
            int r0 = Math.min(length, (int) currentRemaining());
            length = length - r0;
            this.currentByteBufferPos += (long) r0;
            goto L5
        }

        private void skipRawVarint() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private ByteBuffer slice(int begin, int end) throws IOException {
            int r0 = this.currentByteBuffer.position();
            int r1 = this.currentByteBuffer.limit();
            ByteBuffer r2 = this.currentByteBuffer;
            r2.position(begin);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.limit(end);     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r3 = this.currentByteBuffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.position(r0);
            r2.limit(r1);
            return r3;
        L6:
            th = move-exception;
            r2.position(r0);
            r2.limit(r1);
            throw th;
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
        }
    }

    private static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        private interface RefillCallback {
            void onRefill();
        }

        private class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;
            final /* synthetic */ StreamDecoder this$0;

            private SkippedDataSink(final StreamDecoder this$0) {
                this.this$0 = this$0;
                this.lastPos = StreamDecoder.access$500(this$0);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream != null) goto L5;
                this.byteArrayStream = new ByteArrayOutputStream();
            L5:
                this.byteArrayStream.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
                this.lastPos = 0;
            }

            ByteBuffer getSkippedData() {
                ByteArrayOutputStream r0 = this.byteArrayStream;
                if (r0 == null) goto L5;
                r0.write(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0));
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            L5:
                return ByteBuffer.wrap(StreamDecoder.access$600(this.this$0), this.lastPos, StreamDecoder.access$500(this.this$0) - this.lastPos);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
        }

        /* synthetic */ StreamDecoder(InputStream r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ int access$500(StreamDecoder r0) {
            return r0.pos;
        }

        static /* synthetic */ byte[] access$600(StreamDecoder r0) {
            return r0.buffer;
        }

        private StreamDecoder(final InputStream input, int bufferSize) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(input, "input");
            this.input = input;
            this.buffer = new byte[bufferSize];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        private static int read(InputStream input, byte[] data, int offset, int length) throws IOException {
            return input.read(data, offset, length);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private static long skip(InputStream input, long length) throws IOException {
            return input.skip(length);
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        private static int available(InputStream input) throws IOException {
            return input.available();
        L4:
            e = move-exception;
            e.setThrownFromInputStream();
            throw e;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r0 = readRawVarint32();
            this.lastTag = r0;
            if (WireFormat.getTagFieldNumber(r0) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            long r2 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(r2);
            return true;
        L6:
            if (r0 != 2) goto L8;
            ByteString r4 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(r4);
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            int r5 = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(r5);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int r6 = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(r6);
            output.writeUInt32NoTag(r6);
            return true;
        L24:
            long r3 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(r3);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0, output) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r0 = readRawVarint32();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L12;
            return "";
        L12:
            if (r0 > this.bufferSize) goto L16;
            refillBuffer(r0);
            String r1 = new String(this.buffer, this.pos, r0, Internal.UTF_8);
            this.pos += r0;
            return r1;
        L16:
            return new String(readRawBytesSlowPath(r0, false), Internal.UTF_8);
        L5:
            if (r0 > (this.bufferSize - this.pos)) goto L8;
            String r2 = new String(this.buffer, this.pos, r0, Internal.UTF_8);
            this.pos += r0;
            return r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r0 = readRawVarint32();
            int r1 = this.pos;
            int r2 = this.bufferSize;
            if (r0 > (r2 - r1)) goto L6;
            if (r0 <= 0) goto L6;
            byte[] r3 = this.buffer;
            this.pos = r1 + r0;
        L14:
            return Utf8.decodeUtf8(r3, r1, r0);
        L6:
            if (r0 != 0) goto L9;
            return "";
        L9:
            r1 = 0;
            if (r0 > r2) goto L12;
            refillBuffer(r0);
            r3 = this.buffer;
            this.pos = r0 + 0;
            goto L14
        L12:
            r3 = readRawBytesSlowPath(r0, false);
            goto L14
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return r3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return r3;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r0 = readRawVarint32();
            int r1 = this.bufferSize;
            int r2 = this.pos;
            if (r0 > (r1 - r2)) goto L7;
            if (r0 <= 0) goto L7;
            ByteString r3 = ByteString.copyFrom(this.buffer, r2, r0);
            this.pos += r0;
            return r3;
        L7:
            if (r0 != 0) goto L11;
            return ByteString.EMPTY;
        L11:
            return readBytesSlowPath(r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int r0 = readRawVarint32();
            int r1 = this.bufferSize;
            int r2 = this.pos;
            if (r0 > (r1 - r2)) goto L8;
            if (r0 <= 0) goto L8;
            byte[] r3 = Arrays.copyOfRange(this.buffer, r2, r2 + r0);
            this.pos += r0;
            return r3;
        L8:
            return readRawBytesSlowPath(r0, false);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r0 = readRawVarint32();
            int r1 = this.bufferSize;
            int r2 = this.pos;
            if (r0 > (r1 - r2)) goto L7;
            if (r0 <= 0) goto L7;
            ByteBuffer r3 = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, r2, r2 + r0));
            this.pos += r0;
            return r3;
        L7:
            if (r0 != 0) goto L11;
            return Internal.EMPTY_BYTE_BUFFER;
        L11:
            return ByteBuffer.wrap(readRawBytesSlowPath(r0, true));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            int r0 = this.pos;
            int r1 = this.bufferSize;
            if (r1 == r0) goto L35;
            byte[] r2 = this.buffer;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.pos = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L35;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L15;
            int r7 = r6 ^ (-128);
        L36:
            this.pos = r5;
            return r7;
        L15:
            int r8 = r5 + 1;
            int r9 = r6 ^ (r2[r5] << 14);
            if (r9 < 0) goto L19;
            r7 = r9 ^ 16256;
        L18:
            r5 = r8;
            goto L36
        L19:
            r5 = r8 + 1;
            int r10 = r9 ^ (r2[r8] << 21);
            if (r10 >= 0) goto L22;
            r7 = r10 ^ (-2080896);
            goto L36
        L22:
            r8 = r5 + 1;
            byte r11 = r2[r5];
            r7 = (r10 ^ (r11 << 28)) ^ 266354560;
            if (r11 >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
            r8 = r5 + 1;
            if (r2[r5] >= 0) goto L18;
            r5 = r8 + 1;
            if (r2[r8] >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if ((this.bufferSize - this.pos) < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            byte[] r1 = this.buffer;
            int r2 = this.pos;
            this.pos = r2 + 1;
            if (r1[r2] >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            int r0 = this.pos;
            int r1 = this.bufferSize;
            if (r1 == r0) goto L41;
            byte[] r2 = this.buffer;
            int r3 = r0 + 1;
            byte r4 = r2[r0];
            if (r4 < 0) goto L10;
            this.pos = r3;
            return r4;
        L10:
            if ((r1 - r3) < 9) goto L41;
            int r5 = r3 + 1;
            int r6 = r4 ^ (r2[r3] << 7);
            if (r6 >= 0) goto L16;
            int r7 = r6 ^ (-128);
        L15:
            long r8 = r7;
        L44:
            this.pos = r5;
            return r8;
        L16:
            int r9 = r5 + 1;
            int r10 = r6 ^ (r2[r5] << 14);
            if (r10 < 0) goto L19;
            r5 = r9;
            r8 = r10 ^ 16256;
            goto L44
        L19:
            r5 = r9 + 1;
            int r11 = r10 ^ (r2[r9] << 21);
            if (r11 >= 0) goto L22;
            r7 = r11 ^ (-2080896);
            goto L15
        L22:
            long r12 = r11;
            int r13 = r5 + 1;
            long r14 = r12 ^ (((long) r2[r5]) << 28);
            if (r14 < 0) goto L26;
            long r15 = 266354560;
        L25:
            r8 = r14 ^ r15;
            r5 = r13;
            goto L44
        L26:
            r5 = r13 + 1;
            long r16 = r14 ^ (((long) r2[r13]) << 35);
            if (r16 >= 0) goto L30;
            long r17 = -34093383808L;
        L29:
            r8 = r16 ^ r17;
            goto L44
        L30:
            r13 = r5 + 1;
            r14 = r16 ^ (((long) r2[r5]) << 42);
            if (r14 < 0) goto L33;
            r15 = 4363953127296L;
            goto L25
        L33:
            r5 = r13 + 1;
            r16 = r14 ^ (((long) r2[r13]) << 49);
            if (r16 >= 0) goto L36;
            r17 = -558586000294016L;
            goto L29
        L36:
            int r18 = r5 + 1;
            long r19 = (r16 ^ (((long) r2[r5]) << 56)) ^ 71499008037633920L;
            if (r19 >= 0) goto L42;
            r5 = r18 + 1;
            if (r2[r18] < 0) goto L41;
        L43:
            r8 = r19;
            goto L44
        L42:
            r5 = r18;
        L41:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = readRawByte();
            r0 = r0 | (((long) (r3 & 127)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int r0 = this.pos;
            if ((this.bufferSize - r0) >= 4) goto L5;
            refillBuffer(4);
            r0 = this.pos;
        L5:
            byte[] r1 = this.buffer;
            this.pos = r0 + 4;
            return (((r1[r0] & 255) | ((r1[r0 + 1] & 255) << 8)) | ((r1[r0 + 2] & 255) << 16)) | ((r1[r0 + 3] & 255) << 24);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int r0 = this.pos;
            if ((this.bufferSize - r0) >= 8) goto L5;
            refillBuffer(8);
            r0 = this.pos;
        L5:
            byte[] r1 = this.buffer;
            this.pos = r0 + 8;
            long r2 = ((((((((long) r1[r0]) & 255) | ((((long) r1[r0 + 1]) & 255) << 8)) | ((((long) r1[r0 + 2]) & 255) << 16)) | ((((long) r1[r0 + 3]) & 255) << 24)) | ((((long) r1[r0 + 4]) & 255) << 32)) | ((((long) r1[r0 + 5]) & 255) << 40)) | ((((long) r1[r0 + 6]) & 255) << 48);
            return ((((long) r1[r0 + 7]) & 255) << 56) | r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L10;
            int r3 = byteLimit + (this.totalBytesRetired + this.pos);
            int r0 = this.currentLimit;
            if (r3 > r0) goto L8;
            this.currentLimit = r3;
            recomputeBufferSizeAfterLimit();
            return r0;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            int r0 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = r0;
            int r1 = this.totalBytesRetired + r0;
            int r2 = this.currentLimit;
            if (r1 <= r2) goto L5;
            int r3 = r1 - r2;
            this.bufferSizeAfterLimit = r3;
            this.bufferSize = r0 - r3;
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r0 = this.currentLimit;
            if (r0 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r0 - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos == this.bufferSize) goto L5;
        L7:
            return false;
        L5:
            if (tryRefillBuffer(1) == true) goto L7;
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        private void refillBuffer(int n) throws IOException {
            if (tryRefillBuffer(n) == false) goto L5;
            return;
        L5:
            if (n <= ((this.sizeLimit - this.totalBytesRetired) - this.pos)) goto L9;
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L9:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private boolean tryRefillBuffer(int n) throws IOException {
            if ((this.pos + n) <= this.bufferSize) goto L35;
            int r0 = this.sizeLimit;
            int r1 = this.totalBytesRetired;
            int r2 = this.pos;
            if (n <= ((r0 - r1) - r2)) goto L8;
            return false;
        L8:
            if (((r1 + r2) + n) <= this.currentLimit) goto L10;
            return false;
        L10:
            RefillCallback r3 = this.refillCallback;
            if (r3 == null) goto L13;
            r3.onRefill();
        L13:
            int r4 = this.pos;
            if (r4 <= 0) goto L19;
            int r5 = this.bufferSize;
            if (r5 <= r4) goto L18;
            byte[] r6 = this.buffer;
            System.arraycopy(r6, r4, r6, 0, r5 - r4);
        L18:
            this.totalBytesRetired += r4;
            this.bufferSize -= r4;
            this.pos = 0;
        L19:
            InputStream r7 = this.input;
            byte[] r8 = this.buffer;
            int r9 = this.bufferSize;
            int r10 = read(r7, r8, r9, Math.min(r8.length - r9, (this.sizeLimit - this.totalBytesRetired) - this.bufferSize));
            if (r10 == 0) goto L33;
            if (r10 < (-1)) goto L33;
            if (r10 > this.buffer.length) goto L33;
            if (r10 <= 0) goto L31;
            this.bufferSize += r10;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize < n) goto L30;
            return true;
        L30:
            return tryRefillBuffer(n);
        L31:
            return false;
        L33:
            throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + r10 + "\nThe InputStream implementation is buggy.");
        L35:
            throw new IllegalStateException("refillBuffer() called when " + n + " bytes were already available in buffer");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos != this.bufferSize) goto L5;
            refillBuffer(1);
        L5:
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 + 1;
            return r0[r1];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(final int size) throws IOException {
            int r0 = this.pos;
            if (size > (this.bufferSize - r0)) goto L8;
            if (size <= 0) goto L8;
            int r3 = size + r0;
            this.pos = r3;
            return Arrays.copyOfRange(this.buffer, r0, r3);
        L8:
            return readRawBytesSlowPath(size, false);
        }

        private byte[] readRawBytesSlowPath(final int size, boolean ensureNoLeakedReferences) throws IOException {
            byte[] r0 = readRawBytesSlowPathOneChunk(size);
            if (r0 == null) goto L7;
            if (ensureNoLeakedReferences == true) goto L6;
            return r0;
        L6:
            return (byte[]) r0.clone();
        L7:
            int r5 = this.pos;
            int r1 = this.bufferSize;
            int r2 = r1 - r5;
            this.totalBytesRetired += r1;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r3 = readRawBytesSlowPathRemainingChunks(size - r2);
            byte[] r4 = new byte[size];
            System.arraycopy(this.buffer, r5, r4, 0, r2);
            Iterator<byte[]> r6 = r3.iterator();
        L9:
            if (r6.hasNext() == false) goto L11;
            byte[] r7 = r6.next();
            System.arraycopy(r7, 0, r4, r2, r7.length);
            r2 = r2 + r7.length;
            goto L9
        L11:
            return r4;
        }

        private byte[] readRawBytesSlowPathOneChunk(final int size) throws IOException {
            if (size == 0) goto L4;
            if (size < 0) goto L30;
            int r0 = (this.totalBytesRetired + this.pos) + size;
            if ((r0 - this.sizeLimit) > 0) goto L28;
            int r1 = this.currentLimit;
            if (r0 > r1) goto L25;
            int r2 = this.bufferSize - this.pos;
            int r3 = size - r2;
            if (r3 >= 4096) goto L13;
        L17:
            byte[] r4 = new byte[size];
            System.arraycopy(this.buffer, this.pos, r4, 0, r2);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
        L18:
            if (r2 >= size) goto L24;
            int r5 = read(this.input, r4, r2, size - r2);
            if (r5 == (-1)) goto L23;
            this.totalBytesRetired += r5;
            r2 = r2 + r5;
            goto L18
        L23:
            throw InvalidProtocolBufferException.truncatedMessage();
        L24:
            return r4;
        L13:
            if (r3 <= available(this.input)) goto L17;
            return null;
        L25:
            skipRawBytes((r1 - this.totalBytesRetired) - this.pos);
            throw InvalidProtocolBufferException.truncatedMessage();
        L28:
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        L30:
            throw InvalidProtocolBufferException.negativeSize();
        L4:
            return Internal.EMPTY_BYTE_ARRAY;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int sizeLeft) throws IOException {
            ArrayList r0 = new ArrayList();
        L3:
            if (sizeLeft <= 0) goto L12;
            int r1 = Math.min(sizeLeft, 4096);
            byte[] r2 = new byte[r1];
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L11;
            int r4 = this.input.read(r2, r3, r1 - r3);
            if (r4 == (-1)) goto L10;
            this.totalBytesRetired += r4;
            r3 = r3 + r4;
            goto L5
        L10:
            throw InvalidProtocolBufferException.truncatedMessage();
        L11:
            sizeLeft = sizeLeft - r1;
            r0.add(r2);
            goto L3
        L12:
            return r0;
        }

        private ByteString readBytesSlowPath(final int size) throws IOException {
            byte[] r0 = readRawBytesSlowPathOneChunk(size);
            if (r0 != null) goto L5;
            int r1 = this.pos;
            int r2 = this.bufferSize;
            int r3 = r2 - r1;
            this.totalBytesRetired += r2;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> r4 = readRawBytesSlowPathRemainingChunks(size - r3);
            byte[] r5 = new byte[size];
            System.arraycopy(this.buffer, r1, r5, 0, r3);
            Iterator<byte[]> r6 = r4.iterator();
        L8:
            if (r6.hasNext() == false) goto L11;
            byte[] r7 = r6.next();
            System.arraycopy(r7, 0, r5, r3, r7.length);
            r3 = r3 + r7.length;
            goto L8
        L11:
            return ByteString.wrap(r5);
        L5:
            return ByteString.copyFrom(r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(final int size) throws IOException {
            int r0 = this.bufferSize;
            int r1 = this.pos;
            if (size > (r0 - r1)) goto L6;
            if (size < 0) goto L6;
            this.pos = r1 + size;
            return;
        L6:
            skipRawBytesSlowPath(size);
        }

        private void skipRawBytesSlowPath(final int size) throws IOException {
            if (size < 0) goto L33;
            int r0 = this.totalBytesRetired;
            int r1 = this.pos;
            int r2 = (r0 + r1) + size;
            int r3 = this.currentLimit;
            if (r2 > r3) goto L30;
            int r4 = 0;
            if (this.refillCallback != null) goto L23;
            this.totalBytesRetired = r0 + r1;
            int r5 = this.bufferSize - r1;
            this.bufferSize = 0;
            this.pos = 0;
            r4 = r5;
        L8:
            if (r4 >= size) goto L22;
            long r6 = size - r4;
            long r7 = skip(this.input, r6);     // Catch: Throwable -> L19
            if (r7 < 0) goto L18;
            if (r7 > r6) goto L18;
            if (r7 == 0) goto L22;
            r4 = r4 + ((int) r7);     // Catch: Throwable -> L19
        L18:
            throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + r7 + "\nThe InputStream implementation is buggy.");     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            this.totalBytesRetired += r4;
            recomputeBufferSizeAfterLimit();
            throw th;
        L22:
            this.totalBytesRetired += r4;
            recomputeBufferSizeAfterLimit();
        L23:
            if (r4 >= size) goto L41;
            int r8 = this.bufferSize;
            int r9 = r8 - this.pos;
            this.pos = r8;
            refillBuffer(1);
        L25:
            int r10 = size - r9;
            int r11 = this.bufferSize;
            if (r10 <= r11) goto L28;
            r9 = r9 + r11;
            this.pos = r11;
            refillBuffer(1);
            goto L25
        L28:
            this.pos = r10;
            return;
        L41:
            return;
        L30:
            skipRawBytes((r3 - r0) - r1);
            throw InvalidProtocolBufferException.truncatedMessage();
        L33:
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        /* synthetic */ UnsafeDirectNioDecoder(ByteBuffer r1, boolean r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private UnsafeDirectNioDecoder(ByteBuffer buffer, boolean immutable) {
            super(null);
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            long r0 = UnsafeUtil.addressOffset(buffer);
            this.address = r0;
            this.limit = ((long) buffer.limit()) + r0;
            long r1 = r0 + ((long) buffer.position());
            this.pos = r1;
            this.startPos = r1;
            this.immutable = immutable;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd() == false) goto L6;
            this.lastTag = 0;
            return 0;
        L6:
            int r0 = readRawVarint32();
            this.lastTag = r0;
            if (WireFormat.getTagFieldNumber(r0) == 0) goto L11;
            return this.lastTag;
        L11:
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void checkLastTagWas(final int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) goto L6;
            return;
        L6:
            throw InvalidProtocolBufferException.invalidEndTag();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            skipRawBytes(8);
            return true;
        L6:
            if (r0 != 2) goto L8;
            skipRawBytes(readRawVarint32());
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            skipRawBytes(4);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            skipMessage();
            checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
            return true;
        L24:
            skipRawVarint();
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean skipField(final int tag, final CodedOutputStream output) throws IOException {
            int r0 = WireFormat.getTagWireType(tag);
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            long r2 = readRawLittleEndian64();
            output.writeUInt32NoTag(tag);
            output.writeFixed64NoTag(r2);
            return true;
        L6:
            if (r0 != 2) goto L8;
            ByteString r4 = readBytes();
            output.writeUInt32NoTag(tag);
            output.writeBytesNoTag(r4);
            return true;
        L8:
            if (r0 == 3) goto L18;
            if (r0 != 4) goto L11;
            return false;
        L11:
            if (r0 != 5) goto L15;
            int r5 = readRawLittleEndian32();
            output.writeUInt32NoTag(tag);
            output.writeFixed32NoTag(r5);
            return true;
        L15:
            throw InvalidProtocolBufferException.invalidWireType();
        L18:
            output.writeUInt32NoTag(tag);
            skipMessage(output);
            int r6 = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
            checkLastTagWas(r6);
            output.writeUInt32NoTag(r6);
            return true;
        L24:
            long r3 = readInt64();
            output.writeUInt32NoTag(tag);
            output.writeUInt64NoTag(r3);
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
        L2:
            int r0 = readTag();
            if (r0 == 0) goto L6;
            if (skipField(r0, output) == true) goto L2;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            if (readRawVarint64() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readString() throws IOException {
            int r0 = readRawVarint32();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 >= 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r0 > remaining()) goto L8;
            byte[] r1 = new byte[r0];
            long r9 = r0;
            UnsafeUtil.copyMemory(this.pos, r1, 0, r9);
            String r2 = new String(r1, Internal.UTF_8);
            this.pos += r9;
            return r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int r0 = readRawVarint32();
            if (r0 > 0) goto L5;
        L8:
            if (r0 != 0) goto L11;
            return "";
        L11:
            if (r0 > 0) goto L15;
            throw InvalidProtocolBufferException.negativeSize();
        L15:
            throw InvalidProtocolBufferException.truncatedMessage();
        L5:
            if (r0 > remaining()) goto L8;
            String r1 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), r0);
            this.pos += (long) r0;
            return r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return r3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException {
            int r0 = readRawVarint32();
            checkRecursionLimit();
            int r1 = pushLimit(r0);
            this.recursionDepth++;
            T r3 = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) goto L7;
            popLimit(r1);
            return r3;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int r0 = readRawVarint32();
            if (r0 > 0) goto L5;
        L14:
            if (r0 == 0) goto L16;
            if (r0 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return ByteString.EMPTY;
        L5:
            if (r0 > remaining()) goto L14;
            if (this.immutable == true) goto L9;
        L12:
            byte[] r7 = new byte[r0];
            long r8 = r0;
            UnsafeUtil.copyMemory(this.pos, r7, 0, r8);
            this.pos += r8;
            return ByteString.wrap(r7);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r1 = this.pos;
            long r3 = r0;
            ByteBuffer r2 = slice(r1, r1 + r3);
            this.pos += r3;
            return ByteString.wrap(r2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int r0 = readRawVarint32();
            if (r0 > 0) goto L5;
        L14:
            if (r0 == 0) goto L16;
            if (r0 >= 0) goto L21;
            throw InvalidProtocolBufferException.negativeSize();
        L21:
            throw InvalidProtocolBufferException.truncatedMessage();
        L16:
            return Internal.EMPTY_BYTE_BUFFER;
        L5:
            if (r0 > remaining()) goto L14;
            if (this.immutable == false) goto L9;
        L12:
            byte[] r1 = new byte[r0];
            long r10 = r0;
            UnsafeUtil.copyMemory(this.pos, r1, 0, r10);
            this.pos += r10;
            return ByteBuffer.wrap(r1);
        L9:
            if (this.enableAliasing == false) goto L12;
            long r2 = this.pos;
            long r3 = r0;
            ByteBuffer r4 = slice(r2, r2 + r3);
            this.pos += r3;
            return r4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawVarint32() throws IOException {
            long r0 = this.pos;
            if (this.limit == r0) goto L35;
            long r4 = r0 + 1;
            byte r1 = UnsafeUtil.getByte(r0);
            if (r1 < 0) goto L10;
            this.pos = r4;
            return r1;
        L10:
            if ((this.limit - r4) < 9) goto L35;
            long r6 = r4 + 1;
            int r2 = r1 ^ (UnsafeUtil.getByte(r4) << 7);
            if (r2 >= 0) goto L15;
            int r3 = r2 ^ (-128);
        L36:
            this.pos = r6;
            return r3;
        L15:
            long r5 = r6 + 1;
            int r7 = r2 ^ (UnsafeUtil.getByte(r6) << 14);
            if (r7 < 0) goto L19;
            r3 = r7 ^ 16256;
        L18:
            r6 = r5;
            goto L36
        L19:
            r6 = r5 + 1;
            int r8 = r7 ^ (UnsafeUtil.getByte(r5) << 21);
            if (r8 >= 0) goto L22;
            r3 = r8 ^ (-2080896);
            goto L36
        L22:
            r5 = r6 + 1;
            byte r9 = UnsafeUtil.getByte(r6);
            r3 = (r8 ^ (r9 << 28)) ^ 266354560;
            if (r9 >= 0) goto L18;
            r6 = r5 + 1;
            if (UnsafeUtil.getByte(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (UnsafeUtil.getByte(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (UnsafeUtil.getByte(r5) >= 0) goto L36;
            r5 = r6 + 1;
            if (UnsafeUtil.getByte(r6) >= 0) goto L18;
            r6 = r5 + 1;
            if (UnsafeUtil.getByte(r5) >= 0) goto L36;
        L35:
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (remaining() < 10) goto L5;
            skipRawVarintFastPath();
            return;
        L5:
            skipRawVarintSlowPath();
        }

        private void skipRawVarintFastPath() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            long r1 = this.pos;
            this.pos = 1 + r1;
            if (UnsafeUtil.getByte(r1) >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int r0 = 0;
        L4:
            if (r0 >= 10) goto L10;
            if (readRawByte() >= 0) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawVarint64() throws IOException {
            long r0 = this.pos;
            if (this.limit == r0) goto L42;
            long r4 = r0 + 1;
            byte r1 = UnsafeUtil.getByte(r0);
            if (r1 < 0) goto L10;
            this.pos = r4;
            return r1;
        L10:
            if ((this.limit - r4) < 9) goto L42;
            long r6 = r4 + 1;
            int r2 = r1 ^ (UnsafeUtil.getByte(r4) << 7);
            if (r2 >= 0) goto L16;
            int r3 = r2 ^ (-128);
        L15:
            long r5 = r3;
        L44:
            this.pos = r6;
            return r5;
        L16:
            long r7 = r6 + 1;
            int r8 = r2 ^ (UnsafeUtil.getByte(r6) << 14);
            if (r8 < 0) goto L20;
            r5 = r8 ^ 16256;
        L19:
            r6 = r7;
            goto L44
        L20:
            r6 = r7 + 1;
            int r9 = r8 ^ (UnsafeUtil.getByte(r7) << 21);
            if (r9 >= 0) goto L23;
            r3 = r9 ^ (-2080896);
            goto L15
        L23:
            r7 = r6 + 1;
            long r10 = ((long) r9) ^ (((long) UnsafeUtil.getByte(r6)) << 28);
            if (r10 < 0) goto L27;
            long r11 = 266354560;
        L26:
            r5 = r10 ^ r11;
            goto L19
        L27:
            long r12 = r7 + 1;
            long r13 = r10 ^ (((long) UnsafeUtil.getByte(r7)) << 35);
            if (r13 >= 0) goto L31;
            long r14 = -34093383808L;
        L30:
            r5 = r13 ^ r14;
            r6 = r12;
            goto L44
        L31:
            r7 = r12 + 1;
            r10 = r13 ^ (((long) UnsafeUtil.getByte(r12)) << 42);
            if (r10 < 0) goto L34;
            r11 = 4363953127296L;
            goto L26
        L34:
            r12 = r7 + 1;
            r13 = r10 ^ (((long) UnsafeUtil.getByte(r7)) << 49);
            if (r13 >= 0) goto L37;
            r14 = -558586000294016L;
            goto L30
        L37:
            r7 = r12 + 1;
            r5 = (r13 ^ (((long) UnsafeUtil.getByte(r12)) << 56)) ^ 71499008037633920L;
            if (r5 >= 0) goto L19;
            long r15 = 1 + r7;
            if (UnsafeUtil.getByte(r7) < 0) goto L42;
            r6 = r15;
        L42:
            return readRawVarint64SlowPath();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            long r0 = 0;
            int r2 = 0;
        L4:
            if (r2 >= 64) goto L10;
            byte r3 = readRawByte();
            r0 = r0 | (((long) (r3 & 127)) << r2);
            if ((r3 & 128) == 0) goto L7;
            r2 = r2 + 7;
            goto L4
        L7:
            return r0;
        L10:
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long r0 = this.pos;
            if ((this.limit - r0) < 4) goto L7;
            this.pos = 4 + r0;
            return (((UnsafeUtil.getByte(r0) & 255) | ((UnsafeUtil.getByte(1 + r0) & 255) << 8)) | ((UnsafeUtil.getByte(2 + r0) & 255) << 16)) | ((UnsafeUtil.getByte(r0 + 3) & 255) << 24);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long r0 = this.pos;
            if ((this.limit - r0) < 8) goto L7;
            this.pos = 8 + r0;
            long r2 = ((((((((long) UnsafeUtil.getByte(r0)) & 255) | ((((long) UnsafeUtil.getByte(1 + r0)) & 255) << 8)) | ((((long) UnsafeUtil.getByte(2 + r0)) & 255) << 16)) | ((((long) UnsafeUtil.getByte(3 + r0)) & 255) << 24)) | ((((long) UnsafeUtil.getByte(4 + r0)) & 255) << 32)) | ((((long) UnsafeUtil.getByte(5 + r0)) & 255) << 40)) | ((((long) UnsafeUtil.getByte(6 + r0)) & 255) << 48);
            return ((((long) UnsafeUtil.getByte(r0 + 7)) & 255) << 56) | r2;
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) goto L10;
            int r2 = byteLimit + getTotalBytesRead();
            int r0 = this.currentLimit;
            if (r2 > r0) goto L8;
            this.currentLimit = r2;
            recomputeBufferSizeAfterLimit();
            return r0;
        L8:
            throw InvalidProtocolBufferException.truncatedMessage();
        L10:
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void popLimit(final int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int r0 = this.currentLimit;
            if (r0 != Integer.MAX_VALUE) goto L7;
            return -1;
        L7:
            return r0 - getTotalBytesRead();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            if (this.pos != this.limit) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            long r0 = this.pos;
            if (r0 == this.limit) goto L7;
            this.pos = 1 + r0;
            return UnsafeUtil.getByte(r0);
        L7:
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(final int length) throws IOException {
            if (length >= 0) goto L4;
        L7:
            if (length > 0) goto L14;
            if (length != 0) goto L12;
            return Internal.EMPTY_BYTE_ARRAY;
        L12:
            throw InvalidProtocolBufferException.negativeSize();
        L14:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > remaining()) goto L7;
            byte[] r0 = new byte[length];
            long r1 = this.pos;
            long r3 = length;
            slice(r1, r1 + r3).get(r0);
            this.pos += r3;
            return r0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream
        public void skipRawBytes(final int length) throws IOException {
            if (length >= 0) goto L4;
        L7:
            if (length >= 0) goto L11;
            throw InvalidProtocolBufferException.negativeSize();
        L11:
            throw InvalidProtocolBufferException.truncatedMessage();
        L4:
            if (length > remaining()) goto L7;
            this.pos += (long) length;
        }

        private void recomputeBufferSizeAfterLimit() {
            long r0 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = r0;
            int r2 = (int) (r0 - this.startPos);
            int r3 = this.currentLimit;
            if (r2 <= r3) goto L5;
            int r4 = r2 - r3;
            this.bufferSizeAfterLimit = r4;
            this.limit = r0 - ((long) r4);
            return;
        L5:
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private int bufferPos(long pos) {
            return (int) (pos - this.address);
        }

        private ByteBuffer slice(long begin, long end) throws IOException {
            int r0 = this.buffer.position();
            int r1 = this.buffer.limit();
            ByteBuffer r2 = this.buffer;
            r2.position(bufferPos(begin));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.limit(bufferPos(end));     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            ByteBuffer r3 = this.buffer.slice();     // Catch: Throwable -> L6 IllegalArgumentException -> L8
            r2.position(r0);
            r2.limit(r1);
            return r3;
        L8:
            e = move-exception;
            InvalidProtocolBufferException r4 = InvalidProtocolBufferException.truncatedMessage();     // Catch: Throwable -> L6
            r4.initCause(e);     // Catch: Throwable -> L6
            throw r4;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            r2.position(r0);
            r2.limit(r1);
            throw th;
        }
    }

    static {
    }

    public static int decodeZigZag32(final int n) {
        int r0 = n >>> 1;
        return (-(n & 1)) ^ r0;
    }

    public static long decodeZigZag64(final long n) {
        long r0 = n >>> 1;
        return (-(n & 1)) ^ r0;
    }

    public abstract void checkLastTagWas(final int value) throws InvalidProtocolBufferException;

    public abstract void enableAliasing(boolean enabled);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(final int oldLimit);

    public abstract int pushLimit(int byteLimit) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(final int fieldNumber, final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract void readGroup(final int fieldNumber, final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(final Parser<T> parser, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract void readMessage(final MessageLite.Builder builder, final ExtensionRegistryLite extensionRegistry) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(final int size) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(final int fieldNumber, final MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public abstract boolean skipField(final int tag) throws IOException;

    @Deprecated
    public abstract boolean skipField(final int tag, final CodedOutputStream output) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream output) throws IOException;

    public abstract void skipRawBytes(final int size) throws IOException;

    /* synthetic */ CodedInputStream(AnonymousClass1 r1) {
        this();
    }

    public static CodedInputStream newInstance(final InputStream input) {
        return newInstance(input, 4096);
    }

    public static CodedInputStream newInstance(final InputStream input, int bufferSize) {
        if (bufferSize <= 0) goto L9;
        if (input != null) goto L7;
        return newInstance(Internal.EMPTY_BYTE_ARRAY);
    L7:
        return new StreamDecoder(input, bufferSize, null);
    L9:
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(final Iterable<ByteBuffer> input) {
        if (UnsafeDirectNioDecoder.isSupported() == true) goto L7;
        return newInstance(new IterableByteBufferInputStream(input));
    L7:
        return newInstance(input, false);
    }

    static CodedInputStream newInstance(final Iterable<ByteBuffer> bufs, final boolean bufferIsImmutable) {
        Iterator<ByteBuffer> r0 = bufs.iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        ByteBuffer r3 = r0.next();
        r2 = r2 + r3.remaining();
        if (r3.hasArray() == true) goto L7;
        if (r3.isDirect() == true) goto L10;
        r1 = r1 | 4;
        goto L4
    L10:
        r1 = r1 | 2;
        goto L4
    L7:
        r1 = r1 | 1;
        goto L4
    L13:
        if (r1 != 2) goto L17;
        return new IterableDirectByteBufferDecoder(bufs, r2, bufferIsImmutable, null);
    L17:
        return newInstance(new IterableByteBufferInputStream(bufs));
    }

    public static CodedInputStream newInstance(final byte[] buf) {
        return newInstance(buf, 0, buf.length);
    }

    public static CodedInputStream newInstance(final byte[] buf, final int off, final int len) {
        return newInstance(buf, off, len, false);
    }

    static CodedInputStream newInstance(final byte[] buf, final int off, final int len, final boolean bufferIsImmutable) {
        ArrayDecoder r6 = new ArrayDecoder(buf, off, len, bufferIsImmutable, null);
        r6.pushLimit(len);     // Catch: InvalidProtocolBufferException -> L5
        return r6;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static CodedInputStream newInstance(ByteBuffer buf) {
        return newInstance(buf, false);
    }

    static CodedInputStream newInstance(ByteBuffer buf, boolean bufferIsImmutable) {
        if (buf.hasArray() == false) goto L7;
        return newInstance(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining(), bufferIsImmutable);
    L7:
        if (buf.isDirect() == true) goto L9;
    L12:
        int r4 = buf.remaining();
        byte[] r0 = new byte[r4];
        buf.duplicate().get(r0);
        return newInstance(r0, 0, r4, true);
    L9:
        if (UnsafeDirectNioDecoder.isSupported() == false) goto L12;
        return new UnsafeDirectNioDecoder(buf, bufferIsImmutable, null);
    }

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) goto L6;
        return;
    L6:
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public final int setRecursionLimit(final int limit) {
        if (limit < 0) goto L6;
        int r0 = this.recursionLimit;
        this.recursionLimit = limit;
        return r0;
    L6:
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + limit);
    }

    public final int setSizeLimit(final int limit) {
        if (limit < 0) goto L6;
        int r0 = this.sizeLimit;
        this.sizeLimit = limit;
        return r0;
    L6:
        throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
    }

    final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public static int readRawVarint32(final int firstByte, final InputStream input) throws IOException {
        if ((firstByte & 128) != 0) goto L5;
        return firstByte;
    L5:
        int r3 = firstByte & 127;
        int r0 = 7;
    L7:
        if (r0 >= 32) goto L17;
        int r1 = input.read();
        if (r1 == (-1)) goto L15;
        r3 = r3 | ((r1 & 127) << r0);
        if ((r1 & 128) == 0) goto L12;
        r0 = r0 + 7;
        goto L7
    L12:
        return r3;
    L15:
        throw InvalidProtocolBufferException.truncatedMessage();
    L17:
        if (r0 >= 64) goto L27;
        int r2 = input.read();
        if (r2 == (-1)) goto L25;
        if ((r2 & 128) == 0) goto L22;
        r0 = r0 + 7;
        goto L17
    L22:
        return r3;
    L25:
        throw InvalidProtocolBufferException.truncatedMessage();
    L27:
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(final InputStream input) throws IOException {
        int r0 = input.read();
        if (r0 == (-1)) goto L7;
        return readRawVarint32(r0, input);
    L7:
        throw InvalidProtocolBufferException.truncatedMessage();
    }
}
