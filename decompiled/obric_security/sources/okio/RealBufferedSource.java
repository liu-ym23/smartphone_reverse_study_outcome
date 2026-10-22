package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer;
    boolean closed;
    public final Source source;

    RealBufferedSource(Source r2) {
        this.buffer = new Buffer();
        if (r2 == null) goto L7;
        this.source = r2;
        return;
    L7:
        throw new NullPointerException("source == null");
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.Source
    public long read(Buffer r5, long r6) throws IOException {
        if (r5 == null) goto L19;
        if (r6 < 0) goto L17;
        if (this.closed == true) goto L15;
        if (this.buffer.size != 0) goto L13;
        if (this.source.read(this.buffer, 8192) != (-1)) goto L13;
        return -1;
    L13:
        return this.buffer.read(r5, Math.min(r6, this.buffer.size));
    L15:
        throw new IllegalStateException("closed");
    L17:
        throw new IllegalArgumentException("byteCount < 0: " + r6);
    L19:
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (this.closed == true) goto L12;
        if (this.buffer.exhausted() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.source.read(this.buffer, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public void require(long r1) throws IOException {
        if (request(r1) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public boolean request(long r5) throws IOException {
        if (r5 < 0) goto L17;
        if (this.closed == true) goto L15;
    L7:
        if (this.buffer.size >= r5) goto L12;
        if (this.source.read(this.buffer, 8192) != (-1)) goto L7;
        return false;
    L12:
        return true;
    L15:
        throw new IllegalStateException("closed");
    L17:
        throw new IllegalArgumentException("byteCount < 0: " + r5);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        require(1);
        return this.buffer.readByte();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r1) throws IOException {
        require(r1);
        return this.buffer.readByteString(r1);
    }

    @Override // okio.BufferedSource
    public int select(Options r7) throws IOException {
        if (this.closed == true) goto L15;
    L4:
        int r0 = this.buffer.selectPrefix(r7, true);
        if (r0 == (-1)) goto L6;
        if (r0 != (-2)) goto L12;
        if (this.source.read(this.buffer, 8192) != (-1)) goto L4;
        return -1;
    L12:
        this.buffer.skip(r7.byteStrings[r0].size());
        return r0;
    L6:
        return -1;
    L15:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r1) throws IOException {
        require(r1);
        return this.buffer.readByteArray(r1);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r7) throws IOException {
        require(r7.length);     // Catch: EOFException -> L5
        this.buffer.readFully(r7);
        return;
    L5:
        e = move-exception;
        int r1 = 0;
    L8:
        if (this.buffer.size <= 0) goto L14;
        Buffer r2 = this.buffer;
        int r3 = r2.read(r7, r1, (int) r2.size);
        if (r3 == (-1)) goto L13;
        r1 = r1 + r3;
        goto L8
    L13:
        throw new AssertionError();
    L14:
        throw e;
    }

    @Override // okio.BufferedSource
    public int read(byte[] r10, int r11, int r12) throws IOException {
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        if (this.buffer.size != 0) goto L9;
        if (this.source.read(this.buffer, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.buffer.read(r10, r11, (int) Math.min(r7, this.buffer.size));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r5) throws IOException {
        if (this.buffer.size != 0) goto L9;
        if (this.source.read(this.buffer, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.buffer.read(r5);
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r1, long r2) throws IOException {
        require(r2);     // Catch: EOFException -> L5
        this.buffer.readFully(r1, r2);
        return;
    L5:
        e = move-exception;
        r1.writeAll(this.buffer);
        throw e;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r9) throws IOException {
        if (r9 == null) goto L14;
        long r2 = 0;
    L5:
        if (this.source.read(this.buffer, 8192) == (-1)) goto L10;
        long r4 = this.buffer.completeSegmentByteCount();
        if (r4 <= 0) goto L5;
        r2 = r2 + r4;
        r9.write(this.buffer, r4);
        goto L5
    L10:
        if (this.buffer.size() <= 0) goto L20;
        long r3 = r2 + this.buffer.size();
        Buffer r8 = this.buffer;
        r9.write(r8, r8.size());
        return r3;
    L20:
        return r2;
    L14:
        throw new IllegalArgumentException("sink == null");
    }

    @Override // okio.BufferedSource
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r1) throws IOException {
        require(r1);
        return this.buffer.readUtf8(r1);
    }

    @Override // okio.BufferedSource
    public String readString(Charset r3) throws IOException {
        if (r3 == null) goto L6;
        this.buffer.writeAll(this.source);
        return this.buffer.readString(r3);
    L6:
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    public String readString(long r1, Charset r3) throws IOException {
        require(r1);
        if (r3 == null) goto L7;
        return this.buffer.readString(r1, r3);
    L7:
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws IOException {
        long r0 = indexOf((byte) 10);
        if (r0 != (-1)) goto L10;
        if (this.buffer.size != 0) goto L11;
        return null;
    L11:
        return readUtf8(this.buffer.size);
    L10:
        return this.buffer.readUtf8Line(r0);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r14) throws IOException {
        if (r14 < 0) goto L27;
        if (r14 != Long.MAX_VALUE) goto L7;
        long r5 = Long.MAX_VALUE;
    L8:
        long r7 = indexOf((byte) 10, 0, r5);
        if (r7 == (-1)) goto L13;
        return this.buffer.readUtf8Line(r7);
    L13:
        if (r5 < Long.MAX_VALUE) goto L15;
    L24:
        Buffer r6 = new Buffer();
        Buffer r0 = this.buffer;
        r0.copyTo(r6, 0, Math.min(32, r0.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), r14) + " content=" + r6.readByteString().hex() + 8230);
    L15:
        if (request(r5) == false) goto L24;
        if (this.buffer.getByte(r5 - 1) != 13) goto L24;
        if (request(1 + r5) == false) goto L24;
        if (this.buffer.getByte(r5) != 10) goto L24;
        return this.buffer.readUtf8Line(r5);
    L7:
        r5 = r14 + 1;
        goto L8
    L27:
        throw new IllegalArgumentException("limit < 0: " + r14);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws IOException {
        require(1);
        byte r0 = this.buffer.getByte(0);
        if ((r0 & 224) != 192) goto L6;
        require(2);
    L12:
        return this.buffer.readUtf8CodePoint();
    L6:
        if ((r0 & 240) != 224) goto L9;
        require(3);
        goto L12
    L9:
        if ((r0 & 248) != 240) goto L12;
        require(4);
        goto L12
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        require(2);
        return this.buffer.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2);
        return this.buffer.readShortLe();
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        require(4);
        return this.buffer.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4);
        return this.buffer.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws IOException {
        require(8);
        return this.buffer.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws IOException {
        require(8);
        return this.buffer.readLongLe();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws IOException {
        require(1);
        int r1 = 0;
    L3:
        int r2 = r1 + 1;
        if (request(r2) == false) goto L19;
        byte r3 = this.buffer.getByte(r1);
        if (r3 >= 48) goto L8;
    L9:
        if (r1 != 0) goto L14;
        if (r3 != 45) goto L14;
    L13:
        r1 = r2;
    L14:
        if (r1 != 0) goto L19;
        throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(r3)}));
    L8:
        if (r3 <= 57) goto L13;
    L19:
        return this.buffer.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        int r1 = 0;
    L3:
        int r2 = r1 + 1;
        if (request(r2) == false) goto L24;
        byte r3 = this.buffer.getByte(r1);
        if (r3 < 48) goto L10;
        if (r3 > 57) goto L10;
    L18:
        r1 = r2;
    L10:
        if (r3 < 97) goto L14;
        if (r3 <= 102) goto L18;
    L14:
        if (r3 < 65) goto L19;
        if (r3 <= 70) goto L18;
    L19:
        if (r1 != 0) goto L24;
        throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(r3)}));
    L24:
        return this.buffer.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public void skip(long r5) throws IOException {
        if (this.closed == true) goto L16;
    L5:
        if (r5 <= 0) goto L14;
        if (this.buffer.size != 0) goto L13;
        if (this.source.read(this.buffer, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r0 = Math.min(r5, this.buffer.size());
        this.buffer.skip(r0);
        r5 = r5 - r0;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) throws IOException {
        return indexOf(r7, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) throws IOException {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11, long r13) throws IOException {
        if (this.closed == true) goto L23;
        if (r11 < 0) goto L21;
        if (r13 < r11) goto L21;
    L9:
        if (r11 >= r13) goto L19;
        long r0 = this.buffer.indexOf(r10, r11, r13);
        if (r0 != (-1)) goto L12;
        long r1 = this.buffer.size;
        if (r1 >= r13) goto L19;
        if (this.source.read(this.buffer, 8192) == (-1)) goto L19;
        r11 = Math.max(r11, r1);
        goto L9
    L12:
        return r0;
    L19:
        return -1;
    L21:
        throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(r11), Long.valueOf(r13)}));
    L23:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r3) throws IOException {
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r9, long r10) throws IOException {
        if (this.closed == true) goto L12;
    L4:
        long r0 = this.buffer.indexOf(r9, r10);
        if (r0 != (-1)) goto L6;
        long r1 = this.buffer.size;
        if (this.source.read(this.buffer, 8192) == (-1)) goto L9;
        r10 = Math.max(r10, (r1 - ((long) r9.size())) + 1);
        goto L4
    L9:
        return -1;
    L6:
        return r0;
    L12:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r3) throws IOException {
        return indexOfElement(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r9, long r10) throws IOException {
        if (this.closed == true) goto L12;
    L4:
        long r0 = this.buffer.indexOfElement(r9, r10);
        if (r0 != (-1)) goto L6;
        long r1 = this.buffer.size;
        if (this.source.read(this.buffer, 8192) == (-1)) goto L9;
        r10 = Math.max(r10, r1);
        goto L4
    L9:
        return -1;
    L6:
        return r0;
    L12:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, ByteString r9) throws IOException {
        return rangeEquals(r7, r9, 0, r9.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, ByteString r9, int r10, int r11) throws IOException {
        if (this.closed == true) goto L24;
        if (r7 < 0) goto L22;
        if (r10 < 0) goto L22;
        if (r11 < 0) goto L22;
        if ((r9.size() - r10) < r11) goto L22;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L20;
        long r2 = ((long) r0) + r7;
        if (request(1 + r2) == false) goto L15;
        if (this.buffer.getByte(r2) != r9.getByte(r10 + r0)) goto L18;
        r0 = r0 + 1;
        goto L12
    L18:
        return false;
    L15:
        return false;
    L20:
        return true;
    L22:
        return false;
    L24:
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new AnonymousClass1(this);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        this.source.close();
        this.buffer.clear();
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }
}
