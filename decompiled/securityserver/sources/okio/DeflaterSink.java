package okio;

import com.bytedance.apm.battery.dao.DBHelper;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(@NotNull BufferedSink r2, @NotNull Deflater r3) {
        Intrinsics.f(r2, "sink");
        Intrinsics.f(r3, "deflater");
        this.sink = r2;
        this.deflater = r3;
    }

    @IgnoreJRERequirement
    private final void deflate(boolean r8) {
        Buffer r0 = this.sink.getBuffer();
    L3:
        Segment r1 = r0.writableSegment$okio(1);
        if (r8 == false) goto L6;
        Deflater r2 = this.deflater;
        byte[] r3 = r1.data;
        int r4 = r1.limit;
        int r5 = r2.deflate(r3, r4, 8192 - r4, 2);
    L7:
        if (r5 > 0) goto L8;
        if (this.deflater.needsInput() == false) goto L3;
        if (r1.pos != r1.limit) goto L21;
        r0.head = r1.pop();
        SegmentPool.recycle(r1);
        return;
    L21:
        return;
    L8:
        r1.limit += r5;
        r0.setSize$okio(r0.size() + ((long) r5));
        this.sink.emitCompleteSegments();
        goto L3
    L6:
        Deflater r6 = this.deflater;
        byte[] r7 = r1.data;
        int r9 = r1.limit;
        r5 = r6.deflate(r7, r9, 8192 - r9);
        goto L7
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
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

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        deflate(true);
        this.sink.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer r8, long r9) {
        Intrinsics.f(r8, DBHelper.BATTERY_COL_SOURCE);
        Util.checkOffsetAndCount(r8.size(), 0, r9);
    L4:
        if (r9 <= 0) goto L9;
        Segment r0 = r8.head;
        Intrinsics.c(r0);
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        this.deflater.setInput(r0.data, r0.pos, r1);
        deflate(false);
        long r4 = r1;
        r8.setSize$okio(r8.size() - r4);
        int r2 = r0.pos + r1;
        r0.pos = r2;
        if (r2 != r0.limit) goto L8;
        r8.head = r0.pop();
        SegmentPool.recycle(r0);
    L8:
        r9 = r9 - r4;
        goto L4
    }

    public DeflaterSink(@NotNull Sink r2, @NotNull Deflater r3) {
        Intrinsics.f(r2, "sink");
        Intrinsics.f(r3, "deflater");
        this(Okio.buffer(r2), r3);
    }
}
