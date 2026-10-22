package okio;

import a.a;
import com.bytedance.apm.battery.dao.DBHelper;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(@NotNull BufferedSource r2, @NotNull Inflater r3) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r3, "inflater");
        this.source = r2;
        this.inflater = r3;
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

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer r5, long r6) {
        Intrinsics.f(r5, "sink");
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

    public final long readOrInflate(@NotNull Buffer r6, long r7) {
        Intrinsics.f(r6, "sink");
        if (r7 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L26;
        if ((!this.closed) == false) goto L24;
        if (r7 != 0) goto L27;
        return 0;
    L27:
        Segment r2 = r6.writableSegment$okio(1);     // Catch: DataFormatException -> L15
        int r8 = (int) Math.min(r7, 8192 - r2.limit);     // Catch: DataFormatException -> L15
        refill();     // Catch: DataFormatException -> L15
        int r9 = this.inflater.inflate(r2.data, r2.limit, r8);     // Catch: DataFormatException -> L15
        releaseBytesAfterInflate();     // Catch: DataFormatException -> L15
        if (r9 <= 0) goto L18;
        r2.limit += r9;     // Catch: DataFormatException -> L15
        long r10 = r9;
        r6.setSize$okio(r6.size() + r10);     // Catch: DataFormatException -> L15
        return r10;
    L18:
        if (r2.pos != r2.limit) goto L20;
        r6.head = r2.pop();     // Catch: DataFormatException -> L15
        SegmentPool.recycle(r2);     // Catch: DataFormatException -> L15
    L20:
        return 0;
    L15:
        e = move-exception;
        throw new IOException(e);
    L24:
        throw new IllegalStateException("closed".toString());
    L26:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r7).toString());
    L5:
        r4 = false;
        goto L6
    }

    public final boolean refill() {
        if (this.inflater.needsInput() == true) goto L6;
        return false;
    L6:
        if (this.source.exhausted() == false) goto L9;
        return true;
    L9:
        Segment r0 = this.source.getBuffer().head;
        Intrinsics.c(r0);
        int r2 = r0.limit;
        int r3 = r0.pos;
        int r4 = r2 - r3;
        this.bufferBytesHeldByInflater = r4;
        this.inflater.setInput(r0.data, r3, r4);
        return false;
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    public InflaterSource(@NotNull Source r2, @NotNull Inflater r3) {
        Intrinsics.f(r2, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r3, "inflater");
        this(Okio.buffer(r2), r3);
    }
}
