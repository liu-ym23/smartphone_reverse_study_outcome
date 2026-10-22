package kotlin.s0.w.d.l0.e.b.c0;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.i;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.f.a0.b.e;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC0526a f19724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f19725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f19726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f19727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f19728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f19730g;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.c0.a$a, reason: collision with other inner class name */
    public static final enum EnumC0526a extends Enum<EnumC0526a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0527a f19731g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final Map<Integer, EnumC0526a> f19732h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0526a f19733i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0526a f19734j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final EnumC0526a f19735k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final EnumC0526a f19736l = null;
        public static final EnumC0526a m = null;
        public static final EnumC0526a n = null;
        private static final /* synthetic */ EnumC0526a[] o = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f19737f;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.c0.a$a$a, reason: collision with other inner class name */
        public static final class C0527a {
            private C0527a() {
            }

            public /* synthetic */ C0527a(g r1) {
                this();
            }

            public final EnumC0526a a(int r1) {
                EnumC0526a r0 = (EnumC0526a) EnumC0526a.b().get(Integer.valueOf(r1));
                if (r0 == null) goto L5;
                return r0;
            L5:
                return EnumC0526a.f19733i;
            }
        }

        static {
            int r2 = 0;
            f19733i = new EnumC0526a("UNKNOWN", 0, 0);
            f19734j = new EnumC0526a("CLASS", 1, 1);
            f19735k = new EnumC0526a("FILE_FACADE", 2, 2);
            f19736l = new EnumC0526a("SYNTHETIC_CLASS", 3, 3);
            m = new EnumC0526a("MULTIFILE_CLASS", 4, 4);
            n = new EnumC0526a("MULTIFILE_CLASS_PART", 5, 5);
            o = a();
            f19731g = new C0527a(null);
            EnumC0526a[] r0 = values();
            LinkedHashMap r3 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r0.length), 16));
            int r1 = r0.length;
        L3:
            if (r2 >= r1) goto L5;
            EnumC0526a r4 = r0[r2];
            r3.put(Integer.valueOf(r4.f19737f), r4);
            r2 = r2 + 1;
            goto L3
        L5:
            f19732h = r3;
        }

        private EnumC0526a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f19737f = r3;
        }

        private static final /* synthetic */ EnumC0526a[] a() {
            return new EnumC0526a[]{f19733i, f19734j, f19735k, f19736l, m, n};
        }

        public static final /* synthetic */ Map b() {
            return f19732h;
        }

        public static final EnumC0526a c(int r1) {
            return f19731g.a(r1);
        }

        public static EnumC0526a valueOf(String r1) {
            return (EnumC0526a) Enum.valueOf(EnumC0526a.class, r1);
        }

        public static EnumC0526a[] values() {
            return (EnumC0526a[]) o.clone();
        }
    }

    public a(EnumC0526a r1, e r2, String[] r3, String[] r4, String[] r5, String r6, int r7, String r8, byte[] r9) {
        o.f(r1, "kind");
        o.f(r2, "metadataVersion");
        this.f19724a = r1;
        this.f19725b = r2;
        this.f19726c = r3;
        this.f19727d = r4;
        this.f19728e = r5;
        this.f19729f = r6;
        this.f19730g = r7;
    }

    private final boolean h(int r1, int r2) {
        if ((r1 & r2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String[] a() {
        return this.f19726c;
    }

    public final String[] b() {
        return this.f19727d;
    }

    public final EnumC0526a c() {
        return this.f19724a;
    }

    public final e d() {
        return this.f19725b;
    }

    public final String e() {
        String r0 = this.f19729f;
        if (this.f19724a != EnumC0526a.n) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L10;
        return null;
    L10:
        return r0;
    L5:
        r2 = false;
        goto L6
    }

    public final List<String> f() {
        String[] r0 = this.f19726c;
        if (this.f19724a != EnumC0526a.m) goto L5;
        boolean r2 = true;
    L6:
        List<String> r1 = null;
        if (r2 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        r1 = i.d(r0);
    L12:
        if (r1 == null) goto L14;
        return r1;
    L14:
        return r.g();
    L5:
        r2 = false;
        goto L6
    }

    public final String[] g() {
        return this.f19728e;
    }

    public final boolean i() {
        return h(this.f19730g, 2);
    }

    public final boolean j() {
        if (h(this.f19730g, 64) == true) goto L5;
    L7:
        return false;
    L5:
        if (h(this.f19730g, 32) == true) goto L7;
        return true;
    }

    public final boolean k() {
        if (h(this.f19730g, 16) == true) goto L5;
    L7:
        return false;
    L5:
        if (h(this.f19730g, 32) == true) goto L7;
        return true;
    }

    public String toString() {
        return this.f19724a + " version=" + this.f19725b;
    }
}
