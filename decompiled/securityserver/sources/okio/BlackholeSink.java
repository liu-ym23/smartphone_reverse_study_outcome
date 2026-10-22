package okio;

import com.bytedance.apm.battery.dao.DBHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class BlackholeSink implements Sink {
    public BlackholeSink() {
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer r1, long r2) {
        Intrinsics.f(r1, DBHelper.BATTERY_COL_SOURCE);
        r1.skip(r2);
    }
}
