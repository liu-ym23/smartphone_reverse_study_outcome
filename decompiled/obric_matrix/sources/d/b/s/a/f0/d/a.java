package d.b.s.a.f0.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f14747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f14748b = null;

    /* JADX INFO: renamed from: d.b.s.a.f0.d.a$a, reason: collision with other inner class name */
    class RunnableC0398a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f14749f;

        RunnableC0398a(a r1) {
            this.f14749f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r1 = this.f14749f;     // Catch: Exception -> L4
            a.a(r1, r1.b());     // Catch: Exception -> L4
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f14750f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f14751g;

        b(a r1, Object r2) {
            this.f14751g = r1;
            this.f14750f = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f14751g.d(this.f14750f);
        }
    }

    static {
        f14747a = Executors.newSingleThreadExecutor();
        f14748b = new Handler(Looper.getMainLooper());
    }

    public a() {
    }

    static /* synthetic */ void a(a r0, Object r1) {
        r0.e(r1);
    }

    private void e(T r3) {
        f14748b.post(new b(this, r3));
    }

    protected abstract T b();

    public final void c() {
        f14747a.execute(new RunnableC0398a(this));
    }

    protected abstract void d(T r1);
}
