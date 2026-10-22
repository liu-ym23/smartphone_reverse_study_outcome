package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k1;
import kotlin.s0.w.d.l0.n.l1;

/* JADX INFO: loaded from: classes2.dex */
public class l0 extends m0 implements j1 {
    public static final a q = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f19010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f19011l;
    private final boolean m;
    private final boolean n;
    private final kotlin.s0.w.d.l0.n.e0 o;
    private final j1 p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final l0 a(kotlin.s0.w.d.l0.c.a r15, j1 r16, int r17, kotlin.s0.w.d.l0.c.o1.g r18, kotlin.s0.w.d.l0.g.f r19, kotlin.s0.w.d.l0.n.e0 r20, boolean r21, boolean r22, boolean r23, kotlin.s0.w.d.l0.n.e0 r24, a1 r25, kotlin.n0.c.a<? extends List<? extends k1>> r26) {
            kotlin.n0.d.o.f(r15, "containingDeclaration");
            kotlin.n0.d.o.f(r18, "annotations");
            kotlin.n0.d.o.f(r19, "name");
            kotlin.n0.d.o.f(r20, "outType");
            kotlin.n0.d.o.f(r25, "source");
            if (r26 != null) goto L6;
            return new l0(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
        L6:
            return new b(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }
    }

    public static final class b extends l0 {
        private final kotlin.h r;

        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends k1>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f19012f;

            a(b r1) {
                this.f19012f = r1;
                super(0);
            }

            public final List<k1> a() {
                return this.f19012f.O0();
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends k1> invoke() {
                return a();
            }
        }

        public b(kotlin.s0.w.d.l0.c.a r2, j1 r3, int r4, kotlin.s0.w.d.l0.c.o1.g r5, kotlin.s0.w.d.l0.g.f r6, kotlin.s0.w.d.l0.n.e0 r7, boolean r8, boolean r9, boolean r10, kotlin.s0.w.d.l0.n.e0 r11, a1 r12, kotlin.n0.c.a<? extends List<? extends k1>> r13) {
            kotlin.n0.d.o.f(r2, "containingDeclaration");
            kotlin.n0.d.o.f(r5, "annotations");
            kotlin.n0.d.o.f(r6, "name");
            kotlin.n0.d.o.f(r7, "outType");
            kotlin.n0.d.o.f(r12, "source");
            kotlin.n0.d.o.f(r13, "destructuringVariables");
            super(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
            this.r = kotlin.i.b(r13);
        }

        @Override // kotlin.s0.w.d.l0.c.q1.l0, kotlin.s0.w.d.l0.c.j1
        public j1 H0(kotlin.s0.w.d.l0.c.a r15, kotlin.s0.w.d.l0.g.f r16, int r17) {
            kotlin.n0.d.o.f(r15, "newOwner");
            kotlin.n0.d.o.f(r16, "newName");
            kotlin.s0.w.d.l0.c.o1.g r5 = getAnnotations();
            kotlin.n0.d.o.e(r5, "annotations");
            kotlin.s0.w.d.l0.n.e0 r7 = b();
            kotlin.n0.d.o.e(r7, WsConstants.KEY_CONNECTION_TYPE);
            boolean r8 = u0();
            boolean r9 = b0();
            boolean r10 = X();
            kotlin.s0.w.d.l0.n.e0 r11 = l0();
            a1 r12 = a1.f18847a;
            kotlin.n0.d.o.e(r12, "NO_SOURCE");
            return new b(r15, null, r17, r5, r16, r7, r8, r9, r10, r11, r12, new a(this));
        }

        public final List<k1> O0() {
            return (List) this.r.getValue();
        }
    }

    static {
        q = new a(null);
    }

    public l0(kotlin.s0.w.d.l0.c.a r8, j1 r9, int r10, kotlin.s0.w.d.l0.c.o1.g r11, kotlin.s0.w.d.l0.g.f r12, kotlin.s0.w.d.l0.n.e0 r13, boolean r14, boolean r15, boolean r16, kotlin.s0.w.d.l0.n.e0 r17, a1 r18) {
        kotlin.n0.d.o.f(r8, "containingDeclaration");
        kotlin.n0.d.o.f(r11, "annotations");
        kotlin.n0.d.o.f(r12, "name");
        kotlin.n0.d.o.f(r13, "outType");
        kotlin.n0.d.o.f(r18, "source");
        super(r8, r11, r12, r13, r18);
        this.f19010k = r10;
        this.f19011l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        if (r9 != null) goto L5;
        j1 r0 = this;
    L6:
        this.p = r0;
        return;
    L5:
        r0 = r9;
        goto L6
    }

    public static final l0 L0(kotlin.s0.w.d.l0.c.a r13, j1 r14, int r15, kotlin.s0.w.d.l0.c.o1.g r16, kotlin.s0.w.d.l0.g.f r17, kotlin.s0.w.d.l0.n.e0 r18, boolean r19, boolean r20, boolean r21, kotlin.s0.w.d.l0.n.e0 r22, a1 r23, kotlin.n0.c.a<? extends List<? extends k1>> r24) {
        return q.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.j1
    public j1 H0(kotlin.s0.w.d.l0.c.a r14, kotlin.s0.w.d.l0.g.f r15, int r16) {
        kotlin.n0.d.o.f(r14, "newOwner");
        kotlin.n0.d.o.f(r15, "newName");
        kotlin.s0.w.d.l0.c.o1.g r5 = getAnnotations();
        kotlin.n0.d.o.e(r5, "annotations");
        kotlin.s0.w.d.l0.n.e0 r7 = b();
        kotlin.n0.d.o.e(r7, WsConstants.KEY_CONNECTION_TYPE);
        boolean r8 = u0();
        boolean r9 = b0();
        boolean r10 = X();
        kotlin.s0.w.d.l0.n.e0 r11 = l0();
        a1 r12 = a1.f18847a;
        kotlin.n0.d.o.e(r12, "NO_SOURCE");
        return new l0(r14, null, r16, r5, r15, r7, r8, r9, r10, r11, r12);
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r2, D r3) {
        kotlin.n0.d.o.f(r2, "visitor");
        return r2.k(this, r3);
    }

    public Void M0() {
        return null;
    }

    public j1 N0(l1 r2) {
        kotlin.n0.d.o.f(r2, "substitutor");
        if (r2.k() == false) goto L6;
        return this;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.s0.w.d.l0.c.k1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.k.r.g W() {
        return (kotlin.s0.w.d.l0.k.r.g) M0();
    }

    @Override // kotlin.s0.w.d.l0.c.j1
    public boolean X() {
        return this.n;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public j1 a() {
        j1 r0 = this.p;
        if (r0 != this) goto L6;
        return this;
    L6:
        return r0.a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.j1
    public boolean b0() {
        return this.m;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.a c() {
        kotlin.s0.w.d.l0.c.m r1 = super.c();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (kotlin.s0.w.d.l0.c.a) r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m c() {
        return c();
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        N0(r1);
        return this;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public Collection<j1> f() {
        Collection<? extends kotlin.s0.w.d.l0.c.a> r0 = c().f();
        kotlin.n0.d.o.e(r0, "containingDeclaration.overriddenDescriptors");
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((kotlin.s0.w.d.l0.c.a) r2.next()).h().get(j()));
        goto L4
    L6:
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r1 = kotlin.s0.w.d.l0.c.t.f19164f;
        kotlin.n0.d.o.e(r1, "LOCAL");
        return r1;
    }

    @Override // kotlin.s0.w.d.l0.c.j1
    public int j() {
        return this.f19010k;
    }

    @Override // kotlin.s0.w.d.l0.c.k1
    public boolean j0() {
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.j1
    public kotlin.s0.w.d.l0.n.e0 l0() {
        return this.o;
    }

    @Override // kotlin.s0.w.d.l0.c.j1
    public boolean u0() {
        if (this.f19011l == false) goto L7;
        kotlin.s0.w.d.l0.c.a r1 = c();
        kotlin.n0.d.o.d(r1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        if (((kotlin.s0.w.d.l0.c.b) r1).i().a() == false) goto L7;
        return true;
    L7:
        return false;
    }
}
