package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.MessageConstraintException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* JADX INFO: loaded from: classes5.dex */
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
    private final byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream inStream;
    private final ByteArrayBuffer lineBuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl r2, int r3, int r4, MessageConstraints r5, CharsetDecoder r6) {
        Args.notNull(r2, "HTTP transport metrcis");
        Args.positive(r3, "Buffer size");
        this.metrics = r2;
        this.buffer = new byte[r3];
        this.bufferPos = 0;
        this.bufferLen = 0;
        if (r4 >= 0) goto L6;
        r4 = 512;
    L6:
        this.minChunkLimit = r4;
        if (r5 != null) goto L10;
        r5 = MessageConstraints.DEFAULT;
    L10:
        this.constraints = r5;
        this.lineBuffer = new ByteArrayBuffer(r3);
        this.decoder = r6;
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl r7, int r8) {
        this(r7, r8, r8, null, null);
    }

    public void bind(InputStream r1) {
        this.inStream = r1;
    }

    public boolean isBound() {
        if (this.inStream == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int length() {
        return this.bufferLen - this.bufferPos;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    private int streamRead(byte[] r3, int r4, int r5) throws IOException {
        Asserts.notNull(this.inStream, "Input stream");
        return this.inStream.read(r3, r4, r5);
    }

    public int fillBuffer() throws IOException {
        int r0 = this.bufferPos;
        if (r0 <= 0) goto L8;
        int r1 = this.bufferLen - r0;
        if (r1 <= 0) goto L7;
        byte[] r3 = this.buffer;
        System.arraycopy(r3, r0, r3, 0, r1);
    L7:
        this.bufferPos = 0;
        this.bufferLen = r1;
    L8:
        int r2 = this.bufferLen;
        byte[] r4 = this.buffer;
        int r5 = streamRead(r4, r2, r4.length - r2);
        if (r5 != (-1)) goto L11;
        return -1;
    L11:
        this.bufferLen = r2 + r5;
        this.metrics.incrementBytesTransferred(r5);
        return r5;
    }

    public boolean hasBufferedData() {
        if (this.bufferPos >= this.bufferLen) goto L5;
        return true;
    L5:
        return false;
    }

    public void clear() {
        this.bufferPos = 0;
        this.bufferLen = 0;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read() throws IOException {
    L3:
        if (hasBufferedData() == true) goto L7;
        if (fillBuffer() != (-1)) goto L3;
        return -1;
    L7:
        byte[] r0 = this.buffer;
        int r1 = this.bufferPos;
        this.bufferPos = r1 + 1;
        return r0[r1] & 255;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] r3, int r4, int r5) throws IOException {
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (hasBufferedData() == false) goto L10;
        int r6 = Math.min(r5, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, r3, r4, r6);
        this.bufferPos += r6;
        return r6;
    L10:
        if (r5 <= this.minChunkLimit) goto L16;
        int r7 = streamRead(r3, r4, r5);
        if (r7 <= 0) goto L14;
        this.metrics.incrementBytesTransferred(r7);
    L14:
        return r7;
    L16:
        if (hasBufferedData() == true) goto L20;
        if (fillBuffer() != (-1)) goto L16;
        return -1;
    L20:
        int r8 = Math.min(r5, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, r3, r4, r8);
        this.bufferPos += r8;
        return r8;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int read(byte[] r3) throws IOException {
        if (r3 != null) goto L6;
        return 0;
    L6:
        return read(r3, 0, r3.length);
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int readLine(CharArrayBuffer r9) throws IOException {
        Args.notNull(r9, "Char array buffer");
        int r0 = this.constraints.getMaxLineLength();
        boolean r2 = true;
        int r3 = 0;
    L4:
        if (r2 == false) goto L36;
        int r5 = this.bufferPos;
    L7:
        if (r5 >= this.bufferLen) goto L12;
        if (this.buffer[r5] == 10) goto L13;
        r5 = r5 + 1;
    L13:
        if (r0 <= 0) goto L23;
        int r6 = this.lineBuffer.length();
        if (r5 < 0) goto L17;
        int r7 = r5;
    L19:
        if (((r6 + r7) - this.bufferPos) < r0) goto L23;
        throw new MessageConstraintException("Maximum line length limit exceeded");
    L17:
        r7 = this.bufferLen;
    L23:
        if (r5 != (-1)) goto L25;
        if (hasBufferedData() == false) goto L33;
        int r4 = this.bufferLen;
        int r8 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r8, r4 - r8);
        this.bufferPos = this.bufferLen;
    L33:
        r3 = fillBuffer();
        if (r3 != (-1)) goto L4;
    L29:
        r2 = false;
        goto L4
    L25:
        if (this.lineBuffer.isEmpty() == true) goto L27;
        int r10 = r5 + 1;
        int r11 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r11, r10 - r11);
        this.bufferPos = r10;
        goto L29
    L27:
        return lineFromReadBuffer(r9, r5);
    L12:
        r5 = -1;
        goto L13
    L36:
        if (r3 != (-1)) goto L41;
        if (this.lineBuffer.isEmpty() == false) goto L41;
        return -1;
    L41:
        return lineFromLineBuffer(r9);
    }

    private int lineFromLineBuffer(CharArrayBuffer r4) throws IOException {
        int r0 = this.lineBuffer.length();
        if (r0 <= 0) goto L12;
        if (this.lineBuffer.byteAt(r0 - 1) != 10) goto L7;
        r0 = r0 - 1;
    L7:
        if (r0 <= 0) goto L12;
        if (this.lineBuffer.byteAt(r0 - 1) != 13) goto L12;
        r0 = r0 - 1;
    L12:
        if (this.decoder != null) goto L14;
        r4.append(this.lineBuffer, 0, r0);
    L15:
        this.lineBuffer.clear();
        return r0;
    L14:
        r0 = appendDecoded(r4, ByteBuffer.wrap(this.lineBuffer.buffer(), 0, r0));
        goto L15
    }

    private int lineFromReadBuffer(CharArrayBuffer r4, int r5) throws IOException {
        int r0 = this.bufferPos;
        this.bufferPos = r5 + 1;
        if (r5 > r0) goto L5;
    L7:
        int r6 = r5 - r0;
        if (this.decoder != null) goto L11;
        r4.append(this.buffer, r0, r6);
        return r6;
    L11:
        return appendDecoded(r4, ByteBuffer.wrap(this.buffer, r0, r6));
    L5:
        if (this.buffer[r5 - 1] != 13) goto L7;
        r5 = r5 - 1;
        goto L7
    }

    private int appendDecoded(CharArrayBuffer r5, ByteBuffer r6) throws IOException {
        int r1 = 0;
        if (r6.hasRemaining() == true) goto L6;
        return 0;
    L6:
        if (this.cbuf != null) goto L8;
        this.cbuf = CharBuffer.allocate(1024);
    L8:
        this.decoder.reset();
    L10:
        if (r6.hasRemaining() == false) goto L12;
        r1 = r1 + handleDecodingResult(this.decoder.decode(r6, this.cbuf, true), r5, r6);
        goto L10
    L12:
        int r2 = r1 + handleDecodingResult(this.decoder.flush(this.cbuf), r5, r6);
        this.cbuf.clear();
        return r2;
    }

    private int handleDecodingResult(CoderResult r1, CharArrayBuffer r2, ByteBuffer r3) throws IOException {
        if (r1.isError() == false) goto L5;
        r1.throwException();
    L5:
        this.cbuf.flip();
        int r4 = this.cbuf.remaining();
    L7:
        if (this.cbuf.hasRemaining() == false) goto L9;
        r2.append(this.cbuf.get());
        goto L7
    L9:
        this.cbuf.compact();
        return r4;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public String readLine() throws IOException {
        CharArrayBuffer r0 = new CharArrayBuffer(64);
        if (readLine(r0) != (-1)) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public boolean isDataAvailable(int r1) throws IOException {
        return hasBufferedData();
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
