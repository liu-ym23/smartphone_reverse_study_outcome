package com.bytedance.lighten.loader;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class i extends d.c.c.b.c {
    public i(Executor r3, int r4) {
        super("FixSizeSerialExecutor", 1, r3, new h(r4));
    }

    @Override // d.c.c.b.c, java.util.concurrent.Executor
    public synchronized void execute(Runnable r1) {
        monitor-enter(this);
        super.execute(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
