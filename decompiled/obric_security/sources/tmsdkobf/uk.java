package tmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public abstract class uk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f561a;
    private static Looper b;

    static {
        f561a = new Handler(Looper.getMainLooper());
        b = null;
    }

    public static HandlerThread a(String r1, int r2) {
        return sl.a().a(r1, r2);
    }

    public static void b(Runnable r1, String r2) {
        sl.a().a(r1, r2);
    }

    public static void a(Runnable r1, String r2) {
        sl.a().b(r1, r2);
    }

    public static ExecutorService a(String r0) {
        return Executors.newSingleThreadExecutor();
    }

    public static void a(Runnable r1) {
        f561a.post(r1);
    }

    public static Looper a() {
        monitor-enter(uk.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (b != null) goto L7;
        HandlerThread r1 = a("Shark-CommonLooper", -1);     // Catch: Throwable -> L10
        r1.start();     // Catch: Throwable -> L10
        b = r1.getLooper();     // Catch: Throwable -> L10
    L7:
        monitor-exit(uk.class);     // Catch: Throwable -> L10
        return b;
    }
}
