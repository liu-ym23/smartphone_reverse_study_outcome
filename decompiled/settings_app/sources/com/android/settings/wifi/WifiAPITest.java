package com.android.settings.wifi;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes.dex */
public class WifiAPITest extends BaseActivity implements View.OnClickListener {
    private static final String KEY_DISABLE_NETWORK = "disable_network";
    private static final String KEY_DISCONNECT = "disconnect";
    private static final String KEY_ENABLE_NETWORK = "enable_network";
    private static final String TAG = "WifiAPITest";
    private SettingItemText mWifiDisableNetwork;
    private SettingItemText mWifiDisconnect;
    private SettingItemText mWifiEnableNetwork;
    private WifiManager mWifiManager;
    private int netid;

    public void com_android_settings_wifi_WifiAPITest__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_wifi_WifiAPITest__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_wifi_WifiAPITest__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_WifiAPITest__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public WifiAPITest() {
    }

    static /* synthetic */ int access$000(WifiAPITest r0) {
        return r0.netid;
    }

    static /* synthetic */ int access$002(WifiAPITest r0, int r1) {
        r0.netid = r1;
        return r1;
    }

    static /* synthetic */ WifiManager access$100(WifiAPITest r0) {
        return r0.mWifiManager;
    }

    public void com_android_settings_wifi_WifiAPITest__onCreate$___twin___(Bundle r4) {
        requestWindowFeature(1);
        super.onCreate(r4);
        setContentView(R.layout.wifi_api_test_activity);
        this.mBackView = ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new AnonymousClass1(this));
        SettingItemText r5 = (SettingItemText) findViewById(R.id.disconnect);
        this.mWifiDisconnect = r5;
        r5.setOnClickListener(this);
        SettingItemText r6 = (SettingItemText) findViewById(R.id.disable_network);
        this.mWifiDisableNetwork = r6;
        r6.setOnClickListener(this);
        SettingItemText r7 = (SettingItemText) findViewById(R.id.enable_network);
        this.mWifiEnableNetwork = r7;
        r7.setOnClickListener(this);
        findViewById(R.id.getConfiguredNetworks).setEnabled(false);
        findViewById(R.id.getConnectionInfo).setEnabled(false);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        if (r7 != this.mWifiDisconnect) goto L6;
        this.mWifiManager.disconnect();
        return;
    L6:
        if (r7 != this.mWifiDisableNetwork) goto L9;
        AlertDialog.Builder r8 = new AlertDialog.Builder(this, getResources().getInteger(R.integer.dialog_style_id));
        r8.setTitle("Input");
        r8.setMessage("Enter Network ID");
        final EditText r0 = new EditText(this);
        r8.setView(r0);
        r8.setPositiveButton("Ok", new AnonymousClass2(this, r0));
        r8.setNegativeButton("Cancel", new AnonymousClass3(this));
        r8.show();
        return;
    L9:
        if (r7 != this.mWifiEnableNetwork) goto L14;
        AlertDialog.Builder r9 = new AlertDialog.Builder(this, getResources().getInteger(R.integer.dialog_style_id));
        r9.setTitle("Input");
        r9.setMessage("Enter Network ID");
        final EditText r1 = new EditText(this);
        r9.setView(r1);
        r9.setPositiveButton("Ok", new AnonymousClass4(this, r1));
        r9.setNegativeButton("Cancel", new AnonymousClass5(this));
        r9.show();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiAPITest_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(WifiAPITest r1) {
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onCreate(WifiAPITest r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiAPITest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_WifiAPITest__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_BatchedActivityLancet_onResume(WifiAPITest r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(WifiAPITest r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        WifiAPITest r5 = r4;
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
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(WifiAPITest r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_WifiAPITest__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_BatchedActivityLancet_onStop(WifiAPITest r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_WifiAPITest_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onResume(WifiAPITest r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiAPITest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_WifiAPITest__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(WifiAPITest r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onPause(WifiAPITest r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiAPITest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_WifiAPITest__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(WifiAPITest r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        WifiAPITest r5 = r3;
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
    public static void com_android_settings_wifi_WifiAPITest_com_obric_hook_lancet_PrivacyHook_onStop(WifiAPITest r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        WifiAPITest r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_WifiAPITest__onStop$___twin___();
    }
}
