package com.android.settings.specialaccess.vrlistener;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VrListenersSettingsActivity extends ManagedServiceActivity {
    public static final ManagedServiceActivity.Config CONFIG = null;
    private static final String TAG = "VrListenersSettingsActivity";

    public void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.no_vr_listeners;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.vr_listeners_subtitle;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.vr_listeners_title;
    }

    @Override // com.android.settings.specialaccess.vrlistener.ManagedServiceActivity, com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.specialaccess.vrlistener.ManagedServiceActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settings.specialaccess.vrlistener.ManagedServiceActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public VrListenersSettingsActivity() {
    }

    static {
        CONFIG = new ManagedServiceActivity.Config.Builder().setTag(TAG).setSetting("enabled_vr_listeners").setIntentAction("android.service.vr.VrListenerService").setPermission("android.permission.BIND_VR_LISTENER_SERVICE").setNoun("vr listener").setWarningDialogTitle(R.string.vr_listener_security_warning_title).setWarningDialogSummary(R.string.vr_listener_security_warning_summary).setEmptyText(R.string.no_vr_listeners).build();
    }

    @Override // com.android.settings.specialaccess.vrlistener.ManagedServiceActivity
    protected ManagedServiceActivity.Config getConfig() {
        return CONFIG;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(VrListenersSettingsActivity r1) {
        r1.com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(VrListenersSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(VrListenersSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        VrListenersSettingsActivity r5 = r4;
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
    public static void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(VrListenersSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(VrListenersSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(VrListenersSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(VrListenersSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_vrlistener_VrListenersSettingsActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        VrListenersSettingsActivity r5 = r3;
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
}
