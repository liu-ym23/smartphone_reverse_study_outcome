package d.c.c.b;

import android.os.Handler;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class e extends AbstractExecutorService implements ScheduledExecutorService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f15373f;

    public e(Handler r1) {
        this.f15373f = r1;
    }

    public boolean a() {
        if (Thread.currentThread() != this.f15373f.getLooper().getThread()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) {
        throw new UnsupportedOperationException();
    }

    protected <T> f<T> b(Runnable r2, T r3) {
        return new f(this.f15373f, r2, r3);
    }

    protected <T> f<T> c(Callable<T> r2) {
        return new f(this.f15373f, r2);
    }

    public ScheduledFuture<?> d(Runnable r2) {
        return e(r2, null);
    }

    public <T> ScheduledFuture<T> e(Runnable r1, T r2) {
        Objects.requireNonNull(r1);
        f<T> r3 = b(r1, r2);
        execute(r3);
        return r3;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r1) {
        this.f15373f.post(r1);
    }

    public <T> ScheduledFuture<T> f(Callable<T> r1) {
        Objects.requireNonNull(r1);
        f<T> r2 = c(r1);
        execute(r2);
        return r2;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Runnable r1, Object r2) {
        return b(r1, r2);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected /* bridge */ /* synthetic */ RunnableFuture newTaskFor(Callable r1) {
        return c(r1);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable r2, long r3, TimeUnit r5) {
        f r4 = b(r2, null);
        this.f15373f.postDelayed(r4, r5.toMillis(r3));
        return r4;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> r1, long r2, TimeUnit r4) {
        f r3 = c(r1);
        this.f15373f.postDelayed(r3, r4.toMillis(r2));
        return r3;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable r1, long r2, long r4, TimeUnit r6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable r1, long r2, long r4, TimeUnit r6) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable r1) {
        return d(r1);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable r1, Object r2) {
        return e(r1, r2);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Callable r1) {
        return f(r1);
    }
}
