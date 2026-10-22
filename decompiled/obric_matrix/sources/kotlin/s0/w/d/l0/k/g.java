package kotlin.s0.w.d.l0.k;

import java.util.Comparator;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.y;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Comparator<kotlin.s0.w.d.l0.c.m> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f20525f = null;

    static {
        f20525f = new g();
    }

    private g() {
    }

    private static Integer b(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.c.m r3) {
        int r0 = c(r3) - c(r2);
        if (r0 == 0) goto L7;
        return Integer.valueOf(r0);
    L7:
        if (d.B(r2) == true) goto L9;
    L12:
        int r4 = r2.getName().c(r3.getName());
        if (r4 != 0) goto L15;
        return null;
    L15:
        return Integer.valueOf(r4);
    L9:
        if (d.B(r3) == false) goto L12;
        return 0;
    }

    private static int c(kotlin.s0.w.d.l0.c.m r1) {
        if (d.B(r1) == false) goto L7;
        return 8;
    L7:
        if ((r1 instanceof kotlin.s0.w.d.l0.c.l) == false) goto L11;
        return 7;
    L11:
        if ((r1 instanceof u0) == false) goto L19;
        if (((u0) r1).m0() != null) goto L16;
        return 6;
    L16:
        return 5;
    L19:
        if ((r1 instanceof y) == false) goto L27;
        if (((y) r1).m0() != null) goto L24;
        return 4;
    L24:
        return 3;
    L27:
        if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L31;
        return 2;
    L31:
        if ((r1 instanceof e1) == false) goto L34;
        return 1;
    L34:
        return 0;
    }

    public int a(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
        Integer r0 = b(r1, r2);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
        return a(r1, r2);
    }
}
