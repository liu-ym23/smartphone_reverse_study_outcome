package com.bytedance.lighten.loader;

/* JADX INFO: loaded from: classes.dex */
class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.c.f.e.p.b f4980a = null;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4981a = null;

        static {
            int[] r0 = new int[d.b.k.a.u.values().length];
            f4981a = r0;
            r0[d.b.k.a.u.f14073f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f4981a[d.b.k.a.u.f14074g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f4981a[d.b.k.a.u.f14076i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f4981a[d.b.k.a.u.f14075h.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f4981a[d.b.k.a.u.f14077j.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f4981a[d.b.k.a.u.f14079l.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f4981a[d.b.k.a.u.f14078k.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f4981a[d.b.k.a.u.m.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        f4980a = d.c.f.e.p.b.f15668g;
    }

    public static d.c.f.e.p.b a(d.b.k.a.u r2) {
        d.c.f.e.p.b r0 = f4980a;
        switch(a.f4981a[r2.ordinal()]) {
            case 1: goto L13;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            default: goto L21;
        };
    L21:
        return r0;
    L14:
        return d.c.f.e.p.b.f15669h;
    L15:
        return d.c.f.e.p.b.f15667f;
    L16:
        return d.c.f.e.p.b.f15668g;
    L17:
        return d.c.f.e.p.b.f15666e;
    L18:
        return d.c.f.e.p.b.f15664c;
    L19:
        return d.c.f.e.p.b.f15665d;
    L20:
        return d.c.f.e.p.b.f15663b;
    L13:
        return d.c.f.e.p.b.f15662a;
    }
}
