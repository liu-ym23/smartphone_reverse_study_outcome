package com.android.settings.fingerprint;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewKt;
import bytedanceos.util.SidebarHelper;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.RegisterUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.AIPoweredFingerprintGuideAnimView;
import com.android.settings.widget.FingerprintEnrollProgressView;
import com.android.settings.widget.FrontFingerprintAnimView;
import com.android.settingslib.widget.LottieColorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.VibratorHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AIPoweredFingerprintEnrollingActivity extends BaseFingerprintEnrollingActivity implements FingerprintEnrollSidecar.Listener, FingerprintEnrollProgressView.Callback {
    private AIPoweredFingerprintGuideAnimView mAIKeyGuideAnimView;
    private TextView mIntroductionSubTipTv;
    private boolean mIsWebviewLicenseShowing;
    protected TextView mLicenseTextView;
    private final Handler mMainThread;
    private PinObserver mPinObserver;

    /* JADX INFO: renamed from: com.android.settings.fingerprint.AIPoweredFingerprintEnrollingActivity$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP = null;

        static {
            int[] r0 = new int[BaseFingerprintEnrollingActivity.STEP.values().length];
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP = r0;
            r0[BaseFingerprintEnrollingActivity.STEP.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[BaseFingerprintEnrollingActivity.STEP.ENROLLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[BaseFingerprintEnrollingActivity.STEP.ENROLLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[BaseFingerprintEnrollingActivity.STEP.DONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[BaseFingerprintEnrollingActivity.STEP.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getContentLayout() {
        return R.layout.ai_powered_fingerprint_enrolling_layout;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getCorrectImageResource() {
        return R.drawable.front_setting_fp_correct;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getDefaultIntroduction() {
        return R.string.enrolling_ai_powered_fp_introduction;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getDefaultTips() {
        return R.string.enrolling_ai_powered_fp_enrolling_tip;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getErrorImageResource() {
        return R.drawable.front_setting_fp_error;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getSensorType() {
        return 4;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected boolean isFrontFingerPrint() {
        return true;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected boolean needInterceptEnrollmentHelp(int r1, CharSequence r2) {
        if (r1 != 1102) goto L5;
        return true;
    L5:
        if (r1 == 1103) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public AIPoweredFingerprintEnrollingActivity() {
        this.mMainThread = new Handler(Looper.getMainLooper());
        this.mIsWebviewLicenseShowing = false;
    }

    static /* synthetic */ boolean access$002(AIPoweredFingerprintEnrollingActivity r0, boolean r1) {
        r0.mIsWebviewLicenseShowing = r1;
        return r1;
    }

    static /* synthetic */ AIPoweredFingerprintGuideAnimView access$100(AIPoweredFingerprintEnrollingActivity r0) {
        return r0.mAIKeyGuideAnimView;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r2) {
        super.setContentView(r2);
        ((FrameLayout) findViewById(R.id.frame_layout)).addView(UIUtils.buildNoScaledView(this, R.layout.view_ai_fingerprint_background));
    }

    public void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onCreate$___twin___(Bundle r2) {
        sIsUserEnterPasswordSettings = true;
        super.onCreate(r2);
        SidebarHelper.getInstance().exitSidebar(0);
        PinObserver r3 = new PinObserver(this, this.mHandler);
        this.mPinObserver = r3;
        r3.setOnPinListener(new AnonymousClass1(this));
        FrontFingerprintAnimView r4 = this.mFingerprintAnimView;
        if (LottieColorUtils.isDarkMode(this.mContext.getApplicationContext()) == false) goto L5;
        int r0 = R.drawable.ai_powered_front_fingerprint_enroll_init_dark;
    L6:
        r4.setIntroductionImage(r0);
        this.mIntroductionSubTipTv = (TextView) findViewById(R.id.introduction_sub_tip);
        this.mLicenseTextView = (TextView) findViewById(R.id.license_text);
        if (this.fromProvision == false) goto L9;
        this.mLicenseTextView.setVisibility(8);
    L9:
        this.mAIKeyGuideAnimView = (AIPoweredFingerprintGuideAnimView) findViewById(R.id.ai_key_guide_anim_view);
        TextView r5 = this.mLicenseTextView;
        if (r5 == null) goto L13;
        r5.setOnClickListener(new AnonymousClass2(this, this));
        return;
    L13:
        return;
    L5:
        r0 = R.drawable.ai_powered_front_fingerprint_enroll_init;
        goto L6
    }

    @Override // com.android.settings.base.BaseActivity
    protected boolean isInsideWebView(ComponentName r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (this.mIsWebviewLicenseShowing == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r3.getPackageName(), "com.android.provision") == true) goto L10;
        return false;
    L10:
        if (TextUtils.equals(r3.getClassName(), "com.android.provision.webview.CustomWebViewActivity") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onStart$___twin___() {
        super.onStart();
        RegisterUtils.registerSafely("BaseFingerprintEnrollingActivity_mPinObserver", new AIPoweredFingerprintEnrollingActivity$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$onStart$0$com-android-settings-fingerprint-AIPoweredFingerprintEnrollingActivity, reason: not valid java name */
    /* synthetic */ Unit m461xc1e291ec() {
        this.mPinObserver.registerObserver(true);
        return Unit.INSTANCE;
    }

    public void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onStop$___twin___() {
        super.onStop();
        RegisterUtils.unRegisterSafely("BaseFingerprintEnrollingActivity_mPinObserver", new AIPoweredFingerprintEnrollingActivity$$ExternalSyntheticLambda1(this));
        if (this.mCurrentStep == BaseFingerprintEnrollingActivity.STEP.DONE) goto L6;
        uploadAddResultEvent(this.mCurrentStep);
        return;
    }

    /* JADX INFO: renamed from: lambda$onStop$1$com-android-settings-fingerprint-AIPoweredFingerprintEnrollingActivity, reason: not valid java name */
    /* synthetic */ Unit m462x405321b3() {
        this.mPinObserver.registerObserver(false);
        return Unit.INSTANCE;
    }

    public void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onResume$___twin___() {
        super.onResume();
        this.mIsWebviewLicenseShowing = false;
    }

    private void handleFingerDown() {
        this.mIsFingerPressing = true;
    }

    private void handleFingerUp() {
        this.mIsFingerPressing = false;
        this.mHandler.removeMessages(1);
        if (TextUtils.equals(getString(R.string.finger_up_tips), this.mTextTips.getText().toString()) == false) goto L6;
        clearTipsAnimation();
        String r0 = getString(getDefaultTips());
        this.mTextTips.setText(r0);
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        return;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected void updateUI() {
        super.updateUI();
        OLog.i("BaseFingerprintEnrollingActivity", "updateUI mCurrentStep: " + this.mCurrentStep);
        if (this.mLicenseTextView != null) goto L5;
    L8:
        int r0 = AnonymousClass5.$SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[this.mCurrentStep.ordinal()];
        if (r0 != 1) goto L11;
        showIntroductionSubTipTv();
        playGuideAnimation();
        return;
    L11:
        if (r0 != 2) goto L13;
        hideIntroductionSubTipTv();
        resetGuideAnimation(false);
        return;
    L13:
        if (r0 != 3) goto L15;
        resetGuideAnimation(false);
        return;
    L15:
        if (r0 != 4) goto L17;
        this.mTextTips.setText(R.string.fingerprint_enroll_done);
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        resetGuideAnimation(true);
        uploadAddResultEvent(BaseFingerprintEnrollingActivity.STEP.DONE);
        return;
    L17:
        if (r0 == 5) goto L19;
        showIntroductionSubTipTv();
        return;
    L19:
        this.mTextTips.setVisibility(0);
        this.mLicenseTextView.setVisibility(0);
        resetGuideAnimation(false);
        hideIntroductionSubTipTv();
        return;
    L5:
        if (this.mCurrentStep != BaseFingerprintEnrollingActivity.STEP.INIT) goto L7;
        this.mLicenseTextView.setVisibility(0);
        goto L8
    L7:
        this.mLicenseTextView.setVisibility(8);
        goto L8
    }

    private void showIntroductionSubTipTv() {
        TextView r1 = this.mIntroductionSubTipTv;
        if (r1 == null) goto L6;
        r1.setVisibility(0);
        return;
    }

    private void hideIntroductionSubTipTv() {
        TextView r1 = this.mIntroductionSubTipTv;
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }

    private void playGuideAnimation() {
        AIPoweredFingerprintGuideAnimView r0 = this.mAIKeyGuideAnimView;
        if (r0 == null) goto L6;
        ViewKt.updateLayoutParams(r0, new AnonymousClass3(this));
        this.mAIKeyGuideAnimView.playAnimation();
        this.mAIKeyGuideAnimView.setVisibility(0);
        return;
    }

    private void resetGuideAnimation(boolean r3) {
        AIPoweredFingerprintGuideAnimView r0 = this.mAIKeyGuideAnimView;
        if (r0 == null) goto L10;
        ViewKt.updateLayoutParams(r0, new AnonymousClass4(this));
        this.mAIKeyGuideAnimView.reset();
        AIPoweredFingerprintGuideAnimView r2 = this.mAIKeyGuideAnimView;
        if (r3 == false) goto L7;
        int r4 = 8;
    L8:
        r2.setVisibility(r4);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onEnrollmentProgressChange(int r1, int r2) {
        super.onEnrollmentProgressChange(r1, r2);
        if (r2 != 0) goto L5;
        VibratorHelper.INSTANCE.confirm(this);
        return;
    L5:
        VibratorHelper.INSTANCE.rigid(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected boolean needInterceptEnrollmentError(int r1, CharSequence r2) {
        if (this.mCurrentStep != BaseFingerprintEnrollingActivity.STEP.DONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onUdfpsPointerDown(int r2) {
        super.onUdfpsPointerDown(r2);
        OLog.i("BaseFingerprintEnrollingActivity", "onUdfpsPointerDown handleFingerDown");
        handleFingerDown();
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onUdfpsPointerUp(int r2) {
        super.onUdfpsPointerUp(r2);
        OLog.i("BaseFingerprintEnrollingActivity", "onUdfpsPointerUp handleFingerUp");
        handleFingerUp();
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected void updateTipsView(int r7, CharSequence r8) {
        OLog.i("BaseFingerprintEnrollingActivity", "updateTipsView: " + r7 + ", " + r8);
        this.mHandler.removeMessages(1);
        if (r8 != null) goto L5;
        String r9 = "";
    L7:
        if (TextUtils.isEmpty(r9) == true) goto L10;
        clearTipsAnimation();
        this.mTextTips.setText(r9);
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        hideIntroductionSubTipTv();
        this.mTextTips.startAnimation(getAlphaAnimation(1.0f, 0.0f, 200, 2));
        return;
    L10:
        return;
    L5:
        r9 = r8.toString();
        goto L7
    }

    public void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onDestroy$___twin___() {
        super.onDestroy();
        this.mMainThread.removeCallbacksAndMessages(null);
    }

    private void uploadAddResultEvent(BaseFingerprintEnrollingActivity.STEP r7) {
        if (this.fromProvision == false) goto L6;
        String r0 = "obric_os_onboarding";
    L10:
        if (this.mCurrentStep != BaseFingerprintEnrollingActivity.STEP.ENROLLING) goto L12;
    L13:
        HashMap r6 = new HashMap();
        r6.put("enter_from", r0);
        r6.put("record_result", "fail");
        TrackerEvent.uploadEvent("obric_ai_fingerprint_result", r6);
    L15:
        if (r7 != BaseFingerprintEnrollingActivity.STEP.DONE) goto L18;
        HashMap r8 = new HashMap();
        r8.put("enter_from", r0);
        r8.put("record_result", "succ");
        TrackerEvent.uploadEvent("obric_ai_fingerprint_result", r8);
        return;
    L18:
        return;
    L12:
        if (this.mCurrentStep != BaseFingerprintEnrollingActivity.STEP.ERROR) goto L15;
    L6:
        if (this.fromAssistant == false) goto L8;
        r0 = "obric_assistant_onboarding";
        goto L10
    L8:
        r0 = "";
        goto L10
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AIPoweredFingerprintEnrollingActivity r1) {
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(AIPoweredFingerprintEnrollingActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AIPoweredFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(AIPoweredFingerprintEnrollingActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(AIPoweredFingerprintEnrollingActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        AIPoweredFingerprintEnrollingActivity r5 = r4;
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
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(AIPoweredFingerprintEnrollingActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(AIPoweredFingerprintEnrollingActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStart(AIPoweredFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AIPoweredFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(AIPoweredFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AIPoweredFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(AIPoweredFingerprintEnrollingActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(AIPoweredFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AIPoweredFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(AIPoweredFingerprintEnrollingActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        AIPoweredFingerprintEnrollingActivity r5 = r3;
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
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(AIPoweredFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AIPoweredFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(AIPoweredFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        AIPoweredFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_fingerprint_AIPoweredFingerprintEnrollingActivity__onDestroy$___twin___();
    }
}
