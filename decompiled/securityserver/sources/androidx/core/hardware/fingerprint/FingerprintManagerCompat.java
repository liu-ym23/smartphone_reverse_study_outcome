package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    public static abstract class AuthenticationCallback {
        public AuthenticationCallback() {
        }

        public void onAuthenticationError(int r1, CharSequence r2) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int r1, CharSequence r2) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult r1) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject r1) {
            this.mCryptoObject = r1;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(@NonNull Signature r1) {
            this.mSignature = r1;
            this.mCipher = null;
            this.mMac = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.mCipher;
        }

        @Nullable
        public Mac getMac() {
            return this.mMac;
        }

        @Nullable
        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(@NonNull Cipher r1) {
            this.mCipher = r1;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Mac r1) {
            this.mMac = r1;
            this.mCipher = null;
            this.mSignature = null;
        }
    }

    private FingerprintManagerCompat(Context r1) {
        this.mContext = r1;
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context r1) {
        return new FingerprintManagerCompat(r1);
    }

    @Nullable
    @RequiresApi(23)
    private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context r2) {
        if (r2.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
        return null;
    L5:
        return (FingerprintManager) r2.getSystemService(FingerprintManager.class);
    }

    @RequiresApi(23)
    public static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.getCipher() == null) goto L10;
        return new CryptoObject(r2.getCipher());
    L10:
        if (r2.getSignature() == null) goto L14;
        return new CryptoObject(r2.getSignature());
    L14:
        if (r2.getMac() != null) goto L16;
        return null;
    L16:
        return new CryptoObject(r2.getMac());
    }

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback r1) {
        return new AnonymousClass1(r1);
    }

    @RequiresApi(23)
    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.getCipher() == null) goto L10;
        return new FingerprintManager.CryptoObject(r2.getCipher());
    L10:
        if (r2.getSignature() == null) goto L14;
        return new FingerprintManager.CryptoObject(r2.getSignature());
    L14:
        if (r2.getMac() != null) goto L16;
        return null;
    L16:
        return new FingerprintManager.CryptoObject(r2.getMac());
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject r7, int r8, @Nullable CancellationSignal r9, @NonNull AuthenticationCallback r10, @Nullable Handler r11) {
        FingerprintManager r0 = getFingerprintManagerOrNull(this.mContext);
        if (r0 == null) goto L10;
        if (r9 == null) goto L7;
        android.os.CancellationSignal r6 = (android.os.CancellationSignal) r9.getCancellationSignalObject();
    L6:
        android.os.CancellationSignal r2 = r6;
        r0.authenticate(wrapCryptoObject(r7), r2, r8, wrapCallback(r10), r11);
        return;
    L7:
        r6 = null;
        goto L6
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager r0 = getFingerprintManagerOrNull(this.mContext);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hasEnrolledFingerprints() == false) goto L7;
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager r0 = getFingerprintManagerOrNull(this.mContext);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isHardwareDetected() == false) goto L7;
        return true;
    }
}
