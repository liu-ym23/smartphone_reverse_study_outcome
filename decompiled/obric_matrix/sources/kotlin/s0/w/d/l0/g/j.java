package kotlin.s0.w.d.l0.g;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f20294a = null;

    static {
        c r0 = new c("java.lang");
        f20294a = r0;
        o.e(r0.c(f.k("annotation")), "JAVA_LANG_PACKAGE.child(…identifier(\"annotation\"))");
    }

    public static final /* synthetic */ b a(String r0) {
        return j(r0);
    }

    public static final /* synthetic */ b b(String r0) {
        return k(r0);
    }

    public static final /* synthetic */ b c(String r0) {
        return l(r0);
    }

    public static final /* synthetic */ b d(String r0) {
        return m(r0);
    }

    public static final /* synthetic */ Map e(Map r0) {
        return n(r0);
    }

    public static final /* synthetic */ b f(f r0) {
        return o(r0);
    }

    public static final /* synthetic */ b g(String r0) {
        return p(r0);
    }

    public static final /* synthetic */ b h(String r0) {
        return q(r0);
    }

    public static final /* synthetic */ b i(b r0) {
        return r(r0);
    }

    private static final b j(String r2) {
        return new b(i.f20282a.b(), f.k(r2));
    }

    private static final b k(String r2) {
        return new b(i.f20282a.e(), f.k(r2));
    }

    private static final b l(String r2) {
        return new b(i.f20282a.c(), f.k(r2));
    }

    private static final b m(String r2) {
        return new b(i.f20282a.d(), f.k(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> Map<V, K> n(Map<K, ? extends V> r3) {
        Set<Map.Entry<K, ? extends V>> r4 = r3.entrySet();
        LinkedHashMap r1 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r.q(r4, 10)), 16));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r5.next();
        Object r2 = r0.getKey();
        u r6 = a0.a(r0.getValue(), r2);
        r1.put(r6.c(), r6.d());
        goto L4
    L6:
        return r1;
    }

    private static final b o(f r4) {
        i r1 = i.f20282a;
        return new b(r1.a().h(), f.k(r4.g() + r1.a().j().g()));
    }

    private static final b p(String r2) {
        return new b(i.f20282a.f(), f.k(r2));
    }

    private static final b q(String r2) {
        return new b(i.f20282a.g(), f.k(r2));
    }

    private static final b r(b r4) {
        return new b(i.f20282a.e(), f.k('U' + r4.j().g()));
    }
}
