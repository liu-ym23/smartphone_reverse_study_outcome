package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class ReaderInputStream extends InputStream {
    private ByteBuffer byteBuffer;
    private CharBuffer charBuffer;
    private boolean doneFlushing;
    private boolean draining;
    private final CharsetEncoder encoder;
    private boolean endOfInput;
    private final Reader reader;
    private final byte[] singleByte;

    ReaderInputStream(Reader r2, Charset r3, int r4) {
        this(r2, r3.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), r4);
    }

    ReaderInputStream(Reader r3, CharsetEncoder r4, int r5) {
        boolean r0 = true;
        this.singleByte = new byte[1];
        this.reader = (Reader) Preconditions.checkNotNull(r3);
        this.encoder = (CharsetEncoder) Preconditions.checkNotNull(r4);
        if (r5 > 0) goto L6;
        r0 = false;
    L6:
        Preconditions.checkArgument(r0, "bufferSize must be positive: %s", r5);
        r4.reset();
        CharBuffer r6 = CharBuffer.allocate(r5);
        this.charBuffer = r6;
        Java8Compatibility.flip(r6);
        this.byteBuffer = ByteBuffer.allocate(r5);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.singleByte) == 1) goto L7;
        return -1;
    L7:
        return UnsignedBytes.toInt(this.singleByte[0]);
    }

    @Override // java.io.InputStream
    public int read(byte[] r8, int r9, int r10) throws IOException {
        Preconditions.checkPositionIndexes(r9, r9 + r10, r8.length);
        if (r10 != 0) goto L5;
        return 0;
    L5:
        boolean r1 = this.endOfInput;
        int r2 = 0;
    L7:
        if (this.draining == false) goto L19;
        r2 = r2 + drain(r8, r9 + r2, r10 - r2);
        if (r2 == r10) goto L14;
        if (this.doneFlushing == true) goto L14;
        this.draining = false;
        Java8Compatibility.clear(this.byteBuffer);
    L14:
        if (r2 > 0) goto L56;
        return -1;
    L56:
        return r2;
    L19:
        if (this.doneFlushing == false) goto L21;
        CoderResult r3 = CoderResult.UNDERFLOW;
    L25:
        if (r3.isOverflow() == true) goto L26;
        if (r3.isUnderflow() == true) goto L29;
        if (r3.isError() == false) goto L19;
        r3.throwException();
        return 0;
    L29:
        if (r1 == true) goto L30;
        if (this.endOfInput == true) goto L33;
        readMoreChars();
        goto L19
    L33:
        r1 = true;
        goto L19
    L30:
        this.doneFlushing = true;
        startDraining(false);
        goto L7
    L26:
        startDraining(true);
        goto L7
    L21:
        if (r1 == false) goto L23;
        r3 = this.encoder.flush(this.byteBuffer);
        goto L25
    L23:
        r3 = this.encoder.encode(this.charBuffer, this.byteBuffer, this.endOfInput);
        goto L25
    }

    private static CharBuffer grow(CharBuffer r2) {
        CharBuffer r0 = CharBuffer.wrap(Arrays.copyOf(r2.array(), r2.capacity() * 2));
        Java8Compatibility.position(r0, r2.position());
        Java8Compatibility.limit(r0, r2.limit());
        return r0;
    }

    private void readMoreChars() throws IOException {
        if (availableCapacity(this.charBuffer) == 0) goto L5;
    L8:
        int r0 = this.charBuffer.limit();
        int r1 = this.reader.read(this.charBuffer.array(), r0, availableCapacity(this.charBuffer));
        if (r1 != (-1)) goto L11;
        this.endOfInput = true;
        return;
    L11:
        Java8Compatibility.limit(this.charBuffer, r0 + r1);
        return;
    L5:
        if (this.charBuffer.position() <= 0) goto L7;
        Java8Compatibility.flip(this.charBuffer.compact());
        goto L8
    L7:
        this.charBuffer = grow(this.charBuffer);
        goto L8
    }

    private static int availableCapacity(Buffer r1) {
        return r1.capacity() - r1.limit();
    }

    private void startDraining(boolean r2) {
        Java8Compatibility.flip(this.byteBuffer);
        if (r2 == true) goto L5;
    L7:
        this.draining = true;
        return;
    L5:
        if (this.byteBuffer.remaining() != 0) goto L7;
        this.byteBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() * 2);
    }

    private int drain(byte[] r2, int r3, int r4) {
        int r5 = Math.min(r4, this.byteBuffer.remaining());
        this.byteBuffer.get(r2, r3, r5);
        return r5;
    }
}
