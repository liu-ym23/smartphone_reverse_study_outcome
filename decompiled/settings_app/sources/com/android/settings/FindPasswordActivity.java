package com.android.settings;

import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
public class FindPasswordActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    private EditText mAnswer;
    private DevicePolicyManager mDPM;
    private View mOkButton;
    private TextView mQuestion;
    private ImageView mWarningIcon;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void com_android_settings_FindPasswordActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_FindPasswordActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FindPasswordActivity() {
    }

    public void com_android_settings_FindPasswordActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.find_password_activity);
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mQuestion = (TextView) findViewById(R.id.question);
        this.mAnswer = (EditText) findViewById(R.id.answer);
        this.mWarningIcon = (ImageView) findViewById(R.id.icon_wrong_warning);
        this.mAnswer.addTextChangedListener(this);
        View r5 = this.mTitle.addEndAction(R.drawable.standard_icon_complete_selector, -1, null);
        this.mOkButton = r5;
        r5.setOnClickListener(this);
        View r6 = this.mOkButton;
        if (this.mAnswer.getText().length() == 0) goto L5;
        boolean r0 = true;
    L6:
        r6.setEnabled(r0);
        setupBackBtnOnTitle(false);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void com_android_settings_FindPasswordActivity__onResume$___twin___() {
        super.onResume();
        String r0 = AppLockUtil.getSelectedQuestion(this);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        finish();
        return;
    L6:
        this.mQuestion.setText(r0);
    }

    public void com_android_settings_FindPasswordActivity__onPause$___twin___() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mOkButton) goto L11;
        String r3 = this.mAnswer.getText().toString();
        if (r3.length() != 0) goto L7;
        return;
    L7:
        if (AppLockUtil.checkAnswer(this, r3) == false) goto L9;
        gotoResetAppLockWithoutConfirm();
        setResult(-1);
        finish();
        return;
    L9:
        Utils.showShortToast(this, getString(R.string.find_password_answer_wrong));
        showWarningIcon(true);
        return;
    }

    private void gotoResetAppLockWithoutConfirm() {
        LockScreenFragment.gotoChooseEasyPassword(this, this.mDPM, 6, -1, true);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        View r2 = this.mOkButton;
        if (this.mAnswer.getText().length() == 0) goto L5;
        boolean r0 = true;
    L6:
        r2.setEnabled(r0);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        showWarningIcon(false);
    }

    private void showWarningIcon(boolean r1) {
        ImageView r0 = this.mWarningIcon;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FindPasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FindPasswordActivity r1) {
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onCreate(FindPasswordActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_FindPasswordActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(FindPasswordActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FindPasswordActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FindPasswordActivity r5 = r4;
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
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FindPasswordActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_FindPasswordActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(FindPasswordActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_FindPasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onResume(FindPasswordActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_FindPasswordActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FindPasswordActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onPause(FindPasswordActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_FindPasswordActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FindPasswordActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FindPasswordActivity r5 = r3;
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
    public static void com_android_settings_FindPasswordActivity_com_obric_hook_lancet_PrivacyHook_onStop(FindPasswordActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FindPasswordActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_FindPasswordActivity__onStop$___twin___();
    }
}
