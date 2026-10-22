package tmsdkobf;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public abstract class mh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f353a;

    public static synchronized boolean a(Context r3) {
        monitor-enter(mh.class);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (f353a == null) goto L10;
        monitor-exit(mh.class);
        return true;
    L10:
        if (r3 != null) goto L13;
        monitor-exit(mh.class);
        return false;
    L13:
        Context r4 = r3.getApplicationContext();     // Catch: Throwable -> L20
        if (r4 != null) goto L17;
        monitor-exit(mh.class);
        return false;
    L17:
        f353a = r4;     // Catch: Throwable -> L20
        monitor-exit(mh.class);
        return true;
    }

    public static synchronized Context a() {
        monitor-enter(mh.class);
        Context r1 = f353a;     // Catch: Throwable -> L7
        monitor-exit(mh.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
