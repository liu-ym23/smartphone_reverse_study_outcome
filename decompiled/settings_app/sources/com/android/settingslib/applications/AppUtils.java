package com.android.settingslib.applications;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.Flags;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.hardware.usb.IUsbManager;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import com.android.settingslib.Utils;
import com.android.settingslib.applications.instantapps.InstantAppDataProvider;
import com.android.settingslib.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class AppUtils {
    private static final String TAG = "AppUtils";
    private static final Intent sBrowserIntent = null;
    private static InstantAppDataProvider sInstantAppDataProvider;

    public AppUtils() {
    }

    static {
        sBrowserIntent = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.parse("http:"));
    }

    public static CharSequence getLaunchByDefaultSummary(ApplicationsState.AppEntry r3, IUsbManager r4, PackageManager r5, Context r6) {
        String r7 = r3.info.packageName;
        boolean r1 = false;
        if (hasPreferredActivities(r5, r7) == false) goto L5;
    L8:
        boolean r8 = true;
    L10:
        if (r5.getIntentVerificationStatusAsUser(r7, UserHandle.myUserId()) == 0) goto L12;
        r1 = true;
    L12:
        if (r8 == true) goto L16;
        if (r1 == true) goto L16;
        int r9 = R.string.launch_defaults_none;
    L18:
        return r6.getString(r9);
    L16:
        r9 = R.string.launch_defaults_some;
        goto L18
    L5:
        if (hasUsbDefaults(r4, r7) == true) goto L8;
        r8 = false;
        goto L10
    }

    public static boolean hasUsbDefaults(IUsbManager r1, String r2) {
        if (r1 == null) goto L11;
        return r1.hasDefaults(r2, UserHandle.myUserId());
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "mUsbManager.hasDefaults", e);
        return false;
    L11:
        return false;
    }

    public static boolean hasPreferredActivities(PackageManager r2, String r3) {
        ArrayList r0 = new ArrayList();
        r2.getPreferredActivities(new ArrayList(), r0, r3);
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Have " + r0.size() + " number of activities in preferred list");
        if (r0.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isInstant(ApplicationInfo r7) {
        InstantAppDataProvider r0 = sInstantAppDataProvider;
        if (r0 == null) goto L8;
        if (r0.isInstantApp(r7) == false) goto L10;
        return true;
    L10:
        String r1 = SystemProperties.get("settingsdebug.instant.packages");
        if (r1 != null) goto L13;
    L24:
        return false;
    L13:
        if (r1.isEmpty() == true) goto L24;
        if (r7.packageName == null) goto L24;
        String[] r2 = r1.split(",");
        if (r2 == null) goto L24;
        int r3 = r2.length;
        int r4 = 0;
    L19:
        if (r4 >= r3) goto L24;
        if (r7.packageName.contains(r2[r4]) == true) goto L22;
        r4 = r4 + 1;
        goto L19
    L22:
        return true;
    L8:
        if (r7.isInstantApp() == false) goto L10;
        return true;
    }

    public static CharSequence getApplicationLabel(PackageManager r0, String r1) {
        return com.android.settingslib.utils.applications.AppUtils.getApplicationLabel(r0, r1);
    }

    public static boolean isHiddenSystemModule(Context r0, String r1) {
        return ApplicationsState.getInstance((Application) r0.getApplicationContext()).isHiddenModule(r1);
    }

    public static boolean isSystemModule(Context r0, String r1) {
        return ApplicationsState.getInstance((Application) r0.getApplicationContext()).isSystemModule(r1);
    }

    public static boolean isMainlineModule(PackageManager r2, String r3) {
        r2.getModuleInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L5
        return true;
    L5:
        PackageInfo r4 = r2.getPackageInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        if (Flags.provideInfoOfApkInApex() == false) goto L13;
        if (r4.getApexPackageName() == null) goto L11;
        return true;
    L11:
        return false;
    L13:
        return r4.applicationInfo.sourceDir.startsWith(Environment.getApexDirectory().getAbsolutePath());
    L14:
        return false;
    }

    public static String getAppContentDescription(Context r0, String r1, int r2) {
        return com.android.settingslib.utils.applications.AppUtils.getAppContentDescription(r0, r1, r2);
    }

    public static boolean isBrowserApp(Context r1, String r2, int r3) {
        Intent r0 = sBrowserIntent;
        r0.setPackage(r2);
        Iterator r4 = r1.getPackageManager().queryIntentActivitiesAsUser(r0, 131072, r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        ResolveInfo r5 = (ResolveInfo) r4.next();
        if (r5.activityInfo == null) goto L4;
        if (r5.handleAllWebDataURI == false) goto L4;
        return true;
    L11:
        return false;
    }

    public static boolean isDefaultBrowser(Context r1, String r2) {
        return TextUtils.equals(r2, r1.getPackageManager().getDefaultBrowserPackageNameAsUser(UserHandle.myUserId()));
    }

    public static Drawable getIcon(Context r5, ApplicationsState.AppEntry r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.info == null) goto L29;
        AppIconCacheManager r0 = AppIconCacheManager.getInstance();
        String r1 = r6.info.packageName;
        int r2 = r6.info.uid;
        Drawable r3 = r0.get(r1, r2);
        if (r3 != null) goto L15;
        if (r6.apkFile != null) goto L11;
    L13:
        setAppEntryMounted(r6, false);
        return r5.getDrawable(17305168);
    L11:
        if (r6.apkFile.exists() == false) goto L13;
        Drawable r4 = Utils.getBadgedIcon(r5, r6.info);
        r0.put(r1, r2, r4);
        return r4;
    L15:
        if (r6.mounted == false) goto L17;
        return r3;
    L17:
        if (r6.apkFile != null) goto L19;
        return r3;
    L19:
        if (r6.apkFile.exists() == false) goto L28;
        setAppEntryMounted(r6, true);
        Drawable r7 = Utils.getBadgedIcon(r5, r6.info);
        r0.put(r1, r2, r7);
        return r7;
    L28:
        return r3;
    L29:
        return null;
    }

    public static Drawable getIconFromCache(ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L4;
    L7:
        return null;
    L4:
        if (r2.info == null) goto L7;
        return AppIconCacheManager.getInstance().get(r2.info.packageName, r2.info.uid);
    }

    public static void preloadTopIcons(final Context r4, ArrayList<ApplicationsState.AppEntry> r5, int r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L13;
        if (r6 <= 0) goto L14;
        int r0 = 0;
    L9:
        if (r0 >= Math.min(r5.size(), r6)) goto L15;
        final ApplicationsState.AppEntry r1 = r5.get(r0);
        ThreadUtils.getBackgroundExecutor().submit(new AppUtils$$ExternalSyntheticLambda0(r4, r1));
        r0 = r0 + 1;
        goto L9
    L15:
        return;
    L14:
        return;
    }

    static /* synthetic */ void lambda$preloadTopIcons$0(Context r0, ApplicationsState.AppEntry r1) {
        getIcon(r0, r1);
    }

    public static boolean isAppInstalled(ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.info != null) goto L8;
        return false;
    L8:
        if ((r2.info.flags & 8388608) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    private static void setAppEntryMounted(ApplicationsState.AppEntry r1, boolean r2) {
        if (r1.mounted == r2) goto L11;
        monitor-enter(r1);
        r1.mounted = r2;     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static int getCloneUserId(Context r3) {
        UserManager r4 = (UserManager) r3.getSystemService(UserManager.class);
        Iterator<UserHandle> r0 = r4.getUserProfiles().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UserHandle r1 = r0.next();
        if (r4.getUserInfo(r1.getIdentifier()).isCloneProfile() == false) goto L4;
        return r1.getIdentifier();
    L9:
        return -1;
    }
}
