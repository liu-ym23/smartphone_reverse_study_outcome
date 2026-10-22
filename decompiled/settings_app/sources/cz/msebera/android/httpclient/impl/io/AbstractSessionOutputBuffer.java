package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.CoreProtocolPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = null;
    private boolean ascii;
    private ByteBuffer bbuf;
    private ByteArrayBuffer buffer;
    private Charset charset;
    private CharsetEncoder encoder;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;
    private OutputStream outStream;

    static {
        CRLF = new byte[]{13, 10};
    }

    protected AbstractSessionOutputBuffer(OutputStream r2, int r3, Charset r4, int r5, CodingErrorAction r6, CodingErrorAction r7) {
        Args.notNull(r2, "Input stream");
        Args.notNegative(r3, "Buffer size");
        this.outStream = r2;
        this.buffer = new ByteArrayBuffer(r3);
        if (r4 != null) goto L6;
        r4 = Consts.ASCII;
    L6:
        this.charset = r4;
        this.ascii = r4.equals(Consts.ASCII);
        this.encoder = null;
        if (r5 >= 0) goto L10;
        r5 = 512;
    L10:
        this.minChunkLimit = r5;
        this.metrics = createTransportMetrics();
        if (r6 != null) goto L14;
        r6 = CodingErrorAction.REPORT;
    L14:
        this.onMalformedCharAction = r6;
        if (r7 != null) goto L18;
        r7 = CodingErrorAction.REPORT;
    L18:
        this.onUnmappableCharAction = r7;
    }

    public AbstractSessionOutputBuffer() {
    }

    protected void init(OutputStream r2, int r3, HttpParams r4) {
        Args.notNull(r2, "Input stream");
        Args.notNegative(r3, "Buffer size");
        Args.notNull(r4, "HTTP parameters");
        this.outStream = r2;
        this.buffer = new ByteArrayBuffer(r3);
        String r5 = (String) r4.getParameter("http.protocol.element-charset");
        if (r5 == null) goto L5;
        Charset r6 = Charset.forName(r5);
    L6:
        this.charset = r6;
        this.ascii = r6.equals(Consts.ASCII);
        this.encoder = null;
        this.minChunkLimit = r4.getIntParameter(CoreConnectionPNames.MIN_CHUNK_LIMIT, 512);
        this.metrics = createTransportMetrics();
        CodingErrorAction r7 = (CodingErrorAction) r4.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION);
        if (r7 != null) goto L10;
        r7 = CodingErrorAction.REPORT;
    L10:
        this.onMalformedCharAction = r7;
        CodingErrorAction r8 = (CodingErrorAction) r4.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION);
        if (r8 != null) goto L14;
        r8 = CodingErrorAction.REPORT;
    L14:
        this.onUnmappableCharAction = r8;
        return;
    L5:
        r6 = Consts.ASCII;
        goto L6
    }

    protected HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
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

    protected void flushBuffer() throws IOException {
        int r0 = this.buffer.length();
        if (r0 <= 0) goto L6;
        this.outStream.write(this.buffer.buffer(), 0, r0);
        this.buffer.clear();
        this.metrics.incrementBytesTransferred(r0);
        return;
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void flush() throws IOException {
        flushBuffer();
        this.outStream.flush();
    }

    @Override // cz.msebera.android.httpclient.io.SessionOutputBuffer
    public void write(byte[] r3, int r4, int r5) throws IOException {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r5 <= this.minChunkLimit) goto L7;
    L13:
        flushBuffer();
        this.outStream.write(r3, r4, r5);
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
        if (this.buffer.isFull() == false) goto L5;
        flushBuffer();
    L5:
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
        if (this.ascii == false) goto L12;
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
        if (this.ascii == false) goto L15;
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
        if (this.encoder != null) goto L9;
        CharsetEncoder r0 = this.charset.newEncoder();
        this.encoder = r0;
        r0.onMalformedInput(this.onMalformedCharAction);
        this.encoder.onUnmappableCharacter(this.onUnmappableCharAction);
    L9:
        if (this.bbuf != null) goto L11;
        this.bbuf = ByteBuffer.allocate(1024);
    L11:
        this.encoder.reset();
    L13:
        if (r4.hasRemaining() == false) goto L15;
        handleEncodingResult(this.encoder.encode(r4, this.bbuf, true));
        goto L13
    L15:
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
