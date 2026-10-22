package kotlin.s0.w.d.l0.n.t1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends kotlin.s0.w.d.l0.n.i {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21080a = null;

        static {
            f21080a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.n.t1.g
        public kotlin.s0.w.d.l0.c.e b(kotlin.s0.w.d.l0.g.b r1) {
            kotlin.n0.d.o.f(r1, "classId");
            return null;
        }

        @Override // kotlin.s0.w.d.l0.n.t1.g
        public <S extends kotlin.s0.w.d.l0.k.w.h> S c(kotlin.s0.w.d.l0.c.e r1, kotlin.n0.c.a<? extends S> r2) {
            kotlin.n0.d.o.f(r1, "classDescriptor");
            kotlin.n0.d.o.f(r2, "compute");
            return r2.invoke();
        }

        @Override // kotlin.s0.w.d.l0.n.t1.g
        public boolean d(h0 r1) {
            kotlin.n0.d.o.f(r1, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.s0.w.d.l0.n.t1.g
        public boolean e(e1 r1) {
            kotlin.n0.d.o.f(r1, "typeConstructor");
            return false;
        }

        @Override // kotlin.s0.w.d.l0.n.t1.g
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.c.m r1) {
            return i(r1);
        }

        @Override // kotlin.s0.w.d.l0.n.t1.g
        public Collection<e0> g(kotlin.s0.w.d.l0.c.e r1) {
            kotlin.n0.d.o.f(r1, "classDescriptor");
            Collection<e0> r0 = r1.k().a();
            kotlin.n0.d.o.e(r0, "classDescriptor.typeConstructor.supertypes");
            return r0;
        }

        @Override // kotlin.s0.w.d.l0.n.t1.g
        public e0 h(kotlin.s0.w.d.l0.n.w1.i r1) {
            kotlin.n0.d.o.f(r1, WsConstants.KEY_CONNECTION_TYPE);
            return (e0) r1;
        }

        public kotlin.s0.w.d.l0.c.e i(kotlin.s0.w.d.l0.c.m r1) {
            kotlin.n0.d.o.f(r1, "descriptor");
            return null;
        }
    }

    public g() {
    }

    @Override // kotlin.s0.w.d.l0.n.i
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.w1.i a(kotlin.s0.w.d.l0.n.w1.i r1) {
        return h(r1);
    }

    public abstract kotlin.s0.w.d.l0.c.e b(kotlin.s0.w.d.l0.g.b r1);

    public abstract <S extends kotlin.s0.w.d.l0.k.w.h> S c(kotlin.s0.w.d.l0.c.e r1, kotlin.n0.c.a<? extends S> r2);

    public abstract boolean d(h0 r1);

    public abstract boolean e(e1 r1);

    public abstract kotlin.s0.w.d.l0.c.h f(kotlin.s0.w.d.l0.c.m r1);

    public abstract Collection<e0> g(kotlin.s0.w.d.l0.c.e r1);

    public abstract e0 h(kotlin.s0.w.d.l0.n.w1.i r1);
}
