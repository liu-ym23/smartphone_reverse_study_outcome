package wj;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f22867b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f22868a;

    public static synchronized a a() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f22867b != null) goto L9;
        a r5 = new a();     // Catch: Throwable -> L7
        r5.f22868a = new ConcurrentHashMap();     // Catch: Throwable -> L7
        f22867b = r5;     // Catch: Throwable -> L7
    L9:
        a r10 = f22867b;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    }
}
