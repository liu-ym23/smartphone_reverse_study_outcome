package com.android.settingslib.applications;

import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public class InterestingConfigChanges {
    private final int mFlags;
    private final Configuration mLastConfiguration;

    public InterestingConfigChanges() {
        this(-2147470844);
    }

    public InterestingConfigChanges(int r2) {
        this.mLastConfiguration = new Configuration();
        this.mFlags = r2;
    }

    public boolean applyNewConfig(Resources r1) {
        return applyNewConfig(r1.getConfiguration());
    }

    public boolean applyNewConfig(Configuration r2) {
        Configuration r0 = this.mLastConfiguration;
        int r3 = r0.updateFrom(Configuration.generateDelta(r0, r2));
        if ((this.mFlags & r3) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
