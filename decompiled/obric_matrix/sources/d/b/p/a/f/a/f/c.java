package d.b.p.a.f.a.f;

import android.content.Context;
import d.b.p.a.d.h;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class c extends d.b.p.a.f.a.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14293b;

    public c(String r2) {
        super("FileDeleteHandler");
        this.f14293b = r2;
    }

    @Override // d.b.p.a.f.a.e.a
    public void b(Context r2) {
        h.c("LaunchSafePlugin", a() + "method is called.");
        d.b.p.a.f.a.b.f(new File(this.f14293b));
    }
}
