package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/* JADX INFO: loaded from: classes5.dex */
public class SessionOutputBufferImpl implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = null;
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragementSizeHint;
    private final HttpTransportMetricsImpl metrics;
    private OutputStream outStream;

    static {
        CRLF = new byte[]{13, 10};
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl r2, int r3, int r4, CharsetEncoder r5) {
        Args.positive(r3, "Buffer size");
        Args.notNull(r2, "HTTP transport metrcis");
        this.metrics = r2;
        this.buffer = new ByteArrayBuffer(r3);
        if (r4 >= 0) goto L6;
        r4 = 0;
    L6:
        this.fragementSizeHint = r4;
        this.encoder = r5;
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl r2, int r3) {
        this(r2, r3, r3, null);
    }

    public void bind(OutputStream r1) {
        this.outStream = r1;
    }

    public boolean isBound() {
        if (this.outStream == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int length() {
        return this.buffer.length();
    }

    @Override // cz.msebera.android.httpclient.io.BufferInfo
    public int available() {
        return capacity() - length();
    }

    private void streamWrite(byte[] r3, int r4, int r5) throws IOException {
        Asserts.notNull(this.outStream, "Output stream");
        this.outStream.write(r3, r4, r5);
    }

    private void flushStream() throws IOException {
        OutputStream r0 = this.outStream;
        if (r0 == null) goto L6;
        r0.flush();
        return;
    }

    private void flushBuffer() throws IOException {
        int r0 = this.buffer.length();
        if (r0 <= 0) goto L6;
        streamWrite(this.buffer.buffer(), 0, r0);
        this.buffer.clear();
        this.metrics.incrementBytesTransferred(r0);
        return;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void flush() throws IOException {
        flushBuffer();
        flushStream();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] r3, int r4, int r5) throws IOException {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r5 <= this.fragementSizeHint) goto L7;
    L13:
        flushBuffer();
        streamWrite(r3, r4, r5);
        this.metrics.incrementBytesTransferred(r5);
        return;
    L7:
        if (r5 > this.buffer.capacity()) goto L13;
        if (r5 <= (this.buffer.capacity() - this.buffer.length())) goto L12;
        flushBuffer();
    L12:
        this.buffer.append(r3, r4, r5);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] r3) throws IOException {
        if (r3 != null) goto L4;
        return;
    L4:
        write(r3, 0, r3.length);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(int r2) throws IOException {
        if (this.fragementSizeHint > 0) goto L5;
        flushBuffer();
        this.outStream.write(r2);
        return;
    L5:
        if (this.buffer.isFull() == false) goto L7;
        flushBuffer();
    L7:
        this.buffer.append(r2);
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(String r3) throws IOException {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length() > 0) goto L7;
    L13:
        write(CRLF);
        return;
    L7:
        if (this.encoder != null) goto L12;
        int r0 = 0;
    L10:
        if (r0 >= r3.length()) goto L13;
        write(r3.charAt(r0));
        r0 = r0 + 1;
        goto L10
    L12:
        writeEncoded(CharBuffer.wrap(r3));
        goto L13
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer r5) throws IOException {
        if (r5 != null) goto L4;
        return;
    L4:
        int r1 = 0;
        if (this.encoder != null) goto L15;
        int r0 = r5.length();
    L7:
        if (r0 <= 0) goto L16;
        int r2 = Math.min(this.buffer.capacity() - this.buffer.length(), r0);
        if (r2 <= 0) goto L12;
        this.buffer.append(r5, r1, r2);
    L12:
        if (this.buffer.isFull() == false) goto L14;
        flushBuffer();
    L14:
        r1 = r1 + r2;
        r0 = r0 - r2;
    L16:
        write(CRLF);
        return;
    L15:
        writeEncoded(CharBuffer.wrap(r5.buffer(), 0, r5.length()));
        goto L16
    }

    private void writeEncoded(CharBuffer r4) throws IOException {
        if (r4.hasRemaining() == true) goto L6;
        return;
    L6:
        if (this.bbuf != null) goto L8;
        this.bbuf = ByteBuffer.allocate(1024);
    L8:
        this.encoder.reset();
    L10:
        if (r4.hasRemaining() == false) goto L12;
        handleEncodingResult(this.encoder.encode(r4, this.bbuf, true));
        goto L10
    L12:
        handleEncodingResult(this.encoder.flush(this.bbuf));
        this.bbuf.clear();
    }

    private void handleEncodingResult(CoderResult r2) throws IOException {
        if (r2.isError() == false) goto L5;
        r2.throwException();
    L5:
        this.bbuf.flip();
    L7:
        if (this.bbuf.hasRemaining() == false) goto L9;
        write(this.bbuf.get());
        goto L7
    L9:
        this.bbuf.compact();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
