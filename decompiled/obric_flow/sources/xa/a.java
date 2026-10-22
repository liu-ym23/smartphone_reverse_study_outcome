package xa;

import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f23001a;

    public a() {
        PriorityBlockingQueue r10 = new PriorityBlockingQueue();
        this.f23001a = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, r10, new com.bumptech.glide.load.engine.a(4));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        this.f23001a.execute(r5);
    }
}
