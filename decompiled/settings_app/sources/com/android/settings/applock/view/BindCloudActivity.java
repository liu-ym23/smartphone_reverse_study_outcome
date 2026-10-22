package com.android.settings.applock.view;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.settings.AppLockUtil;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BindCloudActivity extends BaseActivity {
    private static final String BYTEDANCE_ORIGIN_APP_TAG = "bytedance_origin_app_tag";
    private static final String CLOUD_SYNC_CLASS = "com.bytedanceos.accounts.AccountsActivity";
    private static final String CLOUD_SYNC_PACKAGE = "com.bytedanceos.cloudsync";
    private static final int REQUEST_CODE = 200;
    private static final String TO_LOGIN = "to_login";
    private static boolean sBindCloudSuccess;
    private boolean mFromBytedanceosLaunchpad;
    private boolean mNeedResult;

    public void com_android_settings_applock_view_BindCloudActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_applock_view_BindCloudActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_applock_view_BindCloudActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public BindCloudActivity() {
    }

    public void com_android_settings_applock_view_BindCloudActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.bind_cloud_layout);
        TextView r4 = (TextView) findViewById(R.id.login_content);
        if (AppLockUtil.isSmilingCloudLogin(this) == false) goto L5;
        r4.setText(R.string.cloud_Login_content);
    L6:
        this.mFromBytedanceosLaunchpad = getIntent().getBooleanExtra(AppLockUtil.FROM_BYTEDANCEOS_LAUNCHPAD, false);
        ((Button) findViewById(R.id.binding_clound)).setOnClickListener(new BindCloudActivity$$ExternalSyntheticLambda0(this));
        sBindCloudSuccess = false;
        return;
    L5:
        r4.setText(R.string.cloud_unLogin_content);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-applock-view-BindCloudActivity, reason: not valid java name */
    /* synthetic */ void m324x1f3ced20(View r1) {
        if (AppLockUtil.isSmilingCloudLogin(getBaseContext()) == false) goto L5;
        gotoPrivacyPasswordSetting();
        return;
    L5:
        this.mNeedResult = true;
        launchSmilingCloud();
    }

    public void launchSmilingCloud() {
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.MAIN");
        r0.setComponent(new ComponentName(CLOUD_SYNC_PACKAGE, CLOUD_SYNC_CLASS));
        r0.putExtra(BYTEDANCE_ORIGIN_APP_TAG, TO_LOGIN);
        startActivityForResult(r0, 200);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        this.mNeedResult = false;
        if (r2 != (-1)) goto L6;
        gotoPrivacyPasswordSetting();
        return;
    }

    private void gotoPrivacyPasswordSetting() {
        Intent r0 = new Intent(this, PrivacyPasswordSettingActivity.class);
        r0.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        r0.putExtra(AppLockUtil.FROM_BYTEDANCEOS_LAUNCHPAD, this.mFromBytedanceosLaunchpad);
        Utils.startActivity(this, r0, 2);
        sBindCloudSuccess = true;
    }

    public void com_android_settings_applock_view_BindCloudActivity__onStop$___twin___() {
        super.onStop();
        if (this.mNeedResult == true) goto L6;
        Utils.finishActivityDelay(this);
        return;
    }

    public void com_android_settings_applock_view_BindCloudActivity__onDestroy$___twin___() {
        super.onDestroy();
        if (sBindCloudSuccess == true) goto L6;
        AppLockUtil.sendPwdErrCodeBroadcast(this.mContext, this.mFromBytedanceosLaunchpad, 0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_applock_view_BindCloudActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BindCloudActivity r1) {
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onCreate(BindCloudActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BindCloudActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_applock_view_BindCloudActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(BindCloudActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(BindCloudActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        BindCloudActivity r5 = r4;
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
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(BindCloudActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_applock_view_BindCloudActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(BindCloudActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_applock_view_BindCloudActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onResume(BindCloudActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BindCloudActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_applock_view_BindCloudActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(BindCloudActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onPause(BindCloudActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BindCloudActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_applock_view_BindCloudActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(BindCloudActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        BindCloudActivity r5 = r3;
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
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onStop(BindCloudActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BindCloudActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_applock_view_BindCloudActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_applock_view_BindCloudActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(BindCloudActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BindCloudActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_applock_view_BindCloudActivity__onDestroy$___twin___();
    }
}
