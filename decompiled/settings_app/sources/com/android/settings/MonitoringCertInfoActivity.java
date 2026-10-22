package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.MessageFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class MonitoringCertInfoActivity extends LifeHookActivity2 implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
    private int mUserId;

    public void com_android_settings_MonitoringCertInfoActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_MonitoringCertInfoActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_MonitoringCertInfoActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_MonitoringCertInfoActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public MonitoringCertInfoActivity() {
    }

    public void com_android_settings_MonitoringCertInfoActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        int r10 = getIntent().getIntExtra("android.intent.extra.USER_ID", UserHandle.myUserId());
        this.mUserId = r10;
        if (r10 != (-10000)) goto L5;
        UserHandle r11 = null;
    L6:
        DevicePolicyManager r0 = (DevicePolicyManager) getSystemService(DevicePolicyManager.class);
        int r1 = getIntent().getIntExtra("android.settings.extra.number_of_certificates", 1);
        if (RestrictedLockUtils.getProfileOrDeviceOwner(this, r11) == null) goto L9;
        int r12 = R.plurals.ssl_ca_cert_settings_button;
    L10:
        CharSequence r13 = getResources().getQuantityText(r12, r1);
        setTitle(r13);
        OAlertDialogBuilder r4 = new OAlertDialogBuilder(this);
        r4.title(r13.toString(), true);
        r4.cancelable(true);
        r4.horizontalButton();
        r4.positiveButton(getResources().getQuantityText(R.plurals.ssl_ca_cert_settings_button, r1), this);
        r4.negativeButton(R.string.cancel, new MonitoringCertInfoActivity$$ExternalSyntheticLambda0());
        if (r0.getProfileOwnerAsUser(this.mUserId) == null) goto L14;
        MessageFormat r14 = new MessageFormat(r0.getResources().getString("Settings.WORK_PROFILE_INSTALLED_CERTIFICATE_AUTHORITY_WARNING", new MonitoringCertInfoActivity$$ExternalSyntheticLambda1(this)), Locale.getDefault());
        HashMap r5 = new HashMap();
        r5.put("numberOfCertificates", Integer.valueOf(r1));
        r5.put("orgName", r0.getProfileOwnerNameAsUser(this.mUserId));
        r4.message(r14.format(r5));
    L17:
        r4.onDismiss(this);
        r4.show();
        return;
    L14:
        if (r0.getDeviceOwnerComponentOnCallingUser() == null) goto L16;
        MessageFormat r15 = new MessageFormat(r0.getResources().getString("Settings.DEVICE_OWNER_INSTALLED_CERTIFICATE_AUTHORITY_WARNING", new MonitoringCertInfoActivity$$ExternalSyntheticLambda2(this)), Locale.getDefault());
        HashMap r6 = new HashMap();
        r6.put("numberOfCertificates", Integer.valueOf(r1));
        r6.put("orgName", r0.getDeviceOwnerNameOnAnyUser());
        r4.message(r15.format(r6));
        goto L17
    L16:
        r4.icon(android.R.drawable.stat_notify_error);
        r4.message(R.string.ssl_ca_cert_warning_message);
        goto L17
    L9:
        r12 = R.plurals.ssl_ca_cert_dialog_title;
        goto L10
    L5:
        r11 = UserHandle.of(r10);
        goto L6
    }

    static /* synthetic */ void lambda$onCreate$0(DialogInterface r0, int r1) {
        if (r0 == null) goto L5;
        r0.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-MonitoringCertInfoActivity, reason: not valid java name */
    /* synthetic */ String m157x854fbbca() {
        return getString(R.string.ssl_ca_cert_info_message);
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-MonitoringCertInfoActivity, reason: not valid java name */
    /* synthetic */ String m158x84d955cb() {
        return getResources().getString(R.string.ssl_ca_cert_info_message_device_owner);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r3, int r4) {
        Intent r5 = new Intent("com.android.settings.TRUSTED_CREDENTIALS_USER");
        r5.setFlags(335544320);
        r5.putExtra(TrustedCredentialsSettings.ARG_SHOW_NEW_FOR_USER, this.mUserId);
        Utils.startActivity(this, r5);
        r3.dismiss();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MonitoringCertInfoActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MonitoringCertInfoActivity r1) {
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(MonitoringCertInfoActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        MonitoringCertInfoActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_MonitoringCertInfoActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(MonitoringCertInfoActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(MonitoringCertInfoActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        MonitoringCertInfoActivity r5 = r4;
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
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(MonitoringCertInfoActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_MonitoringCertInfoActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(MonitoringCertInfoActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_MonitoringCertInfoActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(MonitoringCertInfoActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        MonitoringCertInfoActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_MonitoringCertInfoActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(MonitoringCertInfoActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(MonitoringCertInfoActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        MonitoringCertInfoActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_MonitoringCertInfoActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(MonitoringCertInfoActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        MonitoringCertInfoActivity r5 = r3;
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
    public static void com_android_settings_MonitoringCertInfoActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(MonitoringCertInfoActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        MonitoringCertInfoActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_MonitoringCertInfoActivity__onStop$___twin___();
    }
}
