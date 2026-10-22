package com.bytedance.securityserver.trustcircle;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ TrustCircleManager.Callback c;
    public final /* synthetic */ TrustCircleException e;

    public /* synthetic */ d(com.bytedance.securityserver.a r1, TrustCircleException r2, int r3) {
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
        TrustCircleException r0 = this.e;
        int r1 = r0.b;
        r0.toString();
        this.c.b(r1);
        return;
    L6:
        TrustCircleException r2 = this.e;
        int r3 = r2.b;
        r2.toString();
        this.c.b(r3);
    }
}
