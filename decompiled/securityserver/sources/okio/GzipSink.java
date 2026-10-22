package okio;

import a.a;
import com.bytedance.apm.battery.dao.DBHelper;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc;

    @NotNull
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(@NotNull Sink r4) {
        Intrinsics.f(r4, "sink");
        RealBufferedSink r0 = new RealBufferedSink(r4);
        this.sink = r0;
        Deflater r5 = new Deflater(-1, true);
        this.deflater = r5;
        this.deflaterSink = new DeflaterSink(r0, r5);
        this.crc = new CRC32();
        Buffer r3 = r0.bufferField;
        r3.writeShort(8075);
        r3.writeByte(8);
        r3.writeByte(0);
        r3.writeInt(0);
        r3.writeByte(0);
        r3.writeByte(0);
    }

    private final void updateCrc(Buffer r5, long r6) {
        Segment r7 = r5.head;
        Intrinsics.c(r7);
    L4:
        if (r6 <= 0) goto L6;
        int r0 = (int) Math.min(r6, r7.limit - r7.pos);
        this.crc.update(r7.data, r7.pos, r0);
        r6 = r6 - ((long) r0);
        r7 = r7.next;
        Intrinsics.c(r7);
        goto L4
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_deflater, reason: not valid java name */
    public final Deflater m196deprecated_deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed == false) goto L26;
        return;
    L26:
        this.deflaterSink.finishDeflate$okio();     // Catch: Throwable -> L7
        writeFooter();     // Catch: Throwable -> L7
        th = null;
    L24:
        this.deflater.end();     // Catch: Throwable -> L10
    L22:
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
        if (th != null) goto L22;
        th = th;
    L7:
        th = th;
        goto L24
    }

    @JvmName
    @NotNull
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer r3, long r4) {
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        if (r4 != 0) goto L9;
        return;
    L9:
        updateCrc(r3, r4);
        this.deflaterSink.write(r3, r4);
        return;
    L12:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r4).toString());
    L5:
        r1 = false;
        goto L6
    }
}
