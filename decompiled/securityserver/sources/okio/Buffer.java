package okio;

import a.a;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.sysoptimizer.StackLeakChecker;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;
import okio.internal.BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    @JvmField
    @Nullable
    public Segment head;
    private long size;

    @Metadata
    public static final class UnsafeCursor implements Closeable {

        @JvmField
        @Nullable
        public Buffer buffer;

        @JvmField
        @Nullable
        public byte[] data;

        @JvmField
        public int end;

        @JvmField
        public long offset;

        @JvmField
        public boolean readWrite;
        private Segment segment;

        @JvmField
        public int start;

        public UnsafeCursor() {
            this.offset = -1;
            this.start = -1;
            this.end = -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.buffer = null;
            this.segment = null;
            this.offset = -1;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return;
        L10:
            throw new IllegalStateException("not attached to a buffer".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final long expandBuffer(int r10) {
            boolean r0 = false;
            if (r10 <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L24;
            if (r10 > 8192) goto L10;
            r0 = true;
        L10:
            if (r0 == false) goto L22;
            Buffer r1 = this.buffer;
            if (r1 == null) goto L20;
            if (this.readWrite == false) goto L18;
            long r3 = r1.size();
            Segment r11 = r1.writableSegment$okio(r10);
            int r4 = 8192 - r11.limit;
            r11.limit = 8192;
            long r5 = r4;
            r1.setSize$okio(r3 + r5);
            this.segment = r11;
            this.offset = r3;
            this.data = r11.data;
            this.start = 8192 - r4;
            this.end = 8192;
            return r5;
        L18:
            throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        L20:
            throw new IllegalStateException("not attached to a buffer".toString());
        L22:
            throw new IllegalArgumentException(a.e(r10, "minByteCount > Segment.SIZE: ").toString());
        L24:
            throw new IllegalArgumentException(a.e(r10, "minByteCount <= 0: ").toString());
        L5:
            r2 = false;
            goto L6
        }

        public final int next() {
            long r0 = this.offset;
            Buffer r2 = this.buffer;
            Intrinsics.c(r2);
            if (r0 == r2.size()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L14;
            long r3 = this.offset;
            if (r3 != (-1)) goto L11;
            long r4 = 0;
        L12:
            return seek(r4);
        L11:
            r4 = r3 + ((long) (this.end - this.start));
            goto L12
        L14:
            throw new IllegalStateException("no more bytes".toString());
        L5:
            r1 = false;
            goto L6
        }

        public final long resizeBuffer(long r17) {
            Buffer r3 = this.buffer;
            if (r3 == null) goto L36;
            if (this.readWrite == false) goto L34;
            long r4 = r3.size();
            int r8 = 1;
            if (r17 <= r4) goto L9;
            if (r17 <= r4) goto L31;
            long r11 = r17 - r4;
            boolean r6 = true;
        L26:
            if (r11 <= 0) goto L31;
            Segment r13 = r3.writableSegment$okio(r8);
            int r14 = (int) Math.min(r11, 8192 - r13.limit);
            int r15 = r13.limit + r14;
            r13.limit = r15;
            r11 = r11 - ((long) r14);
            if (r6 == false) goto L30;
            this.segment = r13;
            this.offset = r4;
            this.data = r13.data;
            this.start = r15 - r14;
            this.end = r15;
            r6 = false;
        L30:
            r8 = 1;
        L31:
            r3.setSize$okio(r17);
            return r4;
        L9:
            if (r17 < 0) goto L11;
            boolean r7 = true;
        L12:
            if (r7 == false) goto L22;
            long r9 = r4 - r17;
        L15:
            if (r9 <= 0) goto L20;
            Segment r10 = r3.head;
            Intrinsics.c(r10);
            Segment r12 = r10.prev;
            Intrinsics.c(r12);
            int r16 = r12.limit;
            long r18 = r16 - r12.pos;
            if (r18 > r9) goto L19;
            r3.head = r12.pop();
            SegmentPool.recycle(r12);
            r9 = r9 - r18;
            goto L15
        L19:
            r12.limit = r16 - ((int) r9);
        L20:
            this.segment = null;
            this.offset = r17;
            this.data = null;
            this.start = -1;
            this.end = -1;
            goto L31
        L22:
            throw new IllegalArgumentException(a.h("newSize < 0: ", r17).toString());
        L11:
            r7 = false;
            goto L12
        L34:
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        L36:
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int seek(long r12) {
            Buffer r0 = this.buffer;
            if (r0 == null) goto L44;
            if (r12 < (-1)) goto L42;
            if (r12 > r0.size()) goto L42;
            if (r12 != (-1)) goto L11;
        L39:
            this.segment = null;
            this.offset = r12;
            this.data = null;
            this.start = -1;
            this.end = -1;
            return -1;
        L11:
            if (r12 == r0.size()) goto L39;
            long r1 = r0.size();
            Segment r3 = r0.head;
            Segment r4 = this.segment;
            long r5 = 0;
            if (r4 == null) goto L19;
            long r7 = this.offset;
            int r9 = this.start;
            Intrinsics.c(r4);
            long r8 = r7 - ((long) (r9 - r4.pos));
            if (r8 <= r12) goto L18;
            Segment r6 = r3;
            r3 = this.segment;
            r1 = r8;
        L21:
            if ((r1 - r12) <= (r12 - r5)) goto L26;
        L22:
            Intrinsics.c(r6);
            int r2 = r6.limit;
            int r10 = r6.pos;
            if (r12 < (((long) (r2 - r10)) + r5)) goto L30;
            r5 = r5 + ((long) (r2 - r10));
            r6 = r6.next;
        L30:
            if (this.readWrite == false) goto L37;
            Intrinsics.c(r6);
            if (r6.shared == false) goto L37;
            Segment r11 = r6.unsharedCopy();
            if (r0.head != r6) goto L36;
            r0.head = r11;
        L36:
            r6 = r6.push(r11);
            Segment r13 = r6.prev;
            Intrinsics.c(r13);
            r13.pop();
        L37:
            this.segment = r6;
            this.offset = r12;
            Intrinsics.c(r6);
            this.data = r6.data;
            int r14 = r6.pos + ((int) (r12 - r5));
            this.start = r14;
            int r15 = r6.limit;
            this.end = r15;
            return r15 - r14;
        L26:
            if (r1 <= r12) goto L28;
            Intrinsics.c(r3);
            r3 = r3.prev;
            Intrinsics.c(r3);
            r1 = r1 - ((long) (r3.limit - r3.pos));
            goto L26
        L28:
            r5 = r1;
            r6 = r3;
            goto L30
        L18:
            r6 = this.segment;
            r5 = r8;
            goto L21
        L19:
            r6 = r3;
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(r12), Long.valueOf(r0.size())}, 2)));
        L44:
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public Buffer() {
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r0, Buffer r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.copyTo(r1, r2);
    }

    private final ByteString digest(String r5) {
        MessageDigest r6 = MessageDigest.getInstance(r5);
        Segment r4 = this.head;
        if (r4 == null) goto L7;
        byte[] r0 = r4.data;
        int r1 = r4.pos;
        r6.update(r0, r1, r4.limit - r1);
        Segment r2 = r4.next;
        Intrinsics.c(r2);
    L5:
        if (r2 == r4) goto L7;
        byte[] r3 = r2.data;
        int r7 = r2.pos;
        r6.update(r3, r7, r2.limit - r7);
        r2 = r2.next;
        Intrinsics.c(r2);
    L7:
        byte[] r8 = r6.digest();
        Intrinsics.e(r8, "messageDigest.digest()");
        return new ByteString(r8);
    }

    private final ByteString hmac(String r4, ByteString r5) {
        Mac r0 = Mac.getInstance(r4);     // Catch: InvalidKeyException -> L7
        r0.init(new SecretKeySpec(r5.internalArray$okio(), r4));     // Catch: InvalidKeyException -> L7
        Segment r3 = this.head;     // Catch: InvalidKeyException -> L7
        if (r3 == null) goto L9;
        byte[] r6 = r3.data;     // Catch: InvalidKeyException -> L7
        int r7 = r3.pos;     // Catch: InvalidKeyException -> L7
        r0.update(r6, r7, r3.limit - r7);     // Catch: InvalidKeyException -> L7
        Segment r8 = r3.next;     // Catch: InvalidKeyException -> L7
        Intrinsics.c(r8);     // Catch: InvalidKeyException -> L7
    L5:
        if (r8 == r3) goto L9;
        byte[] r9 = r8.data;     // Catch: InvalidKeyException -> L7
        int r1 = r8.pos;     // Catch: InvalidKeyException -> L7
        r0.update(r9, r1, r8.limit - r1);     // Catch: InvalidKeyException -> L7
        r8 = r8.next;     // Catch: InvalidKeyException -> L7
        Intrinsics.c(r8);     // Catch: InvalidKeyException -> L7
    L9:
        byte[] r10 = r0.doFinal();     // Catch: InvalidKeyException -> L7
        Intrinsics.e(r10, "mac.doFinal()");     // Catch: InvalidKeyException -> L7
        return new ByteString(r10);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer r0, UnsafeCursor r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = new UnsafeCursor();
    L6:
        return r0.readAndWriteUnsafe(r1);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer r0, UnsafeCursor r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = new UnsafeCursor();
    L6:
        return r0.readUnsafe(r1);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer r0, OutputStream r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.size;
    L6:
        return r0.writeTo(r1, r2);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m181deprecated_getByte(long r1) {
        return getByte(r1);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m182deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m183clone();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long r0 = size();
        if (r0 == 0) goto L12;
        Segment r5 = this.head;
        Intrinsics.c(r5);
        Segment r6 = r5.prev;
        Intrinsics.c(r6);
        int r2 = r6.limit;
        if (r2 >= 8192) goto L11;
        if (r6.owner == false) goto L11;
        r0 = r0 - ((long) (r2 - r6.pos));
    L11:
        return r0;
    L12:
        return 0;
    }

    @NotNull
    public final Buffer copy() {
        Buffer r0 = new Buffer();
        if (size() == 0) goto L9;
        Segment r1 = this.head;
        Intrinsics.c(r1);
        Segment r2 = r1.sharedCopy();
        r0.head = r2;
        r2.prev = r2;
        r2.next = r2;
        Segment r3 = r1.next;
    L6:
        if (r3 == r1) goto L8;
        Segment r4 = r2.prev;
        Intrinsics.c(r4);
        Intrinsics.c(r3);
        r4.push(r3.sharedCopy());
        r3 = r3.next;
        goto L6
    L8:
        r0.setSize$okio(size());
    L9:
        return r0;
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream r9) {
        return copyTo$default(this, r9, 0, 0, 6, null);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(@Nullable Object r19) {
        if (this != r19) goto L6;
        return true;
    L6:
        if ((r19 instanceof Buffer) == false) goto L31;
        Buffer r1 = (Buffer) r19;
        if (size() != r1.size()) goto L31;
        if (size() == 0) goto L38;
        Segment r3 = this.head;
        Intrinsics.c(r3);
        Segment r2 = r1.head;
        Intrinsics.c(r2);
        int r5 = r3.pos;
        int r6 = r2.pos;
        long r9 = 0;
    L16:
        if (r9 >= size()) goto L39;
        long r11 = Math.min(r3.limit - r5, r2.limit - r6);
        long r13 = 0;
    L19:
        if (r13 >= r11) goto L25;
        int r16 = r5 + 1;
        int r17 = r6 + 1;
        if (r3.data[r5] != r2.data[r6]) goto L31;
        r13 = r13 + 1;
        r5 = r16;
        r6 = r17;
        goto L19
    L25:
        if (r5 != r3.limit) goto L28;
        r3 = r3.next;
        Intrinsics.c(r3);
        r5 = r3.pos;
    L28:
        if (r6 != r2.limit) goto L30;
        r2 = r2.next;
        Intrinsics.c(r2);
        r6 = r2.pos;
    L30:
        r9 = r9 + r11;
        goto L16
    L39:
        return true;
    L38:
        return true;
    L31:
        return false;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @JvmName
    public final byte getByte(long r7) {
        Util.checkOffsetAndCount(size(), r7, 1);
        Segment r0 = this.head;
        if (r0 != null) goto L5;
        Intrinsics.c(null);
        throw null;
    L5:
        if ((size() - r7) >= r7) goto L11;
        long r1 = size();
    L8:
        if (r1 <= r7) goto L21;
        r0 = r0.prev;
        Intrinsics.c(r0);
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L8
    L21:
        return r0.data[(int) ((((long) r0.pos) + r7) - r1)];
    L11:
        long r2 = 0;
    L12:
        int r6 = r0.limit;
        int r3 = r0.pos;
        long r4 = ((long) (r6 - r3)) + r2;
        if (r4 > r7) goto L15;
        r0 = r0.next;
        Intrinsics.c(r0);
        r2 = r4;
        goto L12
    L15:
        return r0.data[(int) ((((long) r3) + r7) - r2)];
    }

    public int hashCode() {
        Segment r0 = this.head;
        if (r0 == null) goto L11;
        int r1 = 1;
    L5:
        int r2 = r0.pos;
        int r3 = r0.limit;
    L6:
        if (r2 >= r3) goto L8;
        r1 = (r1 * 31) + r0.data[r2];
        r2 = r2 + 1;
        goto L6
    L8:
        r0 = r0.next;
        Intrinsics.c(r0);
        if (r0 != this.head) goto L5;
        return r1;
    L11:
        return 0;
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString r2) {
        Intrinsics.f(r2, "key");
        return hmac("HmacSHA1", r2);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString r2) {
        Intrinsics.f(r2, "key");
        return hmac("HmacSHA256", r2);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString r2) {
        Intrinsics.f(r2, "key");
        return hmac("HmacSHA512", r2);
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
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new C00471(this);
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

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer r7) {
        Intrinsics.f(r7, "sink");
        Segment r0 = this.head;
        if (r0 == null) goto L8;
        int r1 = Math.min(r7.remaining(), r0.limit - r0.pos);
        r7.put(r0.data, r0.pos, r1);
        int r8 = r0.pos + r1;
        r0.pos = r8;
        this.size -= (long) r1;
        if (r8 != r0.limit) goto L7;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L7:
        return r1;
    L8:
        return -1;
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink r5) {
        Intrinsics.f(r5, "sink");
        long r0 = size();
        if (r0 <= 0) goto L5;
        r5.write(this, r0);
    L5:
        return r0;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (size() == 0) goto L10;
        Segment r0 = this.head;
        Intrinsics.c(r0);
        int r1 = r0.pos;
        int r2 = r0.limit;
        int r4 = r1 + 1;
        byte r3 = r0.data[r1];
        setSize$okio(size() - 1);
        if (r4 != r2) goto L7;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L8:
        return r3;
    L7:
        r0.pos = r4;
        goto L8
    L10:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        if (size() == 0) goto L44;
        int r0 = 0;
        boolean r1 = false;
        long r5 = -7;
        long r3 = 0;
        boolean r2 = false;
    L5:
        Segment r7 = this.head;
        Intrinsics.c(r7);
        byte[] r8 = r7.data;
        int r9 = r7.pos;
        int r10 = r7.limit;
    L6:
        if (r9 >= r10) goto L32;
        byte r11 = r8[r9];
        byte r12 = (byte) 48;
        if (r11 < r12) goto L24;
        if (r11 > ((byte) 57)) goto L24;
        int r13 = r12 - r11;
        if (r3 < BufferKt.OVERFLOW_ZONE) goto L18;
        if (r3 == BufferKt.OVERFLOW_ZONE) goto L15;
    L17:
        r3 = (r3 * 10) + ((long) r13);
    L27:
        r9 = r9 + 1;
        r0 = r0 + 1;
        goto L6
    L15:
        if (r13 >= r5) goto L17;
    L18:
        Buffer r15 = new Buffer().writeDecimalLong(r3).writeByte(r11);
        if (r1 == true) goto L22;
        r15.readByte();
    L22:
        throw new NumberFormatException("Number too large: " + r15.readUtf8());
    L24:
        if (r11 != ((byte) 45)) goto L28;
        if (r0 != 0) goto L28;
        r5 = r5 - 1;
        r1 = true;
    L28:
        if (r0 == 0) goto L31;
        r2 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Util.toHexString(r11));
    L32:
        if (r9 != r10) goto L34;
        this.head = r7.pop();
        SegmentPool.recycle(r7);
    L35:
        if (r2 == true) goto L38;
        if (this.head != null) goto L5;
    L38:
        setSize$okio(size() - ((long) r0));
        if (r1 == false) goto L42;
        return r3;
    L42:
        return -r3;
    L34:
        r7.pos = r9;
        goto L35
    L44:
        throw new EOFException();
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream r4) {
        Intrinsics.f(r4, "input");
        readFrom(r4, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer r3, long r4) {
        Intrinsics.f(r3, "sink");
        if (size() < r4) goto L6;
        r3.write(this, r4);
        return;
    L6:
        r3.write(this, size());
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        if (size() == 0) goto L40;
        int r0 = 0;
        boolean r1 = false;
        long r4 = 0;
    L5:
        Segment r6 = this.head;
        Intrinsics.c(r6);
        byte[] r7 = r6.data;
        int r8 = r6.pos;
        int r9 = r6.limit;
    L6:
        if (r8 >= r9) goto L31;
        byte r10 = r7[r8];
        byte r11 = (byte) 48;
        if (r10 >= r11) goto L10;
    L12:
        byte r12 = (byte) 97;
        if (r10 >= r12) goto L15;
    L17:
        r12 = (byte) 65;
        if (r10 < r12) goto L27;
        if (r10 > ((byte) 70)) goto L27;
    L16:
        int r13 = (r10 - r12) + 10;
    L23:
        if (((-1152921504606846976L) & r4) != 0) goto L26;
        r4 = (r4 << 4) | ((long) r13);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L6
    L26:
        throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r4).writeByte(r10).readUtf8());
    L27:
        if (r0 == 0) goto L30;
        r1 = true;
        goto L31
    L30:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Util.toHexString(r10));
    L15:
        if (r10 > ((byte) HttpStatus.SC_PROCESSING)) goto L17;
    L10:
        if (r10 > ((byte) 57)) goto L12;
        r13 = r10 - r11;
    L31:
        if (r8 != r9) goto L33;
        this.head = r6.pop();
        SegmentPool.recycle(r6);
    L34:
        if (r1 == true) goto L37;
        if (this.head != null) goto L5;
    L37:
        setSize$okio(size() - ((long) r0));
        return r4;
    L33:
        r6.pos = r8;
        goto L34
    L40:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (size() < 4) goto L14;
        Segment r0 = this.head;
        Intrinsics.c(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 4) goto L15;
        byte[] r5 = r0.data;
        int r6 = ((r5[r1 + 1] & 255) << 16) | ((r5[r1] & 255) << 24);
        int r7 = r1 + 3;
        int r8 = r6 | ((r5[r1 + 2] & 255) << 8);
        int r2 = r1 + 4;
        int r9 = (r5[r7] & 255) | r8;
        setSize$okio(size() - 4);
        if (r2 != r4) goto L10;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r9;
    L10:
        r0.pos = r2;
        goto L12
    L15:
        return (readByte() & 255) | ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        if (size() < 8) goto L14;
        Segment r0 = this.head;
        Intrinsics.c(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 8) goto L15;
        byte[] r5 = r0.data;
        int r8 = r1 + 7;
        long r6 = (((((((((long) r5[r1]) & 255) << 56) | ((((long) r5[r1 + 1]) & 255) << 48)) | ((((long) r5[r1 + 2]) & 255) << 40)) | ((((long) r5[r1 + 3]) & 255) << 32)) | ((((long) r5[r1 + 4]) & 255) << 24)) | ((((long) r5[r1 + 5]) & 255) << 16)) | ((((long) r5[r1 + 6]) & 255) << 8);
        int r2 = r1 + 8;
        long r7 = r6 | (((long) r5[r8]) & 255);
        setSize$okio(size() - 8);
        if (r2 != r4) goto L10;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return r7;
    L10:
        r0.pos = r2;
        goto L12
    L15:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (size() < 2) goto L14;
        Segment r0 = this.head;
        Intrinsics.c(r0);
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) >= 2) goto L7;
        int r2 = (readByte() & 255) << 8;
        return (short) ((readByte() & 255) | r2);
    L7:
        byte[] r5 = r0.data;
        int r7 = r1 + 1;
        int r8 = (r5[r1] & 255) << 8;
        int r3 = r1 + 2;
        int r6 = (r5[r7] & 255) | r8;
        setSize$okio(size() - 2);
        if (r3 != r4) goto L10;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        return (short) r6;
    L10:
        r0.pos = r3;
        goto L12
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset r3) {
        Intrinsics.f(r3, "charset");
        return readString(this.size, r3);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        return readString(this.size, Charsets.f354a);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        if (size() == 0) goto L40;
        byte r0 = getByte(0);
        int r2 = 1;
        if ((r0 & 128) != 0) goto L8;
        int r1 = r0 & 127;
        int r6 = 0;
        int r5 = 1;
    L16:
        long r9 = r5;
        if (size() < r9) goto L35;
    L18:
        if (r2 >= r5) goto L23;
        long r7 = r2;
        byte r3 = getByte(r7);
        if ((r3 & 192) != 128) goto L22;
        r1 = (r1 << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
        r2 = r2 + 1;
        goto L18
    L22:
        skip(r7);
        return Utf8.REPLACEMENT_CODE_POINT;
    L23:
        skip(r9);
        if (r1 <= 1114111) goto L27;
        return Utf8.REPLACEMENT_CODE_POINT;
    L27:
        if (55296 <= r1) goto L30;
    L32:
        if (r1 >= r6) goto L44;
        return Utf8.REPLACEMENT_CODE_POINT;
    L44:
        return r1;
    L30:
        if (57343 < r1) goto L32;
        return Utf8.REPLACEMENT_CODE_POINT;
    L35:
        StringBuilder r4 = a.p(r5, "size < ", ": ");
        r4.append(size());
        r4.append(" (to read code point prefixed 0x");
        r4.append(Util.toHexString(r0));
        r4.append(')');
        throw new EOFException(r4.toString());
    L8:
        if ((r0 & 224) != 192) goto L11;
        r1 = r0 & 31;
        r5 = 2;
        r6 = 128;
        goto L16
    L11:
        if ((r0 & 240) != 224) goto L14;
        r1 = r0 & 15;
        r5 = 3;
        r6 = 2048;
        goto L16
    L14:
        if ((r0 & 248) != 240) goto L37;
        r1 = r0 & 7;
        r5 = 4;
        r6 = 65536;
        goto L16
    L37:
        skip(1);
        return Utf8.REPLACEMENT_CODE_POINT;
    L40:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long r0 = indexOf((byte) 10);
        if (r0 == (-1)) goto L6;
        return BufferKt.readUtf8Line(this, r0);
    L6:
        if (size() != 0) goto L11;
        return null;
    L11:
        return readUtf8(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long r3) {
        if (this.size < r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public void require(long r3) {
        if (this.size < r3) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options r4) {
        Intrinsics.f(r4, "options");
        int r0 = BufferKt.selectPrefix$default(this, r4, false, 2, null);
        if (r0 == (-1)) goto L7;
        skip(r4.getByteStrings$okio()[r0].size());
        return r0;
    L7:
        return -1;
    }

    public final void setSize$okio(long r1) {
        this.size = r1;
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    @JvmName
    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long r7) {
    L3:
        if (r7 <= 0) goto L11;
        Segment r0 = this.head;
        if (r0 == null) goto L10;
        int r1 = (int) Math.min(r7, r0.limit - r0.pos);
        long r4 = r1;
        setSize$okio(size() - r4);
        r7 = r7 - r4;
        int r2 = r0.pos + r1;
        r0.pos = r2;
        if (r2 != r0.limit) goto L3;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
        goto L3
    L10:
        throw new EOFException();
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return snapshot((int) size());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int r3) {
        boolean r1 = true;
        if (r3 < 1) goto L6;
        if (r3 > 8192) goto L6;
    L7:
        if (r1 == false) goto L20;
        Segment r2 = this.head;
        if (r2 != null) goto L11;
        Segment r4 = SegmentPool.take();
        this.head = r4;
        r4.prev = r4;
        r4.next = r4;
        return r4;
    L11:
        Intrinsics.c(r2);
        Segment r5 = r2.prev;
        Intrinsics.c(r5);
        if ((r5.limit + r3) <= 8192) goto L14;
    L17:
        r5 = r5.push(SegmentPool.take());
    L21:
        return r5;
    L14:
        if (r5.owner == true) goto L21;
    L20:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r1 = false;
        goto L7
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r1) {
        return write(r1);
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source r7) {
        Intrinsics.f(r7, DBHelper.BATTERY_COL_SOURCE);
        long r0 = 0;
    L3:
        long r2 = r7.read(this, 8192);
        if (r2 == (-1)) goto L5;
        r0 = r0 + r2;
        goto L3
    L5:
        return r0;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int r1) {
        return writeByte(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeDecimalLong(long r1) {
        return writeDecimalLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long r1) {
        return writeHexadecimalUnsignedLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int r1) {
        return writeInt(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeIntLe(int r1) {
        return writeIntLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLong(long r1) {
        return writeLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLongLe(long r1) {
        return writeLongLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int r1) {
        return writeShort(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShortLe(int r1) {
        return writeShortLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, int r2, int r3, Charset r4) {
        return writeString(r1, r2, r3, r4);
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream r7) {
        return writeTo$default(this, r7, 0, 2, null);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1) {
        return writeUtf8(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8CodePoint(int r1) {
        return writeUtf8CodePoint(r1);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, Buffer r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r8 = 0;
    L6:
        return r6.copyTo(r7, r8, r10);
    }

    @NotNull
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Buffer m183clone() {
        return copy();
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream r9, long r10) {
        return copyTo$default(this, r9, r10, 0, 4, null);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emit() {
        return emit();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emitCompleteSegments() {
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString r12, long r13) {
        Intrinsics.f(r12, "targetBytes");
        long r0 = 0;
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L74;
        Segment r3 = this.head;
        if (r3 != null) goto L10;
        return -1;
    L10:
        if ((size() - r13) >= r13) goto L43;
        r0 = size();
    L13:
        if (r0 <= r13) goto L16;
        r3 = r3.prev;
        Intrinsics.c(r3);
        r0 = r0 - ((long) (r3.limit - r3.pos));
        goto L13
    L16:
        if (r12.size() != 2) goto L30;
        byte r4 = r12.getByte(0);
        byte r14 = r12.getByte(1);
    L19:
        if (r0 >= size()) goto L94;
        byte[] r5 = r3.data;
        int r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r16 = r3.limit;
    L21:
        if (r15 >= r16) goto L29;
        byte r7 = r5[r15];
        if (r7 == r4) goto L27;
        if (r7 == r14) goto L27;
        r15 = r15 + 1;
    L27:
        int r11 = r3.pos;
    L93:
        return ((long) (r15 - r11)) + r0;
    L29:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
        goto L19
    L94:
        return -1;
    L30:
        byte[] r17 = r12.internalArray$okio();
    L32:
        if (r0 >= size()) goto L95;
        byte[] r6 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r18 = r3.limit;
    L34:
        if (r15 >= r18) goto L42;
        byte r8 = r6[r15];
        int r9 = r17.length;
        int r10 = 0;
    L36:
        if (r10 >= r9) goto L41;
        if (r8 == r17[r10]) goto L39;
        r10 = r10 + 1;
    L39:
        r11 = r3.pos;
        goto L93
    L41:
        r15 = r15 + 1;
        goto L34
    L42:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
        goto L32
    L95:
        return -1;
    L43:
        long r19 = ((long) (r3.limit - r3.pos)) + r0;
        if (r19 > r13) goto L46;
        r3 = r3.next;
        Intrinsics.c(r3);
        r0 = r19;
        goto L43
    L46:
        if (r12.size() != 2) goto L58;
        byte r20 = r12.getByte(0);
        byte r110 = r12.getByte(1);
    L49:
        if (r0 >= size()) goto L96;
        byte[] r21 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r111 = r3.limit;
    L51:
        if (r15 >= r111) goto L57;
        byte r22 = r21[r15];
        if (r22 == r20) goto L27;
        if (r22 == r110) goto L27;
        r15 = r15 + 1;
        goto L51
    L57:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
        goto L49
    L96:
        return -1;
    L58:
        byte[] r112 = r12.internalArray$okio();
    L60:
        if (r0 >= size()) goto L97;
        byte[] r23 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r113 = r3.limit;
    L62:
        if (r15 >= r113) goto L70;
        byte r24 = r23[r15];
        int r25 = r112.length;
        int r26 = 0;
    L64:
        if (r26 >= r25) goto L69;
        if (r24 == r112[r26]) goto L39;
        r26 = r26 + 1;
        goto L64
    L69:
        r15 = r15 + 1;
        goto L62
    L70:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r13 = r0;
        goto L60
    L97:
        return -1;
    L74:
        throw new IllegalArgumentException(a.h("fromIndex < 0: ", r13).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, @NotNull ByteString r9, int r10, int r11) {
        Intrinsics.f(r9, "bytes");
        if (r7 < 0) goto L21;
        if (r10 < 0) goto L22;
        if (r11 >= 0) goto L7;
        return false;
    L7:
        if ((size() - r7) >= r11) goto L9;
        return false;
    L9:
        if ((r9.size() - r10) < r11) goto L25;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L17;
        if (getByte(((long) r0) + r7) != r9.getByte(r10 + r0)) goto L26;
        r0 = r0 + 1;
        goto L12
    L26:
        return false;
    L17:
        return true;
    L25:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor r3) {
        Intrinsics.f(r3, "unsafeCursor");
        if (r3.buffer != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r3.buffer = this;
        r3.readWrite = true;
        return r3;
    L10:
        throw new IllegalStateException("already attached to a buffer".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L16;
        if (size() < r3) goto L14;
        byte[] r4 = new byte[(int) r3];
        readFully(r4);
        return r4;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(a.h("byteCount: ", r3).toString());
    L5:
        if (r3 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L7;
        r0 = true;
        goto L8
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L19;
        if (size() < r3) goto L17;
        if (r3 < 4096) goto L15;
        ByteString r1 = snapshot((int) r3);
        skip(r3);
        return r1;
    L15:
        return new ByteString(readByteArray(r3));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(a.h("byteCount: ", r3).toString());
    L5:
        if (r3 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L7;
        r0 = true;
        goto L8
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream r3, long r4) {
        Intrinsics.f(r3, "input");
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        readFrom(r3, r4, false);
        return this;
    L10:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r4).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long r7, @NotNull Charset r9) {
        Intrinsics.f(r9, "charset");
        if (r7 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L25;
        if (this.size < r7) goto L23;
        if (r7 != 0) goto L14;
        return "";
    L14:
        Segment r0 = this.head;
        Intrinsics.c(r0);
        int r2 = r0.pos;
        if ((((long) r2) + r7) > r0.limit) goto L17;
        int r3 = (int) r7;
        String r4 = new String(r0.data, r2, r3, r9);
        int r10 = r0.pos + r3;
        r0.pos = r10;
        this.size -= r7;
        if (r10 != r0.limit) goto L21;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L21:
        return r4;
    L17:
        return new String(readByteArray(r7), r9);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(a.h("byteCount: ", r7).toString());
    L5:
        if (r7 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L7;
        r1 = true;
        goto L8
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor r3) {
        Intrinsics.f(r3, "unsafeCursor");
        if (r3.buffer != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r3.buffer = this;
        r3.readWrite = false;
        return r3;
    L10:
        throw new IllegalStateException("already attached to a buffer".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long r2) {
        return readString(r2, Charsets.f354a);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long r12) {
        if (r12 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        long r1 = Long.MAX_VALUE;
        if (r12 == Long.MAX_VALUE) goto L11;
        r1 = r12 + 1;
    L11:
        byte r2 = (byte) 10;
        long r5 = indexOf(r2, 0, r1);
        if (r5 == (-1)) goto L15;
        return BufferKt.readUtf8Line(this, r5);
    L15:
        if (r1 < size()) goto L17;
    L22:
        Buffer r6 = new Buffer();
        copyTo(r6, 0, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), r12) + " content=" + r6.readByteString().hex() + 8230);
    L17:
        if (getByte(r1 - 1) != ((byte) 13)) goto L22;
        if (getByte(r1) != r2) goto L22;
        return BufferKt.readUtf8Line(this, r1);
    L25:
        throw new IllegalArgumentException(a.h("limit < 0: ", r12).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r1, int r2, int r3) {
        return write(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeByte(int r5) {
        Segment r0 = writableSegment$okio(1);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        r0.limit = r2 + 1;
        r1[r2] = (byte) r5;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeDecimalLong(long r13) {
        if (r13 == 0) goto L78;
        int r3 = 1;
        if (r13 >= 0) goto L11;
        r13 = -r13;
        if (r13 < 0) goto L79;
        boolean r2 = true;
    L13:
        if (r13 >= 100000000) goto L37;
        if (r13 >= 10000) goto L27;
        if (r13 >= 100) goto L23;
        if (r13 < 10) goto L67;
        r3 = 2;
    L67:
        if (r2 == false) goto L69;
        r3 = r3 + 1;
    L69:
        Segment r4 = writableSegment$okio(r3);
        byte[] r6 = r4.data;
        int r7 = r4.limit + r3;
    L71:
        if (r13 == 0) goto L73;
        long r8 = 10;
        r7 = r7 - 1;
        r6[r7] = BufferKt.getHEX_DIGIT_BYTES()[(int) (r13 % r8)];
        r13 = r13 / r8;
        goto L71
    L73:
        if (r2 == false) goto L75;
        r6[r7 - 1] = (byte) 45;
    L75:
        r4.limit += r3;
        setSize$okio(size() + ((long) r3));
        return this;
    L23:
        if (r13 >= 1000) goto L25;
        r3 = 3;
        goto L67
    L25:
        r3 = 4;
        goto L67
    L27:
        if (r13 >= 1000000) goto L33;
        if (r13 >= 100000) goto L31;
        r3 = 5;
        goto L67
    L31:
        r3 = 6;
        goto L67
    L33:
        if (r13 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L35;
        r3 = 7;
        goto L67
    L35:
        r3 = 8;
        goto L67
    L37:
        if (r13 >= 1000000000000L) goto L49;
        if (r13 >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) goto L45;
        if (r13 >= 1000000000) goto L43;
        r3 = 9;
        goto L67
    L43:
        r3 = 10;
        goto L67
    L45:
        if (r13 >= 100000000000L) goto L47;
        r3 = 11;
        goto L67
    L47:
        r3 = 12;
        goto L67
    L49:
        if (r13 >= 1000000000000000L) goto L58;
        if (r13 >= 10000000000000L) goto L54;
        r3 = 13;
        goto L67
    L54:
        if (r13 >= 100000000000000L) goto L56;
        r3 = 14;
        goto L67
    L56:
        r3 = 15;
        goto L67
    L58:
        if (r13 >= 100000000000000000L) goto L64;
        if (r13 >= 10000000000000000L) goto L62;
        r3 = 16;
        goto L67
    L62:
        r3 = 17;
        goto L67
    L64:
        if (r13 >= 1000000000000000000L) goto L66;
        r3 = 18;
        goto L67
    L66:
        r3 = 19;
        goto L67
    L79:
        return writeUtf8("-9223372036854775808");
    L11:
        r2 = false;
        goto L13
    L78:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long r13) {
        if (r13 == 0) goto L11;
        long r1 = (r13 >>> 1) | r13;
        long r2 = r1 | (r1 >>> 2);
        long r3 = r2 | (r2 >>> 4);
        long r4 = r3 | (r3 >>> 8);
        long r5 = r4 | (r4 >>> 16);
        long r6 = r5 | (r5 >>> 32);
        long r7 = r6 - ((r6 >>> 1) & 6148914691236517205L);
        long r8 = ((r7 >>> 2) & 3689348814741910323L) + (r7 & 3689348814741910323L);
        long r9 = ((r8 >>> 4) + r8) & 1085102592571150095L;
        long r10 = r9 + (r9 >>> 8);
        long r11 = r10 + (r10 >>> 16);
        int r12 = (int) ((((r11 & 63) + ((r11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment r14 = writableSegment$okio(r12);
        byte[] r15 = r14.data;
        int r16 = r14.limit;
        int r17 = (r16 + r12) - 1;
    L6:
        if (r17 < r16) goto L8;
        r15[r17] = BufferKt.getHEX_DIGIT_BYTES()[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r17 = r17 - 1;
        goto L6
    L8:
        r14.limit += r12;
        setSize$okio(size() + ((long) r12));
        return this;
    L11:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeInt(int r8) {
        Segment r1 = writableSegment$okio(4);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        r2[r3] = (byte) ((r8 >>> 24) & 255);
        r2[r3 + 1] = (byte) ((r8 >>> 16) & 255);
        int r4 = r3 + 3;
        r2[r3 + 2] = (byte) ((r8 >>> 8) & 255);
        r2[r4] = (byte) (r8 & 255);
        r1.limit = r3 + 4;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeIntLe(int r1) {
        return writeInt(Util.reverseBytes(r1));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLong(long r12) {
        Segment r1 = writableSegment$okio(8);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        r2[r3] = (byte) ((r12 >>> 56) & 255);
        r2[r3 + 1] = (byte) ((r12 >>> 48) & 255);
        r2[r3 + 2] = (byte) ((r12 >>> 40) & 255);
        r2[r3 + 3] = (byte) ((r12 >>> 32) & 255);
        r2[r3 + 4] = (byte) ((r12 >>> 24) & 255);
        r2[r3 + 5] = (byte) ((r12 >>> 16) & 255);
        r2[r3 + 6] = (byte) ((r12 >>> 8) & 255);
        r2[r3 + 7] = (byte) (r12 & 255);
        r1.limit = r3 + 8;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLongLe(long r1) {
        return writeLong(Util.reverseBytes(r1));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShort(int r7) {
        Segment r1 = writableSegment$okio(2);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r7 >>> 8) & 255);
        r2[r4] = (byte) (r7 & 255);
        r1.limit = r3 + 2;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShortLe(int r1) {
        return writeShort(Util.reverseBytes((short) r1));
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, Charset r2) {
        return writeString(r1, r2);
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream r8, long r9) {
        Intrinsics.f(r8, "out");
        Util.checkOffsetAndCount(this.size, 0, r9);
        Segment r0 = this.head;
    L4:
        if (r9 <= 0) goto L8;
        Intrinsics.c(r0);
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        r8.write(r0.data, r0.pos, r1);
        int r2 = r0.pos + r1;
        r0.pos = r2;
        long r5 = r1;
        this.size -= r5;
        r9 = r9 - r5;
        if (r2 != r0.limit) goto L4;
        Segment r3 = r0.pop();
        this.head = r3;
        SegmentPool.recycle(r0);
        r0 = r3;
        goto L4
    L8:
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1, int r2, int r3) {
        return writeUtf8(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8CodePoint(int r9) {
        if (r9 >= 128) goto L6;
        writeByte(r9);
    L20:
        return this;
    L6:
        if (r9 >= 2048) goto L9;
        Segment r3 = writableSegment$okio(2);
        byte[] r4 = r3.data;
        int r5 = r3.limit;
        r4[r5] = (byte) ((r9 >> 6) | 192);
        r4[r5 + 1] = (byte) ((r9 & 63) | 128);
        r3.limit = r5 + 2;
        setSize$okio(size() + 2);
        goto L20
    L9:
        if (55296 > r9) goto L15;
        if (57343 < r9) goto L15;
        writeByte(63);
    L15:
        if (r9 >= 65536) goto L18;
        Segment r6 = writableSegment$okio(3);
        byte[] r7 = r6.data;
        int r8 = r6.limit;
        r7[r8] = (byte) ((r9 >> 12) | 224);
        r7[r8 + 1] = (byte) (((r9 >> 6) & 63) | 128);
        r7[r8 + 2] = (byte) ((r9 & 63) | 128);
        r6.limit = r8 + 3;
        setSize$okio(size() + 3);
        goto L20
    L18:
        if (r9 > 1114111) goto L22;
        Segment r10 = writableSegment$okio(4);
        byte[] r11 = r10.data;
        int r12 = r10.limit;
        r11[r12] = (byte) ((r9 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        r11[r12 + 1] = (byte) (((r9 >> 12) & 63) | 128);
        r11[r12 + 2] = (byte) (((r9 >> 6) & 63) | 128);
        r11[r12 + 3] = (byte) ((r9 & 63) | 128);
        r10.limit = r12 + 4;
        setSize$okio(size() + 4);
        goto L20
    L22:
        throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(r9));
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, OutputStream r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r10 = r6.size - r2;
    L9:
        return r6.copyTo(r7, r2, r10);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream r8, long r9, long r11) {
        Intrinsics.f(r8, "out");
        Util.checkOffsetAndCount(this.size, r9, r11);
        if (r11 != 0) goto L5;
        return this;
    L5:
        Segment r2 = this.head;
    L6:
        Intrinsics.c(r2);
        int r3 = r2.limit;
        int r4 = r2.pos;
        if (r9 < (r3 - r4)) goto L10;
        r9 = r9 - ((long) (r3 - r4));
        r2 = r2.next;
    L10:
        if (r11 <= 0) goto L12;
        Intrinsics.c(r2);
        int r10 = (int) (((long) r2.pos) + r9);
        int r12 = (int) Math.min(r2.limit - r10, r11);
        r8.write(r2.data, r10, r12);
        r11 = r11 - ((long) r12);
        r2 = r2.next;
        r9 = 0;
        goto L10
    L12:
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString r3) {
        Intrinsics.f(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(Source r1, long r2) {
        return write(r1, r2);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String r3, @NotNull Charset r4) {
        Intrinsics.f(r3, "string");
        Intrinsics.f(r4, "charset");
        return writeString(r3, 0, r3.length(), r4);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String r3) {
        Intrinsics.f(r3, "string");
        return writeUtf8(r3, 0, r3.length());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r10, long r11, long r13) {
        long r0 = 0;
        if (0 <= r11) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L47;
        if (r13 <= size()) goto L14;
        r13 = size();
    L14:
        if (r11 == r13) goto L57;
        Segment r3 = this.head;
        if (r3 != null) goto L19;
        return -1;
    L19:
        if ((size() - r11) >= r11) goto L33;
        r0 = size();
    L22:
        if (r0 <= r11) goto L25;
        r3 = r3.prev;
        Intrinsics.c(r3);
        r0 = r0 - ((long) (r3.limit - r3.pos));
    L25:
        if (r0 >= r13) goto L58;
        byte[] r9 = r3.data;
        int r5 = (int) Math.min(r3.limit, (((long) r3.pos) + r13) - r0);
        int r12 = (int) ((((long) r3.pos) + r11) - r0);
    L27:
        if (r12 >= r5) goto L32;
        if (r9[r12] == r10) goto L56;
        r12 = r12 + 1;
    L56:
        return ((long) (r12 - r3.pos)) + r0;
    L32:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r11 = r0;
        goto L25
    L58:
        return -1;
    L33:
        long r6 = ((long) (r3.limit - r3.pos)) + r0;
        if (r6 > r11) goto L36;
        r3 = r3.next;
        Intrinsics.c(r3);
        r0 = r6;
    L36:
        if (r0 >= r13) goto L59;
        byte[] r14 = r3.data;
        int r7 = (int) Math.min(r3.limit, (((long) r3.pos) + r13) - r0);
        r12 = (int) ((((long) r3.pos) + r11) - r0);
    L38:
        if (r12 >= r7) goto L43;
        if (r14[r12] == r10) goto L56;
        r12 = r12 + 1;
        goto L38
    L43:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        Intrinsics.c(r3);
        r11 = r0;
        goto L36
    L59:
        return -1;
    L57:
        return -1;
    L47:
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + r11 + " toIndex=" + r13).toString());
    L6:
        if (r13 < r11) goto L8;
        r2 = true;
        goto L9
    }

    @NotNull
    public final ByteString snapshot(int r8) {
        if (r8 == 0) goto L19;
        Util.checkOffsetAndCount(size(), 0, r8);
        Segment r0 = this.head;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r2 >= r8) goto L11;
        Intrinsics.c(r0);
        int r4 = r0.limit;
        int r5 = r0.pos;
        if (r4 == r5) goto L10;
        r2 = r2 + (r4 - r5);
        r3 = r3 + 1;
        r0 = r0.next;
        goto L5
    L10:
        throw new AssertionError("s.limit == s.pos");
    L11:
        byte[][] r6 = new byte[r3][];
        int[] r7 = new int[r3 * 2];
        Segment r9 = this.head;
        int r10 = 0;
    L12:
        if (r1 >= r8) goto L15;
        Intrinsics.c(r9);
        r6[r10] = r9.data;
        r1 = r1 + (r9.limit - r9.pos);
        r7[r10] = Math.min(r1, r8);
        r7[r10 + r3] = r9.pos;
        r9.shared = true;
        r10 = r10 + 1;
        r9 = r9.next;
        goto L12
    L15:
        return new SegmentedByteString(r6, r7);
    L19:
        return ByteString.EMPTY;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1) {
        return write(r1);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String r4, int r5, int r6, @NotNull Charset r7) {
        Intrinsics.f(r4, "string");
        Intrinsics.f(r7, "charset");
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L27;
        if (r6 < r5) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L25;
        if (r6 <= r4.length()) goto L15;
        r0 = false;
    L15:
        if (r0 == true) goto L17;
        StringBuilder r8 = a.p(r6, "endIndex > string.length: ", " > ");
        r8.append(r4.length());
        throw new IllegalArgumentException(r8.toString().toString());
    L17:
        if (r7.equals(Charsets.f354a) == true) goto L19;
        String r9 = r4.substring(r5, r6);
        Intrinsics.e(r9, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        byte[] r10 = r9.getBytes(r7);
        Intrinsics.e(r10, "(this as java.lang.String).getBytes(charset)");
        return write(r10, 0, r10.length);
    L19:
        return writeUtf8(r4, r5, r6);
    L25:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r6 + " < " + r5).toString());
    L9:
        r3 = false;
        goto L10
    L27:
        throw new IllegalArgumentException(a.e(r5, "beginIndex < 0: ").toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String r12, int r13, int r14) {
        Intrinsics.f(r12, "string");
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L54;
        if (r14 < r13) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L52;
        if (r14 > r12.length()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L49;
    L16:
        if (r13 >= r14) goto L48;
        char r5 = r12.charAt(r13);
        if (r5 < 128) goto L19;
        if (r5 < 2048) goto L28;
        if (r5 < 55296) goto L47;
        if (r5 > 57343) goto L47;
        int r6 = r13 + 1;
        if (r6 >= r14) goto L38;
        char r7 = r12.charAt(r6);
    L40:
        if (r5 > 56319) goto L46;
        if (56320 > r7) goto L46;
        if (57343 < r7) goto L46;
        int r8 = (((r5 & 1023) << 10) | (r7 & 1023)) + 65536;
        Segment r9 = writableSegment$okio(4);
        byte[] r10 = r9.data;
        int r11 = r9.limit;
        r10[r11] = (byte) ((r8 >> 18) | BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND);
        r10[r11 + 1] = (byte) (((r8 >> 12) & 63) | 128);
        r10[r11 + 2] = (byte) (((r8 >> 6) & 63) | 128);
        r10[r11 + 3] = (byte) ((r8 & 63) | 128);
        r9.limit = r11 + 4;
        setSize$okio(size() + 4);
        r13 = r13 + 2;
    L46:
        writeByte(63);
        r13 = r6;
        goto L16
    L38:
        r7 = 0;
    L47:
        Segment r15 = writableSegment$okio(3);
        byte[] r16 = r15.data;
        int r17 = r15.limit;
        r16[r17] = (byte) ((r5 >> '\f') | 224);
        r16[r17 + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r16[r17 + 2] = (byte) ((r5 & '?') | 128);
        r15.limit = r17 + 3;
        setSize$okio(size() + 3);
    L29:
        r13 = r13 + 1;
        goto L16
    L28:
        Segment r18 = writableSegment$okio(2);
        byte[] r19 = r18.data;
        int r20 = r18.limit;
        r19[r20] = (byte) ((r5 >> 6) | 192);
        r19[r20 + 1] = (byte) ((r5 & '?') | 128);
        r18.limit = r20 + 2;
        setSize$okio(size() + 2);
        goto L29
    L19:
        Segment r21 = writableSegment$okio(1);
        byte[] r22 = r21.data;
        int r23 = r21.limit - r13;
        int r24 = Math.min(r14, 8192 - r23);
        int r25 = r13 + 1;
        r22[r13 + r23] = (byte) r5;
    L20:
        if (r25 >= r24) goto L25;
        char r110 = r12.charAt(r25);
        if (r110 >= 128) goto L25;
        r22[r25 + r23] = (byte) r110;
        r25 = r25 + 1;
    L25:
        int r111 = r21.limit;
        int r26 = (r23 + r25) - r111;
        r21.limit = r111 + r26;
        setSize$okio(size() + ((long) r26));
        r13 = r25;
        goto L16
    L48:
        return this;
    L49:
        StringBuilder r112 = a.p(r14, "endIndex > string.length: ", " > ");
        r112.append(r12.length());
        throw new IllegalArgumentException(r112.toString().toString());
    L14:
        r4 = false;
        goto L15
    L52:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r14 + " < " + r13).toString());
    L9:
        r3 = false;
        goto L10
    L54:
        throw new IllegalArgumentException(a.e(r13, "beginIndex < 0: ").toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] r4) {
        Intrinsics.f(r4, "sink");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = read(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1, int r2, int r3) {
        return write(r1, r2, r3);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer r7) {
        Intrinsics.f(r7, DBHelper.BATTERY_COL_SOURCE);
        int r0 = r7.remaining();
        int r1 = r0;
    L3:
        if (r1 <= 0) goto L5;
        Segment r2 = writableSegment$okio(1);
        int r3 = Math.min(r1, 8192 - r2.limit);
        r7.get(r2.data, r2.limit, r3);
        r1 = r1 - r3;
        r2.limit += r3;
        goto L3
    L5:
        this.size += (long) r0;
        return r0;
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] r3) {
        Intrinsics.f(r3, "sink");
        return read(r3, 0, r3.length);
    }

    private final void readFrom(InputStream r5, long r6, boolean r8) {
    L3:
        if (r6 > 0) goto L7;
        if (r8 == true) goto L7;
        return;
    L7:
        Segment r0 = writableSegment$okio(1);
        int r1 = r5.read(r0.data, r0.limit, (int) Math.min(r6, 8192 - r0.limit));
        if (r1 == (-1)) goto L10;
        r0.limit += r1;
        long r2 = r1;
        this.size += r2;
        r6 = r6 - r2;
        goto L3
    L10:
        if (r0.pos != r0.limit) goto L12;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L12:
        if (r8 == false) goto L15;
        return;
    L15:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] r8, int r9, int r10) {
        Intrinsics.f(r8, "sink");
        Util.checkOffsetAndCount(r8.length, r9, r10);
        Segment r0 = this.head;
        if (r0 == null) goto L7;
        int r11 = Math.min(r10, r0.limit - r0.pos);
        byte[] r1 = r0.data;
        int r2 = r0.pos;
        ArraysKt.g(r1, r9, r8, r2, r2 + r11);
        r0.pos += r11;
        setSize$okio(size() - ((long) r11));
        if (r0.pos != r0.limit) goto L9;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
        return r11;
    L9:
        return r11;
    L7:
        return -1;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer r9, long r10) {
        Intrinsics.f(r9, "out");
        return copyTo(r9, r10, this.size - r10);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString r3) {
        Intrinsics.f(r3, "byteString");
        r3.write$okio(this, 0, r3.size());
        return this;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer r8, long r9, long r11) {
        Intrinsics.f(r8, "out");
        Util.checkOffsetAndCount(size(), r9, r11);
        if (r11 == 0) goto L16;
        r8.setSize$okio(r8.size() + r11);
        Segment r2 = this.head;
    L6:
        Intrinsics.c(r2);
        int r3 = r2.limit;
        int r4 = r2.pos;
        if (r9 < (r3 - r4)) goto L10;
        r9 = r9 - ((long) (r3 - r4));
        r2 = r2.next;
    L10:
        if (r11 <= 0) goto L16;
        Intrinsics.c(r2);
        Segment r5 = r2.sharedCopy();
        int r6 = r5.pos + ((int) r9);
        r5.pos = r6;
        r5.limit = Math.min(r6 + ((int) r11), r5.limit);
        Segment r10 = r8.head;
        if (r10 != null) goto L14;
        r5.prev = r5;
        r5.next = r5;
        r8.head = r5;
    L15:
        r11 = r11 - ((long) (r5.limit - r5.pos));
        r2 = r2.next;
        r9 = 0;
        goto L10
    L14:
        Intrinsics.c(r10);
        Segment r12 = r10.prev;
        Intrinsics.c(r12);
        r12.push(r5);
    L16:
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString r2, int r3, int r4) {
        Intrinsics.f(r2, "byteString");
        r2.write$okio(this, r3, r4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] r3) {
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
        return write(r3, 0, r3.length);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] r10, int r11, int r12) {
        Intrinsics.f(r10, DBHelper.BATTERY_COL_SOURCE);
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        Segment r0 = writableSegment$okio(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.limit);
        int r4 = r11 + r1;
        ArraysKt.g(r10, r0.limit, r0.data, r11, r4);
        r0.limit += r1;
        r11 = r4;
        goto L3
    L5:
        setSize$okio(size() + r7);
        return this;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer r5, long r6) {
        Intrinsics.f(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L16;
        if (size() != 0) goto L11;
        return -1;
    L11:
        if (r6 <= size()) goto L13;
        r6 = size();
    L13:
        r5.write(this, r6);
        return r6;
    L16:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull Source r5, long r6) {
        Intrinsics.f(r5, DBHelper.BATTERY_COL_SOURCE);
    L4:
        if (r6 <= 0) goto L10;
        long r0 = r5.read(this, r6);
        if (r0 == (-1)) goto L9;
        r6 = r6 - r0;
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString r17, long r18) {
        long r0 = r18;
        Intrinsics.f(r17, "bytes");
        if (r17.size() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L53;
        long r6 = 0;
        if (r0 < 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L51;
        Segment r8 = this.head;
        if (r8 != null) goto L15;
    L32:
        return -1;
    L15:
        if ((size() - r0) >= r0) goto L33;
        long r7 = size();
    L18:
        if (r7 <= r0) goto L20;
        r8 = r8.prev;
        Intrinsics.c(r8);
        r7 = r7 - ((long) (r8.limit - r8.pos));
        goto L18
    L20:
        byte[] r11 = r17.internalArray$okio();
        byte r4 = r11[0];
        int r5 = r17.size();
        long r14 = (size() - ((long) r5)) + 1;
    L22:
        if (r7 >= r14) goto L32;
        byte[] r9 = r8.data;
        int r10 = (int) Math.min(r8.limit, (((long) r8.pos) + r14) - r7);
        int r1 = (int) ((((long) r8.pos) + r0) - r7);
    L24:
        if (r1 >= r10) goto L31;
        if (r9[r1] != r4) goto L30;
        if (BufferKt.rangeEquals(r8, r1 + 1, r11, 1, r5) == false) goto L30;
        return ((long) (r1 - r8.pos)) + r7;
    L30:
        r1 = r1 + 1;
        goto L24
    L31:
        r7 = r7 + ((long) (r8.limit - r8.pos));
        r8 = r8.next;
        Intrinsics.c(r8);
        r0 = r7;
    L33:
        long r12 = ((long) (r8.limit - r8.pos)) + r6;
        if (r12 > r0) goto L35;
        r8 = r8.next;
        Intrinsics.c(r8);
        r6 = r12;
        goto L33
    L35:
        byte[] r13 = r17.internalArray$okio();
        byte r15 = r13[0];
        int r16 = r17.size();
        long r19 = (size() - ((long) r16)) + 1;
    L37:
        if (r6 >= r19) goto L32;
        byte[] r20 = r8.data;
        long r110 = r6;
        int r21 = (int) Math.min(r8.limit, (((long) r8.pos) + r19) - r6);
        int r22 = (int) ((((long) r8.pos) + r0) - r110);
    L39:
        if (r22 >= r21) goto L47;
        if (r20[r22] != r15) goto L46;
        if (BufferKt.rangeEquals(r8, r22 + 1, r13, 1, r16) == false) goto L46;
        return ((long) (r22 - r8.pos)) + r110;
    L46:
        r22 = r22 + 1;
        goto L39
    L47:
        r6 = r110 + ((long) (r8.limit - r8.pos));
        r8 = r8.next;
        Intrinsics.c(r8);
        r0 = r6;
        goto L37
    L51:
        throw new IllegalArgumentException(a.h("fromIndex < 0: ", r0).toString());
    L10:
        r3 = false;
        goto L11
    L53:
        throw new IllegalArgumentException("bytes is empty".toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer r9, long r10) {
        Intrinsics.f(r9, DBHelper.BATTERY_COL_SOURCE);
        if (r9 == this) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L34;
        Util.checkOffsetAndCount(r9.size(), 0, r10);
    L9:
        if (r10 <= 0) goto L39;
        Segment r2 = r9.head;
        Intrinsics.c(r2);
        int r3 = r2.limit;
        Segment r4 = r9.head;
        Intrinsics.c(r4);
        if (r10 >= (r3 - r4.pos)) goto L27;
        Segment r5 = this.head;
        if (r5 == null) goto L15;
        Intrinsics.c(r5);
        Segment r6 = r5.prev;
    L16:
        if (r6 != null) goto L18;
    L26:
        Segment r7 = r9.head;
        Intrinsics.c(r7);
        r9.head = r7.split((int) r10);
        goto L27
    L18:
        if (r6.owner == false) goto L26;
        long r8 = ((long) r6.limit) + r10;
        if (r6.shared == false) goto L22;
        int r11 = 0;
    L24:
        if ((r8 - ((long) r11)) > 8192) goto L26;
        Segment r0 = r9.head;
        Intrinsics.c(r0);
        r0.writeTo(r6, (int) r10);
        r9.setSize$okio(r9.size() - r10);
        setSize$okio(size() + r10);
        return;
    L22:
        r11 = r6.pos;
        goto L24
    L15:
        r6 = null;
    L27:
        Segment r12 = r9.head;
        Intrinsics.c(r12);
        long r13 = r12.limit - r12.pos;
        r9.head = r12.pop();
        Segment r14 = this.head;
        if (r14 != null) goto L30;
        this.head = r12;
        r12.prev = r12;
        r12.next = r12;
    L31:
        r9.setSize$okio(r9.size() - r13);
        setSize$okio(size() + r13);
        r10 = r10 - r13;
        goto L9
    L30:
        Intrinsics.c(r14);
        Segment r15 = r14.prev;
        Intrinsics.c(r15);
        r15.push(r12).compact();
        goto L31
    L39:
        return;
    L34:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r1 = false;
        goto L6
    }
}
