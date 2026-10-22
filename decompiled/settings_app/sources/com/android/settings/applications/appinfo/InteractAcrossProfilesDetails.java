package com.android.settings.applications.appinfo;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.applications.AppInfoWithHeader;
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
public class InteractAcrossProfilesDetails extends AppInfoWithHeader {
    private static final String APP_OP_STR = "android:interact_across_profiles";
    private static final String LOG_TAG = "InteractAcrossProfiles";
    private AppOpsManager mAppOpsManager;
    private OListItemSwitch mCheckSwitch;
    private TextView mTvDesc;

    public void com_android_settings_applications_appinfo_InteractAcrossProfilesDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment
    public int getMetricsCategory() {
        return 0;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_appinfo_InteractAcrossProfilesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_appinfo_InteractAcrossProfilesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public InteractAcrossProfilesDetails() {
    }

    static /* synthetic */ PackageInfo access$000(InteractAcrossProfilesDetails r0) {
        return r0.mPackageInfo;
    }

    static /* synthetic */ String access$100(InteractAcrossProfilesDetails r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ AppOpsManager access$200(InteractAcrossProfilesDetails r0) {
        return r0.mAppOpsManager;
    }

    public void com_android_settings_applications_appinfo_InteractAcrossProfilesDetails__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mAppOpsManager = (AppOpsManager) getActivity().getSystemService(AppOpsManager.class);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        if (this.mPackageInfo != null) goto L7;
        return r1.inflate(R.layout.manage_applications_apps_unsupported, null);
    L7:
        return r1.inflate(R.layout.special_access_common_permission_details, null);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mCheckSwitch = (OListItemSwitch) r1.findViewById(R.id.item_switch);
        this.mTvDesc = (TextView) r1.findViewById(R.id.tv_desc);
        refreshUi();
        this.mCheckSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        if (this.mPackageInfo != null) goto L5;
    L21:
        return false;
    L5:
        if (this.mPackageInfo.applicationInfo == null) goto L21;
        if (this.mAppOpsManager.checkOpNoThrow(93, this.mPackageInfo.applicationInfo.uid, this.mPackageName) != 0) goto L10;
        boolean r0 = true;
    L11:
        OListItemSwitch r3 = this.mCheckSwitch;
        if (r3 == null) goto L18;
        if (r0 == false) goto L15;
        int r4 = R.string.interact_across_profiles_switch_enabled;
    L16:
        r3.setTitleString(getString(r4));
        this.mCheckSwitch.setChecked(r0);
        goto L18
    L15:
        r4 = R.string.interact_across_profiles_switch_disabled;
    L18:
        if (this.mTvDesc == null) goto L20;
        this.mTvDesc.setText(getString(R.string.interact_across_profiles_summary_1, new Object[]{this.mPackageInfo.applicationInfo.loadLabel(getPackageManager()).toString()}) + "\n\n" + getString(R.string.interact_across_profiles_summary_2));
    L20:
        return true;
    L10:
        r0 = false;
        goto L11
    }

    public static CharSequence getSummary(Context r3, ApplicationsState.AppEntry r4) {
        if (((AppOpsManager) r3.getSystemService(AppOpsManager.class)).checkOpNoThrow(APP_OP_STR, r4.info.uid, r4.info.packageName) != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        int r6 = R.string.interact_across_profiles_switch_enabled;
    L10:
        return r3.getString(r6);
    L8:
        r6 = R.string.interact_across_profiles_switch_disabled;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_appinfo_InteractAcrossProfilesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(InteractAcrossProfilesDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_InteractAcrossProfilesDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_InteractAcrossProfilesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(InteractAcrossProfilesDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_appinfo_InteractAcrossProfilesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_InteractAcrossProfilesDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(InteractAcrossProfilesDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_InteractAcrossProfilesDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
