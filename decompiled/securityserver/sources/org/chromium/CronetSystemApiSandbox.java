package org.chromium;

import com.ttnet.org.chromium.net.TTAppSecurityManager;

/* JADX INFO: loaded from: classes2.dex */
public class CronetSystemApiSandbox implements TTAppSecurityManager.ITTSystemApiSandbox {
    private static volatile CronetSystemApiSandbox sInstance;

    private CronetSystemApiSandbox() {
    }

    public static CronetSystemApiSandbox inst() {
        if (sInstance != null) goto L16;
        monitor-enter(CronetSystemApiSandbox.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new CronetSystemApiSandbox();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CronetSystemApiSandbox.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public String getNetworkOperator() {
        return CronetAppProviderManager.inst().getNetworkOperator();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public String getSimOperator() {
        return CronetAppProviderManager.inst().getSimOperator();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public int getWifiFrequency() {
        return CronetAppProviderManager.inst().getWifiFrequency();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public int getWifiRssi() {
        return CronetAppProviderManager.inst().getWifiRssi();
    }
}
