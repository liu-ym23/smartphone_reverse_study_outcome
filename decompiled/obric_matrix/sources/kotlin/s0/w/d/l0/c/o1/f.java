package kotlin.s0.w.d.l0.c.o1;

import kotlin.a0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.k.r.v;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f18913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f18914b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f18915c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f18916d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.f f18917e = null;

    static final class a extends q implements kotlin.n0.c.l<h0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.b.h f18918f;

        a(kotlin.s0.w.d.l0.b.h r1) {
            this.f18918f = r1;
            super(1);
        }

        public final e0 a(h0 r2) {
            o.f(r2, "module");
            m0 r1 = r2.o().l(r1.f21065h, this.f18918f.W());
            o.e(r1, "module.builtIns.getArray…ce.INVARIANT, stringType)");
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(h0 r1) {
            return a(r1);
        }
    }

    static {
        kotlin.s0.w.d.l0.g.f r0 = kotlin.s0.w.d.l0.g.f.k("message");
        o.e(r0, "identifier(\"message\")");
        f18913a = r0;
        kotlin.s0.w.d.l0.g.f r1 = kotlin.s0.w.d.l0.g.f.k("replaceWith");
        o.e(r1, "identifier(\"replaceWith\")");
        f18914b = r1;
        kotlin.s0.w.d.l0.g.f r2 = kotlin.s0.w.d.l0.g.f.k("level");
        o.e(r2, "identifier(\"level\")");
        f18915c = r2;
        kotlin.s0.w.d.l0.g.f r3 = kotlin.s0.w.d.l0.g.f.k("expression");
        o.e(r3, "identifier(\"expression\")");
        f18916d = r3;
        kotlin.s0.w.d.l0.g.f r4 = kotlin.s0.w.d.l0.g.f.k("imports");
        o.e(r4, "identifier(\"imports\")");
        f18917e = r4;
    }

    public static final c a(kotlin.s0.w.d.l0.b.h r8, String r9, String r10, String r11) {
        o.f(r8, "<this>");
        o.f(r9, "message");
        o.f(r10, "replaceWith");
        o.f(r11, "level");
        j r0 = new j(r8, kotlin.s0.w.d.l0.b.k.a.p, kotlin.i0.m0.k(new u[]{a0.a(f18916d, new v(r10)), a0.a(f18917e, new kotlin.s0.w.d.l0.k.r.b(r.g(), new a(r8)))}));
        kotlin.s0.w.d.l0.g.c r1 = kotlin.s0.w.d.l0.b.k.a.n;
        kotlin.s0.w.d.l0.g.f r12 = f18915c;
        kotlin.s0.w.d.l0.g.b r4 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.b.k.a.o);
        o.e(r4, "topLevel(StandardNames.FqNames.deprecationLevel)");
        kotlin.s0.w.d.l0.g.f r13 = kotlin.s0.w.d.l0.g.f.k(r11);
        o.e(r13, "identifier(level)");
        return new j(r8, r1, kotlin.i0.m0.k(new u[]{a0.a(f18913a, new v(r9)), a0.a(f18914b, new kotlin.s0.w.d.l0.k.r.a(r0)), a0.a(r12, new kotlin.s0.w.d.l0.k.r.j(r4, r13))}));
    }

    public static /* synthetic */ c b(kotlin.s0.w.d.l0.b.h r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = "WARNING";
    L9:
        return a(r0, r1, r2, r3);
    }
}
