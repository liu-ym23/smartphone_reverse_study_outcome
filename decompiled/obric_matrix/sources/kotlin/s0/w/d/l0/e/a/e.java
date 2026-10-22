package kotlin.s0.w.d.l0.e.a;

import java.util.Map;
import kotlin.s0.w.d.l0.c.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends h0 {
    public static final e m = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<kotlin.s0.w.d.l0.c.b, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ z0 f19250f;

        a(z0 r1) {
            this.f19250f = r1;
            super(1);
        }

        public final Boolean a(kotlin.s0.w.d.l0.c.b r2) {
            kotlin.n0.d.o.f(r2, "it");
            return Boolean.valueOf(h0.f19266a.j().containsKey(kotlin.s0.w.d.l0.e.b.v.d(this.f19250f)));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(kotlin.s0.w.d.l0.c.b r1) {
            return a(r1);
        }
    }

    static {
        m = new e();
    }

    private e() {
    }

    public final kotlin.s0.w.d.l0.g.f i(z0 r1) {
        kotlin.n0.d.o.f(r1, "functionDescriptor");
        Map<String, kotlin.s0.w.d.l0.g.f> r0 = h0.f19266a.j();
        String r2 = kotlin.s0.w.d.l0.e.b.v.d(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r0.get(r2);
    }

    public final boolean j(z0 r4) {
        kotlin.n0.d.o.f(r4, "functionDescriptor");
        if (kotlin.s0.w.d.l0.b.h.f0(r4) == false) goto L8;
        if (kotlin.s0.w.d.l0.k.t.a.c(r4, false, new a(r4), 1, null) == null) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean k(z0 r2) {
        kotlin.n0.d.o.f(r2, "<this>");
        if (kotlin.n0.d.o.a(r2.getName().b(), "removeAt") == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(kotlin.s0.w.d.l0.e.b.v.d(r2), h0.f19266a.h().b()) == false) goto L7;
        return true;
    }
}
