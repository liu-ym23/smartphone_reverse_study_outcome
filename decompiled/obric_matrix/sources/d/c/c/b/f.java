package d.c.c.b;

import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class f<V> implements RunnableFuture<V>, ScheduledFuture<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FutureTask<V> f15374f;

    public f(Handler r1, Runnable r2, V r3) {
        this.f15374f = new FutureTask(r2, r3);
    }

    public f(Handler r1, Callable<V> r2) {
        this.f15374f = new FutureTask(r2);
    }

    public int a(Delayed r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r1) {
        return this.f15374f.cancel(r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Delayed r1) {
        a(r1);
        throw null;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.f15374f.get();
    }

    @Override // java.util.concurrent.Future
    public V get(long r1, TimeUnit r3) {
        return this.f15374f.get(r1, r3);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f15374f.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f15374f.isDone();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        this.f15374f.run();
    }
}
