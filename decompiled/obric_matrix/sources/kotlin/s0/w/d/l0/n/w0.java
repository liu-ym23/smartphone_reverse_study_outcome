package kotlin.s0.w.d.l0.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f21177e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w0 f21178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.c.e1 f21179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<g1> f21180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<kotlin.s0.w.d.l0.c.f1, g1> f21181d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final w0 a(w0 r7, kotlin.s0.w.d.l0.c.e1 r8, List<? extends g1> r9) {
            kotlin.n0.d.o.f(r8, "typeAliasDescriptor");
            kotlin.n0.d.o.f(r9, "arguments");
            List<kotlin.s0.w.d.l0.c.f1> r6 = r8.k().getParameters();
            kotlin.n0.d.o.e(r6, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList r0 = new ArrayList(kotlin.i0.r.q(r6, 10));
            Iterator<T> r10 = r6.iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            r0.add(((kotlin.s0.w.d.l0.c.f1) r10.next()).a());
            goto L4
        L7:
            return new w0(r7, r8, r9, kotlin.i0.m0.q(kotlin.i0.r.G0(r0, r9)), null);
        }
    }

    static {
        f21177e = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private w0(w0 r1, kotlin.s0.w.d.l0.c.e1 r2, List<? extends g1> r3, Map<kotlin.s0.w.d.l0.c.f1, ? extends g1> r4) {
        this.f21178a = r1;
        this.f21179b = r2;
        this.f21180c = r3;
        this.f21181d = r4;
    }

    public /* synthetic */ w0(w0 r1, kotlin.s0.w.d.l0.c.e1 r2, List r3, Map r4, kotlin.n0.d.g r5) {
        this(r1, r2, r3, r4);
    }

    public final List<g1> a() {
        return this.f21180c;
    }

    public final kotlin.s0.w.d.l0.c.e1 b() {
        return this.f21179b;
    }

    public final g1 c(e1 r2) {
        kotlin.n0.d.o.f(r2, "constructor");
        kotlin.s0.w.d.l0.c.h r3 = r2.d();
        if ((r3 instanceof kotlin.s0.w.d.l0.c.f1) == true) goto L7;
        return null;
    L7:
        return this.f21181d.get(r3);
    }

    public final boolean d(kotlin.s0.w.d.l0.c.e1 r3) {
        kotlin.n0.d.o.f(r3, "descriptor");
        if (kotlin.n0.d.o.a(this.f21179b, r3) == true) goto L9;
        w0 r2 = this.f21178a;
        if (r2 == null) goto L7;
        boolean r4 = r2.d(r3);
    L8:
        if (r4 == true) goto L9;
        return false;
    L7:
        r4 = false;
    L9:
        return true;
    }
}
