package androidx.work.impl.utils;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SynchronousExecutor implements Executor {
    public SynchronousExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        command.run();
    }
}
