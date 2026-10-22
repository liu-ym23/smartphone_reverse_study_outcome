package com.ss.android.ugc.quota;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public a() {
    }

    public Map<String, Object> extra() {
        return null;
    }

    public int launchType() {
        int r1 = BDNetworkTagManager.d().b();
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

    @Override // com.ss.android.ugc.quota.b
    public boolean markAsNewUser() {
        return BDNetworkTagManager.d().e();
    }

    @Override // com.ss.android.ugc.quota.b
    public int triggerType() {
        throw null;
    }
}
