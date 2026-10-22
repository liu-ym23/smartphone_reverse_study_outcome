package w7;

import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final HashMap d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f22750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f22751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f22752c;

    static {
        d = new HashMap();
    }

    public static synchronized b a(AsyncTaskManagerType r10) {
        monitor-enter(b.class);
        if (r10 == null) goto L14;
        HashMap r5 = d;     // Catch: Throwable -> L9
        b r11 = (b) r5.get(r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        String r12 = r10.name();     // Catch: Throwable -> L9
        r11 = new b();     // Catch: Throwable -> L9
        r11.f22751b = new ConcurrentHashMap();     // Catch: Throwable -> L9
        r11.f22752c = new ConcurrentHashMap();     // Catch: Throwable -> L9
        r11.f22750a = new ScheduledThreadPoolExecutor(1, new jf.a(r12));     // Catch: Throwable -> L9
        r5.put(r10, r11);     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);
        return r11;
    L14:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final void b(a r10) {
        if (r10 != null) goto L15;
        return;
    L15:
        jm.a r11 = new jm.a();     // Catch: Throwable -> L8
        r11.f18353b = r10;     // Catch: Throwable -> L8
        boolean r5 = r10.f22748b;     // Catch: Throwable -> L8
        ScheduledThreadPoolExecutor r12 = this.f22750a;
        if (r5 == false) goto L10;
        ScheduledFuture<?> r13 = r12.scheduleWithFixedDelay(r11, r10.f22747a, r10.f22749c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
    L11:
        this.f22752c.put(r10, r11);     // Catch: Throwable -> L8
        this.f22751b.put(r10, r13);     // Catch: Throwable -> L8
        return;
    L10:
        r13 = r12.schedule(r11, r10.f22747a, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.n("APM-AsyncTask", "sendTask failed.", th);
    }
}
