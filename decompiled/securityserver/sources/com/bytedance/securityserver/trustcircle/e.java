package com.bytedance.securityserver.trustcircle;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ TrustCircleManager.Callback c;
    public final /* synthetic */ Exception e;

    public /* synthetic */ e(com.bytedance.securityserver.a r1, Exception r2, int r3) {
        this.b = r3;
        this.c = r1;
        this.e = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.e.getMessage();
        this.c.b(1000);
        return;
    L6:
        this.e.getMessage();
        this.c.b(1000);
    }
}
