package uq;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f22429o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f22430p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f22431q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b f22432r = null;
    public static final b s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final b f22433t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final b f22434u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f22435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f22436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22437c;
    public final Object d;
    public final a.a e;
    public boolean f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f22438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f22439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f22440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f22441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public e f22442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f22443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22444n;

    static {
        f22429o = new b(1);
        f22430p = new b(2);
        f22431q = new b(3);
        f22432r = new b(4);
        s = new b(5);
        f22433t = new b(6);
        f22434u = new b(0);
    }

    public d(Object r5, a.a r10) {
        this.f22435a = 0.0f;
        this.f22436b = Float.MAX_VALUE;
        this.f22437c = false;
        this.f = false;
        this.g = -3.4028235E38f;
        this.f22438h = 0;
        this.f22440j = new ArrayList();
        this.f22441k = new ArrayList();
        this.d = r5;
        this.e = r10;
        if (r10 != f22432r) goto L5;
    L19:
        this.f22439i = 0.1f;
    L20:
        this.f22442l = null;
        this.f22443m = Float.MAX_VALUE;
        this.f22444n = false;
        return;
    L5:
        if (r10 == s) goto L19;
        if (r10 == f22433t) goto L19;
        if (r10 != f22434u) goto L13;
        this.f22439i = 0.00390625f;
        goto L20
    L13:
        if (r10 != f22430p) goto L15;
    L18:
        this.f22439i = 0.00390625f;
        goto L20
    L15:
        if (r10 == f22431q) goto L18;
        this.f22439i = 1.0f;
        goto L20
    }

    public final void a(float r5) {
        this.e.E(this.d, r5);
        int r10 = 0;
    L3:
        ArrayList r11 = this.f22441k;
        if (r10 >= r11.size()) goto L9;
        if (r11.get(r10) == null) goto L8;
        ((c) r11.get(r10)).a(this, this.f22436b, this.f22435a);
    L8:
        r10 = r10 + 1;
        goto L3
    L9:
        int r12 = r11.size() - 1;
    L10:
        if (r12 < 0) goto L15;
        if (r11.get(r12) != null) goto L14;
        r11.remove(r12);
    L14:
        r12 = r12 - 1;
        goto L10
    }
}
