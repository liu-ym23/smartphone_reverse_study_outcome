package d.b.j;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f13937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile String f13938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static c f13939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f13940d = null;

    static {
        f13940d = new Object();
    }

    public static void a(Context r2, String r3, c r4) {
        Object r0 = f13940d;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f13938b == null) goto L9;
        Log.w("librarian", "already set init, just skip...");     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (r2 == null) goto L15;
        if (r3 == null) goto L15;
        f13937a = r2;
        f13938b = r3;
        f13939c = r4;
        return;
    L15:
        throw new IllegalStateException("context or version is null in init");
    }

    public static void b(String r2, Context r3) {
        c(r2, false, true, r3);
    }

    private static void c(String r0, boolean r1, boolean r2, Context r3) {
        if (r2 == true) goto L4;
    L6:
        b r4 = b.m;
        if (r4 == null) goto L9;
        r4.m(r0, r1);
        return;
    L9:
        c r5 = f13939c;
        if (r5 == null) goto L12;
        r5.e(r0);
        return;
    L12:
        System.loadLibrary(r0);
        return;
    L4:
        if (f13937a != null) goto L6;
        f13937a = r3;
        goto L6
    }
}
