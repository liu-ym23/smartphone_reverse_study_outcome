package d.b.p.a.c.d.b;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f14217a;

    private static Printer a() {
        if (f14217a == null) goto L12;
    L10:
        return (Printer) f14217a.get(Looper.getMainLooper());
    L7:
        return null;
    L12:
        f14217a = d.b.p.a.d.d.a(Looper.class, "mLogging");     // Catch: Throwable -> L9
        goto L10
    }

    static void b(String r1) {
        Printer r0 = a();
        if (r0 == null) goto L6;
        r0.println(r1);
        return;
    }
}
