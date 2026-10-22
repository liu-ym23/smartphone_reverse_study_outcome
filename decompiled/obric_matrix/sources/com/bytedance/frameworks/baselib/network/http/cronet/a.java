package com.bytedance.frameworks.baselib.network.http.cronet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile EnumC0147a f4676a;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cronet.a$a, reason: collision with other inner class name */
    public static final enum EnumC0147a extends Enum<EnumC0147a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0147a f4677g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0147a f4678h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0147a f4679i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0147a f4680j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final EnumC0147a f4681k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final EnumC0147a f4682l = null;
        private static final /* synthetic */ EnumC0147a[] m = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f4683f;

        static {
            EnumC0147a r0 = new EnumC0147a("NormalStart", 0, -1);
            f4677g = r0;
            EnumC0147a r1 = new EnumC0147a("ColdStart", 1, 0);
            f4678h = r1;
            EnumC0147a r3 = new EnumC0147a("HotStart", 2, 1);
            f4679i = r3;
            EnumC0147a r5 = new EnumC0147a("WarmStart", 3, 2);
            f4680j = r5;
            EnumC0147a r7 = new EnumC0147a("WeakNet", 4, 3);
            f4681k = r7;
            EnumC0147a r9 = new EnumC0147a("Default", 5, 4);
            f4682l = r9;
            m = new EnumC0147a[]{r0, r1, r3, r5, r7, r9};
        }

        private EnumC0147a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f4683f = r3;
        }

        public static EnumC0147a valueOf(String r1) {
            return (EnumC0147a) Enum.valueOf(EnumC0147a.class, r1);
        }

        public static EnumC0147a[] values() {
            return (EnumC0147a[]) m.clone();
        }
    }

    static {
        f4676a = EnumC0147a.f4677g;
        EnumC0147a r0 = EnumC0147a.f4682l;
    }

    public static int a() {
        return f4676a.f4683f;
    }
}
