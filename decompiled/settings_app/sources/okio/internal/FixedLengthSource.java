package okio.internal;

import com.bytedance.apm.constant.PerfConsts;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

/* JADX INFO: compiled from: FixedLengthSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", PerfConsts.PERF_DISK_FILE_SIZE, "", "truncate", "", "(Lokio/Source;JZ)V", "bytesReceived", "read", "sink", "Lokio/Buffer;", "byteCount", "truncateToSize", "", "newSize", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FixedLengthSource extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    public FixedLengthSource(Source r2, long r3, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        super(r2);
        this.size = r3;
        this.truncate = r5;
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "sink");
        long r0 = this.bytesReceived;
        long r2 = this.size;
        if (r0 <= r2) goto L6;
        r11 = 0;
    L11:
        long r12 = super.read(r10, r11);
        if (r12 == (-1)) goto L14;
        this.bytesReceived += r12;
    L14:
        long r1 = this.bytesReceived;
        long r3 = this.size;
        if (r1 >= r3) goto L18;
        if (r12 != (-1)) goto L18;
    L20:
        if (r12 <= 0) goto L25;
        if (r1 <= r3) goto L25;
        truncateToSize(r10, r10.size() - (this.bytesReceived - this.size));
    L25:
        throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
    L18:
        if (r1 > r3) goto L20;
        return r12;
    L6:
        if (this.truncate == false) goto L11;
        long r4 = r2 - r0;
        if (r4 != 0) goto L10;
        return -1;
    L10:
        r11 = Math.min(r11, r4);
        goto L11
    }

    private final void truncateToSize(Buffer r2, long r3) {
        Buffer r1 = new Buffer();
        r1.writeAll(r2);
        r2.write(r1, r3);
        r1.clear();
    }
}
