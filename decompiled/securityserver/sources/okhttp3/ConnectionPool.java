package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConnectionPool {

    @NotNull
    private final RealConnectionPool delegate;

    public ConnectionPool(@NotNull RealConnectionPool r2) {
        Intrinsics.f(r2, "delegate");
        this.delegate = r2;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    @NotNull
    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public ConnectionPool(int r8, long r9, @NotNull TimeUnit r11) {
        Intrinsics.f(r11, "timeUnit");
        this(new RealConnectionPool(TaskRunner.INSTANCE, r8, r9, r11));
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }
}
