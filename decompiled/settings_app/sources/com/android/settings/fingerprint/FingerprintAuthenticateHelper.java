package com.android.settings.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import com.obric.olog.OLog;
import obric.api.FingerprintManagerSmt;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintAuthenticateHelper {
    private static final long LOCKOUT_DURATION = 30000;
    private static final int MSG_FINGER_AUTH_ERROR = 1003;
    private static final int MSG_FINGER_AUTH_FAIL = 1002;
    private static final int MSG_FINGER_AUTH_HELP = 1004;
    private static final int MSG_FINGER_AUTH_SUCCESS = 1001;
    private static final int MSG_REFRESH_FINGERPRINT_TEMPLATES = 1000;
    private static FingerprintAuthenticateHelper mInstance;
    private final String TAG;
    private FingerprintManager.AuthenticationCallback mAuthCallback;
    private Callback mCallback;
    private Context mContext;
    private CancellationSignal mFingerprintCancel;
    private final Runnable mFingerprintLockoutReset;
    private FingerprintManager mFingerprintManager;
    private final Handler mHandler;
    private boolean mIgnoreLockout;
    private boolean mInFingerprintLockout;
    private boolean mRetryWhenAuthSuccess;

    public interface Callback {
        void onAnyFingerprintDetected();

        void onAuthenticationAcquired(int r1);

        void onAuthenticationError(int r1, CharSequence r2);

        void onAuthenticationFailed();

        void onAuthenticationHelp(int r1, CharSequence r2);

        void onAuthenticationSucceeded(int r1);

        void onFingerprintLockoutReset();
    }

    static /* synthetic */ Handler access$000(FingerprintAuthenticateHelper r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Callback access$100(FingerprintAuthenticateHelper r0) {
        return r0.mCallback;
    }

    static /* synthetic */ CancellationSignal access$202(FingerprintAuthenticateHelper r0, CancellationSignal r1) {
        r0.mFingerprintCancel = r1;
        return r1;
    }

    static /* synthetic */ boolean access$300(FingerprintAuthenticateHelper r0) {
        return r0.mRetryWhenAuthSuccess;
    }

    static /* synthetic */ void access$400(FingerprintAuthenticateHelper r0) {
        r0.retryFingerprint();
    }

    static /* synthetic */ boolean access$502(FingerprintAuthenticateHelper r0, boolean r1) {
        r0.mInFingerprintLockout = r1;
        return r1;
    }

    public static FingerprintAuthenticateHelper getInstance(Context r1) {
        if (mInstance != null) goto L6;
        mInstance = new FingerprintAuthenticateHelper(r1.getApplicationContext());
    L6:
        return mInstance;
    }

    private FingerprintAuthenticateHelper(Context r2) {
        this.TAG = "Fingerprint";
        this.mAuthCallback = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
        this.mFingerprintLockoutReset = new AnonymousClass3(this);
        Context r3 = r2.getApplicationContext();
        this.mContext = r3;
        this.mFingerprintManager = (FingerprintManager) r3.getSystemService("fingerprint");
    }

    public void startAuthenticate(Callback r2) {
        startAuthenticate(r2, false, false);
    }

    public void startAuthenticate(Callback r3, boolean r4, boolean r5) {
        OLog.d("Fingerprint", "startAuthenticate... mInFingerprintLockout: " + this.mInFingerprintLockout + ", ignoreLockout: " + r4);
        this.mCallback = r3;
        this.mIgnoreLockout = r4;
        this.mRetryWhenAuthSuccess = r5;
        retryFingerprint();
    }

    public void stopAuthenticate() {
        OLog.d("Fingerprint", "stopAuthenticate.");
        stopFingerprint();
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public boolean isFingerprintUnlockLockout() {
        return this.mInFingerprintLockout;
    }

    private void stopFingerprint() {
        CancellationSignal r0 = this.mFingerprintCancel;
        if (r0 != null) goto L5;
    L7:
        this.mFingerprintCancel = null;
        this.mCallback = null;
        return;
    L5:
        if (r0.isCanceled() == true) goto L7;
        OLog.d("Fingerprint", "mFingerprintCancel stopFingerprint");
        this.mFingerprintCancel.cancel();
        goto L7
    }

    protected void handleError(int r3, CharSequence r4) {
        OLog.d("Fingerprint", "handleError " + r4 + ", errMsgId=" + r3);
        if (r3 != 5) goto L5;
        return;
    L5:
        if (r3 == 7) goto L17;
        switch(r3) {
            case 10001: goto L13;
            case 10002: goto L8;
            case 10003: goto L17;
            default: goto L11;
        };
    L8:
        Callback r5 = this.mCallback;
        if (r5 == null) goto L11;
        r5.onAnyFingerprintDetected();
        goto L11
    L13:
        Callback r2 = this.mCallback;
        if (r2 == null) goto L24;
        r2.onAnyFingerprintDetected();
        return;
    L24:
        return;
    L11:
        retryFingerprint();
        return;
    L17:
        this.mInFingerprintLockout = true;
        Callback r0 = this.mCallback;
        if (r0 == null) goto L21;
        r0.onAuthenticationError(r3, r4);
    L21:
        if (this.mHandler.hasCallbacks(this.mFingerprintLockoutReset) == true) goto L26;
        this.mHandler.postDelayed(this.mFingerprintLockoutReset, 30000);
        return;
    }

    private void retryFingerprint() {
        if (this.mFingerprintManager != null) goto L5;
        return;
    L5:
        OLog.d("Fingerprint", "retryFingerprint");
        CancellationSignal r5 = new CancellationSignal();
        this.mFingerprintCancel = r5;
        if (this.mIgnoreLockout == false) goto L8;
        this.mFingerprintManager.authenticate(null, r5, 0, this.mAuthCallback, null);
        return;
    L8:
        FingerprintManagerSmt.getInstance().authenticateWithType(this.mFingerprintManager, null, this.mFingerprintCancel, 0, this.mAuthCallback, null, 4);
    }
}
