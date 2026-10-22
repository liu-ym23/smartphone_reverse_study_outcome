package com.android.settings.revone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.settings.MainSettings;
import com.android.settings.MainSettingsFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TabletSettings extends MainSettings {

    public static class Settings2 extends MainSettings {
        public void com_android_settings_revone_TabletSettings$Settings2__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_revone_TabletSettings$Settings2__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_revone_TabletSettings$Settings2__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_revone_TabletSettings$Settings2__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_revone_TabletSettings$Settings2__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public Settings2() {
        }

        @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity
        public <T extends Fragment> T getBindFragment() {
            return new MainSettingsFragment();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Settings2 r1) {
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onStop(r1);
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert("onCreate")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onCreate(Settings2 r3, Bundle r4) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            Settings2 r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onCreateWhenPrivacyNotOk(null);
            r0.onSuperCreate(null);
            return;
        L6:
            GrantUtil.INSTANCE.applicationInit();
            r3.com_android_settings_revone_TabletSettings$Settings2__onCreate$___twin___(r4);
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_BatchedActivityLancet_onResume(Settings2 r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(Settings2 r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onResume(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
            OLog.i("AppLifecycle", "onResume_Activity " + r0);
            AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r1.recordVisibleTime(r0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
            Settings2 r5 = r4;
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
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(Settings2 r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_revone_TabletSettings$Settings2__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_BatchedActivityLancet_onStop(Settings2 r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_revone_TabletSettings$Settings2_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @Insert("onResume")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onResume(Settings2 r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            Settings2 r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperResume();
            return;
        L6:
            r3.com_android_settings_revone_TabletSettings$Settings2__onResume$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(Settings2 r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onPause(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @Insert("onPause")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onPause(Settings2 r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            Settings2 r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperPause();
            return;
        L6:
            r3.com_android_settings_revone_TabletSettings$Settings2__onPause$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(Settings2 r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
            OLog.i("AppLifecycle", "onCreate_Activity " + r0);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
            Settings2 r5 = r3;
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
        public static void com_android_settings_revone_TabletSettings$Settings2_com_obric_hook_lancet_PrivacyHook_onStop(Settings2 r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            Settings2 r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperStop();
            return;
        L6:
            r3.com_android_settings_revone_TabletSettings$Settings2__onStop$___twin___();
        }
    }

    public static class TabletSettingsActivity extends MainSettings {
        public void com_android_settings_revone_TabletSettings$TabletSettingsActivity__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_revone_TabletSettings$TabletSettingsActivity__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_revone_TabletSettings$TabletSettingsActivity__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_revone_TabletSettings$TabletSettingsActivity__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_revone_TabletSettings$TabletSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public TabletSettingsActivity() {
        }

        @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity
        public <T extends Fragment> T getBindFragment() {
            return new TabletSettingsFragment();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TabletSettingsActivity r1) {
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert("onCreate")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(TabletSettingsActivity r3, Bundle r4) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            TabletSettingsActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onCreateWhenPrivacyNotOk(null);
            r0.onSuperCreate(null);
            return;
        L6:
            GrantUtil.INSTANCE.applicationInit();
            r3.com_android_settings_revone_TabletSettings$TabletSettingsActivity__onCreate$___twin___(r4);
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(TabletSettingsActivity r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(TabletSettingsActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
            OLog.i("AppLifecycle", "onResume_Activity " + r0);
            AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r1.recordVisibleTime(r0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
            TabletSettingsActivity r5 = r4;
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
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(TabletSettingsActivity r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_revone_TabletSettings$TabletSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(TabletSettingsActivity r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @Insert("onResume")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onResume(TabletSettingsActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            TabletSettingsActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperResume();
            return;
        L6:
            r3.com_android_settings_revone_TabletSettings$TabletSettingsActivity__onResume$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(TabletSettingsActivity r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @Insert("onPause")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onPause(TabletSettingsActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            TabletSettingsActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperPause();
            return;
        L6:
            r3.com_android_settings_revone_TabletSettings$TabletSettingsActivity__onPause$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(TabletSettingsActivity r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
            OLog.i("AppLifecycle", "onCreate_Activity " + r0);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
            TabletSettingsActivity r5 = r3;
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
        public static void com_android_settings_revone_TabletSettings$TabletSettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(TabletSettingsActivity r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
            TabletSettingsActivity r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperStop();
            return;
        L6:
            r3.com_android_settings_revone_TabletSettings$TabletSettingsActivity__onStop$___twin___();
        }
    }

    public void com_android_settings_revone_TabletSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TabletSettings__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_revone_TabletSettings__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_revone_TabletSettings__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_revone_TabletSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.MainSettings, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public TabletSettings() {
    }

    public void com_android_settings_revone_TabletSettings__onNewIntent$___twin___(Intent r5) {
        super.onNewIntent(r5);
        if ("android.intent.action.MAIN".equals(r5.getAction()) == false) goto L5;
        return;
    L5:
        boolean r0 = getTopFragment() instanceof MainSettingsFragment;
        OLog.d(this.TAG, "onNewIntent, isMainSettingsAtTop " + r0 + " intent " + r5);
        if (r0 == true) goto L9;
        Intent r6 = new Intent();
        r6.setClass(this, Settings2.class);
        startActivity(r6);
        return;
    }

    @Override // com.android.settings.MainSettings, com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        return new MainSettingsFragment();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_revone_TabletSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TabletSettings r1) {
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onCreate(TabletSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TabletSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_revone_TabletSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(TabletSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(TabletSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        TabletSettings r5 = r4;
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
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(TabletSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_revone_TabletSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(TabletSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_revone_TabletSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onResume(TabletSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TabletSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_revone_TabletSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(TabletSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onPause(TabletSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TabletSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_revone_TabletSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(TabletSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        TabletSettings r5 = r3;
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
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onStop(TabletSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TabletSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_revone_TabletSettings__onStop$___twin___();
    }

    @Insert("onNewIntent")
    public static void com_android_settings_revone_TabletSettings_com_obric_hook_lancet_PrivacyHook_onNewIntent(TabletSettings r3, Intent r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        TabletSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r4);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_revone_TabletSettings__onNewIntent$___twin___(r4);
    }
}
