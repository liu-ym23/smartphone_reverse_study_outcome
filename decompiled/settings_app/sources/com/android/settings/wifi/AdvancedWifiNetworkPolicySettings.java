package com.android.settings.wifi;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes.dex */
public class AdvancedWifiNetworkPolicySettings extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final String DATA_TO_WIFI_CONNECT_TYPE = "data_to_wifi_connect_type";
    private static final int DATA_TO_WIFI_CONNECT_TYPE_ASK = 2;
    private static final int DATA_TO_WIFI_CONNECT_TYPE_AUTO = 0;
    private static final int DATA_TO_WIFI_CONNECT_TYPE_MANUAL = 1;
    private static final String NETWORK_HANDOVER_TIPS_SWITCH = "network_handover_tips_switch";
    private static final String TAG = "AdvancedWifiNetworkPolicySettings";
    private static final String WIFI_AUTO_CONNECT_TYPE = "wifi_auto_connect_type";
    private String[] DATA_TO_WLAN_POLICY_VALUES;
    private SettingItemSwitch mAutoConnectItem;
    private SwitchEx mAutoConnectItemSwitch;
    private AlertDialog mData2WlanChooser;
    private SettingItemSwitch mNetworkHandoverItem;
    private SwitchEx mNetworkHandoverSwitch;
    private WifiManager mWifiManager;
    private int mmData2WlanIndex;
    private boolean supportCMCC;

    public void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public AdvancedWifiNetworkPolicySettings() {
        this.supportCMCC = true;
    }

    static /* synthetic */ int access$000(AdvancedWifiNetworkPolicySettings r0) {
        return r0.mmData2WlanIndex;
    }

    static /* synthetic */ int access$002(AdvancedWifiNetworkPolicySettings r0, int r1) {
        r0.mmData2WlanIndex = r1;
        return r1;
    }

    static /* synthetic */ String[] access$100(AdvancedWifiNetworkPolicySettings r0) {
        return r0.DATA_TO_WLAN_POLICY_VALUES;
    }

    static /* synthetic */ AlertDialog access$200(AdvancedWifiNetworkPolicySettings r0) {
        return r0.mData2WlanChooser;
    }

    public void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        setContentView(R.layout.wifi_network_policy_advanced_settings);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        this.DATA_TO_WLAN_POLICY_VALUES = getResources().getStringArray(R.array.mobile_to_wlan);
        setupBackBtnOnTitle();
    }

    public void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onResume$___twin___() {
        super.onResume();
        initPreferences();
        initCellularWLANItem();
        refreshWifiInfo();
    }

    private void initPreferences() {
        SettingItemSwitch r0 = (SettingItemSwitch) findViewById(R.id.auto_connect);
        this.mAutoConnectItem = r0;
        this.mAutoConnectItemSwitch = r0.getSwitch();
        SettingItemSwitch r1 = (SettingItemSwitch) findViewById(R.id.network_handover_switch);
        this.mNetworkHandoverItem = r1;
        this.mNetworkHandoverSwitch = r1.getSwitch();
        boolean r2 = false;
        if (Settings.Global.getInt(getContentResolver(), WIFI_AUTO_CONNECT_TYPE, 0) != 0) goto L5;
        boolean r3 = true;
    L6:
        this.mAutoConnectItemSwitch.setChecked(r3);
        this.mAutoConnectItemSwitch.setOnCheckedChangeListener(this);
        if (Settings.System.getInt(getContentResolver(), NETWORK_HANDOVER_TIPS_SWITCH, 0) != 1) goto L9;
        r2 = true;
    L9:
        this.mNetworkHandoverSwitch.setChecked(r2);
        this.mNetworkHandoverSwitch.setOnCheckedChangeListener(this);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mAutoConnectItemSwitch) goto L6;
        Settings.Global.putInt(getContentResolver(), WIFI_AUTO_CONNECT_TYPE, !r3 ? 1 : 0);
        return;
    L6:
        if (r2 != this.mNetworkHandoverSwitch) goto L10;
        Settings.System.putInt(getContentResolver(), NETWORK_HANDOVER_TIPS_SWITCH, r3 ? 1 : 0);
        return;
    }

    private void refreshWifiInfo() {
        android.net.wifi.WifiInfo r0 = this.mWifiManager.getConnectionInfo();
        SettingItemText r1 = (SettingItemText) findViewById(R.id.mac_address);
        if (r0 != null) goto L5;
        String r2 = null;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        r2 = getString(R.string.status_unavailable);
    L10:
        r1.setSubTitle(r2);
        return;
    L5:
        r2 = r0.getMacAddress();
        goto L7
    }

    private void initCellularWLANItem() {
        this.mmData2WlanIndex = Settings.System.getInt(getContentResolver(), DATA_TO_WIFI_CONNECT_TYPE, 0);
        SettingItemText r0 = (SettingItemText) findViewById(R.id.mobile_to_wlan_policy);
        r0.setSubTitle(this.DATA_TO_WLAN_POLICY_VALUES[this.mmData2WlanIndex]);
        r0.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View r5) {
        if (r5.getId() != R.id.mobile_to_wlan_policy) goto L6;
        ArrayAdapter r0 = new ArrayAdapter(this, R.layout.wifi_setup_list_item_single_choice, this.DATA_TO_WLAN_POLICY_VALUES);
        AlertDialog r6 = new AlertDialog.Builder(this, 5).setTitle(R.string.mobile_to_wlan_policy).setSingleChoiceItems(r0, this.mmData2WlanIndex, new AnonymousClass1(this, r5)).setNegativeButton(getString(R.string.cancel), null).create();
        this.mData2WlanChooser = r6;
        r6.setCanceledOnTouchOutside(true);
        this.mData2WlanChooser.show();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AdvancedWifiNetworkPolicySettings r1) {
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onCreate(AdvancedWifiNetworkPolicySettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdvancedWifiNetworkPolicySettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(AdvancedWifiNetworkPolicySettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(AdvancedWifiNetworkPolicySettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        AdvancedWifiNetworkPolicySettings r5 = r4;
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
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(AdvancedWifiNetworkPolicySettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(AdvancedWifiNetworkPolicySettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onResume(AdvancedWifiNetworkPolicySettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdvancedWifiNetworkPolicySettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(AdvancedWifiNetworkPolicySettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onPause(AdvancedWifiNetworkPolicySettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdvancedWifiNetworkPolicySettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(AdvancedWifiNetworkPolicySettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        AdvancedWifiNetworkPolicySettings r5 = r3;
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
    public static void com_android_settings_wifi_AdvancedWifiNetworkPolicySettings_com_obric_hook_lancet_PrivacyHook_onStop(AdvancedWifiNetworkPolicySettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AdvancedWifiNetworkPolicySettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_wifi_AdvancedWifiNetworkPolicySettings__onStop$___twin___();
    }
}
