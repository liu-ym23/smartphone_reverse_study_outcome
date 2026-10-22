package d.i.b.a;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f17033a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f17034b = false;

    static {
    }

    public a() {
    }

    public static boolean a() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (f17033a == false) goto L18;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return true;
    L18:
        System.loadLibrary("vcn");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        f17033a = r2;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r2;
    L10:
        e = move-exception;
        Log.e("vcn", "Can't load avmdl library: " + e);     // Catch: Throwable -> L15
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean b() {
        monitor-enter(a.class);
        boolean r2 = true;
        if (f17034b == false) goto L18;
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return true;
    L18:
        System.loadLibrary("vcnverify");     // Catch: UnsatisfiedLinkError -> L10 Throwable -> L15
    L12:
        f17034b = r2;     // Catch: Throwable -> L15
        monitor-exit(a.class);     // Catch: Throwable -> L15
        return r2;
    L10:
        e = move-exception;
        Log.e("vcn", "Can't load avmdl library: " + e);     // Catch: Throwable -> L15
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }
}
