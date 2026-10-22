package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: compiled from: FileOperator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(Ljava/nio/channels/FileChannel;)V", "read", "", "pos", "", "sink", "Lokio/Buffer;", "byteCount", "write", "source", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel r2) {
        Intrinsics.checkNotNullParameter(r2, "fileChannel");
        this.fileChannel = r2;
    }

    public final void write(long r10, Buffer r12, long r13) throws IOException {
        Intrinsics.checkNotNullParameter(r12, "source");
        if (r13 < 0) goto L11;
        if (r13 > r12.size()) goto L11;
    L7:
        if (r13 <= 0) goto L9;
        long r2 = this.fileChannel.transferFrom(r12, r10, r13);
        r10 = r10 + r2;
        r13 = r13 - r2;
        goto L7
    L9:
        return;
    L11:
        throw new IndexOutOfBoundsException();
    }

    public final void read(long r10, Buffer r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "sink");
        if (r13 < 0) goto L9;
    L5:
        if (r13 <= 0) goto L7;
        long r4 = r10;
        long r6 = r13;
        long r2 = this.fileChannel.transferTo(r4, r6, r12);
        r10 = r10 + r2;
        r13 = r13 - r2;
        goto L5
    L7:
        return;
    L9:
        throw new IndexOutOfBoundsException();
    }
}
