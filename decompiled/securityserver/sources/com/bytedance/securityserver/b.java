package com.bytedance.securityserver;

import com.obric.matrix.platform.sdk.ones.account.OAccountManager;
import com.obric.matrix.platform.sdk.ones.internal.monitor.SdkMonitorManager;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.CmdManager;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.MatrixBinderManager;
import com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int b;

    public /* synthetic */ b(int r1) {
        this.b = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        SdkMonitorManager.a();
        return;
    L6:
        LibraryPrefetcher.b();
        return;
    L8:
        MatrixBinderManager.b();
        return;
    L10:
        MatrixBinderManager.a();
        return;
    L12:
        CmdManager.c();
        return;
    L14:
        OAccountManager.d();
        return;
    L16:
        SecurityAppDelegateImpl.b();
    }
}
