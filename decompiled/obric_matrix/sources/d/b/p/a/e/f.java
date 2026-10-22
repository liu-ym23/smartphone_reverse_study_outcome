package d.b.p.a.e;

import android.app.Application;
import d.b.p.a.d.h;

/* JADX INFO: loaded from: classes.dex */
public class f extends d.b.p.a.g.a {
    public f() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "ProviderInstalledFailedPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r1) {
        super.c(r1);
        d.b.p.a.e.h.b.a.a(new d.b.p.a.e.h.b.c.a());
        d.b.p.a.e.h.b.a.a(new d.b.p.a.e.h.b.c.b());
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        d.b.p.a.e.h.b.a.b();
        h.c(b(), "start");
    }
}
