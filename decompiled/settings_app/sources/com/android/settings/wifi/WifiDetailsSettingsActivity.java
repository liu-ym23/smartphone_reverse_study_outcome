package com.android.settings.wifi;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.UserManager;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.settings.FeatureFactory;
import com.android.settings.MainSettings;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.wifitrackerlib.NetworkDetailsTracker;
import com.android.wifitrackerlib.WifiEntry;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class WifiDetailsSettingsActivity extends MainSettings {
    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":settings:show_fragment_args";
    public static final String KEY_CHOSEN_WIFIENTRY_KEY = "key_chosen_wifientry_key";
    private static final long MAX_SCAN_AGE_MILLIS = 15000;
    private static final long SCAN_INTERVAL_MILLIS = 5000;
    static final int SECURITY_EAP = 3;
    static final int SECURITY_PSK = 2;
    static final int SECURITY_SAE = 6;
    static final int SECURITY_WAPI_CERT = 5;
    static final int SECURITY_WAPI_PSK = 4;
    static final int SECURITY_WEP = 1;
    private AccessPointInfo mAccessPoint;
    private NetworkDetailsTracker mNetworkDetailsTracker;
    private WifiManager mWifiManager;
    private HandlerThread mWorkerThread;

    public void com_android_settings_wifi_WifiDetailsSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_wifi_WifiDetailsSettingsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_wifi_WifiDetailsSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_WifiDetailsSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public WifiDetailsSettingsActivity() {
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        if (this.mNetworkDetailsTracker == null) goto L16;
        Intent r0 = getIntent();
        WifiEntry r1 = this.mNetworkDetailsTracker.getWifiEntry();
        updateAccessPointInfo(r1);
        OLog.d(this.TAG, "wifiEntry.getConnectedState():" + r1.getConnectedState());
        if (r1.getConnectedState() == 2) goto L12;
        Bundle r2 = new Bundle();
        r2.putBoolean("edit", false);
        r2.putBoolean("text_is_selectable", false);
        if (this.mAccessPoint == null) goto L9;
        Bundle r3 = new Bundle();
        this.mAccessPoint.saveWifiState(r3);
        r2.putBundle("access_point", r3);
    L9:
        r0.putExtras(r2);
        WifiSetupFragment r5 = new WifiSetupFragment();
        r5.setArguments(r0.getExtras());
        return r5;
    L12:
        if (this.mAccessPoint == null) goto L16;
        Bundle r4 = new Bundle();
        r4.putParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION, this.mAccessPoint.getConfig());
        r4.putSerializable(AccessPointInfo.EXTRA_PSK_TYPE, this.mAccessPoint.pskType);
        r4.putParcelable(AccessPointInfo.EXTRA_WIFI_INFO, this.mAccessPoint.getInfo());
        r4.putSerializable(AccessPointInfo.EXTRA_DETAILED_STATE, this.mAccessPoint.getState());
        r4.putInt("back_text_id", R.string.wifi_settings_title);
        r4.putString("key_chosen_wifientry_key", this.mAccessPoint.key);
        r0.putExtras(r4);
        AccessPointDetailFragment r6 = new AccessPointDetailFragment();
        r6.setArguments(r0.getExtras());
        return r6;
    L16:
        return new WifiSetupFragment();
    }

    private void updateAccessPointInfo(WifiEntry r3) {
        if (r3.getWifiConfiguration() == null) goto L5;
        AccessPointInfo r0 = new AccessPointInfo(r3.getWifiConfiguration());
        this.mAccessPoint = r0;
        r0.key = r3.getKey();
        return;
    L5:
        getScanResult(r3);
    }

    private void getScanResult(WifiEntry r6) {
        List<ScanResult> r2 = null;
        r2 = this.mWifiManager.getScanResults();     // Catch: RuntimeException -> L5
        OLog.d(this.TAG, "wifiManager.getScanResults(), size:" + r2.size());     // Catch: RuntimeException -> L5
        OLog.d(this.TAG, "wifiManager.getWifiState(), wifiState:" + this.mWifiManager.getWifiState());     // Catch: RuntimeException -> L5
    L7:
        if (r2 != null) goto L9;
    L23:
        ScanResult r0 = new ScanResult();
        r0.SSID = AccessPointInfo.removeDoubleQuotes(r6.getSsid());
        r0.capabilities = getScanResultSecurity(r6);
        r0.level = r6.getLevel();
        AccessPointInfo r1 = new AccessPointInfo(r0);
        this.mAccessPoint = r1;
        r1.key = r6.getKey();
        return;
    L9:
        if (r2.isEmpty() == true) goto L23;
        Iterator<ScanResult> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L38;
        ScanResult r4 = r3.next();
        if (r4.SSID == null) goto L12;
        if (r4.SSID.length() == 0) goto L12;
        if (r4.capabilities.contains("[IBSS]") == true) goto L12;
        if (r4.SSID.equals(AccessPointInfo.removeDoubleQuotes(r6.getSsid())) == false) goto L12;
        AccessPointInfo r5 = new AccessPointInfo(r4);
        this.mAccessPoint = r5;
        r5.key = r6.getKey();
        return;
    L38:
        return;
    L5:
        e = move-exception;
        OLog.e(this.TAG, "wifiManager.getScanResults(), e:" + e);
        goto L7
    }

    private String getScanResultSecurity(WifiEntry r1) {
        int r0 = r1.getSecurity();
        if (r0 != 1) goto L7;
        return "WEP";
    L7:
        if (r0 != 2) goto L11;
        return "PSK";
    L11:
        if (r0 != 3) goto L15;
        return "EAP";
    L15:
        if (r0 != 6) goto L18;
        return "SAE";
    L18:
        return "";
    }

    public void com_android_settings_wifi_WifiDetailsSettingsActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        if (isConfigWifiAllowed() == true) goto L5;
    L9:
        finish();
        return;
    L5:
        if (isAddWifiConfigAllowed() == false) goto L9;
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        setupNetworksDetailTracker();
    }

    boolean isConfigWifiAllowed() {
        UserManager r0 = (UserManager) getSystemService(UserManager.class);
        if (r0 != null) goto L5;
        return true;
    L5:
        boolean r1 = !r0.hasUserRestriction("no_config_wifi");
        if (r1 == true) goto L8;
        OLog.e(this.TAG, "The user is not allowed to configure Wi-Fi.");
    L8:
        return r1;
    }

    boolean isAddWifiConfigAllowed() {
        UserManager r0 = (UserManager) getSystemService(UserManager.class);
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.hasUserRestriction("no_add_wifi_config") == false) goto L10;
        OLog.e(this.TAG, "The user is not allowed to add Wi-Fi configuration.");
        return false;
    L10:
        return true;
    }

    private void setupNetworksDetailTracker() {
        if (this.mNetworkDetailsTracker == null) goto L5;
        return;
    L5:
        Intent r0 = getIntent();
        if (r0 != null) goto L8;
    L13:
        String r1 = "";
    L14:
        String r11 = r1;
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.isEmpty() == true) goto L22;
        HandlerThread r2 = new HandlerThread(this.TAG + VectorFormat.DEFAULT_PREFIX + Integer.toHexString(System.identityHashCode(this)) + VectorFormat.DEFAULT_SUFFIX, 10);
        this.mWorkerThread = r2;
        r2.start();
        final ZoneOffset r3 = ZoneOffset.UTC;
        this.mNetworkDetailsTracker = FeatureFactory.getFactory(this).getWifiTrackerLibProvider().createNetworkDetailsTracker(getLifecycle(), this, new Handler(Looper.getMainLooper()), this.mWorkerThread.getThreadHandler(), new AnonymousClass1(this, r3), 15000, 5000, r11);
        return;
    L22:
        return;
    L8:
        if (r0.getExtras() == null) goto L13;
        Bundle r4 = GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r0, ":settings:show_fragment_args");
        if (r4 == null) goto L12;
        r1 = r4.getString("key_chosen_wifientry_key");
        goto L14
    L12:
        r1 = r0.getStringExtra("key_chosen_wifientry_key");
        goto L14
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WifiDetailsSettingsActivity r1) {
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(WifiDetailsSettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiDetailsSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_WifiDetailsSettingsActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(WifiDetailsSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(WifiDetailsSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        WifiDetailsSettingsActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(WifiDetailsSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_WifiDetailsSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(WifiDetailsSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(WifiDetailsSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiDetailsSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_WifiDetailsSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(WifiDetailsSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(WifiDetailsSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiDetailsSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_WifiDetailsSettingsActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(WifiDetailsSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        WifiDetailsSettingsActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_wifi_WifiDetailsSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(WifiDetailsSettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiDetailsSettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_WifiDetailsSettingsActivity__onStop$___twin___();
    }
}
