package com.google.crypto.tink.shaded.protobuf;

import android.bluetooth.client.pbap.BluetoothPbapClient;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.BinaryWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r0 = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0;
            r0[WireFormat.FieldType.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L56:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L38:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 17;     // Catch: NoSuchFieldError -> L37
            return;
        }
    }

    private static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        SafeDirectWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newDirectBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer() == false) goto L11;
            ByteBuffer r0 = allocatedBuffer.nioBuffer();
            if (r0.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = r0;
            Java8Compatibility.limit(r0, r0.capacity());
            Java8Compatibility.position(this.buffer, 0);
            this.buffer.order(ByteOrder.LITTLE_ENDIAN);
            int r3 = this.buffer.limit() - 1;
            this.limitMinusOne = r3;
            this.pos = r3;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            Java8Compatibility.position(this.buffer, this.pos + 1);
            this.buffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int fieldNumber, String value) {
            int r0 = getTotalBytesWritten();
            writeString(value);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int r0 = getTotalBytesWritten();
            schema.writeTo(value, this);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & (-128)) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) value);
        }

        private void writeVarint32TwoBytes(int value) {
            int r0 = this.pos - 2;
            this.pos = r0;
            this.buffer.putShort(r0 + 1, (short) (((value & 127) | 128) | ((value & 16256) << 1)));
        }

        private void writeVarint32ThreeBytes(int value) {
            int r0 = this.pos - 3;
            this.pos = r0;
            this.buffer.putInt(r0, (((value & 127) | 128) << 8) | (((2080768 & value) << 10) | (((value & 16256) | 16384) << 9)));
        }

        private void writeVarint32FourBytes(int value) {
            int r0 = this.pos - 4;
            this.pos = r0;
            this.buffer.putInt(r0 + 1, ((value & 127) | 128) | ((((266338304 & value) << 3) | (((2080768 & value) | 2097152) << 2)) | (((value & 16256) | 16384) << 1)));
        }

        private void writeVarint32FiveBytes(int value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (value >>> 28));
            int r2 = this.pos - 4;
            this.pos = r2;
            this.buffer.putInt(r2 + 1, ((value & 127) | 128) | ((((((value >>> 21) & 127) | 128) << 24) | ((((value >>> 14) & 127) | 128) << 16)) | ((((value >>> 7) & 127) | 128) << 8)));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            writeVarint32OneByte((int) value);
        }

        private void writeVarint64TwoBytes(long value) {
            writeVarint32TwoBytes((int) value);
        }

        private void writeVarint64ThreeBytes(long value) {
            writeVarint32ThreeBytes((int) value);
        }

        private void writeVarint64FourBytes(long value) {
            writeVarint32FourBytes((int) value);
        }

        private void writeVarint64FiveBytes(long value) {
            int r0 = this.pos - 5;
            this.pos = r0;
            this.buffer.putLong(r0 - 2, (((value & 127) | 128) << 24) | (((((34091302912L & value) << 28) | (((266338304 & value) | BluetoothPbapClient.VCARD_ATTR_X_IRMC_CALL_DATETIME) << 27)) | (((2080768 & value) | 2097152) << 26)) | (((16256 & value) | 16384) << 25)));
        }

        private void writeVarint64SixBytes(long value) {
            int r0 = this.pos - 6;
            this.pos = r0;
            this.buffer.putLong(r0 - 1, (((value & 127) | 128) << 16) | ((((((4363686772736L & value) << 21) | (((34091302912L & value) | 34359738368L) << 20)) | (((266338304 & value) | BluetoothPbapClient.VCARD_ATTR_X_IRMC_CALL_DATETIME) << 19)) | (((2080768 & value) | 2097152) << 18)) | (((16256 & value) | 16384) << 17)));
        }

        private void writeVarint64SevenBytes(long value) {
            int r0 = this.pos - 7;
            this.pos = r0;
            this.buffer.putLong(r0, (((value & 127) | 128) << 8) | (((((((558551906910208L & value) << 14) | (((4363686772736L & value) | 4398046511104L) << 13)) | (((34091302912L & value) | 34359738368L) << 12)) | (((266338304 & value) | BluetoothPbapClient.VCARD_ATTR_X_IRMC_CALL_DATETIME) << 11)) | (((2080768 & value) | 2097152) << 10)) | (((16256 & value) | 16384) << 9)));
        }

        private void writeVarint64EightBytes(long value) {
            int r0 = this.pos - 8;
            this.pos = r0;
            this.buffer.putLong(r0 + 1, ((value & 127) | 128) | ((((((((71494644084506624L & value) << 7) | (((558551906910208L & value) | 562949953421312L) << 6)) | (((4363686772736L & value) | 4398046511104L) << 5)) | (((34091302912L & value) | 34359738368L) << 4)) | (((266338304 & value) | BluetoothPbapClient.VCARD_ATTR_X_IRMC_CALL_DATETIME) << 3)) | (((2080768 & value) | 2097152) << 2)) | (((16256 & value) | 16384) << 1)));
        }

        private void writeVarint64EightBytesWithSign(long value) {
            int r0 = this.pos - 8;
            this.pos = r0;
            this.buffer.putLong(r0 + 1, ((value & 127) | 128) | (((((((((71494644084506624L & value) | 72057594037927936L) << 7) | (((558551906910208L & value) | 562949953421312L) << 6)) | (((4363686772736L & value) | 4398046511104L) << 5)) | (((34091302912L & value) | 34359738368L) << 4)) | (((266338304 & value) | BluetoothPbapClient.VCARD_ATTR_X_IRMC_CALL_DATETIME) << 3)) | (((2080768 & value) | 2097152) << 2)) | (((16256 & value) | 16384) << 1)));
        }

        private void writeVarint64NineBytes(long value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (value >>> 56));
            writeVarint64EightBytesWithSign(value & 72057594037927935L);
        }

        private void writeVarint64TenBytes(long value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, (byte) (value >>> 63));
            ByteBuffer r2 = this.buffer;
            int r3 = this.pos;
            this.pos = r3 - 1;
            r2.put(r3, (byte) (((value >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(value & 72057594037927935L);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int value) {
            int r0 = this.pos - 4;
            this.pos = r0;
            this.buffer.putInt(r0 + 1, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long value) {
            int r0 = this.pos - 8;
            this.pos = r0;
            this.buffer.putLong(r0 + 1, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int r0 = in.length() - 1;
            this.pos -= r0;
        L4:
            if (r0 < 0) goto L9;
            char r3 = in.charAt(r0);
            if (r3 >= 128) goto L9;
            this.buffer.put(this.pos + r0, (byte) r3);
            r0 = r0 - 1;
        L9:
            if (r0 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r0;
        L13:
            if (r0 < 0) goto L41;
            char r4 = in.charAt(r0);
            if (r4 >= 128) goto L20;
            int r5 = this.pos;
            if (r5 < 0) goto L20;
            ByteBuffer r6 = this.buffer;
            this.pos = r5 - 1;
            r6.put(r5, (byte) r4);
        L40:
            r0 = r0 - 1;
        L20:
            if (r4 >= 2048) goto L25;
            int r7 = this.pos;
            if (r7 <= 0) goto L25;
            ByteBuffer r8 = this.buffer;
            this.pos = r7 - 1;
            r8.put(r7, (byte) ((r4 & '?') | 128));
            ByteBuffer r9 = this.buffer;
            int r10 = this.pos;
            this.pos = r10 - 1;
            r9.put(r10, (byte) ((r4 >>> 6) | 960));
        L25:
            if (r4 >= 55296) goto L27;
        L28:
            int r11 = this.pos;
            if (r11 <= 1) goto L32;
            ByteBuffer r12 = this.buffer;
            this.pos = r11 - 1;
            r12.put(r11, (byte) ((r4 & '?') | 128));
            ByteBuffer r13 = this.buffer;
            int r14 = this.pos;
            this.pos = r14 - 1;
            r13.put(r14, (byte) (((r4 >>> 6) & 63) | 128));
            ByteBuffer r15 = this.buffer;
            int r16 = this.pos;
            this.pos = r16 - 1;
            r15.put(r16, (byte) ((r4 >>> '\f') | 480));
        L32:
            if (this.pos <= 2) goto L39;
            if (r0 == 0) goto L38;
            char r17 = in.charAt(r0 - 1);
            if (Character.isSurrogatePair(r17, r4) == false) goto L38;
            r0 = r0 - 1;
            int r18 = Character.toCodePoint(r17, r4);
            ByteBuffer r19 = this.buffer;
            int r20 = this.pos;
            this.pos = r20 - 1;
            r19.put(r20, (byte) ((r18 & 63) | 128));
            ByteBuffer r21 = this.buffer;
            int r22 = this.pos;
            this.pos = r22 - 1;
            r21.put(r22, (byte) (((r18 >>> 6) & 63) | 128));
            ByteBuffer r23 = this.buffer;
            int r24 = this.pos;
            this.pos = r24 - 1;
            r23.put(r24, (byte) (((r18 >>> 12) & 63) | 128));
            ByteBuffer r25 = this.buffer;
            int r26 = this.pos;
            this.pos = r26 - 1;
            r25.put(r26, (byte) ((r18 >>> 18) | 240));
        L38:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L39:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L40
        L27:
            if (57343 >= r4) goto L32;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) {
            ByteBuffer r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0.put(r1, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            int r0 = this.pos - length;
            this.pos = r0;
            Java8Compatibility.position(this.buffer, r0 + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L6:
            int r0 = this.pos - length;
            this.pos = r0;
            Java8Compatibility.position(this.buffer, r0 + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int r0 = value.remaining();
            if (spaceLeft() >= r0) goto L5;
            nextBuffer(r0);
        L5:
            int r1 = this.pos - r0;
            this.pos = r1;
            Java8Compatibility.position(this.buffer, r1 + 1);
            this.buffer.put(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int r0 = value.remaining();
            if (spaceLeft() >= r0) goto L6;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
            return;
        L6:
            int r1 = this.pos - r0;
            this.pos = r1;
            Java8Compatibility.position(this.buffer, r1 + 1);
            this.buffer.put(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    private static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        SafeHeapWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            AllocatedBuffer r0 = this.allocatedBuffer;
            r0.position((this.pos - r0.arrayOffset()) + 1);
            this.allocatedBuffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newHeapBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            int r0 = allocatedBuffer.arrayOffset();
            this.limit = allocatedBuffer.limit() + r0;
            int r1 = r0 + allocatedBuffer.position();
            this.offset = r1;
            this.offsetMinusOne = r1 - 1;
            int r3 = this.limit - 1;
            this.limitMinusOne = r3;
            this.pos = r3;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) throws IOException {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) throws IOException {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) throws IOException {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) throws IOException {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) throws IOException {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) throws IOException {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) throws IOException {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int r2, boolean r3) throws IOException {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int fieldNumber, String value) throws IOException {
            int r0 = getTotalBytesWritten();
            writeString(value);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) throws IOException {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int r0 = getTotalBytesWritten();
            schema.writeTo(value, this);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & (-128)) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) value;
        }

        private void writeVarint32TwoBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 7);
            this.pos = r2 - 1;
            r0[r2] = (byte) ((value & 127) | 128);
        }

        private void writeVarint32ThreeBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 14);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r3 - 1;
            r0[r3] = (byte) ((value & 127) | 128);
        }

        private void writeVarint32FourBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 21);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 14) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r4 - 1;
            r0[r4] = (byte) ((value & 127) | 128);
        }

        private void writeVarint32FiveBytes(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 28);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 21) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 14) & 127) | 128);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r5 - 1;
            r0[r5] = (byte) ((value & 127) | 128);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = (byte) value;
        }

        private void writeVarint64TwoBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 7);
            this.pos = r2 - 1;
            r0[r2] = (byte) ((((int) value) & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (((int) value) >>> 14);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r3 - 1;
            r0[r3] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64FourBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 21);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 14) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r4 - 1;
            r0[r4] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64FiveBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 28);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 21) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 14) & 127) | 128);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r5 - 1;
            r0[r5] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64SixBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 35);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 28) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 21) & 127) | 128);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((value >>> 14) & 127) | 128);
            int r6 = r5 - 1;
            r0[r5] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r6 - 1;
            r0[r6] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64SevenBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 42);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 35) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 28) & 127) | 128);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((value >>> 21) & 127) | 128);
            int r6 = r5 - 1;
            r0[r5] = (byte) (((value >>> 14) & 127) | 128);
            int r7 = r6 - 1;
            r0[r6] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r7 - 1;
            r0[r7] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64EightBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 49);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 42) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 35) & 127) | 128);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((value >>> 28) & 127) | 128);
            int r6 = r5 - 1;
            r0[r5] = (byte) (((value >>> 21) & 127) | 128);
            int r7 = r6 - 1;
            r0[r6] = (byte) (((value >>> 14) & 127) | 128);
            int r8 = r7 - 1;
            r0[r7] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r8 - 1;
            r0[r8] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64NineBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 56);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 49) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 42) & 127) | 128);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((value >>> 35) & 127) | 128);
            int r6 = r5 - 1;
            r0[r5] = (byte) (((value >>> 28) & 127) | 128);
            int r7 = r6 - 1;
            r0[r6] = (byte) (((value >>> 21) & 127) | 128);
            int r8 = r7 - 1;
            r0[r7] = (byte) (((value >>> 14) & 127) | 128);
            int r9 = r8 - 1;
            r0[r8] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r9 - 1;
            r0[r9] = (byte) ((value & 127) | 128);
        }

        private void writeVarint64TenBytes(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (value >>> 63);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((value >>> 56) & 127) | 128);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((value >>> 49) & 127) | 128);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((value >>> 42) & 127) | 128);
            int r6 = r5 - 1;
            r0[r5] = (byte) (((value >>> 35) & 127) | 128);
            int r7 = r6 - 1;
            r0[r6] = (byte) (((value >>> 28) & 127) | 128);
            int r8 = r7 - 1;
            r0[r7] = (byte) (((value >>> 21) & 127) | 128);
            int r9 = r8 - 1;
            r0[r8] = (byte) (((value >>> 14) & 127) | 128);
            int r10 = r9 - 1;
            r0[r9] = (byte) (((value >>> 7) & 127) | 128);
            this.pos = r10 - 1;
            r0[r10] = (byte) ((value & 127) | 128);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) ((value >> 24) & 255);
            int r3 = r2 - 1;
            r0[r2] = (byte) ((value >> 16) & 255);
            int r4 = r3 - 1;
            r0[r3] = (byte) ((value >> 8) & 255);
            this.pos = r4 - 1;
            r0[r4] = (byte) (value & 255);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            int r2 = r1 - 1;
            r0[r1] = (byte) (((int) (value >> 56)) & 255);
            int r3 = r2 - 1;
            r0[r2] = (byte) (((int) (value >> 48)) & 255);
            int r4 = r3 - 1;
            r0[r3] = (byte) (((int) (value >> 40)) & 255);
            int r5 = r4 - 1;
            r0[r4] = (byte) (((int) (value >> 32)) & 255);
            int r6 = r5 - 1;
            r0[r5] = (byte) (((int) (value >> 24)) & 255);
            int r7 = r6 - 1;
            r0[r6] = (byte) (((int) (value >> 16)) & 255);
            int r8 = r7 - 1;
            r0[r7] = (byte) (((int) (value >> 8)) & 255);
            this.pos = r8 - 1;
            r0[r8] = (byte) (((int) value) & 255);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int r0 = in.length() - 1;
            this.pos -= r0;
        L4:
            if (r0 < 0) goto L9;
            char r2 = in.charAt(r0);
            if (r2 >= 128) goto L9;
            this.buffer[this.pos + r0] = (byte) r2;
            r0 = r0 - 1;
        L9:
            if (r0 != (-1)) goto L12;
            this.pos--;
            return;
        L12:
            this.pos += r0;
        L13:
            if (r0 < 0) goto L41;
            char r3 = in.charAt(r0);
            if (r3 >= 128) goto L20;
            int r4 = this.pos;
            if (r4 <= this.offsetMinusOne) goto L20;
            byte[] r5 = this.buffer;
            this.pos = r4 - 1;
            r5[r4] = (byte) r3;
        L40:
            r0 = r0 - 1;
        L20:
            if (r3 >= 2048) goto L25;
            int r6 = this.pos;
            if (r6 <= this.offset) goto L25;
            byte[] r7 = this.buffer;
            int r8 = r6 - 1;
            r7[r6] = (byte) ((r3 & '?') | 128);
            this.pos = r8 - 1;
            r7[r8] = (byte) ((r3 >>> 6) | 960);
        L25:
            if (r3 >= 55296) goto L27;
        L28:
            int r9 = this.pos;
            if (r9 <= (this.offset + 1)) goto L32;
            byte[] r10 = this.buffer;
            int r11 = r9 - 1;
            r10[r9] = (byte) ((r3 & '?') | 128);
            int r12 = r11 - 1;
            r10[r11] = (byte) (((r3 >>> 6) & 63) | 128);
            this.pos = r12 - 1;
            r10[r12] = (byte) ((r3 >>> '\f') | 480);
        L32:
            if (this.pos <= (this.offset + 2)) goto L39;
            if (r0 == 0) goto L38;
            char r13 = in.charAt(r0 - 1);
            if (Character.isSurrogatePair(r13, r3) == false) goto L38;
            r0 = r0 - 1;
            int r14 = Character.toCodePoint(r13, r3);
            byte[] r15 = this.buffer;
            int r16 = this.pos;
            int r17 = r16 - 1;
            r15[r16] = (byte) ((r14 & 63) | 128);
            int r18 = r17 - 1;
            r15[r17] = (byte) (((r14 >>> 6) & 63) | 128);
            int r19 = r18 - 1;
            r15[r18] = (byte) (((r14 >>> 12) & 63) | 128);
            this.pos = r19 - 1;
            r15[r19] = (byte) ((r14 >>> 18) | 240);
        L38:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L39:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L40
        L27:
            if (57343 >= r3) goto L32;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) {
            byte[] r0 = this.buffer;
            int r1 = this.pos;
            this.pos = r1 - 1;
            r0[r1] = value;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            int r0 = this.pos - length;
            this.pos = r0;
            System.arraycopy(value, offset, this.buffer, r0 + 1, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L6:
            int r0 = this.pos - length;
            this.pos = r0;
            System.arraycopy(value, offset, this.buffer, r0 + 1, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int r0 = value.remaining();
            if (spaceLeft() >= r0) goto L5;
            nextBuffer(r0);
        L5:
            int r1 = this.pos - r0;
            this.pos = r1;
            value.get(this.buffer, r1 + 1, r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int r0 = value.remaining();
            if (spaceLeft() >= r0) goto L5;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
        L5:
            int r1 = this.pos - r0;
            this.pos = r1;
            value.get(this.buffer, r1 + 1, r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        static /* synthetic */ boolean access$000() {
            return isSupported();
        }

        UnsafeDirectWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        private static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newDirectBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer() == false) goto L11;
            ByteBuffer r0 = allocatedBuffer.nioBuffer();
            if (r0.isDirect() == false) goto L9;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.buffer = r0;
            Java8Compatibility.limit(r0, r0.capacity());
            Java8Compatibility.position(this.buffer, 0);
            long r1 = UnsafeUtil.addressOffset(this.buffer);
            this.bufferOffset = r1;
            long r2 = r1 + ((long) (this.buffer.limit() - 1));
            this.limitMinusOne = r2;
            this.pos = r2;
            return;
        L9:
            throw new RuntimeException("Allocator returned non-direct buffer");
        L11:
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.buffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int fieldNumber, String value) {
            int r0 = getTotalBytesWritten();
            writeString(value);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int r0 = getTotalBytesWritten();
            schema.writeTo(value, this);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & (-128)) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) value);
        }

        private void writeVarint32TwoBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 7));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((value & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 14));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 7) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FourBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 21));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 14) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 7) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FiveBytes(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 28));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 21) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 14) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 7) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) ((value & 127) | 128));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) value);
        }

        private void writeVarint64TwoBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 7));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((((int) value) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (((int) value) >>> 14));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 7) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FourBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 21));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 14) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 7) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FiveBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 28));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 21) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 14) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 7) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SixBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 35));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 28) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 21) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 14) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 7) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SevenBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 42));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 35) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 28) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 21) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 14) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 7) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) ((value & 127) | 128));
        }

        private void writeVarint64EightBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 49));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 42) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 35) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 28) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 21) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 14) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((value >>> 7) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) ((value & 127) | 128));
        }

        private void writeVarint64NineBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 56));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 49) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 42) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 35) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 28) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 21) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((value >>> 14) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((value >>> 7) & 127) | 128));
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) ((value & 127) | 128));
        }

        private void writeVarint64TenBytes(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (value >>> 63));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((value >>> 56) & 127) | 128));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((value >>> 49) & 127) | 128));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((value >>> 42) & 127) | 128));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((value >>> 35) & 127) | 128));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((value >>> 28) & 127) | 128));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((value >>> 21) & 127) | 128));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((value >>> 14) & 127) | 128));
            long r8 = this.pos;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) (((value >>> 7) & 127) | 128));
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r9, (byte) ((value & 127) | 128));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) ((value >> 24) & 255));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) ((value >> 16) & 255));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) ((value >> 8) & 255));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (value & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, (byte) (((int) (value >> 56)) & 255));
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r1, (byte) (((int) (value >> 48)) & 255));
            long r2 = this.pos;
            this.pos = r2 - 1;
            UnsafeUtil.putByte(r2, (byte) (((int) (value >> 40)) & 255));
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r3, (byte) (((int) (value >> 32)) & 255));
            long r4 = this.pos;
            this.pos = r4 - 1;
            UnsafeUtil.putByte(r4, (byte) (((int) (value >> 24)) & 255));
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) (((int) (value >> 16)) & 255));
            long r6 = this.pos;
            this.pos = r6 - 1;
            UnsafeUtil.putByte(r6, (byte) (((int) (value >> 8)) & 255));
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) (((int) value) & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int r0 = in.length();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L9;
            char r4 = in.charAt(r0);
            if (r4 >= 128) goto L9;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r5, (byte) r4);
        L9:
            if (r0 != (-1)) goto L11;
            return;
        L11:
            if (r0 < 0) goto L39;
            char r6 = in.charAt(r0);
            if (r6 >= 128) goto L18;
            long r7 = this.pos;
            if (r7 < this.bufferOffset) goto L18;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r7, (byte) r6);
        L38:
            r0 = r0 - 1;
        L18:
            if (r6 >= 2048) goto L23;
            long r8 = this.pos;
            if (r8 <= this.bufferOffset) goto L23;
            this.pos = r8 - 1;
            UnsafeUtil.putByte(r8, (byte) ((r6 & '?') | 128));
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r9, (byte) ((r6 >>> 6) | 960));
        L23:
            if (r6 >= 55296) goto L25;
        L26:
            long r10 = this.pos;
            if (r10 <= (this.bufferOffset + 1)) goto L30;
            this.pos = r10 - 1;
            UnsafeUtil.putByte(r10, (byte) ((r6 & '?') | 128));
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r11, (byte) (((r6 >>> 6) & 63) | 128));
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r12, (byte) ((r6 >>> '\f') | 480));
        L30:
            if (this.pos <= (this.bufferOffset + 2)) goto L37;
            if (r0 == 0) goto L36;
            char r13 = in.charAt(r0 - 1);
            if (Character.isSurrogatePair(r13, r6) == false) goto L36;
            r0 = r0 - 1;
            int r14 = Character.toCodePoint(r13, r6);
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r15, (byte) ((r14 & 63) | 128));
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r16, (byte) (((r14 >>> 6) & 63) | 128));
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r17, (byte) (((r14 >>> 12) & 63) | 128));
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r18, (byte) ((r14 >>> 18) | 240));
        L36:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L37:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L38
        L25:
            if (57343 >= r6) goto L30;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) {
            long r0 = this.pos;
            this.pos = r0 - 1;
            UnsafeUtil.putByte(r0, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L5;
            nextBuffer(length);
        L5:
            this.pos -= (long) length;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (spaceLeft() >= length) goto L6;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) length;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(value, offset, length);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int r0 = value.remaining();
            if (spaceLeft() >= r0) goto L5;
            nextBuffer(r0);
        L5:
            this.pos -= (long) r0;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int r0 = value.remaining();
            if (spaceLeft() >= r0) goto L6;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
            return;
        L6:
            this.pos -= (long) r0;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        UnsafeHeapWriter(BufferAllocator alloc, int chunkSize) {
            super(alloc, chunkSize, null);
            nextBuffer();
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void finishCurrentBuffer() {
            if (this.allocatedBuffer == null) goto L6;
            this.totalDoneBytes += bytesWrittenToCurrentBuffer();
            this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
            this.allocatedBuffer = null;
            this.pos = 0;
            this.limitMinusOne = 0;
            return;
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void nextBuffer(int capacity) {
            nextBuffer(newHeapBuffer(capacity));
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray() == false) goto L7;
            finishCurrentBuffer();
            this.buffers.addFirst(allocatedBuffer);
            this.allocatedBuffer = allocatedBuffer;
            this.buffer = allocatedBuffer.array();
            long r0 = allocatedBuffer.arrayOffset();
            this.limit = ((long) allocatedBuffer.limit()) + r0;
            long r1 = r0 + ((long) allocatedBuffer.position());
            this.offset = r1;
            this.offsetMinusOne = r1 - 1;
            long r2 = this.limit - 1;
            this.limitMinusOne = r2;
            this.pos = r2;
            return;
        L7:
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeVarint32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeInt32(int fieldNumber, int value) {
            requireSpace(15);
            writeInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt32(int fieldNumber, int value) {
            requireSpace(10);
            writeSInt32(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed32(int fieldNumber, int value) {
            requireSpace(9);
            writeFixed32(value);
            writeTag(fieldNumber, 5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeUInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeVarint64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeSInt64(int fieldNumber, long value) {
            requireSpace(15);
            writeSInt64(value);
            writeTag(fieldNumber, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeFixed64(int fieldNumber, long value) {
            requireSpace(13);
            writeFixed64(value);
            writeTag(fieldNumber, 1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBool(int r2, boolean r3) {
            requireSpace(6);
            write(r3 ? 1 : 0);
            writeTag(r2, 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeString(int fieldNumber, String value) {
            int r0 = getTotalBytesWritten();
            writeString(value);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeBytes(int fieldNumber, ByteString value) {
            value.writeToReverse(this);     // Catch: IOException -> L5
            requireSpace(10);
            writeVarint32(value.size());
            writeTag(fieldNumber, 2);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value) throws IOException {
            int r0 = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(value, this);
            int r4 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r4);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeMessage(int fieldNumber, Object value, Schema schema) throws IOException {
            int r0 = getTotalBytesWritten();
            schema.writeTo(value, this);
            int r3 = getTotalBytesWritten() - r0;
            requireSpace(10);
            writeVarint32(r3);
            writeTag(fieldNumber, 2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value) throws IOException {
            writeTag(fieldNumber, 4);
            Protobuf.getInstance().writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeGroup(int fieldNumber, Object value, Schema schema) throws IOException {
            writeTag(fieldNumber, 4);
            schema.writeTo(value, this);
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeStartGroup(int fieldNumber) {
            writeTag(fieldNumber, 3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Writer
        public void writeEndGroup(int fieldNumber) {
            writeTag(fieldNumber, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeInt32(int value) {
            if (value < 0) goto L4;
            writeVarint32(value);
            return;
        L4:
            writeVarint64(value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt32(int value) {
            writeVarint32(CodedOutputStream.encodeZigZag32(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeSInt64(long value) {
            writeVarint64(CodedOutputStream.encodeZigZag64(value));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeBool(boolean r1) {
            write(r1 ? 1 : 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeTag(int fieldNumber, int wireType) {
            writeVarint32(WireFormat.makeTag(fieldNumber, wireType));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint32(int value) {
            if ((value & (-128)) != 0) goto L6;
            writeVarint32OneByte(value);
            return;
        L6:
            if ((value & (-16384)) != 0) goto L9;
            writeVarint32TwoBytes(value);
            return;
        L9:
            if (((-2097152) & value) != 0) goto L12;
            writeVarint32ThreeBytes(value);
            return;
        L12:
            if (((-268435456) & value) != 0) goto L14;
            writeVarint32FourBytes(value);
            return;
        L14:
            writeVarint32FiveBytes(value);
        }

        private void writeVarint32OneByte(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) value);
        }

        private void writeVarint32TwoBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 7));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((value & 127) | 128));
        }

        private void writeVarint32ThreeBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 14));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 7) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FourBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 21));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 14) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 7) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) ((value & 127) | 128));
        }

        private void writeVarint32FiveBytes(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 28));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 21) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 14) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 7) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) ((value & 127) | 128));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeVarint64(long value) {
            switch(BinaryWriter.access$200(value)) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L25;
            };
        L5:
            writeVarint64TenBytes(value);
            return;
        L6:
            writeVarint64NineBytes(value);
            return;
        L7:
            writeVarint64EightBytes(value);
            return;
        L8:
            writeVarint64SevenBytes(value);
            return;
        L9:
            writeVarint64SixBytes(value);
            return;
        L10:
            writeVarint64FiveBytes(value);
            return;
        L11:
            writeVarint64FourBytes(value);
            return;
        L12:
            writeVarint64ThreeBytes(value);
            return;
        L13:
            writeVarint64TwoBytes(value);
            return;
        L14:
            writeVarint64OneByte(value);
            return;
        }

        private void writeVarint64OneByte(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) value);
        }

        private void writeVarint64TwoBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 7));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((((int) value) & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (((int) value) >>> 14));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 7) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FourBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 21));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 14) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 7) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) ((value & 127) | 128));
        }

        private void writeVarint64FiveBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 28));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 21) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 14) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 7) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SixBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 35));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 28) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 21) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 14) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 7) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) ((value & 127) | 128));
        }

        private void writeVarint64SevenBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 42));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 35) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 28) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 21) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 14) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 7) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) ((value & 127) | 128));
        }

        private void writeVarint64EightBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 49));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 42) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 35) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 28) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 21) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 14) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((value >>> 7) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) ((value & 127) | 128));
        }

        private void writeVarint64NineBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 56));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 49) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 42) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 35) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 28) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 21) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((value >>> 14) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((value >>> 7) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) ((value & 127) | 128));
        }

        private void writeVarint64TenBytes(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (value >>> 63));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((value >>> 56) & 127) | 128));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((value >>> 49) & 127) | 128));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((value >>> 42) & 127) | 128));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((value >>> 35) & 127) | 128));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((value >>> 28) & 127) | 128));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((value >>> 21) & 127) | 128));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((value >>> 14) & 127) | 128));
            byte[] r16 = this.buffer;
            long r17 = this.pos;
            this.pos = r17 - 1;
            UnsafeUtil.putByte(r16, r17, (byte) (((value >>> 7) & 127) | 128));
            byte[] r18 = this.buffer;
            long r19 = this.pos;
            this.pos = r19 - 1;
            UnsafeUtil.putByte(r18, r19, (byte) ((value & 127) | 128));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed32(int value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) ((value >> 24) & 255));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) ((value >> 16) & 255));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) ((value >> 8) & 255));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (value & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeFixed64(long value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, (byte) (((int) (value >> 56)) & 255));
            byte[] r2 = this.buffer;
            long r3 = this.pos;
            this.pos = r3 - 1;
            UnsafeUtil.putByte(r2, r3, (byte) (((int) (value >> 48)) & 255));
            byte[] r4 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r4, r5, (byte) (((int) (value >> 40)) & 255));
            byte[] r6 = this.buffer;
            long r7 = this.pos;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r6, r7, (byte) (((int) (value >> 32)) & 255));
            byte[] r8 = this.buffer;
            long r9 = this.pos;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r8, r9, (byte) (((int) (value >> 24)) & 255));
            byte[] r10 = this.buffer;
            long r11 = this.pos;
            this.pos = r11 - 1;
            UnsafeUtil.putByte(r10, r11, (byte) (((int) (value >> 16)) & 255));
            byte[] r12 = this.buffer;
            long r13 = this.pos;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r12, r13, (byte) (((int) (value >> 8)) & 255));
            byte[] r14 = this.buffer;
            long r15 = this.pos;
            this.pos = r15 - 1;
            UnsafeUtil.putByte(r14, r15, (byte) (((int) value) & 255));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void writeString(String in) {
            requireSpace(in.length());
            int r0 = in.length();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L9;
            char r4 = in.charAt(r0);
            if (r4 >= 128) goto L9;
            byte[] r1 = this.buffer;
            long r5 = this.pos;
            this.pos = r5 - 1;
            UnsafeUtil.putByte(r1, r5, (byte) r4);
        L9:
            if (r0 != (-1)) goto L11;
            return;
        L11:
            if (r0 < 0) goto L39;
            char r6 = in.charAt(r0);
            if (r6 >= 128) goto L18;
            long r7 = this.pos;
            if (r7 <= this.offsetMinusOne) goto L18;
            byte[] r8 = this.buffer;
            this.pos = r7 - 1;
            UnsafeUtil.putByte(r8, r7, (byte) r6);
        L38:
            r0 = r0 - 1;
        L18:
            if (r6 >= 2048) goto L23;
            long r9 = this.pos;
            if (r9 <= this.offset) goto L23;
            byte[] r10 = this.buffer;
            this.pos = r9 - 1;
            UnsafeUtil.putByte(r10, r9, (byte) ((r6 & '?') | 128));
            byte[] r11 = this.buffer;
            long r12 = this.pos;
            this.pos = r12 - 1;
            UnsafeUtil.putByte(r11, r12, (byte) ((r6 >>> 6) | 960));
        L23:
            if (r6 >= 55296) goto L25;
        L26:
            long r13 = this.pos;
            if (r13 <= (this.offset + 1)) goto L30;
            byte[] r14 = this.buffer;
            this.pos = r13 - 1;
            UnsafeUtil.putByte(r14, r13, (byte) ((r6 & '?') | 128));
            byte[] r15 = this.buffer;
            long r16 = this.pos;
            this.pos = r16 - 1;
            UnsafeUtil.putByte(r15, r16, (byte) (((r6 >>> 6) & 63) | 128));
            byte[] r17 = this.buffer;
            long r18 = this.pos;
            this.pos = r18 - 1;
            UnsafeUtil.putByte(r17, r18, (byte) ((r6 >>> '\f') | 480));
        L30:
            if (this.pos <= (this.offset + 2)) goto L37;
            if (r0 == 0) goto L36;
            char r19 = in.charAt(r0 - 1);
            if (Character.isSurrogatePair(r19, r6) == false) goto L36;
            r0 = r0 - 1;
            int r20 = Character.toCodePoint(r19, r6);
            byte[] r21 = this.buffer;
            long r22 = this.pos;
            this.pos = r22 - 1;
            UnsafeUtil.putByte(r21, r22, (byte) ((r20 & 63) | 128));
            byte[] r23 = this.buffer;
            long r24 = this.pos;
            this.pos = r24 - 1;
            UnsafeUtil.putByte(r23, r24, (byte) (((r20 >>> 6) & 63) | 128));
            byte[] r25 = this.buffer;
            long r26 = this.pos;
            this.pos = r26 - 1;
            UnsafeUtil.putByte(r25, r26, (byte) (((r20 >>> 12) & 63) | 128));
            byte[] r27 = this.buffer;
            long r28 = this.pos;
            this.pos = r28 - 1;
            UnsafeUtil.putByte(r27, r28, (byte) ((r20 >>> 18) | 240));
        L36:
            throw new Utf8.UnpairedSurrogateException(r0 - 1, r0);
        L37:
            requireSpace(r0);
            r0 = r0 + 1;
            goto L38
        L25:
            if (57343 >= r6) goto L30;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte value) {
            byte[] r0 = this.buffer;
            long r1 = this.pos;
            this.pos = r1 - 1;
            UnsafeUtil.putByte(r0, r1, value);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(byte[] value, int offset, int length) {
            if (offset < 0) goto L9;
            if ((offset + length) > value.length) goto L9;
            requireSpace(length);
            this.pos -= (long) length;
            System.arraycopy(value, offset, this.buffer, arrayPos() + 1, length);
            return;
        L9:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(value.length), Integer.valueOf(offset), Integer.valueOf(length)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(byte[] value, int offset, int length) {
            if (offset < 0) goto L13;
            if ((offset + length) > value.length) goto L13;
            if (spaceLeft() >= length) goto L10;
            this.totalDoneBytes += length;
            this.buffers.addFirst(AllocatedBuffer.wrap(value, offset, length));
            nextBuffer();
            return;
        L10:
            this.pos -= (long) length;
            System.arraycopy(value, offset, this.buffer, arrayPos() + 1, length);
            return;
        L13:
            throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(value.length), Integer.valueOf(offset), Integer.valueOf(length)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void write(ByteBuffer value) {
            int r0 = value.remaining();
            requireSpace(r0);
            this.pos -= (long) r0;
            value.get(this.buffer, arrayPos() + 1, r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer value) {
            int r0 = value.remaining();
            if (spaceLeft() >= r0) goto L5;
            this.totalDoneBytes += r0;
            this.buffers.addFirst(AllocatedBuffer.wrap(value));
            nextBuffer();
        L5:
            this.pos -= (long) r0;
            value.get(this.buffer, arrayPos() + 1, r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.BinaryWriter
        void requireSpace(int size) {
            if (spaceLeft() >= size) goto L6;
            nextBuffer(size);
            return;
        }
    }

    private static byte computeUInt64SizeNoTag(long value) {
        if (((-128) & value) != 0) goto L7;
        return 1;
    L7:
        if (value >= 0) goto L11;
        return 10;
    L11:
        if (((-34359738368L) & value) == 0) goto L13;
        byte r0 = (byte) 6;
        value = value >>> 28;
    L15:
        if (((-2097152) & value) == 0) goto L18;
        r0 = (byte) (r0 + 2);
        value = value >>> 14;
    L18:
        if ((value & (-16384)) != 0) goto L20;
        return r0;
    L20:
        return (byte) (r0 + 1);
    L13:
        r0 = 2;
        goto L15
    }

    abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    abstract void requireSpace(int size);

    abstract void writeBool(boolean value);

    abstract void writeFixed32(int value);

    abstract void writeFixed64(long value);

    abstract void writeInt32(int value);

    abstract void writeSInt32(int value);

    abstract void writeSInt64(long value);

    abstract void writeString(String in);

    abstract void writeTag(int fieldNumber, int wireType);

    abstract void writeVarint32(int value);

    abstract void writeVarint64(long value);

    /* synthetic */ BinaryWriter(BufferAllocator r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static /* synthetic */ byte access$200(long r0) {
        return computeUInt64SizeNoTag(r0);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator alloc) {
        return newHeapInstance(alloc, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeHeapSupported() == false) goto L6;
        return newUnsafeHeapInstance(alloc, chunkSize);
    L6:
        return newSafeHeapInstance(alloc, chunkSize);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator alloc) {
        return newDirectInstance(alloc, 4096);
    }

    public static BinaryWriter newDirectInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeDirectSupported() == false) goto L6;
        return newUnsafeDirectInstance(alloc, chunkSize);
    L6:
        return newSafeDirectInstance(alloc, chunkSize);
    }

    static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.access$000();
    }

    static BinaryWriter newSafeHeapInstance(BufferAllocator alloc, int chunkSize) {
        return new SafeHeapWriter(alloc, chunkSize);
    }

    static BinaryWriter newUnsafeHeapInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeHeapSupported() == false) goto L7;
        return new UnsafeHeapWriter(alloc, chunkSize);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter newSafeDirectInstance(BufferAllocator alloc, int chunkSize) {
        return new SafeDirectWriter(alloc, chunkSize);
    }

    static BinaryWriter newUnsafeDirectInstance(BufferAllocator alloc, int chunkSize) {
        if (isUnsafeDirectSupported() == false) goto L7;
        return new UnsafeDirectWriter(alloc, chunkSize);
    L7:
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private BinaryWriter(BufferAllocator alloc, int chunkSize) {
        this.buffers = new ArrayDeque(4);
        if (chunkSize <= 0) goto L7;
        this.alloc = (BufferAllocator) Internal.checkNotNull(alloc, "alloc");
        this.chunkSize = chunkSize;
        return;
    L7:
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed32(int fieldNumber, int value) throws IOException {
        writeFixed32(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeInt64(int fieldNumber, long value) throws IOException {
        writeUInt64(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed64(int fieldNumber, long value) throws IOException {
        writeFixed64(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFloat(int fieldNumber, float value) throws IOException {
        writeFixed32(fieldNumber, Float.floatToRawIntBits(value));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeDouble(int fieldNumber, double value) throws IOException {
        writeFixed64(fieldNumber, Double.doubleToRawLongBits(value));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeEnum(int fieldNumber, int value) throws IOException {
        writeInt32(fieldNumber, value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeInt32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeInt32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeInt32List_Internal(fieldNumber, list, packed);
    }

    private void writeInt32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeInt32(list.get(r0).intValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeInt32(fieldNumber, list.get(r6).intValue());
        r6 = r6 - 1;
        goto L8
    }

    private void writeInt32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeInt32(list.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeInt32(fieldNumber, list.getInt(r6));
        r6 = r6 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFixed32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeFixed32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeFixed32List_Internal(fieldNumber, list, packed);
    }

    private void writeFixed32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed32(list.get(r0).intValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeFixed32(fieldNumber, list.get(r6).intValue());
        r6 = r6 - 1;
        goto L8
    }

    private void writeFixed32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed32(list.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeFixed32(fieldNumber, list.getInt(r6));
        r6 = r6 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeInt64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        writeUInt64List(fieldNumber, list, packed);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeUInt64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if ((list instanceof LongArrayList) == false) goto L5;
        writeUInt64List_Internal(fieldNumber, (LongArrayList) list, packed);
        return;
    L5:
        writeUInt64List_Internal(fieldNumber, list, packed);
    }

    private void writeUInt64List_Internal(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeVarint64(list.get(r0).longValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeUInt64(fieldNumber, list.get(r7).longValue());
        r7 = r7 - 1;
        goto L8
    }

    private void writeUInt64List_Internal(int fieldNumber, LongArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeVarint64(list.getLong(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeUInt64(fieldNumber, list.getLong(r7));
        r7 = r7 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFixed64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if ((list instanceof LongArrayList) == false) goto L5;
        writeFixed64List_Internal(fieldNumber, (LongArrayList) list, packed);
        return;
    L5:
        writeFixed64List_Internal(fieldNumber, list, packed);
    }

    private void writeFixed64List_Internal(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed64(list.get(r0).longValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeFixed64(fieldNumber, list.get(r7).longValue());
        r7 = r7 - 1;
        goto L8
    }

    private void writeFixed64List_Internal(int fieldNumber, LongArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed64(list.getLong(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeFixed64(fieldNumber, list.getLong(r7));
        r7 = r7 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeFloatList(int fieldNumber, List<Float> list, boolean packed) throws IOException {
        if ((list instanceof FloatArrayList) == false) goto L5;
        writeFloatList_Internal(fieldNumber, (FloatArrayList) list, packed);
        return;
    L5:
        writeFloatList_Internal(fieldNumber, list, packed);
    }

    private void writeFloatList_Internal(int fieldNumber, List<Float> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(list.get(r0).floatValue()));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeFloat(fieldNumber, list.get(r6).floatValue());
        r6 = r6 - 1;
        goto L8
    }

    private void writeFloatList_Internal(int fieldNumber, FloatArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 4) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed32(Float.floatToRawIntBits(list.getFloat(r0)));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeFloat(fieldNumber, list.getFloat(r6));
        r6 = r6 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeDoubleList(int fieldNumber, List<Double> list, boolean packed) throws IOException {
        if ((list instanceof DoubleArrayList) == false) goto L5;
        writeDoubleList_Internal(fieldNumber, (DoubleArrayList) list, packed);
        return;
    L5:
        writeDoubleList_Internal(fieldNumber, list, packed);
    }

    private void writeDoubleList_Internal(int fieldNumber, List<Double> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(list.get(r0).doubleValue()));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeDouble(fieldNumber, list.get(r7).doubleValue());
        r7 = r7 - 1;
        goto L8
    }

    private void writeDoubleList_Internal(int fieldNumber, DoubleArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 8) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeFixed64(Double.doubleToRawLongBits(list.getDouble(r0)));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeDouble(fieldNumber, list.getDouble(r7));
        r7 = r7 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeEnumList(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        writeInt32List(fieldNumber, list, packed);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeBoolList(int fieldNumber, List<Boolean> list, boolean packed) throws IOException {
        if ((list instanceof BooleanArrayList) == false) goto L5;
        writeBoolList_Internal(fieldNumber, (BooleanArrayList) list, packed);
        return;
    L5:
        writeBoolList_Internal(fieldNumber, list, packed);
    }

    private void writeBoolList_Internal(int fieldNumber, List<Boolean> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace(list.size() + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeBool(list.get(r0).booleanValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeBool(fieldNumber, list.get(r6).booleanValue());
        r6 = r6 - 1;
        goto L8
    }

    private void writeBoolList_Internal(int fieldNumber, BooleanArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace(list.size() + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeBool(list.getBoolean(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeBool(fieldNumber, list.getBoolean(r6));
        r6 = r6 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeStringList(int fieldNumber, List<String> list) throws IOException {
        if ((list instanceof LazyStringList) == false) goto L7;
        LazyStringList r0 = (LazyStringList) list;
        int r4 = list.size() - 1;
    L5:
        if (r4 < 0) goto L10;
        writeLazyString(fieldNumber, r0.getRaw(r4));
        r4 = r4 - 1;
        goto L5
    L10:
        return;
    L7:
        int r1 = list.size() - 1;
    L8:
        if (r1 < 0) goto L13;
        writeString(fieldNumber, list.get(r1));
        r1 = r1 - 1;
        goto L8
    }

    private void writeLazyString(int fieldNumber, Object value) throws IOException {
        if ((value instanceof String) == false) goto L5;
        writeString(fieldNumber, (String) value);
        return;
    L5:
        writeBytes(fieldNumber, (ByteString) value);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeBytesList(int fieldNumber, List<ByteString> list) throws IOException {
        int r0 = list.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeBytes(fieldNumber, list.get(r0));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeUInt32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeUInt32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeUInt32List_Internal(fieldNumber, list, packed);
    }

    private void writeUInt32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeVarint32(list.get(r0).intValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeUInt32(fieldNumber, list.get(r6).intValue());
        r6 = r6 - 1;
        goto L8
    }

    private void writeUInt32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeVarint32(list.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeUInt32(fieldNumber, list.getInt(r6));
        r6 = r6 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        writeFixed32List(fieldNumber, list, packed);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSFixed64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        writeFixed64List(fieldNumber, list, packed);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSInt32List(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if ((list instanceof IntArrayList) == false) goto L5;
        writeSInt32List_Internal(fieldNumber, (IntArrayList) list, packed);
        return;
    L5:
        writeSInt32List_Internal(fieldNumber, list, packed);
    }

    private void writeSInt32List_Internal(int fieldNumber, List<Integer> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeSInt32(list.get(r0).intValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeSInt32(fieldNumber, list.get(r6).intValue());
        r6 = r6 - 1;
        goto L8
    }

    private void writeSInt32List_Internal(int fieldNumber, IntArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 5) + 10);
        int r5 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeSInt32(list.getInt(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r5);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r6 = list.size() - 1;
    L8:
        if (r6 < 0) goto L13;
        writeSInt32(fieldNumber, list.getInt(r6));
        r6 = r6 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeSInt64List(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if ((list instanceof LongArrayList) == false) goto L5;
        writeSInt64List_Internal(fieldNumber, (LongArrayList) list, packed);
        return;
    L5:
        writeSInt64List_Internal(fieldNumber, list, packed);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public <K, V> void writeMap(int fieldNumber, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        Iterator<Map.Entry<K, V>> r8 = map.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry<K, V> r0 = r8.next();
        int r1 = getTotalBytesWritten();
        writeMapEntryField(this, 2, metadata.valueType, r0.getValue());
        writeMapEntryField(this, 1, metadata.keyType, r0.getKey());
        writeVarint32(getTotalBytesWritten() - r1);
        writeTag(fieldNumber, 2);
        goto L4
    }

    static final void writeMapEntryField(Writer writer, int fieldNumber, WireFormat.FieldType fieldType, Object object) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L7;
            default: goto L5;
        };
    L14:
        writer.writeBytes(fieldNumber, (ByteString) object);
        return;
    L15:
        writer.writeMessage(fieldNumber, object);
        return;
    L16:
        writer.writeDouble(fieldNumber, ((Double) object).doubleValue());
        return;
    L17:
        writer.writeFloat(fieldNumber, ((Float) object).floatValue());
        return;
    L18:
        writer.writeUInt64(fieldNumber, ((Long) object).longValue());
        return;
    L19:
        writer.writeUInt32(fieldNumber, ((Integer) object).intValue());
        return;
    L20:
        writer.writeString(fieldNumber, (String) object);
        return;
    L21:
        writer.writeSInt64(fieldNumber, ((Long) object).longValue());
        return;
    L22:
        writer.writeSInt32(fieldNumber, ((Integer) object).intValue());
        return;
    L23:
        writer.writeSFixed64(fieldNumber, ((Long) object).longValue());
        return;
    L24:
        writer.writeSFixed32(fieldNumber, ((Integer) object).intValue());
        return;
    L25:
        writer.writeInt64(fieldNumber, ((Long) object).longValue());
        return;
    L26:
        writer.writeInt32(fieldNumber, ((Integer) object).intValue());
        return;
    L27:
        writer.writeFixed64(fieldNumber, ((Long) object).longValue());
        return;
    L28:
        writer.writeFixed32(fieldNumber, ((Integer) object).intValue());
        return;
    L29:
        writer.writeBool(fieldNumber, ((Boolean) object).booleanValue());
        return;
    L5:
        throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
    L7:
        if ((object instanceof Internal.EnumLite) == false) goto L10;
        writer.writeEnum(fieldNumber, ((Internal.EnumLite) object).getNumber());
        return;
    L10:
        if ((object instanceof Integer) == false) goto L13;
        writer.writeEnum(fieldNumber, ((Integer) object).intValue());
        return;
    L13:
        throw new IllegalArgumentException("Unexpected type for enum in map.");
    }

    private void writeSInt64List_Internal(int fieldNumber, List<Long> list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeSInt64(list.get(r0).longValue());
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeSInt64(fieldNumber, list.get(r7).longValue());
        r7 = r7 - 1;
        goto L8
    }

    private void writeSInt64List_Internal(int fieldNumber, LongArrayList list, boolean packed) throws IOException {
        if (packed == false) goto L7;
        requireSpace((list.size() * 10) + 10);
        int r6 = getTotalBytesWritten();
        int r0 = list.size() - 1;
    L4:
        if (r0 < 0) goto L6;
        writeSInt64(list.getLong(r0));
        r0 = r0 - 1;
        goto L4
    L6:
        writeVarint32(getTotalBytesWritten() - r6);
        writeTag(fieldNumber, 2);
        return;
    L7:
        int r7 = list.size() - 1;
    L8:
        if (r7 < 0) goto L13;
        writeSInt64(fieldNumber, list.getLong(r7));
        r7 = r7 - 1;
        goto L8
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageList(int fieldNumber, List<?> list) throws IOException {
        int r0 = list.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeMessage(fieldNumber, list.get(r0));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageList(int fieldNumber, List<?> list, Schema schema) throws IOException {
        int r0 = list.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeMessage(fieldNumber, list.get(r0), schema);
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int fieldNumber, List<?> list) throws IOException {
        int r0 = list.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeGroup(fieldNumber, list.get(r0));
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int fieldNumber, List<?> list, Schema schema) throws IOException {
        int r0 = list.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        writeGroup(fieldNumber, list.get(r0), schema);
        r0 = r0 - 1;
        goto L3
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void writeMessageSetItem(int fieldNumber, Object value) throws IOException {
        writeTag(1, 4);
        if ((value instanceof ByteString) == false) goto L5;
        writeBytes(3, (ByteString) value);
    L6:
        writeUInt32(2, fieldNumber);
        writeTag(1, 3);
        return;
    L5:
        writeMessage(3, value);
        goto L6
    }

    final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    final AllocatedBuffer newHeapBuffer(int capacity) {
        return this.alloc.allocateHeapBuffer(Math.max(capacity, this.chunkSize));
    }

    final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    final AllocatedBuffer newDirectBuffer(int capacity) {
        return this.alloc.allocateDirectBuffer(Math.max(capacity, this.chunkSize));
    }
}
