package d.d.a.a;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class j {
    static l.a.b.c a(List<h> r4) {
        TreeSet r0 = new TreeSet();
        l.a.b.c.b r1 = l.a.b.c.d();
        if (r4 == null) goto L20;
        Iterator<h> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        h r2 = r5.next();
        if (r2 == null) goto L6;
        if (r2.a() == null) goto L6;
        r0.addAll(r2.a());
        goto L6
    L13:
        if (r0.size() <= 0) goto L30;
        Iterator r6 = r0.iterator();
    L16:
        if (r6.hasNext() == false) goto L19;
        r1.a((String) r6.next());
        goto L16
    L19:
        return r1.b();
    L30:
        return null;
    L20:
        return null;
    }
}
