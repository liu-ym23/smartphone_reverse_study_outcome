package com.android.settings.applications.appinfo;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.android.settings.R;
import com.android.settings.applications.AppInfoWithHeader;
import com.android.settings.applications.AppStateAppOpsBridge;
import com.android.settings.applications.AppStateMediaManagementAppsBridge;
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
public class MediaManagementAppsDetails extends AppInfoWithHeader implements Preference.OnPreferenceChangeListener {
    private static final String KEY_SWITCH_PREF = "media_management_apps_toggle";
    private AppStateMediaManagementAppsBridge mAppBridge;
    private AppOpsManager mAppOpsManager;
    private OListItemSwitch mCheckSwitch;
    private AppStateAppOpsBridge.PermissionState mPermissionState;
    private TwoStatePreference mSwitchPref;

    public void com_android_settings_applications_appinfo_MediaManagementAppsDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment
    public int getMetricsCategory() {
        return 1874;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_appinfo_MediaManagementAppsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_appinfo_MediaManagementAppsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public MediaManagementAppsDetails() {
    }

    static /* synthetic */ AppStateAppOpsBridge.PermissionState access$000(MediaManagementAppsDetails r0) {
        return r0.mPermissionState;
    }

    static /* synthetic */ void access$100(MediaManagementAppsDetails r0, boolean r1) {
        r0.setCanManageMedia(r1);
    }

    public void com_android_settings_applications_appinfo_MediaManagementAppsDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        this.mAppBridge = new AppStateMediaManagementAppsBridge(r5, this.mState, null);
        this.mAppOpsManager = (AppOpsManager) r5.getSystemService(AppOpsManager.class);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        if (this.mPackageInfo != null) goto L7;
        return r1.inflate(R.layout.manage_applications_apps_unsupported, null);
    L7:
        return r1.inflate(R.layout.special_access_common_permission_details, null);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mPermissionState = this.mAppBridge.createPermissionState(this.mPackageName, this.mPackageInfo.applicationInfo.uid);
        OListItemSwitch r5 = (OListItemSwitch) r3.findViewById(R.id.item_switch);
        this.mCheckSwitch = r5;
        r5.setTitleString(getString(R.string.media_management_apps_toggle_label));
        this.mCheckSwitch.setChecked(this.mPermissionState.isPermissible());
        this.mCheckSwitch.setEnabled(this.mPermissionState.permissionDeclared);
        this.mCheckSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
        ((TextView) r3.findViewById(R.id.tv_desc)).setText(R.string.media_management_apps_description);
        refreshUi();
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        boolean r4 = ((Boolean) r3).booleanValue();
        if (r2 != this.mSwitchPref) goto L11;
        AppStateAppOpsBridge.PermissionState r5 = this.mPermissionState;
        if (r5 != null) goto L7;
        return true;
    L7:
        if (r4 == r5.isPermissible()) goto L14;
        setCanManageMedia(r4);
        logPermissionChange(r4, this.mPackageName);
        refreshUi();
        return true;
    L14:
        return true;
    L11:
        return false;
    }

    private void setCanManageMedia(boolean r5) {
        AppOpsManager r0 = this.mAppOpsManager;
        int r1 = this.mPackageInfo.applicationInfo.uid;
        if (r5 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setUidMode(110, r1, r2);
        logPermissionChange(r5, this.mPackageInfo.packageName);
        return;
    L5:
        r2 = 2;
        goto L6
    }

    private void logPermissionChange(boolean r3, String r4) {
        OLog.i(TAG, "logSpecialPermissionChange logCategory=" + (r3 ? 1 : 0) + ", packageName=" + r4);
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        if (this.mPackageInfo != null) goto L5;
        return false;
    L5:
        if (this.mPackageInfo.applicationInfo == null) goto L11;
        return true;
    L11:
        return false;
    }

    public static int getSummary(Context r2, ApplicationsState.AppEntry r3) {
        if ((r3.extraInfo instanceof AppStateAppOpsBridge.PermissionState) == false) goto L5;
        AppStateAppOpsBridge.PermissionState r4 = (AppStateAppOpsBridge.PermissionState) r3.extraInfo;
    L7:
        if (r4.isPermissible() == false) goto L9;
        return R.string.app_permission_summary_allowed;
    L9:
        return R.string.app_permission_summary_not_allowed;
    L5:
        r4 = new AppStateMediaManagementAppsBridge(r2, null, null).createPermissionState(r3.info.packageName, r3.info.uid);
        goto L7
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_appinfo_MediaManagementAppsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MediaManagementAppsDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_MediaManagementAppsDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_MediaManagementAppsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MediaManagementAppsDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_appinfo_MediaManagementAppsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_MediaManagementAppsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MediaManagementAppsDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_MediaManagementAppsDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
