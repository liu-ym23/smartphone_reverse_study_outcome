package okio;

import a.a;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealBufferedSource implements BufferedSource {

    @JvmField
    @NotNull
    public final Buffer bufferField;

    @JvmField
    public boolean closed;

    @JvmField
    @NotNull
    public final Source source;

    public RealBufferedSource(@NotNull Source r2) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        this.source = r2;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == true) goto L7;
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
        return;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if ((!this.closed) == false) goto L12;
        if (this.bufferField.exhausted() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) {
        return indexOf(r7, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString r3) {
        Intrinsics.f(r3, "targetBytes");
        return indexOfElement(r3, 0);
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new AnonymousClass1(this);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, @NotNull ByteString r10) {
        Intrinsics.f(r10, "bytes");
        return rangeEquals(r8, r10, 0, r10.size());
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] r3) {
        Intrinsics.f(r3, "sink");
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink r9) {
        Intrinsics.f(r9, "sink");
        long r2 = 0;
    L4:
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L9;
        long r4 = this.bufferField.completeSegmentByteCount();
        if (r4 <= 0) goto L4;
        r2 = r2 + r4;
        r9.write(this.bufferField, r4);
        goto L4
    L9:
        if (this.bufferField.size() <= 0) goto L17;
        long r3 = r2 + this.bufferField.size();
        Buffer r8 = this.bufferField;
        r9.write(r8, r8.size());
        return r3;
    L17:
        return r2;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        require(1);
        long r4 = 0;
    L3:
        long r6 = r4 + 1;
        if (request(r6) == false) goto L20;
        byte r8 = this.bufferField.getByte(r4);
        if (r8 < ((byte) 48)) goto L10;
        if (r8 > ((byte) 57)) goto L10;
    L14:
        r4 = r6;
    L10:
        if (r4 != 0) goto L15;
        if (r8 == ((byte) 45)) goto L14;
    L15:
        if (r4 != 0) goto L20;
        CharsKt.c(16);
        CharsKt.c(16);
        String r0 = Integer.toString(r8, 16);
        Intrinsics.e(r0, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x".concat(r0));
    L20:
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] r7) {
        Intrinsics.f(r7, "sink");
        require(r7.length);     // Catch: EOFException -> L6
        this.bufferField.readFully(r7);
        return;
    L6:
        e = move-exception;
        int r1 = 0;
    L9:
        if (this.bufferField.size() <= 0) goto L15;
        Buffer r2 = this.bufferField;
        int r3 = r2.read(r7, r1, (int) r2.size());
        if (r3 == (-1)) goto L14;
        r1 = r1 + r3;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        require(1);
        int r0 = 0;
    L3:
        int r1 = r0 + 1;
        if (request(r1) == false) goto L24;
        byte r2 = this.bufferField.getByte(r0);
        if (r2 < ((byte) 48)) goto L10;
        if (r2 > ((byte) 57)) goto L10;
    L18:
        r0 = r1;
    L10:
        if (r2 < ((byte) 97)) goto L14;
        if (r2 <= ((byte) HttpStatus.SC_PROCESSING)) goto L18;
    L14:
        if (r2 < ((byte) 65)) goto L19;
        if (r2 <= ((byte) 70)) goto L18;
    L19:
        if (r0 != 0) goto L24;
        CharsKt.c(16);
        CharsKt.c(16);
        String r3 = Integer.toString(r2, 16);
        Intrinsics.e(r3, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(r3));
    L24:
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long r2, @NotNull Charset r4) {
        Intrinsics.f(r4, "charset");
        require(r2);
        return this.bufferField.readString(r2, r4);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        require(1);
        byte r0 = this.bufferField.getByte(0);
        if ((r0 & 224) != 192) goto L6;
        require(2);
    L12:
        return this.bufferField.readUtf8CodePoint();
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
    @Nullable
    public String readUtf8Line() {
        long r0 = indexOf((byte) 10);
        if (r0 != (-1)) goto L9;
        if (this.bufferField.size() != 0) goto L10;
        return null;
    L10:
        return readUtf8(this.bufferField.size());
    L9:
        return BufferKt.readUtf8Line(this.bufferField, r0);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long r8) {
        if (r8 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        if ((!this.closed) == false) goto L17;
    L10:
        if (this.bufferField.size() >= r8) goto L15;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L10;
        return false;
    L15:
        return true;
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public void require(long r1) {
        if (request(r1) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options r9) {
        Intrinsics.f(r9, "options");
        if ((!this.closed) == false) goto L14;
    L4:
        int r0 = BufferKt.selectPrefix(this.bufferField, r9, true);
        if (r0 != (-2)) goto L6;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L4;
    L18:
        return -1;
    L6:
        if (r0 == (-1)) goto L18;
        this.bufferField.skip(r9.getByteStrings$okio()[r0].size());
        return r0;
    L14:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public void skip(long r5) {
        if ((!this.closed) == false) goto L16;
    L5:
        if (r5 <= 0) goto L14;
        if (this.bufferField.size() != 0) goto L13;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r0 = Math.min(r5, this.bufferField.size());
        this.bufferField.skip(r0);
        r5 = r5 - r0;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString r9, long r10) {
        Intrinsics.f(r9, "targetBytes");
        if ((!this.closed) == false) goto L13;
    L4:
        long r0 = this.bufferField.indexOfElement(r9, r10);
        if (r0 != (-1)) goto L16;
        long r1 = this.bufferField.size();
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L10;
        r10 = Math.max(r10, r1);
        goto L4
    L10:
        return -1;
    L16:
        return r0;
    L13:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Source
    public long read(@NotNull Buffer r5, long r6) {
        Intrinsics.f(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L19;
        if ((!this.closed) == false) goto L17;
        if (this.bufferField.size() != 0) goto L15;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L15;
        return -1;
    L15:
        return this.bufferField.read(r5, Math.min(r6, this.bufferField.size()));
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long r14) {
        if (r14 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L29;
        if (r14 != Long.MAX_VALUE) goto L10;
        long r5 = Long.MAX_VALUE;
    L11:
        byte r2 = (byte) 10;
        long r7 = indexOf(r2, 0, r5);
        if (r7 == (-1)) goto L15;
        return BufferKt.readUtf8Line(this.bufferField, r7);
    L15:
        if (r5 < Long.MAX_VALUE) goto L17;
    L26:
        Buffer r6 = new Buffer();
        Buffer r1 = this.bufferField;
        r1.copyTo(r6, 0, Math.min(32, r1.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), r14) + " content=" + r6.readByteString().hex() + "…");
    L17:
        if (request(r5) == false) goto L26;
        if (this.bufferField.getByte(r5 - 1) != ((byte) 13)) goto L26;
        if (request(1 + r5) == false) goto L26;
        if (this.bufferField.getByte(r5) != r2) goto L26;
        return BufferKt.readUtf8Line(this.bufferField, r5);
    L10:
        r5 = r14 + 1;
        goto L11
    L29:
        throw new IllegalArgumentException(a.h("limit < 0: ", r14).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString r3) {
        Intrinsics.f(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, @NotNull ByteString r10, int r11, int r12) {
        Intrinsics.f(r10, "bytes");
        if ((!this.closed) == false) goto L22;
        if (r8 < 0) goto L20;
        if (r11 < 0) goto L20;
        if (r12 < 0) goto L20;
        if ((r10.size() - r11) < r12) goto L20;
        int r0 = 0;
    L12:
        if (r0 >= r12) goto L26;
        long r3 = ((long) r0) + r8;
        if (request(1 + r3) == false) goto L20;
        if (this.bufferField.getByte(r3) != r10.getByte(r11 + r0)) goto L20;
        r0 = r0 + 1;
        goto L12
    L26:
        return true;
    L20:
        return false;
    L22:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r11, long r12, long r14) {
        boolean r1 = true;
        if ((!this.closed) == false) goto L27;
        if (0 <= r12) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == true) goto L13;
        StringBuilder r10 = a.s("fromIndex=", r12, " toIndex=");
        r10.append(r14);
        throw new IllegalArgumentException(r10.toString().toString());
    L13:
        if (r12 >= r14) goto L34;
        long r0 = this.bufferField.indexOf(r11, r12, r14);
        if (r0 != (-1)) goto L23;
        long r2 = this.bufferField.size();
        if (r2 >= r14) goto L32;
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L33;
        r12 = Math.max(r12, r2);
        goto L13
    L33:
        return -1;
    L32:
        return -1;
    L23:
        return r0;
    L34:
        return -1;
    L8:
        if (r14 < r12) goto L10;
    L27:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset r3) {
        Intrinsics.f(r3, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(r3);
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long r1) {
        require(r1);
        return this.bufferField.readByteArray(r1);
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long r1) {
        require(r1);
        return this.bufferField.readByteString(r1);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long r1) {
        require(r1);
        return this.bufferField.readUtf8(r1);
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer r2, long r3) {
        Intrinsics.f(r2, "sink");
        require(r3);     // Catch: EOFException -> L6
        this.bufferField.readFully(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.writeAll(this.bufferField);
        throw e;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString r9, long r10) {
        Intrinsics.f(r9, "bytes");
        if ((!this.closed) == false) goto L13;
    L4:
        long r0 = this.bufferField.indexOf(r9, r10);
        if (r0 != (-1)) goto L16;
        long r1 = this.bufferField.size();
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L10;
        r10 = Math.max(r10, (r1 - ((long) r9.size())) + 1);
        goto L4
    L10:
        return -1;
    L16:
        return r0;
    L13:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] r10, int r11, int r12) {
        Intrinsics.f(r10, "sink");
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        if (this.bufferField.size() != 0) goto L8;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L8;
        return -1;
    L8:
        return this.bufferField.read(r10, r11, (int) Math.min(r7, this.bufferField.size()));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer r5) {
        Intrinsics.f(r5, "sink");
        if (this.bufferField.size() != 0) goto L9;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.bufferField.read(r5);
    }
}
