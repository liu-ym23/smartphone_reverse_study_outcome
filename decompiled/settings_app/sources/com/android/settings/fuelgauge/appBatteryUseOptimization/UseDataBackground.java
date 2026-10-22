package com.android.settings.fuelgauge.appBatteryUseOptimization;

import android.net.NetworkPolicyManager;
import android.os.Bundle;
import android.os.IDeviceIdleController;
import android.os.IPowerAdvisor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemCheck;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UseDataBackground extends BaseFragment implements View.OnClickListener {
    private static final String DEVICE_IDLE_SERVICE = "deviceidle";
    private OListItemCheck mBackgroundNetworkAllow;
    private OListItemCheck mBackgroundNetworkRejectScreenOff;
    private IDeviceIdleController mDeviceIdleService;
    private String mPackageName;
    private int mUid;

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UseDataBackground() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.use_data_background_layout, r3, false);
        OListItemCheck r5 = (OListItemCheck) findViewByIdNullable(R.id.background_network_allow);
        this.mBackgroundNetworkAllow = r5;
        r5.setOnClickListener(this);
        OListItemCheck r6 = (OListItemCheck) findViewByIdNullable(R.id.background_network_reject_screen_off);
        this.mBackgroundNetworkRejectScreenOff = r6;
        r6.setOnClickListener(this);
        this.mDeviceIdleService = IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE));
        Bundle r7 = getArguments();
        this.mPackageName = r7.getString("package_name");
        this.mUid = r7.getInt("application_uid", 0);
        if ("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS".equals(this._mActivity.getIntent().getAction()) == false) goto L6;
        this.mPackageName = this._mActivity.getIntent().getData().getSchemeSpecificPart();
    L6:
        if (TextUtils.isEmpty(this.mPackageName) == false) goto L8;
        OLog.d(this.TAG, "mPackageName is empty");
        finish();
    L8:
        updateView();
        return this.mRootView;
    }

    private void updateView() {
        if (getUseDataBackgroundState() != 0) goto L5;
        this.mBackgroundNetworkAllow.setChecked(true);
        this.mBackgroundNetworkRejectScreenOff.setChecked(false);
        return;
    L5:
        this.mBackgroundNetworkAllow.setChecked(false);
        this.mBackgroundNetworkRejectScreenOff.setChecked(true);
    }

    private int getUseDataBackgroundState() {
        int r0 = NetworkPolicyManager.from(this.mContext).getUidPolicy(this.mUid);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        if (isWhileListApp(this.mPackageName) == true) goto L9;
        return 8;
    L9:
        return r0;
    }

    public void addApp(String r1) {
        IDeviceIdleController r0 = this.mDeviceIdleService;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.addPowerSaveWhitelistApp(r1);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void removeApp(String r1) {
        IDeviceIdleController r0 = this.mDeviceIdleService;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.removePowerSaveWhitelistApp(r1);     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean isWhileListApp(String r2) {
        IDeviceIdleController r1 = this.mDeviceIdleService;
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.isPowerSaveWhitelistApp(r2);
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L9:
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (RiskPermissionControlGuard.intercept(getActivity(), this.mPackageName, UserHandle.getUserId(this.mUid), 3) == false) goto L7;
        updateView();
        return;
    L7:
        if (r5 != this.mBackgroundNetworkAllow) goto L10;
        saveNetworkPolicyStatus(0);
    L12:
        updateView();
        return;
    L10:
        if (r5 != this.mBackgroundNetworkRejectScreenOff) goto L12;
        saveNetworkPolicyStatus(8);
        goto L12
    }

    private void saveNetworkPolicyStatus(int r4) {
        NetworkPolicyManager r0 = NetworkPolicyManager.from(this.mContext);
        if (r4 != 8) goto L5;
        r0.setUidPolicy(this.mUid, 0);
    L6:
        if (r4 != 0) goto L8;
        addApp(this.mPackageName);
    L9:
        IPowerAdvisor r1 = IPowerAdvisor.Stub.asInterface(ServiceManager.getService("poweradvisor"));
        if (r1 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(this.mPackageName) == true) goto L21;
        r1.userSelectedWhitelistApp(this.mPackageName, r4);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        OLog.e(this.TAG, "saveNetworkPolicyStatus e: " + e);
        return;
    L21:
        return;
    L8:
        removeApp(this.mPackageName);
        goto L9
    L5:
        r0.setUidPolicy(this.mUid, r4);
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UseDataBackground r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UseDataBackground r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UseDataBackground r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_appBatteryUseOptimization_UseDataBackground__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
