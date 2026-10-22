package c;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f421b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f422c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f423d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f424e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f425a;

    /* JADX INFO: renamed from: c.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0026a {
    }

    private static class b implements Executor {
        private b() {
        }

        /* synthetic */ b(C0026a r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            new Handler(Looper.getMainLooper()).post(r2);
        }
    }

    static {
        f421b = new a();
        int r0 = Runtime.getRuntime().availableProcessors();
        f422c = r0;
        f423d = r0 + 1;
        f424e = (r0 * 2) + 1;
    }

    private a() {
        this.f425a = new b(null);
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 9) goto L6;
        r2.allowCoreThreadTimeOut(r3);
        return;
    }

    public static ExecutorService b() {
        ThreadPoolExecutor r7 = new ThreadPoolExecutor(f423d, f424e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(r7, true);
        return r7;
    }

    public static Executor c() {
        return f421b.f425a;
    }
}
