package com.android.settings.specialaccess.appinfo;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.android.settings.R;
import com.android.settings.applications.AppInfoWithHeader;
import com.android.settings.applications.AppStateAppOpsBridge;
import com.android.settings.applications.AppStateManageExternalStorageBridge;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.applications.ApplicationsState;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManageExternalStorageDetails extends AppInfoWithHeader implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    private static final String KEY_APP_OPS_SETTINGS_SWITCH = "app_ops_settings_switch";
    private AppOpsManager mAppOpsManager;
    private AppStateManageExternalStorageBridge mBridge;
    private OListItemSwitch mCheckSwitch;
    private AppStateAppOpsBridge.PermissionState mPermissionState;
    private TwoStatePreference mSwitchPref;

    private void logSpecialPermissionChange(boolean r1, String r2) {
    }

    public void com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment
    public int getMetricsCategory() {
        return 1822;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r1) {
        return false;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ManageExternalStorageDetails() {
    }

    static /* synthetic */ AppStateAppOpsBridge.PermissionState access$000(ManageExternalStorageDetails r0) {
        return r0.mPermissionState;
    }

    static /* synthetic */ void access$100(ManageExternalStorageDetails r0, boolean r1) {
        r0.setManageExternalStorageState(r1);
    }

    public void com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        this.mBridge = new AppStateManageExternalStorageBridge(r5, this.mState, null);
        this.mAppOpsManager = (AppOpsManager) r5.getSystemService("appops");
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        if (this.mPackageInfo != null) goto L7;
        return r1.inflate(R.layout.manage_applications_apps_unsupported, null);
    L7:
        return r1.inflate(R.layout.special_access_manage_external_storage_permission_details, null);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mPermissionState = this.mBridge.getManageExternalStoragePermState(this.mPackageName, this.mPackageInfo.applicationInfo.uid);
        OListItemSwitch r5 = (OListItemSwitch) r3.findViewById(R.id.item_switch);
        this.mCheckSwitch = r5;
        r5.setTitleString(getString(R.string.permit_manage_external_storage));
        this.mCheckSwitch.setChecked(this.mPermissionState.isPermissible());
        this.mCheckSwitch.setEnabled(this.mPermissionState.permissionDeclared);
        this.mCheckSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
        refreshUi();
    }

    @Override // com.android.settings.applications.AppInfoBase, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mBridge.release();
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        if (r2 != this.mSwitchPref) goto L11;
        AppStateAppOpsBridge.PermissionState r4 = this.mPermissionState;
        if (r4 != null) goto L7;
        return true;
    L7:
        if (r3.equals(Boolean.valueOf(r4.isPermissible())) == true) goto L14;
        setManageExternalStorageState(((Boolean) r3).booleanValue());
        refreshUi();
        return true;
    L14:
        return true;
    L11:
        return false;
    }

    private void setManageExternalStorageState(boolean r3) {
        logSpecialPermissionChange(r3, this.mPackageName);
        AppOpsManager r0 = this.mAppOpsManager;
        int r2 = this.mPackageInfo.applicationInfo.uid;
        if (r3 == false) goto L5;
        int r4 = 0;
    L6:
        r0.setUidMode(92, r2, r4);
        return;
    L5:
        r4 = 2;
        goto L6
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        PackageInfo r0 = this.mPackageInfo;
        return true;
    }

    public static CharSequence getSummary(Context r2, ApplicationsState.AppEntry r3) {
        if ((r3.extraInfo instanceof AppStateAppOpsBridge.PermissionState) == false) goto L5;
        AppStateAppOpsBridge.PermissionState r4 = (AppStateAppOpsBridge.PermissionState) r3.extraInfo;
    L7:
        return getSummary(r2, r4);
    L5:
        r4 = new AppStateManageExternalStorageBridge(r2, null, null).getManageExternalStoragePermState(r3.info.packageName, r3.info.uid);
        goto L7
    }

    private static CharSequence getSummary(Context r0, AppStateAppOpsBridge.PermissionState r1) {
        if (r1.isPermissible() == false) goto L5;
        int r2 = R.string.app_permission_summary_allowed;
    L7:
        return r0.getString(r2);
    L5:
        r2 = R.string.app_permission_summary_not_allowed;
        goto L7
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManageExternalStorageDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManageExternalStorageDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManageExternalStorageDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_specialaccess_appinfo_ManageExternalStorageDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
