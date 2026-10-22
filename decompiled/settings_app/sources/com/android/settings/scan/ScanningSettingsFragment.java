package com.android.settings.scan;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ScanningSettingsFragment extends BaseFragment {
    private static final String TAG = "ScanningSettingsFragment";
    private OSwitch mBluetoothScanSwitch;
    private WifiManager mWifiManager;
    private OSwitch mWifiScanSwitch;

    public void com_android_settings_scan_ScanningSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_scan_ScanningSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_scan_ScanningSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_scan_ScanningSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ScanningSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.scanning_settings_fragment_layout, r5, false);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService(WifiManager.class);
        LinearLayout r7 = (LinearLayout) findViewByIdNullable(R.id.wifi_scan_switch_container);
        LinearLayout r8 = (LinearLayout) findViewByIdNullable(R.id.bluetooth_scan_switch_container);
        OSwitch r9 = new OSwitch(this.mContext);
        this.mWifiScanSwitch = r9;
        r9.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mWifiScanSwitch.setId(android.R.id.switch_widget);
        r7.addView(this.mWifiScanSwitch);
        this.mWifiScanSwitch.setVisibility(8);
        r7.setOnClickListener(new ScanningSettingsFragment$$ExternalSyntheticLambda0(this));
        OSwitch r10 = new OSwitch(this.mContext);
        this.mBluetoothScanSwitch = r10;
        r10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.mBluetoothScanSwitch.setId(android.R.id.switch_widget);
        r8.addView(this.mBluetoothScanSwitch);
        this.mBluetoothScanSwitch.setVisibility(8);
        r8.setOnClickListener(new ScanningSettingsFragment$$ExternalSyntheticLambda1(this));
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-scan-ScanningSettingsFragment, reason: not valid java name */
    /* synthetic */ void m580xd72cbb0f(View r2) {
        if (this.mWifiScanSwitch.getVisibility() != 8) goto L5;
        this.mWifiScanSwitch.setVisibility(0);
        return;
    L5:
        OSwitch r3 = this.mWifiScanSwitch;
        r3.setChecked(!r3.isChecked());
        this.mWifiManager.setScanAlwaysAvailable(this.mWifiScanSwitch.isChecked());
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-scan-ScanningSettingsFragment, reason: not valid java name */
    /* synthetic */ void m581x505556e(View r2) {
        if (this.mBluetoothScanSwitch.getVisibility() != 8) goto L5;
        this.mBluetoothScanSwitch.setVisibility(0);
        return;
    L5:
        OSwitch r3 = this.mBluetoothScanSwitch;
        r3.setChecked(!r3.isChecked());
        setBluetoothScanAlwaysAvailable(this.mBluetoothScanSwitch.isChecked());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        this.mWifiScanSwitch.setChecked(this.mWifiManager.isScanAlwaysAvailable());
        this.mBluetoothScanSwitch.setChecked(isBluetoothScanAlwaysAvailable());
    }

    private boolean isBluetoothScanAlwaysAvailable() {
        if (Settings.Global.getInt(getContentResolver(), "ble_scan_always_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setBluetoothScanAlwaysAvailable(boolean r2) {
        Settings.Global.putInt(getContentResolver(), "ble_scan_always_enabled", r2 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_scan_ScanningSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScanningSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_scan_ScanningSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_scan_ScanningSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScanningSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_scan_ScanningSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_scan_ScanningSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScanningSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_scan_ScanningSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
