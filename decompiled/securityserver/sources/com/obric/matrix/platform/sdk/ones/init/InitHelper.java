package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.crash.MatrixCrashConfigBuilder;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsConfig;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class InitHelper {

    @NotNull
    public static final InitHelper INSTANCE = null;

    @NotNull
    public static final String TAG = "InitHelper";

    static {
        INSTANCE = new InitHelper();
    }

    private InitHelper() {
    }

    private final int getVersionCode(Application r3) {
        return r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;
    L5:
        e = move-exception;
        Log.e(TAG, "Failed to get version code", e);
        return 0;
    }

    private final String getVersionName(Application r3) {
        String r4 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionName;     // Catch: PackageManager.NameNotFoundException -> L7
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4;
    L7:
        e = move-exception;
        Log.e(TAG, "Failed to get version name", e);
        return "";
    }

    private final void initCrashProtect(Application r4) {
        CrashProvider.INSTANCE.refreshJson(MatrixSettingsManager.Companion.getInstance().getAllSettings());     // Catch: Exception -> L4
        MatrixCrashConfigBuilder r0 = new MatrixCrashConfigBuilder(r4).enableSpBlockPlugin(true).enableSpFetcherDeadObjectPlugin(true).enableProviderInstalledFailedPlugin(true).enableCookieManagerPlugin(true).enableFinalizeTimeoutPlugin(true).enableJsDialogBadTokenPlugin(true).enableStopActivityNPEPlugin(true).enableToastBadTokenPlugin(true).enableSuperUncaughtExceptionPlugin(true);     // Catch: Exception -> L4
        String r1 = r4.getPackageName();     // Catch: Exception -> L4
        Intrinsics.e(r1, "application.packageName");     // Catch: Exception -> L4
        r0.packageName(r1).appVersion(getVersionName(r4)).updateVersion(getVersionCode(r4)).crashPortraitProvider(AnonymousClass1.INSTANCE).onCrashCatchSucceed(AnonymousClass2.INSTANCE).buildAndInit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MLog.e(TAG, "initCrashProtect error", e);
    }

    public final void initSettingsAndCrashProtect(@NotNull Application r5, boolean r6) {
        Intrinsics.f(r5, "application");
        MatrixSettingsManager.Companion r0 = MatrixSettingsManager.Companion;
        if (r0.isInited() == true) goto L5;
        MatrixSettingsConfig.Builder r1 = new MatrixSettingsConfig.Builder();
        String r2 = r5.getPackageName();
        Intrinsics.e(r2, "application.packageName");
        r0.init(r5, r1.setPackageName(r2).setVersionCode(getVersionCode(r5)).setIsBoe(r6).setVersionName(getVersionName(r5)).build());
    L5:
        r0.getInstance().addSettingsUpdateListener(new C00341());
        initCrashProtect(r5);
    }
}
