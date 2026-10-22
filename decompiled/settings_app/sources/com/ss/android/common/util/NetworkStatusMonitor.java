package com.ss.android.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes5.dex */
public final class NetworkStatusMonitor {
    private static final long ADJUST_INTERVAL = 5000;
    static final String TAG = "NetworkStatusMonitor";
    private static Context mContext = null;
    private static BroadcastReceiver mNetworkStateReceiver = null;
    private static volatile com.bytedance.common.utility.NetworkUtils.NetworkType mNetworkType = null;
    static boolean mReceiverOn = false;
    private static volatile NetworkStatusMonitor sNetworkStatusMonitor;
    private long lastAdjustTime;

    public void onDestroy() {
    }

    static /* synthetic */ com.bytedance.common.utility.NetworkUtils.NetworkType access$002(com.bytedance.common.utility.NetworkUtils.NetworkType r0) {
        mNetworkType = r0;
        return r0;
    }

    static /* synthetic */ Context access$100() {
        return mContext;
    }

    static {
        mNetworkType = com.bytedance.common.utility.NetworkUtils.NetworkType.MOBILE;
    }

    private NetworkStatusMonitor() {
        this.lastAdjustTime = 0;
    }

    public static NetworkStatusMonitor getIns(Context r2) {
        if (sNetworkStatusMonitor != null) goto L15;
        monitor-enter(NetworkStatusMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sNetworkStatusMonitor != null) goto L9;
        mContext = r2.getApplicationContext();     // Catch: Throwable -> L11
        sNetworkStatusMonitor = new NetworkStatusMonitor();     // Catch: Throwable -> L11
        mNetworkStateReceiver = new AnonymousClass1();     // Catch: Throwable -> L11
        start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkStatusMonitor.class);     // Catch: Throwable -> L11
    L15:
        return sNetworkStatusMonitor;
    }

    private static void start() {
        if (mReceiverOn == true) goto L6;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r0.addAction("android.net.wifi.STATE_CHANGE");
        mReceiverOn = true;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(mContext.getApplicationContext(), mNetworkStateReceiver, r0);     // Catch: Throwable -> L8
    L6:
        mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(mContext);
    }

    private void stop() {
        if (mReceiverOn == false) goto L6;
        mReceiverOn = false;
        mContext.unregisterReceiver(mNetworkStateReceiver);
        mNetworkStateReceiver = null;
        return;
    }

    public void onResume() {
        start();
    }

    public void onPause() {
        stop();
    }

    public com.bytedance.common.utility.NetworkUtils.NetworkType getNetworkType() {
        return mNetworkType;
    }

    public boolean isWifiOn() {
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.WIFI != mNetworkType) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNetworkOn() {
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.NONE != mNetworkType) goto L8;
        if ((System.currentTimeMillis() - this.lastAdjustTime) <= 5000) goto L8;
        mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(mContext);
        this.lastAdjustTime = System.currentTimeMillis();
    L8:
        if (com.bytedance.common.utility.NetworkUtils.NetworkType.NONE == mNetworkType) goto L10;
        return true;
    L10:
        return false;
    }
}
