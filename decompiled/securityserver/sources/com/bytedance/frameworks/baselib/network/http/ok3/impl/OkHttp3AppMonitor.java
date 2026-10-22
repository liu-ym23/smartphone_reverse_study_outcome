package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3AppMonitor implements LifeCycleMonitor.AppStateListener {
    private static final String TAG = "OkHttp3AppMonitor";
    private LifeCycleMonitor mLifeCycleMonitor;
    private BroadcastReceiver mNetworkStateReceiver;

    public OkHttp3AppMonitor() {
        this.mLifeCycleMonitor = new LifeCycleMonitor();
        this.mNetworkStateReceiver = new AnonymousClass1(this);
    }

    private void registerForeBackgroundCallback(Context r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "register activity forground and background switch Callback");
    L6:
        if ((r3 instanceof Application) == false) goto L11;
        Application r4 = (Application) r3;
        if (r4 == null) goto L12;
        this.mLifeCycleMonitor.setAppStateChangedListener(this);
        r4.registerActivityLifecycleCallbacks(this.mLifeCycleMonitor);
        return;
    L12:
        return;
    }

    private void registerNetworkStateChanged(Context r3) {
        if (r3 == null) goto L7;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r3.registerReceiver(this.mNetworkStateReceiver, r0);
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "register network state changed completed");
        return;
    L8:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        HttpDns.getService().onResume();
    }

    public void registerAppMonitorListener(Context r1) {
        registerNetworkStateChanged(r1);
        registerForeBackgroundCallback(r1);
    }
}
