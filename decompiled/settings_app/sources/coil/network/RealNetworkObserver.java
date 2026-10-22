package coil.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkObserver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\f\u0010\u0007\u001a\u00020\b*\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0012"}, d2 = {"Lcoil/network/RealNetworkObserver;", "Lcoil/network/NetworkObserver;", "connectivityManager", "Landroid/net/ConnectivityManager;", "listener", "Lcoil/network/NetworkObserver$Listener;", "(Landroid/net/ConnectivityManager;Lcoil/network/NetworkObserver$Listener;)V", "isOnline", "", "()Z", "networkCallback", "coil/network/RealNetworkObserver$networkCallback$1", "Lcoil/network/RealNetworkObserver$networkCallback$1;", "onConnectivityChange", "", "network", "Landroid/net/Network;", "shutdown", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RealNetworkObserver implements NetworkObserver {
    private final ConnectivityManager connectivityManager;
    private final NetworkObserver.Listener listener;
    private final RealNetworkObserver$networkCallback$1 networkCallback;

    /* JADX WARN: Type inference failed for: r3v1, types: [coil.network.RealNetworkObserver$networkCallback$1] */
    public RealNetworkObserver(ConnectivityManager r2, NetworkObserver.Listener r3) {
        this.connectivityManager = r2;
        this.listener = r3;
        ?? r4 = new RealNetworkObserver$networkCallback$1(this);
        this.networkCallback = r4;
        r2.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (ConnectivityManager.NetworkCallback) r4);
    }

    public static final /* synthetic */ void access$onConnectivityChange(RealNetworkObserver r0, Network r1, boolean r2) {
        r0.onConnectivityChange(r1, r2);
    }

    @Override // coil.network.NetworkObserver
    public boolean isOnline() {
        Network[] r0 = this.connectivityManager.getAllNetworks();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        if (isOnline(r0[r3]) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    @Override // coil.network.NetworkObserver
    public void shutdown() {
        this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
    }

    private final void onConnectivityChange(Network r7, boolean r8) {
        Network[] r0 = this.connectivityManager.getAllNetworks();
        int r1 = r0.length;
        boolean r2 = false;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        Network r4 = r0[r3];
        if (Intrinsics.areEqual(r4, r7) == false) goto L7;
        boolean r5 = r8;
    L8:
        if (r5 == true) goto L9;
        r3 = r3 + 1;
        goto L3
    L9:
        r2 = true;
        goto L11
    L7:
        r5 = isOnline(r4);
    L11:
        this.listener.onConnectivityChange(r2);
    }

    private final boolean isOnline(Network r1) {
        NetworkCapabilities r0 = this.connectivityManager.getNetworkCapabilities(r1);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasCapability(12) == false) goto L7;
        return true;
    }
}
