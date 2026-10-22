package okio.internal;

import com.android.settings.DataUsageFragment;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;

/* JADX INFO: compiled from: -RealBufferedSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b¨\u00068"}, d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", DataUsageFragment.INTENT_EXTRA_LIMIT, "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class _RealBufferedSourceKt {
    public static final long commonRead(RealBufferedSource r4, Buffer r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L19;
        if ((!r4.closed) == false) goto L17;
        if (r4.bufferField.size() != 0) goto L15;
        if (r4.source.read(r4.bufferField, 8192) != (-1)) goto L15;
        return -1;
    L15:
        return r4.bufferField.read(r5, Math.min(r6, r4.bufferField.size()));
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final boolean commonExhausted(RealBufferedSource r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if ((!r6.closed) == false) goto L12;
        if (r6.bufferField.exhausted() == true) goto L7;
    L9:
        return false;
    L7:
        if (r6.source.read(r6.bufferField, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonRequire(RealBufferedSource r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.request(r2) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    public static final boolean commonRequest(RealBufferedSource r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r8 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        if ((!r7.closed) == false) goto L16;
    L10:
        if (r7.bufferField.size() >= r8) goto L14;
        if (r7.source.read(r7.bufferField, 8192) != (-1)) goto L10;
        return false;
    L14:
        return true;
    L16:
        throw new IllegalStateException("closed".toString());
    L18:
        throw new IllegalArgumentException(("byteCount < 0: " + r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final byte commonReadByte(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.require(1);
        return r2.bufferField.readByte();
    }

    public static final ByteString commonReadByteString(RealBufferedSource r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.require(r2);
        return r1.bufferField.readByteString(r2);
    }

    public static final int commonSelect(RealBufferedSource r8, Options r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "options");
        if ((!r8.closed) == false) goto L14;
    L4:
        int r0 = _BufferKt.selectPrefix(r8.bufferField, r9, true);
        if (r0 != (-2)) goto L6;
        if (r8.source.read(r8.bufferField, 8192) != (-1)) goto L4;
        return -1;
    L6:
        if (r0 == (-1)) goto L9;
        r8.bufferField.skip(r9.getByteStrings$okio()[r0].size());
        return r0;
    L9:
        return -1;
    L14:
        throw new IllegalStateException("closed".toString());
    }

    public static final byte[] commonReadByteArray(RealBufferedSource r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.require(r2);
        return r1.bufferField.readByteArray(r2);
    }

    public static final void commonReadFully(RealBufferedSource r6, byte[] r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "sink");
        r6.require(r7.length);     // Catch: EOFException -> L6
        r6.bufferField.readFully(r7);
        return;
    L6:
        e = move-exception;
        int r1 = 0;
    L9:
        if (r6.bufferField.size() <= 0) goto L15;
        int r2 = r6.bufferField.read(r7, r1, (int) r6.bufferField.size());
        if (r2 == (-1)) goto L14;
        r1 = r1 + r2;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    public static final int commonRead(RealBufferedSource r9, byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r10, "sink");
        long r7 = r12;
        _UtilKt.checkOffsetAndCount(r10.length, r11, r7);
        if (r9.bufferField.size() != 0) goto L9;
        if (r9.source.read(r9.bufferField, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return r9.bufferField.read(r10, r11, (int) Math.min(r7, r9.bufferField.size()));
    }

    public static final void commonReadFully(RealBufferedSource r1, Buffer r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "sink");
        r1.require(r3);     // Catch: EOFException -> L6
        r1.bufferField.readFully(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.writeAll(r1.bufferField);
        throw e;
    }

    public static final long commonReadAll(RealBufferedSource r8, Sink r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "sink");
        long r2 = 0;
    L4:
        if (r8.source.read(r8.bufferField, 8192) == (-1)) goto L9;
        long r4 = r8.bufferField.completeSegmentByteCount();
        if (r4 <= 0) goto L4;
        r2 = r2 + r4;
        r9.write(r8.bufferField, r4);
        goto L4
    L9:
        if (r8.bufferField.size() <= 0) goto L17;
        long r3 = r2 + r8.bufferField.size();
        r9.write(r8.bufferField, r8.bufferField.size());
        return r3;
    L17:
        return r2;
    }

    public static final String commonReadUtf8(RealBufferedSource r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.require(r2);
        return r1.bufferField.readUtf8(r2);
    }

    public static final String commonReadUtf8Line(RealBufferedSource r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        long r0 = r4.indexOf((byte) 10);
        if (r0 != (-1)) goto L9;
        if (r4.bufferField.size() != 0) goto L10;
        return null;
    L10:
        return r4.readUtf8(r4.bufferField.size());
    L9:
        return _BufferKt.readUtf8Line(r4.bufferField, r0);
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        if (r14 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L30;
        if (r14 != Long.MAX_VALUE) goto L10;
        long r5 = Long.MAX_VALUE;
    L11:
        long r7 = r13.indexOf((byte) 10, 0, r5);
        if (r7 == (-1)) goto L16;
        return _BufferKt.readUtf8Line(r13.bufferField, r7);
    L16:
        if (r5 < Long.MAX_VALUE) goto L18;
    L27:
        Buffer r6 = new Buffer();
        r13.bufferField.copyTo(r6, 0, Math.min(32, r13.bufferField.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(r13.bufferField.size(), r14) + " content=" + r6.readByteString().hex() + 8230);
    L18:
        if (r13.request(r5) == false) goto L27;
        if (r13.bufferField.getByte(r5 - 1) != 13) goto L27;
        if (r13.request(1 + r5) == false) goto L27;
        if (r13.bufferField.getByte(r5) != 10) goto L27;
        return _BufferKt.readUtf8Line(r13.bufferField, r5);
    L10:
        r5 = r14 + 1;
        goto L11
    L30:
        throw new IllegalArgumentException(("limit < 0: " + r14).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.require(1);
        byte r0 = r3.bufferField.getByte(0);
        if ((r0 & 224) != 192) goto L6;
        r3.require(2);
    L12:
        return r3.bufferField.readUtf8CodePoint();
    L6:
        if ((r0 & 240) != 224) goto L9;
        r3.require(3);
        goto L12
    L9:
        if ((r0 & 248) != 240) goto L12;
        r3.require(4);
        goto L12
    }

    public static final short commonReadShort(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.require(2);
        return r2.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.require(2);
        return r2.bufferField.readShortLe();
    }

    public static final int commonReadInt(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.require(4);
        return r2.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.require(4);
        return r2.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.require(8);
        return r2.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.require(8);
        return r2.bufferField.readLongLe();
    }

    public static final long commonReadDecimalLong(RealBufferedSource r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.require(1);
        long r4 = 0;
    L3:
        long r6 = r4 + 1;
        if (r10.request(r6) == false) goto L20;
        byte r8 = r10.bufferField.getByte(r4);
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
        return r10.bufferField.readDecimalLong();
    }

    public static final long commonReadHexadecimalUnsignedLong(RealBufferedSource r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.require(1);
        int r0 = 0;
    L3:
        int r1 = r0 + 1;
        if (r5.request(r1) == false) goto L24;
        byte r2 = r5.bufferField.getByte(r0);
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
        return r5.bufferField.readHexadecimalUnsignedLong();
    }

    public static final void commonSkip(RealBufferedSource r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((!r4.closed) == false) goto L16;
    L5:
        if (r5 <= 0) goto L14;
        if (r4.bufferField.size() != 0) goto L13;
        if (r4.source.read(r4.bufferField, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r0 = Math.min(r5, r4.bufferField.size());
        r4.bufferField.skip(r0);
        r5 = r5 - r0;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource r10, byte r11, long r12, long r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean r1 = true;
        if ((!r10.closed) == false) goto L26;
        if (0 <= r12) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L24;
    L12:
        if (r12 >= r14) goto L22;
        long r0 = r10.bufferField.indexOf(r11, r12, r14);
        if (r0 != (-1)) goto L15;
        long r2 = r10.bufferField.size();
        if (r2 >= r14) goto L22;
        if (r10.source.read(r10.bufferField, 8192) == (-1)) goto L22;
        r12 = Math.max(r12, r2);
        goto L12
    L15:
        return r0;
    L22:
        return -1;
    L24:
        throw new IllegalArgumentException(("fromIndex=" + r12 + " toIndex=" + r14).toString());
    L7:
        if (r12 > r14) goto L9;
    L26:
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(RealBufferedSource r8, ByteString r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "bytes");
        if ((!r8.closed) == false) goto L12;
    L4:
        long r0 = r8.bufferField.indexOf(r9, r10);
        if (r0 != (-1)) goto L6;
        long r1 = r8.bufferField.size();
        if (r8.source.read(r8.bufferField, 8192) == (-1)) goto L9;
        r10 = Math.max(r10, (r1 - ((long) r9.size())) + 1);
        goto L4
    L9:
        return -1;
    L6:
        return r0;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOfElement(RealBufferedSource r8, ByteString r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "targetBytes");
        if ((!r8.closed) == false) goto L12;
    L4:
        long r0 = r8.bufferField.indexOfElement(r9, r10);
        if (r0 != (-1)) goto L6;
        long r1 = r8.bufferField.size();
        if (r8.source.read(r8.bufferField, 8192) == (-1)) goto L9;
        r10 = Math.max(r10, r1);
        goto L4
    L9:
        return -1;
    L6:
        return r0;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    public static final boolean commonRangeEquals(RealBufferedSource r7, long r8, ByteString r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r10, "bytes");
        if ((!r7.closed) == false) goto L23;
        if (r8 < 0) goto L21;
        if (r11 < 0) goto L21;
        if (r12 < 0) goto L21;
        if ((r10.size() - r11) < r12) goto L21;
        int r0 = 0;
    L12:
        if (r0 >= r12) goto L20;
        long r3 = ((long) r0) + r8;
        if (r7.request(1 + r3) == false) goto L15;
        if (r7.bufferField.getByte(r3) != r10.getByte(r11 + r0)) goto L18;
        r0 = r0 + 1;
        goto L12
    L18:
        return false;
    L15:
        return false;
    L20:
        return true;
    L21:
        return false;
    L23:
        throw new IllegalStateException("closed".toString());
    }

    public static final BufferedSource commonPeek(RealBufferedSource r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Okio.buffer(new PeekSource(r1));
    }

    public static final void commonClose(RealBufferedSource r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.closed == false) goto L5;
        return;
    L5:
        r1.closed = true;
        r1.source.close();
        r1.bufferField.clear();
    }

    public static final Timeout commonTimeout(RealBufferedSource r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.source.timeout();
    }

    public static final String commonToString(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return "buffer(" + r2.source + ')';
    }

    public static final ByteString commonReadByteString(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.bufferField.writeAll(r2.source);
        return r2.bufferField.readByteString();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.bufferField.writeAll(r2.source);
        return r2.bufferField.readByteArray();
    }

    public static final String commonReadUtf8(RealBufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.bufferField.writeAll(r2.source);
        return r2.bufferField.readUtf8();
    }
}
