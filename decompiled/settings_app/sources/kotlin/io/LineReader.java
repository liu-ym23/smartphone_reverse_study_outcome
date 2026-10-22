package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Console.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    public static final LineReader INSTANCE = null;
    private static final ByteBuffer byteBuf = null;
    private static final byte[] bytes = null;
    private static final CharBuffer charBuf = null;
    private static final char[] chars = null;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb = null;

    private LineReader() {
    }

    static {
        INSTANCE = new LineReader();
        byte[] r1 = new byte[32];
        bytes = r1;
        char[] r0 = new char[32];
        chars = r0;
        ByteBuffer r2 = ByteBuffer.wrap(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "wrap(...)");
        byteBuf = r2;
        CharBuffer r3 = CharBuffer.wrap(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "wrap(...)");
        charBuf = r3;
        sb = new StringBuilder();
    }

    public final synchronized String readLine(InputStream r11, Charset r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "inputStream");     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r12, "charset");     // Catch: Throwable -> L59
        CharsetDecoder r0 = decoder;     // Catch: Throwable -> L59
        if (r0 == null) goto L9;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");     // Catch: Throwable -> L59
        r0 = null;
    L8:
        if (Intrinsics.areEqual(r0.charset(), r12) == false) goto L9;
    L10:
        int r1 = 0;
        int r2 = 0;
    L11:
        int r3 = r11.read();     // Catch: Throwable -> L59
        boolean r7 = true;
        if (r3 == (-1)) goto L14;
        int r8 = r1 + 1;     // Catch: Throwable -> L59
        bytes[r1] = (byte) r3;     // Catch: Throwable -> L59
        if (r3 == 10) goto L30;
        if (r8 == 32) goto L30;
        if (directEOL == false) goto L30;
        r1 = r8;
    L30:
        ByteBuffer r4 = byteBuf;     // Catch: Throwable -> L59
        r4.limit(r8);     // Catch: Throwable -> L59
        charBuf.position(r2);     // Catch: Throwable -> L59
        r2 = decode(false);     // Catch: Throwable -> L59
        if (r2 > 0) goto L33;
    L57:
        r1 = compactBytes();     // Catch: Throwable -> L59
        goto L11
    L33:
        if (chars[r2 - 1] != '\n') goto L57;
        r4.position(0);     // Catch: Throwable -> L59
        int r13 = r2;
    L35:
        if (r13 <= 0) goto L43;
        char[] r5 = chars;     // Catch: Throwable -> L59
        if (r5[r13 - 1] != '\n') goto L43;
        r13 = r13 - 1;     // Catch: Throwable -> L59
        if (r13 <= 0) goto L43;
        if (r5[r13 - 1] != '\r') goto L43;
        r13 = r13 - 1;     // Catch: Throwable -> L59
    L43:
        StringBuilder r6 = sb;     // Catch: Throwable -> L59
        if (r6.length() == 0) goto L47;
        r7 = false;
    L47:
        if (r7 == false) goto L51;
        String r9 = new String(chars, 0, r13);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r9;
    L51:
        r6.append(chars, 0, r13);     // Catch: Throwable -> L59
        String r14 = r6.toString();     // Catch: Throwable -> L59
        Intrinsics.checkNotNullExpressionValue(r14, "toString(...)");     // Catch: Throwable -> L59
        if (r6.length() <= 32) goto L54;
        trimStringBuilder();     // Catch: Throwable -> L59
    L54:
        r6.setLength(0);     // Catch: Throwable -> L59
        monitor-exit(this);
        return r14;
    L14:
        if (sb.length() != 0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == false) goto L22;
        if (r1 != 0) goto L22;
        if (r2 != 0) goto L22;
        monitor-exit(this);
        return null;
    L22:
        r13 = decodeEndOfInput(r1, r2);     // Catch: Throwable -> L59
        goto L35
    L16:
        r15 = false;
    L9:
        updateCharset(r12);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    }

    private final int decode(boolean r6) {
    L2:
        CharsetDecoder r0 = decoder;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r0 = null;
    L5:
        ByteBuffer r1 = byteBuf;
        CharBuffer r2 = charBuf;
        CoderResult r3 = r0.decode(r1, r2, r6);
        Intrinsics.checkNotNullExpressionValue(r3, "decode(...)");
        if (r3.isError() == false) goto L8;
        resetAll();
        r3.throwException();
    L8:
        int r4 = r2.position();
        if (r3.isOverflow() == false) goto L10;
        StringBuilder r5 = sb;
        char[] r7 = chars;
        int r8 = r4 - 1;
        r5.append(r7, 0, r8);
        r2.position(0);
        r2.limit(32);
        r2.put(r7[r8]);
        goto L2
    L10:
        return r4;
    }

    private final int compactBytes() {
        ByteBuffer r2 = byteBuf;
        r2.compact();
        int r0 = r2.position();
        r2.position(0);
        return r0;
    }

    private final int decodeEndOfInput(int r2, int r3) {
        ByteBuffer r0 = byteBuf;
        r0.limit(r2);
        charBuf.position(r3);
        int r1 = decode(true);
        CharsetDecoder r4 = decoder;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r4 = null;
    L5:
        r4.reset();
        r0.position(0);
        return r1;
    }

    private final void updateCharset(Charset r5) {
        CharsetDecoder r6 = r5.newDecoder();
        Intrinsics.checkNotNullExpressionValue(r6, "newDecoder(...)");
        decoder = r6;
        ByteBuffer r7 = byteBuf;
        r7.clear();
        CharBuffer r0 = charBuf;
        r0.clear();
        r7.put((byte) 10);
        r7.flip();
        CharsetDecoder r2 = decoder;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r2 = null;
    L5:
        boolean r3 = false;
        r2.decode(r7, r0, false);
        if (r0.position() == 1) goto L8;
    L10:
        directEOL = r3;
        resetAll();
        return;
    L8:
        if (r0.get(0) != '\n') goto L10;
        r3 = true;
        goto L10
    }

    private final void resetAll() {
        CharsetDecoder r1 = decoder;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("decoder");
        r1 = null;
    L5:
        r1.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    private final void trimStringBuilder() {
        StringBuilder r1 = sb;
        r1.setLength(32);
        r1.trimToSize();
    }
}
