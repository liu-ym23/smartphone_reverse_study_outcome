package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkStateTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/work/impl/constraints/trackers/NetworkStateTracker24;", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "Landroidx/work/impl/constraints/NetworkState;", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "initialState", "getInitialState", "()Landroidx/work/impl/constraints/NetworkState;", "networkCallback", "androidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1", "Landroidx/work/impl/constraints/trackers/NetworkStateTracker24$networkCallback$1;", "startTracking", "", "stopTracking", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {
    private final ConnectivityManager connectivityManager;
    private final NetworkStateTracker24$networkCallback$1 networkCallback;

    public static final /* synthetic */ ConnectivityManager access$getConnectivityManager$p(NetworkStateTracker24 r0) {
        return r0.connectivityManager;
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ NetworkState getInitialState() {
        return getInitialState();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(Context r2, TaskExecutor r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskExecutor");
        super(r2, r3);
        Object r4 = getAppContext().getSystemService("connectivity");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) r4;
        this.networkCallback = new NetworkStateTracker24$networkCallback$1(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState getInitialState() {
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Registering network callback");     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
        NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while registering network callback", e);
        return;
    L5:
        e = move-exception;
        Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while registering network callback", e);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        Logger.get().debug(NetworkStateTrackerKt.access$getTAG$p(), "Unregistering network callback");     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
        NetworkApi21.unregisterNetworkCallbackCompat(this.connectivityManager, this.networkCallback);     // Catch: SecurityException -> L5 IllegalArgumentException -> L7
    L13:
        return;
    L7:
        e = move-exception;
        Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while unregistering network callback", e);
        return;
    L5:
        e = move-exception;
        Logger.get().error(NetworkStateTrackerKt.access$getTAG$p(), "Received exception while unregistering network callback", e);
    }
}
