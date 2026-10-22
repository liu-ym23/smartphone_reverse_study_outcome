package com.android.settings.applications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.deviceinfo.Memory;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class ApplicationSettingsFragment extends BaseFragment implements View.OnClickListener {
    private SettingItemText mDoppelganger;
    private SettingItemText mPreferredAppSettings;
    private SettingItemText mViewAppManagement;
    private SettingItemText mViewPermissions;
    private SettingItemText mViewPowerSave;
    private SettingItemText mViewStorage;

    public void com_android_settings_applications_ApplicationSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_applications_ApplicationSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ApplicationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ApplicationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ApplicationSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.app_settings, r3, false);
        SettingItemText r5 = (SettingItemText) findViewByIdNullable(R.id.item_doppelganger);
        this.mDoppelganger = r5;
        r5.setOnClickListener(this);
        SettingItemText r6 = (SettingItemText) findViewByIdNullable(R.id.item_preferred_app);
        this.mPreferredAppSettings = r6;
        r6.setOnClickListener(this);
        SettingItemText r7 = (SettingItemText) findViewByIdNullable(R.id.item_application_manage);
        this.mViewAppManagement = r7;
        r7.setOnClickListener(this);
        SettingItemText r8 = (SettingItemText) findViewByIdNullable(R.id.item_storage);
        this.mViewStorage = r8;
        r8.setOnClickListener(this);
        SettingItemText r9 = (SettingItemText) findViewByIdNullable(R.id.item_powersave);
        this.mViewPowerSave = r9;
        r9.setOnClickListener(this);
        SettingItemText r10 = (SettingItemText) findViewByIdNullable(R.id.item_permissions);
        this.mViewPermissions = r10;
        r10.setOnClickListener(this);
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r11) {
        Intent r0 = new Intent();
        r0.putExtra("back_text_id", R.string.manager_application);
        if (this.mDoppelganger != r11) goto L6;
        Intent r12 = new Intent();
        r12.setClassName("com.android.settings", "com.android.settings.Settings$DoppelgangerSettingsActivity");
        startActivity(r12);
        SettingsTracker.onItemClick(1702);
        return;
    L6:
        if (this.mPreferredAppSettings != r11) goto L9;
        start(PreferredActivityCategoryFragment.class);
        SettingsTracker.onItemClick(1703);
        return;
    L9:
        if (this.mViewAppManagement != r11) goto L12;
        Intent r13 = new Intent("android.intent.action.MAIN");
        r13.setClassName("com.android.settings", "com.android.settings.Settings$ManageApplicationsActivity");
        r13.putExtra(ManageApplicationsFragment.EXTRA_SYSTEM_APP_MANAGER, false);
        r13.putExtra("title_id", R.string.system_app_manager_title);
        startActivity(r13);
        SettingsTracker.onItemClick(1701);
        return;
    L12:
        if (this.mViewStorage != r11) goto L19;
        if (Utils.needJumpToSecurity(this.mContext, 1) == false) goto L16;
        r0.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.storage.StorageActivity");
        r0.setAction("android.intent.action.MAIN");
        r0.removeExtra("back_text_id");
        r0.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r0.putExtra("back_text_res_name", "manager_application");
        r0.putExtra("bytedanceos.intent.extra.ANIM_RESOURCE_ID", new int[]{R.anim.slide_in_from_left, R.anim.slide_out_to_right});
        startActivity(r0);
    L17:
        SettingsTracker.onItemClick(1704);
        return;
    L16:
        start(Memory.class);
        goto L17
    L19:
        if (this.mViewPowerSave != r11) goto L22;
        r0.setClassName("com.android.settings", "com.android.settings.fuelgauge.PowerUsageSummaryActivity");
        Utils.startActivity(getActivity(), r0);
        return;
    L22:
        if (this.mViewPermissions != r11) goto L30;
        r0.setClassName(Constants.PKG_SECURITY, "com.obric.security.PermissionsActivity");
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r0.putExtra("back_text_res_name", "manager_application");
        Utils.startActivity(getActivity(), r0);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SettingsTracker.trackAppManagerSettings(this.mContext);
        super.onDestroy();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ApplicationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ApplicationSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ApplicationSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ApplicationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ApplicationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ApplicationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ApplicationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ApplicationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ApplicationSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
