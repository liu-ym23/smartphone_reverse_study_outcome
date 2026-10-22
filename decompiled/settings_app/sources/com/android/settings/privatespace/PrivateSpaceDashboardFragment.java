package com.android.settings.privatespace;

import android.os.Bundle;
import android.os.Flags;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class PrivateSpaceDashboardFragment extends DashboardFragment {
    private static final String TAG = "PSDashboardFragment";

    public void com_android_settings_privatespace_PrivateSpaceDashboardFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.dashboard.DashboardFragment
    protected String getLogTag() {
        return TAG;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment
    public int getMetricsCategory() {
        return 2040;
    }

    @Override // com.android.settings.dashboard.DashboardFragment
    protected int getPreferenceScreenResId() {
        return R.xml.private_space_settings;
    }

    @Override // com.android.settings.dashboard.DashboardFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_privatespace_PrivateSpaceDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.dashboard.DashboardFragment, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_privatespace_PrivateSpaceDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrivateSpaceDashboardFragment() {
    }

    public void com_android_settings_privatespace_PrivateSpaceDashboardFragment__onCreate$___twin___(Bundle r3) {
        if (Flags.allowPrivateProfile() == true) goto L5;
        return;
    L5:
        if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L13;
        super.onCreate(r3);
        if (r3 == null) goto L9;
        return;
    L9:
        if (getIntent().getBooleanExtra(PrivateSpaceAuthenticationActivity.EXTRA_SHOW_PRIVATE_SPACE_UNLOCKED, false) == false) goto L15;
        OLog.i(TAG, "Private space unlocked showing toast");
        ToastUtils.show(getContext(), getContext().getString(R.string.private_space_unlocked));
        return;
    L15:
        return;
    }

    @Override // com.android.settings.dashboard.DashboardFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (PrivateSpaceMaintainer.getInstance(getContext()).isPrivateSpaceLocked() == false) goto L6;
        getActivity().finishAndRemoveTask();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_privatespace_PrivateSpaceDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrivateSpaceDashboardFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_privatespace_PrivateSpaceDashboardFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_privatespace_PrivateSpaceDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrivateSpaceDashboardFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_privatespace_PrivateSpaceDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_privatespace_PrivateSpaceDashboardFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrivateSpaceDashboardFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_privatespace_PrivateSpaceDashboardFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
