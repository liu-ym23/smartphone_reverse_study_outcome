package okio;

import com.bytedance.apm.battery.dao.DBHelper;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(@NotNull OutputStream r2, @NotNull Timeout r3) {
        Intrinsics.f(r2, "out");
        Intrinsics.f(r3, "timeout");
        this.out = r2;
        this.timeout = r3;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    @NotNull
    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer r8, long r9) {
        Intrinsics.f(r8, DBHelper.BATTERY_COL_SOURCE);
        Util.checkOffsetAndCount(r8.size(), 0, r9);
    L4:
        if (r9 <= 0) goto L8;
        this.timeout.throwIfReached();
        Segment r0 = r8.head;
        Intrinsics.c(r0);
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        this.out.write(r0.data, r0.pos, r1);
        r0.pos += r1;
        long r2 = r1;
        r9 = r9 - r2;
        r8.setSize$okio(r8.size() - r2);
        if (r0.pos != r0.limit) goto L4;
        r8.head = r0.pop();
        SegmentPool.recycle(r0);
        goto L4
    }
}
