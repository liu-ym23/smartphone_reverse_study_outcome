package com.bytedance.securityserver.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int b;

    public /* synthetic */ c() {
        this.b = 1;
    }

    private final void a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L14;
            case 1: goto L16;
            default: goto L4;
        };
    L4:
        return;
    L14:
        int r2 = WiFiMonitor.AnonymousClass1.b;
        return;
    L16:
        EventUploadUtils.b();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (th.getMessage() != null) goto L11;
        String r3 = th.getClass().getSimpleName();
    L12:
        Log.e("SecurityAuditUpload", "SecurityAudit report task failed: " + r3);
        return;
    L11:
        r3 = th.getMessage();
        goto L12
    }

    public /* synthetic */ c(int r1, int r2) {
        this.b = r2;
    }
}
