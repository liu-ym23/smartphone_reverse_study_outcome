package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.MalformedChunkCodingException;
import cz.msebera.android.httpclient.TruncatedChunkException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_INVALID = Integer.MAX_VALUE;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private long chunkSize;
    private boolean closed;
    private final MessageConstraints constraints;
    private boolean eof;
    private Header[] footers;
    private final SessionInputBuffer in;
    private long pos;
    private int state;

    public ChunkedInputStream(SessionInputBuffer r3, MessageConstraints r4) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.in = (SessionInputBuffer) Args.notNull(r3, "Session input buffer");
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        if (r4 != null) goto L6;
        r4 = MessageConstraints.DEFAULT;
    L6:
        this.constraints = r4;
        this.state = 1;
    }

    public ChunkedInputStream(SessionInputBuffer r2) {
        this(r2, null);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        SessionInputBuffer r0 = this.in;
        if ((r0 instanceof BufferInfo) == true) goto L5;
        return 0;
    L5:
        return (int) Math.min(((BufferInfo) r0).length(), this.chunkSize - this.pos);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed == true) goto L19;
        if (this.eof == false) goto L8;
        return -1;
    L8:
        if (this.state == 2) goto L12;
        nextChunk();
        if (this.eof == false) goto L12;
        return -1;
    L12:
        int r0 = this.in.read();
        if (r0 == (-1)) goto L17;
        long r1 = this.pos + 1;
        this.pos = r1;
        if (r1 < this.chunkSize) goto L17;
        this.state = 3;
    L17:
        return r0;
    L19:
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) throws IOException {
        if (this.closed == true) goto L21;
        if (this.eof == false) goto L8;
        return -1;
    L8:
        if (this.state == 2) goto L12;
        nextChunk();
        if (this.eof == false) goto L12;
        return -1;
    L12:
        int r13 = this.in.read(r10, r11, (int) Math.min(r12, this.chunkSize - this.pos));
        if (r13 == (-1)) goto L18;
        long r14 = this.pos + ((long) r13);
        this.pos = r14;
        if (r14 < this.chunkSize) goto L17;
        this.state = 3;
    L17:
        return r13;
    L18:
        this.eof = true;
        throw new TruncatedChunkException("Truncated chunk (expected size: %,d; actual size: %,d)", new Object[]{Long.valueOf(this.chunkSize), Long.valueOf(this.pos)});
    L21:
        throw new IOException("Attempted read from closed stream.");
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    private void nextChunk() throws IOException {
        if (this.state == Integer.MAX_VALUE) goto L16;
        long r2 = getChunkSize();     // Catch: MalformedChunkCodingException -> L12
        this.chunkSize = r2;     // Catch: MalformedChunkCodingException -> L12
        if (r2 < 0) goto L11;
        this.state = 2;     // Catch: MalformedChunkCodingException -> L12
        this.pos = 0;     // Catch: MalformedChunkCodingException -> L12
        if (r2 != 0) goto L18;
        this.eof = true;     // Catch: MalformedChunkCodingException -> L12
        parseTrailerHeaders();     // Catch: MalformedChunkCodingException -> L12
        return;
    L18:
        return;
    L11:
        throw new MalformedChunkCodingException("Negative chunk size");     // Catch: MalformedChunkCodingException -> L12
    L12:
        e = move-exception;
        this.state = Integer.MAX_VALUE;
        throw e;
    L16:
        throw new MalformedChunkCodingException("Corrupt data stream");
    }

    private long getChunkSize() throws IOException {
        int r0 = this.state;
        if (r0 != 1) goto L5;
    L17:
        this.buffer.clear();
        if (this.in.readLine(this.buffer) == (-1)) goto L28;
        int r1 = this.buffer.indexOf(59);
        if (r1 >= 0) goto L22;
        r1 = this.buffer.length();
    L22:
        String r4 = this.buffer.substringTrimmed(0, r1);
        return Long.parseLong(r4, 16);
    L26:
        throw new MalformedChunkCodingException("Bad chunk header: " + r4);
    L28:
        throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
    L5:
        if (r0 != 3) goto L16;
        this.buffer.clear();
        if (this.in.readLine(this.buffer) == (-1)) goto L14;
        if (this.buffer.isEmpty() == false) goto L12;
        this.state = 1;
        goto L17
    L12:
        throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
    L14:
        throw new MalformedChunkCodingException("CRLF expected at end of chunk");
    L16:
        throw new IllegalStateException("Inconsistent codec state");
    }

    private void parseTrailerHeaders() throws IOException {
        this.footers = AbstractMessageParser.parseHeaders(this.in, this.constraints.getMaxHeaderCount(), this.constraints.getMaxLineLength(), null);     // Catch: HttpException -> L4
        return;
    L4:
        e = move-exception;
        MalformedChunkCodingException r0 = new MalformedChunkCodingException("Invalid footer: " + e.getMessage());
        r0.initCause(e);
        throw r0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L18;
        return;
    L18:
    L14:
        th = move-exception;
        this.eof = true;
        this.closed = true;
        throw th;
    L6:
        if (this.eof == false) goto L8;
    L13:
        this.eof = true;
        this.closed = true;
        return;
    L8:
        if (this.state == Integer.MAX_VALUE) goto L13;
        byte[] r1 = new byte[2048];     // Catch: Throwable -> L14
    L10:
        if (read(r1) < 0) goto L13;
        goto L13
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }
}
