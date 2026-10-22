package com.android.settings.applications;

import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes2.dex */
class InterestingConfigChanges {
    final Configuration mLastConfiguration;
    int mLastDensity;

    InterestingConfigChanges() {
        this.mLastConfiguration = new Configuration();
    }

    boolean applyNewConfig(Resources r6) {
        int r0 = this.mLastConfiguration.updateFrom(r6.getConfiguration());
        if (this.mLastDensity == r6.getDisplayMetrics().densityDpi) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L11:
        this.mLastDensity = r6.getDisplayMetrics().densityDpi;
        return true;
    L8:
        if ((r0 & 772) != 0) goto L11;
        return false;
    L5:
        r1 = false;
        goto L6
    }
}
