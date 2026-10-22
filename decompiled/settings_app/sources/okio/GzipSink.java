package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GzipSink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u00020\t8G¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(Sink r4) {
        Intrinsics.checkNotNullParameter(r4, "sink");
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

    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink
    public void write(Buffer r3, long r4) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "source");
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
        throw new IllegalArgumentException(("byteCount < 0: " + r4).toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
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

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private final void updateCrc(Buffer r5, long r6) {
        Segment r7 = r5.head;
        Intrinsics.checkNotNull(r7);
    L4:
        if (r6 <= 0) goto L6;
        int r0 = (int) Math.min(r6, r7.limit - r7.pos);
        this.crc.update(r7.data, r7.pos, r0);
        r6 = r6 - ((long) r0);
        r7 = r7.next;
        Intrinsics.checkNotNull(r7);
        goto L4
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}))
    /* JADX INFO: renamed from: -deprecated_deflater, reason: not valid java name */
    public final Deflater m3242deprecated_deflater() {
        return this.deflater;
    }
}
