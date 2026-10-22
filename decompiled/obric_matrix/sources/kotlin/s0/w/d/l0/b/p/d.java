package kotlin.s0.w.d.l0.b.p;

import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.m.n;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends kotlin.s0.w.d.l0.k.w.e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18765a = null;

        static {
            int[] r0 = new int[c.values().length];
            r0[c.f18757i.ordinal()] = 1;
            r0[c.f18758j.ordinal()] = 2;
            f18765a = r0;
        }
    }

    public d(n r2, b r3) {
        o.f(r2, "storageManager");
        o.f(r3, "containingClass");
        super(r2, r3);
    }

    @Override // kotlin.s0.w.d.l0.k.w.e
    protected List<y> i() {
        kotlin.s0.w.d.l0.c.e r0 = l();
        o.d(r0, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        c r1 = ((b) r0).V0();
        int r2 = a.f18765a[r1.ordinal()];
        boolean r3 = true;
        if (r2 != 1) goto L5;
        e.a r4 = e.f18766J;
        b r5 = (b) l();
        r3 = false;
    L10:
        return r.d(r4.a(r5, r3));
    L5:
        if (r2 != 2) goto L11;
        r4 = e.f18766J;
        r5 = (b) l();
        goto L10
    L11:
        return r.g();
    }
}
