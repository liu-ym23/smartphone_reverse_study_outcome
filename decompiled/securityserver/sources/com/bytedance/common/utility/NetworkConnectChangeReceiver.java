package com.bytedance.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NetworkConnectChangeReceiver extends BroadcastReceiver {
    public NetworkConnectChangeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r2, Intent r3) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r3.getAction()) == false) goto L5;
    L8:
        NetworkUtils.setNetworkType(NetworkUtils.getNetworkType(r2));
        return;
    L5:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r3.getAction()) == true) goto L8;
        if ("android.net.wifi.STATE_CHANGE".equals(r3.getAction()) == true) goto L8;
    }
}
