package com.android.settings;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class FindPasswordWaysActivity extends BaseActivity implements View.OnClickListener {
    private static final String EMAIL_KEY = "bytedance_cloud_sync_display_name";
    private String mAnswer;
    private AlertDialog mDialog;
    private boolean mFromBytedanceosLauncher;
    private SettingItemText mItemEmail;
    private SettingItemText mItemQuestionSetting;
    private OButton mOkView;
    private String mQuestion;
    private int mQuestionIndex;
    private String password;

    public void com_android_settings_FindPasswordWaysActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_FindPasswordWaysActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FindPasswordWaysActivity() {
        this.mQuestionIndex = -1;
    }

    static /* synthetic */ String access$000(FindPasswordWaysActivity r0) {
        return r0.mQuestion;
    }

    static /* synthetic */ void access$100(FindPasswordWaysActivity r0) {
        r0.showPassWarningDialog();
    }

    static /* synthetic */ void access$200(FindPasswordWaysActivity r0) {
        r0.done();
    }

    static /* synthetic */ SettingItemText access$300(FindPasswordWaysActivity r0) {
        return r0.mItemEmail;
    }

    static /* synthetic */ void access$400(FindPasswordWaysActivity r0, SettingItemText r1, String r2) {
        r0.setupSettingItem(r1, r2);
    }

    static /* synthetic */ String access$500(FindPasswordWaysActivity r0) {
        return r0.getSelectedQuestion();
    }

    static /* synthetic */ void access$600(FindPasswordWaysActivity r0, String r1, String r2) {
        r0.updateOkButton(r1, r2);
    }

    public void com_android_settings_FindPasswordWaysActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        this.mFromBytedanceosLauncher = getIntent().getBooleanExtra(ChooseLockPassword.FROM_BYTEDANCEOS_LAUNCHER, false);
        setContentView(R.layout.find_password_ways_layout);
        SettingItemText r6 = (SettingItemText) findViewById(R.id.item_email);
        this.mItemEmail = r6;
        r6.setOnClickListener(this);
        SettingItemText r7 = (SettingItemText) findViewById(R.id.item_question_setting);
        this.mItemQuestionSetting = r7;
        r7.setOnClickListener(this);
        if (SettingsFeature.isSmilingCloudAvailable(this) == true) goto L5;
        this.mItemEmail.setVisibility(8);
        this.mItemQuestionSetting.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
    L5:
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.view_title);
        OButton r8 = (OButton) this.mTitle.addEndAction(R.string.find_password_setting_pass, -1, null);
        this.mOkView = r8;
        r8.setOnClickListener(new AnonymousClass1(this));
        setupBackBtnOnTitle(false);
        this.password = getIntent().getStringExtra("password");
        ContentResolver r9 = getContentResolver();
        Uri r0 = android.provider.Settings.System.getUriFor(EMAIL_KEY);
        final Handler r3 = new Handler();
        r9.registerContentObserver(r0, false, new AnonymousClass2(this, r3));
    }

    public void com_android_settings_FindPasswordWaysActivity__onResume$___twin___() {
        super.onResume();
        String r0 = getEmailAddress(this);
        setupSettingItem(this.mItemEmail, r0);
        if (this.mQuestion != null) goto L5;
        String r1 = getSelectedQuestion();
        this.mQuestion = r1;
        setupSettingItem(this.mItemQuestionSetting, r1);
    L5:
        updateOkButton(r0, this.mQuestion);
    }

    private void showPassWarningDialog() {
        if (this.mDialog != null) goto L6;
        this.mDialog = new AlertDialog.Builder(this).setTitle(R.string.find_password_setting_pass).setMessage(R.string.find_password_ways_unset_msg).setNegativeButton(R.string.cancel, new AnonymousClass5(this)).setOnCancelListener(new AnonymousClass4(this)).setPositiveButton(R.string.ok, new AnonymousClass3(this)).create();
    L6:
        if (this.mDialog.isShowing() == true) goto L9;
        this.mDialog.show();
        return;
    }

    private void updateOkButton(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
    L7:
        this.mOkView.setText(R.string.done);
        return;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        this.mOkView.setText(R.string.find_password_setting_pass);
    }

    private void setupSettingItem(SettingItemText r3, String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r3.setSummary(r4);
        r3.setSubTitle(null);
        r3.setArrowVisible(false);
        r3.setOnClickListener(null);
        r3.setClickable(false);
        r3.setFocusable(false);
        return;
    L5:
        r3.setSubTitle(R.string.unset);
        r3.setSummary(null);
        r3.setArrowVisible(true);
        r3.setOnClickListener(this);
        r3.setClickable(true);
        r3.setFocusable(true);
    }

    private void done() {
        if (TextUtils.isEmpty(this.mAnswer) == true) goto L5;
        FindPasswordQuestionSettings.saveAnswer(this, this.mAnswer);
    L5:
        int r0 = this.mQuestionIndex;
        if (r0 < 0) goto L8;
        FindPasswordQuestionSettings.saveSelectedQuestionIndex(this, r0);
    L8:
        FindPasswordQuestionSettings.savePassword(this, this.password);
        if (getEmailAddress(this) == null) goto L11;
        SendPassword.launch(this, -1, -1);
    L11:
        setResult(-1);
        finish();
    }

    public void com_android_settings_FindPasswordWaysActivity__onPause$___twin___() {
        super.onPause();
        this.mItemQuestionSetting.setOnClickListener(null);
        this.mItemEmail.setOnClickListener(null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 != (-1)) goto L13;
        if (r2 != 0) goto L14;
        if (r4 == null) goto L15;
        this.mQuestionIndex = r4.getIntExtra(FindPasswordQuestionSettings.EXTRA_QUESTION_INDEX, -1);
        this.mAnswer = r4.getStringExtra(FindPasswordQuestionSettings.EXTRA_ANSWER);
        this.mQuestion = getResources().getStringArray(R.array.find_password_questions)[this.mQuestionIndex];
        if (TextUtils.isEmpty(this.mAnswer) == false) goto L9;
    L11:
        updateOkButton(getEmailAddress(this), this.mQuestion);
        return;
    L9:
        if (TextUtils.isEmpty(this.mQuestion) == true) goto L11;
        setupSettingItem(this.mItemQuestionSetting, this.mQuestion);
        goto L11
    L15:
        return;
    L14:
        return;
    }

    public static String getEmailAddress(Context r1) {
        String r2 = android.provider.Settings.System.getString(r1.getContentResolver(), EMAIL_KEY);
        if (isEmail(r2) == false) goto L5;
        return r2;
    L5:
        return null;
    }

    private static boolean isEmail(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return Patterns.EMAIL_ADDRESS.matcher(r1).matches();
    }

    private String getSelectedQuestion() {
        return AppLockUtil.getSelectedQuestion(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mItemEmail) goto L6;
        launchSmilingCloud(this, !this.mFromBytedanceosLauncher);
        return;
    L6:
        if (r2 != this.mItemQuestionSetting) goto L10;
        gotoSettingFindPasswordQuestion();
        return;
    }

    public static void launchSmilingCloud(Context r3, boolean r4) {
        OLog.d("Settings", "fromSettings " + r4);
        Intent r0 = new Intent();
        r0.setClassName("com.bytedanceos.cloudsync", "com.bytedanceos.accounts.AccountsActivity");
        if (r4 == false) goto L5;
        String r5 = "register_login_from_settings";
    L6:
        r0.putExtra("bytedance_origin_app_tag", r5);
        r0.putExtra("back_text", "find_password");
        Utils.startActivity(r3, r0);
        return;
    L5:
        r5 = "register_login";
        goto L6
    }

    private void gotoSettingFindPasswordQuestion() {
        Intent r0 = new Intent(this, FindPasswordQuestionSettingsActivity.class);
        r0.putExtra("back_text_id", R.string.find_password_way_title);
        r0.putExtra(ChooseLockPassword.FROM_BYTEDANCEOS_LAUNCHER, this.mFromBytedanceosLauncher);
        r0.putExtra("password", this.password);
        startActivityForResult(r0, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FindPasswordWaysActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FindPasswordWaysActivity r1) {
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onCreate(FindPasswordWaysActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordWaysActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_FindPasswordWaysActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(FindPasswordWaysActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FindPasswordWaysActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FindPasswordWaysActivity r5 = r4;
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
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FindPasswordWaysActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_FindPasswordWaysActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(FindPasswordWaysActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_FindPasswordWaysActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onResume(FindPasswordWaysActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordWaysActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_FindPasswordWaysActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FindPasswordWaysActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onPause(FindPasswordWaysActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordWaysActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_FindPasswordWaysActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FindPasswordWaysActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FindPasswordWaysActivity r5 = r3;
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
    public static void com_android_settings_FindPasswordWaysActivity_com_obric_hook_lancet_PrivacyHook_onStop(FindPasswordWaysActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordWaysActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_FindPasswordWaysActivity__onStop$___twin___();
    }
}
