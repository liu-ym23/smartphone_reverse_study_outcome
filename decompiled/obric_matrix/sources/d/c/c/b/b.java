package d.c.c.b;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b extends AbstractExecutorService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final b f15364f = null;

    static {
        f15364f = new b();
    }

    private b() {
    }

    public static b a() {
        return f15364f;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) {
        return true;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) {
        r1.run();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }
}
