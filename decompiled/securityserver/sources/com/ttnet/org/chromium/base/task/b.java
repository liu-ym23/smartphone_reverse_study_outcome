package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int r1, Object r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b;
        Object r1 = this.c;
        switch(r0) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        ((TaskRunnerImpl) r1).runPreNativeTask();
        return;
    L6:
        ChainedTasks.a((ChainedTasks) r1);
        return;
    L8:
        ChromeThreadPoolExecutor.AnonymousClass1.a((Runnable) r1);
    }
}
