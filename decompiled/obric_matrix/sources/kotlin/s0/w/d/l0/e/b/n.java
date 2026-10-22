package kotlin.s0.w.d.l0.e.b;

import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes2.dex */
final class n implements m<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f19788a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19789a = null;

        static {
            int[] r0 = new int[kotlin.s0.w.d.l0.b.i.values().length];
            r0[kotlin.s0.w.d.l0.b.i.f18690k.ordinal()] = 1;
            r0[kotlin.s0.w.d.l0.b.i.f18691l.ordinal()] = 2;
            r0[kotlin.s0.w.d.l0.b.i.m.ordinal()] = 3;
            r0[kotlin.s0.w.d.l0.b.i.n.ordinal()] = 4;
            r0[kotlin.s0.w.d.l0.b.i.o.ordinal()] = 5;
            r0[kotlin.s0.w.d.l0.b.i.p.ordinal()] = 6;
            r0[kotlin.s0.w.d.l0.b.i.q.ordinal()] = 7;
            r0[kotlin.s0.w.d.l0.b.i.r.ordinal()] = 8;
            f19789a = r0;
        }
    }

    static {
        f19788a = new n();
    }

    private n() {
    }

    @Override // kotlin.s0.w.d.l0.e.b.m
    public /* bridge */ /* synthetic */ String a(l r1) {
        return l(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.m
    public /* bridge */ /* synthetic */ l b(String r1) {
        return h(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.m
    public /* bridge */ /* synthetic */ l c(String r1) {
        return i(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.m
    public /* bridge */ /* synthetic */ l d(l r1) {
        return g(r1);
    }

    @Override // kotlin.s0.w.d.l0.e.b.m
    public /* bridge */ /* synthetic */ l e() {
        return k();
    }

    @Override // kotlin.s0.w.d.l0.e.b.m
    public /* bridge */ /* synthetic */ l f(kotlin.s0.w.d.l0.b.i r1) {
        return j(r1);
    }

    public l g(l r3) {
        kotlin.n0.d.o.f(r3, "possiblyPrimitiveType");
        if ((r3 instanceof l.d) == false) goto L8;
        l.d r0 = (l.d) r3;
        if (r0.i() == null) goto L9;
        String r4 = kotlin.s0.w.d.l0.k.u.d.c(r0.i().l()).f();
        kotlin.n0.d.o.e(r4, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return i(r4);
    L9:
        return r3;
    L8:
        return r3;
    }

    public l h(String r10) {
        kotlin.n0.d.o.f(r10, "representation");
        r10.length();
        char r1 = r10.charAt(0);
        kotlin.s0.w.d.l0.k.u.e[] r2 = kotlin.s0.w.d.l0.k.u.e.values();
        int r3 = r2.length;
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L12;
        kotlin.s0.w.d.l0.k.u.e r7 = r2[r4];
        if (r7.g().charAt(0) != r1) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L13;
        r4 = r4 + 1;
    L13:
        if (r7 == null) goto L17;
        return new l.d(r7);
    L17:
        if (r1 != 'V') goto L20;
        return new l.d(null);
    L20:
        if (r1 != '[') goto L23;
        String r11 = r10.substring(1);
        kotlin.n0.d.o.e(r11, "this as java.lang.String).substring(startIndex)");
        return new l.a(h(r11));
    L23:
        if (r1 != 'L') goto L25;
        kotlin.u0.k.H(r10, ';', false, 2, null);
    L25:
        String r12 = r10.substring(1, r10.length() - 1);
        kotlin.n0.d.o.e(r12, "this as java.lang.String…ing(startIndex, endIndex)");
        return new l.c(r12);
    L8:
        r8 = false;
        goto L9
    L12:
        r7 = null;
        goto L13
    }

    public l.c i(String r1) {
        kotlin.n0.d.o.f(r1, "internalName");
        return new l.c(r1);
    }

    public l j(kotlin.s0.w.d.l0.b.i r1) {
        kotlin.n0.d.o.f(r1, "primitiveType");
        switch(a.f19789a[r1.ordinal()]) {
            case 1: goto L14;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L5;
        };
    L5:
        throw new kotlin.m();
    L15:
        return l.f19776a.d();
    L16:
        return l.f19776a.g();
    L17:
        return l.f19776a.e();
    L18:
        return l.f19776a.f();
    L19:
        return l.f19776a.h();
    L20:
        return l.f19776a.b();
    L21:
        return l.f19776a.c();
    L14:
        return l.f19776a.a();
    }

    public l k() {
        return i("java/lang/Class");
    }

    public String l(l r3) {
        kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
        if ((r3 instanceof l.a) == false) goto L6;
        return '[' + l(((l.a) r3).i());
    L6:
        if ((r3 instanceof l.d) == false) goto L13;
        kotlin.s0.w.d.l0.k.u.e r2 = ((l.d) r3).i();
        if (r2 == null) goto L11;
        String r4 = r2.g();
        if (r4 == null) goto L11;
        return r4;
    L11:
        return "V";
    L13:
        if ((r3 instanceof l.c) == false) goto L17;
        return 'L' + ((l.c) r3).i() + ';';
    L17:
        throw new kotlin.m();
    }
}
