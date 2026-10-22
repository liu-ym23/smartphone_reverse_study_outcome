package d.c.i.c.b;

import d.c.i.e.h;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f15865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f f15866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f15867d;

    static {
    }

    public static a a(d.c.i.d.f r7, d.c.i.g.e r8, h<d.c.b.a.d, d.c.i.l.c> r9) {
        if (f15864a == true) goto L10;
        f15865b = (a) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(new Class[]{d.c.i.d.f.class, d.c.i.g.e.class, h.class}).newInstance(new Object[]{r7, r8, r9});     // Catch: Throwable -> L11
    L7:
        if (f15865b == null) goto L10;
        f15864a = true;
    L10:
        return f15865b;
    }

    public static f b() {
        return f15866c;
    }

    public static int c() {
        return f15867d;
    }

    public static void d(int r0) {
        f15867d = r0;
    }
}
