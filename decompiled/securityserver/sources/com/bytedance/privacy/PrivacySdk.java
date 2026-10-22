package com.bytedance.privacy;

import android.content.Context;
import com.bytedance.privacy.attestation.IdAttestationManager;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.privacy.bridge.IEnvBridge;
import com.bytedance.privacy.bridge.IEventBridge;
import com.bytedance.privacy.bridge.ILogBridge;
import com.bytedance.privacy.exception.BdPrivacyException;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.PccManager;
import com.bytedance.privacy.pseudoid.PseudoManager;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.bytedance.privacy.utils.EventUtils;
import com.bytedance.privacy.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class PrivacySdk {
    private static volatile boolean initialized = false;

    public PrivacySdk() {
    }

    private static void checkInitialized() {
        if (initialized == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Privacy SDK not initialized. Please call PrivacySdk.init(...) during app startup.");
    }

    public static IdAttestationManager getIdAttestationManager() {
        checkInitialized();
        if (IdAttestationManager.f8a != null) goto L16;
        monitor-enter(IdAttestationManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (IdAttestationManager.f8a != null) goto L11;
        IdAttestationManager.f8a = new IdAttestationManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(IdAttestationManager.class);     // Catch: Throwable -> L9
    L16:
        return IdAttestationManager.f8a;
    }

    public static PccManager getPccManager(Context r0) {
        checkInitialized();
        return PccManager.getInstance(r0);
    }

    public static PseudoManager getPseudoManager() {
        checkInitialized();
        return PseudoManager.getInstance();
    }

    public static void init(IAccountBridge r2, IEnvBridge r3) {
        if (initialized == false) goto L5;
        return;
    L5:
        monitor-enter(PrivacySdk.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (initialized == true) goto L17;
        if (r2 == null) goto L16;
        if (r3 == null) goto L14;
        AccountApi.f23a = r2;     // Catch: Throwable -> L11
        NetworkConfig.a().f12a = r3;     // Catch: Throwable -> L11
        initialized = true;     // Catch: Throwable -> L11
        goto L17
    L14:
        throw new BdPrivacyException("IEnvBridge cannot be null");     // Catch: Throwable -> L11
    L16:
        throw new BdPrivacyException("IAccountBridge cannot be null");     // Catch: Throwable -> L11
    L17:
        monitor-exit(PrivacySdk.class);     // Catch: Throwable -> L11
    }

    public static void initEventReporter(IEventBridge r0) {
        EventUtils.f31a = r0;
    }

    public static void initLogger(ILogBridge r0) {
        LogUtils.f32a = r0;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
