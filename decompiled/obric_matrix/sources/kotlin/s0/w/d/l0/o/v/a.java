package kotlin.s0.w.d.l0.o.v;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.k.w.h;
import kotlin.s0.w.d.l0.p.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> a(Collection<? extends T> r1, Collection<? extends T> r2) {
        o.f(r2, "collection");
        if (r2.isEmpty() == false) goto L5;
        return r1;
    L5:
        if (r1 != 0) goto L8;
        return r2;
    L8:
        if ((r1 instanceof LinkedHashSet) == false) goto L11;
        ((LinkedHashSet) r1).addAll(r2);
        return r1;
    L11:
        LinkedHashSet r0 = new LinkedHashSet(r1);
        r0.addAll(r2);
        return r0;
    }

    public static final e<h> b(Iterable<? extends h> r4) {
        o.f(r4, "scopes");
        e<h> r0 = new e();
        Iterator<? extends h> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        h r1 = r5.next();
        h r2 = r1;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if (r2 == h.b.f20650b) goto L10;
        r3 = true;
        goto L11
    L13:
        return r0;
    }
}
