package d.b.b.f.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<e> f12784a;

    static {
        new HashMap();
        f12784a = new LinkedList();
    }

    public static synchronized void a() {
        monitor-enter(f.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f12784a.isEmpty() == true) goto L11;
        Iterator<e> r1 = f12784a.iterator();     // Catch: Throwable -> L13
    L8:
        if (r1.hasNext() == false) goto L10;
        d.b.b.l.a.d(r1.next());     // Catch: Throwable -> L13
        goto L8
    L10:
        f12784a.clear();     // Catch: Throwable -> L13
    L11:
        monitor-exit(f.class);
    }
}
