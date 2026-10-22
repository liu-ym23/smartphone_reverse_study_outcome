package kotlin.s0.w.d.l0.e.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.i0.t0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<TAnnotation> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    private static final Map<String, b> f19200c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f19201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Object, TAnnotation> f19202b;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.a$a, reason: collision with other inner class name */
    static final class C0507a extends kotlin.n0.d.q implements kotlin.n0.c.l<TAnnotation, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0507a f19203f = null;

        static {
            f19203f = new C0507a();
        }

        C0507a() {
            super(1);
        }

        public final Boolean a(TAnnotation r1) {
            kotlin.n0.d.o.f(r1, "$this$extractNullability");
            return Boolean.FALSE;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object r1) {
            return a(r1);
        }
    }

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        b[] r1 = b.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        b r4 = r1[r3];
        String r5 = r4.b();
        if (r0.get(r5) != null) goto L7;
        r0.put(r5, r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        f19200c = r0;
    }

    public a(w r2) {
        kotlin.n0.d.o.f(r2, "javaTypeEnhancementState");
        this.f19201a = r2;
        this.f19202b = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<b> a(Set<? extends b> r2) {
        if (r2.contains(b.f19219j) == true) goto L5;
        return r2;
    L5:
        return t0.h(t0.g(kotlin.i0.i.q0(b.values()), b.f19220k), r2);
    }

    private final q d(TAnnotation r10) {
        q r0 = r(r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        kotlin.u<TAnnotation, Set<b>> r1 = t(r10);
        if (r1 != null) goto L8;
        return null;
    L8:
        TAnnotation r2 = r1.a();
        Set<b> r5 = r1.b();
        f0 r11 = q(r10);
        if (r11 != null) goto L12;
        r11 = p(r2);
    L12:
        if (r11.c() == false) goto L14;
        return null;
    L14:
        kotlin.s0.w.d.l0.e.a.o0.i r9 = g(r2, C0507a.f19203f);
        if (r9 != null) goto L18;
        return null;
    L18:
        return new q(kotlin.s0.w.d.l0.e.a.o0.i.b(r9, null, r11.g(), 1, null), r5, false, 4, null);
    }

    private final kotlin.s0.w.d.l0.e.a.o0.i g(TAnnotation r4, kotlin.n0.c.l<? super TAnnotation, Boolean> r5) {
        kotlin.s0.w.d.l0.e.a.o0.i r0 = n(r4, r5.invoke(r4).booleanValue());
        if (r0 == null) goto L5;
        return r0;
    L5:
        TAnnotation r1 = s(r4);
        if (r1 != null) goto L8;
        return null;
    L8:
        f0 r6 = p(r4);
        if (r6.c() == false) goto L11;
        return null;
    L11:
        kotlin.s0.w.d.l0.e.a.o0.i r3 = n(r1, r5.invoke(r1).booleanValue());
        if (r3 != null) goto L14;
        return null;
    L14:
        return kotlin.s0.w.d.l0.e.a.o0.i.b(r3, null, r6.g(), 1, null);
    }

    private final TAnnotation h(TAnnotation r3, kotlin.s0.w.d.l0.g.c r4) {
        Iterator<TAnnotation> r5 = k(r3).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        TAnnotation r0 = r5.next();
        if (kotlin.n0.d.o.a(i(r0), r4) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private final boolean l(TAnnotation r3, kotlin.s0.w.d.l0.g.c r4) {
        Iterable<TAnnotation> r5 = k(r3);
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<TAnnotation> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (kotlin.n0.d.o.a(i(r6.next()), r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) r5).isEmpty() == false) goto L7;
        return false;
    }

    private final kotlin.s0.w.d.l0.e.a.o0.i n(TAnnotation r6, boolean r7) {
        kotlin.s0.w.d.l0.g.c r0 = i(r6);
        if (r0 != null) goto L5;
        return null;
    L5:
        f0 r2 = this.f19201a.c().invoke(r0);
        if (r2.c() == false) goto L8;
        return null;
    L8:
        boolean r4 = false;
        if (b0.l().contains(r0) == false) goto L12;
    L10:
        kotlin.s0.w.d.l0.e.a.o0.h r5 = kotlin.s0.w.d.l0.e.a.o0.h.f19560g;
    L52:
        if (r2.g() == true) goto L54;
        if (r7 == true) goto L54;
    L56:
        return new kotlin.s0.w.d.l0.e.a.o0.i(r5, r4);
    L54:
        r4 = true;
        goto L56
    L12:
        if (b0.k().contains(r0) == false) goto L15;
    L13:
        r5 = kotlin.s0.w.d.l0.e.a.o0.h.f19561h;
        goto L52
    L15:
        if (kotlin.n0.d.o.a(r0, b0.g()) == true) goto L10;
        if (kotlin.n0.d.o.a(r0, b0.h()) == false) goto L21;
    L19:
        r5 = kotlin.s0.w.d.l0.e.a.o0.h.f19559f;
        goto L52
    L21:
        if (kotlin.n0.d.o.a(r0, b0.f()) == false) goto L40;
        String r8 = (String) kotlin.i0.r.Q(b(r6, false));
        if (r8 == null) goto L13;
        switch(r8.hashCode()) {
            case 73135176: goto L37;
            case 74175084: goto L34;
            case 433141802: goto L31;
            case 1933739535: goto L28;
            default: goto L38;
        };
    L38:
        return null;
    L28:
        if (r8.equals("ALWAYS") == false) goto L38;
    L31:
        if (r8.equals("UNKNOWN") == true) goto L19;
    L34:
        if (r8.equals("NEVER") == true) goto L10;
    L37:
        if (r8.equals("MAYBE") == true) goto L10;
    L40:
        if (kotlin.n0.d.o.a(r0, b0.d()) == true) goto L10;
        if (kotlin.n0.d.o.a(r0, b0.c()) == true) goto L13;
        if (kotlin.n0.d.o.a(r0, b0.a()) == true) goto L13;
        if (kotlin.n0.d.o.a(r0, b0.b()) == true) goto L10;
        return null;
    }

    private final f0 o(TAnnotation r3) {
        kotlin.s0.w.d.l0.g.c r0 = i(r3);
        if (r0 == null) goto L9;
        if (c.c().containsKey(r0) == false) goto L9;
        return this.f19201a.c().invoke(r0);
    L9:
        return p(r3);
    }

    private final f0 p(TAnnotation r1) {
        f0 r2 = q(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        return this.f19201a.d().a();
    }

    private final f0 q(TAnnotation r3) {
        f0 r0 = this.f19201a.d().c().get(i(r3));
        if (r0 == null) goto L5;
        return r0;
    L5:
        TAnnotation r4 = h(r3, c.d());
        if (r4 == null) goto L35;
        Iterable<String> r5 = b(r4, false);
        if (r5 == null) goto L36;
        String r6 = (String) kotlin.i0.r.Q(r5);
        if (r6 == null) goto L40;
        f0 r2 = this.f19201a.d().b();
        if (r2 != null) goto L34;
        int r7 = r6.hashCode();
        if (r7 == (-2137067054)) goto L30;
        if (r7 == (-1838656823)) goto L26;
        if (r7 == 2656902) goto L22;
        return null;
    L22:
        if (r6.equals("WARN") == true) goto L37;
        return null;
    L37:
        return f0.f19254h;
    L26:
        if (r6.equals("STRICT") == true) goto L38;
        return null;
    L38:
        return f0.f19255i;
    L30:
        if (r6.equals("IGNORE") == true) goto L39;
        return null;
    L39:
        return f0.f19253g;
    L34:
        return r2;
    L40:
        return null;
    L36:
        return null;
    L35:
        return null;
    }

    private final q r(TAnnotation r9) {
        if (this.f19201a.b() == false) goto L5;
        return null;
    L5:
        q r2 = c.a().get(i(r9));
        if (r2 == null) goto L18;
        f0 r8 = o(r9);
        if (r8 == f0.f19253g) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L14;
        r8 = null;
    L14:
        if (r8 != null) goto L17;
        return null;
    L17:
        return q.b(r2, kotlin.s0.w.d.l0.e.a.o0.i.b(r2.d(), null, r8.g(), 1, null), null, false, 6, null);
    L10:
        r10 = false;
        goto L11
    L18:
        return null;
    }

    private final kotlin.u<TAnnotation, Set<b>> t(TAnnotation r6) {
        if (this.f19201a.d().d() == false) goto L5;
        return null;
    L5:
        TAnnotation r0 = h(r6, c.e());
        if (r0 != null) goto L8;
        return null;
    L8:
        Iterator<TAnnotation> r7 = k(r6).iterator();
    L10:
        if (r7.hasNext() == false) goto L17;
        TAnnotation r2 = r7.next();
        if (s(r2) == null) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L10;
    L18:
        if (r2 != null) goto L20;
        return null;
    L20:
        Iterable<String> r8 = b(r0, true);
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<String> r9 = r8.iterator();
    L22:
        if (r9.hasNext() == false) goto L27;
        b r3 = f19200c.get(r9.next());
        if (r3 == null) goto L22;
        r1.add(r3);
        goto L22
    L27:
        return new kotlin.u(r2, a(r1));
    L14:
        r4 = false;
        goto L15
    L17:
        r2 = null;
        goto L18
    }

    protected abstract Iterable<String> b(TAnnotation r1, boolean r2);

    public final x c(x r5, Iterable<? extends TAnnotation> r6) {
        kotlin.n0.d.o.f(r6, "annotations");
        if (this.f19201a.b() == false) goto L5;
        return r5;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<? extends TAnnotation> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        q r1 = d(r7.next());
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L12:
        if (r0.isEmpty() == false) goto L14;
        return r5;
    L14:
        if (r5 == null) goto L18;
        EnumMap<b, q> r4 = r5.b();
        if (r4 == null) goto L18;
        EnumMap r8 = new EnumMap(r4);
    L19:
        boolean r9 = false;
        Iterator r2 = r0.iterator();
    L21:
        if (r2.hasNext() == false) goto L26;
        q r3 = (q) r2.next();
        Iterator<b> r10 = r3.e().iterator();
    L24:
        if (r10.hasNext() == false) goto L21;
        r8.put(r10.next(), r3);
        r9 = true;
        goto L24
    L26:
        if (r9 == true) goto L29;
        return r5;
    L29:
        return new x(r8);
    L18:
        r8 = new EnumMap(b.class);
        goto L19
    }

    public final kotlin.s0.w.d.l0.e.a.o0.f e(Iterable<? extends TAnnotation> r5) {
        kotlin.n0.d.o.f(r5, "annotations");
        Iterator<? extends TAnnotation> r6 = r5.iterator();
        kotlin.s0.w.d.l0.e.a.o0.f r1 = null;
    L4:
        if (r6.hasNext() == false) goto L15;
        kotlin.s0.w.d.l0.g.c r2 = i(r6.next());
        if (b0.m().contains(r2) == true) goto L7;
        if (b0.j().contains(r2) == false) goto L4;
        kotlin.s0.w.d.l0.e.a.o0.f r3 = kotlin.s0.w.d.l0.e.a.o0.f.f19556g;
    L11:
        if (r1 == null) goto L14;
        if (r1 == r3) goto L14;
        return null;
    L14:
        r1 = r3;
        goto L4
    L7:
        r3 = kotlin.s0.w.d.l0.e.a.o0.f.f19555f;
        goto L11
    L15:
        return r1;
    }

    public final kotlin.s0.w.d.l0.e.a.o0.i f(Iterable<? extends TAnnotation> r5, kotlin.n0.c.l<? super TAnnotation, Boolean> r6) {
        kotlin.n0.d.o.f(r5, "annotations");
        kotlin.n0.d.o.f(r6, "forceWarning");
        Iterator<? extends TAnnotation> r7 = r5.iterator();
        kotlin.s0.w.d.l0.e.a.o0.i r1 = null;
    L4:
        if (r7.hasNext() == false) goto L23;
        kotlin.s0.w.d.l0.e.a.o0.i r2 = g(r7.next(), r6);
        if (r1 == null) goto L21;
        if (r2 == null) goto L4;
        if (kotlin.n0.d.o.a(r2, r1) == true) goto L4;
        if (r2.d() == false) goto L18;
        if (r1.d() == false) goto L4;
    L18:
        if (r2.d() == true) goto L22;
        if (r1.d() == true) goto L21;
    L22:
        return null;
    L21:
        r1 = r2;
        goto L4
    L23:
        return r1;
    }

    protected abstract kotlin.s0.w.d.l0.g.c i(TAnnotation r1);

    protected abstract Object j(TAnnotation r1);

    protected abstract Iterable<TAnnotation> k(TAnnotation r1);

    public final boolean m(TAnnotation r3) {
        kotlin.n0.d.o.f(r3, "annotation");
        TAnnotation r4 = h(r3, kotlin.s0.w.d.l0.b.k.a.u);
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterable<String> r2 = b(r4, false);
        if ((r2 instanceof Collection) == true) goto L8;
    L10:
        Iterator<String> r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L21;
        if (kotlin.n0.d.o.a(r5.next(), kotlin.s0.w.d.l0.c.o1.n.F.name()) == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (((Collection) r2).isEmpty() == false) goto L10;
        return false;
    }

    public final TAnnotation s(TAnnotation r5) {
        kotlin.n0.d.o.f(r5, "annotation");
        if (this.f19201a.d().d() == false) goto L6;
        return null;
    L6:
        if (kotlin.i0.r.J(c.b(), i(r5)) == false) goto L8;
    L29:
        return r5;
    L8:
        if (l(r5, c.f()) == true) goto L29;
        if (l(r5, c.g()) == true) goto L13;
        return null;
    L13:
        ConcurrentHashMap<Object, TAnnotation> r0 = this.f19202b;
        Object r2 = j(r5);
        TAnnotation r3 = r0.get(r2);
        if (r3 != null) goto L33;
        Iterator<TAnnotation> r6 = k(r5).iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        TAnnotation r4 = s(r6.next());
        if (r4 == null) goto L17;
    L22:
        if (r4 != null) goto L24;
        return null;
    L24:
        TAnnotation r7 = r0.putIfAbsent(r2, r4);
        if (r7 != null) goto L28;
        return r4;
    L28:
        return r7;
    L21:
        r4 = null;
        goto L22
    L33:
        return r3;
    }
}
