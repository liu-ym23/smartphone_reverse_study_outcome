package com.android.settings.fingerprint.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.SensorProperties;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorProperties;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.provider.Settings;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settingslib.drawer.EntriesProvider;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.matrix.platform.sdk.ones.account.log.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FingerprintUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0007J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u001a\u0010 \u001a\u00020!2\b\u0010\u0016\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u001bH\u0007J(\u0010$\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001bH\u0007J\u0018\u0010'\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u001bH\u0007J\u0018\u0010)\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u001bH\u0007J\u0018\u0010+\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/android/settings/fingerprint/utils/FingerprintUtils;", "", "()V", "KEY_AI_BUTTON_UNLOCK_ENABLED_WHEN_SCREEN_TURNED_OFF", "", "KEY_OBRIC_UDFPS_ICON_VISIBILITY_POLICY", "KEY_UDFPS_UNLOCK_SCREEN_ENABLE", "KEY_UDFPS_UNLOCK_SCREEN_TYPE", "POLICY_FOLLOW_AOD", "", "POLICY_OFF", "POLICY_TAP_LIFT", "TAG", "UDFPS_UNLOCK_SCREEN_TYPE_ENTER_HOME_SCREEN", "UDFPS_UNLOCK_SCREEN_TYPE_REMAIN_ON_LOCK_SCREEN", "getFingerprintList", "", "Landroid/hardware/fingerprint/Fingerprint;", "fm", "Landroid/hardware/fingerprint/FingerprintManager;", "sensorType", "getUdfpsPolicy", "context", "Landroid/content/Context;", "getUdfpsPolicySummary", "getUdfpsUnlockScreenType", "hasAIFps", "", "hasUdfps", "isAIPoweredFpsEnabledWhenScreenOff", "isNetworkAvailable", "isUdfpsUnlockScreenEnabled", "loadFaceLicenseWebview", "", "Landroid/app/Activity;", "needFinishOnBackground", "loadUrlWithLicenseWebViewActivity", "url", "title", "updateAIPoweredFpsEnabledWhenScreenOff", "isEnabled", "updateUdfpsUnlockScreenEnabled", EntriesProvider.METHOD_IS_CHECKED, "updateUdfpsUnlockScreenType", "type", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FingerprintUtils {
    public static final FingerprintUtils INSTANCE = null;
    public static final String KEY_AI_BUTTON_UNLOCK_ENABLED_WHEN_SCREEN_TURNED_OFF = "ai_button_unlock_enabled_when_screen_turned_off";
    public static final String KEY_OBRIC_UDFPS_ICON_VISIBILITY_POLICY = "obric_udfps_icon_visibility_policy";
    public static final String KEY_UDFPS_UNLOCK_SCREEN_ENABLE = "udfps_unlock_screen_enable";
    public static final String KEY_UDFPS_UNLOCK_SCREEN_TYPE = "udfps_unlock_screen_type";
    public static final int POLICY_FOLLOW_AOD = 2;
    public static final int POLICY_OFF = 0;
    public static final int POLICY_TAP_LIFT = 1;
    private static final String TAG = "FingerprintUtils";
    public static final int UDFPS_UNLOCK_SCREEN_TYPE_ENTER_HOME_SCREEN = 0;
    public static final int UDFPS_UNLOCK_SCREEN_TYPE_REMAIN_ON_LOCK_SCREEN = 1;

    public static /* synthetic */ void $r8$lambda$QPRWoY9hrjVly0AWescHc4POU4Y(Activity r0) {
        loadUrlWithLicenseWebViewActivity$lambda$2(r0);
    }

    static {
        INSTANCE = new FingerprintUtils();
    }

    private FingerprintUtils() {
    }

    @JvmStatic
    public static final int getUdfpsPolicy(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return Settings.Secure.getInt(r2.getContentResolver(), KEY_OBRIC_UDFPS_ICON_VISIBILITY_POLICY, 1);
    }

    @JvmStatic
    public static final String getUdfpsPolicySummary(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = getUdfpsPolicy(r4);
        if (r0 != 0) goto L5;
        String r5 = r4.getString(R.string.obric_udfps_display_policy_off);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        return r5;
    L5:
        if (r0 != 1) goto L7;
        String r6 = r4.getString(R.string.obric_udfps_display_policy_tap_lift);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        return r6;
    L7:
        if (r0 == 2) goto L9;
        String r7 = r4.getString(R.string.obric_udfps_display_policy_tap_lift);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        return r7;
    L9:
        String r8 = r4.getString(R.string.obric_udfps_display_policy_follow_aod);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        return r8;
    }

    @JvmStatic
    public static final List<Fingerprint> getFingerprintList(FingerprintManager r8, int r9) {
        if (r8 != null) goto L33;
        return null;
    L33:
        List<Fingerprint> r1 = r8.getEnrolledFingerprints();     // Catch: Exception -> L30
        if (r9 != 0) goto L8;
        return r1;
    L8:
        List r10 = r8.getSensorProperties();     // Catch: Exception -> L30
        Intrinsics.checkNotNullExpressionValue(r10, "getSensorProperties(...)");     // Catch: Exception -> L30
        Iterator r11 = r10.iterator();     // Catch: Exception -> L30
        int r3 = -1;
    L10:
        if (r11.hasNext() == false) goto L16;
        FingerprintSensorProperties r4 = (SensorProperties) r11.next();     // Catch: Exception -> L30
        if ((r4 instanceof FingerprintSensorProperties) == false) goto L10;
        if (r4.getSensorType() != r9) goto L10;
        r3 = r4.getSensorId();     // Catch: Exception -> L30
        goto L10
    L16:
        if (r3 == (-1)) goto L32;
        if (r1 == null) goto L47;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L30
        Iterator<T> r13 = r1.iterator();     // Catch: Exception -> L30
    L20:
        if (r13.hasNext() == false) goto L27;
        Object r2 = r13.next();     // Catch: Exception -> L30
        if (((Fingerprint) r2).getDeviceId() != r3) goto L24;
        boolean r5 = true;
    L25:
        if (r5 == false) goto L20;
        r12.add(r2);     // Catch: Exception -> L30
        goto L20
    L24:
        r5 = false;
        goto L25
    L27:
        return r12;
    L47:
        return null;
    L32:
        return null;
    L30:
        e = move-exception;
        OLog.INSTANCE.e(TAG, "getFingerprintList", e);
        goto L32
    }

    @JvmStatic
    public static final boolean hasUdfps(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r3 = r2.getSystemService("fingerprint");
        if ((r3 instanceof FingerprintManager) == false) goto L5;
        FingerprintManager r4 = (FingerprintManager) r3;
    L6:
        List<Fingerprint> r5 = getFingerprintList(r4, 2);
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((!r5.isEmpty()) == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r4 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean hasAIFps(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r3 = r2.getSystemService("fingerprint");
        if ((r3 instanceof FingerprintManager) == false) goto L5;
        FingerprintManager r4 = (FingerprintManager) r3;
    L6:
        List<Fingerprint> r5 = getFingerprintList(r4, 4);
        if (r5 != null) goto L9;
        return false;
    L9:
        if ((!r5.isEmpty()) == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r4 = null;
        goto L6
    }

    @JvmStatic
    public static final boolean isAIPoweredFpsEnabledWhenScreenOff(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.System.getInt(r2.getContentResolver(), KEY_AI_BUTTON_UNLOCK_ENABLED_WHEN_SCREEN_TURNED_OFF, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @JvmStatic
    public static final void updateAIPoweredFpsEnabledWhenScreenOff(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.System.putInt(r1.getContentResolver(), KEY_AI_BUTTON_UNLOCK_ENABLED_WHEN_SCREEN_TURNED_OFF, r2 ? 1 : 0);
    }

    @JvmStatic
    public static final boolean isUdfpsUnlockScreenEnabled(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.Global.getInt(r2.getContentResolver(), KEY_UDFPS_UNLOCK_SCREEN_ENABLE, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final void updateUdfpsUnlockScreenEnabled(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), KEY_UDFPS_UNLOCK_SCREEN_ENABLE, r2 ? 1 : 0);
    }

    @JvmStatic
    public static final int getUdfpsUnlockScreenType(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return Settings.Global.getInt(r2.getContentResolver(), KEY_UDFPS_UNLOCK_SCREEN_TYPE, 0);
    }

    @JvmStatic
    public static final void updateUdfpsUnlockScreenType(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.Global.putInt(r1.getContentResolver(), KEY_UDFPS_UNLOCK_SCREEN_TYPE, r2);
    }

    @JvmStatic
    public static final void loadUrlWithLicenseWebViewActivity(final Activity r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intent r0 = new Intent();     // Catch: Exception -> L5
        r0.setComponent(new ComponentName("com.android.provision", "com.android.provision.webview.CustomWebViewActivity"));     // Catch: Exception -> L5
        r0.putExtra("extra_url", r5);     // Catch: Exception -> L5
        r0.putExtra("extra_title", r6);     // Catch: Exception -> L5
        r0.putExtra("extra_need_finish_on_background", r7);     // Catch: Exception -> L5
        r4.startActivity(r0);     // Catch: Exception -> L5
        ThreadUtils.postOnMainThread(new FingerprintUtils$$ExternalSyntheticLambda0(r4), 1000L);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "loadUrlWithExplorer, error_msg: " + e);
    }

    private static final void loadUrlWithLicenseWebViewActivity$lambda$2(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "$context");
        if (INSTANCE.isNetworkAvailable(r2) == true) goto L6;
        ToastUtils.show(r2.getApplicationContext(), R.string.network_unavailable_tips_for_webview);
        return;
    }

    @JvmStatic
    public static final void loadFaceLicenseWebview(Activity r2, boolean r3) {
        if (r2 != null) goto L11;
        OLog.e(TAG, "loadFaceLicenseWebview, context is null, return");
        return;
    L11:
        r2.startActivity(new Intent("com.zte.faceverify.PRIVACY"));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        OLog.e(TAG, "loadFaceLicenseWebview, error_msg: " + e);
    }

    public final boolean isNetworkAvailable(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r3 = NetworkUtils.isNetworkAvailable(r4);
        Object r5 = r4.getSystemService("connectivity");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r6 = (ConnectivityManager) r5;
        Network r0 = r6.getActiveNetwork();
        if (r0 == null) goto L11;
        NetworkCapabilities r7 = r6.getNetworkCapabilities(r0);
        if (r7 == null) goto L11;
        if (r7.hasCapability(12) == false) goto L11;
        if (r7.hasCapability(16) == false) goto L11;
        boolean r8 = true;
    L12:
        if (r3 == false) goto L16;
        if (r8 == false) goto L16;
        return true;
    L16:
        return false;
    L11:
        r8 = false;
        goto L12
    }
}
