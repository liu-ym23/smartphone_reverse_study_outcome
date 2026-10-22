package kotlin.s0.w.d.l0.c;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends kotlin.s0.w.d.l0.c.a, d0 {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18848f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18849g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f18850h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f18851i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f18852j = null;

        static {
            a r0 = new a("DECLARATION", 0);
            f18848f = r0;
            a r1 = new a("FAKE_OVERRIDE", 1);
            f18849g = r1;
            a r3 = new a("DELEGATION", 2);
            f18850h = r3;
            a r5 = new a("SYNTHESIZED", 3);
            f18851i = r5;
            f18852j = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f18852j.clone();
        }

        public boolean a() {
            if (this == f18849g) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Override // kotlin.s0.w.d.l0.c.a, kotlin.s0.w.d.l0.c.m
    b a();

    @Override // kotlin.s0.w.d.l0.c.a
    Collection<? extends b> f();

    a i();

    b k0(m r1, e0 r2, u r3, a r4, boolean r5);

    void x0(Collection<? extends b> r1);
}
