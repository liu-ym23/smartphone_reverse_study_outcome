package kotlin.s0.w.d.l0.f.z;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.f.q;
import kotlin.s0.w.d.l0.f.t;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<q> f20248a;

    public g(t r6) {
        o.f(r6, "typeTable");
        List<q> r0 = r6.A();
        if (r6.B() == false) goto L16;
        int r1 = r6.w();
        List<q> r7 = r6.A();
        o.e(r7, "typeTable.typeList");
        ArrayList r2 = new ArrayList(r.q(r7, 10));
        int r3 = 0;
        Iterator<T> r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L15;
        Object r4 = r8.next();
        int r5 = r3 + 1;
        if (r3 < 0) goto L13;
        q r9 = (q) r4;
        if (r3 < r1) goto L12;
        q.c r10 = r9.A0();
        r10.N(true);
        r9 = r10.v();
    L12:
        r2.add(r9);
        r3 = r5;
        goto L6
    L13:
        r.p();
        throw null;
    L15:
        r0 = r2;
    L16:
        o.e(r0, "run {\n        val origin… else originalTypes\n    }");
        this.f20248a = r0;
    }

    public final q a(int r1) {
        return this.f20248a.get(r1);
    }
}
