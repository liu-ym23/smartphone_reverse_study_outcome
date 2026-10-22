package l.a.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f21489a;

    public c(List<d> r2) {
        this.f21489a = null;
        this.f21489a = new b(r2);
    }

    public List<d> a(d r1) {
        return this.f21489a.g(r1);
    }

    public List<d> b(List<d> r5) {
        Collections.sort(r5, new f());
        TreeSet r0 = new TreeSet();
        Iterator<d> r1 = r5.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        d r2 = r1.next();
        if (r0.contains(r2) == true) goto L4;
        r0.addAll(a(r2));
        goto L4
    L9:
        Iterator r4 = r0.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r5.remove((d) r4.next());
        goto L11
    L13:
        Collections.sort(r5, new e());
        return r5;
    }
}
