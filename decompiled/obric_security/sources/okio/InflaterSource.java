package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes5.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(Source r1, Inflater r2) {
        this(Okio.buffer(r1), r2);
    }

    InflaterSource(BufferedSource r1, Inflater r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L8;
        this.source = r1;
        this.inflater = r2;
        return;
    L8:
        throw new IllegalArgumentException("inflater == null");
    L10:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.Source
    public long read(Buffer r7, long r8) throws IOException {
        if (r8 < 0) goto L33;
        if (this.closed == true) goto L31;
        if (r8 != 0) goto L8;
        return 0;
    L8:
        boolean r0 = refill();
        Segment r1 = r7.writableSegment(1);     // Catch: DataFormatException -> L27
        int r2 = this.inflater.inflate(r1.data, r1.limit, (int) Math.min(r8, 8192 - r1.limit));     // Catch: DataFormatException -> L27
        if (r2 > 0) goto L11;
        if (this.inflater.finished() == true) goto L22;
        if (this.inflater.needsDictionary() == true) goto L22;
        if (r0 == false) goto L8;
        throw new EOFException("source exhausted prematurely");     // Catch: DataFormatException -> L27
    L22:
        releaseInflatedBytes();     // Catch: DataFormatException -> L27
        if (r1.pos != r1.limit) goto L39;
        r7.head = r1.pop();     // Catch: DataFormatException -> L27
        SegmentPool.recycle(r1);     // Catch: DataFormatException -> L27
        return -1;
    L39:
        return -1;
    L11:
        r1.limit += r2;     // Catch: DataFormatException -> L27
        long r3 = r2;
        r7.size += r3;     // Catch: DataFormatException -> L27
        return r3;
    L27:
        e = move-exception;
        throw new IOException(e);
    L31:
        throw new IllegalStateException("closed");
    L33:
        throw new IllegalArgumentException("byteCount < 0: " + r8);
    }

    public final boolean refill() throws IOException {
        if (this.inflater.needsInput() == true) goto L5;
        return false;
    L5:
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) goto L14;
        if (this.source.exhausted() == false) goto L11;
        return true;
    L11:
        Segment r0 = this.source.buffer().head;
        this.bufferBytesHeldByInflater = r0.limit - r0.pos;
        this.inflater.setInput(r0.data, r0.pos, this.bufferBytesHeldByInflater);
        return false;
    L14:
        throw new IllegalStateException("?");
    }

    private void releaseInflatedBytes() throws IOException {
        int r0 = this.bufferBytesHeldByInflater;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = r0 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= r1;
        this.source.skip(r1);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }
}
