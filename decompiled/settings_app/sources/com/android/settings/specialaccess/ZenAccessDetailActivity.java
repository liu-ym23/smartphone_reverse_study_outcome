package com.android.settings.specialaccess;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class ZenAccessDetailActivity extends BaseActivity {
    private static final String TAG = "ZenAccessDetailActivity";
    private SettingItemSwitch mCheckSwitch;
    private String mPackageName;

    public void com_android_settings_specialaccess_ZenAccessDetailActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_specialaccess_ZenAccessDetailActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_specialaccess_ZenAccessDetailActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_ZenAccessDetailActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ZenAccessDetailActivity() {
    }

    static /* synthetic */ String access$000(ZenAccessDetailActivity r0) {
        return r0.mPackageName;
    }

    public void com_android_settings_specialaccess_ZenAccessDetailActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.special_access_detail_activity);
        Intent r6 = getIntent();
        this.mPackageName = r6.getData().getSchemeSpecificPart();
        boolean r7 = r6.getBooleanExtra("zen_access", hasAccess(getBaseContext(), this.mPackageName));
        this.mBackView = ((OFloatingTitleBar) findViewById(R.id.view_title)).addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
        this.mBackView.setOnClickListener(new ZenAccessDetailActivity$$ExternalSyntheticLambda2(this));
        ((SettingItemSwitch) findViewById(R.id.item_switch)).setTitle(R.string.zen_access_detail_switch);
        ((TextView) findViewById(R.id.tv_desc)).setText(R.string.zen_access_warning_dialog_summary);
        SettingItemSwitch r0 = (SettingItemSwitch) findViewById(R.id.item_switch);
        this.mCheckSwitch = r0;
        r0.setChecked(r7);
        this.mCheckSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-specialaccess-ZenAccessDetailActivity, reason: not valid java name */
    /* synthetic */ void m607x4bb4f697(View r1) {
        finish();
    }

    public boolean hasAccess(Context r1, String r2) {
        return ((NotificationManager) r1.getSystemService(NotificationManager.class)).isNotificationPolicyAccessGrantedForPackage(r2);
    }

    public void setAccess(final Context r1, final String r2, final boolean r3) {
        AsyncTask.execute(new ZenAccessDetailActivity$$ExternalSyntheticLambda0(r1, r2, r3));
    }

    static /* synthetic */ void lambda$setAccess$1(Context r1, String r2, boolean r3) {
        ((NotificationManager) r1.getSystemService(NotificationManager.class)).setNotificationPolicyAccessGranted(r2, r3);
    }

    public static void deleteRules(final Context r1, final String r2) {
        AsyncTask.execute(new ZenAccessDetailActivity$$ExternalSyntheticLambda1(r1, r2));
    }

    static /* synthetic */ void lambda$deleteRules$2(Context r1, String r2) {
        ((NotificationManager) r1.getSystemService(NotificationManager.class)).removeAutomaticZenRules(r2);
    }

    public void com_android_settings_specialaccess_ZenAccessDetailActivity__finish$___twin___() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Standard);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ZenAccessDetailActivity r1) {
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ZenAccessDetailActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ZenAccessDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_specialaccess_ZenAccessDetailActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ZenAccessDetailActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ZenAccessDetailActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ZenAccessDetailActivity r5 = r4;
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
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ZenAccessDetailActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_ZenAccessDetailActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ZenAccessDetailActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onResume(ZenAccessDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ZenAccessDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_specialaccess_ZenAccessDetailActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ZenAccessDetailActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onPause(ZenAccessDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ZenAccessDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_specialaccess_ZenAccessDetailActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ZenAccessDetailActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ZenAccessDetailActivity r5 = r3;
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
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_onStop(ZenAccessDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ZenAccessDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_specialaccess_ZenAccessDetailActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_specialaccess_ZenAccessDetailActivity_com_obric_hook_lancet_PrivacyHook_finish(ZenAccessDetailActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ZenAccessDetailActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_specialaccess_ZenAccessDetailActivity__finish$___twin___();
    }
}
