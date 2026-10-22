package com.bytedance.securityserver.trustcircle;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ TrustCircleManager.Callback c;

    public /* synthetic */ c(com.bytedance.securityserver.a r1, int r2) {
        this.b = r2;
        this.c = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.c.b(0);
        return;
    L6:
        this.c.b(0);
    }
}
