package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.InflaterSource;

/* JADX INFO: compiled from: MessageInflater.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "noContextTakeover", "", "(Z)V", "deflatedBytes", "Lokio/Buffer;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "close", "", "inflate", "buffer", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageInflater implements Closeable {
    private final Buffer deflatedBytes;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean r3) {
        this.noContextTakeover = r3;
        Buffer r4 = new Buffer();
        this.deflatedBytes = r4;
        Inflater r0 = new Inflater(true);
        this.inflater = r0;
        this.inflaterSource = new InflaterSource(r4, r0);
    }

    public final void inflate(Buffer r6) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "buffer");
        if (this.deflatedBytes.size() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        if (this.noContextTakeover == false) goto L10;
        this.inflater.reset();
    L10:
        this.deflatedBytes.writeAll(r6);
        this.deflatedBytes.writeInt(65535);
        long r1 = this.inflater.getBytesRead() + this.deflatedBytes.size();
    L11:
        this.inflaterSource.readOrInflate(r6, Long.MAX_VALUE);
        if (this.inflater.getBytesRead() < r1) goto L11;
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }
}
