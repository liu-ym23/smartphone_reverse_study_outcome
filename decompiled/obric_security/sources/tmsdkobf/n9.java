package tmsdkobf;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f365a = null;
    public static final AtomicReference b = null;
    public static String c;

    static {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        f365a = r0;
        b = new AtomicReference();
        r0.put("C892BA2", new yc());
        r0.put("43780D5", new yc());
        r0.put("7CD3AF2", new yc());
        r0.put("22792AF", new ja());
        c = "";
        c = k8.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);     // Catch: Throwable -> L5
        return;
    }

    public static u9 a(Context r3) {
        AtomicReference r0 = b;
        u9 r1 = (u9) r0.get();
        if (r1 == null) goto L5;
        return r1;
    L5:
        monitor-enter(r0);
        u9 r2 = (u9) r0.get();     // Catch: Throwable -> L23
        if (r2 == null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r2;
    L11:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L15;
        u9 r4 = u9.a(-11);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r4;
    L15:
        Map r5 = f365a;     // Catch: Throwable -> L23
        ConcurrentHashMap r6 = (ConcurrentHashMap) r5;     // Catch: Throwable -> L23
        zi r7 = (zi) r6.get(c);     // Catch: Throwable -> L23
        if (r7 != null) goto L20;
        u9 r8 = u9.a(-10);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r8;
    L20:
        u9 r9 = r7.a(r3);     // Catch: Throwable -> L23
        r0.set(r9);     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return r9;
    L23:
        th = move-exception;
        throw th;
    }
}
