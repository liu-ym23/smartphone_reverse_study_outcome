package ms.bd.c;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class f22453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f22454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f22455d;

    public p3(Context r23) {
        this.f22452a = r23;
        Class<?> r1 = Class.forName((String) m.a(16777217, 0, 0, "934905", new byte[]{43, 62, 74, 3, 14, 44, 62, 0, 106, 96, 44, 127, 78, 73, 65, 43, 55, 2, 105, 39, 1, 53, 119, 95, 0, 52, 51, 22, 96, 123, 1, 60, 87, 65}));     // Catch: Exception -> L8
        this.f22453b = r1;     // Catch: Exception -> L8
        this.f22454c = r1.newInstance();     // Catch: Exception -> L8
    L10:
        Class r2 = this.f22453b;     // Catch: Exception -> L9
        this.f22455d = r2.getMethod((String) m.a(16777217, 0, 0, "cee1bd", new byte[]{117, 98, 2, 106, 124, 90, 68}), new Class[]{Context.class});     // Catch: Exception -> L9
        return;
    }

    public String a() {
        if (this.f22453b != null) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L13;
        return null;
    L13:
        Context r1 = this.f22452a;
        Method r4 = this.f22455d;
        Object r5 = this.f22454c;
        if (r5 == null) goto L22;
        if (r4 == null) goto L23;
        return (String) r4.invoke(r5, new Object[]{r1});
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L5:
        if (this.f22454c == null) goto L9;
        if (this.f22455d == null) goto L9;
        r0 = true;
        goto L11
    }
}
