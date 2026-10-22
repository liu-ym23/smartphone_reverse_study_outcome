package kotlin.s0.w.d.l0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.g.b> f18672b = null;

    static {
        f18671a = new c();
        Set<i> r0 = i.f18689j;
        ArrayList r1 = new ArrayList(r.q(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(k.c((i) r2.next()));
        goto L4
    L6:
        kotlin.s0.w.d.l0.g.c r3 = k.a.f18724g.l();
        kotlin.n0.d.o.e(r3, "string.toSafe()");
        List r4 = r.l0(r1, r3);
        kotlin.s0.w.d.l0.g.c r5 = k.a.f18726i.l();
        kotlin.n0.d.o.e(r5, "_boolean.toSafe()");
        List r6 = r.l0(r4, r5);
        kotlin.s0.w.d.l0.g.c r7 = k.a.f18728k.l();
        kotlin.n0.d.o.e(r7, "_enum.toSafe()");
        List r8 = r.l0(r6, r7);
        LinkedHashSet r9 = new LinkedHashSet();
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r9.add(kotlin.s0.w.d.l0.g.b.m((kotlin.s0.w.d.l0.g.c) r10.next()));
        goto L8
    L10:
        f18672b = r9;
    }

    private c() {
    }

    public final Set<kotlin.s0.w.d.l0.g.b> a() {
        return f18672b;
    }

    public final Set<kotlin.s0.w.d.l0.g.b> b() {
        return f18672b;
    }
}
