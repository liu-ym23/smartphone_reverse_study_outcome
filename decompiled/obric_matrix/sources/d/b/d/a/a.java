package d.b.d.a;

import android.util.Log;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f13185a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f13186b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f13187c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile String f13188d = "ttboringssl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile String f13189e = "ttcrypto";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Lock f13190f;

    static {
        f13190f = new ReentrantLock();
    }

    public a() {
    }

    public static boolean a() {
        f13190f.lock();     // Catch: Throwable -> L15 Error -> L17
        if (f13187c == null) goto L9;
        boolean r0 = f13187c.a();     // Catch: Throwable -> L15 Error -> L17
        f13190f.unlock();
        return r0;
    L9:
        if (f13186b == true) goto L12;
        System.loadLibrary(f13189e);     // Catch: Throwable -> L15 Error -> L17
        f13186b = true;     // Catch: Throwable -> L15 Error -> L17
    L12:
        if (f13185a == true) goto L14;
        System.loadLibrary(f13188d);     // Catch: Throwable -> L15 Error -> L17
        f13185a = true;     // Catch: Throwable -> L15 Error -> L17
    L14:
        f13190f.unlock();
        if (f13185a == true) goto L23;
    L25:
        return false;
    L23:
        if (f13186b == false) goto L25;
        return true;
    L15:
        th = move-exception;
        f13190f.unlock();
        throw th;
    L17:
        e = move-exception;
        Log.e("BoringsslLoaderWrapper", "load boringssl:" + f13185a + " load crypto:" + f13186b + "  err:" + e.toString());     // Catch: Throwable -> L15
        goto L14
    }
}
