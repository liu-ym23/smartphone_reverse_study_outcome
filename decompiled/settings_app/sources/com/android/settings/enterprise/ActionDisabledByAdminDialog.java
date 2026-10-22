package com.android.settings.enterprise;

import android.app.admin.DevicePolicyManager;
import android.app.admin.EnforcingAdmin;
import android.app.admin.UnknownAuthority;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.security.advancedprotection.AdvancedProtectionManager;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.FlagsReflectionUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ActionDisabledByAdminDialog extends LifeHookActivity2 implements DialogInterface.OnDismissListener {
    private OAlertDialog mAlertDialog;
    private ActionDisabledByAdminDialogHelper mDialogHelper;

    public void com_android_settings_enterprise_ActionDisabledByAdminDialog__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_enterprise_ActionDisabledByAdminDialog__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_enterprise_ActionDisabledByAdminDialog__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_enterprise_ActionDisabledByAdminDialog__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent r1) {
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onNewIntent(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ActionDisabledByAdminDialog() {
    }

    public void com_android_settings_enterprise_ActionDisabledByAdminDialog__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        RestrictedLockUtils.EnforcedAdmin r4 = getAdminDetailsFromIntent(getIntent());
        String r0 = getRestrictionFromIntent(getIntent());
        ActionDisabledByAdminDialogHelper r1 = new ActionDisabledByAdminDialogHelper(this, r0);
        this.mDialogHelper = r1;
        OAlertDialog r5 = r1.prepareDialogBuilder(r0, r4);
        this.mAlertDialog = r5;
        r5.setOnDismissListener(this);
        this.mAlertDialog.show();
    }

    public void com_android_settings_enterprise_ActionDisabledByAdminDialog__onNewIntent$___twin___(Intent r3) {
        super.onNewIntent(r3);
        RestrictedLockUtils.EnforcedAdmin r0 = getAdminDetailsFromIntent(r3);
        String r4 = getRestrictionFromIntent(r3);
        OAlertDialog r1 = this.mAlertDialog;
        if (r1 == null) goto L6;
        this.mDialogHelper.updateDialog(r4, r0, r1);
        return;
    }

    RestrictedLockUtils.EnforcedAdmin getAdminDetailsFromIntent(Intent r9) {
        RestrictedLockUtils.EnforcedAdmin r0 = new RestrictedLockUtils.EnforcedAdmin(null, UserHandle.of(UserHandle.myUserId()));
        if (r9 != null) goto L5;
        return r0;
    L5:
        r0.component = (ComponentName) r9.getParcelableExtra("android.app.extra.DEVICE_ADMIN", ComponentName.class);
        int r1 = r9.getIntExtra("android.intent.extra.USER_ID", UserHandle.myUserId());
        if (r0.component != null) goto L15;
        DevicePolicyManager r5 = (DevicePolicyManager) getSystemService(DevicePolicyManager.class);
        String r6 = getRestrictionFromIntent(r9);
        if (FlagsReflectionUtils.aapmApi() == false) goto L12;
        if (r5 == null) goto L12;
        if (r6 == null) goto L12;
        launchAdvancedProtectionDialogOrTryToSetAdminComponent(r5, r1, r6, r0);
    L12:
        Bundle r8 = r5.getEnforcingAdminAndUserDetails(r1, r6);
        if (r8 == null) goto L17;
        r0.component = (ComponentName) r8.getParcelable("android.app.extra.DEVICE_ADMIN", ComponentName.class);
    L17:
        if (r9.hasExtra("android.intent.extra.USER") == false) goto L19;
        r0.user = (UserHandle) r9.getParcelableExtra("android.intent.extra.USER", UserHandle.class);
    L25:
        return r0;
    L19:
        if (r8 == null) goto L22;
        r1 = r8.getInt("android.intent.extra.USER_ID", UserHandle.myUserId());
    L22:
        if (r1 != (-10000)) goto L24;
        r0.user = null;
        goto L25
    L24:
        r0.user = UserHandle.of(r1);
    L15:
        r8 = null;
        goto L17
    }

    private void launchAdvancedProtectionDialogOrTryToSetAdminComponent(DevicePolicyManager r3, int r4, String r5, RestrictedLockUtils.EnforcedAdmin r6) {
        EnforcingAdmin r7 = r3.getEnforcingAdmin(r4, r5);
        if (r7 != null) goto L6;
        return;
    L6:
        if ((r7.getAuthority() instanceof UnknownAuthority) == true) goto L8;
    L13:
        r6.component = r7.getComponentName();
        return;
    L8:
        if ("android.security.advancedprotection".equals(r7.getAuthority().getName()) == false) goto L13;
        if (((AdvancedProtectionManager) getSystemService(AdvancedProtectionManager.class)) != null) goto L12;
        return;
    L12:
        startActivityAsUser(AdvancedProtectionManager.createSupportIntentForPolicyIdentifierOrRestriction(r5, 0), UserHandle.of(r4));
        finish();
    }

    String getRestrictionFromIntent(Intent r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getStringExtra("android.app.extra.RESTRICTION");
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r1) {
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ActionDisabledByAdminDialog r1) {
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(ActionDisabledByAdminDialog r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ActionDisabledByAdminDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_enterprise_ActionDisabledByAdminDialog__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_BatchedActivityLancet_onResume(ActionDisabledByAdminDialog r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ActionDisabledByAdminDialog r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ActionDisabledByAdminDialog r5 = r4;
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
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ActionDisabledByAdminDialog r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_enterprise_ActionDisabledByAdminDialog__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_BatchedActivityLancet_onStop(ActionDisabledByAdminDialog r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onResume(ActionDisabledByAdminDialog r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ActionDisabledByAdminDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_enterprise_ActionDisabledByAdminDialog__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ActionDisabledByAdminDialog r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onPause(ActionDisabledByAdminDialog r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ActionDisabledByAdminDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_enterprise_ActionDisabledByAdminDialog__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ActionDisabledByAdminDialog r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ActionDisabledByAdminDialog r5 = r3;
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
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onStop(ActionDisabledByAdminDialog r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ActionDisabledByAdminDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_enterprise_ActionDisabledByAdminDialog__onStop$___twin___();
    }

    @Insert("onNewIntent")
    public static void com_android_settings_enterprise_ActionDisabledByAdminDialog_com_obric_hook_lancet_PrivacyHookActivity2_onNewIntent(ActionDisabledByAdminDialog r3, Intent r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ActionDisabledByAdminDialog r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r4);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_enterprise_ActionDisabledByAdminDialog__onNewIntent$___twin___(r4);
    }
}
