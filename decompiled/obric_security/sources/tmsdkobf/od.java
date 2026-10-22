package tmsdkobf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class od {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f396a = null;

    static {
        f396a = new ArrayList();
    }

    public static synchronized List a(l7 r4) {
        monitor-enter(od.class);
        List r1 = f396a;     // Catch: Throwable -> L14
        ArrayList r2 = (ArrayList) r1;     // Catch: Throwable -> L14
        if (r2.isEmpty() == false) goto L12;
        if (r4 == null) goto L12;
        List r5 = r4.a();     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        if (r5.isEmpty() == true) goto L12;
        r2.addAll(r5);     // Catch: Throwable -> L14
    L12:
        monitor-exit(od.class);
        return r1;
    L14:
        th = move-exception;
        throw th;
    }

    public static String a(Set r3) {
        StringBuilder r0 = new StringBuilder();
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L13
    L4:
        if (r4.hasNext() == false) goto L12;
        String r1 = (String) r4.next();     // Catch: Throwable -> L13
        if (r0.length() <= 0) goto L9;
        r0.append("|");     // Catch: Throwable -> L13
    L9:
        r0.append(r1);     // Catch: Throwable -> L13
    L12:
        return r0.toString();
    }
}
