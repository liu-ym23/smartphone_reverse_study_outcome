package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readOrInflate", "refill", "releaseBytesAfterInflate", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource r2, Inflater r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "inflater");
        this.source = r2;
        this.inflater = r3;
    }

    public InflaterSource(Source r2, Inflater r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "inflater");
        this(Okio.buffer(r2), r3);
    }

    @Override // okio.Source
    public long read(Buffer r5, long r6) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "sink");
    L3:
        long r0 = readOrInflate(r5, r6);
        if (r0 > 0) goto L5;
        if (this.inflater.finished() == true) goto L16;
        if (this.inflater.needsDictionary() == true) goto L23;
        if (this.source.exhausted() == false) goto L3;
        throw new EOFException("source exhausted prematurely");
    L23:
        return -1;
    L16:
        return -1;
    L5:
        return r0;
    }

    public final long readOrInflate(Buffer r6, long r7) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "sink");
        if (r7 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L25;
        if ((!this.closed) == false) goto L23;
        if (r7 != 0) goto L26;
        return 0;
    L26:
        Segment r2 = r6.writableSegment$okio(1);     // Catch: DataFormatException -> L19
        int r8 = (int) Math.min(r7, 8192 - r2.limit);     // Catch: DataFormatException -> L19
        refill();     // Catch: DataFormatException -> L19
        int r9 = this.inflater.inflate(r2.data, r2.limit, r8);     // Catch: DataFormatException -> L19
        releaseBytesAfterInflate();     // Catch: DataFormatException -> L19
        if (r9 <= 0) goto L16;
        r2.limit += r9;     // Catch: DataFormatException -> L19
        long r10 = r9;
        r6.setSize$okio(r6.size() + r10);     // Catch: DataFormatException -> L19
        return r10;
    L16:
        if (r2.pos != r2.limit) goto L18;
        r6.head = r2.pop();     // Catch: DataFormatException -> L19
        SegmentPool.recycle(r2);     // Catch: DataFormatException -> L19
    L18:
        return 0;
    L19:
        e = move-exception;
        throw new IOException(e);
    L23:
        throw new IllegalStateException("closed".toString());
    L25:
        throw new IllegalArgumentException(("byteCount < 0: " + r7).toString());
    L5:
        r4 = false;
        goto L6
    }

    public final boolean refill() throws IOException {
        if (this.inflater.needsInput() == true) goto L6;
        return false;
    L6:
        if (this.source.exhausted() == false) goto L9;
        return true;
    L9:
        Segment r0 = this.source.getBuffer().head;
        Intrinsics.checkNotNull(r0);
        this.bufferBytesHeldByInflater = r0.limit - r0.pos;
        this.inflater.setInput(r0.data, r0.pos, this.bufferBytesHeldByInflater);
        return false;
    }

    private final void releaseBytesAfterInflate() {
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
