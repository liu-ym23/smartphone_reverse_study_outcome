package com.android.server.policy.keyguard;

/* JADX INFO: loaded from: classes.dex */
public class ObricKeyguardServiceDelegateImpl implements IObricKeyguardServiceDelegate {
    private static final String TAG = "ObricKeyguardServiceDelegateImpl";
    private KeyguardServiceDelegate mBase;

    public ObricKeyguardServiceDelegateImpl(KeyguardServiceDelegate base) {
        this.mBase = base;
    }

    public void handleWindowVisibleChanged(String packageName, boolean winVisible) {
        if (this.mBase != null) goto L5;
        return;
    L5:
        if (this.mBase.mKeyguardService != null) goto L8;
        return;
    L8:
        if (this.mBase.mKeyguardService.isShowing() == false) goto L12;
        this.mBase.mKeyguardService.handleWindowVisibleChanged(packageName, winVisible);
        return;
    }
}
