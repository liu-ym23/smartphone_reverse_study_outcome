package d.c.i.e;

/* JADX INFO: loaded from: classes2.dex */
public class t implements h.c {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15979a = null;

        static {
            int[] r0 = new int[d.c.c.g.b.values().length];
            f15979a = r0;
            r0[d.c.c.g.b.f15395g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f15979a[d.c.c.g.b.f15399k.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f15979a[d.c.c.g.b.f15396h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f15979a[d.c.c.g.b.f15397i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f15979a[d.c.c.g.b.f15398j.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public t() {
    }

    @Override // d.c.i.e.h.c
    public double a(d.c.c.g.b r5) {
        int r4 = a.f15979a[r5.ordinal()];
        if (r4 != 1) goto L5;
        return 0.0d;
    L5:
        if (r4 != 2) goto L7;
        return 1.0d;
    L7:
        if (r4 != 3) goto L9;
        return 1.0d;
    L9:
        if (r4 != 4) goto L11;
        return 1.0d;
    L11:
        if (r4 == 5) goto L19;
        d.c.c.e.a.G("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", new Object[]{r5});
        return 0.0d;
    L19:
        return 1.0d;
    }
}
