package okio.internal;

import com.bytedance.apm.battery.dao.DBHelper;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealBufferedSinkKt {
    public static final void commonClose(@NotNull RealBufferedSink r4) {
        Intrinsics.f(r4, "$this$commonClose");
        if (r4.closed == false) goto L21;
        return;
    L21:
    L9:
        th = th;
    L23:
        r4.sink.close();     // Catch: Throwable -> L14
    L17:
        r4.closed = true;
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
        if (r4.bufferField.size() <= 0) goto L11;
        Sink r0 = r4.sink;     // Catch: Throwable -> L9
        Buffer r1 = r4.bufferField;     // Catch: Throwable -> L9
        r0.write(r1, r1.size());     // Catch: Throwable -> L9
    L11:
        th = null;
        goto L23
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull RealBufferedSink r4) {
        Intrinsics.f(r4, "$this$commonEmit");
        if ((!r4.closed) == false) goto L9;
        long r0 = r4.bufferField.size();
        if (r0 <= 0) goto L7;
        r4.sink.write(r4.bufferField, r0);
    L7:
        return r4;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink r4) {
        Intrinsics.f(r4, "$this$commonEmitCompleteSegments");
        if ((!r4.closed) == false) goto L9;
        long r0 = r4.bufferField.completeSegmentByteCount();
        if (r0 <= 0) goto L7;
        r4.sink.write(r4.bufferField, r0);
    L7:
        return r4;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonFlush(@NotNull RealBufferedSink r4) {
        Intrinsics.f(r4, "$this$commonFlush");
        if ((!r4.closed) == false) goto L10;
        if (r4.bufferField.size() <= 0) goto L7;
        Sink r0 = r4.sink;
        Buffer r1 = r4.bufferField;
        r0.write(r1, r1.size());
    L7:
        r4.sink.flush();
        return;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSink r1) {
        Intrinsics.f(r1, "$this$commonTimeout");
        return r1.sink.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSink r2) {
        Intrinsics.f(r2, "$this$commonToString");
        return "buffer(" + r2.sink + ')';
    }

    public static final void commonWrite(@NotNull RealBufferedSink r1, @NotNull Buffer r2, long r3) {
        Intrinsics.f(r1, "$this$commonWrite");
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2, r3);
        r1.emitCompleteSegments();
        return;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonWriteAll(@NotNull RealBufferedSink r6, @NotNull Source r7) {
        Intrinsics.f(r6, "$this$commonWriteAll");
        Intrinsics.f(r7, DBHelper.BATTERY_COL_SOURCE);
        long r0 = 0;
    L3:
        long r2 = r7.read(r6.bufferField, 8192);
        if (r2 == (-1)) goto L5;
        r0 = r0 + r2;
        r6.emitCompleteSegments();
        goto L3
    L5:
        return r0;
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink r1, int r2) {
        Intrinsics.f(r1, "$this$commonWriteByte");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeByte(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink r1, long r2) {
        Intrinsics.f(r1, "$this$commonWriteDecimalLong");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeDecimalLong(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink r1, long r2) {
        Intrinsics.f(r1, "$this$commonWriteHexadecimalUnsignedLong");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeHexadecimalUnsignedLong(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink r1, int r2) {
        Intrinsics.f(r1, "$this$commonWriteInt");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeInt(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink r1, int r2) {
        Intrinsics.f(r1, "$this$commonWriteIntLe");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeIntLe(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink r1, long r2) {
        Intrinsics.f(r1, "$this$commonWriteLong");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeLong(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink r1, long r2) {
        Intrinsics.f(r1, "$this$commonWriteLongLe");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeLongLe(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink r1, int r2) {
        Intrinsics.f(r1, "$this$commonWriteShort");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeShort(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink r1, int r2) {
        Intrinsics.f(r1, "$this$commonWriteShortLe");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeShortLe(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink r1, @NotNull String r2) {
        Intrinsics.f(r1, "$this$commonWriteUtf8");
        Intrinsics.f(r2, "string");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeUtf8(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink r1, int r2) {
        Intrinsics.f(r1, "$this$commonWriteUtf8CodePoint");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeUtf8CodePoint(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink r1, @NotNull ByteString r2) {
        Intrinsics.f(r1, "$this$commonWrite");
        Intrinsics.f(r2, "byteString");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink r1, @NotNull String r2, int r3, int r4) {
        Intrinsics.f(r1, "$this$commonWriteUtf8");
        Intrinsics.f(r2, "string");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeUtf8(r2, r3, r4);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink r1, @NotNull ByteString r2, int r3, int r4) {
        Intrinsics.f(r1, "$this$commonWrite");
        Intrinsics.f(r2, "byteString");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2, r3, r4);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink r1, @NotNull byte[] r2) {
        Intrinsics.f(r1, "$this$commonWrite");
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink r1, @NotNull byte[] r2, int r3, int r4) {
        Intrinsics.f(r1, "$this$commonWrite");
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2, r3, r4);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink r4, @NotNull Source r5, long r6) {
        Intrinsics.f(r4, "$this$commonWrite");
        Intrinsics.f(r5, DBHelper.BATTERY_COL_SOURCE);
    L4:
        if (r6 <= 0) goto L10;
        long r0 = r5.read(r4.bufferField, r6);
        if (r0 == (-1)) goto L9;
        r6 = r6 - r0;
        r4.emitCompleteSegments();
        goto L4
    L9:
        throw new EOFException();
    L10:
        return r4;
    }
}
