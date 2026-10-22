package d.b.p.a.e.h.b;

import android.app.Instrumentation;
import android.os.Looper;
import d.b.p.a.d.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends Instrumentation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<d.b.p.a.e.h.a.b.a> f14264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f14265b;

    static {
        f14264a = new ArrayList();
    }

    public a() {
    }

    public static void a(d.b.p.a.e.h.a.b.a r2) {
        if (h.b() == true) goto L5;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.a() == true) goto L14;
        return;
    L14:
        if (f14264a.contains(r2) == true) goto L18;
        f14264a.add(r2);
        return;
    L18:
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("register only in UI thread.");
    }

    public static void b() {
        if (f14265b == false) goto L13;
        return;
    L13:
        Object r1 = d.b.p.a.d.a.c();     // Catch: Exception -> L10
        Field r2 = r1.getClass().getDeclaredField("mInstrumentation");     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        if ((r2.get(r1) instanceof a) == false) goto L8;
        return;
    L8:
        r2.set(r1, new a());     // Catch: Exception -> L10
        h.a("InstrumentationWrapper", "Fix success.");     // Catch: Exception -> L10
        f14265b = true;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        h.a("InstrumentationWrapper", e.getMessage());
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object r3, Throwable r4) {
        Iterator<d.b.p.a.e.h.a.b.a> r0 = f14264a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().b(r3, r4) == false) goto L4;
        return true;
    L10:
        return super.onException(r3, r4);
    }
}
