package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ TraceEvent.ATrace c;

    public /* synthetic */ g(TraceEvent.ATrace r1, int r2) {
        this.b = r2;
        this.c = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b;
        TraceEvent.ATrace r1 = this.c;
        switch(r0) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        TraceEvent.ATrace.a(r1);
        return;
    L6:
        TraceEvent.ATrace.b(r1);
    }
}
