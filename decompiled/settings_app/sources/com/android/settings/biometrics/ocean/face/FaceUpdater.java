package com.android.settings.biometrics.ocean.face;

import android.content.Context;
import android.hardware.face.Face;
import android.hardware.face.FaceEnrollCell;
import android.hardware.face.FaceEnrollOptions;
import android.hardware.face.FaceManager;
import android.os.CancellationSignal;
import android.os.UserHandle;
import android.view.Surface;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.LockPatternCheckerOnly;
import com.android.settings.Utils;
import com.android.settings.utils.ThreadUtils;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class FaceUpdater {
    private static final String TAG = "FaceUpdater";
    private final Context mContext;
    private final FaceManager mFaceManager;
    private final LockPatternUtils mLockPatternUtils;

    public interface IOnTokenGeneratedListener {
        void onTokenGenerated(byte[] r1);
    }

    private static class NotifyingEnrollmentCallback extends FaceManager.EnrollmentCallback {
        private final FaceManager.EnrollmentCallback mCallback;
        private final Context mContext;

        NotifyingEnrollmentCallback(Context r1, FaceManager.EnrollmentCallback r2) {
            this.mContext = r1;
            this.mCallback = r2;
        }

        public void onEnrollmentError(int r1, CharSequence r2) {
            this.mCallback.onEnrollmentError(r1, r2);
        }

        public void onEnrollmentHelp(int r1, CharSequence r2) {
            this.mCallback.onEnrollmentHelp(r1, r2);
        }

        public void onEnrollmentFrame(int r9, CharSequence r10, FaceEnrollCell r11, int r12, float r13, float r14, float r15) {
            this.mCallback.onEnrollmentFrame(r9, r10, r11, r12, r13, r14, r15);
        }

        public void onEnrollmentProgress(int r1) {
            this.mCallback.onEnrollmentProgress(r1);
        }
    }

    private static class NotifyingRemovalCallback extends FaceManager.RemovalCallback {
        private final FaceManager.RemovalCallback mCallback;
        private final Context mContext;

        NotifyingRemovalCallback(Context r1, FaceManager.RemovalCallback r2) {
            this.mContext = r1;
            this.mCallback = r2;
        }

        public void onRemovalError(Face r1, int r2, CharSequence r3) {
            this.mCallback.onRemovalError(r1, r2, r3);
        }

        public void onRemovalSucceeded(Face r1, int r2) {
            this.mCallback.onRemovalSucceeded(r1, r2);
        }
    }

    public FaceUpdater(Context r2) {
        this.mContext = r2;
        this.mFaceManager = Utils.getFaceManagerOrNull(r2);
        this.mLockPatternUtils = new LockPatternUtils(r2);
    }

    public FaceUpdater(Context r1, FaceManager r2) {
        this.mContext = r1;
        this.mFaceManager = r2;
        this.mLockPatternUtils = new LockPatternUtils(r1);
    }

    public void enroll(int r9, byte[] r10, CancellationSignal r11, FaceManager.EnrollmentCallback r12, int[] r13) {
        enroll(r9, r10, r11, new NotifyingEnrollmentCallback(this.mContext, r12), r13, null, false);
    }

    public void enroll(int r10, byte[] r11, CancellationSignal r12, FaceManager.EnrollmentCallback r13, int[] r14, Surface r15, boolean r16) {
        if (r11 != null) goto L5;
    L7:
        this.mFaceManager.enroll(r10, r11, r12, new NotifyingEnrollmentCallback(this.mContext, r13), r14, r15, r16, getFaceEnrollOptions());
        return;
    L5:
        if (r11.length <= 1) goto L7;
        OLog.i(TAG, "enroll: token=" + r11[0] + r11[1]);
        goto L7
    }

    public void remove(Face r3, int r4, FaceManager.RemovalCallback r5) {
        this.mFaceManager.remove(r3, r4, new NotifyingRemovalCallback(this.mContext, r5));
    }

    private FaceEnrollOptions getFaceEnrollOptions() {
        FaceEnrollOptions.Builder r1 = new FaceEnrollOptions.Builder();
        r1.setEnrollReason(0);
        return r1.build();
    }

    public void generateToken(final String r4, final IOnTokenGeneratedListener r5) {
        OLog.i(TAG, "generateToken: ");
        this.mFaceManager.generateChallenge(UserHandle.myUserId(), new FaceUpdater$$ExternalSyntheticLambda5(this, r4, r5));
    }

    /* JADX INFO: renamed from: lambda$generateToken$2$com-android-settings-biometrics-ocean-face-FaceUpdater, reason: not valid java name */
    /* synthetic */ void m344x22718e6c(String r9, final IOnTokenGeneratedListener r10, int r11, int r12, final long r13) {
        OLog.i(TAG, "generateToken: challenge " + r13);
        if (this.mLockPatternUtils.getKeyguardStoredPasswordQuality(UserHandle.myUserId()) != 65536) goto L8;
        if (r9 != null) goto L6;
        byte[] r4 = null;
    L7:
        LockPatternCheckerOnly.verifyPattern(this.mLockPatternUtils, LockPatternUtils.byteArrayToPattern(r4), r13, UserHandle.myUserId(), new FaceUpdater$$ExternalSyntheticLambda3(this, r13, r10));
        return;
    L6:
        r4 = r9.getBytes();
        goto L7
    L8:
        LockPatternCheckerOnly.verifyPassword(this.mLockPatternUtils, r9, r13, Utils.getEffectiveUserId(this.mContext), new FaceUpdater$$ExternalSyntheticLambda4(this, r13, r10));
    }

    /* JADX INFO: renamed from: lambda$generateToken$0$com-android-settings-biometrics-ocean-face-FaceUpdater, reason: not valid java name */
    /* synthetic */ void m342x2004e8ae(long r8, IOnTokenGeneratedListener r10, VerifyCredentialResponse r11, int r12) {
        OLog.i(TAG, "generateToken: pattern onVerified, token = " + r11 + ", use time: " + r12);
        requestTokenWithResponse(this.mContext, r11, r8, r10);
    }

    /* JADX INFO: renamed from: lambda$generateToken$1$com-android-settings-biometrics-ocean-face-FaceUpdater, reason: not valid java name */
    /* synthetic */ void m343x213b3b8d(long r8, IOnTokenGeneratedListener r10, VerifyCredentialResponse r11, int r12) {
        OLog.i(TAG, "generateToken: password onVerified, token = " + r11 + ", use time: " + r12);
        requestTokenWithResponse(this.mContext, r11, r8, r10);
    }

    public void generateToken2(final LockscreenCredential r4, final IOnTokenGeneratedListener r5) {
        OLog.i(TAG, "generateToken: ");
        this.mFaceManager.generateChallenge(UserHandle.myUserId(), new FaceUpdater$$ExternalSyntheticLambda0(this, r4, r5));
    }

    /* JADX INFO: renamed from: lambda$generateToken2$5$com-android-settings-biometrics-ocean-face-FaceUpdater, reason: not valid java name */
    /* synthetic */ void m347xcd23b545(LockscreenCredential r8, final IOnTokenGeneratedListener r9, int r10, int r11, final long r12) {
        OLog.i(TAG, "generateToken: challenge " + r12);
        if (this.mLockPatternUtils.getKeyguardStoredPasswordQuality(UserHandle.myUserId()) != 65536) goto L5;
        LockPatternCheckerOnly.verifyPattern2(this.mLockPatternUtils, r8, r12, UserHandle.myUserId(), new FaceUpdater$$ExternalSyntheticLambda1(this, r12, r9));
        return;
    L5:
        LockPatternCheckerOnly.verifyPassword2(this.mLockPatternUtils, r8, r12, Utils.getEffectiveUserId(this.mContext), new FaceUpdater$$ExternalSyntheticLambda2(this, r12, r9));
    }

    /* JADX INFO: renamed from: lambda$generateToken2$3$com-android-settings-biometrics-ocean-face-FaceUpdater, reason: not valid java name */
    /* synthetic */ void m345xcab70f87(long r8, IOnTokenGeneratedListener r10, VerifyCredentialResponse r11, int r12) {
        OLog.i(TAG, "generateToken: pattern onVerified, token = " + r11 + ", use time: " + r12);
        requestTokenWithResponse(this.mContext, r11, r8, r10);
    }

    /* JADX INFO: renamed from: lambda$generateToken2$4$com-android-settings-biometrics-ocean-face-FaceUpdater, reason: not valid java name */
    /* synthetic */ void m346xcbed6266(long r8, IOnTokenGeneratedListener r10, VerifyCredentialResponse r11, int r12) {
        OLog.i(TAG, "generateToken: password onVerified, token = " + r11 + ", use time: " + r12);
        requestTokenWithResponse(this.mContext, r11, r8, r10);
    }

    private void requestTokenWithResponse(final Context r9, final VerifyCredentialResponse r10, final long r11, final IOnTokenGeneratedListener r13) {
        ThreadUtils.postOnBackgroundThread(new AnonymousClass1(this, r9, r10, r11, r13));
    }
}
