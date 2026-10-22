package kotlin.io.encoding;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Base64IOStream.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J(\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "input", "base64", "Lkotlin/io/encoding/Base64;", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferEndIndex", "", "byteBufferLength", "getByteBufferLength", "()I", "byteBufferStartIndex", "isClosed", "", "isEOF", "singleByteBuffer", "symbolBuffer", "close", "", "copyByteBufferInto", "dst", "dstOffset", "length", "decodeSymbolBufferInto", "dstEndIndex", "symbolBufferLength", "handlePaddingSymbol", "read", "destination", "offset", "readNextSymbol", "resetByteBufferIfEmpty", "shiftByteBufferToStartIfNeeded", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DecodeInputStream extends InputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferEndIndex;
    private int byteBufferStartIndex;
    private final InputStream input;
    private boolean isClosed;
    private boolean isEOF;
    private final byte[] singleByteBuffer;
    private final byte[] symbolBuffer;

    public DecodeInputStream(InputStream r2, Base64 r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "base64");
        this.input = r2;
        this.base64 = r3;
        this.singleByteBuffer = new byte[1];
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[1024];
    }

    private final int getByteBufferLength() {
        return this.byteBufferEndIndex - this.byteBufferStartIndex;
    }

    @Override // java.io.InputStream
    public int read() {
        int r0 = this.byteBufferStartIndex;
        if (r0 >= this.byteBufferEndIndex) goto L6;
        int r1 = this.byteBuffer[r0] & 255;
        this.byteBufferStartIndex = r0 + 1;
        resetByteBufferIfEmpty();
        return r1;
    L6:
        int r2 = read(this.singleByteBuffer, 0, 1);
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L11;
        return this.singleByteBuffer[0] & 255;
    L11:
        throw new IllegalStateException("Unreachable".toString());
    L12:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "destination");
        if (r11 < 0) goto L51;
        if (r12 < 0) goto L51;
        int r0 = r11 + r12;
        if (r0 > r10.length) goto L51;
        if (this.isClosed == true) goto L49;
        if (this.isEOF == false) goto L13;
        return -1;
    L13:
        if (r12 != 0) goto L16;
        return 0;
    L16:
        if (getByteBufferLength() < r12) goto L19;
        copyByteBufferInto(r10, r11, r12);
        return r12;
    L19:
        int r13 = ((((r12 - getByteBufferLength()) + 3) - 1) / 3) * 4;
        int r4 = r11;
    L20:
        boolean r5 = this.isEOF;
        if (r5 == true) goto L43;
        if (r13 <= 0) goto L43;
        int r6 = Math.min(this.symbolBuffer.length, r13);
        int r7 = 0;
    L24:
        boolean r8 = this.isEOF;
        if (r8 == true) goto L34;
        if (r7 >= r6) goto L34;
        int r9 = readNextSymbol();
        if (r9 != (-1)) goto L30;
        this.isEOF = true;
        goto L24
    L30:
        if (r9 != 61) goto L31;
        r7 = handlePaddingSymbol(r7);
        this.isEOF = true;
        goto L24
    L31:
        this.symbolBuffer[r7] = (byte) r9;
        r7 = r7 + 1;
    L34:
        if (r8 == true) goto L38;
        if (r7 == r6) goto L38;
        boolean r14 = false;
    L39:
        if (r14 == false) goto L42;
        r13 = r13 - r7;
        r4 = r4 + decodeSymbolBufferInto(r10, r4, r0, r7);
        goto L20
    L42:
        throw new IllegalStateException("Check failed.".toString());
    L38:
        r14 = true;
    L43:
        if (r4 != r11) goto L47;
        if (r5 == false) goto L47;
        return -1;
    L47:
        return r4 - r11;
    L49:
        throw new IOException("The input stream is closed.");
    L51:
        throw new IndexOutOfBoundsException("offset: " + r11 + ", length: " + r12 + ", buffer size: " + r10.length);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed == true) goto L6;
        this.isClosed = true;
        this.input.close();
        return;
    }

    private final int decodeSymbolBufferInto(byte[] r8, int r9, int r10, int r11) {
        int r6 = this.byteBufferEndIndex;
        this.byteBufferEndIndex = r6 + this.base64.decodeIntoByteArray(this.symbolBuffer, this.byteBuffer, r6, 0, r11);
        int r12 = Math.min(getByteBufferLength(), r10 - r9);
        copyByteBufferInto(r8, r9, r12);
        shiftByteBufferToStartIfNeeded();
        return r12;
    }

    private final void copyByteBufferInto(byte[] r4, int r5, int r6) {
        byte[] r0 = this.byteBuffer;
        int r1 = this.byteBufferStartIndex;
        ArraysKt.copyInto(r0, r4, r5, r1, r1 + r6);
        this.byteBufferStartIndex += r6;
        resetByteBufferIfEmpty();
    }

    private final void resetByteBufferIfEmpty() {
        if (this.byteBufferStartIndex != this.byteBufferEndIndex) goto L6;
        this.byteBufferStartIndex = 0;
        this.byteBufferEndIndex = 0;
        return;
    }

    private final void shiftByteBufferToStartIfNeeded() {
        byte[] r0 = this.byteBuffer;
        int r1 = r0.length;
        int r2 = this.byteBufferEndIndex;
        if (((this.symbolBuffer.length / 4) * 3) <= (r1 - r2)) goto L6;
        ArraysKt.copyInto(r0, r0, 0, this.byteBufferStartIndex, r2);
        this.byteBufferEndIndex -= this.byteBufferStartIndex;
        this.byteBufferStartIndex = 0;
        return;
    }

    private final int handlePaddingSymbol(int r4) {
        this.symbolBuffer[r4] = Base64.padSymbol;
        if ((r4 & 3) != 2) goto L9;
        int r0 = readNextSymbol();
        if (r0 < 0) goto L10;
        this.symbolBuffer[r4 + 1] = (byte) r0;
    L10:
        return r4 + 2;
    L9:
        return r4 + 1;
    }

    private final int readNextSymbol() {
        if (this.base64.isMimeScheme$kotlin_stdlib() == false) goto L5;
    L6:
        int r0 = this.input.read();
        if (r0 == (-1)) goto L10;
        if (Base64Kt.isInMimeAlphabet(r0) == false) goto L6;
    L10:
        return r0;
    L5:
        return this.input.read();
    }
}
