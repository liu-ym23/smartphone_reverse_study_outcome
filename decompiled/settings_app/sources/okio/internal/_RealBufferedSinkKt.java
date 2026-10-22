package okio.internal;

import android.icu.text.DateFormat;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: -RealBufferedSink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0080\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0080\b¨\u0006*"}, d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", DateFormat.SECOND, "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _RealBufferedSinkKt {
    public static final void commonWrite(RealBufferedSink r1, Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2, r3);
        r1.emitCompleteSegments();
        return;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink r1, ByteString r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "byteString");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink r1, ByteString r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "byteString");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2, r3, r4);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "string");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeUtf8(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink r1, String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "string");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeUtf8(r2, r3, r4);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeUtf8CodePoint(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWrite(RealBufferedSink r1, byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "source");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.write(r2, r3, r4);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeByte(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeShort(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeShortLe(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeInt(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeIntLe(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeLong(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeLongLe(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeDecimalLong(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((!r1.closed) == false) goto L7;
        r1.bufferField.writeHexadecimalUnsignedLong(r2);
        return r1.emitCompleteSegments();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((!r4.closed) == false) goto L10;
        long r0 = r4.bufferField.completeSegmentByteCount();
        if (r0 <= 0) goto L8;
        r4.sink.write(r4.bufferField, r0);
    L8:
        return r4;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSink commonEmit(RealBufferedSink r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((!r4.closed) == false) goto L10;
        long r0 = r4.bufferField.size();
        if (r0 <= 0) goto L8;
        r4.sink.write(r4.bufferField, r0);
    L8:
        return r4;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonFlush(RealBufferedSink r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((!r4.closed) == false) goto L10;
        if (r4.bufferField.size() <= 0) goto L7;
        r4.sink.write(r4.bufferField, r4.bufferField.size());
    L7:
        r4.sink.flush();
        return;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonClose(RealBufferedSink r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.closed == false) goto L19;
        return;
    L19:
    L9:
        th = th;
    L21:
        r4.sink.close();     // Catch: Throwable -> L12
    L15:
        r4.closed = true;
        if (th != null) goto L18;
        return;
    L18:
        throw th;
    L12:
        th = move-exception;
        if (th != null) goto L15;
        th = th;
        goto L15
    L6:
        if (r4.bufferField.size() <= 0) goto L8;
        r4.sink.write(r4.bufferField, r4.bufferField.size());     // Catch: Throwable -> L9
    L8:
        th = null;
        goto L21
    }

    public static final Timeout commonTimeout(RealBufferedSink r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return "buffer(" + r2.sink + ')';
    }

    public static final long commonWriteAll(RealBufferedSink r6, Source r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "source");
        long r0 = 0;
    L3:
        long r2 = r7.read(r6.bufferField, 8192);
        if (r2 == (-1)) goto L6;
        r0 = r0 + r2;
        r6.emitCompleteSegments();
        goto L3
    L6:
        return r0;
    }

    public static final BufferedSink commonWrite(RealBufferedSink r4, Source r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "source");
    L4:
        if (r6 <= 0) goto L11;
        long r0 = r5.read(r4.bufferField, r6);
        if (r0 == (-1)) goto L9;
        r6 = r6 - r0;
        r4.emitCompleteSegments();
        goto L4
    L9:
        throw new EOFException();
    L11:
        return r4;
    }
}
