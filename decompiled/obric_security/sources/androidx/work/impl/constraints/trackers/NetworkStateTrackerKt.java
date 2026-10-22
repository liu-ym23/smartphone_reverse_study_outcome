package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi23;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkStateTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u0012"}, d2 = {"TAG", "", "activeNetworkState", "Landroidx/work/impl/constraints/NetworkState;", "Landroid/net/ConnectivityManager;", "getActiveNetworkState$annotations", "(Landroid/net/ConnectivityManager;)V", "getActiveNetworkState", "(Landroid/net/ConnectivityManager;)Landroidx/work/impl/constraints/NetworkState;", "isActiveNetworkValidated", "", "(Landroid/net/ConnectivityManager;)Z", "NetworkStateTracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "context", "Landroid/content/Context;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class NetworkStateTrackerKt {
    private static final String TAG = null;

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static /* synthetic */ void getActiveNetworkState$annotations(ConnectivityManager r0) {
    }

    public static final ConstraintTracker<NetworkState> NetworkStateTracker(Context r1, TaskExecutor r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "taskExecutor");
        return new NetworkStateTracker24(r1, r2);
    }

    static {
        String r0 = Logger.tagWithPrefix("NetworkStateTracker");
        Intrinsics.checkNotNullExpressionValue(r0, "tagWithPrefix(\"NetworkStateTracker\")");
        TAG = r0;
    }

    public static final boolean isActiveNetworkValidated(ConnectivityManager r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        NetworkCapabilities r5 = NetworkApi21.getNetworkCapabilitiesCompat(r4, NetworkApi23.getActiveNetworkCompat(r4));     // Catch: SecurityException -> L7
        if (r5 == null) goto L12;
        return NetworkApi21.hasCapabilityCompat(r5, 16);
    L12:
        return false;
    L7:
        e = move-exception;
        Logger.get().error(TAG, "Unable to validate active network", e);
        return false;
    }

    public static final NetworkState getActiveNetworkState(ConnectivityManager r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        NetworkInfo r0 = r5.getActiveNetworkInfo();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        boolean r4 = isActiveNetworkValidated(r5);
        boolean r6 = ConnectivityManagerCompat.isActiveNetworkMetered(r5);
        if (r0 != null) goto L11;
    L13:
        r1 = false;
    L15:
        return new NetworkState(r3, r4, r6, r1);
    L11:
        if (r0.isRoaming() == true) goto L13;
    L5:
        if (r0.isConnected() == false) goto L7;
        r3 = true;
        goto L8
    }
}
