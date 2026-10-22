package d.b.h.a.a.h;

import com.bytedance.common.utility.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f13351a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f13352b = false;

    static {
    }

    public a() {
    }

    public static long b() {
        return f13351a;
    }

    public static void c() {
        if (f13352b == false) goto L6;
        f13352b = false;
        f13351a++;
        return;
    }

    public static void d() {
        if (f13352b == true) goto L6;
        f13352b = true;
        f13351a++;
        return;
    }

    public static String e(String r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (k.c(r2) == true) goto L12;
        return new d.b.h.a.a.h.p.b(r2).a();
    L12:
        return "";
    }
}
