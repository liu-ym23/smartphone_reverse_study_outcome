package com.bytedanceos.securitycenter.dynamicResolution;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import bytedanceos.util.LogTag;
import com.bytedanceos.powerusage.DynamicResolutionConfig;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicResolutionHelper {
    private static final String TAG = "DynamicResolutionHelper";

    static {
    }

    public DynamicResolutionHelper() {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ int access$100(Context r0) {
        return getDynamicResState(r0);
    }

    public static void updatePackageInstall(final Context context, final String packageName, final int value) {
        LogTag.d(TAG, " updatePackageInstall value = " + value);
        AsyncTask.execute(new AnonymousClass1(packageName, context, value));
    }

    public static void updateGameApp(final Context context, final String packageName) {
        AsyncTask.execute(new AnonymousClass2(packageName, context));
    }

    private static int getDynamicResState(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), DynamicResolutionConfig.DYNAMIC_RES_STATE, -1);
    }

    public static void configureResolution(final Context context) {
        AsyncTask.execute(new AnonymousClass3(context));
    }
}
