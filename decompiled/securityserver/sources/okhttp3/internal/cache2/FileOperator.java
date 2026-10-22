package okhttp3.internal.cache2;

import com.bytedance.apm.battery.dao.DBHelper;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel r2) {
        Intrinsics.f(r2, "fileChannel");
        this.fileChannel = r2;
    }

    public final void read(long r10, @NotNull Buffer r12, long r13) {
        Intrinsics.f(r12, "sink");
        if (r13 < 0) goto L9;
    L5:
        if (r13 <= 0) goto L7;
        long r2 = this.fileChannel.transferTo(r10, r13, r12);
        r10 = r10 + r2;
        r13 = r13 - r2;
        goto L5
    L7:
        return;
    L9:
        throw new IndexOutOfBoundsException();
    }

    public final void write(long r10, @NotNull Buffer r12, long r13) {
        Intrinsics.f(r12, DBHelper.BATTERY_COL_SOURCE);
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
}
