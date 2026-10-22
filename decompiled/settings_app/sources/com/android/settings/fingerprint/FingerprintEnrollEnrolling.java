package com.android.settings.fingerprint;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintEnrollEnrolling extends FingerprintEnrollBase implements FingerprintEnrollSidecar.Listener {
    private static final int FINISH_DELAY = 250;
    private static final int HINT_TIMEOUT_DURATION = 2500;
    private static final int ICON_TOUCH_COUNT_SHOW_UNTIL_DIALOG_SHOWN = 3;
    private static final long ICON_TOUCH_DURATION_UNTIL_DIALOG_SHOWN = 500;
    private static final int PROGRESS_BAR_MAX = 10000;
    static final String TAG_SIDECAR = "sidecar";
    private boolean mAnimationCancelled;
    private final Runnable mDelayedFinishRunnable;
    private TextView mErrorText;
    private Interpolator mFastOutLinearInInterpolator;
    private Interpolator mFastOutSlowInInterpolator;
    private ImageView mFingerprintAnimator;
    private final Animatable2.AnimationCallback mIconAnimationCallback;
    private AnimatedVectorDrawable mIconAnimationDrawable;
    private int mIconTouchCount;
    private int mIndicatorBackgroundActivatedColor;
    private int mIndicatorBackgroundRestingColor;
    private Interpolator mLinearOutSlowInInterpolator;
    private ObjectAnimator mProgressAnim;
    private final Animator.AnimatorListener mProgressAnimationListener;
    private ProgressBar mProgressBar;
    private TextView mRepeatMessage;
    private boolean mRestoring;
    private final Runnable mShowDialogRunnable;
    private FingerprintEnrollSidecar mSidecar;
    private TextView mStartMessage;
    private final Runnable mTouchAgainRunnable;

    public static class IconTouchDialog extends DialogFragment {
        public void com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public IconTouchDialog() {
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            OAlertDialogBuilder r4 = new OAlertDialogBuilder(getActivity());
            r4.title(R.string.security_settings_fingerprint_enroll_touch_dialog_title).message(R.string.security_settings_fingerprint_enroll_touch_dialog_message).positiveButton(R.string.security_settings_fingerprint_enroll_dialog_ok, new AnonymousClass1(this));
            return r4.build();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(IconTouchDialog r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(IconTouchDialog r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(IconTouchDialog r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_fingerprint_FingerprintEnrollEnrolling$IconTouchDialog__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollEnrolling_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_fingerprint_FingerprintEnrollEnrolling_com_obric_hook_lancet_PrivacyHookActivity2_onStart(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_fingerprint_FingerprintEnrollEnrolling_com_obric_hook_lancet_PrivacyHookActivity2_onStop(this);
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onUdfpsPointerDown(int r1) {
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onUdfpsPointerUp(int r1) {
    }

    public FingerprintEnrollEnrolling() {
        this.mProgressAnimationListener = new AnonymousClass5(this);
        this.mDelayedFinishRunnable = new AnonymousClass6(this);
        this.mIconAnimationCallback = new AnonymousClass7(this);
        this.mShowDialogRunnable = new AnonymousClass8(this);
        this.mTouchAgainRunnable = new AnonymousClass9(this);
    }

    static /* synthetic */ int access$000(FingerprintEnrollEnrolling r0) {
        return r0.mIconTouchCount;
    }

    static /* synthetic */ int access$008(FingerprintEnrollEnrolling r2) {
        int r0 = r2.mIconTouchCount;
        r2.mIconTouchCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ void access$100(FingerprintEnrollEnrolling r0) {
        r0.showIconTouchDialog();
    }

    static /* synthetic */ void access$1000(FingerprintEnrollEnrolling r0, byte[] r1) {
        r0.launchFinish(r1);
    }

    static /* synthetic */ boolean access$1100(FingerprintEnrollEnrolling r0) {
        return r0.mAnimationCancelled;
    }

    static /* synthetic */ void access$1200(FingerprintEnrollEnrolling r0) {
        r0.startIconAnimation();
    }

    static /* synthetic */ void access$1300(FingerprintEnrollEnrolling r0, CharSequence r1) {
        r0.showError(r1);
    }

    static /* synthetic */ Runnable access$200(FingerprintEnrollEnrolling r0) {
        return r0.mShowDialogRunnable;
    }

    static /* synthetic */ ImageView access$300(FingerprintEnrollEnrolling r0) {
        return r0.mFingerprintAnimator;
    }

    static /* synthetic */ int access$400(FingerprintEnrollEnrolling r0) {
        return r0.mIndicatorBackgroundActivatedColor;
    }

    static /* synthetic */ int access$500(FingerprintEnrollEnrolling r0) {
        return r0.mIndicatorBackgroundRestingColor;
    }

    static /* synthetic */ Interpolator access$600(FingerprintEnrollEnrolling r0) {
        return r0.mLinearOutSlowInInterpolator;
    }

    static /* synthetic */ TextView access$700(FingerprintEnrollEnrolling r0) {
        return r0.mErrorText;
    }

    static /* synthetic */ ProgressBar access$800(FingerprintEnrollEnrolling r0) {
        return r0.mProgressBar;
    }

    static /* synthetic */ Runnable access$900(FingerprintEnrollEnrolling r0) {
        return r0.mDelayedFinishRunnable;
    }

    public void com_android_settings_fingerprint_FingerprintEnrollEnrolling__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        setContentView(R.layout.fingerprint_enroll_enrolling);
        setHeaderText(R.string.security_settings_fingerprint_enroll_start_title);
        this.mStartMessage = (TextView) findViewById(R.id.start_message);
        this.mRepeatMessage = (TextView) findViewById(R.id.repeat_message);
        this.mErrorText = (TextView) findViewById(R.id.error_text);
        this.mProgressBar = (ProgressBar) findViewById(R.id.fingerprint_progress_bar);
        ImageView r0 = (ImageView) findViewById(R.id.fingerprint_animator);
        this.mFingerprintAnimator = r0;
        AnimatedVectorDrawable r1 = (AnimatedVectorDrawable) r0.getDrawable();
        this.mIconAnimationDrawable = r1;
        r1.registerAnimationCallback(this.mIconAnimationCallback);
        this.mFastOutSlowInInterpolator = AnimationUtils.loadInterpolator(this, 17563661);
        this.mLinearOutSlowInInterpolator = AnimationUtils.loadInterpolator(this, 17563662);
        this.mFastOutLinearInInterpolator = AnimationUtils.loadInterpolator(this, 17563663);
        this.mFingerprintAnimator.setOnTouchListener(new AnonymousClass1(this));
        this.mIndicatorBackgroundRestingColor = getColor(R.color.fingerprint_indicator_background_resting);
        this.mIndicatorBackgroundActivatedColor = getColor(R.color.fingerprint_indicator_background_activated);
        if (r3 == null) goto L5;
        boolean r4 = true;
    L6:
        this.mRestoring = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }

    public void com_android_settings_fingerprint_FingerprintEnrollEnrolling__onStart$___twin___() {
        super.onStart();
        FingerprintEnrollSidecar r0 = (FingerprintEnrollSidecar) getSupportFragmentManager().findFragmentByTag(TAG_SIDECAR);
        this.mSidecar = r0;
        if (r0 != null) goto L5;
        this.mSidecar = new FingerprintEnrollSidecar();
        getSupportFragmentManager().beginTransaction().add(this.mSidecar, TAG_SIDECAR).commit();
    L5:
        this.mSidecar.setListener(this);
        updateProgress(false);
        updateDescription();
        if (this.mRestoring == false) goto L9;
        startIconAnimation();
        return;
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        this.mAnimationCancelled = false;
        startIconAnimation();
    }

    private void startIconAnimation() {
        this.mIconAnimationDrawable.start();
    }

    private void stopIconAnimation() {
        this.mAnimationCancelled = true;
        this.mIconAnimationDrawable.stop();
    }

    public void com_android_settings_fingerprint_FingerprintEnrollEnrolling__onStop$___twin___() {
        super.onStop();
        FingerprintEnrollSidecar r0 = this.mSidecar;
        if (r0 == null) goto L5;
        r0.setListener(null);
    L5:
        stopIconAnimation();
        if (isChangingConfigurations() == true) goto L12;
        FingerprintEnrollSidecar r1 = this.mSidecar;
        if (r1 == null) goto L10;
        r1.cancelEnrollment();
        getSupportFragmentManager().beginTransaction().remove(this.mSidecar).commitAllowingStateLoss();
    L10:
        finish();
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FingerprintEnrollSidecar r0 = this.mSidecar;
        if (r0 == null) goto L5;
        r0.setListener(null);
        this.mSidecar.cancelEnrollment();
        getSupportFragmentManager().beginTransaction().remove(this.mSidecar).commitAllowingStateLoss();
        this.mSidecar = null;
    L5:
        super.onBackPressed();
    }

    private void animateProgress(int r5) {
        ObjectAnimator r0 = this.mProgressAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ProgressBar r1 = this.mProgressBar;
        ObjectAnimator r6 = ObjectAnimator.ofInt(r1, "progress", new int[]{r1.getProgress(), r5});
        r6.addListener(this.mProgressAnimationListener);
        r6.setInterpolator(this.mFastOutSlowInInterpolator);
        r6.setDuration(250);
        r6.start();
        this.mProgressAnim = r6;
    }

    private void animateFlash() {
        ValueAnimator r0 = ValueAnimator.ofArgb(new int[]{this.mIndicatorBackgroundRestingColor, this.mIndicatorBackgroundActivatedColor});
        final ValueAnimator.AnimatorUpdateListener r1 = new AnonymousClass2(this);
        r0.addUpdateListener(r1);
        r0.addListener(new AnonymousClass3(this, r1));
        r0.setInterpolator(this.mFastOutSlowInInterpolator);
        r0.setDuration(300);
        r0.start();
    }

    private void launchFinish(byte[] r3) {
        Intent r0 = getFinishIntent();
        r0.addFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        r0.putExtra("hw_auth_token", r3);
        if (this.mUserId == (-10000)) goto L5;
        r0.putExtra("android.intent.extra.USER_ID", this.mUserId);
    L5:
        startActivity(r0);
        finish();
    }

    protected Intent getFinishIntent() {
        return new Intent(this, FingerprintEnrollFinish.class);
    }

    private void updateDescription() {
        if (this.mSidecar.getEnrollmentSteps() != (-1)) goto L5;
        setHeaderText(R.string.security_settings_fingerprint_enroll_start_title);
        this.mStartMessage.setVisibility(0);
        this.mRepeatMessage.setVisibility(4);
        return;
    L5:
        setHeaderText(R.string.security_settings_fingerprint_enroll_repeat_title, true);
        this.mStartMessage.setVisibility(4);
        this.mRepeatMessage.setVisibility(0);
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onEnrollmentHelp(int r1, CharSequence r2) {
        this.mErrorText.setText(r2);
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onEnrollmentError(int r1, CharSequence r2) {
        showError(r2);
        stopIconAnimation();
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollSidecar.Listener
    public void onEnrollmentProgressChange(int r3, int r4) {
        updateProgress(true);
        updateDescription();
        clearError();
        animateFlash();
        this.mErrorText.removeCallbacks(this.mTouchAgainRunnable);
        this.mErrorText.postDelayed(this.mTouchAgainRunnable, 2500);
    }

    private void updateProgress(boolean r3) {
        int r0 = getProgress(this.mSidecar.getEnrollmentSteps(), this.mSidecar.getEnrollmentRemaining());
        if (r3 == false) goto L5;
        animateProgress(r0);
        return;
    L5:
        this.mProgressBar.setProgress(r0);
    }

    private int getProgress(int r2, int r3) {
        if (r2 != (-1)) goto L5;
        return 0;
    L5:
        int r4 = r2 + 1;
        return (Math.max(0, r4 - r3) * 10000) / r4;
    }

    private void showIconTouchDialog() {
        this.mIconTouchCount = 0;
        new IconTouchDialog().show(getSupportFragmentManager(), null);
    }

    private void showError(CharSequence r5) {
        this.mErrorText.setText(r5);
        if (this.mErrorText.getVisibility() != 4) goto L5;
        this.mErrorText.setVisibility(0);
        this.mErrorText.setTranslationY(getResources().getDimensionPixelSize(R.dimen.fingerprint_error_text_appear_distance));
        this.mErrorText.setAlpha(0.0f);
        this.mErrorText.animate().alpha(1.0f).translationY(0.0f).setDuration(200).setInterpolator(this.mLinearOutSlowInInterpolator).start();
        return;
    L5:
        this.mErrorText.animate().cancel();
        this.mErrorText.setAlpha(1.0f);
        this.mErrorText.setTranslationY(0.0f);
    }

    private void clearError() {
        if (this.mErrorText.getVisibility() != 0) goto L6;
        this.mErrorText.animate().alpha(0.0f).translationY(getResources().getDimensionPixelSize(R.dimen.fingerprint_error_text_disappear_distance)).setDuration(100).setInterpolator(this.mFastOutLinearInInterpolator).withEndAction(new AnonymousClass4(this)).start();
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollEnrolling_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(FingerprintEnrollEnrolling r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollEnrolling r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FingerprintEnrollEnrolling__onCreate$___twin___(r4);
    }

    @Insert("onStart")
    public static void com_android_settings_fingerprint_FingerprintEnrollEnrolling_com_obric_hook_lancet_PrivacyHookActivity2_onStart(FingerprintEnrollEnrolling r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollEnrolling r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollEnrolling__onStart$___twin___();
    }

    @Insert("onStop")
    public static void com_android_settings_fingerprint_FingerprintEnrollEnrolling_com_obric_hook_lancet_PrivacyHookActivity2_onStop(FingerprintEnrollEnrolling r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollEnrolling r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_fingerprint_FingerprintEnrollEnrolling__onStop$___twin___();
    }
}
