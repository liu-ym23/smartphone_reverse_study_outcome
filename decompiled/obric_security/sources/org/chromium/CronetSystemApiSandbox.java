package org.chromium;

import com.ttnet.org.chromium.net.TTAppSecurityManager;

/* JADX INFO: loaded from: classes5.dex */
public class CronetSystemApiSandbox implements TTAppSecurityManager.ITTSystemApiSandbox {
    private static volatile CronetSystemApiSandbox sInstance;

    public static CronetSystemApiSandbox inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetSystemApiSandbox.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetSystemApiSandbox();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetSystemApiSandbox.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private CronetSystemApiSandbox() {
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public int getWifiFrequency() {
        return CronetAppProviderManager.inst().getWifiFrequency();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public int getWifiRssi() {
        return CronetAppProviderManager.inst().getWifiRssi();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public String getNetworkOperator() {
        return CronetAppProviderManager.inst().getNetworkOperator();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public String getSimOperator() {
        return CronetAppProviderManager.inst().getSimOperator();
    }
}
