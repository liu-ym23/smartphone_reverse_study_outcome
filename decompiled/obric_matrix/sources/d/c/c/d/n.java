package d.c.c.d;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static RuntimeException a(Throwable r1) {
        i.g(r1);
        c(r1);
        throw new RuntimeException(r1);
    }

    public static <X extends Throwable> void b(Throwable r1, Class<X> r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2.isInstance(r1) == true) goto L7;
        return;
    L7:
        throw r2.cast(r1);
    }

    public static void c(Throwable r1) {
        b(r1, Error.class);
        b(r1, RuntimeException.class);
    }
}
