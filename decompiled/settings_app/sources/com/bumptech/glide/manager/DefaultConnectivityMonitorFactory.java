package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    public DefaultConnectivityMonitorFactory() {
    }

    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    public ConnectivityMonitor build(Context r3, ConnectivityMonitor.ConnectivityListener r4) {
        if (ContextCompat.checkSelfPermission(r3, NETWORK_PERMISSION) != 0) goto L5;
        boolean r2 = true;
    L7:
        if (Log.isLoggable(TAG, 3) == false) goto L12;
        if (r2 == false) goto L10;
        String r0 = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
    L11:
        Log.d(TAG, r0);
        goto L12
    L10:
        r0 = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
    L12:
        if (r2 == false) goto L15;
        return new DefaultConnectivityMonitor(r3, r4);
    L15:
        return new NullConnectivityMonitor();
    L5:
        r2 = false;
        goto L7
    }
}
