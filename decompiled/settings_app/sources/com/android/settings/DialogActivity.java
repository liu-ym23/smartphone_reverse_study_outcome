package com.android.settings;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DialogActivity extends LifeHookActivity2 {
    public static final String DIALOG_EXTRA_PKG_NAME = "appPackageName";
    public static final int DIALOG_IDEA_PILLS_OFF = 5;
    public static final int DIALOG_IDEA_PILLS_SEARCH_OFF = 6;
    public static final int DIALOG_PHONE_CASE_DISABLED = 7;
    public static final int DIALOG_SETTING_PHONE_CASE_APP_NOT_FOND = 4;
    public static final int DIALOG_SHORTCUT_ENABLE_TALKBACK = 3;
    public static final int DIALOG_SHORTCUT_KEY_TIPS = 1;
    public static final int DIALOG_SMART_SCREEN_TIPS = 2;
    public static final String DIALOG_TYPE = "dialog_type";
    public static final int REQ_VERIFY_LAUNCHER_PASSWORD = 1000;
    private static final String TAG = "DialogActivity";
    private boolean mShouldFinishWhenDismiss;
    private AlertDialog mWarningDialog;

    /* JADX INFO: renamed from: com.android.settings.DialogActivity$7, reason: invalid class name */
    class AnonymousClass7 implements DialogInterface.OnClickListener {
        final /* synthetic */ DialogActivity this$0;
        final /* synthetic */ boolean val$enable;

        AnonymousClass7(DialogActivity r1, boolean r2) {
            this.this$0 = r1;
            this.val$enable = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            android.provider.Settings.Global.putInt(this.this$0.getContentResolver(), SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, this.val$enable ? 1 : 0);
        }
    }

    static {
    }

    public void com_android_settings_DialogActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_DialogActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_DialogActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_DialogActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // android.app.Activity
    public void finish() {
        com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_DialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_DialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_DialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_DialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_DialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DialogActivity() {
        this.mShouldFinishWhenDismiss = true;
    }

    static /* synthetic */ AlertDialog access$002(DialogActivity r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(DialogActivity r0) {
        return r0.mShouldFinishWhenDismiss;
    }

    static /* synthetic */ void access$200(DialogActivity r0) {
        r0.enableAccessibilityService();
    }

    static /* synthetic */ void access$300(DialogActivity r0, String r1) {
        r0.launchAppStoreForPackage(r1);
    }

    public void com_android_settings_DialogActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        int r5 = getIntent().getIntExtra(DIALOG_TYPE, -1);
        OLog.d(TAG, "create DialogActivity dialogType = " + r5);
        if (r5 != 2) goto L9;
        if (SettingsFeature.isSupportSmartScreenProtection() == true) goto L9;
        finish();
        return;
    L9:
        if (r5 != 3) goto L11;
        this.mShouldFinishWhenDismiss = false;
    L11:
        showWarningDialog(r5);
        setTitle(null);
    }

    private void showWarningDialog(int r5) {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        AlertDialog.Builder r1 = new AlertDialog.Builder(this);
        r1.setTitle(R.string.dlg_title_notice).setNegativeButton(android.R.string.cancel, null).setCancelable(false).setOnDismissListener(new AnonymousClass1(this));
        switch(r5) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L11;
            case 7: goto L12;
            default: goto L9;
        };
    L9:
        finish();
        return;
    L11:
        handlethinkboostDialog(r1, r5);
        goto L22
    L12:
        handlePhoneCase(r1, r5);
        goto L22
    L21:
        handleSmartScreen(r1, r5);
    L22:
        AlertDialog r6 = r1.create();
        this.mWarningDialog = r6;
        r6.show();
        return;
    L14:
        if ("com.android.launcher3".equals(Utils.getDefaultLauncherPkg(this)) == false) goto L17;
        enableAccessibilityService();
        finish();
        return;
    L17:
        r1.setTitle(R.string.launcher_switch_warning_title);
        r1.setMessage(R.string.launcher_force_switch_content_talkback);
        final boolean r7 = Utils.hasLockedPackages(getPackageManager());
        if (r7 == false) goto L20;
        r1.setMessage(R.string.launcher_force_switch_content_talkback_psw);
    L20:
        r1.setPositiveButton(android.R.string.ok, new AnonymousClass2(this, r7));
        r1.setNegativeButton(android.R.string.cancel, new AnonymousClass3(this));
        goto L22
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private AlertDialog.Builder handlethinkboostDialog(AlertDialog.Builder r4, int r5) {
        final Intent r0 = new Intent();
        r0.setClassName("com.bytedanceos.sara", "com.bytedanceos.sara.bubble.SettingActivity");
        r0.setAction("android.intent.action.MAIN");
        r4.setNegativeButton(R.string.cancel, null);
        r4.setTitle(R.string.dlg_title_notice);
        if (r5 != 5) goto L5;
        r4.setMessage(R.string.phone_case_idea_pills_off_dlg_tips);
    L9:
        r4.setPositiveButton(R.string.switch_on_text, new AnonymousClass4(this, this, r0));
        return r4;
    L5:
        if (r5 != 6) goto L9;
        r4.setMessage(R.string.phone_case_idea_pills_search_off_dlg_tips);
        goto L9
    }

    private AlertDialog.Builder handlePhoneCase(AlertDialog.Builder r6, int r7) {
        if (r7 != 7) goto L6;
        r6.setMessage(getString(R.string.phone_case_dlg_disable_by_usr));
        r6.setNegativeButton(R.string.cancel, null);
        r6.setTitle(R.string.dlg_title_notice);
        r6.setPositiveButton(R.string.dialog_positive_button_setup, new AnonymousClass5(this, this));
    L8:
        return r6;
    L6:
        if (r7 != 4) goto L8;
        final String r8 = getIntent().getStringExtra(DIALOG_EXTRA_PKG_NAME);
        r6.setMessage(getString(R.string.phone_case_shortcut_app_notfond_dlg, new Object[]{getAppLabel(r8)}));
        r6.setPositiveButton(R.string.install_text, new AnonymousClass6(this, r8));
        r6.setNegativeButton(R.string.cancel, null);
        goto L8
    }

    private AlertDialog.Builder handleSmartScreen(AlertDialog.Builder r1, int r2) {
        android.provider.Settings.Global.getInt(getContentResolver(), SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0);
        ImageView r0 = null;
        r0.getLayoutParams();
        throw null;
    }

    private void enableAccessibilityService() {
        List<AccessibilityServiceInfo> r0 = Utils.getInstalledSpeakingAccessibilityServices(this);
        if (r0.isEmpty() == false) goto L6;
        OLog.w(TAG, "no accessibility service fond");
        return;
    L6:
        OLog.d(TAG, "will switch to original launcher");
        android.provider.Settings.Global.putInt(getContentResolver(), "accessibility_speech_reading", 1);
        Utils.switchToOriginalLauncher(this);
        ServiceInfo r1 = r0.get(0).getResolveInfo().serviceInfo;
        Utils.enableAccessibilityService(this, new ComponentName(r1.packageName, r1.name).flattenToString(), true);
    }

    private void launchAppStoreForPackage(String r3) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(r3)));
    }

    private String getAppLabel(String r3) {
        int r0 = Arrays.asList(getResources().getStringArray(R.array.phone_case_quick_tools_app_pkg)).indexOf(r3);
        if (r0 > (-1)) goto L21;
        PreferenceMgr r2 = PreferenceMgr.getInstance(getApplicationContext());
        Locale r1 = Locale.getDefault();
        JSONObject r4 = new JSONObject(r2.getString(r3, "{}"));     // Catch: JSONException -> L14
        if (Locale.SIMPLIFIED_CHINESE.equals(r1) == false) goto L10;
        String r5 = r4.get(Constants.APP_LABELS_OF_ZH_CN).toString();     // Catch: JSONException -> L14
    L17:
        return r5;
    L10:
        if (Locale.TRADITIONAL_CHINESE.equals(r1) == false) goto L12;
        r5 = r4.get(Constants.APP_LABELS_OF_ZH_TW).toString();     // Catch: JSONException -> L14
        goto L17
    L12:
        r5 = r4.get(Constants.APP_LABELS_OF_EN_US).toString();     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L21:
        return getResources().getStringArray(R.array.phone_case_quick_tools_app_label)[r0 + 1];
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r3, int r4, Intent r5) {
        super.onActivityResult(r3, r4, r5);
        if (r3 == 1000) goto L5;
    L7:
        OLog.d(TAG, "request:" + r3 + ", resultCode " + r4);
        finish();
        return;
    L5:
        if (r4 != (-1)) goto L7;
        enableAccessibilityService();
        Utils.launchNewLauncher(this);
        goto L7
    }

    public void com_android_settings_DialogActivity__finish$___twin___() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DialogActivity r1) {
        com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(DialogActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_DialogActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(DialogActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_DialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DialogActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DialogActivity r5 = r4;
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
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DialogActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_DialogActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(DialogActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_DialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onResume(DialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_DialogActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DialogActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onPause(DialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_DialogActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DialogActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DialogActivity r5 = r3;
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
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_onStop(DialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_DialogActivity__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_DialogActivity_com_obric_hook_lancet_PrivacyHookActivity2_finish(DialogActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        DialogActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_DialogActivity__finish$___twin___();
    }
}
