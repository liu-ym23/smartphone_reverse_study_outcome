package d.c.f.a.a;

import android.content.res.Resources;
import d.c.c.d.l;
import d.c.i.e.q;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f15500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.c.f.b.a f15501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.c.i.j.a f15502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Executor f15503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private q<d.c.b.a.d, d.c.i.l.c> f15504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.c.c.d.e<d.c.i.j.a> f15505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l<Boolean> f15506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Set<d.c.f.c.d> f15507h;

    public g() {
    }

    public Set<d.c.f.c.d> a() {
        return this.f15507h;
    }

    public void b(Resources r1, d.c.f.b.a r2, d.c.i.j.a r3, Executor r4, q<d.c.b.a.d, d.c.i.l.c> r5, d.c.c.d.e<d.c.i.j.a> r6, l<Boolean> r7, Set<d.c.f.c.d> r8) {
        this.f15500a = r1;
        this.f15501b = r2;
        this.f15502c = r3;
        this.f15503d = r4;
        this.f15504e = r5;
        this.f15505f = r6;
        this.f15506g = r7;
        this.f15507h = r8;
    }

    protected d c(Resources r8, d.c.f.b.a r9, d.c.i.j.a r10, Executor r11, q<d.c.b.a.d, d.c.i.l.c> r12, d.c.c.d.e<d.c.i.j.a> r13) {
        return new d(r8, r9, r10, r11, r12, r13);
    }

    public d d() {
        d r0 = c(this.f15500a, this.f15501b, this.f15502c, this.f15503d, this.f15504e, this.f15505f);
        l<Boolean> r7 = this.f15506g;
        if (r7 == null) goto L5;
        r0.n0(r7.get().booleanValue());
    L5:
        return r0;
    }
}
