package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.devicecredential.ConfirmDeviceCredentialActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmDeviceCredentialActivityNew extends LifeHookActivity2 {
    private static final int REQUEST_CONFIRMATION = 0;
    private static final String STATE_CONFIRMATION_ACTIVITY_LAUNCHED = "confirmation_activity_launched";
    public static final String TAG = "ConfirmDeviceCredentialActivityNew";
    private boolean mConfirmationActivityLaunched;

    public static class InternalActivityNew extends ConfirmDeviceCredentialActivityNew {
        public void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // com.android.settings.ConfirmDeviceCredentialActivityNew, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public InternalActivityNew() {
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(InternalActivityNew r1) {
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert("onCreate")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(InternalActivityNew r3, Bundle r4) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            InternalActivityNew r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onCreateWhenPrivacyNotOk(null);
            r0.onSuperCreate(null);
            return;
        L6:
            GrantUtil.INSTANCE.applicationInit();
            r3.com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onCreate$___twin___(r4);
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_BatchedActivityLancet_onResume(InternalActivityNew r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(InternalActivityNew r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
            OLog.i("AppLifecycle", "onResume_Activity " + r0);
            AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r1.recordVisibleTime(r0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
            InternalActivityNew r5 = r4;
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
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(InternalActivityNew r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_BatchedActivityLancet_onStop(InternalActivityNew r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @Insert("onResume")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onResume(InternalActivityNew r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            InternalActivityNew r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperResume();
            return;
        L6:
            r3.com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onResume$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(InternalActivityNew r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @Insert("onPause")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onPause(InternalActivityNew r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            InternalActivityNew r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperPause();
            return;
        L6:
            r3.com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onPause$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(InternalActivityNew r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
            OLog.i("AppLifecycle", "onCreate_Activity " + r0);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
            InternalActivityNew r5 = r3;
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
        public static void com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onStop(InternalActivityNew r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            InternalActivityNew r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperStop();
            return;
        L6:
            r3.com_android_settings_ConfirmDeviceCredentialActivityNew$InternalActivityNew__onStop$___twin___();
        }
    }

    static {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_ConfirmDeviceCredentialActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    public ConfirmDeviceCredentialActivityNew() {
    }

    public static Intent createIntent(CharSequence r3, CharSequence r4) {
        Intent r0 = new Intent();
        r0.setClassName("com.android.settings", ConfirmDeviceCredentialActivityNew.class.getName());
        r0.putExtra("android.app.extra.TITLE", r3);
        r0.putExtra("android.app.extra.DESCRIPTION", r4);
        return r0;
    }

    public static Intent createIntent(CharSequence r3, CharSequence r4, long r5) {
        Intent r0 = new Intent();
        r0.setClassName("com.android.settings", ConfirmDeviceCredentialActivityNew.class.getName());
        r0.putExtra("android.app.extra.TITLE", r3);
        r0.putExtra("android.app.extra.DESCRIPTION", r4);
        r0.putExtra("challenge", r5);
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        return r0;
    }

    public void com_android_settings_ConfirmDeviceCredentialActivityNew__onCreate$___twin___(Bundle r12) {
        super.onCreate(r12);
        if (r12 == null) goto L8;
        boolean r13 = r12.getBoolean(STATE_CONFIRMATION_ACTIVITY_LAUNCHED);
        this.mConfirmationActivityLaunched = r13;
        if (r13 == false) goto L8;
        return;
    L8:
        if (isFromTestActivity() == false) goto L12;
        routeToOriginActivity();
        return;
    L12:
        if (XTSUtils.isInXtsMode() == false) goto L15;
        routeToAospActivity();
        return;
    L15:
        Utils.setTranslucentStatusAndNavigation(getApplicationContext(), getWindow());
        Intent r14 = getIntent();
        String r0 = r14.getStringExtra("android.app.extra.TITLE");     // Catch: RuntimeException -> L40
        String r6 = r14.getStringExtra("android.app.extra.DESCRIPTION");     // Catch: RuntimeException -> L40
        int r1 = Utils.getCredentialOwnerUserId(this);
        if (isInternalActivity() == true) goto L43;
    L23:
        int r15 = r1;
    L24:
        boolean r2 = Utils.isManagedProfile(UserManager.get(this), r15);
        if (r0 != null) goto L28;
        if (r2 == false) goto L28;
        r0 = getTitleFromOrganizationName(r15);
    L28:
        String r5 = r0;
        ChooseLockSettingsHelper r3 = new ChooseLockSettingsHelper(this);
        LockPatternUtils r4 = new LockPatternUtils(this);
        if (r2 == true) goto L31;
    L35:
        boolean r16 = r3.launchConfirmationActivity(0, null, r5, r6, false, true, r15, 2);
    L36:
        this.mConfirmationActivityLaunched = r16;
        if (r16 == true) goto L47;
        OLog.d(TAG, "No pattern, password or PIN set.");
        setResult(-1);
        finish();
        return;
    L47:
        return;
    L31:
        if (isInternalActivity() == false) goto L35;
        if (r4.isSeparateProfileChallengeEnabled(r15) == true) goto L35;
        r16 = r3.launchConfirmationActivityWithExternalAndChallenge(0, null, r5, r6, true, 0, r15);
        goto L36
    L43:
        r15 = Utils.getUserIdFromBundle(this, r14.getExtras());     // Catch: SecurityException -> L21
    L21:
        e = move-exception;
        OLog.e(TAG, "Invalid intent extra", e);
    L40:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        r3.putBoolean(STATE_CONFIRMATION_ACTIVITY_LAUNCHED, this.mConfirmationActivityLaunched);
        super.onSaveInstanceState(r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    private boolean isFromTestActivity() {
        ComponentName r0 = getCallingActivity();
        if ((this instanceof InternalActivityNew) == true) goto L8;
        if (r0 == null) goto L8;
        if (r0.getClassName().contains("ConfirmDeviceCredentialTestActivity") == false) goto L8;
        return true;
    L8:
        return false;
    }

    private void routeToAospActivity() {
        Intent r0 = getIntent();
        Intent r1 = new Intent();
        r1.setClass(this, ConfirmDeviceCredentialActivity.class);
        if (isInternalActivity() == false) goto L5;
        r1.setClass(this, ConfirmDeviceCredentialActivity.InternalActivity.class);
    L5:
        r1.putExtras(r0);
        r1.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        startActivity(r1);
        finish();
        overridePendingTransition(0, 0);
    }

    private void routeToOriginActivity() {
        Intent r1 = new Intent(getIntent());
        r1.setClass(this, ConfirmDeviceCredentialActivity.class);
        r1.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        startActivity(r1);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        if (r5 != (-1)) goto L5;
        boolean r7 = true;
    L6:
        OLog.d(TAG, "Device credentials confirmed: " + r7);
        setResult(r5, r6);
        finish();
        return;
    L5:
        r7 = false;
        goto L6
    }

    private boolean isInternalActivity() {
        return this instanceof InternalActivityNew;
    }

    private String getTitleFromOrganizationName(int r2) {
        DevicePolicyManager r1 = (DevicePolicyManager) getSystemService("device_policy");
        if (r1 == null) goto L5;
        CharSequence r3 = r1.getOrganizationNameForUser(r2);
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.toString();
    L5:
        r3 = null;
        goto L6
    }

    @Insert("onCreate")
    public static void com_android_settings_ConfirmDeviceCredentialActivityNew_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(ConfirmDeviceCredentialActivityNew r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        ConfirmDeviceCredentialActivityNew r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ConfirmDeviceCredentialActivityNew__onCreate$___twin___(r4);
    }
}
