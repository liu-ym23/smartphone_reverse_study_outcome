package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0003J\r\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$okio", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink r2, Deflater r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        Intrinsics.checkNotNullParameter(r3, "deflater");
        this.sink = r2;
        this.deflater = r3;
    }

    public DeflaterSink(Sink r2, Deflater r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        Intrinsics.checkNotNullParameter(r3, "deflater");
        this(Okio.buffer(r2), r3);
    }

    @Override // okio.Sink
    public void write(Buffer r8, long r9) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "source");
        _UtilKt.checkOffsetAndCount(r8.size(), 0, r9);
    L4:
        if (r9 <= 0) goto L9;
        Segment r0 = r8.head;
        Intrinsics.checkNotNull(r0);
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        this.deflater.setInput(r0.data, r0.pos, r1);
        deflate(false);
        long r4 = r1;
        r8.setSize$okio(r8.size() - r4);
        r0.pos += r1;
        if (r0.pos != r0.limit) goto L8;
        r8.head = r0.pop();
        SegmentPool.recycle(r0);
    L8:
        r9 = r9 - r4;
        goto L4
    }

    private final void deflate(boolean r8) {
        Buffer r0 = this.sink.getBuffer();
    L3:
        Segment r1 = r0.writableSegment$okio(1);
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
        r0.setSize$okio(r0.size() + ((long) r2));
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

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L24;
        return;
    L24:
        finishDeflate$okio();     // Catch: Throwable -> L7
        th = null;
    L22:
        this.deflater.end();     // Catch: Throwable -> L10
    L26:
        this.sink.close();     // Catch: Throwable -> L15
    L18:
        this.closed = true;
        if (th != null) goto L21;
        return;
    L21:
        throw th;
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
        return "DeflaterSink(" + this.sink + ')';
    }
}
