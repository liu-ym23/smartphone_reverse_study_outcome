package d.b.w.a.d;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15252a;

    static {
        f15252a = Log.isLoggable("watson_assist", 3);
    }

    public static void a(String r1) {
        b("watson_assist", r1);
    }

    public static void b(String r1, String r2) {
        if (f15252a == false) goto L6;
        Log.d(r1, r2);
        return;
    }

    public static void c(String r1) {
        d("watson_assist", r1);
    }

    public static void d(String r0, String r1) {
        Log.e(r0, r1);
    }

    public static void e(String r1) {
        f("watson_assist", r1);
    }

    public static void f(String r0, String r1) {
        Log.i(r0, r1);
    }

    public static void g(String r1) {
        h("watson_assist", r1);
    }

    public static void h(String r0, String r1) {
        Log.w(r0, r1);
    }
}
