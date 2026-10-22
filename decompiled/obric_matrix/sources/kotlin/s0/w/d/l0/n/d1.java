package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayDeque;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f20957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.w1.p f20960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f20961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f20962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> f20965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Set<kotlin.s0.w.d.l0.n.w1.k> f20966j;

    public interface a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.d1$a$a, reason: collision with other inner class name */
        public static final class C0575a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f20967a;

            public C0575a() {
            }

            @Override // kotlin.s0.w.d.l0.n.d1.a
            public void a(kotlin.n0.c.a<Boolean> r2) {
                kotlin.n0.d.o.f(r2, "block");
                if (this.f20967a == false) goto L5;
                return;
            L5:
                this.f20967a = r2.invoke().booleanValue();
            }

            public final boolean b() {
                return this.f20967a;
            }
        }

        void a(kotlin.n0.c.a<Boolean> r1);
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f20968f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f20969g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f20970h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ b[] f20971i = null;

        static {
            f20968f = new b("CHECK_ONLY_LOWER", 0);
            f20969g = new b("CHECK_SUBTYPE_AND_LOWER", 1);
            f20970h = new b("SKIP_LOWER", 2);
            f20971i = a();
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{f20968f, f20969g, f20970h};
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) f20971i.clone();
        }
    }

    public static abstract class c {

        public static abstract class a extends c {
            public a() {
                super(null);
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f20972a = null;

            static {
                f20972a = new b();
            }

            private b() {
                super(null);
            }

            @Override // kotlin.s0.w.d.l0.n.d1.c
            public kotlin.s0.w.d.l0.n.w1.k a(d1 r1, kotlin.s0.w.d.l0.n.w1.i r2) {
                kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_STATE);
                kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
                return r1.j().h0(r2);
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.n.d1$c$c, reason: collision with other inner class name */
        public static final class C0576c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0576c f20973a = null;

            static {
                f20973a = new C0576c();
            }

            private C0576c() {
                super(null);
            }

            @Override // kotlin.s0.w.d.l0.n.d1.c
            public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.w1.k a(d1 r1, kotlin.s0.w.d.l0.n.w1.i r2) {
                b(r1, r2);
                throw null;
            }

            public Void b(d1 r1, kotlin.s0.w.d.l0.n.w1.i r2) {
                kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_STATE);
                kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        public static final class d extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f20974a = null;

            static {
                f20974a = new d();
            }

            private d() {
                super(null);
            }

            @Override // kotlin.s0.w.d.l0.n.d1.c
            public kotlin.s0.w.d.l0.n.w1.k a(d1 r1, kotlin.s0.w.d.l0.n.w1.i r2) {
                kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_STATE);
                kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
                return r1.j().T(r2);
            }
        }

        private c() {
        }

        public /* synthetic */ c(kotlin.n0.d.g r1) {
            this();
        }

        public abstract kotlin.s0.w.d.l0.n.w1.k a(d1 r1, kotlin.s0.w.d.l0.n.w1.i r2);
    }

    public d1(boolean r2, boolean r3, boolean r4, kotlin.s0.w.d.l0.n.w1.p r5, h r6, i r7) {
        kotlin.n0.d.o.f(r5, "typeSystemContext");
        kotlin.n0.d.o.f(r6, "kotlinTypePreparator");
        kotlin.n0.d.o.f(r7, "kotlinTypeRefiner");
        this.f20957a = r2;
        this.f20958b = r3;
        this.f20959c = r4;
        this.f20960d = r5;
        this.f20961e = r6;
        this.f20962f = r7;
    }

    public static final /* synthetic */ int a(d1 r0) {
        return r0.f20963g;
    }

    public static final /* synthetic */ void b(d1 r0, int r1) {
        r0.f20963g = r1;
    }

    public static /* synthetic */ Boolean d(d1 r0, kotlin.s0.w.d.l0.n.w1.i r1, kotlin.s0.w.d.l0.n.w1.i r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = false;
    L7:
        return r0.c(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    public Boolean c(kotlin.s0.w.d.l0.n.w1.i r1, kotlin.s0.w.d.l0.n.w1.i r2, boolean r3) {
        kotlin.n0.d.o.f(r1, "subType");
        kotlin.n0.d.o.f(r2, "superType");
        return null;
    }

    public final void e() {
        ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> r0 = this.f20965i;
        kotlin.n0.d.o.c(r0);
        r0.clear();
        Set<kotlin.s0.w.d.l0.n.w1.k> r1 = this.f20966j;
        kotlin.n0.d.o.c(r1);
        r1.clear();
        this.f20964h = false;
    }

    public boolean f(kotlin.s0.w.d.l0.n.w1.i r1, kotlin.s0.w.d.l0.n.w1.i r2) {
        kotlin.n0.d.o.f(r1, "subType");
        kotlin.n0.d.o.f(r2, "superType");
        return true;
    }

    public b g(kotlin.s0.w.d.l0.n.w1.k r1, kotlin.s0.w.d.l0.n.w1.d r2) {
        kotlin.n0.d.o.f(r1, "subType");
        kotlin.n0.d.o.f(r2, "superType");
        return b.f20969g;
    }

    public final ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> h() {
        return this.f20965i;
    }

    public final Set<kotlin.s0.w.d.l0.n.w1.k> i() {
        return this.f20966j;
    }

    public final kotlin.s0.w.d.l0.n.w1.p j() {
        return this.f20960d;
    }

    public final void k() {
        this.f20964h = true;
        if (this.f20965i != null) goto L6;
        this.f20965i = new ArrayDeque(4);
    L6:
        if (this.f20966j != null) goto L9;
        this.f20966j = kotlin.s0.w.d.l0.p.f.f21288h.a();
        return;
    }

    public final boolean l(kotlin.s0.w.d.l0.n.w1.i r2) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
        if (this.f20959c == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f20960d.z0(r2) == false) goto L7;
        return true;
    }

    public final boolean m() {
        return this.f20957a;
    }

    public final boolean n() {
        return this.f20958b;
    }

    public final kotlin.s0.w.d.l0.n.w1.i o(kotlin.s0.w.d.l0.n.w1.i r2) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
        return this.f20961e.a(r2);
    }

    public final kotlin.s0.w.d.l0.n.w1.i p(kotlin.s0.w.d.l0.n.w1.i r2) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
        return this.f20962f.a(r2);
    }

    public boolean q(kotlin.n0.c.l<? super a, kotlin.f0> r1) {
        kotlin.n0.d.o.f(r1, "block");
        a.C0575a r0 = new a.C0575a();
        r1.invoke(r0);
        return r0.b();
    }
}
