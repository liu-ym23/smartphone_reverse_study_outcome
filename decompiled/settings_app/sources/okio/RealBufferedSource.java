package okio;

import com.android.settings.DataUsageFragment;
import com.obric.capabilitykit.common.Ext;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.internal._BufferKt;

/* JADX INFO: compiled from: RealBufferedSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", DataUsageFragment.INTENT_EXTRA_LIMIT, Ext.KEY_REQUEST, "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public RealBufferedSource(Source r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.source = r2;
        this.bufferField = new Buffer();
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public int read(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "sink");
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public String readString(long r2, Charset r4) {
        Intrinsics.checkNotNullParameter(r4, "charset");
        require(r2);
        return this.bufferField.readString(r2, r4);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) {
        return indexOf(r7, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "targetBytes");
        return indexOfElement(r3, 0);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        return rangeEquals(r8, r10, 0, r10.size());
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new AnonymousClass1(this);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Source
    public long read(Buffer r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "sink");
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
        throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
    L5:
        r2 = false;
        goto L6
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

    @Override // okio.BufferedSource
    public void require(long r1) {
        if (request(r1) == false) goto L6;
        return;
    L6:
        throw new EOFException();
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
        throw new IllegalArgumentException(("byteCount < 0: " + r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r1) {
        require(r1);
        return this.bufferField.readByteString(r1);
    }

    @Override // okio.BufferedSource
    public int select(Options r9) {
        Intrinsics.checkNotNullParameter(r9, "options");
        if ((!this.closed) == false) goto L14;
    L4:
        int r0 = _BufferKt.selectPrefix(this.bufferField, r9, true);
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
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r1) {
        require(r1);
        return this.bufferField.readByteArray(r1);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r7) {
        Intrinsics.checkNotNullParameter(r7, "sink");
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
    public int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        long r7 = r12;
        _UtilKt.checkOffsetAndCount(r10.length, r11, r7);
        if (this.bufferField.size() != 0) goto L8;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L8;
        return -1;
    L8:
        return this.bufferField.read(r10, r11, (int) Math.min(r7, this.bufferField.size()));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r5) {
        Intrinsics.checkNotNullParameter(r5, "sink");
        if (this.bufferField.size() != 0) goto L9;
        if (this.source.read(this.bufferField, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.bufferField.read(r5);
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        require(r3);     // Catch: EOFException -> L6
        this.bufferField.readFully(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.writeAll(this.bufferField);
        throw e;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r9) {
        Intrinsics.checkNotNullParameter(r9, "sink");
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
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r1) {
        require(r1);
        return this.bufferField.readUtf8(r1);
    }

    @Override // okio.BufferedSource
    public String readString(Charset r3) {
        Intrinsics.checkNotNullParameter(r3, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(r3);
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long r0 = indexOf((byte) 10);
        if (r0 != (-1)) goto L9;
        if (this.bufferField.size() != 0) goto L10;
        return null;
    L10:
        return readUtf8(this.bufferField.size());
    L9:
        return _BufferKt.readUtf8Line(this.bufferField, r0);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r14) {
        if (r14 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L29;
        if (r14 != Long.MAX_VALUE) goto L10;
        long r5 = Long.MAX_VALUE;
    L11:
        long r7 = indexOf((byte) 10, 0, r5);
        if (r7 == (-1)) goto L15;
        return _BufferKt.readUtf8Line(this.bufferField, r7);
    L15:
        if (r5 < Long.MAX_VALUE) goto L17;
    L26:
        Buffer r6 = new Buffer();
        Buffer r1 = this.bufferField;
        r1.copyTo(r6, 0, Math.min(32, r1.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), r14) + " content=" + r6.readByteString().hex() + 8230);
    L17:
        if (request(r5) == false) goto L26;
        if (this.bufferField.getByte(r5 - 1) != 13) goto L26;
        if (request(1 + r5) == false) goto L26;
        if (this.bufferField.getByte(r5) != 10) goto L26;
        return _BufferKt.readUtf8Line(this.bufferField, r5);
    L10:
        r5 = r14 + 1;
        goto L11
    L29:
        throw new IllegalArgumentException(("limit < 0: " + r14).toString());
    L5:
        r0 = false;
        goto L6
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
    public long readDecimalLong() {
        require(1);
        long r4 = 0;
    L3:
        long r6 = r4 + 1;
        if (request(r6) == false) goto L20;
        byte r8 = this.bufferField.getByte(r4);
        if (r8 < 48) goto L10;
        if (r8 > 57) goto L10;
    L14:
        r4 = r6;
    L10:
        if (r4 != 0) goto L15;
        if (r8 == 45) goto L14;
    L15:
        if (r4 != 0) goto L20;
        StringBuilder r0 = new StringBuilder("Expected a digit or '-' but was 0x");
        String r1 = Integer.toString(r8, CharsKt.checkRadix(CharsKt.checkRadix(16)));
        Intrinsics.checkNotNullExpressionValue(r1, "toString(this, checkRadix(radix))");
        throw new NumberFormatException(r0.append(r1).toString());
    L20:
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        require(1);
        int r0 = 0;
    L3:
        int r1 = r0 + 1;
        if (request(r1) == false) goto L24;
        byte r2 = this.bufferField.getByte(r0);
        if (r2 < 48) goto L10;
        if (r2 > 57) goto L10;
    L18:
        r0 = r1;
    L10:
        if (r2 < 97) goto L14;
        if (r2 <= 102) goto L18;
    L14:
        if (r2 < 65) goto L19;
        if (r2 <= 70) goto L18;
    L19:
        if (r0 != 0) goto L24;
        StringBuilder r3 = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
        String r4 = Integer.toString(r2, CharsKt.checkRadix(CharsKt.checkRadix(16)));
        Intrinsics.checkNotNullExpressionValue(r4, "toString(this, checkRadix(radix))");
        throw new NumberFormatException(r3.append(r4).toString());
    L24:
        return this.bufferField.readHexadecimalUnsignedLong();
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

    @Override // okio.BufferedSource
    public long indexOf(byte r11, long r12, long r14) {
        boolean r1 = true;
        if ((!this.closed) == false) goto L26;
        if (0 <= r12) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L24;
    L12:
        if (r12 >= r14) goto L33;
        long r0 = this.bufferField.indexOf(r11, r12, r14);
        if (r0 != (-1)) goto L22;
        long r2 = this.bufferField.size();
        if (r2 >= r14) goto L31;
        if (this.source.read(this.bufferField, 8192) == (-1)) goto L32;
        r12 = Math.max(r12, r2);
        goto L12
    L32:
        return -1;
    L31:
        return -1;
    L22:
        return r0;
    L33:
        return -1;
    L24:
        throw new IllegalArgumentException(("fromIndex=" + r12 + " toIndex=" + r14).toString());
    L7:
        if (r12 > r14) goto L9;
    L26:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "bytes");
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
    public long indexOfElement(ByteString r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "targetBytes");
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

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, ByteString r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        if ((!this.closed) == false) goto L23;
        if (r8 < 0) goto L21;
        if (r11 < 0) goto L21;
        if (r12 < 0) goto L21;
        if ((r10.size() - r11) < r12) goto L21;
        int r0 = 0;
    L12:
        if (r0 >= r12) goto L27;
        long r3 = ((long) r0) + r8;
        if (request(1 + r3) == false) goto L21;
        if (this.bufferField.getByte(r3) != r10.getByte(r11 + r0)) goto L21;
        r0 = r0 + 1;
        goto L12
    L27:
        return true;
    L21:
        return false;
    L23:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == true) goto L6;
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
        return;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }
}
