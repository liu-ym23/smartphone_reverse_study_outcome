package kotlin.s0.w.d.l0.e.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f19258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.g.f> f19259b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<kotlin.s0.w.d.l0.g.f, List<kotlin.s0.w.d.l0.g.f>> f19260c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.g.c> f19261d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.g.f> f19262e = null;

    static {
        f19258a = new g();
        kotlin.s0.w.d.l0.g.d r1 = kotlin.s0.w.d.l0.b.k.a.f18728k;
        kotlin.s0.w.d.l0.g.c r2 = kotlin.s0.w.d.l0.b.k.a.H;
        Map<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.g.f> r0 = m0.k(new kotlin.u[]{kotlin.a0.a(h.b(r1, "name"), kotlin.s0.w.d.l0.g.f.k("name")), kotlin.a0.a(h.b(r1, "ordinal"), kotlin.s0.w.d.l0.g.f.k("ordinal")), kotlin.a0.a(h.a(kotlin.s0.w.d.l0.b.k.a.D, "size"), kotlin.s0.w.d.l0.g.f.k("size")), kotlin.a0.a(h.a(r2, "size"), kotlin.s0.w.d.l0.g.f.k("size")), kotlin.a0.a(h.b(kotlin.s0.w.d.l0.b.k.a.f18723f, "length"), kotlin.s0.w.d.l0.g.f.k("length")), kotlin.a0.a(h.a(r2, "keys"), kotlin.s0.w.d.l0.g.f.k("keySet")), kotlin.a0.a(h.a(r2, "values"), kotlin.s0.w.d.l0.g.f.k("values")), kotlin.a0.a(h.a(r2, "entries"), kotlin.s0.w.d.l0.g.f.k("entrySet"))});
        f19259b = r0;
        Set<Map.Entry<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.g.f>> r3 = r0.entrySet();
        ArrayList r4 = new ArrayList(kotlin.i0.r.q(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r6 = (Map.Entry) r5.next();
        r4.add(new kotlin.u(((kotlin.s0.w.d.l0.g.c) r6.getKey()).g(), r6.getValue()));
        goto L4
    L6:
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r4.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        kotlin.u r9 = (kotlin.u) r8.next();
        kotlin.s0.w.d.l0.g.f r10 = (kotlin.s0.w.d.l0.g.f) r9.d();
        Object r11 = r7.get(r10);
        if (r11 != null) goto L12;
        r11 = new ArrayList();
        r7.put(r10, r11);
    L12:
        ((List) r11).add((kotlin.s0.w.d.l0.g.f) r9.c());
        goto L8
    L13:
        LinkedHashMap r12 = new LinkedHashMap(m0.d(r7.size()));
        Iterator r13 = r7.entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L17;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.put(r14.getKey(), kotlin.i0.r.K((Iterable) r14.getValue()));
        goto L15
    L17:
        f19260c = r12;
        Set<kotlin.s0.w.d.l0.g.c> r15 = f19259b.keySet();
        f19261d = r15;
        ArrayList r16 = new ArrayList(kotlin.i0.r.q(r15, 10));
        Iterator<T> r17 = r15.iterator();
    L19:
        if (r17.hasNext() == false) goto L21;
        r16.add(((kotlin.s0.w.d.l0.g.c) r17.next()).g());
        goto L19
    L21:
        f19262e = kotlin.i0.r.D0(r16);
    }

    private g() {
    }

    public final Map<kotlin.s0.w.d.l0.g.c, kotlin.s0.w.d.l0.g.f> a() {
        return f19259b;
    }

    public final List<kotlin.s0.w.d.l0.g.f> b(kotlin.s0.w.d.l0.g.f r1) {
        kotlin.n0.d.o.f(r1, "name1");
        List<kotlin.s0.w.d.l0.g.f> r0 = f19260c.get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return kotlin.i0.r.g();
    }

    public final Set<kotlin.s0.w.d.l0.g.c> c() {
        return f19261d;
    }

    public final Set<kotlin.s0.w.d.l0.g.f> d() {
        return f19262e;
    }
}
