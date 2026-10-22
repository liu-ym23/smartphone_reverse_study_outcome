package com.android.settings.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintUiHelper extends FingerprintManager.AuthenticationCallback {
    private static final long ERROR_TIMEOUT = 1300;
    private Callback mCallback;
    private CancellationSignal mCancellationSignal;
    private TextView mErrorTextView;
    private FingerprintManager mFingerprintManager;
    private ImageView mIcon;
    private Runnable mResetErrorTextRunnable;
    private int mUserId;

    public interface Callback {
        void onAuthenticated();

        void onFingerprintIconVisibilityChanged(boolean r1);
    }

    static /* synthetic */ TextView access$000(FingerprintUiHelper r0) {
        return r0.mErrorTextView;
    }

    static /* synthetic */ ImageView access$100(FingerprintUiHelper r0) {
        return r0.mIcon;
    }

    public FingerprintUiHelper(ImageView r3, TextView r4, Callback r5, int r6) {
        this.mResetErrorTextRunnable = new AnonymousClass1(this);
        this.mFingerprintManager = (FingerprintManager) r3.getContext().getSystemService(FingerprintManager.class);
        this.mIcon = r3;
        this.mErrorTextView = r4;
        this.mCallback = r5;
        this.mUserId = r6;
    }

    public void startListening() {
        FingerprintManager r0 = this.mFingerprintManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isHardwareDetected() == true) goto L7;
        return;
    L7:
        if (this.mFingerprintManager.getEnrolledFingerprints(this.mUserId).size() <= 0) goto L12;
        this.mCancellationSignal = new CancellationSignal();
        setFingerprintIconVisibility(true);
        this.mIcon.setImageResource(R.drawable.ic_fingerprint);
        return;
    }

    public void stopListening() {
        CancellationSignal r0 = this.mCancellationSignal;
        if (r0 == null) goto L6;
        r0.cancel();
        this.mCancellationSignal = null;
        return;
    }

    private boolean isListening() {
        CancellationSignal r0 = this.mCancellationSignal;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCanceled() == true) goto L7;
        return true;
    }

    private void setFingerprintIconVisibility(boolean r3) {
        ImageView r0 = this.mIcon;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        this.mCallback.onFingerprintIconVisibilityChanged(r3);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int r1, CharSequence r2) {
        showError(r2);
        setFingerprintIconVisibility(false);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int r1, CharSequence r2) {
        showError(r2);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        showError(this.mIcon.getResources().getString(R.string.fingerprint_not_recognized));
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult r2) {
        this.mIcon.setImageResource(R.drawable.ic_fingerprint_success);
        this.mCallback.onAuthenticated();
    }

    private void showError(CharSequence r3) {
        if (isListening() == true) goto L5;
        return;
    L5:
        this.mIcon.setImageResource(R.drawable.ic_fingerprint_error);
        this.mErrorTextView.setText(r3);
        this.mErrorTextView.removeCallbacks(this.mResetErrorTextRunnable);
        this.mErrorTextView.postDelayed(this.mResetErrorTextRunnable, ERROR_TIMEOUT);
    }
}
