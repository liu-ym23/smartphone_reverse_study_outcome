package com.android.settings.utils;

import android.os.Bundle;
import android.os.UserManager;
import android.view.View;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProfileSettingsPreferenceFragment extends SettingsPreferenceFragment {
    public void com_android_settings_utils_ProfileSettingsPreferenceFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_utils_ProfileSettingsPreferenceFragment__onResume$___twin___() {
        super.onResume();
    }

    protected abstract String getIntentActionString();

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_utils_ProfileSettingsPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_utils_ProfileSettingsPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ProfileSettingsPreferenceFragment() {
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        final SpinnerAdapter r4 = MultiSDKAdapterNew.createUserSpinnerAdapter((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER), getActivity());
        if (r4 == null) goto L6;
        final Spinner r5 = (Spinner) setPinnedHeaderView(R.layout.spinner_view);
        r5.setAdapter(r4);
        r5.setOnItemSelectedListener(new AnonymousClass1(this, r4, r5));
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_utils_ProfileSettingsPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ProfileSettingsPreferenceFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_utils_ProfileSettingsPreferenceFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_utils_ProfileSettingsPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ProfileSettingsPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_utils_ProfileSettingsPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_utils_ProfileSettingsPreferenceFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ProfileSettingsPreferenceFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_utils_ProfileSettingsPreferenceFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
