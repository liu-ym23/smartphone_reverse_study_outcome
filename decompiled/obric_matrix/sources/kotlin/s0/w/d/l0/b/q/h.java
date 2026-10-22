package kotlin.s0.w.d.l0.b.q;

import java.io.InputStream;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.k0;
import kotlin.s0.w.d.l0.e.b.o;
import kotlin.s0.w.d.l0.l.b.k;
import kotlin.s0.w.d.l0.l.b.l;
import kotlin.s0.w.d.l0.l.b.p;
import kotlin.s0.w.d.l0.l.b.r;
import kotlin.s0.w.d.l0.l.b.s;
import kotlin.s0.w.d.l0.l.b.v;
import kotlin.s0.w.d.l0.m.n;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends kotlin.s0.w.d.l0.l.b.a {
    static {
    }

    public h(n r27, o r28, h0 r29, k0 r30, kotlin.s0.w.d.l0.c.p1.a r31, kotlin.s0.w.d.l0.c.p1.c r32, l r33, kotlin.s0.w.d.l0.n.t1.l r34, kotlin.s0.w.d.l0.k.v.a r35) {
        kotlin.n0.d.o.f(r27, "storageManager");
        kotlin.n0.d.o.f(r28, "finder");
        kotlin.n0.d.o.f(r29, "moduleDescriptor");
        kotlin.n0.d.o.f(r30, "notFoundClasses");
        kotlin.n0.d.o.f(r31, "additionalClassPartsProvider");
        kotlin.n0.d.o.f(r32, "platformDependentDeclarationFilter");
        kotlin.n0.d.o.f(r33, "deserializationConfiguration");
        kotlin.n0.d.o.f(r34, "kotlinTypeChecker");
        kotlin.n0.d.o.f(r35, "samConversionResolver");
        super(r27, r28, r29);
        kotlin.s0.w.d.l0.l.b.o r5 = new kotlin.s0.w.d.l0.l.b.o(this);
        kotlin.s0.w.d.l0.l.b.f0.a r0 = kotlin.s0.w.d.l0.l.b.f0.a.m;
        kotlin.s0.w.d.l0.l.b.d r8 = new kotlin.s0.w.d.l0.l.b.d(r29, r30, r0);
        v.a r7 = v.a.f20864a;
        r r9 = r.f20858a;
        kotlin.n0.d.o.e(r9, "DO_NOTHING");
        i(new k(r27, r29, r33, r5, r8, this, r7, r9, kotlin.s0.w.d.l0.d.b.c.a.f19185a, s.a.f20859a, kotlin.i0.r.j(new kotlin.s0.w.d.l0.c.p1.b[]{new kotlin.s0.w.d.l0.b.p.a(r27, r29), new e(r27, r29, null, 4, null)}), r30, kotlin.s0.w.d.l0.l.b.j.f20827a.a(), r31, r32, r0.e(), r34, r35, null, null, 786432, null));
    }

    @Override // kotlin.s0.w.d.l0.l.b.a
    protected p d(kotlin.s0.w.d.l0.g.c r8) {
        kotlin.n0.d.o.f(r8, "fqName");
        InputStream r5 = f().b(r8);
        if (r5 != null) goto L7;
        return null;
    L7:
        return kotlin.s0.w.d.l0.l.b.f0.c.s.a(r8, h(), g(), r5, false);
    }
}
