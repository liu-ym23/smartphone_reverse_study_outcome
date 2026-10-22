package kotlin.s0.w.d.l0.c.q1;

import java.util.Collections;
import java.util.List;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.j1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.n1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f18951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final kotlin.s0.w.d.l0.m.i<kotlin.s0.w.d.l0.n.m0> f18952h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<kotlin.s0.w.d.l0.k.w.h> f18953i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<x0> f18954j;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.c.q1.a$a, reason: collision with other inner class name */
    class C0503a implements kotlin.n0.c.a<kotlin.s0.w.d.l0.n.m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f18955f;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.c.q1.a$a$a, reason: collision with other inner class name */
        class C0504a implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.t1.g, kotlin.s0.w.d.l0.n.m0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ C0503a f18956f;

            C0504a(C0503a r1) {
                this.f18956f = r1;
            }

            public kotlin.s0.w.d.l0.n.m0 a(kotlin.s0.w.d.l0.n.t1.g r3) {
                kotlin.s0.w.d.l0.c.h r0 = r3.f(this.f18956f.f18955f);
                if (r0 != null) goto L7;
                return this.f18956f.f18955f.f18952h.invoke();
            L7:
                if ((r0 instanceof e1) == false) goto L11;
                return kotlin.s0.w.d.l0.n.f0.b((e1) r0, n1.g(r0.k().getParameters()));
            L11:
                if ((r0 instanceof t) == false) goto L15;
                return n1.u(r0.k().c(r3), ((t) r0).J(r3), this);
            L15:
                return r0.s();
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.m0 invoke(kotlin.s0.w.d.l0.n.t1.g r1) {
                return a(r1);
            }
        }

        C0503a(a r1) {
            this.f18955f = r1;
        }

        public kotlin.s0.w.d.l0.n.m0 a() {
            a r0 = this.f18955f;
            return n1.t(r0, r0.D0(), new C0504a(this));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.m0 invoke() {
            return a();
        }
    }

    class b implements kotlin.n0.c.a<kotlin.s0.w.d.l0.k.w.h> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f18957f;

        b(a r1) {
            this.f18957f = r1;
        }

        public kotlin.s0.w.d.l0.k.w.h a() {
            return new kotlin.s0.w.d.l0.k.w.f(this.f18957f.D0());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.w.h invoke() {
            return a();
        }
    }

    class c implements kotlin.n0.c.a<x0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f18958f;

        c(a r1) {
            this.f18958f = r1;
        }

        public x0 a() {
            return new q(this.f18958f);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ x0 invoke() {
            return a();
        }
    }

    static {
    }

    public a(kotlin.s0.w.d.l0.m.n r2, kotlin.s0.w.d.l0.g.f r3) {
        if (r2 == null) goto L9;
        if (r3 == null) goto L7;
        this.f18951g = r3;
        this.f18952h = r2.d(new C0503a(this));
        this.f18953i = r2.d(new b(this));
        this.f18954j = r2.d(new c(this));
        return;
    L7:
        A0(1);
        throw null;
    L9:
        A0(0);
        throw null;
    }

    private static /* synthetic */ void A0(int r19) {
        if (r19 == 2) goto L16;
        if (r19 == 3) goto L16;
        if (r19 == 4) goto L16;
        if (r19 == 5) goto L16;
        if (r19 == 6) goto L16;
        if (r19 == 9) goto L16;
        if (r19 == 12) goto L16;
        if (r19 == 14) goto L16;
        if (r19 == 16) goto L16;
        if (r19 == 17) goto L16;
        if (r19 == 19) goto L16;
        if (r19 == 20) goto L16;
        String r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L17:
        if (r19 == 2) goto L30;
        if (r19 == 3) goto L30;
        if (r19 == 4) goto L30;
        if (r19 == 5) goto L30;
        if (r19 == 6) goto L30;
        if (r19 == 9) goto L30;
        if (r19 == 12) goto L30;
        if (r19 == 14) goto L30;
        if (r19 == 16) goto L30;
        if (r19 == 17) goto L30;
        if (r19 == 19) goto L30;
        if (r19 == 20) goto L30;
        int r14 = 3;
    L31:
        Object[] r15 = new Object[r14];
        switch(r19) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L38;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L38;
            case 10: goto L35;
            case 11: goto L36;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L38;
            case 15: goto L35;
            case 16: goto L38;
            case 17: goto L38;
            case 18: goto L34;
            case 19: goto L38;
            case 20: goto L38;
            default: goto L33;
        };
    L33:
        r15[0] = "storageManager";
    L41:
        if (r19 == 2) goto L62;
        if (r19 == 3) goto L61;
        if (r19 == 4) goto L60;
        if (r19 == 5) goto L59;
        if (r19 == 6) goto L58;
        if (r19 == 9) goto L57;
        if (r19 == 12) goto L57;
        if (r19 == 14) goto L57;
        if (r19 == 16) goto L57;
        if (r19 == 17) goto L56;
        if (r19 == 19) goto L55;
        if (r19 == 20) goto L54;
        r15[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
    L63:
        switch(r19) {
            case 2: goto L67;
            case 3: goto L67;
            case 4: goto L67;
            case 5: goto L67;
            case 6: goto L67;
            case 7: goto L66;
            case 8: goto L66;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L66;
            case 12: goto L67;
            case 13: goto L66;
            case 14: goto L67;
            case 15: goto L66;
            case 16: goto L67;
            case 17: goto L67;
            case 18: goto L65;
            case 19: goto L67;
            case 20: goto L67;
            default: goto L64;
        };
    L64:
        r15[2] = "<init>";
        goto L67
    L65:
        r15[2] = "substitute";
        goto L67
    L66:
        r15[2] = "getMemberScope";
    L67:
        String r16 = String.format(r13, r15);
        if (r19 == 2) goto L82;
        if (r19 == 3) goto L82;
        if (r19 == 4) goto L82;
        if (r19 == 5) goto L82;
        if (r19 == 6) goto L82;
        if (r19 == 9) goto L82;
        if (r19 == 12) goto L82;
        if (r19 == 14) goto L82;
        if (r19 == 16) goto L82;
        if (r19 == 17) goto L82;
        if (r19 == 19) goto L82;
        if (r19 == 20) goto L82;
        throw new IllegalArgumentException(r16);
    L82:
        throw new IllegalStateException(r16);
    L54:
        r15[1] = "getDefaultType";
        goto L63
    L55:
        r15[1] = "substitute";
        goto L63
    L56:
        r15[1] = "getUnsubstitutedMemberScope";
    L57:
        r15[1] = "getMemberScope";
        goto L63
    L58:
        r15[1] = "getContextReceivers";
        goto L63
    L59:
        r15[1] = "getThisAsReceiverParameter";
        goto L63
    L60:
        r15[1] = "getUnsubstitutedInnerClassesScope";
        goto L63
    L61:
        r15[1] = "getOriginal";
        goto L63
    L62:
        r15[1] = "getName";
        goto L63
    L34:
        r15[0] = "substitutor";
        goto L41
    L35:
        r15[0] = "typeSubstitution";
        goto L41
    L36:
        r15[0] = "kotlinTypeRefiner";
        goto L41
    L37:
        r15[0] = "typeArguments";
        goto L41
    L38:
        r15[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        goto L41
    L39:
        r15[0] = "name";
    L30:
        r14 = 2;
    L16:
        r13 = "@NotNull method %s.%s must not return null";
        goto L17
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h D0() {
        kotlin.s0.w.d.l0.k.w.h r1 = J(kotlin.s0.w.d.l0.k.t.a.k(kotlin.s0.w.d.l0.k.d.g(this)));
        if (r1 == null) goto L5;
        return r1;
    L5:
        A0(17);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t
    public kotlin.s0.w.d.l0.k.w.h F(j1 r3, kotlin.s0.w.d.l0.n.t1.g r4) {
        if (r3 == null) goto L16;
        if (r4 != null) goto L6;
        A0(11);
        throw null;
    L6:
        if (r3.f() == false) goto L12;
        kotlin.s0.w.d.l0.k.w.h r2 = J(r4);
        if (r2 == null) goto L10;
        return r2;
    L10:
        A0(12);
        throw null;
    L12:
        l1 r5 = l1.g(r3);
        return new kotlin.s0.w.d.l0.k.w.m(J(r4), r5);
    L16:
        A0(10);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e F0(l1 r2) {
        if (r2 != null) goto L4;
        A0(18);
        throw null;
    L4:
        if (r2.k() == false) goto L7;
        return this;
    L7:
        return new s(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public List<x0> G0() {
        List<x0> r0 = Collections.emptyList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(6);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.a(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public x0 K0() {
        x0 r0 = this.f18954j.invoke();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(5);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t, kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.e a() {
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t, kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h a() {
        a();
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.t, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        a();
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h a0(j1 r3) {
        if (r3 == null) goto L9;
        kotlin.s0.w.d.l0.k.w.h r2 = F(r3, kotlin.s0.w.d.l0.k.t.a.k(kotlin.s0.w.d.l0.k.d.g(this)));
        if (r2 == null) goto L7;
        return r2;
    L7:
        A0(16);
        throw null;
    L9:
        A0(15);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return F0(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.j0
    public kotlin.s0.w.d.l0.g.f getName() {
        kotlin.s0.w.d.l0.g.f r0 = this.f18951g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(2);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e, kotlin.s0.w.d.l0.c.h
    public kotlin.s0.w.d.l0.n.m0 s() {
        kotlin.s0.w.d.l0.n.m0 r0 = this.f18952h.invoke();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(20);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.e
    public kotlin.s0.w.d.l0.k.w.h y0() {
        kotlin.s0.w.d.l0.k.w.h r0 = this.f18953i.invoke();
        if (r0 == null) goto L5;
        return r0;
    L5:
        A0(4);
        throw null;
    }
}
