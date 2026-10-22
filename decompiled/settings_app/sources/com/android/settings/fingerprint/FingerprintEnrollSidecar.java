package com.android.settings.fingerprint;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintEnrollOptions;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.UserHandle;
import androidx.fragment.app.Fragment;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ResourceUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.privacy.GrantUtil;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintEnrollSidecar extends Fragment {
    public static final int EVENT_FINGER_ACQUIRED_PARTIAL = 1;
    public static final int EVENT_FINGER_AREA_ENROLLED_ALREADY = 1106;
    public static final int EVENT_FINGER_AREA_TOO_SMALL = 2;
    public static final int EVENT_FINGER_DOWN = 1102;
    public static final int EVENT_FINGER_ENROLLED_ALREADY = 1105;
    public static final int EVENT_FINGER_MOVE_TOO_FAST = 5;
    public static final int EVENT_FINGER_UP = 1103;
    public static final int EVENT_FINGER_UP2 = 1003;
    public static String EXTRA_PASSWORD = "extra_password";
    public static String EXTRA_SENSOR_ID = "extra_sensor_id";
    public static String EXTRA_SENSOR_TYPE = "extra_sensor_type";
    public static String EXTRA_TOKEN = "extra_token";
    public static final int MAX_BACK_ENROLL_STEP = 12;
    public static final int MAX_DARWIN_ENROLL_STEP = 32;
    public static final int MAX_DELTA_ENROLL_STEP = 20;
    public static final int MAX_ENROLL_STEP = 100;
    public static final int MAX_PACIFIC_ENROLL_STEP = 100;
    public static final int MAX_ZTE_APFPS_ENROLL_STEP = 26;
    public static final int MAX_ZTE_UDFPS_ENROLL_STEP = 15;
    private final String TAG;
    private boolean isFirstProgress;
    private long lastTime;
    private int mCurrentStep;
    private boolean mDone;
    private int mEnrollReason;
    private OAlertDialog mEnrollTipDialog;
    private boolean mEnrolling;
    private FingerprintManager.EnrollmentCallback mEnrollmentCallback;
    private CancellationSignal mEnrollmentCancel;
    private int mEnrollmentRemaining;
    private int mEnrollmentSteps;
    private FingerprintManager mFingerprintManager;
    private int mHalfStep;
    private Handler mHandler;
    private Listener mListener;
    private UdfpsBGELoadingDialog mLoadingDialog;
    private LockscreenCredential mPassword;
    private int mPreRemaining;
    private int mSensorId;
    private int mSensorType;
    private boolean mShouldDoBGE;
    private final Runnable mTimeoutRunnable;
    private byte[] mToken;
    private long startTime;

    public interface Listener {
        void onEnrollmentError(int r1, CharSequence r2);

        void onEnrollmentHelp(int r1, CharSequence r2);

        void onEnrollmentProgressChange(int r1, int r2);

        void onUdfpsPointerDown(int r1);

        void onUdfpsPointerUp(int r1);
    }

    static {
    }

    public void com_android_settings_fingerprint_FingerprintEnrollSidecar__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollSidecar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fingerprint_FingerprintEnrollSidecar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FingerprintEnrollSidecar() {
        this.TAG = "FingerprintEnrollSidecar";
        this.mEnrollmentSteps = -1;
        this.mEnrollmentRemaining = 0;
        this.mHandler = new Handler();
        this.mSensorId = -1;
        this.mSensorType = 2;
        this.mShouldDoBGE = true;
        this.mEnrollReason = 2;
        this.mPreRemaining = 0;
        this.mHalfStep = 0;
        this.mCurrentStep = 0;
        this.startTime = 0;
        this.lastTime = 0;
        this.isFirstProgress = true;
        this.mEnrollmentCallback = new AnonymousClass1(this);
        this.mTimeoutRunnable = new AnonymousClass2(this);
    }

    static /* synthetic */ int access$000(FingerprintEnrollSidecar r0) {
        return r0.mPreRemaining;
    }

    static /* synthetic */ long access$100(FingerprintEnrollSidecar r2) {
        return r2.lastTime;
    }

    static /* synthetic */ boolean access$1002(FingerprintEnrollSidecar r0, boolean r1) {
        r0.mEnrolling = r1;
        return r1;
    }

    static /* synthetic */ long access$102(FingerprintEnrollSidecar r0, long r1) {
        r0.lastTime = r1;
        return r1;
    }

    static /* synthetic */ int access$200(FingerprintEnrollSidecar r0) {
        return r0.mSensorType;
    }

    static /* synthetic */ long access$300(FingerprintEnrollSidecar r2) {
        return r2.startTime;
    }

    static /* synthetic */ boolean access$400(FingerprintEnrollSidecar r0) {
        return r0.isFirstProgress;
    }

    static /* synthetic */ boolean access$402(FingerprintEnrollSidecar r0, boolean r1) {
        r0.isFirstProgress = r1;
        return r1;
    }

    static /* synthetic */ int access$502(FingerprintEnrollSidecar r0, int r1) {
        r0.mCurrentStep = r1;
        return r1;
    }

    static /* synthetic */ int access$600(FingerprintEnrollSidecar r0) {
        return r0.mEnrollmentSteps;
    }

    static /* synthetic */ int access$602(FingerprintEnrollSidecar r0, int r1) {
        r0.mEnrollmentSteps = r1;
        return r1;
    }

    static /* synthetic */ int access$702(FingerprintEnrollSidecar r0, int r1) {
        r0.mEnrollmentRemaining = r1;
        return r1;
    }

    static /* synthetic */ boolean access$802(FingerprintEnrollSidecar r0, boolean r1) {
        r0.mDone = r1;
        return r1;
    }

    static /* synthetic */ Listener access$900(FingerprintEnrollSidecar r0) {
        return r0.mListener;
    }

    public void setPassword(LockscreenCredential r1) {
        this.mPassword = r1;
    }

    public void com_android_settings_fingerprint_FingerprintEnrollSidecar__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r4) {
        super.onAttach(r4);
        this.mFingerprintManager = (FingerprintManager) r4.getSystemService(FingerprintManager.class);
        byte[] r5 = r4.getIntent().getByteArrayExtra("hw_auth_token");
        this.mToken = r5;
        if (r5 != null) goto L6;
        this.mToken = getArguments().getByteArray(EXTRA_TOKEN);
        OLog.d("FingerprintEnrollSidecar", "FingerprintEnrollSidecar got mToken " + this.mToken);
    L6:
        if (this.mToken != null) goto L8;
        boolean r6 = true;
    L9:
        this.mShouldDoBGE = r6;
        OLog.e("FingerprintEnrollSidecar", "onAttach mShouldDoBGE=" + this.mShouldDoBGE);
        this.mPassword = getArguments().getParcelable(EXTRA_PASSWORD);
        this.mSensorId = getArguments().getInt(EXTRA_SENSOR_ID, -1);
        int r7 = getArguments().getInt(EXTRA_SENSOR_TYPE, 2);
        this.mSensorType = r7;
        this.mPreRemaining = getMaxStep(r7);
        OLog.e("FingerprintEnrollSidecar", "onAttach got mPassword= " + this.mPassword);
        return;
    L8:
        r6 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        OLog.e("FingerprintEnrollSidecar", " FingerprintEnrollSidecar onStart");
        if (this.mEnrolling == false) goto L5;
        return;
    L5:
        if (this.mShouldDoBGE == false) goto L7;
        preStartEnrollment();
        return;
    L7:
        startEnrollment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (getActivity().isChangingConfigurations() == true) goto L5;
        cancelEnrollment();
    L5:
        UdfpsBGELoadingDialog r0 = this.mLoadingDialog;
        if (r0 == null) goto L9;
        r0.hide();
        this.mLoadingDialog = null;
        return;
    }

    private FingerprintEnrollOptions toFingerprintEnrollOptions(Intent r4) {
        int r5 = r4.getIntExtra("enroll_reason", -1);
        FingerprintEnrollOptions.Builder r0 = new FingerprintEnrollOptions.Builder();
        r0.setEnrollReason(0);
        setEnrollSensorId(r0, this.mSensorId);
        if (r5 == (-1)) goto L6;
        r0.setEnrollReason(r5);
    L6:
        return r0.build();
    }

    private void setEnrollSensorId(FingerprintEnrollOptions.Builder r6, int r7) {
        if (r7 == (-1)) goto L11;
        r6.getClass().getMethod("setEnrollSensorId", new Class[]{Integer.TYPE}).invoke(r6, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L6
        return;
    L6:
        e = move-exception;
        OLog.e("FingerprintEnrollSidecar", "Failed to invoke setEnrollSensorId via reflection", e);
        return;
    }

    public void resetToken(byte[] r1) {
        this.mToken = r1;
    }

    private void preStartEnrollment() {
        OLog.e("FingerprintEnrollSidecar", "FingerprintEnrollSidecar preStartEnrollment= " + this.mPassword);
        UdfpsBGELoadingDialog r0 = new UdfpsBGELoadingDialog(getActivity(), ResourceUtils.getString(R.string.security_validating), this.mPassword, this.mSensorId, this.mSensorType, new FingerprintEnrollSidecar$$ExternalSyntheticLambda2(this));
        this.mLoadingDialog = r0;
        r0.show();
    }

    /* JADX INFO: renamed from: lambda$preStartEnrollment$2$com-android-settings-fingerprint-FingerprintEnrollSidecar, reason: not valid java name */
    /* synthetic */ Unit m466x5f124e86(byte[] r4) {
        UdfpsBGELoadingDialog r0 = this.mLoadingDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
        this.mLoadingDialog = null;
    L5:
        OLog.e("FingerprintEnrollSidecar", "FingerprintEnrollSidecar preStartEnrollment bytes= " + r4);
        this.mToken = r4;
        if (getActivity() != null) goto L8;
    L10:
        startEnrollment();
    L11:
        return null;
    L8:
        if (getActivity().getClass().equals(AIPoweredFingerprintEnrollingActivity.class) == false) goto L10;
        OAlertDialog r5 = new OAlertDialogBuilder(getActivity()).title(R.string.enroll_new_ai_powered_fingerprint_dialog_title).message(R.string.enroll_new_ai_powered_fingerprint_dialog_content).positiveButton("", new FingerprintEnrollSidecar$$ExternalSyntheticLambda0()).negativeButton(R.string.ok2, new FingerprintEnrollSidecar$$ExternalSyntheticLambda1(this)).build();
        this.mEnrollTipDialog = r5;
        r5.show();
        goto L11
    }

    static /* synthetic */ void lambda$preStartEnrollment$0(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    /* JADX INFO: renamed from: lambda$preStartEnrollment$1$com-android-settings-fingerprint-FingerprintEnrollSidecar, reason: not valid java name */
    /* synthetic */ void m465x4e5c81c5(DialogInterface r1, int r2) {
        startEnrollment();
        r1.dismiss();
    }

    private void startEnrollment() {
        OLog.e("FingerprintEnrollSidecar", "FingerprintEnrollSidecar startEnrollment, sensorId: " + this.mSensorId + ", sensorType: " + this.mSensorType);
        this.mHandler.removeCallbacks(this.mTimeoutRunnable);
        this.mEnrollmentSteps = -1;
        if (SettingsFeature.isDarwin() == false) goto L5;
        initStep();
    L5:
        CancellationSignal r0 = this.mEnrollmentCancel;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        this.mEnrollmentCancel = new CancellationSignal();
        if (getActivity() != null) goto L11;
        return;
    L11:
        FingerprintManager r3 = (FingerprintManager) getActivity().getSystemService(FingerprintManager.class);
        OLog.i("FingerprintEnrollSidecar", "startEnrollment, sensorId: " + this.mSensorId + ", sensorType: " + this.mSensorType);
        Intent r1 = new Intent();
        r1.putExtra("enroll_reason", 2);
        r3.enroll(this.mToken, this.mEnrollmentCancel, UserHandle.myUserId(), this.mEnrollmentCallback, this.mEnrollReason, toFingerprintEnrollOptions(r1));
        this.mEnrolling = true;
        this.startTime = System.currentTimeMillis();
        this.isFirstProgress = true;
    }

    public boolean cancelEnrollment() {
        this.mHandler.removeCallbacks(this.mTimeoutRunnable);
        if (this.mEnrolling == false) goto L9;
        OLog.d("FingerprintEnrollSidecar", "cancelEnrollment");
        this.mEnrollmentCancel.cancel();
        this.mEnrolling = false;
        this.mEnrollmentSteps = -1;
        if (SettingsFeature.isDarwin() == false) goto L10;
        initStep();
        return true;
    L10:
        return true;
    L9:
        return false;
    }

    public void resetCurrentStep() {
        OLog.i("FingerprintEnrollSidecar", "resetCurrentStep");
        this.mCurrentStep = 0;
    }

    public void startEnrollIfNeeded() {
        if (this.mEnrolling == true) goto L6;
        startEnrollment();
        return;
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    public int getEnrollmentSteps() {
        return this.mEnrollmentSteps;
    }

    public int getCurrentProgress() {
        int r0 = getMaxStep(this.mSensorType);
        return ((r0 - this.mEnrollmentRemaining) * 100) / r0;
    }

    public int getEnrollmentRemaining() {
        return this.mEnrollmentRemaining;
    }

    public boolean isDone() {
        return this.mDone;
    }

    public boolean isEnrolling() {
        return this.mEnrolling;
    }

    public int getCurrentStep() {
        return this.mCurrentStep;
    }

    public void initStep() {
        this.mPreRemaining = getMaxStep(this.mSensorType);
        this.mHalfStep = 0;
        this.mCurrentStep = 0;
    }

    public boolean isShowTips() {
        if ((this.mHalfStep % 2) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int getMaxStep(int r1) {
        if (SettingsFeature.isSupportNubiaShare() == true) goto L5;
        return 100;
    L5:
        if (r1 != 4) goto L8;
        return 26;
    L8:
        return 15;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollSidecar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FingerprintEnrollSidecar r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintEnrollSidecar__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintEnrollSidecar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FingerprintEnrollSidecar r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fingerprint_FingerprintEnrollSidecar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fingerprint_FingerprintEnrollSidecar_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FingerprintEnrollSidecar r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fingerprint_FingerprintEnrollSidecar__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
