package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = null;
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int bufferSize) {
            super(null);
            if (bufferSize < 0) goto L7;
            byte[] r2 = new byte[Math.max(bufferSize, 20)];
            this.buffer = r2;
            this.limit = r2.length;
            return;
        L7:
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        final void buffer(byte value) {
            byte[] r0 = this.buffer;
            int r1 = this.position;
            this.position = r1 + 1;
            r0[r1] = value;
            this.totalBytesWritten++;
        }

        final void bufferTag(final int fieldNumber, final int wireType) {
            bufferUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        final void bufferInt32NoTag(final int value) {
            if (value < 0) goto L4;
            bufferUInt32NoTag(value);
            return;
        L4:
            bufferUInt64NoTag(value);
        }

        final void bufferUInt32NoTag(int value) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r0 = this.position;
        L6:
            if ((value & (-128)) == 0) goto L7;
            byte[] r2 = this.buffer;
            int r3 = this.position;
            this.position = r3 + 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((value & 127) | 128));
            value = value >>> 7;
            goto L6
        L7:
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            UnsafeUtil.putByte(r4, r5, (byte) value);
            this.totalBytesWritten += (int) (((long) this.position) - r0);
            return;
        L11:
            if ((value & (-128)) == 0) goto L12;
            byte[] r1 = this.buffer;
            int r6 = this.position;
            this.position = r6 + 1;
            r1[r6] = (byte) ((value & 127) | 128);
            this.totalBytesWritten++;
            value = value >>> 7;
            goto L11
        L12:
            byte[] r7 = this.buffer;
            int r8 = this.position;
            this.position = r8 + 1;
            r7[r8] = (byte) value;
            this.totalBytesWritten++;
        }

        final void bufferUInt64NoTag(long value) {
            if (CodedOutputStream.access$100() == false) goto L11;
            long r6 = this.position;
        L6:
            if ((value & (-128)) == 0) goto L7;
            byte[] r0 = this.buffer;
            int r8 = this.position;
            this.position = r8 + 1;
            UnsafeUtil.putByte(r0, r8, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L6
        L7:
            byte[] r1 = this.buffer;
            int r2 = this.position;
            this.position = r2 + 1;
            UnsafeUtil.putByte(r1, r2, (byte) value);
            this.totalBytesWritten += (int) (((long) this.position) - r6);
            return;
        L11:
            if ((value & (-128)) == 0) goto L12;
            byte[] r3 = this.buffer;
            int r7 = this.position;
            this.position = r7 + 1;
            r3[r7] = (byte) ((((int) value) & 127) | 128);
            this.totalBytesWritten++;
            value = value >>> 7;
            goto L11
        L12:
            byte[] r4 = this.buffer;
            int r5 = this.position;
            this.position = r5 + 1;
            r4[r5] = (byte) value;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.position;
            int r2 = r1 + 1;
            r0[r1] = (byte) (value & 255);
            int r3 = r2 + 1;
            r0[r2] = (byte) ((value >> 8) & 255);
            int r4 = r3 + 1;
            r0[r3] = (byte) ((value >> 16) & 255);
            this.position = r4 + 1;
            r0[r4] = (byte) ((value >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.position;
            int r2 = r1 + 1;
            r0[r1] = (byte) (value & 255);
            int r3 = r2 + 1;
            r0[r2] = (byte) ((value >> 8) & 255);
            int r4 = r3 + 1;
            r0[r3] = (byte) ((value >> 16) & 255);
            int r5 = r4 + 1;
            r0[r4] = (byte) (255 & (value >> 24));
            int r6 = r5 + 1;
            r0[r5] = (byte) (((int) (value >> 32)) & 255);
            int r7 = r6 + 1;
            r0[r6] = (byte) (((int) (value >> 40)) & 255);
            int r8 = r7 + 1;
            r0[r7] = (byte) (((int) (value >> 48)) & 255);
            this.position = r8 + 1;
            r0[r8] = (byte) (((int) (value >> 56)) & 255);
            this.totalBytesWritten += 8;
        }
    }

    private static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
        }

        ArrayEncoder(byte[] buffer, int offset, int length) {
            super(null);
            if (buffer == null) goto L11;
            int r2 = offset + length;
            if (((offset | length) | (buffer.length - r2)) < 0) goto L9;
            this.buffer = buffer;
            this.offset = offset;
            this.position = offset;
            this.limit = r2;
            return;
        L9:
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(buffer.length), Integer.valueOf(offset), Integer.valueOf(length)}));
        L11:
            throw new NullPointerException("buffer");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeTag(final int fieldNumber, final int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32(final int fieldNumber, final int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32(final int fieldNumber, final int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32(final int fieldNumber, final int value) throws IOException {
            writeTag(fieldNumber, 5);
            writeFixed32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64(final int fieldNumber, final long value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64(final int fieldNumber, final long value) throws IOException {
            writeTag(fieldNumber, 1);
            writeFixed64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBool(int r2, boolean r3) throws IOException {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeString(final int fieldNumber, final String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBytes(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArray(final int fieldNumber, final byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArray(final int fieldNumber, final byte[] value, final int offset, final int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteBuffer(final int fieldNumber, final ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeBytesNoTag(final ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(final byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeRawBytes(final ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer r3 = value.duplicate();
            Java8Compatibility.clear(r3);
            write(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessage(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void writeMessage(final int fieldNumber, final MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeMessageNoTag(final MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void writeMessageNoTag(final MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(byte value) throws IOException {
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            this.position = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = value;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int value) throws IOException {
        L3:
            if ((value & (-128)) == 0) goto L4;
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L8
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L8
            this.position = r1 + 1;     // Catch: IndexOutOfBoundsException -> L8
            r0[r1] = (byte) ((value & 127) | 128);     // Catch: IndexOutOfBoundsException -> L8
            value = value >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L4:
            byte[] r2 = this.buffer;     // Catch: IndexOutOfBoundsException -> L8
            int r3 = this.position;     // Catch: IndexOutOfBoundsException -> L8
            this.position = r3 + 1;     // Catch: IndexOutOfBoundsException -> L8
            r2[r3] = (byte) value;     // Catch: IndexOutOfBoundsException -> L8
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int value) throws IOException {
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            int r2 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = (byte) (value & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r3 = r2 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r2] = (byte) ((value >> 8) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r4 = r3 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r3] = (byte) ((value >> 16) & 255);     // Catch: IndexOutOfBoundsException -> L4
            this.position = r4 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r4] = (byte) ((value >> 24) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long value) throws IOException {
            if (CodedOutputStream.access$100() == false) goto L12;
            if (spaceLeft() < 10) goto L12;
        L7:
            if ((value & (-128)) == 0) goto L8;
            byte[] r0 = this.buffer;
            int r6 = this.position;
            this.position = r6 + 1;
            UnsafeUtil.putByte(r0, r6, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L7
        L8:
            byte[] r1 = this.buffer;
            int r2 = this.position;
            this.position = r2 + 1;
            UnsafeUtil.putByte(r1, r2, (byte) value);
            return;
        L12:
            if ((value & (-128)) == 0) goto L13;
            byte[] r3 = this.buffer;     // Catch: IndexOutOfBoundsException -> L17
            int r7 = this.position;     // Catch: IndexOutOfBoundsException -> L17
            this.position = r7 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r3[r7] = (byte) ((((int) value) & 127) | 128);     // Catch: IndexOutOfBoundsException -> L17
            value = value >>> 7;
        L17:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        L13:
            byte[] r4 = this.buffer;     // Catch: IndexOutOfBoundsException -> L17
            int r5 = this.position;     // Catch: IndexOutOfBoundsException -> L17
            this.position = r5 + 1;     // Catch: IndexOutOfBoundsException -> L17
            r4[r5] = (byte) value;     // Catch: IndexOutOfBoundsException -> L17
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long value) throws IOException {
            byte[] r0 = this.buffer;     // Catch: IndexOutOfBoundsException -> L4
            int r1 = this.position;     // Catch: IndexOutOfBoundsException -> L4
            int r2 = r1 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r1] = (byte) (((int) value) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r3 = r2 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r2] = (byte) (((int) (value >> 8)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r4 = r3 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r3] = (byte) (((int) (value >> 16)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r5 = r4 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r4] = (byte) (((int) (value >> 24)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r6 = r5 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r5] = (byte) (((int) (value >> 32)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r7 = r6 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r6] = (byte) (((int) (value >> 40)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            int r8 = r7 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r7] = (byte) (((int) (value >> 48)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            this.position = r8 + 1;     // Catch: IndexOutOfBoundsException -> L4
            r0[r8] = (byte) (((int) (value >> 56)) & 255);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(byte[] value, int offset, int length) throws IOException {
            System.arraycopy(value, offset, this.buffer, this.position, length);     // Catch: IndexOutOfBoundsException -> L4
            this.position += length;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(length)}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void write(ByteBuffer value) throws IOException {
            int r0 = value.remaining();
            value.get(this.buffer, this.position, r0);     // Catch: IndexOutOfBoundsException -> L5
            this.position += r0;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(r0)}), e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void writeStringNoTag(String value) throws IOException {
            int r0 = this.position;
            int r1 = computeUInt32SizeNoTag(value.length() * 3);     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r2 = computeUInt32SizeNoTag(value.length());     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            if (r2 != r1) goto L6;
            int r3 = r0 + r2;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = r3;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r4 = Utf8.encode(value, this.buffer, r3, spaceLeft());     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = r0;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            writeUInt32NoTag((r4 - r0) - r2);     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = r4;     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
        L14:
            return;
        L6:
            writeUInt32NoTag(Utf8.encodedLength(value));     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
            this.position = Utf8.encode(value, this.buffer, this.position, spaceLeft());     // Catch: IndexOutOfBoundsException -> L8 Utf8.UnpairedSurrogateException -> L11
        L11:
            e = move-exception;
            this.position = r0;
            inefficientWriteStringNoTag(value, e);
            return;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        ByteOutputEncoder(ByteOutput out, int bufferSize) {
            super(bufferSize);
            if (out == null) goto L7;
            this.out = out;
            return;
        L7:
            throw new NullPointerException("out");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(final int fieldNumber, final int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(final int fieldNumber, final int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(final int fieldNumber, final int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(final int fieldNumber, final int value) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(fieldNumber, 5);
            bufferFixed32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(final int fieldNumber, final long value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(final int fieldNumber, final long value) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(fieldNumber, 1);
            bufferFixed64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r2, 0);
            buffer(r3 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(final int fieldNumber, final String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(final int fieldNumber, final byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(final int fieldNumber, final byte[] value, final int offset, final int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(final int fieldNumber, final ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(final ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(final byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(final ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer r3 = value.duplicate();
            Java8Compatibility.clear(r3);
            write(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(final int fieldNumber, final MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(final MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(final MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(final int value) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(final long value) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            int r0 = value.length() * 3;
            int r1 = computeUInt32SizeNoTag(r0);
            int r2 = r1 + r0;
            if (r2 <= this.limit) goto L7;
            byte[] r3 = new byte[r0];
            int r7 = Utf8.encode(value, r3, 0, r0);
            writeUInt32NoTag(r7);
            writeLazy(r3, 0, r7);
            return;
        L7:
            if (r2 <= (this.limit - this.position)) goto L9;
            doFlush();
        L9:
            int r4 = this.position;
            int r5 = computeUInt32SizeNoTag(value.length());     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            if (r5 != r1) goto L13;
            this.position = r4 + r5;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r6 = Utf8.encode(value, this.buffer, this.position, this.limit - this.position);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r4;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            int r8 = (r6 - r4) - r5;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r8);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = r6;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r8;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L21:
            return;
        L13:
            int r9 = Utf8.encodedLength(value);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            bufferUInt32NoTag(r9);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.position = Utf8.encode(value, this.buffer, this.position, r9);     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
            this.totalBytesWritten += r9;     // Catch: IndexOutOfBoundsException -> L15 Utf8.UnpairedSurrogateException -> L18
        L18:
            e = move-exception;
            this.totalBytesWritten -= this.position - r4;
            this.position = r4;
            inefficientWriteStringNoTag(value, e);
            return;
        L15:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            flush();
            this.out.write(value, offset, length);
            this.totalBytesWritten += length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            flush();
            this.out.writeLazy(value, offset, length);
            this.totalBytesWritten += length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            flush();
            int r0 = value.remaining();
            this.out.write(value);
            this.totalBytesWritten += r0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            flush();
            int r0 = value.remaining();
            this.out.writeLazy(value);
            this.totalBytesWritten += r0;
        }

        private void flushIfNotAvailable(int requiredSize) throws IOException {
            if ((this.limit - this.position) >= requiredSize) goto L6;
            doFlush();
            return;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }

    private static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream.ArrayEncoder, com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String explanationMessage) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + explanationMessage);
        }

        OutOfSpaceException(Throwable cause) {
            super(MESSAGE, cause);
        }

        OutOfSpaceException(String explanationMessage, Throwable cause) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + explanationMessage, cause);
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream out, int bufferSize) {
            super(bufferSize);
            if (out == null) goto L7;
            this.out = out;
            return;
        L7:
            throw new NullPointerException("out");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(final int fieldNumber, final int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(final int fieldNumber, final int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(final int fieldNumber, final int value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(final int fieldNumber, final int value) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(fieldNumber, 5);
            bufferFixed32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(final int fieldNumber, final long value) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(fieldNumber, 0);
            bufferUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(final int fieldNumber, final long value) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(fieldNumber, 1);
            bufferFixed64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(r2, 0);
            buffer(r3 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(final int fieldNumber, final String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(final int fieldNumber, final byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(final int fieldNumber, final byte[] value, final int offset, final int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(final int fieldNumber, final ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(final ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(final byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(final ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer r3 = value.duplicate();
            Java8Compatibility.clear(r3);
            write(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(final int fieldNumber, final MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(final MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(final MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            if (this.position != this.limit) goto L5;
            doFlush();
        L5:
            buffer(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(final int value) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(final long value) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            int r0 = value.length() * 3;     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r1 = computeUInt32SizeNoTag(r0);     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r2 = r1 + r0;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r2 <= this.limit) goto L7;
            byte[] r3 = new byte[r0];     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r4 = Utf8.encode(value, r3, 0, r0);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeUInt32NoTag(r4);     // Catch: Utf8.UnpairedSurrogateException -> L22
            writeLazy(r3, 0, r4);     // Catch: Utf8.UnpairedSurrogateException -> L22
            return;
        L7:
            if (r2 <= (this.limit - this.position)) goto L9;
            doFlush();     // Catch: Utf8.UnpairedSurrogateException -> L22
        L9:
            int r5 = computeUInt32SizeNoTag(value.length());     // Catch: Utf8.UnpairedSurrogateException -> L22
            int r6 = this.position;     // Catch: Utf8.UnpairedSurrogateException -> L22
            if (r5 == r1) goto L12;
            int r7 = Utf8.encodedLength(value);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r7);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = Utf8.encode(value, this.buffer, this.position, r7);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L14:
            this.totalBytesWritten += r7;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L28:
            return;
        L12:
            this.position = r6 + r5;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            int r8 = Utf8.encode(value, this.buffer, this.position, this.limit - this.position);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r6;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            r7 = (r8 - r6) - r5;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            bufferUInt32NoTag(r7);     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
            this.position = r8;     // Catch: ArrayIndexOutOfBoundsException -> L16 Utf8.UnpairedSurrogateException -> L19
        L19:
            e = move-exception;
            this.totalBytesWritten -= this.position - r6;     // Catch: Utf8.UnpairedSurrogateException -> L22
            this.position = r6;     // Catch: Utf8.UnpairedSurrogateException -> L22
            throw e;     // Catch: Utf8.UnpairedSurrogateException -> L22
        L16:
            e = move-exception;
            throw new OutOfSpaceException(e);     // Catch: Utf8.UnpairedSurrogateException -> L22
        L22:
            e = move-exception;
            inefficientWriteStringNoTag(value, e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position <= 0) goto L6;
            doFlush();
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            if ((this.limit - this.position) < length) goto L5;
            System.arraycopy(value, offset, this.buffer, this.position, length);
            this.position += length;
            this.totalBytesWritten += length;
            return;
        L5:
            int r0 = this.limit - this.position;
            System.arraycopy(value, offset, this.buffer, this.position, r0);
            int r5 = offset + r0;
            int r6 = length - r0;
            this.position = this.limit;
            this.totalBytesWritten += r0;
            doFlush();
            if (r6 > this.limit) goto L8;
            System.arraycopy(value, r5, this.buffer, 0, r6);
            this.position = r6;
        L9:
            this.totalBytesWritten += r6;
            return;
        L8:
            this.out.write(value, r5, r6);
            goto L9
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            int r0 = value.remaining();
            if ((this.limit - this.position) < r0) goto L5;
            value.get(this.buffer, this.position, r0);
            this.position += r0;
            this.totalBytesWritten += r0;
            return;
        L5:
            int r1 = this.limit - this.position;
            value.get(this.buffer, this.position, r1);
            int r2 = r0 - r1;
            this.position = this.limit;
            this.totalBytesWritten += r1;
            doFlush();
        L7:
            if (r2 <= this.limit) goto L9;
            value.get(this.buffer, 0, this.limit);
            this.out.write(this.buffer, 0, this.limit);
            r2 = r2 - this.limit;
            this.totalBytesWritten += this.limit;
            goto L7
        L9:
            value.get(this.buffer, 0, r2);
            this.position = r2;
            this.totalBytesWritten += r2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        private void flushIfNotAvailable(int requiredSize) throws IOException {
            if ((this.limit - this.position) >= requiredSize) goto L6;
            doFlush();
            return;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        SafeDirectNioEncoder(ByteBuffer buffer) {
            super(null);
            this.originalBuffer = buffer;
            this.buffer = buffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = buffer.position();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(final int fieldNumber, final int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(final int fieldNumber, final int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(final int fieldNumber, final int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(final int fieldNumber, final int value) throws IOException {
            writeTag(fieldNumber, 5);
            writeFixed32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(final int fieldNumber, final long value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(final int fieldNumber, final long value) throws IOException {
            writeTag(fieldNumber, 1);
            writeFixed64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(final int fieldNumber, final String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(final int fieldNumber, final byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(final int fieldNumber, final byte[] value, final int offset, final int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(final int fieldNumber, final ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(final int fieldNumber, final MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(final int fieldNumber, final MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(final int fieldNumber, final ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(final MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(final MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            this.buffer.put(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(final ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(final byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(final ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer r3 = value.duplicate();
            Java8Compatibility.clear(r3);
            write(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
        L3:
            if ((value & (-128)) == 0) goto L4;
            this.buffer.put((byte) ((value & 127) | 128));     // Catch: BufferOverflowException -> L8
            value = value >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) value);     // Catch: BufferOverflowException -> L8
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int value) throws IOException {
            this.buffer.putInt(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
        L3:
            if (((-128) & value) == 0) goto L4;
            this.buffer.put((byte) ((((int) value) & 127) | 128));     // Catch: BufferOverflowException -> L8
            value = value >>> 7;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            this.buffer.put((byte) value);     // Catch: BufferOverflowException -> L8
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long value) throws IOException {
            this.buffer.putLong(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            this.buffer.put(value, offset, length);     // Catch: BufferOverflowException -> L4 IndexOutOfBoundsException -> L7
            return;
        L7:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            this.buffer.put(value);     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            int r0 = this.buffer.position();
            int r1 = computeUInt32SizeNoTag(value.length() * 3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r2 = computeUInt32SizeNoTag(value.length());     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            if (r2 != r1) goto L6;
            int r3 = this.buffer.position() + r2;     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(value);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            int r4 = this.buffer.position();     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r0);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            writeUInt32NoTag(r4 - r3);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            Java8Compatibility.position(this.buffer, r4);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L14:
            return;
        L6:
            writeUInt32NoTag(Utf8.encodedLength(value));     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
            encode(value);     // Catch: IllegalArgumentException -> L8 Utf8.UnpairedSurrogateException -> L11
        L11:
            e = move-exception;
            Java8Compatibility.position(this.buffer, r0);
            inefficientWriteStringNoTag(value, e);
            return;
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, this.buffer.position());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        private void encode(String value) throws IOException {
            Utf8.encodeUtf8(value, this.buffer);     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(ByteBuffer buffer) {
            super(null);
            this.originalBuffer = buffer;
            this.buffer = buffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long r0 = UnsafeUtil.addressOffset(buffer);
            this.address = r0;
            long r2 = ((long) buffer.position()) + r0;
            this.initialPosition = r2;
            long r1 = r0 + ((long) buffer.limit());
            this.limit = r1;
            this.oneVarintLimit = r1 - 10;
            this.position = r2;
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeTag(int fieldNumber, int wireType) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32(int fieldNumber, int value) throws IOException {
            writeTag(fieldNumber, 5);
            writeFixed32NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 0);
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64(int fieldNumber, long value) throws IOException {
            writeTag(fieldNumber, 1);
            writeFixed64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBool(int r2, boolean r3) throws IOException {
            writeTag(r2, 0);
            write(r3 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeString(int fieldNumber, String value) throws IOException {
            writeTag(fieldNumber, 2);
            writeStringNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytes(int fieldNumber, ByteString value) throws IOException {
            writeTag(fieldNumber, 2);
            writeBytesNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value) throws IOException {
            writeByteArray(fieldNumber, value, 0, value.length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArray(int fieldNumber, byte[] value, int offset, int length) throws IOException {
            writeTag(fieldNumber, 2);
            writeByteArrayNoTag(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException {
            writeTag(fieldNumber, 2);
            writeUInt32NoTag(value.capacity());
            writeRawBytes(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessage(int fieldNumber, MessageLite value) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessage(int fieldNumber, MessageLite value, Schema schema) throws IOException {
            writeTag(fieldNumber, 2);
            writeMessageNoTag(value, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int fieldNumber, MessageLite value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeMessage(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int fieldNumber, ByteString value) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, fieldNumber);
            writeBytes(3, value);
            writeTag(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite value) throws IOException {
            writeUInt32NoTag(value.getSerializedSize());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void writeMessageNoTag(MessageLite value, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) value).getSerializedSize(schema));
            schema.writeTo(value, this.wrapper);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) throws IOException {
            long r0 = this.position;
            if (r0 >= this.limit) goto L7;
            this.position = 1 + r0;
            UnsafeUtil.putByte(r0, value);
            return;
        L7:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString value) throws IOException {
            writeUInt32NoTag(value.size());
            value.writeTo(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] value, int offset, int length) throws IOException {
            writeUInt32NoTag(length);
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer value) throws IOException {
            if (value.hasArray() == false) goto L5;
            write(value.array(), value.arrayOffset(), value.capacity());
            return;
        L5:
            ByteBuffer r3 = value.duplicate();
            Java8Compatibility.clear(r3);
            write(r3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int value) throws IOException {
            if (value < 0) goto L4;
            writeUInt32NoTag(value);
            return;
        L4:
            writeUInt64NoTag(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int value) throws IOException {
            if (this.position <= this.oneVarintLimit) goto L5;
        L9:
            long r3 = this.position;
            if (r3 >= this.limit) goto L17;
            if ((value & (-128)) == 0) goto L13;
            this.position = r3 + 1;
            UnsafeUtil.putByte(r3, (byte) ((value & 127) | 128));
            value = value >>> 7;
            goto L9
        L13:
            this.position = 1 + r3;
            UnsafeUtil.putByte(r3, (byte) value);
            return;
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        L5:
            if ((value & (-128)) == 0) goto L6;
            long r4 = this.position;
            this.position = r4 + 1;
            UnsafeUtil.putByte(r4, (byte) ((value & 127) | 128));
            value = value >>> 7;
            goto L5
        L6:
            long r5 = this.position;
            this.position = 1 + r5;
            UnsafeUtil.putByte(r5, (byte) value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int value) throws IOException {
            this.buffer.putInt(bufferPos(this.position), value);
            this.position += 4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long value) throws IOException {
            if (this.position <= this.oneVarintLimit) goto L5;
        L9:
            long r8 = this.position;
            if (r8 >= this.limit) goto L17;
            if ((value & (-128)) == 0) goto L13;
            this.position = r8 + 1;
            UnsafeUtil.putByte(r8, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L9
        L13:
            this.position = 1 + r8;
            UnsafeUtil.putByte(r8, (byte) value);
            return;
        L17:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        L5:
            if ((value & (-128)) == 0) goto L6;
            long r9 = this.position;
            this.position = r9 + 1;
            UnsafeUtil.putByte(r9, (byte) ((((int) value) & 127) | 128));
            value = value >>> 7;
            goto L5
        L6:
            long r0 = this.position;
            this.position = 1 + r0;
            UnsafeUtil.putByte(r0, (byte) value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long value) throws IOException {
            this.buffer.putLong(bufferPos(this.position), value);
            this.position += 8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) throws IOException {
            if (value == null) goto L12;
            if (offset < 0) goto L12;
            if (length < 0) goto L12;
            if ((value.length - length) < offset) goto L12;
            long r9 = length;
            long r0 = this.limit - r9;
            long r5 = this.position;
            if (r0 < r5) goto L12;
            UnsafeUtil.copyMemory(value, offset, r5, r9);
            this.position += r9;
            return;
        L12:
            if (value != null) goto L16;
            throw new NullPointerException("value");
        L16:
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(length)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) throws IOException {
            write(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) throws IOException {
            int r0 = value.remaining();     // Catch: BufferOverflowException -> L4
            repositionBuffer(this.position);     // Catch: BufferOverflowException -> L4
            this.buffer.put(value);     // Catch: BufferOverflowException -> L4
            this.position += (long) r0;     // Catch: BufferOverflowException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) throws IOException {
            write(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String value) throws IOException {
            long r0 = this.position;
            int r2 = computeUInt32SizeNoTag(value.length() * 3);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r3 = computeUInt32SizeNoTag(value.length());     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            if (r3 != r2) goto L6;
            int r4 = bufferPos(this.position) + r3;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Java8Compatibility.position(this.buffer, r4);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(value, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            int r5 = this.buffer.position() - r4;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r5);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r5;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L17:
            return;
        L6:
            int r6 = Utf8.encodedLength(value);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            writeUInt32NoTag(r6);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            repositionBuffer(this.position);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            Utf8.encodeUtf8(value, this.buffer);     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
            this.position += (long) r6;     // Catch: IndexOutOfBoundsException -> L8 IllegalArgumentException -> L11 Utf8.UnpairedSurrogateException -> L14
        L14:
            e = move-exception;
            this.position = r0;
            repositionBuffer(r0);
            inefficientWriteStringNoTag(value, e);
            return;
        L11:
            e = move-exception;
            throw new OutOfSpaceException(e);
        L8:
            e = move-exception;
            throw new OutOfSpaceException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void flush() {
            Java8Compatibility.position(this.originalBuffer, bufferPos(this.position));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        private void repositionBuffer(long pos) {
            Java8Compatibility.position(this.buffer, bufferPos(pos));
        }

        private int bufferPos(long pos) {
            return (int) (pos - this.address);
        }
    }

    public static int computeBoolSizeNoTag(final boolean unused) {
        return 1;
    }

    public static int computeDoubleSizeNoTag(final double unused) {
        return 8;
    }

    public static int computeFixed32SizeNoTag(final int unused) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(final long unused) {
        return 8;
    }

    public static int computeFloatSizeNoTag(final float unused) {
        return 4;
    }

    static int computePreferredBufferSize(int dataLength) {
        if (dataLength <= 4096) goto L5;
        return 4096;
    L5:
        return dataLength;
    }

    public static int computeSFixed32SizeNoTag(final int unused) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(final long unused) {
        return 8;
    }

    public static int computeUInt32SizeNoTag(final int value) {
        if ((value & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((value & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & value) != 0) goto L15;
        return 3;
    L15:
        if ((value & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int computeUInt64SizeNoTag(long value) {
        if (((-128) & value) != 0) goto L7;
        return 1;
    L7:
        if (value >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & value) == 0) goto L13;
        value = value >>> 28;
        int r0 = 6;
    L15:
        if (((-2097152) & value) == 0) goto L18;
        r0 = r0 + 2;
        value = value >>> 14;
    L18:
        if ((value & (-16384)) != 0) goto L20;
        return r0;
    L20:
        return r0 + 1;
    L13:
        r0 = 2;
        goto L15
    }

    public static int encodeZigZag32(final int n) {
        int r0 = n << 1;
        return (n >> 31) ^ r0;
    }

    public static long encodeZigZag64(final long n) {
        long r0 = n << 1;
        return (n >> 63) ^ r0;
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public abstract int spaceLeft();

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(byte value) throws IOException;

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(ByteBuffer value) throws IOException;

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void write(byte[] value, int offset, int length) throws IOException;

    public abstract void writeBool(int fieldNumber, boolean value) throws IOException;

    public abstract void writeByteArray(int fieldNumber, byte[] value) throws IOException;

    public abstract void writeByteArray(int fieldNumber, byte[] value, int offset, int length) throws IOException;

    abstract void writeByteArrayNoTag(final byte[] value, final int offset, final int length) throws IOException;

    public abstract void writeByteBuffer(int fieldNumber, ByteBuffer value) throws IOException;

    public abstract void writeBytes(int fieldNumber, ByteString value) throws IOException;

    public abstract void writeBytesNoTag(final ByteString value) throws IOException;

    public abstract void writeFixed32(int fieldNumber, int value) throws IOException;

    public abstract void writeFixed32NoTag(int value) throws IOException;

    public abstract void writeFixed64(int fieldNumber, long value) throws IOException;

    public abstract void writeFixed64NoTag(long value) throws IOException;

    public abstract void writeInt32(int fieldNumber, int value) throws IOException;

    public abstract void writeInt32NoTag(final int value) throws IOException;

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer value) throws IOException;

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void writeLazy(byte[] value, int offset, int length) throws IOException;

    public abstract void writeMessage(final int fieldNumber, final MessageLite value) throws IOException;

    abstract void writeMessage(final int fieldNumber, final MessageLite value, Schema schema) throws IOException;

    public abstract void writeMessageNoTag(final MessageLite value) throws IOException;

    abstract void writeMessageNoTag(final MessageLite value, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(final int fieldNumber, final MessageLite value) throws IOException;

    public abstract void writeRawBytes(final ByteBuffer value) throws IOException;

    public abstract void writeRawMessageSetExtension(final int fieldNumber, final ByteString value) throws IOException;

    public abstract void writeString(int fieldNumber, String value) throws IOException;

    public abstract void writeStringNoTag(String value) throws IOException;

    public abstract void writeTag(int fieldNumber, int wireType) throws IOException;

    public abstract void writeUInt32(int fieldNumber, int value) throws IOException;

    public abstract void writeUInt32NoTag(int value) throws IOException;

    public abstract void writeUInt64(int fieldNumber, long value) throws IOException;

    public abstract void writeUInt64NoTag(long value) throws IOException;

    /* synthetic */ CodedOutputStream(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$100() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static {
        logger = Logger.getLogger(CodedOutputStream.class.getName());
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    }

    public static CodedOutputStream newInstance(final OutputStream output) {
        return newInstance(output, 4096);
    }

    public static CodedOutputStream newInstance(final OutputStream output, final int bufferSize) {
        return new OutputStreamEncoder(output, bufferSize);
    }

    public static CodedOutputStream newInstance(final byte[] flatArray) {
        return newInstance(flatArray, 0, flatArray.length);
    }

    public static CodedOutputStream newInstance(final byte[] flatArray, final int offset, final int length) {
        return new ArrayEncoder(flatArray, offset, length);
    }

    public static CodedOutputStream newInstance(ByteBuffer buffer) {
        if (buffer.hasArray() == false) goto L7;
        return new HeapNioEncoder(buffer);
    L7:
        if (buffer.isDirect() == false) goto L16;
        if (buffer.isReadOnly() == true) goto L16;
        if (UnsafeDirectNioEncoder.isSupported() == false) goto L14;
        return newUnsafeInstance(buffer);
    L14:
        return newSafeInstance(buffer);
    L16:
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    static CodedOutputStream newUnsafeInstance(ByteBuffer buffer) {
        return new UnsafeDirectNioEncoder(buffer);
    }

    static CodedOutputStream newSafeInstance(ByteBuffer buffer) {
        return new SafeDirectNioEncoder(buffer);
    }

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int unused) {
        return newInstance(byteBuffer);
    }

    static CodedOutputStream newInstance(ByteOutput byteOutput, int bufferSize) {
        if (bufferSize < 0) goto L6;
        return new ByteOutputEncoder(byteOutput, bufferSize);
    L6:
        throw new IllegalArgumentException("bufferSize must be positive");
    }

    private CodedOutputStream() {
    }

    public final void writeSInt32(final int fieldNumber, final int value) throws IOException {
        writeUInt32(fieldNumber, encodeZigZag32(value));
    }

    public final void writeSFixed32(final int fieldNumber, final int value) throws IOException {
        writeFixed32(fieldNumber, value);
    }

    public final void writeInt64(final int fieldNumber, final long value) throws IOException {
        writeUInt64(fieldNumber, value);
    }

    public final void writeSInt64(final int fieldNumber, final long value) throws IOException {
        writeUInt64(fieldNumber, encodeZigZag64(value));
    }

    public final void writeSFixed64(final int fieldNumber, final long value) throws IOException {
        writeFixed64(fieldNumber, value);
    }

    public final void writeFloat(final int fieldNumber, final float value) throws IOException {
        writeFixed32(fieldNumber, Float.floatToRawIntBits(value));
    }

    public final void writeDouble(final int fieldNumber, final double value) throws IOException {
        writeFixed64(fieldNumber, Double.doubleToRawLongBits(value));
    }

    public final void writeEnum(final int fieldNumber, final int value) throws IOException {
        writeInt32(fieldNumber, value);
    }

    public final void writeRawByte(final byte value) throws IOException {
        write(value);
    }

    public final void writeRawByte(final int value) throws IOException {
        write((byte) value);
    }

    public final void writeRawBytes(final byte[] value) throws IOException {
        write(value, 0, value.length);
    }

    public final void writeRawBytes(final byte[] value, int offset, int length) throws IOException {
        write(value, offset, length);
    }

    public final void writeRawBytes(final ByteString value) throws IOException {
        value.writeTo(this);
    }

    public final void writeSInt32NoTag(final int value) throws IOException {
        writeUInt32NoTag(encodeZigZag32(value));
    }

    public final void writeSFixed32NoTag(final int value) throws IOException {
        writeFixed32NoTag(value);
    }

    public final void writeInt64NoTag(final long value) throws IOException {
        writeUInt64NoTag(value);
    }

    public final void writeSInt64NoTag(final long value) throws IOException {
        writeUInt64NoTag(encodeZigZag64(value));
    }

    public final void writeSFixed64NoTag(final long value) throws IOException {
        writeFixed64NoTag(value);
    }

    public final void writeFloatNoTag(final float value) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(value));
    }

    public final void writeDoubleNoTag(final double value) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(value));
    }

    public final void writeBoolNoTag(boolean r1) throws IOException {
        write(r1 ? 1 : 0);
    }

    public final void writeEnumNoTag(final int value) throws IOException {
        writeInt32NoTag(value);
    }

    public final void writeByteArrayNoTag(final byte[] value) throws IOException {
        writeByteArrayNoTag(value, 0, value.length);
    }

    public static int computeInt32Size(final int fieldNumber, final int value) {
        return computeTagSize(fieldNumber) + computeInt32SizeNoTag(value);
    }

    public static int computeUInt32Size(final int fieldNumber, final int value) {
        return computeTagSize(fieldNumber) + computeUInt32SizeNoTag(value);
    }

    public static int computeSInt32Size(final int fieldNumber, final int value) {
        return computeTagSize(fieldNumber) + computeSInt32SizeNoTag(value);
    }

    public static int computeFixed32Size(final int fieldNumber, final int value) {
        return computeTagSize(fieldNumber) + computeFixed32SizeNoTag(value);
    }

    public static int computeSFixed32Size(final int fieldNumber, final int value) {
        return computeTagSize(fieldNumber) + computeSFixed32SizeNoTag(value);
    }

    public static int computeInt64Size(final int fieldNumber, final long value) {
        return computeTagSize(fieldNumber) + computeInt64SizeNoTag(value);
    }

    public static int computeUInt64Size(final int fieldNumber, final long value) {
        return computeTagSize(fieldNumber) + computeUInt64SizeNoTag(value);
    }

    public static int computeSInt64Size(final int fieldNumber, final long value) {
        return computeTagSize(fieldNumber) + computeSInt64SizeNoTag(value);
    }

    public static int computeFixed64Size(final int fieldNumber, final long value) {
        return computeTagSize(fieldNumber) + computeFixed64SizeNoTag(value);
    }

    public static int computeSFixed64Size(final int fieldNumber, final long value) {
        return computeTagSize(fieldNumber) + computeSFixed64SizeNoTag(value);
    }

    public static int computeFloatSize(final int fieldNumber, final float value) {
        return computeTagSize(fieldNumber) + computeFloatSizeNoTag(value);
    }

    public static int computeDoubleSize(final int fieldNumber, final double value) {
        return computeTagSize(fieldNumber) + computeDoubleSizeNoTag(value);
    }

    public static int computeBoolSize(final int fieldNumber, final boolean value) {
        return computeTagSize(fieldNumber) + computeBoolSizeNoTag(value);
    }

    public static int computeEnumSize(final int fieldNumber, final int value) {
        return computeTagSize(fieldNumber) + computeEnumSizeNoTag(value);
    }

    public static int computeStringSize(final int fieldNumber, final String value) {
        return computeTagSize(fieldNumber) + computeStringSizeNoTag(value);
    }

    public static int computeBytesSize(final int fieldNumber, final ByteString value) {
        return computeTagSize(fieldNumber) + computeBytesSizeNoTag(value);
    }

    public static int computeByteArraySize(final int fieldNumber, final byte[] value) {
        return computeTagSize(fieldNumber) + computeByteArraySizeNoTag(value);
    }

    public static int computeByteBufferSize(final int fieldNumber, final ByteBuffer value) {
        return computeTagSize(fieldNumber) + computeByteBufferSizeNoTag(value);
    }

    public static int computeLazyFieldSize(final int fieldNumber, final LazyFieldLite value) {
        return computeTagSize(fieldNumber) + computeLazyFieldSizeNoTag(value);
    }

    public static int computeMessageSize(final int fieldNumber, final MessageLite value) {
        return computeTagSize(fieldNumber) + computeMessageSizeNoTag(value);
    }

    static int computeMessageSize(final int fieldNumber, final MessageLite value, final Schema schema) {
        return computeTagSize(fieldNumber) + computeMessageSizeNoTag(value, schema);
    }

    public static int computeMessageSetExtensionSize(final int fieldNumber, final MessageLite value) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, fieldNumber)) + computeMessageSize(3, value);
    }

    public static int computeRawMessageSetExtensionSize(final int fieldNumber, final ByteString value) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, fieldNumber)) + computeBytesSize(3, value);
    }

    public static int computeLazyFieldMessageSetExtensionSize(final int fieldNumber, final LazyFieldLite value) {
        return ((computeTagSize(1) * 2) + computeUInt32Size(2, fieldNumber)) + computeLazyFieldSize(3, value);
    }

    public static int computeTagSize(final int fieldNumber) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(fieldNumber, 0));
    }

    public static int computeInt32SizeNoTag(final int value) {
        if (value >= 0) goto L4;
        return 10;
    L4:
        return computeUInt32SizeNoTag(value);
    }

    public static int computeSInt32SizeNoTag(final int value) {
        return computeUInt32SizeNoTag(encodeZigZag32(value));
    }

    public static int computeInt64SizeNoTag(final long value) {
        return computeUInt64SizeNoTag(value);
    }

    public static int computeSInt64SizeNoTag(final long value) {
        return computeUInt64SizeNoTag(encodeZigZag64(value));
    }

    public static int computeEnumSizeNoTag(final int value) {
        return computeInt32SizeNoTag(value);
    }

    public static int computeStringSizeNoTag(final String value) {
        int r1 = Utf8.encodedLength(value);     // Catch: Utf8.UnpairedSurrogateException -> L4
    L6:
        return computeLengthDelimitedFieldSize(r1);
    L4:
        r1 = value.getBytes(Internal.UTF_8).length;
        goto L6
    }

    public static int computeLazyFieldSizeNoTag(final LazyFieldLite value) {
        return computeLengthDelimitedFieldSize(value.getSerializedSize());
    }

    public static int computeBytesSizeNoTag(final ByteString value) {
        return computeLengthDelimitedFieldSize(value.size());
    }

    public static int computeByteArraySizeNoTag(final byte[] value) {
        return computeLengthDelimitedFieldSize(value.length);
    }

    public static int computeByteBufferSizeNoTag(final ByteBuffer value) {
        return computeLengthDelimitedFieldSize(value.capacity());
    }

    public static int computeMessageSizeNoTag(final MessageLite value) {
        return computeLengthDelimitedFieldSize(value.getSerializedSize());
    }

    static int computeMessageSizeNoTag(final MessageLite value, final Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) value).getSerializedSize(schema));
    }

    static int computeLengthDelimitedFieldSize(int fieldLength) {
        return computeUInt32SizeNoTag(fieldLength) + fieldLength;
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    final void inefficientWriteStringNoTag(String value, Utf8.UnpairedSurrogateException cause) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", cause);
        byte[] r4 = value.getBytes(Internal.UTF_8);
        writeUInt32NoTag(r4.length);     // Catch: IndexOutOfBoundsException -> L5
        writeLazy(r4, 0, r4.length);     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        e = move-exception;
        throw new OutOfSpaceException(e);
    }

    @Deprecated
    public final void writeGroup(final int fieldNumber, final MessageLite value) throws IOException {
        writeTag(fieldNumber, 3);
        writeGroupNoTag(value);
        writeTag(fieldNumber, 4);
    }

    @Deprecated
    final void writeGroup(final int fieldNumber, final MessageLite value, Schema schema) throws IOException {
        writeTag(fieldNumber, 3);
        writeGroupNoTag(value, schema);
        writeTag(fieldNumber, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(final MessageLite value) throws IOException {
        value.writeTo(this);
    }

    @Deprecated
    final void writeGroupNoTag(final MessageLite value, Schema schema) throws IOException {
        schema.writeTo(value, this.wrapper);
    }

    @Deprecated
    public static int computeGroupSize(final int fieldNumber, final MessageLite value) {
        return (computeTagSize(fieldNumber) * 2) + value.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSize(final int fieldNumber, final MessageLite value, Schema schema) {
        return (computeTagSize(fieldNumber) * 2) + computeGroupSizeNoTag(value, schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(final MessageLite value) {
        return value.getSerializedSize();
    }

    @Deprecated
    static int computeGroupSizeNoTag(final MessageLite value, Schema schema) {
        return ((AbstractMessageLite) value).getSerializedSize(schema);
    }

    @Deprecated
    public final void writeRawVarint32(int value) throws IOException {
        writeUInt32NoTag(value);
    }

    @Deprecated
    public final void writeRawVarint64(long value) throws IOException {
        writeUInt64NoTag(value);
    }

    @Deprecated
    public static int computeRawVarint32Size(final int value) {
        return computeUInt32SizeNoTag(value);
    }

    @Deprecated
    public static int computeRawVarint64Size(long value) {
        return computeUInt64SizeNoTag(value);
    }

    @Deprecated
    public final void writeRawLittleEndian32(final int value) throws IOException {
        writeFixed32NoTag(value);
    }

    @Deprecated
    public final void writeRawLittleEndian64(final long value) throws IOException {
        writeFixed64NoTag(value);
    }
}
