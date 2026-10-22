package com.ss.android.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkStatusMonitorLite {
    private static final long ADJUST_INTERVAL = 5000;
    private static final String STATE_CHANGE = "android.net.wifi.STATE_CHANGE";
    static final String TAG = "NTStatusMonitorLite";
    private static final String WIFI_STATE_CHANGE = "android.net.wifi.WIFI_STATE_CHANGED";
    private static volatile NetworkStatusMonitorLite sNetworkStatusMonitor;
    private long lastAdjustTime;
    private final Context mContext;
    private BroadcastReceiver mNetworkStateReceiver;
    private com.bytedance.common.utility.NetworkUtils.NetworkType mNetworkType;
    private boolean mReceiverOn;

    static /* synthetic */ com.bytedance.common.utility.NetworkUtils.NetworkType access$002(NetworkStatusMonitorLite r0, com.bytedance.common.utility.NetworkUtils.NetworkType r1) {
        r0.mNetworkType = r1;
        return r1;
    }

    static /* synthetic */ Context access$100(NetworkStatusMonitorLite r0) {
        return r0.mContext;
    }

    public static NetworkStatusMonitorLite getIns(Context r2) {
        if (sNetworkStatusMonitor != null) goto L15;
        monitor-enter(NetworkStatusMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sNetworkStatusMonitor != null) goto L9;
        sNetworkStatusMonitor = new NetworkStatusMonitorLite(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkStatusMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sNetworkStatusMonitor;
    }

    private NetworkStatusMonitorLite(Context r3) {
        this.mReceiverOn = false;
        this.mNetworkType = com.bytedance.common.utility.NetworkUtils.NetworkType.MOBILE;
        this.lastAdjustTime = 0;
        this.mContext = r3.getApplicationContext();
        start();
    }

    public void onResume() {
        start();
    }

    public void onPause() {
        stop();
    }

    public void onDestroy() {
        if (this.mReceiverOn == false) goto L13;
        this.mReceiverOn = false;
        this.mContext.unregisterReceiver(this.mNetworkStateReceiver);     // Catch: Exception -> L7
    L9:
        this.mNetworkStateReceiver = null;
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    private void start() {
        if (this.mReceiverOn == true) goto L6;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r0.addAction(WIFI_STATE_CHANGE);
        r0.addAction(STATE_CHANGE);
        BroadcastReceiver r1 = new AnonymousClass1(this);
        this.mNetworkStateReceiver = r1;
        this.mReceiverOn = true;
        this.mContext.registerReceiver(r1, r0);     // Catch: Throwable -> L8
    L6:
        this.mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(this.mContext);
    }

    private void stop() {
        if (this.mReceiverOn == false) goto L13;
        this.mReceiverOn = false;
        this.mContext.unregisterReceiver(this.mNetworkStateReceiver);     // Catch: Exception -> L7
    L9:
        this.mNetworkStateReceiver = null;
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public com.bytedance.common.utility.NetworkUtils.NetworkType getNetworkType() {
        refreshNetStatus();
        return this.mNetworkType;
    }

    private void refreshNetStatus() {
        if ((System.currentTimeMillis() - this.lastAdjustTime) <= 5000) goto L6;
        this.mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(this.mContext);
        this.lastAdjustTime = System.currentTimeMillis();
        return;
    }

    public boolean isWifiOn() {
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.WIFI != this.mNetworkType) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNetworkOn() {
        refreshNetStatus();
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.NONE == this.mNetworkType) goto L5;
        return true;
    L5:
        return false;
    }
}
