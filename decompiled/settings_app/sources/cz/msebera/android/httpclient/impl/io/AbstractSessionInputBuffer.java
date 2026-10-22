package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.HttpTransportMetrics;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.params.CoreConnectionPNames;
import cz.msebera.android.httpclient.params.CoreProtocolPNames;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractSessionInputBuffer implements SessionInputBuffer, BufferInfo {
    private boolean ascii;
    private byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private Charset charset;
    private CharsetDecoder decoder;
    private InputStream inStream;
    private ByteArrayBuffer lineBuffer;
    private int maxLineLen;
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;

    public AbstractSessionInputBuffer() {
    }

    protected void init(InputStream r2, int r3, HttpParams r4) {
        Args.notNull(r2, "Input stream");
        Args.notNegative(r3, "Buffer size");
        Args.notNull(r4, "HTTP parameters");
        this.inStream = r2;
        this.buffer = new byte[r3];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.lineBuffer = new ByteArrayBuffer(r3);
        String r5 = (String) r4.getParameter("http.protocol.element-charset");
        if (r5 == null) goto L5;
        Charset r6 = Charset.forName(r5);
    L6:
        this.charset = r6;
        this.ascii = r6.equals(Consts.ASCII);
        this.decoder = null;
        this.maxLineLen = r4.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
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

    protected int fillBuffer() throws IOException {
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
        int r5 = this.inStream.read(r4, r2, r4.length - r2);
        if (r5 != (-1)) goto L11;
        return -1;
    L11:
        this.bufferLen = r2 + r5;
        this.metrics.incrementBytesTransferred(r5);
        return r5;
    }

    protected boolean hasBufferedData() {
        if (this.bufferPos >= this.bufferLen) goto L5;
        return true;
    L5:
        return false;
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
        int r7 = this.inStream.read(r3, r4, r5);
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

    private int locateLF() {
        int r0 = this.bufferPos;
    L4:
        if (r0 >= this.bufferLen) goto L9;
        if (this.buffer[r0] == 10) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public int readLine(CharArrayBuffer r8) throws IOException {
        Args.notNull(r8, "Char array buffer");
        boolean r1 = true;
        int r2 = 0;
    L4:
        if (r1 == false) goto L26;
        int r4 = locateLF();
        if (r4 == (-1)) goto L14;
        if (this.lineBuffer.isEmpty() == true) goto L10;
        int r5 = r4 + 1;
        int r3 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r3, r5 - r3);
        this.bufferPos = r5;
    L12:
        r1 = false;
    L20:
        if (this.maxLineLen <= 0) goto L4;
        if (this.lineBuffer.length() < this.maxLineLen) goto L4;
        throw new IOException("Maximum line length limit exceeded");
    L10:
        return lineFromReadBuffer(r8, r4);
    L14:
        if (hasBufferedData() == false) goto L16;
        int r6 = this.bufferLen;
        int r7 = this.bufferPos;
        this.lineBuffer.append(this.buffer, r7, r6 - r7);
        this.bufferPos = this.bufferLen;
    L16:
        r2 = fillBuffer();
        if (r2 != (-1)) goto L20;
    L26:
        if (r2 != (-1)) goto L31;
        if (this.lineBuffer.isEmpty() == false) goto L31;
        return -1;
    L31:
        return lineFromLineBuffer(r8);
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
        if (this.ascii == false) goto L14;
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
        if (this.ascii == false) goto L11;
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
        if (this.decoder != null) goto L9;
        CharsetDecoder r0 = this.charset.newDecoder();
        this.decoder = r0;
        r0.onMalformedInput(this.onMalformedCharAction);
        this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
    L9:
        if (this.cbuf != null) goto L11;
        this.cbuf = CharBuffer.allocate(1024);
    L11:
        this.decoder.reset();
    L13:
        if (r6.hasRemaining() == false) goto L15;
        r1 = r1 + handleDecodingResult(this.decoder.decode(r6, this.cbuf, true), r5, r6);
        goto L13
    L15:
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
        if (readLine(r0) != (-1)) goto L5;
        return null;
    L5:
        return r0.toString();
    }

    @Override // cz.msebera.android.httpclient.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
