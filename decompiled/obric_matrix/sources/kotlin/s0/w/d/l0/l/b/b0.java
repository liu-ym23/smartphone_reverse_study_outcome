package kotlin.s0.w.d.l0.l.b;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20700a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20701b = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.f.j.values().length];
            r0[kotlin.s0.w.d.l0.f.j.f20026g.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.f.j.f20027h.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.f.j.f20028i.ordinal()] = 3;
            r0[kotlin.s0.w.d.l0.f.j.f20029j.ordinal()] = 4;
            f20700a = r0;
            int[] r1 = new int[kotlin.s0.w.d.l0.c.b.a.values().length];
            r1[kotlin.s0.w.d.l0.c.b.a.f18848f.ordinal()] = 1;
            r1[kotlin.s0.w.d.l0.c.b.a.f18849g.ordinal()] = 2;
            r1[kotlin.s0.w.d.l0.c.b.a.f18850h.ordinal()] = 3;
            r1[kotlin.s0.w.d.l0.c.b.a.f18851i.ordinal()] = 4;
            int[] r2 = new int[kotlin.s0.w.d.l0.f.x.values().length];
            r2[kotlin.s0.w.d.l0.f.x.f20203g.ordinal()] = 1;
            r2[kotlin.s0.w.d.l0.f.x.f20204h.ordinal()] = 2;
            r2[kotlin.s0.w.d.l0.f.x.f20207k.ordinal()] = 3;
            r2[kotlin.s0.w.d.l0.f.x.f20205i.ordinal()] = 4;
            r2[kotlin.s0.w.d.l0.f.x.f20206j.ordinal()] = 5;
            r2[kotlin.s0.w.d.l0.f.x.f20208l.ordinal()] = 6;
            f20701b = r2;
        }
    }

    public static final kotlin.s0.w.d.l0.c.u a(a0 r1, kotlin.s0.w.d.l0.f.x r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (r2 != null) goto L5;
        int r3 = -1;
    L6:
        String r4 = "PRIVATE";
        switch(r3) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L13;
        };
    L9:
        kotlin.s0.w.d.l0.c.u r5 = kotlin.s0.w.d.l0.c.t.f19164f;
        r4 = "LOCAL";
    L15:
        kotlin.n0.d.o.e(r5, r4);
        return r5;
    L10:
        r5 = kotlin.s0.w.d.l0.c.t.f19163e;
        r4 = "PUBLIC";
        goto L15
    L11:
        r5 = kotlin.s0.w.d.l0.c.t.f19161c;
        r4 = "PROTECTED";
        goto L15
    L12:
        r5 = kotlin.s0.w.d.l0.c.t.f19160b;
        r4 = "PRIVATE_TO_THIS";
        goto L15
    L13:
        r5 = kotlin.s0.w.d.l0.c.t.f19159a;
        goto L15
    L14:
        r5 = kotlin.s0.w.d.l0.c.t.f19162d;
        r4 = "INTERNAL";
        goto L15
    L5:
        r3 = a.f20701b[r2.ordinal()];
        goto L6
    }

    public static final kotlin.s0.w.d.l0.c.b.a b(a0 r1, kotlin.s0.w.d.l0.f.j r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        if (r2 != null) goto L5;
        int r3 = -1;
    L7:
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L21;
        if (r3 != 4) goto L19;
        return kotlin.s0.w.d.l0.c.b.a.f18851i;
    L21:
        return kotlin.s0.w.d.l0.c.b.a.f18850h;
    L22:
        return kotlin.s0.w.d.l0.c.b.a.f18849g;
    L19:
        return kotlin.s0.w.d.l0.c.b.a.f18848f;
    L5:
        r3 = a.f20700a[r2.ordinal()];
        goto L7
    }
}
