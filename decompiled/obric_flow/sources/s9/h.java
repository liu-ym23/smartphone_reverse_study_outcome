package s9;

import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static sj.d f21879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f21880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AtomicBoolean f21881c;
    public static final Object d = null;
    public static final CountDownLatch e = null;
    public static sj.d f;
    public static Object g;

    static {
        f21881c = new AtomicBoolean(false);
        d = new Object();
        e = new CountDownLatch(1);
    }

    public static void a(String r5) {
        if (com.bytedance.common.utility.b.b(r5) == false) goto L5;
        return;
    L5:
        sj.d r10 = f;
        if (r10 != null) goto L8;
        return;
    L8:
        if (com.bytedance.common.utility.b.b(r5) == true) goto L24;
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        if (r10.f21907a == false) goto L15;
        r10.k();     // Catch: Throwable -> L13
    L19:
        return;
    L15:
        r10.j();     // Catch: Throwable -> L13
        goto L19
    }

    public static void b(String r5, String r10, boolean r11) {
        if (com.bytedance.common.utility.b.b(r5) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.b.b(r10) == true) goto L37;
        sj.d r12 = f;
        if (r12 == null) goto L35;
        CopyOnWriteArrayList r13 = r12.f21918p;
        if (r13.isEmpty() == true) goto L38;
        Iterator r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L40;
        String r15 = (String) r14.next();
        if (com.bytedance.common.utility.b.b(r15) == true) goto L14;
        if (r5.endsWith(r15) == false) goto L14;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L27
        r16.put("url", r5 + r10);     // Catch: Throwable -> L27
        r16.put("replace", r11);     // Catch: Throwable -> L27
        TTNetInit.monitorLogSend("api_http", r16);     // Catch: Throwable -> L27
    L21:
        if (TTNetInit.apiHttpInterceptEnabled() == false) goto L36;
        if (r11 == false) goto L25;
        return;
    L25:
        throw new NotAllowApiHttpException("Api http request is not allowed to be executed");
    L36:
        return;
    L40:
        return;
    L38:
        return;
    L35:
        return;
    }

    public static void c() {
        if (f21881c.get() != true) goto L5;
        return;
    L5:
        f21881c.getAndSet(true);
        CountDownLatch r5 = e;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.getCount() <= 0) goto L12;
        e.countDown();
        return;
    }
}
