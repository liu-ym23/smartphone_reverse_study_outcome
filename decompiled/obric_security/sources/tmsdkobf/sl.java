package tmsdkobf;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List f517a;
    private static t6 b;
    private static volatile b7 c;

    static {
        f517a = new ArrayList();
        b = null;
        c = null;
    }

    public static final boolean a(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static synchronized void b(Socket r2) {
        monitor-enter(sl.class);
        if (r2 != null) goto L14;
    L12:
        monitor-exit(sl.class);
        return;
    L14:
    L9:
        th = move-exception;
        throw th;
    L6:
        if (f517a.contains(r2) == false) goto L12;
        f517a.remove(r2);     // Catch: Throwable -> L9
        goto L12
    }

    public static synchronized void a(Socket r2) {
        monitor-enter(sl.class);
        if (r2 != null) goto L14;
    L12:
        monitor-exit(sl.class);
        return;
    L14:
    L9:
        th = move-exception;
        throw th;
    L6:
        if (f517a.contains(r2) == true) goto L12;
        f517a.add(r2);     // Catch: Throwable -> L9
        goto L12
    }

    public static void a(t6 r0) {
        b = r0;
    }

    public static b7 a() {
        if (c != null) goto L15;
        monitor-enter(sl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = b.b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(sl.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }
}
