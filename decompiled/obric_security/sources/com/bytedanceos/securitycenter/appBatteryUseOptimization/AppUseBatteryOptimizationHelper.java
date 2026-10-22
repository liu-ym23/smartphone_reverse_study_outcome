package com.bytedanceos.securitycenter.appBatteryUseOptimization;

import android.content.Context;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes2.dex */
public class AppUseBatteryOptimizationHelper {
    public AppUseBatteryOptimizationHelper() {
    }

    public static void updatePackageInstall(final Context context, final String packageName, final int value, final int userId) {
        AsyncTask.execute(new AnonymousClass1(packageName, userId, value, context));
    }
}
