package obric.api;

import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import android.util.Singleton;

/* JADX INFO: loaded from: classes5.dex */
public class FingerprintManagerSmt {
    public static final int CLIENT_TYPE_NEED_FEEDBACK_IN_LOCKOUT = 4;
    public static final int CLIENT_TYPE_NEVER_TIMEOUT = 1;
    public static final int CLIENT_TYPE_NEVER_TIMEOUT_AND_VIBRATE = 3;
    public static final int CLIENT_TYPE_NEVER_VIBRATE = 2;
    public static final int CLIENT_TYPE_SCREEN_AOD = 32;
    public static final int CLIENT_TYPE_SCREEN_FOD = 48;
    public static final int CLIENT_TYPE_SCREEN_ON = 16;
    public static final int FINGERPRINT_ERROR_AUTHENTICATION_IN_LOCKOUT = 10003;
    public static final int FINGERPRINT_ERROR_FAILED_IN_LOCKOUT = 10001;
    public static final int FINGERPRINT_ERROR_GOOD_IN_LOCKOUT = 10002;
    public static final String FINGERPRINT_OP_PACKAGE_NAME = "fp_opPackageName";
    public static final String FINGERPRINT_SCREEN_MODE = "fp_screen_mode";
    private static final Singleton<FingerprintManagerSmt> sFingerprintManagerSmt = null;

    public void authenticateWithType(FingerprintManager r1, FingerprintManager.CryptoObject r2, CancellationSignal r3, int r4, FingerprintManager.AuthenticationCallback r5, Handler r6, int r7) {
    }

    /* synthetic */ FingerprintManagerSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sFingerprintManagerSmt = new AnonymousClass1();
    }

    public static FingerprintManagerSmt getInstance() {
        return (FingerprintManagerSmt) sFingerprintManagerSmt.get();
    }

    private FingerprintManagerSmt() {
    }
}
