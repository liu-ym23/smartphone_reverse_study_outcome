package com.android.settings.fingerprint;

import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.api.LayoutParamsSmt;
import bytedanceos.util.SidebarHelper;
import com.android.settings.AdaptConstants;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.ScreenBrightnessUtils;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsFeature;
import com.android.settings.serviceapi.IFingerprintService;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DeviceBrand;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.FingerprintEnrollProgressView;
import com.android.settings.widget.FrontFingerprintEnrollGuideAnimView;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.VibratorHelper;

/* JADX INFO: loaded from: classes2.dex */
public class FrontFingerprintEnrollingActivity extends BaseFingerprintEnrollingActivity implements FingerprintEnrollSidecar.Listener, FingerprintEnrollProgressView.Callback {
    private static final int DARWIN_FINGERPRINT_Y = 1516;
    private static final int DELTA_FINGERPRINT_Y = 1801;
    private static final float ENROLL_AREA_PRESS_H_MM = 13.956f;
    private static final float ENROLL_AREA_PRESS_W_MM = 15.506f;
    private static final int FINGERPRINT_ENROLL_DELAYED_TIME = 600;
    private static final int MAX_SCREENBRIGHTNESS = 255;
    private static final int SHOW_EDGE_PROGRESS_DELAYED_TIME = 700;
    private static float mScreenBrightness = -1.0f;
    private static int mSunshineScreenMode = -1;
    private int PACIFIC_FINGERPRINT_Y;
    private RelativeLayout mEnrollAreaContainer;
    private Runnable mEnrollRunnable;
    private FingerprintCallObserver mFingerprintObserver;
    private FrontFingerprintEnrollGuideAnimView mGuideAnimView;
    private boolean mIsWebviewLicenseShowing;
    private long mLastSetTime;
    protected TextView mLicenseTextView;
    private final Handler mMainThread;
    private PinObserver mPinObserver;
    private Runnable mRestoreDimRunnable;
    private final ContentObserver mScreenBrightnessChangeObs;
    private final ContentObserver mSunshineModeObs;
    private LinearLayout mTipsLayout;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mWindowParams;

    /* JADX INFO: renamed from: com.android.settings.fingerprint.FrontFingerprintEnrollingActivity$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
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

    static {
    }

    public void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getContentLayout() {
        return R.layout.fingerprint_enrolling_layout_front;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getCorrectImageResource() {
        return R.drawable.front_setting_fp_correct;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getErrorImageResource() {
        return R.drawable.front_setting_fp_error;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getSensorType() {
        return 2;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected boolean isFrontFingerPrint() {
        return true;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public FrontFingerprintEnrollingActivity() {
        this.PACIFIC_FINGERPRINT_Y = 0;
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.mMainThread = r1;
        this.mTipsLayout = null;
        this.mIsWebviewLicenseShowing = false;
        this.mScreenBrightnessChangeObs = new AnonymousClass4(this, r1);
        this.mSunshineModeObs = new AnonymousClass5(this, r1);
        this.mRestoreDimRunnable = new AnonymousClass7(this);
        this.mEnrollRunnable = new AnonymousClass8(this);
    }

    static /* synthetic */ void access$000(FrontFingerprintEnrollingActivity r0, boolean r1) {
        r0.showEnroll(r1);
    }

    static /* synthetic */ void access$100(FrontFingerprintEnrollingActivity r0) {
        r0.hideEnroll();
    }

    static /* synthetic */ boolean access$202(FrontFingerprintEnrollingActivity r0, boolean r1) {
        r0.mIsWebviewLicenseShowing = r1;
        return r1;
    }

    static /* synthetic */ float access$302(float r0) {
        mScreenBrightness = r0;
        return r0;
    }

    static /* synthetic */ RelativeLayout access$400(FrontFingerprintEnrollingActivity r0) {
        return r0.mEnrollAreaContainer;
    }

    static /* synthetic */ void access$500(FrontFingerprintEnrollingActivity r0, View r1) {
        r0.startEnterAnimation(r1);
    }

    static /* synthetic */ WindowManager.LayoutParams access$600(FrontFingerprintEnrollingActivity r0) {
        return r0.mWindowParams;
    }

