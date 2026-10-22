package d.b.p.a.f.a.f;

import android.content.Context;
import d.b.p.a.d.h;

/* JADX INFO: loaded from: classes.dex */
public class b extends d.b.p.a.f.a.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14292b;

    public b(String r2) {
        super("DatabaseDeleteHandler");
        this.f14292b = r2;
    }

    @Override // d.b.p.a.f.a.e.a
    public void b(Context r3) {
        h.c("LaunchSafePlugin", a() + "method is called.");
        d.b.p.a.f.a.b.e(r3, this.f14292b);
    }
}
