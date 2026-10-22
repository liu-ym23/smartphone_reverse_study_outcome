package kotlin.s0.w.d.l0.k.q.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.i;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.h;
import kotlin.s0.w.d.l0.m.f;
import kotlin.s0.w.d.l0.m.n;
import kotlin.s0.w.d.l0.n.c0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.h0;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.j1;
import kotlin.s0.w.d.l0.n.r1;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    static final class a extends q implements kotlin.n0.c.a<e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ g1 f20560f;

        a(g1 r1) {
            this.f20560f = r1;
            super(0);
        }

        public final e0 a() {
            e0 r1 = this.f20560f.b();
            o.e(r1, "this@createCapturedIfNeeded.type");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ e0 invoke() {
            return a();
        }
    }

    public static final class b extends kotlin.s0.w.d.l0.n.q {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f20561c;

        b(j1 r1, boolean r2) {
            this.f20561c = r2;
            super(r1);
        }

        @Override // kotlin.s0.w.d.l0.n.j1
        public boolean b() {
            return this.f20561c;
        }

        @Override // kotlin.s0.w.d.l0.n.q, kotlin.s0.w.d.l0.n.j1
        public g1 e(e0 r3) {
            o.f(r3, "key");
            g1 r2 = super.e(r3);
            f1 r0 = null;
            if (r2 == null) goto L9;
            h r4 = r3.O0().d();
            if ((r4 instanceof f1) == false) goto L8;
            r0 = (f1) r4;
        L8:
            return d.a(r2, r0);
        L9:
            return null;
        }
    }

    public static final /* synthetic */ g1 a(g1 r0, f1 r1) {
        return b(r0, r1);
    }

    private static final g1 b(g1 r3, f1 r4) {
        if (r4 != null) goto L4;
    L15:
        return r3;
    L4:
        if (r3.a() == r1.f21065h) goto L15;
        if (r4.n() != r3.a()) goto L14;
        if (r3.d() == false) goto L12;
        n r1 = f.f20912e;
        o.e(r1, "NO_LOCKS");
        return new i1(new h0(r1, new a(r3)));
    L12:
        return new i1(r3.b());
    L14:
        return new i1(c(r3));
    }

    public static final e0 c(g1 r8) {
        o.f(r8, "typeProjection");
        return new kotlin.s0.w.d.l0.k.q.a.a(r8, null, false, null, 14, null);
    }

    public static final boolean d(e0 r1) {
        o.f(r1, "<this>");
        return r1.O0() instanceof kotlin.s0.w.d.l0.k.q.a.b;
    }

    public static final j1 e(j1 r4, boolean r5) {
        o.f(r4, "<this>");
        if ((r4 instanceof c0) == false) goto L10;
        c0 r6 = (c0) r4;
        f1[] r0 = r6.j();
        List r7 = i.s0(r6.i(), r6.j());
        ArrayList r1 = new ArrayList(r.q(r7, 10));
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        u r2 = (u) r8.next();
        r1.add(b((g1) r2.c(), (f1) r2.d()));
        goto L6
    L8:
        Object[] r9 = r1.toArray(new g1[0]);
        o.d(r9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new c0(r0, (g1[]) r9, r5);
    L10:
        return new b(r4, r5);
    }

    public static /* synthetic */ j1 f(j1 r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return e(r0, r1);
    }
}