    static /* synthetic */ WindowManager access$700(FrontFingerprintEnrollingActivity r0) {
        return r0.mWindowManager;
    }

    static /* synthetic */ long access$800(FrontFingerprintEnrollingActivity r2) {
        return r2.mLastSetTime;
    }

    static /* synthetic */ long access$802(FrontFingerprintEnrollingActivity r0, long r1) {
        r0.mLastSetTime = r1;
        return r1;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r2) {
        super.setContentView(r2);
        ((FrameLayout) findViewById(R.id.frame_layout)).addView(UIUtils.buildNoScaledView(this, R.layout.view_fingerprint_background));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == true) goto L5;
        hideEnroll();
        return;
    L5:
        if (this.mEnrollAreaContainer != null) goto L7;
        initParams();
        initEnrollArea();
    L7:
        showEnroll(true);
    }

    public void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onCreate$___twin___(Bundle r8) {
        sIsUserEnterPasswordSettings = true;
        super.onCreate(r8);
        SidebarHelper.getInstance().exitSidebar(0);
        this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        PinObserver r9 = new PinObserver(this, this.mHandler);
        this.mPinObserver = r9;
        r9.setOnPinListener(new AnonymousClass1(this));
        FingerprintCallObserver r10 = new FingerprintCallObserver(this, this.mHandler);
        this.mFingerprintObserver = r10;
        r10.setOnFingerCallListener(new AnonymousClass2(this));
        this.mTipsLayout = (LinearLayout) findViewById(R.id.tip_container);
        mScreenBrightness = ScreenBrightnessUtils.getScreenBrightness(this.mContext);
        mSunshineScreenMode = getScreenSunshineMode(this.mContext);
        ContentResolver r11 = this.mContext.getContentResolver();
        r11.registerContentObserver(Settings.System.getUriFor(AdaptConstants.SCREEN_BRIGHTNESS), false, this.mScreenBrightnessChangeObs);
        r11.registerContentObserver(Settings.System.getUriFor("sunshine_screen"), false, this.mSunshineModeObs);
        WindowManager.LayoutParams r12 = getWindow().getAttributes();
        LayoutParamsSmt.getInstance().add_bytedancePrivateFlag(r12, 16777216);
        getWindow().setAttributes(r12);
        float r13 = getResources().getDimension(R.dimen.pacific_fingerprint_center_y_mm);
        float r0 = getResources().getDimension(R.dimen.pacific_fingerprint_area_h_mm);
        OLog.e("BaseFingerprintEnrollingActivity", "CENTER_Y=" + r13 + ", AREA_H=" + r0 + ", PRESS_H=" + getResources().getDimension(R.dimen.pacific_fingerprint_press_h_mm) + ", PRESS_W=" + getResources().getDimension(R.dimen.pacific_fingerprint_press_w_mm));
        DisplayMetrics r1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(r1);
        int r2 = r1.heightPixels;
        this.PACIFIC_FINGERPRINT_Y = (int) (((double) (r13 - (r0 / 2.0f))) + 0.5d);
        OLog.e("BaseFingerprintEnrollingActivity", "PACIFIC_FINGERPRINT_Y= " + this.PACIFIC_FINGERPRINT_Y + ", screenY=" + r2);
        TextView r14 = (TextView) findViewById(R.id.license_text);
        this.mLicenseTextView = r14;
        if (r14 == null) goto L6;
        r14.setOnClickListener(new AnonymousClass3(this, this));
        return;
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

    public void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onResume$___twin___() {
        super.onResume();
        this.mIsWebviewLicenseShowing = false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        showEnroll(false);
    }

    public void updateWindowFlagByDim(boolean r5) {
        WindowManager.LayoutParams r1 = (WindowManager.LayoutParams) this.mEnrollAreaContainer.getLayoutParams();     // Catch: Exception -> L5
        float r2 = (mScreenBrightness * 1.0f) / 255.0f;     // Catch: Exception -> L5
        MultiSDKAdapter.updateWindowFlagByDim(r1, r5, r2);     // Catch: Exception -> L5
        this.mWindowManager.updateViewLayout(this.mEnrollAreaContainer, r1);     // Catch: Exception -> L5
        OLog.w("Enroll_FP", "updateWindowFlagByDim:" + r5 + " dimAmountForBrightness: " + r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private int getScreenSunshineMode(Context r2) {
        return Settings.System.getInt(r2.getContentResolver(), "sunshine_screen", -1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onStart$___twin___() {
        super.onStart();
        if (this.mEnrollAreaContainer != null) goto L5;
        initParams();
        initEnrollArea();
    L5:
        this.mPinObserver.registerObserver(true);
        this.mFingerprintObserver.registerObserver(true);
    }

    private void showEnroll(boolean r3) {
        Handler r0 = this.mHandler;
        Runnable r1 = new AnonymousClass6(this);
        if (r3 == false) goto L5;
        long r2 = 270;
    L6:
        r0.postDelayed(r1, r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    private void hideEnroll() {
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Exception -> L4
        this.mWindowManager.removeView(this.mEnrollAreaContainer);     // Catch: Exception -> L4
        Settings.Global.putInt(SettingsApplication.getContext().getContentResolver(), "SHOW_FINGERPRINT_ENROLL_ICON", 0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void startEnterAnimation(View r3) {
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{0.0f, 1.0f});
        r2.setDuration(200);
        r2.setInterpolator(new DecelerateInterpolator());
        r2.start();
    }

    private void initParams() {
        WindowManager.LayoutParams r6 = new WindowManager.LayoutParams(-1, -2, MultiSDKAdapter.ENROLL_WINDOW_TYPE, 25167112, -3);
        this.mWindowParams = r6;
        r6.setTitle("enroll_fingerprint");
        this.mWindowParams.gravity = 81;
        this.mWindowParams.packageName = this.mContext.getPackageName();
        Context r0 = UIUtils.buildNoScaledContext(this);
        float r1 = getFingerprintBottomMargin(r0);
        int r4 = 0;
        if (Settings.System.getInt(getContentResolver(), settings.Settings.Global.KEY_HIDE_NAVIGATION_BAR, 0) != 1) goto L5;
        boolean r2 = true;
    L7:
        if (Settings.Global.getInt(getContentResolver(), "navigationbar_trigger_mode", 2) != 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
        int r3 = 32;
    L12:
        r4 = UIUtils.dp2px(r0, r3);
    L16:
        this.mWindowParams.y = Math.round(UIUtils.verticalMm2px(r0, r1) - r4);
        LayoutParamsSmt.getInstance().setForbidMoveByThumb(this.mWindowParams, true);
        return;
    L13:
        if (r2 == true) goto L16;
        r3 = 16;
        goto L12
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    private float getFingerprintBottomMargin(Context r1) {
        IFingerprintService r0 = (IFingerprintService) ServiceManager.getService(IFingerprintService.class);
        if (r0 == null) goto L7;
        return r0.getFingerprintEnrollAreaBottomMargin(r1);
    L7:
        if (DeviceBrand.isNubia() == true) goto L9;
        return 26.55459f;
    L9:
        return (r1.getResources().getDisplayMetrics().density / 3.5f) * 31.199999f;
    }

    private void initEnrollArea() {
        Context r0 = UIUtils.buildNoScaledContext(this);
        RelativeLayout r1 = (RelativeLayout) UIUtils.buildNoScaledView(r0, R.layout.front_fingerprint_enroll_guide_anim_view_container_layout);
        this.mEnrollAreaContainer = r1;
        this.mGuideAnimView = (FrontFingerprintEnrollGuideAnimView) r1.findViewById(R.id.front_fps_enroll_guide_anim_view);
        ImageView r3 = (ImageView) this.mEnrollAreaContainer.findViewById(R.id.iv_normal_state);
        ViewGroup.LayoutParams r2 = r3.getLayoutParams();
        r2.width = Math.round(UIUtils.mm2PxHorizontal(r0, ENROLL_AREA_PRESS_W_MM));
        r2.height = Math.round(UIUtils.mm2PxVertical(r0, ENROLL_AREA_PRESS_H_MM));
        r3.setLayoutParams(r2);
        r3.requestLayout();
    }

    public void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onStop$___twin___() {
        super.onStop();
        this.mPinObserver.registerObserver(false);
        this.mFingerprintObserver.registerObserver(false);
    }

    private void handleFingerDown() {
        this.mIsFingerPressing = true;
        this.mGuideAnimView.postDelayed(this.mEnrollRunnable, 15);
    }

    private void handleFingerUp() {
        this.mIsFingerPressing = false;
        this.mGuideAnimView.removeCallbacks(this.mEnrollRunnable);
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
        int r0 = AnonymousClass9.$SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[this.mCurrentStep.ordinal()];
        if (r0 != 1) goto L11;
        setEnrollIconVisible();
        return;
    L11:
        if (r0 != 2) goto L13;
        setEnrollIconVisible();
        return;
    L13:
        if (r0 != 3) goto L15;
        return;
    L15:
        if (r0 != 4) goto L17;
        this.mEnrollAreaContainer.setVisibility(8);
        this.mTextTips.setText(R.string.fingerprint_enroll_done);
        this.mTextTips.setTextColor(getResources().getColor(R.color.oui_basic_text_1));
        return;
    L17:
        if (r0 == 5) goto L19;
        setEnrollIconVisible();
        return;
    L19:
        this.mEnrollAreaContainer.setVisibility(8);
        this.mTextTips.setVisibility(0);
        this.mLicenseTextView.setVisibility(0);
        return;
    L5:
        if (this.mCurrentStep != BaseFingerprintEnrollingActivity.STEP.INIT) goto L7;
        this.mLicenseTextView.setVisibility(0);
        goto L8
    L7:
        this.mLicenseTextView.setVisibility(8);
        goto L8
    }

    private void setEnrollIconVisible() {
        this.mEnrollAreaContainer.setVisibility(0);
        if (this.mGuideAnimView.getVisibility() == 0) goto L6;
        this.mGuideAnimView.setVisibility(0);
    L6:
        if (this.mCurrentStep != BaseFingerprintEnrollingActivity.STEP.INIT) goto L8;
        this.mGuideAnimView.playAnimation();
        return;
    L8:
        this.mGuideAnimView.reset();
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

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onEnrollmentHelp(int r1, CharSequence r2) {
        super.onEnrollmentHelp(r1, r2);
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
        this.mTextTips.startAnimation(getAlphaAnimation(1.0f, 0.0f, 200, 2));
        return;
    L10:
        return;
    L5:
        r9 = r8.toString();
        goto L7
    }

    public void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onDestroy$___twin___() {
        super.onDestroy();
        ContentResolver r0 = this.mContext.getContentResolver();
        r0.unregisterContentObserver(this.mScreenBrightnessChangeObs);
        r0.unregisterContentObserver(this.mSunshineModeObs);
        this.mMainThread.removeCallbacksAndMessages(null);
        hideEnroll();
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getDefaultTips() {
        if (SettingsFeature.isSupportNubiaShare() == false) goto L6;
        return R.string.enrolling_front_fp_enrolling_tip_for_sliding;
    L6:
        return R.string.enrolling_front_fp_enrolling_tip;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getDefaultIntroduction() {
        if (SettingsFeature.isSupportNubiaShare() == false) goto L6;
        return R.string.enrolling_front_fp_introduction_for_sliding;
    L6:
        return R.string.enrolling_front_fp_introduction;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(FrontFingerprintEnrollingActivity r1) {
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(FrontFingerprintEnrollingActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FrontFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(FrontFingerprintEnrollingActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(FrontFingerprintEnrollingActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        FrontFingerprintEnrollingActivity r5 = r4;
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
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(FrontFingerprintEnrollingActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(FrontFingerprintEnrollingActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStart(FrontFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FrontFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(FrontFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FrontFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(FrontFingerprintEnrollingActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(FrontFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FrontFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(FrontFingerprintEnrollingActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        FrontFingerprintEnrollingActivity r5 = r3;
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
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(FrontFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FrontFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_fingerprint_FrontFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(FrontFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        FrontFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_fingerprint_FrontFingerprintEnrollingActivity__onDestroy$___twin___();
    }
}
