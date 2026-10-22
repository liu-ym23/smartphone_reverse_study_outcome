package kotlin.s0.w.d.l0.b;

import java.util.Set;
import kotlin.i0.t0;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<i> f18689j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i f18690k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i f18691l = null;
    public static final i m = null;
    public static final i n = null;
    public static final i o = null;
    public static final i p = null;
    public static final i q = null;
    public static final i r = null;
    private static final /* synthetic */ i[] s = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f18692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.g.f f18693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.h f18694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.h f18695i;

    static final class a extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.g.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f18696f;

        a(i r1) {
            this.f18696f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.g.c a() {
            kotlin.s0.w.d.l0.g.c r1 = k.f18715k.c(this.f18696f.c());
            kotlin.n0.d.o.e(r1, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.c invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<kotlin.s0.w.d.l0.g.c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f18697f;

        b(i r1) {
            this.f18697f = r1;
            super(0);
        }

        public final kotlin.s0.w.d.l0.g.c a() {
            kotlin.s0.w.d.l0.g.c r1 = k.f18715k.c(this.f18697f.j());
            kotlin.n0.d.o.e(r1, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.g.c invoke() {
            return a();
        }
    }

    static {
        f18690k = new i("BOOLEAN", 0, "Boolean");
        i r0 = new i("CHAR", 1, "Char");
        f18691l = r0;
        i r1 = new i("BYTE", 2, "Byte");
        m = r1;
        i r4 = new i("SHORT", 3, "Short");
        n = r4;
        i r6 = new i("INT", 4, "Int");
        o = r6;
        i r8 = new i("FLOAT", 5, "Float");
        p = r8;
        i r10 = new i("LONG", 6, "Long");
        q = r10;
        i r12 = new i("DOUBLE", 7, "Double");
        r = r12;
        s = a();
        f18689j = t0.e(new i[]{r0, r1, r4, r6, r8, r10, r12});
    }

    private i(String r1, int r2, String r3) {
        super(r1, r2);
        kotlin.s0.w.d.l0.g.f r4 = kotlin.s0.w.d.l0.g.f.k(r3);
        kotlin.n0.d.o.e(r4, "identifier(typeName)");
        this.f18692f = r4;
        kotlin.s0.w.d.l0.g.f r5 = kotlin.s0.w.d.l0.g.f.k(r3 + "Array");
        kotlin.n0.d.o.e(r5, "identifier(\"${typeName}Array\")");
        this.f18693g = r5;
        kotlin.l r6 = kotlin.l.f18418g;
        this.f18694h = kotlin.i.a(r6, new b(this));
        this.f18695i = kotlin.i.a(r6, new a(this));
    }

    private static final /* synthetic */ i[] a() {
        return new i[]{f18690k, f18691l, m, n, o, p, q, r};
    }

    public static i valueOf(String r1) {
        return (i) Enum.valueOf(i.class, r1);
    }

    public static i[] values() {
        return (i[]) s.clone();
    }

    public final kotlin.s0.w.d.l0.g.c b() {
        return (kotlin.s0.w.d.l0.g.c) this.f18695i.getValue();
    }

    public final kotlin.s0.w.d.l0.g.f c() {
        return this.f18693g;
    }

    public final kotlin.s0.w.d.l0.g.c g() {
        return (kotlin.s0.w.d.l0.g.c) this.f18694h.getValue();
    }

    public final kotlin.s0.w.d.l0.g.f j() {
        return this.f18692f;
    }
}
