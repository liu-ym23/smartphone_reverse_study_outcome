package kotlin.s0.w.d.l0.g;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    private static final f f20252e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f20253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f20254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f20255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f20256d;

    static {
        f r0 = h.f20280g;
        f20252e = r0;
        o.e(c.k(r0), "topLevel(LOCAL_NAME)");
    }

    public a(c r2, c r3, f r4, c r5) {
        o.f(r2, "packageName");
        o.f(r4, "callableName");
        this.f20253a = r2;
        this.f20254b = r3;
        this.f20255c = r4;
        this.f20256d = r5;
    }

    public /* synthetic */ a(c r1, c r2, f r3, c r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public a(c r9, f r10) {
        o.f(r9, "packageName");
        o.f(r10, "callableName");
        this(r9, null, r10, null, 8, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (o.a(this.f20253a, r6.f20253a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f20254b, r6.f20254b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f20255c, r6.f20255c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f20256d, r6.f20256d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f20253a.hashCode() * 31;
        c r1 = this.f20254b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.f20255c.hashCode()) * 31;
        c r5 = this.f20256d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r2 = this.f20253a.b();
        o.e(r2, "packageName.asString()");
        r0.append(kotlin.u0.k.v(r2, '.', '/', false, 4, null));
        r0.append("/");
        c r1 = this.f20254b;
        if (r1 == null) goto L5;
        r0.append(r1);
        r0.append(".");
    L5:
        r0.append(this.f20255c);
        String r8 = r0.toString();
        o.e(r8, "StringBuilder().apply(builderAction).toString()");
        return r8;
    }
}
