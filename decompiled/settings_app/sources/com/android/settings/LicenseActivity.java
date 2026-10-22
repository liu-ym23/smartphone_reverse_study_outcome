package com.android.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemProperties;
import android.webkit.WebView;
import com.android.settings.base.BaseActivity;
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
public class LicenseActivity extends BaseActivity {
    private static final String ASSETS_FILE_PREFIX = "file:///android_asset/";
    public static final String EXTRA_INFO_TYPE = "extra_info_type";
    public static final int INFO_TYPE_LEGAL_NOTICE = 3;
    public static final int INFO_TYPE_NATIONAL_CERTIFICATION = 6;
    public static final int INFO_TYPE_OPEN_SOURCE_LICENSE = 0;
    public static final int INFO_TYPE_PRIVACY_POLICY = 2;
    public static final int INFO_TYPE_SAFETY_INFORMATION = 5;
    public static final int INFO_TYPE_UE_LICENSE = 4;
    public static final int INFO_TYPE_USER_LICENSE = 1;
    private static final String LEGAL_NOTICE_DEF_FILE_NAME = "bytedance_os_legal_notice.html";
    private static final int LOADING_DLG_ID = 0;
    private static final String NATIONAL_CERTIFICATION_DEF_FILE_NAME = null;
    private static final String OPEN_SOURCE_LICENSE_DEF_FILE_NAME = "open_source_licenses.txt";
    private static final String PRIVACY_POLICY_DEF_FILE_NAME = "bytedance_os_privacy_policy.html";
    private static final String SAFETY_INFORMATION_LICENSE_DEF_FILE_NAME = "bytedance_os_safety_information.html";
    private static final String UE_PLAN_LICENSE_DEF_FILE_NAME = "bytedance_os_ue_plan_license.html";
    private static final String USER_LICENSE_DEF_FILE_NAME = "bytedance_os_user_license.html";
    private final String[] defFiles;
    private int infoType;
    private final int[] titleResArray;
    private WebView webview;

    public void com_android_settings_LicenseActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_LicenseActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_LicenseActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_LicenseActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_LicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_LicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_LicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_LicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_LicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public LicenseActivity() {
        this.titleResArray = new int[]{R.string.title_open_source_license, R.string.title_user_license_argeement, R.string.title_privacy_policy, R.string.title_legal_notice, R.string.user_experience_plan, R.string.title_national_certification};
        this.defFiles = new String[]{OPEN_SOURCE_LICENSE_DEF_FILE_NAME, USER_LICENSE_DEF_FILE_NAME, PRIVACY_POLICY_DEF_FILE_NAME, LEGAL_NOTICE_DEF_FILE_NAME, UE_PLAN_LICENSE_DEF_FILE_NAME, NATIONAL_CERTIFICATION_DEF_FILE_NAME};
    }

    static {
        if (SystemProperties.get("ro.housing.color").equals("white") == false) goto L5;
        String r0 = "certification_info_delta_white.png";
    L6:
        NATIONAL_CERTIFICATION_DEF_FILE_NAME = r0;
        return;
    L5:
        r0 = "certification_info_delta_black_green.png";
        goto L6
    }

    public void com_android_settings_LicenseActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LicenseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LicenseActivity r1) {
        com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(LicenseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LicenseActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(LicenseActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_LicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(LicenseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        LicenseActivity r5 = r4;
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
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(LicenseActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_LicenseActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(LicenseActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_LicenseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onResume(LicenseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_LicenseActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(LicenseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onPause(LicenseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_LicenseActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(LicenseActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        LicenseActivity r5 = r3;
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
    public static void com_android_settings_LicenseActivity_com_obric_hook_lancet_PrivacyHook_onStop(LicenseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LicenseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_LicenseActivity__onStop$___twin___();
    }
}
