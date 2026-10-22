package coil.network;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import coil.util.Contexts;
import coil.util.Logger;
import coil.util.Logs;
import kotlin.Metadata;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", NetworkObserverKt.TAG, "Lcoil/network/NetworkObserver;", "context", "Landroid/content/Context;", "listener", "Lcoil/network/NetworkObserver$Listener;", "logger", "Lcoil/util/Logger;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NetworkObserverKt {
    private static final String TAG = "NetworkObserver";

    public static final NetworkObserver NetworkObserver(Context r3, NetworkObserver.Listener r4, Logger r5) {
        ConnectivityManager r0 = (ConnectivityManager) ContextCompat.getSystemService(r3, ConnectivityManager.class);
        if (r0 != null) goto L5;
    L14:
        if (r5 == null) goto L19;
        if (r5.getLevel() > 5) goto L19;
        r5.log(TAG, 5, "Unable to register network observer.", null);
    L19:
        return new EmptyNetworkObserver();
    L5:
        if (Contexts.isPermissionGranted(r3, "android.permission.ACCESS_NETWORK_STATE") == false) goto L14;
        return new RealNetworkObserver(r0, r4);
    L9:
        e = move-exception;
        if (r5 == null) goto L13;
        Logs.log(r5, TAG, new RuntimeException("Failed to register network observer.", e));
    L13:
        return new EmptyNetworkObserver();
    }
}
