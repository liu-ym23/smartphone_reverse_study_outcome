package com.ss.android.ugc.quota;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class BDNetworkTagContextProviderAdapter implements IBDNetworkTagContextProvider {
    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public Map<String, Object> extra() {
        return null;
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int triggerType() {
        return 1;
    }

    public BDNetworkTagContextProviderAdapter() {
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public boolean markAsNewUser() {
        return BDNetworkTagManager.getInstance().isFirstInstallLaunch();
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int launchType() {
        int r1 = BDNetworkTagManager.getInstance().currentLaunchType();
        if (r1 != (-999)) goto L5;
    L14:
        return r1;
    L5:
        if (r1 == (-1)) goto L14;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L14;
        throw new IllegalStateException("BDNetworkTagManager#updateLaunchType should be called while launch type changed");
    }
}
