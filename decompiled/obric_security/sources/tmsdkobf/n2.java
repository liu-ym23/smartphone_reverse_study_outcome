package tmsdkobf;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class n2 extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f361a;

    public interface a {
        void a(Runnable r1, Throwable r2);

        void a(Thread r1, Runnable r2);
    }

    public n2(int r10, int r11, long r12, TimeUnit r14, BlockingQueue r15, RejectedExecutionHandler r16) {
        super(r10, r11, r12, r14, r15, new m2(), r16);
        this.f361a = null;
    }

    public void a(a r1) {
        this.f361a = r1;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r1, Throwable r2) {
        super.afterExecute(r1, r2);
        a r0 = this.f361a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread r1, Runnable r2) {
        super.beforeExecute(r1, r2);
        a r0 = this.f361a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r1) {
        super.execute(r1);
    }
}
