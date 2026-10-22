package tmsdkobf;

import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class qk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f459a = null;

    static {
        f459a = new AtomicReference();
    }

    public static String a() {
        AtomicReference r0 = f459a;
        String r1 = (String) r0.get();
        if (r1 != null) goto L13;
        monitor-enter(r0);
        r1 = (String) r0.get();     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = Build.MODEL;     // Catch: Throwable -> L10
        r0.set(r1);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r1;
    }

    public static int b() {
        return Integer.parseInt(Build.VERSION.SDK);
    L4:
        return 0;
    }
}
