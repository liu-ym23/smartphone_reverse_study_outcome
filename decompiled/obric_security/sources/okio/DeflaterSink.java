package okio;

import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes5.dex */
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(Sink r1, Deflater r2) {
        this(Okio.buffer(r1), r2);
    }

    DeflaterSink(BufferedSink r1, Deflater r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L8;
        this.sink = r1;
        this.deflater = r2;
        return;
    L8:
        throw new IllegalArgumentException("inflater == null");
    L10:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.Sink
    public void write(Buffer r7, long r8) throws IOException {
        Util.checkOffsetAndCount(r7.size, 0, r8);
    L4:
        if (r8 <= 0) goto L9;
        Segment r0 = r7.head;
        int r1 = (int) Math.min(r8, r0.limit - r0.pos);
        this.deflater.setInput(r0.data, r0.pos, r1);
        deflate(false);
        long r4 = r1;
        r7.size -= r4;
        r0.pos += r1;
        if (r0.pos != r0.limit) goto L8;
        r7.head = r0.pop();
        SegmentPool.recycle(r0);
    L8:
        r8 = r8 - r4;
        goto L4
    }

    private void deflate(boolean r8) throws IOException {
        Buffer r0 = this.sink.buffer();
    L3:
        Segment r1 = r0.writableSegment(1);
        if (r8 == false) goto L6;
        int r2 = this.deflater.deflate(r1.data, r1.limit, 8192 - r1.limit, 2);
    L7:
        if (r2 > 0) goto L8;
        if (this.deflater.needsInput() == false) goto L3;
        if (r1.pos != r1.limit) goto L21;
        r0.head = r1.pop();
        SegmentPool.recycle(r1);
        return;
    L21:
        return;
    L8:
        r1.limit += r2;
        r0.size += (long) r2;
        this.sink.emitCompleteSegments();
        goto L3
    L6:
        r2 = this.deflater.deflate(r1.data, r1.limit, 8192 - r1.limit);
        goto L7
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    void finishDeflate() throws IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L24;
        return;
    L24:
        finishDeflate();     // Catch: Throwable -> L7
        th = null;
    L22:
        this.deflater.end();     // Catch: Throwable -> L10
    L26:
        this.sink.close();     // Catch: Throwable -> L15
    L18:
        this.closed = true;
        if (th == null) goto L28;
        Util.sneakyRethrow(th);
        return;
    L28:
        return;
    L15:
        th = move-exception;
        if (th != null) goto L18;
        th = th;
    L10:
        th = move-exception;
        if (th != null) goto L26;
        th = th;
    L7:
        th = th;
        goto L22
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }
}
