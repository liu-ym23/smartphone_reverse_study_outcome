package com.android.settings.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentKt;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class AdvancedAccessPointSettingsFragment extends BaseFragment implements View.OnClickListener {
    public static final String KEY_ADVANCED_ACCESS_POINT_SETTINGS_FRAGMENT_RESULT = "advanced_access_point_settings_fragment_result";
    private boolean launchBywifiSetup;
    private AccessPoint mAccessPoint;
    private WifiConfigControllerEx mController;
    private IntentFilter mIntentFilter;
    private boolean mIsBackPressed;
    private BroadcastReceiver mReceiver;
    private WifiManager.ActionListener mSaveListener;
    private WifiManager mWifiManager;

    public static /* synthetic */ void $r8$lambda$rbGTfacAFAcHUlMZ1vs8Xe77H74(View r0) {
        r0.requestApplyInsets();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_AdvancedAccessPointSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_AdvancedAccessPointSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AdvancedAccessPointSettingsFragment() {
        this.mIsBackPressed = false;
        this.mIntentFilter = new IntentFilter();
        this.mReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(AdvancedAccessPointSettingsFragment r0, Context r1, Intent r2) {
        r0.handleEvent(r1, r2);
    }

    static /* synthetic */ WifiConfigControllerEx access$100(AdvancedAccessPointSettingsFragment r0) {
        return r0.mController;
    }

    public void com_android_settings_wifi_AdvancedAccessPointSettingsFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mWifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        Bundle r5 = getArguments();
        Parcelable r0 = r5.getParcelable(AccessPointInfo.EXTRA_WIFI_CONFIGURATION);
        this.launchBywifiSetup = r5.getBoolean("launch_by_wifiSetup", false);
        if (r0 == null) goto L11;
        if ((r0 instanceof WifiConfiguration) == false) goto L11;
        this.mAccessPoint = new AccessPoint(getActivity(), (WifiConfiguration) r0);
        android.net.wifi.WifiInfo r1 = (android.net.wifi.WifiInfo) r5.getParcelable(AccessPointInfo.EXTRA_WIFI_INFO);
        NetworkInfo.DetailedState r6 = (NetworkInfo.DetailedState) r5.getSerializable(AccessPointInfo.EXTRA_DETAILED_STATE);
        if (r1 == null) goto L11;
        if (r6 == null) goto L11;
        this.mAccessPoint.update(r1, r6, -1);
    L11:
        if (this.mAccessPoint != null) goto L14;
        finish();
        return;
    L14:
        this.mSaveListener = new AnonymousClass2(this);
        this.mIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        this.mIntentFilter.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.advanced_access_point_settings_fragment, r3, false);
        AccessPoint r5 = this.mAccessPoint;
        if (r5 != null) goto L5;
    L12:
        finish();
        return this.mRootView;
    L5:
        if (r5.getConfig() == null) goto L12;
        final View r6 = this.mRootView.findViewById(R.id.view_title);
        if (r6 == null) goto L10;
        r6.setFitsSystemWindows(true);
        Objects.requireNonNull(r6);
        r6.post(new AdvancedAccessPointSettingsFragment$$ExternalSyntheticLambda0(r6));
    L10:
        WifiConfigControllerEx r7 = new WifiConfigControllerEx(this, this.mRootView, this.mAccessPoint);
        this.mController = r7;
        r7.setSaveButtonListener(this);
        this.mController.setDismissListener(new AdvancedAccessPointSettingsFragment$$ExternalSyntheticLambda1(this));
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-wifi-AdvancedAccessPointSettingsFragment, reason: not valid java name */
    /* synthetic */ void m664xeb9ec7ca(boolean r1) {
        if (r1 == false) goto L5;
        this.mIsBackPressed = true;
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        View r3 = this.mBackView;
        if (r3 == null) goto L6;
        r3.setOnClickListener(this);
        r3.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    void submit() {
        WifiConfiguration r0 = this.mController.getConfig();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.networkId == (-1)) goto L11;
        if (this.mAccessPoint == null) goto L16;
        this.mWifiManager.save(r0, this.mSaveListener);
        return;
    L16:
        return;
    L11:
        if (this.launchBywifiSetup == true) goto L13;
        return;
    L13:
        if (getActivity() == null) goto L19;
        Bundle r1 = new Bundle();
        r1.putParcelable("extra_ap_configuration", r0);
        r1.putInt("result_code", RESULT_OK);
        FragmentKt.setFragmentResult(this, KEY_ADVANCED_ACCESS_POINT_SETTINGS_FRAGMENT_RESULT, r1);
        finish();
        return;
    }

    public void com_android_settings_wifi_AdvancedAccessPointSettingsFragment__onResume$___twin___() {
        super.onResume();
        registerReceiver(this.mReceiver, this.mIntentFilter);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mReceiver);
    }

    private void handleEvent(Context r3, Intent r4) {
        String r0 = r4.getAction();
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(r0) == false) goto L8;
        if (r4.hasExtra("supplicantError") == false) goto L18;
        ToastUtils.show(r3, R.string.wifi_maybe_password_error);
        return;
    L18:
        return;
    L8:
        if ("android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(r0) == false) goto L20;
        WifiConfiguration r5 = (WifiConfiguration) r4.getParcelableExtra("wifiConfiguration");
        if (r4.getIntExtra("changeReason", -1) != 1) goto L21;
        if (r5 != null) goto L13;
        return;
    L13:
        if (this.mAccessPoint != null) goto L15;
        return;
    L15:
        if (r5.networkId != this.mAccessPoint.networkId) goto L24;
        finish();
        return;
    L24:
        return;
    L21:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        submit();
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L9;
        WifiConfigControllerEx r0 = this.mController;
        if (r0 == null) goto L9;
        r0.onKeyDown();
        return true;
    L9:
        return super.onKeyDown(r2, r3);
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        if (this.mIsBackPressed == true) goto L5;
        WifiConfigControllerEx r1 = this.mController;
        if (r1 == null) goto L11;
        r1.savePoxyAndIpConfiguration();
        return true;
    L11:
        return true;
    L5:
        return super.onBackPressedSupport();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_AdvancedAccessPointSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AdvancedAccessPointSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_AdvancedAccessPointSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AdvancedAccessPointSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AdvancedAccessPointSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_AdvancedAccessPointSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_AdvancedAccessPointSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AdvancedAccessPointSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_AdvancedAccessPointSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
