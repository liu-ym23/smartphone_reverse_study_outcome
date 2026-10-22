package d.c.f.a.a;

import android.content.Context;
import android.content.res.Resources;
import d.c.c.b.h;
import d.c.c.d.l;
import d.c.i.e.q;
import d.c.i.g.j;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f implements l<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.g.g f15497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f15498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<d.c.f.c.d> f15499d;

    public f(Context r2, b r3) {
        this(r2, j.o(), r3);
    }

    public f(Context r2, j r3, b r4) {
        this(r2, r3, null, r4);
    }

    public f(Context r12, j r13, Set<d.c.f.c.d> r14, b r15) {
        this.f15496a = r12;
        d.c.i.g.g r0 = r13.m();
        this.f15497b = r0;
        if (r15 != null) goto L18;
        g r2 = new g();
        this.f15498c = r2;
        Resources r3 = r12.getResources();
        d.c.f.b.a r4 = d.c.f.b.a.e();
        d.c.i.j.a r5 = r13.d(r12);
        h r6 = h.g();
        q<d.c.b.a.d, d.c.i.l.c> r7 = r0.f();
        if (r15 == null) goto L7;
        r15.a();
        throw null;
    L7:
        if (r15 == null) goto L9;
        r15.b();
        throw null;
    L9:
        if (r15 != null) goto L12;
        r2.b(r3, r4, r5, r6, r7, null, null, null);
        this.f15499d = r14;
        return;
    L12:
        r15.c();
        throw null;
    L18:
        r15.d();
        throw null;
    }

    public e a() {
        return new e(this.f15496a, this.f15498c, this.f15497b, this.f15499d);
    }

    @Override // d.c.c.d.l
    public /* bridge */ /* synthetic */ e get() {
        return a();
    }
}
