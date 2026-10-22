package com.android.settings.notification;

import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Slog;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.accessibility.AccessibilitySettings;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationAccessConfirmationActivity extends LifeHookActivity2 implements DialogInterface {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "NotificationAccessConfirmationActivity";
    private ComponentName mComponentName;
    private DevicePolicyManager mDpm;
    private NotificationManager mNm;
    private UserManager mUm;
    private int mUserId;

    public void com_android_settings_notification_NotificationAccessConfirmationActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_notification_NotificationAccessConfirmationActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public NotificationAccessConfirmationActivity() {
    }

    public void com_android_settings_notification_NotificationAccessConfirmationActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        getWindow().addSystemFlags(524288);
        this.mUm = (UserManager) getSystemService(UserManager.class);
        this.mDpm = (DevicePolicyManager) getSystemService(DevicePolicyManager.class);
        if (this.mUm.isManagedProfile() == false) goto L6;
        Slog.w(LOG_TAG, "Apps in the work profile do not support notification listeners");
        ToastUtils.show(this, this.mDpm.getResources().getString("Settings.WORK_APPS_CANNOT_ACCESS_NOTIFICATION_SETTINGS", new NotificationAccessConfirmationActivity$$ExternalSyntheticLambda0(this)));
        finish();
        return;
    L6:
        this.mNm = (NotificationManager) getSystemService("notification");
        this.mComponentName = (ComponentName) getIntent().getParcelableExtra(AccessibilitySettings.EXTRA_COMPONENT_NAME);
        this.mUserId = getIntent().getIntExtra("user_id", -10000);
        ComponentName r10 = this.mComponentName;
        if (r10 != null) goto L9;
    L37:
        finish();
        return;
    L9:
        if (r10.getPackageName() == null) goto L37;
        if (this.mComponentName.flattenToString().length() > NotificationManager.MAX_SERVICE_COMPONENT_NAME_LENGTH) goto L37;
        CharSequence r11 = getPackageManager().getApplicationInfo(this.mComponentName.getPackageName(), 0).loadSafeLabel(getPackageManager(), 1000.0f, 5);     // Catch: PackageManager.NameNotFoundException -> L34
        if (TextUtils.isEmpty(r11) == false) goto L18;
        finish();
        return;
    L18:
        Iterator r1 = getPackageManager().queryIntentServicesAsUser(new Intent("android.service.notification.NotificationListenerService"), 0, this.mUserId).iterator();
    L20:
        if (r1.hasNext() == false) goto L28;
        ResolveInfo r3 = (ResolveInfo) r1.next();
        if (r3.serviceInfo.getComponentName().equals(this.mComponentName) == false) goto L20;
        if ("android.permission.BIND_NOTIFICATION_LISTENER_SERVICE".equals(r3.serviceInfo.permission) == true) goto L27;
        Slog.e(LOG_TAG, "Service " + this.mComponentName + " lacks permission android.permission.BIND_NOTIFICATION_LISTENER_SERVICE");
        finish();
        return;
    L27:
        boolean r2 = true;
    L29:
        if (r2 == true) goto L32;
        Slog.e(LOG_TAG, "Service " + this.mComponentName + " lacks an intent-filter action for android.service.notification.NotificationListenerService.");
        finish();
        return;
    L32:
        AlertController.AlertParams r0 = new AlertController.AlertParams(this);
        r0.mTitle = getString(R.string.notification_listener_security_warning_title, new Object[]{r11});
        r0.mMessage = getString(R.string.notification_listener_security_warning_summary, new Object[]{r11});
        r0.mPositiveButtonText = getString(R.string.allow);
        r0.mPositiveButtonListener = new NotificationAccessConfirmationActivity$$ExternalSyntheticLambda1(this);
        r0.mNegativeButtonText = getString(R.string.deny);
        r0.mNegativeButtonListener = new NotificationAccessConfirmationActivity$$ExternalSyntheticLambda2(this);
        AlertController.create(this, this, getWindow()).installContent(r0);
        getWindow().setCloseOnTouchOutside(false);
        return;
    L28:
        r2 = false;
    L34:
        e = move-exception;
        Slog.e(LOG_TAG, "Couldn't find app with package name for " + this.mComponentName, e);
        finish();
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-notification-NotificationAccessConfirmationActivity, reason: not valid java name */
    /* synthetic */ String m526x8a313755() {
        return getString(R.string.notification_settings_work_profile);
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-notification-NotificationAccessConfirmationActivity, reason: not valid java name */
    /* synthetic */ void m527xa4a23074(DialogInterface r1, int r2) {
        onAllow();
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-notification-NotificationAccessConfirmationActivity, reason: not valid java name */
    /* synthetic */ void m528xbf132993(DialogInterface r1, int r2) {
        cancel();
    }

    public void com_android_settings_notification_NotificationAccessConfirmationActivity__onResume$___twin___() {
        super.onResume();
        getWindow().addFlags(524288);
    }

    public void com_android_settings_notification_NotificationAccessConfirmationActivity__onPause$___twin___() {
        getWindow().clearFlags(524288);
        super.onPause();
    }

    private void onAllow() {
        this.mNm.setNotificationListenerAccessGranted(this.mComponentName, true);
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return AlertActivity.dispatchPopulateAccessibilityEvent(this, r1);
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        finish();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        if (isFinishing() == true) goto L6;
        finish();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NotificationAccessConfirmationActivity r1) {
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(NotificationAccessConfirmationActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        NotificationAccessConfirmationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_notification_NotificationAccessConfirmationActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(NotificationAccessConfirmationActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(NotificationAccessConfirmationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        NotificationAccessConfirmationActivity r5 = r4;
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
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(NotificationAccessConfirmationActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_notification_NotificationAccessConfirmationActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(NotificationAccessConfirmationActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(NotificationAccessConfirmationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        NotificationAccessConfirmationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_notification_NotificationAccessConfirmationActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(NotificationAccessConfirmationActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(NotificationAccessConfirmationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        NotificationAccessConfirmationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_notification_NotificationAccessConfirmationActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(NotificationAccessConfirmationActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        NotificationAccessConfirmationActivity r5 = r3;
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
    public static void com_android_settings_notification_NotificationAccessConfirmationActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(NotificationAccessConfirmationActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        NotificationAccessConfirmationActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_notification_NotificationAccessConfirmationActivity__onStop$___twin___();
    }
}
