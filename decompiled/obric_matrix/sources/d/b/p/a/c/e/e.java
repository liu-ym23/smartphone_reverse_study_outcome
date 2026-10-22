package d.b.p.a.c.e;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static void a() {
        Log.d("QueuedWkProxyBAndroid0", "start hook, time stamp = " + System.currentTimeMillis());
        Field r2 = Class.forName("android.app.QueuedWork").getDeclaredField("sPendingWorkFinishers");     // Catch: Exception -> L13
        r2.setAccessible(true);     // Catch: Exception -> L11
        ConcurrentLinkedQueue r3 = (ConcurrentLinkedQueue) r2.get(null);     // Catch: Exception -> L11
        if (r3 != null) goto L28;
    L19:
        Log.d("QueuedWkProxyBAndroid0", "end hook, time stamp = " + System.currentTimeMillis());
        return;
    L28:
        r2.set(null, new a(r3));     // Catch: Exception -> L9
        Log.d("QueuedWkProxyBAndroid0", "Below android 0,replaceQueueWorkPendingWorkFinishers success.");     // Catch: Exception -> L9
    L9:
        e = e;
    L15:
        if (r3 == null) goto L18;
        if (r2 == null) goto L18;
        r2.set(null, r3);     // Catch: Exception -> L21
    L18:
        Log.e("QueuedWkProxyBAndroid0", "Below android 0,,hook sPendingWorkFinishers fail.", e);
    L11:
        e = e;
        r3 = null;
    L13:
        e = e;
        r2 = null;
        r3 = null;
        goto L15
    }
}
