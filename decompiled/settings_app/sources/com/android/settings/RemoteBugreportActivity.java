package com.android.settings;

import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteBugreportActivity extends LifeHookActivity2 {
    private static final String TAG = "RemoteBugreportActivity";

    public void com_android_settings_RemoteBugreportActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_RemoteBugreportActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_RemoteBugreportActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_RemoteBugreportActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public RemoteBugreportActivity() {
    }

    public void com_android_settings_RemoteBugreportActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        DevicePolicyManager r8 = (DevicePolicyManager) getSystemService(DevicePolicyManager.class);
        int r0 = getIntent().getIntExtra("android.app.extra.bugreport_notification_type", -1);
        if (r0 != 2) goto L6;
        new AlertDialog.Builder(this).setMessage(r8.getResources().getString("Settings.SHARING_REMOTE_BUGREPORT_MESSAGE", new RemoteBugreportActivity$$ExternalSyntheticLambda0(this))).setOnDismissListener(new AnonymousClass2(this)).setNegativeButton(android.R.string.ok, new AnonymousClass1(this)).create().show();
        return;
    L6:
        if (r0 != 1) goto L8;
    L11:
        if (r0 != 1) goto L13;
        final int r2 = R.string.share_remote_bugreport_dialog_message;
    L14:
        if (r0 != 1) goto L16;
        String r1 = "Settings.SHARE_REMOTE_BUGREPORT_NOT_FINISHED_REQUEST_CONSENT";
    L17:
        new AlertDialog.Builder(this).setTitle(r8.getResources().getString("Settings.SHARE_REMOTE_BUGREPORT_DIALOG_TITLE", new RemoteBugreportActivity$$ExternalSyntheticLambda1(this))).setMessage(r8.getResources().getString(r1, new RemoteBugreportActivity$$ExternalSyntheticLambda2(this, r2))).setOnDismissListener(new AnonymousClass5(this)).setNegativeButton(R.string.decline_remote_bugreport_action, new AnonymousClass4(this)).setPositiveButton(R.string.share_remote_bugreport_action, new AnonymousClass3(this)).create().show();
        return;
    L16:
        r1 = "Settings.SHARE_REMOTE_BUGREPORT_FINISHED_REQUEST_CONSENT";
        goto L17
    L13:
        r2 = R.string.share_remote_bugreport_dialog_message_finished;
        goto L14
    L8:
        if (r0 == 3) goto L11;
        OLog.e(TAG, "Incorrect dialog type, no dialog shown. Received: " + r0);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-RemoteBugreportActivity, reason: not valid java name */
    /* synthetic */ String m193lambda$onCreate$0$comandroidsettingsRemoteBugreportActivity() {
        return getString(R.string.sharing_remote_bugreport_dialog_message);
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-RemoteBugreportActivity, reason: not valid java name */
    /* synthetic */ String m194lambda$onCreate$1$comandroidsettingsRemoteBugreportActivity() {
        return getString(R.string.share_remote_bugreport_dialog_title);
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-RemoteBugreportActivity, reason: not valid java name */
    /* synthetic */ String m195lambda$onCreate$2$comandroidsettingsRemoteBugreportActivity(int r1) {
        return getString(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_RemoteBugreportActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RemoteBugreportActivity r1) {
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(RemoteBugreportActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RemoteBugreportActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_RemoteBugreportActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(RemoteBugreportActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(RemoteBugreportActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        RemoteBugreportActivity r5 = r4;
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
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(RemoteBugreportActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_RemoteBugreportActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(RemoteBugreportActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_RemoteBugreportActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(RemoteBugreportActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RemoteBugreportActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_RemoteBugreportActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(RemoteBugreportActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(RemoteBugreportActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RemoteBugreportActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_RemoteBugreportActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(RemoteBugreportActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        RemoteBugreportActivity r5 = r3;
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
    public static void com_android_settings_RemoteBugreportActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(RemoteBugreportActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        RemoteBugreportActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_RemoteBugreportActivity__onStop$___twin___();
    }
}
