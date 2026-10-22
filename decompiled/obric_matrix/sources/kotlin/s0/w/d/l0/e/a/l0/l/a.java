package kotlin.s0.w.d.l0.e.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.e.a.n0.n;
import kotlin.s0.w.d.l0.e.a.n0.p;
import kotlin.s0.w.d.l0.e.a.n0.q;
import kotlin.s0.w.d.l0.e.a.n0.r;
import kotlin.s0.w.d.l0.e.a.n0.w;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.n0.g f19386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<q, Boolean> f19387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.n0.c.l<r, Boolean> f19388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.f, List<r>> f19389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.f, n> f19390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.g.f, w> f19391f;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.l0.l.a$a, reason: collision with other inner class name */
    static final class C0512a extends kotlin.n0.d.q implements kotlin.n0.c.l<r, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f19392f;

        C0512a(a r1) {
            this.f19392f = r1;
            super(1);
        }

        public final Boolean a(r r2) {
            o.f(r2, "m");
            if (((Boolean) a.g(this.f19392f).invoke(r2)).booleanValue() == true) goto L5;
        L7:
            boolean r1 = false;
        L9:
            return Boolean.valueOf(r1);
        L5:
            if (p.c(r2) == true) goto L7;
            r1 = true;
            goto L9
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(r r1) {
            return a(r1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(kotlin.s0.w.d.l0.e.a.n0.g r4, kotlin.n0.c.l<? super q, Boolean> r5) {
        o.f(r4, "jClass");
        o.f(r5, "memberFilter");
        this.f19386a = r4;
        this.f19387b = r5;
        C0512a r6 = new C0512a(this);
        this.f19388c = r6;
        kotlin.t0.h r7 = kotlin.t0.k.n(kotlin.i0.r.I(r4.M()), r6);
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r0 = r9.next();
        kotlin.s0.w.d.l0.g.f r1 = ((r) r0).getName();
        Object r2 = r8.get(r1);
        if (r2 != null) goto L8;
        r2 = new ArrayList();
        r8.put(r1, r2);
    L8:
        ((List) r2).add(r0);
        goto L4
    L9:
        this.f19389d = r8;
        kotlin.t0.h r10 = kotlin.t0.k.n(kotlin.i0.r.I(this.f19386a.C()), this.f19387b);
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Object r3 = r12.next();
        r11.put(((n) r3).getName(), r3);
        goto L11
    L13:
        this.f19390e = r11;
        Collection<w> r13 = this.f19386a.k();
        kotlin.n0.c.l<q, Boolean> r14 = this.f19387b;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r13.iterator();
    L15:
        if (r16.hasNext() == false) goto L19;
        Object r17 = r16.next();
        if (r14.invoke((q) r17).booleanValue() == false) goto L15;
        r15.add(r17);
        goto L15
    L19:
        LinkedHashMap r18 = new LinkedHashMap(kotlin.r0.e.c(m0.d(kotlin.i0.r.q(r15, 10)), 16));
        Iterator r19 = r15.iterator();
    L21:
        if (r19.hasNext() == false) goto L23;
        Object r20 = r19.next();
        r18.put(((w) r20).getName(), r20);
        goto L21
    L23:
        this.f19391f = r18;
    }

    public static final /* synthetic */ kotlin.n0.c.l g(a r0) {
        return r0.f19387b;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
    public Set<kotlin.s0.w.d.l0.g.f> a() {
        kotlin.t0.h r2 = kotlin.t0.k.n(kotlin.i0.r.I(this.f19386a.M()), this.f19388c);
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(((r) r3.next()).getName());
        goto L4
    L6:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
    public w b(kotlin.s0.w.d.l0.g.f r2) {
        o.f(r2, "name");
        return this.f19391f.get(r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
    public n c(kotlin.s0.w.d.l0.g.f r2) {
        o.f(r2, "name");
        return this.f19390e.get(r2);
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
    public Set<kotlin.s0.w.d.l0.g.f> d() {
        return this.f19391f.keySet();
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
    public Set<kotlin.s0.w.d.l0.g.f> e() {
        kotlin.t0.h r2 = kotlin.t0.k.n(kotlin.i0.r.I(this.f19386a.C()), this.f19387b);
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(((n) r3.next()).getName());
        goto L4
    L6:
        return r0;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.l.b
    public Collection<r> f(kotlin.s0.w.d.l0.g.f r2) {
        o.f(r2, "name");
        List<r> r1 = this.f19389d.get(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return kotlin.i0.r.g();
    }
}
