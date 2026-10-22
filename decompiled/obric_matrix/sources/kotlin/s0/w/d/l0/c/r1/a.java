package kotlin.s0.w.d.l0.c.r1;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.m1;
import kotlin.s0.w.d.l0.c.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f19074c = null;

    static {
        f19074c = new a();
    }

    private a() {
        super("package", false);
    }

    @Override // kotlin.s0.w.d.l0.c.n1
    public Integer a(n1 r2) {
        o.f(r2, "visibility");
        if (this != r2) goto L8;
        int r1 = 0;
    L6:
        return Integer.valueOf(r1);
    L8:
        if (m1.f18886a.b(r2) == false) goto L10;
        r1 = 1;
        goto L6
    L10:
        r1 = -1;
        goto L6
    }

    @Override // kotlin.s0.w.d.l0.c.n1
    public String b() {
        return "public/*package*/";
    }

    @Override // kotlin.s0.w.d.l0.c.n1
    public n1 d() {
        return m1.g.f18894c;
    }
}
