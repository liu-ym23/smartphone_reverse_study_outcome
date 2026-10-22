package kotlin.s0.w.d.l0.b;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f18745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.g.f> f18746b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> f18747c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.g.b> f18748d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<kotlin.s0.w.d.l0.g.f> f18749e = null;

    static {
        f18745a = new o();
        n[] r0 = n.values();
        ArrayList r1 = new ArrayList(r0.length);
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r1.add(r0[r4].g());
        r4 = r4 + 1;
        goto L3
    L5:
        f18746b = r.D0(r1);
        m[] r5 = m.values();
        ArrayList r6 = new ArrayList(r5.length);
        int r7 = r5.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L8;
        r6.add(r5[r8].b());
        r8 = r8 + 1;
        goto L6
    L8:
        r.D0(r6);
        f18747c = new HashMap();
        f18748d = new HashMap();
        m0.j(new u[]{a0.a(m.f18731h, kotlin.s0.w.d.l0.g.f.k("ubyteArrayOf")), a0.a(m.f18732i, kotlin.s0.w.d.l0.g.f.k("ushortArrayOf")), a0.a(m.f18733j, kotlin.s0.w.d.l0.g.f.k("uintArrayOf")), a0.a(m.f18734k, kotlin.s0.w.d.l0.g.f.k("ulongArrayOf"))});
        n[] r9 = n.values();
        LinkedHashSet r10 = new LinkedHashSet();
        int r11 = r9.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        r10.add(r9[r12].b().j());
        r12 = r12 + 1;
        goto L9
    L11:
        f18749e = r10;
        n[] r13 = n.values();
        int r14 = r13.length;
    L12:
        if (r3 >= r14) goto L14;
        n r15 = r13[r3];
        f18747c.put(r15.b(), r15.c());
        f18748d.put(r15.c(), r15.b());
        r3 = r3 + 1;
        goto L12
    }

    private o() {
    }

    public static final boolean d(e0 r2) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
        if (n1.v(r2) == false) goto L5;
        return false;
    L5:
        kotlin.s0.w.d.l0.c.h r3 = r2.O0().d();
        if (r3 != null) goto L9;
        return false;
    L9:
        return f18745a.c(r3);
    }

    public final kotlin.s0.w.d.l0.g.b a(kotlin.s0.w.d.l0.g.b r1) {
        kotlin.n0.d.o.f(r1, "arrayClassId");
        return f18747c.get(r1);
    }

    public final boolean b(kotlin.s0.w.d.l0.g.f r1) {
        kotlin.n0.d.o.f(r1, "name");
        return f18749e.contains(r1);
    }

    public final boolean c(kotlin.s0.w.d.l0.c.m r2) {
        kotlin.n0.d.o.f(r2, "descriptor");
        kotlin.s0.w.d.l0.c.m r1 = r2.c();
        if ((r1 instanceof l0) == true) goto L5;
    L9:
        return false;
    L5:
        if (kotlin.n0.d.o.a(((l0) r1).e(), k.f18715k) == false) goto L9;
        if (f18746b.contains(r2.getName()) == false) goto L9;
        return true;
    }
}
