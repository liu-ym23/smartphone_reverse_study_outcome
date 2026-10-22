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
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
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

    private static class Holder {
        private static BuildInfo sInstance;

        static {
            sInstance = new BuildInfo();
        }

        private Holder() {
        }

        static /* synthetic */ BuildInfo access$000() {
            return sInstance;
        }
    }

    static {
    }

    @VisibleForTesting
    BuildInfo() {
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
        Context r2 = ContextUtils.getApplicationContext();     // Catch: Exception -> L25
        String r3 = r2.getPackageName();     // Catch: Exception -> L25
        PackageManager r4 = r2.getPackageManager();     // Catch: Exception -> L25
        PackageInfo r5 = r4.getPackageInfo(r3, 0);     // Catch: Exception -> L25
        long r6 = packageVersionCode(r5);     // Catch: Exception -> L25
        this.hostVersionCode = r6;     // Catch: Exception -> L25
        PackageInfo r8 = sBrowserPackageInfo;     // Catch: Exception -> L25
        if (r8 == null) goto L6;
        this.packageName = r8.packageName;     // Catch: Exception -> L25
        this.versionCode = packageVersionCode(r8);     // Catch: Exception -> L25
        this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);     // Catch: Exception -> L25
        sBrowserApplicationInfo = sBrowserPackageInfo.applicationInfo;     // Catch: Exception -> L25
        sBrowserPackageInfo = null;     // Catch: Exception -> L25
    L7:
        this.hostPackageLabel = nullToEmpty(r4.getApplicationLabel(r5.applicationInfo));     // Catch: Exception -> L25
        this.installerPackageName = nullToEmpty(r4.getInstallerPackageName(this.packageName));     // Catch: Exception -> L25
        String r7 = "Not Enabled";
        if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) goto L28;
    L12:
        this.resourcesVersion = r7;     // Catch: Exception -> L25
        if (Build.VERSION.SDK_INT < 21) goto L16;
        String r9 = TextUtils.join(", ", Build.SUPPORTED_ABIS);     // Catch: Exception -> L25
    L15:
        this.abiString = r9;     // Catch: Exception -> L25
        String r10 = Build.FINGERPRINT;     // Catch: Exception -> L25
        this.androidBuildFingerprint = r10.substring(0, Math.min(r10.length(), 128));     // Catch: Exception -> L25
        UiModeManager r11 = (UiModeManager) r2.getSystemService("uimode");     // Catch: Exception -> L25
        if (r11 != null) goto L20;
    L22:
        r0 = false;
    L23:
        this.isTV = r0;     // Catch: Exception -> L25
        this.isAutomotive = r2.getPackageManager().hasSystemFeature("android.hardware.type.automotive");     // Catch: Exception -> L25
        return;
    L20:
        if (r11.getCurrentModeType() != 4) goto L22;
    L16:
        r9 = String.format("ABI1: %s, ABI2: %s", new Object[]{Build.CPU_ABI, Build.CPU_ABI2});     // Catch: Exception -> L25
        goto L15
    L28:
        r7 = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);     // Catch: Exception -> L11
    L11:
        r7 = "Not found";
        goto L12
    L6:
        this.packageName = r3;     // Catch: Exception -> L25
        this.versionCode = r6;     // Catch: Exception -> L25
        this.versionName = nullToEmpty(r5.versionName);     // Catch: Exception -> L25
        sBrowserApplicationInfo = r2.getApplicationInfo();     // Catch: Exception -> L25
    L25:
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
        if (Build.VERSION.SDK_INT >= 32) goto L5;
    L7:
        return false;
    L5:
        if (isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME) == false) goto L7;
        return true;
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
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApiHelperForP.getLongVersionCode(r2);
    L7:
        return r2.versionCode;
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
    String[] getAllProperties() {
        String r0 = ContextUtils.getApplicationContext().getPackageName();
        String[] r1 = new String[28];
        r1[0] = Build.BRAND;
        r1[1] = Build.DEVICE;
        r1[2] = Build.ID;
        r1[3] = Build.MANUFACTURER;
        r1[4] = Build.MODEL;
        r1[5] = String.valueOf(Build.VERSION.SDK_INT);
        r1[6] = Build.TYPE;
        r1[7] = Build.BOARD;
        r1[8] = r0;
        r1[9] = String.valueOf(this.hostVersionCode);
        r1[10] = this.hostPackageLabel;
        r1[11] = this.packageName;
        r1[12] = String.valueOf(this.versionCode);
        r1[13] = this.versionName;
        r1[14] = this.androidBuildFingerprint;
        r1[15] = this.gmsVersionCode;
        r1[16] = this.installerPackageName;
        r1[17] = this.abiString;
        r1[18] = sFirebaseAppId;
        r1[19] = this.customThemes;
        r1[20] = this.resourcesVersion;
        r1[21] = String.valueOf(ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion);
        boolean r2 = isDebugAndroid();
        String r3 = LocationInfoConst.ALLOW_USE_LOCATION;
        if (r2 == false) goto L5;
        String r4 = LocationInfoConst.ALLOW_USE_LOCATION;
    L6:
        r1[22] = r4;
        if (this.isTV == false) goto L9;
        String r5 = LocationInfoConst.ALLOW_USE_LOCATION;
    L10:
        r1[23] = r5;
        r1[24] = Build.VERSION.INCREMENTAL;
        r1[25] = Build.HARDWARE;
        if (isAtLeastT() == false) goto L13;
        String r6 = LocationInfoConst.ALLOW_USE_LOCATION;
    L14:
        r1[26] = r6;
        if (this.isAutomotive == true) goto L18;
        r3 = BDLocationException.ERROR_TIMEOUT;
    L18:
        r1[27] = r3;
        return r1;
    L13:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L14
    L9:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L10
    L5:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public ApplicationInfo getBrowserApplicationInfo() {
        return sBrowserApplicationInfo;
    }
}
