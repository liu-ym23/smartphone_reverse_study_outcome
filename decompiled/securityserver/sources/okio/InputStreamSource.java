package okio;

import a.a;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(@NotNull InputStream r2, @NotNull Timeout r3) {
        Intrinsics.f(r2, "input");
        Intrinsics.f(r3, "timeout");
        this.input = r2;
        this.timeout = r3;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer r4, long r5) {
        Intrinsics.f(r4, "sink");
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r5 < 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L27;
        this.timeout.throwIfReached();     // Catch: AssertionError -> L15
        Segment r0 = r4.writableSegment$okio(1);     // Catch: AssertionError -> L15
        int r3 = this.input.read(r0.data, r0.limit, (int) Math.min(r5, 8192 - r0.limit));     // Catch: AssertionError -> L15
        if (r3 == (-1)) goto L13;
        r0.limit += r3;     // Catch: AssertionError -> L15
        long r2 = r3;
        r4.setSize$okio(r4.size() + r2);     // Catch: AssertionError -> L15
        return r2;
    L13:
        if (r0.pos != r0.limit) goto L17;
        r4.head = r0.pop();     // Catch: AssertionError -> L15
        SegmentPool.recycle(r0);     // Catch: AssertionError -> L15
        return -1;
    L17:
        return -1;
    L15:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == true) goto L24;
        throw e;
    L24:
        throw new IOException(e);
    L27:
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r5).toString());
    L8:
        r1 = false;
        goto L9
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.timeout;
    }

    @NotNull
    public String toString() {
        return "source(" + this.input + ')';
    }
}
