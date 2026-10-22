package d.b.s.a.q;

import com.bytedance.sdk.account.impl.k;
import java.util.Map;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g, h, d.b.s.a.g, d.b.s.a.z.b, d.b.s.a.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ g f14876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ h f14877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ d.b.s.a.h f14878c;

    public a() {
        g r0 = com.bytedance.sdk.account.impl.d.d();
        o.b(r0, "BDAccountAPIV3Impl.instance()");
        this.f14876a = r0;
        h r1 = com.bytedance.sdk.account.impl.e.a();
        o.b(r1, "BDAccountCoreApiImpl.instance()");
        this.f14877b = r1;
        o.b(d.b.s.a.b.a(), "BDAccountExtraApiImpl.instance()");
        o.b(d.b.s.a.z.a.a(), "BDAccountLegacyApiImpl.instance()");
        d.b.s.a.h r2 = d.b.s.a.c.a();
        o.b(r2, "BDAccountSpecialApiImpl.instance()");
        this.f14878c = r2;
        o.b(k.a(), "BDAccountVcdApiImpl.instance()");
    }

    @Override // d.b.s.a.q.g
    public void a(String r1, String r2, int r3, d.b.s.a.q.k.a r4) {
        this.f14876a.a(r1, r2, r3, r4);
    }

    @Override // d.b.s.a.q.g
    public void b(String r1, d.b.s.a.q.j.a<d.b.s.a.q.j.c> r2) {
        this.f14876a.b(r1, r2);
    }

    @Override // d.b.s.a.q.h
    public void c(String r7, Map<Object, Object> r8, Object r9, com.ss.android.token.f r10, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r11) {
        this.f14877b.c(r7, r8, r9, r10, r11);
    }

    @Override // d.b.s.a.q.h
    public void d(String r1, d.b.s.a.q.k.c r2) {
        this.f14877b.d(r1, r2);
    }

    @Override // d.b.s.a.q.g
    public void e(String r1, int r2, Map<String, String> r3, d.b.s.a.b0.b.g.c r4) {
        this.f14876a.e(r1, r2, r3, r4);
    }

    @Override // d.b.s.a.q.g
    public void f(String r1, String r2, d.b.s.a.q.k.e r3) {
        this.f14876a.f(r1, r2, r3);
    }

    @Override // d.b.s.a.q.g
    public void g(String r1, String r2, d.b.s.a.b0.b.g.d r3) {
        this.f14876a.g(r1, r2, r3);
    }

    @Override // d.b.s.a.q.h
    public void h(String r1, Map<Object, Object> r2, d.b.s.a.q.j.a<d.b.s.a.q.j.d> r3) {
        this.f14877b.h(r1, r2, r3);
    }

    @Override // d.b.s.a.q.g
    public void i(String r7, String r8, String r9, String r10, d.b.s.a.b0.b.g.b r11) {
        this.f14876a.i(r7, r8, r9, r10, r11);
    }

    @Override // d.b.s.a.q.g
    public void j(String r1, String r2, String r3, d.b.s.a.b0.b.g.e r4) {
        this.f14876a.j(r1, r2, r3, r4);
    }

    @Override // d.b.s.a.q.g
    public void k(String r1, String r2, d.b.s.a.q.k.d r3) {
        this.f14876a.k(r1, r2, r3);
    }

    @Override // d.b.s.a.h
    public void l(String r1, String r2, String r3, d.b.s.a.q.k.g r4) {
        this.f14878c.l(r1, r2, r3, r4);
    }

    @Override // d.b.s.a.q.g
    public void m(String r1, d.b.s.a.q.k.b r2) {
        this.f14876a.m(r1, r2);
    }

    @Override // d.b.s.a.q.g
    public void n(String r8, String r9, Integer r10, String r11, Map<String, String> r12, d.b.s.a.b0.b.g.a r13) {
        this.f14876a.n(r8, r9, r10, r11, r12, r13);
    }
}
