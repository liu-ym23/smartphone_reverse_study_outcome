package d.b.l.a.h.g;

import android.os.Process;
import androidx.annotation.NonNull;
import d.b.l.a.h.f;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f14119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f14120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f f14121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f14122i;

    /* JADX INFO: renamed from: d.b.l.a.h.g.a$a, reason: collision with other inner class name */
    class RunnableC0376a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f14123f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f14124g;

        RunnableC0376a(a r1, Runnable r2) {
            this.f14124g = r1;
            this.f14123f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            if (a.a(this.f14124g) == null) goto L14;
            a.a(this.f14124g).a(Thread.currentThread().getId());
        L14:
            Runnable r0 = this.f14123f;     // Catch: Throwable -> L9
            if (r0 == null) goto L16;
            r0.run();     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            d.b.l.a.h.c.a().a(th, "APM_INNER_ERROR_async_task");
            if (a.b(this.f14124g) == null) goto L17;
            a.b(this.f14124g).onError(this.f14124g.f14119f, th.getMessage());
            return;
        }
    }

    public interface b {
        void a(long r1);
    }

    public a(@NonNull String r3) {
        this.f14119f = a.class.getSimpleName();
        this.f14120g = "APM_" + r3;
    }

    static /* synthetic */ b a(a r0) {
        return r0.f14122i;
    }

    static /* synthetic */ f b(a r0) {
        return r0.f14121h;
    }

    public void c(f r1) {
        this.f14121h = r1;
    }

    public void d(b r1) {
        this.f14122i = r1;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        return new Thread(new RunnableC0376a(this, r3), this.f14120g);
    }
}
