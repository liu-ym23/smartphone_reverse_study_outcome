package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.InflaterSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    public final void inflate(@NotNull Buffer r7) {
        Intrinsics.f(r7, "buffer");
        if (this.deflatedBytes.size() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        if (this.noContextTakeover == false) goto L10;
        this.inflater.reset();
    L10:
        this.deflatedBytes.writeAll(r7);
        this.deflatedBytes.writeInt(65535);
        long r1 = this.inflater.getBytesRead();
        long r2 = this.deflatedBytes.size() + r1;
    L11:
        this.inflaterSource.readOrInflate(r7, Long.MAX_VALUE);
        if (this.inflater.getBytesRead() < r2) goto L11;
        return;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }
}
