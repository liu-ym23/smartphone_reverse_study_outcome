package kotlin.s0.w.d.l0.c.r1;

import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.m1;
import kotlin.s0.w.d.l0.c.n1;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f19075c = null;

    static {
        f19075c = new b();
    }

    private b() {
        super("protected_and_package", true);
    }

    @Override // kotlin.s0.w.d.l0.c.n1
    public Integer a(n1 r2) {
        o.f(r2, "visibility");
        if (o.a(this, r2) == false) goto L7;
        return 0;
    L7:
        if (r2 != m1.b.f18889c) goto L11;
        return null;
    L11:
        if (m1.f18886a.b(r2) == false) goto L13;
        int r1 = 1;
    L15:
        return Integer.valueOf(r1);
    L13:
        r1 = -1;
        goto L15
    }

    @Override // kotlin.s0.w.d.l0.c.n1
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // kotlin.s0.w.d.l0.c.n1
    public n1 d() {
        return m1.g.f18894c;
    }
}
