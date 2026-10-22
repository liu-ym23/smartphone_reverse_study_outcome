package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.setupwizardlib.SetupWizardPreferenceLayout;
import com.android.setupwizardlib.view.NavigationBar;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SetupEncryptionInterstitial extends EncryptionInterstitial {

    public static class SetupEncryptionInterstitialFragment extends EncryptionInterstitial.EncryptionInterstitialFragment implements NavigationBar.NavigationBarListener {
        public void com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // com.android.settings.EncryptionInterstitial.EncryptionInterstitialFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // com.android.setupwizardlib.view.NavigationBar.NavigationBarListener
        public void onNavigateNext() {
        }

        @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public SetupEncryptionInterstitialFragment() {
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onViewCreated(View r3, Bundle r4) {
            super.onViewCreated(r3, r4);
            SetupWizardPreferenceLayout r5 = (SetupWizardPreferenceLayout) r3;
            r5.setDividerInset(getContext().getResources().getDimensionPixelSize(R.dimen.suw_items_icon_divider_inset));
            NavigationBar r6 = r5.getNavigationBar();
            r6.setNavigationBarListener(this);
            Button r7 = r6.getNextButton();
            r7.setText(null);
            r7.setEnabled(false);
            r5.setHeaderText(R.string.encryption_interstitial_header);
            FragmentActivity r8 = getActivity();
            if (r8 == null) goto L5;
            SetupWizardUtils.setImmersiveMode(r8);
        L5:
            setDivider(null);
        }

        @Override // com.android.settings.EncryptionInterstitial.EncryptionInterstitialFragment
        protected TextView createHeaderView() {
            return (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.setup_encryption_interstitial_header, null, false);
        }

        @Override // androidx.preference.PreferenceFragmentCompat
        public RecyclerView onCreateRecyclerView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
            return ((SetupWizardPreferenceLayout) r2).onCreateRecyclerView(r1, r2, r3);
        }

        @Override // com.android.setupwizardlib.view.NavigationBar.NavigationBarListener
        public void onNavigateBack() {
            FragmentActivity r0 = getActivity();
            if (r0 == null) goto L6;
            r0.onBackPressed();
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SetupEncryptionInterstitialFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SetupEncryptionInterstitialFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SetupEncryptionInterstitialFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_SetupEncryptionInterstitial$SetupEncryptionInterstitialFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public void com_android_settings_SetupEncryptionInterstitial__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_SetupEncryptionInterstitial__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_SetupEncryptionInterstitial__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_SetupEncryptionInterstitial__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.SettingsActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.SettingsActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public SetupEncryptionInterstitial() {
    }

    public static Intent createStartIntent(Context r0, int r1, boolean r2, Intent r3) {
        Intent r4 = EncryptionInterstitial.createStartIntent(r0, r1, r2, r3);
        r4.setClass(r0, SetupEncryptionInterstitial.class);
        r4.putExtra("extra_prefs_show_button_bar", false).putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID, -1);
        return r4;
    }

    @Override // com.android.settings.EncryptionInterstitial, com.android.settings.SettingsActivity, android.app.Activity
    public Intent getIntent() {
        Intent r0 = new Intent(super.getIntent());
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT, SetupEncryptionInterstitialFragment.class.getName());
        return r0;
    }

    @Override // com.android.settings.EncryptionInterstitial, com.android.settings.SettingsActivity
    protected boolean isValidFragment(String r1) {
        return SetupEncryptionInterstitialFragment.class.getName().equals(r1);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper
    protected void onApplyThemeResource(Resources.Theme r1, int r2, boolean r3) {
        super.onApplyThemeResource(r1, SetupWizardUtils.getTheme(getIntent()), r3);
    }

    public void com_android_settings_SetupEncryptionInterstitial__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SetupEncryptionInterstitial_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SetupEncryptionInterstitial r1) {
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onCreate(SetupEncryptionInterstitial r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SetupEncryptionInterstitial r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SetupEncryptionInterstitial__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_BatchedActivityLancet_onResume(SetupEncryptionInterstitial r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(SetupEncryptionInterstitial r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        SetupEncryptionInterstitial r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(SetupEncryptionInterstitial r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_SetupEncryptionInterstitial__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_BatchedActivityLancet_onStop(SetupEncryptionInterstitial r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_SetupEncryptionInterstitial_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onResume(SetupEncryptionInterstitial r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SetupEncryptionInterstitial r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_SetupEncryptionInterstitial__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(SetupEncryptionInterstitial r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onPause(SetupEncryptionInterstitial r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SetupEncryptionInterstitial r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_SetupEncryptionInterstitial__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(SetupEncryptionInterstitial r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        SetupEncryptionInterstitial r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_SetupEncryptionInterstitial_com_obric_hook_lancet_PrivacyHook_onStop(SetupEncryptionInterstitial r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SetupEncryptionInterstitial r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_SetupEncryptionInterstitial__onStop$___twin___();
    }
}
