package kotlin.s0.w.d.l0.b.q;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.n.f1;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final f1 a(kotlin.s0.w.d.l0.c.e r4, kotlin.s0.w.d.l0.c.e r5) {
        o.f(r4, TypedValues.TransitionType.S_FROM);
        o.f(r5, TypedValues.TransitionType.S_TO);
        r4.u().size();
        r5.u().size();
        f1.a r0 = f1.f21004b;
        List<kotlin.s0.w.d.l0.c.f1> r6 = r4.u();
        o.e(r6, "from.declaredTypeParameters");
        ArrayList r1 = new ArrayList(r.q(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r1.add(((kotlin.s0.w.d.l0.c.f1) r7.next()).k());
        goto L4
    L6:
        List<kotlin.s0.w.d.l0.c.f1> r8 = r5.u();
        o.e(r8, "to.declaredTypeParameters");
        ArrayList r9 = new ArrayList(r.q(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        m0 r2 = ((kotlin.s0.w.d.l0.c.f1) r10.next()).s();
        o.e(r2, "it.defaultType");
        r9.add(kotlin.s0.w.d.l0.n.x1.a.a(r2));
        goto L8
    L11:
        return f1.a.e(r0, kotlin.i0.m0.q(r.G0(r1, r9)), false, 2, null);
    }
}
