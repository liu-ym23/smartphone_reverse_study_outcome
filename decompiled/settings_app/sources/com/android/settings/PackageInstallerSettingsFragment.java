package com.android.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class PackageInstallerSettingsFragment extends BaseFragment implements View.OnClickListener, DialogInterface.OnClickListener {
    private SettingItemCheck mSourceBytedance;
    private SettingItemCheck mSourceGooglePlay;
    private SettingItemCheck mSourceUnknown;
    private AlertDialog mWarnInstallApps;

    public void com_android_settings_PackageInstallerSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_PackageInstallerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_PackageInstallerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PackageInstallerSettingsFragment() {
    }

    static /* synthetic */ void access$000(PackageInstallerSettingsFragment r0, boolean r1) {
        r0.updateUnknownSourceState(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.package_installer_settings_layout, r4, false);
        this.mSourceBytedance = (SettingItemCheck) findViewByIdNullable(R.id.source_bytedance);
        if (isBytedanceAppstoreAvailable() == false) goto L5;
        this.mSourceBytedance.setChecked(true);
        this.mSourceBytedance.setCheckedIconLight(true);
        Utils.isEnglishLocale();
        int r6 = 1;
    L7:
        if (Utils.isPackageInstalled(this.mContext, "com.android.vending") == false) goto L12;
        SettingItemCheck r7 = (SettingItemCheck) findViewByIdNullable(R.id.source_google_play);
        this.mSourceGooglePlay = r7;
        r7.setChecked(true);
        this.mSourceGooglePlay.setCheckedIconLight(true);
        this.mSourceGooglePlay.setVisibility(0);
        if (r6 != 0) goto L11;
        this.mSourceGooglePlay.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_top);
    L11:
        r6 = r6 + 1;
    L12:
        SettingItemCheck r8 = (SettingItemCheck) findViewByIdNullable(R.id.source_unknown);
        this.mSourceUnknown = r8;
        r8.setOnClickListener(this);
        if (r6 != 0) goto L16;
        this.mSourceUnknown.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
    L16:
        return this.mRootView;
    L5:
        this.mSourceBytedance.setVisibility(8);
        r6 = 0;
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        AlertDialog r3 = this.mWarnInstallApps;
        if (r3 != null) goto L5;
    L6:
        updateUnknownSourceState(isInstallingUnknownAppsAllowed());
        return;
    L5:
        if (r3.isShowing() == false) goto L6;
    }

    private boolean isBytedanceAppstoreAvailable() {
        if (Utils.isPackageInstalled(this.mContext, Utils.APP_STORE_PACKAGE) == true) goto L5;
    L9:
        return false;
    L5:
        if (SettingsFeature.isFeatureDomestic(this.mContext) == false) goto L9;
        if (Utils.isCmccVersion(this.mContext) == true) goto L9;
        return true;
    }

    public void com_android_settings_PackageInstallerSettingsFragment__onResume$___twin___() {
        super.onResume();
        AlertDialog r0 = this.mWarnInstallApps;
        if (r0 != null) goto L5;
    L6:
        updateUnknownSourceState(isInstallingUnknownAppsAllowed());
        return;
    L5:
        if (r0.isShowing() == false) goto L6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlertDialog r0 = this.mWarnInstallApps;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private boolean isInstallingUnknownAppsAllowed() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "install_non_market_apps", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setNonMarketAppsAllowed(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "install_non_market_apps", r2 ? 1 : 0);
    }

    private void updateUnknownSourceState(boolean r1) {
        this.mSourceUnknown.setChecked(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 == this.mSourceUnknown) goto L5;
        return;
    L5:
        if (isInstallingUnknownAppsAllowed() == true) goto L7;
        updateUnknownSourceState(true);
        warnAppInstallation();
        return;
    L7:
        updateUnknownSourceState(false);
        setNonMarketAppsAllowed(false);
    }

    private void warnAppInstallation() {
        if (this.mWarnInstallApps != null) goto L5;
        this.mWarnInstallApps = new AlertDialog.Builder(this._mActivity, getResources().getInteger(R.integer.dialog_style_id)).setTitle(getResources().getString(R.string.enter_save_power_alert_title)).setIcon(android.R.drawable.ic_dialog_alert).setMessage(getResources().getString(R.string.install_all_warning)).setPositiveButton(android.R.string.yes, this).setNegativeButton(android.R.string.no, this).setOnCancelListener(new AnonymousClass1(this)).create();
    L5:
        this.mWarnInstallApps.dismiss();
        this.mWarnInstallApps.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (r2 != (-1)) goto L6;
        setNonMarketAppsAllowed(true);
        return;
    L6:
        if (r2 != (-2)) goto L10;
        updateUnknownSourceState(false);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_PackageInstallerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PackageInstallerSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PackageInstallerSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PackageInstallerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PackageInstallerSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_PackageInstallerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PackageInstallerSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PackageInstallerSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PackageInstallerSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
