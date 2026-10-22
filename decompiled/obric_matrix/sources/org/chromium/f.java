package org.chromium;

import com.ttnet.org.chromium.net.TTAppSecurityManager;

/* JADX INFO: loaded from: classes2.dex */
public class f implements TTAppSecurityManager.ITTSystemApiSandbox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f22672a;

    private f() {
    }

    public static f a() {
        if (f22672a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22672a != null) goto L9;
        f22672a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f22672a;
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public String getNetworkOperator() {
        return c.W().x();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public String getSimOperator() {
        return c.W().G();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public int getWifiFrequency() {
        return c.W().S();
    }

    @Override // com.ttnet.org.chromium.net.TTAppSecurityManager.ITTSystemApiSandbox
    public int getWifiRssi() {
        return c.W().T();
    }
}
