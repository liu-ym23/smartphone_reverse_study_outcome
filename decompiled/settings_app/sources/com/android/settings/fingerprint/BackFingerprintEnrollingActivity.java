package com.android.settings.fingerprint;

import android.app.AlertDialog;
import android.content.Intent;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.settings.InvisibleApi;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.BaseFingerprintAnimView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BackFingerprintEnrollingActivity extends BaseFingerprintEnrollingActivity implements FingerprintEnrollSidecar.Listener, BaseFingerprintAnimView.Callback {
    View mEnrollingLayout;
    LinearLayout mFindSensorLayout;
    private TextView mSetupForPayment;
    private AlertDialog mSetupForPaymentDialog;
    TextView mTextProgress;

    /* JADX INFO: renamed from: com.android.settings.fingerprint.BackFingerprintEnrollingActivity$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP = null;

        static {
            int[] r0 = new int[BaseFingerprintEnrollingActivity.STEP.values().length];
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP = r0;
            r0[BaseFingerprintEnrollingActivity.STEP.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[BaseFingerprintEnrollingActivity.STEP.ENROLLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[BaseFingerprintEnrollingActivity.STEP.DONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[BaseFingerprintEnrollingActivity.STEP.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public void com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_fingerprint_BackFingerprintEnrollingActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getContentLayout() {
        return R.layout.fingerprint_enrolling_layout_back;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getCorrectImageResource() {
        return R.drawable.setting_fp_correct;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getDefaultTips() {
        return R.string.enroll_fingerprint_tips;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected int getErrorImageResource() {
        return R.drawable.setting_fp_error;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected boolean isFrontFingerPrint() {
        return false;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.ConfirmLockBaseActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity, com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public BackFingerprintEnrollingActivity() {
    }

    static /* synthetic */ void access$000(BackFingerprintEnrollingActivity r0) {
        r0.showSetupForPaymentDialog();
    }

    static /* synthetic */ void access$100(BackFingerprintEnrollingActivity r0) {
        r0.gotoSetupForPayment();
    }

    public void com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mFindSensorLayout = (LinearLayout) findViewById(R.id.find_sensor_layout);
        this.mEnrollingLayout = findViewById(R.id.enrolling_layout);
        this.mTextProgress = (TextView) findViewById(R.id.progress_text);
        this.mSetupForPayment = (TextView) findViewById(R.id.setup_for_payment);
        setSetupForPaymentTextView();
        TextView r0 = (TextView) findViewById(R.id.tv_find_sensor_tips);
        r0.setGravity(1);
        if (SettingsFeature.isFingerprintSensorInBackside() == false) goto L6;
        r0.setText(R.string.find_sensor_from_back_tips);
        return;
    }

    private void setSetupForPaymentTextView() {
        if (this.mSetupForPayment != null) goto L6;
        return;
    L6:
        if (this.mIsFromSetupWizard == false) goto L8;
    L17:
        this.mSetupForPayment.setVisibility(4);
        return;
    L8:
        if (isFingerprintEnrolled() == false) goto L17;
        if (areAllPaymentWaysFingerprintSetted() == true) goto L17;
        this.mSetupForPayment.setVisibility(0);
        if (TextUtils.isEmpty(this.mSetupForPayment.getText()) == true) goto L15;
        return;
    L15:
        String r0 = getString(R.string.fingerprint_setup_for_payment) + "\n";
        SpannableString r1 = SpannableString.valueOf(r0 + getString(R.string.learn_more));
        r1.setSpan(new AnonymousClass1(this), r0.length(), r1.length(), 33);
        this.mSetupForPayment.setText(r1);
        this.mSetupForPayment.setHighlightColor(getResources().getColor(android.R.color.transparent));
        this.mSetupForPayment.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private boolean areAllPaymentWaysFingerprintSetted() {
        FingerprintManager r0 = (FingerprintManager) getSystemService("fingerprint");
        List r1 = new ArrayList();
        if (r0 == null) goto L9;
        r1 = r0.getEnrolledFingerprints();
        if (r1 != null) goto L7;
    L8:
        return false;
    L7:
        if (r1.isEmpty() == true) goto L8;
    L9:
        Iterator r2 = r1.iterator();
        boolean r3 = false;
        boolean r4 = false;
    L11:
        if (r2.hasNext() == false) goto L24;
        String r5 = Settings.Global.getString(getContentResolver(), "quick_app_via_fingerprint_id_" + InvisibleApi.getFingerId((Fingerprint) r2.next()));
        if (r5 == null) goto L11;
        if (r5.contains("com.eg.android.AlipayGphone") == false) goto L19;
        r3 = true;
    L21:
        if (r3 == false) goto L11;
        if (r4 == false) goto L11;
        return true;
    L19:
        if (r5.contains("com.tencent.mm") == false) goto L21;
        r4 = true;
        goto L21
    L24:
        return false;
    }

    private void showSetupForPaymentDialog() {
        if (this.mSetupForPaymentDialog != null) goto L6;
        this.mSetupForPaymentDialog = new AlertDialog.Builder(this).setTitle(R.string.quick_pay_via_fingerprint).setView(R.layout.dialog_fingerprint_payment).setNegativeButton(R.string.close, null).setPositiveButton(R.string.goto_setup, new AnonymousClass2(this)).create();
    L6:
        if (this.mSetupForPaymentDialog.isShowing() == true) goto L9;
        this.mSetupForPaymentDialog.show();
        return;
    }

    private void gotoSetupForPayment() {
        Intent r0 = new Intent(this, com.android.settings.Settings.FingerprintSetupForPaymentActivity.class);
        r0.putExtra(FingerprintSetupForPaymentFragment.EXTRA_FINGERPRINT_ID, getLastCompletedFingerprintID());
        r0.putExtra("password_confirmed", true);
        Utils.startActivity(this, r0);
    }

    private int getLastCompletedFingerprintID() {
        List r1 = ((FingerprintManager) getSystemService("fingerprint")).getEnrolledFingerprints();
        if (r1 != null) goto L5;
        return -1;
    L5:
        if (r1.isEmpty() == false) goto L8;
        return -1;
    L8:
        return InvisibleApi.getFingerId((Fingerprint) r1.get(r1.size() - 1));
    }

    private void playEnrollingProgressAnim() {
        int r0 = this.mSidecar.getEnrollmentSteps() + 1;
        int r2 = r0 - this.mSidecar.getEnrollmentRemaining();
        if (r0 <= 0) goto L9;
        AlphaAnimation r1 = getAlphaAnimation(0.6f, 1.0f);
        if (r2 != 1) goto L7;
        r1.setStartOffset(150);
    L7:
        this.mTextProgress.startAnimation(r1);
        return;
    }

    private AlphaAnimation getAlphaAnimation(float r1, float r2) {
        AlphaAnimation r0 = new AlphaAnimation(r1, r2);
        r0.setDuration(150);
        return r0;
    }

    private int getProgress(int r2, int r3) {
        if (r2 != (-1)) goto L5;
        return 0;
    L5:
        int r4 = r2 + 1;
        return (Math.max(0, r4 - r3) * 100) / r4;
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected void updateUI() {
        super.updateUI();
        OLog.d("BaseFingerprintEnrollingActivity", "updateUI " + this.mCurrentStep);
        int r0 = AnonymousClass3.$SwitchMap$com$android$settings$fingerprint$BaseFingerprintEnrollingActivity$STEP[this.mCurrentStep.ordinal()];
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L7;
        this.mEnrollingLayout.setVisibility(0);
        this.mFindSensorLayout.setVisibility(4);
        this.mTextProgress.setText(getString(R.string.enroll_fingerprint_progress, new Object[]{Integer.valueOf(getProgress(this.mSidecar.getEnrollmentSteps(), this.mSidecar.getEnrollmentRemaining()))}));
        playEnrollingProgressAnim();
    L18:
        setSetupForPaymentTextView();
        return;
    L7:
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L18;
        this.mTextProgress.setText(R.string.enroll_result_fail);
        goto L18
    L11:
        this.mTextProgress.setText(R.string.enroll_result_ok);
        goto L18
    L14:
        if (Utils.isFingerprintExists(this) == false) goto L16;
        this.mEnrollingLayout.setVisibility(0);
        this.mFindSensorLayout.setVisibility(4);
    L17:
        this.mTextProgress.setText(R.string.put_finger_on_sensor);
        goto L18
    L16:
        this.mEnrollingLayout.setVisibility(4);
        this.mFindSensorLayout.setVisibility(0);
        goto L17
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected void updateTipsView(int r7, CharSequence r8) {
        boolean r1 = true;
        this.mHandler.removeMessages(1);
        if (r8 != null) goto L5;
        String r9 = "";
    L7:
        if (r7 != 2) goto L9;
        r9 = getString(R.string.fingerprint_area_too_small_tips);
    L26:
        if (TextUtils.isEmpty(r9) == true) goto L32;
        this.mTextTips.clearAnimation();
        this.mTextTips.setText(r9);
        if (r1 == false) goto L30;
        this.mTextTips.setTextColor(getResources().getColor(R.color.fingerprint_enrolling_tips_error_color));
        this.mTextTips.startAnimation(getAlphaAnimation(1.0f, 0.0f, 200, 2));
        return;
    L30:
        this.mTextTips.setTextColor(getResources().getColor(R.color.fingerprint_enrolling_tips_normal_color));
        return;
    L32:
        return;
    L9:
        if (r7 != 108) goto L11;
    L23:
        this.mIsFingerPressing = true;
        OLog.d("BaseFingerprintEnrollingActivity", "mIsFingerPressing " + this.mIsFingerPressing);
        goto L26
    L11:
        if (r7 != 1003) goto L13;
    L20:
        this.mIsFingerPressing = false;
        OLog.d("BaseFingerprintEnrollingActivity", "mIsFingerPressing " + this.mIsFingerPressing);
        if (TextUtils.equals(getString(R.string.finger_up_tips), this.mTextTips.getText().toString()) == false) goto L26;
        r9 = getString(R.string.enroll_fingerprint_tips);
        r1 = false;
        goto L26
    L13:
        if (r7 != 1106) goto L15;
        r9 = getString(R.string.fingerprint_same_area_tips);
        goto L26
    L15:
        if (r7 == 1102) goto L23;
        if (r7 == 1103) goto L20;
    L5:
        r9 = r8.toString();
        goto L7
    }

    @Override // com.android.settings.fingerprint.BaseFingerprintEnrollingActivity
    protected void onFingerprintEnrollDone() {
        super.onFingerprintEnrollDone();
        this.mTextTips.setVisibility(4);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BackFingerprintEnrollingActivity r1) {
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(BackFingerprintEnrollingActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(BackFingerprintEnrollingActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(BackFingerprintEnrollingActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        BackFingerprintEnrollingActivity r5 = r4;
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
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(BackFingerprintEnrollingActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_fingerprint_BackFingerprintEnrollingActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(BackFingerprintEnrollingActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onResume(BackFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(BackFingerprintEnrollingActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onPause(BackFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(BackFingerprintEnrollingActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        BackFingerprintEnrollingActivity r5 = r3;
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
    public static void com_android_settings_fingerprint_BackFingerprintEnrollingActivity_com_obric_hook_lancet_PrivacyHook_onStop(BackFingerprintEnrollingActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        BackFingerprintEnrollingActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_BackFingerprintEnrollingActivity__onStop$___twin___();
    }
}
