package tmsdkobf;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class cj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f135a = false;
    private static hh b;

    static {
        b = new hj();
    }

    public static void a(boolean r0) {
        f135a = r0;
        if (r0 == false) goto L5;
        b = new fj();
        return;
    L5:
        b = new hj();
    }

    public static void b(String r1, Object r2) {
        b.b(r1, a(r2));
    }

    public static void a(String r1, Object r2) {
        b.a(r1, a(r2));
    }

    private static String a(Object r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof String) == false) goto L10;
        return (String) r1;
    L10:
        if ((r1 instanceof Throwable) == false) goto L14;
        return a((Throwable) r1);
    L14:
        return r1.toString();
    }

    public static String a(Throwable r2) {
        if (r2 != null) goto L5;
        return "(Null stack trace)";
    L5:
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        r2.printStackTrace(r1);
        r1.flush();
        String r3 = r0.toString();
        r1.close();
        return r3;
    }
}
