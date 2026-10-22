package kotlin.s0.w.d.l0.e.a.j0;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Map;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.m.m;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public class b implements kotlin.s0.w.d.l0.c.o1.c, kotlin.s0.w.d.l0.e.a.k0.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f19297f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.c f19298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a1 f19299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i f19300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.a.n0.b f19301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19302e;

    static final class a extends q implements kotlin.n0.c.a<m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.g f19303f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f19304g;

        a(kotlin.s0.w.d.l0.e.a.l0.g r1, b r2) {
            this.f19303f = r1;
            this.f19304g = r2;
            super(0);
        }

        public final m0 a() {
            m0 r1 = this.f19303f.d().o().o(this.f19304g.e()).s();
            o.e(r1, "c.module.builtIns.getBui…qName(fqName).defaultType");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ m0 invoke() {
            return a();
        }
    }

    static {
        f19297f = new l[]{e0.g(new y(e0.b(b.class), WsConstants.KEY_CONNECTION_TYPE, "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    }

    public b(kotlin.s0.w.d.l0.e.a.l0.g r2, kotlin.s0.w.d.l0.e.a.n0.a r3, kotlin.s0.w.d.l0.g.c r4) {
        o.f(r2, "c");
        o.f(r4, "fqName");
        this.f19298a = r4;
        if (r3 == null) goto L7;
        a1 r5 = r2.a().t().a(r3);
        if (r5 == null) goto L7;
    L8:
        this.f19299b = r5;
        this.f19300c = r2.e().d(new a(r2, this));
        if (r3 == null) goto L13;
        Collection<kotlin.s0.w.d.l0.e.a.n0.b> r6 = r3.getArguments();
        if (r6 == null) goto L13;
        kotlin.s0.w.d.l0.e.a.n0.b r7 = (kotlin.s0.w.d.l0.e.a.n0.b) r.Q(r6);
    L14:
        this.f19301d = r7;
        boolean r8 = true;
        if (r3 != null) goto L17;
    L19:
        r8 = false;
    L20:
        this.f19302e = r8;
        return;
    L17:
        if (r3.g() != true) goto L19;
    L13:
        r7 = null;
    L7:
        r5 = a1.f18847a;
        o.e(r5, "NO_SOURCE");
        goto L8
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public Map<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.k.r.g<?>> a() {
        return kotlin.i0.m0.h();
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.e0 b() {
        return d();
    }

    protected final kotlin.s0.w.d.l0.e.a.n0.b c() {
        return this.f19301d;
    }

    public m0 d() {
        return (m0) m.a(this.f19300c, this, f19297f[0]);
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public kotlin.s0.w.d.l0.g.c e() {
        return this.f19298a;
    }

    @Override // kotlin.s0.w.d.l0.e.a.k0.g
    public boolean g() {
        return this.f19302e;
    }

    @Override // kotlin.s0.w.d.l0.c.o1.c
    public a1 getSource() {
        return this.f19299b;
    }
}
