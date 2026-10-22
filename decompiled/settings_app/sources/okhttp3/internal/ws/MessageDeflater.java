package okhttp3.internal.ws;

import com.android.settings.applications.PreferredSettingsUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;

/* JADX INFO: compiled from: MessageDeflater.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "noContextTakeover", "", "(Z)V", "deflatedBytes", "Lokio/Buffer;", "deflater", "Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "close", "", "deflate", "buffer", "endsWith", PreferredSettingsUtils.OTHERS_SUFFIX_KEY, "Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public final void deflate(Buffer r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "buffer");
        if (this.deflatedBytes.size() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L24;
        if (this.noContextTakeover == false) goto L10;
        this.deflater.reset();
    L10:
        this.deflaterSink.write(r7, r7.size());
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.access$getEMPTY_DEFLATE_BLOCK$p()) == false) goto L20;
        long r2 = this.deflatedBytes.size() - ((long) 4);
        Buffer.UnsafeCursor r1 = Buffer.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
        r1.resizeBuffer(r2);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r1, null);
    L21:
        Buffer r6 = this.deflatedBytes;
        r7.write(r6, r6.size());
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.deflaterSink.close();
    }

    private final boolean endsWith(Buffer r5, ByteString r6) {
        return r5.rangeEquals(r5.size() - ((long) r6.size()), r6);
    }
}
