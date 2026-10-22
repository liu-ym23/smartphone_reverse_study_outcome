package d.b.b.f.e;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f12805a;

    public static String a() {
        return f12805a;
    }

    public static void b(String r0) {
        f12805a = r0;
    }

    public static boolean c() {
        return d();
    }

    private static boolean d() {
        f12805a = d.b.b.f.a.c().b();
        return false;
    }

    public static boolean e(d.b.b.f.d.c r9, double r10, boolean r12) {
        if (r12 == false) goto L30;
        if (r9.a().isEmpty() == true) goto L19;
        Iterator<String> r13 = d.b.b.f.a.c().a().iterator();
        double r4 = 0.0d;
    L8:
        if (r13.hasNext() == false) goto L21;
        String r6 = r13.next();
        if (r9.a().containsKey(r6) == false) goto L8;
        double r7 = r9.a().get(r6).doubleValue();
        if (r7 < 0.0d) goto L8;
        if (r4 > r7) goto L8;
        r4 = r7;
    L21:
        if (r4 > 0.0d) goto L25;
        r4 = r9.c();
    L25:
        if (r10 <= r4) goto L28;
        return true;
    L28:
        return false;
    L19:
        r4 = 0.0d;
        goto L21
    L30:
        if (r9.b().isEmpty() == true) goto L44;
        Iterator<String> r14 = d.b.b.f.a.c().a().iterator();
        double r5 = 0.0d;
    L33:
        if (r14.hasNext() == false) goto L46;
        String r8 = r14.next();
        if (r9.b().containsKey(r8) == false) goto L33;
        double r11 = r9.b().get(r8).doubleValue();
        if (r11 < 0.0d) goto L33;
        if (r5 > r11) goto L33;
        r5 = r11;
    L46:
        if (r5 > 0.0d) goto L50;
        r5 = r9.d();
    L50:
        if (r10 <= r5) goto L53;
        return true;
    L53:
        return false;
    L44:
        r5 = 0.0d;
        goto L46
    }
}
