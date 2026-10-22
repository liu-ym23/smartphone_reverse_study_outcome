package d.b.p.a.c;

import android.app.Application;
import android.os.Build;
import d.b.p.a.d.h;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.b.p.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f14214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14215b;

    public a() {
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "CookieManagerPlugin";
    }

    @Override // d.b.p.a.g.a
    public void c(Application r2) {
        super.c(r2);
        this.f14214a = r2;
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r3 = true;
    L6:
        this.f14215b = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // d.b.p.a.g.a
    public void d() {
        super.d();
        if (this.f14214a == null) goto L10;
        h.c(b(), "start");
        if (this.f14215b == true) goto L7;
        return;
    L7:
        new d.b.p.a.c.f.a().a(this.f14214a);
        return;
    L10:
        throw new RuntimeException("mApplication must not null!!!");
    }
}
