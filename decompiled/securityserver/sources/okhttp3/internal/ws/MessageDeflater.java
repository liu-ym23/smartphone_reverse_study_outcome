package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MessageDeflater implements Closeable {
    private final Buffer deflatedBytes;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean r4) {
        this.noContextTakeover = r4;
        Buffer r5 = new Buffer();
        this.deflatedBytes = r5;
        Deflater r0 = new Deflater(-1, true);
        this.deflater = r0;
        this.deflaterSink = new DeflaterSink(r5, r0);
    }

    private final boolean endsWith(Buffer r5, ByteString r6) {
        return r5.rangeEquals(r5.size() - ((long) r6.size()), r6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.deflaterSink.close();
    }

    public final void deflate(@NotNull Buffer r6) {
        Intrinsics.f(r6, "buffer");
        if (this.deflatedBytes.size() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L24;
        if (this.noContextTakeover == false) goto L10;
        this.deflater.reset();
    L10:
        this.deflaterSink.write(r6, r6.size());
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.access$getEMPTY_DEFLATE_BLOCK$p()) == false) goto L20;
        long r1 = this.deflatedBytes.size() - ((long) 4);
        Buffer.UnsafeCursor r2 = Buffer.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
        r2.resizeBuffer(r1);     // Catch: Throwable -> L15
        CloseableKt.a(r2, null);
    L21:
        Buffer r5 = this.deflatedBytes;
        r6.write(r5, r5.size());
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.a(r2, th);
        throw th;
    L20:
        this.deflatedBytes.writeByte(0);
        goto L21
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }
}
