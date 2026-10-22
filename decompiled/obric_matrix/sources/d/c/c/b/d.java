package d.c.c.b;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class d extends c implements ExecutorService {
    public d(Executor r4) {
        super("SerialExecutor", 1, r4, new LinkedBlockingQueue());
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
