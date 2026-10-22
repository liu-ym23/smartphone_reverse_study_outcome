package com.ss.android.ugc.quota;

import com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor;

/* JADX INFO: loaded from: classes5.dex */
public interface IBDNetworkTagDepend {
    boolean enable();

    boolean isNewInstall();

    IBDNetworkLaunchMonitor launchMonitor();

    void onLaunchTypeUpdate(int r1);
}
