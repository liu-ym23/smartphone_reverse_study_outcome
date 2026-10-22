package com.obric.matrix.platform.sdk.ones.account;

import com.obric.matrix.platform.sdk.ones.account.api.IUpdateAccountInfoCallback;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ IUpdateAccountInfoCallback c;

    public /* synthetic */ c(IUpdateAccountInfoCallback r1, int r2) {
        this.b = r2;
        this.c = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b;
        IUpdateAccountInfoCallback r1 = this.c;
        switch(r0) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        OAccountManager.e(r1);
        return;
    L6:
        OAccountManager.c(r1);
    }
}
