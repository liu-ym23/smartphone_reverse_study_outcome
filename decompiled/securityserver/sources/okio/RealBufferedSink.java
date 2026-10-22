package okio;

import com.bytedance.apm.battery.dao.DBHelper;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealBufferedSink implements BufferedSink {

    @JvmField
    @NotNull
    public final Buffer bufferField;

    @JvmField
    public boolean closed;

    @JvmField
    @NotNull
    public final Sink sink;

    public RealBufferedSink(@NotNull Sink r2) {
        Intrinsics.f(r2, "sink");
        this.sink = r2;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == true) goto L25;
    L9:
        th = th;
    L21:
        this.sink.close();     // Catch: Throwable -> L14
    L17:
        this.closed = true;
        if (th != null) goto L20;
        return;
    L20:
        throw th;
    L14:
        th = move-exception;
        if (th != null) goto L17;
        th = th;
        goto L17
    L6:
        if (this.bufferField.size() <= 0) goto L11;
        Sink r0 = this.sink;     // Catch: Throwable -> L9
        Buffer r1 = this.bufferField;     // Catch: Throwable -> L9
        r0.write(r1, r1.size());     // Catch: Throwable -> L9
    L11:
        th = null;
        goto L21
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emit() {
        if ((!this.closed) == false) goto L9;
        long r0 = this.bufferField.size();
        if (r0 <= 0) goto L7;
        this.sink.write(this.bufferField, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink emitCompleteSegments() {
        if ((!this.closed) == false) goto L9;
        long r0 = this.bufferField.completeSegmentByteCount();
        if (r0 <= 0) goto L7;
        this.sink.write(this.bufferField, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if ((!this.closed) == false) goto L10;
        if (this.bufferField.size() <= 0) goto L7;
        Sink r0 = this.sink;
        Buffer r1 = this.bufferField;
        r0.write(r1, r1.size());
    L7:
        this.sink.flush();
        return;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new AnonymousClass1(this);
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer r2) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.closed) == false) goto L7;
        int r3 = this.bufferField.write(r2);
        emitCompleteSegments();
        return r3;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source r7) {
        Intrinsics.f(r7, DBHelper.BATTERY_COL_SOURCE);
        long r0 = 0;
    L3:
        long r2 = r7.read(this.bufferField, 8192);
        if (r2 == (-1)) goto L5;
        r0 = r0 + r2;
        emitCompleteSegments();
        goto L3
    L5:
        return r0;
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeByte(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeByte(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeDecimalLong(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeDecimalLong(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeHexadecimalUnsignedLong(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeInt(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeInt(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeIntLe(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeIntLe(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLong(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeLong(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeLongLe(long r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeLongLe(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShort(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeShort(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeShortLe(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeShortLe(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String r2, @NotNull Charset r3) {
        Intrinsics.f(r2, "string");
        Intrinsics.f(r3, "charset");
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeString(r2, r3);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String r2) {
        Intrinsics.f(r2, "string");
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeUtf8(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8CodePoint(int r2) {
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeUtf8CodePoint(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer r2, long r3) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2, r3);
        emitCompleteSegments();
        return;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String r2, int r3, int r4, @NotNull Charset r5) {
        Intrinsics.f(r2, "string");
        Intrinsics.f(r5, "charset");
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeString(r2, r3, r4, r5);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String r2, int r3, int r4) {
        Intrinsics.f(r2, "string");
        if ((!this.closed) == false) goto L7;
        this.bufferField.writeUtf8(r2, r3, r4);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString r2) {
        Intrinsics.f(r2, "byteString");
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString r2, int r3, int r4) {
        Intrinsics.f(r2, "byteString");
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2, r3, r4);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] r2) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] r2, int r3, int r4) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!this.closed) == false) goto L7;
        this.bufferField.write(r2, r3, r4);
        return emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull Source r5, long r6) {
        Intrinsics.f(r5, DBHelper.BATTERY_COL_SOURCE);
    L4:
        if (r6 <= 0) goto L10;
        long r0 = r5.read(this.bufferField, r6);
        if (r0 == (-1)) goto L9;
        r6 = r6 - r0;
        emitCompleteSegments();
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }
}
