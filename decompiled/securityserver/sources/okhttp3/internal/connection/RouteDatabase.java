package okhttp3.internal.connection;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RouteDatabase {
    private final Set<Route> failedRoutes;

    public RouteDatabase() {
        this.failedRoutes = new LinkedHashSet();
    }

    public final synchronized void connected(@NotNull Route r2) {
        monitor-enter(this);
        Intrinsics.f(r2, CloudControlInf.ROUTE);     // Catch: Throwable -> L6
        this.failedRoutes.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void failed(@NotNull Route r2) {
        monitor-enter(this);
        Intrinsics.f(r2, "failedRoute");     // Catch: Throwable -> L6
        this.failedRoutes.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean shouldPostpone(@NotNull Route r2) {
        monitor-enter(this);
        Intrinsics.f(r2, CloudControlInf.ROUTE);     // Catch: Throwable -> L6
        boolean r3 = this.failedRoutes.contains(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }
}
