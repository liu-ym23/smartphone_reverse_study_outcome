package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public final class TTAppSecurityManager {
    private static final String TAG = "TTAppSecurityManager";
    private static volatile TTAppSecurityManager sInstance;
    private ITTSystemApiSandbox mSystemApiSandbox;

    public interface ITTSystemApiSandbox {
        String getNetworkOperator();

        String getSimOperator();

        int getWifiFrequency();

        int getWifiRssi();
    }

    interface Natives {
        boolean isTTPRestrictionEnabled();

        boolean isUserPrivacyRestrictionEnabled();
    }

    static {
    }

    public TTAppSecurityManager() {
    }

    public static TTAppSecurityManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TTAppSecurityManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTAppSecurityManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTAppSecurityManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public String getNetworkOperator() {
        ITTSystemApiSandbox r0 = this.mSystemApiSandbox;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getNetworkOperator();
    }

    public String getSimOperator() {
        ITTSystemApiSandbox r0 = this.mSystemApiSandbox;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getSimOperator();
    }

    public int getWifiFrequency() {
        ITTSystemApiSandbox r0 = this.mSystemApiSandbox;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getWifiFrequency();
    }

    public int getWifiRssi() {
        ITTSystemApiSandbox r0 = this.mSystemApiSandbox;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getWifiRssi();
    }

    boolean isTTPRestrictionEnabled() {
        return TTAppSecurityManagerJni.get().isTTPRestrictionEnabled();
    }

    boolean isUserPrivacyRestrictionEnabled() {
        return TTAppSecurityManagerJni.get().isUserPrivacyRestrictionEnabled();
    }

    public void setSystemApiSandbox(ITTSystemApiSandbox r1) {
        this.mSystemApiSandbox = r1;
    }
}
