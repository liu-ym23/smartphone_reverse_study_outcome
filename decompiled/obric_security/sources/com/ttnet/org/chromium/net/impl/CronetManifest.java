package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class CronetManifest {
    static final String METRICS_OPT_IN_META_DATA_STR = "com.ttnet.org.chromium.net.CronetMetricsOptIn";

    private CronetManifest() {
    }

    public static boolean isAppOptedInForTelemetry(Context r2, CronetLogger.CronetSource r3) {
        ApplicationInfo r4 = r2.getPackageManager().getApplicationInfo(r2.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r4.metaData == null) goto L11;
        return r4.metaData.getBoolean(METRICS_OPT_IN_META_DATA_STR);
    L11:
        return false;
    L12:
        return false;
    }
}
