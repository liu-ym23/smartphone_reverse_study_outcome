package com.ttnet.org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.BuildCompat;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BuildInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_FINGERPRINT_LENGTH = 128;
    private static final String TAG = "BuildInfo";
    private static ApplicationInfo sBrowserApplicationInfo = null;
    private static PackageInfo sBrowserPackageInfo = null;
    private static String sFirebaseAppId = "";
    private static boolean sInitialized;
    public String abiString;
    public String androidBuildFingerprint;
    public String customThemes;
    public String gmsVersionCode;
    public String hostPackageLabel;
    public long hostVersionCode;
    public String installerPackageName;
    public boolean isAutomotive;
    public boolean isTV;
    public String packageName;
    public String resourcesVersion;
    public long versionCode;
    public String versionName;

    public static class Holder {
        private static BuildInfo sInstance;

        static {
            sInstance = new BuildInfo();
        }

        private Holder() {
        }

        public static /* synthetic */ BuildInfo access$000() {
            return sInstance;
        }
    }

    @VisibleForTesting
    public BuildInfo() {
        this.hostPackageLabel = "";
        this.packageName = "";
        this.versionName = "";
        this.installerPackageName = "";
        this.gmsVersionCode = "";
        this.abiString = "";
        this.androidBuildFingerprint = "";
        this.customThemes = "";
        this.resourcesVersion = "";
        boolean r0 = true;
        sInitialized = true;
        Context r2 = ContextUtils.getApplicationContext();     // Catch: Exception -> L6
        String r3 = r2.getPackageName();     // Catch: Exception -> L6
        PackageManager r4 = r2.getPackageManager();     // Catch: Exception -> L6
        PackageInfo r5 = r4.getPackageInfo(r3, 0);     // Catch: Exception -> L6
        long r6 = packageVersionCode(r5);     // Catch: Exception -> L6
        this.hostVersionCode = r6;     // Catch: Exception -> L6
        PackageInfo r8 = sBrowserPackageInfo;     // Catch: Exception -> L6
        if (r8 == null) goto L8;
        this.packageName = r8.packageName;     // Catch: Exception -> L6
        this.versionCode = packageVersionCode(r8);     // Catch: Exception -> L6
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);     // Catch: Exception -> L6
        sBrowserApplicationInfo = sBrowserPackageInfo.applicationInfo;     // Catch: Exception -> L6
        sBrowserPackageInfo = null;     // Catch: Exception -> L6
    L9:
        this.hostPackageLabel = nullToEmpty(r4.getApplicationLabel(r5.applicationInfo));     // Catch: Exception -> L6
        this.installerPackageName = nullToEmpty(r4.getInstallerPackageName(this.packageName));     // Catch: Exception -> L6
        String r7 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L26;
    L14:
        this.resourcesVersion = r7;     // Catch: Exception -> L6
        this.abiString = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L6
        String r9 = Build.FINGERPRINT;     // Catch: Exception -> L6
        this.androidBuildFingerprint = r9.substring(0, Math.min(r9.length(), 128));     // Catch: Exception -> L6
        UiModeManager r10 = (UiModeManager) r2.getSystemService("uimode");     // Catch: Exception -> L6
        if (r10 != null) goto L17;
    L19:
        r0 = false;
    L20:
        this.isTV = r0;     // Catch: Exception -> L6
        this.isAutomotive = r2.getPackageManager().hasSystemFeature("android.hardware.type.automotive");     // Catch: Exception -> L6
        return;
    L17:
        if (r10.getCurrentModeType() != 4) goto L19;
    L26:
        r7 = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L13
    L13:
        r7 = "Not found";
        goto L14
    L8:
        this.packageName = r3;     // Catch: Exception -> L6
        this.versionCode = r6;     // Catch: Exception -> L6
        this.versionName = nullToEmpty(r5.versionName);     // Catch: Exception -> L6
        sBrowserApplicationInfo = r2.getApplicationInfo();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "NameNotFoundException: " + e, new Object[0]);
    }

    @CalledByNative
    private static String[] getAll() {
        return getInstance().getAllProperties();
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }

    public static BuildInfo getInstance() {
        return Holder.access$000();
    }

    private static boolean isAtLeastPreReleaseCodename(String r2, String r3) {
        if ("REL".equals(r3) == false) goto L5;
        return false;
    L5:
        Locale r0 = Locale.ROOT;
        if (r3.toUpperCase(r0).compareTo(r2.toUpperCase(r0)) < 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isAtLeastT() {
        return isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME);
    }

    public static boolean isDebugAndroid() {
        String r0 = Build.TYPE;
        if ("eng".equals(r0) == false) goto L5;
    L8:
        return true;
    L5:
        if ("userdebug".equals(r0) == true) goto L8;
        return false;
    }

    private static String nullToEmpty(CharSequence r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.toString();
    }

    public static long packageVersionCode(PackageInfo r2) {
        return ApiHelperForP.getLongVersionCode(r2);
    }

    public static void setBrowserPackageInfo(PackageInfo r0) {
        sBrowserPackageInfo = r0;
    }

    public static void setFirebaseAppId(String r0) {
        sFirebaseAppId = r0;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static boolean targetsAtLeastT() {
        if (ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion < 33) goto L5;
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    public String[] getAllProperties() {
        String r10 = ContextUtils.getApplicationContext().getPackageName();
        String r2 = Build.BRAND;
        String r3 = Build.DEVICE;
        String r4 = Build.ID;
        String r5 = Build.MANUFACTURER;
        String r6 = Build.MODEL;
        String r7 = String.valueOf(Build.VERSION.SDK_INT);
        String r8 = Build.TYPE;
        String r9 = Build.BOARD;
        String r11 = String.valueOf(this.hostVersionCode);
        String r12 = this.hostPackageLabel;
        String r13 = this.packageName;
        String r14 = String.valueOf(this.versionCode);
        String r15 = this.versionName;
        String r1 = this.androidBuildFingerprint;
        String r16 = this.gmsVersionCode;
        String r17 = this.installerPackageName;
        String r18 = this.abiString;
        String r20 = sFirebaseAppId;
        String r19 = this.customThemes;
        String r21 = this.resourcesVersion;
        String r22 = String.valueOf(ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion);
        if (isDebugAndroid() == false) goto L5;
        String r26 = "1";
    L7:
        if (this.isTV == false) goto L9;
        String r23 = "1";
    L10:
        String r28 = Build.VERSION.INCREMENTAL;
        String r29 = Build.HARDWARE;
        if (isAtLeastT() == false) goto L13;
        String r30 = "1";
    L15:
        if (this.isAutomotive == false) goto L17;
        String r0 = "1";
    L19:
        return new String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1, r16, r17, r18, r20, r19, r21, r22, r26, r23, r28, r29, r30, r0};
    L17:
        r0 = "0";
        goto L19
    L13:
        r30 = "0";
        goto L15
    L9:
        r23 = "0";
        goto L10
    L5:
        r26 = "0";
        goto L7
    }

    public ApplicationInfo getBrowserApplicationInfo() {
        return sBrowserApplicationInfo;
    }
}
