package kotlin.s0.w.d.l0.e.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f19524a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> f19525b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.g.c> f19526c = null;

    static {
        m r0 = new m();
        f19524a = r0;
        LinkedHashMap r1 = new LinkedHashMap();
        f19525b = r1;
        kotlin.s0.w.d.l0.g.i r2 = kotlin.s0.w.d.l0.g.i.f20282a;
        r0.c(r2.j(), r0.a(new String[]{"java.util.ArrayList", "java.util.LinkedList"}));
        r0.c(r2.l(), r0.a(new String[]{"java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"}));
        r0.c(r2.k(), r0.a(new String[]{"java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"}));
        kotlin.s0.w.d.l0.g.b r3 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("java.util.function.Function"));
        kotlin.n0.d.o.e(r3, "topLevel(FqName(\"java.util.function.Function\"))");
        r0.c(r3, r0.a(new String[]{"java.util.function.UnaryOperator"}));
        kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("java.util.function.BiFunction"));
        kotlin.n0.d.o.e(r4, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        r0.c(r4, r0.a(new String[]{"java.util.function.BinaryOperator"}));
        ArrayList r5 = new ArrayList(r1.size());
        Iterator r6 = r1.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r7 = (Map.Entry) r6.next();
        kotlin.s0.w.d.l0.g.b r8 = (kotlin.s0.w.d.l0.g.b) r7.getKey();
        kotlin.s0.w.d.l0.g.b r9 = (kotlin.s0.w.d.l0.g.b) r7.getValue();
        r5.add(kotlin.a0.a(r8.b(), r9.b()));
        goto L4
    L6:
        f19526c = m0.q(r5);
    }

    private m() {
    }

    private final List<kotlin.s0.w.d.l0.g.b> a(String... r5) {
        ArrayList r4 = new ArrayList(r5.length);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.add(kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c(r5[r1])));
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    private final void c(kotlin.s0.w.d.l0.g.b r3, List<kotlin.s0.w.d.l0.g.b> r4) {
        Map<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> r2 = f19525b;
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Object r0 = r5.next();
        kotlin.s0.w.d.l0.g.b r1 = (kotlin.s0.w.d.l0.g.b) r0;
        r2.put((kotlin.s0.w.d.l0.g.b) r0, r3);
        goto L4
    }

    public final kotlin.s0.w.d.l0.g.c b(kotlin.s0.w.d.l0.g.c r1) {
        kotlin.n0.d.o.f(r1, "classFqName");
        return f19526c.get(r1);
    }
}
