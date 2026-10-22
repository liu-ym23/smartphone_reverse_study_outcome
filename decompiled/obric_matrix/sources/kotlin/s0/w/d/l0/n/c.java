package kotlin.s0.w.d.l0.n;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f20945a = null;

    static {
        f20945a = new c();
    }

    private c() {
    }

    private final boolean c(d1 r3, kotlin.s0.w.d.l0.n.w1.k r4, kotlin.s0.w.d.l0.n.w1.n r5) {
        kotlin.s0.w.d.l0.n.w1.p r2 = r3.j();
        if (r2.f0(r4) == false) goto L6;
        return true;
    L6:
        if (r2.W(r4) == false) goto L10;
        return false;
    L10:
        if (r3.n() == false) goto L15;
        if (r2.n0(r4) == false) goto L15;
        return true;
    L15:
        return r2.A0(r2.c(r4), r5);
    }

    private final boolean e(d1 r4, kotlin.s0.w.d.l0.n.w1.k r5, kotlin.s0.w.d.l0.n.w1.k r6) {
        kotlin.s0.w.d.l0.n.w1.p r3 = r4.j();
        if (f.f20980b == false) goto L13;
        if (r3.b(r5) == true) goto L10;
        if (r3.Z(r3.c(r5)) == true) goto L10;
        r4.l(r5);
    L10:
        if (r3.b(r6) == true) goto L13;
        r4.l(r6);
    L13:
        if (r3.W(r6) == false) goto L16;
        return true;
    L16:
        if (r3.C(r5) == false) goto L18;
    L39:
        return true;
    L18:
        if (r3.I(r5) == true) goto L39;
        if ((r5 instanceof kotlin.s0.w.d.l0.n.w1.d) == true) goto L23;
    L25:
        c r0 = f20945a;
        if (r0.a(r4, r5, d1.c.b.f20972a) == false) goto L29;
        return true;
    L29:
        if (r3.C(r6) == false) goto L32;
        return false;
    L32:
        if (r0.a(r4, r6, d1.c.d.f20974a) == false) goto L35;
        return false;
    L35:
        if (r3.v0(r5) == false) goto L38;
        return false;
    L38:
        return r0.b(r4, r5, r3.c(r6));
    L23:
        if (r3.k((kotlin.s0.w.d.l0.n.w1.d) r5) == false) goto L25;
        return true;
    }

    public final boolean a(d1 r13, kotlin.s0.w.d.l0.n.w1.k r14, d1.c r15) {
        kotlin.n0.d.o.f(r13, "<this>");
        kotlin.n0.d.o.f(r14, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.f(r15, "supertypesPolicy");
        kotlin.s0.w.d.l0.n.w1.p r12 = r13.j();
        if (r12.v0(r14) == false) goto L7;
        if (r12.W(r14) == true) goto L7;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L56;
        r13.k();
        ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> r1 = r13.h();
        kotlin.n0.d.o.c(r1);
        Set<kotlin.s0.w.d.l0.n.w1.k> r3 = r13.i();
        kotlin.n0.d.o.c(r3);
        r1.push(r14);
    L14:
        if ((!r1.isEmpty()) == false) goto L45;
        if (r3.size() > 1000) goto L44;
        kotlin.s0.w.d.l0.n.w1.k r4 = r1.pop();
        kotlin.n0.d.o.e(r4, "current");
        if (r3.add(r4) == false) goto L14;
        if (r12.W(r4) == false) goto L22;
        d1.c r5 = d1.c.C0576c.f20973a;
    L24:
        if ((!kotlin.n0.d.o.a(r5, d1.c.C0576c.f20973a)) == true) goto L27;
        r5 = null;
    L27:
        if (r5 == null) goto L14;
        kotlin.s0.w.d.l0.n.w1.p r6 = r13.j();
        Iterator<kotlin.s0.w.d.l0.n.w1.i> r7 = r6.t(r6.c(r4)).iterator();
    L31:
        if (r7.hasNext() == false) goto L14;
        kotlin.s0.w.d.l0.n.w1.k r8 = r5.a(r13, r7.next());
        if (r12.v0(r8) == false) goto L37;
        if (r12.W(r8) == true) goto L37;
    L38:
        boolean r9 = true;
    L40:
        if (r9 == true) goto L41;
        r1.add(r8);
        goto L31
    L41:
        r13.e();
    L37:
        if (r12.C(r8) == true) goto L38;
        r9 = false;
        goto L40
    L22:
        r5 = r15;
        goto L24
    L44:
        throw new IllegalStateException(("Too many supertypes for type: " + r14 + ". Supertypes = " + kotlin.i0.r.Z(r3, null, null, null, 0, null, null, 63, null)).toString());
    L45:
        r13.e();
        return false;
    L56:
        return true;
    L7:
        if (r12.C(r14) == true) goto L8;
        r0 = false;
        goto L10
    }

    public final boolean b(d1 r12, kotlin.s0.w.d.l0.n.w1.k r13, kotlin.s0.w.d.l0.n.w1.n r14) {
        kotlin.n0.d.o.f(r12, WsConstants.KEY_CONNECTION_STATE);
        kotlin.n0.d.o.f(r13, "start");
        kotlin.n0.d.o.f(r14, "end");
        kotlin.s0.w.d.l0.n.w1.p r11 = r12.j();
        if (f20945a.c(r12, r13, r14) == true) goto L43;
        r12.k();
        ArrayDeque<kotlin.s0.w.d.l0.n.w1.k> r0 = r12.h();
        kotlin.n0.d.o.c(r0);
        Set<kotlin.s0.w.d.l0.n.w1.k> r2 = r12.i();
        kotlin.n0.d.o.c(r2);
        r0.push(r13);
    L7:
        if ((!r0.isEmpty()) == false) goto L31;
        if (r2.size() > 1000) goto L30;
        kotlin.s0.w.d.l0.n.w1.k r3 = r0.pop();
        kotlin.n0.d.o.e(r3, "current");
        if (r2.add(r3) == false) goto L7;
        if (r11.W(r3) == false) goto L15;
        d1.c r4 = d1.c.C0576c.f20973a;
    L17:
        if ((!kotlin.n0.d.o.a(r4, d1.c.C0576c.f20973a)) == true) goto L20;
        r4 = null;
    L20:
        if (r4 == null) goto L7;
        kotlin.s0.w.d.l0.n.w1.p r5 = r12.j();
        Iterator<kotlin.s0.w.d.l0.n.w1.i> r6 = r5.t(r5.c(r3)).iterator();
    L24:
        if (r6.hasNext() == false) goto L7;
        kotlin.s0.w.d.l0.n.w1.k r7 = r4.a(r12, r6.next());
        if (f20945a.c(r12, r7, r14) == true) goto L27;
        r0.add(r7);
        goto L24
    L27:
        r12.e();
        return true;
    L15:
        r4 = d1.c.b.f20972a;
        goto L17
    L30:
        throw new IllegalStateException(("Too many supertypes for type: " + r13 + ". Supertypes = " + kotlin.i0.r.Z(r2, null, null, null, 0, null, null, 63, null)).toString());
    L31:
        r12.e();
        return false;
    L43:
        return true;
    }

    public final boolean d(d1 r2, kotlin.s0.w.d.l0.n.w1.k r3, kotlin.s0.w.d.l0.n.w1.k r4) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_STATE);
        kotlin.n0.d.o.f(r3, "subType");
        kotlin.n0.d.o.f(r4, "superType");
        return e(r2, r3, r4);
    }
}
