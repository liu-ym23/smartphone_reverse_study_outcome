package t2;

import com.bytedance.ai.infra.thread_pool.ThreadPriority;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f22095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f22096b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f22097c = null;
    public static final e d = null;
    public static final c e = null;
    public static final e f = null;

    static {
        int r5 = Runtime.getRuntime().availableProcessors();
        Intrinsics.checkNotNullParameter("APPLET-IO", "poolName");
        e8.a r10 = new e8.a(1);
        TimeUnit r11 = TimeUnit.SECONDS;
        SynchronousQueue r12 = new SynchronousQueue();
        ThreadPriority r13 = ThreadPriority.f2165b;
        f22095a = new e(0, 128, r12, new d("APPLET-IO", r13), r10);
        int r14 = (r5 * 2) + 1;
        int r15 = Math.max(Math.min(r14, 4), Math.min(r5 + 1, 9));
        Intrinsics.checkNotNullParameter("APPLET-CALC", "poolName");
        e8.a r16 = new e8.a(1);
        e r17 = new e(r15, r14, new LinkedBlockingQueue(256), new d("APPLET-CALC", r13), r16);
        r17.allowCoreThreadTimeOut(true);
        f22096b = r17;
        e r18 = new e(4, 4, 15, new LinkedBlockingQueue(256), new d("APPLET-BACKGROUND", ThreadPriority.f2164a));
        r18.allowCoreThreadTimeOut(true);
        f22097c = r18;
        e r19 = new e(1, 1, 30, new LinkedBlockingQueue(), new d("APPLET-SERIAL", r13));
        r19.allowCoreThreadTimeOut(true);
        d = r19;
        e = new c(1, new d("APPLET-SCHEDULE", r13));
        e r20 = new e(4, 4, 30, new LinkedBlockingQueue(), new d("APPLET-SAFEGUARD", r13));
        r20.allowCoreThreadTimeOut(true);
        f = r20;
    }
}
