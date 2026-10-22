package com.ss.android.ugc.quota;

import android.app.Application;
import android.util.Log;
import android.util.Pair;
import com.ss.android.ugc.quota.launch.BDNetworkLaunchMonitor;
import com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class BDNetworkTagManager {
    private static final String BD_NETWORK_REQUEST_TAG_KEY = "x-tt-request-tag";
    private static final String TAG = "BDNetworkTagManager";
    private static volatile BDNetworkTagManager sInstance;
    private Application context;
    private IBDNetworkTagDepend depend;
    private AtomicBoolean enable;
    private boolean firstInstallLaunch;
    private AtomicBoolean inited;
    private IBDNetworkLaunchMonitor launchMonitor;
    private int launchType;

    private BDNetworkTagManager() {
        this.enable = new AtomicBoolean(false);
        this.inited = new AtomicBoolean(false);
        this.launchType = -999;
    }

    public static BDNetworkTagManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(BDNetworkTagManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BDNetworkTagManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDNetworkTagManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void init(Application r3, IBDNetworkTagDepend r4) {
        if (this.inited.get() == false) goto L6;
        Log.d(TAG, "Already inited");
        return;
    L6:
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        this.context = r3;
        this.depend = r4;
        this.enable.set(r4.enable());
        if (r4.launchMonitor() != null) goto L11;
        IBDNetworkLaunchMonitor r0 = new BDNetworkLaunchMonitor(r3);
    L12:
        this.launchMonitor = r0;
        this.firstInstallLaunch = r4.isNewInstall();
        this.inited.compareAndSet(false, true);
        return;
    L11:
        r0 = r4.launchMonitor();
    L15:
        throw new IllegalArgumentException("Context or depend is NULL");
    }

    public void enable(boolean r1) {
        this.enable.set(r1);
    }

    public void updateLaunchType(int r2) {
        if (enabled() == true) goto L5;
        return;
    L5:
        this.launchType = r2;
        IBDNetworkTagDepend r1 = this.depend;
        if (r1 == null) goto L9;
        r1.onLaunchTypeUpdate(r2);
        return;
    }

    public Pair<String, String> buildBDNetworkTag(IBDNetworkTagContextProvider r3) {
        if (enabled() == true) goto L6;
        return null;
    L6:
        if (r3 == null) goto L13;
        int r0 = this.launchMonitor.currentLaunchType();
        if (this.launchType == r0) goto L11;
        updateLaunchType(r0);
    L11:
        return new Pair(BD_NETWORK_REQUEST_TAG_KEY, "t=" + r3.triggerType() + ";n=" + (r3.markAsNewUser() ? 1 : 0));
    L13:
        throw new IllegalArgumentException("ContextProvider is NULL");
    }

    public int currentLaunchType() {
        if (enabled() == true) goto L7;
        return -999;
    L7:
        return this.launchType;
    }

    public boolean isFirstInstallLaunch() {
        if (enabled() == true) goto L7;
        return false;
    L7:
        return this.firstInstallLaunch;
    }

    private boolean enabled() {
        if (this.inited.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.enable.get() == false) goto L7;
        return true;
    }
}
