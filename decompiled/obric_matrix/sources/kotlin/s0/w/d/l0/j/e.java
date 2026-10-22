package kotlin.s0.w.d.l0.j;

import java.util.ArrayList;
import java.util.Set;
import kotlin.i0.r;

/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<e> f20465g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<e> f20466h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f20467i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f20468j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f20469k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f20470l = null;
    public static final e m = null;
    public static final e n = null;
    public static final e o = null;
    public static final e p = null;
    public static final e q = null;
    public static final e r = null;
    public static final e s = null;
    public static final e t = null;
    public static final e u = null;
    public static final e v = null;
    private static final /* synthetic */ e[] w = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f20471f;

    static {
        int r2 = 0;
        f20467i = new e("VISIBILITY", 0, true);
        f20468j = new e("MODALITY", 1, true);
        f20469k = new e("OVERRIDE", 2, true);
        f20470l = new e("ANNOTATIONS", 3, false);
        m = new e("INNER", 4, true);
        n = new e("MEMBER_KIND", 5, true);
        o = new e("DATA", 6, true);
        p = new e("INLINE", 7, true);
        q = new e("EXPECT", 8, true);
        r = new e("ACTUAL", 9, true);
        s = new e("CONST", 10, true);
        t = new e("LATEINIT", 11, true);
        u = new e("FUN", 12, true);
        v = new e("VALUE", 13, true);
        w = a();
        e[] r0 = values();
        ArrayList r1 = new ArrayList();
        int r3 = r0.length;
    L3:
        if (r2 >= r3) goto L8;
        e r4 = r0[r2];
        if (r4.f20471f == false) goto L7;
        r1.add(r4);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        f20465g = r.D0(r1);
        f20466h = kotlin.i0.i.q0(values());
    }

    private e(String r1, int r2, boolean r3) {
        super(r1, r2);
        this.f20471f = r3;
    }

    private static final /* synthetic */ e[] a() {
        return new e[]{f20467i, f20468j, f20469k, f20470l, m, n, o, p, q, r, s, t, u, v};
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) w.clone();
    }
}
