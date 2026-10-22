package kotlin.s0.w.d.l0.o;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.x;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends kotlin.s0.w.d.l0.o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f21237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<h> f21238b = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<y, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f21239f = null;

        static {
            f21239f = new a();
        }

        a() {
            super(1);
        }

        public final String a(y r3) {
            kotlin.n0.d.o.f(r3, "$this$$receiver");
            List<j1> r2 = r3.h();
            kotlin.n0.d.o.e(r2, "valueParameters");
            j1 r4 = (j1) kotlin.i0.r.d0(r2);
            boolean r5 = true;
            if (r4 != null) goto L5;
        L12:
            r5 = false;
        L13:
            p r6 = p.f21237a;
            if (r5 == true) goto L16;
            return "last parameter should not have a default value or be a vararg";
        L16:
            return null;
        L5:
            if (kotlin.s0.w.d.l0.k.t.a.a(r4) == false) goto L7;
        L9:
            boolean r7 = false;
        L10:
            if (r7 != true) goto L12;
        L7:
            if (r4.l0() != null) goto L9;
            r7 = true;
            goto L10
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(y r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<y, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f21240f = null;

        static {
            f21240f = new b();
        }

        b() {
            super(1);
        }

        private static final boolean b(kotlin.s0.w.d.l0.c.m r1) {
            if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L5;
        L7:
            return false;
        L5:
            if (kotlin.s0.w.d.l0.b.h.a0((kotlin.s0.w.d.l0.c.e) r1) == false) goto L7;
            return true;
        }

        public final String a(y r4) {
            kotlin.n0.d.o.f(r4, "$this$$receiver");
            p r3 = p.f21237a;
            kotlin.s0.w.d.l0.c.m r5 = r4.c();
            kotlin.n0.d.o.e(r5, "containingDeclaration");
            boolean r0 = true;
            if (b(r5) == true) goto L16;
            Collection<? extends y> r6 = r4.f();
            kotlin.n0.d.o.e(r6, "overriddenDescriptors");
            if (r6.isEmpty() == false) goto L7;
        L6:
            boolean r7 = false;
        L13:
            if (r7 == true) goto L16;
            r0 = false;
            goto L16
        L7:
            Iterator<T> r8 = r6.iterator();
        L9:
            if (r8.hasNext() == false) goto L6;
            kotlin.s0.w.d.l0.c.m r9 = ((y) r8.next()).c();
            kotlin.n0.d.o.e(r9, "it.containingDeclaration");
            if (b(r9) == false) goto L9;
            r7 = true;
        L16:
            if (r0 == true) goto L18;
            return "must override ''equals()'' in Any";
        L18:
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(y r1) {
            return a(r1);
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<y, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f21241f = null;

        static {
            f21241f = new c();
        }

        c() {
            super(1);
        }

        public final String a(y r6) {
            kotlin.n0.d.o.f(r6, "$this$$receiver");
            x0 r5 = r6.f0();
            if (r5 != null) goto L5;
            r5 = r6.m0();
        L5:
            p r0 = p.f21237a;
            boolean r1 = false;
            if (r5 == null) goto L15;
            e0 r2 = r6.getReturnType();
            if (r2 == null) goto L10;
            e0 r3 = r5.b();
            kotlin.n0.d.o.e(r3, "receiver.type");
            boolean r4 = kotlin.s0.w.d.l0.n.x1.a.o(r2, r3);
        L11:
            if (r4 == false) goto L13;
        L14:
            r1 = true;
            goto L15
        L13:
            if (p.c(r0, r6, r5) == false) goto L15;
        L10:
            r4 = false;
        L15:
            if (r1 == true) goto L17;
            return "receiver must be a supertype of the return type";
        L17:
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(y r1) {
            return a(r1);
        }
    }

    static {
        f21237a = new p();
        kotlin.s0.w.d.l0.g.f r2 = q.f21250i;
        k.b r9 = k.b.f21229b;
        f[] r3 = {r9, new t.a(1)};
        kotlin.s0.w.d.l0.g.f r4 = q.f21251j;
        f[] r5 = {r9, new t.a(2)};
        kotlin.s0.w.d.l0.g.f r13 = q.f21242a;
        m r6 = m.f21231a;
        j r7 = j.f21225a;
        kotlin.s0.w.d.l0.g.f r14 = q.f21247f;
        t.d r8 = t.d.f21270b;
        r.a r10 = r.a.f21257d;
        kotlin.s0.w.d.l0.g.f r15 = q.f21249h;
        t.c r11 = t.c.f21269b;
        f21238b = kotlin.i0.r.j(new h[]{new h(r2, r3, null, 4, null), new h(r4, r5, a.f21239f), new h(r13, new f[]{r9, r6, new t.a(2), r7}, null, 4, null), new h(q.f21243b, new f[]{r9, r6, new t.a(3), r7}, null, 4, null), new h(q.f21244c, new f[]{r9, r6, new t.b(2), r7}, null, 4, null), new h(q.f21248g, new f[]{r9}, null, 4, null), new h(r14, new f[]{r9, r8, r6, r10}, null, 4, null), new h(r15, new f[]{r9, r11}, null, 4, null), new h(q.f21252k, new f[]{r9, r11}, null, 4, null), new h(q.f21253l, new f[]{r9, r11, r10}, null, 4, null), new h(q.z, new f[]{r9, r8, r6}, null, 4, null), new h(q.f21245d, new f[]{k.a.f21228b}, b.f21240f), new h(q.f21246e, new f[]{r9, r.b.f21259d, r8, r6}, null, 4, null), new h(q.H, new f[]{r9, r8, r6}, null, 4, null), new h(q.G, new f[]{r9, r11}, null, 4, null), new h(kotlin.i0.r.j(new kotlin.s0.w.d.l0.g.f[]{q.o, q.p}), new f[]{r9}, c.f21241f), new h(q.I, new f[]{r9, r.c.f21261d, r8, r6}, null, 4, null), new h(q.m, new f[]{r9, r11}, null, 4, null)});
    }

    private p() {
    }

    public static final /* synthetic */ boolean c(p r0, y r1, x0 r2) {
        return r0.d(r1, r2);
    }

    private final boolean d(y r2, x0 r3) {
        kotlin.s0.w.d.l0.k.w.o.f r1 = r3.getValue();
        kotlin.n0.d.o.e(r1, "receiver.value");
        if ((r1 instanceof kotlin.s0.w.d.l0.k.w.o.e) == true) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.c.e r4 = ((kotlin.s0.w.d.l0.k.w.o.e) r1).r();
        if (r4.L() == true) goto L8;
        return false;
    L8:
        kotlin.s0.w.d.l0.g.b r5 = kotlin.s0.w.d.l0.k.t.a.g(r4);
        if (r5 != null) goto L11;
        return false;
    L11:
        kotlin.s0.w.d.l0.c.h r6 = x.b(kotlin.s0.w.d.l0.k.t.a.l(r4), r5);
        if ((r6 instanceof e1) == true) goto L14;
        r6 = null;
    L14:
        e1 r7 = (e1) r6;
        if (r7 != null) goto L17;
        return false;
    L17:
        e0 r8 = r2.getReturnType();
        if (r8 != null) goto L20;
        return false;
    L20:
        return kotlin.s0.w.d.l0.n.x1.a.o(r8, r7.V());
    }

    @Override // kotlin.s0.w.d.l0.o.b
    public List<h> b() {
        return f21238b;
    }
}
