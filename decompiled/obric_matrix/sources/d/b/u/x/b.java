package d.b.u.x;

import d.b.u.w.d;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f15123a;

    static {
        f15123a = new a();
    }

    public static void a(String r1) {
        d r0 = f15123a;
        if (r0 == null) goto L6;
        r0.c(r1);
        return;
    }

    public static void b(String r1) {
        d r0 = f15123a;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public static void c(String r1) {
        d r0 = f15123a;
        if (r0 == null) goto L6;
        r0.d(r1);
        return;
    }

    public static void d(d r0) {
        if (r0 == null) goto L5;
        f15123a = r0;
        return;
    }

    public static void e(String r1) {
        d r0 = f15123a;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }
}
