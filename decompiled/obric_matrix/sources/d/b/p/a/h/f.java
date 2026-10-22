package d.b.p.a.h;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static void a(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static <T> T b(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static void c(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }
}
