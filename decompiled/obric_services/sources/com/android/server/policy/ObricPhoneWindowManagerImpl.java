package com.android.server.policy;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ObricPhoneWindowManagerImpl implements IObricPhoneWindowManager {
    private PhoneWindowManager mBase;

    public ObricPhoneWindowManagerImpl(PhoneWindowManager base) {
        this.mBase = base;
    }

    public void adjustAssistBundle(Bundle args) {
        args.putInt("custom_show_flags", 0);
    }

    public void handleWindowVisibleChanged(String packageName, boolean winVisible) {
        if (this.mBase != null) goto L5;
        return;
    L5:
        if (this.mBase.mKeyguardDelegate == null) goto L10;
        this.mBase.mKeyguardDelegate.getObricExt().handleWindowVisibleChanged(packageName, winVisible);
        return;
    }
}
