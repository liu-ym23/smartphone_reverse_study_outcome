package okio.internal;

import a.a;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
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
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealBufferedSourceKt {
    public static final void commonClose(@NotNull RealBufferedSource r1) {
        Intrinsics.f(r1, "$this$commonClose");
        if (r1.closed == false) goto L5;
        return;
    L5:
        r1.closed = true;
        r1.source.close();
        r1.bufferField.clear();
    }

    public static final boolean commonExhausted(@NotNull RealBufferedSource r6) {
        Intrinsics.f(r6, "$this$commonExhausted");
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

    public static final long commonIndexOf(@NotNull RealBufferedSource r10, byte r11, long r12, long r14) {
        Intrinsics.f(r10, "$this$commonIndexOf");
        boolean r1 = true;
        if ((!r10.closed) == false) goto L27;
        if (0 <= r12) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == true) goto L13;
        StringBuilder r13 = a.s("fromIndex=", r12, " toIndex=");
        r13.append(r14);
        throw new IllegalArgumentException(r13.toString().toString());
    L13:
        if (r12 >= r14) goto L23;
        long r0 = r10.bufferField.indexOf(r11, r12, r14);
        if (r0 != (-1)) goto L16;
        long r2 = r10.bufferField.size();
        if (r2 >= r14) goto L23;
        if (r10.source.read(r10.bufferField, 8192) == (-1)) goto L23;
        r12 = Math.max(r12, r2);
        goto L13
    L16:
        return r0;
    L23:
        return -1;
    L8:
        if (r14 < r12) goto L10;
    L27:
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOfElement(@NotNull RealBufferedSource r8, @NotNull ByteString r9, long r10) {
        Intrinsics.f(r8, "$this$commonIndexOfElement");
        Intrinsics.f(r9, "targetBytes");
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

    @NotNull
    public static final BufferedSource commonPeek(@NotNull RealBufferedSource r1) {
        Intrinsics.f(r1, "$this$commonPeek");
        return Okio.buffer(new PeekSource(r1));
    }

    public static final boolean commonRangeEquals(@NotNull RealBufferedSource r7, long r8, @NotNull ByteString r10, int r11, int r12) {
        Intrinsics.f(r7, "$this$commonRangeEquals");
        Intrinsics.f(r10, "bytes");
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

    public static final long commonRead(@NotNull RealBufferedSource r4, @NotNull Buffer r5, long r6) {
        Intrinsics.f(r4, "$this$commonRead");
        Intrinsics.f(r5, "sink");
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
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r6).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final long commonReadAll(@NotNull RealBufferedSource r8, @NotNull Sink r9) {
        Intrinsics.f(r8, "$this$commonReadAll");
        Intrinsics.f(r9, "sink");
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
        Buffer r10 = r8.bufferField;
        r9.write(r10, r10.size());
        return r3;
    L17:
        return r2;
    }

    public static final byte commonReadByte(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadByte");
        r2.require(1);
        return r2.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource r1, long r2) {
        Intrinsics.f(r1, "$this$commonReadByteArray");
        r1.require(r2);
        return r1.bufferField.readByteArray(r2);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource r1, long r2) {
        Intrinsics.f(r1, "$this$commonReadByteString");
        r1.require(r2);
        return r1.bufferField.readByteString(r2);
    }

    public static final long commonReadDecimalLong(@NotNull RealBufferedSource r10) {
        Intrinsics.f(r10, "$this$commonReadDecimalLong");
        r10.require(1);
        long r4 = 0;
    L3:
        long r6 = r4 + 1;
        if (r10.request(r6) == false) goto L20;
        byte r8 = r10.bufferField.getByte(r4);
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
        return r10.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource r6, @NotNull byte[] r7) {
        Intrinsics.f(r6, "$this$commonReadFully");
        Intrinsics.f(r7, "sink");
        r6.require(r7.length);     // Catch: EOFException -> L6
        r6.bufferField.readFully(r7);
        return;
    L6:
        e = move-exception;
        int r1 = 0;
    L9:
        if (r6.bufferField.size() <= 0) goto L15;
        Buffer r2 = r6.bufferField;
        int r3 = r2.read(r7, r1, (int) r2.size());
        if (r3 == (-1)) goto L14;
        r1 = r1 + r3;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull RealBufferedSource r5) {
        Intrinsics.f(r5, "$this$commonReadHexadecimalUnsignedLong");
        r5.require(1);
        int r0 = 0;
    L3:
        int r1 = r0 + 1;
        if (r5.request(r1) == false) goto L24;
        byte r2 = r5.bufferField.getByte(r0);
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
        return r5.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadInt");
        r2.require(4);
        return r2.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadIntLe");
        r2.require(4);
        return r2.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadLong");
        r2.require(8);
        return r2.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadLongLe");
        r2.require(8);
        return r2.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadShort");
        r2.require(2);
        return r2.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadShortLe");
        r2.require(2);
        return r2.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource r1, long r2) {
        Intrinsics.f(r1, "$this$commonReadUtf8");
        r1.require(r2);
        return r1.bufferField.readUtf8(r2);
    }

    public static final int commonReadUtf8CodePoint(@NotNull RealBufferedSource r3) {
        Intrinsics.f(r3, "$this$commonReadUtf8CodePoint");
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

    @Nullable
    public static final String commonReadUtf8Line(@NotNull RealBufferedSource r4) {
        Intrinsics.f(r4, "$this$commonReadUtf8Line");
        long r0 = r4.indexOf((byte) 10);
        if (r0 != (-1)) goto L9;
        if (r4.bufferField.size() != 0) goto L10;
        return null;
    L10:
        return r4.readUtf8(r4.bufferField.size());
    L9:
        return BufferKt.readUtf8Line(r4.bufferField, r0);
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull RealBufferedSource r13, long r14) {
        Intrinsics.f(r13, "$this$commonReadUtf8LineStrict");
        if (r14 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L30;
        if (r14 != Long.MAX_VALUE) goto L10;
        long r5 = Long.MAX_VALUE;
    L11:
        byte r2 = (byte) 10;
        long r7 = r13.indexOf(r2, 0, r5);
        if (r7 == (-1)) goto L16;
        return BufferKt.readUtf8Line(r13.bufferField, r7);
    L16:
        if (r5 < Long.MAX_VALUE) goto L18;
    L27:
        Buffer r6 = new Buffer();
        Buffer r1 = r13.bufferField;
        r1.copyTo(r6, 0, Math.min(32, r1.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(r13.bufferField.size(), r14) + " content=" + r6.readByteString().hex() + "…");
    L18:
        if (r13.request(r5) == false) goto L27;
        if (r13.bufferField.getByte(r5 - 1) != ((byte) 13)) goto L27;
        if (r13.request(1 + r5) == false) goto L27;
        if (r13.bufferField.getByte(r5) != r2) goto L27;
        return BufferKt.readUtf8Line(r13.bufferField, r5);
    L10:
        r5 = r14 + 1;
        goto L11
    L30:
        throw new IllegalArgumentException(a.h("limit < 0: ", r14).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final boolean commonRequest(@NotNull RealBufferedSource r7, long r8) {
        Intrinsics.f(r7, "$this$commonRequest");
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
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final void commonRequire(@NotNull RealBufferedSource r1, long r2) {
        Intrinsics.f(r1, "$this$commonRequire");
        if (r1.request(r2) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    public static final int commonSelect(@NotNull RealBufferedSource r8, @NotNull Options r9) {
        Intrinsics.f(r8, "$this$commonSelect");
        Intrinsics.f(r9, "options");
        if ((!r8.closed) == false) goto L14;
    L4:
        int r0 = BufferKt.selectPrefix(r8.bufferField, r9, true);
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

    public static final void commonSkip(@NotNull RealBufferedSource r4, long r5) {
        Intrinsics.f(r4, "$this$commonSkip");
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

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSource r1) {
        Intrinsics.f(r1, "$this$commonTimeout");
        return r1.source.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonToString");
        return "buffer(" + r2.source + ')';
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadByteArray");
        r2.bufferField.writeAll(r2.source);
        return r2.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadByteString");
        r2.bufferField.writeAll(r2.source);
        return r2.bufferField.readByteString();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource r2) {
        Intrinsics.f(r2, "$this$commonReadUtf8");
        r2.bufferField.writeAll(r2.source);
        return r2.bufferField.readUtf8();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource r1, @NotNull Buffer r2, long r3) {
        Intrinsics.f(r1, "$this$commonReadFully");
        Intrinsics.f(r2, "sink");
        r1.require(r3);     // Catch: EOFException -> L6
        r1.bufferField.readFully(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.writeAll(r1.bufferField);
        throw e;
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource r8, @NotNull ByteString r9, long r10) {
        Intrinsics.f(r8, "$this$commonIndexOf");
        Intrinsics.f(r9, "bytes");
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

    public static final int commonRead(@NotNull RealBufferedSource r9, @NotNull byte[] r10, int r11, int r12) {
        Intrinsics.f(r9, "$this$commonRead");
        Intrinsics.f(r10, "sink");
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        if (r9.bufferField.size() != 0) goto L9;
        if (r9.source.read(r9.bufferField, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return r9.bufferField.read(r10, r11, (int) Math.min(r7, r9.bufferField.size()));
    }
}
