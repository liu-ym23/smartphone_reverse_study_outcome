package com.obric.matrix.platform.sdk.ones.account;

import com.obric.matrix.platform.sdk.ones.account.api.IUpdateTokenMapCallback;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ IUpdateTokenMapCallback c;

    public /* synthetic */ d(IUpdateTokenMapCallback r1, int r2) {
        this.b = r2;
        this.c = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b;
        IUpdateTokenMapCallback r1 = this.c;
        switch(r0) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        OAccountManager.b(r1);
        return;
    L6:
        OAccountManager.a(r1);
    }
}
