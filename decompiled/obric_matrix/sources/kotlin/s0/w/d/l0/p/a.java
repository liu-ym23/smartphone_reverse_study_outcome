package kotlin.s0.w.d.l0.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final <T> void a(Collection<T> r1, T r2) {
        o.f(r1, "<this>");
        if (r2 == null) goto L6;
        r1.add(r2);
        return;
    }

    private static final int b(int r1) {
        if (r1 >= 3) goto L6;
        return 3;
    L6:
        return (r1 + (r1 / 3)) + 1;
    }

    public static final <T> List<T> c(ArrayList<T> r2) {
        o.f(r2, "<this>");
        int r0 = r2.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L11;
        r2.trimToSize();
        return r2;
    L11:
        return r.d(r.P(r2));
    L9:
        return r.g();
    }

    public static final <K> Map<K, Integer> d(Iterable<? extends K> r4) {
        o.f(r4, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<? extends K> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        int r2 = r1 + 1;
        r0.put(r5.next(), Integer.valueOf(r1));
        r1 = r2;
        goto L4
    L6:
        return r0;
    }

    public static final <K, V> HashMap<K, V> e(int r1) {
        return new HashMap(b(r1));
    }

    public static final <E> HashSet<E> f(int r1) {
        return new HashSet(b(r1));
    }

    public static final <E> LinkedHashSet<E> g(int r1) {
        return new LinkedHashSet(b(r1));
    }
}
