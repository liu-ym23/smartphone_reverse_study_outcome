package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = null;
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    private static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        ByteArrayDataInputStream(ByteArrayInputStream r2) {
            this.input = new DataInputStream(r2);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] r1) {
            this.input.readFully(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public void readFully(byte[] r1, int r2, int r3) {
            this.input.readFully(r1, r2, r3);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int skipBytes(int r1) {
            return this.input.skipBytes(r1);
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public boolean readBoolean() {
            return this.input.readBoolean();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public byte readByte() {
            return this.input.readByte();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedByte() {
            return this.input.readUnsignedByte();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public short readShort() {
            return this.input.readShort();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readUnsignedShort() {
            return this.input.readUnsignedShort();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public char readChar() {
            return this.input.readChar();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public int readInt() {
            return this.input.readInt();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public long readLong() {
            return this.input.readLong();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public float readFloat() {
            return this.input.readFloat();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public double readDouble() {
            return this.input.readDouble();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        @CheckForNull
        public String readLine() {
            return this.input.readLine();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Override // com.google.common.io.ByteArrayDataInput, java.io.DataInput
        public String readUTF() {
            return this.input.readUTF();
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }
    }

    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputStream;
        final DataOutput output;

        ByteArrayDataOutputStream(ByteArrayOutputStream r2) {
            this.byteArrayOutputStream = r2;
            this.output = new DataOutputStream(r2);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(int r1) {
            this.output.write(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] r1) {
            this.output.write(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void write(byte[] r1, int r2, int r3) {
            this.output.write(r1, r2, r3);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBoolean(boolean r1) {
            this.output.writeBoolean(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeByte(int r1) {
            this.output.writeByte(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeBytes(String r1) {
            this.output.writeBytes(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChar(int r1) {
            this.output.writeChar(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeChars(String r1) {
            this.output.writeChars(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeDouble(double r1) {
            this.output.writeDouble(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeFloat(float r1) {
            this.output.writeFloat(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeInt(int r1) {
            this.output.writeInt(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeLong(long r1) {
            this.output.writeLong(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeShort(int r1) {
            this.output.writeShort(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput, java.io.DataOutput
        public void writeUTF(String r1) {
            this.output.writeUTF(r1);     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.common.io.ByteArrayDataOutput
        public byte[] toByteArray() {
            return this.byteArrayOutputStream.toByteArray();
        }
    }

    private static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        LimitedInputStream(InputStream r3, long r4) {
            super(r3);
            this.mark = -1;
            Preconditions.checkNotNull(r3);
            if (r4 < 0) goto L5;
            boolean r5 = true;
        L6:
            Preconditions.checkArgument(r5, "limit must be non-negative");
            this.left = r4;
            return;
        L5:
            r5 = false;
            goto L6
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(this.in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int r3) {
            monitor-enter(this);
            this.in.mark(r3);     // Catch: Throwable -> L6
            this.mark = this.left;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.left != 0) goto L5;
            return -1;
        L5:
            int r0 = this.in.read();
            if (r0 == (-1)) goto L8;
            this.left--;
        L8:
            return r0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r7, int r8, int r9) throws IOException {
            long r0 = this.left;
            if (r0 != 0) goto L5;
            return -1;
        L5:
            int r10 = this.in.read(r7, r8, (int) Math.min(r9, r0));
            if (r10 == (-1)) goto L8;
            this.left -= (long) r10;
        L8:
            return r10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (this.in.markSupported() == false) goto L13;
            if (this.mark == (-1)) goto L11;
            this.in.reset();     // Catch: Throwable -> L14
            this.left = this.mark;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L11:
            throw new IOException("Mark not set");     // Catch: Throwable -> L14
        L13:
            throw new IOException("Mark not supported");     // Catch: Throwable -> L14
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long r3) throws IOException {
            long r4 = this.in.skip(Math.min(r3, this.left));
            this.left -= r4;
            return r4;
        }
    }

    static byte[] createBuffer() {
        return new byte[8192];
    }

    private ByteStreams() {
    }

    public static long copy(InputStream r5, OutputStream r6) throws IOException {
        Preconditions.checkNotNull(r5);
        Preconditions.checkNotNull(r6);
        byte[] r0 = createBuffer();
        long r1 = 0;
    L3:
        int r3 = r5.read(r0);
        if (r3 == (-1)) goto L5;
        r6.write(r0, 0, r3);
        r1 = r1 + ((long) r3);
        goto L3
    L5:
        return r1;
    }

    public static long copy(ReadableByteChannel r13, WritableByteChannel r14) throws IOException {
        Preconditions.checkNotNull(r13);
        Preconditions.checkNotNull(r14);
        long r1 = 0;
        if ((r13 instanceof FileChannel) == false) goto L11;
        FileChannel r0 = (FileChannel) r13;
        long r9 = r0.position();
        long r11 = r9;
    L5:
        long r3 = r0.transferTo(r11, 524288, r14);
        r11 = r11 + r3;
        r0.position(r11);
        if (r3 > 0) goto L5;
        if (r11 < r0.size()) goto L5;
        return r11 - r9;
    L11:
        ByteBuffer r2 = ByteBuffer.wrap(createBuffer());
    L13:
        if (r13.read(r2) == (-1)) goto L19;
        Java8Compatibility.flip(r2);
    L16:
        if (r2.hasRemaining() == false) goto L18;
        r1 = r1 + ((long) r14.write(r2));
        goto L16
    L18:
        Java8Compatibility.clear(r2);
        goto L13
    L19:
        return r1;
    }

    private static byte[] toByteArrayInternal(InputStream r6, Queue<byte[]> r7, int r8) throws IOException {
        int r0 = 8192;
    L4:
        if (r8 >= MAX_ARRAY_LEN) goto L14;
        int r2 = Math.min(r0, MAX_ARRAY_LEN - r8);
        byte[] r3 = new byte[r2];
        r7.add(r3);
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L12;
        int r5 = r6.read(r3, r4, r2 - r4);
        if (r5 == (-1)) goto L10;
        r4 = r4 + r5;
        r8 = r8 + r5;
        goto L6
    L10:
        return combineBuffers(r7, r8);
    L12:
        r0 = IntMath.saturatedMultiply(r0, 2);
        goto L4
    L14:
        if (r6.read() != (-1)) goto L18;
        return combineBuffers(r7, MAX_ARRAY_LEN);
    L18:
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] combineBuffers(Queue<byte[]> r6, int r7) {
        byte[] r0 = new byte[r7];
        int r1 = r7;
    L3:
        if (r1 <= 0) goto L5;
        byte[] r2 = r6.remove();
        int r3 = Math.min(r1, r2.length);
        System.arraycopy(r2, 0, r0, r7 - r1, r3);
        r1 = r1 - r3;
        goto L3
    L5:
        return r0;
    }

    public static byte[] toByteArray(InputStream r2) throws IOException {
        Preconditions.checkNotNull(r2);
        return toByteArrayInternal(r2, new ArrayDeque(20), 0);
    }

    static byte[] toByteArray(InputStream r6, long r7) throws IOException {
        if (r7 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "expectedSize (%s) must be non-negative", r7);
        if (r7 > 2147483639) goto L22;
        int r8 = (int) r7;
        byte[] r9 = new byte[r8];
        int r1 = r8;
    L10:
        if (r1 <= 0) goto L16;
        int r4 = r8 - r1;
        int r5 = r6.read(r9, r4, r1);
        if (r5 == (-1)) goto L14;
        r1 = r1 - r5;
        goto L10
    L14:
        return Arrays.copyOf(r9, r4);
    L16:
        int r2 = r6.read();
        if (r2 != (-1)) goto L19;
        return r9;
    L19:
        ArrayDeque r3 = new ArrayDeque(22);
        r3.add(r9);
        r3.add(new byte[]{(byte) r2});
        return toByteArrayInternal(r6, r3, r8 + 1);
    L22:
        throw new OutOfMemoryError(new StringBuilder(62).append(r7).append(" bytes is too large to fit in a byte array").toString());
    L5:
        r0 = false;
        goto L6
    }

    public static long exhaust(InputStream r7) throws IOException {
        byte[] r0 = createBuffer();
        long r1 = 0;
    L3:
        long r3 = r7.read(r0);
        if (r3 == (-1)) goto L6;
        r1 = r1 + r3;
        goto L3
    L6:
        return r1;
    }

    public static ByteArrayDataInput newDataInput(byte[] r1) {
        return newDataInput(new ByteArrayInputStream(r1));
    }

    public static ByteArrayDataInput newDataInput(byte[] r2, int r3) {
        Preconditions.checkPositionIndex(r3, r2.length);
        return newDataInput(new ByteArrayInputStream(r2, r3, r2.length - r3));
    }

    public static ByteArrayDataInput newDataInput(ByteArrayInputStream r1) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(r1));
    }

    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    public static ByteArrayDataOutput newDataOutput(int r3) {
        if (r3 < 0) goto L6;
        return newDataOutput(new ByteArrayOutputStream(r3));
    L6:
        throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[]{Integer.valueOf(r3)}));
    }

    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream r1) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(r1));
    }

    static {
        NULL_OUTPUT_STREAM = new AnonymousClass1();
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    public static InputStream limit(InputStream r1, long r2) {
        return new LimitedInputStream(r1, r2);
    }

    public static void readFully(InputStream r2, byte[] r3) throws IOException {
        readFully(r2, r3, 0, r3.length);
    }

    public static void readFully(InputStream r1, byte[] r2, int r3, int r4) throws IOException {
        int r5 = read(r1, r2, r3, r4);
        if (r5 != r4) goto L6;
        return;
    L6:
        throw new EOFException(new StringBuilder(81).append("reached end of stream after reading ").append(r5).append(" bytes; ").append(r4).append(" bytes expected").toString());
    }

    public static void skipFully(InputStream r4, long r5) throws IOException {
        long r0 = skipUpTo(r4, r5);
        if (r0 < r5) goto L6;
        return;
    L6:
        throw new EOFException(new StringBuilder(100).append("reached end of stream after skipping ").append(r0).append(" bytes; ").append(r5).append(" bytes expected").toString());
    }

    static long skipUpTo(InputStream r10, long r11) throws IOException {
        byte[] r2 = null;
        long r3 = 0;
    L4:
        if (r3 >= r11) goto L14;
        long r5 = r11 - r3;
        long r7 = skipSafely(r10, r5);
        if (r7 != 0) goto L13;
        int r6 = (int) Math.min(r5, 8192);
        if (r2 != null) goto L10;
        r2 = new byte[r6];
    L10:
        r7 = r10.read(r2, 0, r6);
        if (r7 == (-1)) goto L14;
    L13:
        r3 = r3 + r7;
    L14:
        return r3;
    }

    private static long skipSafely(InputStream r2, long r3) throws IOException {
        int r0 = r2.available();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return r2.skip(Math.min(r0, r3));
    }

    @ParametricNullness
    public static <T> T readBytes(InputStream r3, ByteProcessor<T> r4) throws IOException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        byte[] r0 = createBuffer();
    L3:
        int r1 = r3.read(r0);
        if (r1 == (-1)) goto L8;
        if (r4.processBytes(r0, 0, r1) == true) goto L3;
    L8:
        return r4.getResult();
    }

    public static int read(InputStream r3, byte[] r4, int r5, int r6) throws IOException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        int r0 = 0;
        if (r6 < 0) goto L12;
        Preconditions.checkPositionIndexes(r5, r5 + r6, r4.length);
    L5:
        if (r0 >= r6) goto L10;
        int r1 = r3.read(r4, r5 + r0, r6 - r0);
        if (r1 == (-1)) goto L10;
        r0 = r0 + r1;
    L10:
        return r0;
    L12:
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(r6)}));
    }
}
