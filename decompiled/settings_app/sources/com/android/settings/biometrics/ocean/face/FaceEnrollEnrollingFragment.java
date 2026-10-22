package com.android.settings.biometrics.ocean.face;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.databinding.FaceEnrollEnrollingBinding;
import com.android.settings.fingerprint.BaseFingerprintEnrollingActivity;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: FaceEnrollEnrollingFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/android/settings/biometrics/ocean/face/FaceEnrollEnrollingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "faceEnrollMgr", "Lcom/android/settings/biometrics/ocean/face/FaceEnrollMgr;", "fingerprintManager", "Landroid/hardware/fingerprint/FingerprintManager;", "lockPatternUtils", "Lcom/android/internal/widget/LockPatternUtils;", "mIsFromSetupWizard", "", "mPendingLockCheck", "Landroid/os/AsyncTask;", "password", "Lcom/android/internal/widget/LockscreenCredential;", "surfaceHolder", "Landroid/view/SurfaceHolder;", "surfaceView", "Landroid/view/SurfaceView;", "surfaceViewCallback", "com/android/settings/biometrics/ocean/face/FaceEnrollEnrollingFragment$surfaceViewCallback$1", "Lcom/android/settings/biometrics/ocean/face/FaceEnrollEnrollingFragment$surfaceViewCallback$1;", "viewBinding", "Lcom/android/settings/databinding/FaceEnrollEnrollingBinding;", "generateAndInitSurfaceView", "", "getResultIntent", "Landroid/content/Intent;", "getSurfaceHolder", "getSurfaceView", "launchFinish", "launchSetupNext", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "startDoneAlphaAnimation", "startEnrolling", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FaceEnrollEnrollingFragment extends Fragment {
    private final String TAG;
    private FaceEnrollMgr faceEnrollMgr;
    private FingerprintManager fingerprintManager;
    private LockPatternUtils lockPatternUtils;
    private boolean mIsFromSetupWizard;
    private AsyncTask<?, ?, ?> mPendingLockCheck;
    private LockscreenCredential password;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;
    private final FaceEnrollEnrollingFragment$surfaceViewCallback$1 surfaceViewCallback;
    private FaceEnrollEnrollingBinding viewBinding;

    public static /* synthetic */ void $r8$lambda$8Nv_paDVLQz1Rwl7MGB6y3IviRo(FaceEnrollEnrollingFragment r0, View r1) {
        onViewCreated$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$MIZT-j6ytS2XLwZwLg3FJ9qA00A, reason: not valid java name */
    public static /* synthetic */ void m341$r8$lambda$MIZTj6ytS2XLwZwLg3FJ9qA00A(SurfaceView r0, ValueAnimator r1) {
        startDoneAlphaAnimation$lambda$17$lambda$16$lambda$15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Tn46m0MjlvKM4KfKLdMZ3J0MVQQ(FaceEnrollEnrollingFragment r0, View r1) {
        onViewCreated$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$iJHWfDd13dVoaE81DtZEJSQRsys(FaceEnrollEnrollingFragment r0, View r1) {
        onViewCreated$lambda$6(r0, r1);
    }

    public void com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.settings.biometrics.ocean.face.FaceEnrollEnrollingFragment$surfaceViewCallback$1] */
    public FaceEnrollEnrollingFragment() {
        this.TAG = "FaceEnrollEnrollingFrag";
        this.surfaceViewCallback = new FaceEnrollEnrollingFragment$surfaceViewCallback$1(this);
    }

    public static final /* synthetic */ void access$generateAndInitSurfaceView(FaceEnrollEnrollingFragment r0) {
        r0.generateAndInitSurfaceView();
    }

    public static final /* synthetic */ FaceEnrollMgr access$getFaceEnrollMgr$p(FaceEnrollEnrollingFragment r0) {
        return r0.faceEnrollMgr;
    }

    public static final /* synthetic */ boolean access$getMIsFromSetupWizard$p(FaceEnrollEnrollingFragment r0) {
        return r0.mIsFromSetupWizard;
    }

    public static final /* synthetic */ Intent access$getResultIntent(FaceEnrollEnrollingFragment r0) {
        return r0.getResultIntent();
    }

    public static final /* synthetic */ SurfaceHolder access$getSurfaceHolder(FaceEnrollEnrollingFragment r0) {
        return r0.getSurfaceHolder();
    }

    public static final /* synthetic */ SurfaceView access$getSurfaceView(FaceEnrollEnrollingFragment r0) {
        return r0.getSurfaceView();
    }

    public static final /* synthetic */ FaceEnrollEnrollingBinding access$getViewBinding$p(FaceEnrollEnrollingFragment r0) {
        return r0.viewBinding;
    }

    public static final /* synthetic */ void access$setSurfaceHolder$p(FaceEnrollEnrollingFragment r0, SurfaceHolder r1) {
        r0.surfaceHolder = r1;
    }

    public static final /* synthetic */ void access$startDoneAlphaAnimation(FaceEnrollEnrollingFragment r0) {
        r0.startDoneAlphaAnimation();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FaceEnrollEnrollingBinding r4 = FaceEnrollEnrollingBinding.inflate(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.viewBinding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L5:
        ConstraintLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        UIUtils.fitMaskTitle((ViewGroup) r8);
        super.onViewCreated(r8, r9);
        Context r10 = getContext();
        if (r10 != null) goto L5;
        return;
    L5:
        FragmentActivity r11 = getActivity();
        FaceEnrollEnrollingBinding r0 = null;
        if (r11 == null) goto L10;
        Intent r12 = r11.getIntent();
        if (r12 == null) goto L10;
        byte[] r13 = r12.getByteArrayExtra("hw_auth_token");
    L11:
        this.fingerprintManager = (FingerprintManager) r10.getSystemService(FingerprintManager.class);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L14;
        this.lockPatternUtils = new ChooseLockSettingsHelper(r1).utils();
    L14:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L19;
        Intent r3 = r2.getIntent();
        if (r3 == null) goto L19;
        LockscreenCredential r4 = (LockscreenCredential) r3.getParcelableExtra("password");
    L20:
        this.password = r4;
        FragmentActivity r5 = getActivity();
        boolean r6 = false;
        if (r5 == null) goto L25;
        Intent r7 = r5.getIntent();
        if (r7 == null) goto L25;
        r6 = r7.getBooleanExtra(ProvisionConstants.EXTRA_SETUPWIZARD, false);
    L25:
        this.mIsFromSetupWizard = r6;
        FaceEnrollMgr r14 = new FaceEnrollMgr();
        LifecycleOwner r15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r15, "getViewLifecycleOwner(...)");
        r14.init(r10, r13, r15, new FaceEnrollEnrollingFragment$onViewCreated$2$1(this));
        this.faceEnrollMgr = r14;
        FaceEnrollEnrollingBinding r16 = this.viewBinding;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L28:
        OFloatingTitleBar r17 = r16.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r17, "viewTitle");
        OFloatingTitleBar.addStartAction$default(r17, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null).setOnClickListener(new FaceEnrollEnrollingFragment$$ExternalSyntheticLambda0(this));
        generateAndInitSurfaceView();
        FaceEnrollMgr r18 = this.faceEnrollMgr;
        if (r18 == null) goto L31;
        r18.getHelpTextLv().observe(getViewLifecycleOwner(), new FaceEnrollEnrollingFragment$sam$androidx_lifecycle_Observer$0(new FaceEnrollEnrollingFragment$onViewCreated$4$1(this)));
        r18.getProgressTextLv().observe(getViewLifecycleOwner(), new FaceEnrollEnrollingFragment$sam$androidx_lifecycle_Observer$0(new FaceEnrollEnrollingFragment$onViewCreated$4$2(this)));
        r18.getProgressLv().observe(getViewLifecycleOwner(), new FaceEnrollEnrollingFragment$sam$androidx_lifecycle_Observer$0(new FaceEnrollEnrollingFragment$onViewCreated$4$3(this)));
        r18.getTimeoutLv().observe(getViewLifecycleOwner(), new FaceEnrollEnrollingFragment$sam$androidx_lifecycle_Observer$0(new FaceEnrollEnrollingFragment$onViewCreated$4$4(this)));
    L31:
        FaceEnrollEnrollingBinding r19 = this.viewBinding;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r19 = null;
    L34:
        r19.enrollFinish.setOnClickListener(new FaceEnrollEnrollingFragment$$ExternalSyntheticLambda1(this));
        FaceEnrollEnrollingBinding r20 = this.viewBinding;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r20 = null;
    L37:
        r20.gotoNext.setOnClickListener(new FaceEnrollEnrollingFragment$$ExternalSyntheticLambda2(this));
        FaceEnrollEnrollingBinding r21 = this.viewBinding;
        if (r21 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L41:
        final LottieAnimationView r22 = r0.faceEnrollingLottieView;
        FaceEnrollMgr r23 = this.faceEnrollMgr;
        if (r23 == null) goto L47;
        MutableLiveData<Boolean> r24 = r23.getHasEnrollingImageDataLv();
        if (r24 == null) goto L48;
        r24.observe(getViewLifecycleOwner(), new FaceEnrollEnrollingFragment$sam$androidx_lifecycle_Observer$0(new FaceEnrollEnrollingFragment$onViewCreated$7$1(r22)));
        return;
    L48:
        return;
    L47:
        return;
    L40:
        r0 = r21;
    L19:
        r4 = null;
    L10:
        r13 = null;
        goto L11
    }

    private static final void onViewCreated$lambda$2(FaceEnrollEnrollingFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }

    private static final void onViewCreated$lambda$5(final FaceEnrollEnrollingFragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        FaceEnrollMgr r4 = r2.faceEnrollMgr;
        if (r4 == null) goto L7;
        MutableLiveData<Boolean> r5 = r4.getTimeoutLv();
        if (r5 == null) goto L7;
        boolean r6 = Intrinsics.areEqual(r5.getValue(), true);
    L8:
        if (r6 == true) goto L11;
        r2.launchFinish();
        return;
    L11:
        if (r2.password != null) goto L14;
        OLog.e(r2.TAG, "password null");
        return;
    L14:
        FaceEnrollEnrollingBinding r7 = r2.viewBinding;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L17:
        r7.enrollFinish.setClickable(false);
        final FaceEnrollMgr r8 = r2.faceEnrollMgr;
        if (r8 == null) goto L22;
        LockscreenCredential r0 = r2.password;
        Intrinsics.checkNotNull(r0);
        r8.generateToken(r0, new FaceEnrollEnrollingFragment$onViewCreated$5$1$1(r2, r8));
        return;
    L22:
        return;
    L7:
        r6 = false;
        goto L8
    }

    private static final void onViewCreated$lambda$6(FaceEnrollEnrollingFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.launchSetupNext();
    }

    private final Intent getResultIntent() {
        Intent r0 = new Intent();
        r0.putExtra("request_code", -1);
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L9;
        Intent r4 = r3.getIntent();
        if (r4 == null) goto L9;
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L9;
        r0.putExtra("request_code", r5.getInt("request_code", -1));
    L9:
        return r0;
    }

    private final SurfaceHolder getSurfaceHolder() {
        return this.surfaceHolder;
    }

    private final void launchFinish() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.setResult(-1, getResultIntent());
        r0.finish();
        return;
    }

    private final void launchSetupNext() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        r0.setResult(-1, getResultIntent());
        r0.finish();
        return;
    }

    private final SurfaceView getSurfaceView() {
        return this.surfaceView;
    }

    private final void generateAndInitSurfaceView() {
        SurfaceView r0 = this.surfaceView;
        FaceEnrollEnrollingBinding r2 = null;
        if (r0 == null) goto L8;
        FaceEnrollEnrollingBinding r3 = this.viewBinding;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L7:
        r3.previewContainer.removeView(r0);
    L8:
        this.surfaceView = null;
        this.surfaceHolder = null;
        SurfaceView r1 = new SurfaceView(getContext());
        r1.setScaleY(1.3333334f);
        r1.getHolder().addCallback(this.surfaceViewCallback);
        FaceEnrollEnrollingBinding r4 = this.viewBinding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L12:
        r2.previewContainer.addView(r1, 0, new FrameLayout.LayoutParams(-1, -1));
        this.surfaceView = r1;
        return;
    L11:
        r2 = r4;
        goto L12
    }

    private final void startEnrolling() {
        OLog.e(this.TAG, "startEnrolling password=" + this.password);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        Intent r1 = BaseFingerprintEnrollingActivity.launchFingerprintEnrollingActivity(r0);
        LockscreenCredential r2 = this.password;
        if (r2 == null) goto L7;
        r1.putExtra("password", (Parcelable) r2);
    L7:
        r1.putExtra(BaseFingerprintEnrollingActivity.EXTRA_FROM_FP_MANAGER, false);
        r1.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, this.mIsFromSetupWizard);
        Utils.startActivity(r0, r1, 2);
        r0.setResult(-1, getResultIntent());
        r0.finish();
        return;
    }

    private final void startDoneAlphaAnimation() {
        final SurfaceView r0 = getSurfaceView();
        if (r0 == null) goto L6;
        OLog.d(this.TAG, "startDoneAlphaAnimation surface");
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r3.setDuration(Token.Duration.OUI_ANIMATION_DURATION_SHORT_4.getDuration());
        r3.setInterpolator(new LinearInterpolator());
        r3.addUpdateListener(new FaceEnrollEnrollingFragment$$ExternalSyntheticLambda3(r0));
        r3.addListener(new FaceEnrollEnrollingFragment$startDoneAlphaAnimation$1$1$2(r0));
        r3.start();
        return;
    }

    private static final void startDoneAlphaAnimation$lambda$17$lambda$16$lambda$15(SurfaceView r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_apply");
        Intrinsics.checkNotNullParameter(r2, "it");
        Object r3 = r2.getAnimatedValue();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Float");
        r1.setAlpha(((Float) r3).floatValue());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FaceEnrollEnrollingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FaceEnrollEnrollingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FaceEnrollEnrollingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_ocean_face_FaceEnrollEnrollingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
