package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.crash.MatrixCrashConfigBuilder;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsConfig;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/InitHelper;", "", "()V", "TAG", "", "buildSettingsConfig", "Lcom/obric/matrix/platform/sdk/ones/settings/MatrixSettingsConfig;", "context", "Landroid/content/Context;", "isBoolean", "", "getVersionCode", "", "getVersionName", "initCrashProtect", "", "application", "Landroid/app/Application;", "crashProtectConfig", "Lcom/obric/matrix/platform/sdk/ones/init/CrashProtectConfig;", "initSettings", "initSettingsAndCrashProtect", "prepareSettings", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InitHelper {
    public static final InitHelper INSTANCE = null;
    public static final String TAG = "InitHelper";

    static {
        INSTANCE = new InitHelper();
    }

    private InitHelper() {
    }

    private final int getVersionCode(Context r3) {
        return r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;
    L5:
        e = move-exception;
        Log.e(TAG, "Failed to get version code", e);
        return 0;
    }

    private final String getVersionName(Context r3) {
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

    public final void initSettingsAndCrashProtect(Application r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "application");
        initSettingsAndCrashProtect(r2, r3, new CrashProtectConfig.Builder().build());
    }

    public final void initSettingsAndCrashProtect(Application r2, boolean r3, CrashProtectConfig r4) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Intrinsics.checkNotNullParameter(r4, "crashProtectConfig");
        initSettings(r2, r3);
        MatrixSettingsManager.Companion.getInstance().addSettingsUpdateListener(new C02311());
        initCrashProtect(r2, r4);
    }

    public final void prepareSettings(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (MatrixSettingsManager.Companion.isInited() == true) goto L6;
        Context r5 = r3.getApplicationContext();
        MatrixSettingsManager.Companion r0 = MatrixSettingsManager.Companion;
        Intrinsics.checkNotNullExpressionValue(r5, "appContext");
        r0.prepare$sdk_platform_ones_release(r5, buildSettingsConfig(r5, r4));
        return;
    }

    public final void initSettings(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (MatrixSettingsManager.Companion.isInited() == true) goto L6;
        Context r5 = r3.getApplicationContext();
        MatrixSettingsManager.Companion r0 = MatrixSettingsManager.Companion;
        Intrinsics.checkNotNullExpressionValue(r5, "appContext");
        r0.init(r5, buildSettingsConfig(r5, r4));
        return;
    }

    private final MatrixSettingsConfig buildSettingsConfig(Context r4, boolean r5) {
        MatrixSettingsConfig.Builder r0 = new MatrixSettingsConfig.Builder();
        String r1 = r4.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r1, "context.packageName");
        return r0.setPackageName(r1).setVersionCode(getVersionCode(r4)).setIsBoe(r5).setVersionName(getVersionName(r4)).build();
    }

    private final void initCrashProtect(Application r3, CrashProtectConfig r4) {
        CrashProvider.INSTANCE.refreshJson(MatrixSettingsManager.Companion.getInstance().getAllSettings());     // Catch: Exception -> L4
        MatrixCrashConfigBuilder r5 = new MatrixCrashConfigBuilder(r3).enableSpBlockPlugin(r4.getEnableSpBlockPlugin()).enableSpFetcherDeadObjectPlugin(r4.getEnableSpFetcherDeadObjectPlugin()).enableProviderInstalledFailedPlugin(r4.getEnableProviderInstalledFailedPlugin()).enableCookieManagerPlugin(r4.getEnableCookieManagerPlugin()).enableFinalizeTimeoutPlugin(r4.getEnableFinalizeTimeoutPlugin()).enableJsDialogBadTokenPlugin(r4.getEnableJsDialogBadTokenPlugin()).enableStopActivityNPEPlugin(r4.getEnableStopActivityNPEPlugin()).enableToastBadTokenPlugin(r4.getEnableToastBadTokenPlugin()).enableSuperUncaughtExceptionPlugin(r4.getEnableSuperUncaughtExceptionPlugin());     // Catch: Exception -> L4
        String r0 = r3.getPackageName();     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r0, "application.packageName");     // Catch: Exception -> L4
        r5.packageName(r0).appVersion(getVersionName(r3)).updateVersion(getVersionCode(r3)).crashPortraitProvider(AnonymousClass1.INSTANCE).onCrashCatchSucceed(AnonymousClass2.INSTANCE).buildAndInit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MLog.e(TAG, "initCrashProtect error", e);
    }
}
