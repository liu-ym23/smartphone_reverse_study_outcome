package com.bytedance.bdlocation.scan.networklistener;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
    private Network lastNetWork;

    public NetworkCallbackImpl() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(@NonNull Network r1) {
        super.onAvailable(r1);
        Logger.d("NetworkCallback:onAvailable: 网络已连接");
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(@NonNull Network r3, @NonNull NetworkCapabilities r4) {
        super.onCapabilitiesChanged(r3, r4);
        if (r3 == null) goto L20;
        if (r4 == null) goto L21;
        Logger.d(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged network：" + r3.toString());
        if (this.lastNetWork == null) goto L10;
        Logger.d(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged lastNetWork：" + this.lastNetWork.toString());
    L10:
        if (r3.equals(this.lastNetWork) == false) goto L18;
        Logger.d(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged: 相同network");
        return;
    L18:
        Logger.d(NetworkManager.TAG + ":NetworkCallback:resetPollUploadScheduleNetWorkChange");     // Catch: Exception -> L15
        NetworkManager.getInstance().notifyWifiChanged(r3, r4);     // Catch: Exception -> L15
        this.lastNetWork = r3;     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        Logger.e(NetworkManager.TAG + ":NetworkCallback:onCapabilitiesChanged error", e);
        return;
    L21:
        return;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(@NonNull Network r1) {
        super.onLost(r1);
        Logger.d("NetworkCallback:onLost: 网络已断开");
    }
}
