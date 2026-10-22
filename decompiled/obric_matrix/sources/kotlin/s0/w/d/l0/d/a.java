package kotlin.s0.w.d.l0.d;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.e;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.d.b.b;
import kotlin.s0.w.d.l0.d.b.c;
import kotlin.s0.w.d.l0.g.f;
import kotlin.s0.w.d.l0.k.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final void a(c r7, b r8, e r9, f r10) {
        o.f(r7, "<this>");
        o.f(r8, TypedValues.TransitionType.S_FROM);
        o.f(r9, "scopeOwner");
        o.f(r10, "name");
        if (r7 != c.a.f19185a) goto L5;
        return;
    L5:
        kotlin.s0.w.d.l0.d.b.a r11 = r8.getLocation();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r7.a() == false) goto L11;
        kotlin.s0.w.d.l0.d.b.e r0 = r11.getPosition();
    L12:
        String r2 = r11.a();
        String r4 = d.m(r9).b();
        o.e(r4, "getFqName(scopeOwner).asString()");
        kotlin.s0.w.d.l0.d.b.f r5 = kotlin.s0.w.d.l0.d.b.f.f19198g;
        String r6 = r10.b();
        o.e(r6, "name.asString()");
        r7.b(r2, r0, r4, r5, r6);
        return;
    L11:
        r0 = kotlin.s0.w.d.l0.d.b.e.f19193h.a();
        goto L12
    }

    public static final void b(c r1, b r2, l0 r3, f r4) {
        o.f(r1, "<this>");
        o.f(r2, TypedValues.TransitionType.S_FROM);
        o.f(r3, "scopeOwner");
        o.f(r4, "name");
        String r5 = r3.e().b();
        o.e(r5, "scopeOwner.fqName.asString()");
        String r6 = r4.b();
        o.e(r6, "name.asString()");
        c(r1, r2, r5, r6);
    }

    public static final void c(c r7, b r8, String r9, String r10) {
        o.f(r7, "<this>");
        o.f(r8, TypedValues.TransitionType.S_FROM);
        o.f(r9, "packageFqName");
        o.f(r10, "name");
        if (r7 != c.a.f19185a) goto L5;
        return;
    L5:
        kotlin.s0.w.d.l0.d.b.a r11 = r8.getLocation();
        if (r11 != null) goto L9;
        return;
    L9:
        if (r7.a() == false) goto L11;
        kotlin.s0.w.d.l0.d.b.e r0 = r11.getPosition();
    L12:
        String r2 = r11.a();
        r7.b(r2, r0, r9, kotlin.s0.w.d.l0.d.b.f.f19197f, r10);
        return;
    L11:
        r0 = kotlin.s0.w.d.l0.d.b.e.f19193h.a();
        goto L12
    }
}
