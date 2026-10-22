package com.obric.security.securestate;

/* JADX INFO: loaded from: classes.dex */
public class SecureState {
    private static final String KEY_SERVICE_NAME = "vendor.bytedance.hardware.secure_state.ISecureStateService/default";
    private static final String TAG = null;
    private static volatile SecureState mSecureState;

    static {
        TAG = SecureState.class.getSimpleName();
    }

    private SecureState() {
    }

    public static SecureState getInstance() {
        if (mSecureState != null) goto L15;
        monitor-enter(SecureState.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mSecureState != null) goto L9;
        mSecureState = new SecureState();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SecureState.class);     // Catch: Throwable -> L11
    L15:
        return mSecureState;
    }
}
