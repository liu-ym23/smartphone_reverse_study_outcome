package com.ss.android.ugc.quota.launch;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import com.ss.android.ugc.quota.BDNetworkTagManager;

/* JADX INFO: loaded from: classes5.dex */
public class BDNetworkLaunchMonitor implements IBDNetworkLaunchMonitor {
    private static final String TAG = "BDNetworkLaunchMonitor";
    private boolean appInBackground;
    private int fgActivityCount;
    private boolean firstLaunch;
    private int launchType;

    static /* synthetic */ boolean access$000(BDNetworkLaunchMonitor r0) {
        return r0.firstLaunch;
    }

    static /* synthetic */ boolean access$002(BDNetworkLaunchMonitor r0, boolean r1) {
        r0.firstLaunch = r1;
        return r1;
    }

    static /* synthetic */ void access$100(BDNetworkLaunchMonitor r0, int r1) {
        r0.onLaunchTypeChanged(r1);
    }

    static /* synthetic */ void access$200(BDNetworkLaunchMonitor r0, String r1, Activity r2) {
        r0.logCurrentStats(r1, r2);
    }

    static /* synthetic */ int access$300(BDNetworkLaunchMonitor r0) {
        return r0.fgActivityCount;
    }

    static /* synthetic */ int access$308(BDNetworkLaunchMonitor r2) {
        int r0 = r2.fgActivityCount;
        r2.fgActivityCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$310(BDNetworkLaunchMonitor r2) {
        int r0 = r2.fgActivityCount;
        r2.fgActivityCount = r0 - 1;
        return r0;
    }

    static /* synthetic */ boolean access$400(BDNetworkLaunchMonitor r0) {
        return r0.appInBackground;
    }

    static /* synthetic */ boolean access$402(BDNetworkLaunchMonitor r0, boolean r1) {
        r0.appInBackground = r1;
        return r1;
    }

    public BDNetworkLaunchMonitor(Application r2) {
        this.fgActivityCount = 0;
        this.appInBackground = false;
        this.firstLaunch = true;
        this.launchType = -999;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.registerActivityLifecycleCallbacks(new AnonymousClass1(this));
    }

    private void onLaunchTypeChanged(int r3) {
        if (this.launchType != r3) goto L5;
        return;
    L5:
        Log.d(TAG, "Current launch type is " + r3);
        this.launchType = r3;
        BDNetworkTagManager.getInstance().updateLaunchType(r3);
    }

    private void logCurrentStats(String r2, Activity r3) {
        Log.d(TAG, r2 + ", Activity:" + r3 + ",fgActivityCount: " + this.fgActivityCount + ",appInBackground: " + this.appInBackground);
    }

    @Override // com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor
    public int currentLaunchType() {
        return this.launchType;
    }
}
