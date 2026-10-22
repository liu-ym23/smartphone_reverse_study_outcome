package kotlin.io.encoding;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Base64IOStream.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0016J \u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlin/io/encoding/EncodeOutputStream;", "Ljava/io/OutputStream;", "output", "base64", "Lkotlin/io/encoding/Base64;", "(Ljava/io/OutputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferLength", "", "isClosed", "", "lineLength", "symbolBuffer", "checkOpen", "", "close", "copyIntoByteBuffer", "source", "startIndex", "endIndex", "encodeByteBufferIntoOutput", "encodeIntoOutput", "flush", "write", "offset", "length", "b", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class EncodeOutputStream extends OutputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferLength;
    private boolean isClosed;
    private int lineLength;
    private final OutputStream output;
    private final byte[] symbolBuffer;

    public EncodeOutputStream(OutputStream r2, Base64 r3) {
        Intrinsics.checkNotNullParameter(r2, "output");
        Intrinsics.checkNotNullParameter(r3, "base64");
        this.output = r2;
        this.base64 = r3;
        if (r3.isMimeScheme$kotlin_stdlib() == false) goto L5;
        int r4 = 76;
    L6:
        this.lineLength = r4;
        this.symbolBuffer = new byte[1024];
        this.byteBuffer = new byte[3];
        return;
    L5:
        r4 = -1;
        goto L6
    }

    @Override // java.io.OutputStream
    public void write(int r4) {
        checkOpen();
        byte[] r0 = this.byteBuffer;
        int r1 = this.byteBufferLength;
        int r2 = r1 + 1;
        this.byteBufferLength = r2;
        r0[r1] = (byte) r4;
        if (r2 != 3) goto L6;
        encodeByteBufferIntoOutput();
        return;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "source");
        checkOpen();
        if (r8 < 0) goto L38;
        if (r9 < 0) goto L38;
        int r0 = r8 + r9;
        if (r0 > r7.length) goto L38;
        if (r9 != 0) goto L9;
        return;
    L9:
        int r10 = this.byteBufferLength;
        if (r10 >= 3) goto L12;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L36;
        if (r10 == 0) goto L20;
        r8 = r8 + copyIntoByteBuffer(r7, r8, r0);
        if (this.byteBufferLength == 0) goto L20;
        return;
    L20:
        if ((r8 + 3) > r0) goto L33;
        if (this.base64.isMimeScheme$kotlin_stdlib() == false) goto L24;
        int r11 = this.lineLength;
    L25:
        int r12 = Math.min(r11 / 4, (r0 - r8) / 3);
        int r5 = (r12 * 3) + r8;
        if (encodeIntoOutput(r7, r8, r5) != (r12 * 4)) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L32;
        r8 = r5;
        goto L20
    L32:
        throw new IllegalStateException("Check failed.".toString());
    L28:
        r13 = false;
        goto L29
    L24:
        r11 = this.symbolBuffer.length;
        goto L25
    L33:
        ArraysKt.copyInto(r7, this.byteBuffer, 0, r8, r0);
        this.byteBufferLength = r0 - r8;
        return;
    L36:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r4 = false;
    L38:
        throw new IndexOutOfBoundsException("offset: " + r8 + ", length: " + r9 + ", source size: " + r7.length);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        checkOpen();
        this.output.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed == true) goto L9;
        this.isClosed = true;
        if (this.byteBufferLength == 0) goto L7;
        encodeByteBufferIntoOutput();
    L7:
        this.output.close();
        return;
    }

    private final int copyIntoByteBuffer(byte[] r5, int r6, int r7) {
        int r8 = Math.min(3 - this.byteBufferLength, r7 - r6);
        ArraysKt.copyInto(r5, this.byteBuffer, this.byteBufferLength, r6, r6 + r8);
        int r9 = this.byteBufferLength + r8;
        this.byteBufferLength = r9;
        if (r9 != 3) goto L5;
        encodeByteBufferIntoOutput();
    L5:
        return r8;
    }

    private final void encodeByteBufferIntoOutput() {
        if (encodeIntoOutput(this.byteBuffer, 0, this.byteBufferLength) != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.byteBufferLength = 0;
        return;
    L10:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private final int encodeIntoOutput(byte[] r7, int r8, int r9) {
        int r10 = this.base64.encodeIntoByteArray(r7, this.symbolBuffer, 0, r8, r9);
        if (this.lineLength != 0) goto L12;
        this.output.write(Base64.Default.getMimeLineSeparatorSymbols$kotlin_stdlib());
        this.lineLength = 76;
        if (r10 > 76) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L12;
        throw new IllegalStateException("Check failed.".toString());
    L7:
        r11 = false;
    L12:
        this.output.write(this.symbolBuffer, 0, r10);
        this.lineLength -= r10;
        return r10;
    }

    private final void checkOpen() {
        if (this.isClosed == true) goto L6;
        return;
    L6:
        throw new IOException("The output stream is closed.");
    }
}
