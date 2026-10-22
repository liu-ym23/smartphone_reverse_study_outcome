package kotlin.s0.w.d.l0.l.b.f0;

import java.util.List;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.f.l;
import kotlin.s0.w.d.l0.f.n;
import kotlin.s0.w.d.l0.f.q;
import kotlin.s0.w.d.l0.f.s;
import kotlin.s0.w.d.l0.f.u;
import kotlin.s0.w.d.l0.i.g;
import kotlin.s0.w.d.l0.i.i;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends kotlin.s0.w.d.l0.l.a {
    public static final a m = null;

    static {
        m = new a();
    }

    private a() {
        g r1 = g.d();
        kotlin.s0.w.d.l0.f.y.b.a(r1);
        o.e(r1, "newInstance().apply(Buil…f::registerAllExtensions)");
        i.f<l, Integer> r2 = kotlin.s0.w.d.l0.f.y.b.f20212a;
        o.e(r2, "packageFqName");
        i.f<kotlin.s0.w.d.l0.f.d, List<kotlin.s0.w.d.l0.f.b>> r3 = kotlin.s0.w.d.l0.f.y.b.f20214c;
        o.e(r3, "constructorAnnotation");
        i.f<kotlin.s0.w.d.l0.f.c, List<kotlin.s0.w.d.l0.f.b>> r4 = kotlin.s0.w.d.l0.f.y.b.f20213b;
        o.e(r4, "classAnnotation");
        i.f<kotlin.s0.w.d.l0.f.i, List<kotlin.s0.w.d.l0.f.b>> r5 = kotlin.s0.w.d.l0.f.y.b.f20215d;
        o.e(r5, "functionAnnotation");
        i.f<n, List<kotlin.s0.w.d.l0.f.b>> r6 = kotlin.s0.w.d.l0.f.y.b.f20216e;
        o.e(r6, "propertyAnnotation");
        i.f<n, List<kotlin.s0.w.d.l0.f.b>> r7 = kotlin.s0.w.d.l0.f.y.b.f20217f;
        o.e(r7, "propertyGetterAnnotation");
        i.f<n, List<kotlin.s0.w.d.l0.f.b>> r8 = kotlin.s0.w.d.l0.f.y.b.f20218g;
        o.e(r8, "propertySetterAnnotation");
        i.f<kotlin.s0.w.d.l0.f.g, List<kotlin.s0.w.d.l0.f.b>> r9 = kotlin.s0.w.d.l0.f.y.b.f20220i;
        o.e(r9, "enumEntryAnnotation");
        i.f<n, kotlin.s0.w.d.l0.f.b.C0541b.c> r10 = kotlin.s0.w.d.l0.f.y.b.f20219h;
        o.e(r10, "compileTimeValue");
        i.f<u, List<kotlin.s0.w.d.l0.f.b>> r11 = kotlin.s0.w.d.l0.f.y.b.f20221j;
        o.e(r11, "parameterAnnotation");
        i.f<q, List<kotlin.s0.w.d.l0.f.b>> r12 = kotlin.s0.w.d.l0.f.y.b.f20222k;
        o.e(r12, "typeAnnotation");
        i.f<s, List<kotlin.s0.w.d.l0.f.b>> r13 = kotlin.s0.w.d.l0.f.y.b.f20223l;
        o.e(r13, "typeParameterAnnotation");
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    private final String o(kotlin.s0.w.d.l0.g.c r1) {
        if (r1.d() == false) goto L5;
        return "default-package";
    L5:
        String r0 = r1.g().b();
        o.e(r0, "fqName.shortName().asString()");
        return r0;
    }

    public final String m(kotlin.s0.w.d.l0.g.c r2) {
        o.f(r2, "fqName");
        return o(r2) + ".kotlin_builtins";
    }

    public final String n(kotlin.s0.w.d.l0.g.c r8) {
        o.f(r8, "fqName");
        StringBuilder r0 = new StringBuilder();
        String r1 = r8.b();
        o.e(r1, "fqName.asString()");
        r0.append(k.v(r1, '.', '/', false, 4, null));
        r0.append('/');
        r0.append(m(r8));
        return r0.toString();
    }
}
