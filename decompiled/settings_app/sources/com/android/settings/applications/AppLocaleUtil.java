package com.android.settings.applications;

import android.app.LocaleConfig;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.LocaleList;
import android.util.FeatureFlagUtils;
import com.obric.olog.OLog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppLocaleUtil {
    public static final Intent LAUNCHER_ENTRY_INTENT = null;
    private static final String TAG = "AppLocaleUtil";
    static LocaleConfig sLocaleConfig;

    private static boolean isDisallowedPackage(Context r0, String r1) {
        return false;
    }

    public AppLocaleUtil() {
    }

    static {
        LAUNCHER_ENTRY_INTENT = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
    }

    public static boolean canDisplayLocaleUi(Context r5, ApplicationInfo r6, List<ResolveInfo> r7) {
        boolean r0 = isDisallowedPackage(r5, r6.packageName);
        boolean r8 = hasLauncherEntry(r6.packageName, r7);
        boolean r1 = r6.isSignedWithPlatformKey();
        if (r0 == true) goto L9;
        if (r1 == true) goto L9;
        if (r8 == false) goto L9;
        if (isAppLocaleSupported(r5, r6.packageName) == false) goto L9;
        boolean r9 = true;
    L10:
        OLog.i(TAG, "Can display preference - [" + r6.packageName + "] : isDisallowedPackage : " + r0 + " / isSignedWithPlatformKey : " + r1 + " / hasLauncherEntry : " + r8 + " / canDisplay : " + r9 + " / 1.1");
        return r9;
    L9:
        r9 = false;
        goto L10
    }

    private static boolean hasLauncherEntry(final String r1, List<ResolveInfo> r2) {
        return r2.stream().anyMatch(new AppLocaleUtil$$ExternalSyntheticLambda0(r1));
    }

    static /* synthetic */ boolean lambda$hasLauncherEntry$0(String r0, ResolveInfo r1) {
        return r1.activityInfo.packageName.equals(r0);
    }

    public static boolean isAppLocaleSupported(Context r3, String r4) {
        LocaleConfig r0 = sLocaleConfig;
        if (r0 == null) goto L5;
        LocaleList r1 = getPackageLocales(r0);
    L7:
        if (r1 == null) goto L14;
        if (r1.size() <= 0) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (FeatureFlagUtils.isEnabled(r3, "settings_app_locale_opt_in_enabled") == false) goto L17;
        return false;
    L17:
        if (getAssetLocales(r3, r4).length <= 0) goto L20;
        return true;
    L20:
        return false;
    L5:
        r1 = getPackageLocales(r3, r4);
        goto L7
    }

    public static String[] getAssetLocales(Context r6, String r7) {
        String[] r8 = r6.getPackageManager().getResourcesForApplication(r7).getAssets().getNonSystemLocales();     // Catch: PackageManager.NameNotFoundException -> L13
        if (r8 != null) goto L8;
        OLog.i(TAG, "[" + r7 + "] locales are null.");     // Catch: PackageManager.NameNotFoundException -> L13
    L8:
        if (r8.length > 0) goto L11;
        OLog.i(TAG, "[" + r7 + "] locales length is 0.");     // Catch: PackageManager.NameNotFoundException -> L13
        return new String[0];
    L11:
        OLog.i(TAG, "First asset locale - [" + r7 + "] " + r8[0]);     // Catch: PackageManager.NameNotFoundException -> L13
        return r8;
    L13:
        e = move-exception;
        OLog.w(TAG, "Can not found the package name : " + r7 + " / " + e);
        return new String[0];
    }

    static LocaleList getPackageLocales(LocaleConfig r1) {
        if (r1.getStatus() == 0) goto L5;
        return null;
    L5:
        return r1.getSupportedLocales();
    }

    public static LocaleList getPackageLocales(Context r3, String r4) {
        return getPackageLocales(new LocaleConfig(r3.createPackageContext(r4, 0)));
    L4:
        e = move-exception;
        OLog.w(TAG, "Can not found the package name : " + r4 + " / " + e);
        return null;
    }
}
