package okio;

import a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(@NotNull BufferedSource r2) {
        Intrinsics.f(r2, "upstream");
        this.upstream = r2;
        Buffer r3 = r2.getBuffer();
        this.buffer = r3;
        Segment r4 = r3.head;
        this.expectedSegment = r4;
        if (r4 == null) goto L5;
        int r5 = r4.pos;
    L6:
        this.expectedPos = r5;
        return;
    L5:
        r5 = -1;
        goto L6
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer r9, long r10) {
        Intrinsics.f(r9, "sink");
        boolean r3 = false;
        if (r10 < 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L35;
        if ((!this.closed) == false) goto L33;
        Segment r6 = this.expectedSegment;
        if (r6 == null) goto L15;
        Segment r7 = this.buffer.head;
        if (r6 != r7) goto L16;
        int r8 = this.expectedPos;
        Intrinsics.c(r7);
        if (r8 == r7.pos) goto L15;
    L16:
        if (r3 == false) goto L31;
        if (r10 != 0) goto L20;
        return 0;
    L20:
        if (this.upstream.request(this.pos + 1) == true) goto L24;
        return -1;
    L24:
        if (this.expectedSegment != null) goto L28;
        Segment r0 = this.buffer.head;
        if (r0 == null) goto L28;
        this.expectedSegment = r0;
        Intrinsics.c(r0);
        this.expectedPos = r0.pos;
    L28:
        long r11 = Math.min(r10, this.buffer.size() - this.pos);
        this.buffer.copyTo(r9, this.pos, r11);
        this.pos += r11;
        return r11;
    L31:
        throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
    L15:
        r3 = true;
        goto L16
    L33:
        throw new IllegalStateException("closed".toString());
    L35:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r10).toString());
    L5:
        r5 = false;
        goto L6
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
