package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PeekSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", "close", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource r2) {
        Intrinsics.checkNotNullParameter(r2, "upstream");
        this.upstream = r2;
        Buffer r3 = r2.getBuffer();
        this.buffer = r3;
        this.expectedSegment = r3.head;
        Segment r4 = r3.head;
        if (r4 == null) goto L5;
        int r5 = r4.pos;
    L6:
        this.expectedPos = r5;
        return;
    L5:
        r5 = -1;
        goto L6
    }

    @Override // okio.Source
    public long read(Buffer r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "sink");
        boolean r3 = false;
        if (r10 < 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L35;
        if ((!this.closed) == false) goto L33;
        Segment r6 = this.expectedSegment;
        if (r6 != null) goto L12;
    L15:
        r3 = true;
    L16:
        if (r3 == false) goto L31;
        if (r10 != 0) goto L20;
        return 0;
    L20:
        if (this.upstream.request(this.pos + 1) == true) goto L24;
        return -1;
    L24:
        if (this.expectedSegment == null) goto L26;
    L28:
        long r11 = Math.min(r10, this.buffer.size() - this.pos);
        this.buffer.copyTo(r9, this.pos, r11);
        this.pos += r11;
        return r11;
    L26:
        if (this.buffer.head == null) goto L28;
        this.expectedSegment = this.buffer.head;
        Segment r0 = this.buffer.head;
        Intrinsics.checkNotNull(r0);
        this.expectedPos = r0.pos;
        goto L28
    L31:
        throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
    L12:
        if (r6 != this.buffer.head) goto L16;
        int r7 = this.expectedPos;
        Segment r8 = this.buffer.head;
        Intrinsics.checkNotNull(r8);
        if (r7 != r8.pos) goto L16;
    L33:
        throw new IllegalStateException("closed".toString());
    L35:
        throw new IllegalArgumentException(("byteCount < 0: " + r10).toString());
    L5:
        r5 = false;
        goto L6
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }
}
