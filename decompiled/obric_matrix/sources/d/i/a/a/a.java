package d.i.a.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static a f17031a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static volatile boolean f17032b = false;

    static {
    }

    public static void e(String r1, String r2) {
        a r0 = f17031a;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
        return;
    L5:
        if (f17032b == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void f(String r1, String r2) {
        a r0 = f17031a;
        if (r0 == null) goto L5;
        r0.c(r1, r2);
        return;
    L5:
        if (f17032b == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void g(String r1, String r2, Throwable r3) {
        a r0 = f17031a;
        if (r0 == null) goto L5;
        r0.e(r1, r2, r3);
        return;
    L5:
        if (f17032b == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void h() {
        a r0 = f17031a;
        if (r0 == null) goto L5;
        r0.flush();
        return;
    L5:
        if (f17032b == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void i() {
        a r0 = f17031a;
        if (r0 == null) goto L5;
        r0.d();
        return;
    L5:
        if (f17032b == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void j(String r1, String r2) {
        a r0 = f17031a;
        if (r0 == null) goto L5;
        r0.b(r1, r2);
        return;
    L5:
        if (f17032b == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }
}
