package d.b.p.a.d;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f14243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f14244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static f f14245c;

    static class a implements f {
        a() {
        }

        private int b(c r2) {
            int r1 = b.f14246a[r2.ordinal()];
            if (r1 != 1) goto L5;
            return 3;
        L5:
            if (r1 == 2) goto L13;
            if (r1 != 3) goto L8;
            return 5;
        L8:
            if (r1 == 4) goto L10;
            return 2;
        L10:
            return 4;
        L13:
            return 6;
        }

        @Override // d.b.p.a.d.f
        public void a(String r1, String r2, c r3) {
            Log.println(b(r3), r1, r2);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14246a = null;

        static {
            int[] r0 = new int[c.values().length];
            f14246a = r0;
            r0[c.f14247f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f14246a[c.f14250i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f14246a[c.f14249h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f14246a[c.f14248g.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f14247f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f14248g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f14249h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f14250i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f14251j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ c[] f14252k = null;

        static {
            c r0 = new c("DEBUG", 0);
            f14247f = r0;
            c r1 = new c("INFO", 1);
            f14248g = r1;
            c r3 = new c("WARNING", 2);
            f14249h = r3;
            c r5 = new c("ERROR", 3);
            f14250i = r5;
            c r7 = new c("NONE", 4);
            f14251j = r7;
            f14252k = new c[]{r0, r1, r3, r5, r7};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f14252k.clone();
        }
    }

    static {
        f14243a = c.f14248g;
        f14244b = false;
        f14245c = new a();
    }

    public static void a(String r1, String r2) {
        e(r1, r2, c.f14247f);
    }

    public static boolean b() {
        return f14244b;
    }

    public static void c(String r1, String r2) {
        e(r1, r2, c.f14250i);
    }

    public static void d(String r1, String r2) {
        e(r1, r2, c.f14248g);
    }

    public static void e(String r2, String r3, c r4) {
        if (r4.ordinal() < f14243a.ordinal()) goto L6;
        f14245c.a(r2, r3, r4);
        return;
    }

    public static void f(f r0) {
        f14245c = r0;
    }

    public static void g(c r1) {
        f14243a = r1;
        if (r1 != c.f14247f) goto L6;
        f14244b = true;
        return;
    }
}
