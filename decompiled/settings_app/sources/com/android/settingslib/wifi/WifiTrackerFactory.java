package com.android.settingslib.wifi;

import android.content.Context;
import com.android.settingslib.core.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public class WifiTrackerFactory {
    private static WifiTracker sTestingWifiTracker;

    public WifiTrackerFactory() {
    }

    public static void setTestingWifiTracker(WifiTracker r0) {
        sTestingWifiTracker = r0;
    }

    public static WifiTracker create(Context r7, WifiTracker.WifiListener r8, Lifecycle r9, boolean r10, boolean r11) {
        WifiTracker r0 = sTestingWifiTracker;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new WifiTracker(r7, r8, r9, r10, r11);
    }
}
