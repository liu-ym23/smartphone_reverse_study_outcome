package kotlin.s0.w.d.l0.e.a.o0;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a0;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.q1.d0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.e.a.i0;
import kotlin.s0.w.d.l0.e.b.u;
import kotlin.s0.w.d.l0.e.b.v;
import kotlin.s0.w.d.l0.e.b.x;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.l0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.o0.d f19605a;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19606f = null;

        static {
            f19606f = new a();
        }

        a() {
            super(1);
        }

        public final Boolean a(q1 r3) {
            kotlin.s0.w.d.l0.c.h r2 = r3.O0().d();
            if (r2 == null) goto L5;
            kotlin.s0.w.d.l0.g.f r4 = r2.getName();
            kotlin.s0.w.d.l0.b.q.c r0 = kotlin.s0.w.d.l0.b.q.c.f18771a;
            if (kotlin.n0.d.o.a(r4, r0.h().g()) == true) goto L9;
        L11:
            boolean r5 = false;
        L13:
            return Boolean.valueOf(r5);
        L9:
            if (kotlin.n0.d.o.a(kotlin.s0.w.d.l0.k.t.a.d(r2), r0.h()) == false) goto L11;
            r5 = true;
            goto L13
        L5:
            return Boolean.FALSE;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(q1 r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f19607f = null;

        static {
            f19607f = new b();
        }

        b() {
            super(1);
        }

        public final e0 a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            x0 r0 = r1.m0();
            kotlin.n0.d.o.c(r0);
            e0 r2 = r0.b();
            kotlin.n0.d.o.e(r2, "it.extensionReceiverParameter!!.type");
            return r2;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f19608f = null;

        static {
            f19608f = new c();
        }

        c() {
            super(1);
        }

        public final e0 a(kotlin.s0.w.d.l0.c.b r1) {
            kotlin.n0.d.o.f(r1, "it");
            e0 r0 = r1.getReturnType();
            kotlin.n0.d.o.c(r0);
            return r0;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ j1 f19609f;

        d(j1 r1) {
            this.f19609f = r1;
            super(1);
        }

        public final e0 a(kotlin.s0.w.d.l0.c.b r2) {
            kotlin.n0.d.o.f(r2, "it");
            e0 r1 = r2.h().get(this.f19609f.j()).b();
            kotlin.n0.d.o.e(r1, "it.valueParameters[p.index].type");
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f19610f = null;

        static {
            f19610f = new e();
        }

        e() {
            super(1);
        }

        public final Boolean a(q1 r1) {
            kotlin.n0.d.o.f(r1, "it");
            return Boolean.valueOf(r1 instanceof l0);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(q1 r1) {
            return a(r1);
        }
    }

    public l(kotlin.s0.w.d.l0.e.a.o0.d r2) {
        kotlin.n0.d.o.f(r2, "typeEnhancement");
        this.f19605a = r2;
    }

    private final boolean a(e0 r1) {
        return n1.c(r1, a.f19606f);
    }

    private final e0 b(kotlin.s0.w.d.l0.c.b r11, kotlin.s0.w.d.l0.c.o1.a r12, boolean r13, kotlin.s0.w.d.l0.e.a.l0.g r14, kotlin.s0.w.d.l0.e.a.b r15, q r16, boolean r17, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.c.b, ? extends e0> r18) {
        n r9 = new n(r12, r13, r14, r15, false, 16, null);
        e0 r2 = r18.invoke(r11);
        Collection<? extends kotlin.s0.w.d.l0.c.b> r1 = r11.f();
        kotlin.n0.d.o.e(r1, "overriddenDescriptors");
        ArrayList r3 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator<T> r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        kotlin.s0.w.d.l0.c.b r5 = (kotlin.s0.w.d.l0.c.b) r4.next();
        kotlin.n0.d.o.e(r5, "it");
        r3.add(r18.invoke(r5));
        goto L4
    L7:
        return c(r9, r2, r3, r16, r17);
    }

    private final e0 c(n r1, e0 r2, List<? extends e0> r3, q r4, boolean r5) {
        return this.f19605a.a(r2, r1.b(r2, r3, r4, r5), r1.u());
    }

    static /* synthetic */ e0 d(l r10, kotlin.s0.w.d.l0.c.b r11, kotlin.s0.w.d.l0.c.o1.a r12, boolean r13, kotlin.s0.w.d.l0.e.a.l0.g r14, kotlin.s0.w.d.l0.e.a.b r15, q r16, boolean r17, kotlin.n0.c.l r18, int r19, Object r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        return r10.b(r11, r12, r13, r14, r15, r16, r8, r18);
    L5:
        r8 = r17;
        goto L7
    }

    static /* synthetic */ e0 e(l r6, n r7, e0 r8, List r9, q r10, boolean r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r10 = null;
    L5:
        q r4 = r10;
        if ((r12 & 8) == 0) goto L9;
        r11 = false;
    L9:
        return r6.c(r7, r8, r9, r4, r11);
    }

    private final <D extends kotlin.s0.w.d.l0.c.b> D f(D r21, kotlin.s0.w.d.l0.e.a.l0.g r22) {
        if ((r21 instanceof kotlin.s0.w.d.l0.e.a.k0.a) == true) goto L5;
        return r21;
    L5:
        kotlin.s0.w.d.l0.e.a.k0.a r13 = (kotlin.s0.w.d.l0.e.a.k0.a) r21;
        boolean r14 = true;
        if (r13.i() == kotlin.s0.w.d.l0.c.b.a.f18849g) goto L8;
    L10:
        kotlin.s0.w.d.l0.e.a.l0.g r8 = kotlin.s0.w.d.l0.e.a.l0.a.h(r22, k(r21, r22));
        if ((r21 instanceof kotlin.s0.w.d.l0.e.a.k0.f) == false) goto L20;
        kotlin.s0.w.d.l0.e.a.k0.f r0 = (kotlin.s0.w.d.l0.e.a.k0.f) r21;
        d0 r1 = r0.S0();
        if (r1 != null) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L20;
        d0 r3 = r0.S0();
        kotlin.n0.d.o.c(r3);
        D r9 = r3;
    L22:
        if (r13.m0() != null) goto L24;
        e0 r16 = null;
    L34:
        if ((r21 instanceof kotlin.s0.w.d.l0.e.a.k0.e) == false) goto L36;
        kotlin.s0.w.d.l0.e.a.k0.e r4 = (kotlin.s0.w.d.l0.e.a.k0.e) r21;
    L37:
        if (r4 == null) goto L41;
        x r5 = x.f19797a;
        kotlin.s0.w.d.l0.c.m r6 = r4.c();
        kotlin.n0.d.o.d(r6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String r7 = u.a(r5, (kotlin.s0.w.d.l0.c.e) r6, v.c(r4, false, false, 3, null));
        if (r7 == null) goto L41;
        k r17 = j.d().get(r7);
    L42:
        if (r17 == null) goto L45;
        r17.a().size();
        r13.h().size();
    L45:
        if (i0.b(r22.a().i()) == true) goto L49;
        if (r8.a().q().b() == true) goto L49;
    L51:
        boolean r10 = false;
    L52:
        List<j1> r11 = r9.h();
        kotlin.n0.d.o.e(r11, "annotationOwnerForMember.valueParameters");
        char r12 = '\n';
        ArrayList r15 = new ArrayList(kotlin.i0.r.q(r11, 10));
        Iterator<T> r18 = r11.iterator();
    L54:
        if (r18.hasNext() == false) goto L62;
        j1 r19 = (j1) r18.next();
        if (r17 == null) goto L60;
        List<q> r20 = r17.a();
        if (r20 == null) goto L60;
        q r23 = (q) kotlin.i0.r.S(r20, r19.j());
    L61:
        ArrayList r110 = r15;
        r110.add(j(r21, r19, r8, r23, r10, new d(r19)));
        r15 = r110;
        r12 = '\n';
    L60:
        r23 = null;
        goto L61
    L62:
        ArrayList r111 = r15;
        if ((r21 instanceof u0) == true) goto L65;
        D r24 = null;
    L66:
        u0 r25 = (u0) r24;
        if (r25 != null) goto L69;
    L71:
        boolean r26 = false;
    L72:
        if (r26 == false) goto L74;
        kotlin.s0.w.d.l0.e.a.b r27 = kotlin.s0.w.d.l0.e.a.b.f19218i;
    L75:
        kotlin.s0.w.d.l0.e.a.b r28 = r27;
        if (r17 == null) goto L78;
        q r29 = r17.b();
    L79:
        e0 r30 = d(this, r21, r9, true, r8, r28, r29, false, c.f19608f, 32, null);
        e0 r31 = r13.getReturnType();
        kotlin.n0.d.o.c(r31);
        if (a(r31) == true) goto L102;
        x0 r32 = r13.m0();
        if (r32 == null) goto L86;
        e0 r33 = r32.b();
        if (r33 == null) goto L86;
        boolean r34 = a(r33);
    L87:
        if (r34 == true) goto L102;
        List<j1> r35 = r13.h();
        kotlin.n0.d.o.e(r35, "valueParameters");
        if ((r35 instanceof Collection) == true) goto L91;
    L93:
        Iterator<T> r36 = r35.iterator();
    L95:
        if (r36.hasNext() == false) goto L92;
        e0 r37 = ((j1) r36.next()).b();
        kotlin.n0.d.o.e(r37, "it.type");
        if (a(r37) == false) goto L95;
        boolean r38 = true;
    L99:
        if (r38 == true) goto L102;
        boolean r39 = false;
    L103:
        if (r39 == false) goto L105;
        kotlin.u<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, ?> r112 = a0.a(kotlin.s0.w.d.l0.k.s.d.a(), new kotlin.s0.w.d.l0.e.a.j(r21));
    L106:
        if (r16 != null) goto L123;
        if (r30 != null) goto L123;
        if (r111.isEmpty() == false) goto L111;
    L110:
        r14 = false;
    L119:
        if (r14 == true) goto L123;
        if (r112 != null) goto L123;
        return r21;
    L111:
        Iterator r40 = r111.iterator();
    L113:
        if (r40.hasNext() == false) goto L110;
        if (((e0) r40.next()) == null) goto L117;
        boolean r41 = true;
    L118:
        if (r41 == false) goto L113;
    L117:
        r41 = false;
    L123:
        if (r16 != null) goto L128;
        x0 r42 = r13.m0();
        if (r42 == null) goto L127;
        e0 r43 = r42.b();
    L129:
        ArrayList r44 = new ArrayList(kotlin.i0.r.q(r111, 10));
        Iterator r45 = r111.iterator();
        int r113 = 0;
    L131:
        if (r45.hasNext() == false) goto L140;
        Object r46 = r45.next();
        int r47 = r113 + 1;
        if (r113 < 0) goto L138;
        e0 r48 = (e0) r46;
        if (r48 != null) goto L137;
        r48 = r13.h().get(r113).b();
        kotlin.n0.d.o.e(r48, "valueParameters[index].type");
    L137:
        r44.add(r48);
        r113 = r47;
        goto L131
    L138:
        kotlin.i0.r.p();
        throw null;
    L140:
        if (r30 != null) goto L142;
        r30 = r13.getReturnType();
        kotlin.n0.d.o.c(r30);
    L142:
        kotlin.s0.w.d.l0.e.a.k0.a r49 = r13.w(r43, r44, r30, r112);
        kotlin.n0.d.o.d(r49, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return r49;
    L127:
        r43 = null;
        goto L129
    L128:
        r43 = r16;
        goto L129
    L105:
        r112 = null;
    L92:
        r38 = false;
        goto L99
    L91:
        if (r35.isEmpty() == false) goto L93;
    L86:
        r34 = false;
    L102:
        r39 = true;
        goto L103
    L78:
        r29 = null;
        goto L79
    L74:
        r27 = kotlin.s0.w.d.l0.e.a.b.f19216g;
        goto L75
    L69:
        if (kotlin.s0.w.d.l0.e.a.l0.l.c.a(r25) != true) goto L71;
        r26 = true;
        goto L72
    L65:
        r24 = r21;
    L49:
        if (i0.a(r21) == false) goto L51;
        r10 = true;
    L41:
        r17 = null;
        goto L42
    L36:
        r4 = null;
        goto L37
    L24:
        if ((r9 instanceof y) == true) goto L26;
        D r50 = null;
    L27:
        y r51 = (y) r50;
        if (r51 == null) goto L30;
        j1 r52 = (j1) r51.i0(kotlin.s0.w.d.l0.e.a.k0.e.L);
    L31:
        r16 = j(r21, r52, r8, null, false, b.f19607f);
        goto L34
    L30:
        r52 = null;
        goto L31
    L26:
        r50 = r9;
        goto L27
    L15:
        if (r1.U() == true) goto L17;
        r2 = true;
    L20:
        r9 = r21;
        goto L22
    L8:
        if (r13.a().f().size() != 1) goto L10;
        return r21;
    }

    private final e0 j(kotlin.s0.w.d.l0.c.b r10, j1 r11, kotlin.s0.w.d.l0.e.a.l0.g r12, q r13, boolean r14, kotlin.n0.c.l<? super kotlin.s0.w.d.l0.c.b, ? extends e0> r15) {
        if (r11 == null) goto L7;
        kotlin.s0.w.d.l0.e.a.l0.g r0 = kotlin.s0.w.d.l0.e.a.l0.a.h(r12, r11.getAnnotations());
        if (r0 == null) goto L7;
        kotlin.s0.w.d.l0.e.a.l0.g r4 = r0;
    L9:
        return b(r10, r11, false, r4, kotlin.s0.w.d.l0.e.a.b.f19217h, r13, r14, r15);
    L7:
        r4 = r12;
        goto L9
    }

    private final <D extends kotlin.s0.w.d.l0.c.b> kotlin.s0.w.d.l0.c.o1.g k(D r5, kotlin.s0.w.d.l0.e.a.l0.g r6) {
        kotlin.s0.w.d.l0.c.h r4 = kotlin.s0.w.d.l0.c.s.a(r5);
        if (r4 == null) goto L5;
        List<kotlin.s0.w.d.l0.e.a.n0.a> r1 = null;
        if ((r4 instanceof kotlin.s0.w.d.l0.e.a.l0.l.f) == false) goto L9;
        kotlin.s0.w.d.l0.e.a.l0.l.f r7 = (kotlin.s0.w.d.l0.e.a.l0.l.f) r4;
    L10:
        if (r7 == null) goto L13;
        r1 = r7.R0();
    L13:
        if (r1 != null) goto L15;
    L18:
        boolean r0 = true;
    L19:
        if (r0 == true) goto L21;
        ArrayList r2 = new ArrayList(kotlin.i0.r.q(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L24:
        if (r3.hasNext() == false) goto L27;
        r2.add(new kotlin.s0.w.d.l0.e.a.l0.l.e(r6, (kotlin.s0.w.d.l0.e.a.n0.a) r3.next(), true));
        goto L24
    L27:
        return kotlin.s0.w.d.l0.c.o1.g.f18919b.a(kotlin.i0.r.i0(r5.getAnnotations(), r2));
    L21:
        return r5.getAnnotations();
    L15:
        if (r1.isEmpty() == true) goto L18;
        r0 = false;
        goto L19
    L9:
        r7 = null;
        goto L10
    L5:
        return r5.getAnnotations();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.s0.w.d.l0.c.b> Collection<D> g(kotlin.s0.w.d.l0.e.a.l0.g r3, Collection<? extends D> r4) {
        kotlin.n0.d.o.f(r3, "c");
        kotlin.n0.d.o.f(r4, "platformSignatures");
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(f((kotlin.s0.w.d.l0.c.b) r5.next(), r3));
        goto L4
    L6:
        return r0;
    }

    public final e0 h(e0 r10, kotlin.s0.w.d.l0.e.a.l0.g r11) {
        kotlin.n0.d.o.f(r10, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.f(r11, "context");
        e0 r9 = e(this, new n(null, false, r11, kotlin.s0.w.d.l0.e.a.b.f19219j, true), r10, kotlin.i0.r.g(), null, false, 12, null);
        if (r9 != null) goto L6;
        return r10;
    L6:
        return r9;
    }

    public final List<e0> i(f1 r13, List<? extends e0> r14, kotlin.s0.w.d.l0.e.a.l0.g r15) {
        kotlin.n0.d.o.f(r13, "typeParameter");
        kotlin.n0.d.o.f(r14, "bounds");
        kotlin.n0.d.o.f(r15, "context");
        ArrayList r0 = new ArrayList(kotlin.i0.r.q(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L13;
        e0 r1 = (e0) r16.next();
        if (kotlin.s0.w.d.l0.n.x1.a.b(r1, e.f19610f) == true) goto L12;
        e0 r2 = e(this, new n(r13, false, r15, kotlin.s0.w.d.l0.e.a.b.f19220k, false, 16, null), r1, kotlin.i0.r.g(), null, false, 12, null);
        if (r2 == null) goto L12;
        r1 = r2;
    L12:
        r0.add(r1);
        goto L4
    L13:
        return r0;
    }
}
