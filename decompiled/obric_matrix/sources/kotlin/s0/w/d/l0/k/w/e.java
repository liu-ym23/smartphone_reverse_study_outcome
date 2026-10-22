package kotlin.s0.w.d.l0.k.w;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f20637d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e f20638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f20639c;

    static final class a extends q implements kotlin.n0.c.a<List<? extends kotlin.s0.w.d.l0.c.m>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f20640f;

        a(e r1) {
            this.f20640f = r1;
            super(0);
        }

        public final List<kotlin.s0.w.d.l0.c.m> a() {
            List<y> r0 = this.f20640f.i();
            return r.k0(r0, e.h(this.f20640f, r0));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.w.d.l0.c.m> invoke() {
            return a();
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.k.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<kotlin.s0.w.d.l0.c.m> f20641a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f20642b;

        b(ArrayList<kotlin.s0.w.d.l0.c.m> r1, e r2) {
            this.f20641a = r1;
            this.f20642b = r2;
        }

        @Override // kotlin.s0.w.d.l0.k.i
        public void a(kotlin.s0.w.d.l0.c.b r2) {
            o.f(r2, "fakeOverride");
            kotlin.s0.w.d.l0.k.j.K(r2, null);
            this.f20641a.add(r2);
        }

        @Override // kotlin.s0.w.d.l0.k.h
        protected void e(kotlin.s0.w.d.l0.c.b r4, kotlin.s0.w.d.l0.c.b r5) {
            o.f(r4, "fromSuper");
            o.f(r5, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f20642b.l() + ": " + r4 + " vs " + r5).toString());
        }
    }

    static {
        f20637d = new kotlin.s0.l[]{e0.g(new kotlin.n0.d.y(e0.b(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public e(kotlin.s0.w.d.l0.m.n r2, kotlin.s0.w.d.l0.c.e r3) {
        o.f(r2, "storageManager");
        o.f(r3, "containingClass");
        this.f20638b = r3;
        this.f20639c = r2.d(new a(this));
    }

    public static final /* synthetic */ List h(e r0, List r1) {
        return r0.j(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<kotlin.s0.w.d.l0.c.m> j(List<? extends y> r11) {
        ArrayList r0 = new ArrayList(3);
        Collection<kotlin.s0.w.d.l0.n.e0> r2 = this.f20638b.k().a();
        o.e(r2, "containingClass.typeConstructor.supertypes");
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r.v(r3, k.a.a(((kotlin.s0.w.d.l0.n.e0) r4.next()).q(), null, null, 3, null));
        goto L4
    L6:
        ArrayList r1 = new ArrayList();
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if ((r6 instanceof kotlin.s0.w.d.l0.c.b) == false) goto L8;
        r1.add(r6);
        goto L8
    L12:
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r1.iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        kotlin.s0.w.d.l0.g.f r10 = ((kotlin.s0.w.d.l0.c.b) r9).getName();
        Object r12 = r7.get(r10);
        if (r12 != null) goto L18;
        r12 = new ArrayList();
        r7.put(r10, r12);
    L18:
        ((List) r12).add(r9);
        goto L14
    L19:
        Iterator r13 = r7.entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L43;
        Map.Entry r14 = (Map.Entry) r13.next();
        kotlin.s0.w.d.l0.g.f r15 = (kotlin.s0.w.d.l0.g.f) r14.getKey();
        List r16 = (List) r14.getValue();
        LinkedHashMap r17 = new LinkedHashMap();
        Iterator r18 = r16.iterator();
    L24:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        Boolean r20 = Boolean.valueOf(((kotlin.s0.w.d.l0.c.b) r19) instanceof y);
        Object r21 = r17.get(r20);
        if (r21 != null) goto L28;
        r21 = new ArrayList();
        r17.put(r20, r21);
    L28:
        ((List) r21).add(r19);
        goto L24
    L29:
        Iterator r22 = r17.entrySet().iterator();
    L31:
        if (r22.hasNext() == false) goto L21;
        Map.Entry r23 = (Map.Entry) r22.next();
        boolean r24 = ((Boolean) r23.getKey()).booleanValue();
        List r25 = (List) r23.getValue();
        kotlin.s0.w.d.l0.k.j r26 = kotlin.s0.w.d.l0.k.j.f20527f;
        if (r24 == false) goto L40;
        Collection<? extends kotlin.s0.w.d.l0.c.b> r27 = new ArrayList();
        Iterator<T> r28 = r11.iterator();
    L36:
        if (r28.hasNext() == false) goto L41;
        Object r29 = r28.next();
        if (o.a(((y) r29).getName(), r15) == false) goto L36;
        r27.add(r29);
    L41:
        r26.v(r15, r25, r27, this.f20638b, new b(r0, this));
        goto L31
    L40:
        r27 = r.g();
        goto L41
    L43:
        return kotlin.s0.w.d.l0.p.a.c(r0);
    }

    private final List<kotlin.s0.w.d.l0.c.m> k() {
        return (List) kotlin.s0.w.d.l0.m.m.a(this.f20639c, this, f20637d[0]);
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<z0> a(kotlin.s0.w.d.l0.g.f r3, kotlin.s0.w.d.l0.d.b.b r4) {
        o.f(r3, "name");
        o.f(r4, LocationMonitorConst.LOCATION);
        List<kotlin.s0.w.d.l0.c.m> r2 = k();
        kotlin.s0.w.d.l0.p.e r5 = new kotlin.s0.w.d.l0.p.e();
        Iterator<T> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Object r0 = r6.next();
        if ((r0 instanceof z0) == false) goto L4;
        if (o.a(((z0) r0).getName(), r3) == false) goto L4;
        r5.add(r0);
        goto L4
    L10:
        return r5;
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.h
    public Collection<u0> c(kotlin.s0.w.d.l0.g.f r3, kotlin.s0.w.d.l0.d.b.b r4) {
        o.f(r3, "name");
        o.f(r4, LocationMonitorConst.LOCATION);
        List<kotlin.s0.w.d.l0.c.m> r2 = k();
        kotlin.s0.w.d.l0.p.e r5 = new kotlin.s0.w.d.l0.p.e();
        Iterator<T> r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Object r0 = r6.next();
        if ((r0 instanceof u0) == false) goto L4;
        if (o.a(((u0) r0).getName(), r3) == false) goto L4;
        r5.add(r0);
        goto L4
    L10:
        return r5;
    }

    @Override // kotlin.s0.w.d.l0.k.w.i, kotlin.s0.w.d.l0.k.w.k
    public Collection<kotlin.s0.w.d.l0.c.m> g(d r2, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.g.f, Boolean> r3) {
        o.f(r2, "kindFilter");
        o.f(r3, "nameFilter");
        if (r2.a(d.p.m()) == true) goto L7;
        return r.g();
    L7:
        return k();
    }

    protected abstract List<y> i();

    protected final kotlin.s0.w.d.l0.c.e l() {
        return this.f20638b;
    }
}
