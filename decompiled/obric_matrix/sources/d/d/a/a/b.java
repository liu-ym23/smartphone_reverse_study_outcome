package d.d.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a.C0436a f16536a = null;

    static {
        f16536a = new a.C0436a();
    }

    b() {
    }

    @Override // d.d.a.a.i
    public List<l.a.b.a> a(Collection<l.a.b.a> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r4 = new ArrayList(r5);
        Collections.sort(r4, f16536a);
        int r6 = -1;
        TreeSet r0 = new TreeSet();
        Iterator r1 = r4.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        l.a.b.a r2 = (l.a.b.a) r1.next();
        if (r2.getStart() <= r6) goto L13;
        if (r2.h() <= r6) goto L13;
        r6 = r2.h();
    L13:
        r0.add(r2);
        goto L7
    L14:
        r4.removeAll(r0);
        return r4;
    }
}
