package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream r2, Timeout r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "timeout");
        this.input = r2;
        this.timeout = r3;
    }

    @Override // okio.Source
    public long read(Buffer r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "sink");
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r5 < 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L26;
        this.timeout.throwIfReached();     // Catch: AssertionError -> L19
        Segment r0 = r4.writableSegment$okio(1);     // Catch: AssertionError -> L19
        int r3 = this.input.read(r0.data, r0.limit, (int) Math.min(r5, 8192 - r0.limit));     // Catch: AssertionError -> L19
        if (r3 == (-1)) goto L13;
        r0.limit += r3;     // Catch: AssertionError -> L19
        long r2 = r3;
        r4.setSize$okio(r4.size() + r2);     // Catch: AssertionError -> L19
        return r2;
    L13:
        if (r0.pos != r0.limit) goto L28;
        r4.head = r0.pop();     // Catch: AssertionError -> L19
        SegmentPool.recycle(r0);     // Catch: AssertionError -> L19
        return -1;
    L28:
        return -1;
    L19:
        e = move-exception;
        if (Okio.isAndroidGetsocknameError(e) == true) goto L23;
        throw e;
    L23:
        throw new IOException(e);
    L26:
        throw new IllegalArgumentException(("byteCount < 0: " + r5).toString());
    L8:
        r1 = false;
        goto L9
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
