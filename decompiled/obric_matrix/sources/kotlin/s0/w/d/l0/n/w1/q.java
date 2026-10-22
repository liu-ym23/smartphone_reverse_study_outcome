package kotlin.s0.w.d.l0.n.w1;

import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21186a = null;

        static {
            int[] r0 = new int[r1.values().length];
            r0[r1.f21065h.ordinal()] = 1;
            r0[r1.f21066i.ordinal()] = 2;
            r0[r1.f21067j.ordinal()] = 3;
            f21186a = r0;
        }
    }

    public static final u a(r1 r1) {
        kotlin.n0.d.o.f(r1, "<this>");
        int r2 = a.f21186a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return u.f21188h;
    L10:
        throw new kotlin.m();
    L15:
        return u.f21187g;
    L13:
        return u.f21189i;
    }
}
